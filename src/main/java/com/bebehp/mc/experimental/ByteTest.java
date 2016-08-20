package com.bebehp.mc.experimental;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.logging.log4j.Logger;

import com.google.common.primitives.Bytes;

import scala.actors.threadpool.Arrays;

public class ByteTest {

	private final byte[] byteKey;
	private final List<byte[]> keys = new ArrayList<byte[]>();
	private byte[] decodeByteKey;

	public ByteTest(final Logger logger) {
		this.keys.add(Base64.encodeBase64("TZ89zhDtYOMka05f8rWCgNq1l9".getBytes()));
		this.keys.add(Base64.encodeBase64("QfbdpOOa4WSnLjRuLhKXKioKBkBVZ8If4dYv3TH1HlhTE9uzGoC".getBytes()));

		this.byteKey = joinByte(this.keys);
		final byte splitByte = 0x2F;
		final int originalRange = this.byteKey.length;

		logger.info(Bytes.indexOf(this.byteKey, splitByte));
		final String strKey = new String(this.byteKey);
		final String[] keyArray = strKey.split(";");
		for (final String line : keyArray)
			logger.info(line);
	}

	public byte[] joinByte(final List list) {
		byte[] joinByte = null;
		final byte splitByte = 0x2F;
		final Iterator it = list.iterator();
		while (it.hasNext()) {
			final byte[] line = (byte[])it.next();
			joinByte = ArrayUtils.addAll(joinByte, line);
			if (it.hasNext())
				joinByte = ArrayUtils.addAll(joinByte, splitByte);
		}
		return joinByte;
	}

	public List splitByte(final byte[] array, final byte target) {
		final List<byte[]> list = new ArrayList<byte[]>();
		//		final byte splitByte = 0x2F;
		final List<Integer> indexList = indexAll(array, target);
		final Iterator iterator = indexList.iterator();
		int count = 0;
		while (iterator.hasNext()) {
			final int to = (Integer)iterator.next();
			list.add(Arrays.copyOfRange(array, count, to));
			count = to;
		}
		return list;
	}

	public List indexAll(final byte[] array, final byte target) {
		final List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < array.length; i++) {
			if (array[i] == target) {
				list.add(i);
			}
		}
		return list;
	}
}
