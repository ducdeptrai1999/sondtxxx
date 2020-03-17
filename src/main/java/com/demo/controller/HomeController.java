package com.demo.controller;

import com.demo.dao.EmployeeDao;
import com.demo.dao.impl.EmployeeDaoImpl;
import com.demo.model.Employee;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/index")
public class HomeController extends HttpServlet {
    EmployeeDao employeeDao;

    public HomeController() {
        this.employeeDao = new EmployeeDaoImpl();
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Employee> employeeList = employeeDao.findAll();
        req.setAttribute("result", employeeList);

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("view/home.jsp");
        requestDispatcher.forward(req,resp);
    }

}
