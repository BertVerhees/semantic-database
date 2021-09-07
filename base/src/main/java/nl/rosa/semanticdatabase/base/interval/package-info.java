package nl.rosa.semanticdatabase.base.interval;
/**
 * 5.
 * Interval
 * 5.1.
 * Overview
 * Another kind of structure commonly needed in rich data is the interval.
 * The definition of the Interval<T> class here is an intensional one, i.e.
 * it states its members by implication from its limits, rather than enumerating them.
 * To support the common need for defining times in models that could be either a fixed point in time or a time interval, the classes Point_interval<T> and Proper_interval<T> are provided.
 * If Interval<X> is defined as the type of a feature in a class in an openEHR model, where X is some descendant of Ordered, then at runtime, either a Point_interval or Proper_interval may be attached.In addition to the generic interval types, the derived types Multiplicity_interval and Cardinality are provided, for use in models to represent multiplicity, optionality, and cardinality.The following UML diagram illustrates the interval package.
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * Figure 5.
 * base.foundation_types.interval package
 * 5.2.
 * Class Definitions
 * <p>
 * 5.2.1.
 * Interval Class
 * <p>
 * 5.2.2.
 * Point_interval Class
 * <p>
 * 5.2.3.
 * Proper_interval Class
 * <p>
 * 5.2.4.
 * Multiplicity_interval Class
 * <p>
 * 5.2.5.
 * Cardinality Class
 */
