package com.voxeldev.webgalleryjsp;

import com.voxeldev.webgalleryjsp.dao.ImagesRepositorySqlImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/images/add")
public class ImageAddServlet extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/add-image.jsp").forward(req, resp);
    }
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ImagesRepositorySqlImpl.getInstance().addImage(req.getParameter("imageUrl"));
        resp.sendRedirect("/images");
    }
}
