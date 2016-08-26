package com.bebehp.mc.experimental;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.IOUtils;
import org.apache.logging.log4j.Logger;

public class ByteOutputTest {

	private final File file;

	public ByteOutputTest(final Logger logger) {
		this.file = new File(System.getProperty("user.dir"), "file.eew");

		final byte[] key2 = null;
		final byte[] key1 = null;
		TweetQuakeKey tweetQuakeKey = null;
		tweetQuakeKey = new TweetQuakeKey("hidden", "hidden");

		try {
			this.file.createNewFile();
		} catch (final IOException e) {
			logger.error(e);
		}

		final ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ObjectOutputStream oos = null;
		BufferedOutputStream bos = null;
		try {
			oos = new ObjectOutputStream(baos);
			oos.writeObject(tweetQuakeKey);
			final byte [] inByte = Base64.encodeBase64(baos.toByteArray());

			bos = new BufferedOutputStream(new FileOutputStream(this.file));
			bos.write(inByte);
			logger.info("phase1");
		} catch (final IOException e) {
			e.printStackTrace();
		} finally {
			IOUtils.closeQuietly(baos);
			IOUtils.closeQuietly(oos);
			IOUtils.closeQuietly(bos);
		}

		BufferedInputStream bis = null;
		ByteArrayInputStream bais = null;
		ObjectInputStream ois = null;
		try {
			bis = new BufferedInputStream(new FileInputStream(this.file));
			final byte[] outByte = new byte[bis.available()];
			bis.read(outByte);

			bais = new ByteArrayInputStream(Base64.decodeBase64(outByte));
			ois = new ObjectInputStream(bais);
			final TweetQuakeKey tqk = (TweetQuakeKey)ois.readObject();
			logger.info(tqk.getKey1());
			logger.info(tqk.getKey2());
		} catch (final FileNotFoundException e) {
			e.printStackTrace();
		} catch (final IOException e) {
			e.printStackTrace();
		} catch (final ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			IOUtils.closeQuietly(bis);
			IOUtils.closeQuietly(bais);
			IOUtils.closeQuietly(ois);
		}

	}
}
