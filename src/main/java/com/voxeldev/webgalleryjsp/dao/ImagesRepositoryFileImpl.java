package com.voxeldev.webgalleryjsp.dao;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.voxeldev.webgalleryjsp.models.Image;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ImagesRepositoryFileImpl implements ImagesRepository {
    
    private static final String PATH = "C:\\Users\\agent\\IdeaProjects\\WebGalleryJSP\\src\\main\\images.json";
    
    private static ImagesRepositoryFileImpl imagesRepository;
    
    private final Gson gson = new Gson();
    private final List<Image> images = read();
    
    @Override
    public List<Image> getImages() {
        return images;
    }
    
    public static ImagesRepositoryFileImpl getInstance() {
        if (imagesRepository == null) {
            imagesRepository = new ImagesRepositoryFileImpl();
        }
        return imagesRepository;
    }
    
    @Override
    public void addImage(String url) {
        int id;
        
        if (images.size() > 0)
            id = images.get(images.size() - 1).getId() + 1;
        else
            id = 0;
        
        images.add(new Image(id, url));
        
        write();
    }
    
    @Override
    public void deleteImage(String url) {
        Optional<Image> optionalImage = images.stream().filter(image -> image.getUrl().equals(url)).findFirst();
        
        if (optionalImage.isEmpty())
            return;
        
        images.remove(optionalImage.get());
        
        write();
    }
    
    private List<Image> read() {
        try (FileReader fileReader = new FileReader(PATH)) {
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String json = bufferedReader.readLine();
            
            bufferedReader.close();
    
            return gson.fromJson(json, new TypeToken<List<Image>>(){}.getType());
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return new ArrayList<>();
    }
    
    private void write() {
        try (FileWriter fileWriter = new FileWriter(PATH)) {
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            
            bufferedWriter.write(gson.toJson(images));
            bufferedWriter.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
