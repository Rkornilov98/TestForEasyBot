package dev.rkorn.testforeasybot.controller;

import dev.rkorn.testforeasybot.dto.AddProductDto;
import dev.rkorn.testforeasybot.dto.EditProductDto;
import dev.rkorn.testforeasybot.dto.ProductByIdDto;
import dev.rkorn.testforeasybot.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/")
@RequiredArgsConstructor
public class Controller {

    private final ProductService productService;

    @PostMapping("/add")
    public void addProduct(@RequestBody AddProductDto productDto){
        productService.addProduct(productDto);
    }

    @PostMapping("/edit/{id}")
    public void editProduct(@PathVariable Long id, @RequestBody EditProductDto productDto){
        productService.editProduct(productDto, id);
    }

    @GetMapping("/all")
    public List<ProductByIdDto> getAllProducts(){
        return productService.getAllProducts();
    }

    @GetMapping("/get/{id}")
    public ProductByIdDto getProductById(@PathVariable Long id){
        return productService.getProductById(id);
    }
}
