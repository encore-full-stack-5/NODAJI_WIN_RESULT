package com.example.win.service;

import com.example.win.api.FeignAccount;
import com.example.win.dto.response.WinResponseDto;
import com.example.win.global.domain.entity.WinResult;
import com.example.win.global.domain.repository.WinResultRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ScheduledDepositService {

    private final WinResultRepository winResultRepository;
    private final FeignAccount feignAccount;
    @Transactional
    @Scheduled(cron = "0 0 0 1 * ?")
    public void addPensionAmountToDeposit(){
        List<WinResult> allValidWinResults = winResultRepository.findAllValidWinResults();
        allValidWinResults.forEach(result -> {
            feignAccount.depositPoint(result.getUserId(), WinResponseDto.from(result));
            result.setLeftMonths(result.getLeftMonths() - 1);
        });
    }
}
