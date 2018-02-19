package me.travisgray.Service;


import me.travisgray.Models.User;
import me.travisgray.Repositories.RoleRepository;
import me.travisgray.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public Long countByEmail(String email) {
        return userRepository.countByEmail(email);
    }

    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

//    Create method to save as Admin or User with The new user model can also save new user role within Data Loader

    public void saveUser(User user) {
        user.setRoles(Arrays.asList(roleRepository.findByRole("USER")));
        user.setEnabled(true);
        userRepository.save(user);
    }

    public void saveAdmin(User user) {
        user.setRoles(Arrays.asList(roleRepository.findByRole("ADMIN")));
        user.setEnabled(true);
        userRepository.save(user);
    }


    public void saveEmployer(User user){

        user.setRoles(Arrays.asList(roleRepository.findByRole("Employer")));
        user.setEnabled(true);
        userRepository.save(user);
    }

    public void saveApplicant(User user){

        user.setRoles(Arrays.asList(roleRepository.findByRole("Applicant")));
        user.setEnabled(true);
        userRepository.save(user);
    }


}