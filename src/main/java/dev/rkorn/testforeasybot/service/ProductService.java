package dev.rkorn.testforeasybot.service;

import dev.rkorn.testforeasybot.dto.AddProductDto;
import dev.rkorn.testforeasybot.dto.EditProductDto;
import dev.rkorn.testforeasybot.dto.ProductByIdDto;

import java.util.List;

public interface ProductService {

    void addProduct(AddProductDto productDto);

    void editProduct(EditProductDto productDto, Long id);

    ProductByIdDto getProductById(Long id);

    List<ProductByIdDto> getAllProductsByType(String type);
}
