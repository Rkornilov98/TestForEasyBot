package dev.rkorn.testforeasybot.service.impl;

import dev.rkorn.testforeasybot.dto.AddProductDto;
import dev.rkorn.testforeasybot.dto.EditProductDto;
import dev.rkorn.testforeasybot.dto.ProductByIdDto;
import dev.rkorn.testforeasybot.entities.Product;
import dev.rkorn.testforeasybot.entities.enums.Type;
import dev.rkorn.testforeasybot.repository.ProductRepository;
import dev.rkorn.testforeasybot.service.ProductService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
//@Transactional(readOnly = true)
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public void addProduct(AddProductDto productDto) {
        //проверка на дубликат?
        Product product = Product.builder()
                .producer(productDto.getProducer())
                .series(productDto.getSeries())
                .price(productDto.getPrice())
                .amount(productDto.getAmount())
                .type(productDto.getType())
                .property(productDto.getProperty()).build();

        productRepository.save(product);
    }

    @Override
    public void editProduct(EditProductDto productDto, Long id) {
        Optional<Product> productOptional = productRepository.findById(id);
        if (productOptional.isPresent()){
            Product product = productOptional.get();
            product.setProducer(product.getProducer());
            product.setPrice(productDto.getPrice());
            product.setSeries(productDto.getSeries());
            product.setAmount(productDto.getAmount());
            product.setType(productDto.getType());
            product.setProperty(product.getProperty());

            productRepository.save(product);
        } else throw new EntityNotFoundException("Товар с таким идентификатором не найден");
    }

    @Override
    public ProductByIdDto getProductById(Long id) {
        Optional<Product> productOptional = productRepository.findById(id);
        if (productOptional.isPresent()){
            Product product = productOptional.get();
            ProductByIdDto productByIdDto= ProductByIdDto.builder()
                    .producer(product.getProducer())
                    .series(product.getSeries())
                    .price(product.getPrice())
                    .amount(product.getAmount())
                    .type(product.getType())
                    .property(product.getProperty()).build();
            return productByIdDto;
        } else throw new EntityNotFoundException("Товар с таким идентификатором не найден");
    }

    @Override
    public List<ProductByIdDto> getAllProductsByType(String type) {
        return productRepository.findAllByType(Type.valueOf(type)).stream().map(product -> ProductByIdDto.builder()
                .producer(product.getProducer())
                .amount(product.getAmount())
                .series(product.getSeries())
                .price(product.getPrice())
                .type(product.getType())
                .property(product.getProperty())
                .build()).collect(Collectors.toList());
    }
}
