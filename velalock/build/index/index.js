export default function(global, globalThis, window, $app_exports$, $app_evaluate$) {
    var org_app_require = $app_require$;
    (function(global, globalThis, window, $app_exports$, $app_evaluate$) {
        var setTimeout = global.setTimeout;
        var setInterval = global.setInterval;
        var clearTimeout = global.clearTimeout;
        var clearInterval = global.clearInterval;
        var $app_require$1 = global.$app_require$ || org_app_require;
        var createPageHandler = function() {
            return (()=>{
                var __webpack_modules__ = {
                    "./src/common/ble.js" (__unused_rspack___webpack_module__, __webpack_exports__, __webpack_require__) {
                        "use strict";
                        __webpack_require__.r(__webpack_exports__);
                        Object.defineProperty(exports, "__esModule", {
                            value: true
                        });
                        exports.LockClient = void 0;
                        var P = _interopRequireWildcard(require("./protocol.js"));
                        function _interopRequireWildcard(e, t) {
                            if ("function" == typeof WeakMap) var r = new WeakMap(), n = new WeakMap();
                            return (_interopRequireWildcard = function(e, t) {
                                if (!t && e && e.__esModule) return e;
                                var o, i, f = {
                                    __proto__: null,
                                    default: e
                                };
                                if (null === e || "object" != typeof e && "function" != typeof e) return f;
                                if (o = t ? n : r) {
                                    if (o.has(e)) return o.get(e);
                                    o.set(e, f);
                                }
                                for(const t in e)"default" !== t && ({}).hasOwnProperty.call(e, t) && ((i = (o = Object.defineProperty) && Object.getOwnPropertyDescriptor(e, t)) && (i.get || i.set) ? o(f, t, i) : f[t] = e[t]);
                                return f;
                            })(e, t);
                        }
                        function getBleModule() {
                            try {
                                if ("u" > typeof require) {
                                    const m = $app_require$1("@app-module/system.bluetooth.ble");
                                    if (m) return m;
                                }
                            } catch (e) {}
                            try {
                                if (void 0 !== globalThis) return globalThis['@system.bluetooth.ble'] || null;
                            } catch (e) {}
                            return null;
                        }
                        const SERVICE_UUID = '000018f0-0000-1000-8000-00805f9b34fb';
                        const WRITE_UUID = '00002af1-0000-1000-8000-00805f9b34fb';
                        const NOTIFY_UUID = '00002af0-0000-1000-8000-00805f9b34fb';
                        const WRITE_CHUNK = 20;
                        function bufToBytes(buf) {
                            if (buf instanceof ArrayBuffer) return new Uint8Array(buf);
                            if ("u" > typeof ArrayBuffer && ArrayBuffer.isView(buf)) return new Uint8Array(buf.buffer, buf.byteOffset, buf.byteLength);
                            if (Array.isArray(buf)) return Uint8Array.from(buf);
                            return new Uint8Array(0);
                        }
                        function bytesToArrayBuffer(bytes) {
                            const ab = new ArrayBuffer(bytes.length);
                            const u = new Uint8Array(ab);
                            u.set(bytes);
                            return ab;
                        }
                        class LockClient {
                            constructor(opts){
                                this.mac = opts.mac;
                                this.dataSecret = opts.dataSecret;
                                this.userKey = opts.userKey;
                                this.autoLock = false !== opts.autoLock;
                                this.device = null;
                                this.writeChar = null;
                                this.notifyChar = null;
                                this.recvBuf = new Uint8Array(0);
                                this.pending = [];
                                this.connected = false;
                                this.log = opts.log || function() {};
                            }
                            _onNotify(data) {
                                try {
                                    const val = data && data.characteristicValue;
                                    if (!val) return;
                                    const chunk = bufToBytes(val);
                                    if (0 === chunk.length) return;
                                    this.log('RECV ' + P.bytesToHex(chunk));
                                    this.recvBuf = P.concatBytes(this.recvBuf, chunk);
                                    while(true){
                                        const res = P.tryParsePacket(this.recvBuf, this.dataSecret);
                                        if (!res) break;
                                        this.recvBuf = this.recvBuf.slice(res.consumed);
                                        this._dispatch(res.tlvs);
                                    }
                                } catch (e) {
                                    this.log('onNotify error: ' + (e && e.message ? e.message : e));
                                }
                            }
                            _dispatch(tlvs) {
                                for(let i = 0; i < this.pending.length; i++){
                                    const p = this.pending[i];
                                    if (p.match(tlvs)) {
                                        this.pending.splice(i, 1);
                                        p.resolve(tlvs);
                                        return;
                                    }
                                }
                            }
                            _waitPacket(matchFn, timeoutMs) {
                                const self = this;
                                return new Promise((resolve, reject)=>{
                                    const timer = setTimeout(function() {
                                        const idx = self.pending.findIndex(function(p) {
                                            return p.resolve === resolve;
                                        });
                                        if (idx >= 0) self.pending.splice(idx, 1);
                                        reject(new Error('等待响应超时'));
                                    }, timeoutMs || 8000);
                                    self.pending.push({
                                        match: matchFn,
                                        resolve: function(tlvs) {
                                            clearTimeout(timer);
                                            resolve(tlvs);
                                        }
                                    });
                                });
                            }
                            static isBleSupported() {
                                const ble = getBleModule();
                                return !!(ble && 'function' == typeof ble.createGattClientDevice);
                            }
                            connect() {
                                const self = this;
                                return new Promise(function(resolve, reject) {
                                    const ble = getBleModule();
                                    if (!ble || 'function' != typeof ble.createGattClientDevice) return void reject(new Error('@system.bluetooth.ble 不可用：本设备(可能 S4/澎湃OS3)未开放 JS 蓝牙，需改用 Vela 原生 C 开发'));
                                    let dev;
                                    try {
                                        dev = ble.createGattClientDevice(self.mac, 'PUBLIC');
                                    } catch (e) {
                                        reject(new Error('createGattClientDevice 失败: ' + (e.message || e)));
                                        return;
                                    }
                                    self.device = dev;
                                    dev.onBLEConnectionStateChange = function(state) {
                                        self.log('conn state = ' + state);
                                        if (2 === state) self.connected = true;
                                        else if (0 === state || 3 === state) self.connected = false;
                                    };
                                    dev.onBLECharacteristicChange = function(data) {
                                        self._onNotify(data);
                                    };
                                    dev.connect({
                                        success: function() {
                                            const started = Date.now();
                                            const iv = setInterval(function() {
                                                if (self.connected) {
                                                    clearInterval(iv);
                                                    resolve();
                                                } else if (Date.now() - started > 8000) {
                                                    clearInterval(iv);
                                                    reject(new Error('连接超时（门锁是否在附近/已开机？）'));
                                                }
                                            }, 100);
                                        },
                                        fail: function(d, code) {
                                            reject(new Error('连接失败 code=' + code));
                                        }
                                    });
                                });
                            }
                            _getServices() {
                                const self = this;
                                return new Promise(function(resolve, reject) {
                                    self.device.getServices({
                                        success: function(services) {
                                            let writeChar = null;
                                            let notifyChar = null;
                                            for (const s of services || []){
                                                for (const c of s.characteristics || []){
                                                    const u = (c.characteristicUuid || '').toLowerCase();
                                                    if (u === WRITE_UUID.toLowerCase()) writeChar = c;
                                                    if (u === NOTIFY_UUID.toLowerCase()) notifyChar = c;
                                                }
                                            }
                                            if (!writeChar || !notifyChar) return void reject(new Error('未在锁服务中找到写/通知特征值'));
                                            self.writeChar = writeChar;
                                            self.notifyChar = notifyChar;
                                            resolve();
                                        },
                                        fail: function(d, code) {
                                            reject(new Error('发现服务失败 code=' + code));
                                        }
                                    });
                                });
                            }
                            _enableNotify() {
                                const self = this;
                                return new Promise(function(resolve, reject) {
                                    self.device.setNotifyCharacteristicChanged({
                                        characteristic: self.notifyChar,
                                        enable: true,
                                        success: function() {
                                            resolve();
                                        },
                                        fail: function(d, code) {
                                            reject(new Error('启用通知失败 code=' + code));
                                        }
                                    });
                                });
                            }
                            _write(bytes) {
                                const self = this;
                                return new Promise(function(resolve, reject) {
                                    let off = 0;
                                    function writeNext() {
                                        if (off >= bytes.length) return void resolve();
                                        const n = Math.min(WRITE_CHUNK, bytes.length - off);
                                        const chunk = bytes.slice(off, off + n);
                                        off += n;
                                        const characteristic = {
                                            serviceUuid: self.writeChar.serviceUuid,
                                            characteristicUuid: WRITE_UUID,
                                            characteristicValue: bytesToArrayBuffer(chunk)
                                        };
                                        self.log('SEND ' + P.bytesToHex(chunk));
                                        self.device.writeCharacteristicValue({
                                            characteristic: characteristic,
                                            success: function() {
                                                setTimeout(writeNext, 20);
                                            },
                                            fail: function(d, code) {
                                                reject(new Error('写特征失败 code=' + code));
                                            }
                                        });
                                    }
                                    writeNext();
                                });
                            }
                            openLock() {
                                const self = this;
                                return self.connect().then(function() {
                                    return self._getServices();
                                }).then(function() {
                                    return self._enableNotify();
                                }).then(function() {
                                    const grc = P.buildGetRangeCode(self.dataSecret);
                                    const randWaiter = self._waitPacket(function(tlvs) {
                                        return !!tlvs[100];
                                    }, 8000);
                                    return self._write(grc).then(function() {
                                        return randWaiter;
                                    });
                                }).then(function(r1) {
                                    const randStr = r1[100];
                                    const op = P.buildOpenLock(self.userKey, randStr, self.autoLock, self.dataSecret);
                                    const openWaiter = self._waitPacket(function(tlvs) {
                                        return !!tlvs[1];
                                    }, 8000);
                                    return self._write(op).then(function() {
                                        return openWaiter;
                                    });
                                }).then(function(r2) {
                                    const rc = r2[1];
                                    const ok = !!rc && rc.length >= 2 && 0 === rc[0] && 0 === rc[1];
                                    return self.disconnect().then(function() {
                                        return {
                                            success: ok,
                                            resultCode: P.bytesToHex(rc || new Uint8Array(0)),
                                            autoLock: self.autoLock
                                        };
                                    });
                                });
                            }
                            closeLock() {
                                const self = this;
                                return self.connect().then(function() {
                                    return self._getServices();
                                }).then(function() {
                                    return self._enableNotify();
                                }).then(function() {
                                    const grc = P.buildGetRangeCode(self.dataSecret);
                                    const randWaiter = self._waitPacket(function(tlvs) {
                                        return !!tlvs[100];
                                    }, 8000);
                                    return self._write(grc).then(function() {
                                        return randWaiter;
                                    });
                                }).then(function(r1) {
                                    const randStr = r1[100];
                                    const cl = P.buildCloseLock(randStr, self.dataSecret);
                                    const closeWaiter = self._waitPacket(function(tlvs) {
                                        return !!tlvs[1] || !!tlvs[25];
                                    }, 8000);
                                    return self._write(cl).then(function() {
                                        return closeWaiter;
                                    });
                                }).then(function(r2) {
                                    return self.disconnect().then(function() {
                                        return {
                                            success: true,
                                            resultCode: P.bytesToHex(r2[1] || new Uint8Array(0))
                                        };
                                    });
                                });
                            }
                            disconnect() {
                                const self = this;
                                return new Promise(function(resolve) {
                                    if (!self.device) return void resolve();
                                    self.device.disconnect({
                                        success: function() {
                                            resolve();
                                        },
                                        fail: function() {
                                            resolve();
                                        },
                                        complete: function() {
                                            resolve();
                                        }
                                    });
                                });
                            }
                        }
                        exports.LockClient = LockClient;
                    },
                    "./src/common/protocol.js" (__unused_rspack___webpack_module__, __webpack_exports__, __webpack_require__) {
                        "use strict";
                        __webpack_require__.r(__webpack_exports__);
                        Object.defineProperty(exports, "__esModule", {
                            value: true
                        });
                        exports.buildCloseLock = buildCloseLock;
                        exports.buildFullCommand = buildFullCommand;
                        exports.buildGetRangeCode = buildGetRangeCode;
                        exports.buildOpenLock = buildOpenLock;
                        exports.buildTlv = buildTlv;
                        exports.bytesToHex = bytesToHex;
                        exports.concatBytes = concatBytes;
                        exports.hexToBytes = hexToBytes;
                        exports.parseTlv = parseTlv;
                        exports.teaDecrypt = teaDecrypt;
                        exports.teaEncrypt = teaEncrypt;
                        exports.tryParsePacket = tryParsePacket;
                        exports.xorOf = xorOf;
                        const DELTA = 2654435769;
                        const ROUNDS = 16;
                        const BLOCK = 8;
                        function readIntBE(b, off) {
                            return ((0xff & b[off]) << 24 | (0xff & b[off + 1]) << 16 | (0xff & b[off + 2]) << 8 | 0xff & b[off + 3]) >>> 0;
                        }
                        function writeIntBE(b, off, v) {
                            b[off] = v >>> 24 & 0xff;
                            b[off + 1] = v >>> 16 & 0xff;
                            b[off + 2] = v >>> 8 & 0xff;
                            b[off + 3] = 0xff & v;
                        }
                        function hexToBytes(hex) {
                            const s = hex.replace(/\s/g, "");
                            const out = new Uint8Array(s.length / 2);
                            for(let i = 0; i < out.length; i++)out[i] = parseInt(s.substr(2 * i, 2), 16);
                            return out;
                        }
                        function bytesToHex(bytes) {
                            let s = "";
                            for(let i = 0; i < bytes.length; i++)s += (0xff & bytes[i]).toString(16).padStart(2, "0");
                            return s;
                        }
                        function xorOf(data) {
                            let x = 0;
                            for(let i = 0; i < data.length; i++)x ^= 0xff & data[i];
                            return 0xff & x;
                        }
                        function pkcs7Pad(data, block) {
                            const rem = data.length % block;
                            const pad = 0 === rem ? block : block - rem;
                            const out = new Uint8Array(data.length + pad);
                            out.set(data, 0);
                            for(let i = data.length; i < out.length; i++)out[i] = pad;
                            return out;
                        }
                        function teaEncrypt(data, key) {
                            const padded = pkcs7Pad(data, BLOCK);
                            const out = new Uint8Array(padded.length);
                            const k = [
                                readIntBE(key, 0),
                                readIntBE(key, 4),
                                readIntBE(key, 8),
                                readIntBE(key, 12)
                            ];
                            let off = 0;
                            while(off + BLOCK <= padded.length){
                                let v0 = readIntBE(padded, off) >>> 0;
                                let v1 = readIntBE(padded, off + 4) >>> 0;
                                let sum = 0;
                                for(let i = 0; i < ROUNDS; i++){
                                    sum = sum + DELTA >>> 0;
                                    const k0 = k[0] >>> 0, k1 = k[1] >>> 0, k2 = k[2] >>> 0, k3 = k[3] >>> 0;
                                    v0 = v0 + ((v1 << 4 >>> 0) + k0 ^ v1 + sum ^ (v1 >>> 5) + k1) >>> 0;
                                    v1 = v1 + ((v0 << 4 >>> 0) + k2 ^ v0 + sum ^ (v0 >>> 5) + k3) >>> 0;
                                }
                                writeIntBE(out, off, v0);
                                writeIntBE(out, off + 4, v1);
                                off += BLOCK;
                            }
                            return out;
                        }
                        function teaDecrypt(data, key) {
                            const out = new Uint8Array(data.length);
                            const k = [
                                readIntBE(key, 0),
                                readIntBE(key, 4),
                                readIntBE(key, 8),
                                readIntBE(key, 12)
                            ];
                            let off = 0;
                            while(off + BLOCK <= data.length){
                                let v0 = readIntBE(data, off) >>> 0;
                                let v1 = readIntBE(data, off + 4) >>> 0;
                                let sum = DELTA * ROUNDS >>> 0;
                                for(let i = 0; i < ROUNDS; i++){
                                    const k0 = k[0] >>> 0, k1 = k[1] >>> 0, k2 = k[2] >>> 0, k3 = k[3] >>> 0;
                                    v1 = v1 - ((v0 << 4 >>> 0) + k2 ^ v0 + sum ^ (v0 >>> 5) + k3) >>> 0;
                                    v0 = v0 - ((v1 << 4 >>> 0) + k0 ^ v1 + sum ^ (v1 >>> 5) + k1) >>> 0;
                                    sum = sum - DELTA >>> 0;
                                }
                                writeIntBE(out, off, v0);
                                writeIntBE(out, off + 4, v1);
                                off += BLOCK;
                            }
                            const padLen = 0xff & out[out.length - 1];
                            if (padLen >= 1 && padLen <= BLOCK) return out.slice(0, out.length - padLen);
                            return out;
                        }
                        function buildTlv(tag, value) {
                            const out = new Uint8Array(4 + value.length);
                            out[0] = tag >>> 8 & 0xff;
                            out[1] = 0xff & tag;
                            out[2] = value.length >>> 8 & 0xff;
                            out[3] = 0xff & value.length;
                            out.set(value, 4);
                            return out;
                        }
                        function parseTlv(data) {
                            const result = {};
                            let i = 0;
                            while(i + 4 <= data.length){
                                const tag = (0xff & data[i]) << 8 | 0xff & data[i + 1];
                                const length = (0xff & data[i + 2]) << 8 | 0xff & data[i + 3];
                                if (i + 4 + length > data.length) break;
                                result[tag] = data.slice(i + 4, i + 4 + length);
                                i += 4 + length;
                            }
                            return result;
                        }
                        function concatBytes(...arrs) {
                            let len = 0;
                            for (const a of arrs)len += a.length;
                            const out = new Uint8Array(len);
                            let off = 0;
                            for (const a of arrs){
                                out.set(a, off);
                                off += a.length;
                            }
                            return out;
                        }
                        function buildFullCommand(cmdType, cmdCode, units, key) {
                            const cmdValue = concatBytes(...units.map(([t, v])=>buildTlv(t, v)));
                            const innerTag = (cmdType << 8 | cmdCode) >>> 0;
                            const innerTlv = buildTlv(innerTag, cmdValue);
                            const inner = concatBytes(innerTlv, Uint8Array.from([
                                xorOf(innerTlv)
                            ]));
                            const enc = teaEncrypt(inner, key);
                            const tlv29 = buildTlv(29, enc);
                            const outerTlv = buildTlv(0x6a01, tlv29);
                            return concatBytes(outerTlv, Uint8Array.from([
                                xorOf(outerTlv)
                            ]));
                        }
                        function buildGetRangeCode(key) {
                            return buildFullCommand(31, 3, [
                                [
                                    25,
                                    Uint8Array.from([
                                        11,
                                        11,
                                        11,
                                        11
                                    ])
                                ]
                            ], key);
                        }
                        function buildOpenLock(userKey, randStr, autoLock, key) {
                            const a = Uint8Array.from([
                                autoLock ? 1 : 0
                            ]);
                            return buildFullCommand(31, 7, [
                                [
                                    101,
                                    userKey
                                ],
                                [
                                    100,
                                    randStr
                                ],
                                [
                                    25,
                                    Uint8Array.from([
                                        3,
                                        3,
                                        3,
                                        3
                                    ])
                                ],
                                [
                                    66,
                                    a
                                ]
                            ], key);
                        }
                        function buildCloseLock(randStr, key) {
                            return buildFullCommand(31, 9, [
                                [
                                    100,
                                    randStr
                                ],
                                [
                                    25,
                                    Uint8Array.from([
                                        4,
                                        4,
                                        4,
                                        4
                                    ])
                                ]
                            ], key);
                        }
                        function tryParsePacket(buffer, key) {
                            let i = 0;
                            while(i + 5 <= buffer.length){
                                const tag = (0xff & buffer[i]) << 8 | 0xff & buffer[i + 1];
                                const valid = 0x6a01 === tag || 0x6a02 === tag || 0x6a03 === tag || 0x6a04 === tag || 0x1f02 === tag;
                                if (!valid) {
                                    i++;
                                    continue;
                                }
                                const length = (0xff & buffer[i + 2]) << 8 | 0xff & buffer[i + 3];
                                const end = i + 4 + length + 1;
                                if (buffer.length < end) return null;
                                const pkg = buffer.slice(i, end);
                                const x = xorOf(pkg.slice(0, pkg.length - 1));
                                if (x !== pkg[pkg.length - 1]) {
                                    i++;
                                    continue;
                                }
                                const payload = buffer.slice(i + 4, i + 4 + length);
                                const units = parseTlv(payload);
                                if (units[29]) {
                                    const inner = teaDecrypt(units[29], key);
                                    if (inner.length >= 5 && xorOf(inner.slice(0, inner.length - 1)) === inner[inner.length - 1]) {
                                        const innerTlvs = parseTlv(inner.slice(4, inner.length - 1));
                                        return {
                                            tlvs: innerTlvs,
                                            consumed: end
                                        };
                                    }
                                    return null;
                                }
                                if (units[100] || units[25]) return {
                                    tlvs: units,
                                    consumed: end
                                };
                                return {
                                    tlvs: units,
                                    consumed: end
                                };
                            }
                            return null;
                        }
                    }
                };
                var __webpack_module_cache__ = {};
                function __webpack_require__(moduleId) {
                    var cachedModule = __webpack_module_cache__[moduleId];
                    if (void 0 !== cachedModule) return cachedModule.exports;
                    var module = __webpack_module_cache__[moduleId] = {
                        exports: {}
                    };
                    __webpack_modules__[moduleId](module, module.exports, __webpack_require__);
                    return module.exports;
                }
                (()=>{
                    __webpack_require__.r = (exports1)=>{
                        if ("u" > typeof Symbol && Symbol.toStringTag) Object.defineProperty(exports1, Symbol.toStringTag, {
                            value: 'Module'
                        });
                        Object.defineProperty(exports1, '__esModule', {
                            value: true
                        });
                    };
                })();
                (()=>{
                    __webpack_require__.rv = ()=>"1.7.12";
                })();
                (()=>{
                    __webpack_require__.ruid = "bundler=rspack@1.7.12";
                })();
                var __webpack_exports__ = {};
                (()=>{
                    var $app_style$ = [
                        [
                            [
                                [
                                    0,
                                    "page"
                                ]
                            ],
                            {
                                flexDirection: "column",
                                alignItems: "center",
                                paddingTop: "24px",
                                paddingRight: "24px",
                                paddingBottom: "24px",
                                paddingLeft: "24px",
                                backgroundColor: "#0b0b0b"
                            }
                        ],
                        [
                            [
                                [
                                    0,
                                    "title"
                                ]
                            ],
                            {
                                fontSize: "40px",
                                color: "#ffffff",
                                marginTop: "12px",
                                fontWeight: "bold"
                            }
                        ],
                        [
                            [
                                [
                                    0,
                                    "subtitle"
                                ]
                            ],
                            {
                                fontSize: "22px",
                                color: "#8a8a8a",
                                marginTop: "6px",
                                marginBottom: "24px"
                            }
                        ],
                        [
                            [
                                [
                                    0,
                                    "btn"
                                ]
                            ],
                            {
                                width: "360px",
                                height: "88px",
                                borderRadius: "44px",
                                color: "#ffffff",
                                fontSize: "32px",
                                marginBottom: "18px",
                                textAlign: "center"
                            }
                        ],
                        [
                            [
                                [
                                    0,
                                    "btn-probe"
                                ]
                            ],
                            {
                                backgroundColor: "#555555"
                            }
                        ],
                        [
                            [
                                [
                                    0,
                                    "btn-open"
                                ]
                            ],
                            {
                                backgroundColor: "#0a84ff"
                            }
                        ],
                        [
                            [
                                [
                                    0,
                                    "btn-close"
                                ]
                            ],
                            {
                                backgroundColor: "#ff9f0a"
                            }
                        ],
                        [
                            [
                                [
                                    0,
                                    "status"
                                ]
                            ],
                            {
                                fontSize: "26px",
                                color: "#ffd60a",
                                marginTop: "12px",
                                marginRight: "0",
                                marginBottom: "12px",
                                marginLeft: "0",
                                textAlign: "center"
                            }
                        ],
                        [
                            [
                                [
                                    0,
                                    "log"
                                ]
                            ],
                            {
                                width: "420px",
                                height: "280px",
                                marginTop: "8px",
                                borderTopColor: "#333333",
                                borderRightColor: "#333333",
                                borderBottomColor: "#333333",
                                borderLeftColor: "#333333",
                                borderTopWidth: "1px",
                                borderRightWidth: "1px",
                                borderBottomWidth: "1px",
                                borderLeftWidth: "1px",
                                paddingTop: "8px",
                                paddingRight: "8px",
                                paddingBottom: "8px",
                                paddingLeft: "8px"
                            }
                        ],
                        [
                            [
                                [
                                    0,
                                    "logline"
                                ]
                            ],
                            {
                                fontSize: "18px",
                                color: "#6ad36a",
                                lineHeight: "26px"
                            }
                        ]
                    ];
                    var $app_script$ = function __scriptModule__(module, exports1, $app_require$1) {
                        "use strict";
                        Object.defineProperty(exports1, "__esModule", {
                            value: true
                        });
                        exports1.default = void 0;
                        var _ble = __webpack_require__("./src/common/ble.js");
                        var P = _interopRequireWildcard(__webpack_require__("./src/common/protocol.js"));
                        function _interopRequireWildcard(e, t) {
                            if ("function" == typeof WeakMap) var r = new WeakMap(), n = new WeakMap();
                            return (_interopRequireWildcard = function(e, t) {
                                if (!t && e && e.__esModule) return e;
                                var o, i, f = {
                                    __proto__: null,
                                    default: e
                                };
                                if (null === e || "object" != typeof e && "function" != typeof e) return f;
                                if (o = t ? n : r) {
                                    if (o.has(e)) return o.get(e);
                                    o.set(e, f);
                                }
                                for(const t in e)"default" !== t && ({}).hasOwnProperty.call(e, t) && ((i = (o = Object.defineProperty) && Object.getOwnPropertyDescriptor(e, t)) && (i.get || i.set) ? o(f, t, i) : f[t] = e[t]);
                                return f;
                            })(e, t);
                        }
                        const LOCK_MAC = '1E:98:6C:02:A7:77';
                        const DATA_SECRET = P.hexToBytes('DBCCB54D6E2E655958FF9E29CBF8A764');
                        const USER_KEY = P.hexToBytes('0F80D3A7AF16E51B5BAA1A829A144B04C9878901EB6377ACB525214E3820E0D2');
                        var _default = exports1.default = {
                            private: {
                                mac: LOCK_MAC,
                                status: '点击「探测 BLE」检查本设备是否支持',
                                logs: []
                            },
                            onInit () {
                                this.client = new _ble.LockClient({
                                    mac: LOCK_MAC,
                                    dataSecret: DATA_SECRET,
                                    userKey: USER_KEY,
                                    autoLock: true,
                                    log: (m)=>this.appendLog(m)
                                });
                                this.probe();
                            },
                            appendLog (line) {
                                this.logs = (this.logs || []).concat([
                                    line
                                ]);
                                if (this.logs.length > 50) this.logs = this.logs.slice(-50);
                            },
                            setStatus (s) {
                                this.status = s;
                            },
                            probe () {
                                const self = this;
                                self.setStatus('探测中…');
                                self.appendLog('== 探测 @system.bluetooth.ble ==');
                                try {
                                    if (_ble.LockClient.isBleSupported()) {
                                        self.setStatus('✅ 本设备支持 JS BLE API（可尝试真机开锁）');
                                        self.appendLog('createGattClientDevice 方法存在');
                                    } else {
                                        self.setStatus('❌ 本设备不支持 JS BLE（S4/澎湃OS3 大概率需原生 C）');
                                        self.appendLog('createGattClientDevice 不存在');
                                    }
                                } catch (e) {
                                    self.setStatus('❌ 探测异常: ' + (e.message || e));
                                    self.appendLog('ERR ' + (e.message || e));
                                }
                            },
                            openLock () {
                                const self = this;
                                self.setStatus('开锁中…');
                                self.appendLog('>> openLock');
                                self.client.openLock().then(function(r) {
                                    if (r.success) {
                                        self.setStatus('✅ 开锁成功' + (r.autoLock ? '（已设为自动回锁）' : ''));
                                        self.appendLog('<< resultCode=' + r.resultCode);
                                    } else {
                                        self.setStatus('⚠️ 开锁返回失败 resultCode=' + r.resultCode);
                                        self.appendLog('<< resultCode=' + r.resultCode);
                                    }
                                }).catch(function(e) {
                                    self.setStatus('❌ 开锁失败: ' + (e.message || e));
                                    self.appendLog('ERR ' + (e.message || e));
                                });
                            },
                            closeLock () {
                                const self = this;
                                self.setStatus('关锁中…');
                                self.appendLog('>> closeLock');
                                self.client.closeLock().then(function(r) {
                                    self.setStatus('✅ 关锁指令已发送');
                                    self.appendLog('<< resultCode=' + r.resultCode);
                                }).catch(function(e) {
                                    self.setStatus('❌ 关锁失败: ' + (e.message || e));
                                    self.appendLog('ERR ' + (e.message || e));
                                });
                            }
                        };
                        const moduleOwn = exports1.default || module.exports;
                        const accessors = [
                            'public',
                            'protected',
                            'private'
                        ];
                        if (moduleOwn.data && accessors.some(function(acc) {
                            return moduleOwn[acc];
                        })) throw new Error('页面VM对象中的属性data不可与"' + accessors.join(',') + '"同时存在，请使用private替换data名称');
                        if (!moduleOwn.data) {
                            moduleOwn.data = {};
                            moduleOwn._descriptor = {};
                            accessors.forEach(function(acc) {
                                const accType = typeof moduleOwn[acc];
                                if ('object' === accType) {
                                    moduleOwn.data = Object.assign(moduleOwn.data, moduleOwn[acc]);
                                    for(const name in moduleOwn[acc])moduleOwn._descriptor[name] = {
                                        access: acc
                                    };
                                } else if ('function' === accType) console.warn('页面VM对象中的属性' + acc + '的值不能是函数，请使用对象');
                            });
                        }
                    };
                    var $app_template$ = function(vm) {
                        const _vm_ = vm || this;
                        return aiot.__ce__("div", {
                            __vm__: _vm_,
                            __opts__: {
                                classList: [
                                    "page"
                                ]
                            }
                        }, [
                            aiot.__ce__("text", {
                                __vm__: _vm_,
                                __opts__: {
                                    classList: [
                                        "title"
                                    ],
                                    value: "微棠门锁"
                                }
                            }, []),
                            aiot.__ce__("text", {
                                __vm__: _vm_,
                                __opts__: {
                                    classList: [
                                        "subtitle"
                                    ],
                                    value: function() {
                                        return "MAC " + _vm_.mac;
                                    }
                                }
                            }, []),
                            aiot.__ce__("input", {
                                __vm__: _vm_,
                                __opts__: {
                                    classList: [
                                        "btn",
                                        "btn-probe"
                                    ],
                                    type: "button",
                                    value: "探测 BLE",
                                    events: {
                                        click: function(evt) {
                                            return _vm_.probe(evt);
                                        }
                                    }
                                }
                            }, []),
                            aiot.__ce__("input", {
                                __vm__: _vm_,
                                __opts__: {
                                    classList: [
                                        "btn",
                                        "btn-open"
                                    ],
                                    type: "button",
                                    value: "开锁",
                                    events: {
                                        click: function(evt) {
                                            return _vm_.openLock(evt);
                                        }
                                    }
                                }
                            }, []),
                            aiot.__ce__("input", {
                                __vm__: _vm_,
                                __opts__: {
                                    classList: [
                                        "btn",
                                        "btn-close"
                                    ],
                                    type: "button",
                                    value: "关锁",
                                    events: {
                                        click: function(evt) {
                                            return _vm_.closeLock(evt);
                                        }
                                    }
                                }
                            }, []),
                            aiot.__ce__("text", {
                                __vm__: _vm_,
                                __opts__: {
                                    classList: [
                                        "status"
                                    ],
                                    value: function() {
                                        return _vm_.status;
                                    }
                                }
                            }, []),
                            aiot.__ce__("list", {
                                __vm__: _vm_,
                                __opts__: {
                                    classList: [
                                        "log"
                                    ]
                                }
                            }, [
                                aiot.__cf__({
                                    __vm__: _vm_,
                                    __opts__: {
                                        exp: function() {
                                            return _vm_.logs;
                                        },
                                        key: "i",
                                        value: "line"
                                    }
                                }, function(i, line) {
                                    return [
                                        aiot.__ce__("text", {
                                            __vm__: _vm_,
                                            __opts__: {
                                                classList: [
                                                    "logline"
                                                ],
                                                value: function() {
                                                    return line;
                                                }
                                            }
                                        }, [])
                                    ];
                                })
                            ])
                        ]);
                    };
                    $app_exports$['entry'] = function($app_exports$) {
                        $app_script$({}, $app_exports$, $app_require$1);
                        $app_exports$.default.template = $app_template$;
                        $app_exports$.default.style = $app_style$;
                    };
                })();
            })();
        };
        return createPageHandler();
    })(global, globalThis, window, $app_exports$, $app_evaluate$);
}

//# sourceMappingURL=data:application/json;charset=utf-8;base64,eyJ2ZXJzaW9uIjozLCJmaWxlIjoiaW5kZXgvaW5kZXguanMiLCJzb3VyY2VzIjpbIndlYnBhY2s6Ly93ZWl0YW5nLXZlbGEtbG9jay9zcmMvY29tbW9uL2JsZS5qcyIsIndlYnBhY2s6Ly93ZWl0YW5nLXZlbGEtbG9jay9zcmMvY29tbW9uL3Byb3RvY29sLmpzIiwid2VicGFjazovL3dlaXRhbmctdmVsYS1sb2NrL3dlYnBhY2svcnVudGltZS9tYWtlX25hbWVzcGFjZV9vYmplY3QiLCJ3ZWJwYWNrOi8vd2VpdGFuZy12ZWxhLWxvY2svd2VicGFjay9ydW50aW1lL3JzcGFja192ZXJzaW9uIiwid2VicGFjazovL3dlaXRhbmctdmVsYS1sb2NrL3dlYnBhY2svcnVudGltZS9yc3BhY2tfdW5pcXVlX2lkIiwid2VicGFjazovL3dlaXRhbmctdmVsYS1sb2NrL3NyYy9pbmRleC9pbmRleC51eCJdLCJzb3VyY2VzQ29udGVudCI6WyIvLyBibGUuanMg4oCUIOW+ruajoOmXqOmUgSBWZWxhIOW/q+W6lOeUqCBCTEUg5a6i5oi356uvICjln7rkuo4gQHN5c3RlbS5ibHVldG9vdGguYmxlKVxuLy8g5oqK5Zue6LCD5byPIEFQSSDlsIHoo4XmiJAgUHJvbWlzZe+8jOW5tuWunueOsCDov57mjqXihpLlj5bpmo/mnLrkuLLihpLlvIDplIEv5YWz6ZSB4oaS6Kej5p6QIOeahOeKtuaAgeacuuOAglxuLy8g5rOo5oSPOiDlrpjmlrnmlofmoaPms6jmmI4gSlMgQkxFIEdBVFQgQVBJIOS7hSBYaWFvbWkgV2F0Y2ggUzUg5piO56Gu5pSv5oyB77ybXG4vLyAgICAgICDlhbblroPlnovlj7co5aaCIFM0IFNwb3J0IC8g5r6O5rmDT1MzKemcgOecn+acuuWunua1i++8jOacrOaWh+S7tuWcqCBjb25uZWN0IOaXtuWBmuS6huiDveWKm+aOoua1i+OAglxuXG5pbXBvcnQgKiBhcyBQIGZyb20gJy4vcHJvdG9jb2wuanMnXG5cbi8vIOW7tui/n+iOt+WPliBAc3lzdGVtLmJsdWV0b290aC5ibGXvvJpcbi8vIOWFs+mUriDigJTigJQg5qih5Z2X5Yqg6L296Zi25q6144CQ5a6M5YWo5LiN6Kem56Kw44CR6JOd54mZ57O757uf5qih5Z2X77yM56Gu5L+d5Y2z5L2/6K6+5aSH5pyq5byA5pS+IEpTIOiTneeJmVxuLy8g77yI5aaCIFM0IOaooeaLn+WZqOOAgeaIlumDqOWIhiBTNCDnnJ/mnLrvvInvvIxibGUuanMg5Lmf6IO95q2j5bi45Yqg6L2977yMQXBwIOeVjOmdoueFp+W4uOa4suafk+OAgee7neS4jeeZveWxj+OAglxuLy8g6JOd54mZ5qih5Z2X5LuF5Zyo55yf5q2j6KaB6L+e5o6l5pe25omN5Yqo5oCB6I635Y+W77yM57y65aSx5YiZ5a6J5YWo6ZmN57qn5Li6IG51bGzvvIhVSSDlj4vlpb3mj5DnpLrvvInjgIJcbmZ1bmN0aW9uIGdldEJsZU1vZHVsZSgpIHtcbiAgdHJ5IHtcbiAgICBpZiAodHlwZW9mIHJlcXVpcmUgIT09ICd1bmRlZmluZWQnKSB7XG4gICAgICBjb25zdCBtID0gcmVxdWlyZSgnQHN5c3RlbS5ibHVldG9vdGguYmxlJylcbiAgICAgIGlmIChtKSByZXR1cm4gbVxuICAgIH1cbiAgfSBjYXRjaCAoZSkge1xuICAgIC8vIOaooeWdl+S4jeWtmOWcqOaIlui/kOihjOaXtuWKoOi9veWksei0pSDihpIg6ZmN57qn77yM5LiN5oqb5Ye677yM5L+d6K+B5qih5Z2X5Y+v5Yqg6L29XG4gIH1cbiAgdHJ5IHtcbiAgICBpZiAodHlwZW9mIGdsb2JhbFRoaXMgIT09ICd1bmRlZmluZWQnKSB7XG4gICAgICByZXR1cm4gZ2xvYmFsVGhpc1snQHN5c3RlbS5ibHVldG9vdGguYmxlJ10gfHwgbnVsbFxuICAgIH1cbiAgfSBjYXRjaCAoZSkge1xuICAgIC8vIGlnbm9yZVxuICB9XG4gIHJldHVybiBudWxsXG59XG5cbmNvbnN0IFNFUlZJQ0VfVVVJRCA9ICcwMDAwMThmMC0wMDAwLTEwMDAtODAwMC0wMDgwNWY5YjM0ZmInXG5jb25zdCBXUklURV9VVUlEID0gJzAwMDAyYWYxLTAwMDAtMTAwMC04MDAwLTAwODA1ZjliMzRmYidcbmNvbnN0IE5PVElGWV9VVUlEID0gJzAwMDAyYWYwLTAwMDAtMTAwMC04MDAwLTAwODA1ZjliMzRmYidcblxuLy8gVmVsYSDnnJ/mnLogTVRVIOm7mOiupCAyM++8jOWHj+WOuyAzIOWtl+iKguWktOWQjuWNleWMhSAyMCDlrZfoioLvvIjkuI4gUHl0aG9uIOiEmuacrOS4gOiHtO+8iVxuY29uc3QgV1JJVEVfQ0hVTksgPSAyMFxuXG5mdW5jdGlvbiBidWZUb0J5dGVzKGJ1Zikge1xuICBpZiAoYnVmIGluc3RhbmNlb2YgQXJyYXlCdWZmZXIpIHJldHVybiBuZXcgVWludDhBcnJheShidWYpXG4gIGlmICh0eXBlb2YgQXJyYXlCdWZmZXIgIT09ICd1bmRlZmluZWQnICYmIEFycmF5QnVmZmVyLmlzVmlldyhidWYpKSB7XG4gICAgcmV0dXJuIG5ldyBVaW50OEFycmF5KGJ1Zi5idWZmZXIsIGJ1Zi5ieXRlT2Zmc2V0LCBidWYuYnl0ZUxlbmd0aClcbiAgfVxuICBpZiAoQXJyYXkuaXNBcnJheShidWYpKSByZXR1cm4gVWludDhBcnJheS5mcm9tKGJ1ZilcbiAgcmV0dXJuIG5ldyBVaW50OEFycmF5KDApXG59XG5cbmZ1bmN0aW9uIGJ5dGVzVG9BcnJheUJ1ZmZlcihieXRlcykge1xuICBjb25zdCBhYiA9IG5ldyBBcnJheUJ1ZmZlcihieXRlcy5sZW5ndGgpXG4gIGNvbnN0IHUgPSBuZXcgVWludDhBcnJheShhYilcbiAgdS5zZXQoYnl0ZXMpXG4gIHJldHVybiBhYlxufVxuXG5leHBvcnQgY2xhc3MgTG9ja0NsaWVudCB7XG4gIGNvbnN0cnVjdG9yKG9wdHMpIHtcbiAgICB0aGlzLm1hYyA9IG9wdHMubWFjXG4gICAgdGhpcy5kYXRhU2VjcmV0ID0gb3B0cy5kYXRhU2VjcmV0XG4gICAgdGhpcy51c2VyS2V5ID0gb3B0cy51c2VyS2V5XG4gICAgdGhpcy5hdXRvTG9jayA9IG9wdHMuYXV0b0xvY2sgIT09IGZhbHNlIC8vIOm7mOiupOW8gOmUgeWQjuiHquWKqOWbnumUgVxuICAgIHRoaXMuZGV2aWNlID0gbnVsbFxuICAgIHRoaXMud3JpdGVDaGFyID0gbnVsbFxuICAgIHRoaXMubm90aWZ5Q2hhciA9IG51bGxcbiAgICB0aGlzLnJlY3ZCdWYgPSBuZXcgVWludDhBcnJheSgwKVxuICAgIHRoaXMucGVuZGluZyA9IFtdIC8vIOetieW+heeJueWumuWTjeW6lOWMheeahCByZXNvbHZlciDliJfooahcbiAgICB0aGlzLmNvbm5lY3RlZCA9IGZhbHNlXG4gICAgdGhpcy5sb2cgPSBvcHRzLmxvZyB8fCBmdW5jdGlvbiAoKSB7fVxuICB9XG5cbiAgX29uTm90aWZ5KGRhdGEpIHtcbiAgICB0cnkge1xuICAgICAgY29uc3QgdmFsID0gZGF0YSAmJiBkYXRhLmNoYXJhY3RlcmlzdGljVmFsdWVcbiAgICAgIGlmICghdmFsKSByZXR1cm5cbiAgICAgIGNvbnN0IGNodW5rID0gYnVmVG9CeXRlcyh2YWwpXG4gICAgICBpZiAoY2h1bmsubGVuZ3RoID09PSAwKSByZXR1cm5cbiAgICAgIHRoaXMubG9nKCdSRUNWICcgKyBQLmJ5dGVzVG9IZXgoY2h1bmspKVxuICAgICAgdGhpcy5yZWN2QnVmID0gUC5jb25jYXRCeXRlcyh0aGlzLnJlY3ZCdWYsIGNodW5rKVxuICAgICAgLy8g5b6q546v6Kej5p6Q5omA5pyJ5a6M5pW05YyF77yI6ZSB5YG25Y+R5YWI5Y+RIDAwMDAg5YmN5a+877yMdHJ5UGFyc2VQYWNrZXQg5Lya6Lez6L+H6Z2e5rOVIHRhZ++8iVxuICAgICAgd2hpbGUgKHRydWUpIHtcbiAgICAgICAgY29uc3QgcmVzID0gUC50cnlQYXJzZVBhY2tldCh0aGlzLnJlY3ZCdWYsIHRoaXMuZGF0YVNlY3JldClcbiAgICAgICAgaWYgKCFyZXMpIGJyZWFrXG4gICAgICAgIHRoaXMucmVjdkJ1ZiA9IHRoaXMucmVjdkJ1Zi5zbGljZShyZXMuY29uc3VtZWQpXG4gICAgICAgIHRoaXMuX2Rpc3BhdGNoKHJlcy50bHZzKVxuICAgICAgfVxuICAgIH0gY2F0Y2ggKGUpIHtcbiAgICAgIHRoaXMubG9nKCdvbk5vdGlmeSBlcnJvcjogJyArIChlICYmIGUubWVzc2FnZSA/IGUubWVzc2FnZSA6IGUpKVxuICAgIH1cbiAgfVxuXG4gIF9kaXNwYXRjaCh0bHZzKSB7XG4gICAgZm9yIChsZXQgaSA9IDA7IGkgPCB0aGlzLnBlbmRpbmcubGVuZ3RoOyBpKyspIHtcbiAgICAgIGNvbnN0IHAgPSB0aGlzLnBlbmRpbmdbaV1cbiAgICAgIGlmIChwLm1hdGNoKHRsdnMpKSB7XG4gICAgICAgIHRoaXMucGVuZGluZy5zcGxpY2UoaSwgMSlcbiAgICAgICAgcC5yZXNvbHZlKHRsdnMpXG4gICAgICAgIHJldHVyblxuICAgICAgfVxuICAgIH1cbiAgfVxuXG4gIF93YWl0UGFja2V0KG1hdGNoRm4sIHRpbWVvdXRNcykge1xuICAgIGNvbnN0IHNlbGYgPSB0aGlzXG4gICAgcmV0dXJuIG5ldyBQcm9taXNlKChyZXNvbHZlLCByZWplY3QpID0+IHtcbiAgICAgIGNvbnN0IHRpbWVyID0gc2V0VGltZW91dChmdW5jdGlvbiAoKSB7XG4gICAgICAgIGNvbnN0IGlkeCA9IHNlbGYucGVuZGluZy5maW5kSW5kZXgoZnVuY3Rpb24gKHApIHtcbiAgICAgICAgICByZXR1cm4gcC5yZXNvbHZlID09PSByZXNvbHZlXG4gICAgICAgIH0pXG4gICAgICAgIGlmIChpZHggPj0gMCkgc2VsZi5wZW5kaW5nLnNwbGljZShpZHgsIDEpXG4gICAgICAgIHJlamVjdChuZXcgRXJyb3IoJ+etieW+heWTjeW6lOi2heaXticpKVxuICAgICAgfSwgdGltZW91dE1zIHx8IDgwMDApXG4gICAgICBzZWxmLnBlbmRpbmcucHVzaCh7XG4gICAgICAgIG1hdGNoOiBtYXRjaEZuLFxuICAgICAgICByZXNvbHZlOiBmdW5jdGlvbiAodGx2cykge1xuICAgICAgICAgIGNsZWFyVGltZW91dCh0aW1lcilcbiAgICAgICAgICByZXNvbHZlKHRsdnMpXG4gICAgICAgIH1cbiAgICAgIH0pXG4gICAgfSlcbiAgfVxuXG4gIC8vIOaOoua1i+acrOiuvuWkh+aYr+WQpuaUr+aMgSBKUyBCTEXvvIhTNCDnrYnlpJrlnovlj7flj6/og73kuI3lj6/nlKjvvIlcbiAgc3RhdGljIGlzQmxlU3VwcG9ydGVkKCkge1xuICAgIGNvbnN0IGJsZSA9IGdldEJsZU1vZHVsZSgpXG4gICAgcmV0dXJuICEhKGJsZSAmJiB0eXBlb2YgYmxlLmNyZWF0ZUdhdHRDbGllbnREZXZpY2UgPT09ICdmdW5jdGlvbicpXG4gIH1cblxuICBjb25uZWN0KCkge1xuICAgIGNvbnN0IHNlbGYgPSB0aGlzXG4gICAgcmV0dXJuIG5ldyBQcm9taXNlKGZ1bmN0aW9uIChyZXNvbHZlLCByZWplY3QpIHtcbiAgICAgIGNvbnN0IGJsZSA9IGdldEJsZU1vZHVsZSgpXG4gICAgICBpZiAoIWJsZSB8fCB0eXBlb2YgYmxlLmNyZWF0ZUdhdHRDbGllbnREZXZpY2UgIT09ICdmdW5jdGlvbicpIHtcbiAgICAgICAgcmVqZWN0KG5ldyBFcnJvcignQHN5c3RlbS5ibHVldG9vdGguYmxlIOS4jeWPr+eUqO+8muacrOiuvuWkhyjlj6/og70gUzQv5r6O5rmDT1MzKeacquW8gOaUviBKUyDok53niZnvvIzpnIDmlLnnlKggVmVsYSDljp/nlJ8gQyDlvIDlj5EnKSlcbiAgICAgICAgcmV0dXJuXG4gICAgICB9XG4gICAgICBsZXQgZGV2XG4gICAgICB0cnkge1xuICAgICAgICBkZXYgPSBibGUuY3JlYXRlR2F0dENsaWVudERldmljZShzZWxmLm1hYywgJ1BVQkxJQycpXG4gICAgICB9IGNhdGNoIChlKSB7XG4gICAgICAgIHJlamVjdChuZXcgRXJyb3IoJ2NyZWF0ZUdhdHRDbGllbnREZXZpY2Ug5aSx6LSlOiAnICsgKGUubWVzc2FnZSB8fCBlKSkpXG4gICAgICAgIHJldHVyblxuICAgICAgfVxuICAgICAgc2VsZi5kZXZpY2UgPSBkZXZcbiAgICAgIGRldi5vbkJMRUNvbm5lY3Rpb25TdGF0ZUNoYW5nZSA9IGZ1bmN0aW9uIChzdGF0ZSkge1xuICAgICAgICBzZWxmLmxvZygnY29ubiBzdGF0ZSA9ICcgKyBzdGF0ZSlcbiAgICAgICAgaWYgKHN0YXRlID09PSAyKSBzZWxmLmNvbm5lY3RlZCA9IHRydWVcbiAgICAgICAgZWxzZSBpZiAoc3RhdGUgPT09IDAgfHwgc3RhdGUgPT09IDMpIHNlbGYuY29ubmVjdGVkID0gZmFsc2VcbiAgICAgIH1cbiAgICAgIGRldi5vbkJMRUNoYXJhY3RlcmlzdGljQ2hhbmdlID0gZnVuY3Rpb24gKGRhdGEpIHtcbiAgICAgICAgc2VsZi5fb25Ob3RpZnkoZGF0YSlcbiAgICAgIH1cbiAgICAgIGRldi5jb25uZWN0KHtcbiAgICAgICAgc3VjY2VzczogZnVuY3Rpb24gKCkge1xuICAgICAgICAgIGNvbnN0IHN0YXJ0ZWQgPSBEYXRlLm5vdygpXG4gICAgICAgICAgY29uc3QgaXYgPSBzZXRJbnRlcnZhbChmdW5jdGlvbiAoKSB7XG4gICAgICAgICAgICBpZiAoc2VsZi5jb25uZWN0ZWQpIHtcbiAgICAgICAgICAgICAgY2xlYXJJbnRlcnZhbChpdilcbiAgICAgICAgICAgICAgcmVzb2x2ZSgpXG4gICAgICAgICAgICB9IGVsc2UgaWYgKERhdGUubm93KCkgLSBzdGFydGVkID4gODAwMCkge1xuICAgICAgICAgICAgICBjbGVhckludGVydmFsKGl2KVxuICAgICAgICAgICAgICByZWplY3QobmV3IEVycm9yKCfov57mjqXotoXml7bvvIjpl6jplIHmmK/lkKblnKjpmYTov5Ev5bey5byA5py677yf77yJJykpXG4gICAgICAgICAgICB9XG4gICAgICAgICAgfSwgMTAwKVxuICAgICAgICB9LFxuICAgICAgICBmYWlsOiBmdW5jdGlvbiAoZCwgY29kZSkge1xuICAgICAgICAgIHJlamVjdChuZXcgRXJyb3IoJ+i/nuaOpeWksei0pSBjb2RlPScgKyBjb2RlKSlcbiAgICAgICAgfVxuICAgICAgfSlcbiAgICB9KVxuICB9XG5cbiAgX2dldFNlcnZpY2VzKCkge1xuICAgIGNvbnN0IHNlbGYgPSB0aGlzXG4gICAgcmV0dXJuIG5ldyBQcm9taXNlKGZ1bmN0aW9uIChyZXNvbHZlLCByZWplY3QpIHtcbiAgICAgIHNlbGYuZGV2aWNlLmdldFNlcnZpY2VzKHtcbiAgICAgICAgc3VjY2VzczogZnVuY3Rpb24gKHNlcnZpY2VzKSB7XG4gICAgICAgICAgbGV0IHdyaXRlQ2hhciA9IG51bGxcbiAgICAgICAgICBsZXQgbm90aWZ5Q2hhciA9IG51bGxcbiAgICAgICAgICBmb3IgKGNvbnN0IHMgb2Ygc2VydmljZXMgfHwgW10pIHtcbiAgICAgICAgICAgIGZvciAoY29uc3QgYyBvZiBzLmNoYXJhY3RlcmlzdGljcyB8fCBbXSkge1xuICAgICAgICAgICAgICBjb25zdCB1ID0gKGMuY2hhcmFjdGVyaXN0aWNVdWlkIHx8ICcnKS50b0xvd2VyQ2FzZSgpXG4gICAgICAgICAgICAgIGlmICh1ID09PSBXUklURV9VVUlELnRvTG93ZXJDYXNlKCkpIHdyaXRlQ2hhciA9IGNcbiAgICAgICAgICAgICAgaWYgKHUgPT09IE5PVElGWV9VVUlELnRvTG93ZXJDYXNlKCkpIG5vdGlmeUNoYXIgPSBjXG4gICAgICAgICAgICB9XG4gICAgICAgICAgfVxuICAgICAgICAgIGlmICghd3JpdGVDaGFyIHx8ICFub3RpZnlDaGFyKSB7XG4gICAgICAgICAgICByZWplY3QobmV3IEVycm9yKCfmnKrlnKjplIHmnI3liqHkuK3mib7liLDlhpkv6YCa55+l54m55b6B5YC8JykpXG4gICAgICAgICAgICByZXR1cm5cbiAgICAgICAgICB9XG4gICAgICAgICAgc2VsZi53cml0ZUNoYXIgPSB3cml0ZUNoYXJcbiAgICAgICAgICBzZWxmLm5vdGlmeUNoYXIgPSBub3RpZnlDaGFyXG4gICAgICAgICAgcmVzb2x2ZSgpXG4gICAgICAgIH0sXG4gICAgICAgIGZhaWw6IGZ1bmN0aW9uIChkLCBjb2RlKSB7XG4gICAgICAgICAgcmVqZWN0KG5ldyBFcnJvcign5Y+R546w5pyN5Yqh5aSx6LSlIGNvZGU9JyArIGNvZGUpKVxuICAgICAgICB9XG4gICAgICB9KVxuICAgIH0pXG4gIH1cblxuICBfZW5hYmxlTm90aWZ5KCkge1xuICAgIGNvbnN0IHNlbGYgPSB0aGlzXG4gICAgcmV0dXJuIG5ldyBQcm9taXNlKGZ1bmN0aW9uIChyZXNvbHZlLCByZWplY3QpIHtcbiAgICAgIHNlbGYuZGV2aWNlLnNldE5vdGlmeUNoYXJhY3RlcmlzdGljQ2hhbmdlZCh7XG4gICAgICAgIGNoYXJhY3RlcmlzdGljOiBzZWxmLm5vdGlmeUNoYXIsXG4gICAgICAgIGVuYWJsZTogdHJ1ZSxcbiAgICAgICAgc3VjY2VzczogZnVuY3Rpb24gKCkge1xuICAgICAgICAgIHJlc29sdmUoKVxuICAgICAgICB9LFxuICAgICAgICBmYWlsOiBmdW5jdGlvbiAoZCwgY29kZSkge1xuICAgICAgICAgIHJlamVjdChuZXcgRXJyb3IoJ+WQr+eUqOmAmuefpeWksei0pSBjb2RlPScgKyBjb2RlKSlcbiAgICAgICAgfVxuICAgICAgfSlcbiAgICB9KVxuICB9XG5cbiAgX3dyaXRlKGJ5dGVzKSB7XG4gICAgY29uc3Qgc2VsZiA9IHRoaXNcbiAgICByZXR1cm4gbmV3IFByb21pc2UoZnVuY3Rpb24gKHJlc29sdmUsIHJlamVjdCkge1xuICAgICAgbGV0IG9mZiA9IDBcbiAgICAgIGZ1bmN0aW9uIHdyaXRlTmV4dCgpIHtcbiAgICAgICAgaWYgKG9mZiA+PSBieXRlcy5sZW5ndGgpIHtcbiAgICAgICAgICByZXNvbHZlKClcbiAgICAgICAgICByZXR1cm5cbiAgICAgICAgfVxuICAgICAgICBjb25zdCBuID0gTWF0aC5taW4oV1JJVEVfQ0hVTkssIGJ5dGVzLmxlbmd0aCAtIG9mZilcbiAgICAgICAgY29uc3QgY2h1bmsgPSBieXRlcy5zbGljZShvZmYsIG9mZiArIG4pXG4gICAgICAgIG9mZiArPSBuXG4gICAgICAgIGNvbnN0IGNoYXJhY3RlcmlzdGljID0ge1xuICAgICAgICAgIHNlcnZpY2VVdWlkOiBzZWxmLndyaXRlQ2hhci5zZXJ2aWNlVXVpZCxcbiAgICAgICAgICBjaGFyYWN0ZXJpc3RpY1V1aWQ6IFdSSVRFX1VVSUQsXG4gICAgICAgICAgY2hhcmFjdGVyaXN0aWNWYWx1ZTogYnl0ZXNUb0FycmF5QnVmZmVyKGNodW5rKVxuICAgICAgICB9XG4gICAgICAgIHNlbGYubG9nKCdTRU5EICcgKyBQLmJ5dGVzVG9IZXgoY2h1bmspKVxuICAgICAgICBzZWxmLmRldmljZS53cml0ZUNoYXJhY3RlcmlzdGljVmFsdWUoe1xuICAgICAgICAgIGNoYXJhY3RlcmlzdGljOiBjaGFyYWN0ZXJpc3RpYyxcbiAgICAgICAgICBzdWNjZXNzOiBmdW5jdGlvbiAoKSB7XG4gICAgICAgICAgICBzZXRUaW1lb3V0KHdyaXRlTmV4dCwgMjApXG4gICAgICAgICAgfSxcbiAgICAgICAgICBmYWlsOiBmdW5jdGlvbiAoZCwgY29kZSkge1xuICAgICAgICAgICAgcmVqZWN0KG5ldyBFcnJvcign5YaZ54m55b6B5aSx6LSlIGNvZGU9JyArIGNvZGUpKVxuICAgICAgICAgIH1cbiAgICAgICAgfSlcbiAgICAgIH1cbiAgICAgIHdyaXRlTmV4dCgpXG4gICAgfSlcbiAgfVxuXG4gIG9wZW5Mb2NrKCkge1xuICAgIGNvbnN0IHNlbGYgPSB0aGlzXG4gICAgcmV0dXJuIHNlbGYuY29ubmVjdCgpXG4gICAgICAudGhlbihmdW5jdGlvbiAoKSB7IHJldHVybiBzZWxmLl9nZXRTZXJ2aWNlcygpIH0pXG4gICAgICAudGhlbihmdW5jdGlvbiAoKSB7IHJldHVybiBzZWxmLl9lbmFibGVOb3RpZnkoKSB9KVxuICAgICAgLnRoZW4oZnVuY3Rpb24gKCkge1xuICAgICAgICBjb25zdCBncmMgPSBQLmJ1aWxkR2V0UmFuZ2VDb2RlKHNlbGYuZGF0YVNlY3JldClcbiAgICAgICAgY29uc3QgcmFuZFdhaXRlciA9IHNlbGYuX3dhaXRQYWNrZXQoZnVuY3Rpb24gKHRsdnMpIHsgcmV0dXJuICEhdGx2c1sxMDBdIH0sIDgwMDApXG4gICAgICAgIHJldHVybiBzZWxmLl93cml0ZShncmMpLnRoZW4oZnVuY3Rpb24gKCkgeyByZXR1cm4gcmFuZFdhaXRlciB9KVxuICAgICAgfSlcbiAgICAgIC50aGVuKGZ1bmN0aW9uIChyMSkge1xuICAgICAgICBjb25zdCByYW5kU3RyID0gcjFbMTAwXVxuICAgICAgICBjb25zdCBvcCA9IFAuYnVpbGRPcGVuTG9jayhzZWxmLnVzZXJLZXksIHJhbmRTdHIsIHNlbGYuYXV0b0xvY2ssIHNlbGYuZGF0YVNlY3JldClcbiAgICAgICAgY29uc3Qgb3BlbldhaXRlciA9IHNlbGYuX3dhaXRQYWNrZXQoZnVuY3Rpb24gKHRsdnMpIHsgcmV0dXJuICEhdGx2c1sxXSB9LCA4MDAwKVxuICAgICAgICByZXR1cm4gc2VsZi5fd3JpdGUob3ApLnRoZW4oZnVuY3Rpb24gKCkgeyByZXR1cm4gb3BlbldhaXRlciB9KVxuICAgICAgfSlcbiAgICAgIC50aGVuKGZ1bmN0aW9uIChyMikge1xuICAgICAgICBjb25zdCByYyA9IHIyWzFdXG4gICAgICAgIGNvbnN0IG9rID0gISFyYyAmJiByYy5sZW5ndGggPj0gMiAmJiByY1swXSA9PT0gMCAmJiByY1sxXSA9PT0gMFxuICAgICAgICByZXR1cm4gc2VsZi5kaXNjb25uZWN0KCkudGhlbihmdW5jdGlvbiAoKSB7XG4gICAgICAgICAgcmV0dXJuIHtcbiAgICAgICAgICAgIHN1Y2Nlc3M6IG9rLFxuICAgICAgICAgICAgcmVzdWx0Q29kZTogUC5ieXRlc1RvSGV4KHJjIHx8IG5ldyBVaW50OEFycmF5KDApKSxcbiAgICAgICAgICAgIGF1dG9Mb2NrOiBzZWxmLmF1dG9Mb2NrXG4gICAgICAgICAgfVxuICAgICAgICB9KVxuICAgICAgfSlcbiAgfVxuXG4gIGNsb3NlTG9jaygpIHtcbiAgICBjb25zdCBzZWxmID0gdGhpc1xuICAgIHJldHVybiBzZWxmLmNvbm5lY3QoKVxuICAgICAgLnRoZW4oZnVuY3Rpb24gKCkgeyByZXR1cm4gc2VsZi5fZ2V0U2VydmljZXMoKSB9KVxuICAgICAgLnRoZW4oZnVuY3Rpb24gKCkgeyByZXR1cm4gc2VsZi5fZW5hYmxlTm90aWZ5KCkgfSlcbiAgICAgIC50aGVuKGZ1bmN0aW9uICgpIHtcbiAgICAgICAgY29uc3QgZ3JjID0gUC5idWlsZEdldFJhbmdlQ29kZShzZWxmLmRhdGFTZWNyZXQpXG4gICAgICAgIGNvbnN0IHJhbmRXYWl0ZXIgPSBzZWxmLl93YWl0UGFja2V0KGZ1bmN0aW9uICh0bHZzKSB7IHJldHVybiAhIXRsdnNbMTAwXSB9LCA4MDAwKVxuICAgICAgICByZXR1cm4gc2VsZi5fd3JpdGUoZ3JjKS50aGVuKGZ1bmN0aW9uICgpIHsgcmV0dXJuIHJhbmRXYWl0ZXIgfSlcbiAgICAgIH0pXG4gICAgICAudGhlbihmdW5jdGlvbiAocjEpIHtcbiAgICAgICAgY29uc3QgcmFuZFN0ciA9IHIxWzEwMF1cbiAgICAgICAgY29uc3QgY2wgPSBQLmJ1aWxkQ2xvc2VMb2NrKHJhbmRTdHIsIHNlbGYuZGF0YVNlY3JldClcbiAgICAgICAgY29uc3QgY2xvc2VXYWl0ZXIgPSBzZWxmLl93YWl0UGFja2V0KGZ1bmN0aW9uICh0bHZzKSB7IHJldHVybiAhIXRsdnNbMV0gfHwgISF0bHZzWzI1XSB9LCA4MDAwKVxuICAgICAgICByZXR1cm4gc2VsZi5fd3JpdGUoY2wpLnRoZW4oZnVuY3Rpb24gKCkgeyByZXR1cm4gY2xvc2VXYWl0ZXIgfSlcbiAgICAgIH0pXG4gICAgICAudGhlbihmdW5jdGlvbiAocjIpIHtcbiAgICAgICAgcmV0dXJuIHNlbGYuZGlzY29ubmVjdCgpLnRoZW4oZnVuY3Rpb24gKCkge1xuICAgICAgICAgIHJldHVybiB7XG4gICAgICAgICAgICBzdWNjZXNzOiB0cnVlLFxuICAgICAgICAgICAgcmVzdWx0Q29kZTogUC5ieXRlc1RvSGV4KHIyWzFdIHx8IG5ldyBVaW50OEFycmF5KDApKVxuICAgICAgICAgIH1cbiAgICAgICAgfSlcbiAgICAgIH0pXG4gIH1cblxuICBkaXNjb25uZWN0KCkge1xuICAgIGNvbnN0IHNlbGYgPSB0aGlzXG4gICAgcmV0dXJuIG5ldyBQcm9taXNlKGZ1bmN0aW9uIChyZXNvbHZlKSB7XG4gICAgICBpZiAoIXNlbGYuZGV2aWNlKSB7XG4gICAgICAgIHJlc29sdmUoKVxuICAgICAgICByZXR1cm5cbiAgICAgIH1cbiAgICAgIHNlbGYuZGV2aWNlLmRpc2Nvbm5lY3Qoe1xuICAgICAgICBzdWNjZXNzOiBmdW5jdGlvbiAoKSB7XG4gICAgICAgICAgcmVzb2x2ZSgpXG4gICAgICAgIH0sXG4gICAgICAgIGZhaWw6IGZ1bmN0aW9uICgpIHtcbiAgICAgICAgICByZXNvbHZlKClcbiAgICAgICAgfSxcbiAgICAgICAgY29tcGxldGU6IGZ1bmN0aW9uICgpIHtcbiAgICAgICAgICByZXNvbHZlKClcbiAgICAgICAgfVxuICAgICAgfSlcbiAgICB9KVxuICB9XG59XG4iLCIvLyBwcm90b2NvbC5qcyDigJQg5b6u5qOg5pm66IO96Zeo6ZSB5Y2P6K6uIChWZWxhIOW/q+W6lOeUqOeJiClcbi8vIOS4jiB1bmxvY2tfdjIucHkgLyBLb3RsaW4gTG9ja1Byb3RvY29sIOWtl+iKgue6p+S4gOiHtO+8m+e6ryBKU++8jOWPr+eUqCBOb2RlIOebtOaOpea1i+ivleOAglxuLy9cbi8vIOWKoOWvhjogVEVBKDE26L2uLCBkZWx0YT0weDlFMzc3OUI5KSwg5a+G6ZKl5LiO5pWw5o2u5Z2H5Li6IEJJRy1FTkRJQU4gMzLkvY3mlbTmlbBcbi8vIOWkluWxguW4pzogW3RhZygyQiBCRSksIGxlbmd0aCgyQiBCRSksIHBheWxvYWQsIFhPUigxQildXG4vLyAgIHRhZyA9IChjbWRfdHlwZTw8OCl8Y21kX2NvZGVcbi8vIOWRveS7pDpcbi8vICAgZ2V0UmFuZ2VDb2RlIDogQ29tbWFuZFRsdigzMSwzKSArIFRMVigyNSx7MTEsMTEsMTEsMTF9KVxuLy8gICBvcGVuTG9jayAgICAgOiBDb21tYW5kVGx2KDMxLDcpICsgVExWKDEwMSznlKjmiLflr4bpkqUpICsgVExWKDEwMCzpmo/mnLrkuLIpICsgVExWKDI1LHszLDMsMywzfSkgKyBUTFYoNjYs6Ieq5Yqo6ZSBKVxuLy8gICBjbG9zZUxvY2sgICAgOiBDb21tYW5kVGx2KDMxLDkpICsgVExWKDEwMCzpmo/mnLrkuLIpICsgVExWKDI1LHs0LDQsNCw0fSlcblxuY29uc3QgREVMVEEgPSAweDllMzc3OWI5ID4+PiAwO1xuY29uc3QgUk9VTkRTID0gMTY7XG5jb25zdCBCTE9DSyA9IDg7XG5cbmZ1bmN0aW9uIHJlYWRJbnRCRShiLCBvZmYpIHtcbiAgcmV0dXJuIChcbiAgICAoKGJbb2ZmXSAmIDB4ZmYpIDw8IDI0KSB8XG4gICAgKChiW29mZiArIDFdICYgMHhmZikgPDwgMTYpIHxcbiAgICAoKGJbb2ZmICsgMl0gJiAweGZmKSA8PCA4KSB8XG4gICAgKGJbb2ZmICsgM10gJiAweGZmKVxuICApID4+PiAwO1xufVxuXG5mdW5jdGlvbiB3cml0ZUludEJFKGIsIG9mZiwgdikge1xuICBiW29mZl0gPSAodiA+Pj4gMjQpICYgMHhmZjtcbiAgYltvZmYgKyAxXSA9ICh2ID4+PiAxNikgJiAweGZmO1xuICBiW29mZiArIDJdID0gKHYgPj4+IDgpICYgMHhmZjtcbiAgYltvZmYgKyAzXSA9IHYgJiAweGZmO1xufVxuXG5leHBvcnQgZnVuY3Rpb24gaGV4VG9CeXRlcyhoZXgpIHtcbiAgY29uc3QgcyA9IGhleC5yZXBsYWNlKC9cXHMvZywgXCJcIik7XG4gIGNvbnN0IG91dCA9IG5ldyBVaW50OEFycmF5KHMubGVuZ3RoIC8gMik7XG4gIGZvciAobGV0IGkgPSAwOyBpIDwgb3V0Lmxlbmd0aDsgaSsrKSB7XG4gICAgb3V0W2ldID0gcGFyc2VJbnQocy5zdWJzdHIoaSAqIDIsIDIpLCAxNik7XG4gIH1cbiAgcmV0dXJuIG91dDtcbn1cblxuZXhwb3J0IGZ1bmN0aW9uIGJ5dGVzVG9IZXgoYnl0ZXMpIHtcbiAgbGV0IHMgPSBcIlwiO1xuICBmb3IgKGxldCBpID0gMDsgaSA8IGJ5dGVzLmxlbmd0aDsgaSsrKSBzICs9IChieXRlc1tpXSAmIDB4ZmYpLnRvU3RyaW5nKDE2KS5wYWRTdGFydCgyLCBcIjBcIik7XG4gIHJldHVybiBzO1xufVxuXG5leHBvcnQgZnVuY3Rpb24geG9yT2YoZGF0YSkge1xuICBsZXQgeCA9IDA7XG4gIGZvciAobGV0IGkgPSAwOyBpIDwgZGF0YS5sZW5ndGg7IGkrKykgeCBePSBkYXRhW2ldICYgMHhmZjtcbiAgcmV0dXJuIHggJiAweGZmO1xufVxuXG5mdW5jdGlvbiBwa2NzN1BhZChkYXRhLCBibG9jaykge1xuICBjb25zdCByZW0gPSBkYXRhLmxlbmd0aCAlIGJsb2NrO1xuICBjb25zdCBwYWQgPSByZW0gPT09IDAgPyBibG9jayA6IGJsb2NrIC0gcmVtO1xuICBjb25zdCBvdXQgPSBuZXcgVWludDhBcnJheShkYXRhLmxlbmd0aCArIHBhZCk7XG4gIG91dC5zZXQoZGF0YSwgMCk7XG4gIGZvciAobGV0IGkgPSBkYXRhLmxlbmd0aDsgaSA8IG91dC5sZW5ndGg7IGkrKykgb3V0W2ldID0gcGFkO1xuICByZXR1cm4gb3V0O1xufVxuXG4vLyBURUEg5Yqg5a+GIChiaWctZW5kaWFuLCDmoIflh4YgZGVsdGEsIDE2IOi9rilcbmV4cG9ydCBmdW5jdGlvbiB0ZWFFbmNyeXB0KGRhdGEsIGtleSkge1xuICBjb25zdCBwYWRkZWQgPSBwa2NzN1BhZChkYXRhLCBCTE9DSyk7XG4gIGNvbnN0IG91dCA9IG5ldyBVaW50OEFycmF5KHBhZGRlZC5sZW5ndGgpO1xuICBjb25zdCBrID0gW3JlYWRJbnRCRShrZXksIDApLCByZWFkSW50QkUoa2V5LCA0KSwgcmVhZEludEJFKGtleSwgOCksIHJlYWRJbnRCRShrZXksIDEyKV07XG4gIGxldCBvZmYgPSAwO1xuICB3aGlsZSAob2ZmICsgQkxPQ0sgPD0gcGFkZGVkLmxlbmd0aCkge1xuICAgIGxldCB2MCA9IHJlYWRJbnRCRShwYWRkZWQsIG9mZikgPj4+IDA7XG4gICAgbGV0IHYxID0gcmVhZEludEJFKHBhZGRlZCwgb2ZmICsgNCkgPj4+IDA7XG4gICAgbGV0IHN1bSA9IDA7XG4gICAgZm9yIChsZXQgaSA9IDA7IGkgPCBST1VORFM7IGkrKykge1xuICAgICAgc3VtID0gKHN1bSArIERFTFRBKSA+Pj4gMDtcbiAgICAgIGNvbnN0IGswID0ga1swXSA+Pj4gMCwgazEgPSBrWzFdID4+PiAwLCBrMiA9IGtbMl0gPj4+IDAsIGszID0ga1szXSA+Pj4gMDtcbiAgICAgIHYwID0gKHYwICsgKCgoKHYxIDw8IDQpID4+PiAwKSArIGswKSBeICh2MSArIHN1bSkgXiAoKHYxID4+PiA1KSArIGsxKSkpID4+PiAwO1xuICAgICAgdjEgPSAodjEgKyAoKCgodjAgPDwgNCkgPj4+IDApICsgazIpIF4gKHYwICsgc3VtKSBeICgodjAgPj4+IDUpICsgazMpKSkgPj4+IDA7XG4gICAgfVxuICAgIHdyaXRlSW50QkUob3V0LCBvZmYsIHYwKTtcbiAgICB3cml0ZUludEJFKG91dCwgb2ZmICsgNCwgdjEpO1xuICAgIG9mZiArPSBCTE9DSztcbiAgfVxuICByZXR1cm4gb3V0O1xufVxuXG4vLyBURUEg6Kej5a+GXG5leHBvcnQgZnVuY3Rpb24gdGVhRGVjcnlwdChkYXRhLCBrZXkpIHtcbiAgY29uc3Qgb3V0ID0gbmV3IFVpbnQ4QXJyYXkoZGF0YS5sZW5ndGgpO1xuICBjb25zdCBrID0gW3JlYWRJbnRCRShrZXksIDApLCByZWFkSW50QkUoa2V5LCA0KSwgcmVhZEludEJFKGtleSwgOCksIHJlYWRJbnRCRShrZXksIDEyKV07XG4gIGxldCBvZmYgPSAwO1xuICB3aGlsZSAob2ZmICsgQkxPQ0sgPD0gZGF0YS5sZW5ndGgpIHtcbiAgICBsZXQgdjAgPSByZWFkSW50QkUoZGF0YSwgb2ZmKSA+Pj4gMDtcbiAgICBsZXQgdjEgPSByZWFkSW50QkUoZGF0YSwgb2ZmICsgNCkgPj4+IDA7XG4gICAgbGV0IHN1bSA9IChERUxUQSAqIFJPVU5EUykgPj4+IDA7XG4gICAgZm9yIChsZXQgaSA9IDA7IGkgPCBST1VORFM7IGkrKykge1xuICAgICAgY29uc3QgazAgPSBrWzBdID4+PiAwLCBrMSA9IGtbMV0gPj4+IDAsIGsyID0ga1syXSA+Pj4gMCwgazMgPSBrWzNdID4+PiAwO1xuICAgICAgdjEgPSAodjEgLSAoKCgodjAgPDwgNCkgPj4+IDApICsgazIpIF4gKHYwICsgc3VtKSBeICgodjAgPj4+IDUpICsgazMpKSkgPj4+IDA7XG4gICAgICB2MCA9ICh2MCAtICgoKCh2MSA8PCA0KSA+Pj4gMCkgKyBrMCkgXiAodjEgKyBzdW0pIF4gKCh2MSA+Pj4gNSkgKyBrMSkpKSA+Pj4gMDtcbiAgICAgIHN1bSA9IChzdW0gLSBERUxUQSkgPj4+IDA7XG4gICAgfVxuICAgIHdyaXRlSW50QkUob3V0LCBvZmYsIHYwKTtcbiAgICB3cml0ZUludEJFKG91dCwgb2ZmICsgNCwgdjEpO1xuICAgIG9mZiArPSBCTE9DSztcbiAgfVxuICAvLyBQS0NTNyDljrvloavlhYUgKOS4jiBQeXRob24gdGVhX2RlY3J5cHQg5LiA6Ie0KVxuICBjb25zdCBwYWRMZW4gPSBvdXRbb3V0Lmxlbmd0aCAtIDFdICYgMHhmZjtcbiAgaWYgKHBhZExlbiA+PSAxICYmIHBhZExlbiA8PSBCTE9DSykge1xuICAgIHJldHVybiBvdXQuc2xpY2UoMCwgb3V0Lmxlbmd0aCAtIHBhZExlbik7XG4gIH1cbiAgcmV0dXJuIG91dDtcbn1cblxuZXhwb3J0IGZ1bmN0aW9uIGJ1aWxkVGx2KHRhZywgdmFsdWUpIHtcbiAgY29uc3Qgb3V0ID0gbmV3IFVpbnQ4QXJyYXkoNCArIHZhbHVlLmxlbmd0aCk7XG4gIG91dFswXSA9ICh0YWcgPj4+IDgpICYgMHhmZjtcbiAgb3V0WzFdID0gdGFnICYgMHhmZjtcbiAgb3V0WzJdID0gKHZhbHVlLmxlbmd0aCA+Pj4gOCkgJiAweGZmO1xuICBvdXRbM10gPSB2YWx1ZS5sZW5ndGggJiAweGZmO1xuICBvdXQuc2V0KHZhbHVlLCA0KTtcbiAgcmV0dXJuIG91dDtcbn1cblxuZXhwb3J0IGZ1bmN0aW9uIHBhcnNlVGx2KGRhdGEpIHtcbiAgY29uc3QgcmVzdWx0ID0ge307XG4gIGxldCBpID0gMDtcbiAgd2hpbGUgKGkgKyA0IDw9IGRhdGEubGVuZ3RoKSB7XG4gICAgY29uc3QgdGFnID0gKChkYXRhW2ldICYgMHhmZikgPDwgOCkgfCAoZGF0YVtpICsgMV0gJiAweGZmKTtcbiAgICBjb25zdCBsZW5ndGggPSAoKGRhdGFbaSArIDJdICYgMHhmZikgPDwgOCkgfCAoZGF0YVtpICsgM10gJiAweGZmKTtcbiAgICBpZiAoaSArIDQgKyBsZW5ndGggPiBkYXRhLmxlbmd0aCkgYnJlYWs7XG4gICAgcmVzdWx0W3RhZ10gPSBkYXRhLnNsaWNlKGkgKyA0LCBpICsgNCArIGxlbmd0aCk7XG4gICAgaSArPSA0ICsgbGVuZ3RoO1xuICB9XG4gIHJldHVybiByZXN1bHQ7XG59XG5cbmV4cG9ydCBmdW5jdGlvbiBjb25jYXRCeXRlcyguLi5hcnJzKSB7XG4gIGxldCBsZW4gPSAwO1xuICBmb3IgKGNvbnN0IGEgb2YgYXJycykgbGVuICs9IGEubGVuZ3RoO1xuICBjb25zdCBvdXQgPSBuZXcgVWludDhBcnJheShsZW4pO1xuICBsZXQgb2ZmID0gMDtcbiAgZm9yIChjb25zdCBhIG9mIGFycnMpIHtcbiAgICBvdXQuc2V0KGEsIG9mZik7XG4gICAgb2ZmICs9IGEubGVuZ3RoO1xuICB9XG4gIHJldHVybiBvdXQ7XG59XG5cbi8vIOWujOaVtOWRveS7pDpcbi8vICAg5YaF5bGCID0gQ29tbWFuZFRsdihjbWRUeXBlPDw4fGNtZENvZGUsIOWQhOWPguaVsFRMVuaLvOaOpSkgKyBYT1Jcbi8vICAg5aSW5bGCID0gQ29tbWFuZFRsdigxMDYsMSwgVExWKDI5LCBURUEo5YaF5bGCKSkpICsgWE9SXG5leHBvcnQgZnVuY3Rpb24gYnVpbGRGdWxsQ29tbWFuZChjbWRUeXBlLCBjbWRDb2RlLCB1bml0cywga2V5KSB7XG4gIGNvbnN0IGNtZFZhbHVlID0gY29uY2F0Qnl0ZXMoLi4udW5pdHMubWFwKChbdCwgdl0pID0+IGJ1aWxkVGx2KHQsIHYpKSk7XG4gIGNvbnN0IGlubmVyVGFnID0gKChjbWRUeXBlIDw8IDgpIHwgY21kQ29kZSkgPj4+IDA7XG4gIGNvbnN0IGlubmVyVGx2ID0gYnVpbGRUbHYoaW5uZXJUYWcsIGNtZFZhbHVlKTtcbiAgY29uc3QgaW5uZXIgPSBjb25jYXRCeXRlcyhpbm5lclRsdiwgVWludDhBcnJheS5mcm9tKFt4b3JPZihpbm5lclRsdildKSk7XG4gIGNvbnN0IGVuYyA9IHRlYUVuY3J5cHQoaW5uZXIsIGtleSk7XG4gIGNvbnN0IHRsdjI5ID0gYnVpbGRUbHYoMjksIGVuYyk7XG4gIGNvbnN0IG91dGVyVGx2ID0gYnVpbGRUbHYoMHg2YTAxLCB0bHYyOSk7XG4gIHJldHVybiBjb25jYXRCeXRlcyhvdXRlclRsdiwgVWludDhBcnJheS5mcm9tKFt4b3JPZihvdXRlclRsdildKSk7XG59XG5cbmV4cG9ydCBmdW5jdGlvbiBidWlsZEdldFJhbmdlQ29kZShrZXkpIHtcbiAgcmV0dXJuIGJ1aWxkRnVsbENvbW1hbmQoMzEsIDMsIFtbMjUsIFVpbnQ4QXJyYXkuZnJvbShbMTEsIDExLCAxMSwgMTFdKV1dLCBrZXkpO1xufVxuXG5leHBvcnQgZnVuY3Rpb24gYnVpbGRPcGVuTG9jayh1c2VyS2V5LCByYW5kU3RyLCBhdXRvTG9jaywga2V5KSB7XG4gIGNvbnN0IGEgPSBVaW50OEFycmF5LmZyb20oW2F1dG9Mb2NrID8gMSA6IDBdKTtcbiAgcmV0dXJuIGJ1aWxkRnVsbENvbW1hbmQoXG4gICAgMzEsXG4gICAgNyxcbiAgICBbXG4gICAgICBbMTAxLCB1c2VyS2V5XSxcbiAgICAgIFsxMDAsIHJhbmRTdHJdLFxuICAgICAgWzI1LCBVaW50OEFycmF5LmZyb20oWzMsIDMsIDMsIDNdKV0sXG4gICAgICBbNjYsIGFdLFxuICAgIF0sXG4gICAga2V5XG4gICk7XG59XG5cbmV4cG9ydCBmdW5jdGlvbiBidWlsZENsb3NlTG9jayhyYW5kU3RyLCBrZXkpIHtcbiAgcmV0dXJuIGJ1aWxkRnVsbENvbW1hbmQoMzEsIDksIFtbMTAwLCByYW5kU3RyXSwgWzI1LCBVaW50OEFycmF5LmZyb20oWzQsIDQsIDQsIDRdKV1dLCBrZXkpO1xufVxuXG4vLyDku47ntK/orqHpgJrnn6XlrZfoioLkuK3op6PmnpDkuIDkuKrlrozmlbTlpJblsYLljIXlubbop6Plr4YsIOi/lOWbniB7IHRsdnMsIGNvbnN1bWVkIH0g5oiWIG51bGxcbmV4cG9ydCBmdW5jdGlvbiB0cnlQYXJzZVBhY2tldChidWZmZXIsIGtleSkge1xuICBsZXQgaSA9IDA7XG4gIHdoaWxlIChpICsgNSA8PSBidWZmZXIubGVuZ3RoKSB7XG4gICAgY29uc3QgdGFnID0gKChidWZmZXJbaV0gJiAweGZmKSA8PCA4KSB8IChidWZmZXJbaSArIDFdICYgMHhmZik7XG4gICAgY29uc3QgdmFsaWQgPSB0YWcgPT09IDB4NmEwMSB8fCB0YWcgPT09IDB4NmEwMiB8fCB0YWcgPT09IDB4NmEwMyB8fCB0YWcgPT09IDB4NmEwNCB8fCB0YWcgPT09IDB4MWYwMjtcbiAgICBpZiAoIXZhbGlkKSB7XG4gICAgICBpKys7XG4gICAgICBjb250aW51ZTtcbiAgICB9XG4gICAgY29uc3QgbGVuZ3RoID0gKChidWZmZXJbaSArIDJdICYgMHhmZikgPDwgOCkgfCAoYnVmZmVyW2kgKyAzXSAmIDB4ZmYpO1xuICAgIGNvbnN0IGVuZCA9IGkgKyA0ICsgbGVuZ3RoICsgMTtcbiAgICBpZiAoYnVmZmVyLmxlbmd0aCA8IGVuZCkgcmV0dXJuIG51bGw7XG4gICAgY29uc3QgcGtnID0gYnVmZmVyLnNsaWNlKGksIGVuZCk7XG4gICAgY29uc3QgeCA9IHhvck9mKHBrZy5zbGljZSgwLCBwa2cubGVuZ3RoIC0gMSkpO1xuICAgIGlmICh4ICE9PSBwa2dbcGtnLmxlbmd0aCAtIDFdKSB7XG4gICAgICBpKys7XG4gICAgICBjb250aW51ZTtcbiAgICB9XG4gICAgY29uc3QgcGF5bG9hZCA9IGJ1ZmZlci5zbGljZShpICsgNCwgaSArIDQgKyBsZW5ndGgpO1xuICAgIGNvbnN0IHVuaXRzID0gcGFyc2VUbHYocGF5bG9hZCk7XG4gICAgaWYgKHVuaXRzWzI5XSkge1xuICAgICAgY29uc3QgaW5uZXIgPSB0ZWFEZWNyeXB0KHVuaXRzWzI5XSwga2V5KTtcbiAgICAgIGlmIChpbm5lci5sZW5ndGggPj0gNSAmJiB4b3JPZihpbm5lci5zbGljZSgwLCBpbm5lci5sZW5ndGggLSAxKSkgPT09IGlubmVyW2lubmVyLmxlbmd0aCAtIDFdKSB7XG4gICAgICAgIGNvbnN0IGlubmVyVGx2cyA9IHBhcnNlVGx2KGlubmVyLnNsaWNlKDQsIGlubmVyLmxlbmd0aCAtIDEpKTtcbiAgICAgICAgcmV0dXJuIHsgdGx2czogaW5uZXJUbHZzLCBjb25zdW1lZDogZW5kIH07XG4gICAgICB9XG4gICAgICByZXR1cm4gbnVsbDtcbiAgICB9IGVsc2UgaWYgKHVuaXRzWzEwMF0gfHwgdW5pdHNbMjVdKSB7XG4gICAgICByZXR1cm4geyB0bHZzOiB1bml0cywgY29uc3VtZWQ6IGVuZCB9O1xuICAgIH1cbiAgICByZXR1cm4geyB0bHZzOiB1bml0cywgY29uc3VtZWQ6IGVuZCB9O1xuICB9XG4gIHJldHVybiBudWxsO1xufVxuIiwiLy8gZGVmaW5lIF9fZXNNb2R1bGUgb24gZXhwb3J0c1xuX193ZWJwYWNrX3JlcXVpcmVfXy5yID0gKGV4cG9ydHMpID0+IHtcblx0aWYodHlwZW9mIFN5bWJvbCAhPT0gJ3VuZGVmaW5lZCcgJiYgU3ltYm9sLnRvU3RyaW5nVGFnKSB7XG5cdFx0T2JqZWN0LmRlZmluZVByb3BlcnR5KGV4cG9ydHMsIFN5bWJvbC50b1N0cmluZ1RhZywgeyB2YWx1ZTogJ01vZHVsZScgfSk7XG5cdH1cblx0T2JqZWN0LmRlZmluZVByb3BlcnR5KGV4cG9ydHMsICdfX2VzTW9kdWxlJywgeyB2YWx1ZTogdHJ1ZSB9KTtcbn07IiwiX193ZWJwYWNrX3JlcXVpcmVfXy5ydiA9ICgpID0+IChcIjEuNy4xMlwiKSIsIl9fd2VicGFja19yZXF1aXJlX18ucnVpZCA9IFwiYnVuZGxlcj1yc3BhY2tAMS43LjEyXCI7IiwiPHRlbXBsYXRlPlxuICA8ZGl2IGNsYXNzPVwicGFnZVwiPlxuICAgIDx0ZXh0IGNsYXNzPVwidGl0bGVcIj7lvq7mo6Dpl6jplIE8L3RleHQ+XG4gICAgPHRleHQgY2xhc3M9XCJzdWJ0aXRsZVwiPk1BQyB7eyBtYWMgfX08L3RleHQ+XG5cbiAgICA8aW5wdXQgY2xhc3M9XCJidG4gYnRuLXByb2JlXCIgdHlwZT1cImJ1dHRvblwiIHZhbHVlPVwi5o6i5rWLIEJMRVwiIG9uY2xpY2s9XCJwcm9iZVwiIC8+XG4gICAgPGlucHV0IGNsYXNzPVwiYnRuIGJ0bi1vcGVuXCIgdHlwZT1cImJ1dHRvblwiIHZhbHVlPVwi5byA6ZSBXCIgb25jbGljaz1cIm9wZW5Mb2NrXCIgLz5cbiAgICA8aW5wdXQgY2xhc3M9XCJidG4gYnRuLWNsb3NlXCIgdHlwZT1cImJ1dHRvblwiIHZhbHVlPVwi5YWz6ZSBXCIgb25jbGljaz1cImNsb3NlTG9ja1wiIC8+XG5cbiAgICA8dGV4dCBjbGFzcz1cInN0YXR1c1wiPnt7IHN0YXR1cyB9fTwvdGV4dD5cbiAgICA8bGlzdCBjbGFzcz1cImxvZ1wiPlxuICAgICAgPGJsb2NrIGZvcj1cIihpLCBsaW5lKSBpbiBsb2dzXCI+XG4gICAgICAgIDx0ZXh0IGNsYXNzPVwibG9nbGluZVwiPnt7IGxpbmUgfX08L3RleHQ+XG4gICAgICA8L2Jsb2NrPlxuICAgIDwvbGlzdD5cbiAgPC9kaXY+XG48L3RlbXBsYXRlPlxuXG48c3R5bGU+XG4gIC5wYWdlIHtcbiAgICBmbGV4LWRpcmVjdGlvbjogY29sdW1uO1xuICAgIGFsaWduLWl0ZW1zOiBjZW50ZXI7ICAgXG4gICAgcGFkZGluZzogMjRweDtcbiAgICBiYWNrZ3JvdW5kLWNvbG9yOiAjMGIwYjBiO1xuICB9XG4gIC50aXRsZSB7XG4gICAgZm9udC1zaXplOiA0MHB4O1xuICAgIGNvbG9yOiAjZmZmZmZmO1xuICAgIG1hcmdpbi10b3A6IDEycHg7XG4gICAgZm9udC13ZWlnaHQ6IGJvbGQ7XG4gIH1cbiAgLnN1YnRpdGxlIHtcbiAgICBmb250LXNpemU6IDIycHg7XG4gICAgY29sb3I6ICM4YThhOGE7XG4gICAgbWFyZ2luLXRvcDogNnB4O1xuICAgIG1hcmdpbi1ib3R0b206IDI0cHg7XG4gIH1cbiAgLmJ0biB7XG4gICAgd2lkdGg6IDM2MHB4O1xuICAgIGhlaWdodDogODhweDtcbiAgICBib3JkZXItcmFkaXVzOiA0NHB4O1xuICAgIGNvbG9yOiAjZmZmZmZmO1xuICAgIGZvbnQtc2l6ZTogMzJweDtcbiAgICBtYXJnaW4tYm90dG9tOiAxOHB4O1xuICAgIHRleHQtYWxpZ246IGNlbnRlcjtcbiAgfVxuICAuYnRuLXByb2JlIHsgYmFja2dyb3VuZC1jb2xvcjogIzU1NTU1NTsgfVxuICAuYnRuLW9wZW4geyBiYWNrZ3JvdW5kLWNvbG9yOiAjMGE4NGZmOyB9XG4gIC5idG4tY2xvc2UgeyBiYWNrZ3JvdW5kLWNvbG9yOiAjZmY5ZjBhOyB9XG4gIC5zdGF0dXMge1xuICAgIGZvbnQtc2l6ZTogMjZweDtcbiAgICBjb2xvcjogI2ZmZDYwYTtcbiAgICBtYXJnaW46IDEycHggMDtcbiAgICB0ZXh0LWFsaWduOiBjZW50ZXI7XG4gIH1cbiAgLmxvZyB7XG4gICAgd2lkdGg6IDQyMHB4O1xuICAgIGhlaWdodDogMjgwcHg7XG4gICAgbWFyZ2luLXRvcDogOHB4O1xuICAgIGJvcmRlci1jb2xvcjogIzMzMzMzMztcbiAgICBib3JkZXItd2lkdGg6IDFweDtcbiAgICBwYWRkaW5nOiA4cHg7XG4gIH1cbiAgLmxvZ2xpbmUge1xuICAgIGZvbnQtc2l6ZTogMThweDtcbiAgICBjb2xvcjogIzZhZDM2YTtcbiAgICBsaW5lLWhlaWdodDogMjZweDtcbiAgfVxuPC9zdHlsZT5cblxuPHNjcmlwdD5cbiAgaW1wb3J0IHsgTG9ja0NsaWVudCB9IGZyb20gJy4uL2NvbW1vbi9ibGUuanMnXG4gIGltcG9ydCAqIGFzIFAgZnJvbSAnLi4vY29tbW9uL3Byb3RvY29sLmpzJ1xuXG4gIGNvbnN0IExPQ0tfTUFDID0gJzFFOjk4OjZDOjAyOkE3Ojc3J1xuICBjb25zdCBEQVRBX1NFQ1JFVCA9IFAuaGV4VG9CeXRlcygnREJDQ0I1NEQ2RTJFNjU1OTU4RkY5RTI5Q0JGOEE3NjQnKVxuICBjb25zdCBVU0VSX0tFWSA9IFAuaGV4VG9CeXRlcygnMEY4MEQzQTdBRjE2RTUxQjVCQUExQTgyOUExNDRCMDRDOTg3ODkwMUVCNjM3N0FDQjUyNTIxNEUzODIwRTBEMicpXG5cbiAgZXhwb3J0IGRlZmF1bHQge1xuICAgIHByaXZhdGU6IHtcbiAgICAgIG1hYzogTE9DS19NQUMsXG4gICAgICBzdGF0dXM6ICfngrnlh7vjgIzmjqLmtYsgQkxF44CN5qOA5p+l5pys6K6+5aSH5piv5ZCm5pSv5oyBJyxcbiAgICAgIGxvZ3M6IFtdXG4gICAgfSxcbiAgICBvbkluaXQoKSB7XG4gICAgICB0aGlzLmNsaWVudCA9IG5ldyBMb2NrQ2xpZW50KHtcbiAgICAgICAgbWFjOiBMT0NLX01BQyxcbiAgICAgICAgZGF0YVNlY3JldDogREFUQV9TRUNSRVQsXG4gICAgICAgIHVzZXJLZXk6IFVTRVJfS0VZLFxuICAgICAgICBhdXRvTG9jazogdHJ1ZSxcbiAgICAgICAgbG9nOiAobSkgPT4gdGhpcy5hcHBlbmRMb2cobSlcbiAgICAgIH0pXG4gICAgICAvLyDlkK/liqjljbPmjqLmtYvok53niZnog73lipvvvJrnlYzpnaLlt7LmuLLmn5PvvIzmraTosIPnlKjljbPkvb/lpLHotKXkuZ/kuI3lvbHlk43mmL7npLrvvJtcbiAgICAgIC8vIOaXoOiTneeJmeaXtueKtuaAgeagj+S8muaYjuehruaPkOekuuOAjOS4jeaUr+aMgeOAje+8jOiAjOS4jeS8mueZveWxj+aIluWNoeS9j+OAglxuICAgICAgdGhpcy5wcm9iZSgpXG4gICAgfSxcbiAgICBhcHBlbmRMb2cobGluZSkge1xuICAgICAgdGhpcy5sb2dzID0gKHRoaXMubG9ncyB8fCBbXSkuY29uY2F0KFtsaW5lXSlcbiAgICAgIGlmICh0aGlzLmxvZ3MubGVuZ3RoID4gNTApIHRoaXMubG9ncyA9IHRoaXMubG9ncy5zbGljZSgtNTApXG4gICAgfSxcbiAgICBzZXRTdGF0dXMocykge1xuICAgICAgdGhpcy5zdGF0dXMgPSBzXG4gICAgfSxcbiAgICBwcm9iZSgpIHtcbiAgICAgIGNvbnN0IHNlbGYgPSB0aGlzXG4gICAgICBzZWxmLnNldFN0YXR1cygn5o6i5rWL5Lit4oCmJylcbiAgICAgIHNlbGYuYXBwZW5kTG9nKCc9PSDmjqLmtYsgQHN5c3RlbS5ibHVldG9vdGguYmxlID09JylcbiAgICAgIHRyeSB7XG4gICAgICAgIGlmIChMb2NrQ2xpZW50LmlzQmxlU3VwcG9ydGVkKCkpIHtcbiAgICAgICAgICBzZWxmLnNldFN0YXR1cygn4pyFIOacrOiuvuWkh+aUr+aMgSBKUyBCTEUgQVBJ77yI5Y+v5bCd6K+V55yf5py65byA6ZSB77yJJylcbiAgICAgICAgICBzZWxmLmFwcGVuZExvZygnY3JlYXRlR2F0dENsaWVudERldmljZSDmlrnms5XlrZjlnKgnKVxuICAgICAgICB9IGVsc2Uge1xuICAgICAgICAgIHNlbGYuc2V0U3RhdHVzKCfinYwg5pys6K6+5aSH5LiN5pSv5oyBIEpTIEJMRe+8iFM0L+a+jua5g09TMyDlpKfmpoLnjofpnIDljp/nlJ8gQ++8iScpXG4gICAgICAgICAgc2VsZi5hcHBlbmRMb2coJ2NyZWF0ZUdhdHRDbGllbnREZXZpY2Ug5LiN5a2Y5ZyoJylcbiAgICAgICAgfVxuICAgICAgfSBjYXRjaCAoZSkge1xuICAgICAgICBzZWxmLnNldFN0YXR1cygn4p2MIOaOoua1i+W8guW4uDogJyArIChlLm1lc3NhZ2UgfHwgZSkpXG4gICAgICAgIHNlbGYuYXBwZW5kTG9nKCdFUlIgJyArIChlLm1lc3NhZ2UgfHwgZSkpXG4gICAgICB9XG4gICAgfSxcbiAgICBvcGVuTG9jaygpIHtcbiAgICAgIGNvbnN0IHNlbGYgPSB0aGlzXG4gICAgICBzZWxmLnNldFN0YXR1cygn5byA6ZSB5Lit4oCmJylcbiAgICAgIHNlbGYuYXBwZW5kTG9nKCc+PiBvcGVuTG9jaycpXG4gICAgICBzZWxmLmNsaWVudC5vcGVuTG9jaygpXG4gICAgICAgIC50aGVuKGZ1bmN0aW9uIChyKSB7XG4gICAgICAgICAgaWYgKHIuc3VjY2Vzcykge1xuICAgICAgICAgICAgc2VsZi5zZXRTdGF0dXMoJ+KchSDlvIDplIHmiJDlip8nICsgKHIuYXV0b0xvY2sgPyAn77yI5bey6K6+5Li66Ieq5Yqo5Zue6ZSB77yJJyA6ICcnKSlcbiAgICAgICAgICAgIHNlbGYuYXBwZW5kTG9nKCc8PCByZXN1bHRDb2RlPScgKyByLnJlc3VsdENvZGUpXG4gICAgICAgICAgfSBlbHNlIHtcbiAgICAgICAgICAgIHNlbGYuc2V0U3RhdHVzKCfimqDvuI8g5byA6ZSB6L+U5Zue5aSx6LSlIHJlc3VsdENvZGU9JyArIHIucmVzdWx0Q29kZSlcbiAgICAgICAgICAgIHNlbGYuYXBwZW5kTG9nKCc8PCByZXN1bHRDb2RlPScgKyByLnJlc3VsdENvZGUpXG4gICAgICAgICAgfVxuICAgICAgICB9KVxuICAgICAgICAuY2F0Y2goZnVuY3Rpb24gKGUpIHtcbiAgICAgICAgICBzZWxmLnNldFN0YXR1cygn4p2MIOW8gOmUgeWksei0pTogJyArIChlLm1lc3NhZ2UgfHwgZSkpXG4gICAgICAgICAgc2VsZi5hcHBlbmRMb2coJ0VSUiAnICsgKGUubWVzc2FnZSB8fCBlKSlcbiAgICAgICAgfSlcbiAgICB9LFxuICAgIGNsb3NlTG9jaygpIHtcbiAgICAgIGNvbnN0IHNlbGYgPSB0aGlzXG4gICAgICBzZWxmLnNldFN0YXR1cygn5YWz6ZSB5Lit4oCmJylcbiAgICAgIHNlbGYuYXBwZW5kTG9nKCc+PiBjbG9zZUxvY2snKVxuICAgICAgc2VsZi5jbGllbnQuY2xvc2VMb2NrKClcbiAgICAgICAgLnRoZW4oZnVuY3Rpb24gKHIpIHtcbiAgICAgICAgICBzZWxmLnNldFN0YXR1cygn4pyFIOWFs+mUgeaMh+S7pOW3suWPkemAgScpXG4gICAgICAgICAgc2VsZi5hcHBlbmRMb2coJzw8IHJlc3VsdENvZGU9JyArIHIucmVzdWx0Q29kZSlcbiAgICAgICAgfSlcbiAgICAgICAgLmNhdGNoKGZ1bmN0aW9uIChlKSB7XG4gICAgICAgICAgc2VsZi5zZXRTdGF0dXMoJ+KdjCDlhbPplIHlpLHotKU6ICcgKyAoZS5tZXNzYWdlIHx8IGUpKVxuICAgICAgICAgIHNlbGYuYXBwZW5kTG9nKCdFUlIgJyArIChlLm1lc3NhZ2UgfHwgZSkpXG4gICAgICAgIH0pXG4gICAgfVxuICB9XG48L3NjcmlwdD5cbiJdLCJuYW1lcyI6WyJQIiwiX2ludGVyb3BSZXF1aXJlV2lsZGNhcmQiLCJyZXF1aXJlIiwiZSIsInQiLCJXZWFrTWFwIiwiciIsIm4iLCJfX2VzTW9kdWxlIiwibyIsImkiLCJmIiwiX19wcm90b19fIiwiZGVmYXVsdCIsImhhcyIsImdldCIsInNldCIsImhhc093blByb3BlcnR5IiwiY2FsbCIsIk9iamVjdCIsImRlZmluZVByb3BlcnR5IiwiZ2V0T3duUHJvcGVydHlEZXNjcmlwdG9yIiwiZ2V0QmxlTW9kdWxlIiwibSIsImdsb2JhbFRoaXMiLCJTRVJWSUNFX1VVSUQiLCJXUklURV9VVUlEIiwiTk9USUZZX1VVSUQiLCJXUklURV9DSFVOSyIsImJ1ZlRvQnl0ZXMiLCJidWYiLCJBcnJheUJ1ZmZlciIsIlVpbnQ4QXJyYXkiLCJpc1ZpZXciLCJidWZmZXIiLCJieXRlT2Zmc2V0IiwiYnl0ZUxlbmd0aCIsIkFycmF5IiwiaXNBcnJheSIsImZyb20iLCJieXRlc1RvQXJyYXlCdWZmZXIiLCJieXRlcyIsImFiIiwibGVuZ3RoIiwidSIsIkxvY2tDbGllbnQiLCJjb25zdHJ1Y3RvciIsIm9wdHMiLCJtYWMiLCJkYXRhU2VjcmV0IiwidXNlcktleSIsImF1dG9Mb2NrIiwiZGV2aWNlIiwid3JpdGVDaGFyIiwibm90aWZ5Q2hhciIsInJlY3ZCdWYiLCJwZW5kaW5nIiwiY29ubmVjdGVkIiwibG9nIiwiX29uTm90aWZ5IiwiZGF0YSIsInZhbCIsImNoYXJhY3RlcmlzdGljVmFsdWUiLCJjaHVuayIsImJ5dGVzVG9IZXgiLCJjb25jYXRCeXRlcyIsInJlcyIsInRyeVBhcnNlUGFja2V0Iiwic2xpY2UiLCJjb25zdW1lZCIsIl9kaXNwYXRjaCIsInRsdnMiLCJtZXNzYWdlIiwicCIsIm1hdGNoIiwic3BsaWNlIiwicmVzb2x2ZSIsIl93YWl0UGFja2V0IiwibWF0Y2hGbiIsInRpbWVvdXRNcyIsInNlbGYiLCJQcm9taXNlIiwicmVqZWN0IiwidGltZXIiLCJzZXRUaW1lb3V0IiwiaWR4IiwiZmluZEluZGV4IiwiRXJyb3IiLCJwdXNoIiwiY2xlYXJUaW1lb3V0IiwiaXNCbGVTdXBwb3J0ZWQiLCJibGUiLCJjcmVhdGVHYXR0Q2xpZW50RGV2aWNlIiwiY29ubmVjdCIsImRldiIsIm9uQkxFQ29ubmVjdGlvblN0YXRlQ2hhbmdlIiwic3RhdGUiLCJvbkJMRUNoYXJhY3RlcmlzdGljQ2hhbmdlIiwic3VjY2VzcyIsInN0YXJ0ZWQiLCJEYXRlIiwibm93IiwiaXYiLCJzZXRJbnRlcnZhbCIsImNsZWFySW50ZXJ2YWwiLCJmYWlsIiwiZCIsImNvZGUiLCJfZ2V0U2VydmljZXMiLCJnZXRTZXJ2aWNlcyIsInNlcnZpY2VzIiwicyIsImMiLCJjaGFyYWN0ZXJpc3RpY3MiLCJjaGFyYWN0ZXJpc3RpY1V1aWQiLCJ0b0xvd2VyQ2FzZSIsIl9lbmFibGVOb3RpZnkiLCJzZXROb3RpZnlDaGFyYWN0ZXJpc3RpY0NoYW5nZWQiLCJjaGFyYWN0ZXJpc3RpYyIsImVuYWJsZSIsIl93cml0ZSIsIm9mZiIsIndyaXRlTmV4dCIsIk1hdGgiLCJtaW4iLCJzZXJ2aWNlVXVpZCIsIndyaXRlQ2hhcmFjdGVyaXN0aWNWYWx1ZSIsIm9wZW5Mb2NrIiwidGhlbiIsImdyYyIsImJ1aWxkR2V0UmFuZ2VDb2RlIiwicmFuZFdhaXRlciIsInIxIiwicmFuZFN0ciIsIm9wIiwiYnVpbGRPcGVuTG9jayIsIm9wZW5XYWl0ZXIiLCJyMiIsInJjIiwib2siLCJkaXNjb25uZWN0IiwicmVzdWx0Q29kZSIsImNsb3NlTG9jayIsImNsIiwiYnVpbGRDbG9zZUxvY2siLCJjbG9zZVdhaXRlciIsImNvbXBsZXRlIiwiZXhwb3J0cyIsIkRFTFRBIiwiUk9VTkRTIiwiQkxPQ0siLCJyZWFkSW50QkUiLCJiIiwid3JpdGVJbnRCRSIsInYiLCJoZXhUb0J5dGVzIiwiaGV4IiwicmVwbGFjZSIsIm91dCIsInBhcnNlSW50Iiwic3Vic3RyIiwidG9TdHJpbmciLCJwYWRTdGFydCIsInhvck9mIiwieCIsInBrY3M3UGFkIiwiYmxvY2siLCJyZW0iLCJwYWQiLCJ0ZWFFbmNyeXB0Iiwia2V5IiwicGFkZGVkIiwiayIsInYwIiwidjEiLCJzdW0iLCJrMCIsImsxIiwiazIiLCJrMyIsInRlYURlY3J5cHQiLCJwYWRMZW4iLCJidWlsZFRsdiIsInRhZyIsInZhbHVlIiwicGFyc2VUbHYiLCJyZXN1bHQiLCJhcnJzIiwibGVuIiwiYSIsImJ1aWxkRnVsbENvbW1hbmQiLCJjbWRUeXBlIiwiY21kQ29kZSIsInVuaXRzIiwiY21kVmFsdWUiLCJtYXAiLCJpbm5lclRhZyIsImlubmVyVGx2IiwiaW5uZXIiLCJlbmMiLCJ0bHYyOSIsIm91dGVyVGx2IiwidmFsaWQiLCJlbmQiLCJwa2ciLCJwYXlsb2FkIiwiaW5uZXJUbHZzIiwiX193ZWJwYWNrX3JlcXVpcmVfXyIsIlN5bWJvbCIsIl9ibGUiLCJMT0NLX01BQyIsIkRBVEFfU0VDUkVUIiwiVVNFUl9LRVkiLCJfZGVmYXVsdCIsInByaXZhdGUiLCJzdGF0dXMiLCJsb2dzIiwib25Jbml0IiwiY2xpZW50IiwiYXBwZW5kTG9nIiwicHJvYmUiLCJsaW5lIiwiY29uY2F0Iiwic2V0U3RhdHVzIiwiY2F0Y2giXSwibWFwcGluZ3MiOiI7Ozs7Ozs7Ozs7Ozs7Ozs7Ozt3QkFLQSxJQUFBQSxJQUFBQyx3QkFBQUMsUUFBQTt3QkFBa0MsU0FBQUQsd0JBQUFFLENBQUEsRUFBQUMsQ0FBQTs0QkFBQSx5QkFBQUMsU0FBQSxJQUFBQyxJQUFBLElBQUFELFdBQUFFLElBQUEsSUFBQUY7NEJBQUEsT0FBQUosQ0FBQUEsMEJBQUEsU0FBQUUsQ0FBQSxFQUFBQyxDQUFBO2dDQUFBLEtBQUFBLEtBQUFELEtBQUFBLEVBQUFLLFVBQUEsU0FBQUw7Z0NBQUEsSUFBQU0sR0FBQUMsR0FBQUMsSUFBQTtvQ0FBQUMsV0FBQTtvQ0FBQUMsU0FBQVY7Z0NBQUE7Z0NBQUEsYUFBQUEsS0FBQSxtQkFBQUEsS0FBQSxxQkFBQUEsR0FBQSxPQUFBUTtnQ0FBQSxJQUFBRixJQUFBTCxJQUFBRyxJQUFBRCxHQUFBO29DQUFBLElBQUFHLEVBQUFLLEdBQUEsQ0FBQVgsSUFBQSxPQUFBTSxFQUFBTSxHQUFB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