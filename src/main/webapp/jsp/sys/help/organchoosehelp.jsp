<%@	page import="org.sky.sys.utils.EnumUtils"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@include file="/jsp/inc/include.jsp"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<security:csrfMetaTags/>
<script type="text/javascript" src='${basepath}jsp/sys/help/organchoosehelp.js'></script>
<script type="text/javascript">
var SYS_SEX = <%=EnumUtils.getEnums("SYS.SEX") %>;
var SYS_IS = <%=EnumUtils.getEnums("SYS.IS") %>;
var SYS_USER_STATUS = <%=EnumUtils.getEnums("SYS.USER_STATUS") %>;
$(function() {
});
</script> 
</head>
<body>
<div class="easyui-panel"  style="width:100%;height:100%;text-align: center;"
	 data-options="border:false,fit:true,footer:'#editPageButtonsFt'">
<div style="width:100%;height:100%;text-align: left;">
	<ul class="easyui-tree" id="organtree" data-options='animate:true'></ul>
</div>
</div>
<div id='editPageButtonsFt' style="text-align:center; padding:0px; top:0px">
	<a href="javascript:void(0)" id='okBtn' class="easyui-linkbutton" iconCls='icon-save'>确定</a> 
	<a href="javascript:void(0)" id='cloBtn' class="easyui-linkbutton" iconCls='icon-cancel'>关闭</a>
</div>
</body>
</html>