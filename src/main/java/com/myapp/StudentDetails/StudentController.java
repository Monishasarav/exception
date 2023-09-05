package com.myapp.StudentDetails;

import java.util.List;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
//import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/student")
public class StudentController {
	static Logger log = Logger.getLogger(StudentController.class);

	@Autowired
	StudentService ser;

	@PostMapping(value = "/postvalues")
	public String post(@RequestBody List<Student> a) {
		return ser.post(a);
	}

	@GetMapping(value = "/readvalues/{age}")
	public List<Student> read(@PathVariable int age)throws AgeException {
		System.out.println(age);
		PropertyConfigurator.configure("log.properties");
		log.info("info is invalid");
		log.warn("warning");
		log.error("error found");
		log.fatal("error found");
		log.debug("run again");

		return ser.read(age);
	}

	@PutMapping(value = "/updatevalues")
	public String update(@RequestBody List<Student> a) {
		return ser.update(a);
	}

	@DeleteMapping(value = "/delvalues/{id}")
	public String delete(@PathVariable int id) {
		return ser.delete(id);
	}

}
