package com.gitgalaxy.modernized.exception;

public class CicsAbendException extends RuntimeException {
    private final String abcode;
    private final String program;
    private final String site;

    public CicsAbendException(String abcode, String program, String site) {
        super("CICS Abend " + abcode + " at " + site);
        this.abcode = abcode;
        this.program = program;
        this.site = site;
    }

    public String getAbcode() { return abcode; }
    public String getProgram() { return program; }
    public String getSite() { return site; }
}
