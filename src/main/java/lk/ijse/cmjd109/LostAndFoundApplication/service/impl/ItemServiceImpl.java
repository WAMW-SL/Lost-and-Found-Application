package lk.ijse.cmjd109.LostAndFoundApplication.service.impl;

import java.lang.foreign.Linker.Option;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import lk.ijse.cmjd109.LostAndFoundApplication.dao.ItemDao;
import lk.ijse.cmjd109.LostAndFoundApplication.dto.ItemDto;
import lk.ijse.cmjd109.LostAndFoundApplication.dto.ItemStatus;
import lk.ijse.cmjd109.LostAndFoundApplication.entities.ItemEntity;
import lk.ijse.cmjd109.LostAndFoundApplication.exception.ReportNotFoundException;
import lk.ijse.cmjd109.LostAndFoundApplication.service.ItemService;
import lk.ijse.cmjd109.LostAndFoundApplication.util.EntityDtoConversion;
import lk.ijse.cmjd109.LostAndFoundApplication.util.UtilityData;
import lombok.RequiredArgsConstructor;

@Transactional
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
      Optional<ItemEntity> foundReport=itemDao.findById(itemDto.getReportId());
      if(!foundReport.isPresent()){
        throw new ReportNotFoundException("Report not found");
      }
      foundReport.get().setItemName(itemDto.getItemName());
      foundReport.get().setCategory(itemDto.getCategory());
      foundReport.get().setDescription(itemDto.getDescription());
      foundReport.get().setBrand(itemDto.getBrand());
      foundReport.get().setColour(itemDto.getColour());
      foundReport.get().setFoundDate(itemDto.getFoundDate());
      foundReport.get().setLastSeenDate(itemDto.getLastSeenDate());
      foundReport.get().setFoundLocation(itemDto.getFoundLocation());
      foundReport.get().setLastSeenLocation(itemDto.getLastSeenLocation());
      foundReport.get().setStatus(itemDto.getItemStatus());
      foundReport.get().setPrivateDetails(itemDto.getPrivateDetails());
    }

    @Override
    public void deleteReport(String reportId) {
        Optional<ItemEntity> foundReport=itemDao.findById(reportId);
        if(!foundReport.isPresent()){
          throw new ReportNotFoundException("Report not found");
        }
        itemDao.deleteById(reportId);
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
