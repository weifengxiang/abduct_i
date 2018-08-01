<%@page import="org.sky.sys.utils.EnumUtils"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@include file="/jsp/inc/include.jsp"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<security:csrfMetaTags/>
<script type="text/javascript" src='${basepath}jsp/spsb/listtbstspxx.js'></script>
<script type="text/javascript">
var zt = <%=EnumUtils.getEnums("VIDEO.ZT") %>;
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
		<td><input  class="easyui-textbox" data-options="prompt:'输入视频编号'" name="q_spbh"  id="q_spbh" ></input></td>				
		<th><label>视频名称:</label></th>
		<td><input  class="easyui-textbox" data-options="prompt:'输入视频名称'" name="q_spmc"  id="q_spmc" ></input></td>				
		<td><a href="javascript:searchButton()"class="easyui-linkbutton" plain="true" iconCls="icon-search">查询</a></td>
	</tr>
</table>
</div>
<div data-options=" region:'west',iconCls: 'icon-table',split:true" title="视频信息管理" width='50%'>
<table  id="listtbstspxxdg" class="easyui-datagrid" style="width: 100%; height: 100%"
	data-options="
			region:'center',
			fit:true,
			border:false,
			remoteSort : false,
			toolbar: '#sptb',
			pagination:true,
			rownumbers: true,
			checkbox:true,
			singleSelect:true,
			selectOnCheck:false,
			checkOnSelect:false,
			onClickRow:function(rowIndex,rowData){
				loadSpTxList(rowData.spbh);
			},
			onDblClickRow:function(rowIndex, rowData){
								//SKY_EASYUI.beginEdit('listtbstspxxdg',rowIndex);
						  },
			onLoadSuccess : function () {
        		$(this).datagrid('fixRownumber');
        		$(this).datagrid('doCellTip',{'max-width':'200px','delay':500});
    		}
		">
	<thead>
		<tr>
			<th data-options="field: 'checked', checkbox:true"></th>
				<th data-options="field:'spbh',width:180,
				editor:{
						type:'textbox',
						options:{
							required:true
						}}">视频编号</th>
				<th data-options="field:'spmc',width:180,
				editor:{
						type:'textbox',
						options:{
							required:true
						}}">视频名称</th>
				<th data-options="field:'splj',width:180,
				editor:{
						type:'textbox',
						options:{
							required:true
						}}">路径</th>
		</tr>
	</thead>
</table>
</div>
<div data-options=" region:'center',iconCls: 'icon-table'" title="图片信息管理">
	<table  id="listtbstsptxdg" class="easyui-datagrid" style="width: 100%; height: 100%"
	data-options="
			region:'center',
			fit:true,
			border:false,
			remoteSort : false,
			toolbar: '#tptb',
			pagination:true,
			rownumbers: true,
			checkbox:true,
			singleSelect:true,
			selectOnCheck:false,
			checkOnSelect:false,
			onDblClickRow:function(rowIndex, rowData){
								//SKY_EASYUI.beginEdit('listtbstsptxdg',rowIndex);
						  },
			onLoadSuccess : function () {
        		$(this).datagrid('fixRownumber');
        		$(this).datagrid('doCellTip',{'max-width':'200px','delay':500});
    		}
		">
	<thead>
		<tr>
			<th data-options="field: 'checked', checkbox:true"></th>
				<th data-options="field:'txnr',width:180,
				formatter:function(value,row){
						  	 if(0==value){
						  	 	return '无';
						  	 }else{
						  	 	return getImg(row.id);
						  	 }
						 }">图像内容</th>
				<th data-options="field:'spbh',width:180,
				editor:{
						type:'textbox',
						options:{
							required:true
						}}">视频编号</th>
				<th data-options="field:'zt',width:180,
				formatter:function(value,row){
						  	 return SKY.formatterDict(value,row,zt);
						 }">状态</th>
				<th data-options="field:'spwjmc',width:180">视频文件名称</th>
				<th data-options="field:'jt',width:180,
				formatter:function(value,row){
						  	 if(0==value){
						  	 	return '无';
						  	 }else{
						  	 	return getImgJt(row.id);
						  	 }
						 }">比中视频截图</th>
				<th data-options="field:'xsd',width:180,
				editor:{
						type:'textbox',
						options:{
							required:true
						}}">相似度</th>
		</tr>
	</thead>
	</table>
</div>
<div id="sptb" style="height: auto">
	<a href="javascript:void(0)" class="easyui-linkbutton"
		data-options="iconCls:'icon-add',plain:true" onclick="addTbStSpxx()">上传视频</a>
	<a href="javascript:void(0)" class="easyui-linkbutton"
		data-options="iconCls:'icon-20130408025545236_easyicon_net_30',plain:true" onclick="delTbStSpxx()">删除视频</a>
	<a href="javascript:void(0)" class="easyui-linkbutton"
		data-options="iconCls:'icon-06',plain:true" onclick="downloadSysFile()">下载视频</a>
</div>
<div id="tptb" style="height: auto">
	<a href="javascript:void(0)" class="easyui-linkbutton"
		data-options="iconCls:'icon-add',plain:true" onclick="addTbStSpTx()">增加图片</a>
	<a href="javascript:void(0)" class="easyui-linkbutton"
		data-options="iconCls:'icon-20130408025545236_easyicon_net_30',plain:true" onclick="delTbStSpTx()">删除图片</a>

</div>
</body>
</html>