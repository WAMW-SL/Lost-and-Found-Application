package lk.ijse.cmjd109.LostAndFoundApplication.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class RequestDto {
    private String requestId;
    private String fullDescription;
    private RequestStatus requestStatus;
    private String userId;
}
