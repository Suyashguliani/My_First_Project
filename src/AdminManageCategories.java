
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;


public class AdminManageCategories extends javax.swing.JFrame {
    
    ArrayList<Categories> al;
    mytablemodel tm;

    public AdminManageCategories() {
        tm = new mytablemodel();
        al = new ArrayList<>();
        initComponents();
        
        jTable1.setModel(tm);
        
        showAlreadyAddedCategories();
         
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        
        int width = (int) d.getWidth();
        
        int heigth = (int) d.getHeight();
        
        setSize(width,heigth);
        
        setTitle("MANAGE CATEGORIES");
        setVisible(true);
    }
    
    int count;
    
    void showAlreadyAddedCategories()
    {  
        try{
        count = 0;
            
        ResultSet rs = DBLoader.executeQuery("select * from categories");
        al.clear();
        
        while(rs.next()){
            count++;
            String catname = rs.getString("catname");
            String desc = rs.getString("desc");
            al.add(new Categories(catname,desc));
        }
        tm.fireTableDataChanged();
        
        
        }
        catch(Exception ex){
                ex.printStackTrace();
        }
    
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFileChooser1 = new javax.swing.JFileChooser();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        tf1 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tf2 = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Helvetica Neue", 1, 36)); // NOI18N
        jLabel1.setText("MANAGE YOUR CATEGORIES");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(430, 70, 540, 50);

        jLabel2.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        jLabel2.setText("ADD CATEGORIES");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(300, 200, 190, 40);

        jLabel3.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        jLabel3.setText("CATEGORY NAME :");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(150, 290, 170, 40);

        jLabel4.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        jLabel4.setText("DESCRIPTION :");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(150, 380, 170, 40);

        jLabel5.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        jLabel5.setText("PHOTO : ");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(160, 510, 130, 23);

        jLabel6.setText("jLabel6");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(250, 530, 160, 100);
        getContentPane().add(tf1);
        tf1.setBounds(460, 293, 210, 30);

        tf2.setColumns(20);
        tf2.setRows(5);
        jScrollPane1.setViewportView(tf2);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(460, 370, 234, 91);

        jButton1.setText("CHOOSE");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(470, 510, 110, 23);

        jButton2.setText("ADD");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(240, 660, 72, 23);

        jLabel7.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        jLabel7.setText("VIEW CATEGORY");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(1120, 150, 200, 40);

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
        jScrollPane2.setBounds(970, 210, 452, 402);

        jButton3.setText("DELETE");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3);
        jButton3.setBounds(1130, 650, 150, 23);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    File selectedfile;
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int ans = jFileChooser1.showOpenDialog(this);
        
        if(ans == JFileChooser.APPROVE_OPTION)
                {
                  selectedfile = jFileChooser1.getSelectedFile();
                  
                  try
                  {
                      BufferedImage bi = ImageIO.read(selectedfile);
                      
                      bi = scale(bi,160,100);
                      jLabel6.setIcon(new ImageIcon(bi));
   
                  }catch(Exception ex)
                  {
                      ex.printStackTrace();
                  }
                          
                }
    }//GEN-LAST:event_jButton1ActionPerformed

    class mytablemodel extends AbstractTableModel{

        @Override
        public int getRowCount() {
            return count;   
        }

        @Override
        public int getColumnCount() {
           return 2; 
        }

        @Override
        public Object getValueAt(int i, int j) {
            Categories obj = al.get(i);
            
            if(j == 0)
            {
                return obj.catname;
            }else if(j==1){
                return obj.desc;
            }
            return null;     
        }

        @Override
        public String getColumnName(int j) {
            String col[] = {"Category Name","Description"};
           return col[j];
            
        }    
    }
    
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        String catname = tf1.getText();
        String desc = tf2.getText();
        
        try{
        ResultSet rs =  DBLoader.executeQuery("select * from categories where catname = '"+catname+"' ");
        
        
        if(rs.next()){
            JOptionPane.showMessageDialog(this, "This Category alerady exists");
        }else{
            
            String path = SaveFile.saveFile(selectedfile);
            
            rs.moveToInsertRow();
            
            rs.updateString("catname",catname);
            rs.updateString("desc",desc);
            rs.updateString("photo",path);
        
            rs.insertRow();
            JOptionPane.showMessageDialog(this, "Category added successfully");
            
            showAlreadyAddedCategories();
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }    
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        int column = 0;
        int row = jTable1.getSelectedRow();
        
        String catname = (String)jTable1.getModel().getValueAt(row, column);
        
        try{
            ResultSet rs = DBLoader.executeQuery("select * from categories where catname = '" + catname + "' ");

            if (rs.next()) {
                  rs.deleteRow();
                  
                  showAlreadyAddedCategories();
                  
                  JOptionPane.showMessageDialog(this, "Category Deleted Successfuly");
                  
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }//GEN-LAST:event_jButton3ActionPerformed


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
                new AdminManageCategories().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JFileChooser jFileChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField tf1;
    private javax.swing.JTextArea tf2;
    // End of variables declaration//GEN-END:variables
}

