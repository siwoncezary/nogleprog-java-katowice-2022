package pl.nobleprog.katowice.part5servlet.servlet;

import lombok.extern.log4j.Log4j2;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Log4j2
public class HomeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("Path Info " + req.getPathInfo());
        log.info("Servlet path " + req.getServletPath());
        log.info("Path translated " + req.getPathTranslated());
        log.info("Path uri " + req.getRequestURI());
        log.info("Path uri " + req.getRequestURI());
        resp.getWriter().println("Dupa " + req.getRequestURI());
        //getServletContext().getRequestDispatcher("./index").forward(req, resp);
    }
}
