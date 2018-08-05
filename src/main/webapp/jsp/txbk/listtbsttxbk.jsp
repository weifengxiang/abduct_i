<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@include file="/jsp/inc/include.jsp"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<security:csrfMetaTags/>
<script type="text/javascript" src='${basepath}jsp/txbk/listtbsttxbk.js'></script>
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
		<th><label>视频编号:</label></th>
		<td><input  class="easyui-textbox" data-options="prompt:'输入视频编号'" name="q_txbh"  id="q_spbh" ></input></td>				
		<th><label>视频名称:</label></th>
		<td><input  class="easyui-textbox" data-options="prompt:'输入视频名称'" name="q_txmc"  id="q_spmc" ></input></td>				
		<th><label>布控库:</label></th>
		<td><input  class="easyui-textbox" data-options="prompt:'输入布控库'" name="q_bkk"  id="q_bkk" ></input></td>				
		<th><label>备注:</label></th>
		<td><input  class="easyui-textbox" data-options="prompt:'输入备注'" name="q_bz"  id="q_bz" ></input></td>				
		<td><a href="javascript:searchButton()"class="easyui-linkbutton" plain="true" iconCls="icon-search">查询</a></td>
	</tr>
</table>
</div>
<div data-options=" region:'west',iconCls: 'icon-table',split:true" title="图像布控管理" style='width:50%'>
<table  id="listtbsttxbkdg" class="easyui-datagrid" style="width: 100%; height: 100%"
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
								//SKY_EASYUI.beginEdit('listtbsttxbkdg',rowIndex);
						  },
			onClickRow:function(rowIndex, rowData){
								loadJG(rowData);
						  },
			onLoadSuccess : function () {
        		$(this).datagrid('fixRownumber');
        		$(this).datagrid('doCellTip',{'max-width':'200px','delay':500});
    		}
		">
	<thead>
		<tr>
			<th data-options="field: 'checked', checkbox:true"></th>
				<th data-options="field:'txbh',width:180,
				editor:{
						type:'textbox',
						options:{
							required:true
						}}">图像编号</th>
				<th data-options="field:'txmc',width:80,
				editor:{
						type:'textbox',
						options:{
							required:true
						}}">图像名称</th>
				<th data-options="field:'txnr',width:180,
				formatter:function(value,row){
						  	 if(0==value){
						  	 	return '无';
						  	 }else{
						  	 	return getImg(value);
						  	 }
						 }">图像</th>
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
<div data-options=" region:'center',iconCls: 'icon-table'" title="图像布控结果管理">
<table  id="listtbsttxbkjgdg" class="easyui-datagrid" style="width: 100%; height: 100%"
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
								//SKY_EASYUI.beginEdit('listtbsttxbkjgdg',rowIndex);
						  },
			onLoadSuccess : function () {
        		$(this).datagrid('fixRownumber');
        		$(this).datagrid('doCellTip',{'max-width':'200px','delay':500});
    		}
		">
	<thead>
		<tr>
			<th data-options="field: 'checked', checkbox:true"></th>
				<th data-options="field:'ywbh',width:180,
				editor:{
						type:'textbox',
						options:{
							required:true
						}}">业务编号</th>
				<th data-options="field:'xh',width:180,
				editor:{
						type:'textbox',
						options:{
							required:true
						}}">序号</th>
				<th data-options="field:'xsd',width:180,
				editor:{
						type:'textbox',
						options:{
							required:true
						}}">相似度</th>
				<th data-options="field:'bz',width:180,
				editor:{
						type:'textbox',
						options:{
							required:true
						}}">备注</th>
				<th data-options="field:'state',width:180,
				editor:{
						type:'textbox',
						options:{
							required:true
						}}">状态</th>
				<th data-options="field:'ope',width:180,
				formatter:function(value,row){
						  	 return renderBtn(value,row);
						 }">操作</th>
		</tr>
	</thead>
</table>
</div>
<div id="tb" style="height: auto">
	<a href="javascript:void(0)" class="easyui-linkbutton"
		data-options="iconCls:'icon-add',plain:true" onclick="addTbStTxbk()">增加</a>
	<a href="javascript:void(0)" class="easyui-linkbutton"
		data-options="iconCls:'icon-edit',plain:true" onclick="editTbStTxbk()">修改</a>
	<a href="javascript:void(0)" class="easyui-linkbutton"
		data-options="iconCls:'icon-20130408025545236_easyicon_net_30',plain:true" onclick="delTbStTxbk()">删除</a>
	<a href="javascript:void(0)" class="easyui-linkbutton"
		data-options="iconCls:'icon-06',plain:true" onclick="detailTbStTxbk()">查看明细</a>
</div>
</body>
</html>