package com.gitgalaxy.modernized.messaging;

import java.util.Optional;

/**
 * CICS temporary storage (#3620): named queues of numbered items (from 1) that any program of the
 * application can write, read by number or in sequence, rewrite, and delete whole -- scratchpad
 * state, not messaging.
 */
public interface TempStorage {

    /** WRITEQ TS: appends an item; returns its number. */
    int writeItem(String queue, String record);

    /** WRITEQ TS ITEM(n) REWRITE. */
    void rewriteItem(String queue, int item, String record);

    /** READQ TS ITEM(n). */
    Optional<String> readItem(String queue, int item);

    /** READQ TS (NEXT): the item after the last one read. */
    Optional<String> readNext(String queue);

    /** DELETEQ TS: the whole queue. */
    void delete(String queue);

    int numItems(String queue);
}
