package com.gitgalaxy.modernized.messaging;

import java.util.Map;
import java.util.Optional;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import org.springframework.stereotype.Component;

/** Queues in this application's memory (#3620, integration.messaging: in-memory). */
@Component
public class InMemoryMessageQueue implements MessageQueue {

    private final Map<String, Queue<String>> queues = new ConcurrentHashMap<>();

    @Override
    public void send(String queue, String message) {
        queues.computeIfAbsent(queue, q -> new ConcurrentLinkedQueue<>()).add(message);
    }

    @Override
    public Optional<String> receive(String queue) {
        Queue<String> q = queues.get(queue);
        return Optional.ofNullable(q == null ? null : q.poll());
    }

    @Override
    public void purge(String queue) {
        queues.remove(queue);
    }
}
