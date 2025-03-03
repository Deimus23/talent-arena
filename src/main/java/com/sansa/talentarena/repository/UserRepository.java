package com.sansa.talentarena.repository;

import com.sansa.talentarena.model.entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends CrudRepository<User, UUID> {

    Optional<User> findByDni(String dni);
}
