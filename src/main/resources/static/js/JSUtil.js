/**
 * Js工具类
 */
let JSUtil = {
    /**
     * 类型判断工具类
     */
    TypeUtil: {
        isString: function (o) { //是否字符串
            return Object.prototype.toString.call(o).slice(8, -1) === 'String'
        },
        isNumber: function (o) { //是否数字
            return Object.prototype.toString.call(o).slice(8, -1) === 'Number'
        },
        isBoolean: function (o) { //是否boolean
            return Object.prototype.toString.call(o).slice(8, -1) === 'Boolean'
        },
        isFunction: function (o) { //是否函数
            return Object.prototype.toString.call(o).slice(8, -1) === 'Function'
        },
        isNull: function (o) { //是否为null
            return Object.prototype.toString.call(o).slice(8, -1) === 'Null'
        },
        isUndefined: function (o) { //是否undefined
            return Object.prototype.toString.call(o).slice(8, -1) === 'Undefined'
        },
        isObj: function (o) { //是否对象
            return Object.prototype.toString.call(o).slice(8, -1) === 'Object'
        },
        isArray: function (o) { //是否数组
            return Object.prototype.toString.call(o).slice(8, -1) === 'Array'
        },
        isDate: function (o) { //是否时间
            return Object.prototype.toString.call(o).slice(8, -1) === 'Date'
        },
        isRegExp: function (o) { //是否正则
            return Object.prototype.toString.call(o).slice(8, -1) === 'RegExp'
        },
        isError: function (o) { //是否错误对象
            return Object.prototype.toString.call(o).slice(8, -1) === 'Error'
        },
        isSymbol: function (o) { //是否Symbol函数
            return Object.prototype.toString.call(o).slice(8, -1) === 'Symbol'
        },
        isPromise: function (o) { //是否Promise对象
            return Object.prototype.toString.call(o).slice(8, -1) === 'Promise'
        },
        isSet: function (o) { //是否Set对象
            return Object.prototype.toString.call(o).slice(8, -1) === 'Set'
        },
        isFalse: function (o) {
            if (!o || o === 'null' || o === 'undefined' || o === 'false' || o === 'NaN') return true
            return false
        },
        isTrue: function (o) {
            return !this.isFalse(o)
        },
        isIos: function () {
            var u = navigator.userAgent;
            if (u.indexOf('Android') > -1 || u.indexOf('Linux') > -1) {//安卓手机
                // return "Android";
                return false
            } else if (u.indexOf('iPhone') > -1) {//苹果手机
                // return "iPhone";
                return true
            } else if (u.indexOf('iPad') > -1) {//iPad
                // return "iPad";
                return false
            } else if (u.indexOf('Windows Phone') > -1) {//winphone手机
                // return "Windows Phone";
                return false
            } else {
                return false
            }
        },
        isPC: function () { //是否为PC端
            var userAgentInfo = navigator.userAgent;
            var Agents = ["Android", "iPhone",
                "SymbianOS", "Windows Phone",
                "iPad", "iPod"];
            var flag = true;
            for (var v = 0; v < Agents.length; v++) {
                if (userAgentInfo.indexOf(Agents[v]) > 0) {
                    flag = false;
                    break;
                }
            }
            return flag;
        },
        browserType: function () {
            var userAgent = navigator.userAgent; //取得浏览器的userAgent字符串
            var isOpera = userAgent.indexOf("Opera") > -1; //判断是否Opera浏览器
            var isIE = userAgent.indexOf("compatible") > -1 && userAgent.indexOf("MSIE") > -1 && !isOpera; //判断是否IE浏览器
            var isIE11 = userAgent.indexOf('Trident') > -1 && userAgent.indexOf("rv:11.0") > -1;
            var isEdge = userAgent.indexOf("Edge") > -1 && !isIE; //判断是否IE的Edge浏览器
            var isFF = userAgent.indexOf("Firefox") > -1; //判断是否Firefox浏览器
            var isSafari = userAgent.indexOf("Safari") > -1 && userAgent.indexOf("Chrome") == -1; //判断是否Safari浏览器
            var isChrome = userAgent.indexOf("Chrome") > -1 && userAgent.indexOf("Safari") > -1; //判断Chrome浏览器

            if (isIE) {
                var reIE = new RegExp("MSIE (\\d+\\.\\d+);");
                reIE.test(userAgent);
                var fIEVersion = parseFloat(RegExp["$1"]);
                if (fIEVersion == 7) return "IE7"
                else if (fIEVersion == 8) return "IE8";
                else if (fIEVersion == 9) return "IE9";
                else if (fIEVersion == 10) return "IE10";
                else return "IE7以下"//IE版本过低
            }
            if (isIE11) return 'IE11';
            if (isEdge) return "Edge";
            if (isFF) return "FF";
            if (isOpera) return "Opera";
            if (isSafari) return "Safari";
            if (isChrome) return "Chrome";
        },
        checkStr(str, type) {
            switch (type) {
                case 'phone':   //手机号码
                    return /^1[3|4|5|6|7|8|9][0-9]{9}$/.test(str);
                case 'tel':     //座机
                    return /^(0\d{2,3}-\d{7,8})(-\d{1,4})?$/.test(str);
                case 'card':    //身份证
                    return /(^\d{15}$)|(^\d{18}$)|(^\d{17}(\d|X|x)$)/.test(str);
                case 'pwd':     //密码以字母开头，长度在6~18之间，只能包含字母、数字和下划线
                    return /^[a-zA-Z]\w{5,17}$/.test(str)
                case 'postal':  //邮政编码
                    return /[1-9]\d{5}(?!\d)/.test(str);
                case 'QQ':      //QQ号
                    return /^[1-9][0-9]{4,9}$/.test(str);
                case 'email':   //邮箱
                    return /^[\w-]+(\.[\w-]+)*@[\w-]+(\.[\w-]+)+$/.test(str);
                case 'money':   //金额(小数点2位)
                    return /^\d*(?:\.\d{0,2})?$/.test(str);
                case 'URL':     //网址
                    return /(http|ftp|https):\/\/[\w\-_]+(\.[\w\-_]+)+([\w\-\.,@?^=%&:/~\+#]*[\w\-\@?^=%&/~\+#])?/.test(str)
                case 'IP':      //IP
                    return /((?:(?:25[0-5]|2[0-4]\\d|[01]?\\d?\\d)\\.){3}(?:25[0-5]|2[0-4]\\d|[01]?\\d?\\d))/.test(str);
                case 'date':    //日期时间
                    return /^(\d{4})\-(\d{2})\-(\d{2}) (\d{2})(?:\:\d{2}|:(\d{2}):(\d{2}))$/.test(str) || /^(\d{4})\-(\d{2})\-(\d{2})$/.test(str)
                case 'number':  //数字
                    return /^[0-9]$/.test(str);
                case 'english': //英文
                    return /^[a-zA-Z]+$/.test(str);
                case 'chinese': //中文
                    return /^[\u4E00-\u9FA5]+$/.test(str);
                case 'lower':   //小写
                    return /^[a-z]+$/.test(str);
                case 'upper':   //大写
                    return /^[A-Z]+$/.test(str);
                case 'HTML':    //HTML标记
                    return /<("[^"]*"|'[^']*'|[^'">])*>/.test(str);
                default:
                    return true;
            }
        },
        isCardID: function (sId) {
            if (!/(^\d{15}$)|(^\d{17}(\d|X|x)$)/.test(sId)) {
                alert('你输入的身份证长度或格式错误')
                return false
            }
            //身份证城市
            var aCity = {
                11: "北京",
                12: "天津",
                13: "河北",
                14: "山西",
                15: "内蒙古",
                21: "辽宁",
                22: "吉林",
                23: "黑龙江",
                31: "上海",
                32: "江苏",
                33: "浙江",
                34: "安徽",
                35: "福建",
                36: "江西",
                37: "山东",
                41: "河南",
                42: "湖北",
                43: "湖南",
                44: "广东",
                45: "广西",
                46: "海南",
                50: "重庆",
                51: "四川",
                52: "贵州",
                53: "云南",
                54: "西藏",
                61: "陕西",
                62: "甘肃",
                63: "青海",
                64: "宁夏",
                65: "新疆",
                71: "台湾",
                81: "香港",
                82: "澳门",
                91: "国外"
            };
            if (!aCity[parseInt(sId.substr(0, 2))]) {
                alert('你的身份证地区非法')
                return false
            }

            // 出生日期验证
            var sBirthday = (sId.substr(6, 4) + "-" + Number(sId.substr(10, 2)) + "-" + Number(sId.substr(12, 2))).replace(/-/g, "/"),
                d = new Date(sBirthday)
            if (sBirthday != (d.getFullYear() + "/" + (d.getMonth() + 1) + "/" + d.getDate())) {
                alert('身份证上的出生日期非法')
                return false
            }

            // 身份证号码校验
            var sum = 0,
                weights = [7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2],
                codes = "10X98765432"
            for (var i = 0; i < sId.length - 1; i++) {
                sum += sId[i] * weights[i];
            }
            var last = codes[sum % 11]; //计算出来的最后一位身份证号码
            if (sId[sId.length - 1] != last) {
                alert('你输入的身份证号非法')
                return false
            }
            return true
        }
    },
    DateUtil: {
        /**
         * 将日期格式化成指定格式的字符串
         * @param date 要格式化的日期，不传时默认当前时间，也可以是一个时间戳
         * @param fmt 目标字符串格式，支持的字符有：y,M,d,q,w,H,h,m,S，默认：yyyy-MM-dd HH:mm:ss
         * @returns 返回格式化后的日期字符串
         */
        formatDate: function (date, fmt) {
            date = date == undefined ? new Date() : date;
            date = typeof date == 'number' ? new Date(date) : date;
            fmt = fmt || 'yyyy-MM-dd HH:mm:ss';
            var obj =
                {
                    'y': date.getFullYear(), // 年份，注意必须用getFullYear
                    'M': date.getMonth() + 1, // 月份，注意是从0-11
                    'd': date.getDate(), // 日期
                    'q': Math.floor((date.getMonth() + 3) / 3), // 季度
                    'w': date.getDay(), // 星期，注意是0-6
                    'H': date.getHours(), // 24小时制
                    'h': date.getHours() % 12 == 0 ? 12 : date.getHours() % 12, // 12小时制
                    'm': date.getMinutes(), // 分钟
                    's': date.getSeconds(), // 秒
                    'S': date.getMilliseconds() // 毫秒
                };
            var week = ['天', '一', '二', '三', '四', '五', '六'];
            for (var i in obj) {
                fmt = fmt.replace(new RegExp(i + '+', 'g'), function (m) {
                    var val = obj[i] + '';
                    if (i == 'w') return (m.length > 2 ? '星期' : '周') + week[val];
                    for (var j = 0, len = val.length; j < m.length - len; j++) val = '0' + val;
                    return m.length == 1 ? val : val.substring(val.length - m.length);
                });
            }
            return fmt;
        },
        /**
         * 将字符串解析成日期
         * @param str 输入的日期字符串，如'2014-09-13'
         * @param fmt 字符串格式，默认'yyyy-MM-dd'，支持如下：y、M、d、H、m、s、S，不支持w和q
         * @returns 解析后的Date类型日期
         */
        parseDate: function (str, fmt) {
            fmt = fmt || 'yyyy-MM-dd';
            var obj = {y: 0, M: 1, d: 0, H: 0, h: 0, m: 0, s: 0, S: 0};
            fmt.replace(/([^yMdHmsS]*?)(([yMdHmsS])\3*)([^yMdHmsS]*?)/g, function (m, $1, $2, $3, $4, idx, old) {
                str = str.replace(new RegExp($1 + '(\\d{' + $2.length + '})' + $4), function (_m, _$1) {
                    obj[$3] = parseInt(_$1);
                    return '';
                });
                return '';
            });
            obj.M--; // 月份是从0开始的，所以要减去1
            var date = new Date(obj.y, obj.M, obj.d, obj.H, obj.m, obj.s);
            if (obj.S !== 0) date.setMilliseconds(obj.S); // 如果设置了毫秒
            return date;
        },

        /**
         * 将一个日期格式化成友好格式，比如，1分钟以内的返回“刚刚”，
         * 当天的返回时分，当年的返回月日，否则，返回年月日
         * @param {Object} date
         */
        formatDateToFriendly: function (date) {
            date = date || new Date();
            date = typeof date === 'number' ? new Date(date) : date;
            var now = new Date();
            if ((now.getTime() - date.getTime()) < 60 * 1000) return '刚刚'; // 1分钟以内视作“刚刚”
            var temp = this.formatDate(date, 'yyyy年M月d');
            if (temp == this.formatDate(now, 'yyyy年M月d')) return this.formatDate(date, 'HH:mm');
            if (date.getFullYear() == now.getFullYear()) return this.formatDate(date, 'M月d日');
            return temp;
        },
        /**
         * 将一段时长转换成友好格式，如：
         * 147->“2分27秒”
         * 1581->“26分21秒”
         * 15818->“4小时24分”
         * @param {Object} second
         */
        formatDurationToFriendly: function (second) {
            if (second < 60) return second + '秒';
            else if (second < 60 * 60) return (second - second % 60) / 60 + '分' + second % 60 + '秒';
            else if (second < 60 * 60 * 24) return (second - second % 3600) / 60 / 60 + '小时' + Math.round(second % 3600 / 60) + '分';
            return (second / 60 / 60 / 24).toFixed(1) + '天';
        },
        /**
         * 将时间转换成MM:SS形式
         */
        formatTimeToFriendly: function (second) {
            var m = Math.floor(second / 60);
            m = m < 10 ? ('0' + m) : m;
            var s = second % 60;
            s = s < 10 ? ('0' + s) : s;
            return m + ':' + s;
        },
        /**
         * 判断某一年是否是闰年
         * @param year 可以是一个date类型，也可以是一个int类型的年份，不传默认当前时间
         */
        isLeapYear: function (year) {
            if (year === undefined) year = new Date();
            if (year instanceof Date) year = year.getFullYear();
            return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
        },
        /**
         * 获取某一年某一月的总天数，没有任何参数时获取当前月份的
         * 方式一：$.getMonthDays();
         * 方式二：$.getMonthDays(new Date());
         * 方式三：$.getMonthDays(2013, 12);
         */
        getMonthDays: function (date, month) {
            var y, m;
            if (date == undefined) date = new Date();
            if (date instanceof Date) {
                y = date.getFullYear();
                m = date.getMonth();
            }
            else if (typeof date == 'number') {
                y = date;
                m = month - 1;
            }
            var days = [31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31]; // 非闰年的一年中每个月份的天数
            //如果是闰年并且是2月
            if (m == 1 && this.isLeapYear(y)) return days[m] + 1;
            return days[m];
        },
        /**
         * 计算2日期之间的天数，用的是比较毫秒数的方法
         * 传进来的日期要么是Date类型，要么是yyyy-MM-dd格式的字符串日期
         * @param date1 日期一
         * @param date2 日期二
         */
        countDays: function (date1, date2) {
            var fmt = 'yyyy-MM-dd';
            // 将日期转换成字符串，转换的目的是去除“时、分、秒”
            if (date1 instanceof Date && date2 instanceof Date) {
                date1 = this.format(fmt, date1);
                date2 = this.format(fmt, date2);
            }
            if (typeof date1 === 'string' && typeof date2 === 'string') {
                date1 = this.parse(date1, fmt);
                date2 = this.parse(date2, fmt);
                return (date1.getTime() - date2.getTime()) / (1000 * 60 * 60 * 24);
            }
            else {
                console.error('参数格式无效！');
                return 0;
            }
        }
    },
    ArrayUtil: {
        /**
         * 判断一个元素是否在数组中
         * @param arr
         * @param val
         * @returns {boolean}
         */
        contains: function (arr, val) {
            return arr.indexOf(val) != -1 ? true : false;
        },
        /**
         * @param  {arr} 数组
         * @param  {fn} 回调函数
         * @return {undefined}
         */
        each: function (arr, fn) {
            fn = fn || Function;
            var a = [];
            var args = Array.prototype.slice.call(arguments, 1);
            for (var i = 0; i < arr.length; i++) {
                var res = fn.apply(arr, [arr[i], i].concat(args));
                if (res != null) a.push(res);
            }
        },
        /**
         * @param  {arr} 数组
         * @param  {fn} 回调函数
         * @param  {thisObj} this指向
         * @return {Array}
         */
        map(arr, fn, thisObj) {
            var scope = thisObj || window;
            var a = [];
            for (var i = 0, j = arr.length; i < j; ++i) {
                var res = fn.call(scope, arr[i], i, this);
                if (res != null) a.push(res);
            }
            return a;
        },
        /**
         * @param  {arr} 数组
         * @param  {type} 1：从小到大   2：从大到小   3：随机
         * @return {Array}
         */
        sort(arr, type = 1) {
            return arr.sort((a, b) => {
                switch (type) {
                    case 1:
                        return a - b;
                    case 2:
                        return b - a;
                    case 3:
                        return Math.random() - 0.5;
                    default:
                        return arr;
                }
            })
        },
        /**
         * 去重
         * @param arr
         * @returns {*}
         */
        unique(arr) {
            if (Array.hasOwnProperty('from')) {
                return Array.from(new Set(arr));
            } else {
                var n = {}, r = [];
                for (var i = 0; i < arr.length; i++) {
                    if (!n[arr[i]]) {
                        n[arr[i]] = true;
                        r.push(arr[i]);
                    }
                }
                return r;
            }
        },
        /**
         * 求两个集合的并集
         * @param a
         * @param b
         * @returns {*}
         */
        union(a, b) {
            var newArr = a.concat(b);
            return this.unique(newArr);
        },
        /**
         * 求两个集合的交集
         * @param a
         * @param b
         * @returns {*|Array}
         */
        intersect(a, b) {
            var _this = this;
            a = this.unique(a);
            return this.map(a, function (o) {
                return _this.contains(b, o) ? o : null;
            });
        },
        /**
         * 删除其中一个元素
         * @param arr
         * @param ele
         * @returns {*}
         */
        remove(arr, ele) {
            var index = arr.indexOf(ele);
            if (index > -1) {
                arr.splice(index, 1);
            }
            return arr;
        },
        /**
         * 将类数组转换为数组的方法
         * @param ary
         * @returns {*|Array}
         */
        formArray(ary) {
            var arr = [];
            if (Array.isArray(ary)) {
                arr = ary;
            } else {
                arr = Array.prototype.slice.call(ary);
            }
            ;
            return arr;
        },
        /**
         * 最大值
         * @param arr
         * @returns {number}
         */
        max(arr) {
            return Math.max.apply(null, arr);
        },
        /**
         * 最小值
         * @param arr
         * @returns {number}
         */
        min(arr) {
            return Math.min.apply(null, arr);
        },
        /**
         * 求和
         * @param arr
         * @returns {*}
         */
        sum(arr) {
            return arr.reduce((pre, cur) => {
                return pre + cur
            })
        },
        /**
         * 平均值
         * @param arr
         * @returns {number}
         */
        average(arr) {
            return this.sum(arr) / arr.length
        }
    },
    NumberUtil: {
        /*随机数范围*/
        random: function (min, max) {
            if (arguments.length === 2) {
                return Math.floor(min + Math.random() * ((max + 1) - min))
            } else {
                return null;
            }

        },
        /*将阿拉伯数字翻译成中文的大写数字*/
        numberToChinese: function (num) {
            var AA = new Array("零", "一", "二", "三", "四", "五", "六", "七", "八", "九", "十");
            var BB = new Array("", "十", "百", "仟", "萬", "億", "点", "");
            var a = ("" + num).replace(/(^0*)/g, "").split("."),
                k = 0,
                re = "";
            for (var i = a[0].length - 1; i >= 0; i--) {
                switch (k) {
                    case 0:
                        re = BB[7] + re;
                        break;
                    case 4:
                        if (!new RegExp("0{4}//d{" + (a[0].length - i - 1) + "}$")
                            .test(a[0]))
                            re = BB[4] + re;
                        break;
                    case 8:
                        re = BB[5] + re;
                        BB[7] = BB[5];
                        k = 0;
                        break;
                }
                if (k % 4 == 2 && a[0].charAt(i + 2) != 0 && a[0].charAt(i + 1) == 0)
                    re = AA[0] + re;
                if (a[0].charAt(i) != 0)
                    re = AA[a[0].charAt(i)] + BB[k % 4] + re;
                k++;
            }

            if (a.length > 1) // 加上小数部分(如果有小数部分)
            {
                re += BB[6];
                for (var i = 0; i < a[1].length; i++)
                    re += AA[a[1].charAt(i)];
            }
            if (re == '一十')
                re = "十";
            if (re.match(/^一/) && re.length == 3)
                re = re.replace("一", "");
            return re;
        },
        /*将数字转换为大写金额*/
        changeToChinese: function (Num) {
            //判断如果传递进来的不是字符的话转换为字符
            if (typeof Num == "number") {
                Num = new String(Num);
            }
            ;
            Num = Num.replace(/,/g, "") //替换tomoney()中的“,”
            Num = Num.replace(/ /g, "") //替换tomoney()中的空格
            Num = Num.replace(/￥/g, "") //替换掉可能出现的￥字符
            if (isNaN(Num)) { //验证输入的字符是否为数字
                //alert("请检查小写金额是否正确");
                return "";
            }
            ;
            //字符处理完毕后开始转换，采用前后两部分分别转换
            var part = String(Num).split(".");
            var newchar = "";
            //小数点前进行转化
            for (var i = part[0].length - 1; i >= 0; i--) {
                if (part[0].length > 10) {
                    return "";
                    //若数量超过拾亿单位，提示
                }
                var tmpnewchar = ""
                var perchar = part[0].charAt(i);
                switch (perchar) {
                    case "0":
                        tmpnewchar = "零" + tmpnewchar;
                        break;
                    case "1":
                        tmpnewchar = "壹" + tmpnewchar;
                        break;
                    case "2":
                        tmpnewchar = "贰" + tmpnewchar;
                        break;
                    case "3":
                        tmpnewchar = "叁" + tmpnewchar;
                        break;
                    case "4":
                        tmpnewchar = "肆" + tmpnewchar;
                        break;
                    case "5":
                        tmpnewchar = "伍" + tmpnewchar;
                        break;
                    case "6":
                        tmpnewchar = "陆" + tmpnewchar;
                        break;
                    case "7":
                        tmpnewchar = "柒" + tmpnewchar;
                        break;
                    case "8":
                        tmpnewchar = "捌" + tmpnewchar;
                        break;
                    case "9":
                        tmpnewchar = "玖" + tmpnewchar;
                        break;
                }
                switch (part[0].length - i - 1) {
                    case 0:
                        tmpnewchar = tmpnewchar + "元";
                        break;
                    case 1:
                        if (perchar != 0) tmpnewchar = tmpnewchar + "拾";
                        break;
                    case 2:
                        if (perchar != 0) tmpnewchar = tmpnewchar + "佰";
                        break;
                    case 3:
                        if (perchar != 0) tmpnewchar = tmpnewchar + "仟";
                        break;
                    case 4:
                        tmpnewchar = tmpnewchar + "万";
                        break;
                    case 5:
                        if (perchar != 0) tmpnewchar = tmpnewchar + "拾";
                        break;
                    case 6:
                        if (perchar != 0) tmpnewchar = tmpnewchar + "佰";
                        break;
                    case 7:
                        if (perchar != 0) tmpnewchar = tmpnewchar + "仟";
                        break;
                    case 8:
                        tmpnewchar = tmpnewchar + "亿";
                        break;
                    case 9:
                        tmpnewchar = tmpnewchar + "拾";
                        break;
                }
                var newchar = tmpnewchar + newchar;
            }
            //小数点之后进行转化
            if (Num.indexOf(".") != -1) {
                if (part[1].length > 2) {
                    // alert("小数点之后只能保留两位,系统将自动截断");
                    part[1] = part[1].substr(0, 2)
                }
                for (i = 0; i < part[1].length; i++) {
                    tmpnewchar = ""
                    perchar = part[1].charAt(i)
                    switch (perchar) {
                        case "0":
                            tmpnewchar = "零" + tmpnewchar;
                            break;
                        case "1":
                            tmpnewchar = "壹" + tmpnewchar;
                            break;
                        case "2":
                            tmpnewchar = "贰" + tmpnewchar;
                            break;
                        case "3":
                            tmpnewchar = "叁" + tmpnewchar;
                            break;
                        case "4":
                            tmpnewchar = "肆" + tmpnewchar;
                            break;
                        case "5":
                            tmpnewchar = "伍" + tmpnewchar;
                            break;
                        case "6":
                            tmpnewchar = "陆" + tmpnewchar;
                            break;
                        case "7":
                            tmpnewchar = "柒" + tmpnewchar;
                            break;
                        case "8":
                            tmpnewchar = "捌" + tmpnewchar;
                            break;
                        case "9":
                            tmpnewchar = "玖" + tmpnewchar;
                            break;
                    }
                    if (i == 0) tmpnewchar = tmpnewchar + "角";
                    if (i == 1) tmpnewchar = tmpnewchar + "分";
                    newchar = newchar + tmpnewchar;
                }
            }
            //替换所有无用汉字
            while (newchar.search("零零") != -1)
                newchar = newchar.replace("零零", "零");
            newchar = newchar.replace("零亿", "亿");
            newchar = newchar.replace("亿万", "亿");
            newchar = newchar.replace("零万", "万");
            newchar = newchar.replace("零元", "元");
            newchar = newchar.replace("零角", "");
            newchar = newchar.replace("零分", "");
            if (newchar.charAt(newchar.length - 1) == "元") {
                newchar = newchar + "整"
            }
            return newchar;
        }
    },
    StorageUtil: {
        /**--------------------------------------cookie--------------------------------------**/
        /**
         * 设置cookie
         * @param key
         * @param value
         * @param day
         */
        setCookie: function (key, value, day) {
            var setting = arguments[0];
            if (Object.prototype.toString.call(setting).slice(8, -1) === 'Object') {
                for (var i in setting) {
                    var oDate = new Date();
                    oDate.setDate(oDate.getDate() + day);
                    document.cookie = i + '=' + setting[i] + ';expires=' + oDate;
                }
            } else {
                var oDate = new Date();
                oDate.setDate(oDate.getDate() + day);
                document.cookie = name + '=' + value + ';expires=' + oDate;
            }

        },
        /**
         * 获取cookie
         * @param key
         * @returns {string}
         */
        getCookie(key) {
            var arr = document.cookie.split('; ');
            for (var i = 0; i < arr.length; i++) {
                var arr2 = arr[i].split('=');
                if (arr2[0] == name) {
                    return arr2[1];
                }
            }
            return '';
        },
        /**
         * 删除cookie
         * @param name
         */
        removeCookie(name) {
            window.setCookie(name, 1, -1);
        },
        /**--------------------------------------cookie--------------------------------------**/
        /**--------------------------------------localStorage--------------------------------------**/
        /**
         * 设置localStorage
         * @param key
         * @param val
         */
        setLocal: function (key, val) {
            var setting = arguments[0];
            if (Object.prototype.toString.call(setting).slice(8, -1) === 'Object') {
                for (var i in setting) {
                    this.ls.setItem(i, JSON.stringify(setting[i]))
                }
            } else {
                window.localStorage.setItem(key, JSON.stringify(val))
            }
        },

        /**
         * 获取localStorage
         * @param key
         * @returns {*}
         */
        getLocal: function (key) {
            if (key) return JSON.parse(window.localStorage.getItem(key))
            return null;
        },
        /**
         * 移除localStorage
         * @param key
         */
        removeLocal(key) {
            window.localStorage.removeItem(key)
        },
        /**
         * 移除所有localStorage
         */
        clearLocal() {
            window.localStorage.clear()
        },
        /**--------------------------------------localStorage--------------------------------------**/
        /**--------------------------------------sessionStorage--------------------------------------**/
        /**
         * 设置sessionStorage
         * @param key
         * @param val
         */
        setSession(key, val) {
            var setting = arguments[0];
            if (Object.prototype.toString.call(setting).slice(8, -1) === 'Object') {
                for (var i in setting) {
                    window.sessionStorage.setItem(i, JSON.stringify(setting[i]))
                }
            } else {
                window.sessionStorage.setItem(key, JSON.stringify(val))
            }

        },
        /**
         * 获取sessionStorage
         * @param key
         * @returns {*}
         */
        getSession(key) {
            if (key) return JSON.parse(window.sessionStorage.getItem(key))
            return null;
        },
        /**
         * 移除sessionStorage
         * @param key
         */
        removeSession(key) {
            window.sessionStorage.removeItem(key)
        },
        /**
         * 移除所有sessionStorage
         */
        clearSession() {
            window.sessionStorage.clear()
        }
        /**--------------------------------------sessionStorage--------------------------------------**/
    },
    OtherUtil: {
        /**
         * 获取URL指定参数
         * @param name
         * @returns {*}
         */
        getURL: function (name) {
            var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
            var r = window.location.search.substr(1).match(reg);
            if (r != null) return r[2];
            return null;
        },

        /**
         * 获取全部URL参数,并转换成json对象
         * @param url
         */
        getUrlAllParams: function (url) {
            var url = url ? url : window.location.href;
            var _pa = url.substring(url.indexOf('?') + 1),
                _arrS = _pa.split('&'),
                _rs = {};
            for (var i = 0, _len = _arrS.length; i < _len; i++) {
                var pos = _arrS[i].indexOf('=');
                if (pos == -1) {
                    continue;
                }
                var name = _arrS[i].substring(0, pos),
                    value = window.decodeURIComponent(_arrS[i].substring(pos + 1));
                _rs[name] = value;
            }
            return _rs;
        },
        /**
         * 删除URL指定参数,返回url
         * @param url
         * @param name
         * @returns {*}
         */
        delParamsUrl: function (url, name) {
            var baseUrl = url.split('?')[0] + '?';
            var query = url.split('?')[1];
            if (query.indexOf(name) > -1) {
                var obj = {}
                var arr = query.split("&");
                for (var i = 0; i < arr.length; i++) {
                    arr[i] = arr[i].split("=");
                    obj[arr[i][0]] = arr[i][1];
                }
                ;
                delete obj[name];
                var url = baseUrl + JSON.stringify(obj).replace(/[\"\{\}]/g, "").replace(/\:/g, "=").replace(/\,/g, "&");
                return url
            } else {
                return url;
            }
        },
        /**
         * 图片加载
         * @param arr
         * @param callback
         */
        imgLoadAll: function (arr, callback) {
            var arrImg = [];
            for (var i = 0; i < arr.length; i++) {
                var img = new Image();
                img.src = arr[i];
                img.onload = function () {
                    arrImg.push(this);
                    if (arrImg.length == arr.length) {
                        callback && callback();
                    }
                }
            }
        },
        /**
         * 音频加载
         * @param src
         * @param callback
         */
        loadAudio: function (src, callback) {
            var audio = new Audio(src);
            audio.onloadedmetadata = callback;
            audio.src = src;
        },
        /**
         * DOM转字符串
         * @param htmlDOM
         * @returns {string}
         */
        domToStirng: function (htmlDOM) {
            var div = document.createElement("div");
            div.appendChild(htmlDOM);
            return div.innerHTML
        },
        /**
         * 字符串转DOM
         * @param htmlString
         * @returns {Element}
         */
        stringToDom: function (htmlString) {
            var div = document.createElement("div");
            div.innerHTML = htmlString;
            return div.children[0];
        },
        /**
         * 光标所在位置插入字符，并设置光标位置
         *
         * @param {dom} 输入框
         * @param {val} 插入的值
         * @param {posLen} 光标位置处在 插入的值的哪个位置
         */
        setCursorPosition: function (dom, val, posLen) {
            var cursorPosition = 0;
            if (dom.selectionStart) {
                cursorPosition = dom.selectionStart;
            }
            this.insertAtCursor(dom, val);
            dom.focus();
            console.log(posLen)
            dom.setSelectionRange(dom.value.length, cursorPosition + (posLen || val.length));
        },
        /*光标所在位置插入字符*/
        insertAtCursor: function (dom, val) {
            if (document.selection) {
                dom.focus();
                sel = document.selection.createRange();
                sel.text = val;
                sel.select();
            } else if (dom.selectionStart || dom.selectionStart == '0') {
                let startPos = dom.selectionStart;
                let endPos = dom.selectionEnd;
                let restoreTop = dom.scrollTop;
                dom.value = dom.value.substring(0, startPos) + val + dom.value.substring(endPos, dom.value.length);
                if (restoreTop > 0) {
                    dom.scrollTop = restoreTop;
                }
                dom.focus();
                dom.selectionStart = startPos + val.length;
                dom.selectionEnd = startPos + val.length;
            } else {
                dom.value += val;
                dom.focus();
            }
        }
    },
    HttpUtil: {
        /**
         * JQ库表单参数请求
         * 注意要先引入JQ库,
         * @param setting
         */
        jqAjaxFrom: function (setting) {
            $.ajax({
                type: (setting.method || "POST").toUpperCase(),
                url: setting.url || "",
                data: setting.pargrams,
                success: setting.success || function (response) {
                    console.log(response);
                },
                error: setting.error || function (response) {
                    console.log(response);
                }
            });
        },
        /**
         * JQ库Json方式请求
         * 注意要先引入JQ库,
         * @param setting
         */
        jqAjaxJson: function (setting) {
            $.ajax({
                type: (setting.method || "POST").toUpperCase(),
                url: setting.url || "",
                data: JSON.stringify(setting.data),
                contentType: "application/json;charset=utf-8",
                success: setting.success || function (response) {
                    console.log(response);
                },
                error: setting.error || function (response) {
                    console.log(response);
                }
            });
        },
        // let url = 'http://demo.com/api'
        // 例:
        //     ajax({
        //         url: url,
        //         success: function (data) {
        //         }
        //     })
        /**
         * XMLHttpRequest发送http请求
         * @param setting
         */
        ajax: function (setting) {
            //设置参数的初始值
            var opts = {
                method: (setting.method || "GET").toUpperCase(), //请求方式
                url: setting.url || "", // 请求地址
                async: setting.async || true, // 是否异步
                dataType: setting.dataType || "json", // 解析方式
                data: setting.data || "", // 参数
                success: setting.success || function () {
                }, // 请求成功回调
                error: setting.error || function () {
                } // 请求失败回调
            }

            // 参数格式化
            function params_format(obj) {
                var str = ''
                for (var i in obj) {
                    str += i + '=' + obj[i] + '&'
                }
                return str.split('').slice(0, -1).join('')
            }

            // 创建ajax对象
            var xhr = new XMLHttpRequest();

            // 连接服务器open(方法GET/POST，请求地址， 异步传输)
            if (opts.method == 'GET') {
                xhr.open(opts.method, opts.url + "?" + params_format(opts.data), opts.async);
                xhr.send();
            } else {
                xhr.open(opts.method, opts.url, opts.async);
                xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
                xhr.send(opts.data);
            }

            /*
            ** 每当readyState改变时，就会触发onreadystatechange事件
            ** readyState属性存储有XMLHttpRequest的状态信息
            ** 0 ：请求未初始化
            ** 1 ：服务器连接已建立
            ** 2 ：请求已接受
            ** 3 : 请求处理中
            ** 4 ：请求已完成，且相应就绪
            */
            xhr.onreadystatechange = function () {
                if (xhr.readyState === 4 && (xhr.status === 200 || xhr.status === 304)) {
                    switch (opts.dataType) {
                        case "json":
                            var json = JSON.parse(xhr.responseText);
                            opts.success(json);
                            break;
                        case "xml":
                            opts.success(xhr.responseXML);
                            break;
                        default:
                            opts.success(xhr.responseText);
                            break;
                    }
                }
            }

            xhr.onerror = function (err) {
                opts.error(err);
            }
        },
        // let url = 'http://demo.com/api'
        // 例:
        //     fetchHttp(url).then(res => {
        //         console.log(res)
        //     }).catch(e => {
        //         console.log(e)
        //     })
        // fetchHttp(url, {
        //     method: 'POST',
        // })
        /**
         * ES6 Promise发送http请求
         * @param url
         * @param setting
         * @returns {Promise<any>}
         */
        fetchHttp: function (url, setting = {}) {
            //设置参数的初始值
            let opts = {
                method: (setting.method || 'GET').toUpperCase(), //请求方式
                headers: setting.headers || {}, // 请求头设置
                credentials: setting.credentials || true, // 设置cookie是否一起发送
                body: setting.body || {},
                mode: setting.mode || 'cors', // 可以设置 cors, no-cors, same-origin
                redirect: setting.redirect || 'follow', // follow, error, manual
                cache: setting.cache || 'default' // 设置 cache 模式 (default, reload, no-cache)
            }
            let dataType = setting.dataType || "json", // 解析方式
                data = setting.data || "" // 参数

            // 参数格式化
            function params_format(obj) {
                var str = ''
                for (var i in obj) {
                    str += `${i}=${obj[i]}&`
                }
                return str.split('').slice(0, -1).join('')
            }

            if (opts.method === 'GET') {
                url = url + (data ? `?${params_format(data)}` : '')
            } else {
                setting.body = data || {}
            }
            return new Promise((resolve, reject) => {
                fetch(url, opts).then(async res => {
                    let data = dataType === 'text' ? await res.text() :
                        dataType === 'blob' ? await res.blob() : await res.json()
                    resolve(data)
                }).catch(e => {
                    reject(e)
                })
            })
        }
    }
};


