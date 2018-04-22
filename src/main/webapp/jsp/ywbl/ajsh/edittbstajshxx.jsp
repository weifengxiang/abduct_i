<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@include file="/jsp/inc/include.jsp"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<security:csrfMetaTags/>
<script type="text/javascript" src='${basepath}jsp/ywbl/ajsh/edittbstajshxx.js'></script>
<script type="text/javascript">
var _callbacks = $.Callbacks();
$(function() {
	
});
</script> 
</head>
<body>
<div class="easyui-panel"  style="width:100%;height:100%;text-align: center;"
	 data-options="footer:'#editPageButtonsFt'">
		<form id="addedittbstajshxxform" class="easyui-form" method="post" 
			data-options="novalidate:true">
			<input type='hidden' name='id' id='id'/>
			<table style="width:100%">
				  <tr>
					<th><label>案件编号:</label></th>
					<td><input class="easyui-textbox" name="ajbh"
						data-options="required:true"></input></td>
				  </tr>
				  <tr>
					<th><label>审核结果:</label></th>
					<td><input class="easyui-textbox" name="shjg"
						data-options="required:true"></input></td>
				  </tr>
				  <tr>
					<th><label>审核意见:</label></th>
					<td><input class="easyui-textbox" name="shyj"
						data-options="required:true"></input></td>
				  </tr>
				  <tr>
					<th><label>审核单位:</label></th>
					<td><input class="easyui-textbox" name="shdw"
						data-options="required:true"></input></td>
				  </tr>
				  <tr>
					<th><label>审核时间:</label></th>
					<td><input class="easyui-textbox" name="shsj"
						data-options="required:true"></input></td>
				  </tr>
				  <tr>
					<th><label>审核人:</label></th>
					<td><input class="easyui-textbox" name="shenhr"
						data-options="required:true"></input></td>
				  </tr>
				  <tr>
					<th><label>备注:</label></th>
					<td><input class="easyui-textbox" name="bz"
						data-options="required:true"></input></td>
				  </tr>
			</table>
		</form>
</div>
<div id='editPageButtonsFt' style="text-align:center; padding:0px; top:0px">
	<a href="javascript:void(0)" class="easyui-linkbutton" iconCls='icon-save'
		onclick="submitAddEditTbStAjshxxForm()">保存</a> 
	<a href="javascript:void(0)" id='cloBtn' class="easyui-linkbutton" iconCls='icon-cancel'>关闭</a>
</div>
</body>
</html>