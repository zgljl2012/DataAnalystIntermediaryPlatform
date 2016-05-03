
/**
 * 条件筛选框
 * @author 廖金龙
 * @version 2016/3/22
 */
define([], function(){
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
	var filter = {};
	filter.data = {};
	filter.selected = {};
	
	filter.init = function(root, show, callback) {
		var as = root.find("a[hint]");
		filter.callback = callback;
		if(as != null) {
			as.click(function(){
				var prev = $(this).prev();
				if(prev.length == 0) {
					var a = $(this).parent().parent().find("input");
					a.prop("checked", false);
					var aname = a.prop("name");
					delete filter.selected[aname];
					delete filter.data[aname];
					updateSelected(filter.selected);
					if(callback) {
						callback.apply(null,[filter.data]);
					}
					return;
				}
				prev.prop("checked",true);
				filter.data[prev.prop("name")] = prev.prop("value");
				if(show != null) {
					if(prev.prop("type") == "radio") {
						filter.selected[prev.prop("name")] = $(this).html();
					} else if(prev.prop("type") == "checkbox") {
						filter.selected[prev.prop("name")] += $(this).html();
					}
					updateSelected(filter.selected);
					if(callback) {
						callback.apply(null,[filter.data]);
					}
				}
			});
		}
		
		var updateSelected = function(data){
			var s = "";
			for(var i in filter.selected) {
				s += "<label name="+i+" >" + filter.selected[i] + "<em></em></label>";
			}
			show.html(s);
			$(show).find("em").click(function(){
				var prev = $(this).parent();
				var name = prev.attr("name");
				delete filter.data[name];
				root.find("input[name="+name+"]").prop("checked", false);
				delete filter.selected[name];
				updateSelected(filter.selected);
				if(filter.callback) {
					filter.callback.apply(null,[filter.data]);
				}
			});
		};
		
		filter.clear = function() {
			filter.data = {};
			filter.selected = {};
			updateSelected(filter.selected);
			var all = root.find("input");
			all.prop("checked", false);
			if(filter.callback) {
				filter.callback.apply(null,[filter.data]);
			}
		};
		
		return filter;
	}
	return filter;
});
