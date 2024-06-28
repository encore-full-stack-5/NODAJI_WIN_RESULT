package com.example.win.service;


import com.example.win.dto.request.LotteryWinRequestDto;
import com.example.win.dto.request.PensionWinRequestDto;
import com.example.win.dto.request.TotoWinRequestDto;

public interface WinResultService {
    void pensionWinResultProcess(PensionWinRequestDto req);
    void lotteryWinResultProcess(LotteryWinRequestDto req);
    void totoWinResultProcess(TotoWinRequestDto req);
}
