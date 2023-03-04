package com.example.demo.src.post;

import com.example.demo.config.BaseException;
import com.example.demo.src.post.model.PostDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static com.example.demo.config.BaseResponseStatus.DATABASE_ERROR;
import static com.example.demo.config.BaseResponseStatus.TEST_EMPTY_POST;

@RequiredArgsConstructor
@Service
public class PostService {

    private final PostDao postDao;

    public void createPost(PostDto postDto) throws BaseException {
        // 중복
        if (checkPost(postDto.getContent()) == 1) {
            throw new BaseException(TEST_EMPTY_POST);
        }

        try {
        // postDto.setCreate(LocalDateTime.now());
        // postDto.setUpdate(LocalDateTime.now());
            System.out.println("2 = " + postDto.getCreatedAt());
            postDao.createPost(postDto);
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            throw new BaseException(DATABASE_ERROR);
        }
    }

    public int checkPost(String postId) throws BaseException {
        try {
            return postDao.checkPost(postId);
        } catch (Exception exception) {
            throw new BaseException(DATABASE_ERROR);
        }
    }
}