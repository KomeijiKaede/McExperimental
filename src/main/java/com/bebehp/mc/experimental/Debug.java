package com.bebehp.mc.experimental;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.bebehp.mc.experimental.bytes.ByteOutputTest;

public class Debug {

	public static void main(final String[] args) {
		final Logger logger = LogManager.getLogger("Debug");
		// new ModifierExceptionTest().test();
		//		new Iteaaaaarator().test1(logger);
		//		new Base64Test(logger);
		//		new ByteTest(logger);
		new ByteOutputTest(logger);
	}

}
