package com.gitgalaxy.modernized.batch;

import com.gitgalaxy.modernized.service.DbunldgsService;
import java.util.List;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

/** JCL job UNLDGSAM (app/app-authorization-ims-db2-mq/jcl/UNLDGSAM.JCL) as a Spring Batch job (#3622): its steps in JCL order,
 *  each bypassed when its COND= (or the job's) is satisfied, as JCL does.
 *  JCL job flow field testing: open (5 public / 0 private estates). */
@Configuration
public class UnldgsamJobConfig {

    static final List<Dd> DDS_STEP01 = List.of(new Dd("STEPLIB", "OEMA.IMS.IMSP.SDFSRESL", "SHR", null, null), new Dd("STEPLIB", "OEMA.IMS.IMSP.SDFSRESL.V151", "SHR", null, null), new Dd("STEPLIB", "AWS.M2.CARDDEMO.LOADLIB", "SHR", null, null), new Dd("DFSRESLB", "OEMA.IMS.IMSP.SDFSRESL", "SHR", null, null), new Dd("IMS", "OEM.IMS.IMSP.PSBLIB", "SHR", null, null), new Dd("IMS", "OEM.IMS.IMSP.DBDLIB", "SHR", null, null), new Dd("PASFILOP", "AWS.M2.CARDDEMO.PAUTDB.ROOT.GSAM", "OLD", "KEEP", null), new Dd("PADFILOP", "AWS.M2.CARDDEMO.PAUTDB.CHILD.GSAM", "OLD", "KEEP", null), new Dd("DDPAUTP0", "OEM.IMS.IMSP.PAUTHDB", "SHR", null, null), new Dd("DDPAUTX0", "OEM.IMS.IMSP.PAUTHDBX", "SHR", null, null), new Dd("DFSVSAMP", "OEMPP.IMS.V15R01MB.PROCLIB(DFSVSMDB)", "SHR", null, null));

    @Bean
    public Job unldgsamJob(JobRepository jobRepository, PlatformTransactionManager tx, JclSteps steps, DbunldgsService dbunldgsService) {
        return new JobBuilder("UNLDGSAM", jobRepository)
                .start(new StepBuilder("STEP01", jobRepository)
                        .tasklet(steps.program("STEP01", "STEP01", null, null, null, () -> dbunldgsService.runBatch(DDS_STEP01, "DLI,DBUNLDGS,DLIGSAMP,,,,,,,,,,,N")), tx).build())
                .build();
    }
}
