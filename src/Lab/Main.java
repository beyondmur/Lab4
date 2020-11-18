package Lab;

import Lab.Lab2.EquilateralTriangle;
import Lab.Lab2.Triangle;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        ArrayList<Triangle> triangles = new ArrayList<>();
        triangles.add(new Triangle(4, 4, 4, 4, -5, 0)); //does not exist
        triangles.add(new Triangle(0, 5, 4, 0, -5, 0));
        triangles.add(new Triangle(-2, 3, 2, -3, -5.19615, -3.4641));// equilateral_triangle
        triangles.add(new Triangle(0, 5, 0, 0, -2, 0));
        triangles.add(new Triangle(0, 5, 4, 0, -5, 0));
        triangles.add(new Triangle(-6, 0, 0, 0, -3, -5.19615));// equilateral_triangle
        triangles.add(new Triangle(0, 2, 4, 0, 0, -3));
        triangles.add(new Triangle(1, 1, 4, 4, 0, 0)); //does not exist
        triangles.add(new Triangle(0, 5, 4, 0, -5, 0));

        triangles.removeIf(triangle -> !triangle.check_existence());
        System.out.println("The list of triangles: ");
        System.out.println(triangles);
        for (int i = 0; i < triangles.size(); i++) {
            Triangle currentTriangle = triangles.get(i);
            for (int j = i + 1; j < triangles.size(); j++) {
                if (currentTriangle.equals(triangles.get(j))) {
                    System.out.println("Triangle " + (i + 1) + " equals to triangle " + (j + 1));
                } //Отсчет идет на человеческий, то есть треугольник [0] для нас первый.
            }
        }
        //
        ArrayList<EquilateralTriangle> equilateral_triangles = new ArrayList<>();

        for(var triangle: triangles){
            try {
                EquilateralTriangle equilateralTriangle = new EquilateralTriangle(
                        triangle.getPoint_one(),
                        triangle.getPoint_two(),
                        triangle.getPoint_three());
                equilateral_triangles.add(equilateralTriangle);
            }
            catch (RuntimeException ex) {
                System.out.println(ex.getMessage());
            }
        }
        if(triangles.size() > 0) {
            System.out.println("The list of equilateral triangles: ");

            System.out.println(equilateral_triangles);
            EquilateralTriangle equilateral_triangle = Collections.min(equilateral_triangles, Comparator.comparing(s -> s.find_median()));
            System.out.println("The lowest value among medians: " + equilateral_triangle.find_median());
        }
        else {
            System.out.println("No equilateral triangles exist");
        }
    }
}

