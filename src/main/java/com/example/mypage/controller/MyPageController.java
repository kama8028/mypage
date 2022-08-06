package com.example.mypage.controller;


import com.example.mypage.domain.*;
import com.example.mypage.repository.MyInfoRepository;
import com.example.mypage.service.MyAddressService;
import com.example.mypage.service.MyDisposalService;
import com.example.mypage.service.MyInfoService;
import com.example.mypage.service.MyOrderService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class MyPageController {

    private final MyInfoService myInfoService;
    private final MyAddressService myAddressService;
    private final MyOrderService myOrderService;
    private final MyDisposalService myDisposalService;
    private MyPageAll myPageAll;

    @GetMapping("/mypages/{id}")
    public MyPageAll findInfo(@PathVariable("id") Long id) {
        System.out.println("MyInfo 인입");

        MyInfo myInfo = myInfoService.findOne(id);
        List<MyAddress> myAddressList = myAddressService.findAll(id);
        List<MyOrder> myOrderList = myOrderService.findAll(id);
        List<MyDisposal> myDisposalList = myDisposalService.findAll(id);

        myPageAll = new MyPageAll(myInfo, myAddressList, myOrderList, myDisposalList);

        return myPageAll;
    }

    @Getter
    public class MyPageAll {

        private Long memberId;
        private String name;
        private String email;
        private String phone;
        private List<MyAddress> myAddressList;
        private List<MyOrder> myOrderList;
        private List<MyDisposal> myDisposalList;

        public MyPageAll(MyInfo myInfo, List<MyAddress> myAddressList, List<MyOrder> myOrderList, List<MyDisposal> myDisposalList) {
            memberId = myInfo.getMemberId();
            name = myInfo.getName();
            email = myInfo.getEmail();
            phone = myInfo.getPhone();
            this.myAddressList = myAddressList;
            this.myOrderList = myOrderList;
            this.myDisposalList = myDisposalList;
        }
    }

}
