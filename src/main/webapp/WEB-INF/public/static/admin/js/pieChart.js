$(function() {
    var proportion = parseInt(clientWidth / 1920 * 100) / 100;
    // 饼图
    // 饼图的颜色
    var pieColors = ['#1a97f4','#b1d0e1','#10e2cc'];
    // 获取的饼图数据
    var getPieData = [{
        name: '场景服务3',
        value: 333
    }];
    $.ajax({
        "url": "/admin/overview/round",
        async:false,
        "type": "GET",
        "cache": false,
        "success": function (result) {
            getPieData=result;
        }
    });
    // 处理配置项数据
    var pieData = [];
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
});