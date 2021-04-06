/*
 * Copyright (c) eHealth
 */
package be.jeremy.pascal.ci.frontend;

import be.jeremy.pascal.ci.intermediate.ICode;
import be.jeremy.pascal.ci.intermediate.SymTab;

/**
 * @author Jeremy Vanpe (eh056)
 */
public abstract class Parser {

    protected static SymTab symTab = null;

    protected Scanner scanner;

    protected ICode iCode;

    protected Parser(Scanner scanner) {
        this.scanner = scanner;
        this.iCode = null;
    }

    public static SymTab getSymTab() {
        return symTab;
    }

    public ICode getICode() {
        return iCode;
    }

    public abstract void parse() throws Exception;

    public abstract int getErrorCount();

    public Token currentToken() {
        return scanner.currentToken();
    }

    public Token nextToken() throws Exception {
        return scanner.nextToken();
    }

}
