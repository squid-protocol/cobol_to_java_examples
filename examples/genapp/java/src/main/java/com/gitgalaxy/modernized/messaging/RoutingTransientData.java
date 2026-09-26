package com.gitgalaxy.modernized.messaging;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Transient data, routed by each destination's facts (#3620): a CICS-supplied log destination
 * (CSSL, CSMT, ...) goes to the log `cics.td.<queue>`; an extrapartition destination the CSD binds
 * to a DD / dataset appends to `<gitgalaxy.td.directory>/<queue>.txt` (the internal reader's JCL
 * too, flagged: submitting it is #3622); an intrapartition queue.
 * A destination missing below is treated as intrapartition.
 */
@Component
public class RoutingTransientData implements TransientData {

    static final Map<String, String> ROUTES = new HashMap<>();

    static {
        ROUTES.put("CSMT", "log");  // a CICS-supplied log destination
    }
    private final Path directory;

    public RoutingTransientData(@Value("${gitgalaxy.td.directory:td-out}") String directory) {
        this.directory = Path.of(directory);
    }

    @Override
    public void write(String queue, String record) {
        switch (ROUTES.getOrDefault(queue, "queue")) {
            case "log" -> LoggerFactory.getLogger("cics.td." + queue).info(record);
            case "dataset", "reader" -> append(queue, record);
            default -> LOG.warn("TD {} has no message port", queue);
        }
    }

    @Override
    public Optional<String> read(String queue) {
        String route = ROUTES.getOrDefault(queue, "queue");
        if (route.equals("queue") || route.equals("symbol")) {
            return Optional.empty();
        }
        throw new UnsupportedOperationException("TD " + queue + " is a " + route + " destination: it is written, not read");
    }

    @Override
    public void delete(String queue) {
        // no intrapartition queue in this application
    }

    private void append(String queue, String record) {
        try {
            Files.createDirectories(directory);
            Files.write(directory.resolve(queue + ".txt"), List.of(record), StandardCharsets.UTF_8,
                    StandardOpenOption.CREATE, StandardOpenOption.APPEND);
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }

    private static final Logger LOG = LoggerFactory.getLogger(RoutingTransientData.class);
}
