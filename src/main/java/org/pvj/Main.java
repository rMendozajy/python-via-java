package org.pvj;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

import org.python.core.PySystemState;
import org.python.util.PythonInterpreter;

/**
 * Path to python script file should be passed in first argument
 */
public class Main {
	
	public static void main(String[] args) throws IOException {
		PySystemState.initialize(PySystemState.getBaseProperties(),
				new Properties(), args);
		PythonInterpreter p = new PythonInterpreter();
		if (args == null || args.length < 1) {
			System.out.println("Please pass path to validate.py as first argument.");
			return;
		}
		File f = new File(args[0]);
		System.out.printf("Full path to python script: %s%n", f.getCanonicalPath());
		if (!f.exists()) {
			System.out.println("Can't open the file.");
			return;
		}
		if (!f.canRead()) {
			System.out.println("Can't read from the file.");
			return;
		}
		System.out.println("Script execution with jython started...");
		p.execfile(f.getCanonicalPath());
	}
}
