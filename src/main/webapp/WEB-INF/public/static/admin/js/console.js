$(function() {
    var proportion = parseInt(clientWidth / 1920 * 100) / 100;
    // 复选框
    $('.s-select').on('click', function() {
        if ($(this).is('.active')) {
            $(this).removeClass('active');
            // lineOption.legend.selected = {};
            // lineOption.legend.selected['2017/06/21'] = false;
            // myLineChart.setOption(lineOption);
        } else {
            $(this).addClass('active');
            // lineOption.legend.selected = {};
            // lineOption.legend.selected['2017/06/21'] = true;
            // myLineChart.setOption(lineOption);
        }
    });

    // 图表数据
    // 获取的折线图数据
    var getData;
    $.ajax({
        "url": "/admin/user/moneyProfile",
        "data": [
            {"type": 1}
        ],
        "dataType": "json",
        "type": "GET",
        "cache": false,
        "success": function (result) {
            for(var k in result){
                var dt={name:k,data:result[k]};
                getData.push(dt);
            }
        }
    });
    // getData = [{
    //     name: '2017/06/21',
    //     data: [5, 20, 36, 10, 10, 20, 32, 55, 77, 32, 45, 66, 77, 24, 52, 54, 52, 66, 32, 34, 56, 43, 11, 34]
    // },{
    //     name: '2017/06/22',
    //     data: [10, 20, 52, 66, 32, 34, 32, 55, 77, 32, 45, 5, 20, 36, 10, 66, 77, 24, 52, 54, 56, 43, 11, 34]
    // },{
    //     name: '2017/06/25',
    //     data: [1, 2, 5, 6, 3, 4, 2, 5, 77, 32, 45, 5, 20, 36, 10, 66, 77, 24, 52, 54, 56, 43, 11, 34]
    // },{
    //     name: '2017/06/05',
    //     data: [11, 12, 51, 61, 13, 41, 12, 15, 177, 32, 45, 5, 20, 36, 10, 66, 77, 24, 52, 54, 56, 43, 11, 34]
    // }];

    // 获取的饼图数据
    var getPieData = [{
        name: '在线查询',
        value: 335
    },{
        name: '一个分类',
        value: 255
    },{
        name: '场景服务',
        value: 221
    },{
        name: '场景服务2',
        value: 222
    },{
        name: '场景服务3',
        value: 333
    }]

    // 折线图折线的颜色
    var colors = ['#1a97f4', '#97968F'];
    // 折线图折线阴影的颜色
    var areaColors = ['rgba(26,151,244,0.39)','rgba(26,151,244,0.39)'];
    // 折线图x轴的数据
    var xData = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24];
    // 饼图的颜色
    var pieColors = ['#1a97f4','#b1d0e1','#10e2cc'];
    // 处理配置项数据
    var legendData = [];
    var seriesData = [];
    var pieData = [];
    for (var i = 0; i < getData.length; i++) {
        legendData.push({
            name: getData[i].name,
            icon: 'line'
        })
        seriesData.push({
            name: getData[i].name,
            symbol: 'circle',
            connectNulls: true,
            symbolSize: 10 * proportion,
            itemStyle: {
                normal: {
                    color: colors[i]
                }
            },
            lineStyle: {
                normal: {
                    color: colors[i],
                    width: 3 * proportion
                }
            },
            smooth: true,
            areaStyle: {
                normal: {
                    color: areaColors[i]
                }
            },
            type: 'line',
            data: getData[i].data
        })
    }
    for (var i = 0; i < getPieData.length; i++) {
        pieData.push({
            value: getPieData[i].value, 
            name: getPieData[i].name,
            itemStyle: {
                normal: {
                    color: pieColors[i],
                    shadowBlur: 200 * proportion,
                    shadowColor: 'rgba(0, 0, 0, 0.5)'
                }
            },
            labelLine: {
                normal: {
                    lineStyle: {
                        color: pieColors[i]
                    },
                    smooth: 0.2 * proportion,
                    length: 15 * proportion,
                    length2: 30 * proportion
                }
            },
            label: {
                normal: {
                    textStyle: {
                        color: pieColors[i]
                    }
                }
            },
        })
    }

    var canvas = document.querySelector('#bg-canvas');
    var lineChart = document.querySelector('#line-chart');

    // 折线图
    myLineChart = echarts.init(lineChart);

    // 指定图表的配置项和数据
    var lineOption = {
        tooltip: {
            trigger: 'axis',
            axisPointer: {
                type: 'cross'
            },
            formatter: function(params, ticket, callback){
                var time = parseInt(params[0].name);
                var startTime = time - 1;
                time = time > 9 ? time : '0' + time; 
                startTime = startTime > 9 ? startTime : '0' + startTime; 

                var dataHtml = '';
                for (var i = 0; i < params.length; i++) {
                    dataHtml += '<div style="margin-top:.1rem;font-size: .14rem;"><span style="margin-right: .13rem;position: relative;top: -.02rem;display: inline-block;width: .08rem;height: .08rem;border-radius: 50%;background-color: #fff;"></span>'+ params[i].seriesName +'<span style="float: right;">'+ params[i].value +'</span></div>';
                }

                var html = '';
                html +=  '<div style="color:rgba(255,255,255,0.65);font-size: .12rem;">'+ startTime + ':00-' + time +':00<span style="float:right">总交易额(万元)</span></div>'+ dataHtml
                return html;
            },
            backgroundColor: 'rgba(26,151,244,0.39)',
            borderColor: '#1a97f4',
            borderWidth: 1,
            padding: 9 * proportion,
            extraCssText: 'width:'+ 213 * proportion +'px;border-radius: '+ 4 * proportion +'px;'
        },
        legend: {
            // selected: {
            //     '2017/06/21': true,
            //     '2017/06/22': false
            // },
            right: 320 * proportion - (140 * (1 - proportion) / 2),
            top: 200 * proportion,
            orient: 'vertical',
            itemGap: 10 * proportion,
            textStyle: {
                color: '#999'
            },
            formatter: function(name) {
                return name + ' 总交易额';
            },
            data:  legendData
        },
        grid: {
            left: 100 * proportion,
            right: 520 * proportion
        },
        xAxis: {
            type: 'category',
            axisLabel: {
                textStyle: {
                    color: '#999'
                }
            },
            axisLine: {
                lineStyle: {
                    type: 'dashed',
                    color: '#1a97f4'
                }
            },
            axisTick: {
                show: false
            },
            data: xData
        },
        yAxis: {
            axisLabel: {
                textStyle: {
                    color: '#999'
                }
            },
            axisLine: {
                lineStyle: {
                    type: 'dashed',
                    color: '#1a97f4'
                }
            },
            axisTick: {
                show: false
            },
            splitLine: {
                show: false
            }
        },
        series: seriesData
    };

    // 使用刚指定的配置项和数据显示图表。
    myLineChart.setOption(lineOption);

    // 饼图
    var pieChart = document.querySelector('#pie-chart');
    myPieChart = echarts.init(pieChart);

    var pieOption = {
        // tooltip : {
        //     trigger: 'item',
        //     formatter: "{a} <br/>{b} : {c} ({d}%)"
        // },
        visualMap: {
            show: false,
            min: 80,
            max: 600,
            inRange: {
                colorLightness: [0, 1]
            }
        },
        series: [{
            type:'pie',
            radius : ['22%','55%'],
            center: [350 * proportion + 'px', '50%'],
            label: {
                normal: {
                    formatter: '{d}%\n{b}',
                    textStyle: {
                        fontSize: 24 * proportion
                    }
                }
            },
            data: pieData.sort(function (a, b) { return a.value - b.value; }),
            roseType: 'radius',                   
            animationType: 'scale',
            animationEasing: 'elasticOut',
            animationDelay: function (idx) {
                return Math.random() * 200;
            }
        }]
    };

    // 使用刚指定的配置项和数据显示图表。
    myPieChart.setOption(pieOption);

    // 背景
    clientHeight = document.documentElement.clientHeight;    
    canvas.width = clientWidth;
    canvas.height = clientHeight - 90 * proportion;
    if (canvas.getContext) {
        var ctx = canvas.getContext('2d');

        // 随机圆的数量
        var randomNum = parseInt(Math.random() * 300 + 200);

        ctx.beginPath();
        ctx.fillStyle = "rgba(151, 150, 143, 0.3)";
        for (var i = 0; i < randomNum; i++) {
            setTimeout(function() {
                drawCircle(ctx)
            }, 500)
        }
    }

    // 画圆
    function drawCircle(ctx) {
        var left = parseInt(Math.random() * clientWidth);
        var top = parseInt(Math.random() * clientHeight);
        var random = parseInt(Math.random() * 100);
        var radius = 1 * proportion;

        if (random < 10) {
            radius = 2 * proportion;
        } else if (random < 30) {
            radius = 3 * proportion;
        } else if (random > 95) {
            radius = 5 * proportion;
        }

        ctx.moveTo(left, top - radius);
        ctx.arc(left, top, radius, 0, Math.PI*2, true);
        ctx.fill();
    }
})