package com.example.win.dto.request;


import com.example.win.global.domain.entity.WinResult;

public record PensionWinRequestDto(Integer leftMonths, Long amount){
    public WinResult toEntity(String userId, PensionWinRequestDto req){
        return WinResult.builder()
                .resultId(null)
                .type("연금복권")
                .leftMonths(req.leftMonths)
                .amount(req.amount())
                .userId(userId)
                .build();
    }
}