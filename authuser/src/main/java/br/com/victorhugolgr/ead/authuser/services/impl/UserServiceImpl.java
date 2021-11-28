package br.com.victorhugolgr.ead.authuser.services.impl;

import br.com.victorhugolgr.ead.authuser.repository.UserRepository;
import br.com.victorhugolgr.ead.authuser.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
}
