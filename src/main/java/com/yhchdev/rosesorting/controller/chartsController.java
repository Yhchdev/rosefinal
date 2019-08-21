package com.yhchdev.rosesorting.controller;


import com.alibaba.fastjson.JSONObject;

import com.yhchdev.rosesorting.entity.Rosedata;
import com.yhchdev.rosesorting.repository.RoseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/charts/")
public class chartsController {
    @Autowired
    RoseRepository roseRepository;


    @RequestMapping("/dash/")
    public String dash(){

        //最近18朵
        List<Rosedata> rosedataList = roseRepository.QueryRecent();

         ArrayList<Double> toalmediandata = new ArrayList<Double>();
         ArrayList<Double> heightdata = new ArrayList<Double>();
         ArrayList<Double> toalstddata = new ArrayList<Double>();

        for(Rosedata rosedata:rosedataList){
            double toalmedian = rosedata.getTotalMedian();
            toalmediandata.add(toalmedian);
            double height = rosedata.getHeightMedian();
            heightdata.add(height);
            double toalstd = rosedata.getTotalStd();
            toalstddata.add(toalstd);

        }

        JSONObject jsonObj = new JSONObject();

        jsonObj.put("toalmediandata",toalmediandata);
        jsonObj.put("heightdata",heightdata);
        jsonObj.put("toalstddata",toalstddata);

        return jsonObj.toString();
    }

    //画图一 ： 属性平均值
    @RequestMapping("/median/")
    public String mean(){
        List<Rosedata> rosedataList = roseRepository.nativeQueryall();

        //直径
        int topwMedianCount = 0;
        //层数
        Integer pliesCount  = 0;

        double totalMedianCount = 0.0;
        double heightMedianCount = 0;
        double stem_lenCount = 0;
        double weightCount = 0;


        for(Rosedata rosedata:rosedataList ){
            topwMedianCount  += rosedata.getTopwMedian();
            pliesCount += rosedata.getPlies();
            totalMedianCount += rosedata.getTotalMedian();
            heightMedianCount += rosedata.getHeightMedian();
            stem_lenCount += rosedata.getStem_len();
            weightCount += rosedata.getWeight();
        }

        int count = rosedataList.size();
        int top = topwMedianCount / count;
        int plies = pliesCount / count;
        int total = (int) (totalMedianCount / count);
        int height = (int) (heightMedianCount / count);
        int stemlen = (int) (stem_lenCount / count);
        int weight = (int) (weightCount / count);

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("top",top);
        jsonObject.put("plies",plies);
        jsonObject.put("total",total);
        jsonObject.put("height",height);
        jsonObject.put("stemlen",stemlen);
        jsonObject.put("weight",weight);

        return jsonObject.toString();
    }


    //图五：最大值 最小值 标准差
    @RequestMapping("/maxmin/")
    public String maxAndmin(){

        List<Rosedata> rosedataList = roseRepository.nativeQueryall();

        double totalMaxCount = 0;
        double totalMeanCount  = 0;

        double heightMaxCount = 0.0;
        double heightMeanCount = 0.0;

        int topwMaxCount = 0;
        int topwMeanCount = 0;
        double totalStdCount = 0;
        double heightStdCount = 0;
        int topwStdCount = 0;


        for(Rosedata rosedata:rosedataList ){
            totalMaxCount  += rosedata.getTotalMax();
            totalMeanCount += rosedata.getTotalMean();
            heightMaxCount += rosedata.getHeightMax();
            heightMeanCount += rosedata.getHeightMean();
            topwMaxCount += rosedata.getTopwMax();
            topwMeanCount += rosedata.getTopwMean();
            totalStdCount += rosedata.getTotalStd();
            heightStdCount += rosedata.getHeightStd();
            topwStdCount += rosedata.getTopwStd();
        }

        int count = rosedataList.size();
        int totalMax = topwMaxCount / count;
        double totalMean = totalMeanCount / count;
        double heightMax = heightMaxCount / count;
        double heightMean = heightMeanCount / count;
        double topwMax = topwMaxCount / count;
        double topwMean = topwMeanCount / count;
        double totalStd = totalStdCount / count;
        double heightStd = heightStdCount / count;
        double topwStd = topwStdCount / count;


        JSONObject jsonObject = new JSONObject();
        jsonObject.put("totalMax",totalMax);
        jsonObject.put("totalMean",totalMean);
        jsonObject.put("heightMax",heightMax);
        jsonObject.put("heightMean",heightMean);
        jsonObject.put("topwMax",topwMax);
        jsonObject.put("topwMean",topwMean);
        jsonObject.put("totalStd",totalStd);
        jsonObject.put("heightStd", heightStd);
        jsonObject.put("topwStd",topwStd);

        return jsonObject.toString();
    }


    //高度分布
    @RequestMapping("/heightdis/")
    public String heightdis(){
        List<Rosedata> rosedataList = roseRepository.nativeQueryall();
        int mini_30 = 0;
        int s30_35 = 0;
        int s35_40 = 0;
        int s40_45 = 0;
        int s45_50 = 0;
        int s50_max = 0;
        for (Rosedata rosedata: rosedataList){
            double height = rosedata.getHeightMedian();
            if(height<30){
                mini_30 ++;
            } else if(30<=height && height<35){
                s30_35 ++;
            }else if(height>=35 && height<40){
                s35_40 ++;
            }else if(height>40 && height<45){
                s40_45 ++;
            } else if(height>=45 && height<50){
                s45_50 ++;
            }else {
                s50_max ++;
            }
        }

        JSONObject stemlenCount = new JSONObject();
        stemlenCount.put("mini_30",mini_30);
        stemlenCount.put("s30_35", s30_35);
        stemlenCount.put("s35_40",s35_40);
        stemlenCount.put("s40_45",s40_45);
        stemlenCount.put("s45_50",s45_50);
        stemlenCount.put("s50_max",s50_max);

        return stemlenCount.toString();
    }


    //宽度分布
    @RequestMapping("/widthdis/")
    public String widthdis(){
        List<Rosedata> rosedataList = roseRepository.nativeQueryall();
        int mini_30 = 0;
        int s30_35 = 0;
        int s35_40 = 0;
        int s40_45 = 0;
        int s45_50 = 0;
        int s50_max = 0;
        for (Rosedata rosedata: rosedataList){
            double width = rosedata.getTotalMedian();
            if(width<30){
                mini_30 ++;
            } else if(30<= width && width<35){
                s30_35 ++;
            }else if(width>=35 && width<40){
                s35_40 ++;
            }else if(width>40 && width<45){
                s40_45 ++;
            } else if(width>=45 && width<50){
                s45_50 ++;
            }else {
                s50_max ++;
            }
        }

        JSONObject stemlenCount = new JSONObject();
        stemlenCount.put("mini_30",mini_30);
        stemlenCount.put("s30_35", s30_35);
        stemlenCount.put("s35_40",s35_40);
        stemlenCount.put("s40_45",s40_45);
        stemlenCount.put("s45_50",s45_50);
        stemlenCount.put("s50_max",s50_max);

        return stemlenCount.toString();
    }


    //图五-3 杆长分布

    @RequestMapping("/stemlen/")
    public String stemlen(){
        List<Rosedata> rosedataList = roseRepository.nativeQueryall();
        int mini_500 = 0;
        int s500_540 = 0;
        int s540_580 = 0;
        int s580_620 = 0;
        int s620_660 = 0;
        int s660_max = 0;
        for (Rosedata rosedata: rosedataList){
            double len = rosedata.getStem_len();
            if(len<500){
                mini_500 ++;
            } else if(500<=len && len<540){
                s500_540 ++;
            }else if(len>=540 && len<580){
                s540_580 ++;
            }else if(len>=580 && len<620){
                s580_620 ++;
            } else if(len>=620 && len<660){
                s620_660 ++;
            }else {
                s660_max ++;
            }
        }

        JSONObject stemlenCount = new JSONObject();
        stemlenCount.put("mini_500",mini_500);
        stemlenCount.put("s500_540", s500_540);
        stemlenCount.put("s540_580",s540_580);
        stemlenCount.put("s580_620",s580_620);
        stemlenCount.put("s620_660",s620_660);
        stemlenCount.put("s660_max",s660_max);

        return stemlenCount.toString();
    }





    //图六 等级
    @RequestMapping("/grade/")
    public String grade(){
        List<Rosedata> rosedataList = roseRepository.nativeQueryall();
        int num_A = 0;
        int num_B = 0;
        int num_C = 0;
        for (Rosedata rosedata: rosedataList){
            String grade = rosedata.getGrade();
            if(grade.length()>0){
                if(grade.equals("A")){
                    num_A ++;
                }
                if(grade.equals("B")){
                    num_B ++;
                }
                if(grade.equals("C")){
                    num_C ++;
                }
            }
        }

        JSONObject gradeCount = new JSONObject();
        gradeCount.put("A",num_A);
        gradeCount.put("B", num_B);
        gradeCount.put("C",num_C);
        return gradeCount.toString();
    }
}
