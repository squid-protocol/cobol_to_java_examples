package com.gitgalaxy.modernized.exception;

public class CicsConditionException extends RuntimeException {
    private final String condition;
    private final String program;
    private final String site;

    public CicsConditionException(String condition, String program, String site) {
        super("CICS Condition " + condition + " at " + site);
        this.condition = condition;
        this.program = program;
        this.site = site;
    }

    public String getCondition() { return condition; }
    public String getProgram() { return program; }
    public String getSite() { return site; }
}
