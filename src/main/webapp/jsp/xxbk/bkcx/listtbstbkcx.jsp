<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@include file="/jsp/inc/include.jsp"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<security:csrfMetaTags/>
<script type="text/javascript" src='${basepath}jsp/xxbk/bkcx/listtbstbkcx.js'></script>
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
		<th><label>布控编号:</label></th>
		<td><input  class="easyui-textbox" data-options="prompt:'输入布控编号'" name="q_bkbh"  id="q_bkbh" ></input></td>				
		<th><label>业务类型:</label></th>
		<td><input  class="easyui-textbox" data-options="prompt:'输入业务类型'" name="q_ywlx"  id="q_ywlx" ></input></td>				
		<th><label>业务编号:</label></th>
		<td><input  class="easyui-textbox" data-options="prompt:'输入业务编号'" name="q_ywbh"  id="q_ywbh" ></input></td>				
		<th><label>监控时间:</label></th>
		<td><input  class="easyui-textbox" data-options="prompt:'输入监控时间'" name="q_jksj"  id="q_jksj" ></input></td>				
		<th><label>状态:</label></th>
		<td><input  class="easyui-textbox" data-options="prompt:'输入状态'" name="q_zt"  id="q_zt" ></input></td>				
		<th><label>备注:</label></th>
		<td><input  class="easyui-textbox" data-options="prompt:'输入备注'" name="q_bz"  id="q_bz" ></input></td>				
		<td><a href="javascript:searchButton()"class="easyui-linkbutton" plain="true" iconCls="icon-search">查询</a></td>
	</tr>
</table>
</div>
<div data-options=" region:'center',iconCls: 'icon-table'" title="布控查询管理">
<table  id="listtbstbkcxdg" class="easyui-datagrid" style="width: 100%; height: 100%"
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
								//SKY_EASYUI.beginEdit('listtbstbkcxdg',rowIndex);
						  },
			onLoadSuccess : function () {
        		$(this).datagrid('fixRownumber');
        		$(this).datagrid('doCellTip',{'max-width':'200px','delay':500});
    		}
		">
	<thead>
		<tr>
			<th data-options="field: 'checked', checkbox:true"></th>
				<th data-options="field:'bkbh',width:180,
				editor:{
						type:'textbox',
						options:{
							required:true
						}}">布控编号</th>
				<th data-options="field:'ywlx',width:180,
				editor:{
						type:'textbox',
						options:{
							required:true
						}}">业务类型</th>
				<th data-options="field:'ywbh',width:180,
				editor:{
						type:'textbox',
						options:{
							required:true
						}}">业务编号</th>
				<th data-options="field:'jksj',width:180,
				editor:{
						type:'textbox',
						options:{
							required:true
						}}">监控时间</th>
				<th data-options="field:'zt',width:180,
				editor:{
						type:'textbox',
						options:{
							required:true
						}}">状态</th>
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
		data-options="iconCls:'icon-add',plain:true" onclick="addTbStBkcx()">增加</a>
	<a href="javascript:void(0)" class="easyui-linkbutton"
		data-options="iconCls:'icon-edit',plain:true" onclick="editTbStBkcx()">修改</a>
	<a href="javascript:void(0)" class="easyui-linkbutton"
		data-options="iconCls:'icon-20130408025545236_easyicon_net_30',plain:true" onclick="delTbStBkcx()">删除</a>
	<a href="javascript:void(0)" class="easyui-linkbutton"
		data-options="iconCls:'icon-06',plain:true" onclick="detailTbStBkcx()">查看明细</a>
</div>
</body>
</html>