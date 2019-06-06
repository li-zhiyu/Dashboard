function option1(respText){
	var option = {
		    backgroundColor: '#FFFFFF',

		    title: {
		        text: 'Customized Pie',
		        left: 'center',
		        top: 20,
		        textStyle: {
		            color: '#ccc'
		        }
		    },

		    tooltip : {
		        trigger: 'item',
		        formatter: "{a} <br/>{b} : {c} ({d}%)"
		    },

		    visualMap: {
		        show: false,
		        min: 80,
		        max: 600,
		        inRange: {
		            colorLightness: [0, 1]
		        }
		    },
		    series : [
		        {
		            name:'访问来源',
		            type:'pie',
		            radius : '55%',
		            center: ['50%', '50%'],
		            data:[
		                {value:respText.total, name:'总用户数'},
		                {value:respText.current, name:'在线用户'},
		            ],
		            roseType: 'radius',
		            label: {
		                normal: {
		                    textStyle: {
		                        color: 'rgba(255, 255, 255, 0.3)'
		                    }
		                }
		            },
		            labelLine: {
		                normal: {
		                    lineStyle: {
		                        color: 'rgba(255, 255, 255, 0.3)'
		                    },
		                    smooth: 0.2,
		                    length: 10,
		                    length2: 20
		                }
		            },
		            itemStyle: {
		                normal: {
		                    color: '#c23531',
		                    shadowBlur: 200,
		                    shadowColor: 'rgba(0, 0, 0, 0.5)'
		                }
		            },

		            animationType: 'scale',
		            animationEasing: 'elasticOut',
		            animationDelay: function (idx) {
		                return Math.random() * 200;
		            }
		        }
		    ]
		};
	return option;
}

function option2(respText){
	var option = {
		    tooltip: {
		        trigger: 'item',
		        formatter: "{a} <br/>{b}: {c} ({d}%)"
		    },
		    legend: {
		        orient: 'vertical',
		        x: 'left',
		        data:['总用户数','在线用户']
		    },
		    series: [
		        {
		            name:'访问来源',
		            type:'pie',
		            radius: ['50%', '70%'],
		            avoidLabelOverlap: false,
		            label: {
		                normal: {
		                    show: false,
		                    position: 'center'
		                },
		                emphasis: {
		                    show: true,
		                    textStyle: {
		                        fontSize: '30',
		                        fontWeight: 'bold'
		                    }
		                }
		            },
		            labelLine: {
		                normal: {
		                    show: false
		                }
		            },
		            data:[
		                {value:respText.total, name:'总用户数'},
		                {value:respText.current, name:'在线用户'}
		            ]
		        }
		    ]
		};
	return option;
}

function option4(respText){
	option = {
		    title : {
		        text: '项目统计',
		        subtext: '按项目状态分类',
		        x:'center'
		    },
		    tooltip : {
		        trigger: 'item',
		        formatter: "{a} <br/>{b} : {c} ({d}%)"
		    },
		    legend: {
		        orient: 'vertical',
		        left: 'left',
		        data: ['进行中','已结束','已完工','已暂停']
		    },
		    series : [
		        {
		            name: '',
		            type: 'pie',
		            radius : '55%',
		            center: ['50%', '60%'],
		            data:[
		                {value:respText.going, name:'进行中'},
		                {value:respText.over, name:'已结束'},
		                {value:respText.finish, name:'已完工'},
		                {value:respText.suspend, name:'已暂停'}
		            ],
		            itemStyle: {
		                emphasis: {
		                    shadowBlur: 10,
		                    shadowOffsetX: 0,
		                    shadowColor: 'rgba(0, 0, 0, 0.5)'
		                }
		            }
		        }
		    ]
		};
return option;
}

function contractOption(respText){
	option = {

		    series: [
		        {
		            name:'合同回款',
		            type:'pie',
		            radius: ['70%', '90%'],
		            avoidLabelOverlap: false,
		            color:['#6A5ACD','#D3D3D3'],
		            label: {
		                normal: {
		                    show: true,
		                    position: 'center',
		                    textStyle: {
		                        fontSize: '16',
		                        fontWeight: 'bold',
		                        color:'#000000'
		                    }
		                },
		                emphasis: {
		                    show: false,
		                    textStyle: {
		                        fontSize: '30',
		                        fontWeight: 'bold'
		                    }
		                }
		            },
		            data:[
		                {value:respText.currentYear, name:'今年已回款'+'\n\n'+respText.currentYear+'万元'},
		                {value:respText.targetYear-respText.currentYear}
		            ]
		        }
		    ]
		};
	return option;
}

function OVConfirmOption(respText){
	option = {

		    series: [
		        {
		            name:'产值确认',
		            type:'pie',
		            radius: ['70%', '90%'],
		            avoidLabelOverlap: false,
		            color:['#FF7F50','#FAFAD2'],
		            label: {
		                normal: {
		                    show: true,
		                    position: 'center',
		                    textStyle: {
		                        fontSize: '16',
		                        fontWeight: 'bold',
		                        color:'#000000'
		                    }
		                },
		                emphasis: {
		                    show: false,
		                    textStyle: {
		                        fontSize: '30',
		                        fontWeight: 'bold'
		                    }
		                }
		            },
		            data:[
		                {value:respText.currentYear, name:'今年已确认'+'\n\n'+respText.currentYear+'万元'},
		                {value:respText.targetYear-respText.currentYear}
		            ]
		        }
		    ]
		};
	return option;
}

function OVSelfEvaOption(respText){
	option = {

		    series: [
		        {
		            name:'产值自评',
		            type:'pie',
		            radius: ['70%', '90%'],
		            avoidLabelOverlap: false,
		            color:['#FF0000','#FFEFD5'],
		            label: {
		                normal: {
		                    show: true,
		                    position: 'center',
		                    textStyle: {
		                        fontSize: '16',
		                        fontWeight: 'bold',
		                        color:'#000000'
		                    }
		                },
		                emphasis: {
		                    show: false,
		                    textStyle: {
		                        fontSize: '30',
		                        fontWeight: 'bold'
		                    }
		                }
		            },
		            data:[
		                {value:respText.currentYear, name:'今年已自评'+'\n\n'+respText.currentYear+'万元'},
		                {value:respText.targetYear-respText.currentYear}
		            ]
		        }
		    ]
		};
	return option;
}

function SignOption(respText){
	option = {

		    series: [
		        {
		            name:'合同签订',
		            type:'pie',
		            radius: ['70%', '90%'],
		            avoidLabelOverlap: false,
		            color:['#8B008B','#E0FFFF'],
		            label: {
		                normal: {
		                    show: true,
		                    position: 'center',
		                    textStyle: {
		                        fontSize: '16',
		                        fontWeight: 'bold',
		                        color:'#000000'
		                    }
		                },
		                emphasis: {
		                    show: false,
		                    textStyle: {
		                        fontSize: '30',
		                        fontWeight: 'bold'
		                    }
		                }
		            },
		            data:[
		                {value:respText.currentYear, name:'今年已签订'+'\n\n'+respText.currentYear+'万元'},
		                {value:respText.targetYear-respText.currentYear}
		            ]
		        }
		    ]
		};
	return option;
}

function fileOption(respText){
	option = {
		    title: {
		    	text: '                   总计(年)：'+respText.sum,
		        textStyle: {
                      fontSize: '12',
                      fontWeight: 'bold',
                      color:'#0000FF'
                  },
		    },
			color: ['#3398DB'],
		    tooltip : {
		        trigger: 'axis',
		        axisPointer : {            // 坐标轴指示器，坐标轴触发有效
		            type : 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
		        }
		    },
		    grid: {
		        left: '3%',
		        right: '4%',
		        bottom: '3%',
		        top: '10%',
		        containLabel: true
		    },
		    xAxis : [
		        {
		            type : 'category',
		            data : respText.xAxis_data,
		            axisTick: {
		                alignWithLabel: true
		            }
		        }
		    ],
		    yAxis : [
		        {
		            type : 'value'
		        }
		    ],
		    series : [
				        {
				            name:"",
				            type:'bar',
				            barWidth: '40%',
				            data: respText.series_data,
				            markLine : {
                                	data : [{type : 'average', name: '平均值'}]
		                        },
				            label: {
				                normal: {
				                    show: true,
				                    position: 'outside'
				                }
				            }
				        },
				        {
				            type:'line',
							color:'red',
							smooth: true,
				            data: respText.series_data,
				        }
				     ]
		};
	return option;
}

function proProjectOption(respText){
	option = {
		    series: [
		        {
		            name:'拓展项目',
		            type:'pie',
		            radius : '70%',
		            center: ['50%', '50%'],
		            labelLine:{
		            	normal:{
		            		length:8,
		            		lineStyle:{
		            			color:'black',
		            		}
		            	}
		            },
		            label: {
		                normal: {
		                    formatter: ' {b|{b} : \n{c}}{per|({d}%)}',
		                    rich: {
		                        b: {
		                        	color: '#000000',
		                        	fontSize: 11,
		                            lineHeight: 24,
		                            align: 'center'
		                        },
		                        per: {
		                            color: '#0000FF',
		                            padding: [1, 1],
		                            fontSize: 11,
		                            borderRadius: 2,
		                            align: 'center'
		                        }
		                    }
		                }
		            },
		            data:respText.series_data,
		        }
		    ]
		};
	return option;
}

function projectStatusOption(respText){
	option = {
		    series: [
		        {
		            name:'项目状态',
		            type:'pie',
		            radius : '70%',
		            center: ['50%', '50%'],
		            color:['#D2691E','#6495ED','#006400','#483D8B'],
		            labelLine:{
		            	normal:{
		            		length:8,
		            		lineStyle:{
		            			color:'black',
		            		}
		            	}
		            },
		            label: {
		                normal: {
		                    formatter: ' {b|{b} : {c}}{per|({d}%)}',
		                    rich: {
		                        b: {
		                        	color: '#000000',
		                        	fontSize: 11,
		                            lineHeight: 24,
		                            align: 'center'
		                        },
		                        per: {
		                            color: '#0000FF',
		                            padding: [1, 1],
		                            fontSize: 11,
		                            borderRadius: 2,
		                            align: 'center'
		                        }
		                    }
		                }
		            },
		            data:respText.series_data,
		        }
		    ]
		};
	return option;
}

function projectFlowOption(respText){
	option = {
		    series: [
		        {
		            name:'项目状态',
		            type:'pie',
		            radius : '70%',
		            center: ['50%', '50%'],
		            color:['#DC143C','#6495ED','#BDB76B','#696969','#F08080','#4682B4'],
		            labelLine:{
		            	normal:{
		            		length:8,
		            		lineStyle:{
		            			color:'black',
		            		}
		            	}
		            },
		            label: {
		                normal: {
		                    formatter: ' {b|{b} : {c}}{per|({d}%)}',
		                    rich: {
		                        b: {
		                        	color: '#000000',
		                        	fontSize: 11,
		                            lineHeight: 24,
		                            align: 'center'
		                        },
		                        per: {
		                            color: '#0000FF',
		                            padding: [1, 1],
		                            fontSize: 11,
		                            borderRadius: 2,
		                            align: 'center'
		                        }
		                    }
		                }
		            },
		            data:respText.series_data,
		        }
		    ]
		};
	return option;
}