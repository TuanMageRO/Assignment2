package Implementation;

import Object.Node;
import Object.Train;
import Validation.checkInput;
import java.text.ParseException;

public class Menu {
    private final AVLTree trainList;
    private final checkInput input;

    public Menu() {
        trainList = new AVLTree(); // The Tree class should represent an AVL tree
        input = new checkInput();
    }

    public void run() throws ParseException {
        while (true) {
            displayMenu();
            int choice = input.getValidInteger("Enter your choice: ", 1, 12);
            switch (choice) {
                case 1:
                    trainList.loadFile("src/train_data.txt");
                    break;
                case 2:
                    Train train = createTrainFromInput();
                    trainList.insert(train);
                    break;
                case 3:
                    train = createTrainFromInput();
                    trainList.insert(train);
                    break;
                case 4:
                    trainList.inOrder();
                    break;
                case 5:
                    trainList.breadthFirst();
                    break;
                case 6:
                    trainList.saveFile("src/train_data.txt");
                    break;
                case 7:
                    String tcodeToDelete = input.getValidID("Enter tcode to delete by copying: ", trainList);
                    trainList.deleteByCopying(tcodeToDelete);
                    break;
                case 8:
                    tcodeToDelete = input.getValidID("Enter tcode to delete by merging: ", trainList);
                    trainList.deleteByCopying(tcodeToDelete);
                    break;
                case 9:
                    tcodeToDelete = input.getValidID("Enter tcode to delete by AVL deletion: ", trainList);
                    trainList.deleteByCopying(tcodeToDelete);
                    break;
                case 10:
                    String tcodeToSearch = input.getValidID("Enter tcode to search: ", trainList);
                    Train foundNode = trainList.search(tcodeToSearch);
                    if (foundNode != null) {
                        System.out.println("Found train with tcode " + tcodeToSearch + ": " + foundNode);
                    } else {
                        System.out.println("Train with tcode " + tcodeToSearch + " not found.");
                    }
                    break;

                case 11:
                    int trainCount = trainList.countTrains();
                    System.out.println("Total number of trains: " + trainCount);
                    break;
                case 12:
                    trainList.simpleBalancing();
                    break;
                default:
                    System.out.println("Exiting...");
                    return;
            }
        }
    }

    private Train createTrainFromInput() {
        return new Train(
            input.getValidID("Enter tcode: ", trainList),
            input.getValidName("Enter train name: "),
            input.getValidInteger("Enter seat: ", 1, 1000),
            input.getValidInteger("Enter booked: ", 0, 1000),
            input.getValidName("Enter departure place: "),
            input.getValidName("Enter arrival place: "),
            input.getValidTime("Enter departure time: "),
            input.getValidTime("Enter arrival time: ")
        );
    }

    private void displayMenu() {
        System.out.println("==========MENU===========");
        System.out.println("1. Load data from file");
        System.out.println("2. Input & insert data using AVL tree insertion");
        System.out.println("3. Input & insert data using AVL tree insertion");
        System.out.println("4. In-order traverse");
        System.out.println("5. Breadth-first traverse");
        System.out.println("6. In-order traverse and save to file");
        System.out.println("7. Delete by tCode (Copying)");
        System.out.println("8. Delete by tCode (Merging)");
        System.out.println("9. Delete by tCode using AVL deletion");
        System.out.println("10. Search train by tCode");
        System.out.println("11. Count number of trains");
        System.out.println("12. Simple balancing");
        System.out.println("==========================");
    }
}
