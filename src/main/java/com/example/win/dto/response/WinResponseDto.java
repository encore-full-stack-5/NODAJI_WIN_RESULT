package com.example.win.dto.response;

import com.example.win.dto.request.LotteryWinRequestDto;
import com.example.win.dto.request.TotoWinRequestDto;
import com.example.win.global.domain.entity.WinResult;

public record WinResponseDto(String userId, String type, Integer leftMonths, Long amount){
    public static WinResponseDto from(WinResult winResult) {
        return new WinResponseDto(
                winResult.getUserId(),
                winResult.getType(),
                winResult.getLeftMonths(),
                winResult.getAmount());
    }

    public static WinResponseDto from(LotteryWinRequestDto winResult) {
        return new WinResponseDto(
                winResult.userId(),
                "동행복권",
                0,
                winResult.amount());
    }
    public static WinResponseDto from(TotoWinRequestDto winResult) {
        return new WinResponseDto(
                winResult.userId(),
                "토토",
                0,
                winResult.amount());
    }
}