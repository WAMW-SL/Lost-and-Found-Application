package lk.ijse.cmjd109.LostAndFoundApplication.service;

import java.util.List;

import lk.ijse.cmjd109.LostAndFoundApplication.dto.ItemDto;
import lk.ijse.cmjd109.LostAndFoundApplication.dto.ItemStatus;

public interface ItemService {
    public void addReport(ItemDto itemDto);
    public void updateReport(ItemDto itemDto);
    public void deleteReport(String reportId);
    public ItemDto getSelectedItem(String reportId);
    public List<ItemDto> getAllItemsOfSelectedGroup(ItemStatus itemStatus);
    public List<ItemDto> getAllReports();
}
