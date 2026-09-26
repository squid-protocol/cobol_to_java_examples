package com.gitgalaxy.modernized.batch;

import com.gitgalaxy.modernized.service.Cbpaup0cService;
import java.util.List;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

/** JCL job CBPAUP0J (app/app-authorization-ims-db2-mq/jcl/CBPAUP0J.jcl) as a Spring Batch job (#3622): its steps in JCL order,
 *  each bypassed when its COND= (or the job's) is satisfied, as JCL does.
 *  JCL job flow field testing: open (5 public / 0 private estates). */
@Configuration
public class Cbpaup0jJobConfig {

    static final List<Dd> DDS_STEP01 = List.of(new Dd("STEPLIB", "IMS.SDFSRESL", "SHR", null, null), new Dd("STEPLIB", "XXXXXXXX.PROD.LOADLIB", "SHR", null, null), new Dd("DFSRESLB", "IMS.SDFSRESL", "SHR", null, null), new Dd("PROCLIB", "IMS.PROCLIB", "SHR", null, null), new Dd("DFSSEL", "IMS.SDFSRESL", "SHR", null, null), new Dd("IMS", "IMS.PSBLIB", "SHR", null, null), new Dd("IMS", "IMS.DBDLIB", "SHR", null, null));

    @Bean
    public Job cbpaup0jJob(JobRepository jobRepository, PlatformTransactionManager tx, JclSteps steps, Cbpaup0cService cbpaup0cService) {
        return new JobBuilder("CBPAUP0J", jobRepository)
                .start(new StepBuilder("STEP01", jobRepository)
                        .tasklet(steps.program("STEP01", "STEP01", null, null, null, () -> cbpaup0cService.runBatch(DDS_STEP01, "BMP,CBPAUP0C,PSBPAUTB")), tx).build())
                .build();
    }
}
