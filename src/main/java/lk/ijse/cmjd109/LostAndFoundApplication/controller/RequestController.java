package lk.ijse.cmjd109.LostAndFoundApplication.controller;

import java.util.List;

import org.springframework.data.repository.query.Param;
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
import org.springframework.web.bind.annotation.RestController;

import lk.ijse.cmjd109.LostAndFoundApplication.dto.RequestDto;
import lk.ijse.cmjd109.LostAndFoundApplication.dto.RequestStatus;
import lk.ijse.cmjd109.LostAndFoundApplication.exception.RequestNotFoundException;
import lk.ijse.cmjd109.LostAndFoundApplication.service.RequestService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/request")
@RequiredArgsConstructor
public class RequestController {

    private final RequestService requestService;
    
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> addRequest(@RequestBody RequestDto requestDto){
        try {
           requestService.addRequest(requestDto);
           return ResponseEntity.status(HttpStatus.CREATED).build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PatchMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> updateRequest(@RequestBody RequestDto requestDto){
        try {
            requestService.updateRequest(requestDto);
            return ResponseEntity.status(HttpStatus.OK).build();
        } catch (RequestNotFoundException e) {
           e.printStackTrace();
           return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }catch(Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/{requestId}")
    public ResponseEntity<Void> deleteRequest(@PathVariable String requestId){
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<RequestDto> getSelectedRequest(@Param ("requestId") String requestId){
        return ResponseEntity.ok().build();
    }

    @GetMapping(value="/getAll/{requestStatus}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<RequestDto>> getAllRequestsOfSelectedGroup(@PathVariable RequestStatus requestStatus){
        return ResponseEntity.ok().build();
    }
}
