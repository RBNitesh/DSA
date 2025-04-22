


public class Fraction {
    int num; int den;
    public static Fraction add(Fraction f1, Fraction f2){
        int numerator=f1.num*f2.den+f2.num*f1.den;
        int denominator=f1.den*f2.den;
        Fraction f3=new Fraction(numerator,denominator);
        return  f3;
    }

    public static Fraction multiply(Fraction f1, Fraction f2){
        int numerator=f1.num*f2.num;
        int denominator=f1.den*f2.den;
        Fraction f4=new Fraction(numerator,denominator);
        return  f4;
    }

    public Fraction(int num, int den){
        this.num=num;
        this.den=den;
        simpify(num,den);
    }
    public static void simpify(int num, int den){
        int hcf=gcd(num,den);
        int numerator=num/hcf;
        int denominator=den/hcf;
        System.out.println(numerator+"/"+denominator);
    }
    public static int gcd(int a , int b){
        if(a==0) return b;
        else return gcd(b%a, a);
    }

    public static void main(String[] args) { 
        Fraction f1 = new Fraction(15,6);
        Fraction f2 = new Fraction(12,8);
           
        Fraction f3=multiply(f1, f2);
        f1=add(f1, f2);      
    }
}
