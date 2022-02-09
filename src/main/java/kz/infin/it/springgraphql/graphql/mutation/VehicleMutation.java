package kz.infin.it.springgraphql.graphql.mutation;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import kz.infin.it.springgraphql.domain.Engine;
import kz.infin.it.springgraphql.domain.Vehicle;
import kz.infin.it.springgraphql.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class VehicleMutation implements GraphQLMutationResolver {

    @Autowired
    private VehicleService vehicleService;

    public Vehicle createVehicle(final String type, final String modelCode, final String brandName, final String launchDate) {
        return this.vehicleService.createVehicle(type, modelCode, brandName, launchDate);
    }

    public Vehicle updateVehicle(final Long id, final String type, final String modelCode, final String brandName, final String launchDate, final Engine engine) {
        Vehicle vehicle = new Vehicle();
        vehicle.setId(id);
        vehicle.setType(type);
        vehicle.setModelCode(modelCode);
        vehicle.setBrandName(brandName);
        vehicle.setLaunchDate(LocalDate.parse(launchDate));
        vehicle.setEngine(engine);
        return vehicleService.updateVehicle(vehicle);
    }

    public boolean deleteVehicle(final Long id){
        vehicleService.deleteVehicle(id);
        return true;
    }

}