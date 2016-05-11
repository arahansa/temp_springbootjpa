package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.domain.TestDomain;

public interface TestDomainRepository extends JpaRepository<TestDomain, Long>{

}
