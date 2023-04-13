package com.example.demo.repository;

import com.example.demo.model.CurrencyEntity;
import io.micrometer.core.annotation.Timed;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface CurrencyRepository extends JpaRepository<CurrencyEntity, UUID> {
    @Timed("gettingCurrenciesByName")
    List<CurrencyEntity> findByCurrency(String name);

    @Timed("gettingAllCurrencies")
    List<CurrencyEntity> findAll();
}
