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

package es.bsc.inb.ga4gh.beacon.framework.model.v200.responses;

import es.bsc.inb.ga4gh.beacon.framework.model.v200.common.SchemaPerEntity;
import java.util.List;

/**
 * @author Dmitry Repchevsky
 */

public class BeaconResponseMeta {
    
    private String beacon_id;
    private String api_version;
    private List<SchemaPerEntity> returned_schemas;
    private String returned_granularity;
    private Boolean test_mode;
    private BeaconReceivedRequestSummary received_request_summary;

    public String getBeaconId() {
        return beacon_id;
    }

    public void setBeaconId(String beacon_id) {
        this.beacon_id = beacon_id;
    }
    
    public String getApiVersion() {
        return api_version;
    }

    public void setApiVersion(String api_version) {
        this.api_version = api_version;
    }
    
    public List<SchemaPerEntity> getReturnedSchemas() {
        return returned_schemas;
    }

    public void setReturnedSchemas(List<SchemaPerEntity> returned_schemas) {
        this.returned_schemas = returned_schemas;
    }
    
    public String getReturnedGranularity() {
        return returned_granularity;
    }
    
    public void setReturnedGranularity(String returned_granularity) {
        this.returned_granularity = returned_granularity;
    }

    public Boolean getTestMode() {
        return test_mode;
    }
    
    public void setTestMode(Boolean test_mode) {
        this.test_mode = test_mode;
    }

    public BeaconReceivedRequestSummary getReceivedRequestSummary() {
        return received_request_summary;
    }

    public void setReceivedRequestSummary(BeaconReceivedRequestSummary received_request_summary) {
        this.received_request_summary = received_request_summary;
    }
}
