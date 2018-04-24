<%@page import="org.sky.sys.utils.CommonUtils"%>
<%@page import="org.sky.sys.utils.EnumUtils"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@include file="/jsp/inc/include.jsp"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<security:csrfMetaTags/>
<script type="text/javascript" src='${basepath}jsp/ywbl/jash/edittbstajjashxx.js'></script>
<script type="text/javascript">
var _callbacks = $.Callbacks();
var STATE = <%=EnumUtils.getEnums("JASH.STATE") %>;
var shsj = '<%=CommonUtils.getCurrentDate() %>';
var shr  = '<%=BspUtils.getLoginUser().getCode() %>';
var shrName = '<%=BspUtils.getLoginUser().getName() %>';
var shdw = '<%=BspUtils.getLoginUser().getOrganCode() %>';
var shdwName = '<%=BspUtils.getLoginUser().getOrganName() %>';
$(function() {
	
});
</script> 
</head>
<body>
<div class="easyui-panel"  style="width:100%;height:100%;text-align: center;"
	 data-options="footer:'#editPageButtonsFt'">
		<form id="addedittbstajjashxxform" class="easyui-form" method="post" 
			data-options="novalidate:true">
			<input type='hidden' name='id' id='id'/>
			<input type='hidden' name='shdw' id='shdw'/>
			<input type='hidden' name='shenhr' id='shenhr'/>
			<input type='hidden' name='ywlx' value='JASH'/>
			<table style="width:100%">
				  <tr>
					<th><label>案件编号:</label></th>
					<td><input class="easyui-textbox" name="ajbh" id="ajbh" style='width:160px'
						data-options="required:true"></input></td>
					<th><label>审核结果:</label></th>
					<td><input class="easyui-combobox" name="shjg" id="shjg"
						data-options="required:true,
									  data:STATE,
									  valueField:'code',
									  textField:'name'"></input></td>
				  </tr>
				  <tr>
					<th><label>审核意见:</label></th>
					<td colspan='3'><input class="easyui-textbox" name="shyj" style='width:400;height:50'
						data-options="required:true,multiline:true"></input></td>
				  </tr>
				  <tr>
					<th><label>审核单位:</label></th>
					<td><input class="easyui-textbox" name="shdwName" id="shdwName"
						data-options="required:true"></input></td>
	
					<th><label>审核人:</label></th>
					<td><input class="easyui-textbox" name="shenhrName" id="shenhrName"
						data-options="required:true"></input></td>
				  </tr>
				  <tr>
					<th><label>审核时间:</label></th>
					<td colspan='3'><input class="easyui-datetimebox" name="shsj" id="shsj"
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
		onclick="submitAddEditTbStAjjashxxForm()">保存</a> 
	<a href="javascript:void(0)" id='cloBtn' class="easyui-linkbutton" iconCls='icon-cancel'>关闭</a>
</div>
</body>
</html>