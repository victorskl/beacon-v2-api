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

import es.bsc.inb.ga4gh.beacon.framework.model.v200.responses.EntryTypesResponse;
import jakarta.json.bind.Jsonb;
import jakarta.json.bind.JsonbBuilder;
import org.junit.Test;

/**
 * @author Dmitry Repchevsky
 */

public class EntryTypesResponseTest {
    
    public final static String ENTRY_TYPE_RESPONSE =
            "{" +
            "  \"meta\": {" +
            "    \"beaconId\": \"abcd\"," +
            "    \"apiVersion\": \"v2.0\"" +
            "  }," +
            "  \"entryTypes\": {" +
            "    \"type1\": {" +
            "      \"$schema\": \"schema1\"," +
            "      \"id\": \"identifier1\"" +
            "    }," +
            "    \"type2\": {" +
            "      \"$schema\": \"schema2\"," +
            "      \"id\": \"identifier2\"" +
            "    }" +
            "  }" +
            "}";
    
    @Test
    public void deserialize() {
        final Jsonb jsonb = JsonbBuilder.create();
        final EntryTypesResponse response = jsonb.fromJson(ENTRY_TYPE_RESPONSE, EntryTypesResponse.class);
        
        // todo
    }
}
