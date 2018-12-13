package com.pass.cloud.activity.apps.repository;

import com.pass.cloud.activity.apps.domain.Applicant;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author takesi
 */
@Repository
public interface ApplicantRepository extends JpaRepository<Applicant, Long> {

}
