package com.vmancode.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.vmancode.entity.Company;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {}
