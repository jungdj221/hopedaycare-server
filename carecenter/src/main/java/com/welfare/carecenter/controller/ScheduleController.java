package com.welfare.carecenter.controller;

import com.welfare.carecenter.domain.Schedule.*;
import com.welfare.carecenter.domain.User.Patient;
import com.welfare.carecenter.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/carecenter/api/schedule/*")
@CrossOrigin(origins = {"*"}, maxAge = 6000)
public class ScheduleController {

    @Autowired
    private ScheduleService scheduleService;

    public String currentDateAsString() {
        LocalDate localDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return localDate.format(formatter);
    }

    // 적외선 , 공기압 오늘의 명단 추가 -- front 에서 날짜는 useEffect 로 오늘 기준꺼 자동 설정

    // 당일 공기압 치료 받는 어르신 리스트
    @PostMapping("/air-massage")
    public ResponseEntity<List<PatientAirMassage>> createAirMassage(@RequestBody List<PatientAirMassageDTO> massageDTOList){
        String nowDate = currentDateAsString();
        List<PatientAirMassage> response = new ArrayList<>();
        for(PatientAirMassageDTO dto : massageDTOList){
            PatientAirMassage req = PatientAirMassage.builder()
                    .patient(Patient.builder()
                            .patientId(dto.getPatientId())
                            .build())
                    .patientTreatmentDate(nowDate)
                    .build();
            response.add(scheduleService.createAirMassage(req));
        }
        return ResponseEntity.ok(response);

    }
    // 공기압 리스트 수정
    @PutMapping("/air-massage")
    public ResponseEntity<List<PatientAirMassage>> updateAirMassage(@RequestBody List<PatientAirMassageDTO> massageDTOList){
        List<PatientAirMassage> response = new ArrayList<>();
        for(PatientAirMassageDTO dto : massageDTOList){
            PatientAirMassage req = PatientAirMassage.builder()
                    .massageListId(dto.getMassageListId())
                    .patient(Patient.builder()
                            .patientId(dto.getPatientId())
                            .build())
                    .patientTreatmentDate(dto.getPatientTreatmentDate())
                    .build();
            response.add(scheduleService.updateAirMassage(req));
        }
        return ResponseEntity.ok(response);
    }

    // 공기압 리스트 삭제
    @DeleteMapping("/air-massage")
    public ResponseEntity<?> deleteAirMassage(@RequestBody List<PatientAirMassage> massageList){
        for(PatientAirMassage vo : massageList){
            scheduleService.deleteAirMassage(vo.getMassageListId());
        }
        return ResponseEntity.ok().build();
    }

    // 공기압 리스트
    @GetMapping("/air-massage")
    public ResponseEntity<List<PatientAirMassageDTO>> viewAllMassageList(){
        List<PatientAirMassage> massageList = scheduleService.viewAllMassageList();
        List<PatientAirMassageDTO> response = new ArrayList<>();
        for(PatientAirMassage vo : massageList){
            PatientAirMassageDTO req = PatientAirMassageDTO.builder()
                    .massageListId(vo.getMassageListId())
                    .patientId(vo.getPatient().getPatientId())
                    .patientName(vo.getPatient().getPatientName())
                    .patientTreatmentDate(vo.getPatientTreatmentDate())
                    .build();
            response.add(req);
        }
        return ResponseEntity.ok(response);
}
    // 당일 적외선 치료 받는 어르신 리스트
    @PostMapping("/infrared-therapy")
    public ResponseEntity<List<PatientInfraredTherapy>> createInfraredTherapy(@RequestBody List<PatientInfraredTherapyDTO> infraredTherapyDTOList){
        String nowDate = currentDateAsString();
        List<PatientInfraredTherapy> response = new ArrayList<>();
        for(PatientInfraredTherapyDTO dto : infraredTherapyDTOList){
            PatientInfraredTherapy req = PatientInfraredTherapy.builder()
                    .patient(Patient.builder()
                            .patientId(dto.getPatientId())
                            .build())
                    .patientTreatmentDate(nowDate)
                    .build();
            response.add(scheduleService.createInfraredTherapy(req));
        }

        return ResponseEntity.ok(response);
    }

    // 적외선 리스트 수정
    @PutMapping("/infrared-therapy")
    public ResponseEntity<List<PatientInfraredTherapy>> updateTherapyList(@RequestBody List<PatientInfraredTherapyDTO> infraredTherapyDTOList){
        List<PatientInfraredTherapy> response = new ArrayList<>();
        for(PatientInfraredTherapyDTO dto : infraredTherapyDTOList){
            PatientInfraredTherapy req = PatientInfraredTherapy.builder()
                    .therapyListId(dto.getTherapyListId())
                    .patient(Patient.builder()
                            .patientId(dto.getPatientId())
                            .build())
                    .patientTreatmentDate(dto.getPatientTreatmentDate())
                    .build();
            response.add(scheduleService.updateInfraredTherapy(req));
        }
        return ResponseEntity.ok(response);
    }

    // 적외선 리스트 삭제
    @DeleteMapping("/infrared-therapy")
    public ResponseEntity<List<PatientInfraredTherapy>> deleteTherapyList(@RequestBody List<PatientInfraredTherapy> therapyList){
        for(PatientInfraredTherapy vo : therapyList){
            scheduleService.deleteInfraredTherapy(vo.getTherapyListId());
        }
        return ResponseEntity.ok().build();
    }

    // 적외선 리스트
    @GetMapping("/infrared-therapy")
    public ResponseEntity<List<PatientInfraredTherapyDTO>> viewAllTherapyList() {
        List<PatientInfraredTherapy> therapyListList = scheduleService.viewAllTherapyList();
        List<PatientInfraredTherapyDTO> response = new ArrayList<>();
        for(PatientInfraredTherapy vo : therapyListList){
            PatientInfraredTherapyDTO req = PatientInfraredTherapyDTO.builder()
                    .therapyListId(vo.getTherapyListId())
                    .patientId(vo.getPatient().getPatientId())
                    .therapyPatientName(vo.getPatient().getPatientName())
                    .patientTreatmentDate(vo.getPatientTreatmentDate())
                    .build();
            response.add(req);
        }
        return ResponseEntity.ok(response);
    }

    // 시간표 전체 보기
    @GetMapping("/class-schedule")
    public ResponseEntity<List<ClassSchedule>> viewAllSchedule(){
        return ResponseEntity.ok(scheduleService.viewALlSchedule());
    }

    // 시간표 추가
    @PostMapping("/class-schedule")
    public ResponseEntity<List<ClassSchedule>> createSchedule(@RequestBody List<ClassSchedule> scheduleList){
        List<ClassSchedule> response = new ArrayList<>();
        for(ClassSchedule vo : scheduleList){
            response.add(scheduleService.createSchedule(vo));
        }
        return ResponseEntity.ok(response);
    }

    // 시간표 수정
    @PutMapping("/class-schedule")
    public ResponseEntity<List<ClassSchedule>> updateSchedule(@RequestBody List<ClassSchedule> scheduleList){
        List<ClassSchedule> response = new ArrayList<>();
        for(ClassSchedule vo : scheduleList){
            response.add(scheduleService.updateSchedule(vo));
        }
        return ResponseEntity.ok(response);
    }

    // 시간표 삭제
    @DeleteMapping("/class-schedule/{scheduleId}")
    public ResponseEntity<?> deleteSchedule(@PathVariable(name = "scheduleId") int scheduleId){
        scheduleService.deleteSchedule(scheduleId);
        return ResponseEntity.ok().build();
    }

}
