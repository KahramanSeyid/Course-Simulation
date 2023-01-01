package CourseSimulation;

import CourseSimulation.business.CatagoryManager;
import CourseSimulation.business.CourseManager;
import CourseSimulation.business.UserManager;
import CourseSimulation.core.logging.FileLogger;
import CourseSimulation.core.logging.ILogger;
import CourseSimulation.core.logging.MailLogger;
import CourseSimulation.core.logging.SmsLogger;
import CourseSimulation.dataAccess.Hibernate;
import CourseSimulation.dataAccess.Jdbc;
import CourseSimulation.entities.Catagory;
import CourseSimulation.entities.Course;
import CourseSimulation.entities.Instructor;
import CourseSimulation.entities.Student;

public class Main {
	public static void main(String[] args) {

		CourseManager courseManager = new CourseManager(new Hibernate());
		ILogger[] loggers = {new FileLogger(),new MailLogger(),new SmsLogger()};

		Course course1 = new Course();
		course1.setName("Java 2022");
		course1.setPrice(50);
		
		Course course2 = new Course();
		course2.setName("Java 2022");    
		course2.setPrice(50);
		
		Course course3 = new Course();
		course3.setName("C 2008");
		course3.setPrice(50);
		
		Instructor instructor = new Instructor();
		instructor.setName("Engin Demiroğ");
		instructor.createCourse(courseManager,course1);
		instructor.createCourse(courseManager,course2);
		
		instructor.deleteCourse(courseManager, course1);
		instructor.deleteCourse(courseManager, course3);
		
		courseManager.log(loggers, course3);
		
		Student student = new Student();
		student.setName("Seyid Muhammed Kahraman");
		UserManager userManager = new UserManager(new Jdbc());
		userManager.save(student);
		userManager.log(loggers, student);
		
		Catagory catagory = new Catagory();
		catagory.setName("Backend");
		
		CatagoryManager catagoryManager = new CatagoryManager(new Hibernate());
		catagoryManager.save(catagory);
		catagoryManager.save(catagory);// aynı isimle başka bir katagori olduğu için eklemeyecek.
		catagoryManager.delete(catagory);
		catagoryManager.save(catagory);// az önce silinebildiği için yeniden kaydedilebilir/eklenebilir.
		

	}


}
