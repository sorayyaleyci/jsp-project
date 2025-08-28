package org.sorayya.project.controller;

import org.sorayya.project.common.ExceptionWrapper;
import org.sorayya.project.entity.Person;
import org.sorayya.project.service.PersonService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/person/update")
public class PersonUpdate extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            PersonService.update(new Person()
                    .setId(Long.parseLong(req.getParameter("id")))
                    .setName(req.getParameter("name"))
                    .setFamily(req.getParameter("family"))
                    .setSalary(Long.parseLong(req.getParameter("salary"))));
            resp.sendRedirect("/person/findAll");
        } catch (Exception e) {
            ExceptionWrapper.handleError(e, req, resp);
        }
    }
}
