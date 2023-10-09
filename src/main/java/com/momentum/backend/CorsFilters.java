package com.momentum.backend;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class CorsFilters implements Filter {

    final Logger log = LoggerFactory.getLogger(CorsFilters.class);

    @Override
    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
            throws IOException, ServletException {
        HttpServletResponse response = (HttpServletResponse) res;
        try {

            response.setHeader("Access-Control-Allow-Origin", "*");
            response.setHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, HEAD, OPTIONS");
            response.setHeader("Access-Control-Allow-Headers", "Origin, Cache-Control, X-Requested-With, Content-Type, Accept, Authorization, enctype");
            chain.doFilter(req, res);
        } catch (IOException ioe) {
            log.error("IOException in cors filer caught.");
            response.flushBuffer();
        } catch (Exception e) {
            log.error("Exception in cors filer caught.", e);
            response.flushBuffer();
        }
    }



    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

}
