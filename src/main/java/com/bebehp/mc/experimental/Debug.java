package com.bebehp.mc.experimental;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Debug {

	public static void main(final String[] args) {
		final Logger logger = LogManager.getLogger("Debug");
		// new ModifierExceptionTest().test();
		//		new Iteaaaaarator().test1(logger);
		new Base64Test(logger);
	}

}
