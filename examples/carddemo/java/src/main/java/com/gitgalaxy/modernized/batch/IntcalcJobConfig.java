package com.gitgalaxy.modernized.batch;

import com.gitgalaxy.modernized.service.Cbact04cService;
import java.util.List;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

/** JCL job INTCALC (app/jcl/INTCALC.jcl) as a Spring Batch job (#3622): its steps in JCL order,
 *  each bypassed when its COND= (or the job's) is satisfied, as JCL does.
 *  Dataset flow: produces AWS.M2.CARDDEMO.SYSTRAN (step STEP15), read by app/jcl/COMBTRAN.jcl step STEP05R.
 *  JCL job flow field testing: open (5 public / 0 private estates). */
@Configuration
public class IntcalcJobConfig {

    static final List<Dd> DDS_STEP15 = List.of(new Dd("STEPLIB", "AWS.M2.CARDDEMO.LOADLIB", "SHR", null, null), new Dd("TCATBALF", "AWS.M2.CARDDEMO.TCATBALF.VSAM.KSDS", "SHR", null, null), new Dd("XREFFILE", "AWS.M2.CARDDEMO.CARDXREF.VSAM.KSDS", "SHR", null, null), new Dd("XREFFIL1", "AWS.M2.CARDDEMO.CARDXREF.VSAM.AIX.PATH", "SHR", null, null), new Dd("ACCTFILE", "AWS.M2.CARDDEMO.ACCTDATA.VSAM.KSDS", "SHR", null, null), new Dd("DISCGRP", "AWS.M2.CARDDEMO.DISCGRP.VSAM.KSDS", "SHR", null, null), new Dd("TRANSACT", "AWS.M2.CARDDEMO.SYSTRAN", "NEW", "CATLG", "+1"));

    @Bean
    public Job intcalcJob(JobRepository jobRepository, PlatformTransactionManager tx, JclSteps steps, Cbact04cService cbact04cService) {
        return new JobBuilder("INTCALC", jobRepository)
                .start(new StepBuilder("STEP15", jobRepository)
                        .tasklet(steps.program("STEP15", "STEP15", null, null, null, () -> cbact04cService.runBatch(DDS_STEP15, "2022071800")), tx).build())
                .build();
    }
}
