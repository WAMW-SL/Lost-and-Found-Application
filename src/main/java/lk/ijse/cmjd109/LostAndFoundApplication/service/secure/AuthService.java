package lk.ijse.cmjd109.LostAndFoundApplication.service.secure;

import lk.ijse.cmjd109.LostAndFoundApplication.dto.UserDto;
import lk.ijse.cmjd109.LostAndFoundApplication.dto.secure.JWTResponse;
import lk.ijse.cmjd109.LostAndFoundApplication.dto.secure.SignIn;

public interface AuthService {
    JWTResponse SignIn(SignIn signIn);
    JWTResponse SignUp(UserDto userDtO);
}
