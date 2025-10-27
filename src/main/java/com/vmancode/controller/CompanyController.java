package com.vmancode.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.vmancode.entity.Company;
import com.vmancode.service.CompanyService;

@RestController
@RequestMapping("/api/companies")
public class CompanyController {

    private final CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    // ✅ Register a new company
    @PostMapping("/register")
    public Company registerCompany(@RequestBody Company company) {
        return companyService.saveCompany(company);
    }

    // ✅ Get all companies
    @GetMapping
    public List<Company> getAllCompanies() {
        return companyService.getAllCompanies();
    }

    // ✅ Delete a company by ID
    @DeleteMapping("/{id}")
    public void deleteCompany(@PathVariable Long id) {
        companyService.deleteCompany(id);
    }

    // ✅ Update a company by ID
    @PutMapping("/{id}")
    public Company updateCompany(@PathVariable Long id, @RequestBody Company company) {
        return companyService.updateCompany(id, company);
    }
}
