import java.util.Scanner;
public class Main {


	public static void main(String[] args) {
		
	//Constructing objects:	
	Scanner input = new Scanner(System.in);
	//Variables
	int n;
	int m;
	
	//instructions:
	System.out.println("\t Create a new Matrix : ");
	System.out.println("\n Enter the Number of rows of the matrix A: ");
	do { n = input.nextInt(); if (n<=1) System.out.println("\t \t Rows of the Matrix should be at least 2 . Try again !");} while(n<=1);
	System.out.println("Enter the Number of Columns of the matrix A: ");
	do { m = input.nextInt(); if (m<=1) System.out.println("\t \t Columns of the Matrix should be at least 2 . Try again !");} while(m<=1);
	double[][] M = new double[n][m];
	
	System.out.println("input The Elements of the Matrix A :  ");
	for (int i=0; i<n; i++) {
		for (int j=0; j<m; j++) {
		System.out.print("A["+(i+1)+"]["+(j+1)+"] = \t");	M[i][j]=input.nextDouble();
		}
	}
	
	DefineMatrix MatA = new DefineMatrix(n,m);
	MatA.setRow(n);
	MatA.setColumn(m);
	MatA.setA(M);
	
	System.out.println("\t Create a new Matrix : ");
	System.out.println("\n Enter the Number of rows of the matrix B: ");
	do { n = input.nextInt(); if (n<1) System.out.println("\t \t Rows of the Matrix should be at least 1 . Try again !");} while(n<1);
	System.out.println("Enter the Number of Columns of the matrix B: ");
	do { m = input.nextInt(); if (m<1) System.out.println("\t \t Columns of the Matrix should be at least 1 . Try again !");} while(m<1);
	double[][] N = new double[n][m];
	for (int k=0; k<n; k++) {
		for (int v=0; v<m; v++) {
		System.out.print("A["+(k+1)+"]["+(v+1)+"] = \t");	N[k][v]=input.nextDouble();
		}
	}
	DefineMatrix MatB = new DefineMatrix(n,m);
	MatB.setRow(n);
	MatB.setColumn(m);
	MatB.setA(N);
	System.out.println("A = \t ");
	DefineMatrix.displayMatrix(MatA);
	System.out.println("B = \t ");
	DefineMatrix.displayMatrix(MatB);
	/*
	//addition
	if ((MatA.getRow()==MatB.getRow()) && (MatA.getColumn()==MatB.getColumn())) 
	{System.out.println("A+B = "); MatA.displayMatrix(MatA.addMatrices(MatB.getA()));} else {System.out.println("The sum of the matrices is not defined !");}
	// multiplication by a scalar
	System.out.println("Select a Scalar (Real or complex number ) : ");
	double k = input.nextDouble();
	MatA.displayMatrix(MatA.multiplyMatricesByScalar(k));
	//substraction
	System.out.println("A-B = "); MatA.displayMatrix(MatA.addMatrices(MatB.multiplyMatricesByScalar(-1)));*/
	//Multiplication AxB
	/*
	if (MatA.getColumn()==MatB.getRow()) 
	{System.out.println("AxB = "); DefineMatrix.displayMatrix(DefineMatrix.multiplyTwoMatrices(MatA,MatB));} else {System.out.println("The Multiplication of the matrices is not defined !");}
	*/
	   
	   // n-th fibonacci number
	/*int f;
	System.out.println("Enter the rank of the n-th fibonacci number : ");
	do {f = input.nextInt(); if(n<0) System.out.println("Enter a positive integer ! try again !"); } while (n<0);
	System.out.println("A^"+f+"  = "+ (int)DefineMatrix.nthFibonacciNumber(f-1) );*/
	System.out.println(" Det(A) = " +DefineMatrix.det(MatA));
	
	
	
	
	
    input.close();	
}
}
