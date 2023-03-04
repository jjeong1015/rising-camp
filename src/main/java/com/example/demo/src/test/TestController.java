package com.example.demo.src.test;

import com.example.demo.config.BaseException;
import com.example.demo.config.BaseResponse;
import com.example.demo.src.test.model.SalePostDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import static com.example.demo.config.BaseResponseStatus.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/test")
public class TestController {

    private final TestService testService;

    /**
     * 로그 테스트 API
     * [GET] /test/log
     * @return String
     */

    @ResponseBody
    @GetMapping("/log")
    public String getAll() {
        System.out.println("테스트");
//        trace, debug 레벨은 Console X, 파일 로깅 X
//        logger.trace("TRACE Level 테스트");
//        logger.debug("DEBUG Level 테스트");

//        info 레벨은 Console 로깅 O, 파일 로깅 X
        //logger.info("INFO Level 테스트");
//        warn 레벨은 Console 로깅 O, 파일 로깅 O
        //logger.warn("Warn Level 테스트");
//        error 레벨은 Console 로깅 O, 파일 로깅 O (app.log 뿐만 아니라 error.log 에도 로깅 됨)
//        app.log 와 error.log 는 날짜가 바뀌면 자동으로 *.gz 으로 압축 백업됨
        //logger.error("ERROR Level 테스트");

        return "Success Test";
    }

    /**
     * 게시물 생성 API
     * [POST] /test/salePosts
     * @return BaseResponse<PostUserRes>
     */
    // Body
    @ResponseBody
    @PostMapping("/TestController") // "/salePosts"
    public BaseResponse<String> createSalePost(@RequestBody SalePostDto salePostDto) {
        // TODO: email 관련한 짧은 validation 예시입니다. 그 외 더 부가적으로 추가해주세요!

        try{
            System.out.println("1 = " + salePostDto.getCreate());
            testService.createSalePost(salePostDto);
            String result = "salePosts 생성 성공!!";
            return new BaseResponse<>(result);
        } catch(BaseException exception){
            return new BaseResponse<>((exception.getStatus()));
        }
    }
}
