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
                        module.exports = JSON.parse('{"package":"com.chinavisionary.weitanglock","name":"微棠门锁","icon":"/common/icon.png","versionName":"1.0.0","versionCode":1,"minPlatformVersion":1000,"features":[{"name":"system.bluetooth.ble"}],"permissions":[],"deviceTypeList":["watch"],"router":{"entry":"index","pages":{"index":{"component":"index"}}},"config":{"logLevel":"debug","designWidth":480},"display":{"backgroundColor":"#0b0b0b"}}');
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
                        "";
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

//# sourceMappingURL=data:application/json;charset=utf-8;base64,eyJ2ZXJzaW9uIjozLCJmaWxlIjoiYXBwLmpzIiwic291cmNlcyI6WyJ3ZWJwYWNrOi8vd2VpdGFuZy12ZWxhLWxvY2svanNvbnwvVXNlcnMvbHVveXUvY29kZS9kZW1vL3dlaXRhbmcvLnRlbXBfdmVsYWxvY2svc3JjL21hbmlmZXN0Lmpzb24iLCJ3ZWJwYWNrOi8vd2VpdGFuZy12ZWxhLWxvY2svd2VicGFjay9ydW50aW1lL2dsb2JhbCIsIndlYnBhY2s6Ly93ZWl0YW5nLXZlbGEtbG9jay93ZWJwYWNrL3J1bnRpbWUvcnNwYWNrX3ZlcnNpb24iLCJ3ZWJwYWNrOi8vd2VpdGFuZy12ZWxhLWxvY2svd2VicGFjay9ydW50aW1lL3JzcGFja191bmlxdWVfaWQiLCJ3ZWJwYWNrOi8vd2VpdGFuZy12ZWxhLWxvY2svc3JjL2FwcC51eCJdLCJzb3VyY2VzQ29udGVudCI6WyJtb2R1bGUuZXhwb3J0cyA9IEpTT04ucGFyc2UoJ3tcInBhY2thZ2VcIjpcImNvbS5jaGluYXZpc2lvbmFyeS53ZWl0YW5nbG9ja1wiLFwibmFtZVwiOlwi5b6u5qOg6Zeo6ZSBXCIsXCJpY29uXCI6XCIvY29tbW9uL2ljb24ucG5nXCIsXCJ2ZXJzaW9uTmFtZVwiOlwiMS4wLjBcIixcInZlcnNpb25Db2RlXCI6MSxcIm1pblBsYXRmb3JtVmVyc2lvblwiOjEwMDAsXCJmZWF0dXJlc1wiOlt7XCJuYW1lXCI6XCJzeXN0ZW0uYmx1ZXRvb3RoLmJsZVwifV0sXCJwZXJtaXNzaW9uc1wiOltdLFwiZGV2aWNlVHlwZUxpc3RcIjpbXCJ3YXRjaFwiXSxcInJvdXRlclwiOntcImVudHJ5XCI6XCJpbmRleFwiLFwicGFnZXNcIjp7XCJpbmRleFwiOntcImNvbXBvbmVudFwiOlwiaW5kZXhcIn19fSxcImNvbmZpZ1wiOntcImxvZ0xldmVsXCI6XCJkZWJ1Z1wiLFwiZGVzaWduV2lkdGhcIjo0ODB9LFwiZGlzcGxheVwiOntcImJhY2tncm91bmRDb2xvclwiOlwiIzBiMGIwYlwifX0nKSIsIl9fd2VicGFja19yZXF1aXJlX18uZyA9ICgoKSA9PiB7XG5cdGlmICh0eXBlb2YgZ2xvYmFsVGhpcyA9PT0gJ29iamVjdCcpIHJldHVybiBnbG9iYWxUaGlzO1xuXHR0cnkge1xuXHRcdHJldHVybiB0aGlzIHx8IG5ldyBGdW5jdGlvbigncmV0dXJuIHRoaXMnKSgpO1xuXHR9IGNhdGNoIChlKSB7XG5cdFx0aWYgKHR5cGVvZiB3aW5kb3cgPT09ICdvYmplY3QnKSByZXR1cm4gd2luZG93O1xuXHR9XG59KSgpOyIsIl9fd2VicGFja19yZXF1aXJlX18ucnYgPSAoKSA9PiAoXCIxLjcuMTJcIikiLCJfX3dlYnBhY2tfcmVxdWlyZV9fLnJ1aWQgPSBcImJ1bmRsZXI9cnNwYWNrQDEuNy4xMlwiOyIsIi8vIGFwcC51eCDigJQg5bqU55So57qn55Sf5ZG95ZGo5pyf77yI5YWo5bGA77yJXG5leHBvcnQgZGVmYXVsdCB7XG4gIG9uQ3JlYXRlKCkge1xuICAgIGNvbnNvbGUubG9nKCd3ZWl0YW5nbG9jayBhcHAgb25DcmVhdGUnKVxuICB9LFxuICBvbkRlc3Ryb3koKSB7XG4gICAgY29uc29sZS5sb2coJ3dlaXRhbmdsb2NrIGFwcCBvbkRlc3Ryb3knKVxuICB9XG59XG4iXSwibmFtZXMiOlsibW9kdWxlIiwiSlNPTiIsIl9fd2VicGFja19yZXF1aXJlX18iLCJnbG9iYWxUaGlzIiwiRnVuY3Rpb24iLCJlIiwid2luZG93Il0sIm1hcHBpbmdzIjoiOzs7Ozs7Ozs7Ozs7O3dCQUFBQSxPQUFPLE9BQU8sR0FBR0MsS0FBSyxLQUFLLENBQUM7Ozs7Ozs7Ozs7Ozs7O29CQ0E1QkMsb0JBQW9CLENBQUMsR0FBRyxBQUFDO3dCQUN4QixJQUFJLEFBQXNCLFlBQXRCLE9BQU9DLFlBQXlCLE9BQU9BO3dCQUMzQyxJQUFJOzRCQUNILE9BQU8sSUFBSSxJQUFJLElBQUlDLFNBQVM7d0JBQzdCLEVBQUUsT0FBT0MsR0FBRzs0QkFDWCxJQUFJLEFBQWtCLFlBQWxCLE9BQU9DLFFBQXFCLE9BQU9BO3dCQUN4QztvQkFDRDs7O29CQ1BBSixvQkFBb0IsRUFBRSxHQUFHLElBQU87OztvQkNBaENBLG9CQUFvQixJQUFJLEdBQUc7Ozs7Ozt3QkNBM0IifQ==