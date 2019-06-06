function ContractSignByQuarterTable(){
	
	Ext.Ajax.request({
		async : false,
		url : '/statistic/getContractSignByQuarter',
		timeout : 100000000,// 最大等待时间,超出则会触发超时
		params : {},//传入参数
		success : function(response) {

			var respText = Ext.util.JSON.decode(response.responseText);
			if (respText.length == null || respText.length == "") {
				return;
			}
			var thead="";//表列头
			thead+="<tr>"+"<th style=\"text-align:center\">"+"序号"+"</th>"+"<th style=\"text-align:center\">"+"合同编号"+"</th>"+"<th style=\"text-align:center\">"+"项目名称"+"</th>"+"<th style=\"text-align:center\">"+"委托方"+"</th>"+"<th style=\"text-align:center\">"+"签订金额(万元)"+"</th>"+"<th style=\"text-align:center\">"+"签订日期"+"</th>"+"</tr>";	
			var tbody="";//表记录
			var index="";
			for(var i = 0;i<respText.length;i++)
				{
				var record=respText[i];
				index=i+1;
				
				tbody+="<tr>"+"<td>"+index+"</td>"+"<td>"+record.CONTRACT_NO+"</td>"+"<td>"+record.PROJECT_NM+"</td>"+"<td>"+record.SECOND_PARTY+"</td>"+"<td>"+record.EXPECTED_COST+"</td>"+"<td>"+record.SIGNING_DATE+"</td>"+"</tr>";
				}
			$("#datable_1 thead").html(thead);
			$("#datable_1 tbody").html(tbody);
			

		},
		failure : function(data) {

		}
	});
}

function ContractSignByYearTable(){
	
	Ext.Ajax.request({
		async : false,
		url : '/statistic/getContractSignByYear',
		timeout : 100000000,// 最大等待时间,超出则会触发超时
		params : {},//传入参数
		success : function(response) {

			var respText = Ext.util.JSON.decode(response.responseText);
			if (respText.length == null || respText.length == "") {
				return;
			}
			var thead="";//表列头
			thead+="<tr>"+"<th style=\"text-align:center\">"+"序号"+"</th>"+"<th style=\"text-align:center\">"+"合同编号"+"</th>"+"<th style=\"text-align:center\">"+"项目名称"+"</th>"+"<th style=\"text-align:center\">"+"委托方"+"</th>"+"<th style=\"text-align:center\">"+"签订金额(万元)"+"</th>"+"<th style=\"text-align:center\">"+"签订日期"+"</th>"+"</tr>";			
			var tbody="";//表记录
			var index="";
			for(var i = 0;i<respText.length;i++)
				{
				var record=respText[i];
				index=i+1;
				
				tbody+="<tr>"+"<td>"+index+"</td>"+"<td>"+record.CONTRACT_NO+"</td>"+"<td>"+record.PROJECT_NM+"</td>"+"<td>"+record.SECOND_PARTY+"</td>"+"<td>"+record.EXPECTED_COST+"</td>"+"<td>"+record.SIGNING_DATE+"</td>"+"</tr>";
				}
			$("#datable_1 thead").html(thead);
			$("#datable_1 tbody").html(tbody);
			

		},
		failure : function(data) {

		}
	});
}

//当做DOM来填写数据，通过DataTables方式来格式化表格