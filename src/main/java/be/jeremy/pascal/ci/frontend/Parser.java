/*
 * Copyright (c) eHealth
 */
package be.jeremy.pascal.ci.frontend;

import be.jeremy.pascal.ci.intermediate.ICode;
import be.jeremy.pascal.ci.intermediate.SymTab;
import be.jeremy.pascal.ci.message.Message;
import be.jeremy.pascal.ci.message.MessageHandler;
import be.jeremy.pascal.ci.message.MessageListener;
import be.jeremy.pascal.ci.message.MessageProducer;

/**
 * @author Jeremy Vanpe (eh056)
 */
public abstract class Parser implements MessageProducer {

    protected static SymTab symTab = null;

    protected static MessageHandler messageHandler = new MessageHandler();

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

    /**
     * Add a parser message listener.
     *
     * @param listener the message listener to add.
     */
    public void addMessageListener(MessageListener listener) {
        messageHandler.addListener(listener);
    }

    /**
     * Remove a parser message listener.
     *
     * @param listener the message listener to remove.
     */
    public void removeMessageListener(MessageListener listener) {
        messageHandler.removeListener(listener);
    }

    /**
     * Notify listeners after setting the message.
     *
     * @param message the message to set.
     */
    public void sendMessage(Message message) {
        messageHandler.sendMessage(message);
    }
}
