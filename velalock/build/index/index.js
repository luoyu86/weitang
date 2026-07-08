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

//# sourceMappingURL=data:application/json;charset=utf-8;base64,eyJ2ZXJzaW9uIjozLCJmaWxlIjoiaW5kZXgvaW5kZXguanMiLCJzb3VyY2VzIjpbIndlYnBhY2s6Ly93ZWl0YW5nLXZlbGEtbG9jay93ZWJwYWNrL3J1bnRpbWUvcnNwYWNrX3ZlcnNpb24iLCJ3ZWJwYWNrOi8vd2VpdGFuZy12ZWxhLWxvY2svd2VicGFjay9ydW50aW1lL3JzcGFja191bmlxdWVfaWQiLCJ3ZWJwYWNrOi8vd2VpdGFuZy12ZWxhLWxvY2svc3JjL2luZGV4L2luZGV4LnV4Il0sInNvdXJjZXNDb250ZW50IjpbIl9fd2VicGFja19yZXF1aXJlX18ucnYgPSAoKSA9PiAoXCIxLjcuMTJcIikiLCJfX3dlYnBhY2tfcmVxdWlyZV9fLnJ1aWQgPSBcImJ1bmRsZXI9cnNwYWNrQDEuNy4xMlwiOyIsIjx0ZW1wbGF0ZT5cbiAgPGRpdiBjbGFzcz1cInBhZ2VcIj5cbiAgICA8dGV4dCBjbGFzcz1cInRpdGxlXCI+5b6u5qOg6Zeo6ZSBPC90ZXh0PlxuICAgIDx0ZXh0IGNsYXNzPVwic3VidGl0bGVcIj5NQUMge3sgbWFjIH19PC90ZXh0PlxuXG4gICAgPGlucHV0IGNsYXNzPVwiYnRuIGJ0bi1wcm9iZVwiIHR5cGU9XCJidXR0b25cIiB2YWx1ZT1cIuaOoua1iyBCTEVcIiBvbmNsaWNrPVwicHJvYmVcIiAvPlxuICAgIDxpbnB1dCBjbGFzcz1cImJ0biBidG4tb3BlblwiIHR5cGU9XCJidXR0b25cIiB2YWx1ZT1cIuW8gOmUgVwiIG9uY2xpY2s9XCJvcGVuTG9ja1wiIC8+XG4gICAgPGlucHV0IGNsYXNzPVwiYnRuIGJ0bi1jbG9zZVwiIHR5cGU9XCJidXR0b25cIiB2YWx1ZT1cIuWFs+mUgVwiIG9uY2xpY2s9XCJjbG9zZUxvY2tcIiAvPlxuXG4gICAgPHRleHQgY2xhc3M9XCJzdGF0dXNcIj57eyBzdGF0dXMgfX08L3RleHQ+XG4gICAgPGxpc3QgY2xhc3M9XCJsb2dcIj5cbiAgICAgIDxibG9jayBmb3I9XCIoaSwgbGluZSkgaW4gbG9nc1wiPlxuICAgICAgICA8dGV4dCBjbGFzcz1cImxvZ2xpbmVcIj57eyBsaW5lIH19PC90ZXh0PlxuICAgICAgPC9ibG9jaz5cbiAgICA8L2xpc3Q+XG4gIDwvZGl2PlxuPC90ZW1wbGF0ZT5cblxuPHN0eWxlPlxuICAucGFnZSB7XG4gICAgZmxleC1kaXJlY3Rpb246IGNvbHVtbjtcbiAgICBhbGlnbi1pdGVtczogY2VudGVyO1xuICAgIHBhZGRpbmc6IDI0cHg7XG4gICAgYmFja2dyb3VuZC1jb2xvcjogIzBiMGIwYjtcbiAgfVxuICAudGl0bGUge1xuICAgIGZvbnQtc2l6ZTogNDBweDtcbiAgICBjb2xvcjogI2ZmZmZmZjtcbiAgICBtYXJnaW4tdG9wOiAxMnB4O1xuICAgIGZvbnQtd2VpZ2h0OiBib2xkO1xuICB9XG4gIC5zdWJ0aXRsZSB7XG4gICAgZm9udC1zaXplOiAyMnB4O1xuICAgIGNvbG9yOiAjOGE4YThhO1xuICAgIG1hcmdpbi10b3A6IDZweDtcbiAgICBtYXJnaW4tYm90dG9tOiAyNHB4O1xuICB9XG4gIC5idG4ge1xuICAgIHdpZHRoOiAzNjBweDtcbiAgICBoZWlnaHQ6IDg4cHg7XG4gICAgYm9yZGVyLXJhZGl1czogNDRweDtcbiAgICBjb2xvcjogI2ZmZmZmZjtcbiAgICBmb250LXNpemU6IDMycHg7XG4gICAgbWFyZ2luLWJvdHRvbTogMThweDtcbiAgICB0ZXh0LWFsaWduOiBjZW50ZXI7XG4gIH1cbiAgLmJ0bi1wcm9iZSB7IGJhY2tncm91bmQtY29sb3I6ICM1NTU1NTU7IH1cbiAgLmJ0bi1vcGVuIHsgYmFja2dyb3VuZC1jb2xvcjogIzBhODRmZjsgfVxuICAuYnRuLWNsb3NlIHsgYmFja2dyb3VuZC1jb2xvcjogI2ZmOWYwYTsgfVxuICAuc3RhdHVzIHtcbiAgICBmb250LXNpemU6IDI2cHg7XG4gICAgY29sb3I6ICNmZmQ2MGE7XG4gICAgbWFyZ2luOiAxMnB4IDA7XG4gICAgdGV4dC1hbGlnbjogY2VudGVyO1xuICB9XG4gIC5sb2cge1xuICAgIHdpZHRoOiA0MjBweDtcbiAgICBoZWlnaHQ6IDI4MHB4O1xuICAgIG1hcmdpbi10b3A6IDhweDtcbiAgICBib3JkZXItY29sb3I6ICMzMzMzMzM7XG4gICAgYm9yZGVyLXdpZHRoOiAxcHg7XG4gICAgcGFkZGluZzogOHB4O1xuICB9XG4gIC5sb2dsaW5lIHtcbiAgICBmb250LXNpemU6IDE4cHg7XG4gICAgY29sb3I6ICM2YWQzNmE7XG4gICAgbGluZS1oZWlnaHQ6IDI2cHg7XG4gIH1cbjwvc3R5bGU+XG5cbjxzY3JpcHQ+XG4gIC8vID09PT09PT09PT09PT09PT09PT09PT09PT09PT09PT09PT09PT09PT09PT09PT09PT09PT09PT09PT09PVxuICAvLyDljY/orq7lsYIgKOS4jiB1bmxvY2tfdjIucHkg5a2X6IqC57qn5LiA6Ie0LCBURUEgYmlnLWVuZGlhbiAvIFRMViAvIFhPUilcbiAgLy8g5YaF6IGU5Yiw5q2kIC51eCDohJrmnKzvvJrpgb/lhY3ljZXni6wgLmpzIOaooeWdl+iiqyByc3BhY2sg6ZSZ6K+v5Zyw55SoXG4gIC8vIGBleHBvcnRzLnh4eGAg5LqS5pON5L2c77yI6K+l5Y+C5pWw5Zyo5pys5bel5YW36ZO+5LiN5a2Y5ZyoIOKGkiDnmb3lsY/vvInjgIJcbiAgLy8gPT09PT09PT09PT09PT09PT09PT09PT09PT09PT09PT09PT09PT09PT09PT09PT09PT09PT09PT09PT09XG4gIHZhciBERUxUQSA9IDB4OWUzNzc5YjkgPj4+IDA7XG4gIHZhciBST1VORFMgPSAxNjtcbiAgdmFyIEJMT0NLID0gODtcblxuICBmdW5jdGlvbiByZWFkSW50QkUoYiwgb2ZmKSB7XG4gICAgcmV0dXJuIChcbiAgICAgICgoYltvZmZdICYgMHhmZikgPDwgMjQpIHxcbiAgICAgICgoYltvZmYgKyAxXSAmIDB4ZmYpIDw8IDE2KSB8XG4gICAgICAoKGJbb2ZmICsgMl0gJiAweGZmKSA8PCA4KSB8XG4gICAgICAoYltvZmYgKyAzXSAmIDB4ZmYpXG4gICAgKSA+Pj4gMDtcbiAgfVxuXG4gIGZ1bmN0aW9uIHdyaXRlSW50QkUoYiwgb2ZmLCB2KSB7XG4gICAgYltvZmZdID0gKHYgPj4+IDI0KSAmIDB4ZmY7XG4gICAgYltvZmYgKyAxXSA9ICh2ID4+PiAxNikgJiAweGZmO1xuICAgIGJbb2ZmICsgMl0gPSAodiA+Pj4gOCkgJiAweGZmO1xuICAgIGJbb2ZmICsgM10gPSB2ICYgMHhmZjtcbiAgfVxuXG4gIGZ1bmN0aW9uIGhleFRvQnl0ZXMoaGV4KSB7XG4gICAgdmFyIHMgPSBoZXgucmVwbGFjZSgvXFxzL2csICcnKTtcbiAgICB2YXIgb3V0ID0gbmV3IFVpbnQ4QXJyYXkocy5sZW5ndGggLyAyKTtcbiAgICBmb3IgKHZhciBpID0gMDsgaSA8IG91dC5sZW5ndGg7IGkrKykge1xuICAgICAgb3V0W2ldID0gcGFyc2VJbnQocy5zdWJzdHIoaSAqIDIsIDIpLCAxNik7XG4gICAgfVxuICAgIHJldHVybiBvdXQ7XG4gIH1cblxuICBmdW5jdGlvbiBieXRlc1RvSGV4KGJ5dGVzKSB7XG4gICAgdmFyIHMgPSAnJztcbiAgICBmb3IgKHZhciBpID0gMDsgaSA8IGJ5dGVzLmxlbmd0aDsgaSsrKSBzICs9IChieXRlc1tpXSAmIDB4ZmYpLnRvU3RyaW5nKDE2KS5wYWRTdGFydCgyLCAnMCcpO1xuICAgIHJldHVybiBzO1xuICB9XG5cbiAgZnVuY3Rpb24geG9yT2YoZGF0YSkge1xuICAgIHZhciB4ID0gMDtcbiAgICBmb3IgKHZhciBpID0gMDsgaSA8IGRhdGEubGVuZ3RoOyBpKyspIHggXj0gZGF0YVtpXSAmIDB4ZmY7XG4gICAgcmV0dXJuIHggJiAweGZmO1xuICB9XG5cbiAgZnVuY3Rpb24gcGtjczdQYWQoZGF0YSwgYmxvY2spIHtcbiAgICB2YXIgcmVtID0gZGF0YS5sZW5ndGggJSBibG9jaztcbiAgICB2YXIgcGFkID0gcmVtID09PSAwID8gYmxvY2sgOiBibG9jayAtIHJlbTtcbiAgICB2YXIgb3V0ID0gbmV3IFVpbnQ4QXJyYXkoZGF0YS5sZW5ndGggKyBwYWQpO1xuICAgIG91dC5zZXQoZGF0YSwgMCk7XG4gICAgZm9yICh2YXIgaSA9IGRhdGEubGVuZ3RoOyBpIDwgb3V0Lmxlbmd0aDsgaSsrKSBvdXRbaV0gPSBwYWQ7XG4gICAgcmV0dXJuIG91dDtcbiAgfVxuXG4gIGZ1bmN0aW9uIHRlYUVuY3J5cHQoZGF0YSwga2V5KSB7XG4gICAgdmFyIHBhZGRlZCA9IHBrY3M3UGFkKGRhdGEsIEJMT0NLKTtcbiAgICB2YXIgb3V0ID0gbmV3IFVpbnQ4QXJyYXkocGFkZGVkLmxlbmd0aCk7XG4gICAgdmFyIGsgPSBbcmVhZEludEJFKGtleSwgMCksIHJlYWRJbnRCRShrZXksIDQpLCByZWFkSW50QkUoa2V5LCA4KSwgcmVhZEludEJFKGtleSwgMTIpXTtcbiAgICB2YXIgb2ZmID0gMDtcbiAgICB3aGlsZSAob2ZmICsgQkxPQ0sgPD0gcGFkZGVkLmxlbmd0aCkge1xuICAgICAgdmFyIHYwID0gcmVhZEludEJFKHBhZGRlZCwgb2ZmKSA+Pj4gMDtcbiAgICAgIHZhciB2MSA9IHJlYWRJbnRCRShwYWRkZWQsIG9mZiArIDQpID4+PiAwO1xuICAgICAgdmFyIHN1bSA9IDA7XG4gICAgICBmb3IgKHZhciBpID0gMDsgaSA8IFJPVU5EUzsgaSsrKSB7XG4gICAgICAgIHN1bSA9IChzdW0gKyBERUxUQSkgPj4+IDA7XG4gICAgICAgIHZhciBrMCA9IGtbMF0gPj4+IDAsIGsxID0ga1sxXSA+Pj4gMCwgazIgPSBrWzJdID4+PiAwLCBrMyA9IGtbM10gPj4+IDA7XG4gICAgICAgIHYwID0gKHYwICsgKCgoKHYxIDw8IDQpID4+PiAwKSArIGswKSBeICh2MSArIHN1bSkgXiAoKHYxID4+PiA1KSArIGsxKSkpID4+PiAwO1xuICAgICAgICB2MSA9ICh2MSArICgoKCh2MCA8PCA0KSA+Pj4gMCkgKyBrMikgXiAodjAgKyBzdW0pIF4gKCh2MCA+Pj4gNSkgKyBrMykpKSA+Pj4gMDtcbiAgICAgIH1cbiAgICAgIHdyaXRlSW50QkUob3V0LCBvZmYsIHYwKTtcbiAgICAgIHdyaXRlSW50QkUob3V0LCBvZmYgKyA0LCB2MSk7XG4gICAgICBvZmYgKz0gQkxPQ0s7XG4gICAgfVxuICAgIHJldHVybiBvdXQ7XG4gIH1cblxuICBmdW5jdGlvbiB0ZWFEZWNyeXB0KGRhdGEsIGtleSkge1xuICAgIHZhciBvdXQgPSBuZXcgVWludDhBcnJheShkYXRhLmxlbmd0aCk7XG4gICAgdmFyIGsgPSBbcmVhZEludEJFKGtleSwgMCksIHJlYWRJbnRCRShrZXksIDQpLCByZWFkSW50QkUoa2V5LCA4KSwgcmVhZEludEJFKGtleSwgMTIpXTtcbiAgICB2YXIgb2ZmID0gMDtcbiAgICB3aGlsZSAob2ZmICsgQkxPQ0sgPD0gZGF0YS5sZW5ndGgpIHtcbiAgICAgIHZhciB2MCA9IHJlYWRJbnRCRShkYXRhLCBvZmYpID4+PiAwO1xuICAgICAgdmFyIHYxID0gcmVhZEludEJFKGRhdGEsIG9mZiArIDQpID4+PiAwO1xuICAgICAgdmFyIHN1bSA9IChERUxUQSAqIFJPVU5EUykgPj4+IDA7XG4gICAgICBmb3IgKHZhciBpID0gMDsgaSA8IFJPVU5EUzsgaSsrKSB7XG4gICAgICAgIHZhciBrMCA9IGtbMF0gPj4+IDAsIGsxID0ga1sxXSA+Pj4gMCwgazIgPSBrWzJdID4+PiAwLCBrMyA9IGtbM10gPj4+IDA7XG4gICAgICAgIHYxID0gKHYxIC0gKCgoKHYwIDw8IDQpID4+PiAwKSArIGsyKSBeICh2MCArIHN1bSkgXiAoKHYwID4+PiA1KSArIGszKSkpID4+PiAwO1xuICAgICAgICB2MCA9ICh2MCAtICgoKCh2MSA8PCA0KSA+Pj4gMCkgKyBrMCkgXiAodjEgKyBzdW0pIF4gKCh2MSA+Pj4gNSkgKyBrMSkpKSA+Pj4gMDtcbiAgICAgICAgc3VtID0gKHN1bSAtIERFTFRBKSA+Pj4gMDtcbiAgICAgIH1cbiAgICAgIHdyaXRlSW50QkUob3V0LCBvZmYsIHYwKTtcbiAgICAgIHdyaXRlSW50QkUob3V0LCBvZmYgKyA0LCB2MSk7XG4gICAgICBvZmYgKz0gQkxPQ0s7XG4gICAgfVxuICAgIHZhciBwYWRMZW4gPSBvdXRbb3V0Lmxlbmd0aCAtIDFdICYgMHhmZjtcbiAgICBpZiAocGFkTGVuID49IDEgJiYgcGFkTGVuIDw9IEJMT0NLKSB7XG4gICAgICByZXR1cm4gb3V0LnNsaWNlKDAsIG91dC5sZW5ndGggLSBwYWRMZW4pO1xuICAgIH1cbiAgICByZXR1cm4gb3V0O1xuICB9XG5cbiAgZnVuY3Rpb24gYnVpbGRUbHYodGFnLCB2YWx1ZSkge1xuICAgIHZhciBvdXQgPSBuZXcgVWludDhBcnJheSg0ICsgdmFsdWUubGVuZ3RoKTtcbiAgICBvdXRbMF0gPSAodGFnID4+PiA4KSAmIDB4ZmY7XG4gICAgb3V0WzFdID0gdGFnICYgMHhmZjtcbiAgICBvdXRbMl0gPSAodmFsdWUubGVuZ3RoID4+PiA4KSAmIDB4ZmY7XG4gICAgb3V0WzNdID0gdmFsdWUubGVuZ3RoICYgMHhmZjtcbiAgICBvdXQuc2V0KHZhbHVlLCA0KTtcbiAgICByZXR1cm4gb3V0O1xuICB9XG5cbiAgZnVuY3Rpb24gcGFyc2VUbHYoZGF0YSkge1xuICAgIHZhciByZXN1bHQgPSB7fTtcbiAgICB2YXIgaSA9IDA7XG4gICAgd2hpbGUgKGkgKyA0IDw9IGRhdGEubGVuZ3RoKSB7XG4gICAgICB2YXIgdGFnID0gKChkYXRhW2ldICYgMHhmZikgPDwgOCkgfCAoZGF0YVtpICsgMV0gJiAweGZmKTtcbiAgICAgIHZhciBsZW5ndGggPSAoKGRhdGFbaSArIDJdICYgMHhmZikgPDwgOCkgfCAoZGF0YVtpICsgM10gJiAweGZmKTtcbiAgICAgIGlmIChpICsgNCArIGxlbmd0aCA+IGRhdGEubGVuZ3RoKSBicmVhaztcbiAgICAgIHJlc3VsdFt0YWddID0gZGF0YS5zbGljZShpICsgNCwgaSArIDQgKyBsZW5ndGgpO1xuICAgICAgaSArPSA0ICsgbGVuZ3RoO1xuICAgIH1cbiAgICByZXR1cm4gcmVzdWx0O1xuICB9XG5cbiAgZnVuY3Rpb24gY29uY2F0Qnl0ZXMoKSB7XG4gICAgdmFyIGFycnMgPSBBcnJheS5wcm90b3R5cGUuc2xpY2UuY2FsbChhcmd1bWVudHMpO1xuICAgIHZhciBsZW4gPSAwO1xuICAgIGZvciAodmFyIGEgPSAwOyBhIDwgYXJycy5sZW5ndGg7IGErKykgbGVuICs9IGFycnNbYV0ubGVuZ3RoO1xuICAgIHZhciBvdXQgPSBuZXcgVWludDhBcnJheShsZW4pO1xuICAgIHZhciBvZmYgPSAwO1xuICAgIGZvciAodmFyIGIgPSAwOyBiIDwgYXJycy5sZW5ndGg7IGIrKykge1xuICAgICAgb3V0LnNldChhcnJzW2JdLCBvZmYpO1xuICAgICAgb2ZmICs9IGFycnNbYl0ubGVuZ3RoO1xuICAgIH1cbiAgICByZXR1cm4gb3V0O1xuICB9XG5cbiAgZnVuY3Rpb24gYnVpbGRGdWxsQ29tbWFuZChjbWRUeXBlLCBjbWRDb2RlLCB1bml0cywga2V5KSB7XG4gICAgdmFyIGNtZFZhbHVlID0gY29uY2F0Qnl0ZXMuYXBwbHkobnVsbCwgdW5pdHMubWFwKGZ1bmN0aW9uIChwKSB7IHJldHVybiBidWlsZFRsdihwWzBdLCBwWzFdKTsgfSkpO1xuICAgIHZhciBpbm5lclRhZyA9ICgoY21kVHlwZSA8PCA4KSB8IGNtZENvZGUpID4+PiAwO1xuICAgIHZhciBpbm5lclRsdiA9IGJ1aWxkVGx2KGlubmVyVGFnLCBjbWRWYWx1ZSk7XG4gICAgdmFyIGlubmVyID0gY29uY2F0Qnl0ZXMoaW5uZXJUbHYsIFVpbnQ4QXJyYXkuZnJvbShbeG9yT2YoaW5uZXJUbHYpXSkpO1xuICAgIHZhciBlbmMgPSB0ZWFFbmNyeXB0KGlubmVyLCBrZXkpO1xuICAgIHZhciB0bHYyOSA9IGJ1aWxkVGx2KDI5LCBlbmMpO1xuICAgIHZhciBvdXRlclRsdiA9IGJ1aWxkVGx2KDB4NmEwMSwgdGx2MjkpO1xuICAgIHJldHVybiBjb25jYXRCeXRlcyhvdXRlclRsdiwgVWludDhBcnJheS5mcm9tKFt4b3JPZihvdXRlclRsdildKSk7XG4gIH1cblxuICBmdW5jdGlvbiBidWlsZEdldFJhbmdlQ29kZShrZXkpIHtcbiAgICByZXR1cm4gYnVpbGRGdWxsQ29tbWFuZCgzMSwgMywgW1syNSwgVWludDhBcnJheS5mcm9tKFsxMSwgMTEsIDExLCAxMV0pXV0sIGtleSk7XG4gIH1cblxuICBmdW5jdGlvbiBidWlsZE9wZW5Mb2NrKHVzZXJLZXksIHJhbmRTdHIsIGF1dG9Mb2NrLCBrZXkpIHtcbiAgICB2YXIgYSA9IFVpbnQ4QXJyYXkuZnJvbShbYXV0b0xvY2sgPyAxIDogMF0pO1xuICAgIHJldHVybiBidWlsZEZ1bGxDb21tYW5kKFxuICAgICAgMzEsXG4gICAgICA3LFxuICAgICAgW1xuICAgICAgICBbMTAxLCB1c2VyS2V5XSxcbiAgICAgICAgWzEwMCwgcmFuZFN0cl0sXG4gICAgICAgIFsyNSwgVWludDhBcnJheS5mcm9tKFszLCAzLCAzLCAzXSldLFxuICAgICAgICBbNjYsIGFdXG4gICAgICBdLFxuICAgICAga2V5XG4gICAgKTtcbiAgfVxuXG4gIGZ1bmN0aW9uIGJ1aWxkQ2xvc2VMb2NrKHJhbmRTdHIsIGtleSkge1xuICAgIHJldHVybiBidWlsZEZ1bGxDb21tYW5kKDMxLCA5LCBbWzEwMCwgcmFuZFN0cl0sIFsyNSwgVWludDhBcnJheS5mcm9tKFs0LCA0LCA0LCA0XSldXSwga2V5KTtcbiAgfVxuXG4gIC8vIOS7jue0r+iuoemAmuefpeWtl+iKguS4reino+aekOS4gOS4quWujOaVtOWkluWxguWMheW5tuino+Wvhiwg6L+U5ZueIHsgdGx2cywgY29uc3VtZWQgfSDmiJYgbnVsbFxuICBmdW5jdGlvbiB0cnlQYXJzZVBhY2tldChidWZmZXIsIGtleSkge1xuICAgIHZhciBpID0gMDtcbiAgICB3aGlsZSAoaSArIDUgPD0gYnVmZmVyLmxlbmd0aCkge1xuICAgICAgdmFyIHRhZyA9ICgoYnVmZmVyW2ldICYgMHhmZikgPDwgOCkgfCAoYnVmZmVyW2kgKyAxXSAmIDB4ZmYpO1xuICAgICAgdmFyIHZhbGlkID0gdGFnID09PSAweDZhMDEgfHwgdGFnID09PSAweDZhMDIgfHwgdGFnID09PSAweDZhMDMgfHwgdGFnID09PSAweDZhMDQgfHwgdGFnID09PSAweDFmMDI7XG4gICAgICBpZiAoIXZhbGlkKSB7XG4gICAgICAgIGkrKztcbiAgICAgICAgY29udGludWU7XG4gICAgICB9XG4gICAgICB2YXIgbGVuZ3RoID0gKChidWZmZXJbaSArIDJdICYgMHhmZikgPDwgOCkgfCAoYnVmZmVyW2kgKyAzXSAmIDB4ZmYpO1xuICAgICAgdmFyIGVuZCA9IGkgKyA0ICsgbGVuZ3RoICsgMTtcbiAgICAgIGlmIChidWZmZXIubGVuZ3RoIDwgZW5kKSByZXR1cm4gbnVsbDtcbiAgICAgIHZhciBwa2cgPSBidWZmZXIuc2xpY2UoaSwgZW5kKTtcbiAgICAgIHZhciB4ID0geG9yT2YocGtnLnNsaWNlKDAsIHBrZy5sZW5ndGggLSAxKSk7XG4gICAgICBpZiAoeCAhPT0gcGtnW3BrZy5sZW5ndGggLSAxXSkge1xuICAgICAgICBpKys7XG4gICAgICAgIGNvbnRpbnVlO1xuICAgICAgfVxuICAgICAgdmFyIHBheWxvYWQgPSBidWZmZXIuc2xpY2UoaSArIDQsIGkgKyA0ICsgbGVuZ3RoKTtcbiAgICAgIHZhciB1bml0cyA9IHBhcnNlVGx2KHBheWxvYWQpO1xuICAgICAgaWYgKHVuaXRzWzI5XSkge1xuICAgICAgICB2YXIgaW5uZXIgPSB0ZWFEZWNyeXB0KHVuaXRzWzI5XSwga2V5KTtcbiAgICAgICAgaWYgKGlubmVyLmxlbmd0aCA+PSA1ICYmIHhvck9mKGlubmVyLnNsaWNlKDAsIGlubmVyLmxlbmd0aCAtIDEpKSA9PT0gaW5uZXJbaW5uZXIubGVuZ3RoIC0gMV0pIHtcbiAgICAgICAgICB2YXIgaW5uZXJUbHZzID0gcGFyc2VUbHYoaW5uZXIuc2xpY2UoNCwgaW5uZXIubGVuZ3RoIC0gMSkpO1xuICAgICAgICAgIHJldHVybiB7IHRsdnM6IGlubmVyVGx2cywgY29uc3VtZWQ6IGVuZCB9O1xuICAgICAgICB9XG4gICAgICAgIHJldHVybiBudWxsO1xuICAgICAgfSBlbHNlIGlmICh1bml0c1sxMDBdIHx8IHVuaXRzWzI1XSkge1xuICAgICAgICByZXR1cm4geyB0bHZzOiB1bml0cywgY29uc3VtZWQ6IGVuZCB9O1xuICAgICAgfVxuICAgICAgcmV0dXJuIHsgdGx2czogdW5pdHMsIGNvbnN1bWVkOiBlbmQgfTtcbiAgICB9XG4gICAgcmV0dXJuIG51bGw7XG4gIH1cblxuICB2YXIgUCA9IHtcbiAgICBoZXhUb0J5dGVzOiBoZXhUb0J5dGVzLFxuICAgIGJ5dGVzVG9IZXg6IGJ5dGVzVG9IZXgsXG4gICAgeG9yT2Y6IHhvck9mLFxuICAgIHRlYUVuY3J5cHQ6IHRlYUVuY3J5cHQsXG4gICAgdGVhRGVjcnlwdDogdGVhRGVjcnlwdCxcbiAgICBidWlsZFRsdjogYnVpbGRUbHYsXG4gICAgcGFyc2VUbHY6IHBhcnNlVGx2LFxuICAgIGNvbmNhdEJ5dGVzOiBjb25jYXRCeXRlcyxcbiAgICBidWlsZEZ1bGxDb21tYW5kOiBidWlsZEZ1bGxDb21tYW5kLFxuICAgIGJ1aWxkR2V0UmFuZ2VDb2RlOiBidWlsZEdldFJhbmdlQ29kZSxcbiAgICBidWlsZE9wZW5Mb2NrOiBidWlsZE9wZW5Mb2NrLFxuICAgIGJ1aWxkQ2xvc2VMb2NrOiBidWlsZENsb3NlTG9jayxcbiAgICB0cnlQYXJzZVBhY2tldDogdHJ5UGFyc2VQYWNrZXRcbiAgfTtcblxuICAvLyA9PT09PT09PT09PT09PT09PT09PT09PT09PT09PT09PT09PT09PT09PT09PT09PT09PT09PT09PT09PT1cbiAgLy8gQkxFIOWuouaIt+erryAo5Z+65LqOIEBzeXN0ZW0uYmx1ZXRvb3RoLmJsZSwg5bCB6KOF5Li6IFByb21pc2Ug54q25oCB5py6KVxuICAvLyDlu7bov5/ojrflj5bok53niZnmqKHlnZcg4oCU4oCUIOWKoOi9vemYtuauteWujOWFqOS4jeinpueisOiTneeJmSwg5L+d6K+B5peg6JOd54mZ5Lmf6IO95riy5p+T55WM6Z2i44CCXG4gIC8vID09PT09PT09PT09PT09PT09PT09PT09PT09PT09PT09PT09PT09PT09PT09PT09PT09PT09PT09PT09PVxuICBmdW5jdGlvbiBnZXRCbGVNb2R1bGUoKSB7XG4gICAgdHJ5IHtcbiAgICAgIGlmICh0eXBlb2YgcmVxdWlyZSAhPT0gJ3VuZGVmaW5lZCcpIHtcbiAgICAgICAgdmFyIG0gPSByZXF1aXJlKCdAc3lzdGVtLmJsdWV0b290aC5ibGUnKTtcbiAgICAgICAgaWYgKG0pIHJldHVybiBtO1xuICAgICAgfVxuICAgIH0gY2F0Y2ggKGUpIHtcbiAgICAgIC8vIOaooeWdl+S4jeWtmOWcqOaIluWKoOi9veWksei0pSDihpIg6ZmN57qnXG4gICAgfVxuICAgIHRyeSB7XG4gICAgICBpZiAodHlwZW9mIGdsb2JhbFRoaXMgIT09ICd1bmRlZmluZWQnKSB7XG4gICAgICAgIHJldHVybiBnbG9iYWxUaGlzWydAc3lzdGVtLmJsdWV0b290aC5ibGUnXSB8fCBudWxsO1xuICAgICAgfVxuICAgIH0gY2F0Y2ggKGUpIHt9XG4gICAgcmV0dXJuIG51bGw7XG4gIH1cblxuICB2YXIgU0VSVklDRV9VVUlEID0gJzAwMDAxOGYwLTAwMDAtMTAwMC04MDAwLTAwODA1ZjliMzRmYic7XG4gIHZhciBXUklURV9VVUlEID0gJzAwMDAyYWYxLTAwMDAtMTAwMC04MDAwLTAwODA1ZjliMzRmYic7XG4gIHZhciBOT1RJRllfVVVJRCA9ICcwMDAwMmFmMC0wMDAwLTEwMDAtODAwMC0wMDgwNWY5YjM0ZmInO1xuICB2YXIgV1JJVEVfQ0hVTksgPSAyMDtcblxuICBmdW5jdGlvbiBidWZUb0J5dGVzKGJ1Zikge1xuICAgIGlmIChidWYgaW5zdGFuY2VvZiBBcnJheUJ1ZmZlcikgcmV0dXJuIG5ldyBVaW50OEFycmF5KGJ1Zik7XG4gICAgaWYgKHR5cGVvZiBBcnJheUJ1ZmZlciAhPT0gJ3VuZGVmaW5lZCcgJiYgQXJyYXlCdWZmZXIuaXNWaWV3KGJ1ZikpIHtcbiAgICAgIHJldHVybiBuZXcgVWludDhBcnJheShidWYuYnVmZmVyLCBidWYuYnl0ZU9mZnNldCwgYnVmLmJ5dGVMZW5ndGgpO1xuICAgIH1cbiAgICBpZiAoQXJyYXkuaXNBcnJheShidWYpKSByZXR1cm4gVWludDhBcnJheS5mcm9tKGJ1Zik7XG4gICAgcmV0dXJuIG5ldyBVaW50OEFycmF5KDApO1xuICB9XG5cbiAgZnVuY3Rpb24gYnl0ZXNUb0FycmF5QnVmZmVyKGJ5dGVzKSB7XG4gICAgdmFyIGFiID0gbmV3IEFycmF5QnVmZmVyKGJ5dGVzLmxlbmd0aCk7XG4gICAgdmFyIHUgPSBuZXcgVWludDhBcnJheShhYik7XG4gICAgdS5zZXQoYnl0ZXMpO1xuICAgIHJldHVybiBhYjtcbiAgfVxuXG4gIGZ1bmN0aW9uIExvY2tDbGllbnQob3B0cykge1xuICAgIHRoaXMubWFjID0gb3B0cy5tYWM7XG4gICAgdGhpcy5kYXRhU2VjcmV0ID0gb3B0cy5kYXRhU2VjcmV0O1xuICAgIHRoaXMudXNlcktleSA9IG9wdHMudXNlcktleTtcbiAgICB0aGlzLmF1dG9Mb2NrID0gb3B0cy5hdXRvTG9jayAhPT0gZmFsc2U7XG4gICAgdGhpcy5kZXZpY2UgPSBudWxsO1xuICAgIHRoaXMud3JpdGVDaGFyID0gbnVsbDtcbiAgICB0aGlzLm5vdGlmeUNoYXIgPSBudWxsO1xuICAgIHRoaXMucmVjdkJ1ZiA9IG5ldyBVaW50OEFycmF5KDApO1xuICAgIHRoaXMucGVuZGluZyA9IFtdO1xuICAgIHRoaXMuY29ubmVjdGVkID0gZmFsc2U7XG4gICAgdGhpcy5sb2cgPSBvcHRzLmxvZyB8fCBmdW5jdGlvbiAoKSB7fTtcbiAgfVxuXG4gIExvY2tDbGllbnQucHJvdG90eXBlLl9vbk5vdGlmeSA9IGZ1bmN0aW9uIChkYXRhKSB7XG4gICAgdHJ5IHtcbiAgICAgIHZhciB2YWwgPSBkYXRhICYmIGRhdGEuY2hhcmFjdGVyaXN0aWNWYWx1ZTtcbiAgICAgIGlmICghdmFsKSByZXR1cm47XG4gICAgICB2YXIgY2h1bmsgPSBidWZUb0J5dGVzKHZhbCk7XG4gICAgICBpZiAoY2h1bmsubGVuZ3RoID09PSAwKSByZXR1cm47XG4gICAgICB0aGlzLmxvZygnUkVDViAnICsgUC5ieXRlc1RvSGV4KGNodW5rKSk7XG4gICAgICB0aGlzLnJlY3ZCdWYgPSBQLmNvbmNhdEJ5dGVzKHRoaXMucmVjdkJ1ZiwgY2h1bmspO1xuICAgICAgd2hpbGUgKHRydWUpIHtcbiAgICAgICAgdmFyIHJlcyA9IFAudHJ5UGFyc2VQYWNrZXQodGhpcy5yZWN2QnVmLCB0aGlzLmRhdGFTZWNyZXQpO1xuICAgICAgICBpZiAoIXJlcykgYnJlYWs7XG4gICAgICAgIHRoaXMucmVjdkJ1ZiA9IHRoaXMucmVjdkJ1Zi5zbGljZShyZXMuY29uc3VtZWQpO1xuICAgICAgICB0aGlzLl9kaXNwYXRjaChyZXMudGx2cyk7XG4gICAgICB9XG4gICAgfSBjYXRjaCAoZSkge1xuICAgICAgdGhpcy5sb2coJ29uTm90aWZ5IGVycm9yOiAnICsgKGUgJiYgZS5tZXNzYWdlID8gZS5tZXNzYWdlIDogZSkpO1xuICAgIH1cbiAgfTtcblxuICBMb2NrQ2xpZW50LnByb3RvdHlwZS5fZGlzcGF0Y2ggPSBmdW5jdGlvbiAodGx2cykge1xuICAgIGZvciAodmFyIGkgPSAwOyBpIDwgdGhpcy5wZW5kaW5nLmxlbmd0aDsgaSsrKSB7XG4gICAgICB2YXIgcCA9IHRoaXMucGVuZGluZ1tpXTtcbiAgICAgIGlmIChwLm1hdGNoKHRsdnMpKSB7XG4gICAgICAgIHRoaXMucGVuZGluZy5zcGxpY2UoaSwgMSk7XG4gICAgICAgIHAucmVzb2x2ZSh0bHZzKTtcbiAgICAgICAgcmV0dXJuO1xuICAgICAgfVxuICAgIH1cbiAgfTtcblxuICBMb2NrQ2xpZW50LnByb3RvdHlwZS5fd2FpdFBhY2tldCA9IGZ1bmN0aW9uIChtYXRjaEZuLCB0aW1lb3V0TXMpIHtcbiAgICB2YXIgc2VsZiA9IHRoaXM7XG4gICAgcmV0dXJuIG5ldyBQcm9taXNlKGZ1bmN0aW9uIChyZXNvbHZlLCByZWplY3QpIHtcbiAgICAgIHZhciB0aW1lciA9IHNldFRpbWVvdXQoZnVuY3Rpb24gKCkge1xuICAgICAgICB2YXIgaWR4ID0gc2VsZi5wZW5kaW5nLmZpbmRJbmRleChmdW5jdGlvbiAocCkgeyByZXR1cm4gcC5yZXNvbHZlID09PSByZXNvbHZlOyB9KTtcbiAgICAgICAgaWYgKGlkeCA+PSAwKSBzZWxmLnBlbmRpbmcuc3BsaWNlKGlkeCwgMSk7XG4gICAgICAgIHJlamVjdChuZXcgRXJyb3IoJ+etieW+heWTjeW6lOi2heaXticpKTtcbiAgICAgIH0sIHRpbWVvdXRNcyB8fCA4MDAwKTtcbiAgICAgIHNlbGYucGVuZGluZy5wdXNoKHtcbiAgICAgICAgbWF0Y2g6IG1hdGNoRm4sXG4gICAgICAgIHJlc29sdmU6IGZ1bmN0aW9uICh0bHZzKSB7XG4gICAgICAgICAgY2xlYXJUaW1lb3V0KHRpbWVyKTtcbiAgICAgICAgICByZXNvbHZlKHRsdnMpO1xuICAgICAgICB9XG4gICAgICB9KTtcbiAgICB9KTtcbiAgfTtcblxuICBMb2NrQ2xpZW50LmlzQmxlU3VwcG9ydGVkID0gZnVuY3Rpb24gKCkge1xuICAgIHZhciBibGUgPSBnZXRCbGVNb2R1bGUoKTtcbiAgICByZXR1cm4gISEoYmxlICYmIHR5cGVvZiBibGUuY3JlYXRlR2F0dENsaWVudERldmljZSA9PT0gJ2Z1bmN0aW9uJyk7XG4gIH07XG5cbiAgTG9ja0NsaWVudC5wcm90b3R5cGUuY29ubmVjdCA9IGZ1bmN0aW9uICgpIHtcbiAgICB2YXIgc2VsZiA9IHRoaXM7XG4gICAgcmV0dXJuIG5ldyBQcm9taXNlKGZ1bmN0aW9uIChyZXNvbHZlLCByZWplY3QpIHtcbiAgICAgIHZhciBibGUgPSBnZXRCbGVNb2R1bGUoKTtcbiAgICAgIGlmICghYmxlIHx8IHR5cGVvZiBibGUuY3JlYXRlR2F0dENsaWVudERldmljZSAhPT0gJ2Z1bmN0aW9uJykge1xuICAgICAgICByZWplY3QobmV3IEVycm9yKCdAc3lzdGVtLmJsdWV0b290aC5ibGUg5LiN5Y+v55So77ya5pys6K6+5aSHKOWPr+iDvSBTNC/mvo7muYNPUzMp5pyq5byA5pS+IEpTIOiTneeJme+8jOmcgOaUueeUqCBWZWxhIOWOn+eUnyBDIOW8gOWPkScpKTtcbiAgICAgICAgcmV0dXJuO1xuICAgICAgfVxuICAgICAgdmFyIGRldjtcbiAgICAgIHRyeSB7XG4gICAgICAgIGRldiA9IGJsZS5jcmVhdGVHYXR0Q2xpZW50RGV2aWNlKHNlbGYubWFjLCAnUFVCTElDJyk7XG4gICAgICB9IGNhdGNoIChlKSB7XG4gICAgICAgIHJlamVjdChuZXcgRXJyb3IoJ2NyZWF0ZUdhdHRDbGllbnREZXZpY2Ug5aSx6LSlOiAnICsgKGUubWVzc2FnZSB8fCBlKSkpO1xuICAgICAgICByZXR1cm47XG4gICAgICB9XG4gICAgICBzZWxmLmRldmljZSA9IGRldjtcbiAgICAgIGRldi5vbkJMRUNvbm5lY3Rpb25TdGF0ZUNoYW5nZSA9IGZ1bmN0aW9uIChzdGF0ZSkge1xuICAgICAgICBzZWxmLmxvZygnY29ubiBzdGF0ZSA9ICcgKyBzdGF0ZSk7XG4gICAgICAgIGlmIChzdGF0ZSA9PT0gMikgc2VsZi5jb25uZWN0ZWQgPSB0cnVlO1xuICAgICAgICBlbHNlIGlmIChzdGF0ZSA9PT0gMCB8fCBzdGF0ZSA9PT0gMykgc2VsZi5jb25uZWN0ZWQgPSBmYWxzZTtcbiAgICAgIH07XG4gICAgICBkZXYub25CTEVDaGFyYWN0ZXJpc3RpY0NoYW5nZSA9IGZ1bmN0aW9uIChkYXRhKSB7IHNlbGYuX29uTm90aWZ5KGRhdGEpOyB9O1xuICAgICAgZGV2LmNvbm5lY3Qoe1xuICAgICAgICBzdWNjZXNzOiBmdW5jdGlvbiAoKSB7XG4gICAgICAgICAgdmFyIHN0YXJ0ZWQgPSBEYXRlLm5vdygpO1xuICAgICAgICAgIHZhciBpdiA9IHNldEludGVydmFsKGZ1bmN0aW9uICgpIHtcbiAgICAgICAgICAgIGlmIChzZWxmLmNvbm5lY3RlZCkge1xuICAgICAgICAgICAgICBjbGVhckludGVydmFsKGl2KTtcbiAgICAgICAgICAgICAgcmVzb2x2ZSgpO1xuICAgICAgICAgICAgfSBlbHNlIGlmIChEYXRlLm5vdygpIC0gc3RhcnRlZCA+IDgwMDApIHtcbiAgICAgICAgICAgICAgY2xlYXJJbnRlcnZhbChpdik7XG4gICAgICAgICAgICAgIHJlamVjdChuZXcgRXJyb3IoJ+i/nuaOpei2heaXtu+8iOmXqOmUgeaYr+WQpuWcqOmZhOi/kS/lt7LlvIDmnLrvvJ/vvIknKSk7XG4gICAgICAgICAgICB9XG4gICAgICAgICAgfSwgMTAwKTtcbiAgICAgICAgfSxcbiAgICAgICAgZmFpbDogZnVuY3Rpb24gKGQsIGNvZGUpIHtcbiAgICAgICAgICByZWplY3QobmV3IEVycm9yKCfov57mjqXlpLHotKUgY29kZT0nICsgY29kZSkpO1xuICAgICAgICB9XG4gICAgICB9KTtcbiAgICB9KTtcbiAgfTtcblxuICBMb2NrQ2xpZW50LnByb3RvdHlwZS5fZ2V0U2VydmljZXMgPSBmdW5jdGlvbiAoKSB7XG4gICAgdmFyIHNlbGYgPSB0aGlzO1xuICAgIHJldHVybiBuZXcgUHJvbWlzZShmdW5jdGlvbiAocmVzb2x2ZSwgcmVqZWN0KSB7XG4gICAgICBzZWxmLmRldmljZS5nZXRTZXJ2aWNlcyh7XG4gICAgICAgIHN1Y2Nlc3M6IGZ1bmN0aW9uIChzZXJ2aWNlcykge1xuICAgICAgICAgIHZhciB3cml0ZUNoYXIgPSBudWxsLCBub3RpZnlDaGFyID0gbnVsbDtcbiAgICAgICAgICBmb3IgKHZhciBzID0gMDsgcyA8IChzZXJ2aWNlcyB8fCBbXSkubGVuZ3RoOyBzKyspIHtcbiAgICAgICAgICAgIHZhciBjaGFycyA9IHNlcnZpY2VzW3NdLmNoYXJhY3RlcmlzdGljcyB8fCBbXTtcbiAgICAgICAgICAgIGZvciAodmFyIGMgPSAwOyBjIDwgY2hhcnMubGVuZ3RoOyBjKyspIHtcbiAgICAgICAgICAgICAgdmFyIHUgPSAoY2hhcnNbY10uY2hhcmFjdGVyaXN0aWNVdWlkIHx8ICcnKS50b0xvd2VyQ2FzZSgpO1xuICAgICAgICAgICAgICBpZiAodSA9PT0gV1JJVEVfVVVJRC50b0xvd2VyQ2FzZSgpKSB3cml0ZUNoYXIgPSBjaGFyc1tjXTtcbiAgICAgICAgICAgICAgaWYgKHUgPT09IE5PVElGWV9VVUlELnRvTG93ZXJDYXNlKCkpIG5vdGlmeUNoYXIgPSBjaGFyc1tjXTtcbiAgICAgICAgICAgIH1cbiAgICAgICAgICB9XG4gICAgICAgICAgaWYgKCF3cml0ZUNoYXIgfHwgIW5vdGlmeUNoYXIpIHtcbiAgICAgICAgICAgIHJlamVjdChuZXcgRXJyb3IoJ+acquWcqOmUgeacjeWKoeS4reaJvuWIsOWGmS/pgJrnn6XnibnlvoHlgLwnKSk7XG4gICAgICAgICAgICByZXR1cm47XG4gICAgICAgICAgfVxuICAgICAgICAgIHNlbGYud3JpdGVDaGFyID0gd3JpdGVDaGFyO1xuICAgICAgICAgIHNlbGYubm90aWZ5Q2hhciA9IG5vdGlmeUNoYXI7XG4gICAgICAgICAgcmVzb2x2ZSgpO1xuICAgICAgICB9LFxuICAgICAgICBmYWlsOiBmdW5jdGlvbiAoZCwgY29kZSkge1xuICAgICAgICAgIHJlamVjdChuZXcgRXJyb3IoJ+WPkeeOsOacjeWKoeWksei0pSBjb2RlPScgKyBjb2RlKSk7XG4gICAgICAgIH1cbiAgICAgIH0pO1xuICAgIH0pO1xuICB9O1xuXG4gIExvY2tDbGllbnQucHJvdG90eXBlLl9lbmFibGVOb3RpZnkgPSBmdW5jdGlvbiAoKSB7XG4gICAgdmFyIHNlbGYgPSB0aGlzO1xuICAgIHJldHVybiBuZXcgUHJvbWlzZShmdW5jdGlvbiAocmVzb2x2ZSwgcmVqZWN0KSB7XG4gICAgICBzZWxmLmRldmljZS5zZXROb3RpZnlDaGFyYWN0ZXJpc3RpY0NoYW5nZWQoe1xuICAgICAgICBjaGFyYWN0ZXJpc3RpYzogc2VsZi5ub3RpZnlDaGFyLFxuICAgICAgICBlbmFibGU6IHRydWUsXG4gICAgICAgIHN1Y2Nlc3M6IGZ1bmN0aW9uICgpIHsgcmVzb2x2ZSgpOyB9LFxuICAgICAgICBmYWlsOiBmdW5jdGlvbiAoZCwgY29kZSkgeyByZWplY3QobmV3IEVycm9yKCflkK/nlKjpgJrnn6XlpLHotKUgY29kZT0nICsgY29kZSkpOyB9XG4gICAgICB9KTtcbiAgICB9KTtcbiAgfTtcblxuICBMb2NrQ2xpZW50LnByb3RvdHlwZS5fd3JpdGUgPSBmdW5jdGlvbiAoYnl0ZXMpIHtcbiAgICB2YXIgc2VsZiA9IHRoaXM7XG4gICAgcmV0dXJuIG5ldyBQcm9taXNlKGZ1bmN0aW9uIChyZXNvbHZlLCByZWplY3QpIHtcbiAgICAgIHZhciBvZmYgPSAwO1xuICAgICAgZnVuY3Rpb24gd3JpdGVOZXh0KCkge1xuICAgICAgICBpZiAob2ZmID49IGJ5dGVzLmxlbmd0aCkgeyByZXNvbHZlKCk7IHJldHVybjsgfVxuICAgICAgICB2YXIgbiA9IE1hdGgubWluKFdSSVRFX0NIVU5LLCBieXRlcy5sZW5ndGggLSBvZmYpO1xuICAgICAgICB2YXIgY2h1bmsgPSBieXRlcy5zbGljZShvZmYsIG9mZiArIG4pO1xuICAgICAgICBvZmYgKz0gbjtcbiAgICAgICAgdmFyIGNoYXJhY3RlcmlzdGljID0ge1xuICAgICAgICAgIHNlcnZpY2VVdWlkOiBzZWxmLndyaXRlQ2hhci5zZXJ2aWNlVXVpZCxcbiAgICAgICAgICBjaGFyYWN0ZXJpc3RpY1V1aWQ6IFdSSVRFX1VVSUQsXG4gICAgICAgICAgY2hhcmFjdGVyaXN0aWNWYWx1ZTogYnl0ZXNUb0FycmF5QnVmZmVyKGNodW5rKVxuICAgICAgICB9O1xuICAgICAgICBzZWxmLmxvZygnU0VORCAnICsgUC5ieXRlc1RvSGV4KGNodW5rKSk7XG4gICAgICAgIHNlbGYuZGV2aWNlLndyaXRlQ2hhcmFjdGVyaXN0aWNWYWx1ZSh7XG4gICAgICAgICAgY2hhcmFjdGVyaXN0aWM6IGNoYXJhY3RlcmlzdGljLFxuICAgICAgICAgIHN1Y2Nlc3M6IGZ1bmN0aW9uICgpIHsgc2V0VGltZW91dCh3cml0ZU5leHQsIDIwKTsgfSxcbiAgICAgICAgICBmYWlsOiBmdW5jdGlvbiAoZCwgY29kZSkgeyByZWplY3QobmV3IEVycm9yKCflhpnnibnlvoHlpLHotKUgY29kZT0nICsgY29kZSkpOyB9XG4gICAgICAgIH0pO1xuICAgICAgfVxuICAgICAgd3JpdGVOZXh0KCk7XG4gICAgfSk7XG4gIH07XG5cbiAgTG9ja0NsaWVudC5wcm90b3R5cGUub3BlbkxvY2sgPSBmdW5jdGlvbiAoKSB7XG4gICAgdmFyIHNlbGYgPSB0aGlzO1xuICAgIHJldHVybiBzZWxmLmNvbm5lY3QoKVxuICAgICAgLnRoZW4oZnVuY3Rpb24gKCkgeyByZXR1cm4gc2VsZi5fZ2V0U2VydmljZXMoKTsgfSlcbiAgICAgIC50aGVuKGZ1bmN0aW9uICgpIHsgcmV0dXJuIHNlbGYuX2VuYWJsZU5vdGlmeSgpOyB9KVxuICAgICAgLnRoZW4oZnVuY3Rpb24gKCkge1xuICAgICAgICB2YXIgZ3JjID0gUC5idWlsZEdldFJhbmdlQ29kZShzZWxmLmRhdGFTZWNyZXQpO1xuICAgICAgICB2YXIgcmFuZFdhaXRlciA9IHNlbGYuX3dhaXRQYWNrZXQoZnVuY3Rpb24gKHRsdnMpIHsgcmV0dXJuICEhdGx2c1sxMDBdOyB9LCA4MDAwKTtcbiAgICAgICAgcmV0dXJuIHNlbGYuX3dyaXRlKGdyYykudGhlbihmdW5jdGlvbiAoKSB7IHJldHVybiByYW5kV2FpdGVyOyB9KTtcbiAgICAgIH0pXG4gICAgICAudGhlbihmdW5jdGlvbiAocjEpIHtcbiAgICAgICAgdmFyIHJhbmRTdHIgPSByMVsxMDBdO1xuICAgICAgICB2YXIgb3AgPSBQLmJ1aWxkT3BlbkxvY2soc2VsZi51c2VyS2V5LCByYW5kU3RyLCBzZWxmLmF1dG9Mb2NrLCBzZWxmLmRhdGFTZWNyZXQpO1xuICAgICAgICB2YXIgb3BlbldhaXRlciA9IHNlbGYuX3dhaXRQYWNrZXQoZnVuY3Rpb24gKHRsdnMpIHsgcmV0dXJuICEhdGx2c1sxXTsgfSwgODAwMCk7XG4gICAgICAgIHJldHVybiBzZWxmLl93cml0ZShvcCkudGhlbihmdW5jdGlvbiAoKSB7IHJldHVybiBvcGVuV2FpdGVyOyB9KTtcbiAgICAgIH0pXG4gICAgICAudGhlbihmdW5jdGlvbiAocjIpIHtcbiAgICAgICAgdmFyIHJjID0gcjJbMV07XG4gICAgICAgIHZhciBvayA9ICEhcmMgJiYgcmMubGVuZ3RoID49IDIgJiYgcmNbMF0gPT09IDAgJiYgcmNbMV0gPT09IDA7XG4gICAgICAgIHJldHVybiBzZWxmLmRpc2Nvbm5lY3QoKS50aGVuKGZ1bmN0aW9uICgpIHtcbiAgICAgICAgICByZXR1cm4geyBzdWNjZXNzOiBvaywgcmVzdWx0Q29kZTogUC5ieXRlc1RvSGV4KHJjIHx8IG5ldyBVaW50OEFycmF5KDApKSwgYXV0b0xvY2s6IHNlbGYuYXV0b0xvY2sgfTtcbiAgICAgICAgfSk7XG4gICAgICB9KTtcbiAgfTtcblxuICBMb2NrQ2xpZW50LnByb3RvdHlwZS5jbG9zZUxvY2sgPSBmdW5jdGlvbiAoKSB7XG4gICAgdmFyIHNlbGYgPSB0aGlzO1xuICAgIHJldHVybiBzZWxmLmNvbm5lY3QoKVxuICAgICAgLnRoZW4oZnVuY3Rpb24gKCkgeyByZXR1cm4gc2VsZi5fZ2V0U2VydmljZXMoKTsgfSlcbiAgICAgIC50aGVuKGZ1bmN0aW9uICgpIHsgcmV0dXJuIHNlbGYuX2VuYWJsZU5vdGlmeSgpOyB9KVxuICAgICAgLnRoZW4oZnVuY3Rpb24gKCkge1xuICAgICAgICB2YXIgZ3JjID0gUC5idWlsZEdldFJhbmdlQ29kZShzZWxmLmRhdGFTZWNyZXQpO1xuICAgICAgICB2YXIgcmFuZFdhaXRlciA9IHNlbGYuX3dhaXRQYWNrZXQoZnVuY3Rpb24gKHRsdnMpIHsgcmV0dXJuICEhdGx2c1sxMDBdOyB9LCA4MDAwKTtcbiAgICAgICAgcmV0dXJuIHNlbGYuX3dyaXRlKGdyYykudGhlbihmdW5jdGlvbiAoKSB7IHJldHVybiByYW5kV2FpdGVyOyB9KTtcbiAgICAgIH0pXG4gICAgICAudGhlbihmdW5jdGlvbiAocjEpIHtcbiAgICAgICAgdmFyIHJhbmRTdHIgPSByMVsxMDBdO1xuICAgICAgICB2YXIgY2wgPSBQLmJ1aWxkQ2xvc2VMb2NrKHJhbmRTdHIsIHNlbGYuZGF0YVNlY3JldCk7XG4gICAgICAgIHZhciBjbG9zZVdhaXRlciA9IHNlbGYuX3dhaXRQYWNrZXQoZnVuY3Rpb24gKHRsdnMpIHsgcmV0dXJuICEhdGx2c1sxXSB8fCAhIXRsdnNbMjVdOyB9LCA4MDAwKTtcbiAgICAgICAgcmV0dXJuIHNlbGYuX3dyaXRlKGNsKS50aGVuKGZ1bmN0aW9uICgpIHsgcmV0dXJuIGNsb3NlV2FpdGVyOyB9KTtcbiAgICAgIH0pXG4gICAgICAudGhlbihmdW5jdGlvbiAocjIpIHtcbiAgICAgICAgcmV0dXJuIHNlbGYuZGlzY29ubmVjdCgpLnRoZW4oZnVuY3Rpb24gKCkge1xuICAgICAgICAgIHJldHVybiB7IHN1Y2Nlc3M6IHRydWUsIHJlc3VsdENvZGU6IFAuYnl0ZXNUb0hleChyMlsxXSB8fCBuZXcgVWludDhBcnJheSgwKSkgfTtcbiAgICAgICAgfSk7XG4gICAgICB9KTtcbiAgfTtcblxuICBMb2NrQ2xpZW50LnByb3RvdHlwZS5kaXNjb25uZWN0ID0gZnVuY3Rpb24gKCkge1xuICAgIHZhciBzZWxmID0gdGhpcztcbiAgICByZXR1cm4gbmV3IFByb21pc2UoZnVuY3Rpb24gKHJlc29sdmUpIHtcbiAgICAgIGlmICghc2VsZi5kZXZpY2UpIHsgcmVzb2x2ZSgpOyByZXR1cm47IH1cbiAgICAgIHNlbGYuZGV2aWNlLmRpc2Nvbm5lY3Qoe1xuICAgICAgICBzdWNjZXNzOiBmdW5jdGlvbiAoKSB7IHJlc29sdmUoKTsgfSxcbiAgICAgICAgZmFpbDogZnVuY3Rpb24gKCkgeyByZXNvbHZlKCk7IH0sXG4gICAgICAgIGNvbXBsZXRlOiBmdW5jdGlvbiAoKSB7IHJlc29sdmUoKTsgfVxuICAgICAgfSk7XG4gICAgfSk7XG4gIH07XG5cbiAgLy8gPT09PT09PT09PT09PT09PT09PT09PT09PT09PT09PT09PT09PT09PT09PT09PT09PT09PT09PT09PT09XG4gIC8vIOmhtemdoumAu+i+kVxuICAvLyA9PT09PT09PT09PT09PT09PT09PT09PT09PT09PT09PT09PT09PT09PT09PT09PT09PT09PT09PT09PT1cbiAgdmFyIExPQ0tfTUFDID0gJzFFOjk4OjZDOjAyOkE3Ojc3JztcbiAgdmFyIERBVEFfU0VDUkVUID0gUC5oZXhUb0J5dGVzKCdEQkNDQjU0RDZFMkU2NTU5NThGRjlFMjlDQkY4QTc2NCcpO1xuICB2YXIgVVNFUl9LRVkgPSBQLmhleFRvQnl0ZXMoJzBGODBEM0E3QUYxNkU1MUI1QkFBMUE4MjlBMTQ0QjA0Qzk4Nzg5MDFFQjYzNzdBQ0I1MjUyMTRFMzgyMEUwRDInKTtcblxuICBleHBvcnQgZGVmYXVsdCB7XG4gICAgcHJpdmF0ZToge1xuICAgICAgbWFjOiBMT0NLX01BQyxcbiAgICAgIHN0YXR1czogJ+eCueWHu+OAjOaOoua1iyBCTEXjgI3mo4Dmn6XmnKzorr7lpIfmmK/lkKbmlK/mjIEnLFxuICAgICAgbG9nczogW11cbiAgICB9LFxuICAgIG9uSW5pdCgpIHtcbiAgICAgIHRoaXMuY2xpZW50ID0gbmV3IExvY2tDbGllbnQoe1xuICAgICAgICBtYWM6IExPQ0tfTUFDLFxuICAgICAgICBkYXRhU2VjcmV0OiBEQVRBX1NFQ1JFVCxcbiAgICAgICAgdXNlcktleTogVVNFUl9LRVksXG4gICAgICAgIGF1dG9Mb2NrOiB0cnVlLFxuICAgICAgICBsb2c6IChtKSA9PiB0aGlzLmFwcGVuZExvZyhtKVxuICAgICAgfSk7XG4gICAgICAvLyDnlYzpnaLlt7LmuLLmn5PvvIzmraTosIPnlKjljbPkvb/lpLHotKXkuZ/kuI3lvbHlk43mmL7npLrvvJvml6Dok53niZnml7bnirbmgIHmoI/kvJrmmI7noa7mj5DnpLrjgIJcbiAgICAgIHRoaXMucHJvYmUoKTtcbiAgICB9LFxuICAgIGFwcGVuZExvZyhsaW5lKSB7XG4gICAgICB0aGlzLmxvZ3MgPSAodGhpcy5sb2dzIHx8IFtdKS5jb25jYXQoW2xpbmVdKTtcbiAgICAgIGlmICh0aGlzLmxvZ3MubGVuZ3RoID4gNTApIHRoaXMubG9ncyA9IHRoaXMubG9ncy5zbGljZSgtNTApO1xuICAgIH0sXG4gICAgc2V0U3RhdHVzKHMpIHtcbiAgICAgIHRoaXMuc3RhdHVzID0gcztcbiAgICB9LFxuICAgIHByb2JlKCkge1xuICAgICAgdmFyIHNlbGYgPSB0aGlzO1xuICAgICAgc2VsZi5zZXRTdGF0dXMoJ+aOoua1i+S4reKApicpO1xuICAgICAgc2VsZi5hcHBlbmRMb2coJz09IOaOoua1iyBAc3lzdGVtLmJsdWV0b290aC5ibGUgPT0nKTtcbiAgICAgIHRyeSB7XG4gICAgICAgIGlmIChMb2NrQ2xpZW50LmlzQmxlU3VwcG9ydGVkKCkpIHtcbiAgICAgICAgICBzZWxmLnNldFN0YXR1cygn4pyFIOacrOiuvuWkh+aUr+aMgSBKUyBCTEUgQVBJ77yI5Y+v5bCd6K+V55yf5py65byA6ZSB77yJJyk7XG4gICAgICAgICAgc2VsZi5hcHBlbmRMb2coJ2NyZWF0ZUdhdHRDbGllbnREZXZpY2Ug5pa55rOV5a2Y5ZyoJyk7XG4gICAgICAgIH0gZWxzZSB7XG4gICAgICAgICAgc2VsZi5zZXRTdGF0dXMoJ+KdjCDmnKzorr7lpIfkuI3mlK/mjIEgSlMgQkxF77yIUzQv5r6O5rmDT1MzIOWkp+amgueOh+mcgOWOn+eUnyBD77yJJyk7XG4gICAgICAgICAgc2VsZi5hcHBlbmRMb2coJ2NyZWF0ZUdhdHRDbGllbnREZXZpY2Ug5LiN5a2Y5ZyoJyk7XG4gICAgICAgIH1cbiAgICAgIH0gY2F0Y2ggKGUpIHtcbiAgICAgICAgc2VsZi5zZXRTdGF0dXMoJ+KdjCDmjqLmtYvlvILluLg6ICcgKyAoZS5tZXNzYWdlIHx8IGUpKTtcbiAgICAgICAgc2VsZi5hcHBlbmRMb2coJ0VSUiAnICsgKGUubWVzc2FnZSB8fCBlKSk7XG4gICAgICB9XG4gICAgfSxcbiAgICBvcGVuTG9jaygpIHtcbiAgICAgIHZhciBzZWxmID0gdGhpcztcbiAgICAgIHNlbGYuc2V0U3RhdHVzKCflvIDplIHkuK3igKYnKTtcbiAgICAgIHNlbGYuYXBwZW5kTG9nKCc+PiBvcGVuTG9jaycpO1xuICAgICAgc2VsZi5jbGllbnQub3BlbkxvY2soKVxuICAgICAgICAudGhlbihmdW5jdGlvbiAocikge1xuICAgICAgICAgIGlmIChyLnN1Y2Nlc3MpIHtcbiAgICAgICAgICAgIHNlbGYuc2V0U3RhdHVzKCfinIUg5byA6ZSB5oiQ5YqfJyArIChyLmF1dG9Mb2NrID8gJ++8iOW3suiuvuS4uuiHquWKqOWbnumUge+8iScgOiAnJykpO1xuICAgICAgICAgICAgc2VsZi5hcHBlbmRMb2coJzw8IHJlc3VsdENvZGU9JyArIHIucmVzdWx0Q29kZSk7XG4gICAgICAgICAgfSBlbHNlIHtcbiAgICAgICAgICAgIHNlbGYuc2V0U3RhdHVzKCfimqDvuI8g5byA6ZSB6L+U5Zue5aSx6LSlIHJlc3VsdENvZGU9JyArIHIucmVzdWx0Q29kZSk7XG4gICAgICAgICAgICBzZWxmLmFwcGVuZExvZygnPDwgcmVzdWx0Q29kZT0nICsgci5yZXN1bHRDb2RlKTtcbiAgICAgICAgICB9XG4gICAgICAgIH0pXG4gICAgICAgIC5jYXRjaChmdW5jdGlvbiAoZSkge1xuICAgICAgICAgIHNlbGYuc2V0U3RhdHVzKCfinYwg5byA6ZSB5aSx6LSlOiAnICsgKGUubWVzc2FnZSB8fCBlKSk7XG4gICAgICAgICAgc2VsZi5hcHBlbmRMb2coJ0VSUiAnICsgKGUubWVzc2FnZSB8fCBlKSk7XG4gICAgICAgIH0pO1xuICAgIH0sXG4gICAgY2xvc2VMb2NrKCkge1xuICAgICAgdmFyIHNlbGYgPSB0aGlzO1xuICAgICAgc2VsZi5zZXRTdGF0dXMoJ+WFs+mUgeS4reKApicpO1xuICAgICAgc2VsZi5hcHBlbmRMb2coJz4+IGNsb3NlTG9jaycpO1xuICAgICAgc2VsZi5jbGllbnQuY2xvc2VMb2NrKClcbiAgICAgICAgLnRoZW4oZnVuY3Rpb24gKHIpIHtcbiAgICAgICAgICBzZWxmLnNldFN0YXR1cygn4pyFIOWFs+mUgeaMh+S7pOW3suWPkemAgScpO1xuICAgICAgICAgIHNlbGYuYXBwZW5kTG9nKCc8PCByZXN1bHRDb2RlPScgKyByLnJlc3VsdENvZGUpO1xuICAgICAgICB9KVxuICAgICAgICAuY2F0Y2goZnVuY3Rpb24gKGUpIHtcbiAgICAgICAgICBzZWxmLnNldFN0YXR1cygn4p2MIOWFs+mUgeWksei0pTogJyArIChlLm1lc3NhZ2UgfHwgZSkpO1xuICAgICAgICAgIHNlbGYuYXBwZW5kTG9nKCdFUlIgJyArIChlLm1lc3NhZ2UgfHwgZSkpO1xuICAgICAgICB9KTtcbiAgICB9XG4gIH1cbjwvc2NyaXB0PlxuIl0sIm5hbWVzIjpbIl9fd2VicGFja19yZXF1aXJlX18iLCJERUxUQSIsIlJPVU5EUyIsIkJMT0NLIiwicmVhZEludEJFIiwiYiIsIm9mZiIsIndyaXRlSW50QkUiLCJ2IiwiaGV4VG9CeXRlcyIsImhleCIsInMiLCJyZXBsYWNlIiwib3V0IiwiVWludDhBcnJheSIsImxlbmd0aCIsImkiLCJwYXJzZUludCIsInN1YnN0ciIsImJ5dGVzVG9IZXgiLCJieXRlcyIsInRvU3RyaW5nIiwicGFkU3RhcnQiLCJ4b3JPZiIsImRhdGEiLCJ4IiwicGtjczdQYWQiLCJibG9jayIsInJlbSIsInBhZCIsInNldCIsInRlYUVuY3J5cHQiLCJrZXkiLCJwYWRkZWQiLCJrIiwidjAiLCJ2MSIsInN1bSIsImswIiwiazEiLCJrMiIsImszIiwidGVhRGVjcnlwdCIsInBhZExlbiIsInNsaWNlIiwiYnVpbGRUbHYiLCJ0YWciLCJ2YWx1ZSIsInBhcnNlVGx2IiwicmVzdWx0IiwiY29uY2F0Qnl0ZXMiLCJhcnJzIiwiQXJyYXkiLCJwcm90b3R5cGUiLCJjYWxsIiwiYXJndW1lbnRzIiwibGVuIiwiYSIsImJ1aWxkRnVsbENvbW1hbmQiLCJjbWRUeXBlIiwiY21kQ29kZSIsInVuaXRzIiwiY21kVmFsdWUiLCJhcHBseSIsIm1hcCIsInAiLCJpbm5lclRhZyIsImlubmVyVGx2IiwiaW5uZXIiLCJmcm9tIiwiZW5jIiwidGx2MjkiLCJvdXRlclRsdiIsImJ1aWxkR2V0UmFuZ2VDb2RlIiwiYnVpbGRPcGVuTG9jayIsInVzZXJLZXkiLCJyYW5kU3RyIiwiYXV0b0xvY2siLCJidWlsZENsb3NlTG9jayIsInRyeVBhcnNlUGFja2V0IiwiYnVmZmVyIiwidmFsaWQiLCJlbmQiLCJwa2ciLCJwYXlsb2FkIiwiaW5uZXJUbHZzIiwidGx2cyIsImNvbnN1bWVkIiwiUCIsImdldEJsZU1vZHVsZSIsIm0iLCJyZXF1aXJlIiwiZSIsImdsb2JhbFRoaXMiLCJTRVJWSUNFX1VVSUQiLCJXUklURV9VVUlEIiwiTk9USUZZX1VVSUQiLCJXUklURV9DSFVOSyIsImJ1ZlRvQnl0ZXMiLCJidWYiLCJBcnJheUJ1ZmZlciIsImlzVmlldyIsImJ5dGVPZmZzZXQiLCJieXRlTGVuZ3RoIiwiaXNBcnJheSIsImJ5dGVzVG9BcnJheUJ1ZmZlciIsImFiIiwidSIsIkxvY2tDbGllbnQiLCJvcHRzIiwibWFjIiwiZGF0YVNlY3JldCIsImRldmljZSIsIndyaXRlQ2hhciIsIm5vdGlmeUNoYXIiLCJyZWN2QnVmIiwicGVuZGluZyIsImNvbm5lY3RlZCIsImxvZyIsIl9vbk5vdGlmeSIsInZhbCIsImNoYXJhY3RlcmlzdGljVmFsdWUiLCJjaHVuayIsInJlcyIsIl9kaXNwYXRjaCIsIm1lc3NhZ2UiLCJtYXRjaCIsInNwbGljZSIsInJlc29sdmUiLCJfd2FpdFBhY2tldCIsIm1hdGNoRm4iLCJ0aW1lb3V0TXMiLCJzZWxmIiwiUHJvbWlzZSIsInJlamVjdCIsInRpbWVyIiwic2V0VGltZW91dCIsImlkeCIsImZpbmRJbmRleCIsIkVycm9yIiwicHVzaCIsImNsZWFyVGltZW91dCIsImlzQmxlU3VwcG9ydGVkIiwiYmxlIiwiY3JlYXRlR2F0dENsaWVudERldmljZSIsImNvbm5lY3QiLCJkZXYiLCJvbkJMRUNvbm5lY3Rpb25TdGF0ZUNoYW5nZSIsInN0YXRlIiwib25CTEVDaGFyYWN0ZXJpc3RpY0NoYW5nZSIsInN1Y2Nlc3MiLCJzdGFydGVkIiwiRGF0ZSIsIm5vdyIsIml2Iiwic2V0SW50ZXJ2YWwiLCJjbGVhckludGVydmFsIiwiZmFpbCIsImQiLCJjb2RlIiwiX2dldFNlcnZpY2VzIiwiZ2V0U2VydmljZXMiLCJzZXJ2aWNlcyIsImNoYXJzIiwiY2hhcmFjdGVyaXN0aWNzIiwiYyIsImNoYXJhY3RlcmlzdGljVXVpZCIsInRvTG93ZXJDYXNlIiwiX2VuYWJsZU5vdGlmeSIsInNldE5vdGlmeUNoYXJhY3RlcmlzdGljQ2hhbmdlZCIsImNoYXJhY3RlcmlzdGljIiwiZW5hYmxlIiwiX3dyaXRlIiwid3JpdGVOZXh0IiwibiIsIk1hdGgiLCJtaW4iLCJzZXJ2aWNlVXVpZCIsIndyaXRlQ2hhcmFjdGVyaXN0aWNWYWx1ZSIsIm9wZW5Mb2NrIiwidGhlbiIsImdyYyIsInJhbmRXYWl0ZXIiLCJyMSIsIm9wIiwib3BlbldhaXRlciIsInIyIiwicmMiLCJvayIsImRpc2Nvbm5lY3QiLCJyZXN1bHRDb2RlIiwiY2xvc2VMb2NrIiwiY2wiLCJjbG9zZVdhaXRlciIsImNvbXBsZXRlIiwiTE9DS19NQUMiLCJEQVRBX1NFQ1JFVCIsIlVTRVJfS0VZIiwiX2RlZmF1bHQiLCJleHBvcnRzIiwiZGVmYXVsdCIsInByaXZhdGUiLCJzdGF0dXMiLCJsb2dzIiwib25Jbml0IiwiY2xpZW50IiwiYXBwZW5kTG9nIiwicHJvYmUiLCJsaW5lIiwiY29uY2F0Iiwic2V0U3RhdHVzIiwiciIsImNhdGNoIl0sIm1hcHBpbmdzIjoiOzs7Ozs7Ozs7Ozs7Ozs7Ozs7Ozs7O29CQUFBQSxvQkFBb0IsRUFBRSxHQUFHLElBQU87OztvQkNBaENBLG9CQUFvQixJQUFJLEdBQUc7Ozs7Ozs7Ozs7Ozs7Ozs7Ozs7Ozs7Ozs7Ozs7Ozs7Ozs7Ozs7Ozs7Ozs7Ozs7Ozs7Ozs7Ozs7Ozs7Ozs7Ozs7Ozs7Ozs7Ozs7Ozs7Ozs7Ozs7Ozs7Ozs7Ozs7Ozs7Ozs7Ozs7Ozs7Ozs7Ozs7Ozs7Ozs7Ozs7Ozs7Ozs7Ozs7Ozs7Ozs7Ozs7Ozs7Ozs7Ozs7Ozs7Ozs7Ozs7Ozs7Ozs7b0JDNEV6QixJQUFJQyxRQUFRO29CQUNaLElBQUlDLFNBQVM7b0JBQ2IsSUFBSUMsUUFBUTtvQkFFWixTQUFTQyxVQUFVQyxDQUFDLEVBQUVDLEdBQUc7d0JBQ3ZCLE9BQU8sQUFDSixDQUFDRCxDQUFBQSxBQUFTLE9BQVRBLENBQUMsQ0FBQ0MsSUFBSSxBQUFNLEtBQU0sS0FDbkIsQUFBQ0QsQ0FBQUEsQUFBYSxPQUFiQSxDQUFDLENBQUNDLE1BQU0sRUFBRSxBQUFNLEtBQU0sS0FDdkIsQUFBQ0QsQ0FBQUEsQUFBYSxPQUFiQSxDQUFDLENBQUNDLE1BQU0sRUFBRSxBQUFNLEtBQU0sSUFDdkJELEFBQWEsT0FBYkEsQ0FBQyxDQUFDQyxNQUFNLEVBQUUsQUFBTSxNQUNiO29CQUNSO29CQUVBLFNBQVNDLFdBQVdGLENBQUMsRUFB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