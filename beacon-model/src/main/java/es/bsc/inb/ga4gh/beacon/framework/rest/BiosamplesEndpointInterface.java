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
import es.bsc.inb.ga4gh.beacon.framework.model.v200.responses.BeaconResultsetsResponse;
import java.util.concurrent.ExecutorService;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.container.Suspended;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * @author Dmitry Repchevsky
 */

@Path("/biosamples")
public interface BiosamplesEndpointInterface 
        extends BiosamplesInterface, AsyncEndpointInterface {

    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    default void getBiosamples(
            @QueryParam("requestedSchema") String requested_schema,
            @QueryParam("skip") Integer skip,
            @QueryParam("limit") Integer limit,
            @QueryParam("includeResultsetResponses") String include_responses,
            @QueryParam("filters") List<String> filters,
            @Suspended AsyncResponse asyncResponse) {

        final ExecutorService executor = getExecutorService();
        if (executor != null) {
            executor.submit(() -> {
                try {
                    final BeaconResultsetsResponse response = 
                            getBiosamples(requested_schema, skip, limit, 
                                include_responses, filters);
                    asyncResponse.resume(response);
                } catch (Exception ex) {
                    asyncResponse.resume(ex);
                }
            });
        } else {
            try {
                final BeaconResultsetsResponse response = 
                        getBiosamples(requested_schema, skip, limit, 
                            include_responses, filters);
                asyncResponse.resume(response);
            } catch (Exception ex) {
                asyncResponse.resume(ex);
            }
        }        
    }

    @POST
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    default void postBiosamplesRequest(
            BeaconRequestBody request,
            @Suspended AsyncResponse asyncResponse) {

        final ExecutorService executor = getExecutorService();
        if (executor != null) {
            executor.submit(() -> {
                try {
                    final BeaconResultsetsResponse response = postBiosamplesRequest(request);
                    asyncResponse.resume(response);
                } catch (Exception ex) {
                    asyncResponse.resume(ex);
                }
            });
        } else {
            try {
                final BeaconResultsetsResponse response = postBiosamplesRequest(request);
                asyncResponse.resume(response);
            } catch (Exception ex) {
                asyncResponse.resume(ex);
            }
        }        
    }
    
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    default void getOneBiosample(
            @PathParam("id") String id,
            @Suspended AsyncResponse asyncResponse) {

        final ExecutorService executor = getExecutorService();
        if (executor != null) {
            executor.submit(() -> {
                try {
                    final BeaconResultsetsResponse response = getOneBiosample(id);
                    asyncResponse.resume(response);
                } catch (Exception ex) {
                    asyncResponse.resume(ex);
                }
            });
        } else {
            try {
                final BeaconResultsetsResponse response = getOneBiosample(id);
                asyncResponse.resume(response);
            } catch (Exception ex) {
                asyncResponse.resume(ex);
            }
        }
    }

    @POST
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    default void postOneBiosampleRequest(
            @PathParam("id") String id,
            BeaconRequestBody request,
            @Suspended AsyncResponse asyncResponse) {

        final ExecutorService executor = getExecutorService();
        if (executor != null) {
            executor.submit(() -> {
                try {
                    final BeaconResultsetsResponse response = postOneBiosampleRequest(id, request);
                    asyncResponse.resume(response);
                } catch (Exception ex) {
                    asyncResponse.resume(ex);
                }
            });
        } else {
            try {
                final BeaconResultsetsResponse response = postOneBiosampleRequest(id, request);
                asyncResponse.resume(response);
            } catch (Exception ex) {
                asyncResponse.resume(ex);
            }
        }
    }

    @GET
    @Path("/{id}/g_variants")
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
                try {
                    final BeaconResultsetsResponse response = getOneBiosampleGenomicVariants(
                                id, requested_schema, skip, limit);
                    asyncResponse.resume(response);
                } catch (Exception ex) {
                    asyncResponse.resume(ex);
                }
            });
        } else {
            try {
                final BeaconResultsetsResponse response = getOneBiosampleGenomicVariants(
                            id, requested_schema, skip, limit);
                asyncResponse.resume(response);
            } catch (Exception ex) {
                asyncResponse.resume(ex);
            }
        }        
    }
    
    @POST
    @Path("/{id}/g_variants")
    @Produces(MediaType.APPLICATION_JSON)
    default void postOneBiosampleGenomicVariantsRequest(
            @PathParam("id") String id,
            BeaconRequestBody request,
            @Suspended AsyncResponse asyncResponse) {

        final ExecutorService executor = getExecutorService();
        if (executor != null) {
            executor.submit(() -> {
                try {
                    final BeaconResultsetsResponse response = 
                            postOneBiosampleGenomicVariantsRequest(id, request);
                    asyncResponse.resume(response);
                } catch (Exception ex) {
                    asyncResponse.resume(ex);
                }
            });
        } else {
            try {
                final BeaconResultsetsResponse response = 
                        postOneBiosampleGenomicVariantsRequest(id, request);
                asyncResponse.resume(response);
            } catch (Exception ex) {
                asyncResponse.resume(ex);
            }
        }        
    }
    
    @GET
    @Path("/{id}/analyses")
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
                try {
                    final BeaconResultsetsResponse response = 
                            getOneBiosampleAnalysis(id, requested_schema, skip, limit);
                    asyncResponse.resume(response);
                } catch (Exception ex) {
                    asyncResponse.resume(ex);
                }
            });
        } else {
            try {
                final BeaconResultsetsResponse response = 
                        getOneBiosampleAnalysis(id, requested_schema, skip, limit);
                asyncResponse.resume(response);
            } catch (Exception ex) {
                asyncResponse.resume(ex);
            }
        }        
    }
    
    @POST
    @Path("/{id}/analyses")
    @Produces(MediaType.APPLICATION_JSON)
    default void postOneBiosampleAnalysisRequest(
            @PathParam("id") String id,
            BeaconRequestBody request,
            @Suspended AsyncResponse asyncResponse) {

        final ExecutorService executor = getExecutorService();
        if (executor != null) {
            executor.submit(() -> {
                try {
                    final BeaconResultsetsResponse response = 
                            postOneBiosampleAnalysisRequest(id, request);
                    asyncResponse.resume(response);
                } catch (Exception ex) {
                    asyncResponse.resume(ex);
                }
            });
        } else {
            try {
                final BeaconResultsetsResponse response = 
                        postOneBiosampleAnalysisRequest(id, request);
                asyncResponse.resume(response);
            } catch (Exception ex) {
                asyncResponse.resume(ex);
            }
        }        
    }

    @GET
    @Path("/{id}/runs")
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
                try {
                    final BeaconResultsetsResponse response = 
                            getOneBiosampleRuns(id, requested_schema, skip, limit);
                    asyncResponse.resume(response);
                } catch (Exception ex) {
                    asyncResponse.resume(ex);
                }
            });
        } else {
            try {
                final BeaconResultsetsResponse response = 
                        getOneBiosampleRuns(id, requested_schema, skip, limit);
                asyncResponse.resume(response);
            } catch (Exception ex) {
                asyncResponse.resume(ex);
            }
        }        
    }
    
    @POST
    @Path("/{id}/runs")
    @Produces(MediaType.APPLICATION_JSON)
    default void getOneBiosampleRuns(
            @PathParam("id") String id,
            BeaconRequestBody request,
            @Suspended AsyncResponse asyncResponse) {

        final ExecutorService executor = getExecutorService();
        if (executor != null) {
            executor.submit(() -> {
                try {
                    final BeaconResultsetsResponse response = 
                            getOneBiosampleRuns(id, request);
                    asyncResponse.resume(response);
                } catch (Exception ex) {
                    asyncResponse.resume(ex);
                }
            });
        } else {
            try {
                final BeaconResultsetsResponse response = 
                        getOneBiosampleRuns(id, request);
                asyncResponse.resume(response);
            } catch (Exception ex) {
                asyncResponse.resume(ex);
            }
        }
    }
}
