<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@include file="/jsp/inc/include.jsp"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<security:csrfMetaTags/>
<script type="text/javascript" src='${basepath}jsp/ywbl/ajbl/listtbstajblxx.js'></script>
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
		<th><label>案件编号:</label></th>
		<td><input  class="easyui-textbox" data-options="prompt:'输入案件编号'" name="q_ajbh"  id="q_ajbh" ></input></td>				
		<th><label>办理结果(0:受理;1:办结):</label></th>
		<td><input  class="easyui-textbox" data-options="prompt:'输入办理结果(0:受理;1:办结)'" name="q_bljg"  id="q_bljg" ></input></td>				
		<th><label>办理意见:</label></th>
		<td><input  class="easyui-textbox" data-options="prompt:'输入办理意见'" name="q_blyj"  id="q_blyj" ></input></td>				
		<th><label>办理时间:</label></th>
		<td><input  class="easyui-textbox" data-options="prompt:'输入办理时间'" name="q_blsj"  id="q_blsj" ></input></td>				
		<th><label>办理人:</label></th>
		<td><input  class="easyui-textbox" data-options="prompt:'输入办理人'" name="q_blr"  id="q_blr" ></input></td>				
		<th><label>办理单位:</label></th>
		<td><input  class="easyui-textbox" data-options="prompt:'输入办理单位'" name="q_bldw"  id="q_bldw" ></input></td>				
		<th><label>备注:</label></th>
		<td><input  class="easyui-textbox" data-options="prompt:'输入备注'" name="q_bz"  id="q_bz" ></input></td>				
		<th><label>创建时间:</label></th>
		<td><input  class="easyui-textbox" data-options="prompt:'输入创建时间'" name="q_createrTime"  id="q_createrTime" ></input></td>				
		<th><label>修改时间:</label></th>
		<td><input  class="easyui-textbox" data-options="prompt:'输入修改时间'" name="q_updaterTime"  id="q_updaterTime" ></input></td>				
		<td><a href="javascript:searchButton()"class="easyui-linkbutton" plain="true" iconCls="icon-search">查询</a></td>
	</tr>
</table>
</div>
<div data-options=" region:'center',iconCls: 'icon-table'" title="案件办理信息管理">
<table  id="listtbstajblxxdg" class="easyui-datagrid" style="width: 100%; height: 100%"
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
								//SKY_EASYUI.beginEdit('listtbstajblxxdg',rowIndex);
						  },
			onLoadSuccess : function () {
        		$(this).datagrid('fixRownumber');
        		$(this).datagrid('doCellTip',{'max-width':'200px','delay':500});
    		}
		">
	<thead>
		<tr>
			<th data-options="field: 'checked', checkbox:true"></th>
				<th data-options="field:'ajbh',width:180,
				editor:{
						type:'textbox',
						options:{
							required:true
						}}">案件编号</th>
				<th data-options="field:'bljg',width:180,
				editor:{
						type:'textbox',
						options:{
							required:true
						}}">办理结果(0:受理;1:办结)</th>
				<th data-options="field:'blyj',width:180,
				editor:{
						type:'textbox',
						options:{
							required:true
						}}">办理意见</th>
				<th data-options="field:'blsj',width:180,
				editor:{
						type:'textbox',
						options:{
							required:true
						}}">办理时间</th>
				<th data-options="field:'blr',width:180,
				editor:{
						type:'textbox',
						options:{
							required:true
						}}">办理人</th>
				<th data-options="field:'bldw',width:180,
				editor:{
						type:'textbox',
						options:{
							required:true
						}}">办理单位</th>
				<th data-options="field:'bz',width:180,
				editor:{
						type:'textbox',
						options:{
							required:true
						}}">备注</th>
				<th data-options="field:'createrTime',width:180,
				editor:{
						type:'textbox',
						options:{
							required:true
						}}">创建时间</th>
				<th data-options="field:'updaterTime',width:180,
				editor:{
						type:'textbox',
						options:{
							required:true
						}}">修改时间</th>
		</tr>
	</thead>
</table>
</div>
<div id="tb" style="height: auto">
	<a href="javascript:void(0)" class="easyui-linkbutton"
		data-options="iconCls:'icon-add',plain:true" onclick="addTbStAjblxx()">增加</a>
	<a href="javascript:void(0)" class="easyui-linkbutton"
		data-options="iconCls:'icon-edit',plain:true" onclick="editTbStAjblxx()">修改</a>
	<a href="javascript:void(0)" class="easyui-linkbutton"
		data-options="iconCls:'icon-20130408025545236_easyicon_net_30',plain:true" onclick="delTbStAjblxx()">删除</a>
	<a href="javascript:void(0)" class="easyui-linkbutton"
		data-options="iconCls:'icon-06',plain:true" onclick="detailTbStAjblxx()">查看明细</a>
</div>
</body>
</html>