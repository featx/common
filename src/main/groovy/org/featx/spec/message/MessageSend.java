package org.featx.spec.message;

/**
 * @author Excepts
 * @since 2020/1/8 1:02
 */
public interface MessageSend<P> {

    SendResponse send(P payload);

    SendResponse send(String topic, String tag, String hash, P payload);

    void sendOneWay(P payload);

    void sendOneWay(String topic, String tag, String hash, P payload);

    void sendAsync(P payload, SendBack sendBack);

    void sendAsync(String topic, String tag, String hash, P payload, SendBack sendBack);
}
