<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@include file="/jsp/inc/include.jsp"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<security:csrfMetaTags/>
<script type="text/javascript" src='${basepath}jsp/sjzq/sjzq/listtbstsjzq.js'></script>
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
		<th><label>寻亲编号:</label></th>
		<td><input  class="easyui-textbox" data-options="prompt:'输入寻亲编号'" name="q_xqbh"  id="q_xqbh" ></input></td>				
		<th><label>姓名:</label></th>
		<td><input  class="easyui-textbox" data-options="prompt:'输入姓名'" name="q_xm"  id="q_xm" ></input></td>
		<th><label>失踪人所在地:</label></th>
		<td><input  class="easyui-textbox" data-options="prompt:'输入失踪人所在地'" name="q_szrszd"  id="q_szrszd" ></input></td>
		<th><label>失踪地点:</label></th>
		<td><input  class="easyui-textbox" data-options="prompt:'输入失踪地点'" name="q_szdd"  id="q_szdd" ></input></td>				
		<td><a href="javascript:searchButton()"class="easyui-linkbutton" plain="true" iconCls="icon-search">查询</a></td>
	</tr>
</table>
</div>
<div data-options=" region:'center',iconCls: 'icon-table'" title="数据抓取管理">
<table  id="listtbstsjzqdg" class="easyui-datagrid" style="width: 100%; height: 100%"
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
								dblclickFun(rowData);
								//SKY_EASYUI.beginEdit('listtbstsjzqdg',rowIndex);
						  },
			onLoadSuccess : function () {
        		$(this).datagrid('fixRownumber');
        		$(this).datagrid('doCellTip',{'max-width':'200px','delay':500});
    		}
		">
	<thead>
		<tr>
			<th data-options="field: 'checked', checkbox:true"></th>
				<th data-options="field:'tx',width:180,styler:cellStyler,
				formatter:function(value,row){
						  	 if(0==value){
						  	 	return '无';
						  	 }else{
						  	 	return getImg(row.xqbh);
						  	 }
						 }">是否有图像</th>
				<th data-options="field:'xqlb',width:180,
				editor:{
						type:'textbox',
						options:{
							required:true
						}}">寻亲类别</th>
				<th data-options="field:'xqbh',width:180,
				editor:{
						type:'textbox',
						options:{
							required:true
						}}">寻亲编号</th>
				<th data-options="field:'xm',width:180,
				editor:{
						type:'textbox',
						options:{
							required:true
						}}">姓名</th>
				<th data-options="field:'xb',width:180,
				editor:{
						type:'textbox',
						options:{
							required:true
						}}">性别</th>
				<th data-options="field:'csrq',width:180,
				editor:{
						type:'textbox',
						options:{
							required:true
						}}">出生日期</th>
				<th data-options="field:'szssg',width:180,
				editor:{
						type:'textbox',
						options:{
							required:true
						}}">失踪时身高</th>
				<th data-options="field:'szsj',width:180,
				editor:{
						type:'textbox',
						options:{
							required:true
						}}">失踪时间</th>
				<th data-options="field:'szrszd',width:180,
				editor:{
						type:'textbox',
						options:{
							required:true
						}}">失踪人所在地</th>
				<th data-options="field:'szdd',width:180,
				editor:{
						type:'textbox',
						options:{
							required:true
						}}">失踪地点</th>
				<th data-options="field:'xqztzms',width:180,
				editor:{
						type:'textbox',
						options:{
							required:true
						}}">寻亲者特征描述</th>
				<th data-options="field:'qtzl',width:180,
				editor:{
						type:'textbox',
						options:{
							required:true
						}}">其他资料</th>
				<th data-options="field:'zcsj',width:180,
				editor:{
						type:'textbox',
						options:{
							required:true
						}}">注册时间</th>
				<th data-options="field:'gjzyz',width:180,
				editor:{
						type:'textbox',
						options:{
							required:true
						}}">跟进志愿者</th>
				<th data-options="field:'yswz',width:180,
				editor:{
						type:'textbox',
						options:{
							required:true
						}}">原始网址</th>
				<th data-options="field:'note',width:180,
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
<!-- 
	<a href="javascript:void(0)" class="easyui-linkbutton"
		data-options="iconCls:'icon-add',plain:true" onclick="addTbStSjzq()">增加</a>
	<a href="javascript:void(0)" class="easyui-linkbutton"
		data-options="iconCls:'icon-edit',plain:true" onclick="editTbStSjzq()">修改</a>
	<a href="javascript:void(0)" class="easyui-linkbutton"
		data-options="iconCls:'icon-20130408025545236_easyicon_net_30',plain:true" onclick="delTbStSjzq()">删除</a>
 -->
 	<a href="javascript:void(0)" class="easyui-linkbutton"
		data-options="iconCls:'icon-save',plain:true" onclick="expExcel()">导出</a>
	<a href="javascript:void(0)" class="easyui-linkbutton"
		data-options="iconCls:'icon-06',plain:true" onclick="detailTbStSjzq()">查看明细</a>
</div>
</body>
</html>