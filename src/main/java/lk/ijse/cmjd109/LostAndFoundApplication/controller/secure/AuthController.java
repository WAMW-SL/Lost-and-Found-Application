package lk.ijse.cmjd109.LostAndFoundApplication.controller.secure;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lk.ijse.cmjd109.LostAndFoundApplication.dto.UserDto;
import lk.ijse.cmjd109.LostAndFoundApplication.dto.secure.JWTResponse;
import lk.ijse.cmjd109.LostAndFoundApplication.dto.secure.SignIn;
import lk.ijse.cmjd109.LostAndFoundApplication.service.secure.AuthService;
import lombok.RequiredArgsConstructor;

@RequestMapping("/api/v1/auth")
@RestController
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;
    @PostMapping("signin")
    public ResponseEntity<JWTResponse> signIn(@RequestBody SignIn signIn) {
        return new ResponseEntity<>(authService.SignIn(signIn), HttpStatus.OK);
    }
    @PostMapping("signup")
    public ResponseEntity<JWTResponse> signUp(@RequestBody UserDto userDTO) {
        return new ResponseEntity<>(authService.SignUp(userDTO), HttpStatus.OK);
    }
}
