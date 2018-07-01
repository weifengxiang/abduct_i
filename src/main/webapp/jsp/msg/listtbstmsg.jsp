<%@page import="org.sky.sys.utils.EnumUtils"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@include file="/jsp/inc/include.jsp"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<security:csrfMetaTags/>
<script type="text/javascript" src='${basepath}jsp/msg/listtbstmsg.js'></script>
<script type="text/javascript">
var state = <%=EnumUtils.getEnums("MSG.STATE") %>
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
		<th><label>信息接收手机号码:</label></th>
		<td><input  class="easyui-textbox" data-options="prompt:'输入信息接收手机号码'" name="q_receiverTel"  id="q_receiverTel" ></input></td>				
		<td><a href="javascript:searchButton()"class="easyui-linkbutton" plain="true" iconCls="icon-search">查询</a></td>
	</tr>
</table>
</div>
<div data-options=" region:'center',iconCls: 'icon-table'" title="短信发送管理">
<table  id="listtbstmsgdg" class="easyui-datagrid" style="width: 100%; height: 100%"
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
								//SKY_EASYUI.beginEdit('listtbstmsgdg',rowIndex);
						  },
			onLoadSuccess : function () {
        		$(this).datagrid('fixRownumber');
        		$(this).datagrid('doCellTip',{'max-width':'200px','delay':500});
    		}
		">
	<thead>
		<tr>
			<th data-options="field: 'checked', checkbox:true"></th>
				<th data-options="field:'receiver',width:180,
				editor:{
						type:'textbox',
						options:{
							required:true
						}}">接收人</th>
				<th data-options="field:'receiverTel',width:180,
				editor:{
						type:'textbox',
						options:{
							required:true
						}}">信息接收手机号码</th>
				<th data-options="field:'content',width:180,
				editor:{
						type:'textbox',
						options:{
							required:true
						}}">信息内容</th>
				<th data-options="field:'createTime',width:180">创建时间</th>
				<th data-options="field:'sendTime',width:180,
				editor:{
						type:'textbox',
						options:{
							required:true
						}}">发送时间</th>
				<th data-options="field:'state',width:180,
				formatter:function(value,row){
						  	 return SKY.formatterDict(value,row,state);
						 }">状态</th>
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
		data-options="iconCls:'icon-add',plain:true" onclick="addTbStMsg()">增加</a>
	<a href="javascript:void(0)" class="easyui-linkbutton"
		data-options="iconCls:'icon-edit',plain:true" onclick="editTbStMsg()">修改</a>
	<a href="javascript:void(0)" class="easyui-linkbutton"
		data-options="iconCls:'icon-20130408025545236_easyicon_net_30',plain:true" onclick="delTbStMsg()">删除</a>
	<a href="javascript:void(0)" class="easyui-linkbutton"
		data-options="iconCls:'icon-06',plain:true" onclick="detailTbStMsg()">查看明细</a>
</div>
</body>
</html>