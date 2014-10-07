/*! aikuaike 0.1.0 2014-09-28 */
define("clib/cart.extend",["clib/network","clib/template","clib/json2"],function(a,b){var c=a("clib/network"),d=a("clib/template"),e=a("clib/json2");IQ.cart||(IQ.cart={order:"",getcart:"",collect:"",remove:"",add:""});var f=d.parse('<form action="<{= url }>" method="post">				      				<input type="hidden" name="items" value="<{- items }>">				      				<input type="hidden" name="token" value="<{= token }>">				    			</form>');b.postOrder=function(a,b){a instanceof Array||(a=[a]),a=e.stringify(a);var c=$(f({items:a,url:IQ.cart.order,token:b})).hide();$("body").append(c),c.submit()},b.collectIn=function(a,b,d){"function"!=typeof d&&(d=b),a instanceof Array&&(a={itemIds:e.stringify(a)}),c.post(IQ.cart.collect,function(){g(b,!0)},function(){g(d,!1)},{data:a})},b.removeIn=function(a,b,d){"function"!=typeof d&&(d=b),a instanceof Array&&(a={itemIds:e.stringify(a)}),c.post(IQ.cart.remove,function(){g(b,!0)},function(){g(d,!1)},{data:a})},b.addItem=function(a,b,d){"function"!=typeof d&&(d=b),"object"==typeof a&&c.post(IQ.cart.add,function(){g(b,!0)},function(){g(d,!1)},{data:a})};var g=function(a,b){"function"==typeof a&&a(b)}}),define("clib/network",[],function(a,b){var c={url:"",type:"GET",dataType:"json",timeout:6e4},d=function(a,b,d){return d="object"==typeof a?$.extend({},c,a):"object"==typeof b?$.extend({},c,b):$.extend({},c,d),d.success=function(b){"function"==typeof a&&a(b)},d.error=function(a){"function"==typeof b&&b(a)},d};b.get=function(a,b,c,e){e=d(b,c,e),e.url=a,$.ajax(e)},b.post=function(a,b,c,e){e=d(b,c,e),e.url=a,e.type="POST",$.ajax(e)},b.script=function(a,b,c,e){e=d(b,c,e),e.url=a,e.dataType="script",$.ajax(e)},b.text=function(a,b,c,e){e=d(b,c,e),e.url=a,e.dataType="text",$.ajax(e)}}),define("clib/template",[],function(a,b){var c={evaluate:/<{([\s\S]+?)}>/g,interpolate:/<{=([\s\S]+?)}>/g,escape:/<{-([\s\S]+?)}>/g},d=/(.)^/,e={"'":"'","\\":"\\","\r":"r","\n":"n","\u2028":"u2028","\u2029":"u2029"},f=/\\|'|\r|\n|\u2028|\u2029/g,g={"&":"&amp;","<":"&lt;",">":"&gt;",'"':"&quot;","'":"&#x27;","`":"&#x60;"},h={"&amp;":"&","&lt;":"<","&gt;":">","&quot;":'"',"&#x27;":"'","&#x60;":"`"},i=["&","<",">",'"',"'","`"],j=["&amp;","&lt;","&gt;","&quot;","&#x27;","&#x60;"],k=function(a,b){var c=function(b){return a[b]},d="(?:"+b.join("|")+")",e=RegExp(d),f=RegExp(d,"g");return function(a){return a=null==a?"":""+a,e.test(a)?a.replace(f,c):a}},l=function(a){return"\\"+e[a]},m={};m.escape=k(g,i),m.unescape=k(h,j),b.parse=function(a){var b=c,e=RegExp([(b.escape||d).source,(b.interpolate||d).source,(b.evaluate||d).source].join("|")+"|$","g"),g=0,h="__p+='";a.replace(e,function(b,c,d,e,i){return h+=a.slice(g,i).replace(f,l),g=i+b.length,c?h+="'+\n((__t=("+c+"))==null?'':template.escape(__t))+\n'":d?h+="'+\n((__t=("+d+"))==null?'':__t)+\n'":e&&(h+="';\n"+e+"\n__p+='"),b}),h+="';\n",h="with(data){\n"+h+"}\n",h="var __t,__p='',__j=Array.prototype.join,print=function(){__p+=__j.call(arguments,'');};\n"+h+"return __p;\n";try{var i=new Function("data","template",h)}catch(j){throw j.source=h,j}var k=function(a){return i.call(this,a,m)};return k},b.escape=m.escape,b.unescape=m.unescape}),define("clib/json2",[],function(require,exports){function f(a){return 10>a?"0"+a:a}function quote(a){return escapable.lastIndex=0,escapable.test(a)?'"'+a.replace(escapable,function(a){var b=meta[a];return"string"==typeof b?b:"\\u"+("0000"+a.charCodeAt(0).toString(16)).slice(-4)})+'"':'"'+a+'"'}function str(a,b){var c,d,e,f,g,h=gap,i=b[a];switch(i&&"object"==typeof i&&"function"==typeof i.toJSON&&(i=i.toJSON(a)),"function"==typeof rep&&(i=rep.call(b,a,i)),typeof i){case"string":return quote(i);case"number":return isFinite(i)?String(i):"null";case"boolean":case"null":return String(i);case"object":if(!i)return"null";if(gap+=indent,g=[],"[object Array]"===Object.prototype.toString.apply(i)){for(f=i.length,c=0;f>c;c+=1)g[c]=str(c,i)||"null";return e=0===g.length?"[]":gap?"[\n"+gap+g.join(",\n"+gap)+"\n"+h+"]":"["+g.join(",")+"]",gap=h,e}if(rep&&"object"==typeof rep)for(f=rep.length,c=0;f>c;c+=1)"string"==typeof rep[c]&&(d=rep[c],e=str(d,i),e&&g.push(quote(d)+(gap?": ":":")+e));else for(d in i)Object.prototype.hasOwnProperty.call(i,d)&&(e=str(d,i),e&&g.push(quote(d)+(gap?": ":":")+e));return e=0===g.length?"{}":gap?"{\n"+gap+g.join(",\n"+gap)+"\n"+h+"}":"{"+g.join(",")+"}",gap=h,e}}var JSON={};"function"!=typeof Date.prototype.toJSON&&(Date.prototype.toJSON=function(){return isFinite(this.valueOf())?this.getUTCFullYear()+"-"+f(this.getUTCMonth()+1)+"-"+f(this.getUTCDate())+"T"+f(this.getUTCHours())+":"+f(this.getUTCMinutes())+":"+f(this.getUTCSeconds())+"Z":null},String.prototype.toJSON=Number.prototype.toJSON=Boolean.prototype.toJSON=function(){return this.valueOf()});var cx,escapable,gap,indent,meta,rep;"function"!=typeof JSON.stringify&&(escapable=/[\\\"\x00-\x1f\x7f-\x9f\u00ad\u0600-\u0604\u070f\u17b4\u17b5\u200c-\u200f\u2028-\u202f\u2060-\u206f\ufeff\ufff0-\uffff]/g,meta={"\b":"\\b","	":"\\t","\n":"\\n","\f":"\\f","\r":"\\r",'"':'\\"',"\\":"\\\\"},JSON.stringify=function(a,b,c){var d;if(gap="",indent="","number"==typeof c)for(d=0;c>d;d+=1)indent+=" ";else"string"==typeof c&&(indent=c);if(rep=b,b&&"function"!=typeof b&&("object"!=typeof b||"number"!=typeof b.length))throw new Error("JSON.stringify");return str("",{"":a})}),"function"!=typeof JSON.parse&&(cx=/[\u0000\u00ad\u0600-\u0604\u070f\u17b4\u17b5\u200c-\u200f\u2028-\u202f\u2060-\u206f\ufeff\ufff0-\uffff]/g,JSON.parse=function(text,reviver){function walk(a,b){var c,d,e=a[b];if(e&&"object"==typeof e)for(c in e)Object.prototype.hasOwnProperty.call(e,c)&&(d=walk(e,c),void 0!==d?e[c]=d:delete e[c]);return reviver.call(a,b,e)}var j;if(text=String(text),cx.lastIndex=0,cx.test(text)&&(text=text.replace(cx,function(a){return"\\u"+("0000"+a.charCodeAt(0).toString(16)).slice(-4)})),/^[\],:{}\s]*$/.test(text.replace(/\\(?:["\\\/bfnrt]|u[0-9a-fA-F]{4})/g,"@").replace(/"[^"\\\n\r]*"|true|false|null|-?\d+(?:\.\d*)?(?:[eE][+\-]?\d+)?/g,"]").replace(/(?:^|:|,)(?:\s*\[)+/g,"")))return j=eval("("+text+")"),"function"==typeof reviver?walk({"":j},""):j;throw new SyntaxError("JSON.parse")}),exports.stringify=JSON.stringify,exports.parse=JSON.parse});