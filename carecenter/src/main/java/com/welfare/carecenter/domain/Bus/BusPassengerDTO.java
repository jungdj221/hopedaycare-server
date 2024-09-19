package com.welfare.carecenter.domain.Bus;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BusPassengerDTO {
    private int busPassengerId;
    private String busAvgTime;
    private String busPassengerName;
    private String busCallTiming;
    private int busId; // 버스 아이디. 번호 아님
    private String busStatus;  // 오전 , 오후 송영 여부
}
