package com.codegym.basic.service;

import com.codegym.basic.model.GroupEmployee;

public interface GroupEmployeeService {

    Iterable<GroupEmployee> findAll();

    GroupEmployee findById(Long id);


}
