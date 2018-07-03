package com.codegym.basic.repository;

import com.codegym.basic.model.GroupEmployee;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupEmployeeRepository extends PagingAndSortingRepository<GroupEmployee, Long> {
}
