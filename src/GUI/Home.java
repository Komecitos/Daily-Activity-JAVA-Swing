
package GUI;

import java.sql.Connection;
import com.formdev.flatlaf.FlatLightLaf;
import com.mysql.cj.protocol.Resultset;
import com.mysql.cj.x.protobuf.MysqlxNotice;
import java.sql.Statement;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class Home extends javax.swing.JFrame {
    
    public static Connection conn ;
    public static ResultSet rs;
    public static Statement st;
    public static String onLogin;
    DefaultTableModel model ;
  
    public Home()  {
        FlatLightLaf.setup();
        initComponents();
        frameSettings();
        scaleImage();
        buttonMouse();
        setTable();
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql", "root", "root");
            showActivity();
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
       
        JLabel []labels = {homeTeks, profilTeks,  quitTeks};
        for (JLabel lab : labels) {
            lab.setText("");
        }
        mainPanel.removeAll();
        mainPanel.repaint();
        mainPanel.revalidate();

        mainPanel.add(wellcomePane);
        mainPanel.repaint();
        mainPanel.revalidate();
        
        setVisible(true);
                }
    
   public void frameSettings(){
       
       Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

       int x = (screenSize.width - this.getWidth()) / 2;
       int y = (screenSize.height - this.getHeight()) / 2;

       this.setLocation(x, y);
       
       this.setResizable(false);
   }
   public void scaleImage() {
      
//        profil
       ImageIcon icon = new ImageIcon("C:\\Users\\LENOVO\\Documents\\KING JAVA code\\PBOL\\MyRoutine\\src\\Icons\\profilButton.png");
       Image img = icon.getImage();
       Image imgScale = img.getScaledInstance(profilButton.getWidth() - 12, profilButton.getHeight() - 12, Image.SCALE_SMOOTH);
       ImageIcon newIcon = new ImageIcon(imgScale);
       profilButton.setIcon(newIcon);
       
       
       // settings
       ImageIcon icon3 = new ImageIcon("C:\\Users\\LENOVO\\Documents\\KING JAVA code\\PBOL\\MyRoutine\\src\\Icons\\setButton.png");
       Image img3 = icon3.getImage();
       Image imgScale3 = img3.getScaledInstance(profilButton.getWidth() - 12, profilButton.getHeight() - 12, Image.SCALE_SMOOTH);
       ImageIcon newIcon3 = new ImageIcon(imgScale3);
       quitButton.setIcon(newIcon3);
       
       // home
       ImageIcon icon4 = new ImageIcon("C:\\Users\\LENOVO\\Documents\\KING JAVA code\\PBOL\\MyRoutine\\src\\Icons\\homeButton.png");
       Image img4 = icon4.getImage();
       Image imgScale4 = img4.getScaledInstance(homeButton.getWidth() - 12, homeButton.getHeight() - 12, Image.SCALE_SMOOTH);
       ImageIcon newIcon4 = new ImageIcon(imgScale4);
       homeButton.setIcon(newIcon4);
       
       // settings Backcgrund
//       ImageIcon icon5 = new ImageIcon("C:\\Users\\LENOVO\\Documents\\KING JAVA code\\PBOL\\MyRoutine\\src\\Icons\\BG.png");
//       Image img5 = icon5.getImage();
//       Image imgScale5 = img5.getScaledInstance(setBG.getWidth(), setBG.getHeight(), Image.SCALE_SMOOTH);
//       ImageIcon newIcon5 = new ImageIcon(imgScale5);
//       setBG.setIcon(newIcon5);
       
       
   }
   public void buttonMouse() {
       
       JButton []btns = {homeButton, profilButton, quitButton};
       
       for (JButton btn : btns){
           
           btn.addMouseListener(new MouseListener (){

               @Override
               public void mouseClicked(MouseEvent e) {
                   
               }

               @Override
               public void mousePressed(MouseEvent e) {       
               }

               @Override
               public void mouseReleased(MouseEvent e) {        
                   
               }

               @Override
               public void mouseEntered(MouseEvent e) {
                   
                   btn.setBackground(Color.cyan);
               }

               @Override
               public void mouseExited(MouseEvent e) {
                   btn.setBackground(Color.white);
               }
           });
       }
       
       homeButton.addMouseListener(new MouseListener(){
           @Override
           public void mouseClicked(MouseEvent e) {
           }
           @Override
           public void mousePressed(MouseEvent e) {
           }
           @Override
           public void mouseReleased(MouseEvent e) {
           }
           @Override
           public void mouseEntered(MouseEvent e) {
               homeTeks.setText("Home");
           }
           @Override
           public void mouseExited(MouseEvent e) {
               homeTeks.setText("");
           }
       });
       
       profilButton.addMouseListener(new MouseListener(){
           @Override
           public void mouseClicked(MouseEvent e) {
           }
           @Override
           public void mousePressed(MouseEvent e) {
           }
           @Override
           public void mouseReleased(MouseEvent e) {
           }
           @Override
           public void mouseEntered(MouseEvent e) {
               profilTeks.setText("Profil");
           }
           @Override
           public void mouseExited(MouseEvent e) {
               profilTeks.setText("");
           }
       });
       
       
       quitButton.addMouseListener(new MouseListener(){
           @Override
           public void mouseClicked(MouseEvent e) {
           }
           @Override
           public void mousePressed(MouseEvent e) {
           }
           @Override
           public void mouseReleased(MouseEvent e) {
           }
           @Override
           public void mouseEntered(MouseEvent e) {
               quitTeks.setText("Quit");
           }
           @Override
           public void mouseExited(MouseEvent e) {
               quitTeks.setText("");
           }
       });
   }
   public void showActivity() throws SQLException{
       
       int id = 0;
       try {
           id = getAccountID();
       } catch (Exception e) {
           JOptionPane.showMessageDialog(null, e.getMessage());
       }
       st = conn.createStatement();
       
       String []days = {"Minggu","Senin"};
       JTable []tabs = {tableMinggu, tableSenin};
       
       for (String day : days){
           
           rs = st.executeQuery("Select * from activities where user_id = " + id + " and days like '"+day+"'"
                   + "ORDER BY time_start");

           while (rs.next()) {
               String time = rs.getString("time_start") + " - " + rs.getString("time_end");
               String nameAct = rs.getString("activity_name");
               String desc = rs.getString("activity_desc");

               String[] data = {time, nameAct, desc};
               
               switch (day) {
                   case "Minggu" :
                       model = (DefaultTableModel)tableMinggu.getModel();
                       model.addRow(data);
                       break;
                   case "Senin" :
                       model = (DefaultTableModel)tableSenin.getModel();
                       model.addRow(data);
                       break;
                   
                   
               }

               
           }
       }  
   }
   public int getAccountID() {
       ResultSet rs  = null;
       Statement st = null;
       String id = null;
       
        try {
            st = conn.createStatement();
            String query = "Select user_id from users where login_status = true";
            rs = st.executeQuery(query);

            if (rs.next()) {
                id = rs.getString("user_id");

            } else {
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(newActivity.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
            return Integer.parseInt(id);   
    }
   public void setTable(){
       
       JTable tabs[] = {tableMinggu, tableSenin};
       
       for (JTable tab : tabs) {
           
           tab.getTableHeader().setBackground(new Color(51,102,55));
           
           
       }
       
       
       
   }
   public void setOnLogin(String on){
       this.onLogin = on;
   }
   public String getOnLogin() {
       return onLogin;
   }
   
   
   
               
   
   
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        shadowRenderer1 = new raven.tabbed.ShadowRenderer();
        sidePanel = new keeptoo.KGradientPanel();
        profilButton = new javax.swing.JButton();
        profilTeks = new javax.swing.JLabel();
        quitButton = new javax.swing.JButton();
        homeButton = new javax.swing.JButton();
        homeTeks = new javax.swing.JLabel();
        quitTeks = new javax.swing.JLabel();
        mainPanel = new javax.swing.JPanel();
        wellcomePane = new javax.swing.JPanel();
        homePan = new javax.swing.JPanel();
        tabbedPaneCustom1 = new raven.tabbed.TabbedPaneCustom();
        mingguPan = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        remove = new javax.swing.JButton();
        showData = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableMinggu = new javax.swing.JTable();
        jButton10 = new javax.swing.JButton();
        seninPan = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();
        remove1 = new javax.swing.JButton();
        showData1 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tableSenin = new javax.swing.JTable();
        jButton11 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        profilPan = new javax.swing.JPanel();
        SetPan = new raven.tabbed.TabbedPaneCustom();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        foto = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        kGradientPanel1 = new keeptoo.KGradientPanel();
        jButton2 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(51, 51, 51));

        sidePanel.setkEndColor(new java.awt.Color(51, 51, 255));
        sidePanel.setkStartColor(new java.awt.Color(255, 0, 204));

        profilButton.setBorder(null);
        profilButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                profilButtonActionPerformed(evt);
            }
        });

        profilTeks.setBackground(new java.awt.Color(255, 255, 255));
        profilTeks.setFont(new java.awt.Font("Bahnschrift", 1, 12)); // NOI18N
        profilTeks.setForeground(new java.awt.Color(255, 255, 255));
        profilTeks.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        profilTeks.setText("Profil");

        quitButton.setBorder(null);
        quitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quitButtonActionPerformed(evt);
            }
        });

        homeButton.setBorder(null);
        homeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                homeButtonActionPerformed(evt);
            }
        });

        homeTeks.setBackground(new java.awt.Color(255, 255, 255));
        homeTeks.setFont(new java.awt.Font("Bahnschrift", 1, 14)); // NOI18N
        homeTeks.setForeground(new java.awt.Color(255, 255, 255));
        homeTeks.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        homeTeks.setText("Home");

        quitTeks.setBackground(new java.awt.Color(255, 255, 255));
        quitTeks.setFont(new java.awt.Font("Bahnschrift", 1, 12)); // NOI18N
        quitTeks.setForeground(new java.awt.Color(255, 255, 255));
        quitTeks.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        quitTeks.setText("Settings");

        javax.swing.GroupLayout sidePanelLayout = new javax.swing.GroupLayout(sidePanel);
        sidePanel.setLayout(sidePanelLayout);
        sidePanelLayout.setHorizontalGroup(
            sidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, sidePanelLayout.createSequentialGroup()
                .addGroup(sidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(sidePanelLayout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(homeTeks, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(sidePanelLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(sidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(homeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(profilButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(3, 3, 3)))
                .addGap(20, 20, 20))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, sidePanelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(profilTeks)
                .addGap(33, 33, 33))
            .addGroup(sidePanelLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(quitTeks, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, sidePanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(quitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
        );
        sidePanelLayout.setVerticalGroup(
            sidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sidePanelLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(homeTeks, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(homeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(profilTeks, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(profilButton, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(quitTeks, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(quitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33))
        );

        wellcomePane.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout wellcomePaneLayout = new javax.swing.GroupLayout(wellcomePane);
        wellcomePane.setLayout(wellcomePaneLayout);
        wellcomePaneLayout.setHorizontalGroup(
            wellcomePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 890, Short.MAX_VALUE)
        );
        wellcomePaneLayout.setVerticalGroup(
            wellcomePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 513, Short.MAX_VALUE)
        );

        homePan.setBackground(new java.awt.Color(255, 255, 255));

        jButton1.setText("add");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        remove.setText("Remove");
        remove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeActionPerformed(evt);
            }
        });

        showData.setText("Refresh");
        showData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showDataActionPerformed(evt);
            }
        });

        tableMinggu.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tableMinggu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Time ", "Activity", "Desctibe", "Cek"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableMinggu.setGridColor(new java.awt.Color(153, 153, 153));
        tableMinggu.setRowHeight(30);
        tableMinggu.setSelectionBackground(new java.awt.Color(102, 204, 255));
        tableMinggu.setSelectionForeground(new java.awt.Color(255, 255, 255));
        tableMinggu.setShowGrid(true);
        tableMinggu.getTableHeader().setReorderingAllowed(false);
        tableMinggu.setUpdateSelectionOnSort(false);
        tableMinggu.setVerifyInputWhenFocusTarget(false);
        jScrollPane2.setViewportView(tableMinggu);
        if (tableMinggu.getColumnModel().getColumnCount() > 0) {
            tableMinggu.getColumnModel().getColumn(0).setResizable(false);
            tableMinggu.getColumnModel().getColumn(1).setResizable(false);
            tableMinggu.getColumnModel().getColumn(2).setResizable(false);
            tableMinggu.getColumnModel().getColumn(3).setResizable(false);
        }

        jButton10.setText("Save");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout mingguPanLayout = new javax.swing.GroupLayout(mingguPan);
        mingguPan.setLayout(mingguPanLayout);
        mingguPanLayout.setHorizontalGroup(
            mingguPanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mingguPanLayout.createSequentialGroup()
                .addGroup(mingguPanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mingguPanLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jButton1)
                        .addGap(45, 45, 45)
                        .addComponent(remove)
                        .addGap(47, 47, 47)
                        .addComponent(jButton10)
                        .addGap(50, 50, 50)
                        .addComponent(showData))
                    .addGroup(mingguPanLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 865, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(17, Short.MAX_VALUE))
        );
        mingguPanLayout.setVerticalGroup(
            mingguPanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mingguPanLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(mingguPanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(remove)
                    .addComponent(showData)
                    .addComponent(jButton10))
                .addContainerGap(10, Short.MAX_VALUE))
        );

        tabbedPaneCustom1.addTab("Minggu", mingguPan);

        jButton3.setText("add");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        remove1.setText("Remove");
        remove1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                remove1ActionPerformed(evt);
            }
        });

        showData1.setText("Refresh");
        showData1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showData1ActionPerformed(evt);
            }
        });

        tableSenin.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        tableSenin.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Time ", "Activity", "Desctibe", "Cek"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableSenin.setGridColor(new java.awt.Color(153, 153, 153));
        tableSenin.setRowHeight(40);
        tableSenin.setSelectionBackground(new java.awt.Color(102, 204, 255));
        tableSenin.setSelectionForeground(new java.awt.Color(255, 255, 255));
        tableSenin.setShowGrid(true);
        jScrollPane3.setViewportView(tableSenin);
        if (tableSenin.getColumnModel().getColumnCount() > 0) {
            tableSenin.getColumnModel().getColumn(0).setResizable(false);
            tableSenin.getColumnModel().getColumn(1).setResizable(false);
            tableSenin.getColumnModel().getColumn(2).setResizable(false);
            tableSenin.getColumnModel().getColumn(3).setResizable(false);
        }

        jButton11.setText("Save");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout seninPanLayout = new javax.swing.GroupLayout(seninPan);
        seninPan.setLayout(seninPanLayout);
        seninPanLayout.setHorizontalGroup(
            seninPanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(seninPanLayout.createSequentialGroup()
                .addGroup(seninPanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(seninPanLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jButton3)
                        .addGap(45, 45, 45)
                        .addComponent(remove1)
                        .addGap(47, 47, 47)
                        .addComponent(jButton11)
                        .addGap(50, 50, 50)
                        .addComponent(showData1))
                    .addGroup(seninPanLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 865, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(17, Short.MAX_VALUE))
        );
        seninPanLayout.setVerticalGroup(
            seninPanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(seninPanLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(seninPanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3)
                    .addComponent(remove1)
                    .addComponent(showData1)
                    .addComponent(jButton11))
                .addContainerGap(10, Short.MAX_VALUE))
        );

        tabbedPaneCustom1.addTab("Senin", seninPan);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 867, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 468, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout homePanLayout = new javax.swing.GroupLayout(homePan);
        homePan.setLayout(homePanLayout);
        homePanLayout.setHorizontalGroup(
            homePanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 899, Short.MAX_VALUE)
            .addGroup(homePanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, homePanLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(tabbedPaneCustom1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
            .addGroup(homePanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(homePanLayout.createSequentialGroup()
                    .addGap(0, 16, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 16, Short.MAX_VALUE)))
        );
        homePanLayout.setVerticalGroup(
            homePanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 513, Short.MAX_VALUE)
            .addGroup(homePanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(tabbedPaneCustom1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(homePanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(homePanLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        profilPan.setBackground(new java.awt.Color(255, 255, 255));
        profilPan.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        SetPan.setSelectedColor(new java.awt.Color(153, 153, 153));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 102, 255), 2, true));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Cabin Sketch", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("First Name");

        jLabel2.setFont(new java.awt.Font("Cabin Sketch", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Last Name");

        jLabel3.setFont(new java.awt.Font("Cabin Sketch", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Email");

        jLabel4.setFont(new java.awt.Font("Cabin Sketch", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Address");

        jLabel6.setFont(new java.awt.Font("Cabin Sketch", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Username");

        foto.setText("ProfilFoto");
        foto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jTextField1.setText("jTextField1");
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jLabel8.setText("jLabel8");

        jLabel9.setText("jLabel8");

        jTextField2.setText("jTextField1");
        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });

        jTextField3.setText("jTextField1");
        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });

        jLabel10.setText("jLabel8");

        jTextField4.setText("jTextField1");
        jTextField4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField4ActionPerformed(evt);
            }
        });

        jLabel11.setText("jLabel8");

        jTextField5.setText("jTextField1");
        jTextField5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField5ActionPerformed(evt);
            }
        });

        jLabel12.setText("jLabel8");

        javax.swing.GroupLayout kGradientPanel1Layout = new javax.swing.GroupLayout(kGradientPanel1);
        kGradientPanel1.setLayout(kGradientPanel1Layout);
        kGradientPanel1Layout.setHorizontalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        kGradientPanel1Layout.setVerticalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jLabel8)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(77, 77, 77)
                        .addComponent(jLabel1))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jLabel10)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(77, 77, 77)
                        .addComponent(jLabel3))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(77, 77, 77)
                        .addComponent(jLabel4))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(77, 77, 77)
                        .addComponent(jLabel6))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jLabel12))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jLabel11))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(77, 77, 77)
                        .addComponent(jLabel2))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jLabel9))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(110, 110, 110)
                        .addComponent(foto, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(77, 77, 77)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(77, 77, 77)
                        .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(77, 77, 77)
                        .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(38, Short.MAX_VALUE))
            .addComponent(kGradientPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(138, 138, 138)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(6, 6, 6)
                        .addComponent(jLabel1)
                        .addGap(6, 6, 6)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(6, 6, 6)
                        .addComponent(jLabel3)
                        .addGap(49, 49, 49)
                        .addComponent(jLabel4))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(116, 116, 116)
                        .addComponent(jLabel6))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(398, 398, 398)
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(333, 333, 333)
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(246, 246, 246)
                        .addComponent(jLabel2))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(204, 204, 204)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(foto, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(397, 397, 397)
                        .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(332, 332, 332)
                        .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(36, 46, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addComponent(kGradientPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jButton2.setBackground(new java.awt.Color(204, 204, 204));
        jButton2.setText("Edit Profile");

        jButton4.setBackground(new java.awt.Color(204, 204, 204));
        jButton4.setText("Change Password");

        jLabel13.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(102, 102, 102));
        jLabel13.setText("Theme :");

        jLabel14.setText("jLabel14");
        jLabel14.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel16.setText("jLabel14");
        jLabel16.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel17.setText("jLabel14");
        jLabel17.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jButton5.setBackground(new java.awt.Color(204, 204, 204));
        jButton5.setText("Theme 1");

        jButton6.setBackground(new java.awt.Color(204, 204, 204));
        jButton6.setText("Theme 2");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setBackground(new java.awt.Color(204, 204, 204));
        jButton7.setText("Theme 3");

        jLabel5.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(102, 102, 102));
        jLabel5.setText("Language");

        jButton8.setBackground(new java.awt.Color(204, 204, 204));
        jButton8.setText("Bahasa");

        jButton9.setBackground(new java.awt.Color(204, 204, 204));
        jButton9.setText("English");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jLabel13))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jButton5)
                        .addGap(31, 31, 31)
                        .addComponent(jButton6)
                        .addGap(34, 34, 34)
                        .addComponent(jButton7))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jLabel5))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jButton8)
                        .addGap(39, 39, 39)
                        .addComponent(jButton9))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jButton2)
                        .addGap(18, 18, 18)
                        .addComponent(jButton4)))
                .addGap(237, 237, 237)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(jLabel13)
                .addGap(11, 11, 11)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton5)
                    .addComponent(jButton6)
                    .addComponent(jButton7))
                .addGap(12, 12, 12)
                .addComponent(jLabel5)
                .addGap(5, 5, 5)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton8)
                    .addComponent(jButton9))
                .addGap(150, 150, 150)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton2)
                    .addComponent(jButton4)))
            .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        SetPan.addTab("Settings", jPanel4);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 875, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 477, Short.MAX_VALUE)
        );

        SetPan.addTab("About Us", jPanel1);

        profilPan.add(SetPan, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 880, 510));

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 899, Short.MAX_VALUE)
            .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(homePan, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(profilPan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(wellcomePane, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 513, Short.MAX_VALUE)
            .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(homePan, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(profilPan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(wellcomePane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(sidePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(sidePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void homeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_homeButtonActionPerformed
        mainPanel.removeAll();
        mainPanel.repaint();
        mainPanel.revalidate();

        mainPanel.add(homePan);
        mainPanel.repaint();
        mainPanel.revalidate();
    }//GEN-LAST:event_homeButtonActionPerformed

    private void quitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quitButtonActionPerformed
       rs  = null;
       st = null;
       String id = null;
        
        int pilihan = JOptionPane.showConfirmDialog(
                null,
                "Apakah anda yakin untuk menutup ?",
                "Konfirmasi",
                JOptionPane.YES_NO_OPTION);
        
        if (pilihan == JOptionPane.YES_OPTION) {
            
           try {
               st = conn.createStatement();
               String query = "Select user_id from users where user_id = "+getAccountID()+"";
               rs = st.executeQuery(query);
               
               if (rs.next()){
                   id = rs.getString("user_id");
                   
                   query = "update users set login_status = false where user_id = " + id;
                   st.executeUpdate(query);
                   System.exit(0);
               } else {
                   JOptionPane.showMessageDialog(null, "Gagal menutup aplikasi");
               }
               
               
           } catch (SQLException ex) {
//               Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, ex.getMessage());
           } catch (Exception e){
               JOptionPane.showMessageDialog(null, e.getMessage());
           }
           
        } else {
            
        }
    }//GEN-LAST:event_quitButtonActionPerformed

    private void profilButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_profilButtonActionPerformed
        // TODO add your handling code here:

        mainPanel.removeAll();
        mainPanel.repaint();
        mainPanel.revalidate();

        mainPanel.add(profilPan);
        mainPanel.repaint();
        mainPanel.revalidate();
    }//GEN-LAST:event_profilButtonActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        // create new activity
        newActivity act = new newActivity();
        act.setVisible(true);
        act.setDay("Minggu");
        act.setIDLogin(onLogin);
        
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void removeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeActionPerformed
        // TODO add your handling code here:
        model = (DefaultTableModel) tableMinggu.getModel();
        int row = tableMinggu.getSelectedRow();
        
        int selectedRow = tableMinggu.getSelectedRow();
        int selectedColumn = tableMinggu.getSelectedColumn();
        
        System.out.println("Data :");
        for (int i = 0; i < selectedColumn; i++) {
            
            Object selectedValue = tableMinggu.getValueAt(i, selectedColumn);
            System.out.println(selectedValue);
        }

                       
        
        
//        try {
//            st = conn.createStatement();
//            String query = "";
//        } catch (SQLException ex) {
//            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
//        }
        
        
        
      
        
        
    }//GEN-LAST:event_removeActionPerformed

    private void showDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showDataActionPerformed
        // remove row
        DefaultTableModel model = (DefaultTableModel) tableMinggu.getModel();
        int rowCount = model.getRowCount();
        if (rowCount > 0) {
            model.setRowCount(0);
        } else {
            JOptionPane.showMessageDialog(this, "Tidak ada baris untuk dihapus", "Peringatan", JOptionPane.WARNING_MESSAGE);
        }
        
        // refresh row
        try {
            showActivity();
        } catch (SQLException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_showDataActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jTextField5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField5ActionPerformed

    private void jTextField4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField4ActionPerformed

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField3ActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        newActivity act = new newActivity();
        act.setVisible(true);
        act.setDay("Senin");
        act.setIDLogin(onLogin);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void remove1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_remove1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_remove1ActionPerformed

    private void showData1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showData1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_showData1ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton11ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
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
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Home().setVisible(true);
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private raven.tabbed.TabbedPaneCustom SetPan;
    private javax.swing.JLabel foto;
    private javax.swing.JButton homeButton;
    private javax.swing.JPanel homePan;
    private javax.swing.JLabel homeTeks;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private keeptoo.KGradientPanel kGradientPanel1;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JPanel mingguPan;
    private javax.swing.JButton profilButton;
    private javax.swing.JPanel profilPan;
    private javax.swing.JLabel profilTeks;
    private javax.swing.JButton quitButton;
    private javax.swing.JLabel quitTeks;
    private javax.swing.JButton remove;
    private javax.swing.JButton remove1;
    private javax.swing.JPanel seninPan;
    private raven.tabbed.ShadowRenderer shadowRenderer1;
    private javax.swing.JButton showData;
    private javax.swing.JButton showData1;
    private keeptoo.KGradientPanel sidePanel;
    private raven.tabbed.TabbedPaneCustom tabbedPaneCustom1;
    private javax.swing.JTable tableMinggu;
    private javax.swing.JTable tableSenin;
    private javax.swing.JPanel wellcomePane;
    // End of variables declaration//GEN-END:variables
}
