/*
 * Copyright (c) eHealth
 */
package be.jeremy.pascal.ci.frontend.pascal;

import be.jeremy.pascal.ci.frontend.EofToken;
import be.jeremy.pascal.ci.frontend.Scanner;
import be.jeremy.pascal.ci.frontend.Source;
import be.jeremy.pascal.ci.frontend.Token;

import static be.jeremy.pascal.ci.frontend.Source.EOF;

/**
 * @author Jeremy Vanpe (eh056)
 */
public class PascalScanner extends Scanner {

    public PascalScanner(Source source) {
        super(source);
    }

    protected Token extractToken() throws Exception {
        Token token;
        char currentChar = currentChar();
        // Construct the next token. The current character determines the token type.
        if (currentChar == EOF) {
            token = new EofToken(source);
        } else {
            token = new Token(source);
        }
        return token;
    }

}

