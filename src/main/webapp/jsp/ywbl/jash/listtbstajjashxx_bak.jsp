<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@include file="/jsp/inc/include.jsp"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<security:csrfMetaTags/>
<script type="text/javascript" src='${basepath}jsp/ywbl/jash/listtbstajjashxx.js'></script>
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
		<th><label>审核结果:</label></th>
		<td><input  class="easyui-textbox" data-options="prompt:'输入审核结果'" name="q_shjg"  id="q_shjg" ></input></td>				
		<th><label>审核意见:</label></th>
		<td><input  class="easyui-textbox" data-options="prompt:'输入审核意见'" name="q_shyj"  id="q_shyj" ></input></td>				
		<th><label>审核单位:</label></th>
		<td><input  class="easyui-textbox" data-options="prompt:'输入审核单位'" name="q_shdw"  id="q_shdw" ></input></td>				
		<th><label>审核时间:</label></th>
		<td><input  class="easyui-textbox" data-options="prompt:'输入审核时间'" name="q_shsj"  id="q_shsj" ></input></td>				
		<th><label>审核人:</label></th>
		<td><input  class="easyui-textbox" data-options="prompt:'输入审核人'" name="q_shr"  id="q_shr" ></input></td>				
		<th><label>备注:</label></th>
		<td><input  class="easyui-textbox" data-options="prompt:'输入备注'" name="q_bz"  id="q_bz" ></input></td>				
		<td><a href="javascript:searchButton()"class="easyui-linkbutton" plain="true" iconCls="icon-search">查询</a></td>
	</tr>
</table>
</div>
<div data-options=" region:'center',iconCls: 'icon-table'" title="案件结案审核信息管理">
<table  id="listtbstajjashxxdg" class="easyui-datagrid" style="width: 100%; height: 100%"
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
								//SKY_EASYUI.beginEdit('listtbstajjashxxdg',rowIndex);
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
				<th data-options="field:'shjg',width:180,
				editor:{
						type:'textbox',
						options:{
							required:true
						}}">审核结果</th>
				<th data-options="field:'shyj',width:180,
				editor:{
						type:'textbox',
						options:{
							required:true
						}}">审核意见</th>
				<th data-options="field:'shdw',width:180,
				editor:{
						type:'textbox',
						options:{
							required:true
						}}">审核单位</th>
				<th data-options="field:'shsj',width:180,
				editor:{
						type:'textbox',
						options:{
							required:true
						}}">审核时间</th>
				<th data-options="field:'shr',width:180,
				editor:{
						type:'textbox',
						options:{
							required:true
						}}">审核人</th>
				<th data-options="field:'bz',width:180,
				editor:{
						type:'textbox',
						options:{
							required:true
						}}">备注</th>
		</tr>
	</thead>
</table>
</div>
<div id="tb" style="height: auto">
	<a href="javascript:void(0)" class="easyui-linkbutton"
		data-options="iconCls:'icon-add',plain:true" onclick="addTbStAjjashxx()">增加</a>
	<a href="javascript:void(0)" class="easyui-linkbutton"
		data-options="iconCls:'icon-edit',plain:true" onclick="editTbStAjjashxx()">修改</a>
	<a href="javascript:void(0)" class="easyui-linkbutton"
		data-options="iconCls:'icon-20130408025545236_easyicon_net_30',plain:true" onclick="delTbStAjjashxx()">删除</a>
	<a href="javascript:void(0)" class="easyui-linkbutton"
		data-options="iconCls:'icon-06',plain:true" onclick="detailTbStAjjashxx()">查看明细</a>
</div>
</body>
</html>