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
    @Transactional(timeout = 30)
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

    @Path("addNew")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @POST
//    @Transactional(timeout = 30)
    public APIResponse addNewInvestor(Investor investor) {
        try {
            investorService.AddNewInvestor(investor);
            return new APIResponse(true, "New investor created successfully.", null, null);
        } catch (Exception e) {
            return new APIResponse(false, "Error occurred while adding new investor.", null, Collections.singletonList(e.getMessage()));
        }
    }

    @Path("update")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @PUT
//    @Transactional(timeout = 30)
    public APIResponse UpdateInvestor(Investor investor) {
        try {
            investorService.UpdateInvestor(investor);
            return new APIResponse(true, "Investor "+investor.getName()+" successfully updated.", null, null);
        } catch (Exception e) {
            return new APIResponse(false, "Error occurred while updating investor. "+investor.getId(), null, Collections.singletonList(e.getMessage()));
        }
    }

    @Path("delete")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @DELETE
    @Transactional(timeout = 15)
    public APIResponse deleteInvestor(Investor investor) {
        try {
            investorService.deleteInvestor(investor.getId());
            return new APIResponse(true, "Investor deleted successfully.", null, null);
        } catch (Exception e) {
            return new APIResponse(false, "Error occurred while deleting investor.", null, Collections.singletonList(e.getMessage()));
        }
    }

}
