package co.udea.ssmu.api.model.jpa.mapper.userTypes;

import co.udea.ssmu.api.model.jpa.dto.userTypes.UserTypeDTO;
import co.udea.ssmu.api.model.jpa.mapper.EntityMapper;
import co.udea.ssmu.api.model.jpa.model.userTypes.UserType;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserTypeMapper extends EntityMapper<UserTypeDTO, UserType> {
}
