package com.gitgalaxy.modernized.batch;

import com.gitgalaxy.modernized.service.Cbtrn03cService;
import java.util.List;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

/** JCL job TRANREPT (app/jcl/TRANREPT.jcl) as a Spring Batch job (#3622): its steps in JCL order,
 *  each bypassed when its COND= (or the job's) is satisfied, as JCL does.
 *  Dataset flow: produces AWS.M2.CARDDEMO.TRANSACT.BKUP (step PRC001), read by app/jcl/COMBTRAN.jcl step STEP05R.
 *  Dataset flow: produces AWS.M2.CARDDEMO.TRANSACT.BKUP (step PRC001), read by app/proc/TRANREPT.prc step STEP05R.
 *  Dataset flow: produces AWS.M2.CARDDEMO.TRANSACT.BKUP (step PRC001), read by samples/jcl/SORTTEST.jcl step STEP05R.
 *  Dataset flow: produces AWS.M2.CARDDEMO.TRANSACT.DALY (step STEP05R), read by app/proc/TRANREPT.prc step STEP10R.
 *  Dataset flow: reads AWS.M2.CARDDEMO.TRANSACT.BKUP (step STEP05R), produced by app/jcl/TRANBKP.jcl step PRC001.
 *  Dataset flow: reads AWS.M2.CARDDEMO.TRANSACT.BKUP (step STEP05R), produced by app/proc/TRANREPT.prc step PRC001.
 *  Dataset flow: reads AWS.M2.CARDDEMO.TRANSACT.BKUP (step STEP05R), produced by samples/jcl/REPRTEST.jcl step PRC001.
 *  Dataset flow: reads AWS.M2.CARDDEMO.TRANSACT.DALY (step STEP10R), produced by app/proc/TRANREPT.prc step STEP05R.
 *  Dataset flow: reads AWS.M2.CARDDEMO.TRANSACT.DALY (step STEP10R), produced by samples/jcl/SORTTEST.jcl step STEP05R.
 *  JCL job flow field testing: open (5 public / 0 private estates). */
@Configuration
public class TranreptJobConfig {

    static final List<Dd> DDS_STEP05R_PRC001 = List.of(new Dd("FILEIN", "NULLFILE", "SHR", null, null), new Dd("FILEOUT", "NULLFILE", "SHR", null, null), new Dd("SYSIN", "&CNTLLIB(REPROCT)", "SHR", null, null));
    static final List<Dd> DDS_STEP05R = List.of(new Dd("SORTIN", "AWS.M2.CARDDEMO.TRANSACT.BKUP", "SHR", null, "+1"), new Dd("SORTOUT", "AWS.M2.CARDDEMO.TRANSACT.DALY", "NEW", "CATLG", "+1"));
    static final List<Dd> DDS_STEP10R = List.of(new Dd("STEPLIB", "AWS.M2.CARDDEMO.LOADLIB", "SHR", null, null), new Dd("TRANFILE", "AWS.M2.CARDDEMO.TRANSACT.DALY", "SHR", null, "+1"), new Dd("CARDXREF", "AWS.M2.CARDDEMO.CARDXREF.VSAM.KSDS", "SHR", null, null), new Dd("TRANTYPE", "AWS.M2.CARDDEMO.TRANTYPE.VSAM.KSDS", "SHR", null, null), new Dd("TRANCATG", "AWS.M2.CARDDEMO.TRANCATG.VSAM.KSDS", "SHR", null, null), new Dd("DATEPARM", "AWS.M2.CARDDEMO.DATEPARM", "SHR", null, null), new Dd("TRANREPT", "AWS.M2.CARDDEMO.TRANREPT", "NEW", "CATLG", "+1"));

    @Bean
    public Job tranreptJob(JobRepository jobRepository, PlatformTransactionManager tx, JclSteps steps, Cbtrn03cService cbtrn03cService) {
        return new JobBuilder("TRANREPT", jobRepository)
                .start(new StepBuilder("STEP05R.PRC001", jobRepository)
                        .tasklet(steps.utility("STEP05R.PRC001", "STEP05R.PRC001", null, null, null, "IDCAMS", "STEP05R.PRC001 runs the utility IDCAMS (its control statements are in SYSIN) -- a utility step to port"), tx).build())
                .next(new StepBuilder("STEP05R", jobRepository)
                        .tasklet(steps.utility("STEP05R", "STEP05R", null, null, null, "SORT", "STEP05R runs the utility SORT (its control statements are in SYSIN) -- a utility step to port"), tx).build())
                .next(new StepBuilder("STEP10R", jobRepository)
                        .tasklet(steps.program("STEP10R", "STEP10R", null, null, null, () -> cbtrn03cService.runBatch(DDS_STEP10R, null)), tx).build())
                .build();
    }
}
