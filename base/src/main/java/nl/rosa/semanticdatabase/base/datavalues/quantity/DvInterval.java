package nl.rosa.semanticdatabase.base.datavalues.quantity;

import nl.rosa.semanticdatabase.base.datavalues.DataValue;
import nl.rosa.semanticdatabase.utils.interval.Interval;

import java.util.Objects;

/**
 * Created by pieter.bos on 04/11/15.
 */
public class DvInterval<Type extends DvOrdered> extends DataValue {

    private final Interval<DvOrdered> interval;

    public DvInterval() {
        interval = new Interval<>();
    }

    public DvInterval(Type lower, Type upper) {
        interval = new Interval<>(lower, upper);
    }

    
    public DvOrdered getLower() {
        return interval.getLower();
    }

    public void setLower(DvOrdered lower) {
        interval.setLower(lower);
    }

    
    public DvOrdered getUpper() {
        return interval.getUpper();
    }

    public void setUpper(DvOrdered upper) {
        interval.setUpper(upper);
    }

    public boolean isLowerUnbounded() {
        return interval.isLowerUnbounded();
    }

    public void setLowerUnbounded(boolean lowerUnbounded) {
        interval.setLowerUnbounded(lowerUnbounded);
    }

    public boolean isUpperUnbounded() {
        return interval.isUpperUnbounded();
    }

    public void setUpperUnbounded(boolean upperUnbounded) {
        interval.setUpperUnbounded(upperUnbounded);
    }

    public boolean isLowerIncluded() {
        return interval.isLowerIncluded();
    }

    public void setLowerIncluded(boolean lowerIncluded) {
        interval.setLowerIncluded(lowerIncluded);
    }

    public boolean isUpperIncluded() {
        return interval.isUpperIncluded();
    }

    public void setUpperIncluded(boolean upperIncluded) {
        interval.setUpperIncluded(upperIncluded);
    }

    public boolean has(DvOrdered value) {
        return interval.has(value);
    }

    public String toString() {
        return interval.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DvInterval<?> that = (DvInterval<?>) o;
        return Objects.equals(interval, that.interval);
    }

    @Override
    public int hashCode() {
        return Objects.hash(interval);
    }
}
