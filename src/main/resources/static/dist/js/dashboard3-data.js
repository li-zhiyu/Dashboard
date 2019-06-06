/*Dashboard3 Init*/
 
"use strict"; 


/*****Load function start*****/
/*$(window).on("load",function(){
	window.setTimeout(function(){
		$.toast({
			heading: 'Welcome to Droopy',
			text: 'Use the predefined ones, or specify a custom position object.',
			position: 'top-left',
			loaderBg:'#f8b32d',
			icon: 'success',
			hideAfter: 3500, 
			stack: 6
		});
	}, 3000);
});*/
/*****Load function* end*****/

/*****E-Charts function start*****/
var echartsConfig = function() { 
	if( $('#project').length > 0 ){
		var myChart = echarts.init(document.getElementById('project'));
		myChart.clear();
		Ext.Ajax.request({
			async : false,
			url : '/statistic/getProjectInfo',
			timeout : 100000000,// 最大等待时间,超出则会触发超时
			params : {},//传入参数
			success : function(response) {

				myChart.showLoading();
				var respText = Ext.util.JSON.decode(response.responseText);
				if (respText.going == null || respText.going == "") {
					return;
				}
				
				myChart.setOption(option4(respText));
				myChart.resize();
				myChart.hideLoading();
				document.getElementById("year").innerHTML=respText.going;
				document.getElementById("mouth").innerHTML=respText.finish;
				document.getElementById("day").innerHTML=respText.suspend;
				myChart.on('click',function(params){
					console.log('你点击的是: ' + params.name);
				})
				
				$(document).on('click','refresh',function(params){
					console.log('你点击的是: ' + params.name);
				})

			},
			failure : function(data) {

			}
		});
	}
	if( $('#refund-pie').length > 0 ){
		var myChart = echarts.init(document.getElementById('refund-pie'));
		myChart.clear();
		Ext.Ajax.request({
			async : false,
			url : '/statistic/getContractPayment',
			timeout : 100000000,// 最大等待时间,超出则会触发超时
			params : {},//传入参数
			success : function(response) {

				myChart.showLoading();
				var respText = Ext.util.JSON.decode(response.responseText);
				if (respText.currentYear == null || respText.currentYear == "") {
					return;
				}
				
				myChart.setOption(contractOption(respText));
				myChart.resize();
				myChart.hideLoading();
				document.getElementById("refund-currentQuarter").innerHTML=respText.currentQuarter+" 万元";
				document.getElementById("refund-currentMonth").innerHTML=respText.currentMonth+" 万元";
				document.getElementById("refund-lastMonth").innerHTML=respText.lastMonth+" 万元";
				document.getElementById("refund-rate").innerHTML=((respText.currentYear*100)/respText.targetYear).toFixed(2)+"%";
				document.getElementById("refund-target").innerHTML=respText.targetYear+" 万元";
				
				if(!(respText.currentMonth==0&&respText.lastMonth==0))
				{
					if(respText.currentMonth>respText.lastMonth){
						var gain=((respText.currentMonth-respText.lastMonth)*100/respText.currentMonth).toFixed(2)+"%";
						$("#refund-currentMonth").append("<span class=\"text-success text-semibold\"style=\"margin-left:4px\"><i class=\"fa fa-level-up\" aria-hidden=\"true\"></i> "+ gain+"</span>");
						
					}else
					{
						var decline=((respText.lastMonth-respText.currentMonth)*100/respText.lastMonth).toFixed(2)+"%";
						$("#refund-currentMonth").append("<span class=\"text-danger text-semibold\"style=\"margin-left:4px\"><i class=\"fa fa-level-down\" aria-hidden=\"true\"></i> "+ decline+"</span>");
					}
				}
			},
			failure : function(data) {

			}
		});
	}
	
	
	if( $('#OV-confirm-pie').length > 0 ){
		var myChart = echarts.init(document.getElementById('OV-confirm-pie'));
		myChart.clear();
		Ext.Ajax.request({
			async : false,
			url : '/statistic/getContractProductiveConfirm',
			timeout : 100000000,// 最大等待时间,超出则会触发超时
			params : {},//传入参数
			success : function(response) {

				myChart.showLoading();
				var respText = Ext.util.JSON.decode(response.responseText);
				if (respText.currentYear == null || respText.currentYear == "") {
					return;
				}
				
				myChart.setOption(OVConfirmOption(respText));
				myChart.resize();
				myChart.hideLoading();
				document.getElementById("OV-confirm-currentQuarter").innerHTML=respText.currentQuarter+" 万元";
				document.getElementById("OV-confirm-currentMonth").innerHTML=respText.currentMonth+" 万元";
				document.getElementById("OV-confirm-lastMonth").innerHTML=respText.lastMonth+" 万元";
				document.getElementById("OV-confirm-rate").innerHTML=((respText.currentYear*100)/respText.targetYear).toFixed(2)+"%";
				document.getElementById("OV-confirm-target").innerHTML=respText.targetYear+" 万元";
				
				if(!(respText.currentMonth==0&&respText.lastMonth==0))
				{
					if(respText.currentMonth>respText.lastMonth){
						var gain=((respText.currentMonth-respText.lastMonth)*100/respText.currentMonth).toFixed(2)+"%";
						$("#OV-confirm-currentMonth").append("<span class=\"text-success text-semibold\"style=\"margin-left:4px\"><i class=\"fa fa-level-up\" aria-hidden=\"true\"></i> "+ gain+"</span>");
						
					}else
					{
						var decline=((respText.lastMonth-respText.currentMonth)*100/respText.lastMonth).toFixed(2)+"%";
						$("#OV-confirm-currentMonth").append("<span class=\"text-danger text-semibold\"style=\"margin-left:4px\"><i class=\"fa fa-level-down\" aria-hidden=\"true\"></i> "+ decline+"</span>");
					}
				}				
			},
			failure : function(data) {

			}
		});
	}
	
	if( $('#OV-SelfEva-pie').length > 0 ){
		var myChart = echarts.init(document.getElementById('OV-SelfEva-pie'));
		myChart.clear();
		Ext.Ajax.request({
			async : false,
			url : '/statistic/getContractProductiveEvaluate',
			timeout : 100000000,// 最大等待时间,超出则会触发超时
			params : {},//传入参数
			success : function(response) {

				myChart.showLoading();
				var respText = Ext.util.JSON.decode(response.responseText);
				if (respText.currentYear == null || respText.currentYear == "") {
					return;
				}
				
				myChart.setOption(OVSelfEvaOption(respText));
				myChart.resize();
				myChart.hideLoading();
				document.getElementById("OV-SelfEva-currentQuarter").innerHTML=respText.currentQuarter+" 万元";
				document.getElementById("OV-SelfEva-currentMonth").innerHTML=respText.currentMonth+" 万元";
				document.getElementById("OV-SelfEva-lastMonth").innerHTML=respText.lastMonth+" 万元";
				document.getElementById("OV-SelfEva-rate").innerHTML=((respText.currentYear*100)/respText.targetYear).toFixed(2)+"%";
				document.getElementById("OV-SelfEva-target").innerHTML=respText.targetYear+" 万元";
				
				if(!(respText.currentMonth==0&&respText.lastMonth==0))
					{
						if(respText.currentMonth>respText.lastMonth){
							var gain=((respText.currentMonth-respText.lastMonth)*100/respText.currentMonth).toFixed(2)+"%";
							$("#OV-SelfEva-currentMonth").append("<span class=\"text-success text-semibold\"style=\"margin-left:4px\"><i class=\"fa fa-level-up\" aria-hidden=\"true\"></i> "+ gain+"</span>");
							
						}else
						{
							var decline=((respText.lastMonth-respText.currentMonth)*100/respText.lastMonth).toFixed(2)+"%";
							$("#OV-SelfEva-currentMonth").append("<span class=\"text-danger text-semibold\"style=\"margin-left:4px\"><i class=\"fa fa-level-down\" aria-hidden=\"true\"></i> "+ decline+"</span>");
						}
					}				
			},
			failure : function(data) {

			}
		});
	}
	
	if( $('#sign-pie').length > 0 ){
		var myChart = echarts.init(document.getElementById('sign-pie'));
		myChart.clear();
		Ext.Ajax.request({
			async : false,
			url : '/statistic/getContractSign',
			timeout : 100000000,// 最大等待时间,超出则会触发超时
			params : {},//传入参数
			success : function(response) {

				myChart.showLoading();
				var respText = Ext.util.JSON.decode(response.responseText);
				if (respText.currentYear == null || respText.currentYear == "") {
					return;
				}
				
				myChart.setOption(SignOption(respText));
				myChart.resize();
				myChart.hideLoading();
				document.getElementById("sign-currentQuarter").innerHTML=respText.currentQuarter+" 万元";
				document.getElementById("sign-currentMonth").innerHTML=respText.currentMonth+" 万元";
				document.getElementById("sign-lastMonth").innerHTML=respText.lastMonth+" 万元";
				document.getElementById("sign-rate").innerHTML=((respText.currentYear*100)/respText.targetYear).toFixed(2)+"%";
				document.getElementById("sign-target").innerHTML=respText.targetYear+" 万元";
				
				if(!(respText.currentMonth==0&&respText.lastMonth==0))
				{
					if(respText.currentMonth>respText.lastMonth){
						var gain=((respText.currentMonth-respText.lastMonth)*100/respText.currentMonth).toFixed(2)+"%";
						$("#sign-currentMonth").append("<span class=\"text-success text-semibold\"style=\"margin-left:4px\"><i class=\"fa fa-level-up\" aria-hidden=\"true\"></i> "+ gain+"</span>");
						
					}else
					{
						var decline=((respText.lastMonth-respText.currentMonth)*100/respText.lastMonth).toFixed(2)+"%";
						$("#sign-currentMonth").append("<span class=\"text-danger text-semibold\"style=\"margin-left:4px\"><i class=\"fa fa-level-down\" aria-hidden=\"true\"></i> "+ decline+"</span>");
					}
				}
			},
			failure : function(data) {

			}
		});
	}
			
	if( $('#project-file').length > 0 ){
		var myChart = echarts.init(document.getElementById('project-file'));
		myChart.clear();
		Ext.Ajax.request({
			async : false,
			url : '/statistic/getFileSumByMonth',
			timeout : 100000000,// 最大等待时间,超出则会触发超时
			params : {},//传入参数
			success : function(response) {

				myChart.showLoading();
				var respText = Ext.util.JSON.decode(response.responseText);
				if (respText.code != "OK" ) {
					return;
				}
/*				if (respText.length == null || respText.length == "") {
					return;
				}
				var xAxis_data=new Array();
				var series_data=new Array();
				for(var i=0; i<respText.length;i++)
					{
						var record=respText[i];
						xAxis_data[i]=record.MONTH;
						series_data[i]=record.SUM;					
					}
				xAxis_data.reverse();
				series_data.reverse();*///数据处理可以放在Controller层，尽量让前端JS直接使用
								
				myChart.setOption(fileOption(respText));
				myChart.hideLoading();
			},
			failure : function(data) {

			}
		});
	}
	
	if( $('#pro-project').length > 0 ){
		var myChart = echarts.init(document.getElementById('pro-project'));
		myChart.clear();
		Ext.Ajax.request({
			async : false,
			url : '/statistic/getProjectSumByDegree',
			timeout : 100000000,// 最大等待时间,超出则会触发超时
			params : {},//传入参数
			success : function(response) {

				myChart.showLoading();
				var respText = Ext.util.JSON.decode(response.responseText);
				if (respText.code != "OK" ) {
					return;
				}
				myChart.setOption(proProjectOption(respText));
				myChart.resize();
				myChart.hideLoading();
			},
			failure : function(data) {

			}
		});
	}
	
	if( $('#project-status').length > 0 ){
		var myChart = echarts.init(document.getElementById('project-status'));
		myChart.clear();
		Ext.Ajax.request({
			async : false,
			url : '/statistic/getProjectInfo',
			timeout : 100000000,// 最大等待时间,超出则会触发超时
			params : {},//传入参数
			success : function(response) {

				myChart.showLoading();
				var respText = Ext.util.JSON.decode(response.responseText);
				if (respText.code != "OK" ) {
					return;
				}
				myChart.setOption(projectStatusOption(respText));
				myChart.resize();
				myChart.hideLoading();
			},
			failure : function(data) {

			}
		});
	}
	
	if( $('#project-flow').length > 0 ){
		var myChart = echarts.init(document.getElementById('project-flow'));
		var selectValue=$('.selectpicker')[0].selectedOptions[0].innerHTML;
		myChart.clear();
		Ext.Ajax.request({
			async : false,
			url : '/statistic/getFlowCountByDate',
			timeout : 100000000,// 最大等待时间,超出则会触发超时
			params : {index:selectValue},//传入参数
			success : function(response) {

				myChart.showLoading();
				var respText = Ext.util.JSON.decode(response.responseText);
				if (respText.code != "OK" ) {
					return;
				}
				myChart.setOption(projectFlowOption(respText));
				myChart.resize();
				myChart.hideLoading();
			},
			failure : function(data) {

			}
		});
	}
	
}
/*****E-Charts function end*****/


/*****Resize function start*****/
var echartResize;
$(window).on("resize", function () {
	/*E-Chart Resize*/
	clearTimeout(echartResize);
	echartResize = setTimeout(echartsConfig, 200);
}).resize(); 
/*****Resize function end*****/

/*****Function Call start*****/
echartsConfig();
/*****Function Call end*****/

/*****Auto-Refersh start*****/

window.setInterval(function () {
	echartsConfig();
},60000);
/*****Auto-Refersh end*****/

/*****Selectpicker Event start*****/

function selectOnchang(obj){ 
	
	if( $('#project-flow').length > 0 ){
		var myChart = echarts.init(document.getElementById('project-flow'));
		//var selectValue=obj.options[obj.selectedIndex].innerHTML;//获取选择框的值(第一种方式)
		var selectValue=obj.selectedOptions[0].innerHTML;
		myChart.clear();
		Ext.Ajax.request({
			async : false,
			url : '/statistic/getFlowCountByDate',
			timeout : 100000000,// 最大等待时间,超出则会触发超时
			params : {index:selectValue},//传入参数
			success : function(response) {

				myChart.showLoading();
				var respText = Ext.util.JSON.decode(response.responseText);
				if (respText.code != "OK" ) {
					return;
				}
				myChart.setOption(projectFlowOption(respText));
				myChart.resize();
				myChart.hideLoading();
			},
			failure : function(data) {

			}
		});
	}
}
/*****Selectpicker Event end*****/