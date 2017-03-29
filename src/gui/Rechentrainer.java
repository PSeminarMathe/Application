package gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.DecimalFormat;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import root.Aufgabe;
import root.AufgabenManager;
import root.StatistikManager;

import java.awt.Font;
import javax.swing.JList;
import javax.swing.JScrollPane;

public class Rechentrainer extends JFrame {
	
	//Felder
	
	private static final String AUTHOR = "JW";
	private static final String VERSION = "2.3.7";
	
	AufgabenManager aufgabenManager;
	Aufgabe currentAufgabe;
	StatistikManager statistikManager;

	//Komponenten
	private JPanel contentPane;
	private JButton btnStart;
	private JButton btnNaechsteAufgabe;
	private JTextField tfErgebnis;
	private JLabel lblMultiplikator;
	private JLabel lblGleichzeichen;
	private JLabel lblNummer1;
	private JLabel lblNummer2;
	private JLabel lblGesamteAufgaben;
	private JLabel lblRichtigeAufgaben;
	private JLabel lblFalscheAufgaben;
	private JList jListFalscheAufgaben;
	private DefaultListModel jListModelFalscheAufgaben;
	private JScrollPane scrollPane;
	
	//Start des Programms
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Rechentrainer frame = new Rechentrainer();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	//Erzeugung Frame
	public Rechentrainer() {
		//Frame Einstellungen
		setTitle(Rechentrainer.getMainTitle());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		
		//Content Pane
		setBounds(100, 100, 451, 358);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		setSize(451, 260);
		
		initMenu();
		initComponents();
		
		aufgabenManager = new AufgabenManager();
		statistikManager = new StatistikManager();
		
		
		setLocationRelativeTo(null);
	}
	
	private static String getMainTitle() {
		return "Rechentrainer v. " + Rechentrainer.VERSION + " | " + Rechentrainer.AUTHOR;
	}
	
	private void initMenu() {
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		//1. Menü
		JMenu menu1 = new JMenu("Menü");
		menuBar.add(menu1);
		
		JMenuItem miRundeStoppen = new JMenuItem("Aktuelle Runde Stoppen");
		miRundeStoppen.addActionListener(e -> {stop();});
		menu1.add(miRundeStoppen);
		
		JMenuItem miBeenden = new JMenuItem("Beenden");
		miBeenden.addActionListener(e -> {System.exit(0);});
		menu1.add(miBeenden);
		
		JMenuItem miInformationen = new JMenuItem("Informationen");
		miInformationen.addActionListener(e -> {
			JOptionPane.showMessageDialog(this, "Coded by: " + Rechentrainer.AUTHOR + "\n" + "Version: " + Rechentrainer.VERSION, "Information", -1);
		});
		menu1.add(miInformationen);
	}
	
	private void initComponents() {
		
		//Labels - statische
		lblMultiplikator = new JLabel("x");
		lblMultiplikator.setFont(new Font("Arial", Font.BOLD, 16));
		lblMultiplikator.setBounds(79, 126, 28, 38);
		contentPane.add(lblMultiplikator);
		
		lblGleichzeichen = new JLabel("=");
		lblGleichzeichen.setFont(new Font("Arial", Font.BOLD, 16));
		lblGleichzeichen.setBounds(130, 126, 28, 38);
		contentPane.add(lblGleichzeichen);
		
		//Labels - Faktoren
		lblNummer1 = new JLabel("13");
		lblNummer1.setFont(new Font("Arial", Font.BOLD, 16));
		lblNummer1.setBounds(42, 126, 36, 38);
		contentPane.add(lblNummer1);
		
		lblNummer2 = new JLabel("13");
		lblNummer2.setFont(new Font("Arial", Font.BOLD, 16));
		lblNummer2.setBounds(102, 126, 36, 38);
		contentPane.add(lblNummer2);
		
		//Ergebnisfeld
		tfErgebnis = new JTextField();
		tfErgebnis.setBounds(156, 130, 96, 32);
		contentPane.add(tfErgebnis);
		tfErgebnis.setColumns(10);
		tfErgebnis.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					nextAufgabe();
				}
			}
		});
		tfErgebnis.setEnabled(false);
		
		//Buttons
		btnStart = new JButton("Start");
		btnStart.setBounds(42, 22, 384, 38);
		btnStart.addActionListener(e -> {
			start();
		});
		contentPane.add(btnStart);
		
		btnNaechsteAufgabe = new JButton("Nächste Aufgabe");
		btnNaechsteAufgabe.setEnabled(false);
		btnNaechsteAufgabe.addActionListener(e -> {
			nextAufgabe();
		});
		btnNaechsteAufgabe.setBounds(281, 128, 119, 38);
		contentPane.add(btnNaechsteAufgabe);
		
		lblGesamteAufgaben = new JLabel("");
		lblGesamteAufgaben.setBounds(42, 186, 187, 16);
		contentPane.add(lblGesamteAufgaben);
		
		lblRichtigeAufgaben = new JLabel("");
		lblRichtigeAufgaben.setBounds(42, 214, 210, 16);
		contentPane.add(lblRichtigeAufgaben);
		
		lblFalscheAufgaben = new JLabel("");
		lblFalscheAufgaben.setBounds(42, 242, 187, 16);
		contentPane.add(lblFalscheAufgaben);
		
		//JList
		scrollPane = new JScrollPane();
		scrollPane.setBounds(260, 181, 142, 107);
		contentPane.add(scrollPane);
		scrollPane.setVisible(false);
		
		jListModelFalscheAufgaben = new DefaultListModel();
		
		jListFalscheAufgaben = new JList();
		scrollPane.setViewportView(jListFalscheAufgaben);
		jListFalscheAufgaben.setModel(jListModelFalscheAufgaben);
				
	}
	
	private void start() {
		int anzahlAufgaben = Integer.parseInt(JOptionPane.showInputDialog("Geben Sie die Anzahl der Aufgaben ein: "));
		aufgabenManager.neueRunde(anzahlAufgaben);
		statistikManager.neueRunde();
		
		//Komponenten 
		btnStart.setEnabled(false);
		tfErgebnis.setEnabled(true);
		btnNaechsteAufgabe.setEnabled(true);
		//Statistik verbergen
		hideStatistics();
		
		nextAufgabe();
	}
	
	private void stop() {
		
		//Komponenten
		btnStart.setEnabled(true);
		tfErgebnis.setEnabled(false);
		btnNaechsteAufgabe.setEnabled(false);
		//Statistiken anzeigen
		showStatistics();
		
		//Logik
		currentAufgabe = null;
	}
	
	private void nextAufgabe() {
		if(!aufgabenManager.isRoundOver()) {
			
			if(currentAufgabe != null)
				alteAufgabePruefen();
			
			//Aufgabe laden und anzeigen
			currentAufgabe = aufgabenManager.getNextAufgabe();
			lblNummer1.setText(String.valueOf(currentAufgabe.getFirstNumber()));
			lblNummer2.setText(String.valueOf(currentAufgabe.getSecondNumber()));
			
			//Farbe je nach Schwierigkeit setzen
			Color farbe;
			switch(currentAufgabe.getDifficulty()) {
				case 0:
					farbe = Color.BLACK;
					break;
				case 1:
					farbe = Color.ORANGE;
					break;
				case 12:
					farbe = Color.RED;
					break;
				default:
					farbe = Color.PINK; //Die hier sollte nicht auftreten
			}
			lblNummer1.setForeground(farbe);
			lblMultiplikator.setForeground(farbe);
			lblNummer2.setForeground(farbe);
			lblGleichzeichen.setForeground(farbe);
			
			tfErgebnis.requestFocus();
			tfErgebnis.setText("");
		} else {
			alteAufgabePruefen();
			stop();
		}
	}
	
	private void alteAufgabePruefen() {
		int userErgebnis = Integer.parseInt(tfErgebnis.getText());
		
		if( userErgebnis == currentAufgabe.getErgebnis()) {
			statistikManager.addRightAnswer(currentAufgabe);
		} else {
			statistikManager.addWrongAnswer(currentAufgabe);
		}
	}
	
	private void showStatistics() {
		this.setSize(getWidth(), 350);
		
		//Komponenten
		scrollPane.setVisible(true);
		lblGesamteAufgaben.setVisible(true);
		lblRichtigeAufgaben.setVisible(true);
		lblFalscheAufgaben.setVisible(true);
		
		//Werte ermitteln
		DecimalFormat df = new DecimalFormat("##0.0");
		lblGesamteAufgaben.setText("Anzahl Aufgaben: " + statistikManager.getAnzahlAufgaben());
		lblRichtigeAufgaben.setText("Anzahl Richtige: " + statistikManager.getAnzahlRichtige() + " - " + 
								df.format(statistikManager.getRightPercentage())  + "%");
		lblFalscheAufgaben.setText("Anzahl Falsche: " + statistikManager.getAnzahlFalsche() + " - " + 
				df.format(statistikManager.getWrongPercentage()) + "%");
		
		//Falsche Aufgaben anzeigen
		for(Aufgabe a : statistikManager.getWrongAnswers()) {
			jListModelFalscheAufgaben.addElement(a.getFirstNumber() + " x " + a.getSecondNumber());
		}
		
		//FalscheAufgaben dem AufgabenManager übergeben
		aufgabenManager.rankAufgaben(statistikManager.getWrongAnswers(), statistikManager.getRightAnswers());
	}
	
	private void hideStatistics() {
		this.setSize(getWidth(), 260);
		
		//Komponenten
		scrollPane.setVisible(false);
		lblGesamteAufgaben.setVisible(false);
		lblRichtigeAufgaben.setVisible(false);
		lblFalscheAufgaben.setVisible(false);
		
		//ListModel 
		jListModelFalscheAufgaben.clear();
	}
	
}
