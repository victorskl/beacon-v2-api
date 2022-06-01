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
 *****************************************************************************
 */

package es.bsc.inb.ga4gh.beacon.framework.rest;

import es.bsc.inb.ga4gh.beacon.framework.CohortsInterface;
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

@Path("/cohorts")
public interface CohortsEndpointInterface 
        extends CohortsInterface, AsyncEndpointInterface {
    
    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    default void getCohorts(
            @QueryParam("requestedSchema") String requested_schema,
            @QueryParam("skip") Integer skip,
            @QueryParam("limit") Integer limit,
            @Suspended AsyncResponse asyncResponse) {

        final ExecutorService executor = getExecutorService();
        if (executor != null) {
            executor.submit(() -> {
                asyncResponse.resume(
                        getCohorts(requested_schema, skip, limit));
            });
        } else {
            asyncResponse.resume(
                    getCohorts(requested_schema, skip, limit));
        } 
    }

    @POST
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    default void postCohortsRequest(
            BeaconRequestBody request,
            @Suspended AsyncResponse asyncResponse) {

        final ExecutorService executor = getExecutorService();
        if (executor != null) {
            executor.submit(() -> {
                asyncResponse.resume(postCohortsRequest(request));
            });
        } else {
            asyncResponse.resume(postCohortsRequest(request));
        }
    }
    
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    default void getOneCohort(
            @PathParam("id") String id,
            @Suspended AsyncResponse asyncResponse) {

        final ExecutorService executor = getExecutorService();
        if (executor != null) {
            executor.submit(() -> {
                asyncResponse.resume(getOneCohort(id));
            });
        } else {
            asyncResponse.resume(getOneCohort(id));
        }
    }
    
    @POST
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    default void postOneCohortRequest(
            @PathParam("id") String id,
            BeaconRequestBody request,
            @Suspended AsyncResponse asyncResponse) {

        final ExecutorService executor = getExecutorService();
        if (executor != null) {
            executor.submit(() -> {
                asyncResponse.resume(postOneCohortRequest(id, request));
            });
        } else {
            asyncResponse.resume(postOneCohortRequest(id, request));
        }
    }

    @GET
    @Path("/{id}/individuals")
    @Produces(MediaType.APPLICATION_JSON)    
    default void getOneCohortIndividuals(
            @PathParam("id") String id,
            @QueryParam("requestedSchema") String requested_schema,
            @QueryParam("skip") Integer skip,
            @QueryParam("limit") Integer limit,
            @Suspended AsyncResponse asyncResponse) {

        final ExecutorService executor = getExecutorService();
        if (executor != null) {
            executor.submit(() -> {
                asyncResponse.resume(
                        getOneCohortIndividuals(
                                id, requested_schema, skip, limit));
            });
        } else {
            asyncResponse.resume(
                    getOneCohortIndividuals(
                            id, requested_schema, skip, limit));
        }        
    }

    @POST
    @Path("/{id}/individuals")
    @Produces(MediaType.APPLICATION_JSON)
    default void postOneCohortIndividualsRequest(
            @PathParam("id") String id,
            BeaconRequestBody request,
            @Suspended AsyncResponse asyncResponse) {

        final ExecutorService executor = getExecutorService();
        if (executor != null) {
            executor.submit(() -> {
                asyncResponse.resume(
                        postOneCohortIndividualsRequest(id, request));
            });
        } else {
            asyncResponse.resume(postOneCohortIndividualsRequest(id, request));
        }
    }
    
    @GET
    @Path("/{id}/filtering_terms")
    @Produces(MediaType.APPLICATION_JSON)
    default void getOneCohortFilteringTerms(
            @PathParam("id") String id,
            @QueryParam("skip") Integer skip,
            @QueryParam("limit") Integer limit,
            @Suspended AsyncResponse asyncResponse) {

        final ExecutorService executor = getExecutorService();
        if (executor != null) {
            executor.submit(() -> {
                asyncResponse.resume(
                        getOneCohortFilteringTerms(id, skip, limit));
            });
        } else {
            asyncResponse.resume(getOneCohortFilteringTerms(id, skip, limit));
        }
    }
    
    @POST
    @Path("/{id}/filtering_terms")
    @Produces(MediaType.APPLICATION_JSON)
    default void postOneCohortFilteringTermsRequest(
            @PathParam("id") String id,
            BeaconRequestBody request,
            @Suspended AsyncResponse asyncResponse) {

        final ExecutorService executor = getExecutorService();
        if (executor != null) {
            executor.submit(() -> {
                asyncResponse.resume(
                        postOneCohortFilteringTermsRequest(id, request));
            });
        } else {
            asyncResponse.resume(postOneCohortFilteringTermsRequest(id, request));
        }
    }
}
