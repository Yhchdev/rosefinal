// 存放时间
var mmtime = [];
//存放高度 标准差
var hestd = [];

var websocket = null;
//var websocketData = null;
//判断当前浏览器是否支持WebSocket
if ('WebSocket' in window) {
    //建立连接，这里的/websocket ，是Servlet中注解中的那个值
    websocket = new WebSocket("ws://localhost:8080/ws");
}
else {
    alert('当前浏览器无法使用核心功能(不支持WebSocket),请使用chrome浏览器');
}
//连接发生错误的回调方法
websocket.onerror = function () {
    //发生连接错误的处理代码
};
//连接成功建立的回调方法
websocket.onopen = function () {
    //连接成功的处理代码
    console.log("连接成功")
}


//接收到消息的回调方法
websocket.onmessage = function (event) {
    //websocketData = event.data
    //console.log(event.data)
    analysisData(event.data)

}
//连接关闭的回调方法
websocket.onclose = function () {
    //连接关闭时的处理代码
}
//监听窗口关闭事件，当窗口关闭时，主动去关闭WebSocket连接，防止连接还没断开就关闭窗口，server端会抛异常。
window.onbeforeunload = function () {
    closeWebSocket();
}
//关闭WebSocket连接
function closeWebSocket() {
    websocket.close();
}


//websocket收到消息 调用此方法
//对通过websocket发送过来的数据进行解析
function analysisData(data) {
    var rose = JSON.parse(data);
    //玫瑰花数据


    //rosesize = obj.data;
    //console.log(obj);


    //整体
    total = rose.r1_data.t;
    total_max = total[0];
    total_mean = total[1];
    total_median = total[2];
    total_std = total[3];


    //上半部分
    up = rose.r1_data.u;
    up_max = up[0];
    up_mean = up[1];
    up_median = up[2];
    up_std = up[3];
    //console.log(up)


    //下半部分
    bottom = rose.r1_data.b;
    bottom_max = bottom[0];
    bottom_mean = bottom[1];
    bottom_median = bottom[2];
    bottom_std = bottom[3];


    //高度
    height = rose.r1_data.h;
    height_max = height[0];
    height_mean = height[1];
    height_median = height[2];
    height_std = height[3];


    //玫瑰花图片
    //pic_base64 = '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';
    var pic_base64 = rose.result_img;
    var pic_src = 'data:image/png;base64,' + pic_base64;


    //时间戳
    var timestamp = new Date().getTime();
    time = new Date(timestamp).Format('yy-MM-dd hh:mm:ss'); //"2018-11-15 17:40:00"
    iwantime = time.split(" ")[1];
    timeh = iwantime.split(":")[0];
    timem = iwantime.split(":")[1];
    times = iwantime.split(":")[2];

    showtime = timeh + ':' + timem + '分' + times + '秒';
    // console.log(showtime);


    //玫瑰花质量(g)
    rosequality = rose.rose_weight;

    console.log(rosequality);


    //实时画图
    plot(total_max, total_mean, total_median, total_std, rosequality, pic_src, height_max, height_mean, height_median, height_std, showtime);

}


//实时画图
function plot(total_max,total_mean,total_median,total_std,rosequality,pic_src,height_max,height_mean,height_median,height_std,showtime) {


    /**
     * 图4
     * 玫瑰花的质量
     */
    var qechart = echarts.init(document.getElementById('quality'));
    qoption = {
        tooltip : {
            formatter: "{a} <br/>{b} : {c}%"
        },
        toolbox: {
            feature: {
                restore: {},
                saveAsImage: {}
            }
        },
        series: [
            {
                name: '玫瑰花质量',
                type: 'gauge',
                detail: {formatter:'质量'},
                data: [{value: 50, name: 'g(克)'}]
            }
        ]
    };
    qoption.series[0].data[0].value = rosequality;
    qechart.setOption(qoption);


    /**
     * 图1
     * 设置玫瑰花的图片路径
     *
     */

    document.getElementById('imgbs')
        .setAttribute('src',pic_src);


    /**
     * 图3 玫瑰花的宽度数据
     */
    var total = echarts.init(document.getElementById('total'))
    goption = {
        backgroundColor:'#000',
        tooltip: {},
        grid:{
            top:'5%',
        },
        legend: {
            data:['玫瑰花尺寸'],
            right:'10%',
            top:'5%',
            textStyle:{
                color:'#fff',
                fontSize:24,
            }
        },
        xAxis: {
            data: ["最宽","平均宽度","宽度中位数","标准差"],       //横坐标
            axisTick:{
                show:false,
            },
            axisLabel:{
                interval: 0,
                rotate:25,
                textStyle: {
                    color:'#fff',
                    fontSize:24,
                }
            },
            axisLine: {
                lineStyle: {
                    type: 'solid',
                    color:'#fff',
                    width:'1  ',                                                //坐标线的宽度

                }
            },
        },
        yAxis: {
            splitLine: {
                show: true,
                lineStyle:{
                    color: '#40A1EA',                                         //网格横线颜色
                    width: 1,
                    type: 'solid'
                }
            },
            axisLabel: {
                textStyle: {
                    color: '#fff',
                    fontSize:24,//坐标值得具体的颜色
                }
            },
            axisLine: {
                show:false,
            },
        },
        series: [{
            name: '玫瑰花高度',
            type: 'bar',
            barWidth:70,
            data: [total_max,total_mean,total_median,total_std],        //数据
            itemStyle: {
                normal: {
                    color: new echarts.graphic.LinearGradient(
                        0, 0, 0, 1,
                        [
                            {offset: 0, color: '#06B5D7'},                   //柱图渐变色
                            {offset: 0.5, color: '#44C0C1'},                 //柱图渐变色
                            {offset: 1, color: '#71C8B1'},                   //柱图渐变色
                        ]
                    )
                },
                emphasis: {
                    color: new echarts.graphic.LinearGradient(
                        0, 0, 0, 1,
                        [
                            {offset: 0, color: '#71C8B1'},                  //柱图高亮渐变色
                            {offset: 0.7, color: '#44C0C1'},                //柱图高亮渐变色
                            {offset: 1, color: '#06B5D7'}                   //柱图高亮渐变色
                        ]
                    )
                }
            },
        }]
    };
    total.setOption(goption);




    /**
     * 图2 数据 时间 ——高度标准差
     */

    //往栈中添加数据
    //加入已经处理好的时间
    mmtime.push(showtime);
    //加入 高度的标准差
    hestd.push(height_std);
    //如果栈中元素超过10个则每次移除最后一个
    if(mmtime.length>10){
        mmtime.shift();
        hestd.shift();
    }

    var heightstd = echarts.init(document.getElementById('heightstd'))
    hstdoption = {
        xAxis: {
            type: 'category',
            boundaryGap: false,
            data: mmtime
        },
        yAxis: {
            type: 'value'
        },
        series: [{
            data: hestd,
            type: 'line',
            areaStyle: {}
        }]
    };
    heightstd.setOption(hstdoption);



}

//时间戳转时间函数
Date.prototype.Format = function (fmt) {
    var o = {
        "M+": this.getMonth() + 1, // 月份
        "d+": this.getDate(), // 日
        "h+": this.getHours(), // 小时
        "m+": this.getMinutes(), // 分
        "s+": this.getSeconds(), // 秒
        "q+": Math.floor((this.getMonth() + 3) / 3), // 季度
        "S": this.getMilliseconds() // 毫秒
    };
    if (/(y+)/.test(fmt))
        fmt = fmt.replace(RegExp.$1, (this.getFullYear() + ""));
    for (var k in o)
        if (new RegExp("(" + k + ")").test(fmt)) fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
    return fmt;
}