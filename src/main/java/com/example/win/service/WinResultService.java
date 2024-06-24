package com.example.win.service;


import com.example.win.dto.request.WinRequestDto;

public interface WinResultService {
    void winResultProcess(String userId, WinRequestDto req);
}
