package lk.ijse.cmjd109.LostAndFoundApplication.util;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Component;

import lk.ijse.cmjd109.LostAndFoundApplication.dto.ItemDto;
import lk.ijse.cmjd109.LostAndFoundApplication.dto.RequestDto;
import lk.ijse.cmjd109.LostAndFoundApplication.entities.ItemEntity;
import lk.ijse.cmjd109.LostAndFoundApplication.entities.RequestEntity;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class EntityDtoConversion {
    private final ModelMapper modelMapper;

    //Item
    public ItemEntity toItemEntity(ItemDto itemDto){
        return modelMapper.map(itemDto,ItemEntity.class);
    }
    public ItemDto toItemDto(ItemEntity itemEntity){
        return modelMapper.map(itemEntity,ItemDto.class);
    }
    public List<ItemDto> toItemDtoList(List<ItemEntity> itemEntities){
        return modelMapper.map(itemEntities,new TypeToken<List<ItemDto>>(){}.getType());
    }

    //Request
    public RequestEntity toRequestEntity(RequestDto requestDto){
        return modelMapper.map(requestDto,RequestEntity.class);
    }
    public RequestDto toRequestDto(RequestEntity requestEntity){
        return modelMapper.map(requestEntity,RequestDto.class);
    }
    public List<RequestDto> toRequestDtoList(List<RequestEntity> requestEntities){
        return modelMapper.map(requestEntities, new TypeToken<List<RequestDto>>(){}.getType());
    }
}
