package com.dam2.project.amazin.auth;

import com.dam2.project.amazin.model.User;
import com.dam2.project.amazin.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Autowired
    public MyUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("Username "+username+" not found"));
//        return org.springframework.security.core.userdetails.User
//                .withUsername(user.getUsername())
//                .password(user.getPassword())
//                .authorities(user.getRole())
//               /* .accountExpired(!user.isAccountNonExpired())
//                .accountLocked(!user.isAccountNonLocked())
//                .credentialsExpired(!user.isCredentialsNonExpired())
//                .disabled(!user.isEnabled())*/
//                .build();
        return new MyUserDetails(user);

    }
}
