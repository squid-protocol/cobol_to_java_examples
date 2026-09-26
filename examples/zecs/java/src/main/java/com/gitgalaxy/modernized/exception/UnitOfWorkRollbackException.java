package com.gitgalaxy.modernized.exception;

public class UnitOfWorkRollbackException extends RuntimeException {
    private final String program;
    private final String site;

    public UnitOfWorkRollbackException(String program, String site) {
        super("Rollback requested at " + site);
        this.program = program;
        this.site = site;
    }

    public String getProgram() { return program; }
    public String getSite() { return site; }
}
