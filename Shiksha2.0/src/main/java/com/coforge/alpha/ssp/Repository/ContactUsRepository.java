package com.coforge.alpha.ssp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.coforge.alpha.ssp.model.ContactUs;

@Repository
public interface ContactUsRepository extends JpaRepository<ContactUs, Long>{

}
