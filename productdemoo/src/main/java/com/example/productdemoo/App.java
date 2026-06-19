package com.example.productdemoo;
import java.util.List;
public class App 
{
    public static void main( String[] args )
    {
    	ProductDAO dao = new ProductDAO();
        Product p1 = new Product();
        p1.setId(101);
        p1.setName("Laptop");
        p1.setPrice(55000.0);
        dao.save(p1);
        System.out.println("Product saved successfully.");

        System.out.println("\nAll Products:");
        List<Product> products = dao.findAll();
        for (Product p : products) {
            System.out.println(p.getId() + " " +p.getName() + " " + p.getPrice());
        }
    }
}
