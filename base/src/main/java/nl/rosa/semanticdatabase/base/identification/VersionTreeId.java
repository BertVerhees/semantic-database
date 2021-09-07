package nl.rosa.semanticdatabase.base.identification;

import java.util.Objects;

/**
 * Originally: Created by pieter.bos on 08/07/16.
 * * @author Yin Su Lim
 *  * @version 1.0
 */
public class VersionTreeId  {

    private String PATTERN = "[1-9](\\d)*(\\.(\\d)+\\.(\\d)+)?";
    private String trunkVersion;
    private String branchNumber;
    private String branchVersion;

    private String value;

    public VersionTreeId() {
    }


    public VersionTreeId(String value) {
        if(value==null || value.isEmpty()){
            throw new IllegalArgumentException("Null or Empty value in VersionId string-construct");
        }
        loadValue(value);
    }

    private void loadValue(String value) {
        if (!value.matches(PATTERN)) {
            throw new IllegalArgumentException("wrong format");
        }
        int branch = value.indexOf(".");
        if (branch < 0) { // no branch, just trunk
            //validateValues(Integer.parseInt(value), 0, 0);
            this.trunkVersion = value;
            this.value = value;
        } else {
            String[] entries = value.split("\\.");
            //System.out.println("in loadValues, size of entries:" + entries.length);
            validateValues(Integer.parseInt(entries[0]), Integer.parseInt(entries[1]),
                    Integer.parseInt(entries[2]));
            this.trunkVersion = entries[0];
            //never set branchNo or branchV to 0
            if(Integer.parseInt(entries[1]) > 0) {
                this.branchNumber = entries[1];
                this.branchVersion = entries[2];
                this.value = value;
            } else {
                this.value = entries[0];
            }
        }
    }

    public VersionTreeId(int trunkVersion, int branchNumber,
                         int branchVersion) {
        validateValues(trunkVersion, branchNumber, branchVersion);
        String trunk = Integer.toString(trunkVersion);
        this.trunkVersion = trunk;
        if(branchNumber > 0 ) {
            this.value = trunk + "." + branchNumber +  "." + branchVersion;
            this.branchNumber = Integer.toString(branchNumber);
            this.branchVersion = Integer.toString(branchVersion);
        } else {
            this.value = trunk;
        }
    }

    private void validateValues(int trunk, int branchNo, int branchV) {
        if (trunk < 1) {
            throw new IllegalArgumentException("trunk number smaller than 1");
        }
        if (branchNo < 0 || branchV < 0) {
            throw new IllegalArgumentException("version number smaller than 0");
        }
        //0 for branchNo or branchV is special case,
        //where both must be 0 to indicate no branch
        if (branchNo == 0 || branchV == 0) {
            if (branchV != branchNo) {
                throw new IllegalArgumentException("breach of branch_validity");
            }
        }
    }

    public String getValue() {
        return value;
    }

    /**
     * Trunk version number
     *
     *@return trunkVersion
     */
    public String trunkVersion() {
        return trunkVersion;
    }

    /**
     * Number of brnach from the trunk point
     *
     *@return
     */
    public String branchNumber() {
        return branchNumber;
    }

    /**
     * Version of the branch
     *
     *@return branchVersion
     */
    public String branchVersion() {
        return branchVersion;
    }

    /**
     * True if this version identifier represents a branch
     *
     */
    public boolean isBranch() {
        return branchVersion != null;
    }

    /**
     * True if this version is the first copy in a version tree
     * i.e. versionTreeId is 1.
     */
    public boolean isFirst() {
        return trunkVersion.equals("1") && !isBranch();
    }

    /**
     * Return the next logical versionTreeId
     * i.e. next logical versionTreeId for 1.2.1 is 1.2.2
     */
    public VersionTreeId next() {
        if (isBranch()) {
            String newBranchVersion = Integer.toString(Integer.valueOf(branchVersion) + 1);
            return new VersionTreeId(trunkVersion + "." + branchNumber +
                    "." +  newBranchVersion);

        } else {

            return new VersionTreeId(Integer.toString(Integer.valueOf(trunkVersion) + 1));
        }
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VersionTreeId that = (VersionTreeId) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        if(branchVersion == null ){
            if(branchNumber == null ){
                return trunkVersion.toString();
            }
            return trunkVersion + "." + branchNumber;
        }
        return trunkVersion + "." + branchNumber +  "." + branchVersion;
    }
}
