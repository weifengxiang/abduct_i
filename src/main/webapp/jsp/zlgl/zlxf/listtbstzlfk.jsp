<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@include file="/jsp/inc/include.jsp"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<security:csrfMetaTags/>
<script type="text/javascript" src='${basepath}jsp/zlgl/zlxf/listtbstzlfk.js'></script>
<script type="text/javascript">
$(function() {
	//init();
});
</script> 
</head>
<body class="easyui-layout" style="width: 100%; height: 100%; padding: 0; border: 0"
	  data-options='border:false,fit:true'>
<div data-options=" region:'center',iconCls: 'icon-table'" title="">
<table  id="listtbstzlfkdg" class="easyui-datagrid" style="width: 100%; height: 100%"
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
								//SKY_EASYUI.beginEdit('listtbstzlfkdg',rowIndex);
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
				<th data-options="field:'jssj',width:180,
				editor:{
						type:'textbox',
						options:{
							required:true
						}}">接收时间</th>
				<th data-options="field:'fksj',width:180,
				editor:{
						type:'textbox',
						options:{
							required:true
						}}">反馈时间</th>
				<th data-options="field:'fknr',width:180,
				editor:{
						type:'textbox',
						options:{
							required:true
						}}">反馈内容</th>
				<th data-options="field:'zt',width:180,
				editor:{
						type:'textbox',
						options:{
							required:true
						}}">状态(0,1,2)</th>
		</tr>
	</thead>
</table>
</div>
</body>
</html>