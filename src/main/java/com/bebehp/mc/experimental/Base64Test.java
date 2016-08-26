package com.bebehp.mc.experimental;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.compress.utils.IOUtils;
import org.apache.logging.log4j.Logger;

public class Base64Test {

	private final String[] keyArray;
	private final File file;
	private TweetQuakeKey tweetQuakeKey;

	public Base64Test(final Logger logger) {
		this.keyArray = new String[] {"hidden", "hidden"};
		this.file = new File(System.getProperty("user.dir"), "test.eew");
		try {
			this.file.createNewFile();
		} catch (final IOException e) {
			logger.error(e);
		}

		ObjectOutputStream outputStream = null;
		try {
			outputStream = new ObjectOutputStream(new FileOutputStream(this.file));
			final TweetQuakeKey tweetQuakeKey = new TweetQuakeKey(getEncodeText(this.keyArray[0]), getEncodeText(this.keyArray[1]));
			outputStream.writeObject(tweetQuakeKey);
		} catch (final FileNotFoundException e) {
			logger.error(e);
		} catch (final IOException e) {
			logger.error(e);
		} finally {
			IOUtils.closeQuietly(outputStream);
		}

		ObjectInputStream inputStream = null;
		try {
			inputStream = new ObjectInputStream(new FileInputStream(this.file));
			this.tweetQuakeKey = (TweetQuakeKey)inputStream.readObject();
		} catch (final IOException e) {
			logger.error(e);
		} catch (final ClassNotFoundException e) {
			logger.error(e);
		} finally {
			IOUtils.closeQuietly(inputStream);
		}

		logger.info(getDecodeText(this.tweetQuakeKey.getKey1()));
		logger.info(getDecodeText(this.tweetQuakeKey.getKey2()));

	}

	public String getEncodeText(final String text) {
		final byte[] encodeByte = Base64.encodeBase64(text.getBytes());
		return new String(encodeByte);
	}

	public String getDecodeText(final String text) {
		final byte[] decodeByte = Base64.decodeBase64(text);
		return new String(decodeByte);
	}
}
