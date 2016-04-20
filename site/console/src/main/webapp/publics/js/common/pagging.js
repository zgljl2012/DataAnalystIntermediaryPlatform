
define([], function(){
	var pagging = {
		current:1,
		pullData:function(){},
		pageSize:0,
		name:"paging"
	};
	/**********************************************************
	 * 获取分页信息
	 */

	pagging.paging = function(pullData, count, pageSize) {
		pagging.pullData = pullData;
		pagging.pageSize = pageSize;
		pagging.count = count;
		console.log(pagging.current);
		var pageCount = getPageCount();
		var e = $("ul[name="+pagging.name+"]");
		var s = "<li><a onclick=pagging.pullData(1)"+" aria-label=Previous title='首页'>"
			+"<span aria-hidden=true>&laquo;</span></a></li>";
		var left=[];
		var right=[];
		var isMiddle = false;
		for(var i=0; i < pageCount;i++) left.push(i+1);
		if(pageCount>5) {
			var all =getPageCount();
			if(pagging.current<=3){
				left=[1,2,3];
				right=[all-1, all];
			} else if(pagging.current>=all-2){
				left=[1,2];
				right=[all-2, all-1, all];
			} else {
				isMiddle = true;
				left=[pagging.current-1, pagging.current, pagging.current+1];
				right = [];
			}
		}
		if(isMiddle) {
			s += "<li><a  onclick=pagging.prev() title='上一页'>...</a></li>"
		}
		for(var i=0;i<left.length;i++) {
			s += "<li><a  onclick=pagging.pullData("+left[i]
				+") >"+left[i]+"</a></li>";
		}
		if(!isMiddle&&left.length >= 3&&pageCount>5) {
			s += "<li><a  title='下一页' onclick=pagging.pullData("+
				"4)>...</a></li>"
		} else if(!isMiddle&&left.length >= 2&&pageCount>5) {
			s += "<li><a  title='下一页' onclick=pagging.pullData("+
			 (getPageCount()-3)+")>...</a></li>"
		}
		for(var i=0;i<right.length;i++) {
			s += "<li><a onclick=pagging.pullData("+right[i]
				+") >"+right[i]+"</a></li>";
		}
		if(isMiddle) {
			s += "<li><a onclick=pagging.next() title='下一页'>...</a></li>"
		}
		s += "<li><a onclick=pagging.pullData("+pageCount+") aria-label=Next title='尾页'>" +
			"<span aria-hidden=true>&raquo;</span></a></li>";
		e.html(s);
	}

	pagging.prev = function(i) {
		if(i == null) i=1;
		if(pagging.current > 1) {
			pagging.pullData(pagging.current-i);
		}
	}

	pagging.next = function(i) {
		if(i==null) i=1;
		if(pagging.current < getPageCount()) {
			pagging.pullData(pagging.current+i);
		}
	}

	function getPageCount() {
		var pageCount = pagging.count % pagging.pageSize; 
		if(pageCount > 0) {
			pageCount = (pagging.count - pageCount)/pagging.pageSize + 1;
		} else {
			pageCount = (pagging.count - pageCount)/pagging.pageSize;
		}
		return pageCount;
	}
	return pagging;
})
