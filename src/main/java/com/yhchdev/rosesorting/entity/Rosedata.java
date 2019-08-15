package com.yhchdev.rosesorting.entity;


import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;

@Entity
@Table(name = "rose")
public class Rosedata {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    //整体
    @Column(name = "total_max")
    private double totalMax;

    @Column(name = "total_mean")
    private double totalMean;

    @Column(name = "total_median")
    private double totalMedian;

    @Column(name = "total_std")
    private double totalStd;


    //上半部分最宽
    @Column(name = "up_max")
    private double upMax;

    //上半部分 平均值
    @Column(name = "up_mean")
    private double upMean;

    //上半部分 中位数
    @Column(name = "up_median")
    private double upMedian;

    //上半部分 标准差
    @Column(name = "up_std")
    private double upStd;

    //下半部分
    @Column(name = "bottom_max")
    private double bottomMax;
    @Column(name = "bottom_mean")
    private double bottomMean;
    @Column(name = "bottom_median")
    private double bottomMedian;
    @Column(name = "bottom_std")
    private double bottomStd;


    //高度 Height
    @Column(name = "height_max")
    private double heightMax;

    @Column(name = "height_mean")
    private double heightMean;

    @Column(name = "height_median")
    private double heightMedian;

    @Column(name = "height_std")
    private double heightStd;


    //信息入库的时间
    @CreatedDate
    private Long createTime;

    //质量
    @Column
    private double weight;


    //等级 grade
    @Column
    private String grade;

    @Column
    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public double getUpMax() {
        return upMax;
    }

    public void setUpMax(double upMax) {
        this.upMax = upMax;
    }

    public double getUpMean() {
        return upMean;
    }

    public void setUpMean(double upMean) {
        this.upMean = upMean;
    }

    public double getUpMedian() {
        return upMedian;
    }

    public void setUpMedian(double upMedian) {
        this.upMedian = upMedian;
    }

    public double getUpStd() {
        return upStd;
    }

    public void setUpStd(double upStd) {
        this.upStd = upStd;
    }

    public double getBottomMax() {
        return bottomMax;
    }

    public void setBottomMax(double bottomMax) {
        this.bottomMax = bottomMax;
    }

    public double getBottomMean() {
        return bottomMean;
    }

    public void setBottomMean(double bottomMean) {
        this.bottomMean = bottomMean;
    }

    public double getBottomMedian() {
        return bottomMedian;
    }

    public void setBottomMedian(double bottomMedian) {
        this.bottomMedian = bottomMedian;
    }

    public double getBottomStd() {
        return bottomStd;
    }

    public void setBottomStd(double bottomStd) {
        this.bottomStd = bottomStd;
    }

    public double getHeightMax() {
        return heightMax;
    }

    public void setHeightMax(double heightMax) {
        this.heightMax = heightMax;
    }

    public double getHeightMean() {
        return heightMean;
    }

    public void setHeightMean(double heightMean) {
        this.heightMean = heightMean;
    }

    public double getHeightMedian() {
        return heightMedian;
    }

    public void setHeightMedian(double heightMedian) {
        this.heightMedian = heightMedian;
    }

    public double getHeightStd() {
        return heightStd;
    }

    public void setHeightStd(double heightStd) {
        this.heightStd = heightStd;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public double getTotalMax() {
        return totalMax;
    }

    public void setTotalMax(double totalMax) {
        this.totalMax = totalMax;
    }

    public double getTotalMean() {
        return totalMean;
    }

    public void setTotalMean(double totalMean) {
        this.totalMean = totalMean;
    }

    public double getTotalMedian() {
        return totalMedian;
    }

    public void setTotalMedian(double totalMedian) {
        this.totalMedian = totalMedian;
    }

    public double getTotalStd() {
        return totalStd;
    }

    public void setTotalStd(double totalStd) {
        this.totalStd = totalStd;
    }
}
