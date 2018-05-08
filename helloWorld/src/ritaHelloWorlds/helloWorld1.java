package ritaHelloWorlds;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;

public class helloWorld1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		ArrayList<person> allPerson = new ArrayList<person>(); 
		while(true) {
			//System.out.println(allPerson.size());
			
			System.out.println("Enter");
			System.out.println("1  for create account");
			System.out.println("2  for login");
			System.out.println("3  for delete account");
			int option = input.nextInt();
			switch(option) {
			case 1:
				System.out.println("Enter account:");
				String account = input.next();
				Boolean flag = false;
				person p = new person();
				p.setAccount(account);
				for(int i=0;i<allPerson.size();i++) {
					String temp = allPerson.get(i).getAccount();
					//System.out.println(temp);
					if(temp.equals(p.getAccount())) {
						System.out.println("in");
						flag = true;
						break;
					}
				}
				if(flag) {
					System.out.println("account has been used");
					break;
				}else {
					p.setAccount(account);
					System.out.println("Enter password:");
					String pw = input.next();
					p.setPassword(pw);
					System.out.println("Enter name:");
					String n = input.next();
					p.setName(n);
					allPerson.add(p);
					break;
				}
			case 2:
				System.out.println("Enter account:");
				account = input.next();
				for(person temp:allPerson) {
					if(temp.getAccount().equals(account)) {
						System.out.println("Enter password");
						temp.showName(input.next());
						break;
					}
				}
				System.out.println("account does not exist");
				break;
			case 3:
				System.out.println("Enter account:");
				account = input.next();
				for(person temp:allPerson) {
					if(temp.getAccount().equals(account)) {
						System.out.println("Enter password");
						if(temp.deleteAccount(input.next())) {
							allPerson.remove(allPerson.indexOf(temp));
						}
					}
				}
				System.out.println("account does not exist");
				break;
			}
		}
	}
	public static int CToF(int c) {
		int f = c*9/5+32;
		return f;
	}
}
class person{
	private String name;
	private String account;
	private String password;
	public String getAccount() {
		return this.account;
	}
	public void setAccount(String acc) {
		this.account = acc;
	}
	public void setPassword(String pw) {
		this.password = pw;
	}
	public void setName(String n) {
		this.name = n;
	}
	public Boolean deleteAccount(String pw) {
		if(pw.equals(this.password)) {
			System.out.println("bye "+this.name);
			return true;
		}else {
			System.out.println("wrong password");
			return false;
		}
	}
	public void showName(String pw) {
		if(checkPassword(pw)) {
			System.out.println("Welcome, "+this.name);
		}else {
			System.out.println("Wrong Password");
		}
	}
	Boolean checkPassword(String pw) {
		if(pw .equals(this.password)) {
			return true;
		}else {
			return false;
			}
		}
	}