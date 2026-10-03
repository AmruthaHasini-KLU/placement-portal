package com.placementportal.controller;
import com.placementportal.dto.Dtos.*; 
import com.placementportal.model.ApplicationStatus; 
import com.placementportal.service.ApplicationService; 
import jakarta.validation.Valid; 
import org.springframework.data.domain.*; 
import org.springframework.web.bind.annotation.*; 
import java.util.*;

@RestController @RequestMapping("/api/applications")
public class ApplicationController
{
 private final ApplicationService service; 
 public ApplicationController(ApplicationService s)
 {
    service=s;
}
 @GetMapping
public Page<ApplicationResponse> list(@RequestParam(required=false) Long studentId,@RequestParam(required=false) Long jobId,@RequestParam(required=false) ApplicationStatus status,Pageable pageable)
{
    return service.list(studentId,jobId,status,pageable);
}
 @GetMapping("/student/{studentId}") public List<ApplicationResponse> byStudent(@PathVariable Long studentId)
 {
    return service.byStudent(studentId);
 }
 @PostMapping public ApplicationResponse create(@Valid @RequestBody ApplicationRequest r)
 {
    return service.create(r);
 }
 @PatchMapping("/{id}/status") public ApplicationResponse status(@PathVariable Long id,@Valid @RequestBody ApplicationStatusRequest r)
 {
    return service.status(id,r);
 }
 @DeleteMapping("/{id}") public void delete(@PathVariable Long id)
 {
    service.delete(id);
 }
}
