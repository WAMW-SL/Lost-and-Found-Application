package lk.ijse.cmjd109.LostAndFoundApplication.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import lk.ijse.cmjd109.LostAndFoundApplication.dao.UserDao;
import lk.ijse.cmjd109.LostAndFoundApplication.dto.UserDto;
import lk.ijse.cmjd109.LostAndFoundApplication.dto.UserRole;
import lk.ijse.cmjd109.LostAndFoundApplication.entities.UserEntity;
import lk.ijse.cmjd109.LostAndFoundApplication.exception.UserNotFoundException;
import lk.ijse.cmjd109.LostAndFoundApplication.service.UserService;
import lk.ijse.cmjd109.LostAndFoundApplication.util.EntityDtoConversion;
import lk.ijse.cmjd109.LostAndFoundApplication.util.UtilityData;
import lombok.RequiredArgsConstructor;

@Transactional
@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final EntityDtoConversion entityDtoConversion;
    private final UserDao userDao;

    @Override
    public UserDto addUser(UserDto userDto) {
        userDto.setUserId(UtilityData.generateUserId());
        return entityDtoConversion.toUserDto(userDao.save(entityDtoConversion.toUserEntity(userDto)));
    }

    @Override
    public void updateUser(UserDto userDto) {
        Optional<UserEntity> foundUser=userDao.findById(userDto.getUserId());
        if(!foundUser.isPresent()){
            throw new UserNotFoundException("User not found");
        }
        foundUser.get().setUserName(userDto.getUserName());
        foundUser.get().setRole(userDto.getRole());
    }

    @Override
    public void deleteUser(String userId) {
        Optional<UserEntity> foundUser=userDao.findById(userId);
        if(!foundUser.isPresent()){
            throw new UserNotFoundException("User not found");
        }
        userDao.deleteById(userId);
    }

    @Override
    public UserDto getSelectedUser(String userId) {
        Optional<UserEntity> foundUser=userDao.findById(userId);
        if(!foundUser.isPresent()){
            throw new UserNotFoundException("User not found");
        }
        return entityDtoConversion.toUserDto(userDao.getReferenceById(userId));
    }

    @Override
    public List<UserDto> getAllUsersOfSelectedGroup(UserRole role) {
        return entityDtoConversion.toUserDtoList(userDao.getAllUsersOfSelectedGroup(role));
    }

    @Override
    public List<UserDto> getAllUsers() {
        return entityDtoConversion.toUserDtoList(userDao.findAll());
    }

    
}
