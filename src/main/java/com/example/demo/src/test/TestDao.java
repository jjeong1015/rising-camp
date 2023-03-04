package com.example.demo.src.test;

import com.example.demo.src.test.model.SalePostDto;
import com.example.demo.src.user.model.PostUserReq;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class TestDao {
    private final JdbcTemplate jdbcTemplate;

    public void createSalePost(SalePostDto salePostDto){

        String createSalePostQuery = "insert into salePost ( title, price, content, state, userId) VALUES ( ?, ?, ?, ?, ?)"; // "insert into SalePost (salePostId, title, price, content) VALUES (?,?,?,?)";
        Object[] createSalePostParams = new Object[]{ salePostDto.getTitle(), salePostDto.getPrice(), salePostDto.getContent(), salePostDto.getState(), salePostDto.getUserId()};
        System.out.println("3 = " + salePostDto.getCreate());
        this.jdbcTemplate.update(createSalePostQuery, createSalePostParams);
    }

    public int checkSalePost(String salePostId){ // 필드명 ?
        String checkSalePostQuery = "select exists(select salePostId from salePost where salePostId = ? and state = 'active')"; // 필드 테이블 필드
        String checkSalePostParams = salePostId; // 필드명 ?
        return this.jdbcTemplate.queryForObject(checkSalePostQuery, int.class, checkSalePostParams);
    }
}
