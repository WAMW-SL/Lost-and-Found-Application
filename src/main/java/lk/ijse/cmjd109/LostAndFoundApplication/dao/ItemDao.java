package lk.ijse.cmjd109.LostAndFoundApplication.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import lk.ijse.cmjd109.LostAndFoundApplication.entities.ItemEntity;

@Repository
public interface ItemDao extends JpaRepository<ItemEntity,String> {
    
}
