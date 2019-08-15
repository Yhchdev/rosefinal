package com.yhchdev.rosesorting.data;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.yhchdev.rosesorting.entity.Rosedata;
import com.yhchdev.rosesorting.repository.RoseRepository;
import com.yhchdev.rosesorting.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class processData {

    @Autowired
    private RoseRepository roseRepository;

    @Autowired
    private UserRepository userRepository;



    public void analysisProData(String obj) {
        Rosedata rosedata = null;

        //jsonString ——> jsonObject
        JSONObject jo = JSON.parseObject(obj);

        //获取Json里面的data 数组
        JSONArray jsarr = jo.getJSONArray("data");
        JSONArray total = jsarr.getJSONArray(0);
        JSONArray up = jsarr.getJSONArray(1);
        JSONArray bottom = jsarr.getJSONArray(2);
        JSONArray height = jsarr.getJSONArray(3);

        //获取重量
        double weight = jo.getDouble("weight");

        //获取品级
        String grade = jo.getString("grade");

        //整体
        double total_max = total.getDouble(0);
        double total_mean = total.getDouble(1);
        double total_median = total.getDouble(2);
        double total_std = total.getDouble(3);

        //上半部分
        double up_max = up.getDouble(0);
        double up_mean = up.getDouble(1);
        double up_median = up.getDouble(2);
        double up_std = up.getDouble(3);


        //下半部分
        double btttom_max = bottom.getDouble(0);
        double btttom_mean = bottom.getDouble(1);
        double btttom_median = bottom.getDouble(2);
        double btttom_std = bottom.getDouble(3);


        //高度
        double height_max = height.getDouble(0);
        double height_mean = height.getDouble(1);
        // median 中位数
        double height_median = height.getDouble(2);
        double height_std = height.getDouble(3);


        //插入数据
        roseRepository.insertRestOne(total_max,total_mean,total_median,total_std,
                up_max,up_mean,up_median,up_std,
                btttom_max,btttom_mean,btttom_median,btttom_std,
                height_max,height_mean,height_median,height_std,
                weight,grade
                );
    }
}
