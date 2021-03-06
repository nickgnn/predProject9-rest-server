package ru.javamentor.predProject9_rest_server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.javamentor.predProject9_rest_server.domain.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String name);
}
