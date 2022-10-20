package com.voxeldev.webgalleryjsp.dao;

import com.voxeldev.webgalleryjsp.models.Image;

import java.io.FileReader;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ImagesRepositorySqlImpl implements ImagesRepository {
    
    private static final String DATABASE_MASTER_USER = "postgres";
    private static final String DATABASE_MASTER_PASSWORD_PATH = "C:\\Program Files\\PostgreSQL\\14\\master.txt";
    private static String databaseMasterPassword;
    
    private static ImagesRepositorySqlImpl imagesRepository;
    
    private List<Image> images = null;
    
    public static ImagesRepositorySqlImpl getInstance() {
        if (imagesRepository == null) {
            imagesRepository = new ImagesRepositorySqlImpl();
            
            try {
                FileReader fileReader = new FileReader(DATABASE_MASTER_PASSWORD_PATH);
                databaseMasterPassword = new Scanner(fileReader).nextLine();
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
        return imagesRepository;
    }
    
    
    
    public List<Image> getImages() {
        if (images == null) {
            images = new ArrayList<>();
            loadImages();
        }
        
        return images;
    }
    
    private void loadImages() {
        try {
            Connection connection = getDatabaseConnection();
            
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * from web.\"WebGallery\"");
            
            while (resultSet.next()) {
                images.add(
                        new Image(
                                resultSet.getInt("id"),
                                resultSet.getString("image_url")
                        )
                );
            }
            
            resultSet.close();
            statement.close();
            connection.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    
    
    public void addImage(String url) {
        if (images == null)
            getImages();
        
        insertImage(new Image(
                images.get(images.size() - 1).getId() + 1,
                url
        ));
        
        images = new ArrayList<>();
        loadImages();
    }
    
    private void insertImage(Image image) {
        try {
            Connection connection = getDatabaseConnection();
            
            Statement statement = connection.createStatement();
            
            statement.executeUpdate(String.format(
                    "INSERT INTO web.\"WebGallery\" (id, image_url) VALUES (%d, '%s')",
                    image.getId(), image.getUrl()
            ));
            
            statement.close();
            connection.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    
    
    public void deleteImage(String url) {
        deleteImageByUrl(url);
        
        images = new ArrayList<>();
        loadImages();
    }
    
    private void deleteImageByUrl(String imageUrl) {
        try {
            Connection connection = getDatabaseConnection();
            
            Statement statement = connection.createStatement();
            
            statement.executeUpdate(String.format(
                    "DELETE FROM web.\"WebGallery\" WHERE image_url = '%s'",
                    imageUrl
            ));
            
            statement.close();
            connection.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    
    
    private Connection getDatabaseConnection() throws SQLException {
        return DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/postgres", DATABASE_MASTER_USER, databaseMasterPassword);
    }
}
