/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import static GUI.Home.conn;
import java.sql.PreparedStatement;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author LENOVO
 */
public class Login extends javax.swing.JFrame {

    public static Connection conn;
     

    public Login() {
        initComponents();
        setFrame();
        buttonMouse();
        falseComponents(false);

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql", "root", "root");
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) { 
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }

        ImageIcon icon = new ImageIcon("C:\\Users\\LENOVO\\Documents\\KING JAVA code\\PBOL\\MyRoutine\\src\\Icons\\profilButton.png");
        Image img = icon.getImage();
        Image imgScale = img.getScaledInstance(profilButton.getWidth(), profilButton.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon newIcon = new ImageIcon(imgScale);
        profilButton.setIcon(newIcon);

        ImageIcon icon1 = new ImageIcon("C:\\Users\\LENOVO\\Documents\\KING JAVA code\\PBOL\\MyRoutine\\src\\Icons\\Loginlogo.png");
        Image img1 = icon1.getImage();
        Image imgScale1 = img1.getScaledInstance(logo.getWidth(), logo.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon newIcon1 = new ImageIcon(imgScale1);
        logo.setIcon(newIcon1);

        this.setResizable(false);
        this.setVisible(true);
    }

    public void falseComponents(boolean x) {
        fName.setVisible(x);
        lName.setVisible(x);
        emailTeks.setVisible(x);
        regUser.setVisible(x);
        regPass.setVisible(x);
        back.setVisible(x);
        registrasiButton.setVisible(x);

    }

    public void setFrame() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (screenSize.width - this.getWidth()) / 2;
        int y = (screenSize.height - this.getHeight()) / 2;

        this.setLocation(x, y);
    }

    public boolean cekRegistrasi() {

        JTextField[] inputs = {fName, emailTeks, regUser, regPass};
        int pwd = regPass.getText().length();
        int ema = emailTeks.getText().length();

        for (JTextField text : inputs) {
            if (text.getText().equals("")) {
                cekLab.setText("Note : all fields must be filled in");
                cekLab.setForeground(Color.red);
                return false;
            }
        }

        if (pwd < 8) {     // cek apakah jumlah password >= 8 karakter
            cekLab.setText("Note : password wrong");
            cekLab.setForeground(Color.red);
            return false;
        } else if (ema < 10) {
            cekLab.setText("Note : email wrong");
            cekLab.setForeground(Color.red);
            return false;
        } else {
            return true;
        }

    }

    public void buttonMouse() {

        JButton[] btns = {logIn, signUp, back, registrasiButton};

        for (JButton btn : btns) {

            btn.addMouseListener(new MouseListener() {

                @Override
                public void mouseClicked(MouseEvent e) {
                    btn.setBackground(new Color(0, 153, 153));

                }

                @Override
                public void mousePressed(MouseEvent e) {

                }

                @Override
                public void mouseReleased(MouseEvent e) {
                    btn.setBackground(new Color(0, 153, 153));
                }

                @Override
                public void mouseEntered(MouseEvent e) {
                    btn.setBackground(new Color(153, 153, 153));
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    btn.setBackground(new Color(0, 153, 153));
                }
            });
        }

    }

    public void resetRegistrasiInput() {

        JTextField[] inputs = {lName, fName, emailTeks, regUser, regPass};

        for (JTextField text : inputs) {
            text.setText("");
        }
        cekLab.setText("confirm cek...");
        cekLab.setForeground(Color.white);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        kGradientPanel1 = new keeptoo.KGradientPanel();
        logo = new javax.swing.JLabel();
        mainPanel = new javax.swing.JPanel();
        homePan = new javax.swing.JPanel();
        userLab = new javax.swing.JLabel();
        userTeks = new javax.swing.JTextField();
        pwdLab = new javax.swing.JLabel();
        logIn = new javax.swing.JButton();
        signUp = new javax.swing.JButton();
        pwdTeks = new javax.swing.JPasswordField();
        profilButton = new javax.swing.JLabel();
        regist = new javax.swing.JPanel();
        kGradientPanel2 = new keeptoo.KGradientPanel();
        jPanel1 = new javax.swing.JPanel();
        registrasiButton = new javax.swing.JButton();
        back = new javax.swing.JButton();
        pwdLab1 = new javax.swing.JLabel();
        pwdLab3 = new javax.swing.JLabel();
        pwdLab4 = new javax.swing.JLabel();
        pwdLab5 = new javax.swing.JLabel();
        pwdLab6 = new javax.swing.JLabel();
        pwdLab7 = new javax.swing.JLabel();
        pwdLab2 = new javax.swing.JLabel();
        fName = new javax.swing.JTextField();
        emailTeks = new javax.swing.JTextField();
        regUser = new javax.swing.JTextField();
        lName = new javax.swing.JTextField();
        regPass = new javax.swing.JTextField();
        cekLab = new javax.swing.JLabel();
        cekLab1 = new javax.swing.JLabel();
        pwdLab8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        logo.setText("jLabel1");

        javax.swing.GroupLayout kGradientPanel1Layout = new javax.swing.GroupLayout(kGradientPanel1);
        kGradientPanel1.setLayout(kGradientPanel1Layout);
        kGradientPanel1Layout.setHorizontalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                .addGap(119, 119, 119)
                .addComponent(logo, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(152, Short.MAX_VALUE))
        );
        kGradientPanel1Layout.setVerticalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                .addGap(107, 107, 107)
                .addComponent(logo, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(134, Short.MAX_VALUE))
        );

        homePan.setBackground(new java.awt.Color(255, 255, 255));

        userLab.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        userLab.setForeground(new java.awt.Color(51, 51, 51));
        userLab.setText("Username");

        userTeks.setBackground(new java.awt.Color(51, 51, 51));
        userTeks.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        userTeks.setForeground(new java.awt.Color(255, 255, 255));
        userTeks.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        userTeks.setBorder(null);

        pwdLab.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        pwdLab.setForeground(new java.awt.Color(51, 51, 51));
        pwdLab.setText("Password");

        logIn.setBackground(new java.awt.Color(0, 153, 153));
        logIn.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        logIn.setForeground(new java.awt.Color(255, 255, 255));
        logIn.setText("LOG IN");
        logIn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logInActionPerformed(evt);
            }
        });

        signUp.setBackground(new java.awt.Color(0, 153, 153));
        signUp.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        signUp.setForeground(new java.awt.Color(255, 255, 255));
        signUp.setText("SIGN UP");
        signUp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signUpActionPerformed(evt);
            }
        });

        pwdTeks.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        pwdTeks.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pwdTeks.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));

        profilButton.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout homePanLayout = new javax.swing.GroupLayout(homePan);
        homePan.setLayout(homePanLayout);
        homePanLayout.setHorizontalGroup(
            homePanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(homePanLayout.createSequentialGroup()
                .addGroup(homePanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(homePanLayout.createSequentialGroup()
                        .addGap(230, 230, 230)
                        .addComponent(pwdLab))
                    .addGroup(homePanLayout.createSequentialGroup()
                        .addGap(152, 152, 152)
                        .addGroup(homePanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(userTeks, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(homePanLayout.createSequentialGroup()
                                .addComponent(logIn, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(signUp))
                            .addComponent(pwdTeks)))
                    .addGroup(homePanLayout.createSequentialGroup()
                        .addGap(226, 226, 226)
                        .addGroup(homePanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(userLab, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(profilButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(174, Short.MAX_VALUE))
        );
        homePanLayout.setVerticalGroup(
            homePanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(homePanLayout.createSequentialGroup()
                .addGap(83, 83, 83)
                .addComponent(profilButton, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(userLab)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(userTeks, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(pwdLab)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pwdTeks, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(homePanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(logIn, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(signUp, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(161, Short.MAX_VALUE))
        );

        regist.setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));

        registrasiButton.setBackground(new java.awt.Color(0, 153, 153));
        registrasiButton.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        registrasiButton.setForeground(new java.awt.Color(255, 255, 255));
        registrasiButton.setText("SIGN UP");
        registrasiButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registrasiButtonActionPerformed(evt);
            }
        });

        back.setBackground(new java.awt.Color(0, 153, 153));
        back.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        back.setForeground(new java.awt.Color(255, 255, 255));
        back.setText("BACK");
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });

        pwdLab1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        pwdLab1.setForeground(new java.awt.Color(255, 255, 255));
        pwdLab1.setText("NEW ACCOUNT");

        pwdLab3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        pwdLab3.setForeground(new java.awt.Color(255, 255, 255));
        pwdLab3.setText("Last Name ");

        pwdLab4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        pwdLab4.setForeground(new java.awt.Color(255, 255, 255));
        pwdLab4.setText("email");

        pwdLab5.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        pwdLab5.setForeground(new java.awt.Color(255, 255, 255));

        pwdLab6.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        pwdLab6.setForeground(new java.awt.Color(255, 255, 255));

        pwdLab7.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        pwdLab7.setForeground(new java.awt.Color(255, 255, 255));
        pwdLab7.setText("Password");

        pwdLab2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        pwdLab2.setForeground(new java.awt.Color(255, 255, 255));
        pwdLab2.setText("First Name");

        fName.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        fName.setHorizontalAlignment(javax.swing.JTextField.LEFT);

        emailTeks.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        emailTeks.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        emailTeks.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailTeksActionPerformed(evt);
            }
        });

        regUser.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        regUser.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        regUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                regUserActionPerformed(evt);
            }
        });

        lName.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lName.setHorizontalAlignment(javax.swing.JTextField.LEFT);

        regPass.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        regPass.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        regPass.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                regPassInputMethodTextChanged(evt);
            }
        });

        cekLab.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        cekLab.setForeground(new java.awt.Color(255, 255, 255));
        cekLab.setText("confirm cek...");

        cekLab1.setForeground(new java.awt.Color(255, 255, 255));
        cekLab1.setText("(at least 8 character)");

        pwdLab8.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        pwdLab8.setForeground(new java.awt.Color(255, 255, 255));
        pwdLab8.setText("Username");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(back, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pwdLab6)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(34, 34, 34)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(pwdLab4)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(pwdLab2)
                                            .addComponent(pwdLab3))
                                        .addComponent(pwdLab5)
                                        .addComponent(pwdLab7)
                                        .addComponent(pwdLab8))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(15, 15, 15)
                                        .addComponent(pwdLab1)))))
                        .addGap(9, 9, 9)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addComponent(registrasiButton))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(cekLab)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(emailTeks, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(fName, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(regUser, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lName, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(regPass, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(cekLab1))))
                .addContainerGap(48, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(pwdLab1)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                        .addComponent(cekLab)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(pwdLab2)
                            .addComponent(fName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(24, 24, 24)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(pwdLab3)
                            .addComponent(lName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(24, 24, 24)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(pwdLab4)
                            .addComponent(emailTeks, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(pwdLab5)
                            .addComponent(regUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pwdLab8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(pwdLab7)
                            .addComponent(regPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(pwdLab6))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cekLab1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(registrasiButton, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(back, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22))
        );

        javax.swing.GroupLayout kGradientPanel2Layout = new javax.swing.GroupLayout(kGradientPanel2);
        kGradientPanel2.setLayout(kGradientPanel2Layout);
        kGradientPanel2Layout.setHorizontalGroup(
            kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel2Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );
        kGradientPanel2Layout.setVerticalGroup(
            kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel2Layout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );

        javax.swing.GroupLayout registLayout = new javax.swing.GroupLayout(regist);
        regist.setLayout(registLayout);
        registLayout.setHorizontalGroup(
            registLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(registLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(kGradientPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(44, Short.MAX_VALUE))
        );
        registLayout.setVerticalGroup(
            registLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(registLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(kGradientPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(36, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 547, Short.MAX_VALUE)
            .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(homePan, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(regist, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 500, Short.MAX_VALUE)
            .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(homePan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(regist, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(kGradientPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 547, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addGap(0, 453, Short.MAX_VALUE)
                    .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(kGradientPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void logInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logInActionPerformed
        // TODO add your handling code here:
        String user = userTeks.getText();
        char[] pw = pwdTeks.getPassword();
        String pass = new String(pw);
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql", "root", "root");
            
            ResultSet rs = null;
        
            Statement st = conn.createStatement();
            String query = "Select * from users where username ='" + user + "' and password = '" + pass + "'";
            rs = st.executeQuery(query);
            
            if (rs.next()) {
                st = conn.createStatement();
                String query3 = "Select user_id from users where username like +'"+user+"'";
                rs = st.executeQuery(query3);
                String save_id = null;
                        
                if (rs.next()) {
                    System.out.println("Berhasil");
                    System.out.println(rs.getString("user_id"));
                    save_id = rs.getString("user_id");
                } else {
                    System.out.println("Gagal");

                }
            
                String query2 = "update users set login_status = true where user_id = "+save_id;
                st.executeUpdate(query2);
                int count = st.getUpdateCount();
                
                if (count==0){
                    System.out.println("Ggagal coi");
                } else {
                    st = conn.createStatement();
                    query = "Select user_id from users where username like '"+user+"'";
                    rs = st.executeQuery(query);
                    
                    if (rs.next()) {
                        
                        dispose();
                        Home home = new Home();
                        
                        String id = rs.getString("user_id");
                        home.setOnLogin(id);                       

                    } else {
                        JOptionPane.showMessageDialog(null, "Gagal");
                    }
                   
                    
                }
              
            } else {
                JOptionPane.showMessageDialog(null, "Gagal");
            }

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_logInActionPerformed

    private void registrasiButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registrasiButtonActionPerformed
        // Cek apakah data terisi semua
        if (cekRegistrasi() != true) {
            JOptionPane.showMessageDialog(null, "Gagal 1");
        } else {

            ResultSet pw;

            try {
               
                Statement stmt = conn.createStatement();

                String query = "SELECT password FROM users WHERE username like '" + regUser.getText() + "' or "
                        + "email like '" + emailTeks.getText() + "'";
                pw = stmt.executeQuery(query);

                if (pw.next()) {
                    cekLab.setText("Note : Username or email is already in used");
                    cekLab.setForeground(Color.red);
                    JOptionPane.showMessageDialog(null, "Gagal");
                } else {
                    // tambahkan username dan password ke table
                    String query1 = "INSERT INTO users (username, password, first_name, last_name, email)\n"
                            + "VALUES ('" + regUser.getText() + "', '" + regPass.getText() + "', '" + fName.getText() + "','" + lName.getText() + "','" + emailTeks.getText() + "');";

                    stmt.executeUpdate(query1);
                    int count = stmt.getUpdateCount();
                    JOptionPane.showMessageDialog(null, "Account complete, Login!");

                    // kembali ke halaman login
                    mainPanel.removeAll();
                    mainPanel.repaint();
                    mainPanel.revalidate();

                    resetRegistrasiInput();

                    mainPanel.add(homePan);
                    mainPanel.repaint();
                    mainPanel.revalidate();

                }
            } catch (SQLException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }//GEN-LAST:event_registrasiButtonActionPerformed

    private void signUpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signUpActionPerformed
        // TODO add your handling code here:
        mainPanel.removeAll();
        mainPanel.repaint();
        mainPanel.revalidate();

        falseComponents(true);

        mainPanel.add(regist);
        mainPanel.repaint();
        mainPanel.revalidate();


    }//GEN-LAST:event_signUpActionPerformed

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        mainPanel.removeAll();
        mainPanel.repaint();
        mainPanel.revalidate();

        resetRegistrasiInput();
        mainPanel.add(homePan);
        mainPanel.repaint();
        mainPanel.revalidate();
    }//GEN-LAST:event_backActionPerformed

    private void emailTeksActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailTeksActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emailTeksActionPerformed

    private void regPassInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_regPassInputMethodTextChanged
        // TODO add your handling code here:


    }//GEN-LAST:event_regPassInputMethodTextChanged

    private void regUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_regUserActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_regUserActionPerformed

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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton back;
    private javax.swing.JLabel cekLab;
    private javax.swing.JLabel cekLab1;
    private javax.swing.JTextField emailTeks;
    private javax.swing.JTextField fName;
    private javax.swing.JPanel homePan;
    private javax.swing.JPanel jPanel1;
    private keeptoo.KGradientPanel kGradientPanel1;
    private keeptoo.KGradientPanel kGradientPanel2;
    private javax.swing.JTextField lName;
    private javax.swing.JButton logIn;
    private javax.swing.JLabel logo;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JLabel profilButton;
    private javax.swing.JLabel pwdLab;
    private javax.swing.JLabel pwdLab1;
    private javax.swing.JLabel pwdLab2;
    private javax.swing.JLabel pwdLab3;
    private javax.swing.JLabel pwdLab4;
    private javax.swing.JLabel pwdLab5;
    private javax.swing.JLabel pwdLab6;
    private javax.swing.JLabel pwdLab7;
    private javax.swing.JLabel pwdLab8;
    private javax.swing.JPasswordField pwdTeks;
    private javax.swing.JTextField regPass;
    private javax.swing.JTextField regUser;
    private javax.swing.JPanel regist;
    private javax.swing.JButton registrasiButton;
    private javax.swing.JButton signUp;
    private javax.swing.JLabel userLab;
    private javax.swing.JTextField userTeks;
    // End of variables declaration//GEN-END:variables
}
