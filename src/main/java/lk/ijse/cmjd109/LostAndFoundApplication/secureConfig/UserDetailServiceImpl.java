package lk.ijse.cmjd109.LostAndFoundApplication.secureConfig;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import lk.ijse.cmjd109.LostAndFoundApplication.dao.UserDao;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserDetailServiceImpl implements UserDetailsService{
     private final UserDao userDao;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
return userDao.findByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));    }
    
}
