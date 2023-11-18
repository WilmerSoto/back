package co.udea.ssmu.api.model.jpa.mapper.users;

import co.udea.ssmu.api.model.jpa.dto.users.UserDTO;
import co.udea.ssmu.api.model.jpa.mapper.EntityMapper;
import co.udea.ssmu.api.model.jpa.model.users.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper extends EntityMapper<UserDTO, User> {
}
