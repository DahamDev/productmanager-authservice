package com.productmanager.authenticator.service;

import com.productmanager.authenticator.entitiy.UserEntitiy;
import com.productmanager.authenticator.entitiy.dto.UserDto;
import com.productmanager.authenticator.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class JwtUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntitiy user = userRepository.findByUsername(username);
        return new User(user.getUsername(), user.getPassword(),
                   new ArrayList<>());
    }

    public UserDto saveUser(UserDto userDto){
        UserEntitiy user = new UserEntitiy();
        UserEntitiy existinguser = userRepository.findByUsername(userDto.getUsername());
        if(existinguser!=null){
            throw new NullPointerException();
        }
        user.setUsername(userDto.getUsername());
        user.setPassword(new BCryptPasswordEncoder().encode(userDto.getPassword()));
        userRepository.save(user);
        return userDto;
    }
}