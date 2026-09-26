package com.gitgalaxy.modernized.batch;

import com.gitgalaxy.modernized.service.BankdataService;
import java.util.List;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

/** JCL job BANKDATA (etc/install/base/installjcl/BANKDATA.jcl) as a Spring Batch job (#3622): its steps in JCL order,
 *  each bypassed when its COND= (or the job's) is satisfied, as JCL does.
 *  JCL job flow field testing: open (5 public / 0 private estates). */
@Configuration
public class BankdataJobConfig {

    static final List<Dd> DDS_BANKDAT0 = List.of();
    static final List<Dd> DDS_BANKDAT1 = List.of();
    static final List<Dd> DDS_BANKDAT5 = List.of(new Dd("STEPLIB", "@BANK_DBRMLIB@", "SHR", null, null), new Dd("STEPLIB", "@BANK_LOADLIB@", "SHR", null, null), new Dd("STEPLIB", "@DB2_HLQ@.SDSNLOAD", "SHR", null, null), new Dd("VSAM", "@BANK_PREFIX@.CUSTOMER", "SHR", null, null));

    @Bean
    public Job bankdataJob(JobRepository jobRepository, PlatformTransactionManager tx, JclSteps steps, BankdataService bankdataService) {
        return new JobBuilder("BANKDATA", jobRepository)
                .start(new StepBuilder("BANKDAT0", jobRepository)
                        .tasklet(steps.utility("BANKDAT0", "BANKDAT0", null, null, null, "IDCAMS", "BANKDAT0 runs the utility IDCAMS (its control statements are in SYSIN) -- a utility step to port"), tx).build())
                .next(new StepBuilder("BANKDAT1", jobRepository)
                        .tasklet(steps.utility("BANKDAT1", "BANKDAT1", null, null, null, "IDCAMS", "BANKDAT1 runs the utility IDCAMS (its control statements are in SYSIN) -- a utility step to port"), tx).build())
                .next(new StepBuilder("BANKDAT5", jobRepository)
                        .tasklet(steps.program("BANKDAT5", "BANKDAT5", null, null, null, () -> bankdataService.runBatch(DDS_BANKDAT5, null)), tx).build())
                .build();
    }
}
