package lk.ijse.cmjd109.LostAndFoundApplication.service;

import java.util.List;

import lk.ijse.cmjd109.LostAndFoundApplication.dto.RequestDto;
import lk.ijse.cmjd109.LostAndFoundApplication.dto.RequestStatus;

public interface RequestService {
    RequestDto addRequest(RequestDto requestDto);
    void updateRequest(RequestDto requestDto);
    void deleteRequest(String requestId);
    RequestDto getSelectedRequest(String requestId);
    List<RequestDto> getAllRequestsOfSelectedGroup(RequestStatus requestStatus);
    List<RequestDto> getAllRequests();
}
