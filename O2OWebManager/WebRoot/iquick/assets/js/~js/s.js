/*! aikuaike 0.1.0 2014-09-28 */
!function(){function a(a){return function(){return a}}function b(a){var b=h(a),c=b[0],b=b[1];this.id=a,this.name=b,this.uri=f(b),this.Ba=!b,this.status=t,c&&b&&(this.Ha=e(g(c+"!"))||{load:function(){}}),this.v=[]}function c(a,b,e){var h=a.length;if(0===h)b();else for(var j=h,k=0;h>k;k++)(function(a){function h(){if(a.status<v)k();else{for(var b=a.v,d=[],f=0;f<b.length;f++){var h=b[f];h&&g(h).status<w&&d.push(h)}0===d.length?k():c(d,k,e)}}function k(){a&&a.status<w&&(a.status=w),0===--j&&b()}var l=a.Ha;l&&(l.normalize&&(a.name=l.normalize(a.name,f)),l.name2url&&(a.uri=l.name2url(a.name))),a.status<v?l&&i(l.load)?l.load(a.name,z,function(b){D(a.id,[],function(){return b}),k()}):d(a,h,e):h()})(g(a[k]))}function d(a,b,c){a.status=u,C[a.id]?b():B[a.id]?A[a.id].push(b):(B[a.id]=k,A[a.id]=[b],c?(b=a.uri,a=r.createElement("script"),a.charset="utf-8",a.async=k,a.src=b,b=r.getElementsByTagName("head")[0]||r.body,b.insertBefore(a,b.firstChild)):r.write('<script charset="utf-8" src="'+a.uri+'"></script>'))}function e(a){if(!a)return l;if(a.status>=x)return a.V;if(a.status<w&&a.V===j)return l;a.status=x;for(var b=[],c=0;c<a.v.length;c++)b[c]=e(g(a.v[c]));var d=c=a.factory;return i(c)&&(d=c.apply(window,b)),a.status=y,a.V=d}function f(a){return/^https?:\/\//.test(a)?a:q+a+".js"}function g(a){return s[a]||(s[a]=new b(a))}function h(a){var b,c=a?a.indexOf("!"):-1;return c>-1&&(b=a.slice(0,c),a=a.slice(c+1,a.length)),[b,a]}function i(a){return"[object Function]"===Object.prototype.toString.call(a)}var j=void 0,k=!0,l=null,m=!1,n=["search!"],o=3,p="BAIDU_DUP_replacement",q="http://dup.baidustatic.com/painter/",r=document,s={},t=0,u=1,v=2,w=3,x=4,y=5,z=window.BAIDU_DUP_require||function(a,b,d){c(a,function(){for(var c=[],d=0;d<a.length;d++)c[d]=e(g(a[d]));i(b)&&b.apply(window,c)},d)},A={},B={},C={},D=window.BAIDU_DUP_define||function(a,b,c){var d=g(a);if(d.status<v&&(d.v=b,d.factory=c,d.status=d.Ba?w:v),B[a])for(delete B[a],C[a]=k,b=A[a],delete A[a];a=b.shift();)a()};D("util/lang",[],function(){function a(a){for(var b={},c="Array Boolean Date Error Function Number RegExp String".split(" "),d=0,e=c.length;e>d;d++)b["[object "+c[d]+"]"]=c[d].toLowerCase();return a==l?"null":b[Object.prototype.toString.call(a)]||"object"}var b=Object.prototype.hasOwnProperty;return{A:b,a:a,getAttribute:function(a,b){for(var c=a,d=b.split(".");d.length;){if(c===j||c===l)return;c=c[d.shift()]}return c},fa:function(c){if("object"!==a(c))return"";var d,e=[];for(d in c)b.call(c,d)&&e.push(d+"="+encodeURIComponent(c[d]));return e.join("&")},j:function(b){var c=[];switch(a(b)){case"object":c=Array.prototype.slice.call(b);break;case"array":c=b;break;case"number":case"string":c.push(b)}return c},unique:function(a){for(var b=[],c={},d=a.length,e=0;d>e;e++){var f=a[e];c[f]||(b[b.length]=f,c[f]=k)}return b},removeItem:function(a,b){for(var c=[].slice.call(a),d=c.length-1;d>=0;d--)c[d]===b&&c.splice(d,1);return c},ca:function(){}}}),D("util/browser",["util/lang"],function(a){var b={},c=navigator.userAgent,d=window.RegExp;if(/msie (\d+\.\d)/i.test(c)&&(b.o=document.documentMode||+d.$1),/opera\/(\d+\.\d)/i.test(c)&&(b.opera=+d.$1),/firefox\/(\d+\.\d)/i.test(c)&&(b.Sa=+d.$1),/(\d+\.\d)?(?:\.\d)?\s+safari\/?(\d+\.\d+)?/i.test(c)&&!/chrome/i.test(c)&&(b.cb=+(d.$1||d.$2)),/chrome\/(\d+\.\d)/i.test(c)){b.la=+d.$1;var e;try{e="scoped"in document.createElement("style")}catch(f){e=m}e&&(b.Ma=k)}try{/(\d+\.\d)/.test(a.getAttribute(window,"external.max_version"))&&(b.Ya=+d.$1)}catch(g){}for(a="Android iPad iPhone Linux Macintosh Windows".split(" "),d="",e=0;e<a.length&&(d=a[e],!c.match(RegExp(d.toLowerCase(),"i")));e++);return b.platform=d,b}),D("util/dom",["util/lang"],function(a){function b(a){try{if(a&&"object"==typeof a&&a.document&&"setInterval"in a)return k}catch(b){}return m}function c(a,c){return c=2===arguments.length?c:a.parent,a!=c||!b(a)}function d(a,b){for(var b=2===arguments.length?b:a.parent,d=0;10>d++&&c(a,b);){var e;try{e=!!a.parent.location.toString()}catch(f){e=m}if(!e)return k;a=a.parent}return d>=10}function e(a){return 9===a.nodeType?a:a.ownerDocument||a.document}return{c:function(b,c){return"string"===a.a(b)&&0<b.length?(c||window).document.getElementById(b):!b.nodeName||1!==b.nodeType&&9!==b.nodeType?l:b},Da:b,p:c,B:d,ra:e,z:function(a){return a=e(a),a.parentWindow||a.defaultView||l},h:function(a){return a=b(a)?a.document:e(a),"CSS1Compat"===a.compatMode?a.documentElement:a.body},I:function(b,e){1===arguments.length&&"number"===a.a(arguments[0])&&(e=arguments[0],b=j);for(var e=e||10,f=window,g=0;g++<e&&c(f)&&!d(f)&&(!b||!b(f));)f=f.parent;return f}}}),D("util/style",["util/lang","util/dom","util/browser"],function(a,b,c){function d(a,c){if(!a)return"";var d="",d=-1<c.indexOf("-")?c.replace(/[-][^-]{1}/g,function(a){return a.charAt(1).toUpperCase()}):c.replace(/[A-Z]{1}/g,function(a){return"-"+a.charAt(0).toLowerCase()}),e=b.z(a);if(e&&e.getComputedStyle){if(e=e.getComputedStyle(a,l))return e.getPropertyValue(c)||e.getPropertyValue(d)}else if(a.currentStyle)return e=a.currentStyle,e[c]||e[d];return""}function e(a){var c={top:0,left:0};if(a===b.h(a))return c;var e=b.ra(a),f=e.body,e=e.documentElement;return a.getBoundingClientRect&&(a=a.getBoundingClientRect(),c.left=Math.floor(a.left)+Math.max(e.scrollLeft,f.scrollLeft),c.top=Math.floor(a.top)+Math.max(e.scrollTop,f.scrollTop),c.left-=e.clientLeft,c.top-=e.clientTop,a=d(f,"borderLeftWidth"),f=d(f,"borderTopWidth"),a=parseInt(a,10),f=parseInt(f,10),c.left-=isNaN(a)?2:a,c.top-=isNaN(f)?2:f),c}function f(a,b){var c=d(a,"margin"+b).toString().toLowerCase().replace("px","").replace("auto","0");return parseInt(c,10)||0}function g(d){for(var e=b.z(d),f=100;d&&d.tagName;){var g=100;if(c.o){if(5<c.o)try{g=parseInt(a.getAttribute(d,"filters.alpha.opacity"),10)||100}catch(h){}f=f>g?g:f}else{try{g=100*(e.getComputedStyle(d,l).opacity||1)}catch(i){}f*=g/100}d=d.parentNode}return 0===f?0:f||100}return{Wa:d,Va:e,n:function(a){var c=b.c(a);if(!c)return m;if(a=e(c),c=b.z(c),!c)return a;for(var d=0;c!==c.parent&&10>d++&&!b.B(c)&&c.frameElement;){var f=e(c.frameElement);a.left+=f.left,a.top+=f.top,c=c.parent}return a},Ta:f,K:function(a,c){var d=b.c(a),e=d.offsetWidth;return c&&(e+=f(d,"Left")+f(d,"Right")),e},J:function(a,c){var d=b.c(a),e=d.offsetHeight;return c&&(e+=f(d,"Top")+f(d,"Bottom")),e},Ua:g,ta:function(a){for(var c=b.c(a),a=b.z(c),c=g(c),d=0;10>d++&&b.p(a)&&!b.B(a);){var e=a.frameElement?g(a.frameElement):100,c=c*(e/100);a=a.parent}return c},aa:function(a){try{var c=b.h(a||window).scrollWidth;if(c||0===c)return c}catch(d){}return-1},$:function(a){try{var c=b.h(a||window).scrollHeight;if(c||0===c)return c}catch(d){}return-1},m:function(a){try{var c=b.h(a||window).clientWidth;if(c||0===c)return c}catch(d){}return-1},l:function(a){try{var c=b.h(a||window).clientHeight;if(c||0===c)return c}catch(d){}return-1},xa:function(a){var c=b.h(a);return a.pageYOffset||c.scrollTop},wa:function(a){var c=b.h(a);return a.pageXOffset||c.scrollLeft}}}),D("util/url",["util/dom"],function(a){return{Z:function(a,b,c){return a=a.match(RegExp("(\\?|&|#)"+b+"=([^&#]*)(&|#)?")),b="",a&&(b=a[2]),c&&(b=decodeURIComponent(b)),b},L:function(b){var b=a.I(b),c="";return a.p(b)&&(c=b.document.referrer),c=c||b.location.href}}}),D("util/event",["util/dom"],function(a){return{bind:function(b,c,d){if(b=a.Da(b)?b:a.c(b))if(b.addEventListener)b.addEventListener(c,d,m);else if(b.attachEvent)b.attachEvent("on"+c,d);else{var e=b["on"+c];b["on"+c]=function(){e&&e.apply(this,arguments),d.apply(this,arguments)}}return b}}}),D("util/cookie",["util/lang"],function(a){return{get:function(a,b){var c=RegExp("(^| )"+a+"=([^;]*)(;|$)").exec(document.cookie);return c?b?decodeURIComponent(c[2]):c[2]:""},set:function(b,c,d,e){var f=d.expires;"number"===a.a(f)&&(f=new Date,f.setTime(+f+d.expires)),document.cookie=b+"="+(e?encodeURIComponent(c):c)+(d.path?"; path="+d.path:"")+(f?"; expires="+f.toGMTString():"")+(d.domain?"; domain="+d.domain:"")}}}),D("util/data",["util/lang","util/dom"],function(a,b){function c(b,c,d){var e,d=d?h:f;if("string"===a.a(b)){for(b=b.split(".");b.length;)e=b.shift(),d[e]=b.length?d[e]!==j?d[e]:{}:c,d=d[e];e=c}return e}function d(b,c){var d,e=c?h:f;return"string"===a.a(b)&&(d=a.getAttribute(e,b)),d}function e(a,b,e){if(!a||!b)return m;var f=d(a)||{};switch(e){case"+1":e=f[b]||0,f[b]=++e;break;default:f[b]=parseInt(e,10)}return c(a,f),f[b]}var f={},g=b.I(),h=g.BAIDU_DUP_info||(g.BAIDU_DUP_info={});return{k:function(a,b){var c=window;return c[a]?c[a]:c[a]=b},Y:function(a){var b=window,c=b[a];return b[a]=j,c},q:c,d:d,ea:function(b,c){var d=c?h:f;switch(a.a(b)){case"string":for(var e=b.split(".");e.length;){var g=e.shift();if(!e.length||d[g]===j)return delete d[g],k;d=d[g]}}return m},R:function(a,b){return e(a,b,"+1")},$a:function(a,b,c){return e(a,b,c)},count:e,qa:function(a,b){return a&&b?(d(a)||{})[b]||0:m},La:function(a,b){if(!a||!b)return m;var e=d("pageConfig")||{};return e[a]=b,c("pageConfig",e),k},pa:function(a){return a?(d("pageConfig")||{})[a]:m}}}),D("util/storage",[],function(){function a(a,b,d){if(c)try{c.setItem(a,d?encodeURIComponent(b):b)}catch(e){}}function b(a,b){if(c){var d=c.getItem(a);return b&&d?decodeURIComponent(d):d}return l}var c=window.localStorage;return{ka:function(){var d=m;try{c.removeItem("BAIDU_DUP_storage_available"),a("BAIDU_DUP_storage_available","1"),b("BAIDU_DUP_storage_available")&&(d=k),c.removeItem("BAIDU_DUP_storage_available")}catch(e){}return d},setItem:a,getItem:b,ia:function(d,e,f){if(c){e=f?encodeURIComponent(e):e,f=b(d)||"";try{a(d,f+((f&&"|")+e))}catch(g){}}},ha:function(d,e,f){if(c)if(e=f?encodeURIComponent(e):e,f=b(d)||"",f=f.replace(RegExp(e+"\\|?","g"),"").replace(/\|$/,""))try{a(d,f)}catch(g){}else c.removeItem(d)}}}),D("util/log",["util/lang","util/event","util/storage"],function(a,b,c){function d(a,b){var c=new Image,d="BAIDU_DUP_log_"+Math.floor(2147483648*Math.random()).toString(36);window[d]=c,c.onload=c.onerror=c.onabort=function(){c.onload=c.onerror=c.onabort=l,c=window[d]=l,b&&b(e,a,k)},c.src=a}var e="BAIDU_DUP_log_storage";return{Xa:d,ab:function(){var a=c.getItem(e);if(a)for(var a=a.split("|"),b=0,f=a.length;f>b;b++)d(decodeURIComponent(a[b]),c.ha)},F:function(f){var f="object"===a.a(f)?f:{},g=f.url||"http://cbjslog.baidu.com/log",h=f.option||"now",f=a.fa(f.data||{}),g=g+((0<=g.indexOf("?")?"&":"?")+f+(f?"&":"")+"rdm="+ +new Date);switch(h){case"now":d(g);break;case"block":break;default:c.ia(e,g,k),b.bind(window,"unload",function(){d(g,c.ha)})}}}}),D("util","util/lang,util/dom,util/style,util/url,util/event,util/cookie,util/data,util/storage,util/log,util/browser".split(","),function(a,b,c,d,e,f,g,h,i,j){return{lang:a,b:b,style:c,url:d,event:e,cookie:f,data:g,fb:h,log:i,U:j}}),D("biz",["util"],function(a){function b(b,c){var d=/^[0-9a-zA-Z]+$/;return b&&d.test(b)&&c?c="array"===a.lang.a(c)?c:Array.prototype.slice.call(arguments,1):[]}function c(b,c,f){if(!c||!c.length)return m;var g,f=f||{Q:m,ba:m,da:m},h=f.ba?a.data.d(d):{},i=f.Q?e:d,h=f.da?{}:a.data.d(i)||h,f={};for(g in h)a.lang.A.call(h,g)&&(f[g]="array"===a.lang.a(h[g])?h[g].slice():h[g]);var h=f[b]||[],j=c.length;for(g=0;j>g;g++){var l=c[g];"string"==typeof l&&(l=encodeURIComponent(l),100>=l.length&&(h[h.length]=l))}return h.length?(f[b]=a.lang.unique(h),a.data.q(i,f),k):m}var d="bizOrientations",e="bizUrgentOrientations";return{T:function(a){var d=b.apply(this,arguments);return c(a,d)},ja:function(a){var d=b.apply(this,arguments);return c(a,d,{Q:k,ba:k})},Oa:function(a){var d=b.apply(this,arguments);return c(a,d,{Q:k,da:k})},ua:function(b){var b=Math.max(0,Math.min(b||500,500)),c=[],f=a.data.d(e)||a.data.d(d)||{};if("object"===a.lang.a(f))for(var g in f)a.lang.A.call(f,g)&&(c[c.length]=g+"="+f[g].join(","));a.data.q(e,j),c.sort(function(a,b){return a.length-b.length}),f="",g=c.length;for(var h=0;g>h&&!(f.length+c[h].length>=b);h++)f+=(h?"&":"")+c[h];return f}}}),D("preview",["biz","util"],function(a,b){function c(){function a(a){var c=b.url.Z;return c(d,"baidu_clb_preview_"+a)||c(d,"baidu_dup_preview_"+a)}var d=b.url.L(),e=a("sid"),f=a("mid"),g=a("vc"),h=+a("ts"),i=l;return 3e4>=+new Date-h&&(i={ga:e,Fa:f,Pa:g}),c=function(){return i},i}return{ya:function(a){var b=[],d=c();return d&&a==d.ga&&(b.push("mid="+d.Fa),b.push("sid="+d.Pa)),b.join("&")},d:function(){return c()},Ca:function(a){var c=m;return a?/cpro_template=/gi.test(a)&&(b.data.q("#unionPreviewSwitch",k),c=k):c=!!b.data.d("#unionPreviewSwitch"),c},za:function(){var a=b.data.d("#unionPreviewData");return a?"prev="+encodeURIComponent(a)+"&pt=union":""},eb:function(a){b.data.q("#unionPreviewData",a)},Ra:function(){b.data.ea("#unionPreviewSwitch"),b.data.ea("#unionPreviewData")}}}),D("slot",["util"],function(a){function b(){for(var a={response:{},holder:"",stack:[],errors:[],status:{}},b=i.length-1;b>=0;b--)a.status[i[b]]=0;return a}function c(a,b){var c=m;return"fillAsync"===b&&(c=k),o[a]&&-1!==o[a].stack.join(" ").toLowerCase().indexOf("async")&&(c=k),c}function d(a,b){if(!a)return"";var c=p+a;return b&&(c+="_"+b),c}function e(a,b,c){return a&&b?(c===j&&(c=+new Date),o[a]?(o[a].status[b]=c,k):m):m}function f(a,b){g(a,"errors",b)}function g(b,c,d){b&&c&&d&&(b=o[b])&&"array"===a.lang.a(b[c])&&b[c].push(d)}function h(a){return a?o[a]||m:o}var i="add,create,request,response,render,finish".split(","),l=[],n={},o={},p="BAIDU_DUP_wrapper_";return{add:function(){var c={ids:[],preloadIds:[]},d=a.lang.j(arguments);if(!d.length)return c;for(var d=d.join(",").split(","),f=[],g=[],i=d.length,j=0;i>j;j++){var k=d[j];if(n.hasOwnProperty(k)){var m=k+"_"+n[k],p=h(m).stack||[];if("preload"===p[p.length-1]){c.preloadIds.push(m);continue}n[k]+=1}else n[k]=0;k=k+"_"+n[k],o[k]=new b,e(k,"add"),g.push(k),f.push(k)}return l=l.concat(g),c.ids=f,c},create:function(b,g,h){if(!b||!g)return m;var i=d(b),j=k;if(a.b.c(i))return o[b].holder=i,j;if(c(b,g)){h=h||"",o[b].holder=h,h=a.b.c(h);try{h&&(h.innerHTML='<div id="'+i+'"></div>',o[b].holder=i)}catch(l){f(b,"Failed to insert wrapper"),j=m}}else if(document.write('<div id="'+i+'"></div>'),!a.b.c(i))try{var n=document.getElementsByTagName("script"),p=n[n.length-1];if(p){var q=p.parentNode;if(q){var r=document.createElement("div");r.id=d(b,"b"),q.insertBefore(r,p)}}}catch(s){f(b,"Failed to create backup wrapper")}return e(b,"create"),j},na:c,sa:function(a){return c(a)?"async":"sync"},X:function(b){return b?(b=a.b.c(o[b].holder)||a.b.c(d(b))||a.b.c(d(b,"b")))&&b.id||"":""},w:h,P:function(a,b){return a&&b&&o[a]?(o[a].response=b,e(a,"response"),k):m},r:e,i:f,G:function(a,b){g(a,"stack",b)},H:function(b){if(b=a.lang.j(b),!b.length)return m;var c,d=[],e={};for(c=0;c<l.length;c++)e[l[c]]=c+1;for(c=0;c<b.length;c++){var f=e[""+b[c]];f===j&&(f=0),d.push(f)}return d},n:function(b){if(b=a.lang.j(b),!b.length)return["-1x-1"];for(var c=[],e=0;e<b.length;e++){var g,h=b[e];try{var i=a.b.c(d(h))||a.b.c(d(h,"b"));if(i){var j=a.style.n(i);j&&(g=[j.top,j.left])}}catch(k){f(h,"Unable to get ps")}g=g?g:[-1,-1],c.push(g.join("x"))}return c}}}),D("api",["slot","util"],function(a,b){return{getDai:a.H,getSlots:a.w,getFillType:a.sa,getFillWrapperId:a.X,setStatus:a.r,addErrorItem:a.i,addStackItem:a.G,bind:b.event.bind,getType:b.lang.a,sendLog:b.log.F,putInfo:b.data.q,getInfo:b.data.d,defineOnce:b.data.k,addCount:b.data.R,getCount:b.data.qa,getConfig:b.data.pa}}),D("param",["slot","preview","biz","util"],function(b,c,d,e){function f(a,b){for(var b=b||0,c=[],d=0,e=a.length;e>d;d++)c.push(a[d].split("_")[b]);return c.join(",")}function g(a){a=a||window.document.domain,0===a.indexOf("www.")&&(a=a.substr(4)),"."===a.charAt(a.length-1)&&(a=a.substring(0,a.length-1));var b=a.match(RegExp("([a-z0-9][a-z0-9\\-]*?\\.(?:com|cn|net|org|gov|info|la|cc|co|jp|us|hk|tv|me|biz|in|be|io|tk|cm|li|ru|ws|hn|fm|tw|ma|in|vn|name|mx|gd|im)(?:\\.(?:cn|jp|tw|ru|th))?)$","i"));return b?b[0]:a}var h=window,i=h.document,l=h.screen,n=h.navigator,o=+new Date,p=[{key:"di",value:function(a){return f(a.id)}},{key:"dcb",value:a("BAIDU_DUP_define")},{key:"dtm",value:a("BAIDU_DUP2_SETJSONADSLOT")},{key:"dbv",value:function(){var a=e.U;return a.Ma?"1":a.la?"2":"0"}},{key:"dci",value:function(a){for(var c="-1",d={fill:"0",fillOnePiece:"1",fillAsync:"2",preload:"3"},e=0;e<a.id.length;e++){var f=b.w(a.id[e]);if(f){var f=f.stack,g=f.length;if(g>=1){c=d[f[g-1]];break}}}return c}},{key:"dri",value:function(a){return f(a.id,1)}},{key:"dis",value:function(){var a=0;e.b.p(h)&&(a+=1),e.b.B(h,h.top)&&(a+=2);var b=e.style.m(),c=e.style.l();return(40>b||10>c)&&(a+=4),a}},{key:"dai",value:function(a){return b.H(a.id).join(",")}},{key:"dds",value:function(){var a=e.data.d("dds");return e.lang.fa(a)}},{key:"drs",value:function(){var a={uninitialized:0,loading:1,loaded:2,interactive:3,complete:4};try{return a[i.readyState]}catch(b){return-1}}},{key:"dvi",value:a("7o")},{key:"ltu",s:k,value:function(){var a=e.url.L(function(a){var b=e.style.m(a),a=e.style.l(a);return b>400&&a>120?k:m});return 0<a.indexOf("cpro_prev")&&(a=a.slice(0,a.indexOf("?"))),a}},{key:"liu",s:k,value:function(){return e.b.p(h)?i.URL:""}},{key:"ltr",s:k,value:function(){var a=e.b.I(),b="";try{b=a.opener?a.opener.document.location.href:""}catch(c){}return b||a.document.referrer}},{key:"lcr",s:k,value:function(){var a=i.referrer,b=a.replace(/^https?:\/\//,""),b=b.split("/")[0],b=b.split(":")[0],b=g(b),c=g(),d=e.cookie.get("BAIDU_DUP_lcr");return d&&c===b?d:c!==b?(e.cookie.set("BAIDU_DUP_lcr",a,{domain:c}),a):""}},{key:"ps",value:function(a){return b.n(a.id).join(",")}},{key:"psr",value:function(){return[l.width,l.height].join("x")}},{key:"par",value:function(){return[l.availWidth,l.availHeight].join("x")}},{key:"pcs",value:function(){return[e.style.m(),e.style.l()].join("x")}},{key:"pss",value:function(){return[e.style.aa(),e.style.$()].join("x")}},{key:"pis",value:function(){return(e.b.p(h)?[e.style.m(),e.style.l()]:[-1,-1]).join("x")}},{key:"cfv",value:function(){var a=0;if(n.plugins&&n.mimeTypes.length){var b=n.plugins["Shockwave Flash"];b&&b.description&&(a=b.description.replace(/([a-zA-Z]|\s)+/,"").replace(/(\s)+r/,".")+".0")}else if(h.ActiveXObject&&!h.opera)for(b=10;b>=2;b--)try{var c=new ActiveXObject("ShockwaveFlash.ShockwaveFlash."+b);c&&(a=c.GetVariable("$version").replace(/WIN/g,"").replace(/,/g,"."))}catch(d){}return parseInt(a,10)}},{key:"ccd",value:function(){return l.colorDepth||0}},{key:"chi",value:function(){return h.history.length||0}},{key:"cja",value:function(){return n.javaEnabled().toString()}},{key:"cpl",value:function(){return n.plugins.length||0}},{key:"cmi",value:function(){return n.mimeTypes.length||0}},{key:"cce",value:function(){return n.cookieEnabled||0}},{key:"col",value:function(){return(n.language||n.browserLanguage||n.systemLanguage).replace(/[^a-zA-Z0-9\-]/g,"")}},{key:"cec",value:function(){return(i.characterSet?i.characterSet:i.charset)||""}},{key:"cdo",value:function(){var a=window.orientation;return a===j&&(a=-1),a}},{key:"tsr",value:function(){var a=0,b=+new Date;return o&&(a=b-o),a}},{key:"tlm",value:function(){return Date.parse(i.lastModified)/1e3}},{key:"tcn",value:function(){return Math.round(+new Date/1e3)}},{key:"tpr",value:function(a){var b,c,a=a&&a.max_age?a.max_age:24e4,d=(new Date).getTime();try{b=!!window.top.location.toString()}catch(e){b=m}return c=b?window.top:window,(b=c.BAIDU_DUP2_pageFirstRequestTime)?d-b>=a&&(b=c.BAIDU_DUP2_pageFirstRequestTime=d):b=c.BAIDU_DUP2_pageFirstRequestTime=d,b||""}},{key:"_preview",value:function(a){return c.ya(f(a.id))}},{key:"dpt",value:function(){var a="none";return c.Ca()&&(a="union"),a}},{key:"coa",s:k,value:function(a){var b=a.id,b=b[0].split("_")[0],a={},c=m,d=e.data.d("#novaOpenApi");if(d&&b&&d[b]){var f,c=k,b=d[b];for(f in b)f&&b.hasOwnProperty(f)&&"undefined"!=typeof b[f]&&(a[f]=encodeURIComponent(b[f]).toString())}c&&(a.c01=1),f="";for(var g in a)g&&a.hasOwnProperty(g)&&"undefined"!=typeof a[g]&&(f+="&"+g+"="+a[g]);return f=f.slice(1)}},{key:"_unionpreview",value:function(){return c.za()}},{key:"baidu_id",value:a("")},{key:"_orientation",value:function(){return d.ua()}}];return{get:function(a,b){for(var c=[],d=0,e=p.length;e>d;d++){var f;try{var g=p[d],h=g.key,i=g.s,j=g.value,j="function"==typeof j?j(a):j,j=i?encodeURIComponent(j):j;if(b&&b===h)return j;f=h&&0!==h.indexOf("_")?h+"="+j:j}catch(k){f=encodeURIComponent(k.toString()),f=f.slice(0,100)}f&&c.push(f)}return c=c.join("&"),c.slice(0,2048)}}}),D("request",["param","slot","util"],function(a,b,c){return D("request!",[],{name2url:function(b){return"http://cb.baidu.com/ecom?"+a.get({id:b.split(",")})}}),D("batch!",[],{name2url:function(b){return"http://cb.baidu.com/ecom?"+a.get({id:b.split(",")})}}),{send:function(a,d,e){if(!a||!d||e===j)return m;var f=[];if("array"!==c.lang.a(a))b.r(a,"request"),f=["request!"+a];else{for(f=0;f<a.length;f++)b.r(a[f],"request");f=1===a.length?["request!"+a[0]]:["batch!"+a.join(",")]}return z(f,d,e),k}}}),D("control",["slot","request","preview","util"],function(a,b,c,d){function e(b,c,e){var f=c.deps,g=c.data,h=a.X(b);e&&!h?a.i(b,"HolderNotFound"):f&&(0>f[0].indexOf("clb/")&&a.r(b,"finish"),z(f,function(c){if("object"===d.lang.a(g)){if(g.id=b,c.hasOwnProperty("validate"))try{var e=c.validate(g);e!==k&&d.log.F({data:{type:e||"ResponseError",errorPainter:f[0],id:b,slotType:g._stype,materialType:g._isMlt,html:!!g._html}})}catch(i){a.i(b,"validateException")}if(c.hasOwnProperty("render"))try{a.r(b,"render"),c.render(g,h)}catch(j){a.i(b,"RenderException")}else a.i(b,"RenderNotFound")}else a.i(b,"ResponseFormatError")},e))}function f(c,d,f){if(!c)return m;var f=f||"",g=a.add(c),c=g.ids[0]||g.preloadIds[0];if(!c)return m;var h=a.na(c,d);return a.G(c,d),a.create(c,d,f),g.ids.length?b.send(c,function(b){a.P(c,b),e(c,b,h)},h):g.preloadIds.length&&(d=a.w(c).response,e(c,d,h)),k}function g(b){for(var c=0,d=b+"_"+c;0!==a.H([d])[0];){var e=a.w(d);if((e=e&&e.response)&&0===e.deps[0].indexOf("clb/")){var f=e.data,e=f._isMlt;(0===e&&""!==f._html||e===m&&f._fxp)&&a.r(d,"finish",0)}d=b+"_"+ ++c}b!==j&&(b=(c=window.BAIDU_CLB_SLOTS_MAP)&&c[b],b!==j&&(e=b._isMlt,0===e&&""!==b._html||e===m&&b._fxp))&&(b._done=m)}return window.BAIDU_CLB_prepareMoveSlot=g,{fill:function(a){return f(a,"fill")},oa:function(a,b){return f(a,"fillAsync",b)},Ia:function(){function e(c){b.send(c,function(b){if("array"===d.lang.a(b)){if(b&&b.length===c.length)for(var e=0;e<c.length;e++)a.P(c[e],b[e])}else"object"===d.lang.a(b)&&b&&1===c.length&&a.P(c[0],b)},m)}var f=d.lang.j(arguments),f=d.lang.unique(f),g=c.d();if(g)for(var h=0,i=f.length;i>h;h++)f[h]==g.ga&&(f.splice(h,1),h--);for(f=a.add(f).ids;f.length;){for(g=f.splice(0,16),h=0;h<g.length;h++)a.G(g[h],"preload");e(g)}},Ja:g}}),D("global",["control","biz","util","preview"],function(a,b,c){function d(a){return a=a.split("."),i[a[0]]+a[1]}function e(){var a=h.BAIDU_DUP;if("object"!==c.lang.a(a)||!a.push){if("array"===c.lang.a(a)&&a.length)for(var b=0;b<a.length;b++)f(a[b]);h.BAIDU_DUP=j,c.data.k("BAIDU_DUP",{push:f}),c.data.k("BAIDU_DUP_proxy",function(a){return a?function(){try{return f([a].concat(c.lang.j(arguments)))}catch(b){0<o--&&c.log.F({data:{type:"ExecuteException",errorName:a,args:c.lang.j(arguments).join("|"),isQuirksMode:"CSS1Compat"!==document.compatMode,documentMode:document.documentMode||"",readyState:document.readyState||"",message:b.message}})}}:void 0});for(b in q)b&&c.lang.A.call(q,b)&&c.data.k(b,h.BAIDU_DUP_proxy(b));g()}}function f(a){if("array"!==c.lang.a(a))return m;var b=a.shift();return c.data.R("apiCount",b),(b=q[b]||r[b]||m)&&b.apply(l,a)}function g(){function a(a){for(var b=0,c=n.length;c>b;b++)if(0===a.indexOf(n[b]))return k;return m}c.data.k("BAIDU_DUP_require",function(b){for(var c=0,d=b.length;d>c;c++)if(a(b[c]))return;z.apply(l,arguments)}),c.data.k("BAIDU_DUP_define",function(b,c){for(var d=0,e=c.length;e>d;d++)if(a(c[d]))return;D.apply(l,arguments)})}var h=window,i={clb:"BAIDU_CLB_",dan:"BAIDU_DAN_",nova:"cpro"},p=[{f:["clb.fillSlot","clb.singleFillSlot","clb.fillSlotWithSize"],g:["fill"],e:a.fill},{f:["clb.fillSlotAsync"],g:["fillAsync"],e:a.oa},{f:["clb.preloadSlots"],g:["preload"],e:a.Ia},{f:["clb.prepareMoveSlot"],g:["prepareMove"],e:a.Ja},{f:["clb.addOrientation"],g:["addOrientation"],e:b.T},{f:["clb.addOrientationOnce"],g:["addOrientationOnce"],e:b.ja},{f:["clb.setOrientationOnce"],g:["setOrientationOnce"],e:b.Oa},{f:["clb.setConfig"],g:["putConfig"],e:c.data.La},{f:["clb.addSlot","clb.enableAllSlots","clb.SETHTMLSLOT"],g:[],e:c.lang.ca}],p=function(a){for(var b={},c={},e=0;e<a.length;e++){for(var f=a[e],g=f.f,h=f.g,f=f.e;g.length;)b[d(g.shift())]=f;for(;h.length;)c[h.shift()]=f}return{Ga:b,Ka:c}}(p),q=p.Ga,r=p.Ka;return{Aa:function(){var f=c.data.Y(d("clb.ORIENTATIONS"));if(f)for(var g in f)Object.prototype.hasOwnProperty.call(f,g)&&b.T(g,f[g]);a.fill(c.data.Y(d("clb.SLOT_ID"))),e()}}}),D("logService",["util/lang","util/event"],function(a,b){b.bind(window,"load",function(){z(["detect"],a.ca,k)})}),D("fingerprint",["util/storage","util/event","util/browser","util/data","param"],function(a,b,c,d,e){var f=window,g=m;c.o?6<=c.o&&(g=k):a.ka()&&(g=k),g&&(d.d("isFPLoaded",k)===k?g=m:d.q("isFPLoaded",k,k)),g&&b.bind(f,"load",function(){var a=f.document,b=a.body,c="http://pos.baidu.com/wh/o.htm?ltr="+e.get({},"ltr"),d=a.createElement("div");d.id="BAIDU_DUP_fp_wrapper",d.style.position="absolute",d.style.left="-1px",d.style.bottom="-1px",d.style.zIndex=0,d.style.width=0,d.style.height=0,d.style.overflow="hidden",d.style.visibility="hidden",d.style.display="none",a=a.createElement("iframe"),a.id="BAIDU_DUP_fp_iframe",a.src=c,a.style.width=0,a.style.height=0,a.style.visibility="hidden",a.style.display="none";try{d.insertBefore(a,d.firstChild),b&&b.insertBefore(d,b.firstChild)}catch(g){}})}),D("replacement",["util"],function(a){function b(){var c=a.url.L(),d=a.url.Z(c,p,k);return b=function(){return d},d}return{va:function(){return b()}}}),z(["replacement"],function(a){(a=a.va())?z([a]):(z(["global"],function(a){a.Aa()}),z(["logService"]),z(["fingerprint"]))}),window.BAIDU_DUP_define&&window.BAIDU_DUP_define("detect",["api"],function(a){function b(b){b.url="",b.host=window.location.hostname,b.from="DUP",a.sendLog({data:b,Za:"now"})}try{setTimeout(function(){var c,d=a.getSlots();for(c in d){var e=d[c],f=e.response,g=m;if("object"!==a.getType(f))g=k;else{var h,g=k;for(h in f)if(Object.prototype.hasOwnProperty.call(f,h)){g=m;break}}var i=e.status,e=e.stack;g?b({type:"preload"===e[0]?"preloadFail":"loadFail",id:c}):!i.render&&!i.finish&&b({type:"renderFail",id:c,error:"preload"===e[0]?"PreloadNotFilled":"NotFilled",empty:!(!f.data||!f.data._html)})}},0)}catch(c){}}),window.BAIDU_DUP_define&&window.BAIDU_DUP_define("viewWatch",["util","param"],function(a,b){function c(){var b=+new Date,c=500;t===i&&v&&(c=b-v),v=b;for(var e in q)if(p.call(q,e)){t===g&&(t=h);var f=q[e];if(f.u&&(f.N+=c),f.D&&(f.M+=c),f.O=b-f.timestamp,t===i)u&&(f.t+=b-f.C);else if(72e5<=f.O)d(m);else{var k=f=j,l=j;for(l in q)if(p.call(q,l)){var n=q[l];if(u){var r=a.b.c(n.Qa);if(!r)break;try{var s=o.m(x),w=o.l(x),y=o.n(r),z=o.xa(x),A=o.wa(x),B=o.K(r),C=o.J(r),D=y.top-z+.35*C,E=y.left-A+.35*B;n.u=D>0&&w>D&&E>0&&s>E;var F=B*C,G=o.n(r),H=G.top-z,I=G.left-A,J=o.K(r),K=o.J(r),L=r=0,r=0>H?Math.max(H+K,0):Math.min(K,Math.max(w-H,0)),L=0>I?Math.max(I+J,0):Math.min(J,Math.max(s-I,0));f=L,k=r,n.D=k*f>.5*F}catch(M){n.u=m,n.D=m}}else n.u=m,n.D=m}}}}function d(b){clearInterval(s);var d=document.domain.toLowerCase();if(!(-1<d.indexOf("autohome.com.cn")||-1<d.indexOf("sina.com.cn")||-1<d.indexOf("pconline.com.cn")||-1<d.indexOf("pcauto.com.cn")||-1<d.indexOf("pclady.com.cn")||-1<d.indexOf("pcgames.com.cn")||-1<d.indexOf("pcbaby.com.cn")||-1<d.indexOf("pchouse.com.cn")||-1<d.indexOf("xcar.com.cn")))if(t!==h)t=i;else{t=i,c();var f,d=m;for(f in q)if(f&&q.hasOwnProperty(f)&&q[f]){var g=q[f];"block"===g.Ea&&(d=k),g.total=r,a.log.F({url:e(g)})}if(b&&d)if(b=+new Date,l.o)for(d=b+200;d>+new Date;);else{for(f=1e5,d=0;f>d;d++);for(d=+new Date,f=Math.min(200*f/(d-b),1e7),d=0;f>d;d++);}}}function e(a){var c="tu="+a.id,d="word="+b.get(j,"ltu"),e="if="+b.get(j,"dis"),g="aw="+a.width,h="ah="+a.height,i="dt="+Math.round(f/1e3),k="pt="+a.O,l=new Date(a.timestamp),m="yyyyMMddhhmmssS",n={"M+":l.getMonth()+1,"d+":l.getDate(),"h+":0===l.getHours()%12?12:l.getHours()%12,"H+":l.getHours(),"m+":l.getMinutes(),"s+":l.getSeconds(),"q+":Math.floor((l.getMonth()+3)/3),S:l.getMilliseconds()},o={0:"日",1:"一",2:"二",3:"三",4:"四",5:"五",6:"六"},p=/(y+)/,q=m.match(p);q&&(m=m.replace(p,(l.getFullYear()+"").substr(4-q[0].length))),p=/(E+)/,(q=m.match(p))&&(q=q[0].length,m=m.replace(p,(q>1?q>2?"星期":"周":"")+o[l.getDay()+""]));for(var r in n)n.hasOwnProperty(r)&&(l=RegExp("("+r+")"),(o=m.match(l))&&(m=m.replace(l,1===o[0].length?n[r]:("00"+n[r]).substr((""+n[r]).length))));for(c=[c,d,e,g,h,i,k,"ps="+m,"it="+a.N,"vs="+(a.u?1:0),"vt="+a.M,"ft="+a.t,"op="+a.opacity,"csp="+w,"bcl="+a.ma,"pof="+a.Na,"top="+a.top,"left="+a.left,"fs=1","total="+a.total],d=0;2>d&&y.length;)e=y.pop(),c.push("lvu"+d+"="+e.url),c.push("lvt"+d+"="+e.time),d++;return a.url+(a.W?a.W+"&":"")+c.join("&")}var f=+new Date,g=1,h=2,i=3,l=a.U,n=a.event.bind,o=a.style,p=a.lang.A,q=[],r=0,s=0,t=g,u=k,v=0,w=[1e4<screen.availWidth?0:screen.availWidth,1e4<screen.availHeight?0:screen.availHeight].join(),x=window;a.b.p(window)&&!a.b.B(window)&&(x=window.top),s=setInterval(c,500),function(){function a(){var a,b=+new Date;for(a in q)if(p.call(q,a)){var c=q[a];c.t+=b-c.C,c.C=b}u=m}function b(){var a,b=+new Date;for(a in q)p.call(q,a)&&(q[a].C=b);u=k}l.o?(n(document,"focusin",b),n(document,"focusout",a)):(n(window,"focus",b),n(window,"blur",a))}(),function(){function a(a){(a=(a.target||a.srcElement).href)&&(y.push({url:encodeURIComponent(a),time:+new Date}),10<y.length&&y.shift())}n(document,"click",a),x!=window&&n(x.document,"click",a)}(),n(window,"beforeunload",d);var y=[];return{register:function(b){var c=+new Date,d=b.id,e=b.wrapperId,f=b.url||"http://eclick.baidu.com/a.js?",g=b.logType||"storage",b=b.extra||"";if(e&&!q[e]){var h=a.b.c(e);if(h){var i=o.n(h);q[e]={id:d,Qa:e,url:f,Ea:g,W:b,timestamp:c,N:0,u:m,M:0,D:m,O:0,t:0,C:c,top:i.top,left:i.left,bb:w,opacity:o.ta(h),ma:[o.m(),o.l()].join(),Na:[o.aa(),o.$()].join(),width:o.K(h),height:o.J(h)},r++}}},getWatchCount:function(){return r}}})}();