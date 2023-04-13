import java.util.ArrayList;

import javax.swing.JOptionPane;

public class App {
    static ArrayList<Object> todolist = new ArrayList<Object>();

    public static void Start() {
        String mess = "Please choose";
        mess += "\n******************\n";
        mess += "\n | 1 | List ";
        mess += "\n | 2 | Add ";
        mess += "\n | 3 | Delete ";
        mess += "\n | 0 or Cancel | Exit ";

        String choose = JOptionPane.showInputDialog(null, mess);
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
            case "2":
                Add();
                break;
            case "3":
                delete();
                break;
            default:
                break;
        }
    }

    public static void list() {
        String messageList = "ToDoList";
        messageList += "\n******************\n";
        for (int i = 0; i < todolist.size(); i++) {
            messageList += "[" + i + "]" + todolist.get(i) + "\n";
        }
        messageList += "There are  " + todolist.size() + " entries in total.";
        message(messageList);
        App.Start();
    }

    public static void Add() {
        String titleAdd = JOptionPane.showInputDialog(null, "Please enter the title");
        if (titleAdd != null && !titleAdd.equals("")) {
            if (todolist.indexOf(titleAdd) >= 0) {
                JOptionPane.showMessageDialog(null, "Saved data entry");
                Add();
            } else {
                todolist.add(titleAdd);
                JOptionPane.showMessageDialog(null, "Added data");
                App.Start();
            }
        }
    }

    public static void delete() {
        String deleteMessage = JOptionPane.showInputDialog(null, "Please enter the index of the wiper");
        if (deleteMessage != null && !deleteMessage.equals("")) {
            if (todolist.indexOf(deleteMessage) >= 0) {
                todolist.remove(todolist.indexOf(deleteMessage));
                JOptionPane.showMessageDialog(null, "Deleted data");
                App.Start();
            } else {
                JOptionPane.showMessageDialog(null, "Data entry not registered in the system");
                delete();
            }
        }
    }

    public static void message(String messageList) {
        JOptionPane.showMessageDialog(null, messageList);
    }

    public static void exit() {
        int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want a exit? ");
        if (confirm == 0) {
            System.exit(0);
        } else {
            App.Start();
        }
    }

    public static void main(String[] args) throws Exception {
        App.Start();
    }
}
