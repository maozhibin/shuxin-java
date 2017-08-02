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
        "url": "/admin/overview/moneyProfile",
        "data":{"types": [0]},
        // "dataType": "json",
        async:false,
        "type": "GET",
        "cache": false,
        "success": function (result) {
            getData="[";
            for(var k in result){
                getData+="{'name':'"+k+"','data':["+result[k]+"]}";
            }
            getData+="]";
            getData=eval('(' + getData + ')');
            playLine();
        }
    });
    $("#lastDay").change(function () {
        // console.log($(this).attr('checked'));
        var lastDayChenked=$(this).is(':checked');
        var lastWeekChenked=$("#lastWeek").is(':checked');
        if(lastDayChenked&&!lastWeekChenked){ /*只出现今日与昨日*/
            $.ajax({
                "url": "/admin/overview/moneyProfile",
                "data":{"types": [0,-1]},
                // "dataType": "json",
                async:false,
                "type": "GET",
                "cache": false,
                "success": function (result) {
                    getData="[";
                    for(var k in result){
                        getData+="{'name':'"+k+"','data':["+result[k]+"]},";
                    }
                    getData=getData.substring(0, getData.length - 1);
                    getData+="]";
                    console.log(eval('('+getData +')'));
                    getData=eval('(' + getData + ')');
                    playLine();
                }
            });
        }else if(lastWeekChenked&&lastDayChenked){
            $.ajax({
                "url": "/admin/overview/moneyProfile",
                "data":{"types": [0,-1,-7]},
                // "dataType": "json",
                async:false,
                "type": "GET",
                "cache": false,
                "success": function (result) {
                    getData="[";
                    for(var k in result){
                        getData+="{'name':'"+k+"','data':["+result[k]+"]},";
                    }
                    getData=getData.substring(0, getData.length - 1);
                    getData+="]";
                    console.log(eval('('+getData +')'));
                    getData=eval('(' + getData + ')');
                    playLine();
                }
            });
        }else if(!lastDayChenked){
            $.ajax({
                "url": "/admin/overview/moneyProfile",
                "data":{"types": [0]},
                // "dataType": "json",
                async:false,
                "type": "GET",
                "cache": false,
                "success": function (result) {
                    getData="[";
                    for(var k in result){
                        getData+="{'name':'"+k+"','data':["+result[k]+"]},";
                    }
                    getData=getData.substring(0, getData.length - 1);
                    getData+="]";
                    console.log(eval('('+getData +')'));
                    getData=eval('(' + getData + ')');
                    playLine();
                }
            });
        }else if(!lastDayChenked&&lastWeekChenked){
            $.ajax({
                "url": "/admin/overview/moneyProfile",
                "data":{"types": [0,-7]},
                // "dataType": "json",
                async:false,
                "type": "GET",
                "cache": false,
                "success": function (result) {
                    getData="[";
                    for(var k in result){
                        getData+="{'name':'"+k+"','data':["+result[k]+"]},";
                    }
                    getData=getData.substring(0, getData.length - 1);
                    getData+="]";
                    console.log(eval('('+getData +')'));
                    getData=eval('(' + getData + ')');
                    playLine();
                }
            });
        }
    });
    $("#lastWeek").change(function () {
        var lastWeekChenked=$(this).is(':checked');
        var lastDayChenked=$("#lastDay").is(':checked');
        if(lastDayChenked&&!lastWeekChenked){ /*只出现今日与昨日*/
            $.ajax({
                "url": "/admin/overview/moneyProfile",
                "data":{"types": [0,-1]},
                // "dataType": "json",
                async:false,
                "type": "GET",
                "cache": false,
                "success": function (result) {
                    getData="[";
                    for(var k in result){
                        getData+="{'name':'"+k+"','data':["+result[k]+"]},";
                    }
                    getData=getData.substring(0, getData.length - 1);
                    getData+="]";
                    console.log(eval('('+getData +')'));
                    getData=eval('(' + getData + ')');
                    playLine();
                }
            });
        }else if(lastWeekChenked&&lastDayChenked){
            $.ajax({
                "url": "/admin/overview/moneyProfile",
                "data":{"types": [0,-1,-7]},
                // "dataType": "json",
                async:false,
                "type": "GET",
                "cache": false,
                "success": function (result) {
                    getData="[";
                    for(var k in result){
                        getData+="{'name':'"+k+"','data':["+result[k]+"]},";
                    }
                    getData=getData.substring(0, getData.length - 1);
                    getData+="]";
                    console.log(eval('('+getData +')'));
                    getData=eval('(' + getData + ')');
                    playLine();
                }
            });
        }else if(!lastDayChenked){
            $.ajax({
                "url": "/admin/overview/moneyProfile",
                "data":{"types": [0]},
                // "dataType": "json",
                async:false,
                "type": "GET",
                "cache": false,
                "success": function (result) {
                    getData="[";
                    for(var k in result){
                        getData+="{'name':'"+k+"','data':["+result[k]+"]},";
                    }
                    getData=getData.substring(0, getData.length - 1);
                    getData+="]";
                    console.log(eval('('+getData +')'));
                    getData=eval('(' + getData + ')');
                    playLine();
                }
            });
        }else if(!lastDayChenked&&lastWeekChenked){
            $.ajax({
                "url": "/admin/overview/moneyProfile",
                "data":{"types": [0,-7]},
                // "dataType": "json",
                async:false,
                "type": "GET",
                "cache": false,
                "success": function (result) {
                    getData="[";
                    for(var k in result){
                        getData+="{'name':'"+k+"','data':["+result[k]+"]},";
                    }
                    getData=getData.substring(0, getData.length - 1);
                    getData+="]";
                    console.log(eval('('+getData +')'));
                    getData=eval('(' + getData + ')');
                    playLine();
                }
            });
        }
    });
    function playLine(){
        // 折线图折线的颜色
        var colors = ['#1a97f4', '#97968F'];
        // 折线图折线阴影的颜色
        var areaColors = ['rgba(26,151,244,0.39)','rgba(26,151,244,0.39)'];
        // 折线图x轴的数据
        var xData = [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23];
        // 处理配置项数据
        var legendData = [];
        var seriesData = [];
        var canvas = document.querySelector('#bg-canvas');
        var lineChart = document.querySelector('#line-chart');
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
    for (var i = 0; i < getData.length; i++) {
        legendData.push({
            name: getData[i].name,
            icon: 'line'
        });
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
        });
    }
        // 折线图
        myLineChart = echarts.init(lineChart);
        // 使用刚指定的配置项和数据显示图表。
        myLineChart.setOption(lineOption);
    }
});