package com.yhchdev.rosesorting.data;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.annotation.JsonAlias;
import com.yhchdev.rosesorting.entity.Rosedata;
import com.yhchdev.rosesorting.repository.RoseRepository;
import com.yhchdev.rosesorting.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class processData {

    @Autowired
    private RoseRepository roseRepository;

    @Autowired
    private UserRepository userRepository;



    public void analysisProData(String obj) {
        //jsonString ——> jsonObject
        JSONObject jo = JSON.parseObject(obj);

        // 获取16组基础数据
        JSONObject r1_data = jo.getJSONObject("r1_data");


        //新增top
        JSONObject top_data = jo.getJSONObject("top_data");
        JSONArray top_w = top_data.getJSONArray("w");
        JSONArray top_h = top_data.getJSONArray("h");

        //System.out.println(r1_data.getJSONArray("t").get(0));

        //整体
        JSONArray total =  r1_data.getJSONArray("t");
        //上半部分
        JSONArray up =  r1_data.getJSONArray("u");

        JSONArray bottom =  r1_data.getJSONArray("b");
        JSONArray height =  r1_data.getJSONArray("h");






        //获取重量
        double weight = jo.getDouble("rose_weight");



        //等级
        String grade = jo.getString("result");


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


        int topw_max = top_w.getIntValue(0);
        int topw_mean = top_w.getIntValue(1);
        int topw_median = top_w.getIntValue(2);
        int topw_std = top_w.getIntValue(3);


        int toph_max = top_h.getIntValue(0);
        int toph_mean = top_h.getIntValue(1);
        int toph_median = top_h.getIntValue(2);
        int toph_std = top_h.getIntValue(3);



        //杆长
        double stem_len = jo.getDouble("height1");
        double stem_len2 = jo.getDouble("height2");
        //height 1 和 height2 无法区分 哪个是上半部分 哪个下半部分
        // 一般情况 杆长都会超出第一个摄像头(长度固定为480),那么杆长就为 480+ 最小的那个值(前提)
        if(stem_len>stem_len2){
            stem_len = 480 + stem_len;
        }else {
            stem_len = 480 + stem_len2;
        }

        // 杆长等级
        int stem_grade = jo.getIntValue("grade");

        // 层数
        int plies = jo.getIntValue("plies");


        //插入数据
//        roseRepository.insertRestOne(total_max,total_mean,total_median,total_std,
//                up_max,up_mean,up_median,up_std,
//                btttom_max,btttom_mean,btttom_median,btttom_std,
//                height_max,height_mean,height_median,height_std,
//                topw_max,topw_mean,topw_median,topw_std,
//                toph_max,toph_mean,toph_median,toph_std,plies,
//                stem_len,stem_grade,weight,grade
//                );
    }
}
