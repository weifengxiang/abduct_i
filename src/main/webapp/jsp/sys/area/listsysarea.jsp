<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@include file="/jsp/inc/include.jsp"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<security:csrfMetaTags/>
<script type="text/javascript" src='${basepath}jsp/sys/area/listsysarea.js'></script>
<script type="text/javascript">
$(function() {
	init();
});
</script> 
</head>
<body class="easyui-layout" style="width: 100%; height: 100%; padding: 0; border: 0"
	  data-options='border:false,fit:true'>
<div data-options="region:'north',split:false,collapsible:false,iconCls:'icon-search'" class="easyui-panel" title="查询条件"
	   style="width:100%; height:63px; padding:0px;" cellpadding="0">
<table class='noborder'>
	<tr style="height: 34px">
		<th><label>行政区划编号:</label></th>
		<td><input  class="easyui-textbox" data-options="prompt:'输入行政区划编号'" name="q_code"  id="q_code" ></input></td>				
		<th><label>名称:</label></th>
		<td><input  class="easyui-textbox" data-options="prompt:'输入名称'" name="q_name"  id="q_name" ></input></td>				
		<th><label>上级代码:</label></th>
		<td><input  class="easyui-textbox" data-options="prompt:'输入上级代码'" name="q_parCode"  id="q_parCode" ></input></td>				
		<th><label>排序代码:</label></th>
		<td><input  class="easyui-textbox" data-options="prompt:'输入排序代码'" name="q_seq"  id="q_seq" ></input></td>				
		<td><a href="javascript:searchButton()"class="easyui-linkbutton" plain="true" iconCls="icon-search">查询</a></td>
	</tr>
</table>
</div>
<div data-options=" region:'center',iconCls: 'icon-table'" title="省市区编码表管理">
<table  id="listsysareadg" class="easyui-datagrid" style="width: 100%; height: 100%"
	data-options="
			region:'center',
			fit:true,
			border:false,
			remoteSort : false,
			toolbar: '#tb',
			pagination:true,
			rownumbers: true,
			checkbox:true,
			singleSelect:true,
			selectOnCheck:false,
			checkOnSelect:false,
			onDblClickRow:function(rowIndex, rowData){
								//SKY_EASYUI.beginEdit('listsysareadg',rowIndex);
						  },
			onLoadSuccess : function () {
        		$(this).datagrid('fixRownumber');
        		$(this).datagrid('doCellTip',{'max-width':'200px','delay':500});
    		}
		">
	<thead>
		<tr>
			<th data-options="field: 'checked', checkbox:true"></th>
				<th data-options="field:'code',width:180,
				editor:{
						type:'textbox',
						options:{
							required:true
						}}">行政区划编号</th>
				<th data-options="field:'name',width:180,
				editor:{
						type:'textbox',
						options:{
							required:true
						}}">名称</th>
				<th data-options="field:'parCode',width:180,
				editor:{
						type:'textbox',
						options:{
							required:true
						}}">上级代码</th>
				<th data-options="field:'seq',width:180,
				editor:{
						type:'textbox',
						options:{
							required:true
						}}">排序代码</th>
		</tr>
	</thead>
</table>
</div>
<div id="tb" style="height: auto">
	<a href="javascript:void(0)" class="easyui-linkbutton"
		data-options="iconCls:'icon-add',plain:true" onclick="addSysArea()">增加</a>
	<a href="javascript:void(0)" class="easyui-linkbutton"
		data-options="iconCls:'icon-edit',plain:true" onclick="editSysArea()">修改</a>
	<a href="javascript:void(0)" class="easyui-linkbutton"
		data-options="iconCls:'icon-20130408025545236_easyicon_net_30',plain:true" onclick="delSysArea()">删除</a>
	<a href="javascript:void(0)" class="easyui-linkbutton"
		data-options="iconCls:'icon-06',plain:true" onclick="detailSysArea()">查看明细</a>
</div>
</body>
</html>