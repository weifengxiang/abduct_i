//初始化
function init(){
	$('#listtbstajdjxxdg').datagrid('options').url=SKY.urlCSRF(basepath+'zhcx/ajcx/getTbStAjdjxxByPage');
	$('#listtbstajdjxxdg').datagrid('load', {
		filter : function(){
			var ft = new HashMap();
			return ft.getJSON();
		}
	});
}

/**
*查看明细
**/
function detailTbStAjdjxx(){
	var checkeds=$('#listtbstajdjxxdg').datagrid('getChecked');
	if(null==checkeds||checkeds.length!=1){
		$.messager.alert('提示','请选择一条记录','info');
		return;
	}
	var gbButton = {
			text: '关闭',  
            iconCls: 'icon-cancel',  
            handler:function(dialog){
            	dialog.close();
            }};
	var buttons = new Array();
	buttons.push(gbButton);
	var opts={
				id:'detailTbStAjdjxx',
				title:'案件登记信息明细',
				width:800,
				height:600,
				modal:true,
				content:'url:'+SKY.urlCSRF(basepath+'ywbl/TbStAjdjxx/initAjxxmainPage?ajbh='+checkeds[0].ajbh),
				buttons:buttons
			  };
	SKY_EASYUI.open(opts);
}

/**
 * 查询按钮
 */
function searchButton(){
	$('#listtbstajdjxxdg').datagrid('options').url=SKY.urlCSRF(basepath+'zhcx/ajcx/getTbStAjdjxxByPage');
	$('#listtbstajdjxxdg').datagrid('load', {
		filter : function(){
			var ft = new HashMap();
			var ajbh =$('#q_ajbh').textbox("getValue");
			if(ajbh){
				ft.put("ajbh@=", ajbh);
			}
			var bjsj =$('#q_bjsj').textbox("getValue");
			if(bjsj){
				ft.put("date_format(bjsj,concat(upper('%y'),'-%m-%d'))@=", bjsj);
			}
			var lxdh =$('#q_lxdh').textbox("getValue");
			if(lxdh){
				ft.put("lxdh@=", lxdh);
			}
			var djsj =$('#q_djsj').textbox("getValue");
			if(djsj){
				ft.put("date_format(djsj,concat(upper('%y'),'-%m-%d'))@=@=", djsj);
			}
			return ft.getJSON();
		}
	});
}