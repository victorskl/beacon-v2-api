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

import es.bsc.inb.ga4gh.beacon.framework.BiosamplesInterface;
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
public interface BiosamplesEndpointInterface 
        extends BiosamplesInterface, AsyncEndpointInterface {

    @GET
    @Path("/biosamples")
    @Produces(MediaType.APPLICATION_JSON)
    default void getBiosamples(
            @QueryParam("requestedSchema") String requested_schema,
            @QueryParam("skip") Integer skip,
            @QueryParam("limit") Integer limit,
            @QueryParam("includeResultsetResponses") String include_responses,
            @Suspended AsyncResponse asyncResponse) {

        final ExecutorService executor = getExecutorService();
        if (executor != null) {
            executor.submit(() -> {
                asyncResponse.resume(
                        getBiosamples(requested_schema, skip, limit, include_responses));
            });
        } else {
            asyncResponse.resume(
                    getBiosamples(requested_schema, skip, limit, include_responses));
        }        
    }

    @POST
    @Path("/biosamples")
    @Produces(MediaType.APPLICATION_JSON)
    default void postBiosamplesRequest(
            BeaconRequestBody request,
            @Suspended AsyncResponse asyncResponse) {

        final ExecutorService executor = getExecutorService();
        if (executor != null) {
            executor.submit(() -> {
                asyncResponse.resume(postBiosamplesRequest(request));
            });
        } else {
            asyncResponse.resume(postBiosamplesRequest(request));
        }        
    }
    
    @GET
    @Path("/biosamples/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    default void getOneBiosample(
            @PathParam("id") String id,
            @Suspended AsyncResponse asyncResponse) {

        final ExecutorService executor = getExecutorService();
        if (executor != null) {
            executor.submit(() -> {
                asyncResponse.resume(getOneBiosample(id));
            });
        } else {
            asyncResponse.resume(getOneBiosample(id));
        }
    }

    @POST
    @Path("/biosamples/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    default void postOneBiosampleRequest(
            @PathParam("id") String id,
            BeaconRequestBody request,
            @Suspended AsyncResponse asyncResponse) {

        final ExecutorService executor = getExecutorService();
        if (executor != null) {
            executor.submit(() -> {
                asyncResponse.resume(postOneBiosampleRequest(id, request));
            });
        } else {
            asyncResponse.resume(postOneBiosampleRequest(id, request));
        }
    }

    @GET
    @Path("/biosamples/{id}/g_variants")
    @Produces(MediaType.APPLICATION_JSON)    
    default void getOneBiosampleGenomicVariants(
            @PathParam("id") String id,
            @QueryParam("requestedSchema") String requested_schema,
            @QueryParam("skip") Integer skip,
            @QueryParam("limit") Integer limit,
            @Suspended AsyncResponse asyncResponse) {

        final ExecutorService executor = getExecutorService();
        if (executor != null) {
            executor.submit(() -> {
                asyncResponse.resume(
                        getOneBiosampleGenomicVariants(
                                id, requested_schema, skip, limit));
            });
        } else {
            asyncResponse.resume(
                    getOneBiosampleGenomicVariants(
                            id, requested_schema, skip, limit));
        }        
    }
    
    @POST
    @Path("/biosamples/{id}/g_variants")
    @Produces(MediaType.APPLICATION_JSON)
    default void postOneBiosampleGenomicVariantsRequest(
            @PathParam("id") String id,
            BeaconRequestBody request,
            @Suspended AsyncResponse asyncResponse) {

        final ExecutorService executor = getExecutorService();
        if (executor != null) {
            executor.submit(() -> {
                asyncResponse.resume(
                        postOneBiosampleGenomicVariantsRequest(id, request));
            });
        } else {
            asyncResponse.resume(
                    postOneBiosampleGenomicVariantsRequest(id, request));
        }        
    }
    
    @GET
    @Path("/biosamples/{id}/analyses")
    @Produces(MediaType.APPLICATION_JSON)    
    default void getOneBiosampleAnalysis(
            @PathParam("id") String id,
            @QueryParam("requestedSchema") String requested_schema,
            @QueryParam("skip") Integer skip,
            @QueryParam("limit") Integer limit,
            @Suspended AsyncResponse asyncResponse) {

        final ExecutorService executor = getExecutorService();
        if (executor != null) {
            executor.submit(() -> {
                asyncResponse.resume(
                        getOneBiosampleAnalysis(
                                id, requested_schema, skip, limit));
            });
        } else {
            asyncResponse.resume(
                    getOneBiosampleAnalysis(
                            id, requested_schema, skip, limit));
        }        
    }
    
    @POST
    @Path("/biosamples/{id}/analyses")
    @Produces(MediaType.APPLICATION_JSON)
    default void postOneBiosampleAnalysisRequest(
            @PathParam("id") String id,
            BeaconRequestBody request,
            @Suspended AsyncResponse asyncResponse) {

        final ExecutorService executor = getExecutorService();
        if (executor != null) {
            executor.submit(() -> {
                asyncResponse.resume(postOneBiosampleAnalysisRequest(id, request));
            });
        } else {
            asyncResponse.resume(
                    postOneBiosampleAnalysisRequest(id, request));
        }        
    }

    @GET
    @Path("/biosamples/{id}/runs")
    @Produces(MediaType.APPLICATION_JSON)    
    default void getOneBiosampleRuns(
            @PathParam("id") String id,
            @QueryParam("requestedSchema") String requested_schema,
            @QueryParam("skip") Integer skip,
            @QueryParam("limit") Integer limit,
            @Suspended AsyncResponse asyncResponse) {

        final ExecutorService executor = getExecutorService();
        if (executor != null) {
            executor.submit(() -> {
                asyncResponse.resume(
                        getOneBiosampleRuns(id, requested_schema, skip, limit));
            });
        } else {
            asyncResponse.resume(
                getOneBiosampleRuns(id, requested_schema, skip, limit));
        }        
    }
    
    @POST
    @Path("/biosamples/{id}/runs")
    @Produces(MediaType.APPLICATION_JSON)
    default void getOneBiosampleRuns(
            @PathParam("id") String id,
            BeaconRequestBody request,
            @Suspended AsyncResponse asyncResponse) {

        final ExecutorService executor = getExecutorService();
        if (executor != null) {
            executor.submit(() -> {
                asyncResponse.resume(
                        getOneBiosampleRuns(id, request));
            });
        } else {
            asyncResponse.resume(
                getOneBiosampleRuns(id, request));
        }        

    }

}
