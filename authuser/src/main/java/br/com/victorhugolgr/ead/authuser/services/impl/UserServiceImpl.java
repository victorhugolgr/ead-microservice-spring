package br.com.victorhugolgr.ead.authuser.services.impl;

import br.com.victorhugolgr.ead.authuser.models.UserModel;
import br.com.victorhugolgr.ead.authuser.repository.UserRepository;
import br.com.victorhugolgr.ead.authuser.services.UserService;
import br.com.victorhugolgr.ead.authuser.specifications.SpecificationTemplate;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public Page<UserModel> findAll(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    @Override
    public Optional<UserModel> findById(UUID userId) {
        return userRepository.findById(userId);
    }

    @Override
    public void delete(UserModel userModel) {
        userRepository.delete(userModel);
    }

    @Override
    public void save(UserModel userModel) {
        userRepository.save(userModel);
    }

    @Override
    public boolean existsByUserName(String username) {
        return userRepository.existsByUsername(username);
    }

    @Override
    public boolean existsByEmail(String email) {
        return userRepository.existsByEmail(email);
    }

    @Override
    public Page<UserModel> findAll(SpecificationTemplate.UserSpec spec, Pageable pageable) {
        return userRepository.findAll(spec, pageable);
    }

}
