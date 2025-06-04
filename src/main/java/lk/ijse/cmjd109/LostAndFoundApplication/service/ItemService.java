package lk.ijse.cmjd109.LostAndFoundApplication.service;

import java.util.List;

import lk.ijse.cmjd109.LostAndFoundApplication.dto.ItemDto;
import lk.ijse.cmjd109.LostAndFoundApplication.dto.ItemStatus;

public interface ItemService {
    void addReport(ItemDto itemDto);
    void updateReport(ItemDto itemDto);
    void deleteReport(String reportId);
    ItemDto getSelectedItem(String reportId);
    List<ItemDto> getAllItemsOfSelectedGroup(ItemStatus itemStatus);
    List<ItemDto> getAllReports();
}
