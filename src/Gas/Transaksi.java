package Gas;

import Gas.Informasi;
import Gas.Home;
import Gas.Gas;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;
import javafx.scene.paint.Color;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.SpinnerListModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
public class Transaksi extends javax.swing.JFrame {
    private static Connection config;
    private DefaultTableModel tabel;
    public Transaksi() {
        this.setLocation(200, 100);
        initComponents();
        tabel=new DefaultTableModel();
        this.tabel_gas.setModel(tabel); 
        tabel.addColumn("ID");
        tabel.addColumn("Atas Nama");
        tabel.addColumn("Tabung Gas");
        tabel.addColumn("Jenis Transaksi");
        tabel.addColumn("Jumlah");
        tabel.addColumn("Total Harga");
        tabel.addColumn("Waktu");
        TableColumn column;
        tabel_gas.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        column = tabel_gas.getColumnModel().getColumn(0);
        column.setPreferredWidth(0);
        column = tabel_gas.getColumnModel().getColumn(1);
        column.setPreferredWidth(145);
        column = tabel_gas.getColumnModel().getColumn(2);
        column.setPreferredWidth(123);
        column = tabel_gas.getColumnModel().getColumn(3);
        column.setPreferredWidth(100);
        column = tabel_gas.getColumnModel().getColumn(4);
        column.setPreferredWidth(54);
        column = tabel_gas.getColumnModel().getColumn(5);
        column.setPreferredWidth(83);
        column = tabel_gas.getColumnModel().getColumn(6);
        column.setPreferredWidth(134);
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
            }*        }, 0, 1000);
        this.ch_tabung.add("");
        try {            
            Connection c=connect();
            Statement s= c.createStatement();
            String sql="SELECT * FROM tb_gas ORDER BY `nama` ASC";
            ResultSet r=s.executeQuery(sql);        
            while (r.next()) {
                this.ch_tabung.add(r.getString("nama")+" - "+r.getString("ukuran")+"Kg");
            }
            r.close();
            s.close();
            ambil_data();
        }catch(SQLException e) {
            JOptionPane.showMessageDialog(this, "Terjadi Kesalahan");
        }
        this.ch_jenis.add("");
        this.ch_jenis.add("Beli");
        this.ch_jenis.add("Jual Eceran");
        this.ch_jenis.add("Jual Grosir");
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
            String sql="SELECT * FROM tb_transaksi ORDER BY waktu,an_tmp,gas ASC";
            ResultSet r=s.executeQuery(sql);        
            while (r.next()) {
                Object[] o=new Object[7];
                o[0]=r.getString("id_transaksi");
                o[1]=r.getString("an_tmp");
                o[2]=r.getString("gas");
                o[3]=r.getString("jns_transaksi");
                o[4]=r.getString("jml");
                o[5]=r.getString("hrg");
                o[6]=r.getString("waktu").substring(8,10)+"/"+r.getString("waktu").substring(5,7)
                        +"/"+r.getString("waktu").substring(0,4)+r.getString("waktu").substring(10, 19);
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
        this.jtxt_an.setText(dt1);
        String dt2=(String) tabel.getValueAt(i, 2);
        this.ch_tabung.select(dt2);
        String dt3=(String) tabel.getValueAt(i, 3);        
        this.ch_jenis.select(dt3);
        String dt4=(String) tabel.getValueAt(i, 4);
        this.jtxt_jml.setText(dt4);
        String dt5=(String) tabel.getValueAt(i, 5); 
        this.jtxt_total.setText(dt5);
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
        jPanel_Mn6 = new javax.swing.JPanel();
        jLabel_Mn6 = new javax.swing.JLabel();
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
        jtxt_an = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        ch_tabung = new java.awt.Choice();
        jLabel5 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jtxt_total = new javax.swing.JTextField();
        jPanel8 = new javax.swing.JPanel();
        ch_jenis = new java.awt.Choice();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jtxt_jml = new javax.swing.JTextField();
        label1 = new java.awt.Label();
        jLabel8 = new javax.swing.JLabel();

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

        jPanel_Mn1.setBackground(new java.awt.Color(0, 102, 51));
        jPanel_Mn1.setForeground(new java.awt.Color(255, 255, 255));

        jLabel_Mn1.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel_Mn1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Mn1.setIcon(new javax.swing.ImageIcon("E:\\Khiqma Project\\Khiqma\\img\\menu1.png")); // NOI18N
        jLabel_Mn1.setText("  Gas");
        jLabel_Mn1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel_Mn1MouseClicked(evt);
            }
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

        jPanel_Mn2.setBackground(new java.awt.Color(112, 195, 155));

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

        jPanel_Mn6.setBackground(new java.awt.Color(0, 102, 51));

        jLabel_Mn6.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel_Mn6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_Mn6.setIcon(new javax.swing.JLabel() {
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
        jLabel_Mn6.setText("  Informasi");
        jLabel_Mn6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel_Mn6MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel_Mn6MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel_Mn6MouseExited(evt);
            }
        });

        javax.swing.GroupLayout jPanel_Mn6Layout = new javax.swing.GroupLayout(jPanel_Mn6);
        jPanel_Mn6.setLayout(jPanel_Mn6Layout);
        jPanel_Mn6Layout.setHorizontalGroup(
            jPanel_Mn6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel_Mn6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel_Mn6Layout.setVerticalGroup(
            jPanel_Mn6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel_Mn6Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel_Mn6))
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
                .addContainerGap()
                .addComponent(jLabel_Waktu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel_MenuLayout.createSequentialGroup()
                .addComponent(jLabel_Tanggal, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel_MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel_Bulan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
            .addComponent(jPanel_Mn6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                .addComponent(jPanel_Mn6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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

        jtxt_an.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jtxt_an.setBorder(null);
        jtxt_an.setSelectionColor(new java.awt.Color(102, 102, 102));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jtxt_an)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jtxt_an, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        jLabel1.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 102, 51));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("Atas Nama");

        jLabel4.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 102, 51));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Tabung Gas");

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 51)));

        ch_tabung.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        ch_tabung.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                ch_tabungItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ch_tabung, javax.swing.GroupLayout.DEFAULT_SIZE, 162, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ch_tabung, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        jLabel5.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 102, 51));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel5.setText("Jumlah Tabung Gas");

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 51)));

        jtxt_total.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jtxt_total.setBorder(null);
        jtxt_total.setSelectionColor(new java.awt.Color(102, 102, 102));
        jtxt_total.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtxt_totalKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtxt_totalKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jtxt_total, javax.swing.GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jtxt_total, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));
        jPanel8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 51)));

        ch_jenis.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        ch_jenis.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                ch_jenisItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ch_jenis, javax.swing.GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ch_jenis, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        jLabel6.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 102, 51));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Jenis Transaksi");

        jLabel7.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 102, 51));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel7.setText("Total Harga");

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));
        jPanel9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 51)));

        jtxt_jml.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jtxt_jml.setBorder(null);
        jtxt_jml.setSelectionColor(new java.awt.Color(102, 102, 102));
        jtxt_jml.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtxt_jmlKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jtxt_jml, javax.swing.GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jtxt_jml, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        label1.setAlignment(java.awt.Label.CENTER);
        label1.setBackground(new java.awt.Color(0, 102, 51));
        label1.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        label1.setForeground(new java.awt.Color(255, 255, 255));
        label1.setText("Pengelolaan Data Transaksi");

        jLabel8.setBackground(new java.awt.Color(255, 255, 255));
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("11");

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
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(22, 22, 22)
                                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))))
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
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(16, 16, 16)))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
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
                .addGap(9, 9, 9))
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
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
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
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
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
        jPanel_Mn1.setBackground(new java.awt.Color(0, 102, 51));
        jLabel_Mn1.setForeground(new java.awt.Color(255, 255, 255));
    }//GEN-LAST:event_jLabel_Mn1MouseExited

    private void jLabel_Mn2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_Mn2MouseExited
        jPanel_Mn2.setBackground(new java.awt.Color(112,195,155));
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
        this.jtxt_an.setText("");
        this.jtxt_total.setText("");
        this.jtxt_jml.setText("");
        this.ch_tabung.select(0);
        this.ch_jenis.select(0);
        segarkan_data();
    }//GEN-LAST:event_label_segarMouseClicked

    private void label_hapusMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label_hapusMouseClicked
        if(!"-".equals(lblkode.getText())){
            int conf = JOptionPane.showConfirmDialog(null,"Apakah Yakin Dihapus?","Konfirmasi",JOptionPane.YES_NO_OPTION);
            label_hapus.setBackground(new java.awt.Color(0, 102, 51));
            if(conf==0){
                Connection c=connect();
                String sqlkode="delete from tb_transaksi "
                + "where id_transaksi="+this.lblkode.getText()+"";
                try {
                    PreparedStatement p2=(PreparedStatement) c.prepareStatement(sqlkode);
                    p2.executeUpdate();
                    p2.close();
                    this.lblkode.setText("-"); 
                    this.jtxt_an.setText("");
                    this.jtxt_total.setText("");
                    this.jtxt_jml.setText("");
                    this.ch_tabung.select(0);
                    this.ch_jenis.select(0);
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
            this.lblkode.setText("-"); 
            this.jtxt_an.setText("");
            this.jtxt_total.setText("");
            this.jtxt_jml.setText("");
            this.ch_tabung.select(0);
            this.ch_jenis.select(0);
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
            this.jtxt_an.setText("");
            this.jtxt_total.setText("");
            this.jtxt_jml.setText("");
            this.ch_tabung.select(0);
            this.ch_jenis.select(0);
        }else if("Simpan".equals(this.label_tambah.getText()))
        {
            String sqlkode="INSERT INTO `db_khiqma`.`tb_transaksi` (`id_transaksi`, `an_tmp`, `gas`, `jns_transaksi`, `jml`, `hrg`, `waktu`) "
                    + "VALUES (NULL, "
                    + "'"+this.jtxt_an.getText()+"', "
                    + "'"+this.ch_tabung.getSelectedItem()+"', "
                    + "'"+this.ch_jenis.getSelectedItem()+"', "
                    + "'"+this.jtxt_jml.getText()+"', "
                    + "'"+this.jtxt_total.getText()+ "', "
                    + "CURRENT_TIMESTAMP);";
            
            try {
                int stok_terisi0=0,stok_terisi1=0,stok_kosong0=0,stok_kosong1=0;
                boolean cek=true;
                String gas1=this.ch_tabung.getSelectedItem();
                int gas2=gas1.indexOf('-');
                String gas=gas1.substring(0, gas2-1);
                String ukur=gas1.substring(gas2+2,gas1.length()-2);
                String sql_beli1="SELECT * FROM `tb_gas` WHERE `nama` = '"+gas+"' AND `ukuran` = "+ukur+"";
                Statement aaa= c.createStatement();
                    ResultSet r=aaa.executeQuery(sql_beli1);
                    while (r.next()) {
                        stok_terisi0=Integer.parseInt(r.getString("stok_terisi"));
                        stok_terisi1=Integer.parseInt(this.jtxt_jml.getText());
                        stok_kosong0=Integer.parseInt(r.getString("stok_kosong"));
                        stok_kosong1=Integer.parseInt(this.jtxt_jml.getText());
                        String sql_beli="";
                        if(this.ch_jenis.getSelectedIndex()==2)
                        {   sql_beli="UPDATE `db_khiqma`.`tb_gas` SET "
                                + "`stok_terisi` = '"+(stok_terisi0-stok_terisi1)+"', "
                                + "`stok_kosong` = '"+(stok_kosong0+stok_kosong1)+"' "
                                + "WHERE `nama` = '"+gas+"' AND `ukuran` = "+ukur+"";
                            if(stok_terisi0<stok_terisi1){ cek=false; }
                        }
                        else if(this.ch_jenis.getSelectedIndex()==3)
                        {   sql_beli="UPDATE `db_khiqma`.`tb_gas` SET "
                                + "`stok_terisi` = '"+(stok_terisi0-stok_terisi1)+"', "
                                + "`stok_kosong` = '"+(stok_kosong0+stok_kosong1)+"' "
                                + "WHERE `nama` = '"+gas+"' AND `ukuran` = "+ukur+"";
                            if(stok_terisi0<stok_terisi1){ cek=false; }
                        }
                        else if(this.ch_jenis.getSelectedIndex()==1)
                        {   sql_beli="UPDATE `db_khiqma`.`tb_gas` SET "
                                + "`stok_terisi` = '"+(stok_terisi0+stok_terisi1)+"', "
                                + "`stok_kosong` = '"+(stok_kosong0-stok_kosong1)+"' "
                                + "WHERE `nama` = '"+gas+"' AND `ukuran` = "+ukur+"";   
                            if(stok_kosong0 < stok_kosong1){ cek=false; }
                        }
                        if(cek==true){
                            PreparedStatement pp=(PreparedStatement) c.prepareStatement(sql_beli);
                            pp.executeUpdate();
                            pp.close();
                        }
                    }
                    r.close();
                    aaa.close();
                    if(cek==true){
                        PreparedStatement p2=(PreparedStatement) c.prepareStatement(sqlkode);
                        p2.executeUpdate();
                        p2.close();
                        JOptionPane.showMessageDialog(this, "Berhasil Menyimpan");
                        label_tambah.setBackground(new java.awt.Color(0, 102, 51));
                        this.lblkode.setText("-"); 
                        this.jtxt_an.setText("");
                        this.jtxt_total.setText("");
                        this.jtxt_jml.setText("");
                        this.ch_tabung.select(0);
                        this.ch_jenis.select(0);
                        segarkan_data();
                    }else{
                        this.lblkode.setText("-"); 
                        if(this.ch_jenis.getSelectedIndex()==2 || this.ch_jenis.getSelectedIndex()==3)
                        { 
                            if(stok_terisi0==0)
                            {JOptionPane.showMessageDialog(this, "Tabung Gas Habis");}
                            else
                            {JOptionPane.showMessageDialog(this, "Tabung Gas Tinggal "+stok_terisi0);}
                        }
                        else
                        { JOptionPane.showMessageDialog(this, "Tabung Gas Penuh, Jika Penambahan Stok Edit Stok Terisi di Pengelolaan Data Gas");}
                        label_tambah.setBackground(new java.awt.Color(0, 102, 51));
                        this.lblkode.setText("-"); 
                        this.jtxt_an.setText("");
                        this.jtxt_total.setText("");
                        this.jtxt_jml.setText("");
                        this.ch_tabung.select(0);
                        this.ch_jenis.select(0);                    
                    }
                
            } catch (SQLException ex) {
                this.lblkode.setText("-"); 
                JOptionPane.showMessageDialog(this, "Gagal Menyimpan");
                label_tambah.setBackground(new java.awt.Color(0, 102, 51));
                this.lblkode.setText("-"); 
                this.jtxt_an.setText("");
                this.jtxt_total.setText("");
                this.jtxt_jml.setText("");
                this.ch_tabung.select(0);
                this.ch_jenis.select(0);
            }
            this.label_tambah.setText("Tambah");
            this.label_edit.setText("Edit");
            this.label_hapus.setVisible(true);
            this.label_cari.setVisible(true);
            this.label_segar.setVisible(true);
        }else if("Perbarui".equals(this.label_tambah.getText()))
        {
            String sqlkode="UPDATE `db_khiqma`.`tb_transaksi` SET "
                    + "`an_tmp` = '"+this.jtxt_an.getText()+"', "
                    + "`hrg` = '"+this.jtxt_total.getText()+"' "
                    + "WHERE "
                    + "`tb_transaksi`.`id_transaksi` = "+this.lblkode.getText()+";";
            try {
                PreparedStatement p2=(PreparedStatement) c.prepareStatement(sqlkode);
                p2.executeUpdate();
                p2.close();
                JOptionPane.showMessageDialog(this, "Berhasil Memperbarui");
                label_edit.setBackground(new java.awt.Color(0, 102, 51));
                label_tambah.setBackground(new java.awt.Color(0, 102, 51));
                this.lblkode.setText("-"); 
                this.jtxt_an.setText("");
                this.jtxt_total.setText("");
                this.jtxt_jml.setText("");
                this.ch_tabung.select(0);
                this.ch_jenis.select(0);
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
            if("".equals(this.jtxt_an.getText())){
                JOptionPane.showMessageDialog(this, "Isikan Atas Nama");
                label_cari.setBackground(new java.awt.Color(0, 102, 51));  
            }else{
                
                tabel.getDataVector().removeAllElements();
                tabel.fireTableDataChanged();
                Connection c = connect();
                Statement  s = c.createStatement();
                String sql="SELECT *  FROM `tb_transaksi` WHERE `an_tmp` LIKE '%"+this.jtxt_an.getText()+"%' ORDER BY waktu,an_tmp,gas ASC";
                ResultSet  r = s.executeQuery(sql);
                int i=0;
                while (r.next()) {
                    i+=1;
                    Object[] o=new Object[7];
                o[0]=r.getString("id_transaksi");
                o[1]=r.getString("an_tmp");
                o[2]=r.getString("gas");
                o[3]=r.getString("jns_transaksi");
                o[4]=r.getString("jml");
                o[5]=r.getString("hrg");
                o[6]=r.getString("waktu").substring(8,10)+"/"+r.getString("waktu").substring(5,7)
                        +"/"+r.getString("waktu").substring(0,4)+r.getString("waktu").substring(10, 19);
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
            this.jtxt_an.setText("");
            this.jtxt_total.setText("");
            this.jtxt_jml.setText("");
            this.ch_tabung.select(0);
            this.ch_jenis.select(0);
            label_cari.setBackground(new java.awt.Color(0, 102, 51));   
        }
    }//GEN-LAST:event_label_cariMouseClicked

    private void jLabel_Mn1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_Mn1MouseClicked
        Gas g = new Gas();
        g.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel_Mn1MouseClicked

    private void jtxt_totalKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxt_totalKeyTyped
               
    }//GEN-LAST:event_jtxt_totalKeyTyped

    private void jtxt_totalKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxt_totalKeyReleased

    }//GEN-LAST:event_jtxt_totalKeyReleased

    private void ch_tabungItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_ch_tabungItemStateChanged
        this.jtxt_total.setText("");
        this.jtxt_jml.setText("");
    }//GEN-LAST:event_ch_tabungItemStateChanged

    private void jtxt_jmlKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxt_jmlKeyReleased
        if(this.ch_tabung.getSelectedIndex()==0){}
        else{
            if("".equals(this.jtxt_jml.getText())){
                this.jtxt_total.setText("");
            }else{
                try {
                    String gas1=this.ch_tabung.getSelectedItem();
                    int gas2=gas1.indexOf('-');
                    String gas=gas1.substring(0, gas2-1);
                    String ukur=gas1.substring(gas2+2,gas1.length()-2);
                    Connection c=connect();
                    Statement s= c.createStatement();
                    String sql="SELECT *  FROM `tb_gas` WHERE `nama` = '"+gas+"' AND `ukuran` = "+ukur+"";
                    ResultSet r=s.executeQuery(sql);
                    while (r.next()) {
                        String ttl="";
                        if(this.ch_jenis.getSelectedIndex()==2)
                        {   ttl= r.getString("hrg_eceran");}
                        else if(this.ch_jenis.getSelectedIndex()==3)
                        {   ttl = r.getString("hrg_grosir");}
                        else if(this.ch_jenis.getSelectedIndex()==1)
                        {   ttl = r.getString("hrg_grosir");}
                        String tl  = this.jtxt_jml.getText();
                        int ttl1 =Integer.parseInt(ttl);
                        int ttl2 =Integer.parseInt(tl);
                        int total=ttl1*ttl2;
                        String tot = Integer.toString(total);
                        this.jtxt_total.setText(tot);
                    }
                    r.close();
                    s.close();
                }catch(SQLException e) {
                    JOptionPane.showMessageDialog(this, "Terjadi Kesalahan");
                }
            }
        }
    }//GEN-LAST:event_jtxt_jmlKeyReleased

    private void ch_jenisItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_ch_jenisItemStateChanged
        this.jtxt_total.setText("");
        this.jtxt_jml.setText("");
    }//GEN-LAST:event_ch_jenisItemStateChanged

    private void jLabel_Mn6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_Mn6MouseClicked
        Informasi in = new Informasi();
        in.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel_Mn6MouseClicked

    private void jLabel_Mn6MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_Mn6MouseEntered
        jPanel_Mn6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel_Mn6.setForeground(new java.awt.Color(0, 102, 51));

    }//GEN-LAST:event_jLabel_Mn6MouseEntered

    private void jLabel_Mn6MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_Mn6MouseExited
        jPanel_Mn6.setBackground(new java.awt.Color(0, 102, 51));
        jLabel_Mn6.setForeground(new java.awt.Color(255, 255, 255));
    }//GEN-LAST:event_jLabel_Mn6MouseExited

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
    private java.awt.Choice ch_jenis;
    private java.awt.Choice ch_tabung;
    private javax.swing.JButton jButton_Exit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel_Bulan;
    private javax.swing.JLabel jLabel_Menu;
    private javax.swing.JLabel jLabel_Mn1;
    private javax.swing.JLabel jLabel_Mn2;
    private javax.swing.JLabel jLabel_Mn3;
    private javax.swing.JLabel jLabel_Mn4;
    private javax.swing.JLabel jLabel_Mn5;
    private javax.swing.JLabel jLabel_Mn6;
    private javax.swing.JLabel jLabel_Tanggal;
    private javax.swing.JLabel jLabel_Title;
    private javax.swing.JLabel jLabel_Waktu;
    private javax.swing.JPanel jPanel1;
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
    private javax.swing.JPanel jPanel_Mn6;
    private javax.swing.JPanel jPanel_Top;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jtxt_an;
    private javax.swing.JTextField jtxt_jml;
    private javax.swing.JTextField jtxt_total;
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
