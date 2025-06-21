package lk.ijse.cmjd109.LostAndFoundApplication.dto.secure;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SignIn implements Serializable{
    private String email;
    private String password;
}
