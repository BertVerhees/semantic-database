package nl.rosa.semanticdatabase.base.datavalues.text;

import nl.rosa.semanticdatabase.base.datatype.CodePhrase;
import nl.rosa.semanticdatabase.base.datavalues.DataValue;
import nl.rosa.semanticdatabase.base.datavalues.DvURI;
import nl.rosa.semanticdatabase.base.datavalues.SingleValuedDataValue;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Originally: Created by pieter.bos on 04/11/15.
 */

/**
 * A text item, which may contain any amount of legal characters arranged as e.g. words, sentences etc
 * (i.e. one DV_TEXT may be more than one word). Visual formatting and hyperlinks may be included via markdown.
 *
 * If the formatting field is set, the value field is affected as follows:
 * formatting = "plain": plain text, may contain newlines;
 * formatting = "plain_no_newlines": plain text with no newlines;
 * formatting = "markdown": text in markdown format; use of CommonMark strongly recommended.
 * A DV_TEXT can be coded by adding mappings to it.
 */
public class DvText extends DataValue implements SingleValuedDataValue<String> {

    /**
     * Displayable rendition of the item, regardless of its underlying structure. For DV_CODED_TEXT,
     * this is the rubric of the complete term as provided by the terminology service.
     */
    private String value;
    /**
     * DEPRECATED: this field is deprecated; use markdown link/text in the value attribute, and "markdown" as the value of the formatting field.
     *
     * Original usage, prior to RM Release 1.0.4: Optional link sitting behind a section of plain text or coded term item.
     */
    @Deprecated
    private DvURI hyperlink;
    /**
     * If set, contains one of the following values:
     * "plain": use for plain text, possibly containing newlines, but otherwise unformatted (same as Void);
     * "plain_no_newlines": use for text containing no newlines or other formatting;
     * "markdown": use for markdown formatted text, strongly recommended in the format of the CommonMark specification.
     * DEPRECATED usage: contains a string of the form "name:value; name:value…​" , e.g.
     * "font-weight : bold; font-family : Arial; font-size : 12pt;". Values taken from W3C CSS2 properties lists for background and font
     */
    @Deprecated
    private String formatting;
    /**
     * Terms from other terminologies most closely matching this term, typically used where the originator
     * (e.g. pathology lab) of information uses a local terminology but also supplies one or more equivalents
     * from well known terminologies (e.g. LOINC).
     */
    private List<TermMapping> mappings = new ArrayList<>();
    /**
     * Optional indicator of the localised language in which the value is written. Coded from openEHR Code Set languages .
     * Only used when either the text object is in a different language from the enclosing ENTRY,
     * or else the text object is being used outside of an ENTRY or other enclosing structure which indicates the language.
     */
    private CodePhrase language;
    /**
     * Name of character encoding scheme in which this value is encoded. Coded from openEHR Code Set character sets .
     * Unicode is the default assumption in openEHR, with UTF-8 being the assumed encoding. This attribute allows
     * for variations from these assumptions.
     */
    private CodePhrase encoding;

    public DvText() {

    }

    public DvText(String value) {
        this.value = value;
    }

    public DvText(String value, CodePhrase language, CodePhrase encoding) {
        this.value = value;
        this.language = language;
        this.encoding = encoding;
    }

    public List<TermMapping> getMappings() {
        return mappings;
    }

    public void setMappings(List<TermMapping> mappings) {
        this.mappings = mappings;
    }

    public void addMapping(TermMapping mapping) {
        this.mappings.add(mapping);
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public DvURI getHyperlink() {
        return hyperlink;
    }

    public void setHyperlink(DvURI hyperlink) {
        this.hyperlink = hyperlink;
    }

    public String getFormatting() {
        return formatting;
    }

    public void setFormatting(String formatting) {
        this.formatting = formatting;
    }

    public CodePhrase getLanguage() {
        return language;
    }

    public void setLanguage(CodePhrase language) {
        this.language = language;
    }

    public CodePhrase getEncoding() {
        return encoding;
    }

    public void setEncoding(CodePhrase encoding) {
        this.encoding = encoding;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DvText dvText = (DvText) o;
        return Objects.equals(value, dvText.value) &&
                Objects.equals(hyperlink, dvText.hyperlink) &&
                Objects.equals(formatting, dvText.formatting) &&
                Objects.equals(mappings, dvText.mappings) &&
                Objects.equals(language, dvText.language) &&
                Objects.equals(encoding, dvText.encoding);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, hyperlink, formatting, mappings, language, encoding);
    }

    @Override
    public String toString() {
        return "DvText{" +
                "value='" + value + '\'' +
                ", hyperlink=" + hyperlink +
                ", formatting='" + formatting + '\'' +
                ", mappings=" + mappings +
                ", language=" + language +
                ", encoding=" + encoding +
                '}';
    }
}
