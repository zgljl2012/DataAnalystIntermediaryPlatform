
/**
 * 条件筛选框插件
 * @author 廖金龙
 * @version 2016/3/22
 */

(function(window){
	/**
	 * parent是一个DIV层，里面的直接元素是dl，筛选框的结构为
	 * <div>
	 * 	<dl>
	 * 	<dt></dt>
	 *    <dd>
	 *       <label><a hint></a></label>
	 *	     <label>
	 *	        <input name="degree" type="radio/checkbox" value="" />
	 *	        <a hint href="javascript:;">本科以上</a></label>
	 *	   </dd>
	 *	</dl>
	 * </div>
	 * 
	 * show是条件展示DIV层，当用户点击条件后直接将条件放入其中
	 * 
	 */
	if(window.$) {
		$.filter2 = {};
	} else {
		$ = {};
		$.filter2 = {};
	}
	$.filter2.data = {};
	$.filter2.selected = {};
	
	var filter = function(root, show, callback) {
		var as = root.find("a[hint]");
		$.filter2.callback = callback;
		if(as != null) {
			as.click(function(){
				var prev = $(this).prev();
				if(prev.length == 0) {
					var a = $(this).parent().parent().find("input");
					a.prop("checked", false);
					var aname = a.prop("name");
					delete $.filter2.selected[aname];
					delete $.filter2.data[aname];
					updateSelected($.filter2.selected);
					if(callback) {
						callback.apply(null,[$.filter2.data]);
					}
					return;
				}
				prev.prop("checked",true);
				$.filter2.data[prev.prop("name")] = prev.prop("value");
				if(show != null) {
					if(prev.prop("type") == "radio") {
						$.filter2.selected[prev.prop("name")] = $(this).html();
					} else if(prev.prop("type") == "checkbox") {
						$.filter2.selected[prev.prop("name")] += $(this).html();
					}
					updateSelected($.filter2.selected);
					if(callback) {
						callback.apply(null,[$.filter2.data]);
					}
				}
			});
		}
		
		var updateSelected = function(data){
			var s = "";
			for(var i in $.filter2.selected) {
				s += "<label name="+i+" >" + $.filter2.selected[i] + "<em></em></label>";
			}
			show.html(s);
			$(show).find("em").click(function(){
				var prev = $(this).parent();
				var name = prev.attr("name");
				delete $.filter2.data[name];
				root.find("input[name="+name+"]").prop("checked", false);
				delete $.filter2.selected[name];
				updateSelected($.filter2.selected);
				if($.filter2.callback) {
					$.filter2.callback.apply(null,[$.filter2.data]);
				}
			});
		};
		
		$.filter2.clear = function() {
			$.filter2.data = {};
			$.filter2.selected = {};
			updateSelected($.filter2.selected);
			var all = root.find("input");
			all.prop("checked", false);
			if($.filter2.callback) {
				$.filter2.callback.apply(null,[$.filter2.data]);
			}
		};
		
		return filter;
	}
	
	$.filter2.init = filter;
})(this);
