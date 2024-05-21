package com.mimi.cruddemo;

import com.mimi.cruddemo.dao.AppDao;
import com.mimi.cruddemo.entity.Instructor;
import com.mimi.cruddemo.entity.InstuctorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}


	@Bean
	public CommandLineRunner commandLineRunner(AppDao appDao) {
		return args -> {
//			createInstructor(appDao);
//			findInstructor(appDao);
//			deleteInstructor(appDao);
//			findInstructorDetailById(appDao);
			deleteInstructorDetailById(appDao);



		};

	}

	private void deleteInstructorDetailById(AppDao appDao) {
		int theId=3;
		System.out.println("/***************************/");
		System.out.println("Deleting the Instructor detail and its associated Instructor... ");
		System.out.println("/***************************/");
		appDao.deleteInstructorDetailById(theId);
		System.out.println("/***************************/");
		System.out.println("Done");
		System.out.println("/***************************/");
	}

	private void findInstructorDetailById(AppDao appDao) {
		int theId=2 ;
		System.out.println("Finding the instructorDetail by id: "+theId + " ...");
		InstuctorDetail temInstructorDetail = appDao.findInstructorDetailById(theId);
		System.out.println("/***************************/");
		System.out.println("The InstructorDetail is : "+temInstructorDetail);
		System.out.println("/***************************/");
		System.out.println("the associated instructor is : "+temInstructorDetail.getInstructor());
		System.out.println("/***************************/");

	}

	private void deleteInstructor(AppDao appDao) {
		int theId=1 ;
		System.out.println("/***************************/");
		System.out.println("Deleting instructor id: "+theId);
		System.out.println("/***************************/");
		appDao.deleteInstructorById(theId);
		System.out.println("Done");
		System.out.println("/***************************/");
	}

	private void findInstructor(AppDao appDao) {
		int theId =2 ;
		System.out.println("Finding the instructor by id: "+theId + " ...");
		Instructor tempInstructor = appDao.findInstructorById(theId);
		System.out.println("/***************************/");
		System.out.println(tempInstructor);
		System.out.println("/***************************/");
		System.out.println("The associated instructor  detail  only is : "+tempInstructor.getInstuctorDetail());
		System.out.println("/***************************/");



	}

	private void createInstructor(AppDao appDao) {
		// create the instructor
		Instructor tempInstructor = new Instructor("Chad","Darby","darby@gmail.com");
		// create the instructor detail
		InstuctorDetail tempInstructorDetail = new InstuctorDetail("youtube.com","loveToCode");
		// associate the object
		tempInstructor.setInstuctorDetail(tempInstructorDetail);
		// save the instructor , and so the instructor detail will be saved
		System.out.println("/***************************/");
		System.out.println("SAVING THE INSTRUCTOR....");
		System.out.println("/***************************/");
		appDao.save(tempInstructor);
		System.out.println("INSTRUCTOR SAVED....");
		System.out.println("/***************************/");
		// create the instructor
//		Instructor tempInstructor = new Instructor("Susan","Lopez","Lopez@gmail.com");
//		// create the instructor detail
//		InstuctorDetail tempInstructorDetail = new InstuctorDetail("youtube1.com","loveToDance");
//		// associate the object
//		tempInstructor.setInstuctorDetail(tempInstructorDetail);
//		// save the instructor , and so the instructor detail will be saved
//		System.out.println("/***************************/");
//		System.out.println("SAVING THE INSTRUCTOR....");
//		System.out.println("/***************************/");
//		appDao.save(tempInstructor);
//		System.out.println("INSTRUCTOR SAVED....");
//		System.out.println("/***************************/");
	}
}
