package com.example.mypage.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
@Getter @Setter
public class MyDisposal {

    @Id
    @GeneratedValue
    private Long disposalId;

    @OneToMany(mappedBy = "myDisposal", cascade = CascadeType.ALL)
    private List<DisposalItem> disposalItem = new ArrayList<>();

    private Long memberId;
    private LocalDateTime disposalDate;
    private String BranchName;

}
