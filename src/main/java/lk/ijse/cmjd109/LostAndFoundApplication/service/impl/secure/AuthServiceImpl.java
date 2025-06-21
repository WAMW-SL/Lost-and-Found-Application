package lk.ijse.cmjd109.LostAndFoundApplication.service.impl.secure;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import lk.ijse.cmjd109.LostAndFoundApplication.dao.UserDao;
import lk.ijse.cmjd109.LostAndFoundApplication.dto.UserDto;
import lk.ijse.cmjd109.LostAndFoundApplication.dto.secure.JWTResponse;
import lk.ijse.cmjd109.LostAndFoundApplication.secureConfig.JWTUtils;
import lk.ijse.cmjd109.LostAndFoundApplication.service.secure.AuthService;
import lk.ijse.cmjd109.LostAndFoundApplication.util.EntityDtoConversion;
import lk.ijse.cmjd109.LostAndFoundApplication.util.UtilityData;
import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
private final UserDao userDao;
    private final JWTUtils jwtUtils;
    private final EntityDtoConversion entityDTOConversion;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    @Override
    public JWTResponse SignIn(lk.ijse.cmjd109.LostAndFoundApplication.dto.secure.SignIn signIn) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(signIn.getEmail(), signIn.getPassword()));
        var signInUser = userDao.findByEmail(signIn.getEmail()).orElseThrow(() -> new UsernameNotFoundException("User not found"));
        var generateToken = jwtUtils.generateToken(signInUser.getEmail(), signInUser.getAuthorities());
        return JWTResponse.builder().token(generateToken).build();
    }

    @Override
    public JWTResponse SignUp(UserDto userDto) {
        userDto.setUserId(UtilityData.generateUserId());
       userDto.setPassword(passwordEncoder.encode(userDto.getPassword()));
       var savedUser =
               userDao.save(entityDTOConversion.toUserEntity(userDto));
        var generatedToken = jwtUtils.generateToken(savedUser.getEmail(), savedUser.getAuthorities());
        return JWTResponse.builder().token(generatedToken).build();
    }
    
}
