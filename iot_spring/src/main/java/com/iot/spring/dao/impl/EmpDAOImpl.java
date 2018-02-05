package com.iot.spring.dao.impl;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.iot.spring.dao.EmpDAO;
import com.iot.spring.vo.Emp;

@Repository
public class EmpDAOImpl implements EmpDAO {
   @Autowired
   private SqlSessionFactory ssf;

   @Override
   public List<Emp> selectEmpList() {
      SqlSession ss = ssf.openSession();
      List<Emp> empList = ss.selectList("emp.selectEmp");
      ss.close();
      return empList;
   }

   @Override
   public Emp selectEmp(Emp emp) {
      String findSd="batis1";
      SqlSession ss = ssf.openSession();
      Emp ep = ss.selectOne("find",findSd);
      if(ep==null) {
         System.out.println("검색된 회원이 없어요!");
      }else {
         System.out.println("No : " + emp.getEmpNo());
         System.out.println("Name : " + emp.getEmpName());
         System.out.println("Salary : " + emp.getEmpSal());
      }
      HashMap<String, Object> map = ss.selectOne("orm.mybatis.memberMapper.getInfo", "batis1");
      
      String empNo = (String)map.get("No");
      String empName = (String)map.get("Name");
       String empSal = (String)map.get("Salary");
      
      System.out.println("No" + empNo);
      System.out.println("Name" + empName);
      System.out.println("Salary" + empSal);
      ss.close();
      return ep;
      
   }

   

   @Override
   public int insertEmp(Emp emp) {
      int id = 0; 
      SqlSession ss = ssf.openSession(); 
      try { 
         id = ss.insert("emp.insert", emp); 
      } finally { 
         ss.commit(); 
         ss.close(); 
      } System.out.println("insert("+emp+") --> "+emp.getEmpNo()); 
      System.out.println(emp.getEmpName()); 
      System.out.println(emp.getEmpSal());
      return id;
   }

   @Override
   public int updateEmp(Emp emp) {
      int id = 0; 
      SqlSession ss = ssf.openSession(); 
      try { 
         id = ss.update("emp.update", emp); 
      } finally { 
         ss.commit();
         ss.close(); 
      }
      return id;
   }

   @Override
   public int deleteEmp(Emp emp) {
      SqlSession ss = ssf.openSession();
      int id = 0; 
      try { 
         id = ss.delete("emp.delete", emp);
      } finally {
         ss.commit();
         ss.close(); 
      }
      return id;
   }
}