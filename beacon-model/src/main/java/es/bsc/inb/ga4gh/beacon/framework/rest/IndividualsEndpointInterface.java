/**
 * *****************************************************************************
 * Copyright (C) 2022 ELIXIR ES, Spanish National Bioinformatics Institute (INB)
 * and Barcelona Supercomputing Center (BSC)
 *
 * Modifications to the initial code base are copyright of their respective
 * authors, or their employers as appropriate.
 * 
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston,
 * MA 02110-1301  USA
 * *****************************************************************************
 */

package es.bsc.inb.ga4gh.beacon.framework.rest;

import es.bsc.inb.ga4gh.beacon.framework.IndividualsInterface;
import es.bsc.inb.ga4gh.beacon.framework.model.v200.requests.BeaconRequestBody;
import java.util.concurrent.ExecutorService;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.container.AsyncResponse;
import jakarta.ws.rs.container.Suspended;
import jakarta.ws.rs.core.MediaType;

/**
 * @author Dmitry Repchevsky
 */

@Path("/")
public interface IndividualsEndpointInterface 
        extends IndividualsInterface, AsyncEndpointInterface {

    @GET
    @Path("/individuals")
    @Produces(MediaType.APPLICATION_JSON)
    default void getIndividuals(
            @QueryParam("requestedSchema") String requested_schema,
            @QueryParam("skip") Integer skip,
            @QueryParam("limit") Integer limit,
            @QueryParam("includeResultsetResponses") String include_responses,
            @Suspended AsyncResponse asyncResponse) {

        final ExecutorService executor = getExecutorService();
        if (executor != null) {
            executor.submit(() -> {
                asyncResponse.resume(
                        getIndividuals(requested_schema, skip, limit, include_responses));
            });
        } else {
            asyncResponse.resume(
                    getIndividuals(requested_schema, skip, limit, include_responses));
        }        
    }

    @POST
    @Path("/individuals")
    @Produces(MediaType.APPLICATION_JSON)
    default void postIndividualsRequest(
            BeaconRequestBody request,
            @Suspended AsyncResponse asyncResponse) {

        final ExecutorService executor = getExecutorService();
        if (executor != null) {
            executor.submit(() -> {
                asyncResponse.resume(postIndividualsRequest(request));
            });
        } else {
            asyncResponse.resume(postIndividualsRequest(request));
        }        
    }

    @GET
    @Path("/individuals/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    default void getOneIndividual(
            @PathParam("id") String id,
            @Suspended AsyncResponse asyncResponse) {

        final ExecutorService executor = getExecutorService();
        if (executor != null) {
            executor.submit(() -> {
                asyncResponse.resume(getOneIndividual(id));
            });
        } else {
            asyncResponse.resume(getOneIndividual(id));
        }
    }

    @POST
    @Path("/individuals/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    default void postOneIndividualRequest(
            @PathParam("id") String id,
            BeaconRequestBody request,
            @Suspended AsyncResponse asyncResponse) {

        final ExecutorService executor = getExecutorService();
        if (executor != null) {
            executor.submit(() -> {
                asyncResponse.resume(postOneIndividualRequest(id, request));
            });
        } else {
            asyncResponse.resume(postOneIndividualRequest(id, request));
        }
    }

    @GET
    @Path("/individuals/{id}/g_variants")
    @Produces(MediaType.APPLICATION_JSON)    
    default void getOneIndividualGenomicVariants(
            @PathParam("id") String id,
            @QueryParam("requestedSchema") String requested_schema,
            @QueryParam("skip") Integer skip,
            @QueryParam("limit") Integer limit,
            @Suspended AsyncResponse asyncResponse) {

        final ExecutorService executor = getExecutorService();
        if (executor != null) {
            executor.submit(() -> {
                asyncResponse.resume(
                        getOneIndividualGenomicVariants(
                                id, requested_schema, skip, limit));
            });
        } else {
            asyncResponse.resume(
                    getOneIndividualGenomicVariants(
                            id, requested_schema, skip, limit));
        }        
    }
    
    @POST
    @Path("/individuals/{id}/g_variants")
    @Produces(MediaType.APPLICATION_JSON)
    default void postOneIndividualGenomicVariantsRequest(
            @PathParam("id") String id,
            BeaconRequestBody request,
            @Suspended AsyncResponse asyncResponse) {

        final ExecutorService executor = getExecutorService();
        if (executor != null) {
            executor.submit(() -> {
                asyncResponse.resume(
                        postOneIndividualGenomicVariantsRequest(id, request));
            });
        } else {
            asyncResponse.resume(
                    postOneIndividualGenomicVariantsRequest(id, request));
        }        
    }

    @GET
    @Path("/individuals/{id}/biosamples")
    @Produces(MediaType.APPLICATION_JSON)    
    default void getOneIndividualBiosamples(
            @PathParam("id") String id,
            @QueryParam("requestedSchema") String requested_schema,
            @QueryParam("skip") Integer skip,
            @QueryParam("limit") Integer limit,
            @Suspended AsyncResponse asyncResponse) {

        final ExecutorService executor = getExecutorService();
        if (executor != null) {
            executor.submit(() -> {
                asyncResponse.resume(
                        getOneIndividualBiosamples(
                                id, requested_schema, skip, limit));
            });
        } else {
            asyncResponse.resume(
                    getOneIndividualBiosamples(
                            id, requested_schema, skip, limit));
        }        
    }

    @POST
    @Path("/individuals/{id}/biosamples")
    @Produces(MediaType.APPLICATION_JSON)
    default void postOneIndividualBiosamplesRequest(
            @PathParam("id") String id,
            BeaconRequestBody request,
            @Suspended AsyncResponse asyncResponse) {

        final ExecutorService executor = getExecutorService();
        if (executor != null) {
            executor.submit(() -> {
                asyncResponse.resume(
                        postOneIndividualBiosamplesRequest(id, request));
            });
        } else {
            asyncResponse.resume(
                    postOneIndividualBiosamplesRequest(id, request));
        }        
    }
    
    @GET
    @Path("/individuals/filtering_terms")
    @Produces(MediaType.APPLICATION_JSON)
    default void getIndividualFilteringTerms(
            @QueryParam("skip") Integer skip,
            @QueryParam("limit") Integer limit,
            @Suspended AsyncResponse asyncResponse) {

        final ExecutorService executor = getExecutorService();
        if (executor != null) {
            executor.submit(() -> {
                asyncResponse.resume(
                        getIndividualFilteringTerms(skip, limit));
            });
        } else {
            asyncResponse.resume(getIndividualFilteringTerms(skip, limit));
        }
    }
    
    @POST
    @Path("/individuals/filtering_terms")
    @Produces(MediaType.APPLICATION_JSON)
    default void postIndividualFilteringTermsRequest(
            BeaconRequestBody request,
            @Suspended AsyncResponse asyncResponse) {

        final ExecutorService executor = getExecutorService();
        if (executor != null) {
            executor.submit(() -> {
                asyncResponse.resume(
                        postIndividualFilteringTermsRequest(request));
            });
        } else {
            asyncResponse.resume(postIndividualFilteringTermsRequest(request));
        }
    }

}
