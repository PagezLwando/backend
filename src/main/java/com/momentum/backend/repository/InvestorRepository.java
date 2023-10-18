package com.momentum.backend.repository;

import com.momentum.backend.models.Investor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InvestorRepository extends CrudRepository<Investor, Integer> {
    @Query(value = "CALL public.getallinvestors()", nativeQuery = true)
    List<Investor> getAllInvestors();

    @Modifying
    @Query(value = "CALL public.insert_investor(name, surname, date_of_birth, cell_number, email, address_id);", nativeQuery = true)
    void addNewInvestor(@Param("name") String name,
                @Param("surname") String surname,
                @Param("email") String email,
                @Param("cell_number") String cell_umber,
                @Param("date_of_birth") String date_of_birth,
                @Param("address_id") String address_id);

    @Modifying
    @Query(value = "CALL public.update_investor(name, surname, date_of_birth, cell_number, email, address_id);", nativeQuery = true)
    void updateInvestor(@Param("name") String name,
                        @Param("surname") String surname,
                        @Param("email") String email,
                        @Param("cell_number") String cell_umber,
                        @Param("date_of_birth") String date_of_birth,
                        @Param("address_id") String address_id);

    @Modifying
    @Query(value = "exec spDeleteInvestor :id", nativeQuery = true)
    void deleteInvestor(@Param("id") Integer id);
}