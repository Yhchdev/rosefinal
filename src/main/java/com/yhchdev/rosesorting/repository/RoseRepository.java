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



    // insert 插入数据
    @Query(value = "INSERT INTO rose (total_max,total_mean,total_median,total_std," +
            "up_max,up_mean,up_median,up_std," +
            "bottom_max,bottom_mean,bottom_median,bottom_std," +
            "height_max,height_mean,height_median,height_std,weight,grade)" +
            "VALUES" +
            "(?1,?2,?3,?4," +
            "?5,?6,?7,?8," +
            "?9,?10,?11,?12," +
            "?13,?14,?15,?16,?17,?18)", nativeQuery = true)
    @Modifying
    @Transactional
    //JPA 执行update/delete query 需要加上事务
    int insertRestOne(double total_max,double total_mean,double total_median,double total_std,
                      double up_max,double up_mean,double up_median,double up_std,
                      double bottom_max,double bottom_mean,double bottom_median,double bottom_std,
                      double height_max,double height_mean,double height_median,double height_std,
                      double weight,String grade
                      );
}
