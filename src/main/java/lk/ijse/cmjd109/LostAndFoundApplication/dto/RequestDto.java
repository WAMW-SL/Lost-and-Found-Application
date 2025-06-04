package lk.ijse.cmjd109.LostAndFoundApplication.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class RequestDto implements Serializable {
    private String requestId;
    private String fullDescription;
    private RequestStatus requestStatus;
    private String userId;
}
