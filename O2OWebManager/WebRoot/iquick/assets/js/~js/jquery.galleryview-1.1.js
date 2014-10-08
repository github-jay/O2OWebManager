/*! aikuaike 0.1.0 2014-09-28 */
!function(a){a.fn.galleryView=function(b){function c(b){if(a("img.nav-next").unbind("click"),a("img.nav-prev").unbind("click"),t.unbind("click"),has_panels&&w.fade_panels&&u.fadeOut(w.transition_speed).eq(b%z).fadeIn(w.transition_speed,function(){has_filmstrip||(a("img.nav-prev").click(e),a("img.nav-next").click(d))}),has_filmstrip){if("strip"==p){s.stop();var c=f(t[b]).left-(f(v[0]).left+2),h=(c>=0?"-=":"+=")+Math.abs(c)+"px";s.animate({left:h},w.transition_speed,w.easing,function(){b>z?(b%=z,x=b,s.css("left","-"+(w.frame_width+y)*b+"px")):z-strip_size>=b&&(b=b%z+z,x=b,s.css("left","-"+(w.frame_width+y)*b+"px")),w.fade_panels||u.hide().eq(b%z).show(),a("img.nav-prev").click(e),a("img.nav-next").click(d),g()})}else if("pointer"==p){v.stop();var i=f(t[b]);v.animate({left:i.left-2+"px"},w.transition_speed,w.easing,function(){w.fade_panels||u.hide().eq(b%z).show(),a("img.nav-prev").click(e),a("img.nav-next").click(d),g()})}a("a",t[b])[0]&&v.unbind("click").click(function(){var c=a("a",t[b]).eq(0);"_blank"==c.attr("target")?window.open(c.attr("href")):location.href=c.attr("href")})}}function d(){a(document).stopTime("transition"),++x==t.length&&(x=0),c(x),a(document).everyTime(w.transition_interval,"transition",function(){d()})}function e(){a(document).stopTime("transition"),--x<0&&(x=z-1),c(x),a(document).everyTime(w.transition_interval,"transition",function(){d()})}function f(a){var b=0,c=0,d=a.id;if(a.offsetParent)do b+=a.offsetLeft,c+=a.offsetTop;while(a=a.offsetParent);if(d==k)return{left:b,top:c};var e=f(r[0]),g=e.left,h=e.top;return{left:b-g,top:c-h}}function g(){t.each(function(b){0==a("a",this).length&&a(this).click(function(){a(document).stopTime("transition"),c(b),x=b,a(document).everyTime(w.transition_interval,"transition",function(){d()})})})}function h(){a(".panel-overlay").length>0&&u.append('<div class="overlay"></div>'),has_filmstrip||(a("<img />").addClass("nav-next").attr("src",q+w.nav_theme+"/next.png").appendTo(r).css({position:"absolute",zIndex:"1100",cursor:"pointer",top:(w.panel_height-22)/2+"px",right:"10px",display:"none"}).click(d),a("<img />").addClass("nav-prev").attr("src",q+w.nav_theme+"/prev.png").appendTo(r).css({position:"absolute",zIndex:"1100",cursor:"pointer",top:(w.panel_height-22)/2+"px",left:"10px",display:"none"}).click(e),a("<img />").addClass("nav-overlay").attr("src",q+w.nav_theme+"/panel-nav-next.png").appendTo(r).css({position:"absolute",zIndex:"1099",top:(w.panel_height-22)/2-10+"px",right:"0",display:"none"}),a("<img />").addClass("nav-overlay").attr("src",q+w.nav_theme+"/panel-nav-prev.png").appendTo(r).css({position:"absolute",zIndex:"1099",top:(w.panel_height-22)/2-10+"px",left:"0",display:"none"})),u.css({width:w.panel_width-parseInt(u.css("paddingLeft").split("px")[0],10)-parseInt(u.css("paddingRight").split("px")[0],10)+"px",height:w.panel_height-parseInt(u.css("paddingTop").split("px")[0],10)-parseInt(u.css("paddingBottom").split("px")[0],10)+"px",position:"absolute",top:"top"==w.filmstrip_position?w.frame_height+C+(w.show_captions?B:C)+"px":"0px",left:"0px",overflow:"hidden",background:"white",display:"none"}),a(".panel-overlay",u).css({position:"absolute",zIndex:"999",width:w.panel_width-20+"px",height:w.overlay_height+"px",top:"top"==w.overlay_position?"0":w.panel_height-w.overlay_height+"px",left:"0",padding:"0 10px",color:w.overlay_text_color,fontSize:w.overlay_font_size}),a(".panel-overlay a",u).css({color:w.overlay_text_color,textDecoration:"underline",fontWeight:"bold"}),a(".overlay",u).css({position:"absolute",zIndex:"998",width:w.panel_width+"px",height:w.overlay_height+"px",top:"top"==w.overlay_position?"0":w.panel_height-w.overlay_height+"px",left:"0",background:w.overlay_color,opacity:w.overlay_opacity}),a(".panel iframe",u).css({width:w.panel_width+"px",height:w.panel_height-w.overlay_height+"px",border:"0"})}function i(){s.wrap('<div class="strip_wrapper"></div>'),"strip"==p&&(t.clone().appendTo(s),t.clone().appendTo(s),t=a("li",s)),w.show_captions&&t.append('<div class="caption"></div>').each(function(){a(this).find(".caption").html(a(this).find("img").attr("title"))}),s.css({listStyle:"none",margin:"0",padding:"0",width:n+"px",position:"absolute",zIndex:"900",top:"0",left:"0",height:w.frame_height+10+"px",background:w.background_color}),t.css({"float":"left",position:"relative",height:w.frame_height+"px",zIndex:"901",marginTop:C+"px",marginBottom:"0px",marginRight:y+"px",padding:"0",cursor:"pointer"}),a("img",t).css({border:"none"}),a(".strip_wrapper",r).css({position:"absolute",top:"top"==w.filmstrip_position?"0px":w.panel_height+"px",left:(l-o)/2+"px",width:o+"px",height:w.frame_height+C+(w.show_captions?B:C)+"px",overflow:"hidden"}),a(".caption",r).css({position:"absolute",top:w.frame_height+"px",left:"0",margin:"0",width:w.frame_width+"px",padding:"0",color:w.caption_text_color,textAlign:"center",fontSize:"10px",height:B+"px",lineHeight:B+"px"});var b=a("<div></div>");if(b.attr("id","pointer").appendTo(r).css({position:"absolute",zIndex:"1000",cursor:"pointer",top:f(t[0]).top-D/2+"px",left:f(t[0]).left-D/2+"px",height:w.frame_height-D+"px",width:w.frame_width-D+"px",border:has_panels?D+"px solid "+("dark"==w.nav_theme?"black":"white"):"none"}),v=a("#pointer",r),has_panels){var c=a("<img />");c.attr("src",q+w.nav_theme+"/pointer"+("top"==w.filmstrip_position?"-down":"")+".png").appendTo(a("#pointer")).css({position:"absolute",zIndex:"1001",top:"bottom"==w.filmstrip_position?"-"+(10+D)+"px":w.frame_height+"px",left:w.frame_width/2-10+"px"})}"strip"==p&&(s.css("left","-"+(w.frame_width+y)*z+"px"),x=z),a("a",t[x])[0]&&v.click(function(){var b=a("a",t[x]).eq(0);"_blank"==b.attr("target")?window.open(b.attr("href")):location.href=b.attr("href")}),a("<img />").addClass("nav-next").attr("src",q+w.nav_theme+"/next.png").appendTo(r).css({position:"absolute",cursor:"pointer",top:("top"==w.filmstrip_position?0:w.panel_height)+C+(w.frame_height-22)/2+"px",right:l/2-o/2-10-22+"px"}).click(d),a("<img />").addClass("nav-prev").attr("src",q+w.nav_theme+"/prev.png").appendTo(r).css({position:"absolute",cursor:"pointer",top:("top"==w.filmstrip_position?0:w.panel_height)+C+(w.frame_height-22)/2+"px",left:l/2-o/2-10-22+"px"}).click(e)}function j(a,b){var c=f(r[0]),d=c.top,e=c.left;return a>e&&a<e+w.panel_width&&b>d&&b<d+w.panel_height}var k,l,m,n,o,p,q,r,s,t,u,v,w=a.extend(a.fn.galleryView.defaults,b),x=0,y=10,z=0,A=!1,B=20,C=5,D=2;return this.each(function(){r=a(this),a("script").each(function(){var b=a(this);b.attr("src")&&b.attr("src").match(/jquery\.galleryview/)&&(q=b.attr("src").split("jquery.galleryview")[0]+"themes/")}),r.css("visibility","hidden"),s=a(".filmstrip",r),t=a("li",s),u=a(".panel",r),k=r.attr("id"),has_panels=u.length>0,has_filmstrip=t.length>0,has_panels||(w.panel_height=0),z=has_panels?u.length:t.length,strip_size=has_panels?Math.floor((w.panel_width-64)/(w.frame_width+y)):Math.min(z,w.filmstrip_size),strip_size>=z?(p="pointer",strip_size=z):p="strip",l=has_panels?w.panel_width:strip_size*(w.frame_width+y)-y+64,m=(has_panels?w.panel_height:0)+(has_filmstrip?w.frame_height+C+(w.show_captions?B:C):0),n="pointer"==p?w.frame_width*z+y*z:w.frame_width*z*3+3*y*z,o=strip_size*w.frame_width+(strip_size-1)*y,r.css({position:"relative",margin:"0",background:w.background_color,border:w.border,width:l+"px",height:m+"px"}),has_filmstrip&&i(),has_panels&&h(),has_filmstrip&&g(),a().mousemove(function(b){j(b.pageX,b.pageY)?(w.pause_on_hover&&a(document).oneTime(500,"animation_pause",function(){a(document).stopTime("transition"),A=!0}),has_panels&&!has_filmstrip&&(a(".nav-overlay").fadeIn("fast"),a(".nav-next").fadeIn("fast"),a(".nav-prev").fadeIn("fast"))):(w.pause_on_hover&&(a(document).stopTime("animation_pause"),A&&(a(document).everyTime(w.transition_interval,"transition",function(){d()}),A=!1)),has_panels&&!has_filmstrip&&(a(".nav-overlay").fadeOut("fast"),a(".nav-next").fadeOut("fast"),a(".nav-prev").fadeOut("fast")))}),u.eq(0).show(),z>1&&a(document).everyTime(w.transition_interval,"transition",function(){d()}),r.css("visibility","visible")})},a.fn.galleryView.defaults={panel_width:400,panel_height:300,frame_width:80,frame_height:80,filmstrip_size:3,overlay_height:70,overlay_font_size:"1em",transition_speed:400,transition_interval:6e3,overlay_opacity:.6,overlay_color:"black",background_color:"black",overlay_text_color:"white",caption_text_color:"white",border:"1px solid black",nav_theme:"light",easing:"swing",filmstrip_position:"bottom",overlay_position:"bottom",show_captions:!1,fade_panels:!0,pause_on_hover:!1}}(jQuery);