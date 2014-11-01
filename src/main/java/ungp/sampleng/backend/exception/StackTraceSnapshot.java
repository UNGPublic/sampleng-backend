package ungp.sampleng.backend.exception;

import java.io.BufferedReader;
import java.io.StringReader;

public class StackTraceSnapshot {

	public static String snapshot(Throwable t) {
		String stacktrace = ExceptionUtil.getStackTraceAsString(t);
		
		stacktrace = lines(4, stacktrace);
		
		return replaceInvalidCharacters(stacktrace);
	}
	
	private static String replaceInvalidCharacters(String stacktrace) {
		return stacktrace.replaceAll(":", "").replaceAll("\n", "").replaceAll("\r", "");
	}
	
	private static String lines(int numberOfLines, String stackeTrace) {
		StringBuilder sb = new StringBuilder();
		try {
			BufferedReader reader = new BufferedReader( new StringReader(stackeTrace) );
			for (int i = 0; i < numberOfLines; i++) {
				sb.append( reader.readLine() ).append("...");
			}
		} catch(Exception e) {
			throw new RuntimeException("Erro ao dar o parse no stack trace.", e);
		}
		
		return sb.toString();
	}
	
}
