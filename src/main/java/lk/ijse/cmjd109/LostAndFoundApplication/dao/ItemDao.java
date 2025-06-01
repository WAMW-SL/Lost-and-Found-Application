package lk.ijse.cmjd109.LostAndFoundApplication.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import lk.ijse.cmjd109.LostAndFoundApplication.dto.ItemStatus;
import lk.ijse.cmjd109.LostAndFoundApplication.entities.ItemEntity;

@Repository
public interface ItemDao extends JpaRepository<ItemEntity,String> {
    @Query("SELECT i FROM ItemEntity i WHERE i.status= :itemStatus")
    List<ItemEntity> getAllItemsOfSelectedGroup(@Param("itemStatus") ItemStatus itemStatus);
}
