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

	<div class="weui_cells_title" style="height: 45px;">&nbsp;</div>
	<div class="weui_tab tab-bottom">
		<div class="weui_tab_bd">
			<div class="weui_tab_bd_item">
				 <div class="weui_cells_title"><span class='f-green'>隐患登记</span></div>
			        <div class="weui_cells weui_cells_form">
				        <form id="dangerCheckform" method="post">
				        <input type='hidden' name='id' id='id'/>
				        <input type='hidden' name='proCode' id='proCode'/>
				        <div class="weui_cell">
			                <div class="weui_cell_hd"><label class="weui_label">工程名称</label></div>
			                <div class="weui_cell_bd weui_cell_primary">
			                    <input id="proName" name="proName" class="weui_input" type="text" placeholder="请选择工程"/>
			                </div>
			            </div>
			            <div class="weui_cell">
			                <div class="weui_cell_hd"><label class="weui_label">日期</label></div>
			                <div class="weui_cell_bd weui_cell_primary">
			                    <input id='checkDate' name="checkDate" class="weui_input" type="text"  placeholder="请输入日期"/>
			                </div>
			            </div>
			            <div class="weui_cell">
			                <div class="weui_cell_hd"><label class="weui_label">存在问题</label></div>
			                <div class="weui_cell_bd weui_cell_primary">
			                   <textarea name="problem" id="problem" class="weui_textarea" placeholder="请输入存在问题" rows="3"></textarea>
			                </div>
			            </div>
			            <div class="weui_cell">
			                <div class="weui_cell_hd"><label class="weui_label">限时</label></div>
			                <div class="weui_cell_bd weui_cell_primary">
			                    <input id="timeLimit" name="timeLimit" class="weui_input" type="text" placeholder="请输入日期"/>
			                </div>
			            </div>
			            <div class="weui_cell">
			                <div class="weui_cell_hd"><label class="weui_label">整改措施</label></div>
			                <div class="weui_cell_bd weui_cell_primary">
			                    <textarea name="measures" id="measures" class="weui_textarea" placeholder="请输入整改措施" rows="3"></textarea>
			                </div>
			            </div>
			            <div class="weui_cell">
			                <div class="weui_cell_hd"><label class="weui_label">罚款金额</label></div>
			                <div class="weui_cell_bd weui_cell_primary">
			                    <input name="penalty" id="penalty" class="weui_input" type="number" pattern="[0-9]*" placeholder="罚款金额"/>
			                </div>
			            </div>
			            <div class="weui_cell">
			                <div class="weui_cell_hd"><label class="weui_label">项目责任人</label></div>
			                <div class="weui_cell_bd weui_cell_primary">
			                    <input name="dutyer" class="weui_input" type="text" placeholder="请输入项目责任人"/>
			                </div>
			            </div>
			            <div class="weui_cell">
			                <div class="weui_cell_hd"><label class="weui_label">责任单位</label></div>
			                <div class="weui_cell_bd weui_cell_primary">
			                    <input name="dutyOrgan" class="weui_input" type="text" placeholder="请输入责任单位"/>
			                </div>
			            </div>
			            <div class="weui_cell">
			                <div class="weui_cell_hd"><label class="weui_label">隐患整改人</label></div>
			                <div class="weui_cell_bd weui_cell_primary">
			                    <input name="reformer" class="weui_input" type="text" placeholder="请输入隐患整改人"/>
			                </div>
			            </div>
			            <div class="weui_cell">
			                <div class="weui_cell_hd"><label class="weui_label">整改时间</label></div>
			                <div class="weui_cell_bd weui_cell_primary">
			                    <input id="reformTime" name="reformTime" class="weui_input" type="text" placeholder="请输入整改时间"/>
			                </div>
			            </div>
						</form>
						<form  id="dangerCheckPic" method="post" enctype="multipart/form-data">
						 	<div class="weui_cell">
								<img id='dangerPicPreView' style="width:210px;height:210px;" src="${basepath}skin/images/dimg.jpg"/>
							</div>
							<div class="weui_cell">
								<input id='dangerPic' name='dangerPic' type="file" accept="image/*" capture="camera" name='拍照'/>
							</div>
						</form>
						<div class="weui_btn_area weui_btn_area_inline">
					    	<a id="formSubmitBtn" href="javascript:" class="weui_btn weui_btn_primary">提交</a>
					    	<a id="formResetBtn" href="javascript:" class="weui_btn bg-orange">重置</a>
					    </div>   
			         </div>
			</div>
			
			<div class="weui_tab_bd_item">
				<div class="weui_cells_title"><span class='f-green'>隐患查询</span></div>
			</div>
			
			<div class="weui_tab_bd_item">
				<div class="weui_cells_title"><span class='f-green'>我</span></div>
			</div>
		</div>
		<div class="weui_tabbar ">
			<a href="javascript:;" class="weui_tabbar_item weui_bar_item_on">
				<div class="weui_tabbar_icon">
					<img
						src="${basepath}skin/plugins/weui-master/images/icon_nav_button.png"
						alt="">
				</div>
				<p class="weui_tabbar_label">隐患登记</p>
			</a> 
			<a href="javascript:;"  class="weui_tabbar_item">
				<div class="weui_tabbar_icon">
					<img
						src="${basepath}skin/plugins/weui-master/images/icon_nav_search_bar.png"
						alt="">
				</div>
				<p class="weui_tabbar_label">隐患查询</p>
			</a> 
			<a href="javascript:;" class="weui_tabbar_item">
				<div class="weui_tabbar_icon">
					<img
						src="${basepath}skin/plugins/weui-master/images/icon_nav_cell.png"
						alt="">
				</div>
				<p class="weui_tabbar_label">我</p>
			</a>
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
