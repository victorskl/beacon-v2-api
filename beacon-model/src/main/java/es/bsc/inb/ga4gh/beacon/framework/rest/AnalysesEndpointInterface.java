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

import es.bsc.inb.ga4gh.beacon.framework.AnalysesInterface;
import es.bsc.inb.ga4gh.beacon.framework.model.v200.requests.BeaconRequestBody;
import es.bsc.inb.ga4gh.beacon.framework.model.v200.responses.BeaconResultsetsResponse;
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

@Path("/analyses")
public interface AnalysesEndpointInterface 
        extends AnalysesInterface, AsyncEndpointInterface {

    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    default void getAnalyses(
            @QueryParam("requestedSchema") String requested_schema,
            @QueryParam("skip") Integer skip,
            @QueryParam("limit") Integer limit,
            @QueryParam("includeResultsetResponses") String include_responses,
            @Suspended AsyncResponse asyncResponse) {

        final ExecutorService executor = getExecutorService();
        if (executor != null) {
            executor.submit(() -> {
                try {
                    final BeaconResultsetsResponse response = getAnalyses(requested_schema, skip, limit, include_responses);
                    asyncResponse.resume(response);
                } catch (Exception ex) {
                    asyncResponse.resume(ex);
                }
            });
        } else {
            try {
                final BeaconResultsetsResponse response = getAnalyses(requested_schema, skip, limit, include_responses);
                asyncResponse.resume(response);
            } catch (Exception ex) {
                asyncResponse.resume(ex);
            }
        } 
    }
        
    @POST
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    default void postAnalyses(
            BeaconRequestBody request,
            @Suspended AsyncResponse asyncResponse) {

        final ExecutorService executor = getExecutorService();
        if (executor != null) {
            executor.submit(() -> {
                try {
                    final BeaconResultsetsResponse response = postAnalyses(request);
                    asyncResponse.resume(response);
                } catch (Exception ex) {
                    asyncResponse.resume(ex);
                }
            });
        } else {
            try {
                final BeaconResultsetsResponse response = postAnalyses(request);
                asyncResponse.resume(response);
            } catch (Exception ex) {
                asyncResponse.resume(ex);
            }
        }
    }
    
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    default void getOneAnalysis(
            @PathParam("id") String id,
            @Suspended AsyncResponse asyncResponse) {

        final ExecutorService executor = getExecutorService();
        if (executor != null) {
            executor.submit(() -> {
                try {
                    final BeaconResultsetsResponse response = getOneAnalysis(id);
                    asyncResponse.resume(response);
                } catch (Exception ex) {
                    asyncResponse.resume(ex);
                }
            });
        } else {
            try {
                final BeaconResultsetsResponse response = getOneAnalysis(id);
                asyncResponse.resume(response);
            } catch (Exception ex) {
                asyncResponse.resume(ex);
            }
        }
    }
    
    @POST
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    default void postOneAnalysisRequest(
            @PathParam("id") String id,
            BeaconRequestBody request,
            @Suspended AsyncResponse asyncResponse) {

        final ExecutorService executor = getExecutorService();
        if (executor != null) {
            executor.submit(() -> {
                try {
                    final BeaconResultsetsResponse response = postOneAnalysisRequest(id, request);
                    asyncResponse.resume(response);
                } catch (Exception ex) {
                    asyncResponse.resume(ex);
                }
            });
        } else {
            try {
                final BeaconResultsetsResponse response = postOneAnalysisRequest(id, request);
                asyncResponse.resume(response);
            } catch (Exception ex) {
                asyncResponse.resume(ex);
            }
        }
    }

    @GET
    @Path("/{id}/g_variants")
    @Produces(MediaType.APPLICATION_JSON)    
    default void getOneAnalysisGenomicVariants(
            @PathParam("id") String id,
            @QueryParam("requestedSchema") String requested_schema,
            @QueryParam("skip") Integer skip,
            @QueryParam("limit") Integer limit,
            @Suspended AsyncResponse asyncResponse) {

        final ExecutorService executor = getExecutorService();
        if (executor != null) {
            executor.submit(() -> {
                try {
                    final BeaconResultsetsResponse response = 
                            getOneAnalysisGenomicVariants(id, requested_schema, skip, limit);
                    asyncResponse.resume(response);
                } catch (Exception ex) {
                    asyncResponse.resume(ex);
                }
            });
        } else {
            try {
                final BeaconResultsetsResponse response = 
                        getOneAnalysisGenomicVariants(id, requested_schema, skip, limit);
                asyncResponse.resume(response);
            } catch (Exception ex) {
                asyncResponse.resume(ex);
            }
        }
    }
    
    @POST
    @Path("/{id}/g_variants")
    @Produces(MediaType.APPLICATION_JSON)
    default void postOneAnalysisGenomicVariantsRequest(
            @PathParam("id") String id,
            BeaconRequestBody request,
            @Suspended AsyncResponse asyncResponse) {

        final ExecutorService executor = getExecutorService();
        if (executor != null) {
            executor.submit(() -> {
                try {
                    final BeaconResultsetsResponse response = 
                            postOneAnalysisGenomicVariantsRequest(id, request);
                    asyncResponse.resume(response);
                } catch (Exception ex) {
                    asyncResponse.resume(ex);
                }
            });
        } else {
            try {
                final BeaconResultsetsResponse response = 
                        postOneAnalysisGenomicVariantsRequest(id, request);
                asyncResponse.resume(response);
            } catch (Exception ex) {
                asyncResponse.resume(ex);
            }
        }
    }

}
