package com.compare;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

public class FECode4 {
	public static String path1,path2,path3;
	public static JTextArea area;


	public static void main(String[] args) {
		createWindow();
	}

	private static void createWindow() {    
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		createUI(frame);
		
		frame.setSize(600, 400);      
		frame.setLocationRelativeTo(null);  
		frame.setVisible(true);
	}

	private static void createUI(final JFrame frame){  
		JPanel panel = new JPanel();
		LayoutManager layout = new FlowLayout();  
		panel.setLayout(layout); 
		
		
		JLabel heading = new JLabel("JSON COMPARISON TOOL");
		heading.setBounds(200,-10, 240,90);  

		JLabel json1_label = new JLabel("JSON 1 Object    :");
		json1_label.setBounds(30,60, 100,70);  

		JLabel json2_label = new JLabel("JSON 2 Object    :");
		json2_label.setBounds(30,110, 100,70); 
		 
		JLabel output_label = new JLabel("   Output         :");
		output_label.setBounds(50,160, 100,70); 
		
	

		JTextField t1,t2,t3;  
		t1=new JTextField("");  
		t1.setBounds(150,80, 250,30);  

		t2=new JTextField("");  
		t2.setBounds(150,130, 250,30);  
		
		t3=new JTextField("");  
		t3.setBounds(150,180, 250,30);
		
		

		JButton button = new JButton("Browse");
		button.setBounds(430,80, 100,30);

		JButton browse_button2 = new JButton("Browse");
		browse_button2.setBounds(430,130, 100,30); 

		JButton browse_button3 = new JButton("Browse");
		browse_button3.setBounds(430,180, 100,30); 
		

		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser fileChooser = new JFileChooser();
				fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
				int option = fileChooser.showOpenDialog(frame);
				option = JFileChooser.APPROVE_OPTION;
				File file = fileChooser.getSelectedFile();
				t1.setText("Selected: " + file.getName());
				path1 =file.getAbsolutePath();

			} 
		});


		browse_button2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser fileChooser = new JFileChooser();
				fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
				int option = fileChooser.showOpenDialog(frame);
				option = JFileChooser.APPROVE_OPTION;
				File file = fileChooser.getSelectedFile();
				t2.setText("Selected: " + file.getName());
				path2 = file.getAbsolutePath();

			} 
		});


		browse_button3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser fileChooser = new JFileChooser();
				fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
				int option = fileChooser.showOpenDialog(frame);
				option = JFileChooser.APPROVE_OPTION;
				File file = fileChooser.getSelectedFile();
				t3.setText("Selected: " + file.getName());
				path3 = file.getAbsolutePath();

			} 
		});

	
		 area=new JTextArea();
	//	 area.setBounds(150,150, 380,100); 
		 
		
	      
		 
	     
		
		JButton submit_button = new JButton("Submit");
		submit_button.setBounds(250,260, 100,30); 
		
		submit_button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				StringBuilder output = ContentClass.ValidateJson(path1,path2,path3);
				
				area.setText(output.toString());
				
				try {
					DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
					   LocalDateTime now = LocalDateTime.now();  
					   System.out.println(dtf.format(now));  
			         FileWriter file = new FileWriter(path3+"\\output.json");
			      //   FileWriter file = new FileWriter(path3+"\\output\\"+dtf.format(now)+""+".json");
			        // System.out.println(path3+"\\out3.json"+strDate);
			         file.write(output.toString());
			         
			         
			         JOptionPane.showMessageDialog(frame,"JSON Comparison is completed");  
			         file.close();
			         
			         
			      } catch (IOException e1) {
			         // TODO Auto-generated catch block
			         e1.printStackTrace();
			      }
				  

			} 
	
		
		});
		

		panel.add(heading);
		panel.add(json1_label);
		panel.add(json2_label);
		panel.add(output_label);
		
	
		panel.add(t1);
		panel.add(t2);
		panel.add(t3);
	//	panel.add(area);
		
		panel.add(button);
		panel.add(browse_button2);
		panel.add(browse_button3);
		panel.add(submit_button);
		
		frame.add(heading);
		frame.add(json1_label);
		frame.add(json2_label);
		frame.add(output_label);
		
		frame.add(t1);
		frame.add(t2);
		frame.add(t3);
		frame.add(button);
		frame.add(browse_button2);
		frame.add(browse_button3);
		frame.add(submit_button);
		frame.add(area);
		
		  
		frame.getContentPane().add(panel, BorderLayout.CENTER);   
	}  
}