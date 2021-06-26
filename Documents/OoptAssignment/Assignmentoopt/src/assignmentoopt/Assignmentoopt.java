
package assignmentoopt;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Assignmentoopt {

    public static void main(String[] args) {
        Product[] prod = new Product[100];
        prod[0] = new Product("MEAT MANIA",28.90);
        prod[1] = new Product("SPICY SAUSAGE", 27.20);
        prod[2] = new Product("ALOHA CHICKEN",26.00);
        prod[3] = new Product("BEEF PEPPERONI",25.20);
        prod[4] = new Product("CLASSIC CHICKEN",28.90);
        
        Staff[] staff = new Staff[200];
        staff[0] = new Staff("Amy Tan",21,'M',"1234");
        staff[1] = new Staff("Emily Wong",24,'F',"abc456");
        staff[2] = new Staff("Alice Ong",40,'F',"abc789");
        staff[3] = new Staff("Ng Xing Xing",23,'M',"abc235");
        staff[4] = new Staff("Tan En En",38,'F',"abc123");
        
        staff[0].setPosition("Manager");
        
        Order[] order = new Order[100];
        Receipt[] receipt = new Receipt[100];
        
        logo();
        login(prod,order,staff,receipt);
    }
    public static void logo(){
        System.out.println("***********       *******           ********       ********       **********     ****            ****       ****");
        System.out.println("***********      **********         *********     *********         ******       ****             ****     ****");
        System.out.println("****            ****    ****        ***********************         ******       ****              ****   ****");
        System.out.println("***********    **************       *****   ********  *****         ******       ****                 ****");
        System.out.println("***********   ****************      *****      **     *****         ******       ****                 ****");
        System.out.println("****         ****         ****      *****             *****         ******       ****************     ****");
        System.out.println("****        ****           ****     *****             *****       **********     ****************     ****\n\n");
        
        System.out.println("\t\t\t************      **********    ****************    ****************            ********");
        System.out.println("\t\t\t*************       ******      ***************     ***************            **********");
        System.out.println("\t\t\t******    ****      ******             *******            *******             *****   ****");
        System.out.println("\t\t\t******    ****      ******             ******             ******             *****     ****");
        System.out.println("\t\t\t*************       ******            ******             ******             ****************");
        System.out.println("\t\t\t***********         ******           ******             ******             ******************");
        System.out.println("\t\t\t******              ******         *******             *******            *****          *****");
        System.out.println("\t\t\t******              ******       ***************     ***************      *****          *****");
        System.out.println("\t\t\t******            **********    ****************    ****************      *****          *****\n\n");
    }
    public static void login(Product[] prod, Order[] order, Staff[] staff, Receipt []r){
        int input;
        String temp;
        
        Scanner scanner = new Scanner(System.in);
        LocalDateTime myDate = LocalDateTime.now(); //date&time object
        DateTimeFormatter formatDateTimeObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String formattedDate = myDate.format(formatDateTimeObj);
        System.out.println("Today's Date & Time: "+formattedDate);
        System.out.println("============================================================================================================================");
        System.out.println("Log in to your account.");
        do{
            System.out.println("============================================================================================================================");
            System.out.println("1.Manager login");
            System.out.println("2.Staff login");
            System.out.println("3.Exit");
            System.out.println("============================================================================================================================");
            System.out.print("\nPlease enter your option > ");
            temp = scanner.nextLine();
 
            try{
                input = Integer.parseInt(temp);        
            }catch(NumberFormatException e){            
                input=0;
            }

            switch(input){
                case 1:
                    ManagerLogin(prod,order,staff, r);           
                    break;
                case 2:
                    StaffLogin(prod,order,staff,r);
                    break;
                case 3:
                    break;
                default:
                    System.out.println("Invalid Option.\n");

            }
        }while(input!=3);
    }
    public static void StaffLogin(Product[] prod, Order[] order, Staff[] staff, Receipt []r){
        Scanner scr = new Scanner(System.in);
        String staffid;
        String staffpass; 
        boolean login;
        int staffCounter = Staff.getStaffCounter();
        
        do{
            System.out.print("\nStaff ID > ");
            staffid = scr.nextLine();
            login = false;
            for(int i=0;i<staffCounter;i++){
                if(staffid.equalsIgnoreCase(staff[i].getStaffID())){
                    System.out.print("Password > ");
                    staffpass = scr.nextLine();
                        if(staffpass.equalsIgnoreCase(staff[i].getPassword())){
                            System.out.println("Welcome " + staff[i].getName() + "!\n");
                            login = true;
                            break;
                        }
                        else{
                           System.out.println("Fail to log in!\n");
                        }           
                }
            }
            
            if(!login){
                System.out.println("Staff ID not found! Please try again.\n");
            }
            
        }while(!login);
        staffMenu(prod,order,staff,r,staffid);
    }  
    public static void staffMenu(Product[] prod, Order[] order, Staff[] staff, Receipt []r, String staffid){
        Scanner scr = new Scanner(System.in);
        int choice;
        do{ 
            
            System.out.println("============================================================================================================================");
            System.out.println("1.Take Order");
            System.out.println("2.Log out");
            System.out.println("============================================================================================================================");
            System.out.print("Please enter your choice > ");
            String temp;
            temp = scr.nextLine();

            try{
                choice = Integer.parseInt(temp);       
            }catch(NumberFormatException e){           
                choice=0;
            }
            
            switch(choice){
                case 1:
                    r = takeOrder(prod,order,r,staffid);      
                    break;
                case 2:
                    break;
                default:
                    System.out.println("Invalid Option.\n");
            }
         }while(choice!=2);
    }
    public static void ManagerLogin(Product[] prod,Order[] order,Staff[] staff, Receipt []r){
        String managerID;
        String managerPassword;
        
        boolean foundManagerID;
        int staffCounter = Staff.getStaffCounter(),i;
        Scanner scr = new Scanner(System.in);
        boolean notManager;
        do{
            notManager=false;
            System.out.print("\nManager ID > ");
            managerID = scr.nextLine();
            foundManagerID=false;
            for(i=0;i<staffCounter;i++){
                if(managerID.equalsIgnoreCase(staff[i].getStaffID())){
                    
                    if(!staff[i].getPosition().equalsIgnoreCase("Manager")){
                        System.out.println("This is not a Manager ID!!! Please enter again!\n");
                        notManager=true;
                    }else{
                        foundManagerID=true;
                        break;
                    }
                }
            }
            
            if(!foundManagerID&&!notManager){
                System.out.println("Manager ID not found! Please enter again!\n");
            }
            
        }while(!foundManagerID);
        
        int num=3;
        boolean login;
        do{
            login=false;
            System.out.print("Password > ");
            managerPassword = scr.nextLine();

            if(staff[i].getPassword().equals(managerPassword)){
                System.out.println("Welcome " + staff[i].getName() + "!\n");
                login=true;
                break;
            }else{
                if(num==1)
                    break;
                
                System.out.printf("\nWrong Password! You have %d more attempt(s) left\n",--num);
            }
            
        }while(num!=0);
       
        if(login){
            int choice;
            do{ 
                System.out.println("============================================================================================================================");
                System.out.println("1.Manage Product");
                System.out.println("2.Summary Report");
                System.out.println("3.Staff");
                System.out.println("4.Log Out");
                System.out.println("============================================================================================================================");
                System.out.print("Please enter your choice > ");
                String temp;
                temp = scr.nextLine();

                try{
                    choice = Integer.parseInt(temp);       
                }catch(NumberFormatException e){           
                    choice=0;
                }

                switch(choice){
                    case 1:
                        productMenu(prod);
                        break;
                    case 2:
                        if(Receipt.getCount()!=0){
                            summaryReport(prod,r);
                        }else{
                            System.out.println("No Payment made for today!\n");
                        }
                        break;
                    case 3:
                        staffMenu(staff);
                        break;
                    case 4:
                        break;
                    default:
                        System.out.println("Invalid Option.\n");
                }
            }while(choice!=4);
        }else{
            System.out.println("Login Failed! Please try again later.\n");
        }
    }
    public static void staffMenu(Staff[] staff){
        Scanner scr = new Scanner(System.in);
        int choice;
        do{
            System.out.println("==================================Staff Menu====================================================");
            System.out.println("1.View All Staff");
            System.out.println("2.Add New Staff");
            System.out.println("3.Exit staff menu");
            System.out.println("============================================================================================================================");
            System.out.print("Please enter your choice > ");
            String temp;
            temp = scr.nextLine();

            try{
                choice = Integer.parseInt(temp);       
            }catch(NumberFormatException e){           
                choice=0;
            }
            
            switch(choice){
                case 1:
                    staffDetail(staff);
                    break;
                case 2:
                    addStaff(staff);
                    break;
                case 3:
                    break;
                default:
                    System.out.println("Invalid Option.\n");
            }
        }while(choice!=3);
    }
    public static void staffDetail(Staff[] staff){
        int staffCounter = Staff.getStaffCounter();
        System.out.println("\n----------------------Staff Details-----------------------");
        for(int i=0;i<staffCounter;i++){      
            System.out.println(staff[i].toString());      
        }
        System.out.print("\n");
    }
    public static void addStaff(Staff[] staff){
        Scanner scr = new Scanner(System.in);
        int age;
        char add,gender,addMore;
        String name;
        
        System.out.print("\nAdd Staff?(Y/y=Yes,N/n=No) > ");
        String tempSpace = scr.nextLine();
        add = checkYesNo(tempSpace);
        
        if(add=='Y'){
            do{   
                int staffCounter = Staff.getStaffCounter();
                System.out.print("Please enter the staff name: ");
                name = scr.nextLine();
                name = checkValidName(name);
   
                System.out.print("Please enter the staff age: ");
                tempSpace = scr.nextLine();
                age = checkValidInteger(tempSpace);
          
                do{
                    System.out.print("Please enter the staff gender(F/M): ");
                    gender = scr.nextLine().charAt(0);
                    
                    if(gender!='f'&&gender!='F'&&gender!='m'&&gender!='M'){
                         gender = 'Z';
                         System.out.println("Invalid Input");
                    }
                }while(gender=='Z');
                  
                System.out.print("Confirm to add the staff?(Y/y=Yes,others=No) > ");
                char confirmAdd = scr.nextLine().charAt(0);
                if(confirmAdd=='Y'||confirmAdd=='y'){
                    staff[staffCounter] = new Staff(name,age,gender,"password");
                    staffDetail(staff);  
                }
               
                System.out.print("\nAdd another Staff Record? (y/n)  > ");
                tempSpace = scr.nextLine();
                addMore = checkYesNo(tempSpace);
                System.out.print("\n");
                
            }while(addMore=='Y');
        }else{
            System.out.println("Add Staff Function Exited.\n");
        }
    }
    public static int checkValidInteger(String tempSpace){
        
        Scanner scr = new Scanner(System.in);
        int age;
        
        do{
            
            try{
                age = Integer.parseInt(tempSpace);
            }catch(NumberFormatException e){
                age = -1;
            }
            
            if(age==-1){
                System.out.println("Invalid Input! Please Enter Again.\n");
            }
            
            if(age>65){
                System.out.println("Go Enjoy your retired life :D \n");
                age=-1;
            }
           
            if(age<21&&age!=-1){
                System.out.println("You are too young for this position!\n");
                age=-1;
            }
            
            if(age==-1){
                System.out.print("Enter Age : ");
                tempSpace = scr.nextLine();
            }
            
        }while(age==-1);
        
        return age;
    }
    public static String checkValidName(String tempName){
        Scanner scr = new Scanner(System.in);
        boolean valid;
        
        do{
            valid = false;
            for(int i=0;i<tempName.length();i++){
                
                if(tempName.charAt(i)==' ')
                    continue;

                if((int)tempName.charAt(i)<65||(int)tempName.charAt(i)>90&&(int)tempName.charAt(i)<97||(int)tempName.charAt(i)>122)
                    break;
                
                if(i==tempName.length()-1)
                    valid = true;
            }
            
            if(!valid){
                System.out.println("Invalid Format! Please Try Again.\n");
                System.out.printf("Enter Name : ");
                tempName = scr.nextLine();
            }
            
        }while(!valid);
        
        return tempName;
    }
    public static void productMenu(Product[] prod){
        int choice;
        String temp;
        Scanner scr = new Scanner(System.in);
        do{
            System.out.println("\n\t***********WELCOME!!**********");
            System.out.println("\t*\t1.Add Product        *");
            System.out.println("\t*\t2.Delete Product     *");
            System.out.println("\t*\t3.View Product       *");
            System.out.println("\t*\t4.Modify Product     *");
            System.out.println("\t*\t5.Back               *");
            System.out.println("\t******************************\n");
            
            System.out.print("Please enter your choice > ");
            temp = scr.nextLine();
 
            try{
                choice = Integer.parseInt(temp);        //CONVERT SRTING INTO NUMBER : "123" --> 123
            }catch(NumberFormatException e){            //CATCH FAIL : "123b" #b CANNOT BE CONVERTED
                choice=0;
            }

            switch(choice){
                case 1:
                    addProd(prod);
                    break;
                case 2:
                    removeProd(prod);
                    break;
                case 3:
                    viewProd(prod);
                    break;
                case 4:
                    modifyProd(prod);
                    break;  
                case 5:
                    break;
                default:
                    System.out.println("Invalid Option.\n");

            }
        }while(choice!=5); //IF USER SELECT 5 THEN PROGRAM TERMINATE, ELSE CONTINUE LOOPING (AVOID CALLING SAME FUNCTION)
        
    }
    public static double readDouble(double min, double max) {
        double prodPrice;
        Scanner scr = new Scanner(System.in);
        do{
            try{
                prodPrice = Double.parseDouble(scr.nextLine());  
                if(prodPrice>=min && prodPrice <=max){
                    break;
                }else{
                    System.out.println("Amount less than min or greater than max.\n");
                    
                    prodPrice = -1;
                }
            }catch(Exception e){
                System.out.println("Invalid value.\n");
                prodPrice = -1;
            }
            if(prodPrice==-1){
                System.out.print("Please enter the price: RM ");        
            }
        }while(prodPrice==-1);
        
        return prodPrice;
    }
    public static void addProd(Product[] prod) {
        Scanner scr = new Scanner(System.in);
        char addMore;
        String prodName;
        boolean found;
        char confirm;  
        
        do{
            int x = Product.getProdCounter()-Product.getRemoveProd();
            do{
                found = false;
                System.out.print("Please enter the product name: ");
                prodName = scr.nextLine();
                if(prodName.length()==0){
                    System.out.println("Product Name cannot be Blank!!!\n");
                    found=true;
                }
            
                for(int i=0;i<x;i++){
                    if(prod[i].getProdName().equalsIgnoreCase(prodName)){
                        System.out.println("Product name repeated.\n");
                        found = true;
                        break;
                    }
                }
            }while(found);
            
            System.out.print("Please enter the price: RM ");
            double prodPrice = readDouble(0,Double.MAX_VALUE);

            System.out.print("Confirm to add the product?(Y/y=Yes,others=No) > ");
            confirm = checkYesNo(scr.nextLine());

            if(confirm == 'Y') {
                System.out.println("\n-----------------Add successful!-----------------");
                prod[x] = new Product(prodName.toUpperCase(), prodPrice);
                System.out.println("Product ID\tProduct Name\t    Product Price" );
                System.out.printf("A%04d\t\t%-16s\tRM%7.2f\n",prod[x].getProdID(),prod[x].getProdName(),prod[x].getProdPrice()); 
                viewProd(prod);
            }else{
                System.out.println("Add Product Cancelled.\n");
            }

            System.out.print("\nAdd another Product Record? (y/n) > ");
            addMore = checkYesNo(scr.nextLine());
            System.out.print("\n");
            
        }while(addMore=='Y');
    }
    public static void viewProd(Product[] prod){
        int prodCounter=Product.getProdCounter()-Product.getRemoveProd();
        System.out.println("\n----------------------Menu-----------------------");
        
        for(int p=0;p<prodCounter;p++){      
            System.out.printf("A%04d\t\t%-16s\tRM%7.2f\n",prod[p].getProdID(),prod[p].getProdName(),prod[p].getProdPrice());
        }
        System.out.print("\n");
    }
    public static void removeProd(Product[] prod){
        Scanner scr = new Scanner(System.in);
        String temp;
        boolean found=false;
        int prodID,i;
        viewProd(prod);
        int prodCounter = Product.getProdCounter()-Product.getRemoveProd();
        do{ 
            System.out.print("Enter product ID that you want to remove > A");
            temp = scr.nextLine();
            
            try{
                prodID = Integer.parseInt(temp);       
            }catch(NumberFormatException e){  
                System.out.println("Invalid Product ID!");
                prodID=0;
            }
            
            if(prodID!=0){
                found = false;
                for(i=0;i<prodCounter;i++){
                    if(prod[i].getProdID()==prodID){
                        found = true;
                        break;
                    }
                } 
            }
            
            if(!found&&prodID!=0){
                System.out.println("Product ID not found!");
                prodID=0;
            }
        }while(prodID==0);
        
        System.out.print("Confirm Remove Product? (y/n) :");
        String tempSpace = scr.nextLine();
        char confirm = checkYesNo(tempSpace);
        
        if(confirm=='Y'){
            for(i=0;i<prodCounter;i++){
                if(prod[i].getProdID()==prodID){
                    for(int x=i;x<prodCounter;x++){
                        prod[x]=prod[x+1];
                    }
                    Product.incRemoveProd();
                    break;
                }
            }
            System.out.println("Product has been Removed.\n");
        }else{
            System.out.println("Remove Product has been Cancelled.\n");
        }
        viewProd(prod);
    }
    public static char checkYesNo(String input){
        Scanner scr = new Scanner(System.in);
        char choice='Z';
        
        do{
            if(input.length()==1){
                if(input.equals("")){
                    choice = 'Z';
                }else{
                    choice = input.charAt(0);
                }
            }
            
            if(choice!='Y'&&choice!='y'&&choice!='N'&&choice!='n')
                choice = 'Z';
            else if(choice=='Y'||choice=='y')
                return 'Y';
            else
                return 'N';
            
            if(choice=='Z'){
                System.out.print("\nInvalid Option! Please Enter Again!\n");
                System.out.print("Yes or No? (y/n) : ");
                input = scr.nextLine();
            }
            
        }while(choice=='Z');
        return choice;
    }
    public static void modifyProd(Product[] prod){
        String prodName,temp;
        boolean found=false;
        int prodID;
        Scanner scr = new Scanner(System.in);
        int i=0,select,prodCounter=Product.getProdCounter()-Product.getRemoveProd();
        
        do{ 
            viewProd(prod);
            System.out.print("\nEnter product ID > A");   
            temp = scr.nextLine();
            
            try{
                prodID = Integer.parseInt(temp);       
            }catch(NumberFormatException e){  
                System.out.println("Invalid Product ID!");
                prodID=0;
            }
            
            if(prodID!=0){
                found = false;
                for(i=0;i<prodCounter;i++){
                    if(prod[i].getProdID()==prodID){
                        found = true;
                        break;
                    }
                } 
            }
            
            if(!found&&prodID!=0){
                System.out.println("Product ID not found!");
                prodID=0;
            }
        }while(prodID == 0);

        do{
            System.out.println("1.Product Name");
            System.out.println("2.Product Price");
            
            System.out.print("Select the item that you want to modify >");    
            temp = scr.nextLine();
            
           try{
                select = Integer.parseInt(temp);       
            }catch(NumberFormatException e){         
                select=0;
            }
            
           if(select!=1&&select!=2){
               System.out.println("Invalid Option!\n");
           }
        }while(select!=1&&select!=2);
        
        if(select==1){
            do{
                found = false;
                System.out.print("Enter new product name > ");
                prodName = scr.nextLine();
                if(prodName.length()==0){
                    found=true;
                    System.out.println("Product Name cannot be Blank!!!\n");
                }
            
                for(int y=0;y<prodCounter;y++){
                    if(prod[y].getProdName().equalsIgnoreCase(prodName)){
                        System.out.println("Product name repeated.\n");
                        found = true;
                        break;
                    }
                }
            }while(found);
           
            prod[i].setProdName(prodName.toUpperCase());
        }else{
            double price;
            System.out.print("Enter new product price > ");
            price =readDouble(0,Double.MAX_VALUE);
            prod[i].setProdPrice(price);
        }
        viewProd(prod);
       
    }
    public static Receipt[] takeOrder(Product[] prod, Order[] orderNumArray,Receipt []r,String staffID) {
        Scanner ord = new Scanner(System.in);
        int choiceOrder, prodQty = 0, i = 0;
        int productCounter = Product.getProdCounter() - Product.getRemoveProd();
        int orderCounter, continuePurchase;
        double unitPrice;
        double totalP = 0.00;
        double amtPay;
        double totalPayment=0.00;
        
        int order=0;
        Order[] o = new Order[10];
        

        do {
            orderCounter = Order.getOrderCounter();
            System.out.print("Do you want to add order? (y/n) >> ");
            String tempSpace = ord.nextLine();
            choiceOrder = checkYesNo(tempSpace);

            if (choiceOrder != 'Y') {
                System.out.println("Take Order Cancelled.\n");
            } else {
                viewProd(prod);
                System.out.println("\n");
                System.out.println("Taking Order Process Started!");
                boolean foundID;
                do {
                    System.out.print("Please enter the Product ID (Axxxx) >> A");
                    int prodID = Integer.parseInt(ord.nextLine());

                    foundID = false;
                    for (i = 0; i < productCounter; i++) {
                        if (prod[i].getProdID() == prodID) {
                            foundID = true;
                            break;
                        }
                    }

                    if (!foundID) {
                        System.out.println("Product Id Not Found!\n");
                    }

                } while (!foundID);

                boolean validQty;
                do{
                    validQty=true;
                    System.out.print("Enter Product Quantity  >> ");
                    String temp = ord.nextLine();
                    
                    try{
                        prodQty = Integer.parseInt(temp);        
                    }catch(NumberFormatException e){            
                        prodQty=0;
                    }
                    
                    if(prodQty<1){
                        System.out.println("Invalid Quantity!\n");
                        validQty=false;
                    }
                    
                }while(prodQty==0||!validQty);

                System.out.printf("Product Name : %s\t Purchase Quantity : %d\t Unit Price : %.2f\n", prod[i].getProdName(), prodQty, prod[i].getProdPrice());
                unitPrice = prod[i].getProdPrice();
                System.out.print("Confirm Purchase? (y/n) >> ");
                tempSpace = ord.nextLine();
                char confirm = checkYesNo(tempSpace);
                
                if (confirm == 'Y') {
                    orderNumArray[orderCounter] = new Order(prod[i], prod[i].getProdName(), prodQty, unitPrice, totalP);
                    System.out.println("Total       : RM" + orderNumArray[orderCounter].calcTotal());
                    totalP = orderNumArray[orderCounter].getTotalPrice();
                    o[order] = new Order(prod[i], prod[i].getProdName(), prodQty, unitPrice, totalP);
                    order+=1;
                    
                }else{
                    System.out.println("Order Cancelled.\n");
                }
            }
            
            System.out.println();
            System.out.print("Continue Purchase? (y/n) >> ");
            String temp = ord.nextLine();
            continuePurchase = checkYesNo(temp);
            
            if (continuePurchase == 'N') {
                
                for(int c=0; c<order; c++){
                
                    totalPayment += o[c].getTotalPrice();
                }
                
                if(0!=totalPayment){
                    totalP = prod[i].getProdPrice() * prodQty;
                    System.out.println("Total       : RM" + totalPayment);
                    
                    do{
                        System.out.print("Amount Paid : RM");
                        String tempPrice = ord.nextLine();

                        try{
                            amtPay = Integer.parseInt(tempPrice);        
                        }catch(NumberFormatException e){            
                            amtPay=-1;
                        }
                        
                        if(amtPay >= totalP){
                            orderNumArray[orderCounter].setAmtPaid(amtPay);
                            o[0].setAmtPaid(amtPay);
                        }
                        else{
                            System.out.println("Amount not Enough To PAY!!!!\n");
                            amtPay=-1;
                        }
                    }while(amtPay==-1);
                }
                else{
                    System.out.println("Total       : RM0.00");
                }
            }
        } while (continuePurchase == 'Y');
        
        Receipt[] receipt = Receipt(prod,o,r,staffID);
        return receipt;
    }
    public static boolean isNumber(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    public static void summaryReport(Product[] prod, Receipt []r){
        
        LocalDate today = LocalDate.now();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd MMM yyyy");
        String formatDateTime = today.format(format);
        
        
        Report[] rpt = new Report[100];
        
        int itemCount=0;
        
        for (int a=0; a<Product.getProdCounter(); a++){
            
            rpt[a] = new Report(prod[a].getProdName(), prod[a].getProdPrice());            
            itemCount+=1;
        }
  
        calcuQuantity(rpt, itemCount, r);
        
        calcuTotalPrice(rpt, itemCount);
        
        System.out.print("\n\n");
        System.out.println("\t\t\t\t\t\t - Summary Report of Daily Sales - \n");
        System.out.println("\t\t\t\t\t\t          Family Pizza\n");
        System.out.println("\t\t\t\t\t\t  B-G-7, BELLAMY, Plaza Arkadia");
        System.out.println("\t\t\t\t\t\tDesa Parkcity, 52200 Kuala Lumpur");
        System.out.println("\t\t\t\t\t\t       Tel : 03-6222 4433\n\n");
        System.out.println("Date\t\t"+ formatDateTime + "\t\t\t\t\t\t\t\t\t\tReport ID : DS0001" );
        System.out.println("=============================================================================================================================");
        System.out.println("NO.\t\tProduct Name \t\t\t Quantity \t\t\t Unit Price \t\t\t Total Price");
        System.out.println("=============================================================================================================================");
        
        int orderCount=1;
        for (int i=0; i<Product.getProdCounter(); i++) {
            if(rpt[i].getQty()!=0){
                System.out.printf("%d\t\t%s\t\t\t     %d\t\t\t\t    %.2f\t\t\t    %.2f\n", orderCount, rpt[i].getItemName(), rpt[i].getQty(), rpt[i].getUnitPrice(), rpt[i].getTotalPrice());
                orderCount++;
            }
        }
        
        
        System.out.println("------------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("TOTAL \t\t\t\t\t\t     %d\t\t\t\t\t\t\t\t    %.2f\n", calSumQty(rpt, itemCount), calSumTotal(rpt, itemCount));
        System.out.println("\n\n \t\t\t\t\t\t\t- END OF REPORT -\n\n");
        
        
        
    }
    public static void calcuQuantity(Report[] rpt, int itemC, Receipt[] r){
        
        
        int count=0;
        for(int i=0; i<r.length; i++){
            if(r[i]!=null){
                count++;
            }
        }
        
        for(int num=0; num<itemC; num++){
            
            int qty=0;
            
            for(int input=0; input<count ; input++){
                
                if(rpt[num].getItemName().compareTo(r[input].getPizza())== 0){
                                                                       //order number store to variable
                   rpt[num].setQty(r[input].getQuantity());           //set the input qty into array
                   qty+=rpt[num].getQty();                             //total up all
                   
                }
                else{
                    
                    qty+=0;
                }
            }
            
            rpt[num].setQty(qty);
        }
    }    
    public static void calcuTotalPrice(Report[] rpt, int itemC){
        
        for(int r=0; r<itemC; r++){
            
            double totalPrice=0;
            totalPrice = rpt[r].getUnitPrice()*rpt[r].getQty();
            rpt[r].setTotalPrice(totalPrice);
            
        }
        
    }
    public static int calSumQty(Report[] rpt, int itemCount){
        
        int totalqty=0;
        for(int i=0; i<itemCount; i++){
            
            totalqty+=rpt[i].getQty();
        }
        return totalqty;
        
    }
    public static double calSumTotal(Report[] rpt, int itemCount){
        double sum=0;
        for(int i=0; i<itemCount; i++){
            sum+=rpt[i].getTotalPrice();
        }
        return sum;
    }
    public static Receipt[] Receipt(Product[] prod, Order[] order, Receipt []r, String staffid){
        double sub = 0;
        int su=0;
        int countR;
        int countNo;
        String id = staffid;
        Receipt2 r2 = new Receipt2();
        Receipt []r1 = new Receipt[100];
        
        for(int j=0;j<order.length;j++){
            if(order[j]!=null){
                su++;
            }
        }
        countNo = Receipt2.getReceiptNo();
        countR = Receipt.getCount();
        System.out.printf("\n\nFamily Pizza\n");
        System.out.printf("B-G-7, BELLAMY, Plaza Arkadia\n");
        System.out.printf("Desa Parkcity, 52200 Kuala Lumpur\n");
        System.out.printf("Tel : 03-6222 4433\n");
        System.out.printf("===========================================================\n");
        LocalDateTime myDate = LocalDateTime.now(); //date&time object
        DateTimeFormatter formatDateTimeObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String formattedDate = myDate.format(formatDateTimeObj);
        System.out.println("Date & Time\t\t"+formattedDate);
        System.out.printf("Receipt No.\t\t%d\n",countNo);
        System.out.printf("Cashier\t\t\t%s\n", id);
        System.out.printf("\n");
        System.out.printf("Qty\tItem Description\tPrice(RM)\tAmount(RM)\n");
        System.out.printf("-----------------------------------------------------------\n");
        
        for (int i = 0; i < su; i++) {
            
            r[countR] = new Receipt(order[i].getName(),order[i].getQty(),order[i].getPrice(),order[i].getTotalPrice());
            
            System.out.println(r[countR].toString());
            countR = Receipt.getCount();
        }

        for(int i=0 ; i<su;i++){
            sub = r2.calSubtotal(order[i].getTotalPrice());
        }
        
        r2.setPaid(order[0].getAmtPaid());
        r2.countBalance();
        
        System.out.printf("-----------------------------------------------------------\n");
        System.out.printf("Total\t\t\t\t\t\t%.2f\n",r2.getSubtotal());
        System.out.printf("Paid\t\t\t\t\t\t%.2f\n",r2.getPaid());
        System.out.printf("Change\t\t\t\t\t\t%.2f\n\n\n",r2.getBalance());
        
        return r;
    }
}