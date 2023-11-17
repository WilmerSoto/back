package co.udea.ssmu.api.model.jpa.repository.drivers;

import co.udea.ssmu.api.model.jpa.model.drivers.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface DriverRepository extends JpaRepository<Driver, Integer> {

    @Query("SELECT d FROM Driver d WHERE UPPER(d.cedula) = UPPER(:cedula)")
    Optional<Driver> findByDocumentAndDocumentType(@Param("cedula") String name);

}
