package FlowerShop;

import java.util.Scanner;
import java.lang.*;
import java.awt.*;
import java.awt.image.*;
import javax.imageio.*;
import javax.swing.*;
import java.io.File;

public class FlowerShop{

    public static void main(String args[]){
        double value=0.00;
        int amount=0;
        int converted;
        Person user;
        double userMoney=0;
        boolean light=false;
        Scanner scanner=new Scanner(System.in);
        if(args.length!=0){ //Only accounts for one part names if entering via command line!
            try{
                userMoney=Double.parseDouble(args[1]);
            }
            catch(Exception e){
                System.out.println("That's not a monetary value!");
            }
            if(userMoney>0){
                light=true;
            }else{
                do{
                    System.out.println("How much money are you willing to spend?: ");
                    try{
                        userMoney=Double.parseDouble(scanner.next());
                    }
                    catch(Exception e){
                        System.out.println("That's not a monetary value!");
                    }
                }while(userMoney==0);
            }
            user=new Person(userMoney);
        }
        else{
            while(light==false){
                try{
                    System.out.println("How much money are you willing to spend?: ");
                    userMoney=Double.parseDouble(scanner.next());
                }
                catch(Exception e){
                    System.out.println("That's not a monetary value!");
                }
                if(userMoney>0){
                    light=true;
                }
            }
            user=new Person(userMoney);
        }

        Rose roseStock=new Rose(20,9.00,"roses");

        SunFlower sunFlowerStock=new SunFlower(20,7.00,"passion flowers");

        Marigold marigoldStock=new Marigold(20,7.00,"Marigold");

        Jasmine jasmineStock=new Jasmine(20,8.00,"jasmines");

        IndianLotus indianLotusStock=new IndianLotus(20,10.00,"indian lotuses");

        String userInput;
        boolean flag=true;
        System.out.println("Hello "+"! Welcome to Fragrant Flowers! How may I help you today?");
        do{

            System.out.println();
            System.out.printf("%.2f",user.getMoney());
            System.out.println();
            System.out.println("1-BUY");
            System.out.println("2-BROWSE");
            System.out.println("3-EXIT");
            userInput=scanner.next();
            if(userInput.equals("1")){
                System.out.println("Would you like to buy ...");
                System.out.println("1-Roses");
                System.out.println("2-SunFlowers");
                System.out.println("3-Marigolds");
                System.out.println("4-Jasmines");
                System.out.println("5-Indian Lotuses");

                userInput=scanner.next();
                converted=Integer.parseInt(userInput);
                if(converted>0&&converted<6){
                    System.out.println("How many would you like?");
                    amount=scanner.nextInt();
                }

                switch(userInput){
                    case "1":
                        value=roseStock.accept(new FlowerProcessingVisitor(),amount,user.getMoney(),false);
                        user.transaction(-1*value);

                        break;
                    case "2":
                        value=sunFlowerStock.accept(new FlowerProcessingVisitor(),amount,user.getMoney(),false);
                        user.transaction(-1*value);
                        break;
                    case "3":
                        value=marigoldStock.accept(new FlowerProcessingVisitor(),amount,user.getMoney(),false);
                        user.transaction(-1*value);
                        break;
                    case "4":
                        value=jasmineStock.accept(new FlowerProcessingVisitor(),amount,user.getMoney(),false);
                        user.transaction(-1*value);
                        break;
                    case "5":
                        value=indianLotusStock.accept(new FlowerProcessingVisitor(),amount,user.getMoney(),false);
                        user.transaction(-1*value);
                        break;

                    default:
                        System.out.println("That's not a valid option...");
                        break;
                }
            }
            else if(userInput.equals("2")){
                JFrame editorFrame;
                ImageIcon imageIcon;
                BufferedImage image;
                JLabel jLabel;
                System.out.println("Would you like to view ...");
                System.out.println("1-Rose");
                System.out.println("2-SunFlower");
                System.out.println("3-Marigold");
                System.out.println("4-Jasmine");
                System.out.println("5-Indian Lotus");
                int choice=scanner.nextInt();

                switch(choice){
                    case 1:
                        System.out.print("The price for a rose is $");
                        System.out.printf("%.2f",roseStock.getPrice());
                        System.out.println();
                        System.out.println("There are currently "+roseStock.getAmount()+" roses in stock");
                        editorFrame = new JFrame("Roses");
                        editorFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
                        image=null;
                        try{
                            image = ImageIO.read(new File("D:\\IntelliJ IDEA\\Automaiton test\\src\\FlowerShop\\roses.jpg"));
                        }
                        catch (Exception e)
                        {
                            e.printStackTrace();
                            System.exit(1);
                        }
                        imageIcon = new ImageIcon(image);
                        jLabel = new JLabel();
                        jLabel.setIcon(imageIcon);
                        editorFrame.getContentPane().add(jLabel, BorderLayout.CENTER);
                        editorFrame.pack();
                        editorFrame.setLocationRelativeTo(null);
                        editorFrame.setVisible(true);
                        break;
                    case 2:
                        System.out.print("The price for a sunflower is $");
                        System.out.printf("%.2f",sunFlowerStock.getPrice());
                        System.out.println();
                        System.out.println("There are currently "+sunFlowerStock.getAmount()+" passion flowers in stock");
                        editorFrame = new JFrame("sunFlowers");
                        editorFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
                        image=null;
                        try{
                            image = ImageIO.read(new File("D:\\IntelliJ IDEA\\Automaiton test\\src\\FlowerShop\\sunFlower.png"));
                        }
                        catch (Exception e)
                        {
                            e.printStackTrace();
                            System.exit(1);
                        }
                        imageIcon = new ImageIcon(image);
                        jLabel = new JLabel();
                        jLabel.setIcon(imageIcon);
                        editorFrame.getContentPane().add(jLabel, BorderLayout.CENTER);
                        editorFrame.pack();
                        editorFrame.setLocationRelativeTo(null);
                        editorFrame.setVisible(true);
                        break;
                    case 3:
                        System.out.print("The price for a marigold is $");
                        System.out.printf("%.2f",marigoldStock.getPrice());
                        System.out.println();
                        System.out.println("There are currently "+marigoldStock.getAmount()+" marigolds in stock");
                        editorFrame = new JFrame("Marigolds");
                        editorFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
                        image=null;
                        try{
                            image = ImageIO.read(new File("D:\\IntelliJ IDEA\\Automaiton test\\src\\FlowerShop\\Marigold.jpg"));
                        }
                        catch (Exception e)
                        {
                            e.printStackTrace();
                            System.exit(1);
                        }
                        imageIcon = new ImageIcon(image);
                        jLabel = new JLabel();
                        jLabel.setIcon(imageIcon);
                        editorFrame.getContentPane().add(jLabel, BorderLayout.CENTER);
                        editorFrame.pack();
                        editorFrame.setLocationRelativeTo(null);
                        editorFrame.setVisible(true);
                        break;
                    case 4:
                        System.out.print("The price for a jasmine is $");
                        System.out.printf("%.2f",jasmineStock.getPrice());
                        System.out.println();
                        System.out.println("There are currently "+jasmineStock.getAmount()+" jasmines in stock");
                        editorFrame = new JFrame("Jasmines");
                        editorFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
                        image=null;
                        try{
                            image = ImageIO.read(new File("D:\\IntelliJ IDEA\\Automaiton test\\src\\FlowerShop\\Jasmines.jpg"));
                        }
                        catch (Exception e)
                        {
                            e.printStackTrace();
                            System.exit(1);
                        }
                        imageIcon = new ImageIcon(image);
                        jLabel = new JLabel();
                        jLabel.setIcon(imageIcon);
                        editorFrame.getContentPane().add(jLabel, BorderLayout.CENTER);
                        editorFrame.pack();
                        editorFrame.setLocationRelativeTo(null);
                        editorFrame.setVisible(true);
                        break;
                    case 5:
                        System.out.print("The price for an indian lotus is $");
                        System.out.printf("%.2f",indianLotusStock.getPrice());
                        System.out.println();
                        System.out.println("There are currently "+indianLotusStock.getAmount()+" indian lotuses in stock");
                        editorFrame = new JFrame("Indian Lotus");
                        editorFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
                        image=null;
                        try{
                            image = ImageIO.read(new File("D:\\IntelliJ IDEA\\Automaiton test\\src\\FlowerShop\\Indian Lotus.jpg"));
                        }
                        catch (Exception e)
                        {
                            e.printStackTrace();
                            System.exit(1);
                        }
                        imageIcon = new ImageIcon(image);
                        jLabel = new JLabel();
                        jLabel.setIcon(imageIcon);
                        editorFrame.getContentPane().add(jLabel, BorderLayout.CENTER);
                        editorFrame.pack();
                        editorFrame.setLocationRelativeTo(null);
                        editorFrame.setVisible(true);
                        break;
                    default:
                        System.out.println("That's not a valid option...");
                        break;
                }
            }

            else if(userInput.equals("3")){
                flag=false;
                System.out.println("Thank you, come again!");
                System.exit(1);
            }
            else{
                System.out.println("That's not a valid option!");
            }
        }while(flag);
    }
}
