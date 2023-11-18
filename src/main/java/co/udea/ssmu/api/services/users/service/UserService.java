package co.udea.ssmu.api.services.users.service;

import co.udea.ssmu.api.model.jpa.model.users.User;
import co.udea.ssmu.api.model.jpa.repository.users.UserRepository;
import co.udea.ssmu.api.utils.common.Messages;
import co.udea.ssmu.api.utils.exception.BusinessException;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserService {
    private final UserRepository userRepository;
    private final Messages messages;

    public UserService(UserRepository userRepository, Messages messages) {
        this.userRepository = userRepository;
        this.messages = messages;
    }

    public User save(User user) {
        User userOptional = userRepository.findByNroDocumento(user.getNroDocumento());
        if (userOptional != null) {
            throw new BusinessException(String.format(messages.get("user.save.duplicate.document"), user.getNroDocumento()));
        }
        return userRepository.save(user);
    }

    public List<User> findByAll() {
        return userRepository.findAll();
    }

    public User findByNroDocumento(String nroDocumento){
        User userNroDocumento = userRepository.findByNroDocumento(nroDocumento);
        if (userNroDocumento == null) {
            throw new BusinessException(String.format(messages.get("user.find.nrodoc.error")));
        }
        return userNroDocumento;
    }

    public Page<User> getWithPage(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    public User update(User user) {
        Optional<User> userOptional = userRepository.findById(user.getIdUsuario());
        if (userOptional.isEmpty()) {
            throw new BusinessException(String.format(messages.get("user.update.does.not.exist")));
        }
        return userRepository.save(user);
    }

    public void delete(String nroDocumento) {
        User userNroDocumento = userRepository.findByNroDocumento(nroDocumento);
        if (userNroDocumento == null) {
            throw new BusinessException(String.format(messages.get("user.find.nrodoc.error")));
        }
        userRepository.deleteByNroDocumento(nroDocumento);
    }

}
