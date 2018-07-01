<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@include file="/jsp/inc/include.jsp"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<security:csrfMetaTags/>
<script type="text/javascript" src='${basepath}jsp/msg/detailtbstmsg.js'></script>
<script type="text/javascript">
var _callbacks = $.Callbacks();
$(function() {
	
});
</script> 
</head>
<body>
<div class="easyui-panel"  style="width:100%;height:100%;text-align: center;"
	 data-options="footer:'#detailPageButtonsFt'">
		<form id="detailtbstmsgform" class="easyui-form" method="post" 
			data-options="novalidate:true">
			<input type='hidden' name='id' id='id'/>
			<table style="width:100%">
				  <tr>
					<th><label>接收人:</label></th>
					<td><input class="easyui-textbox" name="receiver"
						data-options="required:true"></input></td>
				  </tr>
				  <tr>
					<th><label>信息接收手机号码:</label></th>
					<td><input class="easyui-textbox" name="receiverTel"
						data-options="required:true"></input></td>
				  </tr>
				  <tr>
					<th><label>信息内容:</label></th>
					<td><input class="easyui-textbox" name="content"
						data-options="required:true"></input></td>
				  </tr>
				  <tr>
					<th><label>发送时间:</label></th>
					<td><input class="easyui-textbox" name="sendTime"
						data-options="required:true"></input></td>
				  </tr>
				  <tr>
					<th><label>状态(-1:发送失败;0:待发送;1:已发送):</label></th>
					<td><input class="easyui-textbox" name="state"
						data-options="required:true"></input></td>
				  </tr>
				  <tr>
					<th><label>备注:</label></th>
					<td><input class="easyui-textbox" name="bz"
						data-options="required:true"></input></td>
				  </tr>
			</table>
		</form>
</div>
<div id='detailPageButtonsFt' style="text-align:center; padding:2px; top:0px">
	<a href="javascript:void(0)" id='cloBtn' class="easyui-linkbutton" iconCls='icon-cancel'">关闭</a>
</div>
</body>
</html>