package com.placementportal.service;
import com.placementportal.dto.Dtos.*;
import com.placementportal.exception.ApiException;
import com.placementportal.model.Student;
import com.placementportal.repository.StudentRepository;
import org.springframework.data.domain.*;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import java.util.*;
import java.util.stream.*;
import java.math.BigDecimal;
@Service
public class StudentService {
    private final StudentRepository repo;
    public StudentService(StudentRepository repo){this.repo=repo;}
    public Page<StudentResponse> list(String search, Pageable pageable){ return repo.findAll((root,q,cb)->{ if(search==null||search.isBlank()) return cb.conjunction(); String p="%"+search.toLowerCase()+"%"; return cb.or(cb.like(cb.lower(root.get("name")),p),cb.like(cb.lower(root.get("email")),p),cb.like(cb.lower(root.get("branch")),p));},pageable).map(StudentResponse::of); }
    public StudentResponse get(Long id){return StudentResponse.of(find(id));}
    public StudentResponse create(StudentRequest r){ if(repo.existsByEmailIgnoreCase(r.email())) throw new ApiException(HttpStatus.CONFLICT,"Student email already exists"); Student s=new Student(); apply(s,r); return StudentResponse.of(repo.save(s));}
    public StudentResponse update(Long id, StudentRequest r){Student s=find(id); if(!s.getEmail().equalsIgnoreCase(r.email())&&repo.existsByEmailIgnoreCase(r.email())) throw new ApiException(HttpStatus.CONFLICT,"Student email already exists"); apply(s,r); return StudentResponse.of(repo.save(s));}
    public void delete(Long id){repo.delete(find(id));}
    public long count(){return repo.count();}
    public Student getEntity(Long id){return find(id);}
    private Student find(Long id){return repo.findById(id).orElseThrow(()->new ApiException(HttpStatus.NOT_FOUND,"Student not found"));}
    private void apply(Student s,StudentRequest r){s.setName(r.name());s.setEmail(r.email());s.setBranch(r.course());s.setGraduationYear(r.graduationYear());s.setCgpa(r.cgpa() == null ? null : BigDecimal.valueOf(r.cgpa()));}
}
