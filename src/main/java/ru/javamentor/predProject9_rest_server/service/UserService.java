package ru.javamentor.predProject9_rest_server.service;

import ru.javamentor.predProject9_rest_server.domain.User;
import ru.javamentor.predProject9_rest_server.exception.DBException;

import java.util.List;

public interface UserService /*extends UserDetailsService*/ {
    List<User> getAllUsers() throws DBException;
    User getUserByName(String name) throws DBException;
    User getUserById(Long id) throws DBException;
    Long getUserIdByName(String name) throws DBException;
    User addUser(User user) throws DBException;
    User editUser(User user) throws DBException;
    void deleteUser(User user) throws DBException;
    Boolean isExistsUser(String name) throws DBException;
}
