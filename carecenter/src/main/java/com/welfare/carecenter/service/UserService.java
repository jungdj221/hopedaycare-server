package com.welfare.carecenter.service;


import com.querydsl.jpa.impl.JPAQueryFactory;
import com.welfare.carecenter.domain.User.Patient;
import com.welfare.carecenter.domain.User.QPatient;
import com.welfare.carecenter.domain.User.Worker;
import com.welfare.carecenter.repo.User.PatientDAO;
import com.welfare.carecenter.repo.User.WorkerDAO;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class UserService {

    @Autowired(required = true)
    private JPAQueryFactory jpaQueryFactory;

    private final QPatient qPatient = QPatient.patient;

    @Autowired
    private PatientDAO patientDAO;

    @Autowired
    private WorkerDAO workerDAO;

//    public Date currentDate (){
//        LocalDateTime localDateTime = LocalDateTime.now();
//        return  java.sql.Timestamp.valueOf(localDateTime);
//    }

    public String currentDateAsString() {
        // 현재 LocalDate 를 얻음 (연월일만 포함)
        LocalDate localDate = LocalDate.now();

        // 원하는 날짜 포맷 지정 (yyyy-MM-dd)
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        // LocalDate 를 포맷팅하여 String 으로 변환
        //String formattedDate =

        return localDate.format(formatter);
    }

    // 직원 명단 가져오기
    public List<Worker> viewAllWorker(){
        return workerDAO.findAll();
    }

    // 직원 추가
    public Worker createWorker(Worker vo){
        return workerDAO.save(vo);
    }

    // 직원 수정
    public Worker updateWorker(Worker vo){
        if(workerDAO.existsById(vo.getWorkerId())){
            return workerDAO.save(vo);
        }
        return null;
    }

    // 직원 삭제 - 직원삭제는 진짜 delete
    public void deleteWorker(int workerId){
        if(workerDAO.existsById(workerId)){
            workerDAO.deleteById(workerId);
        }
    }

    // 어르신 명단 가져오기
    public List<Patient> viewAllPatient(){
        return patientDAO.findAll();
    }

    // 어르신 추가
    public Patient createPatient(Patient vo){
        return patientDAO.save(vo);
    }

    // 어르신 수정
    @Transactional
    public Patient updatePatient(Patient vo){
        if(patientDAO.existsById(vo.getPatientId())){
             long response = jpaQueryFactory.update(qPatient)
                    .set(qPatient.patientName,vo.getPatientName())
                    .set(qPatient.patientInfo,vo.getPatientInfo())
                     .where(qPatient.patientId.eq(vo.getPatientId()))
                    .execute();
             if(response > 0){
                 return patientDAO.findById(vo.getPatientId()).orElseThrow(()->new RuntimeException("patient not found"));
             }else{
                 throw new RuntimeException("failed to update patient");
             }
        }
        return null;
    }

    // 어르신 삭제 - delete 말고 update 로 status 만 바꾸기
    @Transactional
    public Patient graduatePatient(Patient vo){
        String nowDate = currentDateAsString();
        if(patientDAO.existsById(vo.getPatientId())){
            long response = jpaQueryFactory.update(qPatient)
                    .set(qPatient.patientStatus, "N")
                    .set(qPatient.patientGraduationDate, nowDate)
                    .where(qPatient.patientId.eq(vo.getPatientId()))
                    .execute();
            if(response > 0 ){
                return patientDAO.findById(vo.getPatientId()).orElseThrow(()->new RuntimeException("patient not found"));
            }else{
                throw new RuntimeException("failed to update patient");
            }
        }
        return  null;
    }

}
