/*! aikuaike 0.1.0 2014-09-28 */
define("clib/verify.code",[],function(){$(".verify-code-change").on("click",function(){var a=$(this),b=$(a.data("ref")),c=b.data("src"),d=(new Date).getTime()+"";b.attr("src",c+d)}),$(".verify-code-input").one("focus",function(){var a=$(this),b=$(a.data("ref")),c=b.data("src"),d=(new Date).getTime()+"";b.attr("src",c+d)}).val("")});