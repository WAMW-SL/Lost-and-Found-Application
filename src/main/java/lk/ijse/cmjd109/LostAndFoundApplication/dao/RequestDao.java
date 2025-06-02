package lk.ijse.cmjd109.LostAndFoundApplication.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import lk.ijse.cmjd109.LostAndFoundApplication.dto.RequestStatus;
import lk.ijse.cmjd109.LostAndFoundApplication.entities.RequestEntity;

@Repository
public interface RequestDao extends JpaRepository<RequestEntity,String> {
    
    @Query("SELECT r FROM RequestEntity r WHERE r.status=:status")
    List<RequestEntity> getAllRequestsOfSelectedGroup(RequestStatus status);
}
