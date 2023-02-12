package es.bsc.inb.ga4gh.beacon.model.v200.variations;

import java.io.Serializable;

public interface Interval<VT extends ValueType> extends Serializable {

    VT getStart();
    void setStart(VT start);

    VT getEnd();
    void setEnd(VT end);

    String getType();
    void setType(String type);
}
