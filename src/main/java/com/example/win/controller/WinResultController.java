package com.example.win.controller;

import com.example.win.dto.request.LotteryWinRequestDto;
import com.example.win.dto.request.PensionWinRequestDto;
import com.example.win.dto.request.TotoWinRequestDto;
import com.example.win.service.WinResultService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class WinResultController {

    private final WinResultService winResultService;
    /**
     * 당첨 결과 전달
     */
    @PostMapping("/pension/{userId}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void pensionResult(@PathVariable(name = "userId") String userId, @RequestBody PensionWinRequestDto req){
        winResultService.pensionWinResultProcess(userId, req);
    }
    @PostMapping("/lottery/{userId}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void lotteryResult(@PathVariable(name = "userId") String userId, @RequestBody LotteryWinRequestDto req){
        winResultService.lotteryWinResultProcess(userId, req);
    }
    @PostMapping("/toto/{userId}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void totoResult(@PathVariable(name = "userId") String userId, @RequestBody TotoWinRequestDto req){
        winResultService.totoWinResultProcess(userId, req);
    }
}
