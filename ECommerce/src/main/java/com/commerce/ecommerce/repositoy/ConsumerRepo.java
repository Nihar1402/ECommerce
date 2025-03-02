package com.commerce.ecommerce.repositoy;

import com.commerce.ecommerce.model.entity.Consumer;
import com.commerce.ecommerce.model.entity.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import org.springframework.data.domain.Pageable;

@Repository
public interface ConsumerRepo extends JpaRepository<Consumer, Long> {
    @Query("SELECT o from Order o WHERE o.consumer.consumerId = :consumerId")
    Page<Order> findOrdersByConsumerId(@Param("consumerId") Long consumerId, Pageable pageable);
}
