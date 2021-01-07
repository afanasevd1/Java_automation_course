package testMoveClassToPackage;

import org.testng.Assert;
import org.testng.annotations.Test;

@Test
public class EquationsTests {

  public void test0(){
    Eqation e = new Eqation(1, 1, 1);
    Assert.assertEquals(e.result, 0);
  }

  public void test1(){
    Eqation e = new Eqation(1, 2, 1);
    Assert.assertEquals(e.getResult(), 1);
  }

  public void test2(){
    Eqation e = new Eqation(1, 5, 6);
    Assert.assertEquals(e.result, 2);
  }

  public void testA0(){
    Eqation e = new Eqation(0, 1, 1);
    Assert.assertEquals(e.result, 1);
  }

  public void testAB0(){
    Eqation e = new Eqation(0, 0, 1);
    Assert.assertEquals(e.getResult(), 0);
  }

  public void testABC0(){
    Eqation e = new Eqation(0, 0, 0);
    Assert.assertEquals(e.result, -1);
  }
}
