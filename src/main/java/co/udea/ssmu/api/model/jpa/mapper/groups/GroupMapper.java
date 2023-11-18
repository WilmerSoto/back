package co.udea.ssmu.api.model.jpa.mapper.groups;

import co.udea.ssmu.api.model.jpa.dto.groups.GroupDTO;
import co.udea.ssmu.api.model.jpa.mapper.EntityMapper;
import co.udea.ssmu.api.model.jpa.model.groups.Group;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface GroupMapper extends EntityMapper<GroupDTO, Group> {
}
