package br.com.victorhugolgr.ead.authuser.repository;

import br.com.victorhugolgr.ead.authuser.models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<UserModel, UUID> {
}
