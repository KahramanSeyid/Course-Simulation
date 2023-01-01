package CourseSimulation.entities;

import CourseSimulation.business.CourseManager;

public interface ICanProduce {
	void createCourse(CourseManager courseManager, Course course);
	void deleteCourse(CourseManager courseManager, Course course);
}