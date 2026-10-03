package com.placementportal.service;
import com.placementportal.dto.Dtos.*; import com.placementportal.exception.ApiException; import com.placementportal.model.*; import com.placementportal.repository.*;
import org.springframework.data.domain.*; import org.springframework.http.HttpStatus; import org.springframework.stereotype.Service; import java.util.*;
import org.springframework.transaction.annotation.Transactional;
@Service @Transactional public class ApplicationService {
 private final ApplicationRepository repo; private final StudentService students; private final JobService jobs;
 public ApplicationService(ApplicationRepository r,StudentService s,JobService j){repo=r;students=s;jobs=j;}
 public Page<ApplicationResponse> list(Long studentId,Long jobId,ApplicationStatus status,Pageable p){return repo.findAll((root,q,cb)->{var x=cb.conjunction();if(studentId!=null)x=cb.and(x,cb.equal(root.get("student").get("studentId"),studentId));if(jobId!=null)x=cb.and(x,cb.equal(root.get("job").get("jobId"),jobId));if(status!=null)x=cb.and(x,cb.equal(root.get("currentStatus"),status));return x;},p).map(ApplicationResponse::of);}
 public List<ApplicationResponse> byStudent(Long id){students.get(id);return repo.findByStudentStudentIdOrderByApplicationDateDesc(id).stream().map(ApplicationResponse::of).toList();}
 public ApplicationResponse create(ApplicationRequest r){students.get(r.studentId());Job j=jobs.find(r.jobId());if(repo.existsByStudentStudentIdAndJobJobId(r.studentId(),r.jobId()))throw new ApiException(HttpStatus.CONFLICT,"Student has already applied to this job");Application a=new Application();a.setStudent(studentsEntity(r.studentId()));a.setJob(j);return ApplicationResponse.of(repo.save(a));}
 public ApplicationResponse status(Long id,ApplicationStatusRequest r){Application a=find(id);a.setStatus(r.status());return ApplicationResponse.of(repo.save(a));}
 public void delete(Long id){repo.delete(find(id));}
 public long count(){return repo.count();} public long count(ApplicationStatus s){return repo.countByCurrentStatus(s);}
 private Application find(Long id){return repo.findById(id).orElseThrow(()->new ApiException(HttpStatus.NOT_FOUND,"Application not found"));}
 private Student studentsEntity(Long id){return students.getEntity(id);}
}
