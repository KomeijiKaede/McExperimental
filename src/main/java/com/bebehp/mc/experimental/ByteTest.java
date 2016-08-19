package com.bebehp.mc.experimental;

import org.apache.logging.log4j.Logger;

public class ByteTest {

	private final String key;
	private final byte[] byteKey;

	public ByteTest(final Logger logger) {
		this.key = "TZ89zhDtYOMka05f8rWCgNq1l9QfbdpOOa4WSnLjRuLhKXKioKBkBVZ8If4dYv3TH1HlhTE9uzGoC";
		this.byteKey = this.key.getBytes();
		logger.info(new String(this.byteKey, 0, 26));
		logger.info(new String(this.byteKey, 26, 51));
	}
}
