package br.com.victorhugolgr.ead.authuser.services;

import br.com.victorhugolgr.ead.authuser.models.UserModel;
import br.com.victorhugolgr.ead.authuser.specifications.SpecificationTemplate;
import org.apache.catalina.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserService {
    Page<UserModel> findAll(Pageable pageable);

    Optional<UserModel> findById(UUID userId);

    void delete(UserModel userModel);

    void save(UserModel userModel);

    boolean existsByUserName(String username);

    boolean existsByEmail(String email);

    Page<UserModel> findAll(SpecificationTemplate.UserSpec spec, Pageable pageable);
}
