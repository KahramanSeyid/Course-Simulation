package CourseSimulation.business;

import CourseSimulation.core.logging.ILogger;
import CourseSimulation.dataAccess.IDao;
import CourseSimulation.entities.User;

public class UserManager {
	private IDao dao;

	public UserManager(IDao dao) {
		this.dao = dao;
	}
	
	public void save(User user) {
		System.out.println(user.getPosition()+" "+user.getName()+" eklendi.");
		dao.saveUser(user);
	}

	public void delete(User user) {
		System.out.println(user.getPosition()+" "+user.getName()+" silindi.");
		dao.deleteUser(user);
	}
	
	public void log(ILogger[] loggers, User user) {
		for (ILogger logger : loggers) {
			logger.log(user.getName());
		}
	}
}
