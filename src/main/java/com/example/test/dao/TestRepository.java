package com.example.test.dao;

import com.example.test.model.TestBean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface TestRepository extends JpaRepository<TestBean, Integer> {
}
