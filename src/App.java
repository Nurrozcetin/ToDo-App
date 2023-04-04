import java.util.ArrayList;

import javax.swing.JOptionPane;

public class App {
    ArrayList<Object> todolist = new ArrayList<Object>();

    public static void main(String[] args) throws Exception {
        App app = new App();
        app.Start();
    }

    private static void Start() {
        String message = "Please choose";
        message = "\n******************\n";
        message = "\n | 1 | List ";
        message = "\n | 2 | Add ";
        message = "\n | 3 | Delete ";
        message = "\n | 0 or Cancel | Exit ";

        String choose = JOptionPane.showInputDialog(null, message);
        if (choose == null) {
            choose = "0";
        } else if (choose.equals("") || choose.matches("[^0-9]+")) {
            Start();
        }

        switch (choose) {
            case "0":
                exit();
                break;
            case "1":
                list();
                break;
            default:
                break;
        }
    }

    private static void list() {
    }

    private static void exit() {
        int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want a exit? ");
        if (confirm == 0) {
            System.exit(0);
        } else {
            Start();
        }
    }
}
