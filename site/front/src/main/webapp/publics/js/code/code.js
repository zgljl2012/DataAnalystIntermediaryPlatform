hljs.initHighlightingOnLoad();
$(document).ready(function() {
	$('pre code').each(function(i, block) {
		hljs.highlightBlock(block);
	});
	$('pre code').mousedown(function(e){
		console.log(e)
		var x = e.offsetX;
		var y = e.offsetY;
		$("#a").css("top",y+"px");
		$("#a").css("left",x+"px");
	});
});

if(window.localStorage) {
	$("#code").val(localStorage["code"]);
}
   
var run = function() {
	   progress("开始运行...")
	   var code = $("#code").val();
	   if(code == null|| code=='') {
		   progress("运行失败");
		   alert('请先输入代码');
		   return;
	   }
	   $.ajax({
		   type:"post",
		   url:"code/python",
		   data:{code:code},
		   success:function(data) {
			   $("#console").val(data);
			   progress("运行成功");
		   },error:function(){
			   progress("运行失败");
			   alert("网络错误，请刷新重试");
		   }
	   })
};
   
var cache=function(){
	   if(window.localStorage) {
		  localStorage["code"] = $("#code").val();
		 progress("缓存成功");
	   } else {
		   alert("此浏览器版本不支持缓存");
	   }
}
   
var save=function() {
	Download.save($("#code").val(), 'code.py');
}
    
function progress(s) {
	$("#progress").html(s);
}
   
   var Download = {
		    click : function(node) {
		        var ev = document.createEvent("MouseEvents");
		        ev.initMouseEvent("click", true, false, self, 0, 0, 0, 0, 0, false, false, false, false, 0, null);
		        return node.dispatchEvent(ev);
		    },
		    encode : function(data) {
		            return 'data:application/octet-stream;base64,' + btoa( data );
		    },
		    link : function(data, name){
		        var a = document.createElement('a');
		        a.download = name || self.location.pathname.slice(self.location.pathname.lastIndexOf('/')+1);
		        a.href = data || self.location.href;
		        return a;
		    }
		};
		Download.save = function(data, name){
		    this.click(
		        this.link(this.encode( data ),name)
		    );
		};