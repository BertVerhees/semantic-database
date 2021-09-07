package nl.rosa.semanticdatabase.utils.model;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import nl.rosa.semanticdatabase.utils.aom2_interfaces.*;

/**
 * Originally: Created by pieter.bos on 02/02/16.
 */
public abstract class RMInfoLookup extends BMMModelInfoLookup {

    private static RMInfoLookup instance;
    private Object object;
    private ICPrimitiveObject cPrimitiveObject;

//    private RMInfoLookup() {
//        super(new BMMModelNamingStrategy(), RMObject.class);
//    }

//    @Override
    protected void addTypes(Class baseClass) {
//        addClass(Interval.class); //extra class from the base package. No RMObject because it is also used in the AOM
//        addClass(AuditDetails.class);
//        addClass(Ehr.class);
//        addClass(DvTime.class);
//        addClass(RevisionHistoryItem.class);
//        addClass(PartyIdentity.class);
//        addClass(DvParsable.class);
//        addClass(DvDuration.class);
//        addClass(DvDateTime.class);
//        addClass(DvCount.class);
//        addClass(Cluster.class);
//        addClass(IsoOID.class);
//        addClass(PartyRelated.class);
//        addClass(Instruction.class);
//        addClass(Person.class);
//        addClass(GenericId.class);
//        addClass(Evaluation.class);
//        addClass(DvAmount.class);
//        addClass(Capability.class);
//        addClass(UID.class);
//        addClass(Item.class);
//        addClass(Contribution.class);
//        addClass(OriginalVersion.class);
//        addClass(FeederAuditDetails.class);
//        addClass(PartyProxy.class);
//        addClass(PointEvent.class);
//        addClass(CodePhrase.class);
//        addClass(InstructionDetails.class);
//        addClass(DvTimeSpecification.class);
//        addClass(DvAbsoluteQuantity.class);
//        addClass(FeederAudit.class);
//        addClass(Party.class);
//        addClass(ItemSingle.class);
//        addClass(EventContext.class);
//        addClass(DvProportion.class);
//        addClass(DvQuantity.class);
//        addClass(DvOrdered.class);
//        addClass(ContentItem.class);
//        addClass(DataValue.class);
//        addClass(DvOrdinal.class);
//        addClass(DvScale.class);
//        addClass(Agent.class);
//        addClass(InternetId.class);
//        addClass(Role.class);
//        addClass(Group.class);
//        addClass(ObjectId.class);
//        addClass(UIDBasedId.class);
//        addClass(VersionedEhrStatus.class);
//        addClass(PartySelf.class);
//        addClass(DvMultimedia.class);
//        addClass(Actor.class);
//        addClass(VersionTreeId.class);
//        addClass(DvParagraph.class);
//        addClass(ReferenceRange.class);
//        addClass(CareEntry.class);
//        addClass(ItemTree.class);
//        addClass(Element.class);
//        addClass(DvGeneralTimeSpecification.class);
//        addClass(DvDate.class);
//        addClass(Version.class);
//        addClass(DvState.class);
//        addClass(AccessControlSettings.class);
//        addClass(ItemList.class);
//        addClass(DataStructure.class);
//        addClass(History.class);
//        addClass(DvPeriodicTimeSpecification.class);
//        addClass(Contact.class);
//        addClass(TermMapping.class);
//        addClass(Event.class);
//        addClass(Observation.class);
//        addClass(Locatable.class);
//        addClass(UUID.class);
//        addClass(DvTemporal.class);
//        addClass(IsmTransition.class);
//        addClass(Folder.class);
//        addClass(Participation.class);
//        addClass(VersionedComposition.class);
//        addClass(ObjectVersionId.class);
//        addClass(Entry.class);
//        addClass(DvInterval.class);
//        addClass(Organisation.class);
//        addClass(VersionedObject.class);
//        addClass(DvEncapsulated.class);
//        addClass(VersionedFolder.class);
//        addClass(IntervalEvent.class);
//        addClass(ItemTable.class);
//        addClass(Attestation.class);
//        addClass(Address.class);
//        addClass(RevisionHistory.class);
//        addClass(DvIdentifier.class);
//        addClass(DvCodedText.class);
//        addClass(PartyRelationship.class);
//        addClass(LocatableRef.class);
//        addClass(Pathable.class);
//        addClass(EhrAccess.class);
//        addClass(DvEHRURI.class);
//        addClass(ArchetypeID.class);
//        addClass(RMObject.class);
//        addClass(PartyRef.class);
//        addClass(TemplateId.class);
//        addClass(AdminEntry.class);
//        addClass(VersionedEhrAccess.class);
//        addClass(PartyIdentified.class);
//        addClass(Composition.class);
//        addClass(EhrStatus.class);
//        addClass(AccessGroupRef.class);
//        addClass(ObjectRef.class);
//        addClass(GenericEntry.class);
//        addClass(DvQuantified.class);
//        addClass(ImportedVersion.class);
//        addClass(DvBoolean.class);
//        addClass(DvURI.class);
//        addClass(DvText.class);
//        addClass(Action.class);
//        addClass(ItemStructure.class);
//        addClass(HierObjectId.class);
//        addClass(Section.class);
//        addClass(Activity.class);
//        addClass(TerminologyId.class);
//        addClass(Link.class);
//        addClass(Archetyped.class);
//        addClass(ArchetypeHRID.class);
//        addClass(AuthoredResource.class);
//        addClass(TranslationDetails.class);
    }

//    @Override
//    protected boolean isNullable(Class clazz, Method getMethod, Field field) {
//        //The Party class has a non-null field that is nullable in its ancestor Actor. Cannot model that in Java
//        //with Nullable annotations, or have to add really complicated stuff. This works too.
//        if (field != null) {
//            if (Party.class.isAssignableFrom(clazz) && field.getName().equalsIgnoreCase("uid")) {
//                return false;
//            }
//        } else if (getMethod != null) {
//            if (Party.class.isAssignableFrom(clazz) && getMethod.getName().equalsIgnoreCase("getUid")) {
//                return false;
//            }
//        }
//        return super.isNullable(clazz, getMethod, field);
//    }

//    public static RMInfoLookup getInstance() {
//        if (instance == null) {
//            instance = new RMInfoLookup();
//        }
//        return instance;
//    }

//    @Override
//    public Class getClassToBeCreated(String rmTypename) {
//        if (rmTypename.equals("EVENT")) {
//            //this is an abstract class and cannot be created. Create point event instead
//            return PointEvent.class;
//        }
//        return getClass(rmTypename);
//    }

    /**
     * Returns the naming strategy for the java classes of this model
     *
     * @return
     */
    @Override
    public ModelNamingStrategy getNamingStrategy() {
        return null;
    }

    /**
     * Converts the given rm object with the constraint in cPrimitiveObject to the corresponding AOM model
     * <p>
     * For example, converts an OpenEHR RM CodePhrase to a TerminologyCode
     *
     * @param object           the rm object
     * @param cPrimitiveObject the AOM constraint
     * @return the rm object converted to the corresponding AOM object
     */
//    @Override
//    public Object convertToConstraintObject(Object object, ICPrimitiveObject cPrimitiveObject) {
//        if (cPrimitiveObject instanceof ICTerminologyCode) {
//            if (object instanceof DvCodedText && ((DvCodedText) object).getDefiningCode() != null) {
//                return convertCodePhrase(((DvCodedText) object).getDefiningCode());
//            } else if (object instanceof CodePhrase) {
//                return convertCodePhrase((CodePhrase) object);
//            } else {
//                return new TerminologyCode();
//            }
//        }
//        return object;
//    }

//    private TerminologyCode convertCodePhrase(CodePhrase codePhrase) {
//        TerminologyCode result = new TerminologyCode();
//        result.setCodeString(codePhrase.getCodeString());
//        result.setTerminologyId(codePhrase.getTerminologyId() == null ? null : codePhrase.getTerminologyId().getValue());
//        return result;
//    }

//    public Object convertConstrainedPrimitiveToRMObject(Object object) {
//        if (object instanceof TerminologyCode) {
//            return convertTerminologyCode((TerminologyCode) object);
//        }
//        return object;
//    }


//    private CodePhrase convertTerminologyCode(TerminologyCode terminologyCode) {
//        CodePhrase result = new CodePhrase();
//        result.setCodeString(terminologyCode.getCodeString());
//        result.setTerminologyId(terminologyCode == null ? null : new TerminologyId(terminologyCode.getTerminologyId()));
//        return result;
//    }

    /**
     * Callback after an RM Object has been created based on a constraint. Can for example be used
     * to set names or archetype ID Node values
     *
     * @param createdObject
     * @param constraint
     */
//    @Override
//    public void processCreatedObject(Object createdObject, ICObject constraint) {
//        if (createdObject instanceof Locatable) { //and most often, it will be
//            Locatable locatable = (Locatable) createdObject;
//            locatable.setArchetypeNodeId(constraint.getNodeId());
//            locatable.setNameAsString(constraint.getMeaning());
//        }
//    }

//    @Override
//    public String getArchetypeNodeIdFromRMObject(Object rmObject) {
//        if (rmObject == null) {
//            return null;
//        }
//        if (rmObject instanceof Locatable) {
//            Locatable locatable = (Locatable) rmObject;
//            return locatable.getArchetypeNodeId();
//        }
//        return null;
//    }

//    @Override
//    public String getArchetypeIdFromArchetypedRmObject(Object rmObject) {
//        if (rmObject instanceof Locatable) {
//            Locatable locatable = (Locatable) rmObject;
//            if (locatable.getArchetypeDetails() != null) {
//                return locatable.getArchetypeDetails().getArchetypeId().getValue();
//            }
//        }
//        return null;
//    }

//    @Override
//    public String getNameFromRMObject(Object rmObject) {
//        if (rmObject == null) {
//            return null;
//        }
//        if (rmObject instanceof Locatable) {
//            Locatable locatable = (Locatable) rmObject;
//            return locatable.getNameAsString();
//        }
//        return null;
//    }

    /**
     * Deeply clone the given RM Object
     *
     * @param rmObject
     * @return
     */
    @Override
    public Object clone(Object rmObject) {
        return null;
    }


    /**
     * Perform any actions necessary if the value at the given path has just been updated
     * For example, if an ordinal value has been set, this method should also set the symbol.
     * <p>
     * In addition to changing the actual values, it returns which additional paths have been updated as well.
     * For example, if an ordinal's symbol was updated, it will update both the value and the symbol of that ordinal
     * and return the value's path and updated value. This is done to obtain a full set of instructions of what must be
     * changed due to the rule evaluation.
     * <p>
     * This can be the most complex operation of this entire class to implement. If you just throw an exception instead of implementing it
     * everything will work fine except for the rule evaluation.
     * <p>
     * For now this is only needed in the rule evaluation to automatically fix assertions
     *
     * @param rmObject
     * @param archetype
     * @param pathOfParent
     * @param parent
     * @return Each key is a path that was updated as a result of the previously updated path and each corresponding
     * value is this path's updated value
     */

    /**
     * Notification that a value at a given path has been updated in the given archetype. Perform tasks here to make sure
     * every other paths are updated as well.
     *
//     * @param rmObject
//     * @param archetype
//     * @param pathOfParent
//     * @param parent
     */
//    @Override
    public Map<String, Object> pathHasBeenUpdated(Object rmObject, IArchetype archetype, String pathOfParent, Object parent) {
//        return UpdatedValueHandler.pathHasBeenUpdated(rmObject, archetype, pathOfParent, parent);
        return null;
    }

    public boolean validatePrimitiveType(String rmTypeName, String rmAttributeName, ICPrimitiveObject cObject) {
        return false;
    }
//    @Override
//    public boolean validatePrimitiveType(String rmTypeName, String rmAttributeName, ICPrimitiveObject cObject) {
//        IRMAttributeInfo attributeInfo = this.getAttributeInfo(rmTypeName, rmAttributeName);
//        if (attributeInfo == null) {
//            return true;//cannot validate
//        }
//        Class typeInCollection = attributeInfo.getTypeInCollection();
//        if (cObject instanceof CInteger) {
//            return typeInCollection.equals(Long.class) || typeInCollection.getName().equals("long");
//        } else if (cObject instanceof CReal) {
//            return typeInCollection.equals(Double.class) || typeInCollection.getName().equals("double");
//        } else if (cObject instanceof CString) {
//            return typeInCollection.equals(String.class);
//        } else if (cObject instanceof CDate) {
//            return typeInCollection.equals(String.class) ||
//                    typeInCollection.isAssignableFrom(Temporal.class);
//        } else if (cObject instanceof CDateTime) {
//            return typeInCollection.equals(String.class) ||
//                    typeInCollection.isAssignableFrom(Temporal.class);
//        } else if (cObject instanceof CDuration) {
//            return typeInCollection.equals(String.class) ||
//                    typeInCollection.isAssignableFrom(TemporalAccessor.class) ||
//                    typeInCollection.isAssignableFrom(TemporalAmount.class);
//        } else if (cObject instanceof CTime) {
//            return typeInCollection.equals(String.class) ||
//                    typeInCollection.isAssignableFrom(TemporalAccessor.class);
//        } else if (cObject instanceof CTerminologyCode) {
//            return typeInCollection.equals(CodePhrase.class) ||
//                    typeInCollection.equals(DvCodedText.class);
//        } else if (cObject instanceof CBoolean) {
//            return typeInCollection.equals(Boolean.class) || typeInCollection.getName().equals("boolean");
//        }
//        return false;
//
//    }

//    @Override
//    public Collection<IRMPackageId> getId() {
//        List<IRMPackageId> result = new ArrayList<>();
//        result.add(new RMPackageId("openEHR", "EHR"));
//        result.add(new RMPackageId("openEHR", "DEMOGRAPHIC"));
//        return result;
//    }

    /**
     * Pass this method to cObject.effectiveOccurrences to get the reference model property multiplicity
     *
     * @param rmTypeName            the type name of the type to get occurrences for
     * @param rmAttributeNameOrPath The rm attribute name or path lookup to an rm attribute to get the occurrences for
     * @return
     */
//    @Override
//    public MultiplicityInterval referenceModelPropMultiplicity(String rmTypeName, String rmAttributeNameOrPath) {
//        return null;
//    }

    /**
     * Pass this method to cObject.cConformsTo to enable it to check if the two type names are conformant
     *
     * @param childType
     * @param parentType
     * @return
     */
    @Override
    public Boolean rmTypesConformant(String childType, String parentType) {
        return null;
    }

}

