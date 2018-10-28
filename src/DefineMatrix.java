

public class DefineMatrix {

	//data fields
	
private int row;     //rows of matrix
private int column;  // columns of matrix
private double[][] A ; //Matrix A


/*------------------------Constructors------------------------*/
public DefineMatrix(int n,int m) {
row = n;
column = m;
A = new double[row][column];
}
/*-----------------------------------  Setters and Getters --------------------------------*/



public int getRow() {
	return row;
}



public void setRow(int row) {
	this.row = row;
}



public int getColumn() {
	return column;
}



public void setColumn(int column) {
	this.column = column;
}



public double[][] getA() {
	return A;
}



public void setA(double[][] a) {
	A = a;
}





/*-------------------------------Methods and functions -------------------------------------------------*/






public static void displayMatrix(DefineMatrix M) {
  	
	for (int i=0; i<M.row; i++) {
		for (int j=0; j<M.column; j++) {
		 System.out.print(" " +M.A[i][j] + " ");
		}
		System.out.println();
		}	
	
}
/*---------------------------------------------------------------------------*/

public static DefineMatrix addMatrices(DefineMatrix M,DefineMatrix N) {
/** This method adds the Matrix given in parameter to the matrix A (both matrices must have the same dimensions  ) **/
	DefineMatrix S = new DefineMatrix(M.row,M.column);
for (int i=0; i<M.row; i++) {
	for (int j=0; j<M.column; j++) {	
S.A[i][j]=M.A[i][j]+N.A[i][j];
}
}
return(S);	
}
/*---------------------------------------------------------------------------*/
public static DefineMatrix multiplyMatricesByScalar( DefineMatrix M ,double k) {
	/**this method lets Multipy a Matrix by a Scalar**/
	DefineMatrix S = new DefineMatrix(M.row,M.column);
	for (int i=0; i<S.row; i++) {
		for (int j=0; j<S.column; j++) {	
			S.A[i][j]*=k;
	}
	}
	return(S);
}
/*---------------------------------------------------------------------------*/
public static DefineMatrix  multiplyTwoMatrices(DefineMatrix M,DefineMatrix N) {
/**this method lets you Multiply two matrices MxN when the columns of A and rows of B are equal otherwise the multiplication is invalid ! **/
DefineMatrix S = new DefineMatrix(M.row,N.column);
for (int i=0; i<M.row; i++) {
	
	for (int j=0; j<N.column; j++) {
		
	for (int k=0; k<M.row; k++) {
		S.A[i][j] += M.A[i][k]*N.A[k][j];
}		
}
}
return(S);
}
/*-----------------Returns the power to n of a given matrix M-----------------*/

public static DefineMatrix PowerMat(DefineMatrix M ,int n) {
	DefineMatrix S = new DefineMatrix(M.row,M.column);
	
	if (n==0) {
		for (int i=0; i<M.row; i++ ) {
		for (int j=0; j<M.column; j++ ) {
				if (i==j) S.A[i][j]=1; else S.A[i][j]=0;
		}
		}
	
		return(S); }
	 else return(multiplyTwoMatrices(M,PowerMat(M,n-1)));
	
}
/*--------------------------Determining the n-th fibonacci number using 2x2 matrix-------------------------------------------------*/
	
//fibo
public static double nthFibonacciNumber(int n) {
DefineMatrix S = new DefineMatrix(2,2);
DefineMatrix D = new DefineMatrix(2,1);
S.A[0][0]=0;	
S.A[0][1]=1;
S.A[1][0]=1;
S.A[1][1]=1;
D.A[0][0]=1;
D.A[1][0]=1;

return(multiplyTwoMatrices(PowerMat(S,n),D).A[0][0]);	
}
/*---------------Linear operations------------------------------------------------------------*/

public static DefineMatrix permutRows(DefineMatrix E) {
	DefineMatrix M=E;
	int i=0;
	while ((M.A[0][0]==0)&&(i<M.column)) {
	for (int k=0; k<M.row;  k++) {
	double c=M.A[0][k];
	M.A[0][k]=M.A[i+1][k];
	M.A[i+1][k]=c;
	}
	i++;
	if (M.A[0][0]!=0) {for (int k=0; k<M.row; k++)	{
		M.A[0][k]=-1*M.A[0][k];
		}}
	}
	
	for (int j=1; j<M.column; j++) {
	if (M.A[j][0] != 0) {
double r=M.A[j][0]/M.A[0][0];
	for (int k=0; k<M.row; k++) {
	
		M.A[j][k]=M.A[j][k]-r*M.A[0][k];
	}
	
	
	}
	
	}
	return(M);	
	}
/*-----------------Extracting the subMatrix a(i-1)(j-1)-----------------------------------------------------------*/
public static DefineMatrix reduceMatrix(DefineMatrix M) {
	DefineMatrix S = new DefineMatrix(M.row-1,M.column-1);
	for (int i=1; i<M.row; i++ )	 {
		for (int j=1; j<M.column; j++ ) {
		S.A[i-1][j-1]=permutRows(M).A[i][j];
			
		}
			
		}
	
	return(S);
	
}
/*--------------------------Determinant of a square matrix-------------------------------------------------*/

public static double det(DefineMatrix E) {
	DefineMatrix M=E;
	double d=permutRows(M).A[0][0];
	
	if (M.row == 2)	{
	double det=M.A[0][0]*M.A[1][1]-M.A[0][1]*M.A[1][0];
	return(det);
	} else {
	
	
	
	
	return(d*det(reduceMatrix(permutRows(M))));
	}
		
		
	}




	
}
