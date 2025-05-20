package com.example.process.management.Mapper;

import java.io.IOException;

import com.example.process.management.Dto.ProductDto;
import com.example.process.management.Dto.UserDto;
import com.example.process.management.Model.Product;
import com.example.process.management.Model.User;

public class ProductMapper {
     public ProductDto ProductToProductDto(Product client) {
        if (client == null) {
            return null;
        }
        ProductDto UserDto = new ProductDto();
        UserDto.setId(client.getId());
        UserDto.setName(client.getName());
        UserDto.setModelFileName(client.getModelFileName());
        UserDto.setModelFileType(client.getModelFileType());
        UserDto.setStatus_id(client.getStatus_id());
        try {
            if (UserDto.getModelFile() != null && !UserDto.getModelFile().isEmpty()) {
                client.setModelFile(UserDto.getModelFile().getBytes()); 
            }
        } catch (IOException e) {
            // Handle the exception properly (log or throw)
            e.printStackTrace();
        }
        return UserDto;
    }

   
    public Product ProductDtoToProduct(ProductDto UserDto) {
        if (UserDto == null) {
            return null;
        }
        Product client = new Product();
        client.setId(UserDto.getId());
        client.setName(UserDto.getName());
        client.setModelFileName(UserDto.getModelFileName());
        client.setModelFileType(UserDto.getModelFileType());
        client.setStatus_id(UserDto.getStatus_id());
        return client;
    }
}
