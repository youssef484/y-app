package src;


public class ComplexType {
protected double rp; // the real part 
protected double imp; // imaginary part
// constructors
public ComplexType(double rp, double imp) {
	
	this.rp = rp;
	this.imp = imp;
}
//getters and setters
public double getRp() {
	return rp;
}
public void setRp(double rp) {
	this.rp = rp;
}
public double getImp() {
	return imp;
}
public void setImp(double imp) {
	this.imp = imp;
}

// methods
public ComplexType addition(ComplexType z,ComplexType j) {
	/**This method allows you to add two complex numbers   **/
ComplexType w = new ComplexType(getRp(),getImp());
w.setRp(z.getRp()+j.getRp());
w.setImp(z.getImp()+j.getImp());
return(w);	
}
// 
public ComplexType multiplyByRealNumber(ComplexType z,double k) {
	/** this method allow you to multiply a complex number by a Real number **/
ComplexType w = new ComplexType(getRp(),getImp());
w.setImp(k*(w.getImp()));
w.setRp(k*(w.getRp()));
return(w);	
}
//
public  ComplexType multiplyByComplexNumber(ComplexType z,ComplexType p) {
	/** this method allow you to multiply a complex number by a Complex number **/
ComplexType w = new ComplexType(getRp(),getImp());	
w.setImp(z.getRp()*p.getImp()+z.getImp()*p.getRp());
w.setRp(z.getRp()*p.getRp() - z.getImp()*p.getImp());
return(w);
}
//-------------------------
public double modulus(ComplexType z) {
double s=Math.sqrt(getRp()*getRp()+getImp()*getImp());	
	return(s);	
}
//-------------------------
public ComplexType conjugate(ComplexType z) {
ComplexType w = new ComplexType(getRp(),getImp());
w.setImp(-1*getImp());
	
	return(w);
}
//--------------------
public ComplexType simplifyFrac(ComplexType z,ComplexType p) {
	/** this method allow you to simplify a fraction of two complex numbers of the form (a+bi)/(x+iy) **/
	ComplexType w = new ComplexType(getRp(),getImp());
	ComplexType q = new ComplexType(getRp(),getImp());	
double k=1/(p.modulus(p)*p.modulus(p));
w.setImp(z.multiplyByComplexNumber(z, p.conjugate(p)).getImp()*k);
w.setRp(z.multiplyByComplexNumber(z, p.conjugate(p)).getRp()*k);
	return(w);	
}
//----------------------------
public void displayComplexNumber(ComplexType z) {
if (z.getImp()==0) {System.out.println(z.getRp());}
else if (z.getRp()==0) {
	if (z.getImp()==1) {System.out.println("i");} else
	{System.out.println("i("+z.getImp()+")");} }
else {
	if (z.getImp()==1) {System.out.println(+z.getRp()+" + i");}  else
	System.out.println(z.getRp()+" + i("+z.getImp()+")");}
	
}




	
	
	
}
