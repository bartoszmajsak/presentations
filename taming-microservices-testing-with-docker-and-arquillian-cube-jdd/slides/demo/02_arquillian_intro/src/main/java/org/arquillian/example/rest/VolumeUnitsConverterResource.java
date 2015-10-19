package org.arquillian.example.rest;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/convert/volume")
public class VolumeUnitsConverterResource {

    @Inject
    private VolumeUnitsConverter converter;

    @GET
    @Path("/fl/ml/{amount}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response convertToMilliliters(@PathParam("amount") Double amount) {
        return Response.ok().entity(converter.convertToMilliliters(amount)).build();
    }

    @GET
    @Path("/ml/fl/{amount}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response convertToFlouidOunces(@PathParam("amount") Double amount) {
        return Response.ok().entity(converter.convertToFlouidOunces(amount)).build();
    }
}
