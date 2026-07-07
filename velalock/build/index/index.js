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
                        let bluetoothBLE = null;
                        try {
                            if ("u" > typeof require) bluetoothBLE = $app_require$1("@app-module/system.bluetooth.ble");
                        } catch (e) {
                            bluetoothBLE = null;
                        }
                        if (!bluetoothBLE && void 0 !== globalThis) bluetoothBLE = globalThis['@system.bluetooth.ble'] || null;
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
                                return !!(bluetoothBLE && 'function' == typeof bluetoothBLE.createGattClientDevice);
                            }
                            connect() {
                                const self = this;
                                return new Promise(function(resolve, reject) {
                                    if (!LockClient.isBleSupported()) return void reject(new Error('@system.bluetooth.ble 不可用：本设备(可能 S4/澎湃OS3)未开放 JS 蓝牙，需改用 Vela 原生 C 开发'));
                                    let dev;
                                    try {
                                        dev = bluetoothBLE.createGattClientDevice(self.mac, 'PUBLIC');
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
                            async openLock() {
                                await this.connect();
                                await this._getServices();
                                await this._enableNotify();
                                const grc = P.buildGetRangeCode(this.dataSecret);
                                const randWaiter = this._waitPacket(function(tlvs) {
                                    return !!tlvs[100];
                                }, 8000);
                                await this._write(grc);
                                const r1 = await randWaiter;
                                const randStr = r1[100];
                                const op = P.buildOpenLock(this.userKey, randStr, this.autoLock, this.dataSecret);
                                const openWaiter = this._waitPacket(function(tlvs) {
                                    return !!tlvs[1];
                                }, 8000);
                                await this._write(op);
                                const r2 = await openWaiter;
                                const rc = r2[1];
                                const ok = !!rc && rc.length >= 2 && 0 === rc[0] && 0 === rc[1];
                                await this.disconnect();
                                return {
                                    success: ok,
                                    resultCode: P.bytesToHex(rc || new Uint8Array(0)),
                                    autoLock: this.autoLock
                                };
                            }
                            async closeLock() {
                                await this.connect();
                                await this._getServices();
                                await this._enableNotify();
                                const grc = P.buildGetRangeCode(this.dataSecret);
                                const randWaiter = this._waitPacket(function(tlvs) {
                                    return !!tlvs[100];
                                }, 8000);
                                await this._write(grc);
                                const r1 = await randWaiter;
                                const randStr = r1[100];
                                const cl = P.buildCloseLock(randStr, this.dataSecret);
                                const closeWaiter = this._waitPacket(function(tlvs) {
                                    return !!tlvs[1] || !!tlvs[25];
                                }, 8000);
                                await this._write(cl);
                                const r2 = await closeWaiter;
                                await this.disconnect();
                                return {
                                    success: true,
                                    resultCode: P.bytesToHex(r2[1] || new Uint8Array(0))
                                };
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
                            async openLock () {
                                const self = this;
                                self.setStatus('开锁中…');
                                self.appendLog('>> openLock');
                                try {
                                    const r = await self.client.openLock();
                                    if (r.success) {
                                        self.setStatus('✅ 开锁成功' + (r.autoLock ? '（已设为自动回锁）' : ''));
                                        self.appendLog('<< resultCode=' + r.resultCode);
                                    } else {
                                        self.setStatus('⚠️ 开锁返回失败 resultCode=' + r.resultCode);
                                        self.appendLog('<< resultCode=' + r.resultCode);
                                    }
                                } catch (e) {
                                    self.setStatus('❌ 开锁失败: ' + (e.message || e));
                                    self.appendLog('ERR ' + (e.message || e));
                                }
                            },
                            async closeLock () {
                                const self = this;
                                self.setStatus('关锁中…');
                                self.appendLog('>> closeLock');
                                try {
                                    const r = await self.client.closeLock();
                                    self.setStatus('✅ 关锁指令已发送');
                                    self.appendLog('<< resultCode=' + r.resultCode);
                                } catch (e) {
                                    self.setStatus('❌ 关锁失败: ' + (e.message || e));
                                    self.appendLog('ERR ' + (e.message || e));
                                }
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

//# sourceMappingURL=data:application/json;charset=utf-8;base64,eyJ2ZXJzaW9uIjozLCJmaWxlIjoiaW5kZXgvaW5kZXguanMiLCJzb3VyY2VzIjpbIndlYnBhY2s6Ly93ZWl0YW5nLXZlbGEtbG9jay9zcmMvY29tbW9uL2JsZS5qcyIsIndlYnBhY2s6Ly93ZWl0YW5nLXZlbGEtbG9jay9zcmMvY29tbW9uL3Byb3RvY29sLmpzIiwid2VicGFjazovL3dlaXRhbmctdmVsYS1sb2NrL3dlYnBhY2svcnVudGltZS9tYWtlX25hbWVzcGFjZV9vYmplY3QiLCJ3ZWJwYWNrOi8vd2VpdGFuZy12ZWxhLWxvY2svd2VicGFjay9ydW50aW1lL3JzcGFja192ZXJzaW9uIiwid2VicGFjazovL3dlaXRhbmctdmVsYS1sb2NrL3dlYnBhY2svcnVudGltZS9yc3BhY2tfdW5pcXVlX2lkIiwid2VicGFjazovL3dlaXRhbmctdmVsYS1sb2NrL3NyYy9pbmRleC9pbmRleC51eCJdLCJzb3VyY2VzQ29udGVudCI6WyIvLyBibGUuanMg4oCUIOW+ruajoOmXqOmUgSBWZWxhIOW/q+W6lOeUqCBCTEUg5a6i5oi356uvICjln7rkuo4gQHN5c3RlbS5ibHVldG9vdGguYmxlKVxuLy8g5oqK5Zue6LCD5byPIEFQSSDlsIHoo4XmiJAgUHJvbWlzZe+8jOW5tuWunueOsCDov57mjqXihpLlj5bpmo/mnLrkuLLihpLlvIDplIEv5YWz6ZSB4oaS6Kej5p6QIOeahOeKtuaAgeacuuOAglxuLy8g5rOo5oSPOiDlrpjmlrnmlofmoaPms6jmmI4gSlMgQkxFIEdBVFQgQVBJIOS7hSBYaWFvbWkgV2F0Y2ggUzUg5piO56Gu5pSv5oyB77ybXG4vLyAgICAgICDlhbblroPlnovlj7co5aaCIFM0IFNwb3J0IC8g5r6O5rmDT1MzKemcgOecn+acuuWunua1i++8jOacrOaWh+S7tuWcqCBjb25uZWN0IOaXtuWBmuS6huiDveWKm+aOoua1i+OAglxuXG5pbXBvcnQgKiBhcyBQIGZyb20gJy4vcHJvdG9jb2wuanMnXG5cbi8vIOWuuemUmeiOt+WPliBAc3lzdGVtLmJsdWV0b290aC5ibGXvvJpcbi8vIOaooeaLn+WZqC9TNCDnrYnlj6/og73mnKrlvIDmlL4gSlMg6JOd54mZ5qih5Z2X77yM6Z2Z5oCBIGltcG9ydCDkvJrku6TmlbTkuKogYmxlLmpzIOWKoOi9veWksei0pei/m+iAjOeZveWxj+OAglxuLy8g5pS55Li66L+Q6KGM5pe26I635Y+W77yM57y65aSx5pe25a6J5YWo6ZmN57qn5Li6IG51bGzvvIhpc0JsZVN1cHBvcnRlZCDov5Tlm54gZmFsc2XvvIxVSSDlj4vlpb3mj5DnpLrvvInjgIJcbmxldCBibHVldG9vdGhCTEUgPSBudWxsXG50cnkge1xuICBpZiAodHlwZW9mIHJlcXVpcmUgIT09ICd1bmRlZmluZWQnKSB7XG4gICAgYmx1ZXRvb3RoQkxFID0gcmVxdWlyZSgnQHN5c3RlbS5ibHVldG9vdGguYmxlJylcbiAgfVxufSBjYXRjaCAoZSkge1xuICBibHVldG9vdGhCTEUgPSBudWxsXG59XG5pZiAoIWJsdWV0b290aEJMRSAmJiB0eXBlb2YgZ2xvYmFsVGhpcyAhPT0gJ3VuZGVmaW5lZCcpIHtcbiAgYmx1ZXRvb3RoQkxFID0gZ2xvYmFsVGhpc1snQHN5c3RlbS5ibHVldG9vdGguYmxlJ10gfHwgbnVsbFxufVxuXG5jb25zdCBTRVJWSUNFX1VVSUQgPSAnMDAwMDE4ZjAtMDAwMC0xMDAwLTgwMDAtMDA4MDVmOWIzNGZiJ1xuY29uc3QgV1JJVEVfVVVJRCA9ICcwMDAwMmFmMS0wMDAwLTEwMDAtODAwMC0wMDgwNWY5YjM0ZmInXG5jb25zdCBOT1RJRllfVVVJRCA9ICcwMDAwMmFmMC0wMDAwLTEwMDAtODAwMC0wMDgwNWY5YjM0ZmInXG5cbi8vIFZlbGEg55yf5py6IE1UVSDpu5jorqQgMjPvvIzlh4/ljrsgMyDlrZfoioLlpLTlkI7ljZXljIUgMjAg5a2X6IqC77yI5LiOIFB5dGhvbiDohJrmnKzkuIDoh7TvvIlcbmNvbnN0IFdSSVRFX0NIVU5LID0gMjBcblxuZnVuY3Rpb24gYnVmVG9CeXRlcyhidWYpIHtcbiAgaWYgKGJ1ZiBpbnN0YW5jZW9mIEFycmF5QnVmZmVyKSByZXR1cm4gbmV3IFVpbnQ4QXJyYXkoYnVmKVxuICBpZiAodHlwZW9mIEFycmF5QnVmZmVyICE9PSAndW5kZWZpbmVkJyAmJiBBcnJheUJ1ZmZlci5pc1ZpZXcoYnVmKSkge1xuICAgIHJldHVybiBuZXcgVWludDhBcnJheShidWYuYnVmZmVyLCBidWYuYnl0ZU9mZnNldCwgYnVmLmJ5dGVMZW5ndGgpXG4gIH1cbiAgaWYgKEFycmF5LmlzQXJyYXkoYnVmKSkgcmV0dXJuIFVpbnQ4QXJyYXkuZnJvbShidWYpXG4gIHJldHVybiBuZXcgVWludDhBcnJheSgwKVxufVxuXG5mdW5jdGlvbiBieXRlc1RvQXJyYXlCdWZmZXIoYnl0ZXMpIHtcbiAgY29uc3QgYWIgPSBuZXcgQXJyYXlCdWZmZXIoYnl0ZXMubGVuZ3RoKVxuICBjb25zdCB1ID0gbmV3IFVpbnQ4QXJyYXkoYWIpXG4gIHUuc2V0KGJ5dGVzKVxuICByZXR1cm4gYWJcbn1cblxuZXhwb3J0IGNsYXNzIExvY2tDbGllbnQge1xuICBjb25zdHJ1Y3RvcihvcHRzKSB7XG4gICAgdGhpcy5tYWMgPSBvcHRzLm1hY1xuICAgIHRoaXMuZGF0YVNlY3JldCA9IG9wdHMuZGF0YVNlY3JldFxuICAgIHRoaXMudXNlcktleSA9IG9wdHMudXNlcktleVxuICAgIHRoaXMuYXV0b0xvY2sgPSBvcHRzLmF1dG9Mb2NrICE9PSBmYWxzZSAvLyDpu5jorqTlvIDplIHlkI7oh6rliqjlm57plIFcbiAgICB0aGlzLmRldmljZSA9IG51bGxcbiAgICB0aGlzLndyaXRlQ2hhciA9IG51bGxcbiAgICB0aGlzLm5vdGlmeUNoYXIgPSBudWxsXG4gICAgdGhpcy5yZWN2QnVmID0gbmV3IFVpbnQ4QXJyYXkoMClcbiAgICB0aGlzLnBlbmRpbmcgPSBbXSAvLyDnrYnlvoXnibnlrprlk43lupTljIXnmoQgcmVzb2x2ZXIg5YiX6KGoXG4gICAgdGhpcy5jb25uZWN0ZWQgPSBmYWxzZVxuICAgIHRoaXMubG9nID0gb3B0cy5sb2cgfHwgZnVuY3Rpb24gKCkge31cbiAgfVxuXG4gIF9vbk5vdGlmeShkYXRhKSB7XG4gICAgdHJ5IHtcbiAgICAgIGNvbnN0IHZhbCA9IGRhdGEgJiYgZGF0YS5jaGFyYWN0ZXJpc3RpY1ZhbHVlXG4gICAgICBpZiAoIXZhbCkgcmV0dXJuXG4gICAgICBjb25zdCBjaHVuayA9IGJ1ZlRvQnl0ZXModmFsKVxuICAgICAgaWYgKGNodW5rLmxlbmd0aCA9PT0gMCkgcmV0dXJuXG4gICAgICB0aGlzLmxvZygnUkVDViAnICsgUC5ieXRlc1RvSGV4KGNodW5rKSlcbiAgICAgIHRoaXMucmVjdkJ1ZiA9IFAuY29uY2F0Qnl0ZXModGhpcy5yZWN2QnVmLCBjaHVuaylcbiAgICAgIC8vIOW+queOr+ino+aekOaJgOacieWujOaVtOWMhe+8iOmUgeWBtuWPkeWFiOWPkSAwMDAwIOWJjeWvvO+8jHRyeVBhcnNlUGFja2V0IOS8mui3s+i/h+mdnuazlSB0YWfvvIlcbiAgICAgIHdoaWxlICh0cnVlKSB7XG4gICAgICAgIGNvbnN0IHJlcyA9IFAudHJ5UGFyc2VQYWNrZXQodGhpcy5yZWN2QnVmLCB0aGlzLmRhdGFTZWNyZXQpXG4gICAgICAgIGlmICghcmVzKSBicmVha1xuICAgICAgICB0aGlzLnJlY3ZCdWYgPSB0aGlzLnJlY3ZCdWYuc2xpY2UocmVzLmNvbnN1bWVkKVxuICAgICAgICB0aGlzLl9kaXNwYXRjaChyZXMudGx2cylcbiAgICAgIH1cbiAgICB9IGNhdGNoIChlKSB7XG4gICAgICB0aGlzLmxvZygnb25Ob3RpZnkgZXJyb3I6ICcgKyAoZSAmJiBlLm1lc3NhZ2UgPyBlLm1lc3NhZ2UgOiBlKSlcbiAgICB9XG4gIH1cblxuICBfZGlzcGF0Y2godGx2cykge1xuICAgIGZvciAobGV0IGkgPSAwOyBpIDwgdGhpcy5wZW5kaW5nLmxlbmd0aDsgaSsrKSB7XG4gICAgICBjb25zdCBwID0gdGhpcy5wZW5kaW5nW2ldXG4gICAgICBpZiAocC5tYXRjaCh0bHZzKSkge1xuICAgICAgICB0aGlzLnBlbmRpbmcuc3BsaWNlKGksIDEpXG4gICAgICAgIHAucmVzb2x2ZSh0bHZzKVxuICAgICAgICByZXR1cm5cbiAgICAgIH1cbiAgICB9XG4gIH1cblxuICBfd2FpdFBhY2tldChtYXRjaEZuLCB0aW1lb3V0TXMpIHtcbiAgICBjb25zdCBzZWxmID0gdGhpc1xuICAgIHJldHVybiBuZXcgUHJvbWlzZSgocmVzb2x2ZSwgcmVqZWN0KSA9PiB7XG4gICAgICBjb25zdCB0aW1lciA9IHNldFRpbWVvdXQoZnVuY3Rpb24gKCkge1xuICAgICAgICBjb25zdCBpZHggPSBzZWxmLnBlbmRpbmcuZmluZEluZGV4KGZ1bmN0aW9uIChwKSB7XG4gICAgICAgICAgcmV0dXJuIHAucmVzb2x2ZSA9PT0gcmVzb2x2ZVxuICAgICAgICB9KVxuICAgICAgICBpZiAoaWR4ID49IDApIHNlbGYucGVuZGluZy5zcGxpY2UoaWR4LCAxKVxuICAgICAgICByZWplY3QobmV3IEVycm9yKCfnrYnlvoXlk43lupTotoXml7YnKSlcbiAgICAgIH0sIHRpbWVvdXRNcyB8fCA4MDAwKVxuICAgICAgc2VsZi5wZW5kaW5nLnB1c2goe1xuICAgICAgICBtYXRjaDogbWF0Y2hGbixcbiAgICAgICAgcmVzb2x2ZTogZnVuY3Rpb24gKHRsdnMpIHtcbiAgICAgICAgICBjbGVhclRpbWVvdXQodGltZXIpXG4gICAgICAgICAgcmVzb2x2ZSh0bHZzKVxuICAgICAgICB9XG4gICAgICB9KVxuICAgIH0pXG4gIH1cblxuICAvLyDmjqLmtYvmnKzorr7lpIfmmK/lkKbmlK/mjIEgSlMgQkxF77yIUzQg562J5aSa5Z6L5Y+35Y+v6IO95LiN5Y+v55So77yJXG4gIHN0YXRpYyBpc0JsZVN1cHBvcnRlZCgpIHtcbiAgICByZXR1cm4gISEoYmx1ZXRvb3RoQkxFICYmIHR5cGVvZiBibHVldG9vdGhCTEUuY3JlYXRlR2F0dENsaWVudERldmljZSA9PT0gJ2Z1bmN0aW9uJylcbiAgfVxuXG4gIGNvbm5lY3QoKSB7XG4gICAgY29uc3Qgc2VsZiA9IHRoaXNcbiAgICByZXR1cm4gbmV3IFByb21pc2UoZnVuY3Rpb24gKHJlc29sdmUsIHJlamVjdCkge1xuICAgICAgaWYgKCFMb2NrQ2xpZW50LmlzQmxlU3VwcG9ydGVkKCkpIHtcbiAgICAgICAgcmVqZWN0KG5ldyBFcnJvcignQHN5c3RlbS5ibHVldG9vdGguYmxlIOS4jeWPr+eUqO+8muacrOiuvuWkhyjlj6/og70gUzQv5r6O5rmDT1MzKeacquW8gOaUviBKUyDok53niZnvvIzpnIDmlLnnlKggVmVsYSDljp/nlJ8gQyDlvIDlj5EnKSlcbiAgICAgICAgcmV0dXJuXG4gICAgICB9XG4gICAgICBsZXQgZGV2XG4gICAgICB0cnkge1xuICAgICAgICBkZXYgPSBibHVldG9vdGhCTEUuY3JlYXRlR2F0dENsaWVudERldmljZShzZWxmLm1hYywgJ1BVQkxJQycpXG4gICAgICB9IGNhdGNoIChlKSB7XG4gICAgICAgIHJlamVjdChuZXcgRXJyb3IoJ2NyZWF0ZUdhdHRDbGllbnREZXZpY2Ug5aSx6LSlOiAnICsgKGUubWVzc2FnZSB8fCBlKSkpXG4gICAgICAgIHJldHVyblxuICAgICAgfVxuICAgICAgc2VsZi5kZXZpY2UgPSBkZXZcbiAgICAgIGRldi5vbkJMRUNvbm5lY3Rpb25TdGF0ZUNoYW5nZSA9IGZ1bmN0aW9uIChzdGF0ZSkge1xuICAgICAgICBzZWxmLmxvZygnY29ubiBzdGF0ZSA9ICcgKyBzdGF0ZSlcbiAgICAgICAgaWYgKHN0YXRlID09PSAyKSBzZWxmLmNvbm5lY3RlZCA9IHRydWVcbiAgICAgICAgZWxzZSBpZiAoc3RhdGUgPT09IDAgfHwgc3RhdGUgPT09IDMpIHNlbGYuY29ubmVjdGVkID0gZmFsc2VcbiAgICAgIH1cbiAgICAgIGRldi5vbkJMRUNoYXJhY3RlcmlzdGljQ2hhbmdlID0gZnVuY3Rpb24gKGRhdGEpIHtcbiAgICAgICAgc2VsZi5fb25Ob3RpZnkoZGF0YSlcbiAgICAgIH1cbiAgICAgIGRldi5jb25uZWN0KHtcbiAgICAgICAgc3VjY2VzczogZnVuY3Rpb24gKCkge1xuICAgICAgICAgIGNvbnN0IHN0YXJ0ZWQgPSBEYXRlLm5vdygpXG4gICAgICAgICAgY29uc3QgaXYgPSBzZXRJbnRlcnZhbChmdW5jdGlvbiAoKSB7XG4gICAgICAgICAgICBpZiAoc2VsZi5jb25uZWN0ZWQpIHtcbiAgICAgICAgICAgICAgY2xlYXJJbnRlcnZhbChpdilcbiAgICAgICAgICAgICAgcmVzb2x2ZSgpXG4gICAgICAgICAgICB9IGVsc2UgaWYgKERhdGUubm93KCkgLSBzdGFydGVkID4gODAwMCkge1xuICAgICAgICAgICAgICBjbGVhckludGVydmFsKGl2KVxuICAgICAgICAgICAgICByZWplY3QobmV3IEVycm9yKCfov57mjqXotoXml7bvvIjpl6jplIHmmK/lkKblnKjpmYTov5Ev5bey5byA5py677yf77yJJykpXG4gICAgICAgICAgICB9XG4gICAgICAgICAgfSwgMTAwKVxuICAgICAgICB9LFxuICAgICAgICBmYWlsOiBmdW5jdGlvbiAoZCwgY29kZSkge1xuICAgICAgICAgIHJlamVjdChuZXcgRXJyb3IoJ+i/nuaOpeWksei0pSBjb2RlPScgKyBjb2RlKSlcbiAgICAgICAgfVxuICAgICAgfSlcbiAgICB9KVxuICB9XG5cbiAgX2dldFNlcnZpY2VzKCkge1xuICAgIGNvbnN0IHNlbGYgPSB0aGlzXG4gICAgcmV0dXJuIG5ldyBQcm9taXNlKGZ1bmN0aW9uIChyZXNvbHZlLCByZWplY3QpIHtcbiAgICAgIHNlbGYuZGV2aWNlLmdldFNlcnZpY2VzKHtcbiAgICAgICAgc3VjY2VzczogZnVuY3Rpb24gKHNlcnZpY2VzKSB7XG4gICAgICAgICAgbGV0IHdyaXRlQ2hhciA9IG51bGxcbiAgICAgICAgICBsZXQgbm90aWZ5Q2hhciA9IG51bGxcbiAgICAgICAgICBmb3IgKGNvbnN0IHMgb2Ygc2VydmljZXMgfHwgW10pIHtcbiAgICAgICAgICAgIGZvciAoY29uc3QgYyBvZiBzLmNoYXJhY3RlcmlzdGljcyB8fCBbXSkge1xuICAgICAgICAgICAgICBjb25zdCB1ID0gKGMuY2hhcmFjdGVyaXN0aWNVdWlkIHx8ICcnKS50b0xvd2VyQ2FzZSgpXG4gICAgICAgICAgICAgIGlmICh1ID09PSBXUklURV9VVUlELnRvTG93ZXJDYXNlKCkpIHdyaXRlQ2hhciA9IGNcbiAgICAgICAgICAgICAgaWYgKHUgPT09IE5PVElGWV9VVUlELnRvTG93ZXJDYXNlKCkpIG5vdGlmeUNoYXIgPSBjXG4gICAgICAgICAgICB9XG4gICAgICAgICAgfVxuICAgICAgICAgIGlmICghd3JpdGVDaGFyIHx8ICFub3RpZnlDaGFyKSB7XG4gICAgICAgICAgICByZWplY3QobmV3IEVycm9yKCfmnKrlnKjplIHmnI3liqHkuK3mib7liLDlhpkv6YCa55+l54m55b6B5YC8JykpXG4gICAgICAgICAgICByZXR1cm5cbiAgICAgICAgICB9XG4gICAgICAgICAgc2VsZi53cml0ZUNoYXIgPSB3cml0ZUNoYXJcbiAgICAgICAgICBzZWxmLm5vdGlmeUNoYXIgPSBub3RpZnlDaGFyXG4gICAgICAgICAgcmVzb2x2ZSgpXG4gICAgICAgIH0sXG4gICAgICAgIGZhaWw6IGZ1bmN0aW9uIChkLCBjb2RlKSB7XG4gICAgICAgICAgcmVqZWN0KG5ldyBFcnJvcign5Y+R546w5pyN5Yqh5aSx6LSlIGNvZGU9JyArIGNvZGUpKVxuICAgICAgICB9XG4gICAgICB9KVxuICAgIH0pXG4gIH1cblxuICBfZW5hYmxlTm90aWZ5KCkge1xuICAgIGNvbnN0IHNlbGYgPSB0aGlzXG4gICAgcmV0dXJuIG5ldyBQcm9taXNlKGZ1bmN0aW9uIChyZXNvbHZlLCByZWplY3QpIHtcbiAgICAgIHNlbGYuZGV2aWNlLnNldE5vdGlmeUNoYXJhY3RlcmlzdGljQ2hhbmdlZCh7XG4gICAgICAgIGNoYXJhY3RlcmlzdGljOiBzZWxmLm5vdGlmeUNoYXIsXG4gICAgICAgIGVuYWJsZTogdHJ1ZSxcbiAgICAgICAgc3VjY2VzczogZnVuY3Rpb24gKCkge1xuICAgICAgICAgIHJlc29sdmUoKVxuICAgICAgICB9LFxuICAgICAgICBmYWlsOiBmdW5jdGlvbiAoZCwgY29kZSkge1xuICAgICAgICAgIHJlamVjdChuZXcgRXJyb3IoJ+WQr+eUqOmAmuefpeWksei0pSBjb2RlPScgKyBjb2RlKSlcbiAgICAgICAgfVxuICAgICAgfSlcbiAgICB9KVxuICB9XG5cbiAgX3dyaXRlKGJ5dGVzKSB7XG4gICAgY29uc3Qgc2VsZiA9IHRoaXNcbiAgICByZXR1cm4gbmV3IFByb21pc2UoZnVuY3Rpb24gKHJlc29sdmUsIHJlamVjdCkge1xuICAgICAgbGV0IG9mZiA9IDBcbiAgICAgIGZ1bmN0aW9uIHdyaXRlTmV4dCgpIHtcbiAgICAgICAgaWYgKG9mZiA+PSBieXRlcy5sZW5ndGgpIHtcbiAgICAgICAgICByZXNvbHZlKClcbiAgICAgICAgICByZXR1cm5cbiAgICAgICAgfVxuICAgICAgICBjb25zdCBuID0gTWF0aC5taW4oV1JJVEVfQ0hVTkssIGJ5dGVzLmxlbmd0aCAtIG9mZilcbiAgICAgICAgY29uc3QgY2h1bmsgPSBieXRlcy5zbGljZShvZmYsIG9mZiArIG4pXG4gICAgICAgIG9mZiArPSBuXG4gICAgICAgIGNvbnN0IGNoYXJhY3RlcmlzdGljID0ge1xuICAgICAgICAgIHNlcnZpY2VVdWlkOiBzZWxmLndyaXRlQ2hhci5zZXJ2aWNlVXVpZCxcbiAgICAgICAgICBjaGFyYWN0ZXJpc3RpY1V1aWQ6IFdSSVRFX1VVSUQsXG4gICAgICAgICAgY2hhcmFjdGVyaXN0aWNWYWx1ZTogYnl0ZXNUb0FycmF5QnVmZmVyKGNodW5rKVxuICAgICAgICB9XG4gICAgICAgIHNlbGYubG9nKCdTRU5EICcgKyBQLmJ5dGVzVG9IZXgoY2h1bmspKVxuICAgICAgICBzZWxmLmRldmljZS53cml0ZUNoYXJhY3RlcmlzdGljVmFsdWUoe1xuICAgICAgICAgIGNoYXJhY3RlcmlzdGljOiBjaGFyYWN0ZXJpc3RpYyxcbiAgICAgICAgICBzdWNjZXNzOiBmdW5jdGlvbiAoKSB7XG4gICAgICAgICAgICBzZXRUaW1lb3V0KHdyaXRlTmV4dCwgMjApXG4gICAgICAgICAgfSxcbiAgICAgICAgICBmYWlsOiBmdW5jdGlvbiAoZCwgY29kZSkge1xuICAgICAgICAgICAgcmVqZWN0KG5ldyBFcnJvcign5YaZ54m55b6B5aSx6LSlIGNvZGU9JyArIGNvZGUpKVxuICAgICAgICAgIH1cbiAgICAgICAgfSlcbiAgICAgIH1cbiAgICAgIHdyaXRlTmV4dCgpXG4gICAgfSlcbiAgfVxuXG4gIGFzeW5jIG9wZW5Mb2NrKCkge1xuICAgIGF3YWl0IHRoaXMuY29ubmVjdCgpXG4gICAgYXdhaXQgdGhpcy5fZ2V0U2VydmljZXMoKVxuICAgIGF3YWl0IHRoaXMuX2VuYWJsZU5vdGlmeSgpXG5cbiAgICAvLyAxKSDlj5bpmo/mnLrkuLIgZ2V0UmFuZ2VDb2RlXG4gICAgY29uc3QgZ3JjID0gUC5idWlsZEdldFJhbmdlQ29kZSh0aGlzLmRhdGFTZWNyZXQpXG4gICAgY29uc3QgcmFuZFdhaXRlciA9IHRoaXMuX3dhaXRQYWNrZXQoZnVuY3Rpb24gKHRsdnMpIHtcbiAgICAgIHJldHVybiAhIXRsdnNbMTAwXVxuICAgIH0sIDgwMDApXG4gICAgYXdhaXQgdGhpcy5fd3JpdGUoZ3JjKVxuICAgIGNvbnN0IHIxID0gYXdhaXQgcmFuZFdhaXRlclxuICAgIGNvbnN0IHJhbmRTdHIgPSByMVsxMDBdXG5cbiAgICAvLyAyKSDlvIDplIEgb3BlbkxvY2so55So5oi35a+G6ZKlLCDpmo/mnLrkuLIsIOiHquWKqOmUgSlcbiAgICBjb25zdCBvcCA9IFAuYnVpbGRPcGVuTG9jayh0aGlzLnVzZXJLZXksIHJhbmRTdHIsIHRoaXMuYXV0b0xvY2ssIHRoaXMuZGF0YVNlY3JldClcbiAgICBjb25zdCBvcGVuV2FpdGVyID0gdGhpcy5fd2FpdFBhY2tldChmdW5jdGlvbiAodGx2cykge1xuICAgICAgcmV0dXJuICEhdGx2c1sxXVxuICAgIH0sIDgwMDApXG4gICAgYXdhaXQgdGhpcy5fd3JpdGUob3ApXG4gICAgY29uc3QgcjIgPSBhd2FpdCBvcGVuV2FpdGVyXG4gICAgY29uc3QgcmMgPSByMlsxXVxuICAgIGNvbnN0IG9rID0gISFyYyAmJiByYy5sZW5ndGggPj0gMiAmJiByY1swXSA9PT0gMCAmJiByY1sxXSA9PT0gMFxuICAgIGF3YWl0IHRoaXMuZGlzY29ubmVjdCgpXG4gICAgcmV0dXJuIHtcbiAgICAgIHN1Y2Nlc3M6IG9rLFxuICAgICAgcmVzdWx0Q29kZTogUC5ieXRlc1RvSGV4KHJjIHx8IG5ldyBVaW50OEFycmF5KDApKSxcbiAgICAgIGF1dG9Mb2NrOiB0aGlzLmF1dG9Mb2NrXG4gICAgfVxuICB9XG5cbiAgYXN5bmMgY2xvc2VMb2NrKCkge1xuICAgIGF3YWl0IHRoaXMuY29ubmVjdCgpXG4gICAgYXdhaXQgdGhpcy5fZ2V0U2VydmljZXMoKVxuICAgIGF3YWl0IHRoaXMuX2VuYWJsZU5vdGlmeSgpXG5cbiAgICBjb25zdCBncmMgPSBQLmJ1aWxkR2V0UmFuZ2VDb2RlKHRoaXMuZGF0YVNlY3JldClcbiAgICBjb25zdCByYW5kV2FpdGVyID0gdGhpcy5fd2FpdFBhY2tldChmdW5jdGlvbiAodGx2cykge1xuICAgICAgcmV0dXJuICEhdGx2c1sxMDBdXG4gICAgfSwgODAwMClcbiAgICBhd2FpdCB0aGlzLl93cml0ZShncmMpXG4gICAgY29uc3QgcjEgPSBhd2FpdCByYW5kV2FpdGVyXG4gICAgY29uc3QgcmFuZFN0ciA9IHIxWzEwMF1cblxuICAgIGNvbnN0IGNsID0gUC5idWlsZENsb3NlTG9jayhyYW5kU3RyLCB0aGlzLmRhdGFTZWNyZXQpXG4gICAgY29uc3QgY2xvc2VXYWl0ZXIgPSB0aGlzLl93YWl0UGFja2V0KGZ1bmN0aW9uICh0bHZzKSB7XG4gICAgICByZXR1cm4gISF0bHZzWzFdIHx8ICEhdGx2c1syNV1cbiAgICB9LCA4MDAwKVxuICAgIGF3YWl0IHRoaXMuX3dyaXRlKGNsKVxuICAgIGNvbnN0IHIyID0gYXdhaXQgY2xvc2VXYWl0ZXJcbiAgICBhd2FpdCB0aGlzLmRpc2Nvbm5lY3QoKVxuICAgIHJldHVybiB7XG4gICAgICBzdWNjZXNzOiB0cnVlLFxuICAgICAgcmVzdWx0Q29kZTogUC5ieXRlc1RvSGV4KHIyWzFdIHx8IG5ldyBVaW50OEFycmF5KDApKVxuICAgIH1cbiAgfVxuXG4gIGRpc2Nvbm5lY3QoKSB7XG4gICAgY29uc3Qgc2VsZiA9IHRoaXNcbiAgICByZXR1cm4gbmV3IFByb21pc2UoZnVuY3Rpb24gKHJlc29sdmUpIHtcbiAgICAgIGlmICghc2VsZi5kZXZpY2UpIHtcbiAgICAgICAgcmVzb2x2ZSgpXG4gICAgICAgIHJldHVyblxuICAgICAgfVxuICAgICAgc2VsZi5kZXZpY2UuZGlzY29ubmVjdCh7XG4gICAgICAgIHN1Y2Nlc3M6IGZ1bmN0aW9uICgpIHtcbiAgICAgICAgICByZXNvbHZlKClcbiAgICAgICAgfSxcbiAgICAgICAgZmFpbDogZnVuY3Rpb24gKCkge1xuICAgICAgICAgIHJlc29sdmUoKVxuICAgICAgICB9LFxuICAgICAgICBjb21wbGV0ZTogZnVuY3Rpb24gKCkge1xuICAgICAgICAgIHJlc29sdmUoKVxuICAgICAgICB9XG4gICAgICB9KVxuICAgIH0pXG4gIH1cbn1cbiIsIi8vIHByb3RvY29sLmpzIOKAlCDlvq7mo6Dmmbrog73pl6jplIHljY/orq4gKFZlbGEg5b+r5bqU55So54mIKVxuLy8g5LiOIHVubG9ja192Mi5weSAvIEtvdGxpbiBMb2NrUHJvdG9jb2wg5a2X6IqC57qn5LiA6Ie077yb57qvIEpT77yM5Y+v55SoIE5vZGUg55u05o6l5rWL6K+V44CCXG4vL1xuLy8g5Yqg5a+GOiBURUEoMTbova4sIGRlbHRhPTB4OUUzNzc5QjkpLCDlr4bpkqXkuI7mlbDmja7lnYfkuLogQklHLUVORElBTiAzMuS9jeaVtOaVsFxuLy8g5aSW5bGC5binOiBbdGFnKDJCIEJFKSwgbGVuZ3RoKDJCIEJFKSwgcGF5bG9hZCwgWE9SKDFCKV1cbi8vICAgdGFnID0gKGNtZF90eXBlPDw4KXxjbWRfY29kZVxuLy8g5ZG95LukOlxuLy8gICBnZXRSYW5nZUNvZGUgOiBDb21tYW5kVGx2KDMxLDMpICsgVExWKDI1LHsxMSwxMSwxMSwxMX0pXG4vLyAgIG9wZW5Mb2NrICAgICA6IENvbW1hbmRUbHYoMzEsNykgKyBUTFYoMTAxLOeUqOaIt+WvhumSpSkgKyBUTFYoMTAwLOmaj+acuuS4sikgKyBUTFYoMjUsezMsMywzLDN9KSArIFRMVig2Nizoh6rliqjplIEpXG4vLyAgIGNsb3NlTG9jayAgICA6IENvbW1hbmRUbHYoMzEsOSkgKyBUTFYoMTAwLOmaj+acuuS4sikgKyBUTFYoMjUsezQsNCw0LDR9KVxuXG5jb25zdCBERUxUQSA9IDB4OWUzNzc5YjkgPj4+IDA7XG5jb25zdCBST1VORFMgPSAxNjtcbmNvbnN0IEJMT0NLID0gODtcblxuZnVuY3Rpb24gcmVhZEludEJFKGIsIG9mZikge1xuICByZXR1cm4gKFxuICAgICgoYltvZmZdICYgMHhmZikgPDwgMjQpIHxcbiAgICAoKGJbb2ZmICsgMV0gJiAweGZmKSA8PCAxNikgfFxuICAgICgoYltvZmYgKyAyXSAmIDB4ZmYpIDw8IDgpIHxcbiAgICAoYltvZmYgKyAzXSAmIDB4ZmYpXG4gICkgPj4+IDA7XG59XG5cbmZ1bmN0aW9uIHdyaXRlSW50QkUoYiwgb2ZmLCB2KSB7XG4gIGJbb2ZmXSA9ICh2ID4+PiAyNCkgJiAweGZmO1xuICBiW29mZiArIDFdID0gKHYgPj4+IDE2KSAmIDB4ZmY7XG4gIGJbb2ZmICsgMl0gPSAodiA+Pj4gOCkgJiAweGZmO1xuICBiW29mZiArIDNdID0gdiAmIDB4ZmY7XG59XG5cbmV4cG9ydCBmdW5jdGlvbiBoZXhUb0J5dGVzKGhleCkge1xuICBjb25zdCBzID0gaGV4LnJlcGxhY2UoL1xccy9nLCBcIlwiKTtcbiAgY29uc3Qgb3V0ID0gbmV3IFVpbnQ4QXJyYXkocy5sZW5ndGggLyAyKTtcbiAgZm9yIChsZXQgaSA9IDA7IGkgPCBvdXQubGVuZ3RoOyBpKyspIHtcbiAgICBvdXRbaV0gPSBwYXJzZUludChzLnN1YnN0cihpICogMiwgMiksIDE2KTtcbiAgfVxuICByZXR1cm4gb3V0O1xufVxuXG5leHBvcnQgZnVuY3Rpb24gYnl0ZXNUb0hleChieXRlcykge1xuICBsZXQgcyA9IFwiXCI7XG4gIGZvciAobGV0IGkgPSAwOyBpIDwgYnl0ZXMubGVuZ3RoOyBpKyspIHMgKz0gKGJ5dGVzW2ldICYgMHhmZikudG9TdHJpbmcoMTYpLnBhZFN0YXJ0KDIsIFwiMFwiKTtcbiAgcmV0dXJuIHM7XG59XG5cbmV4cG9ydCBmdW5jdGlvbiB4b3JPZihkYXRhKSB7XG4gIGxldCB4ID0gMDtcbiAgZm9yIChsZXQgaSA9IDA7IGkgPCBkYXRhLmxlbmd0aDsgaSsrKSB4IF49IGRhdGFbaV0gJiAweGZmO1xuICByZXR1cm4geCAmIDB4ZmY7XG59XG5cbmZ1bmN0aW9uIHBrY3M3UGFkKGRhdGEsIGJsb2NrKSB7XG4gIGNvbnN0IHJlbSA9IGRhdGEubGVuZ3RoICUgYmxvY2s7XG4gIGNvbnN0IHBhZCA9IHJlbSA9PT0gMCA/IGJsb2NrIDogYmxvY2sgLSByZW07XG4gIGNvbnN0IG91dCA9IG5ldyBVaW50OEFycmF5KGRhdGEubGVuZ3RoICsgcGFkKTtcbiAgb3V0LnNldChkYXRhLCAwKTtcbiAgZm9yIChsZXQgaSA9IGRhdGEubGVuZ3RoOyBpIDwgb3V0Lmxlbmd0aDsgaSsrKSBvdXRbaV0gPSBwYWQ7XG4gIHJldHVybiBvdXQ7XG59XG5cbi8vIFRFQSDliqDlr4YgKGJpZy1lbmRpYW4sIOagh+WHhiBkZWx0YSwgMTYg6L2uKVxuZXhwb3J0IGZ1bmN0aW9uIHRlYUVuY3J5cHQoZGF0YSwga2V5KSB7XG4gIGNvbnN0IHBhZGRlZCA9IHBrY3M3UGFkKGRhdGEsIEJMT0NLKTtcbiAgY29uc3Qgb3V0ID0gbmV3IFVpbnQ4QXJyYXkocGFkZGVkLmxlbmd0aCk7XG4gIGNvbnN0IGsgPSBbcmVhZEludEJFKGtleSwgMCksIHJlYWRJbnRCRShrZXksIDQpLCByZWFkSW50QkUoa2V5LCA4KSwgcmVhZEludEJFKGtleSwgMTIpXTtcbiAgbGV0IG9mZiA9IDA7XG4gIHdoaWxlIChvZmYgKyBCTE9DSyA8PSBwYWRkZWQubGVuZ3RoKSB7XG4gICAgbGV0IHYwID0gcmVhZEludEJFKHBhZGRlZCwgb2ZmKSA+Pj4gMDtcbiAgICBsZXQgdjEgPSByZWFkSW50QkUocGFkZGVkLCBvZmYgKyA0KSA+Pj4gMDtcbiAgICBsZXQgc3VtID0gMDtcbiAgICBmb3IgKGxldCBpID0gMDsgaSA8IFJPVU5EUzsgaSsrKSB7XG4gICAgICBzdW0gPSAoc3VtICsgREVMVEEpID4+PiAwO1xuICAgICAgY29uc3QgazAgPSBrWzBdID4+PiAwLCBrMSA9IGtbMV0gPj4+IDAsIGsyID0ga1syXSA+Pj4gMCwgazMgPSBrWzNdID4+PiAwO1xuICAgICAgdjAgPSAodjAgKyAoKCgodjEgPDwgNCkgPj4+IDApICsgazApIF4gKHYxICsgc3VtKSBeICgodjEgPj4+IDUpICsgazEpKSkgPj4+IDA7XG4gICAgICB2MSA9ICh2MSArICgoKCh2MCA8PCA0KSA+Pj4gMCkgKyBrMikgXiAodjAgKyBzdW0pIF4gKCh2MCA+Pj4gNSkgKyBrMykpKSA+Pj4gMDtcbiAgICB9XG4gICAgd3JpdGVJbnRCRShvdXQsIG9mZiwgdjApO1xuICAgIHdyaXRlSW50QkUob3V0LCBvZmYgKyA0LCB2MSk7XG4gICAgb2ZmICs9IEJMT0NLO1xuICB9XG4gIHJldHVybiBvdXQ7XG59XG5cbi8vIFRFQSDop6Plr4ZcbmV4cG9ydCBmdW5jdGlvbiB0ZWFEZWNyeXB0KGRhdGEsIGtleSkge1xuICBjb25zdCBvdXQgPSBuZXcgVWludDhBcnJheShkYXRhLmxlbmd0aCk7XG4gIGNvbnN0IGsgPSBbcmVhZEludEJFKGtleSwgMCksIHJlYWRJbnRCRShrZXksIDQpLCByZWFkSW50QkUoa2V5LCA4KSwgcmVhZEludEJFKGtleSwgMTIpXTtcbiAgbGV0IG9mZiA9IDA7XG4gIHdoaWxlIChvZmYgKyBCTE9DSyA8PSBkYXRhLmxlbmd0aCkge1xuICAgIGxldCB2MCA9IHJlYWRJbnRCRShkYXRhLCBvZmYpID4+PiAwO1xuICAgIGxldCB2MSA9IHJlYWRJbnRCRShkYXRhLCBvZmYgKyA0KSA+Pj4gMDtcbiAgICBsZXQgc3VtID0gKERFTFRBICogUk9VTkRTKSA+Pj4gMDtcbiAgICBmb3IgKGxldCBpID0gMDsgaSA8IFJPVU5EUzsgaSsrKSB7XG4gICAgICBjb25zdCBrMCA9IGtbMF0gPj4+IDAsIGsxID0ga1sxXSA+Pj4gMCwgazIgPSBrWzJdID4+PiAwLCBrMyA9IGtbM10gPj4+IDA7XG4gICAgICB2MSA9ICh2MSAtICgoKCh2MCA8PCA0KSA+Pj4gMCkgKyBrMikgXiAodjAgKyBzdW0pIF4gKCh2MCA+Pj4gNSkgKyBrMykpKSA+Pj4gMDtcbiAgICAgIHYwID0gKHYwIC0gKCgoKHYxIDw8IDQpID4+PiAwKSArIGswKSBeICh2MSArIHN1bSkgXiAoKHYxID4+PiA1KSArIGsxKSkpID4+PiAwO1xuICAgICAgc3VtID0gKHN1bSAtIERFTFRBKSA+Pj4gMDtcbiAgICB9XG4gICAgd3JpdGVJbnRCRShvdXQsIG9mZiwgdjApO1xuICAgIHdyaXRlSW50QkUob3V0LCBvZmYgKyA0LCB2MSk7XG4gICAgb2ZmICs9IEJMT0NLO1xuICB9XG4gIC8vIFBLQ1M3IOWOu+Whq+WFhSAo5LiOIFB5dGhvbiB0ZWFfZGVjcnlwdCDkuIDoh7QpXG4gIGNvbnN0IHBhZExlbiA9IG91dFtvdXQubGVuZ3RoIC0gMV0gJiAweGZmO1xuICBpZiAocGFkTGVuID49IDEgJiYgcGFkTGVuIDw9IEJMT0NLKSB7XG4gICAgcmV0dXJuIG91dC5zbGljZSgwLCBvdXQubGVuZ3RoIC0gcGFkTGVuKTtcbiAgfVxuICByZXR1cm4gb3V0O1xufVxuXG5leHBvcnQgZnVuY3Rpb24gYnVpbGRUbHYodGFnLCB2YWx1ZSkge1xuICBjb25zdCBvdXQgPSBuZXcgVWludDhBcnJheSg0ICsgdmFsdWUubGVuZ3RoKTtcbiAgb3V0WzBdID0gKHRhZyA+Pj4gOCkgJiAweGZmO1xuICBvdXRbMV0gPSB0YWcgJiAweGZmO1xuICBvdXRbMl0gPSAodmFsdWUubGVuZ3RoID4+PiA4KSAmIDB4ZmY7XG4gIG91dFszXSA9IHZhbHVlLmxlbmd0aCAmIDB4ZmY7XG4gIG91dC5zZXQodmFsdWUsIDQpO1xuICByZXR1cm4gb3V0O1xufVxuXG5leHBvcnQgZnVuY3Rpb24gcGFyc2VUbHYoZGF0YSkge1xuICBjb25zdCByZXN1bHQgPSB7fTtcbiAgbGV0IGkgPSAwO1xuICB3aGlsZSAoaSArIDQgPD0gZGF0YS5sZW5ndGgpIHtcbiAgICBjb25zdCB0YWcgPSAoKGRhdGFbaV0gJiAweGZmKSA8PCA4KSB8IChkYXRhW2kgKyAxXSAmIDB4ZmYpO1xuICAgIGNvbnN0IGxlbmd0aCA9ICgoZGF0YVtpICsgMl0gJiAweGZmKSA8PCA4KSB8IChkYXRhW2kgKyAzXSAmIDB4ZmYpO1xuICAgIGlmIChpICsgNCArIGxlbmd0aCA+IGRhdGEubGVuZ3RoKSBicmVhaztcbiAgICByZXN1bHRbdGFnXSA9IGRhdGEuc2xpY2UoaSArIDQsIGkgKyA0ICsgbGVuZ3RoKTtcbiAgICBpICs9IDQgKyBsZW5ndGg7XG4gIH1cbiAgcmV0dXJuIHJlc3VsdDtcbn1cblxuZXhwb3J0IGZ1bmN0aW9uIGNvbmNhdEJ5dGVzKC4uLmFycnMpIHtcbiAgbGV0IGxlbiA9IDA7XG4gIGZvciAoY29uc3QgYSBvZiBhcnJzKSBsZW4gKz0gYS5sZW5ndGg7XG4gIGNvbnN0IG91dCA9IG5ldyBVaW50OEFycmF5KGxlbik7XG4gIGxldCBvZmYgPSAwO1xuICBmb3IgKGNvbnN0IGEgb2YgYXJycykge1xuICAgIG91dC5zZXQoYSwgb2ZmKTtcbiAgICBvZmYgKz0gYS5sZW5ndGg7XG4gIH1cbiAgcmV0dXJuIG91dDtcbn1cblxuLy8g5a6M5pW05ZG95LukOlxuLy8gICDlhoXlsYIgPSBDb21tYW5kVGx2KGNtZFR5cGU8PDh8Y21kQ29kZSwg5ZCE5Y+C5pWwVExW5ou85o6lKSArIFhPUlxuLy8gICDlpJblsYIgPSBDb21tYW5kVGx2KDEwNiwxLCBUTFYoMjksIFRFQSjlhoXlsYIpKSkgKyBYT1JcbmV4cG9ydCBmdW5jdGlvbiBidWlsZEZ1bGxDb21tYW5kKGNtZFR5cGUsIGNtZENvZGUsIHVuaXRzLCBrZXkpIHtcbiAgY29uc3QgY21kVmFsdWUgPSBjb25jYXRCeXRlcyguLi51bml0cy5tYXAoKFt0LCB2XSkgPT4gYnVpbGRUbHYodCwgdikpKTtcbiAgY29uc3QgaW5uZXJUYWcgPSAoKGNtZFR5cGUgPDwgOCkgfCBjbWRDb2RlKSA+Pj4gMDtcbiAgY29uc3QgaW5uZXJUbHYgPSBidWlsZFRsdihpbm5lclRhZywgY21kVmFsdWUpO1xuICBjb25zdCBpbm5lciA9IGNvbmNhdEJ5dGVzKGlubmVyVGx2LCBVaW50OEFycmF5LmZyb20oW3hvck9mKGlubmVyVGx2KV0pKTtcbiAgY29uc3QgZW5jID0gdGVhRW5jcnlwdChpbm5lciwga2V5KTtcbiAgY29uc3QgdGx2MjkgPSBidWlsZFRsdigyOSwgZW5jKTtcbiAgY29uc3Qgb3V0ZXJUbHYgPSBidWlsZFRsdigweDZhMDEsIHRsdjI5KTtcbiAgcmV0dXJuIGNvbmNhdEJ5dGVzKG91dGVyVGx2LCBVaW50OEFycmF5LmZyb20oW3hvck9mKG91dGVyVGx2KV0pKTtcbn1cblxuZXhwb3J0IGZ1bmN0aW9uIGJ1aWxkR2V0UmFuZ2VDb2RlKGtleSkge1xuICByZXR1cm4gYnVpbGRGdWxsQ29tbWFuZCgzMSwgMywgW1syNSwgVWludDhBcnJheS5mcm9tKFsxMSwgMTEsIDExLCAxMV0pXV0sIGtleSk7XG59XG5cbmV4cG9ydCBmdW5jdGlvbiBidWlsZE9wZW5Mb2NrKHVzZXJLZXksIHJhbmRTdHIsIGF1dG9Mb2NrLCBrZXkpIHtcbiAgY29uc3QgYSA9IFVpbnQ4QXJyYXkuZnJvbShbYXV0b0xvY2sgPyAxIDogMF0pO1xuICByZXR1cm4gYnVpbGRGdWxsQ29tbWFuZChcbiAgICAzMSxcbiAgICA3LFxuICAgIFtcbiAgICAgIFsxMDEsIHVzZXJLZXldLFxuICAgICAgWzEwMCwgcmFuZFN0cl0sXG4gICAgICBbMjUsIFVpbnQ4QXJyYXkuZnJvbShbMywgMywgMywgM10pXSxcbiAgICAgIFs2NiwgYV0sXG4gICAgXSxcbiAgICBrZXlcbiAgKTtcbn1cblxuZXhwb3J0IGZ1bmN0aW9uIGJ1aWxkQ2xvc2VMb2NrKHJhbmRTdHIsIGtleSkge1xuICByZXR1cm4gYnVpbGRGdWxsQ29tbWFuZCgzMSwgOSwgW1sxMDAsIHJhbmRTdHJdLCBbMjUsIFVpbnQ4QXJyYXkuZnJvbShbNCwgNCwgNCwgNF0pXV0sIGtleSk7XG59XG5cbi8vIOS7jue0r+iuoemAmuefpeWtl+iKguS4reino+aekOS4gOS4quWujOaVtOWkluWxguWMheW5tuino+Wvhiwg6L+U5ZueIHsgdGx2cywgY29uc3VtZWQgfSDmiJYgbnVsbFxuZXhwb3J0IGZ1bmN0aW9uIHRyeVBhcnNlUGFja2V0KGJ1ZmZlciwga2V5KSB7XG4gIGxldCBpID0gMDtcbiAgd2hpbGUgKGkgKyA1IDw9IGJ1ZmZlci5sZW5ndGgpIHtcbiAgICBjb25zdCB0YWcgPSAoKGJ1ZmZlcltpXSAmIDB4ZmYpIDw8IDgpIHwgKGJ1ZmZlcltpICsgMV0gJiAweGZmKTtcbiAgICBjb25zdCB2YWxpZCA9IHRhZyA9PT0gMHg2YTAxIHx8IHRhZyA9PT0gMHg2YTAyIHx8IHRhZyA9PT0gMHg2YTAzIHx8IHRhZyA9PT0gMHg2YTA0IHx8IHRhZyA9PT0gMHgxZjAyO1xuICAgIGlmICghdmFsaWQpIHtcbiAgICAgIGkrKztcbiAgICAgIGNvbnRpbnVlO1xuICAgIH1cbiAgICBjb25zdCBsZW5ndGggPSAoKGJ1ZmZlcltpICsgMl0gJiAweGZmKSA8PCA4KSB8IChidWZmZXJbaSArIDNdICYgMHhmZik7XG4gICAgY29uc3QgZW5kID0gaSArIDQgKyBsZW5ndGggKyAxO1xuICAgIGlmIChidWZmZXIubGVuZ3RoIDwgZW5kKSByZXR1cm4gbnVsbDtcbiAgICBjb25zdCBwa2cgPSBidWZmZXIuc2xpY2UoaSwgZW5kKTtcbiAgICBjb25zdCB4ID0geG9yT2YocGtnLnNsaWNlKDAsIHBrZy5sZW5ndGggLSAxKSk7XG4gICAgaWYgKHggIT09IHBrZ1twa2cubGVuZ3RoIC0gMV0pIHtcbiAgICAgIGkrKztcbiAgICAgIGNvbnRpbnVlO1xuICAgIH1cbiAgICBjb25zdCBwYXlsb2FkID0gYnVmZmVyLnNsaWNlKGkgKyA0LCBpICsgNCArIGxlbmd0aCk7XG4gICAgY29uc3QgdW5pdHMgPSBwYXJzZVRsdihwYXlsb2FkKTtcbiAgICBpZiAodW5pdHNbMjldKSB7XG4gICAgICBjb25zdCBpbm5lciA9IHRlYURlY3J5cHQodW5pdHNbMjldLCBrZXkpO1xuICAgICAgaWYgKGlubmVyLmxlbmd0aCA+PSA1ICYmIHhvck9mKGlubmVyLnNsaWNlKDAsIGlubmVyLmxlbmd0aCAtIDEpKSA9PT0gaW5uZXJbaW5uZXIubGVuZ3RoIC0gMV0pIHtcbiAgICAgICAgY29uc3QgaW5uZXJUbHZzID0gcGFyc2VUbHYoaW5uZXIuc2xpY2UoNCwgaW5uZXIubGVuZ3RoIC0gMSkpO1xuICAgICAgICByZXR1cm4geyB0bHZzOiBpbm5lclRsdnMsIGNvbnN1bWVkOiBlbmQgfTtcbiAgICAgIH1cbiAgICAgIHJldHVybiBudWxsO1xuICAgIH0gZWxzZSBpZiAodW5pdHNbMTAwXSB8fCB1bml0c1syNV0pIHtcbiAgICAgIHJldHVybiB7IHRsdnM6IHVuaXRzLCBjb25zdW1lZDogZW5kIH07XG4gICAgfVxuICAgIHJldHVybiB7IHRsdnM6IHVuaXRzLCBjb25zdW1lZDogZW5kIH07XG4gIH1cbiAgcmV0dXJuIG51bGw7XG59XG4iLCIvLyBkZWZpbmUgX19lc01vZHVsZSBvbiBleHBvcnRzXG5fX3dlYnBhY2tfcmVxdWlyZV9fLnIgPSAoZXhwb3J0cykgPT4ge1xuXHRpZih0eXBlb2YgU3ltYm9sICE9PSAndW5kZWZpbmVkJyAmJiBTeW1ib2wudG9TdHJpbmdUYWcpIHtcblx0XHRPYmplY3QuZGVmaW5lUHJvcGVydHkoZXhwb3J0cywgU3ltYm9sLnRvU3RyaW5nVGFnLCB7IHZhbHVlOiAnTW9kdWxlJyB9KTtcblx0fVxuXHRPYmplY3QuZGVmaW5lUHJvcGVydHkoZXhwb3J0cywgJ19fZXNNb2R1bGUnLCB7IHZhbHVlOiB0cnVlIH0pO1xufTsiLCJfX3dlYnBhY2tfcmVxdWlyZV9fLnJ2ID0gKCkgPT4gKFwiMS43LjEyXCIpIiwiX193ZWJwYWNrX3JlcXVpcmVfXy5ydWlkID0gXCJidW5kbGVyPXJzcGFja0AxLjcuMTJcIjsiLCI8dGVtcGxhdGU+XG4gIDxkaXYgY2xhc3M9XCJwYWdlXCI+XG4gICAgPHRleHQgY2xhc3M9XCJ0aXRsZVwiPuW+ruajoOmXqOmUgTwvdGV4dD5cbiAgICA8dGV4dCBjbGFzcz1cInN1YnRpdGxlXCI+TUFDIHt7IG1hYyB9fTwvdGV4dD5cblxuICAgIDxpbnB1dCBjbGFzcz1cImJ0biBidG4tcHJvYmVcIiB0eXBlPVwiYnV0dG9uXCIgdmFsdWU9XCLmjqLmtYsgQkxFXCIgb25jbGljaz1cInByb2JlXCIgLz5cbiAgICA8aW5wdXQgY2xhc3M9XCJidG4gYnRuLW9wZW5cIiB0eXBlPVwiYnV0dG9uXCIgdmFsdWU9XCLlvIDplIFcIiBvbmNsaWNrPVwib3BlbkxvY2tcIiAvPlxuICAgIDxpbnB1dCBjbGFzcz1cImJ0biBidG4tY2xvc2VcIiB0eXBlPVwiYnV0dG9uXCIgdmFsdWU9XCLlhbPplIFcIiBvbmNsaWNrPVwiY2xvc2VMb2NrXCIgLz5cblxuICAgIDx0ZXh0IGNsYXNzPVwic3RhdHVzXCI+e3sgc3RhdHVzIH19PC90ZXh0PlxuICAgIDxsaXN0IGNsYXNzPVwibG9nXCI+XG4gICAgICA8YmxvY2sgZm9yPVwiKGksIGxpbmUpIGluIGxvZ3NcIj5cbiAgICAgICAgPHRleHQgY2xhc3M9XCJsb2dsaW5lXCI+e3sgbGluZSB9fTwvdGV4dD5cbiAgICAgIDwvYmxvY2s+XG4gICAgPC9saXN0PlxuICA8L2Rpdj5cbjwvdGVtcGxhdGU+XG5cbjxzdHlsZT5cbiAgLnBhZ2Uge1xuICAgIGZsZXgtZGlyZWN0aW9uOiBjb2x1bW47XG4gICAgYWxpZ24taXRlbXM6IGNlbnRlcjtcbiAgICBwYWRkaW5nOiAyNHB4O1xuICAgIGJhY2tncm91bmQtY29sb3I6ICMwYjBiMGI7XG4gIH1cbiAgLnRpdGxlIHtcbiAgICBmb250LXNpemU6IDQwcHg7XG4gICAgY29sb3I6ICNmZmZmZmY7XG4gICAgbWFyZ2luLXRvcDogMTJweDtcbiAgICBmb250LXdlaWdodDogYm9sZDtcbiAgfVxuICAuc3VidGl0bGUge1xuICAgIGZvbnQtc2l6ZTogMjJweDtcbiAgICBjb2xvcjogIzhhOGE4YTtcbiAgICBtYXJnaW4tdG9wOiA2cHg7XG4gICAgbWFyZ2luLWJvdHRvbTogMjRweDtcbiAgfVxuICAuYnRuIHtcbiAgICB3aWR0aDogMzYwcHg7XG4gICAgaGVpZ2h0OiA4OHB4O1xuICAgIGJvcmRlci1yYWRpdXM6IDQ0cHg7XG4gICAgY29sb3I6ICNmZmZmZmY7XG4gICAgZm9udC1zaXplOiAzMnB4O1xuICAgIG1hcmdpbi1ib3R0b206IDE4cHg7XG4gICAgdGV4dC1hbGlnbjogY2VudGVyO1xuICB9XG4gIC5idG4tcHJvYmUgeyBiYWNrZ3JvdW5kLWNvbG9yOiAjNTU1NTU1OyB9XG4gIC5idG4tb3BlbiB7IGJhY2tncm91bmQtY29sb3I6ICMwYTg0ZmY7IH1cbiAgLmJ0bi1jbG9zZSB7IGJhY2tncm91bmQtY29sb3I6ICNmZjlmMGE7IH1cbiAgLnN0YXR1cyB7XG4gICAgZm9udC1zaXplOiAyNnB4O1xuICAgIGNvbG9yOiAjZmZkNjBhO1xuICAgIG1hcmdpbjogMTJweCAwO1xuICAgIHRleHQtYWxpZ246IGNlbnRlcjtcbiAgfVxuICAubG9nIHtcbiAgICB3aWR0aDogNDIwcHg7XG4gICAgaGVpZ2h0OiAyODBweDtcbiAgICBtYXJnaW4tdG9wOiA4cHg7XG4gICAgYm9yZGVyLWNvbG9yOiAjMzMzMzMzO1xuICAgIGJvcmRlci13aWR0aDogMXB4O1xuICAgIHBhZGRpbmc6IDhweDtcbiAgfVxuICAubG9nbGluZSB7XG4gICAgZm9udC1zaXplOiAxOHB4O1xuICAgIGNvbG9yOiAjNmFkMzZhO1xuICAgIGxpbmUtaGVpZ2h0OiAyNnB4O1xuICB9XG48L3N0eWxlPlxuXG48c2NyaXB0PlxuICBpbXBvcnQgeyBMb2NrQ2xpZW50IH0gZnJvbSAnLi4vY29tbW9uL2JsZS5qcydcbiAgaW1wb3J0ICogYXMgUCBmcm9tICcuLi9jb21tb24vcHJvdG9jb2wuanMnXG5cbiAgY29uc3QgTE9DS19NQUMgPSAnMUU6OTg6NkM6MDI6QTc6NzcnXG4gIGNvbnN0IERBVEFfU0VDUkVUID0gUC5oZXhUb0J5dGVzKCdEQkNDQjU0RDZFMkU2NTU5NThGRjlFMjlDQkY4QTc2NCcpXG4gIGNvbnN0IFVTRVJfS0VZID0gUC5oZXhUb0J5dGVzKCcwRjgwRDNBN0FGMTZFNTFCNUJBQTFBODI5QTE0NEIwNEM5ODc4OTAxRUI2Mzc3QUNCNTI1MjE0RTM4MjBFMEQyJylcblxuICBleHBvcnQgZGVmYXVsdCB7XG4gICAgcHJpdmF0ZToge1xuICAgICAgbWFjOiBMT0NLX01BQyxcbiAgICAgIHN0YXR1czogJ+eCueWHu+OAjOaOoua1iyBCTEXjgI3mo4Dmn6XmnKzorr7lpIfmmK/lkKbmlK/mjIEnLFxuICAgICAgbG9nczogW11cbiAgICB9LFxuICAgIG9uSW5pdCgpIHtcbiAgICAgIHRoaXMuY2xpZW50ID0gbmV3IExvY2tDbGllbnQoe1xuICAgICAgICBtYWM6IExPQ0tfTUFDLFxuICAgICAgICBkYXRhU2VjcmV0OiBEQVRBX1NFQ1JFVCxcbiAgICAgICAgdXNlcktleTogVVNFUl9LRVksXG4gICAgICAgIGF1dG9Mb2NrOiB0cnVlLFxuICAgICAgICBsb2c6IChtKSA9PiB0aGlzLmFwcGVuZExvZyhtKVxuICAgICAgfSlcbiAgICB9LFxuICAgIGFwcGVuZExvZyhsaW5lKSB7XG4gICAgICB0aGlzLmxvZ3MgPSAodGhpcy5sb2dzIHx8IFtdKS5jb25jYXQoW2xpbmVdKVxuICAgICAgaWYgKHRoaXMubG9ncy5sZW5ndGggPiA1MCkgdGhpcy5sb2dzID0gdGhpcy5sb2dzLnNsaWNlKC01MClcbiAgICB9LFxuICAgIHNldFN0YXR1cyhzKSB7XG4gICAgICB0aGlzLnN0YXR1cyA9IHNcbiAgICB9LFxuICAgIHByb2JlKCkge1xuICAgICAgY29uc3Qgc2VsZiA9IHRoaXNcbiAgICAgIHNlbGYuc2V0U3RhdHVzKCfmjqLmtYvkuK3igKYnKVxuICAgICAgc2VsZi5hcHBlbmRMb2coJz09IOaOoua1iyBAc3lzdGVtLmJsdWV0b290aC5ibGUgPT0nKVxuICAgICAgdHJ5IHtcbiAgICAgICAgaWYgKExvY2tDbGllbnQuaXNCbGVTdXBwb3J0ZWQoKSkge1xuICAgICAgICAgIHNlbGYuc2V0U3RhdHVzKCfinIUg5pys6K6+5aSH5pSv5oyBIEpTIEJMRSBBUEnvvIjlj6/lsJ3or5XnnJ/mnLrlvIDplIHvvIknKVxuICAgICAgICAgIHNlbGYuYXBwZW5kTG9nKCdjcmVhdGVHYXR0Q2xpZW50RGV2aWNlIOaWueazleWtmOWcqCcpXG4gICAgICAgIH0gZWxzZSB7XG4gICAgICAgICAgc2VsZi5zZXRTdGF0dXMoJ+KdjCDmnKzorr7lpIfkuI3mlK/mjIEgSlMgQkxF77yIUzQv5r6O5rmDT1MzIOWkp+amgueOh+mcgOWOn+eUnyBD77yJJylcbiAgICAgICAgICBzZWxmLmFwcGVuZExvZygnY3JlYXRlR2F0dENsaWVudERldmljZSDkuI3lrZjlnKgnKVxuICAgICAgICB9XG4gICAgICB9IGNhdGNoIChlKSB7XG4gICAgICAgIHNlbGYuc2V0U3RhdHVzKCfinYwg5o6i5rWL5byC5bi4OiAnICsgKGUubWVzc2FnZSB8fCBlKSlcbiAgICAgICAgc2VsZi5hcHBlbmRMb2coJ0VSUiAnICsgKGUubWVzc2FnZSB8fCBlKSlcbiAgICAgIH1cbiAgICB9LFxuICAgIGFzeW5jIG9wZW5Mb2NrKCkge1xuICAgICAgY29uc3Qgc2VsZiA9IHRoaXNcbiAgICAgIHNlbGYuc2V0U3RhdHVzKCflvIDplIHkuK3igKYnKVxuICAgICAgc2VsZi5hcHBlbmRMb2coJz4+IG9wZW5Mb2NrJylcbiAgICAgIHRyeSB7XG4gICAgICAgIGNvbnN0IHIgPSBhd2FpdCBzZWxmLmNsaWVudC5vcGVuTG9jaygpXG4gICAgICAgIGlmIChyLnN1Y2Nlc3MpIHtcbiAgICAgICAgICBzZWxmLnNldFN0YXR1cygn4pyFIOW8gOmUgeaIkOWKnycgKyAoci5hdXRvTG9jayA/ICfvvIjlt7Lorr7kuLroh6rliqjlm57plIHvvIknIDogJycpKVxuICAgICAgICAgIHNlbGYuYXBwZW5kTG9nKCc8PCByZXN1bHRDb2RlPScgKyByLnJlc3VsdENvZGUpXG4gICAgICAgIH0gZWxzZSB7XG4gICAgICAgICAgc2VsZi5zZXRTdGF0dXMoJ+KaoO+4jyDlvIDplIHov5Tlm57lpLHotKUgcmVzdWx0Q29kZT0nICsgci5yZXN1bHRDb2RlKVxuICAgICAgICAgIHNlbGYuYXBwZW5kTG9nKCc8PCByZXN1bHRDb2RlPScgKyByLnJlc3VsdENvZGUpXG4gICAgICAgIH1cbiAgICAgIH0gY2F0Y2ggKGUpIHtcbiAgICAgICAgc2VsZi5zZXRTdGF0dXMoJ+KdjCDlvIDplIHlpLHotKU6ICcgKyAoZS5tZXNzYWdlIHx8IGUpKVxuICAgICAgICBzZWxmLmFwcGVuZExvZygnRVJSICcgKyAoZS5tZXNzYWdlIHx8IGUpKVxuICAgICAgfVxuICAgIH0sXG4gICAgYXN5bmMgY2xvc2VMb2NrKCkge1xuICAgICAgY29uc3Qgc2VsZiA9IHRoaXNcbiAgICAgIHNlbGYuc2V0U3RhdHVzKCflhbPplIHkuK3igKYnKVxuICAgICAgc2VsZi5hcHBlbmRMb2coJz4+IGNsb3NlTG9jaycpXG4gICAgICB0cnkge1xuICAgICAgICBjb25zdCByID0gYXdhaXQgc2VsZi5jbGllbnQuY2xvc2VMb2NrKClcbiAgICAgICAgc2VsZi5zZXRTdGF0dXMoJ+KchSDlhbPplIHmjIfku6Tlt7Llj5HpgIEnKVxuICAgICAgICBzZWxmLmFwcGVuZExvZygnPDwgcmVzdWx0Q29kZT0nICsgci5yZXN1bHRDb2RlKVxuICAgICAgfSBjYXRjaCAoZSkge1xuICAgICAgICBzZWxmLnNldFN0YXR1cygn4p2MIOWFs+mUgeWksei0pTogJyArIChlLm1lc3NhZ2UgfHwgZSkpXG4gICAgICAgIHNlbGYuYXBwZW5kTG9nKCdFUlIgJyArIChlLm1lc3NhZ2UgfHwgZSkpXG4gICAgICB9XG4gICAgfVxuICB9XG48L3NjcmlwdD5cbiJdLCJuYW1lcyI6WyJQIiwiX2ludGVyb3BSZXF1aXJlV2lsZGNhcmQiLCJyZXF1aXJlIiwiZSIsInQiLCJXZWFrTWFwIiwiciIsIm4iLCJfX2VzTW9kdWxlIiwibyIsImkiLCJmIiwiX19wcm90b19fIiwiZGVmYXVsdCIsImhhcyIsImdldCIsInNldCIsImhhc093blByb3BlcnR5IiwiY2FsbCIsIk9iamVjdCIsImRlZmluZVByb3BlcnR5IiwiZ2V0T3duUHJvcGVydHlEZXNjcmlwdG9yIiwiYmx1ZXRvb3RoQkxFIiwiZ2xvYmFsVGhpcyIsIlNFUlZJQ0VfVVVJRCIsIldSSVRFX1VVSUQiLCJOT1RJRllfVVVJRCIsIldSSVRFX0NIVU5LIiwiYnVmVG9CeXRlcyIsImJ1ZiIsIkFycmF5QnVmZmVyIiwiVWludDhBcnJheSIsImlzVmlldyIsImJ1ZmZlciIsImJ5dGVPZmZzZXQiLCJieXRlTGVuZ3RoIiwiQXJyYXkiLCJpc0FycmF5IiwiZnJvbSIsImJ5dGVzVG9BcnJheUJ1ZmZlciIsImJ5dGVzIiwiYWIiLCJsZW5ndGgiLCJ1IiwiTG9ja0NsaWVudCIsImNvbnN0cnVjdG9yIiwib3B0cyIsIm1hYyIsImRhdGFTZWNyZXQiLCJ1c2VyS2V5IiwiYXV0b0xvY2siLCJkZXZpY2UiLCJ3cml0ZUNoYXIiLCJub3RpZnlDaGFyIiwicmVjdkJ1ZiIsInBlbmRpbmciLCJjb25uZWN0ZWQiLCJsb2ciLCJfb25Ob3RpZnkiLCJkYXRhIiwidmFsIiwiY2hhcmFjdGVyaXN0aWNWYWx1ZSIsImNodW5rIiwiYnl0ZXNUb0hleCIsImNvbmNhdEJ5dGVzIiwicmVzIiwidHJ5UGFyc2VQYWNrZXQiLCJzbGljZSIsImNvbnN1bWVkIiwiX2Rpc3BhdGNoIiwidGx2cyIsIm1lc3NhZ2UiLCJwIiwibWF0Y2giLCJzcGxpY2UiLCJyZXNvbHZlIiwiX3dhaXRQYWNrZXQiLCJtYXRjaEZuIiwidGltZW91dE1zIiwic2VsZiIsIlByb21pc2UiLCJyZWplY3QiLCJ0aW1lciIsInNldFRpbWVvdXQiLCJpZHgiLCJmaW5kSW5kZXgiLCJFcnJvciIsInB1c2giLCJjbGVhclRpbWVvdXQiLCJpc0JsZVN1cHBvcnRlZCIsImNyZWF0ZUdhdHRDbGllbnREZXZpY2UiLCJjb25uZWN0IiwiZGV2Iiwib25CTEVDb25uZWN0aW9uU3RhdGVDaGFuZ2UiLCJzdGF0ZSIsIm9uQkxFQ2hhcmFjdGVyaXN0aWNDaGFuZ2UiLCJzdWNjZXNzIiwic3RhcnRlZCIsIkRhdGUiLCJub3ciLCJpdiIsInNldEludGVydmFsIiwiY2xlYXJJbnRlcnZhbCIsImZhaWwiLCJkIiwiY29kZSIsIl9nZXRTZXJ2aWNlcyIsImdldFNlcnZpY2VzIiwic2VydmljZXMiLCJzIiwiYyIsImNoYXJhY3RlcmlzdGljcyIsImNoYXJhY3RlcmlzdGljVXVpZCIsInRvTG93ZXJDYXNlIiwiX2VuYWJsZU5vdGlmeSIsInNldE5vdGlmeUNoYXJhY3RlcmlzdGljQ2hhbmdlZCIsImNoYXJhY3RlcmlzdGljIiwiZW5hYmxlIiwiX3dyaXRlIiwib2ZmIiwid3JpdGVOZXh0IiwiTWF0aCIsIm1pbiIsInNlcnZpY2VVdWlkIiwid3JpdGVDaGFyYWN0ZXJpc3RpY1ZhbHVlIiwib3BlbkxvY2siLCJncmMiLCJidWlsZEdldFJhbmdlQ29kZSIsInJhbmRXYWl0ZXIiLCJyMSIsInJhbmRTdHIiLCJvcCIsImJ1aWxkT3BlbkxvY2siLCJvcGVuV2FpdGVyIiwicjIiLCJyYyIsIm9rIiwiZGlzY29ubmVjdCIsInJlc3VsdENvZGUiLCJjbG9zZUxvY2siLCJjbCIsImJ1aWxkQ2xvc2VMb2NrIiwiY2xvc2VXYWl0ZXIiLCJjb21wbGV0ZSIsImV4cG9ydHMiLCJERUxUQSIsIlJPVU5EUyIsIkJMT0NLIiwicmVhZEludEJFIiwiYiIsIndyaXRlSW50QkUiLCJ2IiwiaGV4VG9CeXRlcyIsImhleCIsInJlcGxhY2UiLCJvdXQiLCJwYXJzZUludCIsInN1YnN0ciIsInRvU3RyaW5nIiwicGFkU3RhcnQiLCJ4b3JPZiIsIngiLCJwa2NzN1BhZCIsImJsb2NrIiwicmVtIiwicGFkIiwidGVhRW5jcnlwdCIsImtleSIsInBhZGRlZCIsImsiLCJ2MCIsInYxIiwic3VtIiwiazAiLCJrMSIsImsyIiwiazMiLCJ0ZWFEZWNyeXB0IiwicGFkTGVuIiwiYnVpbGRUbHYiLCJ0YWciLCJ2YWx1ZSIsInBhcnNlVGx2IiwicmVzdWx0IiwiYXJycyIsImxlbiIsImEiLCJidWlsZEZ1bGxDb21tYW5kIiwiY21kVHlwZSIsImNtZENvZGUiLCJ1bml0cyIsImNtZFZhbHVlIiwibWFwIiwiaW5uZXJUYWciLCJpbm5lclRsdiIsImlubmVyIiwiZW5jIiwidGx2MjkiLCJvdXRlclRsdiIsInZhbGlkIiwiZW5kIiwicGtnIiwicGF5bG9hZCIsImlubmVyVGx2cyIsIl9fd2VicGFja19yZXF1aXJlX18iLCJTeW1ib2wiLCJfYmxlIiwiTE9DS19NQUMiLCJEQVRBX1NFQ1JFVCIsIlVTRVJfS0VZIiwiX2RlZmF1bHQiLCJwcml2YXRlIiwic3RhdHVzIiwibG9ncyIsIm9uSW5pdCIsImNsaWVudCIsIm0iLCJhcHBlbmRMb2ciLCJsaW5lIiwiY29uY2F0Iiwic2V0U3RhdHVzIiwicHJvYmUiXSwibWFwcGluZ3MiOiI7Ozs7Ozs7Ozs7Ozs7Ozs7Ozt3QkFLQSxJQUFBQSxJQUFBQyx3QkFBQUMsUUFBQTt3QkFBa0MsU0FBQUQsd0JBQUFFLENBQUEsRUFBQUMsQ0FBQTs0QkFBQSx5QkFBQUMsU0FBQSxJQUFBQyxJQUFBLElBQUFELFdBQUFFLElBQUEsSUFBQUY7NEJBQUEsT0FBQUosQ0FBQUEsMEJBQUEsU0FBQUUsQ0FBQSxFQUFBQyxDQUFBO2dDQUFBLEtBQUFBLEtBQUFELEtBQUFBLEVBQUFLLFVBQUEsU0FBQUw7Z0NBQUEsSUFBQU0sR0FBQUMsR0FBQUMsSUFBQTtvQ0FBQUMsV0FBQTtvQ0FBQUMsU0FBQVY7Z0NBQUE7Z0NBQUEsYUFBQUEsS0FBQSxtQkFBQUEsS0FBQSxxQkFBQUEsR0FBQSxPQUFBUTtnQ0FBQSxJQUFBRixJQUFBTCxJQUFBRyxJQUFBRCxHQUFBO29DQUFBLElBQUFHLEVBQUFLLEdBQUEsQ0FBQVgsSUFBQSxPQUFBTSxFQUFBTSxHQUFBLENBQUFaO29DQUFBTSxFQUFBTyxHQUFBLENBQUFiLEdBQUFRO2dDQUFBO2dDQUFBLFVBQUFQLEtBQUFELEVBQUEsY0FBQUMsS0FBQSxLQUFBYSxjQUFBLENBQUFDLElBQUEsQ0FBQWYsR0FBQUMsTUFBQSxDQUFBTSxDQUFBQSxJQUFBLEFBQUFELENBQUFBLElBQUFVLE9BQUFDLGNBQUEsQUFBQUEsS0FBQUQsT0FB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