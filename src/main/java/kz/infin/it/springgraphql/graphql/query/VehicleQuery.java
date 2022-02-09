package kz.infin.it.springgraphql.graphql.query;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import kz.infin.it.springgraphql.domain.Vehicle;
import kz.infin.it.springgraphql.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class VehicleQuery implements GraphQLQueryResolver {

    @Autowired
    private VehicleService vehicleService;

    public List<Vehicle> getVehicles(final int count) {
        return this.vehicleService.getAllVehicles(count);
    }

    public Optional<Vehicle> getVehicle(final Long id) {
        return this.vehicleService.getVehicle(id);
    }
}