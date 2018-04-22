<%@page import="org.sky.sys.utils.CommonUtils"%>
<%@page import="org.sky.sys.utils.DictUtils"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@include file="/jsp/inc/include.jsp"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<security:csrfMetaTags/>
<script type="text/javascript" src='${basepath}jsp/ywbl/jash/listtbstajjashxx.js'></script>
<script type="text/javascript">
var djsj = '<%=CommonUtils.getCurrentDate() %>';
var bjfs = <%=DictUtils.getDictItem("BJFS") %>;
var bjlb = <%=DictUtils.getDictItem("BJLB") %>;
var bjlx = <%=DictUtils.getDictItem("BJLX") %>;
var bjxl = <%=DictUtils.getDictItem("BJXL") %>;
var lhlb = <%=DictUtils.getDictItem("LHLB") %>;
var sjzt = <%=DictUtils.getDictItem("SJZT") %>;
var ajly = <%=DictUtils.getDictItem("AJLY") %>;
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
		<th><label>案件编号:</label></th>
		<td><input  class="easyui-textbox" data-options="prompt:'输入案件编号'" name="q_ajbh"  id="q_ajbh" ></input></td>				
		<th><label>报警时间:</label></th>
		<td><input  class="easyui-textbox" data-options="prompt:'输入报警时间'" name="q_bjsj"  id="q_bjsj" ></input></td>				
		<th><label>联系电话:</label></th>
		<td><input  class="easyui-textbox" data-options="prompt:'输入联系电话'" name="q_lxdh"  id="q_lxdh" ></input></td>				
		<th><label>登记时间:</label></th>
		<td><input  class="easyui-datebox" data-options="prompt:'输入登记时间'" name="q_djsj"  id="q_djsj" ></input></td>				
		<td><a href="javascript:searchButton()"class="easyui-linkbutton" plain="true" iconCls="icon-search">查询</a></td>
	</tr>
</table>
</div>
<div data-options=" region:'center',iconCls: 'icon-table'" title="案件登记信息管理">
<table  id="listtbstajdjxxdg" class="easyui-datagrid" style="width: 100%; height: 100%"
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
								//SKY_EASYUI.beginEdit('listtbstajdjxxdg',rowIndex);
						  },
			onLoadSuccess : function () {
        		$(this).datagrid('fixRownumber');
        		$(this).datagrid('doCellTip',{'max-width':'200px','delay':500});
    		}
		">
	<thead>
		<tr>
			<th data-options="field: 'checked', checkbox:true"></th>
				<th data-options="field:'ajbh',width:180">案件编号</th>
				<th data-options="field:'bjsj',width:80">报警时间</th>
				<th data-options="field:'ssfj',width:80">所属分局</th>
				<th data-options="field:'lxdh',width:80">联系电话</th>
				<th data-options="field:'bjfs',width:80,
				formatter:function(value,row){
						  	 return SKY.formatterDict(value,row,bjfs);
						 }">报警方式</th>
				<th data-options="field:'bjlb',width:80,
				formatter:function(value,row){
						  	 return SKY.formatterDict(value,row,bjlb);
						 }">报警类别</th>
				<th data-options="field:'bjlx',width:80,
				formatter:function(value,row){
						  	 return SKY.formatterDict(value,row,bjlx);
						 }">报警类型</th>
				<th data-options="field:'bjxl',width:80,
				formatter:function(value,row){
						  	 return SKY.formatterDict(value,row,bjxl);
						 }">报警细类</th>
				<th data-options="field:'sfdz',width:80">事发地址</th>
				<th data-options="field:'lhlb',width:80,
				formatter:function(value,row){
						  	 return SKY.formatterDict(value,row,lhlb);
						 }">来话类别</th>
				<th data-options="field:'bjr',width:80">报警人</th>
				<th data-options="field:'sjxq',width:80">事件详情</th>
				<th data-options="field:'xqdw',width:80">辖区单位</th>
				<th data-options="field:'xzqh',width:80">行政区划</th>
				<th data-options="field:'cjr',width:80">出警人</th>
				<th data-options="field:'dcsj',width:80">到场时间</th>
				<th data-options="field:'dcqk',width:80">到场情况</th>
				<th data-options="field:'fknr',width:80">反馈内容</th>
				<th data-options="field:'cljg',width:80">处理结果</th>
				<th data-options="field:'sjzt',width:60,
				formatter:function(value,row){
						  	 return SKY.formatterDict(value,row,sjzt);
						 }">事件状态</th>
				<th data-options="field:'jwq',width:80">警务区</th>
				<th data-options="field:'dqdwName',width:80">当前单位</th>
				<th data-options="field:'ajly',width:80,
				formatter:function(value,row){
						  	 return SKY.formatterDict(value,row,ajly);
						 }">案件来源</th>
				<th data-options="field:'djrName',width:80">登记人</th>
				<th data-options="field:'djdwName',width:80">登记单位</th>
				<th data-options="field:'djsj',width:80">登记时间</th>
		</tr>
	</thead>
</table>
</div>
<div id="tb" style="height: auto">
	<a href="javascript:void(0)" class="easyui-linkbutton"
		data-options="iconCls:'icon-add',plain:true" onclick="doJash()">结案审核</a>
	<a href="javascript:void(0)" class="easyui-linkbutton"
		data-options="iconCls:'icon-06',plain:true" onclick="detailTbStAjdjxx()">查看明细</a>
</div>
</body>
</html>