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

import es.bsc.inb.ga4gh.beacon.framework.model.v200.common.Handover;
import jakarta.json.JsonObject;
import java.util.List;

/**
 * @author Dmitry Repchevsky
 */

public class BeaconResultset {

    private String id;
    private String set_type;
    private Boolean exists;
    private Integer results_count;
    private List results;
    private List<Handover> results_handovers;
    private JsonObject info;
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
    public String getSetType() {
        return set_type;
    }

    public void setSetType(String set_type) {
        this.set_type = set_type;
    }

    public boolean getExists() {
        return exists;
    }
    
    public void setExists(Boolean exists) {
        this.exists = exists;
    }

    public Integer getResultsCount() {
        return results_count;
    }
    
    public void setResultsCount(Integer results_count) {
        this.results_count = results_count;
    }

    public <T> List<T> getResults() {
        return results;
    }

    public void setResults(List results) {
        this.results = results;
    }

    public List<Handover> getResultsHandovers() {
        return results_handovers;
    }
    
    public void setResultsHandovers(List<Handover> results_handovers) {
        this.results_handovers = results_handovers;
    }
    
    public JsonObject getInfo() {
        return info;
    }

    public void setInfo(JsonObject info) {
        this.info = info;
    }

}
