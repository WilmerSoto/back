package co.udea.ssmu.api.services.drivers.facade;

import co.udea.ssmu.api.model.jpa.dto.drivers.DriverDTO;
import co.udea.ssmu.api.model.jpa.mapper.drivers.DriverMapper;

import co.udea.ssmu.api.services.drivers.service.DriverService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class DriverFacade {

    private final DriverService driverService;
    private final DriverMapper driverMapper;

    public DriverFacade(DriverService driverService, DriverMapper driverMapper) {
        this.driverService = driverService;
        this.driverMapper = driverMapper;
    }

    public DriverDTO save(DriverDTO Driver) {
        return driverMapper.toDto(driverService.save(driverMapper.toEntity(Driver)));
    }

    public List<DriverDTO> findByAll() {
        return driverMapper.toDto(driverService.findByAll());
    }

    public DriverDTO findByCedula(String cedula){
        return driverMapper.toDto(driverService.findByCedula(cedula));
    }

    public Page<DriverDTO> getWithPage(Pageable pageable) {
        return driverService.getWithPage(pageable).map(driverMapper::toDto);
    }

    public DriverDTO update(DriverDTO Driver) {
        return driverMapper.toDto(driverService.update(driverMapper.toEntity(Driver)));
    }

    public void delete(String cedula) {
        driverService.delete(cedula);
    }

    public DriverDTO saveDriver(DriverDTO driverNew) {
        // Para utilizar los 2 servicios, pero si se deja en el objeto driver y se guarda se guardan los 2 objetos
        return driverMapper.toDto(driverService.save(driverMapper.toEntity(driverNew)));
    }

}
