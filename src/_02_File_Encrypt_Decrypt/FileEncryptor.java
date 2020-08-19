package _02_File_Encrypt_Decrypt;

import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

public class FileEncryptor {
	/*
	 * Encryption is the process of encoding a message or information in such a way
	 * that only authorized parties can access it and those who are not authorized
	 * cannot.
	 *
	 * A simple shift cipher works by shifting the letters of a message down based
	 * on a key. If our key is 4 then:
	 * 
	 * a b c d e f g h i j k l m n o p q r s t u v w x y z
	 * 
	 * becomes:
	 *
	 * e f g h i j k l m n o p q r s t u v w x y z a b c d
	 * 
	 * "Hello World" changes to "Lipps Asvph"
	 *
	 * Create a program that takes a message and a key from the user. Use the key to
	 * shift each letter in the users input and save the final result to a file.
	 */
	public static void main(String[] args) {
		int key = Integer.parseInt(JOptionPane.showInputDialog("Enter an Ecryption Key"));
		String message = JOptionPane.showInputDialog("Enter a message");
		String blank = "";
		for (int i = 0; i < message.length(); i++) {
			if (message.charAt(i) == ' ') {
				blank += message.charAt(i);
			} else if (message.charAt(i) + key > 122) {
				int num = message.charAt(i);
				for (int j = 0; j < key; j++) {
					if(num>122) {
					num = 97;
					}
					num++;
				}
				blank += (char) (num);
			} else {
				blank += (char) (message.charAt(i) + key);
			}
		}
		System.out.println(blank);
		try {
			FileWriter fw = new FileWriter("C:/Users/Owner/Documents/Encryption.txt");
			
			fw.write(blank);

			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
