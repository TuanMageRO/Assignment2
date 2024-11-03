package Validation;

import java.util.Scanner;
import Implementation.AVLTree;
import Object.Node;
import Object.Train;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class checkInput {
    private final Scanner sc = new Scanner(System.in);
    private final String nameFormat = "[A-Za-z\\s]+";
    private final String idFormat = "[A-Z0-9]+";
    
    public int getValidInteger(String mess, int min, int max) {
        int n;
        String err = "Invalid input. Program only permits Integer in range " + min + " to " + max;
        while(true) {
            try {
                System.out.println(mess);
                n = Integer.parseInt(sc.nextLine());
                if (n < min || n > max) {
                    System.err.println(err);
                    continue;
                }
                return n;
            } catch (NumberFormatException e) {
                System.out.println(err);
            }
        }
    }
    
    public String getValidName(String mess) {
        String name;
        String err = "Invalid input. Program only permits letters and space for Train-Name/ID/Place.";
        while (true) {
            System.out.println(mess);
            name = sc.nextLine().trim();
            if (name.matches(nameFormat)) {
                return name;
            } else {
                System.err.println(err);
            }
        }
    }
    
    // Check if ID already exists in the AVLTree by searching with the tCode
    public boolean checkExistID(String id, AVLTree trainList) {
        return trainList.search(id) != null;
    }
    
    // Get a valid, unique ID that doesn’t already exist in the AVLTree
    public String getValidID(String mess, AVLTree trainList) {
        String id;
        String err = "Invalid input. Program only permits uppercase letters and digits for ID.";
        while (true) {
            System.out.println(mess);
            id = sc.nextLine().trim();
            if (id.matches(idFormat)) {
                if (!checkExistID(id, trainList)) {
                    return id;
                } else {
                    System.err.println("The Train Code is already used (unique required).");
                }
            } else {
                System.err.println(err);
            }
        }
    }
    
    public String getValidTime(String mess) {
        String time;
        while (true) {
            try {
                System.out.println(mess);
                time = sc.nextLine().trim();
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                Date d = sdf.parse(time);
                if (time.equals(sdf.format(d))) {
                    return time;
                } else {
                    System.err.println("Wrong Time input format (Year-Month-Day HH:mm:ss)");
                }
            } catch (ParseException e) {
                System.err.println("Invalid Date or Time format (ensure MM, dd, HH, mm, ss have 2 digits each).");
            }
        }
    }
}
