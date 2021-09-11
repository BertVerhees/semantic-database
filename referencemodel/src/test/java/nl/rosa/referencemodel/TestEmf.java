package nl.rosa.referencemodel;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcoreFactory;

/**
 * Default created on 3-9-2021
 */

public class TestEmf {
    EPackage poPackage = EcoreFactory.eINSTANCE.createEPackage();
    poPackage.setName("po");

}
