<%@page import="org.sky.sys.utils.ConfUtils"%>
<%@page import="org.sky.sys.utils.EnumUtils"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@include file="/jsp/inc/include.jsp"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<security:csrfMetaTags/>
<script type="text/javascript" src='${basepath}jsp/txsb/txsb/listtbsttxsbbz.js'></script>
<script type="text/javascript">
var ywlx=<%=EnumUtils.getEnums("YWBL.YWLX") %>;
var xsdDegree=<%=ConfUtils.getValue("SIM_DEGREE") %>;
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
		<th><label>业务类型:</label></th>
		<td><input  class="easyui-textbox" data-options="prompt:'输入业务类型'" name="q_ywlx"  id="q_ywlx" ></input></td>				
		<th><label>业务编号:</label></th>
		<td><input  class="easyui-textbox" data-options="prompt:'输入业务编号'" name="q_ywbh"  id="q_ywbh" ></input></td>				
		<th><label>图像序号:</label></th>
		<td><input  class="easyui-textbox" data-options="prompt:'输入图像序号'" name="q_txxh"  id="q_txxh" ></input></td>				
		<td><a href="javascript:searchButton()"class="easyui-linkbutton" plain="true" iconCls="icon-search">查询</a></td>
	</tr>
</table>
</div>
<div data-options=" region:'center',iconCls: 'icon-table'" title="图像识别管理">
<table  id="listtbsttxsbdg" class="easyui-datagrid" style="width: 100%; height: 100%"
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
								dblClick(rowData);
								//SKY_EASYUI.beginEdit('listtbsttxsbdg',rowIndex);
						  },
			onLoadSuccess : function () {
        		$(this).datagrid('fixRownumber');
        		$(this).datagrid('doCellTip',{'max-width':'200px','delay':500});
    		},
    		rowStyler: function(index,row){
					if (row.xsd >= xsdDegree){
						return 'background-color:red;color:#fff;font-weight:bold;';
					}
			}
		">
	<thead>
		<tr>
			<th data-options="field: 'checked', checkbox:true"></th>
				<th data-options="field:'ywlx',width:180,
				formatter:function(value,row){
						  	 return SKY.formatterDict(value,row,ywlx);
						 }">业务类型</th>
				<th data-options="field:'ywbh',width:180,
				editor:{
						type:'textbox',
						options:{
							required:true
						}}">业务编号</th>
				<th data-options="field:'xsd',width:80,
				editor:{
						type:'textbox',
						options:{
							required:true
						}}">相似度</th>
				<th data-options="field:'ajbh',width:180,
				editor:{
						type:'textbox',
						options:{
							required:true
						}}">案件编号</th>
				<th data-options="field:'wz',width:180,
				editor:{
						type:'textbox',
						options:{
							required:true
						}}">位置</th>
				<th data-options="field:'sbsj',width:180,
				editor:{
						type:'textbox',
						options:{
							required:true
						}}">识别时间</th>
		</tr>
	</thead>
</table>
</div>
<div id="tb" style="height: auto">
	<a href="javascript:void(0)" class="easyui-linkbutton"
		data-options="iconCls:'icon-add',plain:true" onclick="addTbStTxsb()">增加</a>
	<a href="javascript:void(0)" class="easyui-linkbutton"
		data-options="iconCls:'icon-edit',plain:true" onclick="editTbStTxsb()">修改</a>
	<a href="javascript:void(0)" class="easyui-linkbutton"
		data-options="iconCls:'icon-20130408025545236_easyicon_net_30',plain:true" onclick="delTbStTxsb()">删除</a>
	<a href="javascript:void(0)" class="easyui-linkbutton"
		data-options="iconCls:'icon-06',plain:true" onclick="detailTbStTxsb()">查看明细</a>
</div>
</body>
</html>