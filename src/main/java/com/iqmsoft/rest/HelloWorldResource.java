package com.iqmsoft.rest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;

@Api(tags = "hello")
@Path("/test")
@Stateless
public class HelloWorldResource {

	@ApiOperation(value = "Say hi!")
	@GET
	@Produces("text/plain")
	public Response doGet() {
		return Response.ok("Hello from WildFly Swarm Swagger EJB Test!").build();
	}
}