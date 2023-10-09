package com.momentum.backend.controllers;

import com.momentum.backend.controllers.models.APIResponse;
import com.momentum.backend.models.Investor;
import com.momentum.backend.services.InvestorService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;

@Component
@Path("/investor/")
public class InvestorsController {
    @Autowired
    InvestorService investorService;

    @Path("getAll")
    @Produces(MediaType.APPLICATION_JSON)
    @GET
//    @Transactional(timeout = 30)
    public APIResponse getAllInvestors() {
        try {
            List<Investor> investors = investorService.getAllInvestors();

            if (investors.isEmpty()) {
                return new APIResponse(true, "No investors details returned", null, null);
            }
            return new APIResponse(true, "Investors details returned successfully", investors, null);
        } catch (Exception e) {
            return new APIResponse(false, "Error occurred while trying to retrieve Investors details ",
                    null, Collections.singletonList(e.getMessage()));
        }
    }

}
