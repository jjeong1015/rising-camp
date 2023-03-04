package com.example.demo.src.image.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
public class ImageDto {
    private Integer imageId;
    private Integer postId;
    private String image1;
    private String image2;
    private String image3;
    private String image4;
    private String image5;
    public LocalDateTime createdAt;
    public LocalDateTime updatedAt;
    private Integer state;


    @Override
    public String toString() {
        return super.toString();
    }
}