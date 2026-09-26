package com.gitgalaxy.modernized.batch;

import com.gitgalaxy.modernized.service.Cbstm03aService;
import java.util.List;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

/** JCL job CREASTMT (app/jcl/CREASTMT.JCL) as a Spring Batch job (#3622): its steps in JCL order,
 *  each bypassed when its COND= (or the job's) is satisfied, as JCL does.
 *  Dataset flow: produces AWS.M2.CARDDEMO.STATEMNT.PS (step STEP030), read by app/jcl/TXT2PDF1.JCL step TXT2PDF.
 *  Dataset flow: produces AWS.M2.CARDDEMO.STATEMNT.PS (step STEP040), read by app/jcl/TXT2PDF1.JCL step TXT2PDF.
 *  JCL job flow field testing: open (5 public / 0 private estates). */
@Configuration
public class CreastmtJobConfig {

    static final List<Dd> DDS_DELDEF01 = List.of();
    static final List<Dd> DDS_STEP010 = List.of(new Dd("SORTIN", "AWS.M2.CARDDEMO.TRANSACT.VSAM.KSDS", "SHR", null, null), new Dd("SORTOUT", "AWS.M2.CARDDEMO.TRXFL.SEQ", "NEW", "CATLG", null));
    static final List<Dd> DDS_STEP020 = List.of(new Dd("INFILE", "AWS.M2.CARDDEMO.TRXFL.SEQ", "SHR", null, null), new Dd("OUTFILE", "AWS.M2.CARDDEMO.TRXFL.VSAM.KSDS", "SHR", null, null));
    static final List<Dd> DDS_STEP030 = List.of(new Dd("HTMLFILE", "AWS.M2.CARDDEMO.STATEMNT.HTML", "MOD", "DELETE", null), new Dd("STMTFILE", "AWS.M2.CARDDEMO.STATEMNT.PS", "MOD", "DELETE", null));
    static final List<Dd> DDS_STEP040 = List.of(new Dd("STEPLIB", "AWS.M2.CARDDEMO.LOADLIB", "SHR", null, null), new Dd("TRNXFILE", "AWS.M2.CARDDEMO.TRXFL.VSAM.KSDS", "SHR", null, null), new Dd("XREFFILE", "AWS.M2.CARDDEMO.CARDXREF.VSAM.KSDS", "SHR", null, null), new Dd("ACCTFILE", "AWS.M2.CARDDEMO.ACCTDATA.VSAM.KSDS", "SHR", null, null), new Dd("CUSTFILE", "AWS.M2.CARDDEMO.CUSTDATA.VSAM.KSDS", "SHR", null, null), new Dd("STMTFILE", "AWS.M2.CARDDEMO.STATEMNT.PS", "NEW", "CATLG", null), new Dd("HTMLFILE", "AWS.M2.CARDDEMO.STATEMNT.HTML", "NEW", "CATLG", null));

    @Bean
    public Job creastmtJob(JobRepository jobRepository, PlatformTransactionManager tx, JclSteps steps, Cbstm03aService cbstm03aService) {
        return new JobBuilder("CREASTMT", jobRepository)
                .start(new StepBuilder("DELDEF01", jobRepository)
                        .tasklet(steps.utility("DELDEF01", "DELDEF01", null, null, null, "IDCAMS", "DELDEF01 runs the utility IDCAMS (its control statements are in SYSIN) -- a utility step to port"), tx).build())
                .next(new StepBuilder("STEP010", jobRepository)
                        .tasklet(steps.utility("STEP010", "STEP010", null, null, null, "SORT", "STEP010 runs the utility SORT (its control statements are in SYSIN) -- a utility step to port"), tx).build())
                .next(new StepBuilder("STEP020", jobRepository)
                        .tasklet(steps.utility("STEP020", "STEP020", null, "(0,NE)", null, "IDCAMS", "STEP020 runs the utility IDCAMS (its control statements are in SYSIN) -- a utility step to port"), tx).build())
                .next(new StepBuilder("STEP030", jobRepository)
                        .tasklet(steps.iefbr14("STEP030", "STEP030", null, "(0,NE)", null, DDS_STEP030), tx).build())
                .next(new StepBuilder("STEP040", jobRepository)
                        .tasklet(steps.program("STEP040", "STEP040", null, "(0,NE)", null, () -> cbstm03aService.runBatch(DDS_STEP040, null)), tx).build())
                .build();
    }
}
