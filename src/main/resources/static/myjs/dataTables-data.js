/*DataTable Init*/

"use strict"; 

$(document).ready(function() {
	"use strict";
	$('#tb_contractSignByYear').DataTable({
		"lengthChange": true,//是否允许用户自定义显示数量
        "bPaginate": true, //翻页功能
        "bFilter": false, //列筛序功能
        "searching": true,//本地搜索
        "ordering": true, //排序功能
        "Info": true,//页脚信息
        "autoWidth": false,//自动宽度
        "oLanguage": {//国际语言转化
            "oAria": {
                "sSortAscending": " - click/return to sort ascending",
                "sSortDescending": " - click/return to sort descending"
            },
            "sLengthMenu": "显示 _MENU_ 记录",
            "sZeroRecords": "对不起，查询不到任何相关数据",
            "sEmptyTable": "未有相关数据",
            "sLoadingRecords": "正在加载数据-请等待...",
            "sInfo": "当前显示 _START_ 到 _END_ 条，共 _TOTAL_ 条记录。",
            "sInfoEmpty": "当前显示0到0条，共0条记录",
            "sInfoFiltered": "（总共 _MAX_ 条记录）",
            "sProcessing": "正在加载数据...",
            "sSearch": "模糊查询：",
            "oPaginate": {
                "sFirst": "首页",
                "sPrevious": " 上一页 ",
                "sNext": " 下一页 ",
                "sLast": " 尾页 "
            }
        },
        "columnDefs": [
                       {
                           orderable: false,
     
                           targets: 1 },
                       {
                           orderable: false,
     
                           targets: 2 },
                        {
                           orderable: false,
         
                           targets: 3 }
                   ],//第二列与第三，四列禁止排序
              "ajax": {
                       url: '/statistic/getContractSignByYear',
                       dataSrc: ''
                   },
           
           "columns": [
                       {data:"CONTRACT_NO"},
                       {data:"PROJECT_NM"},
                       {data:"SECOND_PARTY"},
                       {data:"EXPECTED_COST"},
                       {data:"SIGNING_DATE"}
                     ]
	});
	
	$('#tb_contractSignByQuarter').DataTable({
		"lengthChange": true,//是否允许用户自定义显示数量
        "bPaginate": true, //翻页功能
        "bFilter": false, //列筛序功能
        "searching": true,//本地搜索
        "ordering": true, //排序功能
        "Info": true,//页脚信息
        "autoWidth": false,//自动宽度
        "oLanguage": {//国际语言转化
            "oAria": {
                "sSortAscending": " - click/return to sort ascending",
                "sSortDescending": " - click/return to sort descending"
            },
            "sLengthMenu": "显示 _MENU_ 记录",
            "sZeroRecords": "对不起，查询不到任何相关数据",
            "sEmptyTable": "未有相关数据",
            "sLoadingRecords": "正在加载数据-请等待...",
            "sInfo": "当前显示 _START_ 到 _END_ 条，共 _TOTAL_ 条记录。",
            "sInfoEmpty": "当前显示0到0条，共0条记录",
            "sInfoFiltered": "（总共 _MAX_ 条记录）",
            "sProcessing": "正在加载数据...",
            "sSearch": "模糊查询：",
            "oPaginate": {
                "sFirst": "首页",
                "sPrevious": " 上一页 ",
                "sNext": " 下一页 ",
                "sLast": " 尾页 "
            }
        },
        "columnDefs": [
                       {
                           orderable: false,
     
                           targets: 1 },
                       {
                           orderable: false,
     
                           targets: 2 },
                        {
                           orderable: false,
         
                           targets: 3 }
                   ],//第二列与第三，四列禁止排序
     
         "ajax": {
                    url: '/statistic/getContractSignByQuarter',
                    dataSrc: ''
                },
        
        "columns": [
                    {data:"CONTRACT_NO"},
                    {data:"PROJECT_NM"},
                    {data:"SECOND_PARTY"},
                    {data:"EXPECTED_COST"},
                    {data:"SIGNING_DATE"}
                  ]
	});
	
	$('#tb_contractSignByMonth').DataTable({
		"lengthChange": true,//是否允许用户自定义显示数量
        "bPaginate": true, //翻页功能
        "bFilter": false, //列筛序功能
        "searching": true,//本地搜索
        "ordering": true, //排序功能
        "Info": true,//页脚信息
        "autoWidth": false,//自动宽度
        "oLanguage": {//国际语言转化
            "oAria": {
                "sSortAscending": " - click/return to sort ascending",
                "sSortDescending": " - click/return to sort descending"
            },
            "sLengthMenu": "显示 _MENU_ 记录",
            "sZeroRecords": "对不起，查询不到任何相关数据",
            "sEmptyTable": "未有相关数据",
            "sLoadingRecords": "正在加载数据-请等待...",
            "sInfo": "当前显示 _START_ 到 _END_ 条，共 _TOTAL_ 条记录。",
            "sInfoEmpty": "当前显示0到0条，共0条记录",
            "sInfoFiltered": "（总共 _MAX_ 条记录）",
            "sProcessing": "正在加载数据...",
            "sSearch": "模糊查询：",
            "oPaginate": {
                "sFirst": "首页",
                "sPrevious": " 上一页 ",
                "sNext": " 下一页 ",
                "sLast": " 尾页 "
            }
        },
        "columnDefs": [
                       {
                           orderable: false,
     
                           targets: 1 },
                       {
                           orderable: false,
     
                           targets: 2 },
                        {
                           orderable: false,
         
                           targets: 3 }
                   ],//第二列与第三，四列禁止排序
     
         "ajax": {
                    url: '/statistic/getContractSignByMonth',
                    dataSrc: ''
                },
        
        "columns": [
                    {data:"CONTRACT_NO"},
                    {data:"PROJECT_NM"},
                    {data:"SECOND_PARTY"},
                    {data:"EXPECTED_COST"},
                    {data:"SIGNING_DATE"}
                  ]
	});
	
	$('#tb_contractRefundByMonth').DataTable({
		"lengthChange": true,//是否允许用户自定义显示数量
        "bPaginate": true, //翻页功能
        "bFilter": false, //列筛序功能
        "searching": true,//本地搜索
        "ordering": true, //排序功能
        "Info": true,//页脚信息
        "autoWidth": false,//自动宽度
        "oLanguage": {//国际语言转化
            "oAria": {
                "sSortAscending": " - click/return to sort ascending",
                "sSortDescending": " - click/return to sort descending"
            },
            "sLengthMenu": "显示 _MENU_ 记录",
            "sZeroRecords": "对不起，查询不到任何相关数据",
            "sEmptyTable": "未有相关数据",
            "sLoadingRecords": "正在加载数据-请等待...",
            "sInfo": "当前显示 _START_ 到 _END_ 条，共 _TOTAL_ 条记录。",
            "sInfoEmpty": "当前显示0到0条，共0条记录",
            "sInfoFiltered": "（总共 _MAX_ 条记录）",
            "sProcessing": "正在加载数据...",
            "sSearch": "模糊查询：",
            "oPaginate": {
                "sFirst": "首页",
                "sPrevious": " 上一页 ",
                "sNext": " 下一页 ",
                "sLast": " 尾页 "
            }
        },
        "columnDefs": [
                       {
                           orderable: false,
     
                           targets: 0 },
                       {
                           orderable: false,
     
                           targets: 1 }
                   ],
     
         "ajax": {
                    url: '/statistic/getContractRefundByMonth',
                    dataSrc: ''
                },
        
        "columns": [
                    {data:"CONTRACT_NM"},
                    {data:"PAY_UNIT"},
                    {data:"AMOUNT"},
                    {data:"PAY_DATE"}
                  ]
	});
	
	$('#tb_contractRefundByQuarter').DataTable({
		"lengthChange": true,//是否允许用户自定义显示数量
        "bPaginate": true, //翻页功能
        "bFilter": false, //列筛序功能
        "searching": true,//本地搜索
        "ordering": true, //排序功能
        "Info": true,//页脚信息
        "autoWidth": false,//自动宽度
        "oLanguage": {//国际语言转化
            "oAria": {
                "sSortAscending": " - click/return to sort ascending",
                "sSortDescending": " - click/return to sort descending"
            },
            "sLengthMenu": "显示 _MENU_ 记录",
            "sZeroRecords": "对不起，查询不到任何相关数据",
            "sEmptyTable": "未有相关数据",
            "sLoadingRecords": "正在加载数据-请等待...",
            "sInfo": "当前显示 _START_ 到 _END_ 条，共 _TOTAL_ 条记录。",
            "sInfoEmpty": "当前显示0到0条，共0条记录",
            "sInfoFiltered": "（总共 _MAX_ 条记录）",
            "sProcessing": "正在加载数据...",
            "sSearch": "模糊查询：",
            "oPaginate": {
                "sFirst": "首页",
                "sPrevious": " 上一页 ",
                "sNext": " 下一页 ",
                "sLast": " 尾页 "
            }
        },
        "columnDefs": [
                       {
                           orderable: false,
     
                           targets: 0 },
                       {
                           orderable: false,
     
                           targets: 1 }
                   ],
     
         "ajax": {
                    url: '/statistic/getContractRefundByQuarter',
                    dataSrc: ''
                },
        
        "columns": [
                    {data:"CONTRACT_NM"},
                    {data:"PAY_UNIT"},
                    {data:"AMOUNT"},
                    {data:"PAY_DATE"}
                  ]
	});
	
	$('#tb_contractRefundByYear').DataTable({
		"lengthChange": true,//是否允许用户自定义显示数量
        "bPaginate": true, //翻页功能
        "bFilter": false, //列筛序功能
        "searching": true,//本地搜索
        "ordering": true, //排序功能
        "Info": true,//页脚信息
        "autoWidth": false,//自动宽度
        "oLanguage": {//国际语言转化
            "oAria": {
                "sSortAscending": " - click/return to sort ascending",
                "sSortDescending": " - click/return to sort descending"
            },
            "sLengthMenu": "显示 _MENU_ 记录",
            "sZeroRecords": "对不起，查询不到任何相关数据",
            "sEmptyTable": "未有相关数据",
            "sLoadingRecords": "正在加载数据-请等待...",
            "sInfo": "当前显示 _START_ 到 _END_ 条，共 _TOTAL_ 条记录。",
            "sInfoEmpty": "当前显示0到0条，共0条记录",
            "sInfoFiltered": "（总共 _MAX_ 条记录）",
            "sProcessing": "正在加载数据...",
            "sSearch": "模糊查询：",
            "oPaginate": {
                "sFirst": "首页",
                "sPrevious": " 上一页 ",
                "sNext": " 下一页 ",
                "sLast": " 尾页 "
            }
        },
        "columnDefs": [
                       {
                           orderable: false,
     
                           targets: 0 },
                       {
                           orderable: false,
     
                           targets: 1 }
                   ],
     
         "ajax": {
                    url: '/statistic/getContractRefundByYear',
                    dataSrc: ''
                },
        
        "columns": [
                    {data:"CONTRACT_NM"},
                    {data:"PAY_UNIT"},
                    {data:"AMOUNT"},
                    {data:"PAY_DATE"}
                  ]
	});
	
	$('#tb_oVConfirmByMonth').DataTable({
		"lengthChange": true,//是否允许用户自定义显示数量
        "bPaginate": true, //翻页功能
        "bFilter": false, //列筛序功能
        "searching": true,//本地搜索
        "ordering": true, //排序功能
        "Info": true,//页脚信息
        "autoWidth": false,//自动宽度
        "oLanguage": {//国际语言转化
            "oAria": {
                "sSortAscending": " - click/return to sort ascending",
                "sSortDescending": " - click/return to sort descending"
            },
            "sLengthMenu": "显示 _MENU_ 记录",
            "sZeroRecords": "对不起，查询不到任何相关数据",
            "sEmptyTable": "未有相关数据",
            "sLoadingRecords": "正在加载数据-请等待...",
            "sInfo": "当前显示 _START_ 到 _END_ 条，共 _TOTAL_ 条记录。",
            "sInfoEmpty": "当前显示0到0条，共0条记录",
            "sInfoFiltered": "（总共 _MAX_ 条记录）",
            "sProcessing": "正在加载数据...",
            "sSearch": "模糊查询：",
            "oPaginate": {
                "sFirst": "首页",
                "sPrevious": " 上一页 ",
                "sNext": " 下一页 ",
                "sLast": " 尾页 "
            }
        },
        "columnDefs": [
                       {
                           orderable: false,
     
                           targets: 0 },
                       {
                           orderable: false,
     
                           targets: 1 }
                   ],
     
         "ajax": {
                    url: '/statistic/getContractProductiveConfirmByMonth',
                    dataSrc: ''
                },
        
        "columns": [
                    {data:"CONTRACT_NM"},
                    {data:"PAY_UNIT"},
                    {data:"AMOUNT"},
                    {data:"PAY_DATE"}
                  ]
	});
	
	$('#tb_oVConfirmByQuarter').DataTable({
		"lengthChange": true,//是否允许用户自定义显示数量
        "bPaginate": true, //翻页功能
        "bFilter": false, //列筛序功能
        "searching": true,//本地搜索
        "ordering": true, //排序功能
        "Info": true,//页脚信息
        "autoWidth": false,//自动宽度
        "oLanguage": {//国际语言转化
            "oAria": {
                "sSortAscending": " - click/return to sort ascending",
                "sSortDescending": " - click/return to sort descending"
            },
            "sLengthMenu": "显示 _MENU_ 记录",
            "sZeroRecords": "对不起，查询不到任何相关数据",
            "sEmptyTable": "未有相关数据",
            "sLoadingRecords": "正在加载数据-请等待...",
            "sInfo": "当前显示 _START_ 到 _END_ 条，共 _TOTAL_ 条记录。",
            "sInfoEmpty": "当前显示0到0条，共0条记录",
            "sInfoFiltered": "（总共 _MAX_ 条记录）",
            "sProcessing": "正在加载数据...",
            "sSearch": "模糊查询：",
            "oPaginate": {
                "sFirst": "首页",
                "sPrevious": " 上一页 ",
                "sNext": " 下一页 ",
                "sLast": " 尾页 "
            }
        },
        "columnDefs": [
                       {
                           orderable: false,
     
                           targets: 0 },
                       {
                           orderable: false,
     
                           targets: 1 }
                   ],
     
         "ajax": {
                    url: '/statistic/getContractProductiveConfirmByQuarter',
                    dataSrc: ''
                },
        
        "columns": [
                    {data:"CONTRACT_NM"},
                    {data:"PAY_UNIT"},
                    {data:"AMOUNT"},
                    {data:"PAY_DATE"}
                  ]
	});
	
	$('#tb_oVConfirmByYear').DataTable({
		"lengthChange": true,//是否允许用户自定义显示数量
        "bPaginate": true, //翻页功能
        "bFilter": false, //列筛序功能
        "searching": true,//本地搜索
        "ordering": true, //排序功能
        "Info": true,//页脚信息
        "autoWidth": false,//自动宽度
        "oLanguage": {//国际语言转化
            "oAria": {
                "sSortAscending": " - click/return to sort ascending",
                "sSortDescending": " - click/return to sort descending"
            },
            "sLengthMenu": "显示 _MENU_ 记录",
            "sZeroRecords": "对不起，查询不到任何相关数据",
            "sEmptyTable": "未有相关数据",
            "sLoadingRecords": "正在加载数据-请等待...",
            "sInfo": "当前显示 _START_ 到 _END_ 条，共 _TOTAL_ 条记录。",
            "sInfoEmpty": "当前显示0到0条，共0条记录",
            "sInfoFiltered": "（总共 _MAX_ 条记录）",
            "sProcessing": "正在加载数据...",
            "sSearch": "模糊查询：",
            "oPaginate": {
                "sFirst": "首页",
                "sPrevious": " 上一页 ",
                "sNext": " 下一页 ",
                "sLast": " 尾页 "
            }
        },
        "columnDefs": [
                       {
                           orderable: false,
     
                           targets: 0 },
                       {
                           orderable: false,
     
                           targets: 1 }
                   ],
     
         "ajax": {
                    url: '/statistic/getContractProductiveConfirmByYear',
                    dataSrc: ''
                },
        
        "columns": [
                    {data:"CONTRACT_NM"},
                    {data:"PAY_UNIT"},
                    {data:"AMOUNT"},
                    {data:"PAY_DATE"}
                  ]
	});
	
	$('#tb_oVSelfEvaByMonth').DataTable({
		"lengthChange": true,//是否允许用户自定义显示数量
        "bPaginate": true, //翻页功能
        "bFilter": false, //列筛序功能
        "searching": true,//本地搜索
        "ordering": true, //排序功能
        "Info": true,//页脚信息
        "autoWidth": false,//自动宽度
        "oLanguage": {//国际语言转化
            "oAria": {
                "sSortAscending": " - click/return to sort ascending",
                "sSortDescending": " - click/return to sort descending"
            },
            "sLengthMenu": "显示 _MENU_ 记录",
            "sZeroRecords": "对不起，查询不到任何相关数据",
            "sEmptyTable": "未有相关数据",
            "sLoadingRecords": "正在加载数据-请等待...",
            "sInfo": "当前显示 _START_ 到 _END_ 条，共 _TOTAL_ 条记录。",
            "sInfoEmpty": "当前显示0到0条，共0条记录",
            "sInfoFiltered": "（总共 _MAX_ 条记录）",
            "sProcessing": "正在加载数据...",
            "sSearch": "模糊查询：",
            "oPaginate": {
                "sFirst": "首页",
                "sPrevious": " 上一页 ",
                "sNext": " 下一页 ",
                "sLast": " 尾页 "
            }
        },
        "columnDefs": [
                       {
                           orderable: false,
     
                           targets: 0 },
                       {
                           orderable: false,
     
                           targets: 1 }
                   ],
     
         "ajax": {
                    url: '/statistic/getContractProductiveEvaluateByMonth',
                    dataSrc: ''
                },
        
        "columns": [
                    {data:"CONTRACT_NM"},
                    {data:"PAY_UNIT"},
                    {data:"INVOICEVALUE"},
                    {data:"PAY_DATE"}
                  ]
	});
	
	$('#tb_oVSelfEvaByQuarter').DataTable({
		"lengthChange": true,//是否允许用户自定义显示数量
        "bPaginate": true, //翻页功能
        "bFilter": false, //列筛序功能
        "searching": true,//本地搜索
        "ordering": true, //排序功能
        "Info": true,//页脚信息
        "autoWidth": false,//自动宽度
        "oLanguage": {//国际语言转化
            "oAria": {
                "sSortAscending": " - click/return to sort ascending",
                "sSortDescending": " - click/return to sort descending"
            },
            "sLengthMenu": "显示 _MENU_ 记录",
            "sZeroRecords": "对不起，查询不到任何相关数据",
            "sEmptyTable": "未有相关数据",
            "sLoadingRecords": "正在加载数据-请等待...",
            "sInfo": "当前显示 _START_ 到 _END_ 条，共 _TOTAL_ 条记录。",
            "sInfoEmpty": "当前显示0到0条，共0条记录",
            "sInfoFiltered": "（总共 _MAX_ 条记录）",
            "sProcessing": "正在加载数据...",
            "sSearch": "模糊查询：",
            "oPaginate": {
                "sFirst": "首页",
                "sPrevious": " 上一页 ",
                "sNext": " 下一页 ",
                "sLast": " 尾页 "
            }
        },
        "columnDefs": [
                       {
                           orderable: false,
     
                           targets: 0 },
                       {
                           orderable: false,
     
                           targets: 1 }
                   ],
     
         "ajax": {
                    url: '/statistic/getContractProductiveEvaluateByQuarter',
                    dataSrc: ''
                },
        
        "columns": [
                    {data:"CONTRACT_NM"},
                    {data:"PAY_UNIT"},
                    {data:"INVOICEVALUE"},
                    {data:"PAY_DATE"}
                  ]
	});
	
	$('#tb_oVSelfEvaByYear').DataTable({
		"lengthChange": true,//是否允许用户自定义显示数量
        "bPaginate": true, //翻页功能
        "bFilter": false, //列筛序功能
        "searching": true,//本地搜索
        "ordering": true, //排序功能
        "Info": true,//页脚信息
        "autoWidth": false,//自动宽度
        "oLanguage": {//国际语言转化
            "oAria": {
                "sSortAscending": " - click/return to sort ascending",
                "sSortDescending": " - click/return to sort descending"
            },
            "sLengthMenu": "显示 _MENU_ 记录",
            "sZeroRecords": "对不起，查询不到任何相关数据",
            "sEmptyTable": "未有相关数据",
            "sLoadingRecords": "正在加载数据-请等待...",
            "sInfo": "当前显示 _START_ 到 _END_ 条，共 _TOTAL_ 条记录。",
            "sInfoEmpty": "当前显示0到0条，共0条记录",
            "sInfoFiltered": "（总共 _MAX_ 条记录）",
            "sProcessing": "正在加载数据...",
            "sSearch": "模糊查询：",
            "oPaginate": {
                "sFirst": "首页",
                "sPrevious": " 上一页 ",
                "sNext": " 下一页 ",
                "sLast": " 尾页 "
            }
        },
        "columnDefs": [
                       {
                           orderable: false,
     
                           targets: 0 },
                       {
                           orderable: false,
     
                           targets: 1 }
                   ],
     
         "ajax": {
                    url: '/statistic/getContractProductiveEvaluateByYear',
                    dataSrc: ''
                },
        
        "columns": [
                    {data:"CONTRACT_NM"},
                    {data:"PAY_UNIT"},
                    {data:"INVOICEVALUE"},
                    {data:"PAY_DATE"}
                  ]
    });
    

    $('#tb_test').DataTable({
		"lengthChange": false,//是否允许用户自定义显示数量
        "bPaginate": true, //翻页功能
        "bFilter": false, //列筛序功能
        "searching": false,//本地搜索
        "ordering": false, //排序功能
        "Info": true,//页脚信息
        "autoWidth": true,//自动宽度
        "oLanguage": {//国际语言转化
            "oAria": {
                "sSortAscending": " - click/return to sort ascending",
                "sSortDescending": " - click/return to sort descending"
            },
            "sLengthMenu": "显示 _MENU_ 记录",
            "sZeroRecords": "对不起，查询不到任何相关数据",
            "sEmptyTable": "未有相关数据",
            "sLoadingRecords": "正在加载数据-请等待...",
            "sInfo": "当前显示 _START_ 到 _END_ 条，共 _TOTAL_ 条记录。",
            "sInfoEmpty": "当前显示0到0条，共0条记录",
            "sInfoFiltered": "（总共 _MAX_ 条记录）",
            "sProcessing": "正在加载数据...",
            "sSearch": "模糊查询：",
            "oPaginate": {
                "sFirst": "首页",
                "sPrevious": " 上一页 ",
                "sNext": " 下一页 ",
                "sLast": " 尾页 "
            }
        }
	});

} );