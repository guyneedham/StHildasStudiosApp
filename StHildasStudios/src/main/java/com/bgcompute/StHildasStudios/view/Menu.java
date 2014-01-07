package com.bgcompute.StHildasStudios.view;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.KeyStroke;

import com.bgcompute.StHildasStudios.controller.DClassController;
import com.bgcompute.StHildasStudios.controller.SchoolController;
import com.bgcompute.StHildasStudios.controller.StudentController;
import com.bgcompute.StHildasStudios.controller.TermController;

public class Menu implements ActionListener {

	private JDesktopPane desk;
	private SchoolController shc;
	private StudentController stc;
	private TermController tc;
	private DClassController dc;
	private DisplayStudents dispStudents;

	public Menu(JDesktopPane d, SchoolController shc, StudentController stc, TermController tc, DClassController dc){
		this.desk = d;
		this.shc = shc;
		this.stc = stc;
		this.tc = tc;
		this.dc = dc;
		dispStudents = new DisplayStudents(shc, dc, stc, tc);
	}

	public JMenuBar getMenu(){
		JMenuBar menubar = new JMenuBar();

		JMenu file = new JMenu("File");
		file.setMnemonic(KeyEvent.VK_F);

		JMenu school = schoolMenu();
		JMenu term = termMenu();
		JMenu dclass = classMenu();        

		JMenuItem eMenuItem = new JMenuItem("Exit");
		eMenuItem.setMnemonic(KeyEvent.VK_E);
		eMenuItem.setToolTipText("Exit application");
		eMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				System.exit(0);
			}
		});

		file.add(eMenuItem);

		menubar.add(file);
		menubar.add(school);
		menubar.add(term);
		menubar.add(dclass);	

		return menubar;
	}

	public void actionPerformed(ActionEvent e) {
		if ("ageSortDescSchool".equals(e.getActionCommand())) { //new
			schoolAgeSortDescFrame();
		}
		if("ageSortAscSchool".equals(e.getActionCommand())){
			schoolAgeSortAscFrame();
		}
		else { //quit
			quit();
		}
	}
	
	private void schoolAgeSortAscFrame() {
		JInternalFrame iFrame = new JInternalFrame("School, age sorted (asc)");
		 iFrame.setResizable(true);
         iFrame.setClosable(true);
         iFrame.setIconifiable(true);
         iFrame.setSize(new Dimension(600, 300));
         iFrame.setLocation(0, 0);
         iFrame.getContentPane().add( dispStudents.ageSortSchoolAsc() );
         iFrame.setMaximizable(true);
         iFrame.setResizable(true);
         iFrame.setVisible(true);
         desk.add(iFrame);
		try {
			iFrame.setSelected(true);
		} catch (java.beans.PropertyVetoException e) {}
	}

	protected void quit() {
        System.exit(0);
    }

	protected void schoolAgeSortDescFrame() {
		 JInternalFrame iFrame = new JInternalFrame("School, age sorted (desc)");
         iFrame.setResizable(true);
         iFrame.setClosable(true);
         iFrame.setIconifiable(true);
         //LayoutManager manager = new GridLayout(0,1);
		iFrame.setSize(new Dimension(600, 300));
         //iFrame.setLayout(manager );
         iFrame.setLocation(0, 0);

         //iFrame.getContentPane().setLayout(new BorderLayout());
         //JTable table = dispStudents.ageSortSchoolDesc();
         //JScrollPane scrollPane = new JScrollPane(table);
         iFrame.getContentPane().add( dispStudents.ageSortSchoolDesc() );
         iFrame.setMaximizable(true);
         iFrame.setResizable(true);
         iFrame.setVisible(true);
         desk.add(iFrame);
		try {
			iFrame.setSelected(true);
		} catch (java.beans.PropertyVetoException e) {}
	}

	private JMenu schoolMenu(){
		JMenu school = new JMenu("School");
		school.setMnemonic(KeyEvent.VK_S);

		JMenu viewStudents = new JMenu("View Students");

		JMenuItem ageDesc = new JMenuItem("Age sort (descending)");
		ageDesc.setMnemonic(KeyEvent.VK_D);
		ageDesc.setAccelerator(KeyStroke.getKeyStroke(
				KeyEvent.VK_D, ActionEvent.ALT_MASK));
		ageDesc.setActionCommand("ageSortDescSchool");
		ageDesc.addActionListener(this);
		viewStudents.add(ageDesc);

		JMenuItem ageAsc = new JMenuItem("Age sort (ascending)");
		ageAsc.setMnemonic(KeyEvent.VK_A);
		ageAsc.setAccelerator(KeyStroke.getKeyStroke(
				KeyEvent.VK_A, ActionEvent.ALT_MASK));
		ageAsc.setActionCommand("ageSortAscSchool");
		ageAsc.addActionListener(this);
		viewStudents.add(ageAsc);        

		school.add(viewStudents);

		JMenuItem newStudent = new JMenuItem("New Student");
		newStudent.setToolTipText("Add a student to the school");
		school.add(newStudent);
		
		JMenuItem modStudent = new JMenuItem("Modify Student");
		school.add(modStudent);

		JMenuItem delStudent = new JMenuItem("Delete Student");
		delStudent.setToolTipText("Delete a student from the school");
		school.add(delStudent);

		return school;
	}

	private JMenu termMenu(){
		JMenu term = new JMenu("Term");
		term.setMnemonic(KeyEvent.VK_T);

		JMenuItem viewTerms = new JMenuItem("View all terms");
		term.add(viewTerms);

		JMenuItem newTerm = new JMenuItem("New term");
		term.add(newTerm);
		
		JMenuItem modTerm = new JMenuItem("Modify term");
		term.add(modTerm);

		JMenuItem delTerm = new JMenuItem("Delete term");
		term.add(delTerm);

		JMenuItem currTerm = new JMenuItem("Change current term");
		term.add(currTerm);

		JMenuItem rollOverTerm = new JMenuItem("Rollover a term");
		rollOverTerm.setToolTipText("Rollover students and classes from one term to another");
		term.add(rollOverTerm);

		return term;
	}

	private JMenu classMenu(){
		JMenu dclass = new JMenu("Class");  
		dclass.setMnemonic(KeyEvent.VK_C);

		JMenuItem viewClasses = new JMenuItem("View all classes");
		dclass.add(viewClasses);

		JMenuItem newClass = new JMenuItem("Create a new class");
		dclass.add(newClass);
		
		JMenuItem modClass = new JMenuItem("Modify a class");
		dclass.add(modClass);

		JMenuItem remClass = new JMenuItem("Delete a class");
		dclass.add(remClass);

		JMenuItem migrateClass = new JMenuItem("Migrate a class");
		migrateClass.setToolTipText("Migrate students from one class to another");
		dclass.add(migrateClass);

		return dclass;
	}

}
