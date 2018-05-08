<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@include file="/jsp/inc/include.jsp"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<security:csrfMetaTags/>
<script type="text/javascript" src='${basepath}jsp/txsb/txsb/detailtbsttxsb.js'></script>
<script type="text/javascript">
var _callbacks = $.Callbacks();
$(function() {
	
});
</script> 
</head>
<body>
<div class="easyui-panel"  style="width:100%;height:100%;text-align: center;"
	 data-options="footer:'#detailPageButtonsFt',fit:true">
		<form  id="picForm" method="post" enctype="multipart/form-data">
		 	<table style="width:100%;height:80%">
			 	<tr>
			 		<td style="width:50%">
				 		<div style="text-align: center;">
							<img id='ywPicPreView' style="width:150px;height:150px;" src="${basepath}skin/images/timg.jpg"/>
						</div>
					</td>
					<td  style="width:50%">
						<div style="text-align: center;">
							<img id='ajPicPreView' style="width:150px;height:150px;" src="${basepath}skin/images/timg.jpg"/>
						</div>
					</td>
				</tr>
			</table>
		</form>
</div>
<div id='detailPageButtonsFt' style="text-align:center; padding:2px; top:0px">
	<a href="javascript:void(0)" id='cloBtn' class="easyui-linkbutton" iconCls='icon-cancel'">关闭</a>
</div>
</body>
</html>