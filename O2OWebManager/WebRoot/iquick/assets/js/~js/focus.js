/*! aikuaike 0.1.0 2014-09-28 */
function showContent(a){var b=document.getElementById("list"+current.toString()),c=document.getElementById("showCon"+current.toString()),d=document.getElementById("list"+a.toString()),e=document.getElementById("showCon"+a.toString());current!=a&&(b.className=" ",c.style.display="none",current=a,d.className="on",e.style.display="block")}function setMode(a){null!=a&&(imgNum=a+1)}function showTime(){imgNum>3&&(imgNum=0),showContent(imgNum),imgNum++}var current=0,imgNum=1,interval=0;setMode();