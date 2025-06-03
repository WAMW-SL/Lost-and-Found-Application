package lk.ijse.cmjd109.LostAndFoundApplication.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import lk.ijse.cmjd109.LostAndFoundApplication.dao.UserDao;
import lk.ijse.cmjd109.LostAndFoundApplication.dto.UserDto;
import lk.ijse.cmjd109.LostAndFoundApplication.dto.UserRole;
import lk.ijse.cmjd109.LostAndFoundApplication.service.UserService;
import lk.ijse.cmjd109.LostAndFoundApplication.util.EntityDtoConversion;
import lk.ijse.cmjd109.LostAndFoundApplication.util.UtilityData;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final EntityDtoConversion entityDtoConversion;
    private final UserDao userDao;

    @Override
    public void addUser(UserDto userDto) {
        userDto.setUserId(UtilityData.generateUserId());
        userDao.save(entityDtoConversion.toUserEntity(userDto));
    }

    @Override
    public void updateUser(UserDto userDto) {
           
    }

    @Override
    public void deleteUser(String userId) {
        
    }

    @Override
    public UserDto getSelectedUser(String userId) {
        return null;
    }

    @Override
    public List<UserDto> getAllUsersOfSelectedGroup(UserRole role) {
        return null;
    }

}
