package nl.rosa.semanticdatabase.base.datavalues.text;

import com.google.common.base.MoreObjects;
import nl.rosa.semanticdatabase.base.datatype.CodePhrase;

import java.util.Objects;

/**
 * Originally: Created by pieter.bos on 04/11/15.
 */

/**
 * A text item whose value must be the rubric from a controlled terminology, the key (i.e. the 'code') of which is the
 * defining_code attribute. In other words: a DV_CODED_TEXT is a combination of a CODE_PHRASE (effectively a code)
 * and the rubric of that term, from a terminology service, in the language in which the data were authored.
 *
 * Since DV_CODED_TEXT is a subtype of DV_TEXT, it can be used in place of it, effectively allowing the type DV_TEXT
 * to mean a text item, which may optionally be coded.
 *
 * Misuse: If the intention is to represent a term code attached in some way to a fragment of plain text, DV_CODED_TEXT
 * should not be used; instead use a DV_TEXT and a TERM_MAPPING to a CODE_PHRASE.
 */
public class DvCodedText extends DvText {

    /**
     * The term of which the value attribute is the textual rendition (i.e. rubric).
     */
    private CodePhrase definingCode;


    public DvCodedText() {
    }

    public DvCodedText(String value, CodePhrase definingCode) {
        super(value);
        this.definingCode = definingCode;
    }

    public DvCodedText(String value,  CodePhrase language,  CodePhrase encoding, CodePhrase definingCode) {
        super(value, language, encoding);
        this.definingCode = definingCode;
    }

    public CodePhrase getDefiningCode() {
        return definingCode;
    }

    public void setDefiningCode(CodePhrase definingCode) {
        this.definingCode = definingCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        DvCodedText that = (DvCodedText) o;
        return getDefiningCode().equals(that.getDefiningCode());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getDefiningCode());
    }

    public String toString() {
        return MoreObjects.toStringHelper(this).add("defining_code", definingCode)
                .add("value", getValue())
                .toString();
    }
}
