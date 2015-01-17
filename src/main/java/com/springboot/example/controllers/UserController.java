package com.springboot.example.controllers;

import com.springboot.example.domain.User;
import com.springboot.example.domain.UserRepository;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {
    private static Log LOGGER = LogFactory.getLog(UserController.class);

    @Autowired
    private UserRepository repository;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public @ResponseBody User getUser(@PathVariable final String id) {
        final User user = repository.findOne(id);
        return user;
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public Map<String, String> addUser(@RequestBody @Valid final User user) {
        repository.save(user);
        return new HashMap<String, String>() {{
            put("id", user.getId());
        }};
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteUser(@PathVariable final String id) {
        repository.delete(id);
    }
}