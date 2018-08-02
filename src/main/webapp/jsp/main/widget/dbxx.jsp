<%@page import="org.sky.sys.utils.EnumUtils"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/jsp/inc/include.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<security:csrfMetaTags />
<script type="text/javascript">
var sjzt = <%=EnumUtils.getEnums("AJDJ.STATE") %>;
var zlzt=<%=EnumUtils.getEnums("ZLXF.ZT") %>;
$(function() {
	$('#dbdatagrid').datagrid('options').url=SKY.urlCSRF(basepath+'widget/WidgetController/selectDbxx');
	$('#dbdatagrid').datagrid('load', {
		filter : function(){
			var ft = new HashMap();
			return ft.getJSON();
		}
	});
});
</script> 
</head>
<body style="border:0px;padding:0px;">
                      
<table id="dbdatagrid" class="easyui-datagrid" style="width: 100%; height: 100%"
	data-options="
			fit:true,
			border:false,
			remoteSort : false,
			pagination:true,
			rownumbers: true,
			checkbox:true,
			singleSelect:true,
			selectOnCheck:false,
			checkOnSelect:false,
			onLoadSuccess : function () {
        		$(this).datagrid('fixRownumber');
        		$(this).datagrid('doCellTip',{'max-width':'200px','delay':500});
    		}
		">
	<thead>
		<tr>
			<th data-options="field:'NAME',width:180">待办项</th>
			<th data-options="field:'ZT',width:200,
				formatter:function(value,row){
							 if('案件登记'==row.NAME){
						  	 	return SKY.formatterDict(value,row,sjzt);
						  	 }else if('指令下发'==row.NAME){
						  	 	return SKY.formatterDict(value,row,zlzt);
						  	 }else{
						  	 	return value;
						  	 }
						 }"">状态</th>
			<th data-options="field:'NUM',width:200">数量</th>
		</tr>
	</thead>
</table>
</body>
</html>