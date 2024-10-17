package com.welfare.carecenter.domain.Bus;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BusPickupInformationDTO {
    private int busId;
    private int busNumber;
    private String busVehicleName;
    private String busDriver;
    private String busSubDriver;
    private String busHelper;
    private String busSubHelper;
//    private int busRow;
//    private int busColumn; 이제 필요 없
//    private List<BusPassengerDTO> busPassengerDTOList;
    private List<BusSeats> busSeats = new ArrayList<>();
}
