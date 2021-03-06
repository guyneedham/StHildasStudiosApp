package com.bgcompute.StHildasStudios.view;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.JComponent;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
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
	private NewStudentView newStudentView;
	private ModifyStudentView modifyStudentView;
	private DeleteStudent deleteStudent;
	private ViewAllTerms viewTerms;
	private DeleteTermView deleteTerm;
	private ModifyTermView modifyTerm;
	private NewTermView newTermView;
	private ViewAllClasses viewClasses;
	private NewClassView newClass;
	private ModifyClassView modClass;
	private DeleteClassView delClass;
	private TermClassControlView termClass;
	private StudentsInClass studentsInClass;
	private MigrateData migrator;
	private LocationSortView locationSorter;
	private BillingView billView;
	private MarkPaidView markPaidView;
	private ShowNotPaidView showNotPaidView;
	

	public Menu(JDesktopPane d, SchoolController shc, StudentController stc, TermController tc, DClassController dc){
		this.desk = d;
		this.shc = shc;
		this.stc = stc;
		this.tc = tc;
		this.dc = dc;
		dispStudents = new DisplayStudents(shc, dc, stc, tc);
		newStudentView = new NewStudentView(stc);
		modifyStudentView = new ModifyStudentView(stc);
		deleteStudent = new DeleteStudent(stc);
		newTermView = new NewTermView(tc);
		viewTerms = new ViewAllTerms(shc);
		deleteTerm = new DeleteTermView(tc);
		modifyTerm = new ModifyTermView(tc);
		viewClasses = new ViewAllClasses(dc);
		newClass = new NewClassView(dc);
		modClass = new ModifyClassView(dc);
		delClass = new DeleteClassView(dc);
		termClass = new TermClassControlView(tc);
		studentsInClass = new StudentsInClass(dc);
		migrator = new MigrateData(tc,dc);
		locationSorter = new LocationSortView(dc,shc);
		billView = new BillingView(tc,stc);
		markPaidView = new MarkPaidView(tc);
		showNotPaidView = new ShowNotPaidView(tc);
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
		if ("ageSortDescSchool".equals(e.getActionCommand())) {
			schoolAgeSortDescFrame();
		}
		if("ageSortAscSchool".equals(e.getActionCommand())){
			schoolAgeSortAscFrame();
		}
		if ("newStudent".equals(e.getActionCommand())){
			newStudent();
		}
		if ("modStudent".equals(e.getActionCommand())){
			modStudent();
		}
		if("delStudent".equals(e.getActionCommand())){
			delStudent();
		}
		if("newTerm".equals(e.getActionCommand())){
			newTerm();
		}
		if("viewTerms".equals(e.getActionCommand())){
			viewTerms();
		}
		if("delTerm".equals(e.getActionCommand())){
			delTerms();
		}
		if("modTerm".equals(e.getActionCommand())){
			modTerm();
		}
		if("viewClasses".equals(e.getActionCommand())){
			viewClasses();
		}
		if("newClass".equals(e.getActionCommand())){
			newClass();
		}
		if("modClass".equals(e.getActionCommand())){
			modClass();
		}
		if("remClass".equals(e.getActionCommand())){
			remClass();
		}
		if("termClass".equals(e.getActionCommand())){
			addTermToClass();
		}
		if("remTermClass".equals(e.getActionCommand())){
			remTermFromClass();
		}
		if("studentsInClassAgeDesc".equals(e.getActionCommand())){
			studentsInClassAgeDesc();
		}
		if("studentsInClassAgeAsc".equals(e.getActionCommand())){
			studentsInClassAgeAsc();
		}
		if("studentToClass".equals(e.getActionCommand())){
			studentToClass();
		}
		if("remStudentClass".equals(e.getActionCommand())){
			remStudentFromClass();
		}
		if("migrateClass".equals(e.getActionCommand())){
			migrateClass();
		}
		if("rollOverTerm".equals(e.getActionCommand())){
			migrateTerm();
		}
		if("locationSortSchool".equals(e.getActionCommand())){
			locationSortSchool();
		}
		if("locationSortClass".equals(e.getActionCommand() )){
			locationSortClass();
		}
		if("billGen".equals(e.getActionCommand())){
			billGen();
		}
		if("notPaid".equals(e.getActionCommand())){
			notPaid();
		}
		if("markPaid".equals(e.getActionCommand())){
			markPaid();
		}
	}
	
	public void notPaid(){
		JInternalFrame iFrame = new JInternalFrame("Show Outstanding Payments");
		iFrame.setResizable(true);
        iFrame.setClosable(true);
        iFrame.setIconifiable(true);
        iFrame.setSize(new Dimension(600,600));
        iFrame.setLocation(0, 0);
        iFrame.getContentPane().add( showNotPaidView.showNotPaid() );
        iFrame.setMaximizable(true);
        iFrame.setResizable(true);
        iFrame.setVisible(true);
        desk.add(iFrame);
		try {
			iFrame.setSelected(true);
		} catch (java.beans.PropertyVetoException e) {}
	}
	
	public void markPaid(){
		JInternalFrame iFrame = new JInternalFrame("Mark as Paid");
		iFrame.setResizable(true);
        iFrame.setClosable(true);
        iFrame.setIconifiable(true);
        iFrame.setSize(new Dimension(300,300));
        iFrame.setLocation(0, 0);
        iFrame.getContentPane().add( markPaidView.markPaid() );
        iFrame.setMaximizable(true);
        iFrame.setResizable(true);
        iFrame.setVisible(true);
        desk.add(iFrame);
		try {
			iFrame.setSelected(true);
		} catch (java.beans.PropertyVetoException e) {}
	}
	
	public JInternalFrame billingFrame;
	
	public void billGen(){
		billingFrame = new JInternalFrame("Generate Bill");
		billingFrame.setResizable(true);
		billingFrame.setClosable(true);
		billingFrame.setIconifiable(true);
		billingFrame.setSize(new Dimension(700,700));
		billingFrame.setLocation(0, 0);
		billingFrame.getContentPane().add( billView.makeBill() );
		billingFrame.setMaximizable(true);
		billingFrame.setResizable(true);
		billingFrame.setVisible(true);
		
		JMenuBar menu = new JMenuBar();
		
        JMenu file = new JMenu("File");
        
        JMenuItem save = new JMenuItem("Save Bill");
        //JPanel panel = (JPanel) iFrame.getComponent(0);
        save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				billingFrame.setJMenuBar(null);
				JComponent panel = (JComponent) billingFrame.getComponent(0);
				JInternalFrame saveBill = new JInternalFrame("Save...");
				saveBill.setResizable(true);
				saveBill.setClosable(true);
				saveBill.setIconifiable(true);
				saveBill.setSize(new Dimension(600,200));
				saveBill.setLocation(0, 0);
				SaveBillView saveBillView = new SaveBillView(panel);
				saveBill.getContentPane().add( saveBillView.saveBox() );
				saveBill.setMaximizable(true);
				saveBill.setResizable(true);
				saveBill.setVisible(true);
				desk.add(saveBill);
				try {
					saveBill.setSelected(true);
				} catch (java.beans.PropertyVetoException e) {}
			}
		});
        file.add(save);
        file.setMnemonic(KeyEvent.VK_F);
        menu.add(file);
        billingFrame.setJMenuBar(menu);
        desk.add(billingFrame);
		try {
			billingFrame.setSelected(true);
		} catch (java.beans.PropertyVetoException e) {}
	}
	
	public void locationSortClass(){
		JInternalFrame iFrame = new JInternalFrame("Location Sort Class");
		iFrame.setResizable(true);
        iFrame.setClosable(true);
        iFrame.setIconifiable(true);
        iFrame.setSize(new Dimension(600,600));
        iFrame.setLocation(0, 0);
        iFrame.getContentPane().add( locationSorter.sortClass() );
        iFrame.setMaximizable(true);
        iFrame.setResizable(true);
        iFrame.setVisible(true);
        desk.add(iFrame);
		try {
			iFrame.setSelected(true);
		} catch (java.beans.PropertyVetoException e) {}
	}
	
	public void locationSortSchool(){
		JInternalFrame iFrame = new JInternalFrame("Location Sort School");
		iFrame.setResizable(true);
        iFrame.setClosable(true);
        iFrame.setIconifiable(true);
        iFrame.setSize(new Dimension(600,600));
        iFrame.setLocation(0, 0);
        iFrame.getContentPane().add( locationSorter.sortSchool() );
        iFrame.setMaximizable(true);
        iFrame.setResizable(true);
        iFrame.setVisible(true);
        desk.add(iFrame);
		try {
			iFrame.setSelected(true);
		} catch (java.beans.PropertyVetoException e) {}
	}
	
	public void migrateTerm(){
		JInternalFrame iFrame = new JInternalFrame("Rollover a Term");
		iFrame.setResizable(true);
        iFrame.setClosable(true);
        iFrame.setIconifiable(true);
        iFrame.setSize(new Dimension(600,600));
        iFrame.setLocation(0, 0);
        iFrame.getContentPane().add( migrator.migrateTerm() );
        iFrame.setMaximizable(true);
        iFrame.setResizable(true);
        iFrame.setVisible(true);
        desk.add(iFrame);
		try {
			iFrame.setSelected(true);
		} catch (java.beans.PropertyVetoException e) {}
	}
	
	public void migrateClass(){
		JInternalFrame iFrame = new JInternalFrame("Migrate a Class");
		iFrame.setResizable(true);
        iFrame.setClosable(true);
        iFrame.setIconifiable(true);
        iFrame.setSize(new Dimension(600,600));
        iFrame.setLocation(0, 0);
        iFrame.getContentPane().add( migrator.migrateClass() );
        iFrame.setMaximizable(true);
        iFrame.setResizable(true);
        iFrame.setVisible(true);
        desk.add(iFrame);
		try {
			iFrame.setSelected(true);
		} catch (java.beans.PropertyVetoException e) {}
	}
	
	private void remStudentFromClass(){
		JInternalFrame iFrame = new JInternalFrame("Remove Student from Class");
		iFrame.setResizable(true);
        iFrame.setClosable(true);
        iFrame.setIconifiable(true);
        iFrame.setSize(new Dimension(600,600));
        iFrame.setLocation(0, 0);
        iFrame.getContentPane().add( studentsInClass.removeStudent() );
        iFrame.setMaximizable(true);
        iFrame.setResizable(true);
        iFrame.setVisible(true);
        desk.add(iFrame);
		try {
			iFrame.setSelected(true);
		} catch (java.beans.PropertyVetoException e) {}	
	}
		
	private void studentToClass() {
		JInternalFrame iFrame = new JInternalFrame("Add Student to Class");
		iFrame.setResizable(true);
        iFrame.setClosable(true);
        iFrame.setIconifiable(true);
        iFrame.setSize(new Dimension(600,600));
        iFrame.setLocation(0, 0);
        iFrame.getContentPane().add( studentsInClass.addStudent() );
        iFrame.setMaximizable(true);
        iFrame.setResizable(true);
        iFrame.setVisible(true);
        desk.add(iFrame);
		try {
			iFrame.setSelected(true);
		} catch (java.beans.PropertyVetoException e) {}	
		
	}

	private void studentsInClassAgeAsc() {
		JInternalFrame iFrame = new JInternalFrame("Students in Class sorted by Age Order (Asc)");
		iFrame.setResizable(true);
        iFrame.setClosable(true);
        iFrame.setIconifiable(true);
        iFrame.setSize(new Dimension(600,600));
        iFrame.setLocation(0, 0);
        iFrame.getContentPane().add( studentsInClass.ageAsc() );
        iFrame.setMaximizable(true);
        iFrame.setResizable(true);
        iFrame.setVisible(true);
        desk.add(iFrame);
		try {
			iFrame.setSelected(true);
		} catch (java.beans.PropertyVetoException e) {}	
		
	}

	private void studentsInClassAgeDesc() {
		JInternalFrame iFrame = new JInternalFrame("Students in Class sorted by Age Order (Desc)");
		iFrame.setResizable(true);
        iFrame.setClosable(true);
        iFrame.setIconifiable(true);
        iFrame.setSize(new Dimension(600,600));
        iFrame.setLocation(0, 0);
        iFrame.getContentPane().add( studentsInClass.ageDesc() );
        iFrame.setMaximizable(true);
        iFrame.setResizable(true);
        iFrame.setVisible(true);
        desk.add(iFrame);
		try {
			iFrame.setSelected(true);
		} catch (java.beans.PropertyVetoException e) {}	
		
	}

	private void remTermFromClass() {
		JInternalFrame iFrame = new JInternalFrame("Remove Term from Class");
		iFrame.setResizable(true);
        iFrame.setClosable(true);
        iFrame.setIconifiable(true);
        iFrame.setSize(new Dimension(300, 200));
        iFrame.setLocation(0, 0);
        iFrame.getContentPane().add( termClass.remTerm() );
        iFrame.setMaximizable(true);
        iFrame.setResizable(true);
        iFrame.setVisible(true);
        desk.add(iFrame);
		try {
			iFrame.setSelected(true);
		} catch (java.beans.PropertyVetoException e) {}	
		
	}

	private void addTermToClass() {
		JInternalFrame iFrame = new JInternalFrame("Add Term to Class");
		iFrame.setResizable(true);
        iFrame.setClosable(true);
        iFrame.setIconifiable(true);
        iFrame.setSize(new Dimension(300, 200));
        iFrame.setLocation(0, 0);
        iFrame.getContentPane().add( termClass.addTerm() );
        iFrame.setMaximizable(true);
        iFrame.setResizable(true);
        iFrame.setVisible(true);
        desk.add(iFrame);
		try {
			iFrame.setSelected(true);
		} catch (java.beans.PropertyVetoException e) {}	
		
	}

	private void remClass(){
		JInternalFrame iFrame = new JInternalFrame("Delete Class");
		iFrame.setResizable(true);
        iFrame.setClosable(true);
        iFrame.setIconifiable(true);
        iFrame.setSize(new Dimension(600, 600));
        iFrame.setLocation(0, 0);
        iFrame.getContentPane().add( delClass.delClass() );
        iFrame.setMaximizable(true);
        iFrame.setResizable(true);
        iFrame.setVisible(true);
        desk.add(iFrame);
		try {
			iFrame.setSelected(true);
		} catch (java.beans.PropertyVetoException e) {}	
	}
	
	private void modClass() {
		JInternalFrame iFrame = new JInternalFrame("Modify Class");
		iFrame.setResizable(true);
        iFrame.setClosable(true);
        iFrame.setIconifiable(true);
        iFrame.setSize(new Dimension(600, 600));
        iFrame.setLocation(0, 0);
        iFrame.getContentPane().add( modClass.modClass() );
        iFrame.setMaximizable(true);
        iFrame.setResizable(true);
        iFrame.setVisible(true);
        desk.add(iFrame);
		try {
			iFrame.setSelected(true);
		} catch (java.beans.PropertyVetoException e) {}	
		
	}

	private void newClass() {
		JInternalFrame iFrame = new JInternalFrame("Create New Class");
		iFrame.setResizable(true);
        iFrame.setClosable(true);
        iFrame.setIconifiable(true);
        iFrame.setSize(new Dimension(600, 600));
        iFrame.setLocation(0, 0);
        iFrame.getContentPane().add( newClass.makeNewClass() );
        iFrame.setMaximizable(true);
        iFrame.setResizable(true);
        iFrame.setVisible(true);
        desk.add(iFrame);
		try {
			iFrame.setSelected(true);
		} catch (java.beans.PropertyVetoException e) {}	
		
	}

	private void viewClasses() {
		JInternalFrame iFrame = new JInternalFrame("View All Classes");
		iFrame.setResizable(true);
        iFrame.setClosable(true);
        iFrame.setIconifiable(true);
        iFrame.setSize(new Dimension(600, 600));
        iFrame.setLocation(0, 0);
        iFrame.getContentPane().add( viewClasses.viewAllClasses() );
        iFrame.setMaximizable(true);
        iFrame.setResizable(true);
        iFrame.setVisible(true);
        desk.add(iFrame);
		try {
			iFrame.setSelected(true);
		} catch (java.beans.PropertyVetoException e) {}	
		
	}

	private void modTerm() {
		JInternalFrame iFrame = new JInternalFrame("Modify Term");
		iFrame.setResizable(true);
        iFrame.setClosable(true);
        iFrame.setIconifiable(true);
        iFrame.setSize(new Dimension(600, 600));
        iFrame.setLocation(0, 0);
        iFrame.getContentPane().add( modifyTerm.modifyTerm() );
        iFrame.setMaximizable(true);
        iFrame.setResizable(true);
        iFrame.setVisible(true);
        desk.add(iFrame);
		try {
			iFrame.setSelected(true);
		} catch (java.beans.PropertyVetoException e) {}
		
	}

	private void delTerms() {
		JInternalFrame iFrame = new JInternalFrame("Delete Term");
		iFrame.setResizable(true);
        iFrame.setClosable(true);
        iFrame.setIconifiable(true);
        iFrame.setSize(new Dimension(400, 200));
        iFrame.setLocation(0, 0);
        iFrame.getContentPane().add( deleteTerm.delTerm() );
        iFrame.setMaximizable(true);
        iFrame.setResizable(true);
        iFrame.setVisible(true);
        desk.add(iFrame);
		try {
			iFrame.setSelected(true);
		} catch (java.beans.PropertyVetoException e) {}
		
	}

	private void viewTerms() {
		JInternalFrame iFrame = new JInternalFrame("All Terms");
		 iFrame.setResizable(true);
        iFrame.setClosable(true);
        iFrame.setIconifiable(true);
        iFrame.setSize(new Dimension(600, 300));
        iFrame.setLocation(0, 0);
        iFrame.getContentPane().add( viewTerms.viewTerms() );
        iFrame.setMaximizable(true);
        iFrame.setResizable(true);
        iFrame.setVisible(true);
        desk.add(iFrame);
		try {
			iFrame.setSelected(true);
		} catch (java.beans.PropertyVetoException e) {
			e.printStackTrace();
		}
		
	}

	private void newTerm() {
		JInternalFrame iFrame = new JInternalFrame("New Term");
		iFrame.setResizable(true);
        iFrame.setClosable(true);
        iFrame.setIconifiable(true);
        iFrame.setSize(new Dimension(400, 400));
        iFrame.setLocation(0, 0);
        iFrame.getContentPane().add( newTermView.newTerm() );
        iFrame.setMaximizable(true);
        iFrame.setResizable(true);
        iFrame.setVisible(true);
        desk.add(iFrame);
		try {
			iFrame.setSelected(true);
		} catch (java.beans.PropertyVetoException e) {}
		
	}

	private void delStudent() {
		JInternalFrame iFrame = new JInternalFrame("Delete Student");
		iFrame.setResizable(true);
        iFrame.setClosable(true);
        iFrame.setIconifiable(true);
        iFrame.setSize(new Dimension(400, 200));
        iFrame.setLocation(0, 0);
        iFrame.getContentPane().add( deleteStudent.delStudent() );
        iFrame.setMaximizable(true);
        iFrame.setResizable(true);
        iFrame.setVisible(true);
        desk.add(iFrame);
		try {
			iFrame.setSelected(true);
		} catch (java.beans.PropertyVetoException e) {}
		
	}

	private void modStudent() {
		JInternalFrame iFrame = new JInternalFrame("Modify Student");
		iFrame.setResizable(true);
        iFrame.setClosable(true);
        iFrame.setIconifiable(true);
        iFrame.setSize(new Dimension(600, 600));
        iFrame.setLocation(0, 0);
        iFrame.getContentPane().add( modifyStudentView.modStudent() );
        iFrame.setMaximizable(true);
        iFrame.setResizable(true);
        iFrame.setVisible(true);
        desk.add(iFrame);
		try {
			iFrame.setSelected(true);
		} catch (java.beans.PropertyVetoException e) {}
		
	}

	private void newStudent() {
		JInternalFrame iFrame = new JInternalFrame("New Student");
		iFrame.setResizable(true);
        iFrame.setClosable(true);
        iFrame.setIconifiable(true);
        iFrame.setSize(new Dimension(600, 600));
        iFrame.setLocation(0, 0);
        iFrame.getContentPane().add( newStudentView.newStudent() );
        iFrame.setMaximizable(true);
        iFrame.setResizable(true);
        iFrame.setVisible(true);
        desk.add(iFrame);
		try {
			iFrame.setSelected(true);
		} catch (java.beans.PropertyVetoException e) {}
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
		} catch (java.beans.PropertyVetoException e) {
			e.printStackTrace();
		}
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
		JMenu school = new JMenu("Students");
		school.setMnemonic(KeyEvent.VK_S);

		JMenu viewStudents = new JMenu("View Students");
		
		JMenuItem locationSort = new JMenuItem("Location sort");
		locationSort.setActionCommand("locationSortSchool");
		locationSort.addActionListener(this);
		viewStudents.add(locationSort);

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
		newStudent.setActionCommand("newStudent");
		newStudent.addActionListener(this);
		school.add(newStudent);
		
		JMenuItem modStudent = new JMenuItem("Modify Student");
		modStudent.setToolTipText("Modify an existing student");
		modStudent.setActionCommand("modStudent");
		modStudent.addActionListener(this);
		school.add(modStudent);

		JMenuItem delStudent = new JMenuItem("Delete Student");
		delStudent.setToolTipText("Delete a student from the school");
		delStudent.setActionCommand("delStudent");
		delStudent.addActionListener(this);
		school.add(delStudent);

		return school;
	}

	private JMenu termMenu(){
		JMenu term = new JMenu("Terms");
		term.setMnemonic(KeyEvent.VK_T);

		JMenuItem viewTerms = new JMenuItem("View all terms");
		viewTerms.setActionCommand("viewTerms");
		viewTerms.addActionListener(this);
		term.add(viewTerms);

		JMenuItem newTerm = new JMenuItem("New term");
		newTerm.setActionCommand("newTerm");
		newTerm.addActionListener(this);
		term.add(newTerm);
		
		JMenuItem modTerm = new JMenuItem("Modify term");
		modTerm.setActionCommand("modTerm");
		modTerm.addActionListener(this);
		term.add(modTerm);

		JMenuItem delTerm = new JMenuItem("Delete term");
		delTerm.setActionCommand("delTerm");
		delTerm.addActionListener(this);
		term.add(delTerm);
		
		JMenu bill = new JMenu("Billing...");
		
		JMenuItem billing = new JMenuItem("Generate a Bill");
		billing.setActionCommand("billGen");
		billing.addActionListener(this);
		bill.add(billing);
		
		JMenuItem notPaid = new JMenuItem("Show students with outstanding payment");
		notPaid.setActionCommand("notPaid");
		notPaid.addActionListener(this);
		bill.add(notPaid);
		
		JMenuItem markPaid = new JMenuItem("Mark a student as paid");
		markPaid.setActionCommand("markPaid");
		markPaid.addActionListener(this);
		bill.add(markPaid);
		
		term.add(bill);
		
		JMenuItem rollOverTerm = new JMenuItem("Rollover a term");
		rollOverTerm.setActionCommand("rollOverTerm");
		rollOverTerm.addActionListener(this);
		rollOverTerm.setToolTipText("Rollover students and classes from one term to another");
		term.add(rollOverTerm);

		return term;
	}

	private JMenu classMenu(){
		JMenu dclass = new JMenu("Classes");  
		dclass.setMnemonic(KeyEvent.VK_C);

		JMenuItem viewClasses = new JMenuItem("View all classes");
		viewClasses.setActionCommand("viewClasses");
		viewClasses.addActionListener(this);
		dclass.add(viewClasses);

		JMenuItem newClass = new JMenuItem("Create a new class");
		newClass.setActionCommand("newClass");
		newClass.addActionListener(this);
		dclass.add(newClass);
		
		JMenu termSubMenu = new JMenu("Term...");
		
		JMenuItem termClass = new JMenuItem("Add a Class to a Term");
		termClass.setActionCommand("termClass");
		termClass.addActionListener(this);
		termSubMenu.add(termClass);
		
		JMenuItem remTermClass = new JMenuItem("Remove a Class from a Term");
		remTermClass.setActionCommand("remTermClass");
		remTermClass.addActionListener(this);
		termSubMenu.add(remTermClass);
		
		dclass.add(termSubMenu);
		
		JMenu studentSubMenu = new JMenu("Student...");		
		
		JMenu showStudents = new JMenu("Show Students in Class");
		
		JMenuItem locationSortClass = new JMenuItem("Location Sorted");
		locationSortClass.setActionCommand("locationSortClass");
		locationSortClass.addActionListener(this);
		showStudents.add(locationSortClass);
		
		JMenuItem studentsInClassAgeDesc = new JMenuItem("Age (Desc)");
		studentsInClassAgeDesc.setActionCommand("studentsInClassAgeDesc");
		studentsInClassAgeDesc.addActionListener(this);
		
		JMenuItem studentsInClassAgeAsc = new JMenuItem("Age (Asc)");
		studentsInClassAgeAsc.setActionCommand("studentsInClassAgeAsc");
		studentsInClassAgeAsc.addActionListener(this);
		
		showStudents.add(studentsInClassAgeDesc);
		showStudents.add(studentsInClassAgeAsc);
		
		studentSubMenu.add(showStudents);
		
		JMenuItem studentClass = new JMenuItem("Add Student to Class");
		studentClass.setActionCommand("studentToClass");
		studentClass.addActionListener(this);
		studentSubMenu.add(studentClass);
		
		JMenuItem remStudentClass = new JMenuItem("Remove Student from Class");
		remStudentClass.setActionCommand("remStudentClass");
		remStudentClass.addActionListener(this);
		studentSubMenu.add(remStudentClass);
		
		dclass.add(studentSubMenu);
		
		JMenuItem modClass = new JMenuItem("Modify a class");
		modClass.setActionCommand("modClass");
		modClass.addActionListener(this);
		dclass.add(modClass);

		JMenuItem remClass = new JMenuItem("Delete a class");
		remClass.setActionCommand("remClass");
		remClass.addActionListener(this);
		dclass.add(remClass);

		JMenuItem migrateClass = new JMenuItem("Migrate a class");
		migrateClass.setToolTipText("Migrate students from one class to another");
		migrateClass.setActionCommand("migrateClass");
		migrateClass.addActionListener(this);
		dclass.add(migrateClass);

		return dclass;
	}

}
