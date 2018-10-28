package src;
import java.util.Scanner;
public class ComplexMain {

	public static void main(String[] args) {
	Scanner input = new Scanner(System.in);
	ComplexType C;
	ComplexType Z;
	double n,m;
	System.out.println("Input Re(z1):");
	 n = input.nextDouble();
	 System.out.println("Input Im(z1):");
	 m = input.nextDouble();
	C = new ComplexType(n,m);
	System.out.println("Input Re(z2):");
	 n = input.nextDouble();
	 System.out.println("Input Im(z2):");
	 m = input.nextDouble();
	 Z = new ComplexType(n,m);
	 System.out.print("z1+z2 = ");
	C.displayComplexNumber(C.addition(Z, C));
	System.out.print("z1.z2 = ");
	C.displayComplexNumber(C.multiplyByComplexNumber(Z, C));
	System.out.println("|z1| = "+C.modulus(C));
	System.out.println("|z2| = "+Z.modulus(Z));
	System.out.print("z1/z2 = ");
	C.displayComplexNumber(C.simplifyFrac(C, Z));
	input.close();
	}

}
