package com.evertri.ecrf.service;

import com.evertri.ecrf.model.User;
import com.evertri.ecrf.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    /**
     * Method to find all users
     * @return List of users
     */
    public List<User> findAll() {
        return userRepository.findAll();
    }

    public void delete(Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("User not found with id: " + id));
        userRepository.delete(user);
    }

    /**
     * Method to create a new user
     * @param user user object
     * @return created user object
     */
    public User create(User user) {
        return userRepository.save(user);
    }

    /**
     * Method to save a user
     * @param user user object
     * @return saved user object
     */
    public User save(User user) {
        return userRepository.save(user);
    }

    /**
     * Method to find a user by its id
     *
     * @param id user id
     * @return user object
     */
    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    /**
     * Method to delete a user by its id
     * @param id user id
     */
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }

    /**
     * Method to update a user
     * @param id user id
     * @param user updated user object
     * @return updated user object
     */
    public User update(Long id, User user) {
        User existingUser = userRepository.findById(id).orElse(null);
        if (existingUser == null) {
            return null;
        }
        user.setId(id);
        return userRepository.save(user);
    }
}
