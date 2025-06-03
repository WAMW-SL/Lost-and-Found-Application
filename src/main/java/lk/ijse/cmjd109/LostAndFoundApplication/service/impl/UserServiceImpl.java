package lk.ijse.cmjd109.LostAndFoundApplication.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import lk.ijse.cmjd109.LostAndFoundApplication.dto.UserDto;
import lk.ijse.cmjd109.LostAndFoundApplication.dto.UserRole;
import lk.ijse.cmjd109.LostAndFoundApplication.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Override
    public void addUser(UserDto userDto) {
        
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
