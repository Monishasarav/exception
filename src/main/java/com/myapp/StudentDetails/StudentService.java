package com.myapp.StudentDetails;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

	@Autowired
	StudentDao dao;

	public String post(List<Student> a) {
		return dao.post(a);
	}

	public List<Student> read(int age) throws AgeException {
		List<Student> a = dao.findlist();
		List<Student> b = a.stream().filter(x -> x.getAge() == age).collect(Collectors.toList());
		if (b.isEmpty()) {
			throw new AgeException("age not valid");
		} else {

			return b;
		}

	}

	public String update(List<Student> a) {
		return dao.update(a);
	}

	public String delete(int id) {
		return dao.delete(id);
	}
}
