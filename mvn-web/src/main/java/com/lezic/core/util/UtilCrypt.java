/**
 * <p>Author		:	cielo</p>
 * <p>Date 			: 	2016 下午3:25:02</p>
 */
package com.lezic.core.util;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;

import org.springframework.util.DigestUtils;

/**
 * 加解密工具类
 * 
 * @author cielo
 *
 */
public class UtilCrypt {
	
	/**
	 * 密钥
	 */
	private static String CRYPT_KEY = "2ox#4xi0wn&^e4";

	// 加密
	private static Cipher ecip;
	// 解密
	private static Cipher dcip;

	static {
		try {
			String KEY = DigestUtils.md5DigestAsHex(CRYPT_KEY.getBytes()).toUpperCase();
			KEY = KEY.substring(0, 8);
			byte[] bytes = KEY.getBytes();
			DESKeySpec ks = new DESKeySpec(bytes);
			SecretKeyFactory skf = SecretKeyFactory.getInstance("DES");
			SecretKey sk = skf.generateSecret(ks);
			IvParameterSpec iv2 = new IvParameterSpec(bytes);

			ecip = Cipher.getInstance("DES/CBC/PKCS5Padding");
			ecip.init(Cipher.ENCRYPT_MODE, sk, iv2);

			dcip = Cipher.getInstance("DES/CBC/PKCS5Padding");
			dcip.init(Cipher.DECRYPT_MODE, sk, iv2);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	/**
	 * 加密
	 * @param content
	 * @return
	 * @throws Exception
	 * @author cielo
	 */
	public static String encrypt(String content) throws Exception {
		byte[] bytes = ecip.doFinal(content.getBytes("ascii"));
		return UtilCrypt.byte2hex(bytes);
	}

	/**
	 * 解密
	 * @param content
	 * @return
	 * @throws Exception
	 * @author cielo
	 */
	public static String decrypt(String content) throws Exception {
		byte[] bytes = UtilCrypt.hex2byte(content);
		bytes = dcip.doFinal(bytes);
		return new String(bytes, "ascii");
	}

	/**
	 * 字节码转换成16进制字符串
	 * 
	 * @param byte[]
	 *            b 输入要转换的字节码
	 * @return String 返回转换后的16进制字符串
	 */
	public static String byte2hex(byte[] bytes) {
		StringBuilder hs = new StringBuilder();
		for (byte b : bytes)
			hs.append(String.format("%1$02X", b));
		return hs.toString();
	}

	/**
	 * 字符串转换成字节码
	 * 
	 * @param content
	 * @return
	 * @author cielo
	 */
	public static byte[] hex2byte(String content) {
		int l = content.length() >> 1;
		byte[] result = new byte[l];
		for (int i = 0; i < l; i++) {
			int j = i << 1;
			String s = content.substring(j, j + 2);
			result[i] = Integer.valueOf(s, 16).byteValue();
		}
		return result;
	}

	public static void main(String[] args) throws Exception {
		String password = "babytiana";
		String en = encrypt(password);
		System.out.println("加密后：" + en);
		System.out.println("解密后：" + decrypt(en));

	}
}
