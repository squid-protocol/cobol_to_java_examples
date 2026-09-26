package com.gitgalaxy.modernized.batch;

import com.gitgalaxy.modernized.service.CbimportService;
import java.util.List;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

/** JCL job CBIMPORT (app/jcl/CBIMPORT.jcl) as a Spring Batch job (#3622): its steps in JCL order,
 *  each bypassed when its COND= (or the job's) is satisfied, as JCL does.
 *  JCL job flow field testing: open (5 public / 0 private estates). */
@Configuration
public class CbimportJobConfig {

    static final List<Dd> DDS_STEP01 = List.of(new Dd("STEPLIB", "AWS.M2.CARDDEMO.LOADLIB", "SHR", null, null), new Dd("EXPFILE", "AWS.M2.CARDDEMO.EXPORT.DATA", "SHR", null, null), new Dd("CUSTOUT", "AWS.M2.CARDDEMO.CUSTDATA.IMPORT", "NEW", "CATLG", null), new Dd("ACCTOUT", "AWS.M2.CARDDEMO.ACCTDATA.IMPORT", "NEW", "CATLG", null), new Dd("XREFOUT", "AWS.M2.CARDDEMO.CARDXREF.IMPORT", "NEW", "CATLG", null), new Dd("TRNXOUT", "AWS.M2.CARDDEMO.TRANSACT.IMPORT", "NEW", "CATLG", null), new Dd("ERROUT", "AWS.M2.CARDDEMO.IMPORT.ERRORS", "NEW", "CATLG", null));

    @Bean
    public Job cbimportJob(JobRepository jobRepository, PlatformTransactionManager tx, JclSteps steps, CbimportService cbimportService) {
        return new JobBuilder("CBIMPORT", jobRepository)
                .start(new StepBuilder("STEP01", jobRepository)
                        .tasklet(steps.program("STEP01", "STEP01", null, null, null, () -> cbimportService.runBatch(DDS_STEP01, null)), tx).build())
                .build();
    }
}
