package com.example.demo.src.image;

import com.example.demo.config.BaseException;
import com.example.demo.src.image.ImageDao;
import com.example.demo.src.image.model.ImageDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static com.example.demo.config.BaseResponseStatus.DATABASE_ERROR;
import static com.example.demo.config.BaseResponseStatus.TEST_EMPTY_POST;

@RequiredArgsConstructor
@Service
public class ImageService {

    private final ImageDao imageDao;

    public void createImage(ImageDto imageDto) throws BaseException {
        // 중복
        if (checkImage(imageDto.getImage1()) == 1) {
            throw new BaseException(TEST_EMPTY_POST);
        }

        try {
//            salePostDto.setCreate(LocalDateTime.now());
//            salePostDto.setUpdate(LocalDateTime.now());
            System.out.println("2 = " + imageDto.getCreatedAt());
            imageDao.createImage(imageDto);
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            throw new BaseException(DATABASE_ERROR);
        }
    }
    /*
    public int checkSalePost(String salePost) throws BaseException {
        try{
            return testDao.checkSalePost(salePost);
        } catch (Exception exception){
            throw new BaseException(DATABASE_ERROR);
        }
    }
    */
    public int checkImage(String imageId) throws BaseException {
        try {
            return imageDao.checkImage(imageId);
        } catch (Exception exception) {
            throw new BaseException(DATABASE_ERROR);
        }
    }
}
