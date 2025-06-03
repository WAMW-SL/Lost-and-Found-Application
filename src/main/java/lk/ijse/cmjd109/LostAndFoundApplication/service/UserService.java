package lk.ijse.cmjd109.LostAndFoundApplication.service;

import java.util.List;

import lk.ijse.cmjd109.LostAndFoundApplication.dto.UserDto;
import lk.ijse.cmjd109.LostAndFoundApplication.dto.UserRole;

public interface UserService {
    void addUser(UserDto userDto);
    void updateUser(UserDto userDto);
    void deleteUser(String userId);
    UserDto getSelectedUser(String userId);
    List<UserDto> getAllUsersOfSelectedGroup(UserRole role);
}
