package lk.ijse.cmjd109.LostAndFoundApplication.dto.secure;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class JWTResponse implements Serializable{
    private String token;
}
