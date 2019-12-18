package ru.javamentor.predProject9_rest_server.controllers;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.javamentor.predProject9_rest_server.domain.User;
import ru.javamentor.predProject9_rest_server.exception.DBException;
import ru.javamentor.predProject9_rest_server.service.UserService;

import java.util.List;

@RestController
@RequestMapping("admin")
public class AdminController {
    private final UserService userService;

    @Autowired
    public AdminController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> getAllUsers() throws DBException {
        List<User> users = userService.getAllUsers();

        return users;
    }

    @GetMapping("{id}")
    public User getOneUser(@PathVariable("id") User user) {
        return user;
    }

    @PostMapping
    public User createUser(@RequestBody User user) throws DBException {
        return userService.addUser(user);
    }

    @PutMapping("{id}")
    public User updateUser(@PathVariable("id") User userFromDB, @RequestBody User user) throws DBException {
        BeanUtils.copyProperties(user, userFromDB, "id");

        return userService.editUser(userFromDB);
    }

    @DeleteMapping("{id}")
    public void deleteUser(@PathVariable("id") User user) throws DBException {
        userService.deleteUser(user);
    }
}
