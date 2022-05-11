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

package es.bsc.inb.ga4gh.beacon.framework;

import es.bsc.inb.ga4gh.beacon.framework.model.v200.responses.BeaconFilteringTermsResponse;
import es.bsc.inb.ga4gh.beacon.framework.model.v200.requests.BeaconRequestBody;
import es.bsc.inb.ga4gh.beacon.framework.model.v200.responses.BeaconCollectionsResponse;
import es.bsc.inb.ga4gh.beacon.framework.model.v200.responses.BeaconResultsetsResponse;

/**
 * GA4GH Beacon API Specification - Datasets Endpoints.
 * 
 * @author Dmitry Repchevsky
 */

public interface DatasetsInterface {

    /**
     * Get a list of datasets.
     * 
     * @param requested_schema
     * @param skip
     * @param limit
     * @return 
     */
    BeaconCollectionsResponse getDatasets(
            String requested_schema, Integer skip, Integer limit);
    
    /**
     * Get a list of datasets.
     * 
     * @param request
     * @return 
     */
    BeaconCollectionsResponse postDatasetsRequest(BeaconRequestBody request);
    
    /**
     * Get details about one dataset, identified by its (unique) 'id'.
     * 
     * @param id
     * @return 
     */
    BeaconResultsetsResponse getOneDataset(String id);
    
    /**
     * Get details about one dataset, identified by its (unique) 'id'.
     * 
     * @param id
     * @param request
     * @return 
     */
    BeaconResultsetsResponse postOneDatasetRequest(String id, BeaconRequestBody request);
    
    /**
     * Get details about one dataset, identified by its (unique) 'id'.
     * 
     * @param id
     * @param requested_schema
     * @param skip
     * @param limit
     * @return 
     */
    BeaconResultsetsResponse getOneDatasetGenomicVariants(
            String id, String requested_schema, Integer skip, Integer limit);

    /**
     * Get details about one dataset, identified by its (unique) 'id'.
     * 
     * @param id
     * @param request
     * @return 
     */
    BeaconResultsetsResponse postOneDatasetGenomicVariantsRequest(
            String id, BeaconRequestBody request);
    
    /**
     * 
     * @param id
     * @param requested_schema
     * @param skip
     * @param limit
     * @return 
     */
    BeaconResultsetsResponse getOneDatasetBiosamples(
            String id, String requested_schema, Integer skip, Integer limit);

    /**
     * Get the biosamples list from one dataset, identified by its (unique) 'id'.
     * 
     * @param id
     * @param request
     * @return 
     */
    BeaconResultsetsResponse postOneDatasetBiosamplesRequest(
            String id, BeaconRequestBody request);

    /**
     * Get the individuals list from one dataset, identified by its (unique) 'id'.
     * 
     * @param id
     * @param requested_schema
     * @param skip
     * @param limit
     * @return 
     */
    BeaconResultsetsResponse getOneDatasetIndividuals(
            String id, String requested_schema, Integer skip, Integer limit);

    /**
     * Get the individuals list from one dataset, identified by its (unique) 'id'.
     * 
     * @param id
     * @param request
     * @return 
     */
    BeaconResultsetsResponse postOneDatasetIndividualsRequest(
            String id, BeaconRequestBody request);

    /**
     * Get the list of filtering terms that could be used with a given dataset, identified by its (unique) 'id'.
     * 
     * @param skip
     * @param limit
     * @return 
     */
    BeaconFilteringTermsResponse getOneDatasetFilteringTerms(Integer skip, Integer limit);
    
    /**
     * Get the list of filtering terms that could be used with a given dataset, identified by its (unique) 'id'.
     * 
     * @param request
     * @return 
     */
    BeaconFilteringTermsResponse postOneDatasetFilteringTermsRequest(BeaconRequestBody request);
}
