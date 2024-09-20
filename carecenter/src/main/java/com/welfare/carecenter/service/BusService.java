package com.welfare.carecenter.service;

import com.welfare.carecenter.domain.Bus.BusPassenger;
import com.welfare.carecenter.domain.Bus.BusPickupInformation;
import com.welfare.carecenter.repo.Bus.BusPassengerDAO;
import com.welfare.carecenter.repo.Bus.BusPickupInformationDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BusService {


    @Autowired
    private BusPassengerDAO busPassengerDAO;

    @Autowired
    private BusPickupInformationDAO busPickupDAO;

    // 버스 리스트
    public List<BusPickupInformation> viewAllBusList(){
        return busPickupDAO.findAll();
    }

    //버스 정보 추가
    public BusPickupInformation createBusInfo(BusPickupInformation vo){
        return busPickupDAO.save(vo);
    }

    // 버스 정보 수정
    public BusPickupInformation updateBusInfo(BusPickupInformation vo){
        if(busPickupDAO.existsById(vo.getBusId())){
            return busPickupDAO.save(vo);
        }
        return null;
    }
    // 버스 정보 삭제
    public void deleteBusInfo(int busId){
        if(busPickupDAO.existsById(busId)){
            busPickupDAO.deleteById(busId);
        }

    }

    // 버스 승객 명단
    public List<BusPassenger> viewAllPassengers(){

        return busPassengerDAO.findAll();
    }
    // 버스 승객 추가
    public BusPassenger createPassenger(BusPassenger vo){
        return busPassengerDAO.save(vo);
    }

    // 버스 승객 수정
    public BusPassenger updatePassenger(BusPassenger vo){
        if(busPassengerDAO.existsById(vo.getBusPassengerId())){
            return busPassengerDAO.save(vo);
        }
        return null;
    }

    // 버스 승객 삭제
    public void deletePassenger(int busPassengerId){
        if(busPassengerDAO.existsById(busPassengerId)){
            busPassengerDAO.deleteById(busPassengerId);
        }
    }
}
