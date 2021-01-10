package testMoveClassToPackage; //

public class Prime {

  public static boolean isPrime(int n) { //Определение простого числа
    int m = (int) Math.sqrt(n);
    for (int i = 2; i < m; i++) { // (счетчик; условие выполнения цикла; увеличение счетчика)
      if (n % i == 0) {
        return false;
      }
    }
    return true;
  }


  public static boolean isPrimeWhile(int n) {
    int i =2;
    while (i < n && n % i == 0) {
      i++;
    }
    return i ==n;
  }

  public static boolean isPrime(long n) { //Определение простого числа long
    for (int i = 2; i < n; i++) { // (счетчик; условие выполнения цикла; увеличение счетчика)
      if (n % i == 0) {
        return false;
      }
    }
    return true;
  }

}