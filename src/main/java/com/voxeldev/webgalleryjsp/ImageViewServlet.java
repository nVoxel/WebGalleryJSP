package com.voxeldev.webgalleryjsp;

import com.voxeldev.webgalleryjsp.dao.ImagesRepositorySqlImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/images")
public class ImageViewServlet extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("images", ImagesRepositorySqlImpl.getInstance().getImages());
        req.getRequestDispatcher("/images.jsp").forward(req, resp);
    }
}
