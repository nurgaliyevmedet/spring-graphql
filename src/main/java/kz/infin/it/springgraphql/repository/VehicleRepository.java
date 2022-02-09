package kz.infin.it.springgraphql.repository;

import kz.infin.it.springgraphql.domain.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {

}
