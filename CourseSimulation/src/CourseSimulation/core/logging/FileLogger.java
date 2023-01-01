package CourseSimulation.core.logging;

public class FileLogger implements ILogger {

	public void log(String message) {
		System.out.println("Dosyaya loglandı: "+message);
		
	}

}
