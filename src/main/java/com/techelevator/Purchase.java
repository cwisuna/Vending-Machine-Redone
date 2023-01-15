package com.techelevator;

import com.techelevator.Items.*;
import com.techelevator.view.Menu;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Purchase {
    private Map<String, Item> itemsMap = new LinkedHashMap<>();
    private BigDecimal moneyFed;
    private BigDecimal customerBalance;
    private final String PURCHASE_FEED_MONEY = "Feed Money";
    private final String PURCHASE_SELECT_PRODUCT = "Select Product";
    private final String PURCHASE_FINISH_TRANSACTION = "Finish Transaction";
    private final String[] PURCHASE_MENU_OPTIONS = { PURCHASE_FEED_MONEY, PURCHASE_SELECT_PRODUCT, PURCHASE_FINISH_TRANSACTION };



    public Map<String, Item> getItemsMap() {
        return itemsMap;
    }

    public void setItemsMap(Map<String, Item> itemsMap) {
        this.itemsMap = itemsMap;
    }

    public BigDecimal getMoneyFed() {
        return moneyFed;
    }

    public void setMoneyFed(BigDecimal moneyFed) {
        this.moneyFed = moneyFed;
    }

    public BigDecimal getCustomerBalance() {
        return customerBalance;
    }

    public void setCustomerBalance(BigDecimal customerBalance) {
        this.customerBalance = customerBalance;
    }

    public Purchase(){
        this.moneyFed = new BigDecimal(0.00);
        this.customerBalance = new BigDecimal(0.00);
    }
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

    public void displayVendingItems(){
        for(Map.Entry<String, Item> item : itemsMap.entrySet()){
            System.out.println(item.getValue().getItemSlot() +  " || " + item.getValue().getName() + " || " +  "$" + item.getValue().getPrice() + " || " + item.getValue().getQuantity() + " remaining");
        }
    }

    public void displayPurchaseMenu(){

        Menu purchaseMenu = new Menu(System.in, System.out);
        boolean isRunning = true;
        while (isRunning) {
            String choice = (String) purchaseMenu.getChoiceFromOptions(PURCHASE_MENU_OPTIONS);

            if (choice.equals(PURCHASE_FEED_MONEY)) {
                // feed money
                Scanner moneyInput = new Scanner(System.in);
                moneyFed = moneyInput.nextBigDecimal();
                System.out.println();
                System.out.println("Current Money Provided: " + "$" + moneyFed);

            } else if (choice.equals(PURCHASE_SELECT_PRODUCT)) {
                // select product

            }else if(choice.equals(PURCHASE_FINISH_TRANSACTION)){
                // finish transaction
                System.out.println();
                System.out.println("Goodbye!");
                isRunning = false;
            }
        }

    }


}
