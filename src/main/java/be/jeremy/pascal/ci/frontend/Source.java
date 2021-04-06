/*
 * Copyright (c) eHealth
 */
package be.jeremy.pascal.ci.frontend;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * @author Jeremy Vanpe (eh056)
 */
public class Source {

    public static final char EOL = '\n';

    public static final char EOF = 0;

    private BufferedReader reader;

    private String line;

    private int lineNum;

    private int currentPos;

    public Source(BufferedReader reader) throws IOException {
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
}



