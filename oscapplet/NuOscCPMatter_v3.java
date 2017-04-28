
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import java.applet.*;
import java.awt.*;

import javax.swing.*;

import org.math.plot.*;
import org.math.plot.plotObjects.BaseLabel;

public class NuOscCPMatter_v3  extends Applet implements ActionListener {

	JComboBox choice;
	Banner banner;
	Banner3 banner3;
	Banner5 banner5;
	Plot2DPanel plotpanel1;
	
	JButton but0;
	JButton but1;
	JButton but2;
	JButton but3;
	JButton but4;
	JButton but5;
	JButton but6;
	JButton but7;
	JButton but8;
	JButton but9;
	JButton but10;
	JButton but11;
	JButton but12;
	JButton but13;
	JButton but14;
	JButton but15;
	JButton but16;
	JRadioButton rbut1;
	JRadioButton rbut2;
	JRadioButton rbut3;
	JRadioButton rbut4;
	JRadioButton rbut5;
	JRadioButton rbut6;
	JRadioButton rbut7;
	JPanel panel;
	TextField field0;
	TextField field1;
	TextField field2;
	TextField field3;
	TextField field4;
	TextField field5;
	TextField field6;
	TextField field7;
	TextField field8;
	TextField field9;
	TextField field10;
	TextField field11;
	TextField field12;
	TextField field13;
	TextField field14;
	TextField field15;
	BaseLabel title1;
	BaseLabel title2;
	JLabel Label6;
	JLabel Label8;
	JLabel Label9;
	JLabel Label10;
	JLabel Label11;
	JLabel Label12;
	JLabel Label14;
	JLabel Label1;
	int part_type_val;
	int medium_type_val;
	int flav_number_val;
	String[] plots = new String[] {"Plot of Oscillation Probability versus Distance","Plot of Oscillation Probability versus Energy"};
	ActionEvent actionEvent;
	JLabel Title;
	
	public void init() {

		choice = new JComboBox(plots); //this is the dropdown menu at the top, where one choses among the 2 plotting options
		//defined above in the string plots.
		plotpanel1 = new Plot2DPanel(); //this is the plot area
		plotpanel1.addLegend("SOUTH");
		plotpanel1.setSize(850, 270);
		plotpanel1.setPreferredSize(new Dimension(750, 250));
		
 		panel = new JPanel(new GridBagLayout()); //this is everything that is shown in the applet
 		Color Background = new Color(255,255,255);
 		panel.setBackground(Background);
 		GridBagConstraints c = new GridBagConstraints();
		c.gridx = 0; //this sets the positions of all the elements of the applet along the x (gridx) or y (gridy) directions.
		c.insets = new Insets(3,3,3,3);
		
		banner =  new Banner (5,8);
		banner.add(new Label("                        Three Generations Neutrino Oscillations with CP Violation in Vacuum and/or Matter                   "));         
		c.gridy = 0; //the first element in the applet from top to bottom
		panel.add(banner, c);
		
		Font ButtonFont = new Font("Verdana",Font.BOLD,12);
		
		// All the buttons, plot area and banners are added below:
		
		Panel row00 = new Panel();
		row00.setFont(ButtonFont);
		row00.add (new Label("Choose Option to Plot:",Label.LEFT));
		c.gridy = 1;
		choice.setSize(500, 30);
		choice.setPreferredSize(new Dimension(500, 30));
		row00.add(choice);
		panel.add(row00,c);
		
		Panel row7 = new Panel();
		row7.setFont(ButtonFont);
		Label1 = new JLabel("Type of Medium: ");
		Label1.setForeground(Color.black);
		row7.add (Label1);
		rbut6 = new JRadioButton("Vacuum");
		rbut6.setBackground(Background);
		rbut6.setActionCommand("Vacuum");
		rbut6.setSelected(true);
		rbut7 = new JRadioButton("Matter");
		rbut7.setActionCommand("Matter");
		rbut7.setSelected(false);
		rbut7.setBackground(Background);
		Label1.setVisible(false);
		rbut6.setVisible(false);
		rbut7.setVisible(false);
		 ButtonGroup group3 = new ButtonGroup();
	     group3.add(rbut6);
	     group3.add(rbut7);
	     row7.add(rbut6);
	     row7.add(rbut7);
		c.gridy = 6;
		panel.add(row7, c);

		Panel row4 = new Panel();
		row4.setFont(ButtonFont);
		Label8 = new JLabel("Neutrino Energy (GeV):");
		Label8.setForeground(Color.black);
		row4.add (Label8);
		but8 = new JButton("<html>E<sub>&nu;</sub> = </html>");
		but8.setForeground(Color.black);
		but8.setVisible(false);
		row4.add (but8);
		row4.add (field8 = new TextField("0.05",5));
		Label8.setVisible(false);
		field8.setVisible(false);
		
		Label9 = new JLabel("Max L Displayed (km):");
		Label9.setForeground(Color.black);
		row4.add (Label9);
		but9 = new JButton("<html>L<sub>max</sub> = </html>");
		but9.setForeground(Color.black);
		but9.setVisible(false);
		row4.add (but9);
		row4.add (field9 = new TextField("1000",7));
		Label9.setVisible(false);
		field9.setVisible(false);
		c.gridy = 3;
		panel.add(row4, c);
				
		c.gridy = 2;
		panel.add(plotpanel1, c);
		
		Panel row5 = new Panel();
		row5.setFont(ButtonFont);
		Label10 = new JLabel("Distance (km):");
		Label10.setForeground(Color.black);
		row5.add (Label10);
		but10 = new JButton("L = ");
		but10.setForeground(Color.black);
		but10.setVisible(false);
		row5.add (but10);
		row5.add (field10 = new TextField("295",5));
		Label10.setVisible(false);
		field10.setVisible(false);
		
		Label11 = new JLabel("Min E (GeV):");
		Label11.setForeground(Color.black);
		row5.add (Label11);
		but11 = new JButton("<html>E<sub>min</sub> = </html>");
		but11.setForeground(Color.black);
		but11.setVisible(false);
		row5.add (but11);
		row5.add (field11 = new TextField("0",7));
		Label11.setVisible(false);
		field11.setVisible(false);
		
		Label12 = new JLabel("Max E (GeV):");
		Label12.setForeground(Color.black);
		row5.add (Label12);
		but12 = new JButton("<html>E<sub>max</sub> = </html>");
		but12.setForeground(Color.black);
		but12.setVisible(false);
		row5.add (but12);
		row5.add (field12 = new TextField("3.0",7));
		Label12.setVisible(false);
		field12.setVisible(false);
		c.gridy = 4;
		panel.add(row5, c);
		
		banner5 = new Banner5 (5,10);
		banner5.add(new Label("                                                                                  General Settings                                                                             "));
		c.gridy = 5;
		panel.add(banner5, c);
		
		Panel row1 = new Panel();
		row1.setFont(ButtonFont);
	     
	    row1.add (new Label("Beam Flavour:",Label.LEFT));
		rbut3 = new JRadioButton("<html>&nu;<sub>e</sub></html>");
		rbut3.setActionCommand("electron");
		rbut3.setBackground(Background);
		rbut3.setSelected(true);
		rbut4 = new JRadioButton("<html>&nu;<sub>&micro;</sub></html>");
		rbut4.setActionCommand("muon");
		rbut4.setBackground(Background);
		rbut4.setSelected(false);
		rbut5 = new JRadioButton("<html>&nu;<sub>&tau;</sub></html>");
		rbut5.setActionCommand("tau");
		rbut5.setBackground(Background);
		rbut5.setSelected(false);
		 ButtonGroup group2 = new ButtonGroup();
	     group2.add(rbut3);
	     group2.add(rbut4);
	     group2.add(rbut5);
	     row1.add(rbut3);
	     row1.add(rbut4);
	     row1.add(rbut5);
	     

		row1.add (new Label("       Properties of Incoming Beam:",Label.LEFT));
		rbut1 = new JRadioButton("Neutrino");
		rbut1.setActionCommand("Neutrino");
		rbut1.setBackground(Background);
		rbut1.setSelected(true);
		rbut2 = new JRadioButton("Antineutrino");
		rbut2.setActionCommand("Antineutrino");
		rbut2.setBackground(Background);
		rbut2.setSelected(false);
		 ButtonGroup group = new ButtonGroup();
	     group.add(rbut1);
	     group.add(rbut2);
	     row1.add(rbut1);
	     row1.add(rbut2);

		c.gridy = 9;
		panel.add(row1, c);
	
		Panel row2 = new Panel();
		row2.setFont(ButtonFont);
		row2.add (new Label("Mixing Angles:",Label.LEFT));
		but3 = new JButton("<html>&theta;<sub>12</sub> = </html>");
		//but3 = new Button("\u0398"+"12 = ");
		but3.setForeground(Color.black);
		row2.add (but3);
		row2.add (field3 = new TextField("0.581776",6));

		but4 = new JButton("<html>&theta;<sub>13</sub> = </html>");
		but4.setForeground(Color.black);
		row2.add (but4);
		row2.add (field4 = new TextField("0.15708",6));
		c.gridy = 10;
		panel.add(row2, c);
		
		but5 = new JButton("<html>&theta;<sub>23</sub> = </html>");
		but5.setForeground(Color.black);
		row2.add (but5);
		row2.add (field5 = new TextField("0.785398",6));
		c.gridy = 11;
		panel.add(row2, c);
		
		Panel row3 = new Panel();
		row3.setFont(ButtonFont);
		Label6 = new JLabel("<html>Squared Mass Differences (eV<sup>2</sup>):</html>");
		Label6.setForeground(Color.black);
		row3.add (Label6);
		but6 = new JButton("<html>&Delta;m<sup>2</sup><sub>21</sub> = </html>");
		but6.setForeground(Color.black);
		row3.add (but6);
		row3.add (field6 = new TextField("7.6E-5",7));
		
		but7 = new JButton("<html>&Delta;m<sup>2</sup><sub>32</sub> = </html>");
		but7.setForeground(Color.black);
		row3.add (but7);
		row3.add (field7 = new TextField("2.4E-3",7));
		c.gridy = 12;
		panel.add(row3, c);
		
		Panel row6 = new Panel();
		row6.setFont(ButtonFont);
		row6.add (new Label("CP Violating Phase:",Label.LEFT));
		but13 = new JButton("\u03B4"+"CP  = ");
		but13.setForeground(Color.black);
		row6.add (but13);
		row6.add (field13 = new TextField("0.9",4));
		
		Label14 = new JLabel("Matter Effects:");
		Label14.setForeground(Color.black);
		row6.add (Label14);
		but14 = new JButton("<html>Density (g/cm<sup>3</sup>) = </html>");
		but14.setForeground(Color.black);
		but14.setVisible(false);
		row6.add (but14);
		row6.add (field14 = new TextField("3.2",4));
		Label14.setVisible(false);
		field14.setVisible(false);
		c.gridy = 13;
		panel.add(row6, c);
		
		Panel row0 = new Panel();
		but0 = new JButton("           UPDATE           ");
		row0.add (but0);
		c.gridy = 14;
		panel.add(row0, c);
		
		banner3 =  new Banner3 (5,10);
		banner3.add(new Label(" Caroline Guimarães                                                                                               York University Neutrino Group  ")); 
		c.gridy = 15;
		panel.add(banner3, c);
		
		row00.setForeground(Color.BLACK);
		row0.setForeground(Color.BLACK);
		row1.setForeground(Color.BLACK);
		row2.setForeground(Color.BLACK);
		row3.setForeground(Color.BLACK);
		row4.setForeground(Color.BLACK);
		row5.setForeground(Color.BLACK);
		row6.setForeground(Color.BLACK);		
		row7.setForeground(Color.BLACK);
		
		//The action listener is set below. It is now aware that each button is to be listened to.
		
		choice.addActionListener(this);
		but0.addActionListener(this);
		but3.addActionListener(this);
		but4.addActionListener(this);
		but5.addActionListener(this);
		but6.addActionListener(this);
		but7.addActionListener(this);
		but8.addActionListener(this);
		but9.addActionListener(this);
		but10.addActionListener(this);
		but11.addActionListener(this);
		but12.addActionListener(this);
		but13.addActionListener(this);
		but14.addActionListener(this);

		field3.addActionListener(this);
		field4.addActionListener(this);
		field5.addActionListener(this);
		field6.addActionListener(this);
		field7.addActionListener(this);
		field8.addActionListener(this);
		field9.addActionListener(this);
		field10.addActionListener(this);
		field11.addActionListener(this);
		field12.addActionListener(this);
		field13.addActionListener(this);
		field14.addActionListener(this);
		
		rbut1.addActionListener(this);
		rbut2.addActionListener(this);
		rbut3.addActionListener(this);
		rbut4.addActionListener(this);
		rbut5.addActionListener(this);
		rbut6.addActionListener(this);
		rbut7.addActionListener(this);
		
		this.add(panel);
 
	}
	   
	public class Complex { //Used for complex operations involving the CP violating term
		
		private double real;
		private double imaginary;
		
		public Complex(double real, double imaginary){
			this.real = real;
			this.imaginary = imaginary;
		}
		
		public Complex minus(Complex a, Complex b){
			double real = a.real - b.real;
			double imag = a.imaginary - b.imaginary;
			Complex subtraction = new Complex(real, imag);
			return subtraction;
		}

	    public Complex plus(Complex a, Complex b) {
	        double real = a.real + b.real;
	        double imag = a.imaginary + b.imaginary;
	        Complex sum = new Complex(real, imag);
	        return sum;
	    }
	    
	    public Complex times(Complex a, Complex b) {
	        double real = (a.real * b.real) - (a.imaginary*b.imaginary);
	        double imag = (a.real * b.imaginary) + (a.imaginary*b.real);
	        Complex multiplication = new Complex(real, imag);
	        return multiplication;
	    }
	        
	}

	public Complex times(Complex a, Complex b) {
	    double real = (a.real * b.real) - (a.imaginary*b.imaginary);
	    double imag = (a.real * b.imaginary) + (a.imaginary*b.real);
	    Complex multiplication = new Complex(real, imag);
	    return multiplication;
	}
	
    public void actionPerformed(ActionEvent actionEvent) {

		plotpanel1.removeAllPlots(); //Any time the applet updates, it first resets the plot area and removes the title.
		plotpanel1.removePlotable(title1);
		
		// The following strings contain the information from each field that was defined by the user in the applet
    	String t12_val = field3.getText();
    	String t13_val = field4.getText();
    	String t23_val = field5.getText();
    	String dm21_val = field6.getText();
    	String dm32_val = field7.getText();
    	String enu_val = field8.getText();
    	String dist_max_val = field9.getText();
    	String dist_val = field10.getText();
    	String elow_val = field11.getText();
    	String ehigh_val = field12.getText();
    	String dCP_val = field13.getText();
    	String type_txt = actionEvent.getActionCommand();
    	String rho_val = field14.getText();
   	    	
    	if(type_txt == "Neutrino"){
    		part_type_val = 0;	//This is the definition of part_type_val; 0 = neutrino and 1 = antineutrino
	 	} else if(type_txt == "Antineutrino") {
    		part_type_val = 1;
    	}
    	
    	if(type_txt == "electron"){
    		flav_number_val = 0; //This is the definition of flav_number_val; 0 = electron, 1 = muon and 2 = tau
    		rbut6.setSelected(true);
    		rbut7.setSelected(false);
    		rbut6.setVisible(false);
    		rbut7.setVisible(false);
    		Label1.setVisible(false);
    		but14.setVisible(false);
    		Label14.setVisible(false);
    		field14.setVisible(false);
    		medium_type_val = 0;
    	} else if (type_txt == "muon") {
    		flav_number_val = 1;
    		Label1.setVisible(true);
    		rbut6.setVisible(true);
    		rbut7.setVisible(true);
    	} else if (type_txt == "tau"){
    		flav_number_val = 2;
    		rbut6.setSelected(true);
    		rbut7.setSelected(false);
    		rbut6.setVisible(false);
    		rbut7.setVisible(false);
    		Label1.setVisible(false);
    		but14.setVisible(false);
    		Label14.setVisible(false);
    		field14.setVisible(false);
    		medium_type_val = 0;
    	}
    	
    	if(flav_number_val == 1 && part_type_val == 1){
    		rbut6.setSelected(true);
    		rbut7.setSelected(false);
    		rbut6.setVisible(false);
    		rbut7.setVisible(false);
    		but14.setVisible(false);
    		Label1.setVisible(false);
    		Label14.setVisible(false);
    		field14.setVisible(false);
    		medium_type_val = 0;
    	} else if (flav_number_val == 1 && part_type_val == 0 && medium_type_val==1) {
    		rbut6.setVisible(true);
    		rbut7.setVisible(true);
    		Label1.setVisible(true);
    		Label14.setVisible(true);
    		but14.setVisible(true);
    		field14.setVisible(true);
    	} else if (flav_number_val == 1 && part_type_val == 0 && medium_type_val==0) {
    		rbut6.setVisible(true);
    		rbut7.setVisible(true);
    		Label1.setVisible(true);
    		Label14.setVisible(false);
    		but14.setVisible(false);
    		field14.setVisible(false);
    	}

    	if(type_txt == "Vacuum"){
    		medium_type_val = 0;	//This is the definition of medium_type_val; 0 = vacuum and 1 = matter
    		but14.setVisible(false);
    		Label14.setVisible(false);
    		field14.setVisible(false);
	 	} else if(type_txt == "Matter") {
			but14.setVisible(true);
			Label14.setVisible(true);
			field14.setVisible(true);
	 		medium_type_val = 1;
    	}

         	
    	//Setting the mixing angles
		double t12 = Double.parseDouble(t12_val);
		double t13 = Double.parseDouble(t13_val);
		double t23 = Double.parseDouble(t23_val);
		double dCP = Double.parseDouble(dCP_val);
		int flav_number = flav_number_val;
		int part_type = part_type_val;
		double rho = Double.parseDouble(rho_val);
		
	
		//Setting the mass splittings
		double dm21 = Double.parseDouble(dm21_val);
		double dm32 = Double.parseDouble(dm32_val);
		double dm[][] = new double[3][3];
		dm[0][1] = -dm21;
		dm[1][0] = dm21;
		dm[1][2] = -dm32;
		dm[2][1] = dm32;
		dm[0][2] = -dm21 - dm32;
		dm[2][0] = -dm[0][2];
		
		
		double dist = Double.parseDouble(dist_val); //The default distance
		double enu = Double.parseDouble(enu_val); //The default energy
		double dist_max = Double.parseDouble(dist_max_val);; //
		double enu_max = Double.parseDouble(ehigh_val); //
		double enu_min = Double.parseDouble(elow_val);
		
		//For P vs L Graph:
		double number_dp = 1000; //Number of data points
		int dp_round = (int)Math.round(number_dp); //Rounding off the number of data points, just in case
		
		//For P vs E Graph:
		double number_dp2 = 1000;//Number of data points
		int dp_round2 = (int)Math.round(number_dp2); //Rounding off the number of data points
		
		//Defining the cos and sin of mixing angles
		double c12 = Math.cos(t12);
	    double s12 = Math.sin(t12);
	    double c13 = Math.cos(t13);
	    double s13 = Math.sin(t13);
	    double c23 = Math.cos(t23);
	    double s23 = Math.sin(t23);
	    double cCP = Math.cos(dCP);
	    double sCP = Math.sin(dCP);
	    	    
	    //Defining the entries of the real part of the mixing matrix
	    Complex mix[][] = new Complex[3][3];
	    
	    mix[0][0] = new Complex(c12*c13,0);
	    mix[0][1] = new Complex(s12*c13,0);
	    mix[0][2] = new Complex(s13*cCP,-s13*sCP);

	    mix[1][0] = new Complex(-s12*c23 - c12*s23*s13*cCP,-c12*s23*s13*sCP);
	    mix[1][1] = new Complex(c12*c23 - s12*s23*s13*cCP,-s12*s23*s13*sCP);
	    mix[1][2] = new Complex(s23*c13,0);

	    mix[2][0] = new Complex(s12*s23 - c12*c23*s13*cCP,-c12*c23*s13*sCP);
	    mix[2][1] = new Complex(-c12*s23 - s12*c23*s13*cCP,-s12*c23*s13*sCP);
	    mix[2][2] = new Complex(c23*c13,0);
	    
	    //Defining the entries of the complex part of the mixing matrix
	    Complex mixcc[][] = new Complex[3][3];
	   
	    mixcc[0][0] = new Complex(c12*c13,0);
	    mixcc[0][1] = new Complex(s12*c13,0);
	    mixcc[0][2] = new Complex(s13*cCP,s13*sCP);

	    mixcc[1][0] = new Complex(-s12*c23 - c12*s23*s13*cCP,c12*s23*s13*sCP);
	    mixcc[1][1] = new Complex(c12*c23 - s12*s23*s13*cCP,s12*s23*s13*sCP);
	    mixcc[1][2] = new Complex(s23*c13,0);

	    mixcc[2][0] = new Complex(s12*s23 - c12*c23*s13*cCP,c12*c23*s13*sCP);
	    mixcc[2][1] = new Complex(-c12*s23 - s12*c23*s13*cCP,s12*c23*s13*sCP);
	    mixcc[2][2] = new Complex(c23*c13,0);
   
	    //Calculating oscillation probabilities
	    
	    //for P vs L
	    double prob_nu_e[] = new double[dp_round]; // where dp_round is the number of data points
	    double prob_nu_tau[] = new double[dp_round];
	    double prob_nu_mu[] = new double[dp_round];
	    double prob_nu_e3[] = new double[dp_round]; // where dp_round is the number of data points
	    double prob_nu_tau3[] = new double[dp_round];
	    double prob_nu_mu3[] = new double[dp_round];

	    //for P vs E
	    double prob_nu_e2[] = new double[dp_round2]; // where dp_round is the number of data points
	    double prob_nu_tau2[] = new double[dp_round2];
	    double prob_nu_mu2[] = new double[dp_round2];
	    double prob_nu_e4[] = new double[dp_round2]; // where dp_round is the number of data points
	    double prob_nu_tau4[] = new double[dp_round2];
	    double prob_nu_mu4[] = new double[dp_round2];

	    double Lplot[] = new double[dp_round];
	    double Eplot[] = new double[dp_round2];
    
	    double pro_e = 0;
    	double pro_mu = 0;
    	double pro_tau = 0;
	    double pro_e2 = 0;
    	double pro_mu2 = 0;
    	double pro_tau2 = 0;
    	    
	   // if(medium_type_val==0){ //Calculations for Vacuum

		    int j = 0;
			    for(double L = 0; L <= dist_max; L=L + dist_max/dp_round){ //Calc for P vs L
			    	if(flav_number == 0){
			    		pro_e = 1;
			    		pro_mu = 0;
			    		pro_tau = 0;
			    	} else if (flav_number == 1){
			    		pro_e = 0;
			    		pro_mu = 1;
			    		pro_tau = 0;
			    	} else {
			    		pro_e = 0;
			    		pro_mu = 0;
			    		pro_tau = 1;
			    	}
				    for(int n = 0; n < 3; n++){
				    	for(int m = 0; m < 3; m++){
				    		if(m != n && m > n){
				    		    if (part_type == 0){
						        pro_e = pro_e - 4*(times(mixcc[flav_number][m],times(mix[0][m],times(mix[flav_number][n],mixcc[0][n]))).real)*Math.pow(Math.sin(1.27*dm[m][n]*L/enu),2) + 2*(times(mixcc[flav_number][m],times(mix[0][m],times(mix[flav_number][n],mixcc[0][n]))).imaginary)*Math.sin(2*1.27*dm[m][n]*L/enu);
						        pro_mu = pro_mu - 4*(times(mixcc[flav_number][m],times(mix[1][m],times(mix[flav_number][n],mixcc[1][n]))).real)*Math.pow(Math.sin(1.27*dm[m][n]*L/enu),2) + 2*(times(mixcc[flav_number][m],times(mix[1][m],times(mix[flav_number][n],mixcc[1][n]))).imaginary)*Math.sin(2*1.27*dm[m][n]*L/enu);
						        pro_tau = pro_tau - 4*(times(mixcc[flav_number][m],times(mix[2][m],times(mix[flav_number][n],mixcc[2][n]))).real)*Math.pow(Math.sin(1.27*dm[m][n]*L/enu),2) + 2*(times(mixcc[flav_number][m],times(mix[2][m],times(mix[flav_number][n],mixcc[2][n]))).imaginary)*Math.sin(2*1.27*dm[m][n]*L/enu);
				    		    } 
				    		    else if (part_type == 1) {
			    		    	pro_e = pro_e - 4*(times(mixcc[flav_number][m],times(mix[0][m],times(mix[flav_number][n],mixcc[0][n]))).real)*Math.pow(Math.sin(1.27*dm[m][n]*L/enu),2) - 2*(times(mixcc[flav_number][m],times(mix[0][m],times(mix[flav_number][n],mixcc[0][n]))).imaginary)*Math.sin(2*1.27*dm[m][n]*L/enu);
						        pro_mu = pro_mu - 4*(times(mixcc[flav_number][m],times(mix[1][m],times(mix[flav_number][n],mixcc[1][n]))).real)*Math.pow(Math.sin(1.27*dm[m][n]*L/enu),2) - 2*(times(mixcc[flav_number][m],times(mix[1][m],times(mix[flav_number][n],mixcc[1][n]))).imaginary)*Math.sin(2*1.27*dm[m][n]*L/enu);
						        pro_tau = pro_tau - 4*(times(mixcc[flav_number][m],times(mix[2][m],times(mix[flav_number][n],mixcc[2][n]))).real)*Math.pow(Math.sin(1.27*dm[m][n]*L/enu),2) - 2*(times(mixcc[flav_number][m],times(mix[2][m],times(mix[flav_number][n],mixcc[2][n]))).imaginary)*Math.sin(2*1.27*dm[m][n]*L/enu);
				    		    }
			    		    }
			        	}
				    }
				    if(j < dp_round){
			    	//Setting the x-values to plot
				    Lplot[j] = L;
			    	//Setting the y-values to plot
			    	prob_nu_e[j] = pro_e;
			    	prob_nu_tau[j] = pro_tau;
			    	prob_nu_mu[j] = pro_mu;
				    }
			    j = j + 1;
			    }
	
	
		    int k = 0; 
		    for(double E = enu_min; E <= enu_max; E=E+((enu_max-enu_min)/dp_round2)){ //Calc for P vs E
			    if(flav_number == 0){
		    		pro_e2 = 1;
		    		pro_mu2 = 0;
		    		pro_tau2 = 0;
		    	} else if (flav_number == 1){
		    		pro_e2 = 0;
		    		pro_mu2 = 1;
		    		pro_tau2 = 0;
		    	} else {
		    		pro_e2 = 0;
		    		pro_mu2 = 0;
		    		pro_tau2 = 1;
		    	}
			    for(int n = 0; n < 3; n++){
			    	for(int m = 0; m < 3; m++){
			    		if(m != n && m > n){
			    		    if(part_type == 0){
					        pro_e2 = pro_e2 - 4*(times(mixcc[flav_number][m],times(mix[0][m],times(mix[flav_number][n],mixcc[0][n]))).real)*Math.pow(Math.sin(1.27*dm[m][n]*dist/E),2) + 2*(times(mixcc[flav_number][m],times(mix[0][m],times(mix[flav_number][n],mixcc[0][n]))).imaginary)*Math.sin(2*1.27*dm[m][n]*dist/E);
					        pro_mu2 = pro_mu2 - 4*(times(mixcc[flav_number][m],times(mix[1][m],times(mix[flav_number][n],mixcc[1][n]))).real)*Math.pow(Math.sin(1.27*dm[m][n]*dist/E),2) + 2*(times(mixcc[flav_number][m],times(mix[1][m],times(mix[flav_number][n],mixcc[1][n]))).imaginary)*Math.sin(2*1.27*dm[m][n]*dist/E);
					        pro_tau2 = pro_tau2 - 4*(times(mixcc[flav_number][m],times(mix[2][m],times(mix[flav_number][n],mixcc[2][n]))).real)*Math.pow(Math.sin(1.27*dm[m][n]*dist/E),2) + 2*(times(mixcc[flav_number][m],times(mix[2][m],times(mix[flav_number][n],mixcc[2][n]))).imaginary)*Math.sin(2*1.27*dm[m][n]*dist/E);
			    		    } 
			    		    else if(part_type == 1){
		    		    	pro_e2 = pro_e2 - 4*(times(mixcc[flav_number][m],times(mix[0][m],times(mix[flav_number][n],mixcc[0][n]))).real)*Math.pow(Math.sin(1.27*dm[m][n]*dist/E),2) - 2*(times(mixcc[flav_number][m],times(mix[0][m],times(mix[flav_number][n],mixcc[0][n]))).imaginary)*Math.sin(2*1.27*dm[m][n]*dist/E);
					        pro_mu2 = pro_mu2 - 4*(times(mixcc[flav_number][m],times(mix[1][m],times(mix[flav_number][n],mixcc[1][n]))).real)*Math.pow(Math.sin(1.27*dm[m][n]*dist/E),2) - 2*(times(mixcc[flav_number][m],times(mix[1][m],times(mix[flav_number][n],mixcc[1][n]))).imaginary)*Math.sin(2*1.27*dm[m][n]*dist/E);
					        pro_tau2 = pro_tau2 - 4*(times(mixcc[flav_number][m],times(mix[2][m],times(mix[flav_number][n],mixcc[2][n]))).real)*Math.pow(Math.sin(1.27*dm[m][n]*dist/E),2) - 2*(times(mixcc[flav_number][m],times(mix[2][m],times(mix[flav_number][n],mixcc[2][n]))).imaginary)*Math.sin(2*1.27*dm[m][n]*dist/E);
			    		    }
		    		    }
		        	}
			    }
	
			    if(k < dp_round2){
	
			    	//Setting the x-values to plot
				    Eplot[k] = E;
			    	//Setting the y-values to plot
			    	prob_nu_e2[k] = pro_e2;
			    	prob_nu_tau2[k] = pro_tau2;
			    	prob_nu_mu2[k] = pro_mu2;
			    	
			    }
			    if(E == 0){ //This sets the initial probability value to 0 or 1, (At E=0)
			    	if(flav_number==0){
			    		prob_nu_e2[k] = 1;
			    		prob_nu_mu2[k] = 0;
			    		prob_nu_tau2[k] = 0;
			    	}
			    	if(flav_number==1){
			    		prob_nu_e2[k] = 0;
			    		prob_nu_mu2[k] = 1;
			    		prob_nu_tau2[k] = 0;
			    	}
			    	if(flav_number==2){
			    		prob_nu_e2[k] = 0;
			    		prob_nu_mu2[k] = 0;
			    		prob_nu_tau2[k] = 1;
			    	}
			    }
			    k = k + 1;
		    }
	    //} else { //Calculations for Matter
	    	
		    int j1 = 0;
		    for(double L = 0; L <= dist_max; L=L + dist_max/dp_round){
		    	double a = 7.6*Math.pow(10,-5)*rho*enu;
		    	double ratio = 1.27*L/enu;
		    	if(flav_number == 0){
		    		pro_e = 1;
		    		pro_mu = 0;
		    		pro_tau = 0;
		    	} else if (flav_number == 1){
		    		pro_e = 0;
		    		pro_mu = 1;
		    		pro_tau = 0;
		    	} else {
		    		pro_e = 0;
		    		pro_mu = 0;
		    		pro_tau = 1;
		    	}

			    for(int n = 0; n < 3; n++){
			    	for(int m = 0; m < 3; m++){
			    		if(m != n && m > n){
			    		    if (part_type == 0){
					        pro_e = 4*c13*c13*s13*s13*s23*s23*Math.sin((dm[2][0]*ratio))*Math.sin((dm[2][0]*ratio))*(1+ (1 - 2*s13*s13)*2*a/dm[2][0]) 
					        		+ 8*c13*c13*s12*s13*s23*(c12*c23*cCP - s12*s13*s23)*Math.cos((dm[2][1]*ratio))*Math.sin((dm[2][0]*ratio))*Math.sin((dm[1][0]*ratio)) 
					        		- 8*c13*c13*s13*s13*s23*s23*Math.cos((dm[2][1]*ratio))*Math.sin((dm[2][0]*ratio))*a*(1 - 2*s13*s13)*ratio
					        		- 8*c13*c13*c12*c23*s12*s13*s23*sCP*Math.sin((dm[2][1]*ratio))*Math.sin((dm[2][0]*ratio))*Math.sin((dm[1][0]*ratio))
					        		+ 4*s12*s12*c13*c13*(c12*c12*c23*c23 + s12*s12*s13*s13*s23*s23 - 2*c12*c23*s12*s13*s23*cCP)*Math.sin((dm[1][0]*ratio))*Math.sin((dm[1][0]*ratio));
					        pro_mu = pro_mu - 4*(times(mixcc[flav_number][m],times(mix[1][m],times(mix[flav_number][n],mixcc[1][n]))).real)*Math.pow(Math.sin(1.27*dm[m][n]*L/enu),2) + 2*(times(mixcc[flav_number][m],times(mix[1][m],times(mix[flav_number][n],mixcc[1][n]))).imaginary)*Math.sin(2*1.27*dm[m][n]*L/enu);
					        pro_tau = pro_tau - 4*(times(mixcc[flav_number][m],times(mix[2][m],times(mix[flav_number][n],mixcc[2][n]))).real)*Math.pow(Math.sin(1.27*dm[m][n]*L/enu),2) + 2*(times(mixcc[flav_number][m],times(mix[2][m],times(mix[flav_number][n],mixcc[2][n]))).imaginary)*Math.sin(2*1.27*dm[m][n]*L/enu);
			    		    } 
			    		    else if (part_type == 1) {
		    		    	pro_e = pro_e - 4*(times(mixcc[flav_number][m],times(mix[0][m],times(mix[flav_number][n],mixcc[0][n]))).real)*Math.pow(Math.sin(1.27*dm[m][n]*L/enu),2) - 2*(times(mixcc[flav_number][m],times(mix[0][m],times(mix[flav_number][n],mixcc[0][n]))).imaginary)*Math.sin(2*1.27*dm[m][n]*L/enu);
					        pro_mu = pro_mu - 4*(times(mixcc[flav_number][m],times(mix[1][m],times(mix[flav_number][n],mixcc[1][n]))).real)*Math.pow(Math.sin(1.27*dm[m][n]*L/enu),2) - 2*(times(mixcc[flav_number][m],times(mix[1][m],times(mix[flav_number][n],mixcc[1][n]))).imaginary)*Math.sin(2*1.27*dm[m][n]*L/enu);
					        pro_tau = pro_tau - 4*(times(mixcc[flav_number][m],times(mix[2][m],times(mix[flav_number][n],mixcc[2][n]))).real)*Math.pow(Math.sin(1.27*dm[m][n]*L/enu),2) - 2*(times(mixcc[flav_number][m],times(mix[2][m],times(mix[flav_number][n],mixcc[2][n]))).imaginary)*Math.sin(2*1.27*dm[m][n]*L/enu);
			    		    }
		    		    }
		        	}
			    }
			    if(j1 < dp_round){
		    	//Setting the x-values to plot
			    Lplot[j1] = L;
		    	//Setting the y-values to plot
		    	prob_nu_e3[j1] = pro_e;
		    	prob_nu_tau3[j1] = 0;
		    	prob_nu_mu3[j1] = 0;
			    }
		    j1 = j1 + 1;
		    }


	    int k1 = 0; 
	    for(double E = enu_min; E <= enu_max; E=E+((enu_max-enu_min)/dp_round2)){
	    	double a = 7.6*Math.pow(10,-5)*rho*E;
	    	double ratio = 1.26646*dist/E;
		    if(flav_number == 0){
	    		pro_e2 = 1;
	    		pro_mu2 = 0;
	    		pro_tau2 = 0;
	    	} else if (flav_number == 1){
	    		pro_e2 = 0;
	    		pro_mu2 = 1;
	    		pro_tau2 = 0;
	    	} else {
	    		pro_e2 = 0;
	    		pro_mu2 = 0;
	    		pro_tau2 = 1;
	    	}
		    for(int n = 0; n < 3; n++){
		    	for(int m = 0; m < 3; m++){
		    		if(m != n && m > n){
		    		    if(part_type == 0){
				        pro_e2 = 4*c13*c13*s13*s13*s23*s23*Math.sin((dm[2][0]*ratio))*Math.sin((dm[2][0]*ratio))*(1 + (1 - 2*s13*s13)*2*a/dm[2][0]) 
				        		+ 8*c13*c13*s12*s13*s23*(c12*c23*cCP - s12*s13*s23)*Math.cos((dm[2][1]*ratio))*Math.sin((dm[2][0]*ratio))*Math.sin((dm[1][0]*ratio)) 
				        		- 8*c13*c13*s13*s13*s23*s23*Math.cos((dm[2][1]*ratio))*Math.sin((dm[2][0]*ratio))*a*ratio*(1 - 2*s13*s13)
				        		- 8*c13*c13*c12*c23*s12*s13*s23*sCP*Math.sin((dm[2][1]*ratio))*Math.sin((dm[2][0]*ratio))*Math.sin((dm[1][0]*ratio))
				        		+ 4*s12*s12*c13*c13*(c12*c12*c23*c23 + s12*s12*s13*s13*s23*s23 - 2*c12*c23*s12*s13*s23*cCP)*Math.sin((dm[1][0]*ratio))*Math.sin((dm[1][0]*ratio));
				        //System.out.println("term 1 = "+);
				        pro_mu2 = pro_mu2 - 4*(times(mixcc[flav_number][m],times(mix[1][m],times(mix[flav_number][n],mixcc[1][n]))).real)*Math.pow(Math.sin(1.27*dm[m][n]*dist/E),2) + 2*(times(mixcc[flav_number][m],times(mix[1][m],times(mix[flav_number][n],mixcc[1][n]))).imaginary)*Math.sin(2*1.27*dm[m][n]*dist/E);
				        pro_tau2 = pro_tau2 - 4*(times(mixcc[flav_number][m],times(mix[2][m],times(mix[flav_number][n],mixcc[2][n]))).real)*Math.pow(Math.sin(1.27*dm[m][n]*dist/E),2) + 2*(times(mixcc[flav_number][m],times(mix[2][m],times(mix[flav_number][n],mixcc[2][n]))).imaginary)*Math.sin(2*1.27*dm[m][n]*dist/E);
		    		    } 
		    		    else if(part_type == 1){
	    		    	pro_e2 = pro_e2 - 4*(times(mixcc[flav_number][m],times(mix[0][m],times(mix[flav_number][n],mixcc[0][n]))).real)*Math.pow(Math.sin(1.27*dm[m][n]*dist/E),2) - 2*(times(mixcc[flav_number][m],times(mix[0][m],times(mix[flav_number][n],mixcc[0][n]))).imaginary)*Math.sin(2*1.27*dm[m][n]*dist/E);
				        pro_mu2 = pro_mu2 - 4*(times(mixcc[flav_number][m],times(mix[1][m],times(mix[flav_number][n],mixcc[1][n]))).real)*Math.pow(Math.sin(1.27*dm[m][n]*dist/E),2) - 2*(times(mixcc[flav_number][m],times(mix[1][m],times(mix[flav_number][n],mixcc[1][n]))).imaginary)*Math.sin(2*1.27*dm[m][n]*dist/E);
				        pro_tau2 = pro_tau2 - 4*(times(mixcc[flav_number][m],times(mix[2][m],times(mix[flav_number][n],mixcc[2][n]))).real)*Math.pow(Math.sin(1.27*dm[m][n]*dist/E),2) - 2*(times(mixcc[flav_number][m],times(mix[2][m],times(mix[flav_number][n],mixcc[2][n]))).imaginary)*Math.sin(2*1.27*dm[m][n]*dist/E);
		    		    }
	    		    }
	        	}
		    }

		    if(k1 < dp_round2){

		    	//Setting the x-values to plot
			    Eplot[k1] = E;
		    	//Setting the y-values to plot
		    	prob_nu_e4[k1] = pro_e2;
		    	prob_nu_tau4[k1] = 0;
		    	prob_nu_mu4[k1] = 0;
		    	
		    }
		    if(E == 0){
		    	if(flav_number==0){
		    		prob_nu_e4[k1] = 1;
		    		prob_nu_mu4[k1] = 0;
		    		prob_nu_tau4[k1] = 0;
		    	}
		    	if(flav_number==1){
		    		prob_nu_e4[k1] = 0;
		    		prob_nu_mu4[k1] = 1;
		    		prob_nu_tau4[k1] = 0;
		    	}
		    	if(flav_number==2){
		    		prob_nu_e4[k1] = 0;
		    		prob_nu_mu4[k1] = 0;
		    		prob_nu_tau4[k1] = 1;
		    	}
		    }
		    k1 = k1 + 1;
	    }
     	
		    
	  String particleType;
	  if(part_type==0){
		  particleType = "neutrino";
	  }else{
		  particleType = "antineutrino";
	  }
	  
	  String particleFlavour;
	  if(flav_number==0){
		  particleFlavour = "electron";
	  }else if(flav_number==1) {
		  particleFlavour = "muon";
	  }else{
		  particleFlavour = "tau";
	  }
	  
	  int I = choice.getSelectedIndex(); //This is the dropdown menu at the top --- I=0 means you selected P vs L, I=1 means you selected P vs E
	  if(I==0){ //hides or show fields depending on the selection
		  plotpanel1.removeAllPlots();
		  but8.setVisible(true);
		  field8.setVisible(true);
		  Label8.setVisible(true);
		  but9.setVisible(true);
		  field9.setVisible(true);
		  Label9.setVisible(true);
		  
		  but10.setVisible(false);
		  but11.setVisible(false);
		  but12.setVisible(false);
		  field10.setVisible(false);
		  field11.setVisible(false);
		  field12.setVisible(false);
		  Label10.setVisible(false);
		  Label11.setVisible(false);
		  Label12.setVisible(false);
		  
		  String Small_mu = new String("µ"); 
		  String title_string;
		  
  		  // add the 3 curves to the Plot
		  if(flav_number==1 && medium_type_val==1 && part_type_val==0){ //If incoming beam is of muons, and you select Matter and Neutrino, plot Matter/Vacuum curves only
		  plotpanel1.addLinePlot("<html>&rho; = 0.0 g/cm<sup>3</sup></html>", Lplot, prob_nu_e);
		  plotpanel1.addLinePlot("<html>&rho; = "+ rho +" g/cm<sup>3</sup></html>", Lplot, prob_nu_e3);
		  title_string = "Probability of oscillation for \u03BD"+Small_mu+" \u2192 \u03BD\u2091 with " + enu + " GeV of energy as a function of distance";
		  } else { //For anything else, plot the regular 3 curves
		  plotpanel1.addLinePlot("<html>&nu;<sub>e</sub></html>", Lplot, prob_nu_e);
		  plotpanel1.addLinePlot("<html>&nu;<sub>&mu;</sub></html>", Lplot, prob_nu_mu);
		  plotpanel1.addLinePlot("<html>&nu;<sub>&tau;</sub></html>", Lplot, prob_nu_tau);
		  title_string = "Probability of oscillation for " + particleFlavour + " " + particleType + " beam with " + enu + " GeV of energy as a function of distance";
		  }
		  
		  // set the Axis Labels and Title
		  plotpanel1.setAxisLabels("L (km)", "P");
		  title1 = new BaseLabel(title_string,Color.BLACK,0.5,1.1);
		  title1.setFont(new Font("Arial",Font.BOLD, 13));
		  plotpanel1.addPlotable(title1);
		   
		  // Setting Font and Size of Axis Labels
		  plotpanel1.getAxis(0).setLightLabelFont(new Font("Arial",Font.BOLD, 15));
		  plotpanel1.getAxis(0).setColor(Color.BLACK);
		  plotpanel1.getAxis(0).setLabelFont(new Font("Arial",Font.BOLD, 15));
		  plotpanel1.getAxis(1).setLightLabelFont(new Font("Arial",Font.BOLD, 15));
		  plotpanel1.getAxis(1).setLabelFont(new Font("Arial",Font.BOLD, 15));
		  plotpanel1.getAxis(1).setColor(Color.BLACK);
		  plotpanel1.setFixedBounds(1,0,1);
		  plotpanel1.setFixedBounds(0,0.,dist_max);
		  
		  // Setting Position of Axis 
		  plotpanel1.getAxis(1).setLabelPosition(-0.1, 0.5);
		  plotpanel1.getAxis(0).setLabelPosition(1.0, -0.15);
		  
	  } else if (I==1){
		  plotpanel1.removeAllPlots();
		  but10.setVisible(true);
		  Label10.setVisible(true);
		  field10.setVisible(true);
		  but11.setVisible(true);
		  Label11.setVisible(true);
		  field11.setVisible(true);
		  but12.setVisible(true);
		  Label12.setVisible(true);
		  field12.setVisible(true);
		  
		  but8.setVisible(false);
		  but9.setVisible(false);
		  field8.setVisible(false);
		  field9.setVisible(false);
		  Label8.setVisible(false);
		  Label9.setVisible(false);

		  String title_string1;
		  // add the 3 curves to the Plot
		  if(flav_number==1 && medium_type_val==1 && part_type_val==0){ //only for nu_mu and matter and neutrinos
			  //comparison between matter effects and no matter effects - nu_mu to nu_e.
		  plotpanel1.addLinePlot("<html>&rho; = 0.0 g/cm<sup>3</sup></html>", Eplot, prob_nu_e2);
		  plotpanel1.addLinePlot("<html>&rho; = "+ rho +" g/cm<sup>3</sup></html>", Eplot, prob_nu_e4);
		  title_string1 = "Probability of oscillation for \u03BD\u00B5 \u2192 \u03BD\u2091 at " + dist + " km as a function of neutrino energy";
		  } else { //plot of probability of oscillation into each flavour.
		  plotpanel1.addLinePlot("<html>&nu;<sub>e</sub></html>", Eplot, prob_nu_e2);
		  plotpanel1.addLinePlot("<html>&nu;<sub>&mu;</sub></html>", Eplot, prob_nu_mu2);
		  plotpanel1.addLinePlot("<html>&nu;<sub>&tau;</sub></html>", Eplot, prob_nu_tau2);
		  title_string1 = "Probability of oscillation for " + particleFlavour + " " + particleType + " beam at " + dist + " km as a function of neutrino energy";
		  }
		  
		  // set the Axis Labels and Title
		  plotpanel1.setAxisLabels("E (GeV)", "P");
		  title1 = new BaseLabel(title_string1,Color.BLACK,0.5,1.1);
		  title1.setFont(new Font("Arial",Font.BOLD, 13));
		  plotpanel1.addPlotable(title1);
		  
		  // Setting Position of Axis 
		  plotpanel1.getAxis(1).setLabelPosition(-0.1, 0.5);
		  plotpanel1.getAxis(0).setLabelPosition(1.0, -0.15);
	
		  plotpanel1.getAxis(0).setColor(Color.BLACK);
		  
		  // Setting Font and Size of Axis Labels
		  plotpanel1.getAxis(0).setLightLabelFont(new Font("Arial",Font.BOLD, 15));
		  plotpanel1.getAxis(0).setColor(Color.BLACK);
		  plotpanel1.getAxis(0).setLabelFont(new Font("Arial",Font.BOLD, 15));
		  plotpanel1.getAxis(1).setLightLabelFont(new Font("Arial",Font.BOLD, 15));
		  plotpanel1.getAxis(1).setLabelFont(new Font("Arial",Font.BOLD, 15));
		  plotpanel1.getAxis(1).setColor(Color.BLACK);
		  plotpanel1.setFixedBounds(1,0,1);
		  plotpanel1.setFixedBounds(0,enu_min,enu_max);
		  
	  }	  
}

       
    class Banner extends Panel{
		private static final long serialVersionUID = 1L;
		public Banner(int n, int m){
    	Color lightblue = new Color(166,212,252);
    	Font bannerFont = new Font("Verdana",Font.BOLD,14);
    	setFont(bannerFont);
    	setBackground(lightblue);
    	setForeground(Color.black);
    	setLayout(new GridLayout(1,m,0,5));
    	}                                      
	}   
    
    class Banner5 extends Panel{
		private static final long serialVersionUID = 1L;
		public Banner5(int n, int m){
    	Color lightblue = new Color(172,253,207);//(193,255,204);
    	Font bannerFont = new Font("Verdana",Font.BOLD,14);
    	setFont(bannerFont);
    	setBackground(lightblue);
    	setForeground(Color.black);
    	setLayout(new GridLayout(1,m,0,-5));
    	}                                      
	}   

    class Banner3 extends Panel{
		private static final long serialVersionUID = 1L;
		public Banner3(int n, int m){
    	Color lightblue = new Color(166,212,252);
    	Font bannerFont = new Font("Verdana",Font.BOLD,14);
    	setFont(bannerFont);
    	setBackground(lightblue);
    	setForeground(Color.black);
    	setLayout(new GridLayout(1,m,0,5));
    	}                                      
	}
        
}
