$(function(){var a=$("[data-shafa-focus='auto']");a.focus()}),$(function(){function a(){var a=$("[data-shafa-loop='fade']"),t=$("[data-shafa-loop='item']",a),e=$(".active[data-shafa-loop='item']",a),s=e.index(),i=s+1,o=t.length;i==o&&(i=0),e.removeClass("in"),setTimeout(function(){e.removeClass("active")},600),t.eq(i).addClass("active"),setTimeout(function(){t.eq(i).addClass("in")},100)}function t(){var a=$("[data-shafa-loop='fadeTab']"),t=$("[data-shafa-loop='item']",a),e=t.length,s=$(".active[data-shafa-loop='item']",a),i=s.index(),o="#"+s.attr("id"),n=i+1;n==e&&(n=0);var r=t.eq(n),l="#"+r.attr("id");s.removeClass("in active"),$("[href='"+o+"'][data-shafa-tab]",a).parent().removeClass("active"),r.addClass("in active"),$("[href='"+l+"'][data-shafa-tab]",a).parent().addClass("active")}$("[data-shafa-loop='fade']").length>0&&setInterval(a,4e3),$("[data-shafa-loop='fadeTab']").length>0&&setInterval(t,5e3)}),$(function(){$("[data-shafa-tab='hover']").bind({click:function(a){a.preventDefault()},mouseenter:function(){var a=$(this).attr("href");$(a).siblings().removeClass("in active"),$(a).addClass("in active"),$(this).parent().siblings().removeClass("active"),$(this).parent().addClass("active")}})}),$(function(){function a(a){return!1}var t=$("[data-shafa-download='secure']");t.each(function(){a($(this))})}),$(function(){!function(){function a(a){var t=a.attr("href"),e=a.text();o.val(e),p.hide(),m.addClass("active"),C.removeClass("active"),$(t).addClass("active"),u.addClass("active"),i.removeClass("open")}function t(t){n.removeClass("active"),l.addClass("active"),d.text(t),h.each(function(){var e=$(this).attr("href"),s=e.substr(7),i=s.search(new RegExp(t,"i")),o=$("[href='"+e+"'][data-shafa-tutorial='item']",c);0===i&&0===o.length&&$(this).clone().appendTo(c).click(function(t){t.preventDefault(),a($(this))})}),$("[data-shafa-tutorial='item']",c).each(function(){$(this).attr("href").substr(7).search(new RegExp(t,"i"))<0&&$(this).remove()})}var e=$("[data-shafa-tutorial='pinyin']"),s=$("[data-shafa-tutorial='dismiss']",e),i=$("[data-shafa-tutorial='brands']",e),o=$("[data-shafa-tutorial='input']",i),n=$("[data-shafa-tutorial='group']",i),r=$("[data-shafa-tutorial='tab']",n),l=$("[data-shafa-tutorial='search']",i),d=$("[data-shafa-tutorial='keywords']",i),c=$("[data-shafa-tutorial='results']",i),h=$("[data-shafa-tutorial='item']",n),f=$("[data-shafa-tutorial='models']",e),v=$("[data-shafa-tutorial='button']",f),u=$("[data-shafa-tutorial='content']",f),m=$("[data-shafa-tutorial='input']",f),p=$("[data-shafa-tutorial='tips']",f),C=$("[data-shafa-tutorial='model']",f);o.bind({click:function(){f.removeClass("open"),i.addClass("open"),u.removeClass("active"),c.empty()},keyup:function(){var a=$(this).val().toLowerCase(),e=/^[a-zA-Z0-9!"\[\]{}%^&*:@~#';\/.<>\\|`_-]+$/;if(""==a)n.addClass("active"),l.removeClass("active"),c.empty();else if(/^[a-zA-Z]+$/.test(a.substr(0,1))){var s="";e.test(a)?s=a:$.ajax({type:"GET",url:$(this).attr("data-url"),data:{data:a}}).done(function(a){a.success&&(s=a.data)}),t(s)}}}),v.click(function(){""==o.val()&&(m.removeClass("active"),C.removeClass("active"),p.show()),i.removeClass("open")}),m.keyup(function(){var a=$(".active[data-shafa-tutorial]",f),t=$("[data-shafa-tutorial='modelItem']",a),e=$(this).val().toLowerCase();""==e?t.show():t.each(function(){var a=$(this).text();a.search(new RegExp(e,"i"))>=0?$(this).show():$(this).hide()})}),h.click(function(t){t.preventDefault(),a($(this))}),r.click(function(a){a.preventDefault(),$(this).tab("show")}),s.click(function(){$(this).parent(i).length>0&&i.removeClass("open"),$(this).parent(u).length>0&&u.removeClass("active")})}(),function(){var a=$("[data-shafa-tutorial='list']"),t=$("[data-shafa-tutorial='selector']",a),e=$("[data-shafa-tutorial='item']",a),s=$("[data-shafa-tutorial='brand']",a),i=$("[data-shafa-tutorial='models']",a);t.click(function(a){a.preventDefault();var s=$(this).attr("href");e.removeClass("hide active"),t.removeClass("active"),$(this).addClass("active"),e.each(function(){var a="#"+$(this).attr("id");return a==s?($(this).addClass("active"),!1):void $(this).addClass("hide")})}),s.click(function(a){a.preventDefault();var t=$(this).attr("href");s.removeClass("active"),i.removeClass("show"),e.removeClass("active"),$(this).parents(e).addClass("active"),$(t).addClass("show"),$(this).addClass("active")})}(),function(){function a(){$("[data-shafa-tutorial='item'][value='default']",o).prop("selected",!0),$("[data-shafa-tutorial='item'][value='default']",i).prop("selected",!0)}var t=$("[data-shafa-tutorial='select']"),e=$("[data-shafa-tutorial='submit']",t),s=$("[data-shafa-tutorial='tmp']",t),i=$("[data-shafa-tutorial='brands']",t),o=$("[data-shafa-tutorial='models']",t),n=$("[data-shafa-tutorial='item']",o);$("[data-shafa-tutorial='common']",o);i.change(function(){var a=$(this).val();n.prop("selected",!1),"default"==a?($("option",s).prependTo(o),$("[data-shafa-tutorial='item'][value='default']",o).prop("selected",!0)):"common"==a?n.appendTo(s):($("option",s).insertBefore($("[data-shafa-tutorial='common']",o)),n.each(function(){var t=$(this).data("value");t!=a&&$(this).appendTo(s)}))}),o.change(function(){var t=$(this).val();if("default"==t)a();else{var e=$("[data-shafa-tutorial='item'][value='"+t+"']",o).data("value");window.location.href=t,$("[data-shafa-tutorial='item'][value='"+e+"']",i).prop("selected",!0),ga("send","event","typeSelect","listChange",t)}}),e.click(function(){var a=o.val();return"default"==a?!1:void $(this).attr("href",a)})}()}),$(function(){!function(){var a=$("[data-shafa-collapse='accordion']");a.mouseenter(function(){$(this).siblings(a).removeClass("active"),$(this).addClass("active")})}(),function(){var a=$("[data-shafa-collapse='collapseObject']"),t=a.height(),e=a.data("limit-height"),s=$("[data-shafa-collapse='button']");t>e&&(a.addClass("collapse"),s.parent().show()),s.click(function(a){a.preventDefault();var t=$(this).attr("href");$(t).hasClass("collapse")?($(t).removeClass("collapse"),$(this).html('收起 <i class="fa fa-angle-up"></i>')):($(t).addClass("collapse"),$(this).html('展开 <i class="fa fa-angle-down"></i>'))})}()}),$(function(){function a(a,t,e,s){$.getJSON("http://"+a+"/interface?mod=install_app&data="+t+"&callback=?",function(a){1==a.success&&(4!=r.data("status")&&($("[data-shafa-remote]",r).removeClass("active"),$("[data-shafa-remote='success']",r).addClass("active")),$("[data-shafa-remote='success']",r).html("<p>已推送"+e+"到"+s+"安装</p>").data("status","4"),ga("send","event","installMarket","install"),$.getScript("http://stats.shafa.com/i/app?id="+t),$.getScript("http://stats.shafa.com/i/app_web_download?id="+t))})}function t(t,e,s,i){e?a(t,e,s,i):$(".app-id").each(function(){a(t,$(this).val(),"全部应用",i)})}function e(a,e,s,i){if(-1!=$.inArray(a,l))return!1;var o=$("<button/>").addClass("btn btn-primary remote-install").data("host",a).html(i).click(function(){t($(this).data("host"),e,s,i)});2!=r.data("status")&&(r.data("status",2),$("[data-shafa-remote]",r).removeClass("active"),$("[data-shafa-remote='list']",r).addClass("active")),$("[data-shafa-remote='list']",r).append(o),l.push(a)}function s(a,s){var i=Date.parse(new Date)/1e3,o=i-a.request_time;if(o>86400)$.getJSON("http://app.shafa.com/api/WebController/remove_device?ip="+encodeURIComponent(a.ip)+"&callback=?");else{var r=a.ip+":"+a.port;$.getJSON("http://"+r+"/interface?mod=ping&data=null&callback=?",function(a){d++,$.getJSON("http://"+r+"/interface?mod=device_info&data=null&callback=?",function(a){var i=a.data.device_name,o=n.data("app-id"),l=n.data("app-title");1==s?t(r,o,l,i):e(r,o,l,i)})})}}function i(){var a=setInterval(function(a){var t=r.data("status");if(0===t){var e="http://app.shafa.com/api/WebController/device_list?&hw="+encodeURIComponent(a)+"&callback=?";$.getJSON(e,function(a){if(0===a.code){a=$.parseJSON(a.msg);var t=a.devices.length;if(1==t)s(a.devices[0],t);else for(var e in a.devices)s(a.devices[e],t)}})}},5e3);$("#remoteInstall").on("show.bs.modal",function(a){$(this).data("app-id",$(a.relatedTarget).data("app-id")).data("app-title",$(a.relatedTarget).data("app-title"))}).on("hidden.bs.modal",function(){clearInterval(a),r.data("status",0),$("[data-shafa-remote]",r).removeClass("active"),$("[data-shafa-remote='searching']",r).addClass("active")}),setTimeout(function(){clearInterval(a),0===d&&(r.data("status",1),$("[data-shafa-remote]",r).removeClass("active"),$("[data-shafa-remote='notFound']",r).addClass("active"))},8e3)}function o(){r.data("status",0),$("[data-shafa-remote]",r).removeClass("active"),$("[data-shafa-remote='searching']",r).addClass("active"),i()}var n=$("#remoteInstall"),r=$("[data-shafa-remote='devices']"),l=[],d=0;$("[data-shafa-remote='button']").click(function(){i($(this).data("hw"))}).tooltip(),$("[data-shafa-remote='refresh']").click(function(){o()})}),$(function(){var a=$("[data-intro='indicator']");a.click(function(){var a=$(this).data("target"),t=$(this).data("interval-part"),e=$("[data-interval='"+a+"']");$("[data-interval-part]",e).removeClass("active"),$("[data-interval-part='"+t+"']",e).each(function(){$(this).addClass("active")})});var t=$("[data-interval='banner']"),e=t.data("times");setInterval(function(){var a=$(".active[data-indicator-target='banner']"),s=a.data("interval-part"),i=s+1;i==e&&(i=0),$("[data-interval-part]",t).removeClass("active"),$("[data-interval-part='"+i+"']",t).each(function(){$(this).addClass("active")})},5e3);var s=$("[data-intro='carouselControl']",t);s.click(function(a){a.preventDefault();var s,i=$(this).data("slide-to"),o=$(".active[data-indicator-target='banner']"),n=o.data("interval-part");"prev"==i?(s=n-1,0>s&&(s=e-1)):"next"==i&&(s=n+1,s==e&&(s=0)),$("[data-interval-part]",t).removeClass("active"),$("[data-interval-part='"+s+"']",t).each(function(){$(this).addClass("active")})});var i=$("[data-intro='bannerLog']"),o=$("[data-intro='logPopover']");i.hover(function(){o.addClass("in"),o.css("display","block")},function(){o.removeClass("in"),o.css("display","none")});var n=$("[data-intro='middleNav']"),r=n.height(),l=$("[data-middle-nav]"),d=n.data("position"),c=n.data("top"),h=n.data("height"),f=n.data("option"),v=c+h*l.length-r+f;l.click(function(){var a=$(this).data("middle-nav"),t=c+a*h;"above"==d&&(t-=r),0===a&&(t=c),$("body").animate({scrollTop:t})}),$(document).scroll(function(){var a=$(document).scrollTop(),t=Math.floor((a-c+r-f)/h);if(a>=745?$("#problemCarousel").carousel():$("#problemCarousel").carousel("pause"),a>=c&&v>=a?n.addClass("fixed"):n.removeClass("fixed"),t>=0&&(l.removeClass("active"),$("[data-middle-nav='"+t+"']").addClass("active")),0===t&&($("#themeCarousel").carousel(),$("#appsCarousel").carousel()),1==t){var e=0;if("0%"===$("[data-intro='numIncrease']").text()){var s=setInterval(function(){e++,100>=e&&$("[data-intro='numIncrease']").text(e+"%")},10);setTimeout(function(){clearInterval(s)},1500)}$("[data-intro='rotateRocket']").addClass("clear-image-rotate")}3==t&&$("#extraCarousel").carousel()}),$("#themeCarousel").on("slide.bs.carousel",function(a){var t=a.relatedTarget.dataset.item;$("[data-middle-nav='0']").removeClass("item-bg-0 item-bg-1 item-bg-2"),$("[data-middle-nav='0']").addClass("item-bg-"+t)}),$("#extraCarousel").on("slide.bs.carousel",function(a){var t=a.relatedTarget.dataset.item;$("[data-middle-nav='3']").removeClass("item-bg-0 item-bg-1"),$("[data-middle-nav='3']").addClass("item-bg-"+t)});var u=$("[data-intro='carouselControl']");u.click(function(a){a.preventDefault();var t=$(this).data("slide-to"),e=$(this).attr("href");$(e).carousel(t)});var m=$("[data-intro='tabControl']"),p=$("[data-intro='tabContent']");m.click(function(a){a.preventDefault();var t=$(this).parent(),e=$(this).attr("href");t.hasClass("active")||(t.siblings().removeClass("active"),t.addClass("active")),$(e).hasClass("active")||(p.removeClass("active"),$(e).addClass("active"))});var C=$("#introVideo"),g=C.width(),b=g*(9/16);C.css("height",b)}),$(function(){!function(){$(document).scroll(function(){var a=$(document).scrollTop(),t=$("[data-shafa-scroll='scrollShow']"),e=t.data("shafa-distance");a>=e?t.addClass("show"):t.removeClass("show")})}(),function(){$("[data-shafa-scroll='backTop']").click(function(a){a.preventDefault(),$("body").animate({scrollTop:0})})}()}),$(function(){!function(){var a=$("[data-shafa-oem='uploadImage']");a.length>0&&a.fileupload({dataType:"json",formData:{_token:$("meta[name='csrf-token']").attr("content")},progressall:function(a,t){var e=parseInt(t.loaded/t.total*100,10),s=$(this).siblings("[data-shafa-oem='uploadProgress']"),i=$("[role='progressbar']",s);$(this).siblings("span").removeClass("in"),s.addClass("in"),i.css("width",e+"%")},done:function(a,t){var e=t.result,s=$(this).data("target");if(e.success)$("input[name='"+s+"']").val(e.data.image),$("input[name='"+s+"_select']").prop("checked",!1),$("input[name='"+s+"_select'][value='2']").prop("checked",!0),$(this).siblings("img").attr("src",e.data.image),$(this).siblings("[data-shafa-oem='uploadProgress']").removeClass("in"),$(this).parent().addClass("image-uploaded");else{var i=$(this).siblings("p"),o=$(this).siblings("[data-shafa-oem='uploadProgress']"),n=$("[role='progressbar']",o);i.text(e.data.error).show(),o.removeClass("in"),n.css("width",0),setTimeout(function(){i.hide()},2e3)}}})}(),function(){var a=$("[data-shafa-oem='uploadCode']");a.length>0&&a.fileupload({dataType:"json",formData:{qr_code:"true",_token:$("meta[name='csrf-token']").attr("content")},done:function(a,t){var e=$(this).parent(),s=t.result;console.log(e),s.success&&(e.siblings("img").attr("src",s.data.image),e.siblings("input").val(s.data.image))}})}(),function(){$("[data-shafa-oem='textarea']").bind({focus:function(){$(this).removeClass("show-example")},blur:function(){""===$(this).val()&&$(this).addClass("show-example")}})}()}),$(function(){function a(a,t){var e=$("[data-shafa-methods='mainContainer']"),s=$("[data-shafa-article]",e),i=$("[data-shafa-article='"+a+"']",e),o=$("[data-shafa-methods='loading']",e),n=$("[data-shafa-methods='error']",e);s.removeClass("active"),n.hide(),i.length>0?i.addClass("active"):(o.show(),$.ajaxSetup({headers:{"X-CSRF-TOKEN":$('meta[name="csrf-token"]').attr("content")}}),$.ajax({type:"POST",url:"http://www.shafa.com/method-article",data:{url:t}}).done(function(t){o.hide(),t.success?$("<div/>").attr("data-shafa-article",a).addClass("methods-main-article active").html(t.article).appendTo(e):n.text(t.error).show()}))}!function(){var t=$("[data-shafa-methods='iconList']"),e=$("[data-shafa-methods='icon']",t),s=e.length,i=$("[data-shafa-methods='loopButton']");s>6?(i.parent().addClass("active"),t.addClass("moveable")):6==s?(i.parent().addClass("active-md"),t.addClass("moveable-md")):5==s?e.eq(4).addClass("item-last-lg"):5>s&&e.eq(s-1).addClass("item-last"),t.css("width",144*s),i.click(function(i){i.preventDefault();var o,n=$(this).attr("href").substr(1),r=parseInt(t.css("left")),l=e.width(),d=-(r+1)/l,c=$(window).width();if("prev"==n&&-1==r)return!1;if(c>1200){if(o=!0,"next"==n&&s-d==6)return!1}else if(o=!1,"next"==n&&s-d==5)return!1;var h=$(".active[data-shafa-methods='articleButton']"),f=h.parent().index();if("next"==n){if(f==d){var v=$("[data-shafa-methods='icon']").eq(f+1).children("a");h.removeClass("active"),v.addClass("active"),a(f+1,v.attr("href"))}t.css("left",r-l),$("[data-shafa-methods='loopButton'][href='#prev']").removeClass("disabled"),o&&s-d-1==6?$(this).addClass("disabled"):o||s-d-1!=5||$(this).addClass("disabled")}else{if(f==s-1){var u=$("[data-shafa-methods='icon']").eq(f-1).children("a");h.removeClass("active"),u.addClass("active"),a(f-1,u.attr("href"))}t.css("left",r+l),$("[data-shafa-methods='loopButton'][href='#next']").removeClass("disabled"),parseInt(t.css("left"))==-1-l&&$(this).addClass("disabled")}})}(),function(){var t=$("[data-shafa-methods='articleButton']");t.click(function(e){e.preventDefault();var s=$(this).parent().index();t.removeClass("active"),$(this).addClass("active"),a(s,$(this).attr("href"))})}()});