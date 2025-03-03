package com.sansa.talentarena.service;

import com.sansa.talentarena.model.entity.User;
import com.sansa.talentarena.repository.UserRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class CustomUserDetailService implements UserDetailsService {
    private final UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> userOptional =  userRepository.findByEmail(username);
        return userOptional.orElseThrow( () -> new UsernameNotFoundException(username) );
    }
}
