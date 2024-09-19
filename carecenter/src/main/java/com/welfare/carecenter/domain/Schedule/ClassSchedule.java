package com.welfare.carecenter.domain.Schedule;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "class_schedule")
public class ClassSchedule {
    @Id
    @Column(name = "schedule_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int scheduleId;

    // 요일
    @Column(name = "schedule_date")
    private String scheduleDate;

    // 수업 이름  ex) 한국무용
    @Column(name = "schedule_name")
    private String scheduleName;

    // 뭐하는지 : 공익 도움 필요 ? 추가로 알아야 할 정보들 있음? 등등
    @Column(name = "schedule_info")
    private String scheduleInfo;

    // 시작 시간 - 시작, 끝 둘다 String 으로 front 에서 regex 로 처리
    @Column(name = "schedule_begin")
    private String scheduleBegin;

    // 끝 시간
    @Column(name = "schedule_end")
    private String scheduleEnd;
}
