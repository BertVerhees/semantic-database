package nl.rosa.semanticdatabase.bmm.literal_values;
/**
 * 8.
 * Literal Values
 * 8.1.
 * Overview
 * With a typical formal model, there is a need for formal representation of literal values.
 * This is needed to support constant declarations, 'default values' (a UML concept), enumeration literals and literal routine calls (see next section).
 * In BMM, all such values have as their meta-type the type BMM_LITERAL_VALUE or a descendant.
 * The type hierarchy mostly mimicks the hierarchy of the BMM_TYPE hierarchy, allowing for literal values of any of the meta-types in that part of the model.
 * The UML model of these types is shown below.
 * <p>
 * <p>
 * <p>
 * Figure 32.
 * base.bmm.core.literal_value package - Literal Values
 * 8.2.
 * General Model
 * When a BMM model is instantiated in its in-memory form, e.g.
 * in a BMM modelling tool, any literal values in the model such as constant values (e.g.
 * Real Pi = 3.1415926), default values (e.g.
 * Person.name: String = "(unknown)") etc are instances of 'two types':The value of any such instance is represented by the value_literal field within its BMM_LITERAL_VALUE.
 * This is assumed to carry a serialised form of the value expressed in a syntax known to the model processing environment within which the BMM model is being used.
 * This may be a programming language syntax, JSON, or any other serialisable format, and is specified by BMM_LITERAL_VALUE.syntax.
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * 8.3.
 * Container Literals
 * Literals representing Lists or Sets of values of objects of other types have as their BMM meta-type BMM_CONTAINER_VALUE.
 * For example, if the serialised value ["Feyerabend", "Lakatos", "Popper"] (which happens to be a JSON Array of Strings) were parsed as a List<String> instance, its meta-type would be a BMM_CONTAINER_VALUE instance whose value_literal was the same string, assuming JSON were used as the syntax, and whose type will be BMM_CONTAINER_TYPE.
 * Similarly a syntax that supported literal Sets using braces, e.g.
 * {"Feyerabend", "Lakatos", "Popper"} may be parsed to a Set<String> instance, with the same meta-type as for the List.In a similar way, a Hash table (aka 'map', 'dictionary' etc) structure has as its meta-type BMM_INDEXED_CONTAINER_VALUE.
 * <p>
 * <p>
 * <p>
 * <p>
 * 8.4.
 * Literal Tuples
 * Literal tuples may be expressed in BMM, but are not instances of BMM_LITERAL_VALUE; instead they are instances (at the meta level) of EL_TUPLE, an expression-related meta-type.
 * This is a consequence of the fact that Tuple is considered a BMM built-in type rather than a model-provided type, and also that a Tuple instance may contain items of any meta-type, not just literal values.
 * Tuple instances are used in BMM expressions and described in Section 9.2.
 * <p>
 * <p>
 * 8.5.
 * Type Extensions
 * If it were desired to create a full set of 'native' types for BMM, in the way supplied for UML in the UML Standard Profile, specific descendants would be added to the meta-type classes BMM_SIMPLE_TYPE and BMM_GENERIC_TYPE, as well as BMM_LITERAL_VALUE, which would allow such instances to be directly representable in the internal BMM type system.
 * This would still need to be ultimately mapped to the types actually available in any language in which BMM is implemented.
 * <p>
 * <p>
 * 8.6.
 * Class Definitions
 * <p>
 * 8.6.1.
 * BMM_LITERAL_VALUE Class
 * <p>
 * 8.6.2.
 * BMM_CONTAINER_VALUE Class
 * <p>
 * 8.6.3.
 * BMM_INDEXED_CONTAINER_VALUE Class
 * <p>
 * 8.6.4.
 * BMM_UNITARY_VALUE Class
 * <p>
 * 8.6.5.
 * BMM_PRIMITIVE_VALUE Class
 * <p>
 * 8.6.6.
 * BMM_STRING_VALUE Class
 * <p>
 * 8.6.7.
 * BMM_INTEGER_VALUE Class
 * <p>
 * 8.6.8.
 * BMM_BOOLEAN_VALUE Class
 * <p>
 * 8.6.9.
 * BMM_INTERVAL_VALUE Class
 */
