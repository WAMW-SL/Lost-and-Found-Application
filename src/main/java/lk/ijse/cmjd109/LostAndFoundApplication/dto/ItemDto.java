package lk.ijse.cmjd109.LostAndFoundApplication.dto;

import java.io.Serializable;
import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ItemDto implements Serializable {
    private String reportId;
    private String userId;
    private String itemName;
    private ItemCategory category;
    private String description;
    private String brand;
    private String colour;
    private LocalDate foundDate;
    private LocalDate lastSeenDate;
    private String foundLocation;
    private String lastSeenLocation;
    private String privateDetails;
    private ItemStatus itemStatus;
}
