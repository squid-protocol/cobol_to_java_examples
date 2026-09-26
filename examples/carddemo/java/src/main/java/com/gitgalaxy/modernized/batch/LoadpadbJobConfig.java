package com.gitgalaxy.modernized.batch;

import com.gitgalaxy.modernized.service.PaudblodService;
import java.util.List;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

/** JCL job LOADPADB (app/app-authorization-ims-db2-mq/jcl/LOADPADB.JCL) as a Spring Batch job (#3622): its steps in JCL order,
 *  each bypassed when its COND= (or the job's) is satisfied, as JCL does.
 *  Dataset flow: reads AWS.M2.CARDDEMO.PAUTDB.CHILD.FILEO (step STEP01), produced by app/app-authorization-ims-db2-mq/jcl/UNLDPADB.JCL step STEP01.
 *  Dataset flow: reads AWS.M2.CARDDEMO.PAUTDB.ROOT.FILEO (step STEP01), produced by app/app-authorization-ims-db2-mq/jcl/UNLDPADB.JCL step STEP01.
 *  JCL job flow field testing: open (5 public / 0 private estates). */
@Configuration
public class LoadpadbJobConfig {

    static final List<Dd> DDS_STEP01 = List.of(new Dd("STEPLIB", "OEMA.IMS.IMSP.SDFSRESL", "SHR", null, null), new Dd("STEPLIB", "OEMA.IMS.IMSP.SDFSRESL.V151", "SHR", null, null), new Dd("STEPLIB", "AWS.M2.CARDDEMO.LOADLIB", "SHR", null, null), new Dd("DFSRESLB", "OEMA.IMS.IMSP.SDFSRESL", "SHR", null, null), new Dd("IMS", "OEM.IMS.IMSP.PSBLIB", "SHR", null, null), new Dd("IMS", "OEM.IMS.IMSP.DBDLIB", "SHR", null, null), new Dd("INFILE1", "AWS.M2.CARDDEMO.PAUTDB.ROOT.FILEO", "SHR", null, null), new Dd("INFILE2", "AWS.M2.CARDDEMO.PAUTDB.CHILD.FILEO", "SHR", null, null), new Dd("DFSVSAMP", "OEMPP.IMS.V15R01MB.PROCLIB(DFSVSMDB)", "SHR", null, null));

    @Bean
    public Job loadpadbJob(JobRepository jobRepository, PlatformTransactionManager tx, JclSteps steps, PaudblodService paudblodService) {
        return new JobBuilder("LOADPADB", jobRepository)
                .start(new StepBuilder("STEP01", jobRepository)
                        .tasklet(steps.program("STEP01", "STEP01", null, null, null, () -> paudblodService.runBatch(DDS_STEP01, "BMP,PAUDBLOD,PSBPAUTB")), tx).build())
                .build();
    }
}
