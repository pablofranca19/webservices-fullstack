package com.pablofranca.webservicesmongo.services;

import com.pablofranca.webservicesmongo.domain.User;
import com.pablofranca.webservicesmongo.repositories.UserRepository;
import com.pablofranca.webservicesmongo.services.exception.IdNotFoundException;
import com.pablofranca.webservicesmongo.services.exception.ObjectNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

@Service
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> findAll () {
        return userRepository.findAll();
    }

    public User findById (String id) {
        Optional<User> obj = userRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("No user found with id " + id));
    }

    public User insert (User user) {
        return userRepository.save(user);
    }

    public void delete (String id) {
        findById(id);
        userRepository.deleteById(id);
    }

    public User update(User user) {
        User newUser = userRepository.findById(user.getId()).orElseThrow(() -> new ObjectNotFoundException("User not found: " + user.getId()));
        updateData(newUser, user);
        return userRepository.save(newUser);
    }

    public void updateData (User newUser, User user) {
        newUser.setName(user.getName());
        newUser.setEmail(user.getEmail());
    }



}
