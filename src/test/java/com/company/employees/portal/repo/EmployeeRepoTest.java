package com.company.employees.portal.repo;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.company.employees.portal.entity.EmployeeEntity;
import com.company.employees.portal.repo.EmployeeRepo;

@DataJpaTest
@RunWith(SpringRunner.class)
public class EmployeeRepoTest {

	@Autowired
	private EmployeeRepo employeeRepo;

	@Test
	public void testGetAll() {
		List<EmployeeEntity> entities = employeeRepo.findAll();

	}

}
