package com.example.win.global.domain.entity;

import com.example.win.dto.request.WinRequestDto;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "WIN_RESULT")
public class WinResult {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "RESULT_ID")
    private Long resultId;
    @Setter
    @Column(name = "LEFT_MONTHS")
    private Integer leftMonths;
    @Column(name = "AMOUNT")
    private Long amount;
    @Column(name = "TYPE")
    private String type;
    @Column(name = "USER_ID")
    private String userId;
    public WinResult toEntity(String userId, WinRequestDto req){
        return WinResult.builder()
                .resultId(null)
                .leftMonths(req.leftMonths())
                .amount(req.amount())
                .type(req.type())
                .userId(userId)
                .build();
    }


}
