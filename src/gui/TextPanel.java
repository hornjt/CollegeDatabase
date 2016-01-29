package gui;

import java.awt.BorderLayout;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.Border;

import model.Person;

public class TextPanel extends JPanel {
	private JTextArea textArea;
	
	public TextPanel() {
		textArea = new JTextArea();
		add(textArea);
		setLayout(new BorderLayout());
		add(new JScrollPane(textArea), BorderLayout.CENTER);
		Border outerBorder = BorderFactory.createEmptyBorder(13, 0, 7, 7);
		setBorder(outerBorder);
	}
	
	public void appendText(String text) {
		textArea.append(text);
	}
	
	public void appendDouble(Double number) {
		textArea.append(Double.toString(number));
	}
	
	public void appendObject(Person person) {
		textArea.append(person.toString());
		textArea.append("\n" + "\n");
	}
}
