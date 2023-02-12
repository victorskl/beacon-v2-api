package es.bsc.inb.ga4gh.beacon.model.v200.variations;

import java.io.Serializable;

public interface ValueType extends Serializable {

    Number getValue();
    void setValue(Number value);

    String getType();
    void setType(String type);
}
