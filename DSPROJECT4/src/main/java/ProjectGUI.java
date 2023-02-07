/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */


import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Dell
 */
public class ProjectGUI extends javax.swing.JFrame {

    /**
     * Creates new form ProjectGUI
     */
    
    public static String[] arr;
    public static University_LinkedList LList;
    public static HashTable HT;
    public static boolean UBClicked = false;
    private static UpdateFrame UB;
    
    public ProjectGUI() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        Country = new javax.swing.JComboBox<>();
        Discipline = new javax.swing.JComboBox<>();
        City = new javax.swing.JComboBox<>();
        Search = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        UniList = new javax.swing.JTextArea();
        IPBox = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Univesity Database Seaching");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setResizable(false);

        jButton1.setText("Refresh");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel2.setText("Discipline");

        jLabel3.setText("Country");

        jLabel4.setText("City");

        Country.setLightWeightPopupEnabled(false);
        Country.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CountryActionPerformed(evt);
            }
        });

        Discipline.setLightWeightPopupEnabled(false);

        City.setLightWeightPopupEnabled(false);
        City.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CityActionPerformed(evt);
            }
        });

        Search.setText("Search");
        Search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchActionPerformed(evt);
            }
        });

        UniList.setEditable(false);
        UniList.setBackground(new java.awt.Color(0, 0, 102));
        UniList.setColumns(20);
        UniList.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        UniList.setForeground(new java.awt.Color(255, 255, 255));
        UniList.setRows(5);
        jScrollPane2.setViewportView(UniList);

        IPBox.setText("Input-Box");
        IPBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IPBoxActionPerformed(evt);
            }
        });

        jButton2.setText("Update");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(Search, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jButton1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(IPBox, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                .addGap(35, 35, 35))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Country, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(City, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(Discipline, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 382, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Country, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(City, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(Discipline, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1)
                            .addComponent(jButton2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Search)
                            .addComponent(IPBox))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        Country.removeAllItems();
        arr = LList.get_CountryList();
        Country.addItem("Not Selected");
        for(int i = 0 ; i < arr.length;i++)
        {
            Country.addItem(arr[i]);
        }
        City.removeAllItems();
        City.removeAllItems();
        arr = LList.get_CityList();
        City.addItem("Not Selected");
        for(int i = 0 ; i < arr.length;i++)
        {
            City.addItem(arr[i]);
        }
        Discipline.removeAllItems();
        Discipline.removeAllItems();
        arr = LList.get_DisciplineList();
        Discipline.addItem("Not Selected");
        for(int i = 0 ; i < arr.length;i++)
        {
            Discipline.addItem(arr[i]);
        }
        jButton1.setVisible(false);            
    }//GEN-LAST:event_jButton1ActionPerformed

    private void SearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchActionPerformed
        // TODO add your handling code here:

        UniList.setText("");
        
        
        String COUNTRY = Country.getSelectedItem().toString();
        System.out.println("------------------------------------------------" + COUNTRY);
        if(COUNTRY.equals("Not Selected"))
        {
            COUNTRY = null;
        }
        
        
        
        String CITY = City.getSelectedItem().toString();
        System.out.println("------------------------------------------------" + CITY);
        if(CITY.equals("Not Selected"))
        {
            CITY = null;
        }
        
        String DIS = Discipline.getSelectedItem().toString();
        System.out.println("------------------------------------------------" + DIS);
        if(DIS.equals("Not Selected"))
        {
            DIS = null;
        }
        
        String Listadd = HT.search(COUNTRY, CITY, DIS);
        

        UniList.setText("");
        UniList.setText(Listadd);

        
    }//GEN-LAST:event_SearchActionPerformed

    private void CountryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CountryActionPerformed
        // TODO add your handling code here:
        
        String COUNTRY = Country.getSelectedItem().toString();
        if(!COUNTRY.equals("Not Selected"))
        {
            City.removeAllItems();
            arr = LList.get_CityInCountryList(COUNTRY);
            City.addItem("Not Selected");
            for(int i = 0 ; i < arr.length;i++)
            {
                City.addItem(arr[i]);
            }
        }
    
        if(!COUNTRY.equals("Not Selected"))
        {
            Discipline.removeAllItems();
            arr = LList.get_DisciplineInCountryList(COUNTRY);
            Discipline.addItem("Not Selected");
            for(int i = 0 ; i < arr.length;i++)
            {
                Discipline.addItem(arr[i]);
            }
        }
        
        
    }//GEN-LAST:event_CountryActionPerformed

    private void CityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CityActionPerformed
        // TODO add your handling code here:
       
        String CITY = City.getSelectedItem().toString();
        if(!CITY.equals("Not Selected"))
        {
            Discipline.removeAllItems();
            Discipline.addItem("Not Selected");
            arr = LList.get_DisciplineInCityList(CITY);
            for(int i = 0 ; i < arr.length;i++)
            {
//                System.out.println(arr[i]);
                Discipline.addItem(arr[i]);
                System.out.println(arr[i]);
            }
            
        }      
    }//GEN-LAST:event_CityActionPerformed

    private void IPBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IPBoxActionPerformed
        // TODO add your handling code here:
        UB = new UpdateFrame();
        UB.setVisible(true);
        UBClicked = true;        
    }//GEN-LAST:event_IPBoxActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        
        if(UBClicked == true)
        {
            try {
                HT.Update(UB.Uni_Name,UB.Country,UB.City,UB.Discipline,UB.Rank);
            } catch (IOException ex) {
                Logger.getLogger(ProjectGUI.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("Erroe ider aya hai");
            }
            UBClicked = false;
            jButton1.setVisible(true);
        }
        else
        {
            JFrame frame = new JFrame();
            JOptionPane.showMessageDialog(frame,"please input first ");
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    
        
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) throws FileNotFoundException {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ProjectGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ProjectGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ProjectGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ProjectGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        
        Scanner sc = new Scanner(new File("C:\\Users\\Dell\\Desktop\\DS-Lab\\DSPROJECT4\\src\\main\\java\\Fake.csv")); 
        
		LList = new University_LinkedList();
		
  
		while (sc.hasNextLine())  //returns a boolean value  
		{  
			String x = sc.nextLine();//find and returns the next complete token from this scanner
			String[] Uni  = x.split(",");
			String[] programs = Uni[1].split("-");
			
//			System.out.println(programs.length);
			LList.insert(Uni[0], Uni[3], Uni[2], programs,Uni[4]);
			
 			
//			System.out.println("\nThe Name Of the Uni is = " + Uni[0] + " \nthe programs offered are = " + Uni[1] +  "\nCity = " + Uni[2] + "\nCountry = " + Uni[3] );
		}   
		sc.close();  //closes the scanner
                
//                System.out.println(LList);
                HT = new HashTable(LList);
                
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ProjectGUI().setVisible(true);
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> City;
    private javax.swing.JComboBox<String> Country;
    private javax.swing.JComboBox<String> Discipline;
    private javax.swing.JButton IPBox;
    private javax.swing.JButton Search;
    private javax.swing.JTextArea UniList;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
