package com.coforge.alpha.ssp.Repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.coforge.alpha.ssp.model.Scholarship;

@Repository
public interface ScholarshipRepository extends CrudRepository<Scholarship, Long> {

	@Transactional
	@Modifying
	@Query(value="UPDATE scholarship SET status=:status WHERE student_id=:studentId",nativeQuery = true)
	public void updateStatusById(@Param("studentId") Long studentId, @Param("status") String status);
	
	@Transactional
	@Modifying
	@Query(value="UPDATE scholarship SET s_code=:scode WHERE student_id=:studentId",nativeQuery = true)
	public void updateScodeById(@Param("studentId") Long studentId, @Param("scode") String scode);
	
}
