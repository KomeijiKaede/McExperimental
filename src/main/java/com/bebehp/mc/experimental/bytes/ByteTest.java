package com.bebehp.mc.experimental.bytes;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.logging.log4j.Logger;


public class ByteTest {

	private byte[] byteKey;
	private final File file;
	private final byte splitByte;

	public ByteTest(final Logger logger) {
		this.splitByte = 0x2F;
		this.file = new File(System.getProperty("user.dir"), "file.eew");
		byte[] key2 = null;
		byte[] key1 = null;
		try {
			key1 = Base64.encodeBase64("hidden".getBytes("UTF-8"));
			key2 = Base64.encodeBase64("hidden".getBytes("UTF-8"));
		} catch (final UnsupportedEncodingException e1) {
			// TODO 自動生成された catch ブロック
			e1.printStackTrace();
		}
		this.byteKey = joinByte(this.splitByte, key1, key2);

		try {
			this.file.createNewFile();
		} catch (final IOException e) {
			logger.error(e);
		}

		BufferedOutputStream bos = null;
		try {
			bos = new BufferedOutputStream(new FileOutputStream(this.file));
			bos.write(this.byteKey);
		} catch (final FileNotFoundException e) {
			logger.error(e);
		} catch (final IOException e) {
			logger.error(e);
		} finally {
			IOUtils.closeQuietly(bos);
		}

		BufferedInputStream bis = null;
		try {
			bis = new BufferedInputStream(new FileInputStream(this.file));
			final byte[] data = new byte[bis.available()];
			bis.read(data);
			this.byteKey = data;
		} catch (final IOException e) {
			logger.error(e);
		} finally {
			IOUtils.closeQuietly(bis);
		}

		final List<byte[]> list = splitByte(this.splitByte, this.byteKey);
		final List<String> decodeList = new ArrayList<String>();
		for (final byte[] line : list)
			decodeList.add(new String(Base64.decodeBase64(line)));

		final TweetQuakeKey tweetQuakeKey = new TweetQuakeKey(decodeList.get(0), decodeList.get(1));
		logger.info(tweetQuakeKey.getKey1());
		logger.info(tweetQuakeKey.getKey2());
	}

	public static byte[] joinByte(final byte splitByte, final byte[]... arrays) {
		return joinByte(splitByte, Arrays.asList(arrays));
	}

	public static byte[] joinByte(final byte splitByte, final List<byte[]> arrays) {
		byte[] joinByte = null;
		final Iterator it = arrays.iterator();
		while (it.hasNext()) {
			final byte[] line = (byte[])it.next();
			joinByte = ArrayUtils.addAll(joinByte, line);
			if (it.hasNext())
				joinByte = ArrayUtils.addAll(joinByte, splitByte);
		}
		return joinByte;
	}

	public static List<byte[]> splitByte(final byte target, final byte[] array) {
		final List<byte[]> list = new ArrayList<byte[]>();
		List<Integer> indexList = new ArrayList<Integer>();
		indexList = indexAll(target, array);
		int count = 0;
		final Iterator it = indexList.iterator();
		while (it.hasNext()) {
			final int to = (Integer)it.next();
			list.add(Arrays.copyOfRange(array, count, to));
			count = to+1;
			if (!it.hasNext())
				list.add(Arrays.copyOfRange(array, count, array.length));
		}
		return list;
	}

	private static List indexAll(final byte target, final byte[] array) {
		final List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < array.length; i++) {
			if (array[i] == target)
				list.add(i);
		}
		return list;
	}
}
