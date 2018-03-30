package com.works.common.util;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.security.Security;
import java.util.Map;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;

public class AES {

	/**
	 * AES加密 
	 * @param contentBytes  需要加密的串
	 * @param keyBytes		密钥
	 * @return 加密后的串进行Base64
	 */
	public static String encrypt(byte[] contentBytes, byte[] keyBytes) {
		try {
			fixKeyLength();
			
			Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());
			SecretKeySpec key = new SecretKeySpec(keyBytes, "AES"); 

			Cipher cipher = Cipher.getInstance("AES/ECB/PKCS7Padding", "BC");
			cipher.init(Cipher.ENCRYPT_MODE, key); //用于将 Cipher 初始化为加密模式的常量。
			byte[] tmp = cipher.doFinal(contentBytes);	//操作加密或解密数据

			return new String(Base64.encodeBase64(tmp));

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * AES解密
	 * @param contentBytes	需要解密的密文
	 * @param keyBytes		密钥
	 * @return
	 */
	public static byte[] decrypt(byte[] contentBytes, byte[] keyBytes) {
		try {
			fixKeyLength();
			Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());
			SecretKeySpec key = new SecretKeySpec(keyBytes, "AES");

			Cipher cipher = Cipher.getInstance("AES/ECB/PKCS7Padding", "BC");

			cipher.init(Cipher.DECRYPT_MODE, key);

			byte[] tmp = cipher.doFinal(Base64.decodeBase64(contentBytes));
			return tmp;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	public static void fixKeyLength() {
		String errorString = "Failed manually overriding key-length permissions.";
		int newMaxKeyLength;
		try {
			if ((newMaxKeyLength = Cipher.getMaxAllowedKeyLength("AES")) < 256) {
				Class<?> c = Class.forName("javax.crypto.CryptoAllPermissionCollection");
				Constructor<?> con = c.getDeclaredConstructor();
				con.setAccessible(true);
				Object allPermissionCollection = con.newInstance();
				Field f = c.getDeclaredField("all_allowed");
				f.setAccessible(true);
				f.setBoolean(allPermissionCollection, true);

				c = Class.forName("javax.crypto.CryptoPermissions");
				con = c.getDeclaredConstructor();
				con.setAccessible(true);
				Object allPermissions = con.newInstance();
				f = c.getDeclaredField("perms");
				f.setAccessible(true);
				((Map<String, Object>) f.get(allPermissions)).put("*", allPermissionCollection);

				c = Class.forName("javax.crypto.JceSecurityManager");
				f = c.getDeclaredField("defaultPolicy");
				f.setAccessible(true);
				Field mf = Field.class.getDeclaredField("modifiers");
				mf.setAccessible(true);
				mf.setInt(f, f.getModifiers() & ~Modifier.FINAL);
				f.set(null, allPermissions);

				newMaxKeyLength = Cipher.getMaxAllowedKeyLength("AES");
			}
		} catch (Exception e) {
			throw new RuntimeException(errorString, e);
		}
		if (newMaxKeyLength < 256)
			throw new RuntimeException(errorString); // hack failed
	}
}
