package com.alvaro.users.service;

import com.alvaro.users.model.User;
import com.alvaro.users.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public User getUserById(Long id){
        return userRepository.findById(id).orElseThrow(() -> new RuntimeException("[!] Usuario no encontrado"));

    }

    public User createUser(User user){
        if (userRepository.findByEmail(user.getEmail()).isPresent()) {
            throw new IllegalArgumentException("[!] El email ya está registrado.");
        }
        return userRepository.save(user);
    }

    public User updateUser(Long id, User user) {
        User existingUser = getUserById(id);
        existingUser.setName(user.getName());
        existingUser.setEmail(user.getEmail());
        existingUser.setAge(user.getAge());
        return userRepository.save(existingUser);
    }


    public void deleteUser(Long id){
        if(!userRepository.existsById(id)){
            throw new RuntimeException("[!] Error al eliminar el usuario");
        }
        userRepository.deleteById(id);
    }
}
