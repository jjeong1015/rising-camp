package com.example.demo.src.test;

import com.example.demo.config.BaseException;
import com.example.demo.src.test.model.SalePostDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

import static com.example.demo.config.BaseResponseStatus.*;

@RequiredArgsConstructor
@Service
public class TestService {

    private final TestDao testDao;

    public void createSalePost(SalePostDto salePostDto) throws BaseException {
        // 중복
        if(checkSalePost(salePostDto.getContent()) == 1){ // getSalePost
            throw new BaseException(TEST_EMPTY_POST); // POST_USERS_EXISTS_EMAIL
        }

        try{
//            salePostDto.setCreate(LocalDateTime.now());
//            salePostDto.setUpdate(LocalDateTime.now());
            System.out.println("2 = " + salePostDto.getCreate());
            testDao.createSalePost(salePostDto);
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
    public int checkSalePost(String salePostId) throws BaseException {
        try{
            return testDao.checkSalePost(salePostId);
        } catch (Exception exception){
            throw new BaseException(DATABASE_ERROR);
        }
    }
}
