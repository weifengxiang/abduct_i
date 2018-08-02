<%@page import="org.sky.sys.utils.EnumUtils"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@include file="/jsp/inc/include.jsp"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<security:csrfMetaTags/>
<script type="text/javascript" src='${basepath}jsp/xxbk/bksz/listtbstxxbk.js'></script>
<script type="text/javascript">
var bjlx = <%=EnumUtils.getEnums("XXBK.BJLX") %>;
var zt= <%=EnumUtils.getEnums("XXBK.ZT") %>;
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
		<td><input  class="easyui-textbox" data-options="prompt:'输入布控编号'" name="q_bh"  id="q_bh" ></input></td>				
		<th><label>布控内容:</label></th>
		<td><input  class="easyui-textbox" data-options="prompt:'输入布控内容'" name="q_bknr"  id="q_bknr" ></input></td>				
		<th><label>有效时间起:</label></th>
		<td><input  class="easyui-textbox" data-options="prompt:'输入有效时间起'" name="q_yxsjq"  id="q_yxsjq" ></input></td>				
		<th><label>有效时间至:</label></th>
		<td><input  class="easyui-textbox" data-options="prompt:'输入有效时间至'" name="q_yxsjz"  id="q_yxsjz" ></input></td>				
		<td><a href="javascript:searchButton()"class="easyui-linkbutton" plain="true" iconCls="icon-search">查询</a></td>
	</tr>
</table>
</div>
<div data-options=" region:'center',iconCls: 'icon-table'" title="信息布控管理">
<table  id="listtbstxxbkdg" class="easyui-datagrid" style="width: 100%; height: 100%"
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
								//SKY_EASYUI.beginEdit('listtbstxxbkdg',rowIndex);
						  },
			onLoadSuccess : function () {
        		$(this).datagrid('fixRownumber');
        		$(this).datagrid('doCellTip',{'max-width':'200px','delay':500});
    		}
		">
	<thead>
		<tr>
			<th data-options="field: 'checked', checkbox:true"></th>
				<th data-options="field:'bh',width:180,
				editor:{
						type:'textbox',
						options:{
							required:true
						}}">布控编号</th>
				<th data-options="field:'bknr',width:180,
				editor:{
						type:'textbox',
						options:{
							required:true
						}}">布控内容</th>
				<th data-options="field:'bkk',width:180,
				formatter:function(value,row){
						  	 if('10'==value){
						  	 	return '案件库';
						  	 }else if('01'==value){
						  	 	return '线索库';
						  	 }else if('11'==value){
						  	 	return '案件库，线索库';
						  	 }
						 }">布控库</th>
				<th data-options="field:'tyz',width:180,
				formatter:function(value,row){
						  	 if('00'==value){
						  	 	return '否';
						  	 }else if('01'==value){
						  	 	return '是';
						  	 }
						 }">同音字</th>
				<th data-options="field:'yxsjq',width:180,
				editor:{
						type:'textbox',
						options:{
							required:true
						}}">有效时间起</th>
				<th data-options="field:'yxsjz',width:180,
				editor:{
						type:'textbox',
						options:{
							required:true
						}}">有效时间至</th>
				<th data-options="field:'bjlx',width:80,
				formatter:function(value,row){
						  	 return SKY.formatterDict(value,row,bjlx);
						 }">报警类型</th>
				<th data-options="field:'zrrName',width:80,
				editor:{
						type:'textbox',
						options:{
							required:true
						}}">责任人</th>
				<th data-options="field:'zt',width:80,
				formatter:function(value,row){
						  	 return SKY.formatterDict(value,row,zt);
						 }">状态</th>
		</tr>
	</thead>
</table>
</div>
<div id="tb" style="height: auto">
	<a href="javascript:void(0)" class="easyui-linkbutton"
		data-options="iconCls:'icon-add',plain:true" onclick="addTbStXxbk()">增加</a>
	<a href="javascript:void(0)" class="easyui-linkbutton"
		data-options="iconCls:'icon-edit',plain:true" onclick="editTbStXxbk()">修改</a>
	<a href="javascript:void(0)" class="easyui-linkbutton"
		data-options="iconCls:'icon-20130408025545236_easyicon_net_30',plain:true" onclick="delTbStXxbk()">删除</a>
	<a href="javascript:void(0)" class="easyui-linkbutton"
		data-options="iconCls:'icon-06',plain:true" onclick="detailTbStXxbk()">查看明细</a>
</div>
</body>
</html>