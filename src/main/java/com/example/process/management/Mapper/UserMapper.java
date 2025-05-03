package com.example.process.management.Mapper;

import com.example.process.management.Dto.UserDto;
import com.example.process.management.Model.User;


public class UserMapper {
 
    public UserDto clientToUserDto(User client) {
        if (client == null) {
            return null;
        }
        UserDto UserDto = new UserDto();
        UserDto.setId(client.getId());
        UserDto.setName(client.getName());
        UserDto.setEmail(client.getEmail());
        UserDto.setPhone(client.getPhone());
        UserDto.setRole(client.getRole());
        UserDto.setPassword(client.getPassword());
        UserDto.setImage(client.getImage());
        UserDto.setImageType(client.getImageType());
        return UserDto;
    }

   
    public User UserDtoToClient(UserDto UserDto) {
        if (UserDto == null) {
            return null;
        }
        User client = new User();
        client.setId(UserDto.getId());
        client.setName(UserDto.getName());
        client.setEmail(UserDto.getEmail());
        client.setPhone(UserDto.getPhone());
        client.setRole(UserDto.getRole());
        client.setPassword(UserDto.getPassword());
        client.setImage(UserDto.getImage());
        client.setImageType(UserDto.getImageType());
        return client;
    }
}
