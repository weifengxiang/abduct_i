<%@page import="org.sky.sys.utils.EnumUtils"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@include file="/jsp/inc/include.jsp"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<security:csrfMetaTags/>
<script type="text/javascript" src='${basepath}jsp/xxbk/bksz/detailtbstxxbk.js'></script>
<script type="text/javascript">
var _callbacks = $.Callbacks();
var bjlx = <%=EnumUtils.getEnums("XXBK.BJLX") %>;
var zt= <%=EnumUtils.getEnums("XXBK.ZT") %>;
$(function() {
	
});
</script> 
</head>
<body>
<div class="easyui-panel"  style="width:100%;height:100%;text-align: center;"
	 data-options="footer:'#detailPageButtonsFt'">
		<form id="detailtbstxxbkform" class="easyui-form" method="post" 
			data-options="novalidate:true">
			<input type='hidden' name='id' id='id'/>
			<input type='hidden' name='zrr' id='zrr'/>
			<table style="width:100%">
				  <tr>
					<th><label>布控编号:</label></th>
					<td colspan='3'><input class="easyui-textbox" name="bh" id='bh'  style='width:300'
						data-options="required:true"></input></td>
				  </tr>
				  <tr>
					<th><label>布控内容:</label></th>
					<td colspan='3'><input class="easyui-textbox" name="bknr" style='width:400;height:50'
						data-options="multiline:true,required:true"></input></td>
				  </tr>
				  <tr>
					<th><label>有效时间起:</label></th>
					<td><input class="easyui-datetimebox" name="yxsjq"
						data-options="required:true"></input></td>
				
					<th><label>有效时间至:</label></th>
					<td><input class="easyui-datetimebox" name="yxsjz"
						data-options="required:true"></input></td>
				  </tr>
				  <tr>
					<th><label>报警类型:</label></th>
					<td><input class="easyui-combobox" name="bjlx"
						data-options="required:true,
									  data:bjlx,
									  valueField:'code',
									  textField:'name'
									"></input></td>
					<th><label>责任人:</label></th>
					<td><input class="easyui-textbox" name="zrrName" id="zrrName"
						data-options="required:true"></input>
						<a href="javascript:openUserHelp()"class="easyui-linkbutton" plain="true" iconCls="icon-search">选择</a>
					</td>
				  </tr>
				  <tr>
					<th><label>状态:</label></th>
					<td  colspan='3'><input class="easyui-combobox" name="zt" id='zt'
						data-options="required:true,
									  data:zt,
									  valueField:'code',
									  textField:'name'
									  "></input></td>
				  </tr>
				  <tr>
				  	<th><label>备注:</label></th>
					<td colspan='3'><input class="easyui-textbox" name="bz" style='width:400;height:50'
						data-options="multiline:true"></input></td>
				  </tr>
			</table>
		</form>
</div>
<div id='detailPageButtonsFt' style="text-align:center; padding:2px; top:0px">
	<a href="javascript:void(0)" id='cloBtn' class="easyui-linkbutton" iconCls='icon-cancel'">关闭</a>
</div>
</body>
</html>