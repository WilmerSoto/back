package co.udea.ssmu.api.model.jpa.repository.groups;

import co.udea.ssmu.api.model.jpa.model.groups.Group;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroupRepository extends JpaRepository<Group, Integer> {
}
