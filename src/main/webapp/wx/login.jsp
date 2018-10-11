<!doctype html>
<meta name="viewport"
	content="width=device-width,initial-scale=1,user-scalable=0">

<%@page import="org.sky.sys.utils.ConfUtils"%>
<HTML xmlns="http://www.w3.org/1999/xhtml">
<head>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="org.sky.sys.utils.BspUtils"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<c:url value="/" var="basepath"></c:url>
<link rel="shortcut icon" href="${basepath}skin/images/favicon.png" type="image/x-icon"/>
<script type="text/javascript">
	var basepath = '${basepath}';
</script>
<link rel="stylesheet"
	href="${basepath}skin/plugins/weui-master/style/weuix.min.css" />
<link rel="stylesheet"
	href="${basepath}skin/plugins/weui-master/style/weui2.css" />
<link rel="stylesheet"
	href="${basepath}skin/plugins/weui-master/style/weui3.css" />
<script type="text/javascript"
	src="${basepath}skin/jquery/jquery-1.12.4.min.js"></script>
<script type="text/javascript"
	src="${basepath}skin/jquery/jquery-migrate-1.1.0.min.js"></script>
<script type="text/javascript"
	src="${basepath}skin/jquery/jquery.form.js"></script>
<script type="text/javascript"
	src="${basepath}skin/jquery/jquery.cookie.js"></script>
<script type="text/javascript"
	src="${basepath}skin/jquery/jquery.validate.js"></script>
<script type="text/javascript" src="${basepath}skin/js/md5.js"></script>
<script type="text/javascript" src="${basepath}skin/js/map.js"></script>
<link rel="stylesheet"
	href="${basepath}skin/plugins/weui-master/style/weuix.min.css" />
<script type="text/javascript"
	src="${basepath}skin/plugins/weui-master/zepto.min.js"></script>
<security:csrfMetaTags />
</head>
<title><%=ConfUtils.getValue("procuctName")%></title>

<body  class="page-bg">
<div class="page-hd">
       
</div>
<div style="width: 100%;text-align: center;">
<div  style="width:50px;height:50px;font-size:18px;background:#04b567;opacity:0.5;border-radius:50%;margin:0 auto;">
<i class="icon icon-99 f45"></i>
</div>
</div>
<form  id="loginform" action="${basepath}j_spring_security_check" method="post" >
<security:csrfInput/>
    <div class="weui_cells weui_cells_form">
    
        <div class="weui_cell">
            <div class="weui_cell_hd"><label class="weui_label">用户名</label></div>
            <div class="weui_cell_bd weui_cell_primary">
                <input class="weui_input" type="text" required name="i_username" id="i_username"
                		placeholder="请输入用户名或手机号" emptyTips="请输入用户名或手机号" >
                <input type='hidden' name='username' id='username'/>
            </div>
            <div class="weui_cell_ft">
                <i class="weui_icon_warn"></i>
            </div>
        </div>
        <div class="weui_cell">
            <div class="weui_cell_hd"><label class="weui_label">密码</label></div>
            <div class="weui_cell_bd weui_cell_primary">
                <input class="weui_input" type="password" required name="password" id="i_password"
                       placeholder="请输入密码" tips="请输入密码">
            </div>
            <div class="weui_cell_ft">
                <i class="weui_icon_warn"></i>
            </div>
        </div>
        <div class="weui_cell  weui_cells_checkbox">
        	 <label class="weui_cell weui_check_label" for="rememberme">
                <div class="weui_cell_hd">
                    <input type="checkbox" class="weui_check" name="rememberme" id="rememberme" checked="checked">
                    <i class="weui_icon_checked"></i>
                </div>
                <div class="weui_cell_bd weui_cell_primary">
                    <p>记住我</p>
                </div>
            </label>
        </div>
    </div>
    <div class="weui_msg">
        <div class="weui_text_area">
            <p class="weui_msg_desc"><span class='weui_btn_warn f-white'>${SPRING_SECURITY_LAST_EXCEPTION.message}</span></p>
        </div>
    </div>
    
    <div class="weui_btn_area">
        <a id="formSubmitBtn" href="javascript:" class="weui_btn weui_btn_primary"  onclick='javascript:login()'>登录</a>
    </div>
</form>	
</body>

<script type="text/javascript">
function login() {
	$("#i_password").val(toMD5Str($("#i_password").val()));
	$("#username").val($("#i_username").val()+"@WX");
	$.cookie('logintype', "WX",{ path: '/', expires: 10 });
	$("#loginform").submit();
}
$(function(){
	initRememberMe();
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
        $('#i_username').val($.cookie('absms_crm2_username'));  
        $('#i_password').val($.cookie('absms_crm2_password'));  
    }  
      
    //监听【记住我】事件  
    $("#rememberme").click(function(){
        if($('#rememberme:checked').length>0){//设置cookie  
            $.cookie('absms_crm2_username', $('#i_username').val(),{ path: '/', expires: 10 });  
            $.cookie('absms_crm2_password', $('#i_password').val(),{ path: '/', expires: 10 });  
        }else{//清除cookie
        	$.removeCookie('absms_crm2_username',{ path: '/', expires: 10 });  
            $.removeCookie('absms_crm2_password',{ path: '/', expires: 10 });    
        }  
    }); 
    //取消记住我选中事件
    $('#i_username').on('input',function(){
    	 $("#rememberme").attr("checked", false);  
    });
	$('#i_password').on('input',function(){
		 $("#rememberme").attr("checked", false);  
    });
}
</script>
</HTML>
