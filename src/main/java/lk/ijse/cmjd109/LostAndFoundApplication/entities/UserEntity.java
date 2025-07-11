package lk.ijse.cmjd109.LostAndFoundApplication.entities;

import java.util.List;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lk.ijse.cmjd109.LostAndFoundApplication.dto.UserRole;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name="User")
public class UserEntity{
    @Id
    private String userId;
    private String userName;
    private UserRole role;
    @OneToMany(mappedBy = "user",cascade=CascadeType.ALL,orphanRemoval = true)
    private List<ItemEntity> items;
    @OneToMany(mappedBy="user",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<RequestEntity> requests;
}
