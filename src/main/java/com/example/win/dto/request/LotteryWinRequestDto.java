package com.example.win.dto.request;


import com.example.win.global.domain.entity.WinResult;

public record LotteryWinRequestDto(Long amount){
    public WinResult toEntity(String userId, LotteryWinRequestDto req){
        return WinResult.builder()
                .resultId(null)
                .type("동행복권")
                .leftMonths(0)
                .amount(req.amount())
                .userId(userId)
                .build();
    }
}