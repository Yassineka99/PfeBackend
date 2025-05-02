package com.example.process.management.Mapper;

import com.example.process.management.Dto.UserDto;
import com.example.process.management.Model.User;


public class UserMapper {
    // Example method to convert Client to UserDto
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
        return UserDto;
    }

    // Example method to convert UserDto to Client
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
        return client;
    }
}
