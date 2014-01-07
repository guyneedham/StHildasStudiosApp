package com.bgcompute.StHildasStudios.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import com.bgcompute.StHildasStudios.controller.DClassController;
import com.bgcompute.StHildasStudios.controller.SchoolController;
import com.bgcompute.StHildasStudios.controller.StudentController;
import com.bgcompute.StHildasStudios.controller.TermController;
import com.bgcompute.StHildasStudios.model.ConnectionSettings;
import com.bgcompute.StHildasStudios.model.DClassFactory;
import com.bgcompute.StHildasStudios.model.MySQLConnectionPool;
import com.bgcompute.StHildasStudios.model.MySQLDatabase;
import com.bgcompute.StHildasStudios.model.SortStudents;
import com.bgcompute.StHildasStudios.model.StudentFactory;
import com.bgcompute.StHildasStudios.model.TermFactory;

public class Main {

	private JDesktopPane desk;
	private JPanel pnlMain;
	private static StudentController stc;
	private static SchoolController shc;
	private static DClassController dc;
	private static TermController tc;
	
	public Main() {

		initUI();
	}

	private JPanel initUI() {
		pnlMain = new JPanel(new BorderLayout()){
             @Override public Dimension getPreferredSize(){
                 return new Dimension(600,600);
             }
         };
         desk = new JDesktopPane();
		
/*
		JPanel panel = new JPanel();
		getContentPane().add(panel);

		panel.setLayout(null);
		panel.setToolTipText("A Panel container");

		JButton btn = new JButton("Button");
		btn.setBounds(100, 60, 100, 30);
		btn.setToolTipText("A Button component");

		panel.add(btn);
		
		JButton quitButton = new JButton("Quit");
	       quitButton.setBounds(50, 10, 80, 30);
	       
	       quitButton.addActionListener(new ActionListener() {
	           public void actionPerformed(ActionEvent event) {
	               System.exit(0);
	          }
	       });
	       quitButton.setToolTipText("Quit button");
	       panel.add(quitButton);


		setTitle("Example");
		setSize(300, 200);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);*/
         Menu menu = new Menu(desk, shc, stc, tc, dc);
         pnlMain.add(menu.getMenu(), BorderLayout.PAGE_START);
         pnlMain.add(desk, BorderLayout.CENTER);

         return pnlMain;
        
	}

	private static void createAndShowGUI(){
		JFrame frame = new JFrame("St Hilda's Studio Student Management");
		
		frame.setTitle("St Hilda's Studio Student Management");
        frame.setSize(500, 500);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new Main().initUI());
		frame.setVisible(true);
		JFrame.setDefaultLookAndFeelDecorated(true);
	}
	
	public static void main(String[] args) {		
		
		DClassFactory df = DClassFactory.getInstance();
		TermFactory tf = TermFactory.getInstance();
		StudentFactory sf = StudentFactory.getInstance();
		
		SortStudents sort = new SortStudents();
		
		ConnectionSettings cs = new ConnectionSettings();
		MySQLConnectionPool pool = MySQLConnectionPool.getInstance(cs.getServ(), cs.getName(), cs.getPass(), 1, 1);
		
		MySQLDatabase db = new MySQLDatabase(pool, tf, df, sf);
		stc = new StudentController(db, sf);
		tc = new TermController(tf, db, sort);
		shc = new SchoolController(db, sort, sf);
		dc = new DClassController(db, sort, df);
		
		
		
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				createAndShowGUI();
			}
		});
	}
}

