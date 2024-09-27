package com.welfare.carecenter.controller;

import com.welfare.carecenter.domain.Bus.BusPassenger;
import com.welfare.carecenter.domain.Bus.BusPassengerDTO;
import com.welfare.carecenter.domain.Bus.BusPickupInformation;
import com.welfare.carecenter.service.BusService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/carecenter/api/bus/*")
@CrossOrigin(origins = {"*"}, maxAge = 6000)
public class BusController {

    @Autowired
    private BusService busService;

    // 버스 리스트
    @GetMapping("/bus-info")
    public ResponseEntity<List<BusPickupInformation>> viewAllBusList(){
        return ResponseEntity.ok(busService.viewAllBusList());
    }
    // 버스 정보 추가
    @PostMapping("/bus-info")
    public ResponseEntity<BusPickupInformation> createBusInfo(@RequestBody BusPickupInformation vo){
        return ResponseEntity.ok(busService.createBusInfo(vo));
    }
    // 버스 정보 수정
    @PutMapping("/bus-info")
    public ResponseEntity<BusPickupInformation> updateBusInfo(@RequestBody BusPickupInformation  vo){
        return ResponseEntity.ok(busService.updateBusInfo(vo));
    }
    // 버스 정보 삭제
    @DeleteMapping("/bus-info/{busId}")
    public ResponseEntity<BusPickupInformation> deleteBusInfo(@PathVariable(name = "busId") int busId){
        busService.deleteBusInfo(busId);
        return ResponseEntity.ok().build();
    }

    // 버스 한개 보기
    @GetMapping("/bus-info/{busId}")
    public ResponseEntity<BusPickupInformation> viewOneBus(@PathVariable(name = "busId") int busId){
        log.info("bus : " + busService.viewOneBus(busId));
        return ResponseEntity.ok(busService.viewOneBus(busId));
    }

    // 탑승객 명단 - 여기서의 가져오는 busId 는 busNumber 을 뜻함.
    @GetMapping("/bus-passenger/{busId}")
    public ResponseEntity<List<BusPassengerDTO>> viewAllPassengers(@PathVariable(name = "busId")int busId){
        List<BusPassenger> passengerList = busService.viewAllPassengers(busId);
        List<BusPassengerDTO> response = new ArrayList<>();
        for(BusPassenger vo : passengerList){
            BusPassengerDTO req = BusPassengerDTO.builder()
                    .busPassengerId(vo.getBusPassengerId())
                    .busAvgTime(vo.getBusAvgTime())
                    .busPassengerName(vo.getBusPassengerName())
                    .busCallTiming(vo.getBusCallTiming())
                    .busId(vo.getBusPickupInformation() != null ? vo.getBusPickupInformation().getBusNumber() : 0)
                    .busStatus(vo.getBusStatus())
                    .build();
            response.add(req);

        }
        return ResponseEntity.ok(response);
    }

    // 승객 추가 - 버스정보와의 혼합 dto front 상황따라서 List 로 바뀔수도 있음
    @PostMapping("/bus-passenger")
    public ResponseEntity<List<BusPassenger>> createPassenger(@RequestBody List<BusPassengerDTO> passengerDTOList){

        List<BusPassenger> response = new ArrayList<>();
        for(BusPassengerDTO dto : passengerDTOList){
//            log.info("dto: " + dto);
            BusPassenger req = BusPassenger.builder()
                    .busAvgTime(dto.getBusAvgTime())
                    .busPassengerName(dto.getBusPassengerName())
                    .busCallTiming(dto.getBusCallTiming())
                    .busPickupInformation(BusPickupInformation.builder()
                            .busId(dto.getBusId())
                            .build())
                    .busStatus(dto.getBusStatus())
                    .build();
            response.add(busService.createPassenger(req));
        }

        return ResponseEntity.ok(response);
    }
    // 승객 수정
    @PutMapping("/bus-passenger")
    public ResponseEntity<List<BusPassenger>> updatePassenger(@RequestBody List<BusPassengerDTO> passengerDTOList){
        List<BusPassenger> response = new ArrayList<>();
        for(BusPassengerDTO dto : passengerDTOList){
            BusPassenger req = BusPassenger.builder()
                    .busPassengerId(dto.getBusPassengerId())
                    .busAvgTime(dto.getBusAvgTime())
                    .busPassengerName(dto.getBusPassengerName())
                    .busCallTiming(dto.getBusCallTiming())
                    .busPickupInformation(BusPickupInformation.builder()
                            .busId(dto.getBusId())
                            .build())
                    .busStatus(dto.getBusStatus())
                    .build();
            response.add(busService.updatePassenger(req));
        }

        return ResponseEntity.ok(response);
    }
    // 승객 삭제 - 삭제는 유저 삭제시 같이 진행되는 형태로 할꺼임
    @DeleteMapping("/bus-passenger")
    public ResponseEntity<?> deletePassenger(@RequestBody List<BusPassenger> passengerList){
        for(BusPassenger vo : passengerList){
            busService.deletePassenger(vo.getBusPassengerId());
        }
        return ResponseEntity.ok().build();
    }

}
