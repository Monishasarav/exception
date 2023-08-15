package com.myapp.StudentDetails;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class StudentDao {

	@Autowired
	StudentRepository repo;

	public String post(List<Student> a) {
		repo.saveAll(a);
		return "updated";
	}

	public List<Student> findlist() {
		return repo.findAll();

	}

	public String update(List<Student> a) {
		repo.saveAll(a);
		return "changed";
	}

	public String delete(int id) {
		repo.deleteById(id);
		return "deleted";
	}

}
