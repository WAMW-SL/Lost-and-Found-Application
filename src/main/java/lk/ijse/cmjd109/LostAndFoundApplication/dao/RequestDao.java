package lk.ijse.cmjd109.LostAndFoundApplication.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import lk.ijse.cmjd109.LostAndFoundApplication.entities.RequestEntity;

@Repository
public interface RequestDao extends JpaRepository<RequestEntity,String> {
    
}
