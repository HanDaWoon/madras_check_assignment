package madras_check.admin.config;

import madras_check.admin.entity.MUser;
import madras_check.admin.service.MUserService;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MUserDetails implements UserDetailsService {

    private final MUserService mUserService;

    public MUserDetails(MUserService mUserService) {
        this.mUserService = mUserService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        String userName, password;
        List<GrantedAuthority> authorities;
        MUser mUser = mUserService.findByEmail(username);
        if (mUser == null) {
            throw new UsernameNotFoundException("User details not found for the user : " + username);
        } else{
            userName = mUser.getEmail();
            password = mUser.getPassword();
            authorities = new ArrayList<>();
            authorities.add(new SimpleGrantedAuthority(mUser.getRole()));
        }
        return new User(userName,password,authorities);
    }

}
