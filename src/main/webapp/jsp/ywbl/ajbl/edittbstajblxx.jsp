<%@page import="org.sky.sys.utils.CommonUtils"%>
<%@page import="org.sky.sys.utils.EnumUtils"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@include file="/jsp/inc/include.jsp"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<security:csrfMetaTags/>
<script type="text/javascript" src='${basepath}jsp/ywbl/ajbl/edittbstajblxx.js'></script>
<script type="text/javascript">
var STATE = <%=EnumUtils.getEnums("AJBL.STATE")%>;
var blsj = '<%=CommonUtils.getCurrentDate() %>';
var blr  = '<%=BspUtils.getLoginUser().getCode() %>';
var blrName = '<%=BspUtils.getLoginUser().getName() %>';
var bldw = '<%=BspUtils.getLoginUser().getOrganCode() %>';
var bldwName = '<%=BspUtils.getLoginUser().getOrganName() %>';
var _callbacks = $.Callbacks();
$(function() {
	
});
</script> 
</head>
<body>
<div class="easyui-panel"  style="width:100%;height:100%;text-align: center;"
	 data-options="footer:'#editPageButtonsFt'">
		<form id="addedittbstajblxxform" class="easyui-form" method="post" 
			data-options="novalidate:true">
			<input type='hidden' name='id' id='id'/>
			<input type='hidden' name='blr' id='blr'/>
			<input type='hidden' name='bldw' id='bldw'/>
			<table style="width:100%">
				  <tr>
					<th><label>案件编号:</label></th>
					<td><input class="easyui-textbox" name="ajbh" id="ajbh"
						data-options="required:true"></input></td>
	
					<th><label>办理结果:</label></th>
					<td><input class="easyui-combobox" name="bljg" id="bljg"
						data-options="required:true,
									  valueField:'code',
									  textField:'name',
									  data:STATE"></input></td>
				  </tr>
				  <tr>
					<th><label>办理意见:</label></th>
					<td colspan='3'>
						<input class="easyui-textbox" name="blyj" style='width:400;height:50'
						data-options="required:true,multiline:true"></input></td>
				  </tr>
				 
				  <tr>
					<th><label>办理人:</label></th>
					<td><input class="easyui-textbox" name="blrName" id="blrName"
						data-options="required:true"></input></td>
			
					<th><label>办理单位:</label></th>
					<td><input class="easyui-textbox" name="bldwName" id="bldwName"
						data-options="required:true"></input></td>
				  </tr>
				   <tr>
					<th><label>办理时间:</label></th>
					<td><input class="easyui-datetimebox" name="blsj" id="blsj"
						data-options="required:true"></input></td>
				  </tr>
				  <tr>
					<th><label>备注:</label></th>
					<td colspan='3'><input class="easyui-textbox" name="bz" style='width:400;height:50'
						data-options="multiline:true"></input></td>
				  </tr>
			</table>
		</form>
</div>
<div id='editPageButtonsFt' style="text-align:center; padding:0px; top:0px">
	<a href="javascript:void(0)" class="easyui-linkbutton" iconCls='icon-save'
		onclick="submitAddEditTbStAjblxxForm()">保存</a> 
	<a href="javascript:void(0)" id='cloBtn' class="easyui-linkbutton" iconCls='icon-cancel'>关闭</a>
</div>
</body>
</html>