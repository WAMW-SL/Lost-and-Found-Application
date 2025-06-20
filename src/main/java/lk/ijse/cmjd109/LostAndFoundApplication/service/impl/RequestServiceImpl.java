package lk.ijse.cmjd109.LostAndFoundApplication.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import lk.ijse.cmjd109.LostAndFoundApplication.dao.RequestDao;
import lk.ijse.cmjd109.LostAndFoundApplication.dto.RequestDto;
import lk.ijse.cmjd109.LostAndFoundApplication.dto.RequestStatus;
import lk.ijse.cmjd109.LostAndFoundApplication.entities.RequestEntity;
import lk.ijse.cmjd109.LostAndFoundApplication.exception.RequestNotFoundException;
import lk.ijse.cmjd109.LostAndFoundApplication.service.RequestService;
import lk.ijse.cmjd109.LostAndFoundApplication.util.EntityDtoConversion;
import lk.ijse.cmjd109.LostAndFoundApplication.util.UtilityData;
import lombok.RequiredArgsConstructor;

@Transactional
@RequiredArgsConstructor
@Service
public class RequestServiceImpl implements RequestService {

    private final EntityDtoConversion entityDtoConversion;
    private final RequestDao requestDao;

    @Override
    public RequestDto addRequest(RequestDto requestDto) {
        requestDto.setRequestId(UtilityData.generateRequestId());
        return entityDtoConversion.toRequestDto(requestDao.save(entityDtoConversion.toRequestEntity(requestDto)));
    }

    @Override
    public void updateRequest(RequestDto requestDto) {
        Optional<RequestEntity> foundRequest = requestDao.findById(requestDto.getRequestId());
        if (!foundRequest.isPresent()) {
            throw new RequestNotFoundException("Request not found");
        }
        foundRequest.get().setFullDescription(requestDto.getFullDescription());
        foundRequest.get().setStatus(requestDto.getRequestStatus());
    }

    @Override
    public void deleteRequest(String requestId) {
        Optional<RequestEntity> foundRequest = requestDao.findById(requestId);
        if (!foundRequest.isPresent()) {
            throw new RequestNotFoundException("Request not found");
        }
        requestDao.deleteById(requestId);
    }

    @Override
    public RequestDto getSelectedRequest(String requestId) {
        Optional<RequestEntity> foundRequest = requestDao.findById(requestId);
        if (!foundRequest.isPresent()) {
            throw new RequestNotFoundException("Request not found");
        }
        return entityDtoConversion.toRequestDto(requestDao.getReferenceById(requestId));
    }

    @Override
    public List<RequestDto> getAllRequestsOfSelectedGroup(RequestStatus requestStatus) {
       return entityDtoConversion.toRequestDtoList(requestDao.getAllRequestsOfSelectedGroup(requestStatus));
    }

}
