package com.welfare.carecenter.controller;

import com.welfare.carecenter.domain.Bus.*;
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
    // 버스 정보 추가. 추가와 동시에 busPassenger 에 좌석 수 만큼 빈 배열 추가.
    @PostMapping("/bus-info")
    public ResponseEntity<BusPickupInformation> createBusInfo(@RequestBody BusPickupInformation vo){

        // 좌석 수
        int totalSeats =vo.getBusColumn()*vo.getBusRow();
//        log.info("totalSeats : " + totalSeats);

        // 버스 정보 추가 : 추후에 busId를 얻기 위해서.
        BusPickupInformation response = busService.createBusInfo(vo);
//        log.info("response : " + response);

        // 지속적으로 쓰일 busSeat 추가
        for(int i = 0; i < totalSeats; i++){
//            log.info("for 문 작동됨 : " + i);
            BusPassenger req = BusPassenger.builder()
                    .busAvgTime("미정")
                    .busPassengerName("미정")
                    .busCallTiming("미정")
                    .busPickupInformation(BusPickupInformation.builder()
                            .busId(response.getBusId())
                            .build())
                    .busStatus("미정") // 오전 오후
//                    .busSeatsStatus() // 좌석 쓰임새 : 일반, 좌석없음, 중간 거치형
                    .build();
            busService.createPassenger(req);
        }
        return ResponseEntity.ok(response);
    }
    // 버스 정보 수정
    @PutMapping("/bus-info")
    public ResponseEntity<BusPickupInformation> updateBusInfo(@RequestBody BusPickupInformation  vo){
        // 프론트에서 변경된 사항에 따라서 객석의 데이터가 바뀔수있음을 경고
        return ResponseEntity.ok(busService.updateBusInfo(vo));
    }
    // 버스 정보 삭제 - 연결된 승객도 service 에서 삭제
    @DeleteMapping("/bus-info/{busId}")
    public ResponseEntity<BusPickupInformation> deleteBusInfo(@PathVariable(name = "busId") int busId){
        busService.deleteBusInfo(busId);
        return ResponseEntity.ok().build();
    }

    // 버스 한개 보기 bus + busSeats
    @GetMapping("/bus-info/{busId}")
    public ResponseEntity<BusPickupInformationDTO> viewOneBus(@PathVariable(name = "busId") int busId){
        BusPickupInformation bus = busService.viewOneBus(busId);
        BusPickupInformationDTO busDTO = BusPickupInformationDTO.builder()
                .busId(bus.getBusId())
                .busNumber(bus.getBusNumber())
                .busVehicleName(bus.getBusVehicleName())
                .busDriver(bus.getBusDriver())
                .busSubDriver(bus.getBusSubDriver())
                .busHelper(bus.getBusHelper())
                .busSubHelper(bus.getBusSubHelper())
                .busSeats(busService.viewBusSeats(busId))
                .build();

        return ResponseEntity.ok(busDTO);
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
//                    .busId(vo.getBusPickupInformation() != null ? vo.getBusPickupInformation().getBusNumber() : 0)
//                    .busPickUp(BusPickupInformation.builder()
//                            .busId(vo.getBusPickupInformation().getBusId())
//                            .busNumber(vo.getBusPickupInformation().getBusNumber())
//                            .busVehicleName(vo.getBusPickupInformation().getBusVehicleName())
//                            .busColumn(vo.getBusPickupInformation().getBusColumn())
//                            .busRow(vo.getBusPickupInformation().getBusRow())
//                            .build())
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
                            .busId(dto.getBusPickUp().getBusId())
                            .build())
                    .busStatus(dto.getBusStatus())
                    .build();
            response.add(busService.createPassenger(req));
        }

        return ResponseEntity.ok(response);
    }

    // 승객 추가 - 버스 추가시 row * column 값으로 공간만 생성
//    @PostMapping("/bus-passenger")
//    public ResponseEntity<List<BusPassenger>> createPassenger(@RequestBody BusPickupInformation vo){
//        int totalSeats =vo.getBusColumn()*vo.getBusRow();
//        BusPickupInformation req = busService.
//        List<BusPassenger> response = new ArrayList<>();
//        for(int i=0;i < totalSeats;i++){
////            log.info("dto: " + dto);
//            BusPassenger req = BusPassenger.builder()
//                    .busAvgTime(dto.getBusAvgTime())
//                    .busPassengerName(dto.getBusPassengerName())
//                    .busCallTiming(dto.getBusCallTiming())
//                    .busPickupInformation(BusPickupInformation.builder()
//                            .busId()
//                            .build())
//                    .busStatus(dto.getBusStatus())
//                    .build();
//            response.add(busService.createPassenger(req));
//        }
//
//        return ResponseEntity.ok().build();
//    }
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
                            .busId(dto.getBusPickUp().getBusId())
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
