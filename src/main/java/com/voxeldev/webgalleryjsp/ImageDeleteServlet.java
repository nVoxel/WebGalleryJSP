package com.voxeldev.webgalleryjsp;

import com.voxeldev.webgalleryjsp.dao.ImagesRepositoryFileImpl;
import com.voxeldev.webgalleryjsp.dao.ImagesRepositorySqlImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/images/delete")
public class ImageDeleteServlet extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("images", ImagesRepositoryFileImpl.getInstance().getImages());
        req.getRequestDispatcher("/delete-image.jsp").forward(req, resp);
    }
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ImagesRepositoryFileImpl.getInstance().deleteImage(req.getParameter("imageUrl"));
        resp.sendRedirect("/images");
    }
}
