$(function() {
    var proportion = parseInt(clientWidth / 1920 * 100) / 100;
    /*lineChart*/
    // 图表数据
    var name1,name2,name3,data1,data2,data3;
    $.ajax({
        "url": "/admin/overview/moneyProfile",
        "data":{"types": [0,-1,-7]},
        async:false,
        "type": "GET",
        "cache": false,
        "success": function (result) {
            var name=[],data=[];
            for(var k in result){
                name.push(k);
                data.push(result[k]);
            }
            name1=name[0];
            name2=name[1];
            name3=name[2];
            data1=data[0];
            data2=data[1];
            data3=data[2];
            // console.log(name1);
            // console.log(name2);
            // console.log(name3);
            // console.log(data1);
            // console.log(data2);
            // console.log(data3);
        }
    });


    // 基于准备好的dom，初始化echarts图表
    var myChart = echarts.init(document.getElementById('line-chart'));

    var option = {
        // 图表标题
        title: {
            x: 'left',                 // 水平安放位置，默认为左对齐，可选为：
                                       // 'center' ¦ 'left' ¦ 'right'
                                       // ¦ {number}（x坐标，单位px）
            y: 'top',                  // 垂直安放位置，默认为全图顶端，可选为：
                                       // 'top' ¦ 'bottom' ¦ 'center'
                                       // ¦ {number}（y坐标，单位px）
            //textAlign: null          // 水平对齐方式，默认根据x设置自动调整
            backgroundColor: 'rgba(0,0,0,0)',
            borderColor: '#ccc',       // 标题边框颜色
            borderWidth: 0,            // 标题边框线宽，单位px，默认为0（无边框）
            padding: 5,                // 标题内边距，单位px，默认各方向内边距为5，
                                       // 接受数组分别设定上右下左边距，同css
            itemGap: 10,               // 主副标题纵向间隔，单位px，默认为10，
            textStyle: {
                fontSize: 18,
                fontWeight: 'bolder',
                color: '#ccc'          // 主标题文字颜色
            },
            subtextStyle: {
                color: '#aaa'          // 副标题文字颜色
            },
            text: '平台数据概况'
        },
        tooltip : {
            trigger: 'axis'
        },
        axis : {
            axisLine: {show: false}
        },
        legend: {
            data:['今天','前一日','上周同期']
        },
        toolbox: {
            show : false,
            feature : {
                mark : {show: true},
                dataView : {show: true, readOnly: false},
                magicType : {show: true, type: ['line', 'bar', 'stack', 'tiled']},
                restore : {show: true},
                saveAsImage : {show: true}
            }
        },
        calculable : false,
        xAxis : [
            {
                type : 'category',
                boundaryGap : false,
                splitLine:{show:false},
                splitArea:{show:false},
                axisLabel: {
                    show: true,
                    textStyle: {
                        color: '#fff'
                    }
                },
                data : [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23]
            }
        ],
        yAxis : [
            {
                type : 'value',
                splitLine:{show:false},
                axisLabel: {
                    show: true,
                    textStyle: {
                        color: '#fff'
                    }
                },
                splitArea:{show:false}
            }
        ],
        series : [
            {
                name:'今天',
                type:'line',
                smooth:true,
                itemStyle: {normal: {areaStyle: {type: 'default'}}},
                data:data1
            },
            {
                name:'前一日',
                type:'line',
                smooth:true,
                itemStyle: {normal: {areaStyle: {type: 'default'}}},
                data:data2
            },
            {
                name:'上周同期',
                type:'line',
                smooth:true,
                itemStyle: {
                    normal:
                        {areaStyle:
                            {type: 'default',color:'#333'}
                        }
                    },
                data:data3
            }
        ]
    };

    // 为echarts对象加载数据
    myChart.setOption(option);
    /* /lineChart */
    var canvas = document.querySelector('#bg-canvas');

    // 饼图
    var myPieChart = echarts.init(document.getElementById('pie-chart'));
    // 获取的饼图数据
    var getPieData,names=[];
    $.ajax({
        "url": "/admin/overview/round",
        async:false,
        "type": "GET",
        "cache": false,
        "success": function (result) {
            console.log(result);
            getPieData=result;
            for(var i=0;i<result.length;i++){
                names.push(result[i].name);
            }
            console.log(names);
        }
    });


    var pieOption = {
       /* title : {
            text: '某站点用户访问来源',
            subtext: '纯属虚构',
            x:'center'
        },*/
        tooltip : {
            trigger: 'item',
            formatter: "{a} <br/>{b} : {c} ({d}%)"
        },
        legend: {
            orient : 'vertical',
            x : 'left',
            data:names
        },
        calculable : false,
        series : [
            {
                name:'访问来源',
                type:'pie',
                radius : '55%',
                center: ['50%', '60%'],
                data:getPieData
            }
        ]
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