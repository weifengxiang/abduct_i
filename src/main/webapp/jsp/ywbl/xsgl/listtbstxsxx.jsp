<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@include file="/jsp/inc/include.jsp"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<security:csrfMetaTags/>
<script type="text/javascript" src='${basepath}jsp/ywbl/xsgl/listtbstxsxx.js'></script>
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
		<th><label>线索编号:</label></th>
		<td><input  class="easyui-textbox" data-options="prompt:'输入线索编号'" name="q_ajbh"  id="q_ajbh" ></input></td>				
		<th><label>举报人:</label></th>
		<td><input  class="easyui-textbox" data-options="prompt:'输入举报人'" name="q_jbr"  id="q_jbr" ></input></td>				
		<th><label>举报人证件类型:</label></th>
		<td><input  class="easyui-textbox" data-options="prompt:'输入举报人证件类型'" name="q_zjlx"  id="q_zjlx" ></input></td>				
		<th><label>举报人证件号码:</label></th>
		<td><input  class="easyui-textbox" data-options="prompt:'输入举报人证件号码'" name="q_zjhm"  id="q_zjhm" ></input></td>				
		<th><label>电话:</label></th>
		<td><input  class="easyui-textbox" data-options="prompt:'输入电话'" name="q_dh"  id="q_dh" ></input></td>				
		<th><label>事发地:</label></th>
		<td><input  class="easyui-textbox" data-options="prompt:'输入事发地'" name="q_sfd"  id="q_sfd" ></input></td>				
		<th><label>事件详情:</label></th>
		<td><input  class="easyui-textbox" data-options="prompt:'输入事件详情'" name="q_sjxq"  id="q_sjxq" ></input></td>				
		<th><label>线索来源:</label></th>
		<td><input  class="easyui-textbox" data-options="prompt:'输入线索来源'" name="q_xsly"  id="q_xsly" ></input></td>				
		<th><label>登记人:</label></th>
		<td><input  class="easyui-textbox" data-options="prompt:'输入登记人'" name="q_djr"  id="q_djr" ></input></td>				
		<th><label>登记单位:</label></th>
		<td><input  class="easyui-textbox" data-options="prompt:'输入登记单位'" name="q_djdw"  id="q_djdw" ></input></td>				
		<th><label>登记时间:</label></th>
		<td><input  class="easyui-textbox" data-options="prompt:'输入登记时间'" name="q_djsj"  id="q_djsj" ></input></td>				
		<th><label>状态:</label></th>
		<td><input  class="easyui-textbox" data-options="prompt:'输入状态'" name="q_zt"  id="q_zt" ></input></td>				
		<th><label>备注:</label></th>
		<td><input  class="easyui-textbox" data-options="prompt:'输入备注'" name="q_bz"  id="q_bz" ></input></td>				
		<td><a href="javascript:searchButton()"class="easyui-linkbutton" plain="true" iconCls="icon-search">查询</a></td>
	</tr>
</table>
</div>
<div data-options=" region:'center',iconCls: 'icon-table'" title="线索信息管理">
<table  id="listtbstxsxxdg" class="easyui-datagrid" style="width: 100%; height: 100%"
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
								//SKY_EASYUI.beginEdit('listtbstxsxxdg',rowIndex);
						  },
			onLoadSuccess : function () {
        		$(this).datagrid('fixRownumber');
        		$(this).datagrid('doCellTip',{'max-width':'200px','delay':500});
    		}
		">
	<thead>
		<tr>
			<th data-options="field: 'checked', checkbox:true"></th>
				<th data-options="field:'ajbh',width:180,
				editor:{
						type:'textbox',
						options:{
							required:true
						}}">线索编号</th>
				<th data-options="field:'jbr',width:180,
				editor:{
						type:'textbox',
						options:{
							required:true
						}}">举报人</th>
				<th data-options="field:'zjlx',width:180,
				editor:{
						type:'textbox',
						options:{
							required:true
						}}">举报人证件类型</th>
				<th data-options="field:'zjhm',width:180,
				editor:{
						type:'textbox',
						options:{
							required:true
						}}">举报人证件号码</th>
				<th data-options="field:'dh',width:180,
				editor:{
						type:'textbox',
						options:{
							required:true
						}}">电话</th>
				<th data-options="field:'sfd',width:180,
				editor:{
						type:'textbox',
						options:{
							required:true
						}}">事发地</th>
				<th data-options="field:'sjxq',width:180,
				editor:{
						type:'textbox',
						options:{
							required:true
						}}">事件详情</th>
				<th data-options="field:'xsly',width:180,
				editor:{
						type:'textbox',
						options:{
							required:true
						}}">线索来源</th>
				<th data-options="field:'djr',width:180,
				editor:{
						type:'textbox',
						options:{
							required:true
						}}">登记人</th>
				<th data-options="field:'djdw',width:180,
				editor:{
						type:'textbox',
						options:{
							required:true
						}}">登记单位</th>
				<th data-options="field:'djsj',width:180,
				editor:{
						type:'textbox',
						options:{
							required:true
						}}">登记时间</th>
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
		data-options="iconCls:'icon-add',plain:true" onclick="addTbStXsxx()">增加</a>
	<a href="javascript:void(0)" class="easyui-linkbutton"
		data-options="iconCls:'icon-edit',plain:true" onclick="editTbStXsxx()">修改</a>
	<a href="javascript:void(0)" class="easyui-linkbutton"
		data-options="iconCls:'icon-20130408025545236_easyicon_net_30',plain:true" onclick="delTbStXsxx()">删除</a>
	<a href="javascript:void(0)" class="easyui-linkbutton"
		data-options="iconCls:'icon-06',plain:true" onclick="detailTbStXsxx()">查看明细</a>
</div>
</body>
</html>