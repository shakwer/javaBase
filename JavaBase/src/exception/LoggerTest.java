package exception;

import java.util.logging.LogManager;
import java.util.logging.Logger;

public class LoggerTest {
	public static void main(String[] args) {
		Logger.getGlobal().info("test logger");
		LogManager.getLogManager();
	}
}
