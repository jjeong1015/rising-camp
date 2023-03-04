package com.example.demo.src.test.model;

import lombok.*;
import org.springframework.lang.Nullable;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
public class SalePostDto {
    private String title;
    private Integer price;
    private String content;
    public LocalDateTime create;
    public LocalDateTime update;
    private String state;
    private Integer userId;


    @Override
    public String toString() {
        return super.toString();
    }
}
