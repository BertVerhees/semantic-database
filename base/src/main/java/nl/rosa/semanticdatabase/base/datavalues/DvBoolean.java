package nl.rosa.semanticdatabase.base.datavalues;

import java.util.Objects;

/**
 * Originally: Created by pieter.bos on 04/11/15.
 *
 *  * author:      "Rong Chen <rong@acode.se>"
 *  * support:     "Acode HB <support@acode.se>"
 *  * copyright:   "Copyright (c) 2004 Acode HB, Sweden"
 */
public class DvBoolean extends DataValue implements SingleValuedDataValue<Boolean> {

    public static final DvBoolean TRUE = new DvBoolean(true);

    /**
     * False value
     */
    public static final DvBoolean FALSE = new DvBoolean(false);

    private Boolean value;

    public DvBoolean(boolean value) {
        this.value = value;
    }

    public static DvBoolean valueOf(String value) {
        return Boolean.TRUE.toString().equals(value) ?
                TRUE : FALSE;
    }

    public static DvBoolean valueOf(boolean value) {
        return value ? TRUE : FALSE;
    }

    @Override
    public Boolean getValue() {
        return value;
    }

    @Override
    public void setValue(Boolean value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DvBoolean dvBoolean = (DvBoolean) o;
        return Objects.equals(value, dvBoolean.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
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
 *  The Original Code is DvBoolean.java
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
