/*
 * Copyright (c) eHealth
 */
package be.jeremy.pascal.ci.frontend.pascal;

import be.jeremy.pascal.ci.frontend.EofToken;
import be.jeremy.pascal.ci.frontend.Parser;
import be.jeremy.pascal.ci.frontend.Scanner;
import be.jeremy.pascal.ci.frontend.Token;
import be.jeremy.pascal.ci.message.Message;

import static be.jeremy.pascal.ci.message.MessageType.PARSER_SUMMARY;

/**
 * @author Jeremy Vanpe (eh056)
 */
public class PascalParserTD extends Parser {

    public PascalParserTD(Scanner scanner) {
        super(scanner);
    }

    @Override
    public void parse() throws Exception {
        long startTime = System.currentTimeMillis();

        Token token;
        while (!((token = nextToken()) instanceof EofToken)) {
        }

        float elapsedTime = (System.currentTimeMillis() - startTime) / 1000f;

        sendMessage(new Message(PARSER_SUMMARY, new Number[]{token.getLineNumber(), getErrorCount(), elapsedTime}));
    }

    @Override
    public int getErrorCount() {
        return 0;
    }

}
