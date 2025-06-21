package lk.ijse.cmjd109.LostAndFoundApplication.service.impl.secure;

import org.springframework.stereotype.Service;

import lk.ijse.cmjd109.LostAndFoundApplication.dto.UserDto;
import lk.ijse.cmjd109.LostAndFoundApplication.dto.secure.JWTResponse;
import lk.ijse.cmjd109.LostAndFoundApplication.service.secure.AuthService;

@Service
public class AuthServiceImpl implements AuthService {

    @Override
    public JWTResponse SignIn(lk.ijse.cmjd109.LostAndFoundApplication.dto.secure.SignIn signIn) {
        return null;
    }

    @Override
    public JWTResponse SignUp(UserDto userDtO) {
       return null;
    }
    
}
