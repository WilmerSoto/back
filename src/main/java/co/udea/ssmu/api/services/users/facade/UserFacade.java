package co.udea.ssmu.api.services.users.facade;

import co.udea.ssmu.api.model.jpa.dto.users.UserDTO;
import co.udea.ssmu.api.model.jpa.mapper.users.UserMapper;
import co.udea.ssmu.api.services.users.service.UserService;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class UserFacade {
    private final UserService userService;
    private final UserMapper userMapper;

    public UserFacade(UserService userService, UserMapper userMapper) {
        this.userService = userService;
        this.userMapper = userMapper;
    }

    public UserDTO save(UserDTO user) {
        return userMapper.toDto(userService.save(userMapper.toEntity(user)));
    }

    public List<UserDTO> findByAll() {
        return userMapper.toDto(userService.findByAll());
    }

    public UserDTO findByCedula(String cedula) {
        return userMapper.toDto(userService.findByNroDocumento(cedula));
    }

    public Page<UserDTO> getWithPage(Pageable pageable) {
        return userService.getWithPage(pageable).map(userMapper::toDto);
    }

    public UserDTO update(UserDTO user) {
        return userMapper.toDto(userService.update(userMapper.toEntity(user)));
    }

    public void delete(String cedula) {
        userService.delete(cedula);
    }

}
