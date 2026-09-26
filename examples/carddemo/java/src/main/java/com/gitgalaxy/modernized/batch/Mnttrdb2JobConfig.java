package com.gitgalaxy.modernized.batch;

import com.gitgalaxy.modernized.service.CobtupdtService;
import java.util.List;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

/** JCL job MNTTRDB2 (app/app-transaction-type-db2/jcl/MNTTRDB2.jcl) as a Spring Batch job (#3622): its steps in JCL order,
 *  each bypassed when its COND= (or the job's) is satisfied, as JCL does.
 *  JCL job flow field testing: open (5 public / 0 private estates). */
@Configuration
public class Mnttrdb2JobConfig {

    static final List<Dd> DDS_STEP1 = List.of(new Dd("STEPLIB", "OEM.DB2.DAZ1.SDSNEXIT", "SHR", null, null), new Dd("STEPLIB", "OEMA.DB2.VERSIONA.SDSNLOAD", "SHR", null, null), new Dd("STEPLIB", "AWS.M2.CARDDEMO.LOADLIB", "SHR", null, null), new Dd("DBRMLIB", "AWS.M2.CARDDEMO.DBRMLIB", "SHR", null, null), new Dd("INPFILE", "INPFILE", "SHR", null, null));

    @Bean
    public Job mnttrdb2Job(JobRepository jobRepository, PlatformTransactionManager tx, JclSteps steps, CobtupdtService cobtupdtService) {
        return new JobBuilder("MNTTRDB2", jobRepository)
                .start(new StepBuilder("STEP1", jobRepository)
                        .tasklet(steps.program("STEP1", "STEP1", null, null, null, () -> cobtupdtService.runBatch(DDS_STEP1, null)), tx).build())
                .build();
    }
}
