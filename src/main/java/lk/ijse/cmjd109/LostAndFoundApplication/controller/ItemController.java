package lk.ijse.cmjd109.LostAndFoundApplication.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lk.ijse.cmjd109.LostAndFoundApplication.dto.ItemDto;

@RestController
@RequestMapping("/api/v1/item")
public class ItemController {
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> addReport(@RequestBody ItemDto itemDto){
        return ResponseEntity.ok().build();
    }

    @PatchMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> updateReport(@RequestBody ItemDto itemDto){
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{reportId}")
    public ResponseEntity<Void> deleteReport(@PathVariable String reportId){
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<ItemDto> getLostItems(){
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<ItemDto> getFoundItems(){
        return ResponseEntity.ok().build();
    }
}
