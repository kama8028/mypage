package com.example.mypage;

import com.example.mypage.domain.DisposalItem;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter @Setter
public class DisposalCompleted extends AbstractEvent{

    private Long disposalId;
    private Long memberId;
    private LocalDateTime disposalDate;
    private String BranchName;
    private List<DisposalItem> disposalItem = new ArrayList<>();

}
