package com.welfare.carecenter.service;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.welfare.carecenter.domain.Bus.*;
import com.welfare.carecenter.repo.Bus.BusPassengerDAO;
import com.welfare.carecenter.repo.Bus.BusPickupInformationDAO;
import com.welfare.carecenter.repo.Bus.BusSeatsDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BusService {

    @Autowired
    private JPAQueryFactory jpaQueryFactory;

    private final QBusPassenger qBusPassenger = QBusPassenger.busPassenger;
    private final QBusSeats qBusSeats = QBusSeats.busSeats;

    @Autowired
    private BusPassengerDAO busPassengerDAO;

    @Autowired
    private BusPickupInformationDAO busPickupDAO;

    @Autowired
    private BusSeatsDAO busSeatsDAO;

    // 버스 리스트
    public List<BusPickupInformation> viewAllBusList(){
        return busPickupDAO.findAll();
    }

    //버스 정보 추가
    public BusPickupInformation createBusInfo(BusPickupInformation vo){
        return busPickupDAO.save(vo);
    }

    // 버스 승객 추가 - 승객 창에서 따로 처리
    public BusPassenger createPassenger(BusPassenger vo){
        return busPassengerDAO.save(vo);
    }

    // 버스 정보 수정
    public BusPickupInformation updateBusInfo(BusPickupInformation vo){
        if(busPickupDAO.existsById(vo.getBusId())){
            return busPickupDAO.save(vo);
        }
        return null;
    }
    // 버스 정보 삭제
    @Transactional
    public void deleteBusInfo(int busId){
        if(busPickupDAO.existsById(busId)){
            busPickupDAO.deleteById(busId);
            jpaQueryFactory.delete(qBusPassenger)
                    .where(qBusPassenger.busPickupInformation.busId.eq(busId))
                    .execute();
        }

    }

    // 버스 하나 보기
    public BusPickupInformation viewOneBus (int busId){
        if(busPickupDAO.existsById(busId)){
            return busPickupDAO.findById(busId).orElse(null);
        }
        return null;
    }

    // 버스 좌석 가져오기
    public List<BusSeats> viewBusSeats (int busId){
        return jpaQueryFactory.selectFrom(qBusSeats)
                .where(qBusSeats.busPickupInformation.busId.eq(busId))
                .fetch();
    }

    // 버스 좌석 추가
    public BusSeats createBusSeats

    // 버스 좌석 status 수정
    public BusSeats updateBusSeats (BusSeats vo){
        if(busSeatsDAO.existsById(vo.getBusSeatId())){
            return busSeatsDAO.save(vo);
        }
        return null;
    }


    // 버스 승객 명단
    public List<BusPassenger> viewAllPassengers(int busId){
        return jpaQueryFactory.selectFrom(qBusPassenger)
                .where(qBusPassenger.busPickupInformation.busId.eq(busId))
                .fetch();
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
