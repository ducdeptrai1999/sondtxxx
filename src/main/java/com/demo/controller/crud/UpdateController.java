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

@WebServlet("/update-employee")
public class UpdateController extends HttpServlet {
    EmployeeDao employeeDao;

    public UpdateController() {
        this.employeeDao = new EmployeeDaoImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        employeeDao.delete(Integer.parseInt(id));
        resp.sendRedirect("/index");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String address = req.getParameter("address");
        int phone = Integer.parseInt(req.getParameter("phone"));
        Employee employee = new Employee(id,name,email,address,phone);
        employeeDao.update(employee);
        resp.sendRedirect("/index");
    }
}
