package lk.ijse.cmjd109.LostAndFoundApplication.entities;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lk.ijse.cmjd109.LostAndFoundApplication.dto.ItemCategory;
import lk.ijse.cmjd109.LostAndFoundApplication.dto.ItemStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "Item")
public class ItemEntity {
    @Id
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
    private ItemStatus status;
}
