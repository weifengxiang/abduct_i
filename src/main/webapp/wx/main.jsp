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
<style type="text/css">
.weui-picker-overlay, .weui-picker-container{
	bottom: 55px;
}
</style>
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
<script type="text/javascript"
	src="${basepath}skin/plugins/weui-master/zepto.min.js"></script>
<script type="text/javascript"
	src="${basepath}skin/plugins/weui-master/iscroll.js"></script>
<script src="${basepath}skin/plugins/weui-master/picker.js"></script>
<script src="${basepath}skin/plugins/weui-master/select.js"></script>
<script type="text/javascript" src="${basepath}skin/js/md5.js"></script>
<script type="text/javascript" src="${basepath}skin/js/map.js"></script>
<script type="text/javascript" src="${basepath}skin/js/sky.js"></script>
<script type="text/javascript" src="${basepath}wx/main.js"></script>
<security:csrfMetaTags />
</head>
<title><%=ConfUtils.getValue("procuctName")%></title>
<body ontouchstart style="background-color: #f8f8f8;">
		<div class="weui_cells_title"><span class='f-green'>线索举报</span></div>
        <div class="weui_cells weui_cells_form">
	        <form id="xsxxform" method="post">
	        <input type='hidden' name='id' id='id'/>
            <div class="weui_cell">
                <div class="weui_cell_hd"><label class="weui_label">时间</label></div>
                <div class="weui_cell_bd weui_cell_primary">
                    <input id='sfsj' name="sfsj" class="weui_input" type="text"  placeholder="请输入日期"/>
                </div>
            </div>
            <div class="weui_cell">
                <div class="weui_cell_hd"><label class="weui_label">事发地</label></div>
                <div class="weui_cell_bd weui_cell_primary">
                   <textarea name="sfd" id="sfd" class="weui_textarea" placeholder="请输入事发地" rows="3"></textarea>
                </div>
            </div>
            <div class="weui_cell">
                <div class="weui_cell_hd"><label class="weui_label">事件详情</label></div>
                <div class="weui_cell_bd weui_cell_primary">
                    <textarea name="sjxq" id="sjxq" class="weui_textarea" placeholder="请输入事件详情" rows="3"></textarea>
                </div>
            </div>
            <div class="weui_cell">
                <div class="weui_cell_hd"><label class="weui_label">联系人</label></div>
                <div class="weui_cell_bd weui_cell_primary">
                    <input name="jbr" class="weui_input" type="text" placeholder="请输入联系人"/>
                </div>
            </div>
            <div class="weui_cell">
                <div class="weui_cell_hd"><label class="weui_label">联系电话</label></div>
                <div class="weui_cell_bd weui_cell_primary">
                    <input name="dh" class="weui_input" type="text" placeholder="请输入联系电话"/>
                </div>
            </div>
			</form>
			<form  id="dangerCheckPic" method="post" enctype="multipart/form-data">
			 	<div class="weui_cell">
					<img id='dangerPicPreView' style="width:210px;height:210px;" src="${basepath}skin/images/timg.jpg"/>
				</div>
				<div class="weui_cell">
					<input id='dangerPic' name='dangerPic' type="file" accept="image/*" multiple name='拍照'/>
				</div>
			</form>
			<div class="weui_btn_area weui_btn_area_inline">
		    	<a id="formSubmitBtn" href="javascript:" class="weui_btn weui_btn_primary">提交</a>
		    	<a id="formResetBtn" href="javascript:" class="weui_btn bg-orange">重置</a>
		    </div>   
	</div>
</body>
<script type="text/javascript">
	$(function() {
		$('.weui_tab').tab({
			defaultIndex : 0,
			activeClass : 'weui_bar_item_on',
			onToggle : function(index) {
				if (index > 0) {
					//alert(index);
				}
			}
		});
		mainReg.initRegPage();
	});
</script>
</HTML>
