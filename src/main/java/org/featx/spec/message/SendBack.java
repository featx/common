package org.featx.spec.message;

/**
 * @author Excepts
 * @since 2020/1/11 18:23
 */
public interface SendBack {
    /**
     * The callback method of send message successfully
     * @param sendResponse Send result
     */
    void onSuccess(final SendResponse sendResponse);

    /**
     * The callback method of send message failed
     * @param sendException Send failed exception
     */
    void onException(final SendException sendException);
}
