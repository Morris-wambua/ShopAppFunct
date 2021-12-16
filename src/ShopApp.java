import java.util.Scanner;

public class ShopApp {
    public static String line="==========================================================";
    public static void main(String[] args) {
        //capture student information
        Scanner scs=new Scanner(System.in);
        System.out.println("Enter your name: ");
        String studentName=scs.nextLine();
        System.out.println(line+"\nWELCOME "+studentName+"\n"+line);

        //simulate the product
        Product[] ShopProductCart = simulateProduct();

        /*Simulate the shop*/
        //display the products
        displayProducts(ShopProductCart);

        //choose actions
        System.out.println("What do you want to do now?\n1: Buy stock\n2: sell product\n3: Update price");
        Scanner choice=new Scanner(System.in);
        int option=choice.nextInt();
        System.out.println(line);
        if (option==1) {
            //buy stock
            Scanner sc=new Scanner(System.in);
            System.out.println("Which stock item do you want to buy?\n1>Exercise Band\n2>Yoga Mats\n3>Water Bottles\n4>Board games\n5>Roku express");
            int selection=sc.nextInt();
            switch(selection) {
                case 1:
                    switchStock(ShopProductCart,0);
                    break;
                case 2:
                    switchStock(ShopProductCart,1);
                    break;
                case 3:
                    switchStock(ShopProductCart,2);
                    break;
                case 4:
                    switchStock(ShopProductCart,3);
                    break;
                case 5:
                    switchStock(ShopProductCart,4);
                    break;
            }
        }
        else if (option==2) {
            //sell stock
            System.out.println("Which product do you want to sell?\n1>Exercise Band\n2>Yoga Mats\n3>Water Bottles\n4>Board games\n5>Roku express");
            Scanner sca=new Scanner(System.in);
            int sellingItem=sca.nextInt();
            switch (sellingItem) {
                case 1:
                    switchSellStock(ShopProductCart,0);
                    break;
                case 2:
                    switchSellStock(ShopProductCart,1);
                    break;
                case 3:
                    switchSellStock(ShopProductCart,2);
                    break;
                case 4:
                    switchSellStock(ShopProductCart,3);
                    break;
                case 5:
                    switchSellStock(ShopProductCart,4);
                    break;
            }
        }
        else if(option==3) {
            //Reprice products
            System.out.println("Which product do you want to Reprice?\n1>Exercise Band\n2>Yoga Mats\n3>Water Bottles\n4>Board games\n5>Roku express");
            Scanner scan=new Scanner(System.in);
            int repriceItem=scan.nextInt();

            switch(repriceItem) {
                case 1:
                    switchReprice(ShopProductCart,0);
                    break;
                case 2:
                    switchReprice(ShopProductCart,1);
                case 3:
                    switchReprice(ShopProductCart,2);
                    break;
                case 4:
                    switchReprice(ShopProductCart,3);
                    break;
                case 5:
                    switchReprice(ShopProductCart,4);
                    break;
            }
        }

        else {System.out.println("Invalid choice!");}
    }
    private static void findGrandTotal(Product[] shopArray) {
        System.out.println("The products available in the shop now:");
        double grandTotal1=0;
        for (int i = 0; i< shopArray.length; i++) {
            System.out.println(shopArray[i].toString());
            grandTotal1 += shopArray[i].getStockLevel()* shopArray[i].getPrice();
        }
        System.out.println("The total value of the shop is now: "+grandTotal1);
    }
    private static void switchReprice(Product[] shopArray, int index) {
        System.out.println("Enter the new price: ");
        Scanner sc=new Scanner(System.in);
        Double newBandPrice=sc.nextDouble();
        shopArray[index].setPrice(newBandPrice);
        System.out.println("A new price for "+ shopArray[index].getName()+" has been set to "+ shopArray[index].getPrice());
        findGrandTotal(shopArray);
    }

    private static void switchSellStock(Product[] shopArray,int index) {
        System.out.println("Enter the number of item you wish to sell: ");
        Scanner sc=new Scanner(System.in);
        int outboundBand=sc.nextInt();
        shopArray[index].sell(outboundBand);
        System.out.println(outboundBand+" item(s) sold. The new stock level is:"+(shopArray[index].getStockLevel()));
        findGrandTotal(shopArray);
    }

    private static void switchStock(Product[] shopArray,int index) {
        System.out.println("Enter the number of item you wish to add: ");
        Scanner sc=new Scanner(System.in);
        int newStock=sc.nextInt();
        shopArray[index].buyStock(newStock);
        System.out.println(newStock+" item(s) added to inventory. The new stock level is:"+(shopArray[index].getStockLevel()));
        findGrandTotal(shopArray);
    }

    private static void displayProducts(Product[] shopArray) {
        System.out.println("The products available in the shop include:");
        double grandTotal=0;
        for (int i = 0; i< shopArray.length; i++) {
            System.out.println(shopArray[i].toString());
            grandTotal += shopArray[i].getStockLevel()* shopArray[i].getPrice();
        }
        System.out.println("The total value of the shop is now: "+grandTotal+"\n"+line);
    }

    private static Product[] simulateProduct() {
        Product shopArray[]=new Product[5];
        shopArray[0]=new Product("Exercise Band",15,100.1);
        shopArray[1]=new Product("Yoga Mats",12,200);
        shopArray[2]=new Product("Water Bottles",23,150.55);
        shopArray[3]=new Product("Board games",45,250.55);
        shopArray[4]=new Product("Roku express",78,125.78);
        return shopArray;
    }
}






