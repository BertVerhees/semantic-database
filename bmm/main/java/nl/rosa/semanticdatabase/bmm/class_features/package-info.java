package nl.rosa.semanticdatabase.bmm.class_features;
/**
 * 7.
 * Class Features
 * 7.1.
 * Overview
 * Within the definition of each class in a BMM model are found the declarations of its features, consisting of routines, properties and constants.
 * The overall meta-model of features, as well as the elements that occur within them, namely parameters and local variables is shown below, and described in this section.The taxonomy of meta-types that classify the concrete meta-types representing features is somewhat complicated in an object-oriented approach by the presence of procedures, which are declared features (sometimes called commands or modifiers) that change internal object state, rather than returning a value as is the case with all other kinds of features.
 * The consequence is that the cleanest approach to definition of meta-attributes is the use of two taxonomies, one corresponding to feature declarations (including procedures) and one to do with typed value-returning entities, which excludes procedures.
 * <p>
 * <p>
 * <p>
 * <p>
 * 7.1.1.
 * Feature Groups
 * Features are arranged within a class in feature groups, each represented by an instance of the meta-type BMM_FEATURE_GROUP.
 * By default there is at least one feature group called "feature".
 * Feature groups may be given any name, and are usually used to group features on the basis of things like: meta-type, e.g.
 * a group called "rules" limited to publicly visible functions only; logical feature type, e.g.
 * commands, queries, factory methods etc.
 * The primary purpose of feature groups is to represent specific meta-data that naturally applies to more than one feature in general, and is thus convenient to represent on a logical container rather than repeat individually.
 * Feature group meta-data is recorded in the properties attribute.
 * A feature group may also set default visibility for all features in the group.
 * 7.1.2.
 * Feature Visibility
 * Selective visibility of features to external clients is expressed in the attributes BMM_FEATURE_GROUP.visibility with potential overrides achieved using BMM_CLASS_FEATURE.visibility, i.e.
 * at an individual feature level.
 * Visibility is defined using sub-types of the abstract meta-class BMM_VISIBILITY.
 * TBD: define visibility meta-model; probably need to support C/Java approach and type-based.
 * 7.1.3.
 * Feature Declarations
 * Features are understood in BMM as entities referenceable within a module or lower context.
 * The 'module' in BMM is the class.
 * Class features consist of the formal sub-parts of a class, namely: routines: procedures and functions; properties: mutable static definitions, described in detail in previous sections; constants: immutable static definitions.
 * Variables are also understood as a kind of class feature, whose scoping entity is further restricted to a containing routine.
 * The taxonomy of feature declarations is shown below.
 * Figure 25.
 * Feature taxonomy This taxonomy is concerned with model elements that can be lexically declared within some scope.
 * Those elements defined within a class scope have a type signature, i.e.
 * a formal 'shape' in terms of types.
 * This applies even to procedures, which are formal entities despite having no return type.
 * 7.1.4.
 * Typed Entities
 * For entities with a type, i.e.
 * which can potentially produce a value, the following taxonomy of typing applies.
 * Figure 26.
 * Typed taxonomy This taxonomy is concerned with typedness, valuedness, and mutability, which is the notion that a typed value-producing entity may be Void (null) at execution time.
 * Features, which are declarations in context can be mutable, but value objects (e.g.
 * literal values, delayed routine calls) cannot.
 * 7.1.5.
 * Class Model
 * The class model that results from the above considerations is shown below.
 * Figure 27.
 * base.bmm.core.feature package - Features 7.1.5.1.
 * A Note on Multiple Inheritance In the above model, multiple inheritance is used in order to express the design intention of the model.
 * In many modern languages, multiple inheritance of classes containing attributes is not possible.
 * Accordingly, to aid implementation in these languages, the diagram distinguishes the two inheritance hierarchies as follows: the 'true' inheritance hierarchy under the class BMM_TYPED (shown in green), corresponding to the type taxonomy illustrated in Figure 26 above; a second hierarchy used to obtain structural elements, under BMM_DECLARAION (shown in blue), corresponding to the feature taxonomy illustrated in Figure 25 above.
 * The BMM_TYPED hierarchy is the one requiring type substitutability, and is thus implemented using class inheritance (e.g.
 * extends in Java), while the other should be implemented by inheritance of interfaces.
 * This can be achieved as follows: define the BMM classes BMM_ROUTINE, BMM_CLASS_FEATURE, BMM_CLASS_ENTITY, BMM_DECLARATION etc as interfaces, with the attributes (such as BMM_ROUTINE.parameters) declared as methods and declare the inheritance as interface inheritance (e.g.
 * implements in Java); define a parallel class hierarchy BMM_ROUTINE_IMPL, etc whose design follows the UML model above (i.e.
 * defines real attributes) and which are declared as the types of private data elements in the main classes (e.g.
 * BMM_FUNCTION, in order to obtain the attributes logically defined by BMM_ROUTINE in the UML); implement the methods inherited from the interface hierarchy via a declaration via the appropriate dispatch code referencing the relevant private data member.
 * The above approach should result in the same semantics as defined by the model shown above.
 * 7.1.6.
 * Differential and Flat Form
 * In modelling or programming terms, the features defined on a particular class within a model constitute the features it introduces with respect to its inheritance parent(s).
 * We can think of this list of features as the differential set.
 * A 'top-level' class with no declared inheritance ancestor is considered to inherit by default from the Any class, and its feature set is relationally differential to the top class.
 * In contrast, the effective set of features for an instance at runtime is the result of evaluating these lists of features down the inheritance hierarchy to obtain the flat set of features.
 * The features properties and flat_properties defined on BMM_CLASS provide access to these two lists for any class.
 * 7.1.7.
 * Signatures
 * All class-scoped features have formal signatures (described in Section 5.5), realised as BMM_CLASS_ENTITY.signature.
 * This includes procedures, even though they have no return type.
 * The two types of routines, i.e.
 * functions and procedures, include zero or more formal parameters in their signatures, with functions also having a return type.
 * The standard taxonomy of feature signature types is illustrated below, with each form being controlled by invariants stated in the relevant containing meta-classes (e.g.
 * BMM_FUNCTION, representing a function definition has an invariant requiring signature.result /= Void).
 * Figure 28.
 * Signature taxonomy
 * 7.1.8.
 * Synthesis due to Generic Parameter Substitution
 * Due to the possibility of generating concrete types via substitution of concrete generic parameters for formal parameters of generic classes, new concrete types of features may routinely result anywhere in a fully computed in-memory BMM model.
 * BMM allows such features to be synthesised with their resulting concrete types rather than their 'source-defined' open parameter types, and provides the Boolean flag is_synthesised_generic on the class BMM_CLASS_ENTITY to mark any such synthesised feature.
 * An example of the use of this is described below in Section 12.1.2.
 * 7.2.
 * Constants
 * Constant features in a class are represented by the BMM meta-type BMM_CONSTANT, which is:At runtime a constant has a value, which may be of any type, including complex types, and which is set using its generator expression (i.e.
 * an instance of the meta-type EL_INSTANCE_REF).
 * In the common degenerate case, generator consists simply of a literal value, but may also be a function call or other expression valid in the context of the scoping class.
 * This latter capability is the means by which computed constants are supported.The following abstract syntax illustrates how constants may be defined in a BMM model.
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * class BASIC_DEFINITIONS { feature // // simple constants // constant CR: Character = '\015'; constant LF: Character = '\012'; // // constant of complex type // TODO: correct JSON (maybe YAML?) or other syntax // constant SafeSpeed: Interval<Quantity> = |0.0 km/h ..
 * 60.0 km/h|; // // constant generated by a one-time expression evaluation // constant ProxyVar<Quantity> = {ProxyVar<Quantity>}(arg1, arg2); }
 * 7.3.
 * Properties
 * Class properties are defined via the meta-class BMM_PROPERTY, and its subtypes which distinguish unitary properties (single-valued attributes in a class) from container properties (multiply-valued attributes).The BMM_PROPERTY meta-type defines semantics common to all properties, including is_composition, which indicates whether the property reference instantiates a part-of relationship or an association.
 * <p>
 * <p>
 * <p>
 * <p>
 * 7.3.1.
 * Unitary versus Container Properties
 * Single-valued properties in a BMM model are instances of the type BMM_UNITARY_PROPERTY, and have as their type the meta-type UNITARY_TYPE.
 * Container properties are instances of the meta-type BMM_CONTAINER_PROPERTY, which adds the attribute cardinality, enabling the possible number of container elements to be constrained (this corresponds to the multiplicities used at the end of UML associations).
 * The meta-type BMM_INDEXED_CONTAINER_PROPERTY adds the attribute index_type, enabling representation of indexed concrete container types such as Hash<K,V> etc.
 * A typical example of properties of class is shown below, in which the flattened property view of a class OBSERVATION includes the inherited properties other_participations and links properties exemplifying the container property meta-type: Figure 29.
 * BMM class - properties view The following illustrates how various kinds of properties may appear in a BMM model.
 * The first two properties are associations, used to represent references to shared objects (including singletons), while the remainder are normal compositional sub-parts, i.e.
 * owned sub-instances that will cease to exist when the parent object is destroyed.
 * All of the properties are single-valued, other than other_participations, which is defined as a container property with cardinality [*] (i.e.
 * 0..*) and 'set' semantics.
 * abstract class ENTRY extend CARE_ENTRY { feature -- Locale association property language: CODE_PHRASE <<"iso::iso_639-2">> [0..1]; association property encoding: CODE_PHRASE <<"iana::character-sets">> [0..1]; feature -- Access composition property protocol: ITEM_STRUCTURE[1]; composition property guideline_id: OBJECT_REF[0..1]; composition property subject: PARTY_PROXY[0..1]; composition property other_participations: PARTICIPATION[*]{set}; }
 * 7.3.2.
 * Semantic level
 * TBD: this BMM feature requires review Properties also include two other Boolean meta-data items, is_im_runtime and is_im_infrastructure, which can be used to classify property values in a model according to 'semantic level', which roughly corresponds to the continuum from domain-specific to infrastructure.
 * These may be individually set, or both may be False.
 * The three meaningful value settings are as follows: both False: the value of the property is considered to be design-time constrainable; is IM runtime: True if the property value is only knowable at runtime, as is typically the case for identifiers, dates etc; is infrastructure: True if the property is not a user- or business-oriented property, but something required by software design, e.g instance identifier, meta-data etc.
 * The above screenshot also includes properties have different settings of the is_im_runtime and is_im_infrastructure meta-data flags: property names in black are neither; those in grey are IM runtime (guideline_id, workflow_id), and those in light grey are infrastructure properties (language, encoding, uid, etc).
 * 7.4.
 * Functions and Procedures
 * Functions and procedures are kinds of routine, which are computational features of a class.
 * The classes BMM_FUNCTION, BMM_PROCEDURE and BMM_ROUTINE respectively provide the meta-model for definitions of the two types of routine.The formal parameter definitions of both kinds of routines are represented by an ordered list of instances of the meta-class BMM_PARAMETER, which is defined as a kind of variable.
 * A formal parameter may optionally have the read/write direction defined, which indicates whether the variable contains an input value, should only be written to, or both, i.e.
 * read then written to.
 * The is_nullable meta-attribute inherited from BMM_TYPED_FEATURE indicates whether each parameter is mandatory or not.An additional feature of the meta-model for functions is the notion of operator, which supports the representation of a function call in a formal expression as an operator symbol with one or two operands, in the typical form found in programming languages and first order logics.
 * The BMM approach considers an operator as an optional addition to any function of arity 1 or 2 that may reasonably be represented in an abstract syntax using operator syntax.
 * Operators thus support the use of expressions like weight > 90 to mean weight.gt (90), where weight is of type Real, and the function gt(other: Real) is defined.Any routine may have pre- and/or post-conditions defined for it, represented in BMM by BMM_ASSERTIONs populating the pre_conditions and post_conditions attributes of BMM_ROUINE.
 * An Assertion is a tagged Boolean Expression.The following abstract syntax illustrates the various elements of function definitions.
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
 * abstract class DV_AMOUNT inherit DV_QUANTIFIED { feature -- Arithmetic Operations function equal (other: DV_AMOUNT[1]): Boolean[1] alias {infix '='}; function less_than (other: DV_AMOUNT[1]): Boolean[1] alias {infix '<'}; feature -- Arithmetic Operations function add (other: DV_AMOUNT[1]): DV_AMOUNT[1] alias {infix '+'}; function subtract (other: DV_AMOUNT[1]): DV_AMOUNT[1] alias {infix '-'}; function multiply (val: Real[1]): DV_AMOUNT[1] alias {infix '*'}; function divide (val: Real[1]): DV_AMOUNT[1] alias {infix '/', infix '÷'}; }
 * 7.4.1.
 * Pre- and Post-conditions
 * All BMM routine definitions may include pre- and/or post-conditions, with the semantics of Djikstra’s weakest pre-condition logic (Dijkstra (1976)), Object-Z (Smith (2000)) and the Eiffel language (Meyer (1997)).
 * The essential semantics are as follows: pre-conditions specify truth conditions on public object state and/or parameters that must hold for the routine to execute correctly; if a pre-condition is not met at the moment of routine call, the client (caller) is at fault; post-conditions specify truth conditions on public object state and/or result (in the case of functions) that will hold at the end of routine execution; if a post-condition is not met at the moment of routine completion, the routine is at fault, i.e.
 * contains bugs.
 * The use of pre- and post-conditions is also known as design by contract (DbC), a term introduced by Meyer, and is widely used in general IT, particularly in specification languages such as OMG Interface Definition Language (IDL).
 * The following shows how a routine contract may be specified in an abstract syntax.
 * class I_EHR_SERVICE { feature -- Creation create_ehr_with_id ( an_ehr_id: UUID[1]; an_ehr_status: EHR_STATUS[0..1] ): UUID[1] pre_condition No_duplicate: not has_ehr (an_ehr_id) post_condition Has_ehr: has_ehr (Result) }
 * 7.4.2.
 * Creators and Converters
 * In common with may OOPLs, BMM classes may specify creators, i.e.
 * instance-creating procedures, known as 'constructors' in some OOPLs.
 * These are just a subset of all procedures known in BMM_CLASS.procedures that when executed will satisfy the class invariants.
 * A further subset of the creators are single-argument converters which can initialise a new instance from an instance of another type.
 * Converter routines are typically used to support type conversion in expressions, e.g.
 * String to Date etc.
 * These two subsets are formally defined as the creators and converters reference lists of procedures on BMM_CLASS, as shown in the following UML view.
 * Figure 30.
 * Class creators and converters Creators and converters might be distinguished among other procedures in an abstract syntax as follows.
 * class Date inherit Temporal convert create_from_string { feature -- Creators procedure create_from_string (a_date_str: String[1]) procedure create (a_day, a_month, a_year: Integer[1]) feature -- Modification procedure set_day (a_day: Integer[1]) }
 * 7.4.3.
 * Routine Body
 * BMM supports the definition of statements, i.e.
 * implementation within a ROUTINE as well as 'external' routines, which are represented by an instance of the meta-class BMM_ROUTINE_EXTERNAL.
 * These classes are shown in the following UML view.
 * Figure 31.
 * Routine body The meta-model of statements is described in detail in Section 11.
 * 7.5.
 * Variables
 * At the finest level of detail of a model definition are what are typically thought of as variables within a routine scope.
 * These may be either local variables (variables declared locally within a routine) and parameter variables (declared in the arguments part of a routine declaration).
 * Local variables and parameters have the meta-types BMM_LOCAL and BMM_PARAMETER respectively.
 * The special pre-defined variable Result is automatically available within any function, and is represented by the meta-model type BMM_RESULT.
 * <p>
 * <p>
 * 7.6.
 * Model Theoretic Questions
 * The features meta-model as defined here entails certain choices that have consequences.
 * The primary choice that affects this part of the meta-model is not to treat Void as a type, with the result a procedure is not a typed entity, meaning its signature has no result part.
 * This makes procedures an anomaly within an otherwise typed system of entities, and complicates the inheritance structure of the BMM meta-model.
 * The alternative would have been to treat procedures as Void-returning entities, and thus of type Void (a pseudo-type), as per languages such as C++ and Java, or an equivalent, such as the Unit pseudo-type of Kotlin.
 * The major disadvantage of the latter is that it makes procedure definitions (BMM_PROCEDURE instances within a BMM model) look like typed entities, and as a result, procedure calls look like value-returning entities that could be used within expressions (i.e.
 * no different than function calls).Ultimately this difficulty arises from the decision to include procedures at all within the formal framework, when from a purely functional perspective they would not exist.
 * Avoiding procedures means going down a pure functional route, which, although providing a cleaner model of pure computation, inevitably entails various artificial and non-intuitive means of making a computational entity do something.
 * BMM has taken the route of objects as black boxes having queries (functions, properties) and commands (procedures), with well-behaved models relying on the principle of command-query separation (CQS), i.e.
 * side-effect free functions.
 * CQS is not enforced by BMM, but its use would make a formal model expressed in BMM more tractable to proof-based tools.
 * <p>
 * <p>
 * <p>
 * <p>
 * 7.7.
 * Class Definitions
 * <p>
 * 7.7.1.
 * BMM_TYPED Class
 * <p>
 * 7.7.2.
 * BMM_FEATURE_GROUP Class
 * <p>
 * 7.7.3.
 * BMM_VISIBILITY Class
 * <p>
 * 7.7.4.
 * BMM_CLASS_ENTITY Class
 * <p>
 * 7.7.5.
 * BMM_CLASS_FEATURE Class
 * <p>
 * 7.7.6.
 * BMM_TYPED_FEATURE Class
 * <p>
 * 7.7.7.
 * BMM_INSTANTIABLE Class
 * <p>
 * 7.7.8.
 * BMM_CONSTANT Class
 * <p>
 * 7.7.9.
 * BMM_PROPERTY Class
 * <p>
 * 7.7.10.
 * BMM_UNITARY_PROPERTY Class
 * <p>
 * 7.7.11.
 * BMM_CONTAINER_PROPERTY Class
 * <p>
 * 7.7.12.
 * BMM_INDEXED_CONTAINER_PROPERTY Class
 * <p>
 * 7.7.13.
 * BMM_ROUTINE Class
 * <p>
 * 7.7.14.
 * BMM_FUNCTION Class
 * <p>
 * 7.7.15.
 * BMM_OPERATOR Class
 * <p>
 * 7.7.16.
 * BMM_OPERATOR_POSITION Enumeration
 * <p>
 * 7.7.17.
 * BMM_PROCEDURE Class
 * <p>
 * 7.7.18.
 * BMM_VARIABLE Class
 * <p>
 * 7.7.19.
 * BMM_LOCAL Class
 * <p>
 * 7.7.20.
 * BMM_PARAMETER Class
 * <p>
 * 7.7.21.
 * BMM_RESULT Class
 * <p>
 * 7.7.22.
 * BMM_PARAMETER_DIRECTION Enumeration
 * <p>
 * 7.7.23.
 * BMM_ROUTINE_BODY Class
 * <p>
 * 7.7.24.
 * BMM_ROUTINE_EXTERNAL Class
 */
