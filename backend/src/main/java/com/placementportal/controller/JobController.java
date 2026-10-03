package com.placementportal.controller;
import com.placementportal.dto.Dtos.*; import com.placementportal.model.JobStatus; import com.placementportal.service.JobService; import jakarta.validation.Valid; import org.springframework.data.domain.*; import org.springframework.web.bind.annotation.*;
@RestController @RequestMapping("/api/jobs")
public class JobController {
 private final JobService service; public JobController(JobService s){service=s;}
 @GetMapping public Page<JobResponse> list(@RequestParam(required=false) String search,@RequestParam(required=false) Long companyId,@RequestParam(required=false) JobStatus status,Pageable pageable){return service.list(search,companyId,status,pageable);}
 @GetMapping("/{id}") public JobResponse get(@PathVariable Long id){return service.get(id);}
 @PostMapping public JobResponse create(@Valid @RequestBody JobRequest r){return service.create(r);}
 @PutMapping("/{id}") public JobResponse update(@PathVariable Long id,@Valid @RequestBody JobRequest r){return service.update(id,r);}
 @DeleteMapping("/{id}") public void delete(@PathVariable Long id){service.delete(id);}
}
