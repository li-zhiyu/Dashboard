/*****Selectpicker Event start*****/

function selectOnchang(obj) {

	if ($('#project-flow').length > 0) {
		var myChart = echarts.init(document.getElementById('project-flow'));
		var selectValue = obj.options[obj.selectedIndex].innerHTML;
		//var selectValue=obj.selectedOptions[0].innerHTML;//IE不支持selectedOptions，但chrome可以
		myChart.clear();
		Ext.Ajax.request({
			async: false,
			url: '/statistic/getFlowCountByDate',
			timeout: 100000000,// 最大等待时间,超出则会触发超时
			params: { index: selectValue },//传入参数
			success: function (response) {

				myChart.showLoading();
				var respText = Ext.util.JSON.decode(response.responseText);
				if (respText.code != "OK") {
					return;
				}
				myChart.setOption(projectFlowOption(respText));
				myChart.resize();
				myChart.hideLoading();
			},
			failure: function (data) {

			}
		});
	}
}
/*****Selectpicker Event end*****/

/*****Remove Event start*****/

function deletediv() {
	var node = $('#delete').parents('#projectstatic');
	node.remove();
}

function deleteBlock(index) {
	$('#block' + index).remove();

}

function queren(){
	$("#myModal").modal('hide');
}
/*****Remove Event end*****/