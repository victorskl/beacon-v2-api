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

import es.bsc.inb.ga4gh.beacon.framework.DatasetsInterface;
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
public interface DatasetsEndpointInterface 
        extends DatasetsInterface, AsyncEndpointInterface {

    @GET
    @Path("/datasets")
    @Produces(MediaType.APPLICATION_JSON)
    default void getDatasets(
            @QueryParam("requestedSchema") String requested_schema,
            @QueryParam("skip") Integer skip,
            @QueryParam("limit") Integer limit,
            @Suspended AsyncResponse asyncResponse) {

        final ExecutorService executor = getExecutorService();
        if (executor != null) {
            executor.submit(() -> {
                asyncResponse.resume(
                        getDatasets(requested_schema, skip, limit));
            });
        } else {
            asyncResponse.resume(
                    getDatasets(requested_schema, skip, limit));
        } 
    }

    @POST
    @Path("/datasets")
    @Produces(MediaType.APPLICATION_JSON)
    default void postDatasetsRequest(
            BeaconRequestBody request,
            @Suspended AsyncResponse asyncResponse) {

        final ExecutorService executor = getExecutorService();
        if (executor != null) {
            executor.submit(() -> {
                asyncResponse.resume(postDatasetsRequest(request));
            });
        } else {
            asyncResponse.resume(postDatasetsRequest(request));
        }
    }
    
    @GET
    @Path("/datasets/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    default void getOneDataset(
            @PathParam("id") String id,
            @Suspended AsyncResponse asyncResponse) {

        final ExecutorService executor = getExecutorService();
        if (executor != null) {
            executor.submit(() -> {
                asyncResponse.resume(getOneDataset(id));
            });
        } else {
            asyncResponse.resume(getOneDataset(id));
        }
    }
    
    @POST
    @Path("/datasets/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    default void postOneDatasetRequest(
            @PathParam("id") String id,
            BeaconRequestBody request,
            @Suspended AsyncResponse asyncResponse) {

        final ExecutorService executor = getExecutorService();
        if (executor != null) {
            executor.submit(() -> {
                asyncResponse.resume(postOneDatasetRequest(id, request));
            });
        } else {
            asyncResponse.resume(postOneDatasetRequest(id, request));
        }
    }

    @GET
    @Path("/datasets/{id}/g_variants")
    @Produces(MediaType.APPLICATION_JSON)    
    default void getOneDatasetGenomicVariants(
            @PathParam("id") String id,
            @QueryParam("requestedSchema") String requested_schema,
            @QueryParam("skip") Integer skip,
            @QueryParam("limit") Integer limit,
            @Suspended AsyncResponse asyncResponse) {

        final ExecutorService executor = getExecutorService();
        if (executor != null) {
            executor.submit(() -> {
                asyncResponse.resume(
                        getOneDatasetGenomicVariants(
                                id, requested_schema, skip, limit));
            });
        } else {
            asyncResponse.resume(
                    getOneDatasetGenomicVariants(
                            id, requested_schema, skip, limit));
        }        
    }

    @POST
    @Path("/datasets/{id}/g_variants")
    @Produces(MediaType.APPLICATION_JSON)
    default void postOneDatasetGenomicVariantsRequest(
            @PathParam("id") String id,
            BeaconRequestBody request,
            @Suspended AsyncResponse asyncResponse) {

        final ExecutorService executor = getExecutorService();
        if (executor != null) {
            executor.submit(() -> {
                asyncResponse.resume(
                        postOneDatasetGenomicVariantsRequest(id, request));
            });
        } else {
            asyncResponse.resume(
                    postOneDatasetGenomicVariantsRequest(id, request));
        }        
    }

    @GET
    @Path("/datasets/{id}/biosamples")
    @Produces(MediaType.APPLICATION_JSON)    
    default void getOneDatasetBiosamples(
            @PathParam("id") String id,
            @QueryParam("requestedSchema") String requested_schema,
            @QueryParam("skip") Integer skip,
            @QueryParam("limit") Integer limit,
            @Suspended AsyncResponse asyncResponse) {

        final ExecutorService executor = getExecutorService();
        if (executor != null) {
            executor.submit(() -> {
                asyncResponse.resume(
                        getOneDatasetBiosamples(
                                id, requested_schema, skip, limit));
            });
        } else {
            asyncResponse.resume(
                    getOneDatasetBiosamples(
                            id, requested_schema, skip, limit));
        }        
    }

    @POST
    @Path("/datasets/{id}/biosamples")
    @Produces(MediaType.APPLICATION_JSON)
    default void postOneDatasetBiosamplesRequest(
            @PathParam("id") String id,
            BeaconRequestBody request,
            @Suspended AsyncResponse asyncResponse) {

        final ExecutorService executor = getExecutorService();
        if (executor != null) {
            executor.submit(() -> {
                asyncResponse.resume(
                        postOneDatasetBiosamplesRequest(id, request));
            });
        } else {
            asyncResponse.resume(
                    postOneDatasetBiosamplesRequest(id, request));
        }        
    }

    @GET
    @Path("/datasets/{id}/individuals")
    @Produces(MediaType.APPLICATION_JSON)    
    default void getOneDatasetIndividuals(
            @PathParam("id") String id,
            @QueryParam("requestedSchema") String requested_schema,
            @QueryParam("skip") Integer skip,
            @QueryParam("limit") Integer limit,
            @Suspended AsyncResponse asyncResponse) {

        final ExecutorService executor = getExecutorService();
        if (executor != null) {
            executor.submit(() -> {
                asyncResponse.resume(
                        getOneDatasetIndividuals(
                                id, requested_schema, skip, limit));
            });
        } else {
            asyncResponse.resume(
                    getOneDatasetIndividuals(
                            id, requested_schema, skip, limit));
        }        
    }

    @POST
    @Path("/datasets/{id}/individuals")
    @Produces(MediaType.APPLICATION_JSON)
    default void postOneDatasetIndividualsRequest(
            @PathParam("id") String id,
            BeaconRequestBody request,
            @Suspended AsyncResponse asyncResponse) {

        final ExecutorService executor = getExecutorService();
        if (executor != null) {
            executor.submit(() -> {
                asyncResponse.resume(
                        postOneDatasetIndividualsRequest(id, request));
            });
        } else {
            asyncResponse.resume(
                    postOneDatasetIndividualsRequest(id, request));
        }        
    }

}
