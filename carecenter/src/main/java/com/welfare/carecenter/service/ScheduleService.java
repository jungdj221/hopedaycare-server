package com.welfare.carecenter.service;

import com.welfare.carecenter.domain.Schedule.ClassSchedule;
import com.welfare.carecenter.domain.Schedule.PatientAirMassage;
import com.welfare.carecenter.domain.Schedule.PatientInfraredTherapy;
import com.welfare.carecenter.repo.Schedule.ClassScheduleDAO;
import com.welfare.carecenter.repo.Schedule.PatientAirMassageDAO;
import com.welfare.carecenter.repo.Schedule.PatientInfraredTherapyDAO;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScheduleService {

    @Autowired
    private PatientAirMassageDAO airMassageDAO;

    @Autowired
    private PatientInfraredTherapyDAO infraredTherapyDAO;

    @Autowired
    private ClassScheduleDAO classScheduleDAO;

    // 공기압 받는 명단 추가
    public PatientAirMassage createAirMassage(PatientAirMassage vo){
        return airMassageDAO.save(vo);
    }

    // 공기압 받는 명단 수정
    public PatientAirMassage updateAirMassage(PatientAirMassage vo){
        if(airMassageDAO.existsById(vo.getMassageListId())){
            return airMassageDAO.save(vo);
        }
        return null;
    }

    // 공기압 받는 명단 삭제
    @Transactional
    public void deleteAirMassage(int massageId){
        if(airMassageDAO.existsById(massageId)){
            airMassageDAO.deleteById(massageId);
        }
    }

    // 적외선 받는 명단 추가
    public PatientInfraredTherapy createInfraredTherapy(PatientInfraredTherapy vo){
        return infraredTherapyDAO.save(vo);
    }

    // 적외선 명단 수정
    public PatientInfraredTherapy updateInfraredTherapy(PatientInfraredTherapy vo){
        if(infraredTherapyDAO.existsById(vo.getTherapyListId())){
            return infraredTherapyDAO.save(vo);
        }
        return null;
    }

    // 적외선 명단 삭제
    public void deleteInfraredTherapy(int therapyListId){
        if(infraredTherapyDAO.existsById(therapyListId)){
            infraredTherapyDAO.deleteById(therapyListId);
        }
    }

    // 공기압 리스트 불러오기
    public List<PatientAirMassage> viewAllMassageList (){
        return airMassageDAO.findAll();
    }

    // 적외선 리스트 불러오기
    public List<PatientInfraredTherapy> viewAllTherapyList (){
        return infraredTherapyDAO.findAll();
    }

    // 시간표 리스트
    public List<ClassSchedule> viewALlSchedule(){
        return classScheduleDAO.findAll();
    }

    // 시간표 추가
    public ClassSchedule createSchedule(ClassSchedule vo){
        return classScheduleDAO.save(vo);
    }

    // 시간표 수정
    public ClassSchedule updateSchedule(ClassSchedule vo){
        if(classScheduleDAO.existsById(vo.getScheduleId())){
            return classScheduleDAO.save(vo);
        }
        return null;
    }

    // 시간표 삭제
    public void deleteSchedule(int scheduleId){
        classScheduleDAO.deleteById(scheduleId);
    }
}
