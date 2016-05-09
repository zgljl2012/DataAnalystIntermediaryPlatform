
/**
 * URL管理
 */
define(["common/config"], function(config) {
	var host = config.host;
	var url = {
		user: {
			qy:{
				project:{
					add:host+"project/new",	// 新增项目地址
					list:host+"project/list", // 项目列表地址
				}
			},
			fxs:{
				project:{
					query:host+"user/fxs/project/query", // 分析师查询Url
				}
			}
		},
		project:{
			index:host+"projectIndex",// 项目市场
			bid:host+"project/bid", // 投标
			del:host+"project/bid/del", // 删除投标
			select:host+"project/bid/select", // 中标
			comment:{
				qy:host+"project/qy/comment", // 企业评论分析师Servlet
			},
			bidUpdate:host+"project/bid/update", // 编辑投标单
		}
	}
	return url;
});
