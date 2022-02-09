package kz.infin.it.springgraphql.mapper;

import kz.infin.it.springgraphql.domain.Vehicle;
import kz.infin.it.springgraphql.dto.VehicleDto;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class VehicleMapper {

    public VehicleDto toDto(Vehicle vehicle){
        VehicleDto vehicleDto = new VehicleDto();
        BeanUtils.copyProperties(vehicle, vehicleDto);
        return vehicleDto;
    }

    public Vehicle toEntity(VehicleDto vehicleDto){
        Vehicle vehicle = new Vehicle();
        BeanUtils.copyProperties(vehicleDto, vehicle);
        return vehicle;
    }

}
