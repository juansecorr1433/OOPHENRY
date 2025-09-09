/* This is a program to do basic math operations*/
import java.util.Scanner;


public class Calculator {
    public Calculator(){
        
    }
    
    public int add(int a, int b) {
        return a+b;
    }
    
    public int substract(int a, int b){
        return a-b;
    }
    
    public int multiply(int a, int b) {
        return a*b;
    }
    
    public double divide(int a, int b) {
        return a/b;
    }
    
    public int modulo(int a, int b) {
        return a%b;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Calculator myCalculator = new Calculator();
        System.out.println("Ingrese el primer valor");
        int num1 = sc.nextInt();
        
        System.out.println("Ingrese el segundo valor");
        int num2 = sc.nextInt();
        
        System.out.println("suma:"+myCalculator.add(num1,num2));
        System.out.println("resta:"+myCalculator.substract(num1, num2));
        System.out.println("multiplicacion:"+myCalculator.multiply(num1,num2));
        
    }
}