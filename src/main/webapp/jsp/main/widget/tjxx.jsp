<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/jsp/inc/include.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<security:csrfMetaTags />
<style type="text/css">
</style>
<script type="text/javascript" src="${basepath}skin/plugins/echarts/echarts.min.js"></script>
<script type="text/javascript" src="${basepath}skin/plugins/echarts/shine.js"></script>
<script type="text/javascript" src="${basepath}skin/plugins/echarts/map/js/shandong.js"></script>

<script>
	var orgcode = '';
	$(function() {
		sltj();
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
	function sltj() {
		var chart1 = echarts.init($('#slajtj').get(0));
		// 指定图表的配置项和数据
		var option = {
			tooltip : {
				show : true,
				trigger : 'item'
			},
			legend: {
		        data:['现场登记','微信登记','APP登记']
		    },
			calculable : true,
			xAxis : {
				data : [ "现场登记", "微信登记", "APP登记"]
			},
			yAxis : {
				type : 'value'
			},
			series : [ {
					name : '现场登记',
					type : 'bar',
					data : 12,
				},{
					name : '微信登记',
					type : 'bar',
					data : 1,
				},{
					name : 'APP登记',
					type : 'bar',
					data : 2,
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