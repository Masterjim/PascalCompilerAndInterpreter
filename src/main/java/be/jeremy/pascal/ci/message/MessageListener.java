/*
 * Copyright (c) eHealth
 */
package be.jeremy.pascal.ci.message;

/**
 * @author Jeremy Vanpe (eh056)
 */
public interface MessageListener {

    /**
     * Called to receive a message sent by a message producer.
     *
     * @param message the message that was sent.
     */
    void messageReceived(Message message);

}
