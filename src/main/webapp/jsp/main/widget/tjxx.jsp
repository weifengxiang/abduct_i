<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/jsp/inc/include.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<security:csrfMetaTags />
<style type="text/css">
</style>
<script type="text/javascript" src="${basepath}skin/echarts/echarts.min.js"></script>
<script type="text/javascript" src="${basepath}skin/echarts/shine.js"></script>
<script type="text/javascript" src="${basepath}skin/echarts/map/js/shandong.js"></script>
<script type="text/javascript"
	src="${basepath}skin/portal/jquery.portal.js"></script>
<script>
	var orgcode = '<%=BspUtils.getLoginUserDep().getOrganCode()%>';
	$(function() {
		tjxx();
	});
	// 受理统计获取数据
	function tjxx() {
		$.ajax({
			url : urlcsrf(basepath + 'sys/PubMainShow/getTjxx'),
			type : "POST",
			dataType : 'json',
			success : function(data) {
				sltj(data);
			}
		});
	}
	// 受理统计构建统计图
	function sltj(data) {
		var chart1 = echarts.init($('#slajtj').get(0));
		// 指定图表的配置项和数据
		var option = {
			tooltip : {
				show : true,
				trigger : 'item'
			},
			legend: {
		        data:['电话','短信','来人','来函','传真','互联网','语音留言','其他','微信','微博']
		    },
			calculable : true,
			xAxis : {
				data : [ "投诉", "举报", "咨询"]
			},
			yAxis : {
				type : 'value'
			},
			series : [ {
					name : '电话',
					type : 'bar',
					data : data.dh,
				},{
					name : '短信',
					type : 'bar',
					data : data.dx,
				},{
					name : '来人',
					type : 'bar',
					data : data.lr,
				},{
					name : '来函',
					type : 'bar',
					data : data.lh,
				},{
					name : '传真',
					type : 'bar',
					data : data.cz,
				},{
					name : '互联网',
					type : 'bar',
					data : data.hlw,
				},{
					name : '语音留言',
					type : 'bar',
					data : data.yyly,
				},{
					name : '其他',
					type : 'bar',
					data : data.qt,
				},{
					name : '微信',
					type : 'bar',
					data : data.wx,
				},{
					name : '微博',
					type : 'bar',
					data : data.wb,
				}
				]
		};
		chart1.setOption(option);
	}
</script>
</head>
<body >
	<div id='slajtj' style="width:500px;height:250px;">
	</div>
</body>
</html>