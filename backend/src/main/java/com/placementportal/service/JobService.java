package com.placementportal.service;
import com.placementportal.dto.Dtos.*; import com.placementportal.exception.ApiException; import com.placementportal.model.*; import com.placementportal.repository.JobRepository;
import org.springframework.data.domain.*; import org.springframework.http.HttpStatus; import org.springframework.stereotype.Service; import java.math.BigDecimal;
import org.springframework.transaction.annotation.Transactional;
@Service @Transactional public class JobService {
 private final JobRepository repo; private final CompanyService companies; public JobService(JobRepository r,CompanyService c){repo=r;companies=c;}
 public Page<JobResponse> list(String search,Long companyId,JobStatus status,Pageable p){return repo.findAll((root,q,cb)->{var x=cb.conjunction();if(search!=null&&!search.isBlank()){String s="%"+search.toLowerCase()+"%";x=cb.and(x,cb.or(cb.like(cb.lower(root.get("jobTitle")),s),cb.like(cb.lower(root.get("location")),s)));}if(companyId!=null)x=cb.and(x,cb.equal(root.get("company").get("companyId"),companyId));return x;},p).map(JobResponse::of);}
 public JobResponse get(Long id){return JobResponse.of(find(id));}
 public JobResponse create(JobRequest r){Job j=new Job();apply(j,r);return JobResponse.of(repo.save(j));}
 public JobResponse update(Long id,JobRequest r){Job j=find(id);apply(j,r);return JobResponse.of(repo.save(j));}
 public void delete(Long id){repo.delete(find(id));} public long count(){return repo.count();} public long open(){return repo.count();}
 public Job find(Long id){return repo.findById(id).orElseThrow(()->new ApiException(HttpStatus.NOT_FOUND,"Job not found"));}
 private void apply(Job j,JobRequest r){if(r.salaryMin()!=null&&r.salaryMax()!=null&&r.salaryMin()>r.salaryMax())throw new ApiException(HttpStatus.BAD_REQUEST,"Minimum salary cannot exceed maximum salary");j.setJobTitle(r.title());j.setJobType("Internship".equalsIgnoreCase(r.employmentType())?JobType.INTERNSHIP:JobType.FULL_TIME);j.setLocation(r.location() == null ? "Unknown" : r.location());j.setMinPackage(r.salaryMin() == null ? null : BigDecimal.valueOf(r.salaryMin()));j.setMaxPackage(r.salaryMax() == null ? null : BigDecimal.valueOf(r.salaryMax()));j.setRequiredExperience(0);j.setOpenings(1);j.setCompany(companies.find(r.companyId()));}
}
