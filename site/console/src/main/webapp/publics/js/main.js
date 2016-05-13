
/**
 * 配置require.js
 */

requirejs.config({
	baseUrl:"publics/js",
	shim:{
		"jquery.tmpl":["jquery"],
	},
	paths:{
		"jquery":"jquery-2.1.1.min",
		"jquery.tmpl": "plugins/template/jquery.tmpl.min",
		"dialog":"common/dialog2",
		"pagging":"common/pagging2"
		
	}
})
