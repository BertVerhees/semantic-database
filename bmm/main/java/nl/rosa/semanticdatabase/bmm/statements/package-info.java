package nl.rosa.semanticdatabase.bmm.statements;
/**
 * 11.
 * Statements
 * 11.1.
 * Overview
 * BMM provides meta-model elements for defining the body of a routine, consisting of statements.
 * This facility is not needed for achieving the original purpose of BMM, i.e.
 * a computable in-memory representation of a model at the interface level (classes, types and signatures), rather it provides a basis for representing program logic, such as function definitions.BMM statements are formalised using the classes BMM_STATEMENT_ITEM, BMM_STATEMENT_BLOCK and BMM_STATEMENT and various recognisable descendant types, as shown in the UML view below.The use of the three-class hierarchy pattern allows a Routine body to be a simple statement or a block, containing statements and/or more blocks.
 * The class BMM_STATEMENT is abstract, allowing specific statement meta-models to be developed whose 'statement' meta-types inherit from this class.
 * A number of common types are included by default, and are described below.This facility is primarily provided to support the definition of higher-level languages by embedding them in the outer BMM meta-model.
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * Figure 40.
 * Features for routine definition
 * <p>
 * <p>
 * <p>
 * <p>
 * 11.2.
 * Assignment
 * A BMM assignment is the same concept as found in most frame-based programming languages, and provides a meta-model to represent a writable target (variable or property) being assigned to from a source, which is any expression of the same evaluation type.
 * Type checking is thus based on a comparison of definition.type of the target and eval_type() of the source.The following example shows a simple assignment in the definition of the function position.The BMM meta-model for this statement is shown below.
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * class Simple_bank_account { feature // Definitions overdraft_limit: Decimal = 250; feature // State balance: Decimal; feature // Interface position: Decimal { Result := balance + overdraft_limit } invariant Solvent: position >= 0.0 }
 * <p>
 * <p>
 * <p>
 * Figure 41.
 * Assignment to function Result
 * 11.3.
 * Procedure Call
 * A procedure call is represented in BMM by the meta-type BMM_PROCEDURE_CALL, which refers to an instance of EL_PROCEDURE_AGENT, the same way that a function call is represented in terms of an EL_FUNCTION_AGENT.
 * In the following example, the procedure put() is called from the deposit() and withdraw() functions in the class Account_access.The BMM meta-model for the call is shown below.
 * <p>
 * <p>
 * <p>
 * class Simple_bank_account { feature // Modification put (val: Decimal) precondition valid_amount: val + overdraft_limit >= 0.0 { balance := balance + val } } class Account_access { feature // Command deposit (v: Decimal; ac: Simple_bank_account) pre_condition valid_amount: v > 0.0 { ac.put (v); } withdraw (v: Decimal; ac: Simple_bank_account) pre_condition valid_amount: ac.overdraft_limit - v >= 0.0 { ac.put (-v); } }
 * <p>
 * <p>
 * <p>
 * Figure 42.
 * Procedure call
 * 11.4.
 * Action Tables
 * The BMM statement package includes the meta-classes BMM_ACTION_TABLE and BMM_CONDITIONAL_ACTION, which together provide a way of representing a decision table whose outputs are statements (rather than values, as in the case of the related Expression meta-classes EL_DECISION_TABLE and EL_CONDITIONAL_EXPRESSION).
 * An action table corresponds closely to the standard constructs 'if/then/elseif' and the case statement.The following example shows a typical instance of the BMM Action table meta-type, within a procedure that generates appropriate alerts or alarms based on patient vital signs.
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * check_vital_signs if systolic_pressure.in_range ([critical_high]) raise_alarm ([emergency]) elseif systolic_pressure.in_range ([high]) and oxygen_sat.in_range([low]) call_staff
 * 11.5.
 * Assertions
 * The BMM statement model includes a statement meta-type to represent the notion of an assertion as a statement, typically expressed in syntax such as assert (<boolean expression>).
 * This kind of statement is understood as an executable instruction to check that the condition is true, and if not, to generate an exception of the appropriate type, assuming exceptions are available.
 * <p>
 * <p>
 * 11.6.
 * Class Definitions
 * <p>
 * 11.6.1.
 * BMM_STATEMENT_ITEM Class
 * <p>
 * 11.6.2.
 * BMM_STATEMENT_BLOCK Class
 * <p>
 * 11.6.3.
 * BMM_STATEMENT Class
 * <p>
 * 11.6.4.
 * BMM_PROCEDURE_CALL Class
 * <p>
 * 11.6.5.
 * BMM_ASSIGNMENT Class
 * <p>
 * 11.6.6.
 * BMM_ASSERTION Class
 * <p>
 * 11.6.7.
 * BMM_ACTION_TABLE Class
 * <p>
 * 11.6.8.
 * BMM_CONDITIONAL_ACTION Class
 */
