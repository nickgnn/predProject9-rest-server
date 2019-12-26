package ru.javamentor.predProject9_rest_server.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.javamentor.predProject9_rest_server.domain.User;
import ru.javamentor.predProject9_rest_server.exception.DBException;
import ru.javamentor.predProject9_rest_server.repository.UserRepository;
import ru.javamentor.predProject9_rest_server.service.UserService;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getAllUsers() throws DBException {
        return userRepository.findAll();
    }

    @Override
    public User getUserByName(String name) throws DBException {
        return userRepository.findByUsername(name).get();
    }

    @Override
    public User getUserById(Long id) throws DBException {
        return null;
    }

    @Override
    public Long getUserIdByName(String name) throws DBException {
        return null;
    }

    @Override
    public User addUser(User user) throws DBException {
        Boolean existsUser = isExistsUser(user.getUsername());

        if (existsUser) {
            return null;
        }

        return userRepository.saveAndFlush(user);
    }

    @Override
    public User editUser(User user) throws DBException {
        return userRepository.saveAndFlush(user);
    }

    @Override
    public void deleteUser(User user) throws DBException {
        userRepository.delete(user);
    }

    @Override
    public Boolean isExistsUser(String name) throws DBException {
        User user;

        try {
            user = getUserByName(name);

            return user != null;
        } catch (NoSuchElementException e) {
            e.getMessage();

            return false;
        }
    }

//    @Override
//    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
//        return null;
//    }
}
