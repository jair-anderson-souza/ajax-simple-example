/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.jass2125.ajax.example;

import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Anderson Souza
 */
//@WebServlet(urlPatterns = {"/retrieve"})
public class RetrieveEmployee extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//        LocalDate.now();
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");
        String param = req.getParameter("name");
        EmployeeDao dao = new EmployeeDao();
        Employee employee = dao.search(param);

        PrintWriter out = resp.getWriter();

        String value = new Gson().toJson(employee);
        out.print(value);

//        try (PrintWriter writer = resp.getWriter()) {
//            EmployeeDao dao = new EmployeeDao();
//            Employee employee = dao.search(req.getParameter("name"));
//            JsonElement element = gson.toJsonTree(employee);
//
//            if (employee.getName() == null) {
//                json.addProperty("success", false);
//            } else {
//                json.addProperty("success", true);
//            }
//            json.add("countryInfo", employee);
//            writer.println(json.toString());
//        }
    }

}
