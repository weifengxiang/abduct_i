<%@page import="org.es.sys.utils.EnumUtils"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/jsp/inc/include.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<security:csrfMetaTags />
<script type="text/javascript">
var AI_DB_STATUS=<%=EnumUtils.getEnums("AI.DB_STATUS") %>;
$(function() {
	$('#dbTreeGrid').treegrid({
		url:urlcsrf(basepath+'sys/PubMainShow/getDbcxTj'),
		idField:'id',
		treeField:'id'
	});
});
function addOpen(value,row){
	if(row.id.substring(0,2)=='10'||row.id=='2S'||row.id=='2S3'||row.id=='3Y'
			||row.id=='3S'||row.id=='40'||row.id=='60'||row.id=='7S'){
		return "<a href=\"javascript:void(0);\" onclick=\"openBl('"+row.id+"','"+row.text+"')\" style=\"text-decoration:none;\">"+value+"</a>";
	}else if(row.id=='20'||row.id=='30'){
		var counts = value.split(",");
		var valueStr = counts[0]+"（<font color='#FF7F00'>即将过期："+counts[1]+"</font>，<font color='red'>已过期："+counts[2]+"</font>）";
		return "<a href=\"javascript:void(0);\" onclick=\"openBl('"+row.id+"','"+counts[0]+"')\" style=\"text-decoration:none;\">"+valueStr+"</a>";
	}else{
		return value;
	}
}
function addNodeOpen(value,row){
	if(row.id.substring(0,2)=='10'||row.id=='20'||row.id=='2S'||row.id=='2S3'||row.id=='30'||row.id=='3Y'
			||row.id=='3S'||row.id=='40'||row.id=='60'||row.id=='7S'){
		return "<a href=\"javascript:void(0);\" onclick=\"openBl('"+row.id+"','"+row.text+"')\" style=\"text-decoration:none;\">"+value+"</a>";
	}else{
		return value;
	}
}
//打开办理tab页面
function openBl(status,value){
	if(status.substring(0,2)=='10'){
		window.parent.parent.addTab('补充登记','bcdj/Ai12315Djxx/initAi12315DjxxList','icon-application_osx_add',true);
	}else if(status=='20'){
		window.parent.parent.addTab('信息分流','xxfl/Ai12315Flxx/initAi12315FlxxList','icon-arrow_nw_ne_sw_se',true);
	}else if(status=='2S'){
		window.parent.parent.addTab('分流审核','xxfl/Ai12315Flxx/initAi12315FlshxxList','icon-application_form_edit',true);
	}else if(status=='2S3'){
		window.parent.parent.addTab('领导审批','jldsp/Ai12315Jldsp/initAi12315Jldsp','icon-application_edit',true);
	}else if(status=='30'){
		window.parent.parent.addTab('信息处理','xxcl/Ai12315Xxcl/initAi12315Xxcl','icon-application_form_edit',true);
	}else if(status=='3Y'){
		window.parent.parent.addTab('延期审核','yqsqsh/Ai12315Yqsqsh/initAi12315Yqsqsh','icon-time',true);
	}else if(status=='3S'){
		window.parent.parent.addTab('退回审核','xxcl/Ai12315Back/initAi12315BackList','icon-vcard_edit',true);
	}else if(status=='40'){
		window.parent.parent.addTab('反馈审批','cljgsh/Ai12315Cljgsh/initAi12315Cljgsh','icon-application_form_magnify',true);
	}else if(status=='60'){
		window.parent.parent.addTab('办结审核','bjsh/Ai12315Bjsh/initAi12315Bjsh','icon-application_form_magnify',true);
	}else if(status=='7S'){
		window.parent.parent.addTab('取消审核','xxcl/Ai12315Qxjash/initAi12315Qxjash','icon-application_form_edit',true);
	}else{
		$.messager.alert('提示',"未知业务类型",'info');
	}
}
</script> 
</head>
<body style="border:0px;padding:0px;">
<table id="dbTreeGrid" class="easyui-treegird" style="width:100%;height:100%;">
	<thead>
		<tr>
			<th data-options="field:'id',width:180,
				formatter:function(value,row){
					return addNodeOpen(formatterEnum(value,row,AI_DB_STATUS),row);
					
				}">待办项</th>
			<th data-options="field:'text',width:200,
				formatter:function(value,row){
					return addOpen(value,row);
				}">待处理数量</th>
		</tr>
	</thead>
</table>
</body>
</html>