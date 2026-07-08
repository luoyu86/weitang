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
                var __webpack_modules__ = {};
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
                    __webpack_require__.rv = ()=>"1.7.12";
                })();
                (()=>{
                    __webpack_require__.ruid = "bundler=rspack@1.7.12";
                })();
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
                var $app_script$ = function __scriptModule__(module, exports, $app_require$1) {
                    "use strict";
                    Object.defineProperty(exports, "__esModule", {
                        value: true
                    });
                    exports.default = void 0;
                    var DELTA = 2654435769;
                    var ROUNDS = 16;
                    var BLOCK = 8;
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
                        var s = hex.replace(/\s/g, '');
                        var out = new Uint8Array(s.length / 2);
                        for(var i = 0; i < out.length; i++)out[i] = parseInt(s.substr(2 * i, 2), 16);
                        return out;
                    }
                    function bytesToHex(bytes) {
                        var s = '';
                        for(var i = 0; i < bytes.length; i++)s += (0xff & bytes[i]).toString(16).padStart(2, '0');
                        return s;
                    }
                    function xorOf(data) {
                        var x = 0;
                        for(var i = 0; i < data.length; i++)x ^= 0xff & data[i];
                        return 0xff & x;
                    }
                    function pkcs7Pad(data, block) {
                        var rem = data.length % block;
                        var pad = 0 === rem ? block : block - rem;
                        var out = new Uint8Array(data.length + pad);
                        out.set(data, 0);
                        for(var i = data.length; i < out.length; i++)out[i] = pad;
                        return out;
                    }
                    function teaEncrypt(data, key) {
                        var padded = pkcs7Pad(data, BLOCK);
                        var out = new Uint8Array(padded.length);
                        var k = [
                            readIntBE(key, 0),
                            readIntBE(key, 4),
                            readIntBE(key, 8),
                            readIntBE(key, 12)
                        ];
                        var off = 0;
                        while(off + BLOCK <= padded.length){
                            var v0 = readIntBE(padded, off) >>> 0;
                            var v1 = readIntBE(padded, off + 4) >>> 0;
                            var sum = 0;
                            for(var i = 0; i < ROUNDS; i++){
                                sum = sum + DELTA >>> 0;
                                var k0 = k[0] >>> 0, k1 = k[1] >>> 0, k2 = k[2] >>> 0, k3 = k[3] >>> 0;
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
                        var out = new Uint8Array(data.length);
                        var k = [
                            readIntBE(key, 0),
                            readIntBE(key, 4),
                            readIntBE(key, 8),
                            readIntBE(key, 12)
                        ];
                        var off = 0;
                        while(off + BLOCK <= data.length){
                            var v0 = readIntBE(data, off) >>> 0;
                            var v1 = readIntBE(data, off + 4) >>> 0;
                            var sum = DELTA * ROUNDS >>> 0;
                            for(var i = 0; i < ROUNDS; i++){
                                var k0 = k[0] >>> 0, k1 = k[1] >>> 0, k2 = k[2] >>> 0, k3 = k[3] >>> 0;
                                v1 = v1 - ((v0 << 4 >>> 0) + k2 ^ v0 + sum ^ (v0 >>> 5) + k3) >>> 0;
                                v0 = v0 - ((v1 << 4 >>> 0) + k0 ^ v1 + sum ^ (v1 >>> 5) + k1) >>> 0;
                                sum = sum - DELTA >>> 0;
                            }
                            writeIntBE(out, off, v0);
                            writeIntBE(out, off + 4, v1);
                            off += BLOCK;
                        }
                        var padLen = 0xff & out[out.length - 1];
                        if (padLen >= 1 && padLen <= BLOCK) return out.slice(0, out.length - padLen);
                        return out;
                    }
                    function buildTlv(tag, value) {
                        var out = new Uint8Array(4 + value.length);
                        out[0] = tag >>> 8 & 0xff;
                        out[1] = 0xff & tag;
                        out[2] = value.length >>> 8 & 0xff;
                        out[3] = 0xff & value.length;
                        out.set(value, 4);
                        return out;
                    }
                    function parseTlv(data) {
                        var result = {};
                        var i = 0;
                        while(i + 4 <= data.length){
                            var tag = (0xff & data[i]) << 8 | 0xff & data[i + 1];
                            var length = (0xff & data[i + 2]) << 8 | 0xff & data[i + 3];
                            if (i + 4 + length > data.length) break;
                            result[tag] = data.slice(i + 4, i + 4 + length);
                            i += 4 + length;
                        }
                        return result;
                    }
                    function concatBytes() {
                        var arrs = Array.prototype.slice.call(arguments);
                        var len = 0;
                        for(var a = 0; a < arrs.length; a++)len += arrs[a].length;
                        var out = new Uint8Array(len);
                        var off = 0;
                        for(var b = 0; b < arrs.length; b++){
                            out.set(arrs[b], off);
                            off += arrs[b].length;
                        }
                        return out;
                    }
                    function buildFullCommand(cmdType, cmdCode, units, key) {
                        var cmdValue = concatBytes.apply(null, units.map(function(p) {
                            return buildTlv(p[0], p[1]);
                        }));
                        var innerTag = (cmdType << 8 | cmdCode) >>> 0;
                        var innerTlv = buildTlv(innerTag, cmdValue);
                        var inner = concatBytes(innerTlv, Uint8Array.from([
                            xorOf(innerTlv)
                        ]));
                        var enc = teaEncrypt(inner, key);
                        var tlv29 = buildTlv(29, enc);
                        var outerTlv = buildTlv(0x6a01, tlv29);
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
                        var a = Uint8Array.from([
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
                        var i = 0;
                        while(i + 5 <= buffer.length){
                            var tag = (0xff & buffer[i]) << 8 | 0xff & buffer[i + 1];
                            var valid = 0x6a01 === tag || 0x6a02 === tag || 0x6a03 === tag || 0x6a04 === tag || 0x1f02 === tag;
                            if (!valid) {
                                i++;
                                continue;
                            }
                            var length = (0xff & buffer[i + 2]) << 8 | 0xff & buffer[i + 3];
                            var end = i + 4 + length + 1;
                            if (buffer.length < end) return null;
                            var pkg = buffer.slice(i, end);
                            var x = xorOf(pkg.slice(0, pkg.length - 1));
                            if (x !== pkg[pkg.length - 1]) {
                                i++;
                                continue;
                            }
                            var payload = buffer.slice(i + 4, i + 4 + length);
                            var units = parseTlv(payload);
                            if (units[29]) {
                                var inner = teaDecrypt(units[29], key);
                                if (inner.length >= 5 && xorOf(inner.slice(0, inner.length - 1)) === inner[inner.length - 1]) {
                                    var innerTlvs = parseTlv(inner.slice(4, inner.length - 1));
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
                    var P = {
                        hexToBytes: hexToBytes,
                        bytesToHex: bytesToHex,
                        xorOf: xorOf,
                        teaEncrypt: teaEncrypt,
                        teaDecrypt: teaDecrypt,
                        buildTlv: buildTlv,
                        parseTlv: parseTlv,
                        concatBytes: concatBytes,
                        buildFullCommand: buildFullCommand,
                        buildGetRangeCode: buildGetRangeCode,
                        buildOpenLock: buildOpenLock,
                        buildCloseLock: buildCloseLock,
                        tryParsePacket: tryParsePacket
                    };
                    function getBleModule() {
                        try {
                            if (true) {
                                var m = $app_require$1("@app-module/system.bluetooth.ble");
                                if (m) return m;
                            }
                        } catch (e) {}
                        try {
                            if (void 0 !== globalThis) return globalThis['@system.bluetooth.ble'] || null;
                        } catch (e) {}
                        return null;
                    }
                    var SERVICE_UUID = '000018f0-0000-1000-8000-00805f9b34fb';
                    var WRITE_UUID = '00002af1-0000-1000-8000-00805f9b34fb';
                    var NOTIFY_UUID = '00002af0-0000-1000-8000-00805f9b34fb';
                    var WRITE_CHUNK = 20;
                    function bufToBytes(buf) {
                        if (buf instanceof ArrayBuffer) return new Uint8Array(buf);
                        if ("u" > typeof ArrayBuffer && ArrayBuffer.isView(buf)) return new Uint8Array(buf.buffer, buf.byteOffset, buf.byteLength);
                        if (Array.isArray(buf)) return Uint8Array.from(buf);
                        return new Uint8Array(0);
                    }
                    function bytesToArrayBuffer(bytes) {
                        var ab = new ArrayBuffer(bytes.length);
                        var u = new Uint8Array(ab);
                        u.set(bytes);
                        return ab;
                    }
                    function LockClient(opts) {
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
                    LockClient.prototype._onNotify = function(data) {
                        try {
                            var val = data && data.characteristicValue;
                            if (!val) return;
                            var chunk = bufToBytes(val);
                            if (0 === chunk.length) return;
                            this.log('RECV ' + P.bytesToHex(chunk));
                            this.recvBuf = P.concatBytes(this.recvBuf, chunk);
                            while(true){
                                var res = P.tryParsePacket(this.recvBuf, this.dataSecret);
                                if (!res) break;
                                this.recvBuf = this.recvBuf.slice(res.consumed);
                                this._dispatch(res.tlvs);
                            }
                        } catch (e) {
                            this.log('onNotify error: ' + (e && e.message ? e.message : e));
                        }
                    };
                    LockClient.prototype._dispatch = function(tlvs) {
                        for(var i = 0; i < this.pending.length; i++){
                            var p = this.pending[i];
                            if (p.match(tlvs)) {
                                this.pending.splice(i, 1);
                                p.resolve(tlvs);
                                return;
                            }
                        }
                    };
                    LockClient.prototype._waitPacket = function(matchFn, timeoutMs) {
                        var self = this;
                        return new Promise(function(resolve, reject) {
                            var timer = setTimeout(function() {
                                var idx = self.pending.findIndex(function(p) {
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
                    };
                    LockClient.isBleSupported = function() {
                        var ble = getBleModule();
                        return !!(ble && 'function' == typeof ble.createGattClientDevice);
                    };
                    LockClient.prototype.connect = function() {
                        var self = this;
                        return new Promise(function(resolve, reject) {
                            var ble = getBleModule();
                            if (!ble || 'function' != typeof ble.createGattClientDevice) return void reject(new Error('@system.bluetooth.ble 不可用：本设备(可能 S4/澎湃OS3)未开放 JS 蓝牙，需改用 Vela 原生 C 开发'));
                            var dev;
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
                                    var started = Date.now();
                                    var iv = setInterval(function() {
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
                    };
                    LockClient.prototype._getServices = function() {
                        var self = this;
                        return new Promise(function(resolve, reject) {
                            self.device.getServices({
                                success: function(services) {
                                    var writeChar = null, notifyChar = null;
                                    for(var s = 0; s < (services || []).length; s++){
                                        var chars = services[s].characteristics || [];
                                        for(var c = 0; c < chars.length; c++){
                                            var u = (chars[c].characteristicUuid || '').toLowerCase();
                                            if (u === WRITE_UUID.toLowerCase()) writeChar = chars[c];
                                            if (u === NOTIFY_UUID.toLowerCase()) notifyChar = chars[c];
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
                    };
                    LockClient.prototype._enableNotify = function() {
                        var self = this;
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
                    };
                    LockClient.prototype._write = function(bytes) {
                        var self = this;
                        return new Promise(function(resolve, reject) {
                            var off = 0;
                            function writeNext() {
                                if (off >= bytes.length) return void resolve();
                                var n = Math.min(WRITE_CHUNK, bytes.length - off);
                                var chunk = bytes.slice(off, off + n);
                                off += n;
                                var characteristic = {
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
                    };
                    LockClient.prototype.openLock = function() {
                        var self = this;
                        return self.connect().then(function() {
                            return self._getServices();
                        }).then(function() {
                            return self._enableNotify();
                        }).then(function() {
                            var grc = P.buildGetRangeCode(self.dataSecret);
                            var randWaiter = self._waitPacket(function(tlvs) {
                                return !!tlvs[100];
                            }, 8000);
                            return self._write(grc).then(function() {
                                return randWaiter;
                            });
                        }).then(function(r1) {
                            var randStr = r1[100];
                            var op = P.buildOpenLock(self.userKey, randStr, self.autoLock, self.dataSecret);
                            var openWaiter = self._waitPacket(function(tlvs) {
                                return !!tlvs[1];
                            }, 8000);
                            return self._write(op).then(function() {
                                return openWaiter;
                            });
                        }).then(function(r2) {
                            var rc = r2[1];
                            var ok = !!rc && rc.length >= 2 && 0 === rc[0] && 0 === rc[1];
                            return self.disconnect().then(function() {
                                return {
                                    success: ok,
                                    resultCode: P.bytesToHex(rc || new Uint8Array(0)),
                                    autoLock: self.autoLock
                                };
                            });
                        });
                    };
                    LockClient.prototype.closeLock = function() {
                        var self = this;
                        return self.connect().then(function() {
                            return self._getServices();
                        }).then(function() {
                            return self._enableNotify();
                        }).then(function() {
                            var grc = P.buildGetRangeCode(self.dataSecret);
                            var randWaiter = self._waitPacket(function(tlvs) {
                                return !!tlvs[100];
                            }, 8000);
                            return self._write(grc).then(function() {
                                return randWaiter;
                            });
                        }).then(function(r1) {
                            var randStr = r1[100];
                            var cl = P.buildCloseLock(randStr, self.dataSecret);
                            var closeWaiter = self._waitPacket(function(tlvs) {
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
                    };
                    LockClient.prototype.disconnect = function() {
                        var self = this;
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
                    };
                    var LOCK_MAC = '1E:98:6C:02:A7:77';
                    var DATA_SECRET = P.hexToBytes('DBCCB54D6E2E655958FF9E29CBF8A764');
                    var USER_KEY = P.hexToBytes('0F80D3A7AF16E51B5BAA1A829A144B04C9878901EB6377ACB525214E3820E0D2');
                    var _default = exports.default = {
                        private: {
                            mac: LOCK_MAC,
                            status: '点击「探测 BLE」检查本设备是否支持',
                            logs: []
                        },
                        onInit () {
                            this.client = new LockClient({
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
                            var self = this;
                            self.setStatus('探测中…');
                            self.appendLog('== 探测 @system.bluetooth.ble ==');
                            try {
                                if (LockClient.isBleSupported()) {
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
                            var self = this;
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
                            var self = this;
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
                    const moduleOwn = exports.default || module.exports;
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
        };
        return createPageHandler();
    })(global, globalThis, window, $app_exports$, $app_evaluate$);
}
