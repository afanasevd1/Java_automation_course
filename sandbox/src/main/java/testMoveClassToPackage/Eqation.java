package testMoveClassToPackage;

// Вычисление количества решений квадратного уравнени D = b^2 -4ac

public class Eqation {
  public int a;
  public int b;
  public int c;
  public int result;

  public Eqation(int a, int b, int c) {

    this.a = a;
    this.b = b;
    this.c = c;

    double d = b * b - 4 * a * c;

    if (a == 0) {
      if (b == 0) {
        if (c == 0) {
          result = -1;
        } else {
          result = 0;
        }
      } else {
        result = 1;
      }

    } else {
      if (d > 0) {
        result = 2;
      } else if (d == 0) {
        result = 1;
      } else {
        if (d < 0) {
          result = 0;
        }
      }
    }

  }

  public int getResult() {
    return result;
  }
}