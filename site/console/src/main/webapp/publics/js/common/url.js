
/**
 * URL管理
 */
define(["common/config"], function(config) {
	var host = config.host;
	var console = config.console;
	var url = {
		user: {
			qy:{
				project:{
					add:host+"project/new",	// 新增项目地址
					list:host+"project/list", // 项目列表地址
				}
			},
			front:console+"user/front",
			console:console+"user/console",
		},
		system:{
			variable:console+"variable"
		}
	}
	return url;
});
