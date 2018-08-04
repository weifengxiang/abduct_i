<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@include file="/jsp/inc/include.jsp"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<security:csrfMetaTags/>
<script type="text/javascript" src='${basepath}jsp/txbk/listtbsttxbkjg.js'></script>
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
		<th><label>业务编号:</label></th>
		<td><input  class="easyui-textbox" data-options="prompt:'输入业务编号'" name="q_ywbh"  id="q_ywbh" ></input></td>				
		<th><label>序号:</label></th>
		<td><input  class="easyui-textbox" data-options="prompt:'输入序号'" name="q_xh"  id="q_xh" ></input></td>				
		<th><label>相似度:</label></th>
		<td><input  class="easyui-textbox" data-options="prompt:'输入相似度'" name="q_xsd"  id="q_xsd" ></input></td>				
		<th><label>备注:</label></th>
		<td><input  class="easyui-textbox" data-options="prompt:'输入备注'" name="q_bz"  id="q_bz" ></input></td>				
		<th><label>状态(00:未比中;01:比中):</label></th>
		<td><input  class="easyui-textbox" data-options="prompt:'输入状态(00:未比中;01:比中)'" name="q_state"  id="q_state" ></input></td>				
		<td><a href="javascript:searchButton()"class="easyui-linkbutton" plain="true" iconCls="icon-search">查询</a></td>
	</tr>
</table>
</div>
<div data-options=" region:'center',iconCls: 'icon-table'" title="图像布控结果管理">
<table  id="listtbsttxbkjgdg" class="easyui-datagrid" style="width: 100%; height: 100%"
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
						}}">状态(00:未比中;01:比中)</th>
		</tr>
	</thead>
</table>
</div>
<div id="tb" style="height: auto">
	<a href="javascript:void(0)" class="easyui-linkbutton"
		data-options="iconCls:'icon-add',plain:true" onclick="addTbStTxbkjg()">增加</a>
	<a href="javascript:void(0)" class="easyui-linkbutton"
		data-options="iconCls:'icon-edit',plain:true" onclick="editTbStTxbkjg()">修改</a>
	<a href="javascript:void(0)" class="easyui-linkbutton"
		data-options="iconCls:'icon-20130408025545236_easyicon_net_30',plain:true" onclick="delTbStTxbkjg()">删除</a>
	<a href="javascript:void(0)" class="easyui-linkbutton"
		data-options="iconCls:'icon-06',plain:true" onclick="detailTbStTxbkjg()">查看明细</a>
</div>
</body>
</html>