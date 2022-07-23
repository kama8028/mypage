package com.example.mypage.repository;

import com.example.mypage.domain.MyOrder;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface OrderRepository extends MongoRepository<MyOrder, Long> {
}
