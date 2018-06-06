<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/jsp/inc/include.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>用户信息</title>
<style type="text/css">
.calendar-title{
	font-size:15px;
	font-weight:bold;
}
</style>
<script type="text/javascript">
var userCode = '<%=BspUtils.getLoginUser().getCode() %>';

	$(function() {
		$('#cc').calendar({
			formatter: function(date){
				return date.getDate();
			},
			showWeek:true,
			weekNumberHeader:'第几周'
		});
		/**
		var url = basepath+'sys/PubAttachment/viewNewPubAttachmentImgPath/userhead/'+userId;
		url=urlcsrf(url);
		$.ajax({
			url:url,
			type: "get",
			dataType:'text',
			success:function(data){
				if(null!=data&&""!=data){
					$('#userhead').attr("src",basepath+data+"?"+Math.random());
					//$('#userhead').attr("src",basepath+"securitycode?"+Math.random());
				}
			}
		});
		**/
		var clock = new Clock();
		clock.display(document.getElementById("clock"));
	});
	function Clock() {
		var date = new Date();
		this.year = date.getFullYear();
		this.month = date.getMonth() + 1;
		this.date = date.getDate();
		this.day = new Array("星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六")[date.getDay()];
		this.hour = date.getHours() < 10 ? "0" + date.getHours() : date.getHours();
		this.minute = date.getMinutes() < 10 ? "0" + date.getMinutes() : date.getMinutes();
		this.second = date.getSeconds() < 10 ? "0" + date.getSeconds() : date.getSeconds();

		this.toString = function() {
			return "现在是:" + this.year + "年" + this.month + "月" + this.date + "日 " + this.hour + ":" + this.minute + ":" + this.second + " " + this.day; 
		};
		
		this.toSimpleDate = function() {
			return this.year + "-" + this.month + "-" + this.date;
		};
		
		this.toDetailDate = function() {
			return this.year + "-" + this.month + "-" + this.date + " " + this.hour + ":" + this.minute + ":" + this.second;
		};
		
		this.display = function(ele) {
			var clock = new Clock();
			ele.innerHTML = clock.toString();
			window.setTimeout(function() {clock.display(ele);}, 1000);
		};
	}
</script>

</head>
<body style="width: 100%; height: 100%; padding: 0; border: 0;">
	<div  style="width:200px; height: 180px;float:left">
		<div style="width:160px; border: 1;padding-left:10px;margin-top: 10px;">
			<c:set var="nowDate" value="<%=(new Date()).getHours() %>"></c:set>
			<c:choose>
				<c:when test="${nowDate > 0 && nowDate<6}">
					凌晨好：<font color='blue'><%=BspUtils.getLoginUser().getName() %></font>
				</c:when>
				<c:when test="${nowDate > 6 && nowDate<=12}">
					上午好：<font color='blue'><%=BspUtils.getLoginUser().getName() %></font>
				</c:when>
				<c:when test="${nowDate > 12 && nowDate<=18}">
					下午好：<font color='blue'><%=BspUtils.getLoginUser().getName() %></font>
				</c:when>
				<c:when test="${nowDate > 18 && nowDate<=24}">
					晚上好：<font color='blue'><%=BspUtils.getLoginUser().getName() %></font>
				</c:when>
			</c:choose>
		</div>
		<img id='userhead' alt='头像' title='头像'
			style="width: 150px; height: 150px ;border:1px solid gray;margin-left: 10px; margin-right: 10px;margin-top: 5px;margin-bottom: 0px;padding: 1px;border-radius:5px"
			src="${basepath}skin/images/timg.jpg" />
		<div  style="width:160px; border: 1;padding-left:10px">
		
		</div>
	</div>

	<div style="width:300px;height:180px;float:left;margin:  10px">
		<div style="">
			<span id='clock' style="font-size:14px;"></span>
		</div>
		<div  id="cc" class="easyui-calendar" style="width:300px;height:180px;float:left;"></div>
	</div>  
</div>
</body>

</html>