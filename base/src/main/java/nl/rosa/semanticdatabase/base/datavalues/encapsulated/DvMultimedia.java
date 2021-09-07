package nl.rosa.semanticdatabase.base.datavalues.encapsulated;


import nl.rosa.semanticdatabase.base.datatype.CodePhrase;
import nl.rosa.semanticdatabase.base.datavalues.DvURI;
import nl.rosa.semanticdatabase.base.terminology.OpenEHRCodeSetIdentifiers;
import nl.rosa.semanticdatabase.base.terminology.TerminologyService;

import java.util.Arrays;
import java.util.Objects;

/**
 * Originally: Created by pieter.bos on 04/11/15.
 */

public class DvMultimedia extends DvEncapsulated {

    public DvMultimedia( CodePhrase charset,
                         CodePhrase language,
                         String alternateText,
                         CodePhrase mediaType,
                         CodePhrase compressionAlgorithm,
                         byte[] integrityCheck,
                         CodePhrase integrityCheckAlgorithm,
                         DvMultimedia thumbnail,
                         DvURI uri,
                         byte[] data,
                         TerminologyService terminologyService) {

        super(charset, language);

        if (mediaType == null) {
            throw new IllegalArgumentException("null mediaType");
        }
        if (compressionAlgorithm == null) {
            throw new IllegalArgumentException("null compressionAlgorithm");
        }
        if (integrityCheck != null &&
                integrityCheckAlgorithm == null) {
            throw new IllegalArgumentException(
                    "null integrity check algorithm");
        }
        if (uri == null && data == null) {
            throw new IllegalArgumentException("both uri and ata are null");
        }
        this.alternateText = alternateText;
        this.mediaType = mediaType;
        this.compressionAlgorithm = compressionAlgorithm;
        this.integrityCheck = integrityCheck;
        this.integrityCheckAlgorithm = integrityCheckAlgorithm;
        this.thumbnail = thumbnail;
        this.uri = uri;
        this.data = data;
    }
    
    private String alternateText;
    private DvURI uri;
    private byte[] data;
    private CodePhrase mediaType;//TODO: construct default codephrase with mime type already set as terminology id
    private CodePhrase compressionAlgorithm;
    private byte[] integrityCheck;
    private CodePhrase integrityCheckAlgorithm;
    private Integer size;
    private DvMultimedia thumbnail;

    public String getAlternateText() {
        return alternateText;
    }

    public void setAlternateText( String alternateText) {
        this.alternateText = alternateText;
    }

    
    public DvURI getUri() {
        return uri;
    }

    public void setUri( DvURI uri) {
        this.uri = uri;
    }

    
    public byte[] getData() {
        return data;
    }

    public void setData( byte[] data) {
        this.data = data;
    }

    public CodePhrase getMediaType() {
        return mediaType;
    }

    public void setMediaType(CodePhrase mediaType) {
        this.mediaType = mediaType;
    }

    
    public CodePhrase getCompressionAlgorithm() {
        return compressionAlgorithm;
    }

    public void setCompressionAlgorithm( CodePhrase compressionAlgorithm) {
        this.compressionAlgorithm = compressionAlgorithm;
    }

    
    public byte[] getIntegrityCheck() {
        return integrityCheck;
    }

    public void setIntegrityCheck( byte[] integrityCheck) {
        this.integrityCheck = integrityCheck;
    }


    
    public DvMultimedia getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail( DvMultimedia thumbnail) {
        this.thumbnail = thumbnail;
    }

    
    public CodePhrase getIntegrityCheckAlgorithm() {
        return integrityCheckAlgorithm;
    }

    public void setIntegrityCheckAlgorithm( CodePhrase integrityCheckAlgorithm) {
        this.integrityCheckAlgorithm = integrityCheckAlgorithm;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }




    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        DvMultimedia that = (DvMultimedia) o;
        return Objects.equals(alternateText, that.alternateText) &&
                Objects.equals(uri, that.uri) &&
                Arrays.equals(data, that.data) &&
                Objects.equals(mediaType, that.mediaType) &&
                Objects.equals(compressionAlgorithm, that.compressionAlgorithm) &&
                Arrays.equals(integrityCheck, that.integrityCheck) &&
                Objects.equals(integrityCheckAlgorithm, that.integrityCheckAlgorithm) &&
                Objects.equals(size, that.size) &&
                Objects.equals(thumbnail, that.thumbnail);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(super.hashCode(), alternateText, uri, mediaType, compressionAlgorithm, integrityCheckAlgorithm, size, thumbnail);
        result = 31 * result + Arrays.hashCode(data);
        result = 31 * result + Arrays.hashCode(integrityCheck);
        return result;
    }
}
