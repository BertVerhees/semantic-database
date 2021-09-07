package nl.rosa.semanticdatabase.bmm.types;
/**
 * 5.
 * Types
 * 5.1.
 * Overview
 * One of the foundational distinctions in the BMM is between class and type, in common with the type systems of the modern forms of most object-oriented languages, but in contrast to the UML meta-model.
 * This division is reflected in the two top-level meta-classes BMM_CLASS and BMM_TYPE, and their respective descendants, as shown in the following UML diagram.Classes are definitional entities, while types are understood in BMM as the formal generators of instances (where non-abstract), as the basis of static typing in a formal model, and dynamic conformance, i.e.
 * at execution time, when polymorphic attachment is possible.
 * Most types are specified via the definitions of classes and their constituent parts.
 * Types are used for the following purposes in a BMM model:A simple example of typing of properties is shown in the instance diagram below.Most types are based on one or more defining class(es), which provide the formal definition for the type.
 * The exceptions are formal generic parameters (e.g.
 * the T in List<T>) and the special types for tuples and routine signatures, which are treated as built-in.
 * The BMM meta-type BMM_TYPE and its descendants define the kinds of types available in a BMM model.
 * The design of the types part of the BMM is based on a taxonomy that makes various distinctions convenient to a formalism intended for modelling rather than pure programming.
 * This leads in particular to the top-level distinction between unitary and container meta-types.
 * The taxonomy is illustrated below, including differentiae.BMM_TYPE includes features common to all meta-types:Below BMM_TYPE are the abstract meta-type BMM_UNITARY_TYPE and the concrete meta-type BMM_CONTAINER_TYPE and its specialisation BMM_INDEXED_CONTAINER_TYPE.
 * BMM_UNITARY_TYPE is a meta-type for types whose instances are unitary i.e.
 * singular, while the container meta-types correspond to collections of instances.
 * The latter are further described below.
 * This distinction is made to enable BMM to directly represent the notion of collections in the type system rather than treating them in the same way as any other type, which would force modellers (i.e.
 * authors of actual BMM models) to state concrete containment types such as ArrayedList<Packet>, where ArrayedList would have to be defined in the model as well as Packet.Unitary meta-types are further distinguished as formal generic parameters (BMM_PARAMETER TYPE) and effective types, i.e.
 * concrete unitary types.
 * The former meta-type is used to represent replaceable formal generic parameters (typically 'T', 'U' within types such as List<T> etc) within generic type declarations.Effective types have as their meta-type BMM_EFFECTIVE_TYPE.
 * Its subtypes are BMM_MODEL_TYPE, a meta-type for types defined by classes in the model (thus characterised by the property base_class: BMM_CLASS), BMM_TUPLE_TYPE, a meta-type for tuples (a list of objects of varying types), and BMM_SIGNATURE, a meta-type representing signatures of routines and typed model elements (properties, variables etc).BMM_MODEL_TYPE divides into BMM_SIMPLE_TYPE and BMM_GENERIC_TYPE, corresponding to the standard notions of types familiar in modern programming languages.
 * The class definitions of instances (i.e.
 * BMM model class definitions) of these meta-types are available via the property base_class, of meta-type BMM_CLASS for a BMM simple type, and BMM_GENERIC_CLASS for BMM generic type.These various concrete meta-types are described in more detail below.
 * <p>
 * <p>
 * <p>
 * Figure 10.
 * base.bmm.core.entity Package - Types
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * Figure 11.
 * BMM Typing
 * <p>
 * <p>
 * <p>
 * Figure 12.
 * BMM meta-type taxonomy
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
 * <p>
 * <p>
 * <p>
 * 5.2.
 * Simple Type
 * A simple type is a type based only on a simple class, which is a class with no formal generic parameters.
 * An instance of a simple type is fully described by the class on which it is based, with the only difference being the usual object-oriented possibility of polymorphic attachments of sub-objects whose dynamic types conform to their static type counterparts in the original simple type.
 * Thus, for example, a class Organisation may have a property manager of static type Employee.
 * An instance of the simple type Organisation might have its manager property attached to an instance of Manager, which is legal as long as Manager conforms to Employee, which it will do if Manager is defined as a subtype of Employee.
 * <p>
 * <p>
 * 5.2.1.
 * Conformance
 * Conformance of Simple types follows the inheritance hierarchy via which they are defined, according to the rules: meta-rule: A Simple type can only conform to a Model type, i.e.
 * either another Simple type or a Generic type; concrete rule: A Simple type A conforms to Simple type B iff for base_class of A, all_ancestors() contains B.
 * 5.3.
 * Generic Type
 * A generic type is a type based on a generic class, which has one or more formal type parameters that are substituted by actual types in its declaration.
 * For example, the generic type Interval<Quantity> can be used in a model that contains the generic class Interval<T:Ordered> and Quantity.
 * The general case is that the generic parameter substitution type (BMM_GENERIC_TYPE.generic_parameters) for any formal parameter (BMM_GENERIC_CLASS.generic_parameters) is of meta-type BMM_UNITARY_TYPE.A typical programmatic usage of such a type, and its instantiated BMM model structure is shown below.The parameters of a generic type may be:Consequently, a generic type may be:The first case is detected via the function is_closed defined on BMM_GENERIC_TYPE, while the function is_partially_closed distinguishes the latter two cases.The following shows the BMM instance structure of a generic type that is open.Since the meta-type of BMM_GENERIC_TYPE.generic_parameters in the BMM is BMM_UNITARY_TYPE, constructions such as MyGenericType<List<OtherType>> are prevented, due to the concrete parameter type List<OtherType> being an instance of BMM_CONTAINER_TYPE rather than of BMM_UNITARY_TYPE.
 * Such constructions are nearly always wrong, and not needed in a model expressed in BMM, because containment can be expressed where the formal generic parameter is used, not where the concrete parameter is declared.
 * The following diagram shows the BMM concrete model structure created for a generic type whose formal parameter type is used in this way, i.e.
 * within a container type.
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * Figure 13.
 * Generic type - closed simple
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
 * <p>
 * <p>
 * Figure 14.
 * Generic type - open
 * <p>
 * <p>
 * <p>
 * Figure 15.
 * Generic type - closed container
 * 5.3.1.
 * Conformance
 * Conformance of Generic types is according to the rules: meta-rule: A Generic type can only conform to another Generic type; concrete rules: A Generic type Ga<Tai, …​> conforms to Generic type Gb<Tbi, …​> iff: for base_class of Ga, all_ancestors() contains Gb; and the number of generic parameters is equal; for each Tai, either Tbi is an open formal parameter, and Tai conforms to any generic constraint type, or; Tai conforms to Tbi.
 * 5.4.
 * Tuple Meta-type
 * The meta-type BMM_TUPLE_TYPE enables the type of a tuple i.e.
 * an array of objects each of which may be of any type, to be stated in terms of other types.
 * This is mostly used to state the type of a set of arguments in the BMM_SIGNATURE class, but standalone tuple types may also be used in a model, providing roughly the effect of an anonymous class (or a struct in C/C++).The notional type Tuple defined by BMM_TUPLE_TYPE is treadted as a BMM built-in, and is therefore not stated in any BMM model.
 * <p>
 * <p>
 * 5.4.1.
 * Conformance
 * Conformance of Tuple types is according to the rules: meta-rule: A Tuple type can only conform to another Tuple type; concrete rules: A Tuple type Tuple[Tai, …​] conforms to Tuple type Tuple[Tbi, …​] iff: for each Tai, Tai conforms to Tbi.
 * 5.5.
 * Signature Meta-type
 * Within any typed formalism, any entity declared as having a type also has a signature.
 * In BMM, this is is the case for any kind of feature of a class, including constants, properties, and routines.
 * The signature of a feature is a formal construct capturing the type structure of the feature.
 * The simplest type of signature is that of properties and constants, which may be expressed formally in a typical abstract syntax as follows:This indicates that both have a return type, being the type of the value they are attached to at execution time.The general form of routine signatures is as follows:In the above, the construction [Type, …​] represents a type-tuple.Typical examples of function signatures are as follows:Typical procedure signatures include the following:In order to support functional semantics such as function-as-object, the notion of signature must exist as a first order type.
 * Since signatures have a special structure and usage, they have their own meta-type in BMM, BMM_SIGNATURE.
 * Instances of this meta-type represent any kind of signature, and consist of argument_types, whose meta-type is BMM_TUPLE_TYPE (See [Tuple Type]), and result_type, representing the result type.The following signatures state the types 'any function' and 'any procedure':As for the Tuple meta-type, the notional Signature meta-type is a BMM built-in, and is not itself defined in any BMM model.
 * <p>
 * <p>
 * <p>
 * T_result
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * <[T_arg1, T_arg2, ...], T_result> -- Function type <[T_arg1, T_arg2, ...]> -- Procedure type
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * <[], Date> -- a 0-order function like current_date <[Real, Real], Real> -- a 2nd-order function like '*' for the domain R <[Integer, Integer], Integer> -- a 2nd-order function like 'add' for the domain I
 * <p>
 * <p>
 * <p>
 * <[]> -- a 0-order (argumentless) procedure <[Real]> -- a 1st-order procedure for the domain R <[String, Integer]> -- a procedure taking a String and an Integer argument
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * Function -- any function Procedure -- any procedure
 * <p>
 * <p>
 * 5.5.1.
 * Conformance
 * Conformance of Signature types is as follows: meta-rule: A Signature type can only conform to another Signature type; concrete rules: all specific Function signatures conform to the signature Function); all specific Procedure signatures conform to the signature Procedure; the conformance of specific Function or Procedure signatures to another Function or Procedure signature is such that: the number of argument types accord and; the type conformance of each corresponding argument and result type (for functions) follows the rules for conformance given by the meta-types of those types.
 * 5.6.
 * Container Meta-types
 * In object-oriented type theory, 'container' types are generic types whose outer class happens to have the semantics of a container object, such as a list, set etc.
 * Container types such as List<T>, Set<T> and Hash<K,V> are used ubiquitously in object models.
 * In the BMM, containers and non-container generic types are distinguished via the meta-classes BMM_CONTAINER_TYPE and BMM_GENERIC_TYPE respectively.
 * This allows the BMM to treat container types in a special way.
 * A BMM_CONTAINER_TYPE can be thought of as a 1:N counterpart to a BMM_UNITARY_TYPE, such as the type List<Paragraph> with respect to Paragraph.
 * BMM_GENERIC_TYPE is thus used for objects considered to be singular, but whose types are a product of the base class and one or more parameter types, e.g.
 * Interval<Quantity>.The explicit provision of BMM_CONTAINER_TYPE enables BMM models to mention logical linear container types such as List<T> and Set<T>, on the assumption of their standard semantics in computer science , without worrying about providing concrete types which may be numerous and also variable across programming languages, e.g.
 * ArrayedList<T>, LinkedSet<T>, ArrayedStack<T> and so on.List and Set semantics are achieved via the BMM_CONTAINER_TYPE attributes is_ordered and is_unique, used in the standard combinations i.e.:The following diagram shows how the container type List<Paragraph>, declared as the type of an attribute paragraphs in a class Document, is represented in a BMM model.The semantics of indexed containers, commonly known under the type names Hash<K,V>, HashMap<K,V>, HashTable<K,V>, Dictionary<K,V> and so on, are represented by the meta-type BMM_INDEXED_CONTAINER_TYPE, which inherits from BMM_CONTAINER_TYPE, and adds the property index_type.
 * The latter type represents the key type, which must be such that hash values can be generated, and may be any type, but practically speaking, is almost always a String, Integer, or a Date/Time type.The following diagram shows how the container type Hash<String, Person> is represented in a BMM model.
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
 * Figure 16.
 * Container Type
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * Figure 17.
 * Indexed Container Type
 * 5.6.1.
 * Conformance
 * Conformance of Container types is according to the rules: meta-rule: A Container type can only conform to another Container type; concrete rules: A Container type Ca<Va> conforms to Container type Cb<Vb> conforms to iff: for base_class of Ca, all_ancestors() contains Cb; and Va conforms to Vb.
 * An indexed Container type Ca<Ka, Va> conforms to indexed Container type Gb<Kb, Vb> iff: for base_class of Ca, all_ancestors() contains Cb; Kb conforms to Kb and Va conforms to Vb.
 * 5.7.
 * Type Conformance
 * An algorithm to determine conformance of two type-names (e.g.
 * to implement BMM_MODEL.type_conforms_to()) is as follows:
 * <p>
 * <p>
 * <p>
 * Boolean type_conforms_to (String a_type, anc_type) { BMM_TYPE_NAME a_type_name, anc_type_name; if attached create_type_name_from_string (a_a_type) as a_type_name and attached create_type_name_from_string (anc_type) as anc_type_name { base_class = a_type_name.name; anc_base_class = anc_type_name.name; if (base_class.is_case_insensitive_equal (anc_base_class) or else class_definition (base_class).has_ancestor_class (anc_base_class)) { BMM_CLASS bmm_def_class = class_definition (base_class); // ---- Tuple types // ---- Signature types ---- // ---- Generic types // handle case where formal generic names appear in type name if (valid_generic_type_name (a_type) and bmm_def_class instanceOf (BMM_GENERIC_CLASS) { // in the case of both being generic, we need to compare generics // to start with, the number of generics must match BMM_CLASS anc_bmm_def_class = class_definition (anc_base_class); if (valid_generic_type_name (anc_type) and anc_bmm_def_class instanceOf (BMM_GENERIC_CLASS)) { ArrayedList<String> a_type_gen_params = a_type_name.generic_parameters_type_list; ArrayedList<String> anc_type_gen_params = anc_type_name.generic_parameters_type_list; if (a_type_gen_params.count = anc_type_gen_params.count) { Iterator<String> this_gen_parms_it = a_type_gen_params.iterator(); Iterator<String> other_gen_parms_it = anc_type_gen_params.iterator(); Boolean result = True; String a_type_gen_type, anc_type_gen_type; while (this_gen_parms_it.hasNext() && other_gen_parms_it.hasNext() || !result) { // first we convert any open generic parameters to their conformance types // We assume type names of 1 letter are open parameters String this_gen_parm = this_gen_parms_it.next(); String other_gen_parm = other_gen_parms_it.next(); if (formal_generic_parameter_name (this_gen_parm)) a_type_gen_type = this_bmm_gen_class.generic_parameter_conformance_type (this_gen_parm); else a_type_gen_type = this_gen_parm; if (formal_generic_parameter_name (other_gen_parm)) anc_type_gen_type = other_bmm_gen_class.generic_parameter_conformance_type (other_gen_parm); else anc_type_gen_type = other_gen_parm; -- now do the test result = type_conforms_to (a_type_gen_type, anc_type_gen_type); } return result; } } // Conforms - case where anc type is not provided in generic form, but desc is // e.g.
 * Interval<Integer> conforms to Interval else return True; } // in the following case, the descendant type is not generic, // so the ancestor type cannot be either, for conformance else return not valid_generic_type_name (anc_type); } } }
 * 5.8.
 * Model Theoretic Questions
 * The above model produces a number of outcomes that are not necessarily immediately obvious or expected, including:
 * <p>
 * <p>
 * <p>
 * <p>
 * 5.9.
 * Class Definitions
 * <p>
 * 5.9.1.
 * BMM_TYPE Class
 * <p>
 * 5.9.2.
 * BMM_UNITARY_TYPE Class
 * <p>
 * 5.9.3.
 * BMM_EFFECTIVE_TYPE Class
 * <p>
 * 5.9.4.
 * BMM_PARAMETER_TYPE Class
 * <p>
 * 5.9.5.
 * BMM_MODEL_TYPE Class
 * <p>
 * 5.9.6.
 * BMM_SIMPLE_TYPE Class
 * <p>
 * 5.9.7.
 * BMM_GENERIC_TYPE Class
 * <p>
 * 5.9.8.
 * BMM_TUPLE_TYPE Class
 * <p>
 * 5.9.9.
 * BMM_SIGNATURE Class
 * <p>
 * 5.9.10.
 * BMM_CONTAINER_TYPE Class
 * <p>
 * 5.9.11.
 * BMM_INDEXED_CONTAINER_TYPE Class
 */
