package nl.rosa.semanticdatabase.base.datavalues.quantity;

/**
 * Created by pieter.bos on 04/11/15.
 */
public interface SingleValuedDataValue<Type> {

    Type getValue();

    void setValue(Type type);


}
