package lk.ijse.cmjd109.LostAndFoundApplication.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import lk.ijse.cmjd109.LostAndFoundApplication.dto.UserRole;
import lk.ijse.cmjd109.LostAndFoundApplication.entities.UserEntity;

@Repository
public interface UserDao extends JpaRepository<UserEntity,String>{
    
    @Query("SELECT u FROM UserEntity u WHERE u.role=:role")
    List<UserEntity> getAllUsersOfSelectedGroup(UserRole role);
}
