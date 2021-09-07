package nl.rosa.semanticdatabase.base.datavalues.encapsulated;

import nl.rosa.semanticdatabase.base.datatype.CodePhrase;
import nl.rosa.semanticdatabase.base.datavalues.SingleValuedDataValue;

import java.util.Objects;

/**
 * Originally: Created by pieter.bos on 04/11/15.
 */
public class DvParsable extends DvEncapsulated implements SingleValuedDataValue<String> {

    private String value;
    private String formalism;

    public DvParsable() {
    }

    public DvParsable(String value, String formalism) {
        this.value = value;
        this.formalism = formalism;
    }

    public DvParsable(CodePhrase charset, CodePhrase language, String value, String formalism) {
        super(charset, language);
        this.value = value;
        this.formalism = formalism;
    }

    @Override
    public String getValue() {
        return value;
    }

    @Override
    public void setValue(String value) {
        this.value = value;
    }

    public String getFormalism() {
        return formalism;
    }

    public void setFormalism(String formalism) {
        this.formalism = formalism;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        DvParsable that = (DvParsable) o;
        return Objects.equals(value, that.value) &&
                Objects.equals(formalism, that.formalism);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), value, formalism);
    }
}
