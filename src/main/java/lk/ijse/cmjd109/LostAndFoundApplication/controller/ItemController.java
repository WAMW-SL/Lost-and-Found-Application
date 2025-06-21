package lk.ijse.cmjd109.LostAndFoundApplication.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lk.ijse.cmjd109.LostAndFoundApplication.dto.ItemDto;
import lk.ijse.cmjd109.LostAndFoundApplication.dto.ItemStatus;
import lk.ijse.cmjd109.LostAndFoundApplication.exception.ItemNotFoundException;
import lk.ijse.cmjd109.LostAndFoundApplication.exception.ReportNotFoundException;
import lk.ijse.cmjd109.LostAndFoundApplication.service.ItemService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/item")
public class ItemController {

    private final ItemService itemService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ItemDto> addReport(@RequestBody ItemDto itemDto) {
        try {;
            return new ResponseEntity<ItemDto>(itemService.addReport(itemDto), HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PatchMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> updateReport(@RequestBody ItemDto itemDto) {
        try {
            itemService.updateReport(itemDto);
            return ResponseEntity.ok().build();
        } catch (ReportNotFoundException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/{reportId}")
    public ResponseEntity<Void> deleteReport(@PathVariable String reportId) {
        try {
            itemService.deleteReport(reportId);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } catch (ReportNotFoundException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ItemDto> getSelectedItem(@RequestParam("reportId") String reportId) {
        try {
            return new ResponseEntity<ItemDto>(itemService.getSelectedItem(reportId), HttpStatus.OK);
        } catch (ItemNotFoundException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping(value="/getAll",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ItemDto>> getAllItemsOfSelectedGroup(@RequestParam("itemStatus") ItemStatus itemStatus) {
        try {
            return new ResponseEntity<List<ItemDto>>(itemService.getAllItemsOfSelectedGroup(itemStatus), HttpStatus.OK);
        }catch(Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/getAllReports")
    public ResponseEntity<List<ItemDto>> getAllReports(){
        try {
            System.out.println(itemService.getAllReports());
            return new ResponseEntity<List<ItemDto>>(itemService.getAllReports(), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

}
