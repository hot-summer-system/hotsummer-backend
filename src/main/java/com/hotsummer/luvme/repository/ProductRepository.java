package com.hotsummer.luvme.repository;

import com.hotsummer.luvme.model.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, String> {

    @Query("SELECT p FROM Product p JOIN p.productSkinTypes pst JOIN pst.suitableSkinType sst WHERE sst.type LIKE %:skinType%")
    Optional<List<Product>> findProductsBySuitableSkinTypeDescription(@Param("skinType") String skinType);
}
