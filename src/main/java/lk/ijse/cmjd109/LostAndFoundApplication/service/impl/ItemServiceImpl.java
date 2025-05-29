package lk.ijse.cmjd109.LostAndFoundApplication.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import lk.ijse.cmjd109.LostAndFoundApplication.dto.ItemDto;
import lk.ijse.cmjd109.LostAndFoundApplication.dto.ItemStatus;
import lk.ijse.cmjd109.LostAndFoundApplication.service.ItemService;

@Service
public class ItemServiceImpl implements ItemService{

    @Override
    public void addReport(ItemDto itemDto) {  
                     
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
