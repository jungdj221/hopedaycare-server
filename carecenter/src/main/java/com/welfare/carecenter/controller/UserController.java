package com.welfare.carecenter.controller;

import com.welfare.carecenter.domain.User.Patient;
import com.welfare.carecenter.domain.User.Worker;
import com.welfare.carecenter.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/carecenter/api/user/*")
@CrossOrigin(origins = {"*"}, maxAge = 6000)
public class UserController {

    @Autowired
    private UserService userService;

    // 어르신 명단 가져오기
    @GetMapping("/patient")
    public ResponseEntity <List<Patient>> viewAllPatient(){
        List<Patient> patientList = userService.viewAllPatient();
        return ResponseEntity.ok(patientList);
    }

    // 어르신 추가
    @PostMapping("/patient")
    public ResponseEntity<Patient> createPatient(@RequestBody Patient vo){
//        log.info("vo : " + vo);
        return ResponseEntity.ok(userService.createPatient(vo));
    }

    // 어르신 수정
    @PutMapping("/patient")
    public ResponseEntity<Patient> updatePatient(@RequestBody Patient vo){
        return ResponseEntity.ok(userService.updatePatient(vo));
    }

    // 어르신 비활성화 - 얘만 체크박스로 한번에 리스트 처리
    @PutMapping("/patient-graduate")
    public ResponseEntity<List<Patient>> graduatePatient(@RequestBody List<Patient> patientList){
        List<Patient> response = new ArrayList<>();
        for (Patient patient : patientList){
            response.add(userService.graduatePatient(patient));
        }
        return ResponseEntity.ok(response);
    }

    // 직원 명단 가져오기
    @GetMapping("/worker")
    public ResponseEntity<List<Worker>> viewAllWorker(){
        return ResponseEntity.ok(userService.viewAllWorker());
    }

    // 직원 추가
    @PostMapping("/worker")
    public ResponseEntity<Worker> createWorker(@RequestBody Worker vo){
        return ResponseEntity.ok(userService.createWorker(vo));
    }

    // 직원 수정
    @PutMapping("/worker")
    public ResponseEntity<Worker> updateWorker(@RequestBody Worker vo){
        return ResponseEntity.ok(userService.updateWorker(vo));
    }

    // 직원 삭제 - 리스트로 바꿀꺼면 post 로 변경
    @DeleteMapping("/worker/{wUserId}")
    public ResponseEntity<Worker> deleteWorker(@PathVariable(name = "wUserId") int wUserId){
        userService.deleteWorker(wUserId);
        return ResponseEntity.ok().build();
    }

}
