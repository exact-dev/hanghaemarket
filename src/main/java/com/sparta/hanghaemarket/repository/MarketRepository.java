package com.sparta.hanghaemarket.repository;

import com.sparta.hanghaemarket.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MarketRepository extends JpaRepository<Item, Long> {
}
