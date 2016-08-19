package com.bebehp.mc.experimental;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.Logger;

public class Base64Test {

	private final String key1;
	private final String key2;
	private final String[] keyArray;

	public Base64Test(final Logger logger) {
		this.key1 = RandomStringUtils.randomAlphanumeric(26);
		this.key2 = RandomStringUtils.randomAlphanumeric(51);
		this.keyArray = new String[] {this.key1, this.key2};

		byte[] encodeByte;
		String encodeKey;
		byte[] decodeByte;
		String decodeKey;

		for (final String line : this.keyArray) {
			logger.info("Raw keys: {}", line);
			encodeByte = Base64.encodeBase64(line.getBytes());
			encodeKey = new String(encodeByte);
			logger.info("Encode key: {}", encodeKey);
			decodeByte = Base64.decodeBase64(encodeKey);
			decodeKey = new String(decodeByte);
			logger.info("Decode key: {}", decodeKey);
		}
	}
}
