package nl.rosa.semanticdatabase.bmm.model_access_package;
/**
 * 3.
 * Model Access Package
 * 3.1.
 * Overview
 * The org.openehr.lang.bmm.model_access package provides an interface for the application to load BMM schemas and convert them to BMM model form, and is shown below.
 * In this model, a schema is the serial form of a model or part of a model (i.e.
 * instances of a persistence model like the lang.bmm_persistence model P_XXX classes).
 * One or more schema files are parsed, validated and then converted to create a single BMM_MODEL instance.More than one format for representing serialised BMM models is possible, each having its load, validation and error-reporting logic.
 * The common elements of the load, validate and convert logic are defined by the non format-specific classes in the package, with specific forms of the classes BMM_SCHEMA_DESCRIPTOR and BMM_SCHEMA required for each concrete format.
 * The package above shows the relevant classes for the P_BMM version 2.x format, which is normally saved in .bmm files.
 * Other formats may be saved in files with different extensions.The singleton class BMM_MODEL_ACCESS acts as the entry point for client software to obtain access to loaded BMM models.
 * Since the latter start as schema files which are typically nested according to an 'include' hierarchy, they must be parsed, validated and merged to create each 'top-level' model.
 * The schemas are accessed via instances of the BMM_SCHEMA_DESCRIPTOR object, one for each schema file.
 * The load() routine of this class loads a BMM schema file by direct deserialisation.If the file is structurally correct (say ODIN, JSON etc), an in-memory schema instance will result (e.g.
 * P_BMM_SCHEMA in the case of the P_BMM format), and its validate_created method called.
 * If this succeeds, BMM_SCHEMA_DESCRIPTOR.bmm_schema will be set to this instance, of type BMM_SCHEMA.
 * Subsequently, BMM_SCHEMA.merge() will be called repeatedly, which results in each bmm_schema instance being the merged result of its include children and itself.
 * After merging, BMM_SCHEMA_DESCRIPTOR.validate_merged() will be called, and if successful, a call to create_model() will result in BMM_SCHEMA_DESCRIPTOR.model being populated.Each successfully loaded model is thus instantiated as a BMM_MODEL, and retrievable by calling BMM_MODEL_ACCESS.bmm_model() with a model key, which is a model identifier with full, partial or no version part.
 * In the latter cases, the most recent version model is retrieved for the key.
 * For example, the keys "openEHR_EHR_1.0.4", "openEHR_EHR_1.0", "openEHR_EHR_1", and "openEHR_EHR" will all match the "openEHR_EHR_1.0.4" model, assuming it is the most recent version available.
 * This is convenient for matching models to artefacts (e.g.
 * archetypes) that only mention the model publisher and name, but no version.The following screenshot shows the BMM schema configuration dialog in the openEHR ADL Workbench, including some meta-data, validation status etc, and also the schema nesting structure.
 * A single hierarchy of schemas corresponds to a single instantiated BMM model.The screenshot below shows a number of merged BMM models loaded into the AWB, including some of the packages and classes for the openehr_ehr_extract_1.0.4 model.
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * Figure 4.
 * lang.bmm.model_access Package
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * Figure 5.
 * BMM schema configuration
 * <p>
 * <p>
 * <p>
 * Figure 6.
 * BMM schemas loaded
 * 3.2.
 * Class Definitions
 * <p>
 * 3.2.1.
 * BMM_MODEL_ACCESS Class
 * <p>
 * 3.2.2.
 * BMM_SCHEMA_DESCRIPTOR Class
 * <p>
 * 3.2.3.
 * BMM_MODEL_METADATA Class
 * <p>
 * 3.2.4.
 * BMM_SCHEMA Class
 * <p>
 * 3.2.5.
 * BMM_SCHEMA_STATE Enumeration
 * <p>
 * 3.2.6.
 * BMM_INCLUDE_SPEC Class
 */
