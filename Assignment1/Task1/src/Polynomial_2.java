import java.util.Scanner;

public class Polynomial {
    private double[] coefficients;

    public Polynomial(int degree) {
        coefficients = new double[degree + 1]; // Adding 1 to include constant term
    }

    // Method to set coefficient for a given power
    public void setCoefficient(int power, double coefficient) {
        if (power >= 0 && power < coefficients.length) {
            coefficients[power] = coefficient;
        } else {
            throw new IllegalArgumentException("Power out of range");
        }
    }

    // Method to get coefficient for a given power
    public double getCoefficient(int power) {
        if (power >= 0 && power < coefficients.length) {
            return coefficients[power];
        } else {
            return 0.0;
        }
    }

    // Method to evaluate the polynomial for a given value of x
    public double evaluate(double x) {
        double result = 0.0;
        for (int power = 0; power < coefficients.length; power++) {
            result += coefficients[power] * Math.pow(x, power);
        }
        return result;
    }

    public Polynomial add(double scalar, Polynomial other) {
        int maxDegree = Math.max(this.coefficients.length, other.coefficients.length);
        Polynomial result = new Polynomial(maxDegree - 1);

        for (int power = 0; power < maxDegree; power++) {
            double thisCoefficient = (power < this.coefficients.length) ? this.coefficients[power] : 0.0;
            double otherCoefficient = (power < other.coefficients.length) ? other.coefficients[power] : 0.0;

            result.setCoefficient(power, thisCoefficient + scalar * otherCoefficient);
        }

        return result;
    }

    // Override toString method to format the polynomial as a string
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int power = coefficients.length - 1; power >= 0; power--) {
            double coefficient = coefficients[power];
            if (coefficient != 0.0) {
                if (coefficient > 0 && sb.length() != 0) {
                    sb.append(" + ");
                } else if (coefficient < 0) {
                    sb.append(" - ");
                    coefficient = -coefficient;
                }
                if (coefficient != 1 || power == 0) {
                    sb.append(coefficient);
                }
                if (power > 0) {
                    sb.append("x");
                    if (power > 1) {
                        sb.append("^").append(power);
                    }
                }
            }
        }
        return sb.toString();
    }

    public Polynomial derivative() {
        int degree = coefficients.length - 1;
        if (degree == 0) {
            return new Polynomial(0); // If the polynomial is just a constant, its derivative is 0
        }

        Polynomial derivative = new Polynomial(degree - 1);

        for (int power = 1; power <= degree; power++) {
            derivative.setCoefficient(power - 1, coefficients[power] * power);
        }

        return derivative;
    }

    public static void main(String[] args) {

        System.out.println();
        System.out.println();

        System.out.println("My example:");
        System.out.println();
        System.out.println("Polynomial of degree 4, with c0= 10, c1= -2, c2= 3, c3= 5 and c4= 2 ");
        System.out.println();
        System.out.println();

        Polynomial f = new Polynomial(4); // Degree of polynomial is 4

        f.setCoefficient(4, 2.0);
        f.setCoefficient(3, 5.0);
        f.setCoefficient(2, 3.0);
        f.setCoefficient(1, -2.0);
        f.setCoefficient(0, 10.0); // Sets coefficient for constant term to 10.0

        System.out.println("Polynomial #1 looks like this  ="+ f.toString());
        System.out.println();
        System.out.println();


        double x = 2.0;
        System.out.println("Value of the polynomial when x = " + x + ": " + f.evaluate(x));
        System.out.println("");
        System.out.println("");

        System.out.println("Polynomial #2 of degree 4, with c0= 5, c1= 4, c2= 3, c3= 2 and c4= 5 ");

        Polynomial g = new Polynomial(4); // Degree of polynomial is 4

        g.setCoefficient(4, 5);
        g.setCoefficient(3, 2);
        g.setCoefficient(2, 3); // Sets coefficient for x^2 to 3.0
        g.setCoefficient(1, 4);
        g.setCoefficient(0, 5);

        System.out.println("");
        System.out.println("");
        System.out.println("Polynomial #2 looks like this  ="+ g.toString());
        System.out.println("");
        System.out.println("");
        System.out.println("Now I will add the 2 polynomials and multiply the second polynomial by 2");
        System.out.println("");
        System.out.println("");

        Polynomial h = f.add(2,g);
        System.out.println("resultant polynomial ="+ h.toString());
        System.out.println("");
        System.out.println("");
        System.out.println("I will now find the derivative of the resultant polynomial and display it using the overidden ToString method:");
        Polynomial hderiv = h.derivative();
        System.out.println("");
        System.out.println("");
        System.out.println("Derivative polynomial: "+hderiv);
        System.out.println("");
        System.out.println("");

        System.out.println("Now it's your turn to create a Polynomial and test it:");
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the degree of the polynomial: ");
        int degree = scanner.nextInt();

        Polynomial polynomial = new Polynomial(degree);

        System.out.println("Enter the coefficients starting from the constant term:");

        for (int power = 0; power <= degree; power++) {
            System.out.print("Coefficient for c^" + power + ": ");
            double coefficient = scanner.nextDouble();
            polynomial.setCoefficient(power, coefficient);
        }

        System.out.print("Test the get method, enter the degree of the coefficient you want to get: ");
        int coef = scanner.nextInt();

        System.out.println("the coefficient is "+ polynomial.getCoefficient(coef));

        System.out.println("Enter the value of x to evaluate the polynomial: ");
        double y = scanner.nextDouble();



        System.out.println("Value of the polynomial when x = " + y + ": " + polynomial.evaluate(y));
        System.out.println("");
        System.out.println("");
        System.out.println("Now create a 2nd Polynomial:");
        System.out.println("");
        System.out.print("Enter the degree of the 2nd polynomial: ");
        int degree2 = scanner.nextInt();

        Polynomial polynomial2 = new Polynomial(degree2);

        System.out.println("Enter the coefficients starting from the constant term:");

        for (int power2 = 0; power2 <= degree2; power2++) {
            System.out.print("Coefficient for c^" + power2 + ": ");
            double coefficient2 = scanner.nextDouble();
            polynomial2.setCoefficient(power2, coefficient2);
        }

        System.out.println("Enter scalar to multiply by:");
        double scalar = scanner.nextDouble();

        Polynomial polynew =  polynomial.add(scalar,polynomial2);
        System.out.println("the overidden ToString method is being used...");
        System.out.println("New polynomial ="+ polynew.toString());
        System.out.println("");
        System.out.println("Test the derivative method:");
        Polynomial der = polynew.derivative();
        System.out.println("Derivative of new polynomial ="+ der.toString());
        System.out.println("");


        scanner.close();
    }
}


