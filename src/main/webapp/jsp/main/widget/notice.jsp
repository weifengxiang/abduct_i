<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@include file="/jsp/main/include.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<head>
<security:csrfMetaTags />
<%@page import="org.es.sys.utils.BspUtils"%>
<%@page import="org.es.sys.utils.CommUtils"%>
<%@page import="org.es.sys.utils.EnumUtils"%>
<%@page import="org.es.sys.utils.DictUtils"%>
<link rel="stylesheet" href="${basepath}skin/kindeditor-4.1.10/themes/default/default.css"/>
<script charset="utf-8" src="${basepath}skin/kindeditor-4.1.10/kindeditor.js"></script>
<script charset="utf-8" src="${basepath}skin/kindeditor-4.1.10/lang/zh_CN.js"></script>
<script type="text/javascript">
$(function() {
	$('#listpubnoticedg').datagrid('options').url=urlcsrf(basepath+'sys/PubMainShow/getPubNoticeByPage');
	$('#listpubnoticedg').datagrid('load', {
		filter : function(){
			var ft = new HashMap();
			return ft.getJSON();
		}
		
	});
});
//查看明细
function addOpen(val,row){
	return "<a href=\"javascript:void(0);\" onclick=\"showDetailPubNotice('"+row.recid+"')\">"+row.title+"</a>";
}
//初始化明细页面
function showDetailPubNotice(recid){
	MI.open({
 		id: 'showDetailPubNotice',
 		title: '公告详情',
 		width: 800,
 		height: 600,
 		modal:true,
 		content: 'url:'+basepath+'sys/PubMainShow/toDetailPubNotice/'+recid,
 		onLoad: function(dialog){ 
        }
 	});
}

</script>
</head>
<body>
<table  id="listpubnoticedg" class="easyui-datagrid" style="width: 100%; height: 100%"
				data-options="
						region:'center',
						iconCls: 'icon-edit',
						remoteSort : false,
						pagination:true,
						rownumbers: true,
						singleSelect:true,
						selectOnCheck:false,
						checkOnSelect:false,
						fit:true,
						onLoadSuccess : function () {
				       		$(this).datagrid('fixRownumber');
				       		$(this).datagrid('doCellTip',{'max-width':'200px','delay':500});
				   		}
					">
				<thead>
					<tr>
						<th data-options="field:'title',width:250,
						editor:{
								type:'textbox',
								options:{
									required:true
								}},
						formatter:function(val,row){
							return addOpen(val,row);
						}">公告/通知标题</th>
						<th data-options="field:'pubtimeStr',width:150,
						editor:{
								type:'textbox',
								options:{
									required:true
								}}">发布时间</th>
						<th data-options="field:'pubuserName',width:100,
						editor:{
								type:'textbox',
								options:{
									required:true
								}}">发布人</th>
					</tr>
				</thead>
			</table>
</body>