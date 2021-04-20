/*
 * Copyright (c) eHealth
 */
package be.jeremy.pascal.ci.backend.compiler;

import be.jeremy.pascal.ci.backend.Backend;
import be.jeremy.pascal.ci.intermediate.ICode;
import be.jeremy.pascal.ci.intermediate.SymTab;
import be.jeremy.pascal.ci.message.Message;
import be.jeremy.pascal.ci.message.MessageListener;

import static be.jeremy.pascal.ci.message.MessageType.COMPILER_SUMMARY;

/**
 * @author Jeremy Vanpe (eh056)
 */
public class CodeGenerator extends Backend {

    public void process(ICode iCode, SymTab symTab) {
        long startTime = System.currentTimeMillis();
        float elapsedTime = (System.currentTimeMillis() - startTime) / 1000f;
        int instructionCount = 0;

        sendMessage(new Message(COMPILER_SUMMARY, new Number[]{instructionCount, elapsedTime}));
    }

    @Override
    public void addMessageListener(MessageListener listener) {

    }

    @Override
    public void removeMessageListener(MessageListener listener) {

    }

    @Override
    public void sendMessage(Message message) {

    }
}
