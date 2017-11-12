import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.InputMismatchException;
import java.util.Scanner;

public class AdmissionForm
{
	String name;
	String email;
	long rn;
	String address;
	String ph;
	double hsc;
	double ug;
	
	public AdmissionForm() throws IOException
	{
		try{
			InputStreamReader isr=new InputStreamReader(System.in);
			BufferedReader br=new BufferedReader(isr);
			System.out.println("Roll No.:");
			rn=Long.parseLong(br.readLine());
			System.out.println("Name:");
			name=br.readLine();
			while(true)
			{
				System.out.println("Phone Number:");
				ph=br.readLine();
				if(ph.length()==10)
				{
					
					break ;
				}
				System.out.println("Invalid");
			}
			while(true)
			{
				System.out.println("Email id:");
				email=br.readLine();
				if(email.contains("@") && email.endsWith(".com"))
				{
					break ;
				}
				System.out.println("Invalid");
			}
			System.out.println("Address:");
			address=br.readLine();
			System.out.println("HSC Marks(%):");
			hsc=Double.parseDouble(br.readLine());
			System.out.println("UG Marks(%):");
			ug=Double.parseDouble(br.readLine());
		}
		catch(NumberFormatException e)
		{
			System.out.println("Caught "+e);
		}
		catch(InputMismatchException e)
		{
			System.out.println("Caught "+e);
		}
		catch(NullPointerException e)
		{
			System.out.println("Caught "+e);
		}
	}
	void check()
	{
		if(hsc>=60 && ug>=70)
		{
			System.out.println("You are eligible for National Institute");
		}
		else
		{
			System.out.println("You are not eligible for National Institute");
		}
	}
	public static void main(String args[])
	{
		try{
		AdmissionForm obj=new AdmissionForm();
		obj.check();
		}
		catch(IOException e)
		{
			System.out.println("Caught "+e);
		}
	}
}