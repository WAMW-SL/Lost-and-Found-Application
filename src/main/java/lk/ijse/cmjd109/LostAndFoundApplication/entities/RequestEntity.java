package lk.ijse.cmjd109.LostAndFoundApplication.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lk.ijse.cmjd109.LostAndFoundApplication.dto.RequestStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name="Request")
public class RequestEntity {
    @Id
    private String requestId;
    private String fullDescription;
    private RequestStatus status;
    private String userId;
}
