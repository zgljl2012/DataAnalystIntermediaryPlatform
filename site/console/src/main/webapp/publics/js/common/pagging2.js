
define([], function(){
	/**********************************************************
	 * 获取分页信息
	 */

	var pagging = function(name, pullData, count, pageSize) {
		this.name = name;
		this.pullData = pullData;
		this.pageSize = pageSize;
		this.count = count;
		this.current = 1;
		this.prev = function(i) {
			if(i == null) i=1;
			if(this.current > 1) {
				this.pullData(this.current-i);
				this.current -= i;
			}
		}
		this.next = function(i) {
			if(i==null) i=1;
			if(this.current < this.getPageCount()) {
				this.pullData(this.current+i);
				this.current += i;
			}
		}
	}
	
	pagging.prototype.getPageCount = function() {
		var pageCount = this.count % this.pageSize; 
		if(pageCount > 0) {
			pageCount = (this.count - pageCount)/this.pageSize + 1;
		} else {
			pageCount = (this.count - pageCount)/this.pageSize;
		}
		return pageCount;
	}
	
	pagging.prototype.paging = function() {
		var e = $("ul[name="+this.name+"]");
		var s = "<li><a onclick="+this.name+".pullData(1)"+" aria-label=Previous title='首页'>"
			+"<span aria-hidden=true>&laquo;</span></a></li>";
		var left=[];
		var right=[];
		var isMiddle = false;
		var pageCount = this.getPageCount();
		for(var i=0; i < pageCount;i++) left.push(i+1);
		if(pageCount>5) {
			var all =pageCount;
			if(this.current<=3){
				left=[1,2,3];
				right=[all-1, all];
			} else if(this.current>=all-2){
				left=[1,2];
				right=[all-2, all-1, all];
			} else {
				isMiddle = true;
				left=[this.current-1, this.current, this.current+1];
				right = [];
			}
		}
		if(isMiddle) {
			s += "<li><a  onclick="+this.name+".prev() title='上一页'>...</a></li>"
		}
		for(var i=0;i<left.length;i++) {
			s += "<li><a  onclick="+this.name+".pullData("+left[i]
				+") >"+left[i]+"</a></li>";
		}
		if(!isMiddle&&left.length >= 3&&pageCount>5) {
			s += "<li><a  title='下一页' onclick="+this.name+".pullData("+
				"4)>...</a></li>"
		} else if(!isMiddle&&left.length >= 2&&pageCount>5) {
			s += "<li><a  title='下一页' onclick="+this.name+".pullData("+
			 (getPageCount()-3)+")>...</a></li>"
		}
		for(var i=0;i<right.length;i++) {
			s += "<li><a onclick="+this.name+".pullData("+right[i]
				+") >"+right[i]+"</a></li>";
		}
		if(isMiddle) {
			s += "<li><a onclick="+this.name+".next() title='下一页'>...</a></li>"
		}
		s += "<li><a onclick="+this.name+".pullData("+pageCount+") aria-label=Next title='尾页'>" +
			"<span aria-hidden=true>&raquo;</span></a></li>";
		e.html(s);
	}
	
	return pagging;
})
