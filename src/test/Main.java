package test;

import java.io.IOException;

public class Main {
	public static void main(String args[]) throws Exception{
		System.out.print("\n\n\n========SM2Test.testSM2()========\n\n\n");
		SM2Test sm2test = new SM2Test();
		sm2test.testSM2();
		System.out.print("\n\n\n========SM3Test.testSM3()========\n\n\n");
		SM3Test sm3test = new SM3Test();
		sm3test.testSM3();
		System.out.print("\n\n\n========SM4Test.testSM4()========\n\n\n");
		SM4Test sm4test = new SM4Test();
		sm4test.testSM4();

//		System.out.print("\n\n\n========FileEncAndDec========\n\n\n");
//		FileEncAndDec.encfile();
		
		System.out.print("\n\n\n========FileSM4Test========\n\n\n");
		FileSM4Test.encFileSM4();
		FileSM4Test.decFileSM4();
	}
}
