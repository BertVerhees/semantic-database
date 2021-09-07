package nl.rosa.semanticdatabase.base.rminfo;

import nl.rosa.semanticdatabase.utils.model.IRMPackageId;
import nl.rosa.semanticdatabase.utils.model.RMPackageId;

import java.util.Collection;

/**
 * Originally: Created by pieter.bos on 06/07/16.
 */
public abstract class RMAOMInfoLookup extends ReflectionModelInfoLookup {
    @Override
    public String getArchetypeNodeIdFromRMObject(Object rmObject) {
        return null;
    }

    @Override
    public String getNameFromRMObject(Object rmObject) {
        return null;
    }

    @Override
    public Object clone(Object rmObject) {
        return null;
    }

    @Override
    public Collection<IRMPackageId> getId() {
        return null;
    }

//    private static RMAOMInfoLookup instance;
//
//    public RMAOMInfoLookup() {
//        super(new RMModelNamingStrategy(), ArchetypeModelObject.class, RMAOMInfoLookup.class.getClassLoader(), false /* no attributes without field */);
//
//    }
//
//    public static RMAOMInfoLookup getInstance() {
//        if(instance == null) {
//            instance = new RMAOMInfoLookup();
//        }
//        return instance;
//    }
//
//    @Override
//    protected void addTypes(Class baseClass) {
//        addClass(semanticdatabase.archetypeobjectmodel.aom.primitives.COrdered.class);
//        addClass(semanticdatabase.archetypeobjectmodel.aom.CSecondOrder.class);
//        addClass(semanticdatabase.archetypeobjectmodel.aom.CAttributeTuple.class);
//        addClass(semanticdatabase.archetypeobjectmodel.aom.ResourceDescriptionItem.class);
//        addClass(semanticdatabase.archetypeobjectmodel.aom.OperationalTemplate.class);
//        addClass(semanticdatabase.archetypeobjectmodel.aom.ArchetypeModelObject.class);
//        addClass(com.nedap.archie.aom.primitives.CDate.class);
//        addClass(com.nedap.archie.rules.Assertion.class);
//        addClass(com.nedap.archie.aom.CDefinedObject.class);
//        addClass(com.nedap.archie.aom.primitives.CBoolean.class);
//        addClass(com.nedap.archie.aom.ArchetypeHRID.class);
//        addClass(com.nedap.archie.aom.CComplexObjectProxy.class);
//        addClass(com.nedap.archie.aom.primitives.CTerminologyCode.class);
//        addClass(com.nedap.archie.aom.primitives.CDuration.class);
//        addClass(com.nedap.archie.aom.Template.class);
//        addClass(com.nedap.archie.aom.primitives.CTemporal.class);
//        addClass(com.nedap.archie.aom.CPrimitiveObject.class);
//        addClass(com.nedap.archie.aom.ArchetypeSlot.class);
//        addClass(com.nedap.archie.aom.ResourceDescription.class);
//        addClass(com.nedap.archie.aom.ResourceAnnotations.class);
//        addClass(com.nedap.archie.base.MultiplicityInterval.class);
//        addClass(com.nedap.archie.aom.SiblingOrder.class);
//        addClass(com.nedap.archie.rules.Function.class);
//        addClass(com.nedap.archie.aom.primitives.CReal.class);
//        addClass(com.nedap.archie.rules.RuleStatement.class);
//        addClass(com.nedap.archie.rules.VariableReference.class);
//        addClass(com.nedap.archie.rules.BuiltinVariable.class);
//        addClass(com.nedap.archie.aom.AuthoredArchetype.class);
//        addClass(com.nedap.archie.aom.terminology.ArchetypeTerm.class);
//        addClass(com.nedap.archie.aom.CArchetypeRoot.class);
//        addClass(com.nedap.archie.aom.TemplateOverlay.class);
//        addClass(com.nedap.archie.aom.ArchetypeConstraint.class);
//        addClass(com.nedap.archie.aom.terminology.TerminologyRelation.class);
//        addClass(com.nedap.archie.aom.terminology.ArchetypeTerminology.class);
//        addClass(com.nedap.archie.aom.RulesSection.class);
//        addClass(com.nedap.archie.aom.LanguageSection.class);
//        addClass(com.nedap.archie.aom.CObject.class);
//        addClass(com.nedap.archie.aom.primitives.CString.class);
//        addClass(com.nedap.archie.rules.Constraint.class);
//        addClass(com.nedap.archie.rules.RuleElement.class);
//        addClass(com.nedap.archie.rules.ModelReference.class);
//        addClass(com.nedap.archie.base.terminology.TerminologyCode.class);
//        addClass(com.nedap.archie.rules.ExpressionVariable.class);
//        addClass(com.nedap.archie.aom.terminology.ValueSet.class);
//        addClass(com.nedap.archie.xml.nl.rosa.semanticdatabase.bmm.model.types.CodeDefinitionSet.class);
//        addClass(com.nedap.archie.aom.TranslationDetails.class);
//        addClass(com.nedap.archie.rules.QueryVariable.class);
//        addClass(com.nedap.archie.base.Cardinality.class);
//        addClass(com.nedap.archie.aom.primitives.CInteger.class);
//        addClass(com.nedap.archie.aom.CPrimitiveTuple.class);
//        addClass(com.nedap.archie.base.Interval.class);
//        addClass(com.nedap.archie.aom.AuthoredResource.class);
//        addClass(com.nedap.archie.aom.primitives.CDateTime.class);
//        addClass(com.nedap.archie.rules.Constant.class);
//        addClass(com.nedap.archie.aom.CComplexObject.class);
//        addClass(com.nedap.archie.rules.VariableDeclaration.class);
//        addClass(com.nedap.archie.rules.Operator.class);
//        addClass(com.nedap.archie.rules.BinaryOperator.class);
//        addClass(com.nedap.archie.rules.ForAllStatement.class);
//        addClass(com.nedap.archie.aom.Archetype.class);
//        addClass(com.nedap.archie.aom.CAttribute.class);
//        addClass(com.nedap.archie.rules.Leaf.class);
//        addClass(com.nedap.archie.rules.UnaryOperator.class);
//        addClass(com.nedap.archie.rules.Expression.class);
//        addClass(com.nedap.archie.rules.ArchetypeIdConstraint.class);
//        addClass(com.nedap.archie.aom.primitives.CTime.class);
//    }
//
//    @Override
//    public Object convertToConstraintObject(Object object, CPrimitiveObject cPrimitiveObject) {
//        throw new UnsupportedOperationException("not supported");//TODO: split this to different classes
//    }
//
//    @Override
//    public void processCreatedObject(Object createdObject, CObject constraint) {
//        throw new UnsupportedOperationException("not supported");//TODO: split this to different classes
//    }
//
//    @Override
//    public String getArchetypeNodeIdFromRMObject(Object rmObject) {
//        //technically we could implement this :)
//        if(rmObject instanceof CObject) {
//            return ((CObject) rmObject).getNodeId();
//        }
//        throw new UnsupportedOperationException("not supported");//TODO: split this to different classes
//    }
//
//    @Override
//    public String getNameFromRMObject(Object rmObject) {
//        if(rmObject instanceof CObject) {
//            return ((CObject) rmObject).getMeaning();
//        }
//        //This is a bit of a strange operation for the aom model.
//        throw new UnsupportedOperationException("not supported");//TODO: split this to different classes
//    }
//
//    @Override
//    public Object clone(Object rmObject) {
//        if(rmObject instanceof ArchetypeModelObject) {
//            return ((ArchetypeModelObject) rmObject).clone();
//        }
//        throw new IllegalArgumentException("The ArchieAOMInfoLookup can only clone archetype model objects");
//    }
//
//    @Override
//    public Map<String, Object> pathHasBeenUpdated(Object rmObject, Archetype archetype, String pathOfParent, Object parent) {
//        throw new UnsupportedOperationException("not supported");//TODO: split this to different classes
//    }
//
//    @Override
//    public boolean validatePrimitiveType(String rmTypeName, String rmAttributeName, CPrimitiveObject cObject) {
//        return true;
//    }
//
//    @Override
//    public Collection<RMPackageId> getId() {
//        List<RMPackageId> result = new ArrayList<>();
//        result.add(new RMPackageId("OpenEHR", "AOM"));
//        return result;
//    }
//
}
