package org.sorayya.project.common;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class ExceptionWrapper {

    public static void handleError(Exception e, HttpServletRequest req, HttpServletResponse resp) {
    e.printStackTrace();
    if(e instanceof NumberFormatException)
        req.setAttribute("exception","Number Error!");
    else if(e instanceof  NullPointerException)
        req.setAttribute("exception","Infrastructure Error");
    else if(e instanceof SQLException)
        req.setAttribute("exception", "SQL Error!");
    else
        req.setAttribute("exception","Unknown Error!");

        try{
            req.getRequestDispatcher("/custom-error.jsp").forward(req,resp);
        } catch (ServletException | IOException ex) {
            throw new RuntimeException(ex);
        }
    }

}
