package com.voxeldev.webgalleryjsp.dao;

import com.voxeldev.webgalleryjsp.models.Image;

import java.util.List;

public interface ImagesRepository {
    
    List<Image> getImages();
    
    void addImage(String url);
    
    void deleteImage(String url);
}
