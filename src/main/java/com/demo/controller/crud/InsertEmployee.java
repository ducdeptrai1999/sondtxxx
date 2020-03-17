package com.demo.controller.crud;

import com.demo.dao.EmployeeDao;
import com.demo.dao.impl.EmployeeDaoImpl;
import com.demo.model.Employee;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/insert-employee")
public class InsertEmployee extends HttpServlet {
    EmployeeDao employeeDao;

    public InsertEmployee() {
        this.employeeDao = new EmployeeDaoImpl();
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String address = req.getParameter("address");
        int phone = Integer.parseInt(req.getParameter("phone"));
        Employee employee = new Employee(name,email,address,phone);
        employeeDao.insert(employee);
        resp.sendRedirect("/index");
    }

}
