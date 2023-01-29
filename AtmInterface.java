import java.util.Scanner;
import java.util.*;
class Bank
{
String name;
String userName;
String password;
String accountNo;
float balance;
int transaction=0;
String transactionHistory="";

public void register()
{
Scanner sc=new Scanner(System.in);

System.out.println("=============================");
System.out.println("________Registration________");
System.out.println("=============================");
System.out.println("Enter Your Name ::");
this.name=sc.nextLine();
System.out.println("Enter Username :: ");
this.userName=sc.nextLine();
System.out.println("Enter password :: ");
this.password=sc.nextLine();
System.out.println("Enter Account Number :: ");
this.accountNo=sc.nextLine();
        System.out.println("Enter Amount you want to save into bank :: ");
        this.balance=sc.nextFloat();
System.out.println("______Sucessfully Registred !!!");
System.out.println("=======================================");
System.out.println("_________________Login________________");

}
public boolean login()
{
boolean isLogin=false;
Scanner sc=new Scanner(System.in);
while(!isLogin)
{
System.out.print("Enter username :: ");
String Username=sc.nextLine();
if(Username.equals(userName))
{
while(!isLogin)
{
System.out.print("Enter Password :: ");
String Password=sc.nextLine();
if(Password.equals(password))
{
System.out.println("Login succesful!!");
System.out.println("=======================================");
isLogin=true;
}
else
{
System.out.println("Password is incorrect");
System.out.println("=======================================");
}
}
            }
else{
System.out.println("Username is not found");
System.out.println("=======================================");
}
}
return isLogin;
}
public void withdraw()
{
System.out.println("Enter amount to withdraw ::");
Scanner sc=new Scanner(System.in);
float amount=sc.nextFloat();
try
{
if(balance>=amount)
{
transaction++;
balance-=amount;
System.out.println("Withdraw is succesful");
System.out.println("=======================================");
String str=amount+"Rs withdrawed\n";
transactionHistory=transactionHistory.concat(str);
}
else{
System.out.println("Insufficient balance");
System.out.println("=======================================");
}
}
catch(Exception e)
{
}
}
public void deposit()
{
System.out.println("Enter amount to Deposit :: ");
Scanner sc=new Scanner(System.in);
float amount=sc.nextFloat();
try
{
if(amount<=10000)
{
transaction++;
balance+=amount;
System.out.println("Deposit is succesful!!");
System.out.println("=======================================");
String str=amount+"Rs deposit\n";
transactionHistory=transactionHistory.concat(str);
}
else{
System.out.println("Deposit Limit is 10,000.00 !");
System.out.println("=======================================");
}
}
catch(Exception e)
{
}
}
public void transfer()
{
Scanner sc=new Scanner(System.in);
System.out.println("Enter receipent's name :: ");
String receipent =sc.nextLine();
System.out.println("Enter amount to transfer :: ");
float amount=sc.nextFloat();
try
{
if(balance>=amount)
{
if(amount<50000f)
{
transaction++;
balance-=amount;
System.out.println("Succesful Transefer to " + receipent);
System.out.println("=======================================");
String str=amount+"Rs transferd to"+receipent +"\n";
transactionHistory=transactionHistory.concat(str);
}
else{
System.out.println("Sorry you can transfer amount upto 50000.00");
System.out.println("=======================================");
}
}
else{
System.out.println("Insufficient balance");
System.out.println("=======================================");
}

}
catch(Exception e)
{

}
}
public void checkBalance()
{
System.out.println("=======================================");
System.out.println("Account Balance is :: "+balance+"Rs");
System.out.println("=======================================");
}
public void  transHistory()
{
if(transaction ==0)
{
System.out.println("Empty");
System.out.println("=======================================");

}
else{
System.out.println("=======================================");
System.out.println(transactionHistory);
System.out.println("=======================================");
}
}
}
public class AtmInterface
{
public static void main(String[] args)
{
Bank b=new Bank();
Scanner sc=new Scanner(System.in);
System.out.println("===================================================================");
System.out.println("________________________Welcome to ATM System_____________________");
System.out.println("===================================================================");
System.out.println("1 :: Register");
System.out.println("2 :: Quit");
System.out.println("Enter your choice >>>");
int choice=sc.nextInt();
if(choice==1)
{
b.register();
while(true)
{
if(b.login())
{
boolean isFinished=false;
while(!isFinished)
{
System.out.println("1: Withdraw Money ");
System.out.println("2: Deposit Money ");
System.out.println("3: Transfer amount ");
System.out.println("4: Check Bank Balance");
System.out.println("5: TransHistory");
System.out.println("6: Quit");
System.out.println("Enter one option frome above");
int c=sc.nextInt();
switch(c)
{
case 1:
b.withdraw();
break;
case 2:
b.deposit();
break;
case 3:
b.transfer();
break;
case 4:
b.checkBalance();
break;
case 5:
b.transHistory();
break;
case 6:
System.exit(0);
default:
System.out.println("Enter correct option");
}
}
}
else
{
System.exit(0);
}
}
}
else
{
System.exit(0);
}
}
}