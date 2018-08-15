/**
 * @license Copyright (c) 2003-2014, CKSource - Frederico Knabben. All rights reserved.
 * For licensing, see LICENSE.html or http://ckeditor.com/license
 */

CKEDITOR.editorConfig = function( config ) {
	// Define changes to default configuration here. For example:
	// config.language = 'fr';
	// config.uiColor = '#AADC6E';
	
//	config.toolbar = 'Full';
//
//	config.toolbar_Full =
//	[
//	    ['Source','-','Save','NewPage','Preview','-','Templates'],
//	    ['Cut','Copy','Paste','PasteText','PasteFromWord','-','Print', 'SpellChecker', 'Scayt'],
//	    ['Undo','Redo','-','Find','Replace','-','SelectAll','RemoveFormat'],
//	    ['Form', 'Checkbox', 'Radio', 'TextField', 'Textarea', 'Select', 'Button', 'ImageButton', 'HiddenField'],
//	    '/',
//	    ['Bold','Italic','Underline','Strike','-','Subscript','Superscript'],
//	    ['NumberedList','BulletedList','-','Outdent','Indent','Blockquote'],
//	    ['JustifyLeft','JustifyCenter','JustifyRight','JustifyBlock'],
//	    ['Link','Unlink','Anchor'],
//	    ['Image','Flash','Table','HorizontalRule','Smiley','SpecialChar','PageBreak'],
//	    '/',
//	    ['Styles','Format','Font','FontSize'],
//	    ['TextColor','BGColor'],
//	    ['Maximize', 'ShowBlocks','-','About']
//	];
//
//	config.toolbar_Basic =
//	[
//	    ['Bold', 'Italic', '-', 'NumberedList', 'BulletedList', '-', 'Link', 'Unlink','-','About']
//	];
	config.language = 'zh-cn'; // 配置语言   
//	config.uiColor = '#FFF'; // 背景颜色   
	config.width = '850px'; // 宽度   
	config.height = '455px'; // 高度   
//	config.skin = 'v2';//界面v2,kama,office2003  
	config.disableObjectResizing =false;
	config.disableNativeTableHandles =false;
	config.resize_enabled = false;
	config.fullPage = true;
	config.pasteFromWordIgnoreFontFace = false; 
//
//	// 换行方式 
//	config.enterMode = CKEDITOR.ENTER_BR; 
//	// 当输入：shift+Enter是插入的标签 
//	config.shiftEnterMode = CKEDITOR.ENTER_BR;
	
	var path=window.location.pathname;
	var webContent="";
	if(path.startWith("/teacher/"))
	{
		webContent="/teacher";
	}
	else if(path.startWith("/student/")) 
	{
		webContent="/student";
	}
// 图片上传配置   
	config.filebrowserUploadUrl = "https://file.dafy.com/Servlet/imageUpload.svl?paramCallBacke=ckeditor&callBackServlet="+webContent+"/Servlet/callback.svl&scheme=https";
	
	// 去掉ckeditor“保存”按钮 
	config.removePlugins = 'save'; 

	config.pasteFromWordRemoveStyle = false;
	config.templates_replaceContent = false;
	config.dialog_magnetDistance = 20;
	
	config.toolbar =
	[
	    ['Save','Templates','Cut','Copy','Paste','PasteText','PasteFromWord', 'SpellChecker','Scayt','Undo','Redo','Find','Replace','SelectAll','RemoveFormat','Form', 'Checkbox', 'Radio'],['TextField','Textarea','Select', 'Button', 'Bold','Italic','Underline','Strike','Subscript','Superscript','NumberedList','BulletedList','Outdent','Indent','Blockquote','JustifyLeft','JustifyCenter','JustifyRight','JustifyBlock','Link','Unlink'],['Anchor','Image','Table','HorizontalRule','Smiley','SpecialChar','Styles','Format'],['Font','FontSize','TextColor','BGColor']
	];
	
};
String.prototype.startWith=function(str){     
	  var reg=new RegExp("^"+str);     
	  return reg.test(this);        
} 



