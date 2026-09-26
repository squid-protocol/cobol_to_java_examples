package com.gitgalaxy.modernized.batch;

/** One DD statement of a job step (#3622): its DD name, dataset (DSN, null for SYSOUT / DUMMY / in-stream),
 *  DISP status (NEW / OLD / SHR / MOD), DISP's normal-end disposition (KEEP / CATLG / DELETE / PASS /
 *  UNCATLG, null when not written) and GDG generation ((+1) a new one, (0) the current, (-1) before it). */
public record Dd(String name, String dsn, String status, String normalEnd, String generation) {
}
