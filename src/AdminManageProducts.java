

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Vector;
import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;


public class AdminManageProducts extends javax.swing.JFrame {
    Vector<String> vl;
    ArrayList<Products> al;
    mytablemodel tm;


    public AdminManageProducts() {
        vl = new Vector<>();
        tm = new mytablemodel();
        al = new ArrayList<>();
        initComponents();
        
        jTable1.setModel(tm);
        
        adminShowDropdown();
        showAlreadyAddedProducts();
        
        
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        jComboBox1.setModel(new DefaultComboBoxModel<>(vl));
        
        int width = (int) d.getWidth();
        
        int heigth = (int) d.getHeight();
        
        setTitle("MANAGE PRODUCTS");
        
        setSize(width,heigth);
        setVisible(true);
    }
    
     int count;
    
    void showAlreadyAddedProducts()
    {  
        try{
        count = 0;
            
        ResultSet rs = DBLoader.executeQuery("select * from Products");
        al.clear();
        
        while(rs.next()){
            count++;
            String productname = rs.getString("productname");
            String desc = rs.getString("desc");
            String category = rs.getString("category");
            int price = rs.getInt("price");
            int offerprice = rs.getInt("offerprice");
            int quantity = rs.getInt("quantity");
            al.add(new Products(productname,desc,category,price,offerprice,quantity));

         
        tm.fireTableDataChanged();
        
        
        }
        }
        catch(Exception ex){
                ex.printStackTrace();
        }
    
        
    }
    
    void adminShowDropdown()
    {
         try{
        ResultSet rs =  DBLoader.executeQuery("select * from categories");
             while (rs.next()) 
             {                 
                String catname = rs.getString("catname");
                vl.add(catname);
                
                
             }
         }
         catch(Exception ex)
         {
             ex.printStackTrace();
         }
    }
    
    public static BufferedImage scale(BufferedImage src, int w, int h)
{
    BufferedImage img = 
            new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
    int x, y;
    int ww = src.getWidth();
    int hh = src.getHeight();
    int[] ys = new int[h];
    for (y = 0; y < h; y++)
        ys[y] = y * hh / h;
    for (x = 0; x < w; x++) {
        int newX = x * ww / w;
        for (y = 0; y < h; y++) {
            int col = src.getRGB(newX, ys[y]);
            img.setRGB(x, y, col);
        }
    }
    return img;
}
    
     public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminManageProducts().setVisible(true);
            }
        });
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFileChooser1 = new javax.swing.JFileChooser();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        ta1 = new javax.swing.JTextArea();
        tf1 = new javax.swing.JTextField();
        tf2 = new javax.swing.JTextField();
        tf3 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        tf4 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Helvetica Neue", 1, 36)); // NOI18N
        jLabel1.setText("MANAGE PRODUCT");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(440, 80, 380, 70);

        jLabel2.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        jLabel2.setText("PRODUCT NAME :");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(110, 160, 180, 40);

        jLabel3.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        jLabel3.setText("DESCRIPTION :");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(110, 250, 190, 50);

        jLabel4.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        jLabel4.setText("PHOTO : ");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(120, 410, 130, 23);

        jButton1.setText("CHOOSE");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(430, 410, 120, 23);

        jLabel5.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        jLabel5.setText("CATEGORY : ");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(110, 520, 116, 23);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        getContentPane().add(jComboBox1);
        jComboBox1.setBounds(300, 520, 240, 23);

        jLabel6.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        jLabel6.setText("PRICE");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(120, 580, 55, 23);

        jLabel7.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        jLabel7.setText("OFFER PRICE : ");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(110, 630, 170, 23);

        jButton2.setText("ADD");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(270, 740, 72, 23);

        jLabel8.setText("jLabel8");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(262, 410, 130, 90);

        ta1.setColumns(20);
        ta1.setRows(5);
        jScrollPane1.setViewportView(ta1);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(294, 250, 270, 91);

        tf1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf1ActionPerformed(evt);
            }
        });
        getContentPane().add(tf1);
        tf1.setBounds(290, 170, 270, 23);
        getContentPane().add(tf2);
        tf2.setBounds(298, 580, 240, 23);
        getContentPane().add(tf3);
        tf3.setBounds(294, 630, 250, 23);

        jLabel9.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        jLabel9.setText("QUANTITY :");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(110, 677, 150, 30);
        getContentPane().add(tf4);
        tf4.setBounds(294, 680, 250, 23);

        jLabel10.setText("VIEW PRODUCT");
        getContentPane().add(jLabel10);
        jLabel10.setBounds(860, 160, 110, 40);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable1);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(690, 240, 640, 402);

        jButton3.setText("DELETE");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3);
        jButton3.setBounds(870, 720, 77, 23);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        String productname = tf1.getText();
        String desc = ta1.getText();
        int price =Integer.parseInt(tf2.getText() );
        int offerprice = Integer.parseInt(tf3.getText());
        String category = (String) jComboBox1.getSelectedItem();
        int quantity =Integer.parseInt(tf4.getText() );
        
        
        
        try{
        ResultSet rs =  DBLoader.executeQuery("select * from products where productname = '"+productname+"' ");
        
        
        if(rs.next()){
            JOptionPane.showMessageDialog(this, "This Category alerady exists");
        }else{
            
            String path = SaveFile.saveFile(selectedfile);
            
            rs.moveToInsertRow();
            
            rs.updateString("productname",productname);
            rs.updateString("desc",desc);
            rs.updateString("photo",path);
            rs.updateString("category", category);
            rs.updateInt("price",price);
            rs.updateInt("offerprice",offerprice);
            rs.updateInt("quantity",quantity);
            
        
            rs.insertRow();
            
            
            JOptionPane.showMessageDialog(this, "Category added successfully");
            showAlreadyAddedProducts();
            
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void tf1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf1ActionPerformed
File selectedfile;
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       int ans = jFileChooser1.showOpenDialog(this);
        
        if(ans == JFileChooser.APPROVE_OPTION)
                {
                  selectedfile = jFileChooser1.getSelectedFile();
                  
                  try
                  {
                      BufferedImage bi = ImageIO.read(selectedfile);
                      
                      bi = scale(bi,jLabel8.getHeight(),jLabel8.getWidth());
                      jLabel8.setIcon(new ImageIcon(bi));
   
                  }catch(Exception ex)
                  {
                      ex.printStackTrace();
                  }
                          
                }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        int column = 0;
        int row = jTable1.getSelectedRow();
        
        String productname = (String)jTable1.getModel().getValueAt(row, column);
        
        try{
            ResultSet rs = DBLoader.executeQuery("select * from products where productname = '" + productname + "' ");

            if (rs.next()) {
                  rs.deleteRow();
                  
                  showAlreadyAddedProducts();
                  
                  JOptionPane.showMessageDialog(this, "Category Deleted Successfuly");
                  
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    class mytablemodel extends AbstractTableModel{

        @Override
        public int getRowCount() {
            return count;   
        }

        @Override
        public int getColumnCount() {
           return 6; 
        }

        @Override
        public Object getValueAt(int i, int j) {
            Products obj = al.get(i);
            
            if(j == 0)
            {
                return obj.productname;
            }else if(j==1){
                return obj.desc;
            }
            else if(j==2){
                return obj.category;
            }
            else if(j==3){
                return obj.price;
            }else if(j==4){
                return obj.offerprice;
                
            }else if(j==5){
                return obj.quantity;
            }
            return null;     
        }

        @Override
        public String getColumnName(int j) {
            String col[] = {"Product Name","Description","Category Name" ,"Price","Offer Price", "Quantity"};
           return col[j];
            
        }    
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JFileChooser jFileChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextArea ta1;
    private javax.swing.JTextField tf1;
    private javax.swing.JTextField tf2;
    private javax.swing.JTextField tf3;
    private javax.swing.JTextField tf4;
    // End of variables declaration//GEN-END:variables
}
