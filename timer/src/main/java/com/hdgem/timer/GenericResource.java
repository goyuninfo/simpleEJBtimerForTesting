/*
 * http://localhost:8080/timer/rest/
 */
package com.hdgem.timer;

import java.util.Date;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.ejb.Timeout;
import javax.ejb.TimerService;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author hdgem.com
 */
@Path("/")
@Stateless
public class GenericResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of GenericResource
     */
    public GenericResource() {
    }

    /**
     * PUT method for updating or creating an instance of GenericResource
     *
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }

    private static final Logger logger = Logger.getLogger(GenericResource.class.getName());

    @Resource
    private TimerService timerService;

    @Timeout
    public void run() {
        logger.info("Timer triggered at " + new Date());
    }

    /**
     * Retrieves representation of an instance of
     * com.hdgem.timer.GenericResource
     *
     * @return an instance of java.lang.String
     */
    @GET
    //@Produces(MediaType.APPLICATION_JSON)
    public String startTimer() {
        timerService.createTimer(10000, 10000, "triggers every 10 seconds");
        logger.info("Timer scheduled to fire every 10 seconds");
        return "Timer scheduled to fire every 10 seconds";
    }
}
