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
import es.bsc.inb.ga4gh.beacon.framework.model.v200.responses.BeaconFilteringTermsResponse;
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

/**
 * @author Dmitry Repchevsky
 */

@Path("/individuals")
public interface IndividualsEndpointInterface 
        extends IndividualsInterface, AsyncEndpointInterface {

    @GET
    @Path("/")
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
                try {
                    final BeaconResultsetsResponse response = 
                            getIndividuals(requested_schema, skip, limit, include_responses);
                    asyncResponse.resume(response);
                } catch (Exception ex) {
                    asyncResponse.resume(ex);
                }
            });
        } else {
            try {
                final BeaconResultsetsResponse response = 
                        getIndividuals(requested_schema, skip, limit, include_responses);
                asyncResponse.resume(response);
            } catch (Exception ex) {
                asyncResponse.resume(ex);
            }
        }        
    }

    @POST
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    default void postIndividualsRequest(
            BeaconRequestBody request,
            @Suspended AsyncResponse asyncResponse) {

        final ExecutorService executor = getExecutorService();
        if (executor != null) {
            executor.submit(() -> {
                try {
                    final BeaconResultsetsResponse response = postIndividualsRequest(request);
                    asyncResponse.resume(response);
                } catch (Exception ex) {
                    asyncResponse.resume(ex);
                }
            });
        } else {
            try {
                final BeaconResultsetsResponse response = postIndividualsRequest(request);
                asyncResponse.resume(response);
            } catch (Exception ex) {
                asyncResponse.resume(ex);
            }
        }        
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    default void getOneIndividual(
            @PathParam("id") String id,
            @Suspended AsyncResponse asyncResponse) {

        final ExecutorService executor = getExecutorService();
        if (executor != null) {
            executor.submit(() -> {
                try {
                    final BeaconResultsetsResponse response = getOneIndividual(id);
                    asyncResponse.resume(response);
                } catch (Exception ex) {
                    asyncResponse.resume(ex);
                }
            });
        } else {
            try {
                final BeaconResultsetsResponse response = getOneIndividual(id);
                asyncResponse.resume(response);
            } catch (Exception ex) {
                asyncResponse.resume(ex);
            }
        }
    }

    @POST
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    default void postOneIndividualRequest(
            @PathParam("id") String id,
            BeaconRequestBody request,
            @Suspended AsyncResponse asyncResponse) {

        final ExecutorService executor = getExecutorService();
        if (executor != null) {
            executor.submit(() -> {
                try {
                    final BeaconResultsetsResponse response = postOneIndividualRequest(id, request);
                    asyncResponse.resume(response);
                } catch (Exception ex) {
                    asyncResponse.resume(ex);
                }
            });
        } else {
            try {
                final BeaconResultsetsResponse response = postOneIndividualRequest(id, request);
                asyncResponse.resume(response);
            } catch (Exception ex) {
                asyncResponse.resume(ex);
            }
        }
    }

    @GET
    @Path("/{id}/g_variants")
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
                try {
                    final BeaconResultsetsResponse response = 
                            getOneIndividualGenomicVariants(id, requested_schema, skip, limit);
                    asyncResponse.resume(response);
                } catch (Exception ex) {
                    asyncResponse.resume(ex);
                }
            });
        } else {
            try {
                final BeaconResultsetsResponse response = 
                        getOneIndividualGenomicVariants(id, requested_schema, skip, limit);
                asyncResponse.resume(response);
            } catch (Exception ex) {
                asyncResponse.resume(ex);
            }
        }        
    }
    
    @POST
    @Path("/{id}/g_variants")
    @Produces(MediaType.APPLICATION_JSON)
    default void postOneIndividualGenomicVariantsRequest(
            @PathParam("id") String id,
            BeaconRequestBody request,
            @Suspended AsyncResponse asyncResponse) {

        final ExecutorService executor = getExecutorService();
        if (executor != null) {
            executor.submit(() -> {
                try {
                    final BeaconResultsetsResponse response = 
                            postOneIndividualGenomicVariantsRequest(id, request);
                    asyncResponse.resume(response);
                } catch (Exception ex) {
                    asyncResponse.resume(ex);
                }
            });
        } else {
            try {
                final BeaconResultsetsResponse response = 
                        postOneIndividualGenomicVariantsRequest(id, request);
                asyncResponse.resume(response);
            } catch (Exception ex) {
                asyncResponse.resume(ex);
            }
        }        
    }

    @GET
    @Path("/{id}/biosamples")
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
                try {
                    final BeaconResultsetsResponse response = 
                            getOneIndividualBiosamples(id, requested_schema, skip, limit);
                    asyncResponse.resume(response);
                } catch (Exception ex) {
                    asyncResponse.resume(ex);
                }
            });
        } else {
            try {
                final BeaconResultsetsResponse response = 
                        getOneIndividualBiosamples(id, requested_schema, skip, limit);
                asyncResponse.resume(response);
            } catch (Exception ex) {
                asyncResponse.resume(ex);
            }
        }        
    }

    @POST
    @Path("/{id}/biosamples")
    @Produces(MediaType.APPLICATION_JSON)
    default void postOneIndividualBiosamplesRequest(
            @PathParam("id") String id,
            BeaconRequestBody request,
            @Suspended AsyncResponse asyncResponse) {

        final ExecutorService executor = getExecutorService();
        if (executor != null) {
            executor.submit(() -> {
                try {
                    final BeaconResultsetsResponse response = 
                            postOneIndividualBiosamplesRequest(id, request);
                    asyncResponse.resume(response);
                } catch (Exception ex) {
                    asyncResponse.resume(ex);
                }
            });
        } else {
            try {
                final BeaconResultsetsResponse response = 
                        postOneIndividualBiosamplesRequest(id, request);
                asyncResponse.resume(response);
            } catch (Exception ex) {
                asyncResponse.resume(ex);
            }
        }        
    }
    
    @GET
    @Path("/filtering_terms")
    @Produces(MediaType.APPLICATION_JSON)
    default void getIndividualFilteringTerms(
            @QueryParam("skip") Integer skip,
            @QueryParam("limit") Integer limit,
            @Suspended AsyncResponse asyncResponse) {

        final ExecutorService executor = getExecutorService();
        if (executor != null) {
            executor.submit(() -> {
                try {
                    final BeaconFilteringTermsResponse response = 
                            getIndividualFilteringTerms(skip, limit);
                    asyncResponse.resume(response);
                } catch (Exception ex) {
                    asyncResponse.resume(ex);
                }
            });
        } else {
            try {
                final BeaconFilteringTermsResponse response = 
                        getIndividualFilteringTerms(skip, limit);
                asyncResponse.resume(response);
            } catch (Exception ex) {
                asyncResponse.resume(ex);
            }
        }
    }
    
    @POST
    @Path("/filtering_terms")
    @Produces(MediaType.APPLICATION_JSON)
    default void postIndividualFilteringTermsRequest(
            BeaconRequestBody request,
            @Suspended AsyncResponse asyncResponse) {

        final ExecutorService executor = getExecutorService();
        if (executor != null) {
            executor.submit(() -> {
                try {
                    final BeaconFilteringTermsResponse response = 
                            postIndividualFilteringTermsRequest(request);
                    asyncResponse.resume(response);
                } catch (Exception ex) {
                    asyncResponse.resume(ex);
                }
            });
        } else {
            try {
                final BeaconFilteringTermsResponse response = 
                        postIndividualFilteringTermsRequest(request);
                asyncResponse.resume(response);
            } catch (Exception ex) {
                asyncResponse.resume(ex);
            }
        }
    }
}
