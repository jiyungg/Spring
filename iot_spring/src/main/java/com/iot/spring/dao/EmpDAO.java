package com.iot.spring.dao;

import java.util.List;

import com.iot.spring.vo.Emp;

public interface EmpDAO {

   public List<Emp> selectEmpList();   
   public Emp selectEmp(Emp emp);
   public int insertEmp(Emp emp);
   public int updateEmp(Emp emp);
   public int deleteEmp(Emp emp);
   
}