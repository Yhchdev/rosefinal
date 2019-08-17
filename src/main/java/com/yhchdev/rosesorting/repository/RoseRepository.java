package com.yhchdev.rosesorting.repository;

import com.yhchdev.rosesorting.entity.Rosedata;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


public interface RoseRepository extends JpaRepository<Rosedata, Integer> {


    //查询所有数据
    @Query(value = "SELECT * FROM rose ", nativeQuery = true)
    @Modifying
    @Transactional
    List<Rosedata> nativeQueryall();

    //查询等级比例
//    @Query(value = "select count (*) from rose",nativeQuery = true)
//    @Modifying
//    @Transactional
//    int querya();



    // insert 插入数据
    @Query(value = "INSERT INTO rose (" +
            "total_max,total_mean,total_median,total_std," +
            "up_max,up_mean,up_median,up_std," +
            "bottom_max,bottom_mean,bottom_median,bottom_std," +
            "height_max,height_mean,height_median,height_std," +
            "topw_max,topw_mean,topw_median,topw_std,"+
            "toph_max,toph_mean,toph_median,toph_std,plies,"+
            "stem_len,stem_grade,weight,grade)" +
            "VALUES" +
            "(?1,?2,?3,?4," +
            "?5,?6,?7,?8," +
            "?9,?10,?11,?12," +
            "?13,?14,?15,?16," +
            "?17,?18,?19,?20,"+
            "?21,?22,?23,?24,?25,"+
            "?26,?27,?28,?29)", nativeQuery = true)
    @Modifying
    @Transactional
    //JPA 执行update/delete query 需要加上事务
    int insertRestOne(double total_max,double total_mean,double total_median,double total_std,
                      double up_max,double up_mean,double up_median,double up_std,
                      double bottom_max,double bottom_mean,double bottom_median,double bottom_std,
                      double height_max,double height_mean,double height_median,double height_std,
                      int topw_max,int topw_mean,int topw_median,int topw_std,
                      int toph_max,int toph_mean,int toph_median,int toph_std,int plies,
                      double stem_len,int stem_grade,double weight,String grade
                      );
}
