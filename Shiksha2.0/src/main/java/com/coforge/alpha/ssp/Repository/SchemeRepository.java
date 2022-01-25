package com.coforge.alpha.ssp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.coforge.alpha.ssp.model.Schemes;

@Repository
public interface SchemeRepository extends JpaRepository<Schemes, Long> {

	@Query(value="SELECT amount From schemes WHERE s_code=:scode",nativeQuery = true)
	public double findByScode(@Param("scode") String scode);
}
