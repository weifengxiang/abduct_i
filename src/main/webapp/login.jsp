<!-- 放在第一行 兼容低版本IE-->
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" /> 
<%@page import="org.sky.sys.utils.ConfUtils"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<HTML xmlns="http://www.w3.org/1999/xhtml">
<head>
<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@page import="org.sky.sys.utils.BspUtils"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<c:url value="/" var="basepath"></c:url>
<script type="text/javascript">
var basepath='${basepath}';
</script>

<script type="text/javascript" src="${basepath}skin/jquery/jquery-1.12.4.min.js"></script>
<script type="text/javascript" src="${basepath}skin/jquery/jquery-migrate-1.1.0.min.js"></script>
<script type="text/javascript" src="${basepath}skin/jquery/jquery.form.js"></script>
<script type="text/javascript" src="${basepath}skin/jquery/jquery.cookie.js"></script>
<script type="text/javascript" src="${basepath}skin/jquery/jquery.validate.js"></script>
<script type="text/javascript" src="${basepath}skin/js/md5.js"></script>
<script type="text/javascript" src="${basepath}skin/js/map.js"></script>
<script type="text/javascript" src="${basepath}skin/plugins/jquery-easyui-1.5.4/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${basepath}skin/plugins/jquery-easyui-1.5.4/locale/easyui-lang-zh_CN.js"></script>
<!-- easyUI相关 -->
<link rel="stylesheet" type="text/css" href="${basepath}skin/plugins/jquery-easyui-1.5.4/themes/default/easyui.css" rel="stylesheet" title='themes'>
<!-- 必须下载easyUI相关下面  -->
<link rel="stylesheet" type="text/css" href="${basepath}skin/plugins/jquery-easyui-1.5.4/themes/color.css">
<link rel="stylesheet" type="text/css" href="${basepath}skin/plugins/jquery-easyui-1.5.4/themes/icon.css">
<link rel="stylesheet" type="text/css" href="${basepath}skin/css/sky.css">

<link rel="stylesheet" type="text/css" href="${basepath}skin/plugins/login/css/style2.0.css">
<security:csrfMetaTags />
</head>
<title>
<%=ConfUtils.getValue("procuctName") %>
</title>
<style type="text/css">
	ul li{font-size: 30px;color:#2ec0f6;}
	.tyg-div{z-index:-1000;float:left;position:absolute;left:5%;top:20%;}
	.tyg-p{
		font-size: 14px;
	    font-family: 'microsoft yahei';
	    position: absolute;
	    top: 135px;
	    left: 60px;
	}
	.tyg-div-denglv{
		z-index:1000;float:right;position:absolute;right:3%;top:10%;
	}
	.tyg-div-form{
		background-color: #23305a;
		width:300px;
		height:auto;
		margin:120px auto 0 auto;
		color:#2ec0f6;
	}
	.tyg-div-form form {padding:10px;}
	.tyg-div-form form input[type="text"]{
		width: 270px;
	    height: 30px;
	    margin: 25px 10px 0px 0px;
	}
	.tyg-div-form form input[type="button"]{
	    cursor: pointer;
	    width: 270px;
	    height: 35px;
	    margin-top: 25px;
	    padding: 0;
	    background: #2ec0f6;
	    -moz-border-radius: 6px;
	    -webkit-border-radius: 6px;
	    border-radius: 6px;
	    border: 1px solid #2ec0f6;
	    -moz-box-shadow:
	        0 15px 30px 0 rgba(255,255,255,.25) inset,
	        0 2px 7px 0 rgba(0,0,0,.2);
	    -webkit-box-shadow:
	        0 15px 30px 0 rgba(255,255,255,.25) inset,
	        0 2px 7px 0 rgba(0,0,0,.2);
	    box-shadow:
	        0 15px 30px 0 rgba(255,255,255,.25) inset,
	        0 2px 7px 0 rgba(0,0,0,.2);
	    font-family: 'PT Sans', Helvetica, Arial, sans-serif;
	    font-size: 14px;
	    font-weight: 700;
	    color: #fff;
	    text-shadow: 0 1px 2px rgba(0,0,0,.1);
	    -o-transition: all .2s;
	    -moz-transition: all .2s;
	    -webkit-transition: all .2s;
	    -ms-transition: all .2s;
}
</style>
<body>
<!-- loginbegin -->
<div id="contPar" class="contPar">
	<div id="page1"  style="z-index:1;">
		<div class="title0"><%=ConfUtils.getValue("procuctName") %></div>
		<div class="title1">AI、公共安全、大数据</div>
		<div class="imgGroug">
			<ul>
				<img alt="" class="img0 png" src="./skin/plugins/login/img/page1_0.png">
				<img alt="" class="img1 png" src="./skin/plugins/login/img/page1_1.png">
				<img alt="" class="img2 png" src="./skin/plugins/login/img/page1_2.png">
			</ul>
		</div>
		<img alt="" class="img3 png" src="./skin/plugins/login/img/page1_3.jpg">
	</div>
</div>
<div class="tyg-div-denglv">
	<div class="tyg-div-form">
		<form id="loginform" action="${basepath}j_spring_security_check" method="post" class='login_form'>
		<security:csrfInput/>
			<h2>登录</h2><p class="tyg-p">欢迎访问  <%=ConfUtils.getValue("procuctName") %></p>
			<div style="margin:25px 0px;">
				<input class="easyui-textbox"  name="username" id="j_username" value=''
					  data-options="prompt:'请输入登录用户名',
					  				required:true,
					  				novalidate:true,
					  				iconCls:'icon-man',    
					  				iconAlign:'right'" 
					  style="width:100%;height:35px;"
					/>
			</div>
			<div style="margin:25px 0px;">
				<input class="easyui-textbox" type="password"  name="password" id="j_password" value=''
					   data-options="prompt:'请输入登录密码',
					   				 required:true,
					   				 novalidate:true,
					   				 iconCls:'icon-lock',    
					  				 iconAlign:'right'"
					   style="width:100%;height:35px;"
				/>
			</div>
			<div style="margin:25px 0px;">
				<input id="rememberme" type="checkbox"/>记住我
			</div>
			<div style="margin:25px 0px;">
				<font color=red>${SPRING_SECURITY_LAST_EXCEPTION.message}</font>
			</div>
			<input type='button' id="login_submit" class='tyg-div-form' onclick='login()' value='登录'></input>
		</form>
		
	</div>
</div>
<!-- loginend -->
</body>
<script type="text/javascript" src="${basepath}skin/plugins/login/js/com.js"></script>
<script type="text/javascript">
function login() {
	var validate = $("#j_username").textbox('enableValidation').textbox('isValid');
	if(!validate)return ; 
	var validate = $("#j_password").textbox('enableValidation').textbox('isValid');
	if(!validate)return ;
	$("#j_password").textbox('setValue',toMD5Str($("#j_password").textbox('getValue')));
	$("#loginform").submit();
}
function getLeft(){
	var width=screen.width;
	return (width-400)+'px';
}
$(function(){
	var client = $.cookie('client');
	if('dd'==client){
		window.location.href=basepath+'dingding/login';
	}
	initRememberMe();
	$(document).keypress(function(e) {  
		// 回车键事件  
	    if(e.which == 13){
	    	$('#login_submit').click(); 
	    }  
	 }); 
	//用户名录入框获取光标
	$('#j_username').textbox().next('span').find('input').focus();
	
});
//记住密码操作
function initRememberMe(){
	if($.cookie('absms_crm2_username')!=undefined){  
        $("#rememberme").attr("checked", true);  
    }else{  
        $("#rememberme").attr("checked", false);  
    }  
      
    //读取cookie  
    if($('#rememberme:checked').length>0){  
        $('#j_username').textbox('setValue',$.cookie('absms_crm2_username'));  
        $('#j_password').textbox('setValue',$.cookie('absms_crm2_password'));  
    }  
      
    //监听【记住我】事件  
    $("#rememberme").click(function(){  
        if($('#rememberme:checked').length>0){//设置cookie  
            $.cookie('absms_crm2_username', $('#j_username').textbox('getValue'),{ path: '/', expires: 10 });  
            $.cookie('absms_crm2_password', $('#j_password').textbox('getValue'),{ path: '/', expires: 10 });  
        }else{//清除cookie  
        	$.removeCookie('absms_crm2_username',{ path: '/', expires: 10 });  
            $.removeCookie('absms_crm2_password',{ path: '/', expires: 10 });   
        }  
    });  
}
</script>
</HTML>
