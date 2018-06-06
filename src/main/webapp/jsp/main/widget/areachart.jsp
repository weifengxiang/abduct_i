<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="org.es.sys.utils.BspUtils"%>
<%@page import="org.es.sys.utils.CommUtils"%>
<%@page import="org.es.sys.utils.EnumUtils"%>
<%@page import="org.es.sys.utils.DictUtils"%>
<%@include file="/jsp/main/include.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<security:csrfMetaTags />
<style type="text/css">
</style>
<script type="text/javascript" src="${basepath}skin/echarts/echarts.min.js"></script>
<script type="text/javascript" src="${basepath}skin/echarts/shine.js"></script>
<script type="text/javascript" src="${basepath}skin/echarts/map/js/shandong.js"></script>

<script>
	var orgcode = '<%=BspUtils.getLoginUserDep().getOrganCode()%>';
	// 地图统计构建图形
	function initMap() {
		mapChart = echarts.init($('#sdMapTj').get(0));
		var option = {
			title : {
				text : '各地区登记数量统计('+(new Date).getFullYear()+')',
				left: 'center'
			},
			tooltip : {
				trigger : 'item'
			},
			visualMap : {
				min : 6000,
				max : 600000,
				left : 'left',
				top : 'bottom',
				text : [ '高', '低' ], // 文本，默认为数值文本
				calculable : true,
				inRange: {
	                color: ['orangered','yellow','green']
	            }
			},
			toolbox : {
				show : true,
				orient : 'vertical',
				left : 'right',
				top : 'center',
				feature : {
					dataView : {
						readOnly : false
					},
					restore : {},
					saveAsImage : {}
				}
			},
			series : [ {
				name : '登记数量',
				type : 'map',
				mapType : '山东',
				roam : false,
				label : {
					normal : {
						show : true
					},
					emphasis : {
						show : true
					}
				},
				itemStyle : {
					normal : {
						 label : {
		                        formatter : "{b}\n({c})",
		                    }	  
					}
				},
				data : []
			}]
		};
		mapChart.setOption(option);
	}

	//获取统计数据
	function getMapDate(){
		mapChart.showLoading();
		$.ajax({
			url : urlcsrf(basepath + 'sys/PubMainShow/getMapDate'),
			type : "POST",
			dataType : 'json',
			timeout : 600000,
			success : function(data) {
				mapChart.hideLoading();
				mapChart.setOption({
					title : {
						subtext: '共'+data.count+'件',
					},
					visualMap:{
						min:data.min,
						max:data.max
					},
					series:[{
						data:data.data
					}]
				});
			}
		});
	}
$(function() {
	initMap();
	getMapDate();
});
</script>
</head>
<body>
	<div id='sdMapTj' style="width:500px;height:400px;">
	</div>
</body>
</html>