/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package transaction;

/**
 *
 * @author SHANE
 */
public class MainClass {

    public static Transaction frame1 = new Transaction();
    public static Logs frame2 = new Logs();
    public static Inventory frame3 = new Inventory();

    public static void main(String[] args) {
        frame1.setLocationRelativeTo(null);
        frame1.pack();
        frame2.setLocationRelativeTo(null);
        frame3.setLocationRelativeTo(null);

        // Only show the first one
        frame1.setVisible(true);
    }

}
