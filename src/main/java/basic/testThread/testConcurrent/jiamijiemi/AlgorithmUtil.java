package basic.testThread.testConcurrent.jiamijiemi;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;
import java.security.Key;
import java.security.spec.AlgorithmParameterSpec;

public class AlgorithmUtil {

	// DES加密的私钥，必须是8位长的字符串
    private static final byte[] DES_KEY = "FCy76*h%".getBytes();// 设置密钥

	private static final byte[] DES_IV = "ber57HBh".getBytes();// 设置向量
	
	static AlgorithmParameterSpec iv = null;// 加密算法的参数接口，IvParameterSpec是它的一个实现
	private static Key key = null;

	public static void CryptoTools() throws Exception {
		DESKeySpec keySpec = new DESKeySpec(DES_KEY);// 设置密钥参数
		iv = new IvParameterSpec(DES_IV);// 设置向量
		SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");// 获得密钥工厂
		key = keyFactory.generateSecret(keySpec);// 得到密钥对象
	}

	/**
	 * 加密
	 * @param data
	 * @return String
	 * @throws Exception
	 */
	public static String encode(String data) throws Exception {
		CryptoTools();
		Cipher enCipher = Cipher.getInstance("DES/CBC/PKCS5Padding");// 得到加密对象Cipher
		enCipher.init(Cipher.ENCRYPT_MODE, key, iv);// 设置工作模式为加密模式，给出密钥和向量
		byte[] pasByte = enCipher.doFinal(data.getBytes("utf-8"));
		BASE64Encoder base64Encoder = new BASE64Encoder();
		return base64Encoder.encode(pasByte);
	}

	/**
	 * 解密
	 * @param data
	 * @return String
	 * @throws Exception
	 */
	public static String decode(String data) throws Exception {
		Cipher deCipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
		deCipher.init(Cipher.DECRYPT_MODE, key, iv);
		BASE64Decoder base64Decoder = new BASE64Decoder();
		byte[] pasByte = deCipher.doFinal(base64Decoder.decodeBuffer(data));
		return new String(pasByte, "UTF-8");
	}


	public static void main(String[] args) throws Exception {
		//String tel = "18261613632-123";
		//String enTel = encode(tel);
		//System.out.println("加密: " + enTel + ",长度" + enTel.length());
        //
		//String deTel = decode(enTel);
		//System.out.println("解密: " + deTel + ",长度" + deTel.length());

		String receivePhone = "18261613632";
		receivePhone = AlgorithmUtil.encode(receivePhone);
		receivePhone = "ANE_" + receivePhone;
		System.out.println(receivePhone);
		String deTel = decode(receivePhone);
		System.out.println("解密: " + deTel + ",长度" + deTel.length());
	}

}