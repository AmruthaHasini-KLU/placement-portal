package com.placementportal.controller;
import com.placementportal.dto.Dtos.*; import com.placementportal.service.CompanyService; import jakarta.validation.Valid; import org.springframework.data.domain.*; import org.springframework.web.bind.annotation.*;
@RestController @RequestMapping("/api/companies")
public class CompanyController {
 private final CompanyService service; public CompanyController(CompanyService s){service=s;}
 @GetMapping public Page<CompanyResponse> list(@RequestParam(required=false) String search,Pageable pageable){return service.list(search,pageable);}
 @GetMapping("/{id}") public CompanyResponse get(@PathVariable Long id){return service.get(id);}
 @PostMapping public CompanyResponse create(@Valid @RequestBody CompanyRequest r){return service.create(r);}
 @PutMapping("/{id}") public CompanyResponse update(@PathVariable Long id,@Valid @RequestBody CompanyRequest r){return service.update(id,r);}
 @DeleteMapping("/{id}") public void delete(@PathVariable Long id){service.delete(id);}
}
