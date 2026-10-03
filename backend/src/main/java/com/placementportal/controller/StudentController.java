package com.placementportal.controller;
import com.placementportal.dto.Dtos.*; import com.placementportal.service.StudentService; import jakarta.validation.Valid; import org.springframework.data.domain.*; import org.springframework.web.bind.annotation.*;
@RestController @RequestMapping("/api/students")
public class StudentController {
 private final StudentService service; public StudentController(StudentService s){service=s;}
 @GetMapping public Page<StudentResponse> list(@RequestParam(required=false) String search,Pageable pageable){return service.list(search,pageable);}
 @GetMapping("/{id}") public StudentResponse get(@PathVariable Long id){return service.get(id);}
 @PostMapping public StudentResponse create(@Valid @RequestBody StudentRequest r){return service.create(r);}
 @PutMapping("/{id}") public StudentResponse update(@PathVariable Long id,@Valid @RequestBody StudentRequest r){return service.update(id,r);}
 @DeleteMapping("/{id}") public void delete(@PathVariable Long id){service.delete(id);}
}
