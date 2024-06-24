package com.example.win.dto.request;


import com.example.win.global.domain.entity.WinResult;

public record WinRequestDto(String type, Integer leftMonths, Long amount){
    public WinResult toEntity(String userId, WinRequestDto req){
        return WinResult.builder()
                .resultId(null)
                .type(req.type())
                .leftMonths(req.leftMonths())
                .amount(req.amount())
                .userId(userId)
                .build();
    }
}