package ru.javamentor.predProject9_rest_server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.javamentor.predProject9_rest_server.domain.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
