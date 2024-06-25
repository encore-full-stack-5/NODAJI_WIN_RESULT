package com.example.win.api;

import com.example.win.dto.request.LotteryWinRequestDto;
import com.example.win.dto.response.WinResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class ApiAccount {
    private final FeignAccount feignAccount;
    public final static List<Map<String, Object>> failList
            = new ArrayList<>();
    @Async
    public void depositPoint(String userId, LotteryWinRequestDto req){
        try {
            feignAccount.depositPoint(userId, WinResponseDto.from(req));
        }catch (Exception e){
            Map<String, Object> map = new HashMap<>();
            map.put("userId", userId);
            map.put("type", req.type());
            map.put("amount", req.amount());
            failList.add(map);
        }
    }
}
