package org.featx.spec.message;

/**
 * @author Excepts
 * @since 2020/1/8 1:04
 */
public interface MessageReceive<T> {

    void receive(T payload);
}
