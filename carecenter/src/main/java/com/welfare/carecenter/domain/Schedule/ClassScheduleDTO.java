package com.welfare.carecenter.domain.Schedule;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ClassScheduleDTO {

    private int scheduleId;
    private String scheduleName;
    private String scheduleInfo;
    private String scheduleBegin;
    private String scheduleEnd;
}
