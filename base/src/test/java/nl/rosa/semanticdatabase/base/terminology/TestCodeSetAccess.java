/*
 * component:   "openEHR Reference Implementation"
 * description: "Class TestCodeSetAccess"
 * keywords:    "unit test"
 *
 * author:      "Rong Chen <rong@acode.se>"
 * support:     "Acode HB <support@acode.se>"
 * copyright:   "Copyright (c) 2004 Acode HB, Sweden"
 * license:     "See notice at bottom of class"
 *
 * file:        "$URL: http://svn.openehr.org/ref_impl_java/BRANCHES/Release-1.0/libraries/src/test/org/openehr/rm/support/terminology/TestCodeSetAccess.java $"
 * revision:    "$LastChangedRevision: 2 $"
 * last_change: "$LastChangedDate: 2005-10-12 22:20:08 +0100 (Wed, 12 Oct 2005) $"
 */
package nl.rosa.semanticdatabase.base.terminology;


import nl.rosa.semanticdatabase.base.datatype.CodePhrase;
import nl.rosa.semanticdatabase.base.datavalues.DvState;
import nl.rosa.semanticdatabase.base.datavalues.text.DvCodedText;
import nl.rosa.semanticdatabase.base.identification.TerminologyId;

import java.util.HashSet;
import java.util.Set;

/**
 * TestCodeSetAccess
 * 
 * @author Rong Chen
 * @version 1.0
 */
public class TestCodeSetAccess implements CodeSetAccess {

    /* fields */
    /**
     * Returns identification of this Terminology
     *
     * @return ID not null or empty
     */
    public String id() {
        return null;  // todo: implement this method
    }

    /**
     * Returns all codes known in this terminology
     *
     * @return Set of DvCodePhrase
     */
    public Set<CodePhrase> allCodes() {
        return allCodes;  // todo: implement this method
    }

    /**
     * Return true if this codeSet contains given codePhrase
     *
     * @param code
     * @return true if has
     */
    @Override
    public boolean hasCode(CodePhrase code) {
        return true;//allCodes.contains(code);
    }

    public boolean hasLang(CodePhrase lang) {
        return true;//allCodes.contains(lang);
    }

    public static final CodePhrase ENGLISH = new CodePhrase(new TerminologyId("test"), "en");
    public static final CodePhrase LATIN_1 = new CodePhrase(new TerminologyId("test"),
            "iso-8859-1");
    public static final CodePhrase NULL_FLAVOUR = new CodePhrase(new TerminologyId("test"),
            "unanswered");
    
    static final Set<CodePhrase> allCodes;
    
    static {
        allCodes = new HashSet<CodePhrase>();
        allCodes.add(ENGLISH);
        allCodes.add(LATIN_1);
        allCodes.add(NULL_FLAVOUR);        
    }
    
    // change type
    public static final DvCodedText AMENDMENT =
            new DvCodedText(
                    "creation",
                    ENGLISH,
                    LATIN_1,
                    new CodePhrase(new TerminologyId("test"), "creation"));
    
    public static final DvCodedText SETTING =
            new DvCodedText(
            "setting",
            ENGLISH,
            LATIN_1,
            new CodePhrase(new TerminologyId("test"), "setting_code"));

    public static final DvCodedText ISM_ACTIVE =
            new DvCodedText(
            "ism states",
            ENGLISH,
            LATIN_1,
            new CodePhrase(new TerminologyId("test"), "active"));
    
    // composition category
    public static final DvCodedText EVENT =
            new DvCodedText(
            "event",
            ENGLISH,
            LATIN_1,
            new CodePhrase(new TerminologyId("test"), "event"));

    public static final DvCodedText PERSISTENT =
            new DvCodedText(
            "persistent",
            ENGLISH,
            LATIN_1,
            new CodePhrase(new TerminologyId("test"), "persistent"));
    
    // lifecycle state
    public static final DvState DRAFT =
            new DvState(
            new DvCodedText(
                    "draft",
                    new CodePhrase(new TerminologyId("test"), "draft"),
                    ENGLISH,
                    LATIN_1),
            false);
}

/*
 *  ***** BEGIN LICENSE BLOCK *****
 *  Version: MPL 1.1/GPL 2.0/LGPL 2.1
 *
 *  The contents of this file are subject to the Mozilla Public License Version
 *  1.1 (the 'License'); you may not use this file except in compliance with
 *  the License. You may obtain a copy of the License at
 *  http://www.mozilla.org/MPL/
 *
 *  Software distributed under the License is distributed on an 'AS IS' basis,
 *  WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License
 *  for the specific language governing rights and limitations under the
 *  License.
 *
 *  The Original Code is TestCodeSetAccess.java
 *
 *  The Initial Developer of the Original Code is Rong Chen.
 *  Portions created by the Initial Developer are Copyright (C) 2003-2004
 *  the Initial Developer. All Rights Reserved.
 *
 *  Contributor(s):
 *
 * Software distributed under the License is distributed on an 'AS IS' basis,
 * WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License
 * for the specific language governing rights and limitations under the
 * License.
 *
 *  ***** END LICENSE BLOCK *****
 */