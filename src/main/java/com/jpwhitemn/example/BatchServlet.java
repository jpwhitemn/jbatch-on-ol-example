package com.jpwhitemn.example;

import java.io.IOException;

import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/job/*")
public class BatchServlet extends HttpServlet {

    private static final long serialVersionUID = 2L;

    @Inject
    BatchControllerBean controllerBean;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if ("/job/1".equals(req.getRequestURI())) {
            System.out.println("Directing to controller Job #1");
            controllerBean.startJob1();
        } else if ("/job/2".equals(req.getRequestURI())) {
            System.out.println("Directing to controller Job #2");
            controllerBean.startJob2();
        } else if ("/job/3".equals(req.getRequestURI())) {
            System.out.println(controllerBean.status());
        } else {
            System.out.println("Unknown job request number:" + req.getRequestURI());
        }
        resp.sendRedirect("/");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
