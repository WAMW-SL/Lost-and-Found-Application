package lk.ijse.cmjd109.LostAndFoundApplication.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
public class UserEntity implements Serializable,UserDetails{
    @Id
    private String userId;
    private String userName;
    private String email;
    private String password;
    @Enumerated(EnumType.STRING)
    private UserRole role;
    @OneToMany(mappedBy = "user",cascade=CascadeType.ALL,orphanRemoval = true)
    private List<ItemEntity> items;
    @OneToMany(mappedBy="user",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<RequestEntity> requests;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
       return List.of(new SimpleGrantedAuthority("ROLE_"+role.name()));
    }

    @Override
    public String getUsername() {
        return email;
    }
}
