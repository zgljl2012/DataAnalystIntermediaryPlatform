
/**
 * 常量配置
 */
define([], function(){
	var doc = document;
	// 当前系统模式类型：开发、测试、生产
	var modeTypes = {
		"dev":"http://localhost:8080/front/",
		"test":"",
		"prod":""
	}
	var config = {
		host:modeTypes["dev"],	// 当前系统模式
		console:"http://localhost:8080/console/"
	}
	return config;
})
