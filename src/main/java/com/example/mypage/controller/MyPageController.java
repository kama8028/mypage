package com.example.mypage.controller;


import com.example.mypage.domain.*;
import com.example.mypage.service.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = "*", allowedHeaders = "*")  //CORS 오류를 잡기 위해서 외부 URL 허용을 위한 어노테이션
@RestController
@RequiredArgsConstructor
public class MyPageController {

    private final MyInfoService myInfoService;
    private final MyAddressService myAddressService;
    private final MyOrderService myOrderService;
    private final MyDisposalService myDisposalService;
    private final MyEcoPointService myEcoPointService;
    private MyPageAll myPageAll;

    private final MyOrderItemService myOrderItemService;

    //마이 페이지 진입시 모든 데이터 조회하는 함수
    @GetMapping("/mypages/{id}")
    public MyPageAll findInfo(@PathVariable("id") Long id) {
        System.out.println("MyInfo 인입");

        //MyInfo myInfo = myInfoService.findOne(id);
        //MyEcoPoint myEcoPoint = myEcoPointService.findOne(id);
        //List<MyAddress> myAddressList = myAddressService.findAll(id);
        List<MyOrder> myOrderList = myOrderService.findAll(id);
        List<MyDisposal> myDisposalList = myDisposalService.findAll(id);

        //for(MyOrder order : myOrderList) {
        //    System.out.println("DEBUG : " + order.getAddress());
        //}

        //myPageAll = new MyPageAll(myInfo, myEcoPoint, myAddressList, myOrderList, myDisposalList);

        myPageAll = new MyPageAll(myOrderList, myDisposalList);

        return myPageAll;
    }

    //리뷰 등록시 상품 조회 하는 함수
    @GetMapping("/mypages/orderItem/{orderItemId}")
    public OrderItemDto findOrderItem(@PathVariable("orderItemId") Long orderItemId) {
        System.out.println("리뷰 등록을 위한 상품 조회 함수 진입");
        System.out.println(orderItemId);

        OrderItem orderItem = myOrderItemService.findOne(orderItemId);
        OrderItemDto orderItemDto = new OrderItemDto(orderItem);

        return orderItemDto;
    }

    @Getter
    public class MyPageAll {

//        private Long memberId;
//        private String name;
//        private String email;
//        private String phone;
//        private Long ecoPoint;
//        private List<MyAddress> myAddressList;
        private List<MyOrderDto> myOrderDto;
        private List<MyDisposalDto> myDisposalDto;

        public MyPageAll(List<MyOrder> myOrderList, List<MyDisposal> myDisposalList) {
//        public MyPageAll(MyInfo myInfo, MyEcoPoint myEcoPoint, List<MyAddress> myAddressList, List<MyOrder> myOrderList, List<MyDisposal> myDisposalList) {
//            memberId = myInfo.getMemberId();
//            name = myInfo.getName();
//            email = myInfo.getEmail();
//            phone = myInfo.getPhone();
//            ecoPoint  = myEcoPoint.getEcoPoint();
//            this.myAddressList = myAddressList;
            myOrderDto = myOrderList.stream().map(m -> new MyOrderDto(m)).collect(Collectors.toList());
            myDisposalDto = myDisposalList.stream().map(m -> new MyDisposalDto(m)).collect(Collectors.toList());
        }
    }

    @Getter
    public class MyOrderDto {

        private Long orderId;
        //private LocalDateTime orderDate;
        private String orderDate;
        private String address;
        private List<OrderItemDto> orderItems;
        private String deliveryStatus;  //READY, SHIPPING, CANCEL, COMP


        public MyOrderDto(MyOrder myorder) {
            orderId = myorder.getOrderId();
            //orderDate = myorder.getOrderDate();
            orderDate = myorder.getOrderDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            address = myorder.getAddress();
            orderItems = myorder.getOrderItem().stream().map(m -> new OrderItemDto(m)).collect(Collectors.toList());
            deliveryStatus = myorder.getDeliveryStatus().getValue();
        }
    }

    @Getter
    public class OrderItemDto {

        private Long orderItemId;
        private Long itemId;
        private String itemName;
        private Long price;
        private Long qty;

        private Long reviewId;

        public OrderItemDto(OrderItem orderItem) {
            orderItemId = orderItem.getOrderItemId();
            itemId = orderItem.getItemId();
            itemName = orderItem.getItemName();
            price = orderItem.getPrice();
            qty = orderItem.getQty();
            reviewId = orderItem.getReviewId();
        }

    }

    @Getter
    public class MyDisposalDto {

        private Long disposalId;
        //private LocalDateTime disposalDate;
        private String disposalDate;
        private String branchName;
        private List<DisposalItemDto> disposalItems = new ArrayList<>();

        public MyDisposalDto(MyDisposal myDisposal) {
            disposalId = myDisposal.getDisposalId();
            //disposalDate = myDisposal.getDisposalDate();
            disposalDate = myDisposal.getDisposalDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            branchName = myDisposal.getBranchName();
            disposalItems = myDisposal.getDisposalItem().stream().map(m -> new DisposalItemDto(m)).collect(Collectors.toList());
        }

    }

    @Getter
    private class DisposalItemDto {

        private Long disposalItemId;
        private Long recycleItemId;
        private String recycleItemName;
        private Long qty;
        private Long weight;
        private Long point;

        public DisposalItemDto(DisposalItem disposalItem) {
            disposalItemId = disposalItem.getDisposalItemId();
            recycleItemId = disposalItem.getRecycleItemId();
            recycleItemName = disposalItem.getRecycleItemName();
            qty = disposalItem.getQty();
            weight= disposalItem.getWeight();
            point = disposalItem.getPoint();
        }

    }
}
