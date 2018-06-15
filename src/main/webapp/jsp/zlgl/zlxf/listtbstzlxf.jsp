<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@include file="/jsp/inc/include.jsp"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<security:csrfMetaTags/>
<script type="text/javascript" src='${basepath}jsp/zlgl/zlxf/listtbstzlxf.js'></script>
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
		<th><label>指令编号:</label></th>
		<td><input  class="easyui-textbox" data-options="prompt:'输入指令编号'" name="q_zlbh"  id="q_zlbh" ></input></td>				
		<th><label>指令名称:</label></th>
		<td><input  class="easyui-textbox" data-options="prompt:'输入指令名称'" name="q_zlmc"  id="q_zlmc" ></input></td>				
		<th><label>指令内容:</label></th>
		<td><input  class="easyui-textbox" data-options="prompt:'输入指令内容'" name="q_zlnr"  id="q_zlnr" ></input></td>				
		<th><label>下发时间:</label></th>
		<td><input  class="easyui-datebox" data-options="prompt:'输入下发时间'" name="q_xfsj"  id="q_xfsj" ></input></td>				
		<td><a href="javascript:searchButton()"class="easyui-linkbutton" plain="true" iconCls="icon-search">查询</a></td>
	</tr>
</table>
</div>
<div data-options=" region:'center',iconCls: 'icon-table'" title="指令下发管理">
<table  id="listtbstzlxfdg" class="easyui-datagrid" style="width: 100%; height: 100%"
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
								//SKY_EASYUI.beginEdit('listtbstzlxfdg',rowIndex);
						  },
			onLoadSuccess : function () {
        		$(this).datagrid('fixRownumber');
        		$(this).datagrid('doCellTip',{'max-width':'200px','delay':500});
    		}
		">
	<thead>
		<tr>
			<th data-options="field: 'checked', checkbox:true"></th>
				<th data-options="field:'zlbh',width:180,
				editor:{
						type:'textbox',
						options:{
							required:true
						}}">指令编号</th>
				<th data-options="field:'zlmc',width:180,
				editor:{
						type:'textbox',
						options:{
							required:true
						}}">指令名称</th>
				<th data-options="field:'zlnr',width:180,
				editor:{
						type:'textbox',
						options:{
							required:true
						}}">指令内容</th>
				<th data-options="field:'xfdwName',width:180,
				editor:{
						type:'textbox',
						options:{
							required:true
						}}">下发单位</th>
				<th data-options="field:'jsdwName',width:180,
				editor:{
						type:'textbox',
						options:{
							required:true
						}}">接收单位</th>
				<th data-options="field:'xfsj',width:180,
				editor:{
						type:'textbox',
						options:{
							required:true
						}}">下发时间</th>
				<th data-options="field:'createTime',width:160">下发时间</th>
		</tr>
	</thead>
</table>
</div>
<div id="tb" style="height: auto">
	<a href="javascript:void(0)" class="easyui-linkbutton"
		data-options="iconCls:'icon-add',plain:true" onclick="addTbStZlxf()">增加</a>
	<a href="javascript:void(0)" class="easyui-linkbutton"
		data-options="iconCls:'icon-edit',plain:true" onclick="editTbStZlxf()">修改</a>
	<a href="javascript:void(0)" class="easyui-linkbutton"
		data-options="iconCls:'icon-20130408025545236_easyicon_net_30',plain:true" onclick="delTbStZlxf()">删除</a>
	<a href="javascript:void(0)" class="easyui-linkbutton"
		data-options="iconCls:'icon-06',plain:true" onclick="detailTbStZlxf()">查看明细</a>
	<a href="javascript:void(0)" class="easyui-linkbutton"
		data-options="iconCls:'icon-06',plain:true" onclick="detailTbStZlfk()">查看反馈情况</a>
</div>
</body>
</html>