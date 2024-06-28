package com.example.win.dto.request;


import com.example.win.global.domain.entity.WinResult;

public record TotoWinRequestDto(String userId, Long amount){
    public WinResult toEntity(String userId, TotoWinRequestDto req){
        return WinResult.builder()
                .resultId(null)
                .type("토토")
                .leftMonths(0)
                .amount(req.amount())
                .userId(userId)
                .build();
    }
}