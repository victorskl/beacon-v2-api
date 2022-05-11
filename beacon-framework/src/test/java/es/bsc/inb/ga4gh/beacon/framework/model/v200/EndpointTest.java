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

package es.bsc.inb.ga4gh.beacon.framework.model.v200;

import es.bsc.inb.ga4gh.beacon.framework.model.v200.configuration.Endpoint;
import es.bsc.inb.ga4gh.beacon.framework.model.v200.configuration.RelatedEndpoint;
import jakarta.json.bind.Jsonb;
import jakarta.json.bind.JsonbBuilder;
import java.util.HashMap;
import java.util.Map;
import org.junit.Test;

/**
 * @author Dmitry Repchevsky
 */

public class EndpointTest {
    
    public final static String ENDPOINT_JSON = 
        "{" +
        "  \"endpoints\":{\"property1\":{\"returnedEntryType\":\"endpoint\",\"url\":\"https://www.bsc.es\"}},\"entryType\":\"root\"" +
        "}";

    @Test
    public void serialize() {
        Endpoint endpoint = new Endpoint();
        endpoint.setEntryType("root");
        Map<String, RelatedEndpoint> endpoints = new HashMap();
        endpoints.put("property1", new RelatedEndpoint("https://www.bsc.es", "endpoint"));
        endpoint.setEndpoints(endpoints);
        
        final Jsonb jsonb = JsonbBuilder.create();
        final String s = jsonb.toJson(endpoint);
    }
    
    @Test
    public void deserialize() {
        final Jsonb jsonb = JsonbBuilder.create();
        final Endpoint endpoint = jsonb.fromJson(ENDPOINT_JSON, Endpoint.class);
    }
}
