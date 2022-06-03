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

package es.bsc.inb.ga4gh.beacon.framework.model.v200.requests;

import es.bsc.inb.ga4gh.beacon.framework.model.v200.common.Pagination;
import java.util.List;

/**
 * @author Dmitry Repchevsky
 * 
 * @param <K> BeaconRequestParameters
 */

public class BeaconRequestQuery<K extends BeaconRequestParameters> {
    
    private K request_parameters;
    private List<BeaconQueryFilter> filters;
    private String include_resultset_responses;
    private Pagination pagination;
    private String granularity;
    private Boolean test_mode;
    
    public K getRequestParameters() {
        return request_parameters;
    }

    public void setRequestParameters(K request_parameters) {
        this.request_parameters = request_parameters;
    }

    public List<BeaconQueryFilter> getFilters() {
        return filters;
    }

    public void setFilters(List<BeaconQueryFilter> filters) {
        this.filters = filters;
    }
    
    public String getIncludeResultsetResponses() {
        return include_resultset_responses;
    }
    
    public void setIncludeResultsetResponses(String include_resultset_responses) {
        this.include_resultset_responses = include_resultset_responses;
    }
    
    public Pagination getPagination() {
        return pagination;
    }
    
    public void setPagination(Pagination pagination) {
        this.pagination = pagination;
    }

    public String getGranularity() {
        return granularity;
    }
    
    public void setGranularity(String granularity) {
        this.granularity = granularity;
    }

    public Boolean getTestMode() {
        return test_mode;
    }
    
    public void setTestMode(Boolean test_mode) {
        this.test_mode = test_mode;
    }

}
