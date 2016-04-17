
/**
 * 常量配置
 */
define([], function(){
	var doc = document;
	// 当前系统模式类型：开发、测试、运营
	var modeTypes = {
		"dev":"http://localhost:8080/front/",
		"test":"",
		"trans":""
	}
	var config = {
		host:modeTypes["dev"],	// 当前系统模式
	}
	return config;
})
