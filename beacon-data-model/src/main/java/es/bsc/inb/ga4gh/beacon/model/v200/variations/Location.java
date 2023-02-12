package es.bsc.inb.ga4gh.beacon.model.v200.variations;

import java.io.Serializable;

public interface Location<I extends Interval> extends Serializable {

    String getType();
    void setType(String type);

    String getSequenceId();
    void setSequenceId(String sequenceId);

    I getInterval();
    void setInterval(I interval);
}
