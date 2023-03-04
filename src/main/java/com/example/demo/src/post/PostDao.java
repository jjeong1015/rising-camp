package com.example.demo.src.post;

import com.example.demo.src.post.model.PostDto;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class PostDao {
    private final JdbcTemplate jdbcTemplate;

    public void createPost(PostDto postDto) {
        String createPostQuery = "insert into post (title, category, content, numberOfChats, numberOfInterests, numberOfChecks, price, sellerId, state, areaSettingId, distanceId) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        Object[] createPostParams = new Object[]{postDto.getTitle(), postDto.getCategory(), postDto.getContent(), postDto.getNumberOfChats(), postDto.getNumberOfInterests(), postDto.getNumberOfChecks(), postDto.getPrice(), postDto.getSellerId(), postDto.getState(), postDto.getAreaSettingId(), postDto.getDistanceId()};
        // String createPostQuery = "insert into post (title, content, price, state, userId) VALUES (?, ?, ?, ?, ?)";
        // Object[] createPostParams = new Object[]{postDto.getTitle(), postDto.getContent(), postDto.getPrice(), postDto.getState(), postDto.getUserId()};
        System.out.println("3 = " + postDto.getCreatedAt());
        this.jdbcTemplate.update(createPostQuery, createPostParams);
    }

    public int checkPost(String postId) {
        String checkPostQuery = "select exists(select postId from post where postId = ? and state = 'active')";
        String checkPostParams = postId;
        return this.jdbcTemplate.queryForObject(checkPostQuery, int.class, checkPostParams);
    }
}

