package com.demo.dao.impl;

import com.demo.dao.EmployeeDao;
import com.demo.model.Employee;
import com.demo.util.MySqlConnectionUtil;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDaoImpl implements EmployeeDao {
    @Override
    public Employee insert(Employee employee) {
        try {
            new MySqlConnectionUtil().executableSql("insert into user(name, email, address, phone) values ('"+employee.getName()+"','"+employee.getEmail()+"','"+employee.getAddress()+"',"+employee.getPhone()+");");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return employee;
    }

    @Override
    public void update(Employee employee) {
        try {
            new MySqlConnectionUtil().executableSql("update user set name='"+employee.getName()+"', email= '"+employee.getEmail()+"', address = '"+employee.getAddress()+"', phone = "+employee.getPhone()+" where id= "+employee.getId()+"");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        try {
            new MySqlConnectionUtil().executableSql("delete from user where id= '"+id+"';");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Employee> findAll() {
        List<Employee> employeeList = new ArrayList<>();
        ResultSet resultSet  = null;
        try {
            resultSet = new MySqlConnectionUtil().selectData("select * from user");
            while (resultSet.next()){
                Employee employee = new Employee();
                employee.setId(resultSet.getInt(1));
                employee.setName(resultSet.getString(2));
                employee.setEmail(resultSet.getString(3));
                employee.setAddress(resultSet.getString(4));
                employee.setPhone(resultSet.getInt(5));
                employeeList.add(employee);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return employeeList;
    }

}
