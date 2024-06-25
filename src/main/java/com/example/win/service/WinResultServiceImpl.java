package com.example.win.service;

import com.example.win.api.FeignAccount;
import com.example.win.dto.request.LotteryWinRequestDto;
import com.example.win.dto.request.PensionWinRequestDto;
import com.example.win.dto.request.TotoWinRequestDto;
import com.example.win.dto.response.WinResponseDto;
import com.example.win.global.domain.repository.WinResultRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class WinResultServiceImpl implements WinResultService{
    private final WinResultRepository winResultRepository;
    private final FeignAccount feignAccount;
    @Transactional
    public void pensionWinResultProcess(String userId, PensionWinRequestDto req) {
        winResultRepository.save(req.toEntity(userId, req));
    }
    @Transactional
    public void lotteryWinResultProcess(String userId, LotteryWinRequestDto req) {
        feignAccount.depositPoint(userId, WinResponseDto.from(req));
    }
    @Transactional
    public void totoWinResultProcess(String userId, TotoWinRequestDto req) {
        feignAccount.depositPoint(userId, WinResponseDto.from(req));
    }
}
