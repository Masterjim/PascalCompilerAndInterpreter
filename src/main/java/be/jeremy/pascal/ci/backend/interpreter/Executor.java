/*
 * Copyright (c) eHealth
 */
package be.jeremy.pascal.ci.backend.interpreter;

import be.jeremy.pascal.ci.backend.Backend;
import be.jeremy.pascal.ci.intermediate.ICode;
import be.jeremy.pascal.ci.intermediate.SymTab;
import be.jeremy.pascal.ci.message.Message;
import be.jeremy.pascal.ci.message.MessageListener;

import static be.jeremy.pascal.ci.message.MessageType.INTERPRETER_SUMMARY;

/**
 * @author Jeremy Vanpe (eh056)
 */
public class Executor extends Backend {
    @Override
    public void process(ICode iCode, SymTab symTab) {
        long startTime = System.currentTimeMillis();
        float elapsedTime = (System.currentTimeMillis() - startTime) / 1000f;
        int executionCount = 0;
        int runtimeErrors = 0;

        sendMessage(new Message(INTERPRETER_SUMMARY, new Number[]{executionCount, runtimeErrors, elapsedTime}));
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
