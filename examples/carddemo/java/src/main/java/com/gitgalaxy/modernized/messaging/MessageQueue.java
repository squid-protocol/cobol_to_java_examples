package com.gitgalaxy.modernized.messaging;

import java.util.Optional;

/**
 * The message port (#3620): IBM MQ's MQPUT / MQPUT1 / MQGET and intrapartition TD queues. The adapter
 * (integration.messaging) is the one implementation in this application.
 */
public interface MessageQueue {

    void send(String queue, String message);

    /** A destructive get, without waiting: empty when nothing is queued (MQRC_NO_MSG_AVAILABLE). */
    Optional<String> receive(String queue);

    /** Drops every message queued (DELETEQ TD). */
    void purge(String queue);
}
