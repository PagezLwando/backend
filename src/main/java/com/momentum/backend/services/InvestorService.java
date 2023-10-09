package com.momentum.backend.services;

import com.momentum.backend.models.Investor;
import com.momentum.backend.repository.InvestorRepository;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class InvestorService {
    @Autowired
    InvestorRepository investorRepository;

    @SneakyThrows
    public List<Investor> getAllInvestors() throws Exception {
        try {
//            List<Investor> investors = investorRepository.getAllInvestors();
            List<Investor> investors = investorRepository.findAll();

            if (investors.isEmpty()){
                return null;
            }
            return investors;
        } catch (Exception e) {
            throw new Exception("Error occurred while getting investors details " + e);
        }
    };

}
