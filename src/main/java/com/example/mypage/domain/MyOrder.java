package com.example.mypage.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Embedded;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.time.LocalDateTime;

/** 몽고DB는 데이터 객체들이 컬렉션 내부에서 독립된 문서로 저장되는, 문서 모델 기반(Document-Based)으로 하는 NoSQL 데이터베이스입니다.
    컬렉션이라는 것은 몽고DB에서 용도가 같거나 유사한 문서들을 그룹으로 묶는 것을 말합니다. 그리고 이 컬렉션들은 기존 SQL의 데이터베이스의 테이블처럼 비슷하게 동작합니다.
    몽고DB의 문서 모델은 JSON 기반 포맷입니다. 따라서 유여하게 데이터를 즐의하고 조작할 수 있습니다. **/


/**
 * @Document는 이 클래스가 몽고DB에서 문서로서 매핑될 것을 의미
 * @Document 인수 안의 collection은 데이터베이스 테이블로서의 역할
 */
@Document(collection = "MyOrder")
@Getter @Setter
public class MyOrder {

    Long orderId;
    Long memberId;
    LocalDateTime orderDate;

    @Embedded
    OrderItem orderItem;
    String address;

    @Enumerated(EnumType.STRING)
    private DeliveryStatus deliveryStatus;

}
