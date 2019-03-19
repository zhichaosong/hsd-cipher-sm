package test;

import java.io.ByteArrayOutputStream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import cipher.SM4Utils;

/**
 * 文件加密，读取字节流
 * 
 * @author songzc
 * @date 20190319
 * 
 */
public class FileSM4Test {

	private static File srcFile = new File("file\\春.txt"); // 初始文件
	private static File encFile = new File("file\\encFile.txt"); // 加密文件
	private static File decFile = new File("file\\decFile.txt"); // 解密文件

//	private static File srcFile = new File("file\\spring.jpg"); // 初始文件
//	private static File encFile = new File("file\\encFile.jpg"); // 加密文件
//	private static File decFile = new File("file\\decFile.jpg"); // 解密文件

	// private static File srcFile = new File(
	// "C:\\Users\\Administrator\\Desktop\\spring.jpg"); // 初始文件
	// private static File encFile = new File(
	// "C:\\Users\\Administrator\\Desktop\\encFile.jpg"); // 加密文件
	// private static File decFile = new File(
	// "C:\\Users\\Administrator\\Desktop\\decFile.jpg"); // 解密文件

	public static void encFileSM4() throws IOException {
		SM4Utils sm4 = new SM4Utils();
		sm4.setSecretKey("JeF8U9wHFOMfs2Y8");
		sm4.setHexString(false);

		if (!srcFile.exists()) {
			System.out.println("source file not exixt");
			return;
		}

		if (!encFile.exists()) {
			System.out.println("encrypt file created");
			encFile.createNewFile();
		} else {
			System.out.println("encrypt already created");
		}
		InputStream fis = new FileInputStream(srcFile);
		OutputStream fos = new FileOutputStream(encFile);

		ByteArrayOutputStream bous = new ByteArrayOutputStream();
		int byteread;
		while ((byteread = fis.read()) > -1) {
			bous.write(byteread);
		}
		byte[] txt = bous.toByteArray();
		fos.write(sm4.encryptData_ECB(txt));
		bous.close();

		fis.close();
		fos.flush();
		fos.close();
	}

	public static void decFileSM4() throws IOException {
		SM4Utils sm4 = new SM4Utils();
		sm4.setSecretKey("JeF8U9wHFOMfs2Y8");
		sm4.setHexString(false);

		if (!srcFile.exists()) {
			System.out.println("source file not exixt");
			return;
		}

		if (!decFile.exists()) {
			System.out.println("decrypt file created");
			decFile.createNewFile();
		} else {
			System.out.println("decrypt already created");
		}
		InputStream fis = new FileInputStream(encFile);
		OutputStream fos = new FileOutputStream(decFile);
		int byteread;

		// byte[] input = new byte[100];
		// while ((byteread = fis.read(input)) > -1) {
		// fos.write(sm4.decryptData_ECB(input));
		// }

		ByteArrayOutputStream bous = new ByteArrayOutputStream();
		while ((byteread = fis.read()) > -1) {
			bous.write(byteread);
		}
		byte[] txt = bous.toByteArray();
		fos.write(sm4.decryptData_ECB(txt));
		bous.close();

		fis.close();
		fos.flush();
		fos.close();
	}
}
