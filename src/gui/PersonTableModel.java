package gui;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import model.AdjunctFaculty;
import model.Faculty;
import model.FullTimeFaculty;
import model.FullTimeStudent;
import model.PartTimeStudent;
import model.Person;
import model.Student;

public class PersonTableModel extends AbstractTableModel {

	private List<Person> db;

	private String[] colNames = {"Type", "Name", "ID", "Phone", "Address", "Zip Code",
			"Gender", "Campus", "Major/Dept", "GPA", "Tuition", "Credits", "Pay" };

	public PersonTableModel() {

	}

	@Override
	public String getColumnName(int column) {

		return colNames[column];
	}

	public void setData(List<Person> db) {
		this.db = db;
	}

	public int getColumnCount() {
		return colNames.length;
	}

	@Override
	public int getRowCount() {
		return db.size();
	}

	@Override
	public Object getValueAt(int row, int col) {
		Person person = db.get(row);
		
		switch (col) {
		case 0 :
			if (person instanceof FullTimeStudent)
				return "Full Time Student";
			else if (person instanceof PartTimeStudent)
				return "Part Time Student";
			else if (person instanceof FullTimeFaculty)
				return "Full Time Faculty";
			else
				return "Adjunct Faculty";
		case 1:
			return person.getName();
		case 2:
			return person.getIdNumber();
		case 3:
			return person.getPhoneNum();
		case 4:
			return person.getAddress();
		case 5:
			return person.getZipCode();
		case 6:
			return person.getGender();
		case 7:
			return person.getCampus();
		case 8:
			if (person instanceof Student)
				return ((Student) person).getMajor();
			else if (person instanceof Faculty) 
				return ((Faculty) person).getDepartment();
			 else
				return "N/A";
		case 9:
			if (person instanceof Student) {
				return ((Student) person).getGpa();
			} else
				return "N/A";
		case 10:
			if (person instanceof FullTimeStudent)
				return ((FullTimeStudent) person).getTuition();
			else
				return "N/A";
		case 11:
			if (person instanceof PartTimeStudent)
				return ((PartTimeStudent) person).getCredits();
			else if (person instanceof AdjunctFaculty)
				return ((AdjunctFaculty) person).getCredits();
			else
				return "N/A";
		case 12:
			if (person instanceof FullTimeFaculty)
				return ((FullTimeFaculty) person).getPay();
			else
				return "N/A";
		}
		return null;

	}

}
