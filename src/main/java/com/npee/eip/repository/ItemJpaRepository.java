package com.npee.eip.repository;

import com.npee.eip.model.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemJpaRepository extends JpaRepository<Item, Long> {
}
