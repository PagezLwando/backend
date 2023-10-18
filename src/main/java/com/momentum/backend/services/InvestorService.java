package com.momentum.backend.services;

import com.momentum.backend.models.Investor;
import com.momentum.backend.repository.InvestorRepository;
import jakarta.persistence.Entity;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InvestorService {
    @Autowired
    InvestorRepository investorRepository;

    @SneakyThrows
    public List<Investor> getAllInvestors() throws Exception {
        try {
            List<Investor> investors = investorRepository.getAllInvestors();

            if (investors.isEmpty()){
                return null;
            }
            return investors;
        } catch (Exception e) {
            throw new Exception("Error occurred while getting investors details " + e);
        }
    };

    @SneakyThrows
    public void AddNewInvestor(Investor investor) throws Exception {
        try {
            investorRepository.addNewInvestor(
                    investor.getName(),
                    investor.getSurname(),
                    investor.getDate_of_birth(),
                    investor.getCell_number(),
                    investor.getEmail(),
                    investor.getAddress_id()
            );
        } catch (Exception e) {throw new Exception("Error occurred while adding new user");}
    }

    @SneakyThrows
    public void UpdateInvestor(Investor investor) throws Exception {
        try {
            investorRepository.updateInvestor(
                    investor.getName(),
                    investor.getSurname(),
                    investor.getDate_of_birth(),
                    investor.getCell_number(),
                    investor.getEmail(),
                    investor.getAddress_id()
            );
        } catch (Exception e) {throw new Exception("Error occurred while updating "+investor.getId()+" investor");}
    }

    @SneakyThrows
    public void deleteInvestor(Integer id) {
        try {
            investorRepository.deleteInvestor(id);
        } catch (Exception e) {throw new Exception("Error occurred while trying to delete investor");}
    }

    public Investor getInvestors(Long id) {
        return null;
    }
}
