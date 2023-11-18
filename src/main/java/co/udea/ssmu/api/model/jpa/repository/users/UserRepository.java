package co.udea.ssmu.api.model.jpa.repository.users;

import co.udea.ssmu.api.model.jpa.model.users.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findByNroDocumento(String nroDocumento);
    void deleteByNroDocumento(String nroDocumento);
}
