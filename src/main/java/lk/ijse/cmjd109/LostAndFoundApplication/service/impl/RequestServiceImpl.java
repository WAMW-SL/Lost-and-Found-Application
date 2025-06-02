package lk.ijse.cmjd109.LostAndFoundApplication.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import lk.ijse.cmjd109.LostAndFoundApplication.dao.RequestDao;
import lk.ijse.cmjd109.LostAndFoundApplication.dto.RequestDto;
import lk.ijse.cmjd109.LostAndFoundApplication.dto.RequestStatus;
import lk.ijse.cmjd109.LostAndFoundApplication.service.RequestService;
import lk.ijse.cmjd109.LostAndFoundApplication.util.EntityDtoConversion;
import lk.ijse.cmjd109.LostAndFoundApplication.util.UtilityData;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class RequestServiceImpl implements RequestService{

    private final EntityDtoConversion entityDtoConversion;
    private final RequestDao requestDao;

    @Override
    public void addRequest(RequestDto requestDto) {
        requestDto.setRequestId(UtilityData.generateRequestId());
        requestDao.save(entityDtoConversion.toRequestEntity(requestDto));
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
