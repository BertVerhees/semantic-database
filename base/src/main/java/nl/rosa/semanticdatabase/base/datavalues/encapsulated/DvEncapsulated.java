package nl.rosa.semanticdatabase.base.datavalues.encapsulated;


import nl.rosa.semanticdatabase.base.datatype.CodePhrase;
import nl.rosa.semanticdatabase.base.datavalues.DataValue;
import nl.rosa.semanticdatabase.base.terminology.OpenEHRCodeSetIdentifiers;
import nl.rosa.semanticdatabase.base.terminology.TerminologyService;

import java.util.Objects;

/**
 * Originally: Created by pieter.bos on 04/11/15.
 */
public abstract class DvEncapsulated extends DataValue {
    private CodePhrase charset;
    private CodePhrase language;


    public DvEncapsulated() {
    }

    public DvEncapsulated(CodePhrase charset, CodePhrase language) {
        this.charset = charset;
        this.language = language;
    }

    public CodePhrase getCharset() {
        return charset;
    }

    public void setCharset(CodePhrase charset) {
        this.charset = charset;
    }

    public CodePhrase getLanguage() {
        return language;
    }

    public void setLanguage(CodePhrase language) {
        this.language = language;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DvEncapsulated that = (DvEncapsulated) o;
        return Objects.equals(charset, that.charset) &&
                Objects.equals(language, that.language);
    }

    @Override
    public int hashCode() {
        return Objects.hash(charset, language);
    }
}
