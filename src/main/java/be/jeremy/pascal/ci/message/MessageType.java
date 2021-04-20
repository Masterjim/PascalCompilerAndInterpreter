/*
 * Copyright (c) eHealth
 */
package be.jeremy.pascal.ci.message;

/**
 * @author Jeremy Vanpe (eh056)
 */
public enum MessageType {

    SOURCE_LINE,
    SYNTAX_ERROR,
    PARSER_SUMMARY,
    INTERPRETER_SUMMARY,
    COMPILER_SUMMARY,
    MISCELLANEOUS,
    TOKEN,
    ASSIGN,
    FETCH,
    BREAKPOINT,
    RUNTIME_ERROR,
    CALL,
    RETURN

}
