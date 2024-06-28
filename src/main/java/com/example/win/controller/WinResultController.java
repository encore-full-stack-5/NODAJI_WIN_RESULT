package com.example.win.controller;

import com.example.win.dto.request.LotteryWinRequestDto;
import com.example.win.dto.request.PensionWinRequestDto;
import com.example.win.dto.request.TotoWinRequestDto;
import com.example.win.service.WinResultService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/api/v1")
public class WinResultController {

    private final WinResultService winResultService;
    /**
     * 당첨 결과 전달
     */
    @PostMapping("/pension")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void pensionResult(@RequestBody PensionWinRequestDto req){
        winResultService.pensionWinResultProcess(req);
    }
    @PostMapping("/lottery")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void lotteryResult(@RequestBody LotteryWinRequestDto req){
        winResultService.lotteryWinResultProcess(req);
    }
    @PostMapping("/toto")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void totoResult(@RequestBody TotoWinRequestDto req){
        winResultService.totoWinResultProcess(req);
    }
}
