import java.io.BufferedReader;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
public class Main {
    public static void main(String[] args)throws Exception {
        String filePath = "C:\\Users\\Lenovo\\Downloads\\Groceries.txt";
        String fileTowrite = "C:\\Users\\Lenovo\\Downloads\\GroceriesFormatted.txt";
        FileReader fileReader = new FileReader(filePath);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        FileWriter fileWriter = new FileWriter(fileTowrite);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

        String[] array = new String[4];
        String line;
        String ID;
        String itemName;
        String quantity;
        double price;
        double totalPrice=0.0;
        bufferedWriter.write("***************************************************");
        bufferedWriter.newLine();
        bufferedWriter.write("ID#"+"\t"+"item"+"\t\t\t"+"Quantity"+"\t\t"+"Price");
        bufferedWriter.newLine();
      
        while((line = bufferedReader.readLine())!=null){
            array = line.split(",");
            ID = array[0];
            itemName = array[1];
            quantity = array[2];
            price = Double.parseDouble(array[3]);
            totalPrice = totalPrice + price;
            if(itemName.length()<5 && quantity.length()<4 ){
                line=ID+"\t"+itemName+"\t\t\t"+quantity+"\t\t\t"+price;
            }else if(itemName.length()>=5 && quantity.length()<4){
                line=ID+"\t"+itemName+"\t\t"+quantity+"\t\t\t"+price;
            }
            else{
                line=ID+"\t"+itemName+"\t\t"+quantity+"\t\t"+price;
             }

             System.out.println(line);
             bufferedWriter.write(line);
             bufferedWriter.newLine();

          }

          System.out.println("The grocey shopping total is: €"+ Math.round(totalPrice));

          bufferedWriter.write("************************************************");
          bufferedWriter.newLine();
          bufferedWriter.write("Thegrocey shopping total is: €"+ Math.round(totalPrice));
          bufferedWriter.newLine();
          bufferedWriter.write("*************************************************");
          bufferedWriter.newLine();
          bufferedWriter.flush();
          bufferedWriter.close();
          bufferedReader.close();
}
}
