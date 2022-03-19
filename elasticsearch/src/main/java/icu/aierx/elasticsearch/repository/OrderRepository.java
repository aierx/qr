package icu.aierx.elasticsearch.repository;

import icu.aierx.elasticsearch.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author leiwenyong
 * @since 2022/3/18
 */
public interface OrderRepository extends JpaRepository<Order,Long> {
}
