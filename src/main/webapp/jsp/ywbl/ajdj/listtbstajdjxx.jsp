<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@include file="/jsp/inc/include.jsp"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<security:csrfMetaTags/>
<script type="text/javascript" src='${basepath}jsp/ywbl/ajdj/listtbstajdjxx.js'></script>
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
		<th><label>案件编号:</label></th>
		<td><input  class="easyui-textbox" data-options="prompt:'输入案件编号'" name="q_ajbh"  id="q_ajbh" ></input></td>				
		<th><label>报警时间:</label></th>
		<td><input  class="easyui-textbox" data-options="prompt:'输入报警时间'" name="q_bjsj"  id="q_bjsj" ></input></td>				
		<th><label>所属分局:</label></th>
		<td><input  class="easyui-textbox" data-options="prompt:'输入所属分局'" name="q_ssfj"  id="q_ssfj" ></input></td>				
		<th><label>联系电话:</label></th>
		<td><input  class="easyui-textbox" data-options="prompt:'输入联系电话'" name="q_lxdh"  id="q_lxdh" ></input></td>				
		<th><label>报警方式:</label></th>
		<td><input  class="easyui-textbox" data-options="prompt:'输入报警方式'" name="q_bjfs"  id="q_bjfs" ></input></td>				
		<th><label>报警类别:</label></th>
		<td><input  class="easyui-textbox" data-options="prompt:'输入报警类别'" name="q_bjlb"  id="q_bjlb" ></input></td>				
		<th><label>报警类型:</label></th>
		<td><input  class="easyui-textbox" data-options="prompt:'输入报警类型'" name="q_bjlx"  id="q_bjlx" ></input></td>				
		<th><label>报警细类:</label></th>
		<td><input  class="easyui-textbox" data-options="prompt:'输入报警细类'" name="q_bjxl"  id="q_bjxl" ></input></td>				
		<th><label>事发地址:</label></th>
		<td><input  class="easyui-textbox" data-options="prompt:'输入事发地址'" name="q_sfdz"  id="q_sfdz" ></input></td>				
		<th><label>来话类别:</label></th>
		<td><input  class="easyui-textbox" data-options="prompt:'输入来话类别'" name="q_lhlb"  id="q_lhlb" ></input></td>				
		<th><label>报警人:</label></th>
		<td><input  class="easyui-textbox" data-options="prompt:'输入报警人'" name="q_bjr"  id="q_bjr" ></input></td>				
		<th><label>事件详情:</label></th>
		<td><input  class="easyui-textbox" data-options="prompt:'输入事件详情'" name="q_sjxq"  id="q_sjxq" ></input></td>				
		<th><label>辖区单位:</label></th>
		<td><input  class="easyui-textbox" data-options="prompt:'输入辖区单位'" name="q_xqdw"  id="q_xqdw" ></input></td>				
		<th><label>行政区划:</label></th>
		<td><input  class="easyui-textbox" data-options="prompt:'输入行政区划'" name="q_xzqh"  id="q_xzqh" ></input></td>				
		<th><label>出警人:</label></th>
		<td><input  class="easyui-textbox" data-options="prompt:'输入出警人'" name="q_cjr"  id="q_cjr" ></input></td>				
		<th><label>到场时间:</label></th>
		<td><input  class="easyui-textbox" data-options="prompt:'输入到场时间'" name="q_dcsj"  id="q_dcsj" ></input></td>				
		<th><label>到场情况:</label></th>
		<td><input  class="easyui-textbox" data-options="prompt:'输入到场情况'" name="q_dcqk"  id="q_dcqk" ></input></td>				
		<th><label>反馈内容:</label></th>
		<td><input  class="easyui-textbox" data-options="prompt:'输入反馈内容'" name="q_fknr"  id="q_fknr" ></input></td>				
		<th><label>处理结果:</label></th>
		<td><input  class="easyui-textbox" data-options="prompt:'输入处理结果'" name="q_cljg"  id="q_cljg" ></input></td>				
		<th><label>事件状态(-1:无效;0:登记;1:分流:2:受理;3:办结;4:结案):</label></th>
		<td><input  class="easyui-textbox" data-options="prompt:'输入事件状态(-1:无效;0:登记;1:分流:2:受理;3:办结;4:结案)'" name="q_sjzt"  id="q_sjzt" ></input></td>				
		<th><label>警务区:</label></th>
		<td><input  class="easyui-textbox" data-options="prompt:'输入警务区'" name="q_jwq"  id="q_jwq" ></input></td>				
		<th><label>案发地址类别:</label></th>
		<td><input  class="easyui-textbox" data-options="prompt:'输入案发地址类别'" name="q_afdzlb"  id="q_afdzlb" ></input></td>				
		<th><label>事件发生地址:</label></th>
		<td><input  class="easyui-textbox" data-options="prompt:'输入事件发生地址'" name="q_sjfsdz"  id="q_sjfsdz" ></input></td>				
		<th><label>当前单位:</label></th>
		<td><input  class="easyui-textbox" data-options="prompt:'输入当前单位'" name="q_dqdw"  id="q_dqdw" ></input></td>				
		<th><label>案件来源:</label></th>
		<td><input  class="easyui-textbox" data-options="prompt:'输入案件来源'" name="q_ajly"  id="q_ajly" ></input></td>				
		<th><label>登记人:</label></th>
		<td><input  class="easyui-textbox" data-options="prompt:'输入登记人'" name="q_djr"  id="q_djr" ></input></td>				
		<th><label>登记单位:</label></th>
		<td><input  class="easyui-textbox" data-options="prompt:'输入登记单位'" name="q_djdw"  id="q_djdw" ></input></td>				
		<th><label>登记时间:</label></th>
		<td><input  class="easyui-textbox" data-options="prompt:'输入登记时间'" name="q_djsj"  id="q_djsj" ></input></td>				
		<th><label>线索编号:</label></th>
		<td><input  class="easyui-textbox" data-options="prompt:'输入线索编号'" name="q_xsbh"  id="q_xsbh" ></input></td>				
		<th><label>备注:</label></th>
		<td><input  class="easyui-textbox" data-options="prompt:'输入备注'" name="q_bz"  id="q_bz" ></input></td>				
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
				<th data-options="field:'ajbh',width:180,
				editor:{
						type:'textbox',
						options:{
							required:true
						}}">案件编号</th>
				<th data-options="field:'bjsj',width:180,
				editor:{
						type:'textbox',
						options:{
							required:true
						}}">报警时间</th>
				<th data-options="field:'ssfj',width:180,
				editor:{
						type:'textbox',
						options:{
							required:true
						}}">所属分局</th>
				<th data-options="field:'lxdh',width:180,
				editor:{
						type:'textbox',
						options:{
							required:true
						}}">联系电话</th>
				<th data-options="field:'bjfs',width:180,
				editor:{
						type:'textbox',
						options:{
							required:true
						}}">报警方式</th>
				<th data-options="field:'bjlb',width:180,
				editor:{
						type:'textbox',
						options:{
							required:true
						}}">报警类别</th>
				<th data-options="field:'bjlx',width:180,
				editor:{
						type:'textbox',
						options:{
							required:true
						}}">报警类型</th>
				<th data-options="field:'bjxl',width:180,
				editor:{
						type:'textbox',
						options:{
							required:true
						}}">报警细类</th>
				<th data-options="field:'sfdz',width:180,
				editor:{
						type:'textbox',
						options:{
							required:true
						}}">事发地址</th>
				<th data-options="field:'lhlb',width:180,
				editor:{
						type:'textbox',
						options:{
							required:true
						}}">来话类别</th>
				<th data-options="field:'bjr',width:180,
				editor:{
						type:'textbox',
						options:{
							required:true
						}}">报警人</th>
				<th data-options="field:'sjxq',width:180,
				editor:{
						type:'textbox',
						options:{
							required:true
						}}">事件详情</th>
				<th data-options="field:'xqdw',width:180,
				editor:{
						type:'textbox',
						options:{
							required:true
						}}">辖区单位</th>
				<th data-options="field:'xzqh',width:180,
				editor:{
						type:'textbox',
						options:{
							required:true
						}}">行政区划</th>
				<th data-options="field:'cjr',width:180,
				editor:{
						type:'textbox',
						options:{
							required:true
						}}">出警人</th>
				<th data-options="field:'dcsj',width:180,
				editor:{
						type:'textbox',
						options:{
							required:true
						}}">到场时间</th>
				<th data-options="field:'dcqk',width:180,
				editor:{
						type:'textbox',
						options:{
							required:true
						}}">到场情况</th>
				<th data-options="field:'fknr',width:180,
				editor:{
						type:'textbox',
						options:{
							required:true
						}}">反馈内容</th>
				<th data-options="field:'cljg',width:180,
				editor:{
						type:'textbox',
						options:{
							required:true
						}}">处理结果</th>
				<th data-options="field:'sjzt',width:180,
				editor:{
						type:'textbox',
						options:{
							required:true
						}}">事件状态(-1:无效;0:登记;1:分流:2:受理;3:办结;4:结案)</th>
				<th data-options="field:'jwq',width:180,
				editor:{
						type:'textbox',
						options:{
							required:true
						}}">警务区</th>
				<th data-options="field:'afdzlb',width:180,
				editor:{
						type:'textbox',
						options:{
							required:true
						}}">案发地址类别</th>
				<th data-options="field:'sjfsdz',width:180,
				editor:{
						type:'textbox',
						options:{
							required:true
						}}">事件发生地址</th>
				<th data-options="field:'dqdw',width:180,
				editor:{
						type:'textbox',
						options:{
							required:true
						}}">当前单位</th>
				<th data-options="field:'ajly',width:180,
				editor:{
						type:'textbox',
						options:{
							required:true
						}}">案件来源</th>
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
				<th data-options="field:'xsbh',width:180,
				editor:{
						type:'textbox',
						options:{
							required:true
						}}">线索编号</th>
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
		data-options="iconCls:'icon-add',plain:true" onclick="addTbStAjdjxx()">增加</a>
	<a href="javascript:void(0)" class="easyui-linkbutton"
		data-options="iconCls:'icon-edit',plain:true" onclick="editTbStAjdjxx()">修改</a>
	<a href="javascript:void(0)" class="easyui-linkbutton"
		data-options="iconCls:'icon-20130408025545236_easyicon_net_30',plain:true" onclick="delTbStAjdjxx()">删除</a>
	<a href="javascript:void(0)" class="easyui-linkbutton"
		data-options="iconCls:'icon-06',plain:true" onclick="detailTbStAjdjxx()">查看明细</a>
</div>
</body>
</html>