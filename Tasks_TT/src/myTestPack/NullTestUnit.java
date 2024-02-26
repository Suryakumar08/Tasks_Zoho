package myTestPack;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import exception.CustomException;
import tasks.StringTask;

public class NullTestUnit {

	@Test
	public void test() throws CustomException {
		StringTask obj = new StringTask();
		assertEquals("qwerty", obj.reverseTheString(null));
	}

}
