package com.yhchdev.rosesorting.repository;

import com.yhchdev.rosesorting.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {


    //查询所有数据
    @Query(value = "SELECT * FROM employee ", nativeQuery = true)
    @Modifying
    @Transactional
    List<Employee> Queryallemps();
}
