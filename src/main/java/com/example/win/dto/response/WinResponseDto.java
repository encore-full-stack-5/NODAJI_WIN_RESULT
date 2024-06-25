package com.example.win.dto.response;

import com.example.win.dto.request.LotteryWinRequestDto;
import com.example.win.dto.request.TotoWinRequestDto;
import com.example.win.global.domain.entity.WinResult;

public record WinResponseDto(String type, Integer leftMonths, Long amount){
    public static WinResponseDto from(WinResult winResult) {
        return new WinResponseDto(
                winResult.getType(),
                winResult.getLeftMonths(),
                winResult.getAmount());
    }

    public static WinResponseDto from(LotteryWinRequestDto winResult) {
        return new WinResponseDto(
                "동행복권",
                winResult.leftMonths(),
                winResult.amount());
    }
    public static WinResponseDto from(TotoWinRequestDto winResult) {
        return new WinResponseDto(
                "토토",
                winResult.leftMonths(),
                winResult.amount());
    }
}