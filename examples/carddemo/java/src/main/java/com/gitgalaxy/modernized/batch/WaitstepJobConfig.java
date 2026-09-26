package com.gitgalaxy.modernized.batch;

import com.gitgalaxy.modernized.service.CobswaitService;
import java.util.List;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

/** JCL job WAITSTEP (app/jcl/WAITSTEP.jcl) as a Spring Batch job (#3622): its steps in JCL order,
 *  each bypassed when its COND= (or the job's) is satisfied, as JCL does.
 *  JCL job flow field testing: open (5 public / 0 private estates). */
@Configuration
public class WaitstepJobConfig {

    static final List<Dd> DDS_WAIT = List.of(new Dd("STEPLIB", "AWS.M2.CARDDEMO.LOADLIB", "SHR", null, null));

    @Bean
    public Job waitstepJob(JobRepository jobRepository, PlatformTransactionManager tx, JclSteps steps, CobswaitService cobswaitService) {
        return new JobBuilder("WAITSTEP", jobRepository)
                .start(new StepBuilder("WAIT", jobRepository)
                        .tasklet(steps.program("WAIT", "WAIT", null, null, null, () -> cobswaitService.runBatch(DDS_WAIT, null)), tx).build())
                .build();
    }
}
