package CourseSimulation.dataAccess;

import CourseSimulation.entities.Catagory;
import CourseSimulation.entities.Course;
import CourseSimulation.entities.User;

public interface IDao {
	void saveUser(User user);
	void saveCourse(Course course);
	void saveCatagory(Catagory catagory);
	void deleteUser(User user);
	void deleteCourse(Course course);
	void deleteCatagory(Catagory catagory);
}
