package com.gitgalaxy.modernized.batch;

import com.gitgalaxy.modernized.service.CobolSam1Service;
import java.util.List;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

/** JCL job ZDERUN (JCL/RUN.jcl) as a Spring Batch job (#3622): its steps in JCL order,
 *  each bypassed when its COND= (or the job's) is satisfied, as JCL does.
 *  Dataset flow: reads IBMUSER.SAMPLE.COPY (step CMPLSAM1), produced by JCL/ALLOCATE.jcl step ALLOCAT.
 *  Dataset flow: reads IBMUSER.SAMPLE.COPY (step CMPLSAM1), produced by JCL/ALLOCATE.jcl step DELETE.
 *  Dataset flow: reads IBMUSER.SAMPLE.COPY (step CMPLSAM2), produced by JCL/ALLOCATE.jcl step ALLOCAT.
 *  Dataset flow: reads IBMUSER.SAMPLE.COPY (step CMPLSAM2), produced by JCL/ALLOCATE.jcl step DELETE.
 *  Dataset flow: reads IBMUSER.SAMPLE.COPYLIB (step CMPLSAM1), produced by JCL/ALLOCATE.jcl step ALLOCAT.
 *  Dataset flow: reads IBMUSER.SAMPLE.COPYLIB (step CMPLSAM1), produced by JCL/ALLOCATE.jcl step DELETE.
 *  Dataset flow: reads IBMUSER.SAMPLE.CUSTFILE (step SAM1), produced by JCL/ALLOCATE.jcl step ALLOCAT.
 *  Dataset flow: reads IBMUSER.SAMPLE.CUSTFILE (step SAM1), produced by JCL/ALLOCATE.jcl step DELETE.
 *  Dataset flow: reads IBMUSER.SAMPLE.LOAD (step LINKSAM1), produced by JCL/ALLOCATE.jcl step ALLOCAT.
 *  Dataset flow: reads IBMUSER.SAMPLE.LOAD (step LINKSAM1), produced by JCL/ALLOCATE.jcl step DELETE.
 *  Dataset flow: reads IBMUSER.SAMPLE.LOAD (step LINKSAM2), produced by JCL/ALLOCATE.jcl step ALLOCAT.
 *  Dataset flow: reads IBMUSER.SAMPLE.LOAD (step LINKSAM2), produced by JCL/ALLOCATE.jcl step DELETE.
 *  Dataset flow: reads IBMUSER.SAMPLE.LOAD (step SAM1), produced by JCL/ALLOCATE.jcl step ALLOCAT.
 *  Dataset flow: reads IBMUSER.SAMPLE.LOAD (step SAM1), produced by JCL/ALLOCATE.jcl step DELETE.
 *  Dataset flow: reads IBMUSER.SAMPLE.OBJ (step LINKSAM1), produced by JCL/ALLOCATE.jcl step ALLOCAT.
 *  Dataset flow: reads IBMUSER.SAMPLE.OBJ (step LINKSAM1), produced by JCL/ALLOCATE.jcl step DELETE.
 *  Dataset flow: reads IBMUSER.SAMPLE.OBJ (step LINKSAM2), produced by JCL/ALLOCATE.jcl step ALLOCAT.
 *  Dataset flow: reads IBMUSER.SAMPLE.OBJ (step LINKSAM2), produced by JCL/ALLOCATE.jcl step DELETE.
 *  Dataset flow: reads IBMUSER.SAMPLE.TRANFILE (step SAM1), produced by JCL/ALLOCATE.jcl step ALLOCAT.
 *  Dataset flow: reads IBMUSER.SAMPLE.TRANFILE (step SAM1), produced by JCL/ALLOCATE.jcl step DELETE.
 *  JCL job flow field testing: open (5 public / 0 private estates). */
@Configuration
public class ZderunJobConfig {

    static final List<Dd> DDS_CMPLSAM2 = List.of(new Dd("STEPLIB", "IGY.V6R5M0.SIGYCOMP", "SHR", null, null), new Dd("SYSIN", "IBMUSER.SAMPLE.COBOL(SAM2)", "SHR", null, null), new Dd("SYSLIB", "IBMUSER.SAMPLE.COPY", "SHR", null, null), new Dd("SYSLIN", "IBMUSER.SAMPLE.OBJ(SAM2)", "OLD", null, null));
    static final List<Dd> DDS_CMPLSAM1 = List.of(new Dd("STEPLIB", "IGY.V6R5M0.SIGYCOMP", "SHR", null, null), new Dd("SYSIN", "IBMUSER.SAMPLE.COBOL(SAM1)", "SHR", null, null), new Dd("SYSLIB", "IBMUSER.SAMPLE.COPY", "SHR", null, null), new Dd("MYFILE", "IBMUSER.SAMPLE.COPYLIB", "SHR", null, null), new Dd("MYLIB", "IBMUSER.SAMPLE.COPYLIB", "SHR", null, null), new Dd("SYSLIN", "IBMUSER.SAMPLE.OBJ(SAM1)", "OLD", null, null));
    static final List<Dd> DDS_LINKSAM2 = List.of(new Dd("SYSLMOD", "IBMUSER.SAMPLE.LOAD", "SHR", null, null), new Dd("SYSLIB", "CEE.SCEELKED", "SHR", null, null), new Dd("OBJ", "IBMUSER.SAMPLE.OBJ", "SHR", null, null));
    static final List<Dd> DDS_LINKSAM1 = List.of(new Dd("SYSLMOD", "IBMUSER.SAMPLE.LOAD", "SHR", null, null), new Dd("SYSLIB", "CEE.SCEELKED", "SHR", null, null), new Dd("SYSLIB", "IBMUSER.SAMPLE.LOAD", "SHR", null, null), new Dd("OBJ", "IBMUSER.SAMPLE.OBJ", "SHR", null, null));
    static final List<Dd> DDS_DELETE = List.of(new Dd("DD1", "IBMUSER.SAMPLE.CUSTRPT", "MOD", "DELETE", null), new Dd("DD2", "IBMUSER.SAMPLE.CUSTOUT", "MOD", "DELETE", null));
    static final List<Dd> DDS_SAM1 = List.of(new Dd("STEPLIB", "IBMUSER.SAMPLE.LOAD", "SHR", null, null), new Dd("CUSTFILE", "IBMUSER.SAMPLE.CUSTFILE", "SHR", null, null), new Dd("TRANFILE", "IBMUSER.SAMPLE.TRANFILE", "SHR", null, null), new Dd("CUSTOUT", "IBMUSER.SAMPLE.CUSTOUT", "NEW", "CATLG", null), new Dd("CUSTRPT", "IBMUSER.SAMPLE.CUSTRPT", "NEW", "CATLG", null));

    @Bean
    public Job zderunJob(JobRepository jobRepository, PlatformTransactionManager tx, JclSteps steps, CobolSam1Service cobolSam1Service) {
        return new JobBuilder("ZDERUN", jobRepository)
                .start(new StepBuilder("CMPLSAM2", jobRepository)
                        .tasklet(steps.utility("CMPLSAM2", "CMPLSAM2", null, null, null, "IGYCRCTL", "CMPLSAM2 runs the utility IGYCRCTL (its control statements are in SYSIN) -- a utility step to port"), tx).build())
                .next(new StepBuilder("CMPLSAM1", jobRepository)
                        .tasklet(steps.utility("CMPLSAM1", "CMPLSAM1", null, null, null, "IGYCRCTL", "CMPLSAM1 runs the utility IGYCRCTL (its control statements are in SYSIN) -- a utility step to port"), tx).build())
                .next(new StepBuilder("LINKSAM2", jobRepository)
                        .tasklet(steps.utility("LINKSAM2", "LINKSAM2", null, null, null, "IEWL", "LINKSAM2 runs the utility IEWL (its control statements are in SYSIN) -- a utility step to port"), tx).build())
                .next(new StepBuilder("LINKSAM1", jobRepository)
                        .tasklet(steps.utility("LINKSAM1", "LINKSAM1", null, null, null, "IEWL", "LINKSAM1 runs the utility IEWL (its control statements are in SYSIN) -- a utility step to port"), tx).build())
                .next(new StepBuilder("DELETE", jobRepository)
                        .tasklet(steps.iefbr14("DELETE", "DELETE", null, null, null, DDS_DELETE), tx).build())
                .next(new StepBuilder("SAM1", jobRepository)
                        .tasklet(steps.program("SAM1", "SAM1", null, null, null, () -> cobolSam1Service.runBatch(DDS_SAM1, null)), tx).build())
                .build();
    }
}
