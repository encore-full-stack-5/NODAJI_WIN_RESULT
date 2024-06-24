package com.example.win.service;

import com.example.win.api.FeignAccount;
import com.example.win.dto.request.WinRequestDto;
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
    public void winResultProcess(String userId, WinRequestDto req) {
        if (req.type().equals("연금복권")) winResultRepository.save(req.toEntity(userId, req));
        else feignAccount.depositPoint(userId, WinResponseDto.from(req));
    }
}
