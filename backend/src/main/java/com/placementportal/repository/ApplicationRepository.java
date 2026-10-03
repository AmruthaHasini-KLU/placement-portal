package com.placementportal.repository;
import com.placementportal.model.*;
import org.springframework.data.jpa.repository.*;
import java.util.*;
public interface ApplicationRepository extends JpaRepository<Application, Long>, JpaSpecificationExecutor<Application> {
    boolean existsByStudentStudentIdAndJobJobId(Long studentId, Long jobId);
    long countByCurrentStatus(ApplicationStatus status);
    long countByJobCompanyCompanyId(Long companyId);
    List<Application> findByStudentStudentIdOrderByApplicationDateDesc(Long studentId);
}
