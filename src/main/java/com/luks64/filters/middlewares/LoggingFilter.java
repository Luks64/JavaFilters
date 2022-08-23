package com.luks64.filters.middlewares;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@Component
@Order(1)
public class LoggingFilter implements Filter {

    private final static Logger LOG = LoggerFactory.getLogger(LoggingFilter.class);

    @Override
    public void doFilter(
            ServletRequest request,
            ServletResponse response,
            FilterChain chain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        LOG.info(
                "Starting a transaction for req : {}",
                req.getRequestURI());

        chain.doFilter(request, response);
        LOG.info(
                "Committing a transaction for req : {}",
                req.getRequestURI());

        HttpServletResponse resp = (HttpServletResponse) response;

        LOG.info("req.getRemoteAddr() : {}",req.getRemoteAddr());
        LOG.info("{},{},{}",req.getMethod(), req.getRequestURI(), resp.getStatus());
        LOG.info("{}",req.getRemoteHost());
        LOG.info("{}",req.getHeader("User-Agent"));
        //LOG.info("{}",req.getUserPrincipal().getName());
        //auditTrail.setCreated_at(new LocalDateTime());

    }

    private String actionMapping(String HttpMethod, String URI, int responseCode){
        if(HttpMethod == "POST" && URI == "/login" && responseCode == 200)
            return "Logging in";

        if(HttpMethod == "POST" && URI == "/upload" && responseCode == 200)
            return "Uploaded File";

        return null;
    }
}
