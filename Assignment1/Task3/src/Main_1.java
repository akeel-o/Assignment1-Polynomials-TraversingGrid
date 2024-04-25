
public class Main {
    public static void main(String[] args) {

        System.out.println("Task 2 examples:");
        System.out.println("\nExample 1:");

        Polynomial a = new Polynomial(2);
        a.setCoefficient(2, 2);
        a.setCoefficient(1, 2);
        a.setCoefficient(0, 10.0);
        System.out.println("I have set the coeffiecients as 2, 2, and 10 respectively");
        System.out.println("This is how it looks (using toString method):");
        System.out.println("Polynomial #1 ="+ a.toString());
        System.out.println("Evaluating the Polynomial with x=2: Polynomial = " +a.evaluate(2));
        System.out.println("Derivative of Polynomial #1= " + a.derivative());

        System.out.println("\nExample 2:");

        Polynomial b = new Polynomial(3);
        b.setCoefficient(3, 5);
        b.setCoefficient(2, 5);
        b.setCoefficient(1, 5);
        b.setCoefficient(0, 5);
        System.out.println("I have set the coeffiecients as 5, 5, 5, and 5 respectively");
        System.out.println("This is how it looks (using toString method):");
        System.out.println("Polynomial #2 ="+ b.toString());
        System.out.println("Evaluating the Polynomial with x=2: Polynomial = " +b.evaluate(2));
        System.out.println("Derivative of Polynomial #2= " + b.derivative());

        System.out.println("\nExample 3:");

        Polynomial c = new Polynomial(4);
        c.setCoefficient(4, 10);
        c.setCoefficient(3, 8);
        c.setCoefficient(2, 6);
        c.setCoefficient(1, 4);
        c.setCoefficient(0, 2);
        System.out.println("I have set the coeffiecients as 2, 4, 6,8 and 10 respectively");
        System.out.println("This is how it looks (using toString method):");
        System.out.println("Polynomial #3 ="+ c.toString());
        System.out.println("Evaluating the Polynomial with x=2: Polynomial = " +c.evaluate(2));
        System.out.println("Derivative of Polynomial #3= " + c.derivative());

        System.out.println("\nExample 4:");

        Polynomial d = new Polynomial(5);
        d.setCoefficient(5, 6);
        d.setCoefficient(4, 5);
        d.setCoefficient(3, 4);
        d.setCoefficient(2, 3);
        d.setCoefficient(1, 2);
        d.setCoefficient(0, 1);
        System.out.println("I have set the coeffiecients as 1, 2, 3,4,5 and 6 respectively");
        System.out.println("This is how it looks (using toString method):");
        System.out.println("Polynomial #4 ="+ d.toString());
        System.out.println("Evaluating the Polynomial with x=2: Polynomial = " +d.evaluate(2));
        System.out.println("Derivative of Polynomial #4= " + d.derivative());

        System.out.println("\nExample 5:");

        Polynomial e = new Polynomial(6);
        e.setCoefficient(6, 4);
        e.setCoefficient(5, 3);
        e.setCoefficient(4, 2);
        e.setCoefficient(3, 5);
        e.setCoefficient(2, 2);
        e.setCoefficient(1, 6);
        e.setCoefficient(0, 2);
        System.out.println("I have set the coeffiecients as 2, 6, 2,5,2,3 and 4 respectively");
        System.out.println("This is how it looks (using toString method):");
        System.out.println("Polynomial #5 ="+ e.toString());
        System.out.println("Evaluating the Polynomial with x=2: Polynomial = " +e.evaluate(2));
        System.out.println("Derivative of Polynomial #5= " + e.derivative());

        System.out.println("\nAdditions of Polynomials (with scalar = 2)");
        System.out.println("\n1.....Polynomial a  + 2*Polynomial b");
        System.out.println(a.toString()+" + 2("+b.toString()+")");
        System.out.println("= "+ a.add(2,b));
        System.out.println("\n2.....Polynomial a  + 2*Polynomial c");
        System.out.println(a.toString()+" + 2("+c.toString()+")");
        System.out.println("= "+ a.add(2,c));;
        System.out.println("\n3.....Polynomial b  + 2*Polynomial d");
        System.out.println(b.toString()+" + 2("+d.toString()+")");
        System.out.println("= "+ b.add(2,d));
        System.out.println("\n4.....Polynomial c  + 2*Polynomial e");
        System.out.println(c.toString()+" + 2("+e.toString()+")");
        System.out.println("= "+ c.add(2,e));
        System.out.println("\n5.....Polynomial a  + 2*Polynomial e");
        System.out.println(a.toString()+" + 2("+e.toString()+")");
        System.out.println("= "+ a.add(2,e));


        System.out.println("");
        System.out.println("");
        System.out.println("\nTask 3 examples:");

        Grid grid2 = new Grid();
        int[][] gridWithPath = {
                {2, 1, 2},
                {3, 1, 1},
                {1, 2, 1}
        };
        int[][] gridWithPath2 = {
                {3, 1, 1, 2},
                {3, 1, 1, 2},
                {1, 2, 1, 1},
                {1, 3, 1, 2}
        };

        int[][] gridWithoutPath = {
                {2, 1, 3},
                {3, 1, 1},
                {3, 1, 1}
        };
        int[][] gridWithoutPath2 = {
                {3, 1, 3, 1},
                {3, 1, 1,2},
                {3, 1, 1,2},
                {4, 1, 1,2}
        };
        int[][] gridWithoutPath3 = {
                {3, 2, 2,3},
                {3, 3, 3,2},
                {3, 1, 2,3},
                {3, 1, 2,3},
        };

        System.out.println("\nExample 1:");
        grid2.testGrid(gridWithPath);
        System.out.println("\nExample 2:");
        grid2.testGrid(gridWithoutPath);
        System.out.println("\nExample 3:");
        grid2.testGrid(gridWithPath2);
        System.out.println("\nExample 4:");
        grid2.testGrid(gridWithoutPath2);
        System.out.println("\nExample 5:");
        grid2.testGrid(gridWithoutPath3);









    }
}