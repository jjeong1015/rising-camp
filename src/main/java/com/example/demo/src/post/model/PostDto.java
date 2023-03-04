package com.example.demo.src.post.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
public class PostDto {

    //title, category, content, numberOfChats, numberOfInterests, numberOfChecks, price, sellerId, state, areaSettingId, distanceId

    private String title;
    private String category;
    private String content;
    private Integer numberOfChats;
    private Integer numberOfInterests;
    private Integer numberOfChecks;
    private Integer price;
    private Integer sellerId;
    private Integer buyerId;
    public LocalDateTime createdAt;
    public LocalDateTime updatedAt;
    private Integer state;
    private Integer areaSettingId;
    private Integer distanceId;


    /*
    private String title;
    private Integer price;
    private String content;
    public LocalDateTime createdAt;
    public LocalDateTime updatedAt;
    private String state;
    private Integer userId;
    */

    @Override
    public String toString() {
        return super.toString();
    }
}
