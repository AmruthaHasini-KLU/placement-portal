package com.placementportal.repository;
import com.placementportal.model.*;
import org.springframework.data.jpa.repository.*;
import java.util.*;
public interface JobRepository extends JpaRepository<Job, Long>, JpaSpecificationExecutor<Job> {
    List<Job> findByCompanyCompanyId(Long companyId);
}
