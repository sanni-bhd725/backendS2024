package FinalProject.SleepTracker.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import FinalProject.SleepTracker.domain.AppUser;
import FinalProject.SleepTracker.domain.AppUserRepository;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    AppUserRepository auRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser currUser = auRepository.findByUsername(username);
        UserDetails user = new org.springframework.security.core.userdetails.User(username, currUser.getPasswordHash(),
                AuthorityUtils.createAuthorityList(currUser.getRole()));
        return user;
    }
}
