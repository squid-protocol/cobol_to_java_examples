package com.gitgalaxy.modernized.messaging;

import java.util.Optional;

/** CICS transient data (#3620): WRITEQ / READQ / DELETEQ TD, routed per destination (RoutingTransientData). */
public interface TransientData {

    void write(String queue, String record);

    /** READQ TD: destructive, first in first out; empty when the queue is (QZERO). */
    Optional<String> read(String queue);

    void delete(String queue);
}
