import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderPractice {
    public static void main(String[] args) {
        double totalPrice = 0.0;
        try (BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\Lenovo\\Downloads\\Groceries.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
              
                String[] groceryData = line.split(",");
                
                if (groceryData.length == 4) {
                    int id = Integer.parseInt(groceryData[0]);
                    String itemName = groceryData[1];
                    String quantityStr = groceryData[2];
                    double price = Double.parseDouble(groceryData[3]);
                    System.out.println("ID: " + id + ", Item Name: " + itemName + ", Quantity: " + quantityStr + ", Price: " + price);
                    totalPrice += Double.parseDouble(quantityStr.replaceAll("[^\\d.]","")) * price;
                } else {
                    System.err.println("Invalid format in line: " + line);
                }
            }
            System.out.println("\nTotal price of all items: " + totalPrice);
        } catch (IOException e) {
            System.err.println("An error occurred while reading the file: " + e.getMessage());
        }
    }
}