package com.example.win.service;


import com.example.win.dto.request.LotteryWinRequestDto;
import com.example.win.dto.request.PensionWinRequestDto;
import com.example.win.dto.request.TotoWinRequestDto;

public interface WinResultService {
    void pensionWinResultProcess(String userId, PensionWinRequestDto req);
    void lotteryWinResultProcess(String userId, LotteryWinRequestDto req);
    void totoWinResultProcess(String userId, TotoWinRequestDto req);
}
