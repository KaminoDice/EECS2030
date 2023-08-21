import java.util.Arrays;

public class EnumDemo3 {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(Operation.values()));
		System.out.println(Operation.DIVIDE.apply(1.0, 2d));

	}
	public enum Operation {
		  PLUS {
		    @Override
		    public double apply(double x, double y) {  return x + y;  }
		  },
		  MINUS {
		    @Override
		    public double apply(double x, double y) {  return x - y;  }
		  },
		  TIMES {
		    @Override
		    public double apply(double x, double y) {  return x * y;  }
		  },
		  DIVIDE{
		    @Override
		    public double apply(double x, double y) {  return x / y;  }
		  };
		  
		  public abstract double apply(double x, double y);
		}

}