package com.example.win.dto.request;


import com.example.win.global.domain.entity.WinResult;

public record PensionWinRequestDto(String userId,Integer leftMonths, Long amount){
    public WinResult toEntity(PensionWinRequestDto req){
        return WinResult.builder()
                .resultId(null)
                .userId(req.userId)
                .type("연금복권")
                .leftMonths(req.leftMonths)
                .amount(req.amount)
                .userId(userId)
                .build();
    }
}