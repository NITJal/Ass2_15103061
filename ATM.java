import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Scanner;


public class ATM 
{
	String accNo;
	int pin;
	int balance;
	int check=0;
	public ATM()
	{
		try
		{ 
			Scanner sc=new Scanner(System.in);
			System.out.print("\nEnter your account number:");
			accNo=sc.nextLine();
			System.out.print("\nEnter your PIN number:");
			pin=sc.nextInt();
		}
		catch(InputMismatchException e)
		{
			System.out.print("\nEnter the valid input");
		}
		catch(NumberFormatException e)
		{
			System.out.print("\nConversion not valid");
		}
	}
	void deposit(int n)
	{
		balance+=n;
	}
	void withdrawl(int n)
	{
		try{
		if(n>balance)
			throw new Exception();
		else
			balance-=n;
		}
		catch(Exception ex)
		{
			System.out.println("Insufficient balance");
		}
	}
	void display()
	{
		System.out.println("\nTotal Balance : "+this.balance);
	}
	public static void main(String args[])throws ClassNotFoundException
	{
		
		Map<String,Integer> mp=new HashMap<String,Integer>(); 
		mp.put("abcd", 1234);
		mp.put("efgh", 5678);
		mp.put("ijkl",9101);
		mp.put("mnop",1123);
		
		Scanner sc=new Scanner(System.in);
		ATM a=new ATM();
		try{
			int am,amt;
			for(Map.Entry<String,Integer> entry : mp.entrySet())
			{
				if( a.accNo.equals(entry.getKey()) && a.pin==entry.getValue())
				{
					a.check++;
					while(true)
					{
						System.out.println("\nEnter Your Choice:\n1.Deposit\n2.Withdrawl\n3.Show Balance\n4.Exit\nSelect your choice: ");
						int n=sc.nextInt();
						switch(n)
						{
						case 1:
							System.out.print("\nAmount:");
							am=sc.nextInt();
							a.deposit(am);
							break;
						case 2:
							System.out.print("\nAmount:");
							amt=sc.nextInt();
							a.withdrawl(amt);
							break;
						case 3:
							a.display();
							break;
						case 4:
							System.exit(1);
							break;
						}
					}
					
				}
			}
		}
		catch(NullPointerException e)
		{
			System.out.print("\nNo operation is performed with null string");
		}
		catch(InputMismatchException e)
		{
			System.out.print("\nEnter the valid input");
		}
		catch(NoSuchElementException e)
		{
			System.out.print("\nElement not found");
		}

		if(a.check==0)
		{
			System.out.println("\nINVALID PIN NUMBER");
		}
	}
}