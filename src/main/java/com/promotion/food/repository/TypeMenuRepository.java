package com.promotion.food.repository;

import com.promotion.food.enity.TypeMenu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TypeMenuRepository  extends JpaRepository<TypeMenu,Long> {

    List<TypeMenu> findByActivateTrue();

    Optional<TypeMenu> findByTypeMenuIdAndActivateTrue(long dataTypeMenuId);
}
