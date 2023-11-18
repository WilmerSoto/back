package co.udea.ssmu.api.model.jpa.repository.userTypes;

import co.udea.ssmu.api.model.jpa.model.userTypes.UserType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserTypeRepository extends JpaRepository<UserType, Integer> {
}
