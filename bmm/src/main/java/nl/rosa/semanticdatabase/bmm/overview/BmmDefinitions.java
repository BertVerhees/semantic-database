package nl.rosa.semanticdatabase.bmm.overview;

import java.util.Objects;

import semanticdatabase.base.base_types.definitions_package.BasicDefinitions;
import nl.rosa.semanticdatabase.bmm.classes.BmmSimpleClass;
import nl.rosa.semanticdatabase.bmm.types.BmmSimpleType;

/**
 * #Generated: 2020-11-26T17:29:11.503+01:00
 * #Copyright: Bert Verhees
 * #License: See bottom of file
 * <p>
 * Definitions used by all BMM packages.
 */
public class BmmDefinitions extends BasicDefinitions {

    //***** BmmDefinitions *****

    /*=========================================================*/
    /* * FIELDS * */
    /*=========================================================*/

    /**
     * Current internal version of BMM meta-model, used to determine if a given schema can be processed by a given implementation of the model.
     * cardinality: 1..1
     */
    private String bmmInternalVersion;

    /*=========================================================*/
    /* * POJOS * */
    /*=========================================================*/

    /**
     * Current internal version of BMM meta-model, used to determine if a given schema can be processed by a given implementation of the model.
     * cardinality: 1..1
     */
    public String getBmmInternalVersion() {
        return bmmInternalVersion;
    }

    public void setBmmInternalVersion(String value) {
        if (value == null) {
            throw new NullPointerException(" Setting property:bmmInternalVersion failed, it has cardinality NonNull, but is null");
        }
        this.bmmInternalVersion = bmmInternalVersion;
    }

    /*=========================================================*/
    /* * FUNCTIONS * */
    /*=========================================================*/

    /**
     * built-in class definition corresponding to the top `Any' class.
     * cardinality: 1..1
     */
    public BmmSimpleClass anyClass() {
        BmmSimpleClass result = null;


        if (result == null) {
            throw new NullPointerException("Return-value has cardinality NonNull, but is null.");
        }
        return result;
    }

    /**
     * Built-in type definition corresponding to the top `Any' type.
     * cardinality: 1..1
     */
    public BmmSimpleType anyType() {
        BmmSimpleType result = null;


        if (result == null) {
            throw new NullPointerException("Return-value has cardinality NonNull, but is null.");
        }
        return result;
    }

    /**
     * Create schema id, formed from: a_model_publisher '-' a_schema_name '-' a_model_release e.g.
     * openehr_rm_1.0.3, openehr_test_1.0.1, iso_13606_1_2008_2.1.2.
     * cardinality: 1..1
     */
    public String createSchemaId(,, String a_model_release) {
        if (a_model_release == null) {
            throw new NullPointerException("Parameter a_model_release has cardinality NonNull, but is null.");
        }
        String result = null;


        if (result == null) {
            throw new NullPointerException("Return-value has cardinality NonNull, but is null.");
        }
        return result;
    }

    /*=========================================================*/
    /* * CONSTANTS * */
    /*=========================================================*/

    /**
     * Delimiter used to separate schema id from package path in a fully qualified path.
     */
    final String schemaNameDelimiter = "::";

    /**
     * Delimiter used to separate package names in a package path.
     */
    final String packageNameDelimiter = ".";

    /**
     * Extension used for BMM files.
     */
    final String bmmSchemaFileExtension = ".bmm";

    /**
     * Appears between a name and a type in a declaration or type signature.
     */
    final Character typeDelimiter = ':';

    /**
     * Left delimiter for generic class and generic type names, as used in List<T>.
     */
    final Character genericLeftDelimiter = '<';

    /**
     * Right delimiter for generic class and generic type names, as used in List<T>.
     */
    final Character genericRightDelimiter = '>';

    /**
     * Separator used in Generic types.
     */
    final Character genericSeparator = ',';

    /**
     * Delimiter between formal type parameter and constraint type, as used in Sortable<T: Ordered>.
     */
    final Character genericConstraintDelimiter = ':';

    /**
     * Left delimiter of a Tuple type and also instance.
     * Example: [Integer, String] - a tuple type; [3, "Quixote"] - a tuple.
     */
    final Character tupleLeftDelim = '[';

    /**
     * Right delimiter of a Tuple type and also instance.
     */
    final Character tupleRightDelim = ']';

    /**
     * Separator used in Tuple types and instances.
     */
    final Character tupleSeparator = ',';

    /**
     * Left delimiter used in serial form of instance constrained enumeration.
     */
    final Character constraintLeftDelim = '«';

    /**
     * Right delimiter used in serial form of instance constrained enumeration.
     */
    final Character constraintRightDelim = '»';

    /**
     * Attribute name of logical attribute 'bmm_version' in .bmm schema file.
     */
    final String metadataBmmVersion = "bmm_version";

    /**
     * Attribute name of logical attribute 'schema_name' in .bmm schema file.
     */
    final String metadataSchemaName = "schema_name";

    /**
     * Attribute name of logical attribute 'rm_publisher' in .bmm schema file.
     */
    final String metadataRmPublisher = "rm_publisher";

    /**
     * Attribute name of logical attribute 'rm_release' in .bmm schema file.
     */
    final String metadataRmRelease = "rm_release";

    /**
     * Attribute name of logical attribute 'schema_revision' in .bmm schema file.
     */
    final String metadataSchemaRevision = "schema_revision";

    /**
     * Attribute name of logical attribute 'schema_lifecycle_state' in .bmm schema file.
     */
    final String metadataSchemaLifecycleState = "schema_lifecycle_state";

    /**
     * Attribute name of logical attribute 'schema_description' in .bmm schema file.
     */
    final String metadataSchemaDescription = "schema_description";

    /**
     * Path of schema file.
     */
    final String metadataSchemaPath = "schema_path";

    //***** BmmDefinitions *****

    /*=========================================================*/
    /* * BUILD PATTERN AND CONSTRUCTOR * */
    /*=========================================================*/


    protected BmmDefinitions() {
    }

    public BmmDefinitions(
            String bmmInternalVersion
    ) {
        if (bmmInternalVersion == null) {
            throw new NullPointerException("Property:bmmInternalVersion has cardinality NonNull, but is null");
        }
        this.bmmInternalVersion = bmmInternalVersion;
    }

    private BmmDefinitions(Builder builder) {
        this.setBmmInternalVersion(builder.bmmInternalVersion);
    }

    public static class Builder {
        private final String bmmInternalVersion;  //required

        public Builder(
                String bmmInternalVersion
        ) {
            if (bmmInternalVersion == null) {
                throw new NullPointerException("Property:bmmInternalVersion has cardinality NonNull, but is null");
            }
            this.bmmInternalVersion = bmmInternalVersion;
        }

        public BmmDefinitions build() {
            return new BmmDefinitions(this);
        }
    }


    //***** BmmDefinitions *****

    /*=========================================================*/
    /* * TOSTRING, EQUALS AND HASHCODE * */
    /*=========================================================*/


    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        BmmDefinitions that = (BmmDefinitions) object;
        return
                Objects.equals(bmmInternalVersion, that.bmmInternalVersion);
    }

    public int hashCode() {
        return Objects.hash(
                super.hashCode(),
                bmmInternalVersion
        );
    }

    @Override
    public String toString() {
        return
                "BmmDefinitions {" +
                        "bmmInternalVersion='" + bmmInternalVersion + '\'' +
                        '}';
    }

}

/**
 * ***** BEGIN LICENSE BLOCK *****
 * <p>
 * ISC License
 * <p>
 * Copyright (c) 2020, Bert Verhees
 * <p>
 * Permission to use, copy, modify, and/or distribute this software for any
 * purpose with or without fee is hereby granted, provided that the above
 * copyright notice and this permission notice appear in all copies.
 * <p>
 * THE SOFTWARE IS PROVIDED "AS IS" AND THE AUTHOR DISCLAIMS ALL WARRANTIES
 * WITH REGARD TO THIS SOFTWARE INCLUDING ALL IMPLIED WARRANTIES OF
 * MERCHANTABILITY AND FITNESS.
 * IN NO EVENT SHALL THE AUTHOR BE LIABLE FOR
 * ANY SPECIAL, DIRECT, INDIRECT, OR CONSEQUENTIAL DAMAGES OR ANY DAMAGES
 * WHATSOEVER RESULTING FROM LOSS OF USE, DATA OR PROFITS, WHETHER IN AN
 * ACTION OF CONTRACT, NEGLIGENCE OR OTHER TORTIOUS ACTION, ARISING OUT OF
 * OR IN CONNECTION WITH THE USE OR PERFORMANCE OF THIS SOFTWARE.
 * <p>
 * ***** END LICENSE BLOCK *****
 */
