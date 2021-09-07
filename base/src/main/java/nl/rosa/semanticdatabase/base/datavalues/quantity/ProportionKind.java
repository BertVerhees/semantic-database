package nl.rosa.semanticdatabase.base.datavalues.quantity;

/**
 * Created by pieter.bos on 01/03/16.
 */
public enum ProportionKind {
    RATIO(0), UNITARY(1), PERCENT(2), FRACTION(3), INTEGER_FRACTION(4);

    private final long pk;

    ProportionKind(long pk) {
        this.pk = pk;
    }

    public long getPk() {
        return pk;
    }

    public static ProportionKind fromValue(int value) {
        switch (value) {
            case 0:
                return RATIO;
            case 1:
                return UNITARY;
            case 2:
                return PERCENT;
            case 3:
                return FRACTION;
            case 4:
                return INTEGER_FRACTION;
            default:
                throw new IllegalArgumentException("unknown value");
        }
    }
}
