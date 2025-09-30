package continuefor;

class ContinueFor {
public static void main(String[] args) {

 for (int i = 1; i <= 10; ++i) {

 if (i > 4 && i < 9) {
 continue;                         //Salta el ciclo desde el primer mencionado en el id, hasta el ultimo indicado en el if
 }
 System.out.println(i);
 }
 }
}