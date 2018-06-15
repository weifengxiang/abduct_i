<%@page import="org.sky.sys.utils.CommonUtils"%>
<%@page import="org.sky.sys.utils.EnumUtils"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@include file="/jsp/inc/include.jsp"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<security:csrfMetaTags/>
<script type="text/javascript" src='${basepath}jsp/zlgl/zlfk/edittbstzlfk.js'></script>
<script type="text/javascript">
var zt=<%=EnumUtils.getEnums("ZLXF.ZT") %>;
var datetime = '<%=CommonUtils.getCurrentDate() %>';
var _callbacks = $.Callbacks();
$(function() {
	
});
</script> 
</head>
<body>
<div class="easyui-panel"  style="width:100%;height:100%;text-align: center;"
	 data-options="footer:'#editPageButtonsFt'">
		<form id="addedittbstzlfkform" class="easyui-form" method="post" 
			data-options="novalidate:true">
			<input type='hidden' name='id' id='id'/>
			<table style="width:100%">
				  <tr>
					<th><label>指令编号:</label></th>
					<td><input class="easyui-textbox" name="zlbh"
						data-options="required:true"></input></td>

					<th><label>接收单位:</label></th>
					<td><input class="easyui-textbox" name="jsdw"
						data-options="required:true"></input></td>
				  </tr>
				  <tr>
					<th><label>接收时间:</label></th>
					<td><input class="easyui-textbox" name="jssj"
						data-options="required:true"></input></td>

					<th><label>反馈时间:</label></th>
					<td><input class="easyui-datetimebox" name="fksj" id="fksj"
						data-options="required:true"></input></td>
				  </tr>
				  <tr>
					<th><label>反馈内容:</label></th>
					<td colspan='3'><input class="easyui-textbox" name="fknr"style='width:400;height:50'
						data-options="multiline:true,required:true"></input></td>
				  </tr>
				  
				  <tr>
					<th><label>备注:</label></th>
					<td colspan='3'><input class="easyui-textbox" name="bz"style='width:400;height:50'
						data-options="multiline:true"></input></td>
				  </tr>
				  <tr>
					<th><label>状态:</label></th>
					<td colspan='3'><input class="easyui-combobox" name="zt" id="zt"
						data-options="required:true,
									  data:zt,
									  valueField:'code',
									  textField:'name'
									  "></input></td>
				  </tr>
			</table>
		</form>
</div>
<div id='editPageButtonsFt' style="text-align:center; padding:0px; top:0px">
	<a href="javascript:void(0)" class="easyui-linkbutton" iconCls='icon-save'
		onclick="submitAddEditTbStZlfkForm()">保存</a> 
	<a href="javascript:void(0)" id='cloBtn' class="easyui-linkbutton" iconCls='icon-cancel'>关闭</a>
</div>
</body>
</html>