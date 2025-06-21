package lk.ijse.cmjd109.LostAndFoundApplication.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserDto implements Serializable{
    private String userId;
    private String userName;
    private String email;
    private String password;
    private UserRole role;
}
