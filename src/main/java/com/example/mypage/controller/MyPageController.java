package com.example.mypage.controller;


import com.example.mypage.domain.MyInfo;
import com.example.mypage.service.MyInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MyPageController {

    private final MyInfoService myInfoService;

    @GetMapping("/mypages/myinfo/{id}")
    public MyInfo findInfo(@PathVariable("id") Long id) {
        System.out.println("MyInfo 인입");
        return myInfoService.findOne(id);
    }

}
