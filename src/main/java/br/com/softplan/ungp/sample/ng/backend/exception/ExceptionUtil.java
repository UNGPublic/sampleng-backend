package br.com.softplan.ungp.sample.ng.backend.exception;

import java.io.PrintWriter;
import java.io.StringWriter;

public class ExceptionUtil {
    public static String getStackTraceAsString(Throwable e) {
        StringWriter sw = new StringWriter();
        e.printStackTrace(new PrintWriter(sw));
        return sw.toString();
    }
}
