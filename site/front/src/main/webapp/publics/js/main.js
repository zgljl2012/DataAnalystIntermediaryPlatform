
/**
 * 配置require.js
 */

requirejs.config({
	baseUrl:"publics/js",
	shim:{
		"jquery.tmpl":["jquery"],
	},
	paths:{
		"jquery":"jquery.min",
		"jquery.tmpl": this.baseUrl + "plugins/template/jquery.tmpl.min"
		
	}
})
