// 从服务端获取数据

$(function () {
  var echart1_mean
  $.get("http://localhost:5000/rose/charts/mean/", function (data, status) {
    if (status == "success") {
      echart1_mean = data;
    }else{
      console.log("获取显示数据失效")
    }
  });
});