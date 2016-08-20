package com.bebehp.mc.experimental;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.apache.logging.log4j.Logger;

public class Iteaaaaarator {
	public void test1(final Logger logger) {
		//		final String[] strs = new String[] {"bubu","t","me","tell"};
		//		for (final String str: strs) {
		//			logger.info(str);
		//			// System.out.println(str);
		//		}

		final List<String> strs = Arrays.asList(new String[] {"bubu","t","me","tell"});
		for (final Iterator<String> it = strs.iterator(); it.hasNext();) {
			final String str = it.next();
			logger.info(str);
		}
	}
}
