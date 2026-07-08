export default function(global, globalThis, window, $app_exports$, $app_evaluate$) {
    var org_app_require = $app_require$;
    (function(global, globalThis, window, $app_exports$, $app_evaluate$) {
        var setTimeout = global.setTimeout;
        var setInterval = global.setInterval;
        var clearTimeout = global.clearTimeout;
        var clearInterval = global.clearInterval;
        var $app_require$1 = global.$app_require$ || org_app_require;
        var createAppHandler = function() {
            return (()=>{
                var __webpack_modules__ = {
                    "./src/manifest.json" (module) {
                        "use strict";
                        module.exports = JSON.parse('{"package":"com.chinavisionary.weitanglock","name":"微棠门锁","icon":"/common/icon.png","versionName":"1.0.0","versionCode":1,"minPlatformVersion":1000,"features":[{"name":"system.router"},{"name":"system.bluetooth.ble"}],"permissions":[],"deviceTypeList":["watch"],"router":{"entry":"index","pages":{"index":{"component":"index"}}},"config":{"logLevel":"debug","designWidth":480},"display":{"backgroundColor":"#0b0b0b"}}');
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
                    __webpack_require__.g = (()=>{
                        if ('object' == typeof globalThis) return globalThis;
                        try {
                            return this || new Function('return this')();
                        } catch (e) {
                            if ('object' == typeof window) return window;
                        }
                    })();
                })();
                (()=>{
                    __webpack_require__.rv = ()=>"1.7.12";
                })();
                (()=>{
                    __webpack_require__.ruid = "bundler=rspack@1.7.12";
                })();
                (()=>{
                    var $app_style$ = [];
                    var $app_script$ = function __scriptModule__(module, exports, $app_require$1) {
                        "use strict";
                        Object.defineProperty(exports, "__esModule", {
                            value: true
                        });
                        exports.default = void 0;
                        var _default = exports.default = {
                            onCreate () {
                                console.log('weitanglock app created');
                            },
                            onDestroy () {
                                console.log('weitanglock app destroyed');
                            }
                        };
                    };
                    $app_script$({}, $app_exports$, $app_require$1);
                    $app_exports$.default.style = $app_style$;
                    $app_exports$.default.manifest = __webpack_require__("./src/manifest.json");
                    var $translateStyle$ = function(value) {
                        if ('string' == typeof value) return Object.fromEntries(value.split(';').filter((item)=>Boolean(item && item.trim())).map((item)=>{
                            const matchs = item.match(/([^:]+):(.*)/);
                            if (matchs && matchs.length > 2) return [
                                matchs[1].trim().replace(/-([a-z])/g, (_, match)=>match.toUpperCase()),
                                matchs[2].trim()
                            ];
                            return [];
                        }));
                        return value;
                    };
                    __webpack_require__.g.$translateStyle$ = $translateStyle$;
                })();
            })();
        };
        return createAppHandler();
    })(global, globalThis, window, $app_exports$, $app_evaluate$);
}

//# sourceMappingURL=data:application/json;charset=utf-8;base64,eyJ2ZXJzaW9uIjozLCJmaWxlIjoiYXBwLmpzIiwic291cmNlcyI6WyJ3ZWJwYWNrOi8vd2VpdGFuZy12ZWxhLWxvY2svanNvbnwvVXNlcnMvbHVveXUvY29kZS9kZW1vL3dlaXRhbmcvLnRlbXBfdmVsYWxvY2svc3JjL21hbmlmZXN0Lmpzb24iLCJ3ZWJwYWNrOi8vd2VpdGFuZy12ZWxhLWxvY2svd2VicGFjay9ydW50aW1lL2dsb2JhbCIsIndlYnBhY2s6Ly93ZWl0YW5nLXZlbGEtbG9jay93ZWJwYWNrL3J1bnRpbWUvcnNwYWNrX3ZlcnNpb24iLCJ3ZWJwYWNrOi8vd2VpdGFuZy12ZWxhLWxvY2svd2VicGFjay9ydW50aW1lL3JzcGFja191bmlxdWVfaWQiLCJ3ZWJwYWNrOi8vd2VpdGFuZy12ZWxhLWxvY2svc3JjL2FwcC51eCJdLCJzb3VyY2VzQ29udGVudCI6WyJtb2R1bGUuZXhwb3J0cyA9IEpTT04ucGFyc2UoJ3tcInBhY2thZ2VcIjpcImNvbS5jaGluYXZpc2lvbmFyeS53ZWl0YW5nbG9ja1wiLFwibmFtZVwiOlwi5b6u5qOg6Zeo6ZSBXCIsXCJpY29uXCI6XCIvY29tbW9uL2ljb24ucG5nXCIsXCJ2ZXJzaW9uTmFtZVwiOlwiMS4wLjBcIixcInZlcnNpb25Db2RlXCI6MSxcIm1pblBsYXRmb3JtVmVyc2lvblwiOjEwMDAsXCJmZWF0dXJlc1wiOlt7XCJuYW1lXCI6XCJzeXN0ZW0ucm91dGVyXCJ9LHtcIm5hbWVcIjpcInN5c3RlbS5ibHVldG9vdGguYmxlXCJ9XSxcInBlcm1pc3Npb25zXCI6W10sXCJkZXZpY2VUeXBlTGlzdFwiOltcIndhdGNoXCJdLFwicm91dGVyXCI6e1wiZW50cnlcIjpcImluZGV4XCIsXCJwYWdlc1wiOntcImluZGV4XCI6e1wiY29tcG9uZW50XCI6XCJpbmRleFwifX19LFwiY29uZmlnXCI6e1wibG9nTGV2ZWxcIjpcImRlYnVnXCIsXCJkZXNpZ25XaWR0aFwiOjQ4MH0sXCJkaXNwbGF5XCI6e1wiYmFja2dyb3VuZENvbG9yXCI6XCIjMGIwYjBiXCJ9fScpIiwiX193ZWJwYWNrX3JlcXVpcmVfXy5nID0gKCgpID0+IHtcblx0aWYgKHR5cGVvZiBnbG9iYWxUaGlzID09PSAnb2JqZWN0JykgcmV0dXJuIGdsb2JhbFRoaXM7XG5cdHRyeSB7XG5cdFx0cmV0dXJuIHRoaXMgfHwgbmV3IEZ1bmN0aW9uKCdyZXR1cm4gdGhpcycpKCk7XG5cdH0gY2F0Y2ggKGUpIHtcblx0XHRpZiAodHlwZW9mIHdpbmRvdyA9PT0gJ29iamVjdCcpIHJldHVybiB3aW5kb3c7XG5cdH1cbn0pKCk7IiwiX193ZWJwYWNrX3JlcXVpcmVfXy5ydiA9ICgpID0+IChcIjEuNy4xMlwiKSIsIl9fd2VicGFja19yZXF1aXJlX18ucnVpZCA9IFwiYnVuZGxlcj1yc3BhY2tAMS43LjEyXCI7IiwiPHNjcmlwdD5cbmV4cG9ydCBkZWZhdWx0IHtcbiAgb25DcmVhdGUoKSB7XG4gICAgY29uc29sZS5sb2coJ3dlaXRhbmdsb2NrIGFwcCBjcmVhdGVkJylcbiAgfSxcbiAgb25EZXN0cm95KCkge1xuICAgIGNvbnNvbGUubG9nKCd3ZWl0YW5nbG9jayBhcHAgZGVzdHJveWVkJylcbiAgfVxufVxuPC9zY3JpcHQ+XG4iXSwibmFtZXMiOlsibW9kdWxlIiwiSlNPTiIsIl9fd2VicGFja19yZXF1aXJlX18iLCJnbG9iYWxUaGlzIiwiRnVuY3Rpb24iLCJlIiwid2luZG93IiwiIiwib25DcmVhdGUiLCJjb25zb2xlIiwibG9nIiwib25EZXN0cm95Il0sIm1hcHBpbmdzIjoiOzs7Ozs7Ozs7Ozs7O3dCQUFBQSxPQUFPLE9BQU8sR0FBR0MsS0FBSyxLQUFLLENBQUM7Ozs7Ozs7Ozs7Ozs7O29CQ0E1QkMsb0JBQW9CLENBQUMsR0FBRyxBQUFDO3dCQUN4QixJQUFJLEFBQXNCLFlBQXRCLE9BQU9DLFlBQXlCLE9BQU9BO3dCQUMzQyxJQUFJOzRCQUNILE9BQU8sSUFBSSxJQUFJLElBQUlDLFNBQVM7d0JBQzdCLEVBQUUsT0FBT0MsR0FBRzs0QkFDWCxJQUFJLEFBQWtCLFlBQWxCLE9BQU9DLFFBQXFCLE9BQU9BO3dCQUN4QztvQkFDRDs7O29CQ1BBSixvQkFBb0IsRUFBRSxHQUFHLElBQU87OztvQkNBaENBLG9CQUFvQixJQUFJLEdBQUc7Ozs7Ozs7Ozs7d0JDQzNCSyxJQUFBQSxXQUFBQSxRQUFBQSxPQUFBQSxHQUFlOzRCQUNiQztnQ0FDRUMsUUFBUUMsR0FBRyxDQUFDOzRCQUNkOzRCQUNBQztnQ0FDRUYsUUFBUUMsR0FBRyxDQUFDOzRCQUNkO3dCQUNGIn0=