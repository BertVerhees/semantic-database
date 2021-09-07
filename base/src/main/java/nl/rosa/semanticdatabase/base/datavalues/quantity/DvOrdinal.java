package nl.rosa.semanticdatabase.base.datavalues.quantity;

import nl.rosa.semanticdatabase.base.datatype.CodePhrase;
import nl.rosa.semanticdatabase.base.datavalues.SingleValuedDataValue;
import nl.rosa.semanticdatabase.base.datavalues.text.DvCodedText;

import java.util.List;
import java.util.Objects;

/**
 * Created by pieter.bos on 04/11/15.
 */
public class DvOrdinal
        extends DvOrdered<DvOrdinal>
        implements SingleValuedDataValue<Long>, Comparable<DvOrdinal> {

    private DvCodedText symbol;
    private Long value;

    public DvOrdinal() {
    }

    /**
     * Test if two instances are strictly comparable. Effected in descendants.
     *
     * @param other
     * @return
     */
    @Override
    public Boolean isStrictlyComparableTo(DvOrdered<DvOrdinal> other) {
        return null;
    }

    @Override
    public Boolean lessThan(DvOrdered<DvOrdinal> other) {
        return null;
    }

    public DvOrdinal(Long value, DvCodedText symbol) {
        this.symbol = symbol;
        this.value = value;
    }

    public DvOrdinal(
            List<ReferenceRange<DvOrdinal>> otherReferenceRanges,
            DvInterval normalRange,
            Long value,
            DvCodedText symbol) {
        super(otherReferenceRanges, normalRange);
        this.symbol = symbol;
        this.value = value;
    }
    /**
     * Constructs an Ordinal by value and symbol
     *
     * @param value
     * @param dvCodedTextValue
     * @param dvCodedTextTerminology
     * @param dvCodedTextCode
     * @throws IllegalArgumentException
     */
    public DvOrdinal(
            Long value,
            String dvCodedTextValue,
            String dvCodedTextTerminology,
            String dvCodedTextCode) {
        this(
                null,
                null,
                value,
                new DvCodedText(
                        dvCodedTextValue,
                        new CodePhrase(
                                dvCodedTextTerminology,
                                dvCodedTextCode)
                )
        );
    }



    @Override
    public Long getValue() {
        return value;
    }

    @Override
    public void setValue(Long value) {
        this.value = value;
    }

    @Override
    public int compareTo(DvOrdinal o) {
        return value.compareTo(o.value);
    }


    public DvCodedText getSymbol() {
        return symbol;
    }

    public void setSymbol(DvCodedText symbol) {
        this.symbol = symbol;
    }

    public static DvOrdinal valueOf(String value) {
        int i = value.indexOf("|");
        if (i < 0) {
            throw new IllegalArgumentException("failed to parse DvOrdinal '" + value + "', wrong number of tokens.");
        }
        Long ordinalValue = 0L;
        try {
            ordinalValue = Long.parseLong(value.substring(0, i));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("failed to parse DvOrdinal '" + value + "', invalid integer value.");
        }
        String str = value.substring(i + 1);
        i = str.indexOf("|");
        if (i < 0) {
            throw new IllegalArgumentException("failed to parse DvCodedText '" + str + "', wrong number of tokens.");
        }
        value = str.substring(i+1);
        if(value.contains("|")){
            value = value.substring(0,value.lastIndexOf('|'));
        }
        i = str.indexOf("|");
        if (i < 0) {
            throw new IllegalArgumentException("failed to parse CodePhrase '" + str.substring(0,i) + "', wrong number of tokens.");
        }
        CodePhrase codePhrase = new CodePhrase(str.substring(0,i));
        DvCodedText codedText = new DvCodedText(value,codePhrase);
        return new DvOrdinal(ordinalValue, codedText);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        DvOrdinal dvOrdinal = (DvOrdinal) o;
        return Objects.equals(symbol, dvOrdinal.symbol) &&
                Objects.equals(value, dvOrdinal.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), symbol, value);
    }
}
