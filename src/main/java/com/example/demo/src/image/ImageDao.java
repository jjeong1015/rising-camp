package com.example.demo.src.image;

import com.example.demo.src.image.model.ImageDto;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class ImageDao {
    private final JdbcTemplate jdbcTemplate;

    public void createImage(ImageDto imageDto) {
        String createImageQuery = "insert into image (image1, image2, image3, image4, image5, state) VALUES (?, ?, ?, ?, ?, ?)";
        Object[] createImageParams = new Object[]{imageDto.getImage1(), imageDto.getImage2(), imageDto.getImage3(), imageDto.getImage4(), imageDto.getImage5(), imageDto.getState()};
        System.out.println("3 = " + imageDto.getCreatedAt());
        this.jdbcTemplate.update(createImageQuery, createImageParams);
    }

    public int checkImage(String imageId) {
        String checkImageQuery = "select exists(select imageId from image where imageId = ? and state = 'active')";
        String checkImageParams = imageId;
        return this.jdbcTemplate.queryForObject(checkImageQuery, int.class, checkImageParams);
    }
}


