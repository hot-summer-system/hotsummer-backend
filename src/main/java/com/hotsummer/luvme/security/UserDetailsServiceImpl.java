package com.hotsummer.luvme.security;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.hotsummer.luvme.model.entity.UserTbl;
import com.hotsummer.luvme.service.User.UserService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {
    private final UserService userService;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UserTbl userTbl = userService.getUserByEmail(email);
        Collection<? extends GrantedAuthority> authorities = List
                .of(new SimpleGrantedAuthority(userTbl.getRole().getRoleName()));
        return new UserDetailsImpl(userTbl, authorities);
    }
}
