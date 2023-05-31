package dev.rkorn.testforeasybot.repository;

import dev.rkorn.testforeasybot.entities.Product;
import dev.rkorn.testforeasybot.entities.enums.Type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query("SELECT pr from Product pr where type =:type")
    List<Product> findAllByType(Type type);
}
