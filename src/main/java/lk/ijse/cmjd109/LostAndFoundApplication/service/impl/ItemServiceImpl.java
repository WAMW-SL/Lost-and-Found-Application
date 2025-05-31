package lk.ijse.cmjd109.LostAndFoundApplication.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import lk.ijse.cmjd109.LostAndFoundApplication.dao.ItemDao;
import lk.ijse.cmjd109.LostAndFoundApplication.dto.ItemDto;
import lk.ijse.cmjd109.LostAndFoundApplication.dto.ItemStatus;
import lk.ijse.cmjd109.LostAndFoundApplication.service.ItemService;
import lk.ijse.cmjd109.LostAndFoundApplication.util.EntityDtoConversion;
import lk.ijse.cmjd109.LostAndFoundApplication.util.UtilityData;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ItemServiceImpl implements ItemService{

    private final ItemDao itemDao;
    private final EntityDtoConversion entityDtoConversion;

    @Override
    public void addReport(ItemDto itemDto) {
            itemDto.setReportId(UtilityData.generateReportId());  
            itemDao.save(entityDtoConversion.toItemEntity(itemDto));
    }

    @Override
    public void updateReport(ItemDto itemDto) {
      
    }

    @Override
    public void deleteReport(String reportId) {
        
    }

    @Override
    public ItemDto getSelectedItem(String reportId) {
        return null;
    }

    @Override
    public List<ItemDto> getAllItemsOfSelectedGroup(ItemStatus itemStatus) {
       return null;
    }
    
}
