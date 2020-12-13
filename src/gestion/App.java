package gestion;
import javax.swing.*;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.util.Rotation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

import com.formdev.flatlaf.intellijthemes.FlatCyanLightIJTheme;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.sql.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.awt.event.ItemListener;


public class App extends JFrame{
	
	private JComboBox mark ;
	private JComboBox model;
	private JComboBox year ;


	private String[] marks = {
		    "Select Mark..","Mercedes", "Audi", "Volkswagen", "Seat"
		  };
	
	private String[] killometers = {
		    "0 - 30 000", "30 000 - 60 000", "60 000 - 90 000 ", "90 000 +"
		  };
	
	private String[] years = {
		    "2012", "2013","2014", "2015", "2016", "2017", "2018" 
		  };
	
	public App(){
		super("CARENTAL panel");
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		//this.setIconImage(new ImageIcon("icon/carentalogo.png").getImage());
		this.setIconImage(Toolkit.getDefaultToolkit().getImage("icon/carentalogo.png"));

		this.setSize(screenSize.width/2, screenSize.height/2);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		
		JPanel container = (JPanel) this.getContentPane();
		container.setLayout(null);
		
		Icon iconLogo = new ImageIcon("icon/carental.png");
		JLabel logoAcueil = new JLabel(iconLogo);
		JLabel logoAjout = new JLabel(iconLogo);
		JLabel logoEtat = new JLabel(iconLogo);
		
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.NORTH_EAST);
		tabbedPane.setBounds(6, 40, 828, 458); 
		container.add(tabbedPane);
		
		//panel accueil vaec index=0
		
		JPanel home = new JPanel();
		tabbedPane.addTab("Accueil", home);
		home.setLayout(new BoxLayout(home,BoxLayout.Y_AXIS));
		
		
		logoAcueil.setAlignmentX(Component.CENTER_ALIGNMENT);

		home.add(logoAcueil);
	    home.add(Box.createVerticalStrut(20));// objet qui permet l'espacement entre les éléments

		JLabel hello = new JLabel("Bienvenue!");
		hello.setSize(30,30);
		hello.setAlignmentX(Component.CENTER_ALIGNMENT);
		home.add(hello);
	    home.add(Box.createVerticalStrut(20));

		JLabel actions = new JLabel("Actions:");
		actions.setAlignmentX(Component.CENTER_ALIGNMENT);
		home.add(actions);
	    home.add(Box.createVerticalStrut(20));

		JButton addC = new JButton("Ajouter Voiture");
		addC.setAlignmentX(Component.CENTER_ALIGNMENT);
		home.add(addC);
	    home.add(Box.createVerticalStrut(20));

		JButton updateC = new JButton("Modifier état voiture");
		updateC.setAlignmentX(Component.CENTER_ALIGNMENT);
		home.add(updateC);
	    home.add(Box.createVerticalStrut(20));

		JButton historyCars = new JButton("Voir statistiques");
		historyCars.setAlignmentX(Component.CENTER_ALIGNMENT);
		home.add(historyCars);
	    home.add(Box.createVerticalStrut(20));


		
		

		//panel ajout avec index=1
		
		JPanel ajout = new JPanel();
		tabbedPane.addTab("Ajout", ajout );
		ajout.setLayout(new BoxLayout(ajout, BoxLayout.Y_AXIS));
		
		
		ajout.add(logoAjout);
		logoAjout.setAlignmentX(Component.CENTER_ALIGNMENT);


	    ajout.add(Box.createVerticalStrut(15));//espacement entre composants


		JLabel labelplate = new JLabel("Matricule voiture");
		labelplate.setAlignmentX(Component.CENTER_ALIGNMENT);
		ajout.add(labelplate);
		
	    JTextField matricule = new JTextField();
	    matricule.setAlignmentX(Component.CENTER_ALIGNMENT);
		ajout.add(matricule);
		
	    ajout.add(Box.createVerticalStrut(15));

		JLabel labelmark = new JLabel("Marque");
		labelmark.setAlignmentX(Component.CENTER_ALIGNMENT);
		ajout.add(labelmark);

		
		//liste des marques
		mark = new JComboBox(marks);
	
		mark.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				
				//modéles qui changent selon la marque
				ArrayList<String> models=new ArrayList<>();
				Iterator < String> iter;
				
				String selectedMark = mark.getSelectedItem().toString();
					switch (selectedMark) {
					
					case "Select Mark..":
					 		model.removeAllItems();
					 		break;
					case "Mercedes":
						 	model.removeAllItems();
						 	models.add("Class A");
						 	models.add("Class B");
						 	models.add("Class C");
						 	models.add("Class E");
						 	models.add("Class S");
						 	iter = models.iterator();
						 	
						 	while (iter.hasNext()){
						 		model.addItem(iter.next());
						 	}						 	
				         	
						 	break;
						 	
					 case "Audi":
						 model.removeAllItems();
						 	models.add("A3");
						 	models.add("A4");
						 	models.add("A5");
						 	models.add("A6");
						 	models.add("A7");
						 	models.add("A8");
						 	iter = models.iterator();
						 	
						 	while (iter.hasNext()){
						 		model.addItem(iter.next());
						 	}						 	

							break;

					 case "Volkswagen":
						 model.removeAllItems();
						 	models.add("Golf");
						 	models.add("Passat");
						 	models.add("Jetta");
						 	models.add("Passat CC");
						 	models.add("Tiguan");
						 	models.add("Touareg");
						 	iter = models.iterator();
						 	
						 	while (iter.hasNext()){
						 		model.addItem(iter.next());
						 	}				
						 	break;

					 case "Seat":
						 model.removeAllItems();
						 	models.add("Ibiza");
						 	models.add("Leon");
						 	models.add("Ateca");
						 	models.add("Leon fr");
						 	iter = models.iterator();
						 	
						 	while (iter.hasNext()){
						 		model.addItem(iter.next());
						 	}						 	
							break;
						 	 
					}
				}
			
		});
		
		ajout.add(mark);
		
	    ajout.add(Box.createVerticalStrut(15));

		//liste des modeles, change selon la marque
		JLabel labelmodel = new JLabel("Modéle");
		labelmodel.setAlignmentX(Component.CENTER_ALIGNMENT);
		ajout.add(labelmodel);

		model = new JComboBox();
		ajout.add(model);
		
	    ajout.add(Box.createVerticalStrut(15));

		//liste des années
		JLabel labelyear = new JLabel("Année");
		labelyear.setAlignmentX(Component.CENTER_ALIGNMENT);
		ajout.add(labelyear);

		JComboBox<?> year = new JComboBox<Object>(years);
		
		ajout.add(year);
	    ajout.add(Box.createVerticalStrut(15));

		//liste du killometrage
		JLabel labelkms = new JLabel("Killometrage");
		labelkms.setAlignmentX(Component.CENTER_ALIGNMENT);
		ajout.add(labelkms);

		JComboBox<?> kms = new JComboBox<Object>(killometers);
		
				
		ajout.add(kms);

		//JMenuItem mark = new JMenuItem("");
		//ajout.add(mark);
	    ajout.add(Box.createVerticalStrut(15));

		JButton add = new JButton("Ajouter");
		add.setAlignmentX(Component.CENTER_ALIGNMENT);
		ajout.add(add);
	
		
		JButton cancel = new JButton("Annuler");
		cancel.setAlignmentX(Component.CENTER_ALIGNMENT);
		ajout.add(cancel);
		
		
		
		//panel affectation/reception des voitures au clients, index=2
		
		JPanel etat = new JPanel();
		tabbedPane.addTab("Affectation", etat );
		etat.setLayout(new BoxLayout(etat, BoxLayout.Y_AXIS));
		
		
		etat.add(logoEtat);
		logoEtat.setAlignmentX(Component.CENTER_ALIGNMENT);

		
		etat.add(Box.createVerticalStrut(20));


		JButton load = new JButton("Charger voitures");
		load.setAlignmentX(Component.CENTER_ALIGNMENT);
		etat.add(load);
	
		etat.add(Box.createVerticalStrut(20));

		
		JLabel labelAvailableCar = new JLabel("Voitures disponibles");
		labelAvailableCar.setAlignmentX(Component.CENTER_ALIGNMENT);
		etat.add(labelAvailableCar);
		
		etat.add(Box.createVerticalStrut(20));

		JComboBox voituresdispos = new JComboBox();
		voituresdispos.addItem("");
		etat.add(voituresdispos);
		
		etat.add(Box.createVerticalStrut(20));

		JButton rent = new JButton("Louer");
		rent.setAlignmentX(Component.CENTER_ALIGNMENT);
		etat.add(rent);
	
		
		
		Component verticalStrut = Box.createVerticalStrut(45);
		etat.add(verticalStrut);

		JLabel labelRentedCar = new JLabel("Voitures louées");
		labelRentedCar.setAlignmentX(Component.CENTER_ALIGNMENT);
		etat.add(labelRentedCar);
		
		etat.add(Box.createVerticalStrut(20));

		JComboBox voitureslouees = new JComboBox();
		voitureslouees.addItem("");
		etat.add(voitureslouees);
			
		etat.add(Box.createVerticalStrut(20));

		JButton takerented = new JButton("Recevoir");
		takerented.setAlignmentX(Component.CENTER_ALIGNMENT);
		etat.add(takerented);
		etat.add(Box.createVerticalStrut(20));

		
			 
			 
			 
			 
		//panel statistics
				JPanel statistics = new JPanel();
				tabbedPane.addTab("Statistiques", statistics);
				statistics.setLayout(new BoxLayout(statistics, BoxLayout.Y_AXIS));
				statistics.add(Box.createVerticalStrut(20));

				JLabel clic = new JLabel ("Cliquer sur un bouton pour visualiser la charte et l'histogramme ");
				clic.setAlignmentX(Component.CENTER_ALIGNMENT);
				statistics.add(clic);

				JButton pieChart = new JButton("Charte");
				pieChart.setAlignmentX(Component.CENTER_ALIGNMENT);
				statistics.add(pieChart);

				statistics.add(Box.createVerticalStrut(20));

				JButton groupedBarChart = new JButton("Histograme");
				groupedBarChart.setAlignmentX(Component.CENTER_ALIGNMENT);
				statistics.add(groupedBarChart);
	
				statistics.add(Box.createVerticalStrut(20));
				
				//panel d'affichage des illustrations graphiques  
			    JPanel root = new JPanel();
			    statistics.add(root);
			    statistics.add(Box.createVerticalStrut(20));

		// listeners:
			    
		//listener d'ajout
		add.addActionListener(new ActionListener() {

			
			public void actionPerformed(ActionEvent e) {       
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:8889/agence","root","");
					Statement stm= conn.createStatement(); 
					String query = "INSERT INTO `cars`( `name`,`matricule`,`mark`, `model`, `year`, `killometrage`) "
									+ "VALUES ('"+ mark.getSelectedItem().toString().charAt(0)+"."+ model.getSelectedItem().toString() 
									+ "." +  year.getSelectedItem().toString().substring(year.getSelectedItem().toString().length() - 2) //selectionner les 2 derniers caracteres
									+ "." + matricule.getText() 
									// nom de la voiture, exp: A.A3.12.574657 pour audi a3 modele 2012 portant matricule 574657
									+ "','" + matricule.getText() +  "','"  + mark.getSelectedItem().toString()+"','"+ model.getSelectedItem().toString() + "','" + year.getSelectedItem().toString()+
									"','" +  kms.getSelectedItem().toString()  +  "')";
					
					if (!matricule.getText().equals("") ) {
						stm.executeUpdate(query); 
						tabbedPane.setSelectedIndex(0);				
						JOptionPane.showMessageDialog(null, "Voiture ajoutée avec succés");

					}
					else {
						JOptionPane.showMessageDialog(null, "Veuillez entrer une matricule pour votre voiture");
					}
				    conn.close();
				    

				}
				catch(Exception e1) {
					JOptionPane.showMessageDialog(null, "Erreur, Veuillez réessayer");
		         	System.out.println(e1);


				}
				
			}
			
		});
		// listeners de navigation entre les onglets
		addC.addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setSelectedIndex(1);				
			}
			
		});
		
				cancel.addActionListener(new ActionListener() {
		
					
					public void actionPerformed(ActionEvent e) {
						tabbedPane.setSelectedIndex(0);				
					}
					
				});
				
				updateC.addActionListener(new ActionListener() {
		
					
					public void actionPerformed(ActionEvent e) {
						tabbedPane.setSelectedIndex(2);				
					}
					
				});
			historyCars.addActionListener(new ActionListener() {
		
			
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setSelectedIndex(3);				
			}
			
		});
			
			//listener de chargement des voitures

			load.addActionListener(new ActionListener() {
				
				
				public void actionPerformed(ActionEvent e) {
					 try {
						 	
						 Class.forName("com.mysql.cj.jdbc.Driver");
							Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:8889/agence","root","");
					        Statement stmt = conn.createStatement();
					        Statement stmt2 = conn.createStatement(); 

					       ResultSet rs = stmt.executeQuery("select * from cars where `rented` = 0");
					       ResultSet rs2 = stmt2.executeQuery("select * from cars where `rented` = 1");
					     
					       if (voituresdispos.getItemCount() != 0) {
					    	   voituresdispos.removeAllItems();
						       while (rs.next()) {
						    	  // 
						    	   voituresdispos.addItem(rs.getString("name"));
						       }
					       }
					       
					       
					       if (voitureslouees.getItemCount() != 0) {
					    	   voitureslouees.removeAllItems();
						       while (rs2.next()) {
						    	   //
						    	   voitureslouees.addItem(rs2.getString("name"));
						       }
					       }
							 

					       conn.close();

					       
					   } catch (Exception e2) {

					   	JOptionPane.showMessageDialog(null, "erreur");
			         	System.out.println(e2);

					   }		
					 }
				
			});
			//affectation des voitures
			rent.addActionListener(new ActionListener() { 
				
				
				public void actionPerformed(ActionEvent e) {
					 try {
						 	Class.forName("com.mysql.cj.jdbc.Driver");
							Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:8889/agence","root","");
					        Statement stmtr = conn.createStatement();
					        
					        String query= "update cars set `rented` = 1    where name ='" + voituresdispos.getSelectedItem().toString()+ "';";
					        stmtr.executeUpdate(query);
						   	JOptionPane.showMessageDialog(null, "Voiture louée!");

						   	
						   	//mettre a jour les listes
						   	Statement stmt = conn.createStatement();
					        Statement stmt2 = conn.createStatement(); 

					       ResultSet rs = stmt.executeQuery("select * from cars where `rented` = 0");
					       ResultSet rs2 = stmt2.executeQuery("select * from cars where `rented` = 1");
					     
					       if (voituresdispos.getItemCount() != 0) {
					    	   voituresdispos.removeAllItems();
						       while (rs.next()) {
						    	  // 
						    	   voituresdispos.addItem(rs.getString("name"));
						       }
						      
					       }
					       
					       
					       if (voitureslouees.getItemCount() != 0) {
					    	   voitureslouees.removeAllItems();
						       while (rs2.next()) {
						    	   //
						    	   voitureslouees.addItem(rs2.getString("name"));
						       }
						      

					       }
					       
					       //fermer connection
					        conn.close();

					       
					   } catch (Exception e3) {

					   	JOptionPane.showMessageDialog(null, "erreur");
			         	System.out.println(e3);

					   }		
					 }
				
			});
			
			//réception des voitures
			takerented.addActionListener(new ActionListener() { //takerented
				
				
				public void actionPerformed(ActionEvent e) {
					 try {
						 	Class.forName("com.mysql.cj.jdbc.Driver");
							Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:8889/agence","root","");
					        Statement stmtr = conn.createStatement();
					        
					        String query= "update cars set `rented` = 0 , `number_rent`=`number_rent`+1  where name ='" + voitureslouees.getSelectedItem().toString()+ "';";
					        stmtr.executeUpdate(query);
						   	JOptionPane.showMessageDialog(null, "Voiture reçue");
						   	
						   	//mettre a jour listes
						   	Statement stmt = conn.createStatement();
					        Statement stmt2 = conn.createStatement(); 

					       ResultSet rs = stmt.executeQuery("select * from cars where `rented` = 0");
					       ResultSet rs2 = stmt2.executeQuery("select * from cars where `rented` = 1");
					     
					       if (voituresdispos.getItemCount() != 0) {
					    	   voituresdispos.removeAllItems();
						       while (rs.next()) {
						    	  // 
						    	   voituresdispos.addItem(rs.getString("name"));
						       }
					       }
					       
					       
					       if (voitureslouees.getItemCount() != 0) {
					    	   voitureslouees.removeAllItems();
						       while (rs2.next()) {
						    	   //
						    	   voitureslouees.addItem(rs2.getString("name"));
						       }
					       }
					       //fermer la connection
					        conn.close();

					       
					   } catch (Exception e3) {

					   	JOptionPane.showMessageDialog(null, "erreur");
			         	System.out.println(e3);

					   }		
					 }
				
			});
			// charte graphique
			pieChart.addActionListener( new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					try {
						
						Class.forName("com.mysql.cj.jdbc.Driver");
						Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:8889/agence","root","");
						Statement stm0 = conn.createStatement(); 
						Statement stm00= conn.createStatement(); 
						ResultSet rs0 = stm0.executeQuery("select mark, sum(number_rent) as sum_rent from cars group by mark");
						ResultSet rs00 = stm00.executeQuery("select sum(number_rent) as total from cars");
						
				        
				        DefaultPieDataset result = new DefaultPieDataset();
				        System.out.print(rs0);
				        rs00.next();
				        while (rs0.next()) {
				        	String m = rs0.getString("mark");
				        	Integer n = rs0.getInt("sum_rent")*100/rs00.getInt("total");
					        result.setValue(m, n);
				        }

				        JFreeChart chart = ChartFactory.createPieChart3D(
				        "Représentation du pourcentage des voitures louées par marque", result, true, true, false);
				        PiePlot3D plot = (PiePlot3D) chart.getPlot();
				        plot.setStartAngle(290);
				        plot.setDirection(Rotation.CLOCKWISE);
				        plot.setForegroundAlpha(0.25f);
				        plot.setCircular(true);


				        ChartPanel piechartPanel = new ChartPanel(chart);
				        statistics.removeAll();
				        statistics.add(groupedBarChart, BorderLayout.NORTH);
				        statistics.add(pieChart, BorderLayout.NORTH);
				        statistics.add(piechartPanel, BorderLayout.SOUTH);
				        conn.close();
						
					}
					catch(Exception e1) {
						JOptionPane.showMessageDialog(null, "Erreur, Veuillez réessayer!");
			         	System.out.println(e1);


					}
					
				}
			});
			//histogramme
			groupedBarChart.addActionListener( new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					try {
						 
						Class.forName("com.mysql.cj.jdbc.Driver");
						Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:8889/agence","root","");
						Statement stm01 = conn.createStatement();  
						ResultSet rs01 = stm01.executeQuery("select DISTINCT m.mark, r1.is_rented, r0.not_rented from  (SELECT mark from cars) as m  left join (select mark, COUNT(rented) as is_rented from cars where rented = 1 GROUP BY mark ORDER BY mark) as r1 on m.mark = r1.mark left join (select mark, COUNT(rented) as not_rented from cars where rented = 0 GROUP BY mark ORDER BY mark) as r0 on m.mark = r0.mark;");
						

						DefaultCategoryDataset dataset = new DefaultCategoryDataset();  
				        while (rs01.next()) {
					        dataset.addValue(rs01.getInt("is_rented"), "Louée", rs01.getString("mark"));  
						    dataset.addValue(rs01.getInt("not_rented"), "Non louée", rs01.getString("mark"));  
				        } 
					    
						//Create chart  
					    JFreeChart chart=ChartFactory.createBarChart(  
					        "Nombre des voitures louées/disponibles par marque", //Chart Title  
					        "Marque", // Category axis  
					        "Nombre de voitures", // Value axis  
					        dataset,  
					        PlotOrientation.VERTICAL,  
					        true,true,false  
					       );  
					  
					    
					    ChartPanel barpanel = new ChartPanel(chart); 
					    statistics.removeAll();
					    statistics.add(groupedBarChart, BorderLayout.NORTH);
					    statistics.add(pieChart, BorderLayout.NORTH);
					    statistics.add(barpanel, BorderLayout.SOUTH);
					    conn.close();
					}
					catch(Exception e1) {
						JOptionPane.showMessageDialog(null, "Erreur, Veuillez ré️essayer!");
			         	System.out.println(e1);


					}
				}
			});
				
					
	}	
	
	
	//public JMenuItem createModelMenu() {}
	
	
	 
	
	
	public static void main (String [] args) {
		 try { 
             UIManager.setLookAndFeel(new FlatCyanLightIJTheme()); 
  
         } 
         catch (Exception e) { 
         	System.out.println("erreur");
         	App app =new App();
         	app.show();
	}
}


		
	}

	