package _03_To_Do_List;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class ToDoList implements ActionListener {
	 /*
	 * Create a program with five buttons, add task, view tasks, remove task, save
	 * list, and load list.
	 *
	 * When add task is clicked: Create a JOptionPane to ask the user for a task and
	 * add it to an ArrayList
	 * 
	 * When the view tasks button is clicked: show all the tasks in the list
	 * 
	 * When the remove task button is clicked: Create a JOptionPane to prompt the
	 * user for which task to remove and take it off of the list.
	 * 
	 * When the save list button is clicked: Save the list to a file
	 * 
	 * When the load list button is clicked: Create a JOptionPane to Prompt the user
	 * for the location of the file and load the list from that file
	 * 
	 * When the program starts, it should automatically load the last saved file
	 * into the list.
	 */
	JFrame frame = new JFrame("To Do List:");
	JPanel panel = new JPanel();
	JButton add = new JButton("Add Task");
	JButton view = new JButton("View Tasks");
	JButton remove = new JButton("Remove Task");
	JButton save = new JButton("Save List");
	JButton load = new JButton("Load List");
	ArrayList<String> tasks = new ArrayList<String>();
	public static void main(String[] args) {
		ToDoList tdl = new ToDoList();
		tdl.gui();
	}
	public void gui() {
		frame.add(panel);
		panel.add(add);
		panel.add(view);
		panel.add(remove);
		panel.add(save);
		panel.add(load);
		add.addActionListener(this);
		view.addActionListener(this);
		remove.addActionListener(this);
		save.addActionListener(this);
		load.addActionListener(this);
		frame.setVisible(true);
		frame.pack();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(add==e.getSource()) {
			tasks.add(JOptionPane.showInputDialog("Enter a task"));
		}
		if(view==e.getSource()) {
			JOptionPane.showMessageDialog(null, tasks);
		}
		if(remove==e.getSource()) {
			String remove = JOptionPane.showInputDialog("Enter task to remove");
			ArrayList<String> tasks2 = new ArrayList<String>();
			for (int i = 0; i < tasks.size(); i++) {
				if(!tasks.get(i).equalsIgnoreCase(remove)) {
					tasks2.add(tasks.get(i));
				}
			}
			tasks = tasks2;
		}
	}
}
