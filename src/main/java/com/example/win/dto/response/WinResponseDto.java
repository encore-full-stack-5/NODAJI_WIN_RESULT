package com.example.win.dto.response;

import com.example.win.dto.request.WinRequestDto;
import com.example.win.global.domain.entity.WinResult;

public record WinResponseDto(String type, Integer leftMonths, Long amount){
    public static WinResponseDto from(WinResult winResult) {
        return new WinResponseDto(
                winResult.getType(),
                winResult.getLeftMonths(),
                winResult.getAmount());
    }

    public static WinResponseDto from(WinRequestDto winResult) {
        return new WinResponseDto(
                winResult.type(),
                winResult.leftMonths(),
                winResult.amount());
    }
}