package src;

import java.sql.Connection;
import java.util.Scanner;

public class Controller {
	
	Scanner scanner;
	Connection con;
	
	public Controller(Connection conn) {
		this.con = conn;
	}
	
	public void showMenu() {
		System.out.println(GUI.firstMenu());
		
		scanner = new Scanner(System.in);
        String choice = scanner.nextLine();
        
        while (!choice.equals("1") && !choice.equals("2") && !choice.equals("3")) {
        	scanner = new Scanner(System.in);
            choice = scanner.nextLine();
        }
        	
        switch(choice) {
        	case "1": GUI.employeeHiringMenu(this.con); break;
        	case "2": GUI.jobHuntingMenu(this.con); break;
        	case "3": GUI.optimalCandidatesMenu(this.con); break;
        	default: break;
        }
		
	}

}
