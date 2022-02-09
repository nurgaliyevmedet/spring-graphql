package kz.infin.it.springgraphql.service;

import kz.infin.it.springgraphql.domain.Vehicle;
import kz.infin.it.springgraphql.dto.VehicleDto;
import kz.infin.it.springgraphql.mapper.VehicleMapper;
import kz.infin.it.springgraphql.repository.VehicleRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class VehicleService {

    private final VehicleRepository vehicleRepository;

    private final VehicleMapper vehicleMapper;

    public VehicleService(VehicleRepository vehicleRepository, VehicleMapper vehicleMapper) {
        this.vehicleRepository = vehicleRepository;
        this.vehicleMapper = vehicleMapper;
    }

    @Transactional
    public Vehicle createVehicle(final String type,final String modelCode, final String brandName, final String launchDate) {
        final Vehicle vehicle = new Vehicle();
        vehicle.setType(type);
        vehicle.setModelCode(modelCode);
        vehicle.setBrandName(brandName);
        vehicle.setLaunchDate(LocalDate.parse(launchDate));
        return vehicleRepository.save(vehicle);
    }

    @Transactional()
    public List<Vehicle> getAllVehicles(final int count) {
        return vehicleRepository.findAll().stream().limit(count).collect(Collectors.toList());
    }

    @Transactional()
    public Optional<Vehicle> getVehicle(final Long id) {
        return vehicleRepository.findById(id);
    }

    @Transactional
    public Vehicle updateVehicle(Vehicle vehicle){
        return vehicleRepository.save(vehicle);
    }

    @Transactional
    public void deleteVehicle(Long id){
        vehicleRepository.deleteById(id);
    }
}