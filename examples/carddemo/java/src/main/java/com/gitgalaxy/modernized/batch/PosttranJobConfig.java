package com.gitgalaxy.modernized.batch;

import com.gitgalaxy.modernized.service.Cbtrn02cService;
import java.util.List;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

/** JCL job POSTTRAN (app/jcl/POSTTRAN.jcl) as a Spring Batch job (#3622): its steps in JCL order,
 *  each bypassed when its COND= (or the job's) is satisfied, as JCL does.
 *  JCL job flow field testing: open (5 public / 0 private estates). */
@Configuration
public class PosttranJobConfig {

    static final List<Dd> DDS_STEP15 = List.of(new Dd("STEPLIB", "AWS.M2.CARDDEMO.LOADLIB", "SHR", null, null), new Dd("TRANFILE", "AWS.M2.CARDDEMO.TRANSACT.VSAM.KSDS", "SHR", null, null), new Dd("DALYTRAN", "AWS.M2.CARDDEMO.DALYTRAN.PS", "SHR", null, null), new Dd("XREFFILE", "AWS.M2.CARDDEMO.CARDXREF.VSAM.KSDS", "SHR", null, null), new Dd("DALYREJS", "AWS.M2.CARDDEMO.DALYREJS", "NEW", "CATLG", "+1"), new Dd("ACCTFILE", "AWS.M2.CARDDEMO.ACCTDATA.VSAM.KSDS", "SHR", null, null), new Dd("TCATBALF", "AWS.M2.CARDDEMO.TCATBALF.VSAM.KSDS", "SHR", null, null));

    @Bean
    public Job posttranJob(JobRepository jobRepository, PlatformTransactionManager tx, JclSteps steps, Cbtrn02cService cbtrn02cService) {
        return new JobBuilder("POSTTRAN", jobRepository)
                .start(new StepBuilder("STEP15", jobRepository)
                        .tasklet(steps.program("STEP15", "STEP15", null, null, null, () -> cbtrn02cService.runBatch(DDS_STEP15, null)), tx).build())
                .build();
    }
}
