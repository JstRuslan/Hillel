package org.summer2025.ruslan.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.summer2025.ruslan.Entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
