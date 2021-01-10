package testMoveClassToPackage;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PrimeTests {

  @Test
  public void testPrime() {
    Assert.assertTrue(Prime.isPrime(Integer.MAX_VALUE));
  }

  @Test
  public void testNonPrime() {
    Assert.assertFalse(Prime.isPrime(Integer.MAX_VALUE - 2));
  }

  @Test (enabled = false) // отключение теста
  public void testPrimeLong() {
    long n = Integer.MAX_VALUE;
    Assert.assertTrue(Prime.isPrime(n));
  }

}
