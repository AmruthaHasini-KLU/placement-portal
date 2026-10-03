package com.placementportal.service;
import com.placementportal.dto.Dtos.*;
import com.placementportal.exception.ApiException;
import com.placementportal.model.Company;
import com.placementportal.repository.CompanyRepository;
import org.springframework.data.domain.*;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
@Service
public class CompanyService {
 private final CompanyRepository repo; public CompanyService(CompanyRepository repo){this.repo=repo;}
 public Page<CompanyResponse> list(String search,Pageable p){return repo.findAll((root,q,cb)->search==null||search.isBlank()?cb.conjunction():cb.or(cb.like(cb.lower(root.get("companyName")),"%"+search.toLowerCase()+"%"),cb.like(cb.lower(root.get("industry")),"%"+search.toLowerCase()+"%"),cb.like(cb.lower(root.get("headquarters")),"%"+search.toLowerCase()+"%")),p).map(CompanyResponse::of);}
 public CompanyResponse get(Long id){return CompanyResponse.of(find(id));}
 public CompanyResponse create(CompanyRequest r){Company c=new Company();apply(c,r);return CompanyResponse.of(repo.save(c));}
 public CompanyResponse update(Long id,CompanyRequest r){Company c=find(id);apply(c,r);return CompanyResponse.of(repo.save(c));}
 public void delete(Long id){repo.delete(find(id));} public long count(){return repo.count();}
 public Company find(Long id){return repo.findById(id).orElseThrow(()->new ApiException(HttpStatus.NOT_FOUND,"Company not found"));}
 private void apply(Company c,CompanyRequest r){c.setCompanyName(r.name());c.setIndustry(r.industry() == null ? "Unknown" : r.industry());c.setHeadquarters(r.location() == null ? "Unknown" : r.location());}
}
