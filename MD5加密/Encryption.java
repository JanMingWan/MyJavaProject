package com.system.util.encryption;

import java.security.MessageDigest;

/**
 * 密码加密
 * 
 * @author 王嘉明
 * @createTime 2013/11/21
 * 
 */
public class Encryption {
	/**
	 * MD5加密
	 * 
	 * @param password
	 * @return
	 */
	public static String MD5(String password) {

		char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
				'A', 'B', 'C', 'D', 'E', 'F' };
		try {
			byte[] btInput = password.getBytes();
			// 获得MD5摘要算法的 MessageDigest 对象
			MessageDigest mdInst = MessageDigest.getInstance("MD5");
			// 使用指定的字节更新摘要
			mdInst.update(btInput);
			// 获得密文
			byte[] md = mdInst.digest();
			// 把密文转换成十六进制的字符串形式
			int j = md.length;
			char str[] = new char[j * 2];
			int k = 0;
			for (int i = 0; i < j; i++) {
				byte byte0 = md[i];
				str[k++] = hexDigits[byte0 >>> 4 & 0xf];
				str[k++] = hexDigits[byte0 & 0xf];
			}
			return new String(str);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 盐值加密
	 * 
	 * @param password
	 *            明文密码
	 * @param dataTime
	 *            时间戳
	 * @return
	 */
	public static String MD5Encryption(String password, String dataTime) {
		StringBuffer passwordBuffer = new StringBuffer(MD5(password));// 获取第一次加密的密文
		String encryptionPassword = MD5(passwordBuffer.append(dataTime)
				.toString());// 第二次加密
		return encryptionPassword;
	}

	/**
	 * 登录密码判断
	 * 
	 * @param md5Password
	 *            数据库秘密
	 * @param password
	 *            用户输入秘密
	 * @param dataTime
	 *            时间戳
	 * @return 匹配 true 错误 false
	 */
	public static boolean checkPassword(String md5Password, String password,
			String dataTime) {
		if (md5Password.equals(MD5Encryption(password, dataTime))) {
			return true;
		} else {
			return false;
		}
	}
}
