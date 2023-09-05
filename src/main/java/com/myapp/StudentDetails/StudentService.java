package com.myapp.StudentDetails;

import java.util.List;
import java.util.stream.Collectors;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
	static Logger log = Logger.getLogger(StudentService.class);

	@Autowired
	StudentDao dao;

	public String post(List<Student> a) {
		return dao.post(a);
	}

	public List<Student> read(int age) throws AgeException {
		List<Student> a = dao.findlist();
		PropertyConfigurator.configure("log.properties");
		log.info("info is invalid");
		log.warn("warning");
		log.error("error found");
		log.fatal("error found");
		log.debug("run again");

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
