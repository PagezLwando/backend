package com.momentum.backend.repository;

import com.momentum.backend.models.Investor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InvestorRepository extends CrudRepository<Investor, Integer> {
    @Override
    List<Investor> findAll();
//    @Query(value = "exec spGetAllInvestors", nativeQuery = true)
//    List<Investor> getAllInvestors();
}