/*
 * Copyright (c) eHealth
 */
package be.jeremy.pascal.ci.frontend;

import be.jeremy.pascal.ci.message.Message;
import be.jeremy.pascal.ci.message.MessageHandler;
import be.jeremy.pascal.ci.message.MessageListener;
import be.jeremy.pascal.ci.message.MessageProducer;

import java.io.BufferedReader;
import java.io.IOException;

import static be.jeremy.pascal.ci.message.MessageType.SOURCE_LINE;

/**
 * @author Jeremy Vanpe (eh056)
 */
public class Source implements MessageProducer {

    public static final char EOL = '\n';

    public static final char EOF = 0;

    private final BufferedReader reader;

    private final MessageHandler messageHandler = new MessageHandler();

    private String line;

    private int lineNum;

    private int currentPos;

    public Source(BufferedReader reader) {
        this.lineNum = 0;
        this.currentPos = -2;
        this.reader = reader;
    }

    public int getLineNum() {
        return lineNum;
    }

    public int getPosition() {
        return currentPos;
    }

    public char currentChar() throws Exception {
        if (currentPos == -2) {// First time?
            readLine();
            return nextChar();
        } else if (line == null) { // At end of file?
            return EOF;
        } else if ((currentPos == -1) || (currentPos == line.length())) {// At end of line?
            return EOL;
        } else if (currentPos > line.length()) { // Need to read the next line?
            readLine();
            return nextChar();
        } else {// Return the character at the current
            return line.charAt(currentPos);
        }
    }

    public char nextChar() throws Exception {
        ++currentPos;
        return currentChar();
    }

    public char peekChar() throws Exception {
        currentChar();
        if (line == null) {
            return EOF;
        }
        int nextPos = currentPos + 1;
        return nextPos < line.length() ? line.charAt(nextPos) : EOL;
    }

    private void readLine() throws IOException {
        line = reader.readLine();  // null when at the end of the source
        currentPos = -1;
        if (line != null) {
            ++lineNum;
            sendMessage(new Message(SOURCE_LINE, new Object[] {lineNum, line}));
        }
    }

    public void close() throws Exception {
        if (reader != null) {
            try {
                reader.close();
            } catch (IOException ex) {
                ex.printStackTrace();
                throw ex;
            }
        }
    }

    @Override
    public void addMessageListener(MessageListener listener) {
        messageHandler.addListener(listener);
    }

    @Override
    public void removeMessageListener(MessageListener listener) {
        messageHandler.removeListener(listener);
    }

    @Override
    public void sendMessage(Message message) {
        messageHandler.sendMessage(message);
    }
}



