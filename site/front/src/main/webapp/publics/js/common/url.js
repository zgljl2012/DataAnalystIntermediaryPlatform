
/**
 * URL管理
 */
define(["common/config"], function(config) {
	var host = config.host;
	var url = {
		index:{
			data:host+"index/data",
			project:host+"project/page/",
		},
		user: {
			qy:{
				project:{
					add:host+"project/new",	// 新增项目地址
					list:host+"project/list", // 项目列表地址
					edit:host+"project/update", // 编辑项目提交Servlet
				}
			},
			fxs:{
				project:{
					query:host+"user/fxs/project/query", // 分析师查询Url
				}
			},
			letter:{
				list:host+"letter", // 站内信列表
			}
		},
		project:{
			index:host+"projectIndex",// 项目市场
			bid:host+"project/bid", // 投标
			del:host+"project/bid/del", // 删除投标
			select:host+"project/bid/select", // 中标
			comment:{
				qy:host+"project/qy/comment", // 企业评论分析师Servlet
				fxs:host+"project/fxs/comment", // 分析师评论企业Servlet
			},
			bidUpdate:host+"project/bid/update", // 编辑投标单
		}
	}
	return url;
});
