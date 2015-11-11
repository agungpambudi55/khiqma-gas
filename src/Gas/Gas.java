package Gas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import javafx.scene.paint.Color;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
public class Gas extends javax.swing.JFrame {
    private static Connection config;
    private DefaultTableModel tabel;
    public Gas() {
        this.setLocation(200, 100);
        initComponents();
        tabel=new DefaultTableModel();
        this.tabel_gas.setModel(tabel); 
        tabel.addColumn("ID");
        tabel.addColumn("Nama Produk");
        tabel.addColumn("Ukuran Tabung");
        tabel.addColumn("Harga Grosir");
        tabel.addColumn("Harga Eceran");  
        tabel.addColumn("Stok Terisi");
        tabel.addColumn("Stok Kosong");
        TableColumn column;
        tabel_gas.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        column = tabel_gas.getColumnModel().getColumn(0);
        column.setPreferredWidth(0);
        column = tabel_gas.getColumnModel().getColumn(1);
        column.setPreferredWidth(173);
        column = tabel_gas.getColumnModel().getColumn(2);
        column.setPreferredWidth(100);
        column = tabel_gas.getColumnModel().getColumn(3);
        column.setPreferredWidth(110);
        column = tabel_gas.getColumnModel().getColumn(4);
        column.setPreferredWidth(110);
        column = tabel_gas.getColumnModel().getColumn(5);
        column.setPreferredWidth(80);        
        column = tabel_gas.getColumnModel().getColumn(6);
        column.setPreferredWidth(80);
        segarkan_data();        
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            public void run() {
                DateFormat dateFormat1 = new SimpleDateFormat("HH : mm : ss");
                Date date1 = new Date();
                jLabel_Waktu.setText(dateFormat1.format(date1));
                DateFormat dateFormat2 = new SimpleDateFormat("dd");
                Date date2 = new Date();
                jLabel_Tanggal.setText(dateFormat2.format(date2));
                DateFormat dateFormat3 = new SimpleDateFormat("MMMMM");
                Date date3 = new Date();
                jLabel_Bulan.setText(dateFormat3.format(date3));
                DateFormat dateFormat4 = new SimpleDateFormat("yyyy");
                Date date4 = new Date();
                jLabel2.setText(dateFormat4.format(date4));
            }
        }, 0, 1000);
    }
    private static Connection connect() {
        if (config==null) {
            try {
                String url="jdbc:mysql://localhost:3306/db_khiqma";
                String user="root"; 
                String password="";
                DriverManager.registerDriver(new com.mysql.jdbc.Driver());
                config=DriverManager.getConnection(url,user,password);

            }catch (SQLException x) {
                System.out.println("Connection Error");
            }
        }
        return config;
    }
    private void segarkan_data(){    
        tabel.getDataVector().removeAllElements();
        tabel.fireTableDataChanged();
        try {            
            Connection c=connect();
            Statement s= c.createStatement();
            String sql="SELECT * FROM tb_gas ORDER BY `nama` ASC";
            ResultSet r=s.executeQuery(sql);        
             while (r.next()) {
                Object[] o=new Object[7];
                o[0]=r.getString("id_gas");
                o[1]=r.getString("nama");
                o[2]=r.getString("ukuran");
                o[3]=r.getString("hrg_grosir");
                o[4]=r.getString("hrg_eceran");
                o[5]=r.getString("stok_terisi");
                o[6]=r.getString("stok_kosong");
                tabel.addRow(o);
            }
            r.close();
            s.close();
            ambil_data();
            this.lblkode.setText("-");
        }catch(SQLException e) {
            JOptionPane.showMessageDialog(this, "Terjadi Kesalahan");
        }
    }
    private void ambil_data(){
        int i=this.tabel_gas.getSelectedRow();
        if(i==-1){return;}
        String id=(String) tabel.getValueAt(i, 0);
        this.lblkode.setText(id);
        String dt1=(String) tabel.getValueAt(i, 1);
        this.jtxt_nama.setText(dt1);
        String dt2=(String) tabel.getValueAt(i, 2);
        this.jtxt_ukuran.setText(dt2);
        String dt3=(String) tabel.getValueAt(i, 3);        
        this.jtxt_grosir.setText(dt3);
        String dt4=(String) tabel.getValueAt(i, 4);
        this.jtxt_ecer.setText(dt4);
        String dt5=(String) tabel.getValueAt(i, 5); 
        this.jtxt_terisi.setText(dt5);
        String dt6=(String) tabel.getValueAt(i, 6); 
        this.jtxt_kosong.setText(dt6);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel_Top = new javax.swing.JPanel();
        jPanel_Exit = new javax.swing.JPanel();
        jButton_Exit = new javax.swing.JButton();
        jLabel_Title = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel_Menu = new javax.swing.JLabel();
        jPanel_Menu = new javax.swing.JPanel();
        jPanel_Mn1 = new javax.swing.JPanel();
        jLabel_Mn1 = new javax.swing.JLabel();
        jPanel_Mn2 = new javax.swing.JPanel();
        jLabel_Mn2 = new javax.swing.JLabel();
        jPanel_Mn3 = new javax.swing.JPanel();
        jLabel_Mn3 = new javax.swing.JLabel();
        jPanel_Mn4 = new javax.swing.JPanel();
        jLabel_Mn4 = new javax.swing.JLabel();
        jPanel_Mn5 = new javax.swing.JPanel();
        jLabel_Mn5 = new javax.swing.JLabel();
        jLabel_Waktu = new javax.swing.JLabel();
        jLabel_Tanggal = new javax.swing.JLabel();
        jLabel_Bulan = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel_Mn7 = new javax.swing.JPanel();
        jLabel_Mn7 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        label_tambah = new java.awt.Label();
        label_edit = new java.awt.Label();
        label_hapus = new java.awt.Label();
        label_cari = new java.awt.Label();
        label_segar = new java.awt.Label();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabel_gas = new javax.swing.JTable();
        lblkode = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jtxt_nama = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jtxt_kosong = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jtxt_terisi = new javax.swing.JTextField();
        jPanel8 = new javax.swing.JPanel();
        jtxt_ecer = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jtxt_grosir = new javax.swing.JTextField();
        label1 = new java.awt.Label();
        jLabel8 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jtxt_ukuran = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 51)));

        jPanel_Top.setBackground(new java.awt.Color(0, 102, 51));

        jPanel_Exit.setBackground(new java.awt.Color(0, 102, 51));

        jButton_Exit.setBackground(new java.awt.Color(255, 255, 255));
        jButton_Exit.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jButton_Exit.setForeground(new java.awt.Color(255, 255, 255));
        jButton_Exit.setText("x");
        jButton_Exit.setBorder(null);
        jButton_Exit.setContentAreaFilled(false);
        jButton_Exit.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButton_Exit.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton_Exit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton_ExitMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton_ExitMouseExited(evt);
            }
        });
        jButton_Exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_ExitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel_ExitLayout = new javax.swing.GroupLayout(jPanel_Exit);
        jPanel_Exit.setLayout(jPanel_ExitLayout);
        jPanel_ExitLayout.setHorizontalGroup(
            jPanel_ExitLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel_ExitLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButton_Exit, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel_ExitLayout.setVerticalGroup(
            jPanel_ExitLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel_ExitLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButton_Exit, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jLabel_Title.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel_Title.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_Title.setText("Aplikasi Khiqma Gas");

        jLabel3.setIcon(new javax.swing.ImageIcon("E:\\Khiqma Project\\Khiqma\\img\\1 icon.png")); // NOI18N

        javax.swing.GroupLayout jPanel_TopLayout = new javax.swing.GroupLayout(jPanel_Top);
        jPanel_Top.setLayout(jPanel_TopLayout);
        jPanel_TopLayout.setHorizontalGroup(
            jPanel_TopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel_TopLayout.createSequentialGroup()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel_Title, javax.swing.GroupLayout.PREFERRED_SIZE, 778, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel_Exit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel_TopLayout.setVerticalGroup(
            jPanel_TopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel_TopLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel_TopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addGroup(jPanel_TopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jPanel_Exit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel_Title, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        jLabel_Menu.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel_Menu.setForeground(new java.awt.Color(0, 102, 51));
        jLabel_Menu.setIcon(new javax.swing.ImageIcon("E:\\Khiqma Project\\Khiqma\\img\\2 icon.png")); // NOI18N
        jLabel_Menu.setText("  Menu");
        jLabel_Menu.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 51)));

        jPanel_Menu.setBackground(new java.awt.Color(0, 102, 51));
        jPanel_Menu.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 51)));

        jPanel_Mn1.setBackground(new java.awt.Color(112, 195, 155));
        jPanel_Mn1.setForeground(new java.awt.Color(255, 255, 255));

        jLabel_Mn1.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel_Mn1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Mn1.setIcon(new javax.swing.ImageIcon("E:\\Khiqma Project\\Khiqma\\img\\menu1.png")); // NOI18N
        jLabel_Mn1.setText("  Gas");
        jLabel_Mn1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel_Mn1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel_Mn1MouseExited(evt);
            }
        });

        javax.swing.GroupLayout jPanel_Mn1Layout = new javax.swing.GroupLayout(jPanel_Mn1);
        jPanel_Mn1.setLayout(jPanel_Mn1Layout);
        jPanel_Mn1Layout.setHorizontalGroup(
            jPanel_Mn1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel_Mn1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel_Mn1Layout.setVerticalGroup(
            jPanel_Mn1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel_Mn1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel_Mn2.setBackground(new java.awt.Color(0, 102, 51));

        jLabel_Mn2.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel_Mn2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Mn2.setIcon(new javax.swing.JLabel() {
            public javax.swing.Icon getIcon() {
                try {
                    return new javax.swing.ImageIcon(
                        new java.net.URL("file:/E:/Khiqma Project/Khiqma/img/menu2.png")
                    );
                } catch (java.net.MalformedURLException e) {
                }
                return null;
            }
        }.getIcon());
        jLabel_Mn2.setText("  Transaksi");
        jLabel_Mn2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel_Mn2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel_Mn2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel_Mn2MouseExited(evt);
            }
        });

        javax.swing.GroupLayout jPanel_Mn2Layout = new javax.swing.GroupLayout(jPanel_Mn2);
        jPanel_Mn2.setLayout(jPanel_Mn2Layout);
        jPanel_Mn2Layout.setHorizontalGroup(
            jPanel_Mn2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel_Mn2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel_Mn2Layout.setVerticalGroup(
            jPanel_Mn2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel_Mn2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel_Mn2))
        );

        jPanel_Mn3.setBackground(new java.awt.Color(0, 102, 51));

        jLabel_Mn3.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel_Mn3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Mn3.setIcon(new javax.swing.ImageIcon("E:\\Khiqma Project\\Khiqma\\img\\menu3.png")); // NOI18N
        jLabel_Mn3.setText("  Penghasilan");
        jLabel_Mn3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel_Mn3MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel_Mn3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel_Mn3MouseExited(evt);
            }
        });

        javax.swing.GroupLayout jPanel_Mn3Layout = new javax.swing.GroupLayout(jPanel_Mn3);
        jPanel_Mn3.setLayout(jPanel_Mn3Layout);
        jPanel_Mn3Layout.setHorizontalGroup(
            jPanel_Mn3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel_Mn3, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
        );
        jPanel_Mn3Layout.setVerticalGroup(
            jPanel_Mn3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel_Mn3Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel_Mn3))
        );

        jPanel_Mn4.setBackground(new java.awt.Color(0, 102, 51));

        jLabel_Mn4.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel_Mn4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Mn4.setIcon(new javax.swing.JLabel() {
            public javax.swing.Icon getIcon() {
                try {
                    return new javax.swing.ImageIcon(
                        new java.net.URL("file:/E:/Khiqma Project/Khiqma/img/menu0.png")
                    );
                } catch (java.net.MalformedURLException e) {
                }
                return null;
            }
        }.getIcon());
        jLabel_Mn4.setText("  Beranda");
        jLabel_Mn4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel_Mn4MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel_Mn4MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel_Mn4MouseExited(evt);
            }
        });

        javax.swing.GroupLayout jPanel_Mn4Layout = new javax.swing.GroupLayout(jPanel_Mn4);
        jPanel_Mn4.setLayout(jPanel_Mn4Layout);
        jPanel_Mn4Layout.setHorizontalGroup(
            jPanel_Mn4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel_Mn4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel_Mn4Layout.setVerticalGroup(
            jPanel_Mn4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel_Mn4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel_Mn5.setBackground(new java.awt.Color(0, 102, 51));

        jLabel_Mn5.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel_Mn5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Mn5.setIcon(new javax.swing.JLabel() {
            public javax.swing.Icon getIcon() {
                try {
                    return new javax.swing.ImageIcon(
                        new java.net.URL("file:/E:/Khiqma Project/Khiqma/img/menu5.png")
                    );
                } catch (java.net.MalformedURLException e) {
                }
                return null;
            }
        }.getIcon());
        jLabel_Mn5.setText("  Keluar");
        jLabel_Mn5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel_Mn5MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel_Mn5MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel_Mn5MouseExited(evt);
            }
        });

        javax.swing.GroupLayout jPanel_Mn5Layout = new javax.swing.GroupLayout(jPanel_Mn5);
        jPanel_Mn5.setLayout(jPanel_Mn5Layout);
        jPanel_Mn5Layout.setHorizontalGroup(
            jPanel_Mn5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel_Mn5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel_Mn5Layout.setVerticalGroup(
            jPanel_Mn5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel_Mn5Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel_Mn5))
        );

        jLabel_Waktu.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel_Waktu.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Waktu.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_Waktu.setText("10 : 10 : 10");

        jLabel_Tanggal.setFont(new java.awt.Font("Century Gothic", 0, 38)); // NOI18N
        jLabel_Tanggal.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Tanggal.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel_Tanggal.setText("12");

        jLabel_Bulan.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel_Bulan.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Bulan.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel_Bulan.setText("January");

        jLabel2.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("2016");

        jPanel_Mn7.setBackground(new java.awt.Color(0, 102, 51));

        jLabel_Mn7.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel_Mn7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Mn7.setIcon(new javax.swing.JLabel() {
            public javax.swing.Icon getIcon() {
                try {
                    return new javax.swing.ImageIcon(
                        new java.net.URL("file:/E:/Khiqma Project/Khiqma/img/menu6.png")
                    );
                } catch (java.net.MalformedURLException e) {
                }
                return null;
            }
        }.getIcon());
        jLabel_Mn7.setText("  Informasi");
        jLabel_Mn7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel_Mn7MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel_Mn7MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel_Mn7MouseExited(evt);
            }
        });

        javax.swing.GroupLayout jPanel_Mn7Layout = new javax.swing.GroupLayout(jPanel_Mn7);
        jPanel_Mn7.setLayout(jPanel_Mn7Layout);
        jPanel_Mn7Layout.setHorizontalGroup(
            jPanel_Mn7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel_Mn7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel_Mn7Layout.setVerticalGroup(
            jPanel_Mn7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel_Mn7Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel_Mn7))
        );

        javax.swing.GroupLayout jPanel_MenuLayout = new javax.swing.GroupLayout(jPanel_Menu);
        jPanel_Menu.setLayout(jPanel_MenuLayout);
        jPanel_MenuLayout.setHorizontalGroup(
            jPanel_MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel_Mn1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel_Mn2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel_Mn3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel_Mn4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel_MenuLayout.createSequentialGroup()
                .addComponent(jLabel_Tanggal, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel_MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel_Bulan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
            .addGroup(jPanel_MenuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel_Waktu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jPanel_Mn7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel_Mn5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel_MenuLayout.setVerticalGroup(
            jPanel_MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_MenuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel_Mn4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel_Mn1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel_Mn2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel_Mn3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel_Mn7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel_Mn5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 79, Short.MAX_VALUE)
                .addGroup(jPanel_MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel_MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel_Tanggal, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel_Bulan, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel_Waktu, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        label_tambah.setAlignment(java.awt.Label.CENTER);
        label_tambah.setBackground(new java.awt.Color(0, 102, 51));
        label_tambah.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        label_tambah.setForeground(new java.awt.Color(255, 255, 255));
        label_tambah.setText("Tambah");
        label_tambah.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                label_tambahMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                label_tambahMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                label_tambahMouseExited(evt);
            }
        });

        label_edit.setAlignment(java.awt.Label.CENTER);
        label_edit.setBackground(new java.awt.Color(0, 102, 51));
        label_edit.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        label_edit.setForeground(new java.awt.Color(255, 255, 255));
        label_edit.setText("Edit");
        label_edit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                label_editMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                label_editMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                label_editMouseExited(evt);
            }
        });

        label_hapus.setAlignment(java.awt.Label.CENTER);
        label_hapus.setBackground(new java.awt.Color(0, 102, 51));
        label_hapus.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        label_hapus.setForeground(new java.awt.Color(255, 255, 255));
        label_hapus.setText("Hapus");
        label_hapus.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                label_hapusMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                label_hapusMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                label_hapusMouseExited(evt);
            }
        });

        label_cari.setAlignment(java.awt.Label.CENTER);
        label_cari.setBackground(new java.awt.Color(0, 102, 51));
        label_cari.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        label_cari.setForeground(new java.awt.Color(255, 255, 255));
        label_cari.setText("Cari");
        label_cari.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                label_cariMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                label_cariMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                label_cariMouseExited(evt);
            }
        });

        label_segar.setAlignment(java.awt.Label.CENTER);
        label_segar.setBackground(new java.awt.Color(0, 102, 51));
        label_segar.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        label_segar.setForeground(new java.awt.Color(255, 255, 255));
        label_segar.setText("Segarkan");
        label_segar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                label_segarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                label_segarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                label_segarMouseExited(evt);
            }
        });

        tabel_gas.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        tabel_gas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabel_gas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tabel_gas.setIntercellSpacing(new java.awt.Dimension(2, 2));
        tabel_gas.setRequestFocusEnabled(false);
        tabel_gas.setRowHeight(24);
        tabel_gas.setSelectionBackground(new java.awt.Color(0, 102, 51));
        tabel_gas.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tabel_gas.setShowVerticalLines(false);
        tabel_gas.getTableHeader().setResizingAllowed(false);
        tabel_gas.getTableHeader().setReorderingAllowed(false);
        tabel_gas.setUpdateSelectionOnSort(false);
        tabel_gas.setVerifyInputWhenFocusTarget(false);
        tabel_gas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabel_gasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabel_gas);

        lblkode.setForeground(new java.awt.Color(204, 204, 204));
        lblkode.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblkode.setText("-");

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 51)));

        jtxt_nama.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jtxt_nama.setBorder(null);
        jtxt_nama.setSelectionColor(new java.awt.Color(102, 102, 102));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jtxt_nama)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jtxt_nama, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        jLabel1.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 102, 51));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("Nama Produk Gas");

        jLabel4.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 102, 51));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel4.setText("Stok Tabung Kosong");

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 51)));

        jtxt_kosong.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jtxt_kosong.setBorder(null);
        jtxt_kosong.setSelectionColor(new java.awt.Color(102, 102, 102));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jtxt_kosong, javax.swing.GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jtxt_kosong, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        jLabel5.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 102, 51));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Harga Grosir");

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 51)));

        jtxt_terisi.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jtxt_terisi.setBorder(null);
        jtxt_terisi.setSelectionColor(new java.awt.Color(102, 102, 102));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jtxt_terisi, javax.swing.GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jtxt_terisi, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));
        jPanel8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 51)));

        jtxt_ecer.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jtxt_ecer.setBorder(null);
        jtxt_ecer.setSelectionColor(new java.awt.Color(102, 102, 102));

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jtxt_ecer)
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jtxt_ecer, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        jLabel6.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 102, 51));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel6.setText("Harga Eceran");

        jLabel7.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 102, 51));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("Stok Tabung Terisi");

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));
        jPanel9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 51)));

        jtxt_grosir.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jtxt_grosir.setBorder(null);
        jtxt_grosir.setSelectionColor(new java.awt.Color(102, 102, 102));

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jtxt_grosir, javax.swing.GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jtxt_grosir, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        label1.setAlignment(java.awt.Label.CENTER);
        label1.setBackground(new java.awt.Color(0, 102, 51));
        label1.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        label1.setForeground(new java.awt.Color(255, 255, 255));
        label1.setText("Pengelolaan Data Gas");

        jLabel8.setBackground(new java.awt.Color(255, 255, 255));
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("11");

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));
        jPanel10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 51)));

        jtxt_ukuran.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jtxt_ukuran.setBorder(null);
        jtxt_ukuran.setSelectionColor(new java.awt.Color(102, 102, 102));

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jtxt_ukuran, javax.swing.GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jtxt_ukuran, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        jLabel9.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 102, 51));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel9.setText("Ukuran Tabung Gas");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(label_tambah, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(label_edit, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(label_hapus, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblkode, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(114, 114, 114)
                        .addComponent(label_cari, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(label_segar, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(label1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(10, 10, 10)
                                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(3, 3, 3)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1)
                .addGap(16, 16, 16))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(label_segar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(label_cari, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(label_hapus, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(label_edit, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(label_tambah, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblkode, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(jLabel8)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel_Top, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel_Menu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel_Menu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel_Top, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel_Menu)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel_Menu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(58, Short.MAX_VALUE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_ExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_ExitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jButton_ExitActionPerformed

    private void jButton_ExitMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton_ExitMouseExited
        jPanel_Exit.setBackground(new java.awt.Color(0, 102, 51));
        jButton_Exit.setForeground(new java.awt.Color(255, 255, 255));
    }//GEN-LAST:event_jButton_ExitMouseExited

    private void jButton_ExitMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton_ExitMouseEntered
        // TODO add your handling code here:
        jPanel_Exit.setBackground(new java.awt.Color(255, 255, 255));
        jButton_Exit.setForeground(new java.awt.Color(0, 102, 51));
    }//GEN-LAST:event_jButton_ExitMouseEntered

    private void jLabel_Mn1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_Mn1MouseEntered
        jPanel_Mn1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel_Mn1.setForeground(new java.awt.Color(0, 102, 51));
    }//GEN-LAST:event_jLabel_Mn1MouseEntered

    private void jLabel_Mn2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_Mn2MouseEntered
        jPanel_Mn2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel_Mn2.setForeground(new java.awt.Color(0, 102, 51));
    }//GEN-LAST:event_jLabel_Mn2MouseEntered

    private void jLabel_Mn3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_Mn3MouseEntered
        jPanel_Mn3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel_Mn3.setForeground(new java.awt.Color(0, 102, 51));
    }//GEN-LAST:event_jLabel_Mn3MouseEntered

    private void jLabel_Mn1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_Mn1MouseExited
        jPanel_Mn1.setBackground(new java.awt.Color(112,195,155));
        jLabel_Mn1.setForeground(new java.awt.Color(255, 255, 255));
    }//GEN-LAST:event_jLabel_Mn1MouseExited

    private void jLabel_Mn2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_Mn2MouseExited
        jPanel_Mn2.setBackground(new java.awt.Color(0, 102, 51));
        jLabel_Mn2.setForeground(new java.awt.Color(255, 255, 255));
    }//GEN-LAST:event_jLabel_Mn2MouseExited

    private void jLabel_Mn3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_Mn3MouseExited
        jPanel_Mn3.setBackground(new java.awt.Color(0, 102, 51));
        jLabel_Mn3.setForeground(new java.awt.Color(255, 255, 255));
    }//GEN-LAST:event_jLabel_Mn3MouseExited

    private void jLabel_Mn4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_Mn4MouseEntered
        jPanel_Mn4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel_Mn4.setForeground(new java.awt.Color(0, 102, 51));
    }//GEN-LAST:event_jLabel_Mn4MouseEntered

    private void jLabel_Mn4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_Mn4MouseExited
        jPanel_Mn4.setBackground(new java.awt.Color(0, 102, 51));
        jLabel_Mn4.setForeground(new java.awt.Color(255, 255, 255));
    }//GEN-LAST:event_jLabel_Mn4MouseExited

    private void jLabel_Mn5MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_Mn5MouseEntered
        jPanel_Mn5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel_Mn5.setForeground(new java.awt.Color(0, 102, 51));
    }//GEN-LAST:event_jLabel_Mn5MouseEntered

    private void jLabel_Mn5MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_Mn5MouseExited
        jPanel_Mn5.setBackground(new java.awt.Color(0, 102, 51));
        jLabel_Mn5.setForeground(new java.awt.Color(255, 255, 255));
    }//GEN-LAST:event_jLabel_Mn5MouseExited

    private void jLabel_Mn5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_Mn5MouseClicked
        System.exit(0);
    }//GEN-LAST:event_jLabel_Mn5MouseClicked

    private void jLabel_Mn4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_Mn4MouseClicked
        Home hm = new Home();
        hm.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel_Mn4MouseClicked

    private void label_tambahMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label_tambahMouseEntered
        label_tambah.setBackground(new java.awt.Color(112,195,155));
    }//GEN-LAST:event_label_tambahMouseEntered

    private void label_editMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label_editMouseEntered
        label_edit.setBackground(new java.awt.Color(112,195,155));
    }//GEN-LAST:event_label_editMouseEntered

    private void label_editMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label_editMouseExited
        label_edit.setBackground(new java.awt.Color(0, 102, 51));
    }//GEN-LAST:event_label_editMouseExited

    private void label_tambahMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label_tambahMouseExited
        label_tambah.setBackground(new java.awt.Color(0, 102, 51));
    }//GEN-LAST:event_label_tambahMouseExited

    private void label_hapusMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label_hapusMouseEntered
        label_hapus.setBackground(new java.awt.Color(112,195,155));
    }//GEN-LAST:event_label_hapusMouseEntered

    private void label_hapusMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label_hapusMouseExited
        label_hapus.setBackground(new java.awt.Color(0, 102, 51));
    }//GEN-LAST:event_label_hapusMouseExited

    private void label_cariMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label_cariMouseEntered
        label_cari.setBackground(new java.awt.Color(112,195,155));
    }//GEN-LAST:event_label_cariMouseEntered

    private void label_cariMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label_cariMouseExited
        label_cari.setBackground(new java.awt.Color(0, 102, 51));
    }//GEN-LAST:event_label_cariMouseExited

    private void label_segarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label_segarMouseEntered
        label_segar.setBackground(new java.awt.Color(112,195,155));
    }//GEN-LAST:event_label_segarMouseEntered

    private void label_segarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label_segarMouseExited
        label_segar.setBackground(new java.awt.Color(0, 102, 51));
    }//GEN-LAST:event_label_segarMouseExited

    private void tabel_gasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabel_gasMouseClicked
        this.ambil_data();
    }//GEN-LAST:event_tabel_gasMouseClicked

    private void label_segarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label_segarMouseClicked
        this.jtxt_nama.setText("");
        this.jtxt_ukuran.setText("");
        this.jtxt_grosir.setText("");
        this.jtxt_ecer.setText("");
        this.jtxt_terisi.setText("");
        this.jtxt_kosong.setText("");
        segarkan_data();
    }//GEN-LAST:event_label_segarMouseClicked

    private void label_hapusMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label_hapusMouseClicked
        if(!"-".equals(lblkode.getText())){
            int conf = JOptionPane.showConfirmDialog(null,"Apakah Yakin Dihapus?","Konfirmasi",JOptionPane.YES_NO_OPTION);
            label_hapus.setBackground(new java.awt.Color(0, 102, 51));
            if(conf==0){
                Connection c=connect();
                String sqlkode="delete from tb_gas "
                + "where id_gas="+this.lblkode.getText()+"";
                try {
                    PreparedStatement p2=(PreparedStatement) c.prepareStatement(sqlkode);
                    p2.executeUpdate();
                    p2.close();
                    this.lblkode.setText("-"); 
                    this.jtxt_nama.setText("");
                    this.jtxt_ukuran.setText("");
                    this.jtxt_grosir.setText("");
                    this.jtxt_ecer.setText("");
                    this.jtxt_terisi.setText("");
                    this.jtxt_kosong.setText("");
                    JOptionPane.showMessageDialog(this, "Berhasil Menghapus");
                    label_hapus.setBackground(new java.awt.Color(0, 102, 51));
                    segarkan_data();
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(this, "Gagal Menghapus");
                    label_hapus.setBackground(new java.awt.Color(0, 102, 51));
                    this.lblkode.setText("-"); 
                }
            }
        }
    }//GEN-LAST:event_label_hapusMouseClicked

    private void label_editMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label_editMouseClicked
        if("Edit".equals(this.label_edit.getText()) && !"-".equals(lblkode.getText()))
        {
            this.label_tambah.setText("Perbarui");
            this.label_edit.setText("Batal");
            this.label_hapus.setVisible(false);
            this.label_cari.setVisible(false);
            this.label_segar.setVisible(false);
        }else if("Batal".equals(this.label_edit.getText()))
        {
            this.lblkode.setText("-"); 
            this.label_tambah.setText("Tambah");
            this.label_edit.setText("Edit");
            this.label_hapus.setVisible(true);
            this.label_cari.setVisible(true);
            this.label_segar.setVisible(true);                   
            this.jtxt_nama.setText("");
            this.jtxt_ukuran.setText("");
            this.jtxt_grosir.setText("");
            this.jtxt_ecer.setText("");
            this.jtxt_terisi.setText("");
            this.jtxt_kosong.setText("");
            segarkan_data();
        }
    }//GEN-LAST:event_label_editMouseClicked

    private void label_tambahMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label_tambahMouseClicked
        Connection c=connect();
        if("Tambah".equals(this.label_tambah.getText()))
        {
            this.label_tambah.setText("Simpan");
            this.label_edit.setText("Batal");
            this.label_hapus.setVisible(false);
            this.label_cari.setVisible(false);
            this.label_segar.setVisible(false);
            this.lblkode.setText("-"); 
            this.jtxt_nama.setText("");
            this.jtxt_ukuran.setText("");
            this.jtxt_grosir.setText("");
            this.jtxt_ecer.setText("");
            this.jtxt_terisi.setText("");
            this.jtxt_kosong.setText("");
        }else if("Simpan".equals(this.label_tambah.getText()))
        {
            String sqlkode="INSERT INTO `db_khiqma`.`tb_gas` (`id_gas`, `nama`, `ukuran`, `hrg_grosir`, `hrg_eceran`, `stok_terisi`, `stok_kosong`)"
            + "VALUES (NULL, "
            + "'"+this.jtxt_nama.getText()+"', "
            + "'"+this.jtxt_ukuran.getText()+"', "
            + "'"+this.jtxt_grosir.getText()+"', "
            + "'"+this.jtxt_ecer.getText()+"', "
            + "'"+this.jtxt_terisi.getText()+"', "
            + "'"+this.jtxt_kosong.getText()+"');";
            try {
                PreparedStatement p2=(PreparedStatement) c.prepareStatement(sqlkode);
                p2.executeUpdate();
                p2.close();
                JOptionPane.showMessageDialog(this, "Berhasil Menyimpan");
                label_tambah.setBackground(new java.awt.Color(0, 102, 51));
                this.lblkode.setText("-"); 
                this.jtxt_nama.setText("");
                this.jtxt_ukuran.setText("");
                this.jtxt_grosir.setText("");
                this.jtxt_ecer.setText("");
                this.jtxt_terisi.setText("");
                this.jtxt_kosong.setText("");
                segarkan_data();
            } catch (SQLException ex) {
                this.lblkode.setText("-"); 
                JOptionPane.showMessageDialog(this, "Gagal Menyimpan");
                label_tambah.setBackground(new java.awt.Color(0, 102, 51));
                this.lblkode.setText("-"); 
                this.jtxt_nama.setText("");
                this.jtxt_ukuran.setText("");
                this.jtxt_grosir.setText("");
                this.jtxt_ecer.setText("");
                this.jtxt_terisi.setText("");
                this.jtxt_kosong.setText("");
            }
            this.label_tambah.setText("Tambah");
            this.label_edit.setText("Edit");
            this.label_hapus.setVisible(true);
            this.label_cari.setVisible(true);
            this.label_segar.setVisible(true);
        }else if("Perbarui".equals(this.label_tambah.getText()))
        {
            String sqlkode="UPDATE `db_khiqma`.`tb_gas` SET "
            + "`nama` = '"+this.jtxt_nama.getText()+"', "
            + "`ukuran` = '"+this.jtxt_ukuran.getText()+"', "
            + "`hrg_grosir` = '"+this.jtxt_grosir.getText()+"', "
            + "`hrg_eceran` = '"+this.jtxt_ecer.getText()+"', "
            + "`stok_terisi` = '"+this.jtxt_terisi.getText()+"', "
            + "`stok_kosong` = '"+this.jtxt_kosong.getText()+"' "
            + "WHERE `tb_gas`.`id_gas` = "+this.lblkode.getText()+";";
            try {
                PreparedStatement p2=(PreparedStatement) c.prepareStatement(sqlkode);
                p2.executeUpdate();
                p2.close();
                JOptionPane.showMessageDialog(this, "Berhasil Memperbarui");
                label_edit.setBackground(new java.awt.Color(0, 102, 51));
                label_tambah.setBackground(new java.awt.Color(0, 102, 51));
                this.lblkode.setText("-"); 
                this.jtxt_nama.setText("");
                this.jtxt_ukuran.setText("");
                this.jtxt_grosir.setText("");
                this.jtxt_ecer.setText("");
                this.jtxt_terisi.setText("");
                this.jtxt_kosong.setText("");
                segarkan_data();
            }catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "Gagal Memperbarui");
                label_edit.setBackground(new java.awt.Color(0, 102, 51));
                label_tambah.setBackground(new java.awt.Color(0, 102, 51));
            }
            this.label_tambah.setText("Tambah");
            this.label_edit.setText("Edit");
            this.label_hapus.setVisible(true);
            this.label_cari.setVisible(true);
            this.label_segar.setVisible(true);
        }    }//GEN-LAST:event_label_tambahMouseClicked

    private void label_cariMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label_cariMouseClicked
        try {
            if("".equals(this.jtxt_nama.getText())){
                JOptionPane.showMessageDialog(this, "Isikan Nama Produk Gas");
                label_cari.setBackground(new java.awt.Color(0, 102, 51));  
            }else{
                tabel.getDataVector().removeAllElements();
                tabel.fireTableDataChanged();
                Connection c = connect();
                Statement  s = c.createStatement();
                String sql="SELECT *  FROM `tb_gas` WHERE `nama` LIKE '%"+this.jtxt_nama.getText()+"%' ORDER BY `nama` ASC";
                ResultSet  r = s.executeQuery(sql);
                int i=0;
                while (r.next()) {
                    i+=1;
                    Object[] o=new Object[7];
                    o[0]=r.getString("id_gas");
                    o[1]=r.getString("nama");
                    o[2]=r.getString("ukuran");
                    o[3]=r.getString("hrg_grosir");
                    o[4]=r.getString("hrg_eceran");
                    o[5]=r.getString("stok_terisi");
                    o[6]=r.getString("stok_kosong");
                    tabel.addRow(o);
                }
                r.close();
                s.close();
                if(i==0){
                    JOptionPane.showMessageDialog(this, "Data Tidak Ditemukan");
                }
            }
        }catch(SQLException e) {            
            JOptionPane.showMessageDialog(this, "Terjadi Kesalahan");
        }finally{
            this.lblkode.setText("-"); 
            this.jtxt_nama.setText("");
            this.jtxt_ukuran.setText("");
            this.jtxt_grosir.setText("");
            this.jtxt_ecer.setText("");
            this.jtxt_terisi.setText("");
            this.jtxt_kosong.setText("");
            label_cari.setBackground(new java.awt.Color(0, 102, 51));   
        }
    }//GEN-LAST:event_label_cariMouseClicked

    private void jLabel_Mn2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_Mn2MouseClicked
        Transaksi tr = new Transaksi();
        tr.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel_Mn2MouseClicked

    private void jLabel_Mn7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_Mn7MouseClicked
        Informasi in = new Informasi();
        in.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel_Mn7MouseClicked

    private void jLabel_Mn7MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_Mn7MouseEntered
        jPanel_Mn7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel_Mn7.setForeground(new java.awt.Color(0, 102, 51));
    }//GEN-LAST:event_jLabel_Mn7MouseEntered

    private void jLabel_Mn7MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_Mn7MouseExited
        jPanel_Mn7.setBackground(new java.awt.Color(0, 102, 51));
        jLabel_Mn7.setForeground(new java.awt.Color(255, 255, 255));
    }//GEN-LAST:event_jLabel_Mn7MouseExited

    private void jLabel_Mn3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_Mn3MouseClicked
        Penghasilan peng = new Penghasilan();
        peng.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel_Mn3MouseClicked
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
    private javax.swing.JButton jButton_Exit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel_Bulan;
    private javax.swing.JLabel jLabel_Menu;
    private javax.swing.JLabel jLabel_Mn1;
    private javax.swing.JLabel jLabel_Mn2;
    private javax.swing.JLabel jLabel_Mn3;
    private javax.swing.JLabel jLabel_Mn4;
    private javax.swing.JLabel jLabel_Mn5;
    private javax.swing.JLabel jLabel_Mn7;
    private javax.swing.JLabel jLabel_Tanggal;
    private javax.swing.JLabel jLabel_Title;
    private javax.swing.JLabel jLabel_Waktu;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JPanel jPanel_Exit;
    private javax.swing.JPanel jPanel_Menu;
    private javax.swing.JPanel jPanel_Mn1;
    private javax.swing.JPanel jPanel_Mn2;
    private javax.swing.JPanel jPanel_Mn3;
    private javax.swing.JPanel jPanel_Mn4;
    private javax.swing.JPanel jPanel_Mn5;
    private javax.swing.JPanel jPanel_Mn7;
    private javax.swing.JPanel jPanel_Top;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jtxt_ecer;
    private javax.swing.JTextField jtxt_grosir;
    private javax.swing.JTextField jtxt_kosong;
    private javax.swing.JTextField jtxt_nama;
    private javax.swing.JTextField jtxt_terisi;
    private javax.swing.JTextField jtxt_ukuran;
    private java.awt.Label label1;
    private java.awt.Label label_cari;
    private java.awt.Label label_edit;
    private java.awt.Label label_hapus;
    private java.awt.Label label_segar;
    private java.awt.Label label_tambah;
    private javax.swing.JLabel lblkode;
    private javax.swing.JTable tabel_gas;
    // End of variables declaration//GEN-END:variables
}
