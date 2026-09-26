package com.gitgalaxy.modernized.batch;

import java.util.List;
import java.util.Map;
import org.springframework.batch.core.JobExecution;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/** The generated JCL jobs (#3622): list them, and run one by its JCL name. */
@RestController
@RequestMapping("/api/v1/batch/jobs")
public class BatchJobController {

    private final JclJobLauncher launcher;

    public BatchJobController(JclJobLauncher launcher) {
        this.launcher = launcher;
    }

    @GetMapping
    public List<String> jobs() {
        return launcher.names();
    }

    @PostMapping("/{name}")
    public Map<String, Object> run(@PathVariable String name) {
        JobExecution run = launcher.launch(name);
        return Map.of("job", name, "id", run.getId(), "status", run.getStatus().toString(),
                "exit", run.getExitStatus().getExitCode());
    }
}
