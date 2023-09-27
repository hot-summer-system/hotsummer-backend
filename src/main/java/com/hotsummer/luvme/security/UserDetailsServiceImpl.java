package com.hotsummer.luvme.security;

import com.hotsummer.luvme.model.entity.UserTbl;
import com.hotsummer.luvme.repository.UserTblRepository;
import com.hotsummer.luvme.service.UserTblService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {
    private final UserTblRepository userTblRepository;
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UserTbl userTbl = userTblRepository.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException("User Not Found"));
        Collection<? extends GrantedAuthority> authorities =
                List.of(new SimpleGrantedAuthority(String.valueOf(userTbl.getRole().getRoleId())));
        return new UserDetailsImpl(userTbl, authorities);
    }
}
