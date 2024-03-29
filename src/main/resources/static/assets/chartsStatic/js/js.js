﻿$(function () {
    // 图1 平均值
    $.get("http://localhost:8080/charts/median/", function (data, status) {
        if (status == "success") {
            jsonData = JSON.parse(data);
            var top = jsonData.top;
            var plies = jsonData.plies;
            var total = jsonData.total;
            var height = jsonData.height;
            var stemlen = jsonData.stemlen;
            var weight = jsonData.weight;

            echarts_1([top,plies,total,height,stemlen,weight]);


        } else {
            console.log("获取显示数据失效")
        }
    });

    //图3-1 宽度分布
    // $.get("http://localhost:5000/rose/charts/widthdis/", function (data, status) {
    //     if (status == "success") {
    //         echarts_31(data)
    //     } else {
    //         console.log("获取显示数据失效")
    //     }
    // });

    echarts_2();

    //echarts_32();


    // 图3-1 宽度分布
    $.get("http://localhost:8080/charts/widthdis/", function (data, status) {
        if (status == "success") {
            console.log(JSON.parse(data));
            echarts_31(JSON.parse(data));
        } else {
            console.log("获取宽度数据失败")
        }
    });

    //图3-2 高度分布
    $.get("http://localhost:8080/charts/heightdis/", function (data, status) {
            if (status == "success") {
                console.log(JSON.parse(data));
                echarts_32(JSON.parse(data));
            } else {
                console.log("获取高度数据失败")
            }
        });




    // 图3-3 杆长分布
    $.get("http://localhost:8080/charts/stemlen/", function (data, status) {
        if (status == "success") {
            console.log(JSON.parse(data));
            echarts_33(JSON.parse(data));
        } else {
            console.log("获取杆长数据失败")
        }
    });

    //两条曲线
    echarts_4();


        // 图1 平均值
        $.get("http://localhost:8080/charts/maxmin/", function (data, status) {
            if (status == "success") {
                jsonData = JSON.parse(data);

                var totalMax = jsonData.totalMax;
                var totalMean = jsonData.totalMean;
                var heightMax = jsonData.heightMax;
                var heightMean = jsonData.heightMean;
                var topwMax = jsonData.topwMax;
                var topwMean = jsonData.topwMean;
                var totalStd = jsonData.totalStd;
                var heightStd = jsonData.heightStd;
                var topwStd = jsonData.topwStd;


                echarts_5([totalMax, totalMean, heightMax, heightMean,totalStd,heightStd]);


            } else {
                console.log("获取显示数据失效")
            }
        });

    //图六 等级比例
    $.get("http://localhost:8080/charts/grade/",function(data,status){
        if(status =="success"){
            //jsonGrade = JSON.parse(data);

            echarts_6(JSON.parse(data))
        }
    });
});

echarts_1();
echarts_2();
echarts_4();
echarts_31();
echarts_32();
echarts_33();
echarts_5();
echarts_6();
function echarts_1(echart1_mean) {
    // 基于准备好的dom，初始化echarts实例
    var myChart = echarts.init(document.getElementById('echart1'));

    option = {
        //  backgroundColor: '#00265f',
        tooltip: {
            trigger: 'axis',
            axisPointer: {
                type: 'shadow'
            }
        },
        grid: {
            left: '0%',
            top: '10px',
            right: '0%',
            bottom: '4%',
            containLabel: true
        },
        xAxis: [{
            type: 'category',
            data: ['平均直径', '平均层数', '平均宽度', '平均高度', '平均杆长', '平均质量'],
            axisLine: {
                show: true,
                lineStyle: {
                    color: "rgba(255,255,255,.1)",
                    width: 1,
                    type: "solid"
                },
            },

            axisTick: {
                show: false,
            },
            axisLabel: {
                interval: 0,
                // rotate:50,
                show: true,
                splitNumber: 15,
                textStyle: {
                    color: "rgba(255,255,255,.6)",
                    fontSize: '12',
                },
            },
        }],
        yAxis: [{
            type: 'value',
            axisLabel: {
                //formatter: '{value} %'
                show: true,
                textStyle: {
                    color: "rgba(255,255,255,.6)",
                    fontSize: '12',
                },
            },
            axisTick: {
                show: false,
            },
            axisLine: {
                show: true,
                lineStyle: {
                    color: "rgba(255,255,255,.1	)",
                    width: 1,
                    type: "solid"
                },
            },
            splitLine: {
                lineStyle: {
                    color: "rgba(255,255,255,.1)",
                }
            }
        }],
        series: [
            {
                type: 'bar',
                //data: [200,300,900, 1500, 1200, 600],
                data: echart1_mean,
                barWidth: '35%', //柱子宽度
                // barGap: 1, //柱子之间间距
                itemStyle: {
                    normal: {
                        color: '#2f89cf',
                        opacity: 1,
                        barBorderRadius: 5,
                    }
                }
            }

        ]
    };

    // 使用刚指定的配置项和数据显示图表。
    myChart.setOption(option);
    window.addEventListener("resize", function () {
        myChart.resize();
    });
}
function echarts_2() {
    // 基于准备好的dom，初始化echarts实例
    var myChart = echarts.init(document.getElementById('echart2'));

    option = {
        tooltip: {
            trigger: 'axis',
            axisPointer: {
                lineStyle: {
                    color: '#dddc6b'
                }
            }
        },
        legend: {
            top: '0%',
            textStyle: {
                color: 'rgba(255,255,255,.5)',
                fontSize: '12',
            }
        },
        grid: {
            left: '10',
            top: '30',
            right: '10',
            bottom: '10',
            containLabel: true
        },

        xAxis: [{
            type: 'category',
            boundaryGap: false,
            axisLabel: {
                textStyle: {
                    color: "rgba(255,255,255,.6)",
                    fontSize: 12,
                },
            },
            axisLine: {
                lineStyle: {
                    color: 'rgba(255,255,255,.2)'
                }

            },

            data: ['01', '02', '03', '04', '05', '06', '07', '08', '09', '11','12','13','14','15','16','17','18']

        }, {

            axisPointer: { show: false },
            axisLine: { show: false },
            position: 'bottom',
            offset: 20,



        }],

        yAxis: [{
            type: 'value',
            axisTick: { show: false },
            axisLine: {
                lineStyle: {
                    color: 'rgba(255,255,255,.1)'
                }
            },
            axisLabel: {
                textStyle: {
                    color: "rgba(255,255,255,.6)",
                    fontSize: 12,
                },
            },

            splitLine: {
                lineStyle: {
                    color: 'rgba(255,255,255,.1)'
                }
            }
        }],
        series: [
            {
                name: '2019年8月',
                type: 'line',
                smooth: true,
                symbol: 'circle',
                symbolSize: 5,
                showSymbol: false,
                lineStyle: {

                    normal: {
                        color: '#00d887',
                        width: 2
                    }
                },
                areaStyle: {
                    normal: {
                        color: new echarts.graphic.LinearGradient(0, 0, 0, 1, [{
                            offset: 0,
                            color: 'rgba(0, 216, 135, 0.4)'
                        }, {
                            offset: 0.8,
                            color: 'rgba(0, 216, 135, 0.1)'
                        }], false),
                        shadowColor: 'rgba(0, 0, 0, 0.1)',
                    }
                },
                itemStyle: {
                    normal: {
                        color: '#00d887',
                        borderColor: 'rgba(221, 220, 107, .1)',
                        borderWidth: 12
                    }
                },
                data: [168.53, 259.32, 300.76, 200.67, 164.93, 130.59, 109.05, 118.07,126.2,143.17,154.41,158.69,150.91,130.43,132.6,156.43,160.02]

            },

        ]

    };

    // 使用刚指定的配置项和数据显示图表。
    myChart.setOption(option);
    window.addEventListener("resize", function () {
        myChart.resize();
    });
}
function echarts_5(data) {
    // 基于准备好的dom，初始化echarts实例
    var myChart = echarts.init(document.getElementById('echart5'));

    option = {
        //  backgroundColor: '#00265f',
        tooltip: {
            trigger: 'axis',
            axisPointer: {
                type: 'shadow'
            }
        },

        grid: {
            left: '0%',
            top: '10px',
            right: '0%',
            bottom: '2%',
            containLabel: true
        },
        xAxis: [{
            type: 'category',
            data: ['最大宽度', '最小宽度', '最大高度', '最小高度','宽度标准差', '高度标准差'],
            axisLine: {
                show: true,
                lineStyle: {
                    color: "rgba(255,255,255,.1)",
                    width: 1,
                    type: "solid"
                },
            },

            axisTick: {
                show: false,
            },
            axisLabel: {
                interval: 0,
                // rotate:50,
                show: true,
                splitNumber: 15,
                textStyle: {
                    color: "rgba(255,255,255,.6)",
                    fontSize: '12',
                },
            },
        }],
        yAxis: [{
            type: 'value',
            axisLabel: {
                //formatter: '{value} %'
                show: true,
                textStyle: {
                    color: "rgba(255,255,255,.6)",
                    fontSize: '12',
                },
            },
            axisTick: {
                show: false,
            },
            axisLine: {
                show: true,
                lineStyle: {
                    color: "rgba(255,255,255,.1	)",
                    width: 1,
                    type: "solid"
                },
            },
            splitLine: {
                lineStyle: {
                    color: "rgba(255,255,255,.1)",
                }
            }
        }],
        series: [{
            type: 'bar',
            //data: [2, 3, 3, 9, 15, 12, 6, 4],
            data: data,
            barWidth: '35%', //柱子宽度
            // barGap: 1, //柱子之间间距
            itemStyle: {
                normal: {
                    color: '#2f89cf',
                    opacity: 1,
                    barBorderRadius: 5,
                }
            }
        }
        ]
    };

    // 使用刚指定的配置项和数据显示图表。
    myChart.setOption(option);
    window.addEventListener("resize", function () {
        myChart.resize();
    });
}

function echarts_4() {
    // 基于准备好的dom，初始化echarts实例
    var myChart = echarts.init(document.getElementById('echart4'));

    option = {
        tooltip: {
            trigger: 'axis',
            axisPointer: {
                lineStyle: {
                    color: '#dddc6b'
                }
            }
        },
        legend: {
            top: '0%',
            data: ['2018年度', '2019年度'],
            textStyle: {
                color: 'rgba(255,255,255,.5)',
                fontSize: '12',
            }
        },
        grid: {
            left: '10',
            top: '30',
            right: '10',
            bottom: '10',
            containLabel: true
        },

        xAxis: [{
            type: 'category',
            boundaryGap: false,
            axisLabel: {
                textStyle: {
                    color: "rgba(255,255,255,.6)",
                    fontSize: 12,
                },
            },
            axisLine: {
                lineStyle: {
                    color: 'rgba(255,255,255,.2)'
                }

            },

            data: ['01', '02', '03', '04', '05', '06', '07', '08', '09', '11', '12']

        }, {

            axisPointer: { show: false },
            axisLine: { show: false },
            position: 'bottom',
            offset: 20,



        }],

        yAxis: [{
            type: 'value',
            axisTick: { show: false },
            axisLine: {
                lineStyle: {
                    color: 'rgba(255,255,255,.1)'
                }
            },
            axisLabel: {
                textStyle: {
                    color: "rgba(255,255,255,.6)",
                    fontSize: 12,
                },
            },

            splitLine: {
                lineStyle: {
                    color: 'rgba(255,255,255,.1)'
                }
            }
        }],
        series: [
            {
                name: '2018年度',
                type: 'line',
                smooth: true,
                symbol: 'circle',
                symbolSize: 5,
                showSymbol: false,
                lineStyle: {

                    normal: {
                        color: '#0184d5',
                        width: 2
                    }
                },
                areaStyle: {
                    normal: {
                        color: new echarts.graphic.LinearGradient(0, 0, 0, 1, [{
                            offset: 0,
                            color: 'rgba(1, 132, 213, 0.4)'
                        }, {
                            offset: 0.8,
                            color: 'rgba(1, 132, 213, 0.1)'
                        }], false),
                        shadowColor: 'rgba(0, 0, 0, 0.1)',
                    }
                },
                itemStyle: {
                    normal: {
                        color: '#0184d5',
                        borderColor: 'rgba(221, 220, 107, .1)',
                        borderWidth: 12
                    }
                },
                data: [3, 4, 3, 4, 3, 4, 3, 6, 2, 4,6,9]

            },
            {
                name: '2019年度',
                type: 'line',
                smooth: true,
                symbol: 'circle',
                symbolSize: 5,
                showSymbol: false,
                lineStyle: {

                    normal: {
                        color: '#00d887',
                        width: 2
                    }
                },
                areaStyle: {
                    normal: {
                        color: new echarts.graphic.LinearGradient(0, 0, 0, 1, [{
                            offset: 0,
                            color: 'rgba(0, 216, 135, 0.4)'
                        }, {
                            offset: 0.8,
                            color: 'rgba(0, 216, 135, 0.1)'
                        }], false),
                        shadowColor: 'rgba(0, 0, 0, 0.1)',
                    }
                },
                itemStyle: {
                    normal: {
                        color: '#00d887',
                        borderColor: 'rgba(221, 220, 107, .1)',
                        borderWidth: 12
                    }
                },
                data: [5, 3, 5, 6, 1, 5, 3, 5]

            },

        ]

    };

    // 使用刚指定的配置项和数据显示图表。
    myChart.setOption(option);
    window.addEventListener("resize", function () {
        myChart.resize();
    });
}


//等级比例
function echarts_6(data) {
    // 基于准备好的dom，初始化echarts实例
    var myChart = echarts.init(document.getElementById('echart6'));

    var dataStyle = {
        normal: {
            label: {
                show: false
            },
            labelLine: {
                show: false
            },
            //shadowBlur: 40,
            //shadowColor: 'rgba(40, 40, 40, 1)',
        }
    };
    var placeHolderStyle = {
        normal: {
            color: 'rgba(255,255,255,.05)',
            label: { show: false, },
            labelLine: { show: false }
        },
        emphasis: {
            color: 'rgba(0,0,0,0)'
        }
    };
    option = {    
        title: {
            text: '',
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
                name:'玫瑰花等级',
                type:'pie',
                radius : '55%',
                center: ['50%', '50%'],
                data:[
                    {value:data.A, name:'A'},
                    {value:data.B, name:'B'},
                    {value:data.C, name:'C'},
                ].sort(function (a, b) { return a.value - b.value; }),
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

    // 使用刚指定的配置项和数据显示图表。
    myChart.setOption(option);
    window.addEventListener("resize", function () {
        myChart.resize();
    });
}



function echarts_31(data) {
    // 基于准备好的dom，初始化echarts实例
    var myChart = echarts.init(document.getElementById('fb1'));
    option = {

        title: [{
            text: '宽度分布',
            left: 'center',
            textStyle: {
                color: '#fff',
                fontSize: '16'
            }

        }],
        tooltip: {
            trigger: 'item',
            formatter: "{a} <br/>{b}: {c} ({d}%)",
            position: function (p) {   //其中p为当前鼠标的位置
                return [p[0] + 10, p[1] - 10];
            }
        },
        legend: {

            top: '70%',
            itemWidth: 10,
            itemHeight: 10,
            data: ['30cm以下', '30至35', '35至40', '40至45', '45至50','50cm以上'],
            textStyle: {
                color: 'rgba(255,255,255,.5)',
                fontSize: '12',
            }
        },
        series: [
            {
                name: '宽度分布',
                type: 'pie',
                center: ['50%', '42%'],
                radius: ['40%', '60%'],
                color: ['#065aab', '#066eab', '#0682ab', '#0696ab', '#06a0ab', '#06b4ab', '#06c8ab', '#06dcab', '#06f0ab'],
                label: { show: false },
                labelLine: { show: false },
                data: [
                    { value: data.mini_30, name: '30cm以下' },
                    { value: data.s30_35, name: '30至35' },
                    { value: data.s35_40, name: '35至40' },
                    { value: data.s40_45, name: '40至45' },
                    { value: data.s45_50, name: '45至50' },
                    { value: data.s50_max, name: '50cm以上' }
                ]
            }
        ]
    };

    // 使用刚指定的配置项和数据显示图表。
    myChart.setOption(option);
    window.addEventListener("resize", function () {
        myChart.resize();
    });
}


function echarts_32(data) {
    // 基于准备好的dom，初始化echarts实例
    var myChart = echarts.init(document.getElementById('fb2'));
    option = {

        title: [{
            text: '高度分布',
            left: 'center',
            textStyle: {
                color: '#fff',
                fontSize: '16'
            }

        }],
        tooltip: {
            trigger: 'item',
            formatter: "{a} <br/>{b}: {c} ({d}%)",
            position: function (p) {   //其中p为当前鼠标的位置
                return [p[0] + 10, p[1] - 10];
            }
        },
        legend: {

            top: '70%',
            itemWidth: 10,
            itemHeight: 10,
            data: ['30cm以下', '30至35', '35至40', '40至45', '45至50', '50cm以上'],
            textStyle: {
                color: 'rgba(255,255,255,.5)',
                fontSize: '12',
            }
        },
        series: [
            {
                name: '高度分布',
                type: 'pie',
                center: ['50%', '42%'],
                radius: ['40%', '60%'],
                color: ['#065aab', '#066eab', '#0682ab', '#0696ab', '#06a0ab', '#06b4ab', '#06c8ab', '#06dcab', '#06f0ab'],
                label: { show: false },
                labelLine: { show: false },
                data: [
                    { value: data.mini_30, name: '30cm以下' },
                    { value: data.s30_35, name: '30至35' },
                    { value: data.s35_40, name: '35至40' },
                    { value: data.s40_45, name: '40至45' },
                    { value: data.s45_50, name: '45至50' },
                    { value: data.s50_max, name: '50cm以上' }
                ]
            }
        ]
    };

    // 使用刚指定的配置项和数据显示图表。
    myChart.setOption(option);
    window.addEventListener("resize", function () {
        myChart.resize();
    });
}
function echarts_33(data) {
    // 基于准备好的dom，初始化echarts实例
    var myChart = echarts.init(document.getElementById('fb3'));
    option = {
        title: [{
            text: '杆长分布',
            left: 'center',
            textStyle: {
                color: '#fff',
                fontSize: '16'
            }

        }],
        tooltip: {
            trigger: 'item',
            formatter: "{a} <br/>{b}: {c} ({d}%)",
            position: function (p) {   //其中p为当前鼠标的位置
                return [p[0] + 10, p[1] - 10];
            }
        },
        legend: {
            top: '70%',
            itemWidth: 10,
            itemHeight: 10,
            data: ['500px以下', '500至540', '540至580', '580至620', '620至660', '660px以上'],
            textStyle: {
                color: 'rgba(255,255,255,.5)',
                fontSize: '12',
            }
        },
        series: [
            {
                name: '杆长分布',
                type: 'pie',
                center: ['50%', '42%'],
                radius: ['40%', '60%'],
                color: ['#065aab', '#066eab', '#0682ab', '#0696ab', '#06a0ab', '#06b4ab', '#06c8ab', '#06dcab', '#06f0ab'],
                label: { show: false },
                labelLine: { show: false },
                data: [
                    { value: data.mini_500, name: '500px以下' },
                    { value: data.s500_540, name: '500至540' },
                    { value: data.s540_580, name: '540至580' },
                    { value: data.s580_620, name: '580至620' },
                    { value: data.s620_660, name: '620至660' },
                    { value: data.s660_max, name: '660px以上' }
                ]
            }
        ]
    };

    // 使用刚指定的配置项和数据显示图表。
    myChart.setOption(option);
    window.addEventListener("resize", function () {
        myChart.resize();
    });
}


















