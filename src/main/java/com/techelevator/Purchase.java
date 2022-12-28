package com.techelevator;

import com.techelevator.Items.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Purchase {
    private Map<String, Item> itemsMap = new LinkedHashMap<>();
    private BigDecimal moneyFed;
    private BigDecimal totalMoney;

    public boolean createMap(File file) throws FileNotFoundException {

        if(file.exists()){

            try(Scanner itemFile = new Scanner(file)){

                while(itemFile.hasNextLine()){
                    String line = itemFile.nextLine();
                    String[] itemArray = line.split("\\|");

                    if(itemArray[3].equals("Chip")){
                        itemsMap.put(itemArray[0], new Chips(itemArray[0], itemArray[1], new BigDecimal(itemArray[2]), itemArray[3],5));
                    }else if(itemArray[3].equals("Candy")){
                        itemsMap.put(itemArray[0], new Candy(itemArray[0], itemArray[1], new BigDecimal(itemArray[2]), itemArray[3],5));
                    }else if(itemArray[3].equals("Drink")){
                        itemsMap.put(itemArray[0], new Drink(itemArray[0], itemArray[1], new BigDecimal(itemArray[2]), itemArray[3],5));
                    }else if(itemArray[3].equals("Gum")){
                        itemsMap.put(itemArray[0], new Gum(itemArray[0], itemArray[1], new BigDecimal(itemArray[2]), itemArray[3],5));
                    }else{
                        System.out.println(itemArray[0] + " Type not found.");
                    }
                }
            }catch(FileNotFoundException e){
                System.err.println(e.getMessage());
            }
        }else{
            System.out.println("Something went wrong with the file");
        }
        if(!itemsMap.isEmpty()){
            return true;
        }
        return false;
    }

    public void listItemsFromMap(){
        for(Map.Entry<String, Item> item : itemsMap.entrySet()){
            System.out.println(item.getValue().getItemSlot() +  " || " + item.getValue().getName() + " || " +  "$" + item.getValue().getPrice() + " || " + item.getValue().getQuantity() + " remaining");
        }


    }



}
