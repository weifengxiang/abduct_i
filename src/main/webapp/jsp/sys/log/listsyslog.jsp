<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@include file="/jsp/inc/include.jsp"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<security:csrfMetaTags/>
<script type="text/javascript" src='${basepath}jsp/sys/log/listsyslog.js'></script>
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
		<th><label>操作用户:</label></th>
		<td><input  class="easyui-textbox" data-options="prompt:'输入操作用户'" name="q_userCode"  id="q_userCode" ></input></td>				
		<th><label>操作时间:</label></th>
		<td>
			<input class="easyui-datebox" data-options="prompt:'输入开始操作时间'" name="q_optTimeBegin"  id="q_optTimeBegin" ></input>
			<input class="easyui-datebox" data-options="prompt:'输入结束操作时间'" name="q_optTimeEnd"  id="q_optTimeEnd" ></input>
		</td>				
		
		<td><a href="javascript:searchButton()"class="easyui-linkbutton" plain="true" iconCls="icon-search">查询</a></td>
	</tr>
</table>
</div>
<div data-options=" region:'center',iconCls: 'icon-table'" title="日志表管理">
<table  id="listsyslogdg" class="easyui-datagrid" style="width: 100%; height: 100%"
	data-options="
			region:'center',
			fit:true,
			border:false,
			remoteSort : false,
			pagination:true,
			rownumbers: true,
			checkbox:true,
			singleSelect:true,
			selectOnCheck:false,
			checkOnSelect:false,
			onDblClickRow:function(rowIndex, rowData){
								//SKY_EASYUI.beginEdit('listsyslogdg',rowIndex);
						  },
			onLoadSuccess : function () {
        		$(this).datagrid('fixRownumber');
        		$(this).datagrid('doCellTip',{'max-width':'200px','delay':500});
    		}
		">
	<thead>
		<tr>
			<th data-options="field: 'checked', checkbox:true"></th>
				<th data-options="field:'userCode',width:180,
				editor:{
						type:'textbox',
						options:{
							required:true
						}}">操作用户</th>
				<th data-options="field:'optTime',width:180,
				editor:{
						type:'textbox',
						options:{
							required:true
						}}">操作时间</th>
				<th data-options="field:'ip',width:180,
				editor:{
						type:'textbox',
						options:{
							required:true
						}}">IP地址</th>
				<th data-options="field:'url',width:180,
				editor:{
						type:'textbox',
						options:{
							required:true
						}}">请求URL</th>
				<th data-options="field:'optName',width:180,
				editor:{
						type:'textbox',
						options:{
							required:true
						}}">执行操作</th>
				<th data-options="field:'optMethod',width:180,
				editor:{
						type:'textbox',
						options:{
							required:true
						}}">执行方法</th>
				<th data-options="field:'optParam',width:180,
				editor:{
						type:'textbox',
						options:{
							required:true
						}}">执行参数</th>
				<th data-options="field:'lastTime',width:180,
				editor:{
						type:'textbox',
						options:{
							required:true
						}}">消耗时间</th>
				<th data-options="field:'optResult',width:180,
				editor:{
						type:'textbox',
						options:{
							required:true
						}}">执行结果</th>
		</tr>
	</thead>
</table>
</div>
</body>
</html>