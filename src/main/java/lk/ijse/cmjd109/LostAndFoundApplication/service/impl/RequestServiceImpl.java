package lk.ijse.cmjd109.LostAndFoundApplication.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import lk.ijse.cmjd109.LostAndFoundApplication.dto.RequestDto;
import lk.ijse.cmjd109.LostAndFoundApplication.dto.RequestStatus;
import lk.ijse.cmjd109.LostAndFoundApplication.service.RequestService;

@Service
public class RequestServiceImpl implements RequestService{

    @Override
    public void addRequest(RequestDto requestDto) {

    }

    @Override
    public void updateRequest(RequestDto requestDto) {

    }

    @Override
    public void deleteRequest(String requestId) {

    }

    @Override
    public RequestDto getSelectedRequest(String requestId) {
        return null;
    }

    @Override
    public List<RequestDto> getAllRequestsOfSelectedGroup(RequestStatus requestStatus) {
        return null;
    }
    
}
