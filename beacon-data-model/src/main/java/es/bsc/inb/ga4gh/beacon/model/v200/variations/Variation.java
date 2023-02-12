package es.bsc.inb.ga4gh.beacon.model.v200.variations;

import java.io.Serializable;

public interface Variation<L extends Location> extends Serializable {

    String getVariantType();
    void setVariantType(String variantType);

    String getReferenceBases();
    void setReferenceBases(String referenceBases);

    String getAlternateBases();
    void setAlternateBases(String alternateBases);

    L getLocation();
    void setLocation(L location);
}
