package com.example.win.api;

import com.example.win.dto.response.WinResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "account-service", url = "http://localhost:8083/api/v1")
public interface FeignAccount {
    @PutMapping("/accounts/deposit")
    void depositPoint(@RequestBody WinResponseDto req);
}