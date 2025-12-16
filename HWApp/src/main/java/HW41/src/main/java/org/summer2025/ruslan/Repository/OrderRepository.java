package org.summer2025.ruslan.Repository;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.summer2025.ruslan.Entity.Order;


@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

    }

