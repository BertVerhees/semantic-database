package nl.rosa.semanticdatabase.base.datavalues.timespecification;

import nl.rosa.semanticdatabase.base.datavalues.DataValue;
import nl.rosa.semanticdatabase.base.datavalues.encapsulated.DvParsable;

import java.util.Objects;

/**
 * Originally: Created by pieter.bos on 08/07/16.
 */
public abstract class DvTimeSpecification extends DataValue {

    private DvParsable value;

    public DvTimeSpecification() {
    }

    public DvTimeSpecification(DvParsable value) {
        if(value == null) {
            throw new IllegalArgumentException("Cannot create DvTimeSpecification with null value");
        }
        this.value = value;
    }

    public DvParsable getValue() {
        return value;
    }

    public void setValue(DvParsable value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DvTimeSpecification that = (DvTimeSpecification) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
