package com.hotsummer.luvme.repository;

import com.hotsummer.luvme.model.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ProductRepository extends JpaRepository<Product, String> {

    @Query("SELECT p FROM Product p JOIN p.productSkinTypes pst JOIN pst.suitableSkinType sst WHERE sst.type LIKE %:skinType%")
    Optional<List<Product>> findProductsBySuitableSkinTypeDescription(@Param("skinType") String skinType);

    @Query("SELECT p FROM Product p JOIN p.productCategories pc JOIN pc.category c WHERE c.categoryCode LIKE %:categoryCode%")
    Optional<List<Product>> findProductsCategoryCode(@Param("categoryCode") String categoryCode);
    Optional<Product> findProductByProductId(UUID productId);
}
