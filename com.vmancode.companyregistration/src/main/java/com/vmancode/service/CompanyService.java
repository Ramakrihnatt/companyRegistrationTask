package com.vmancode.service;

import java.util.List;
import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.vmancode.entity.Company;
import com.vmancode.entity.Hr;
import com.vmancode.repo.CompanyRepository;

@Service
public class CompanyService {

    private final CompanyRepository companyRepository;

    public CompanyService(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    public Company saveCompany(Company company) {
        return companyRepository.save(company);
    }

    public List<Company> getAllCompanies() {
        List<Company> companies = companyRepository.findAll();
        // sanitize null fields
        for (Company c : companies) {
            if (c.getName() == null) c.setName("N/A");
            if (c.getAddresses() == null) c.setAddresses(new ArrayList<>());
            if (c.getHr() == null) c.setHr(new Hr());
        }
        return companies;
    }

    public void deleteCompany(Long id) {
        companyRepository.deleteById(id);
    }

    public Company updateCompany(Long id, Company company) {
        Company existing = companyRepository.findById(id)
                              .orElseThrow(() -> new RuntimeException("Company not found"));
        existing.setName(company.getName());
        existing.setRegistrationNo(company.getRegistrationNo());
        existing.setHr(company.getHr());
        existing.setAddresses(company.getAddresses());
        return companyRepository.save(existing);
    }
}
