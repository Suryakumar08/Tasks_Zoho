package myTestPack;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;

public class JUnitTestRunner {
	public static void main(String...args) {
		Result result = JUnitCore.runClasses(AllTests.class);
		System.out.println(result.toString());
	}
}
