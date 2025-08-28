package org.sorayya.project.controller;

import org.sorayya.project.common.ExceptionWrapper;
import org.sorayya.project.service.PersonService;

import javax.servlet.ServletException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/person/findAll")
public class PersonFindAll extends HttpServlet {
    @Override
    public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        try {
            req.setAttribute("personList", PersonService.findAll());
            req.getRequestDispatcher("/person.jsp").forward(req,res);
        } catch (Exception e) {
            ExceptionWrapper.handleError(e,req,res);
        }
    }
}
