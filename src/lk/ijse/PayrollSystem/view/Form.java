package lk.ijse.PayrollSystem.view;

import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.RowFilter;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.plaf.FontUIResource;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
//import javax.swing.text.Document;
import lk.ijse.PayrollSystem.Controller.AdministratorController;
import lk.ijse.PayrollSystem.Controller.AmountEarnedController;
import lk.ijse.PayrollSystem.Controller.AttendanceController;
import lk.ijse.PayrollSystem.Controller.BonusController;
import lk.ijse.PayrollSystem.Controller.DashBoardController;
import lk.ijse.PayrollSystem.Controller.DeductionController;
import lk.ijse.PayrollSystem.Controller.EmployeeController;
import lk.ijse.PayrollSystem.Controller.LoanController;
import lk.ijse.PayrollSystem.Controller.PaymentController;
import lk.ijse.PayrollSystem.Controller.generatePayrollController;
import lk.ijse.PayrollSystem.Model.AdministratorModel;
import lk.ijse.PayrollSystem.Model.AmountEarnedModel;
import lk.ijse.PayrollSystem.Model.AttendanceModel;
import lk.ijse.PayrollSystem.Model.BonusModel;
import lk.ijse.PayrollSystem.Model.DeductionModel;
import lk.ijse.PayrollSystem.Model.EmployeeModel;
import lk.ijse.PayrollSystem.Model.LoanModel;
import lk.ijse.PayrollSystem.Model.PaymentModel;
import lk.ijse.PayrollSystem.Model.generatePayrollModel;
import lk.ijse.PayrollSystem.db.DBConnection;
import org.jfree.data.category.DefaultCategoryDataset;

public class Form extends javax.swing.JFrame {

    public Form() throws ClassNotFoundException, SQLException {
        
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels())
            {
                if("Windows".equals(info.getName())){
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {
            e.getMessage();
        }
        
    
      
        initComponents();
        
          AttendanceTable.getTableHeader().setFont(new FontUIResource("MV Boli", Font.BOLD, 12));
        AttendanceTable.getTableHeader().setOpaque(false);
        AttendanceTable.getTableHeader().setBackground(Color.LIGHT_GRAY);
        AttendanceTable.getTableHeader().setForeground(Color.BLACK);
        
        showDate();
        showTime();
        popupTable();
        popupTableAdmin();
        popupEmployee();
        popupDeductions();
        popupBonus();
        popupLoan();
        popupPayments();
        loadPresent();
        loadAbsent();
        loadLateComers();
        loadPayDay();
        loadEmployee();
        loadAdmin();

        this.setLocationRelativeTo(null);

        PresentBtn.setEnabled(false);
        AbsentBtn.setEnabled(false);
        LatebTN.setEnabled(false);
        AdminisBtn.setEnabled(false);
        DAYsBtn1.setEnabled(false);
        Empbtn.setEnabled(false);

        AttendanceProgress.setVisible(false);
        Administrator.setVisible(false);
        Employee.setVisible(false);
        deductions.setVisible(false);
        deductions.setVisible(false);
        generatePayroll.setVisible(false);
        payments.setVisible(false);
        amountEarn.setVisible(false);
        bonus.setVisible(false);
        lOAN.setVisible(false);

        loadAttendanceTable();
        loadAdministratorTable();
        loadEmployeeTable();
        loadDeductionTable();
        loadLoanTable();
        loadBonusTable();
        loadAmountEarnedTable();
        loadPaymentTable();
        chart1();
        chart2();

    }

    public void chart1() throws ClassNotFoundException, SQLException {

        int jan=0,feb=0,march=0,april=0,may=0,june=0,july=0,aug=0,sept=0,oct=0,nov=0,dec=0;
        
        for (int i = 1; i < 13; i++) {
            AttendanceModel attendance = new AttendanceModel(i);
            if (i == 1) {
                 jan = AttendanceController.getCount(attendance);
            }
            if (i == 2) {
                feb = AttendanceController.getCount(attendance);
            }
            if (i == 3) {
                 march = AttendanceController.getCount(attendance);

            }
            if (i == 4) {
                 april = AttendanceController.getCount(attendance);
            }
            if (i == 5) {
                 may = AttendanceController.getCount(attendance);
            }
            if (i == 6) {
                 june = AttendanceController.getCount(attendance);
            }
            if (i == 7) {
                 july = AttendanceController.getCount(attendance);
            }
            if (i == 8) {
                 aug = AttendanceController.getCount(attendance);
            }
            if (i == 9) {
                sept = AttendanceController.getCount(attendance);
            }
            if (i == 10) {
                 oct = AttendanceController.getCount(attendance);
            }
            if (i == 11) {
                 nov = AttendanceController.getCount(attendance);
            }
            if (i == 12) {
                 dec = AttendanceController.getCount(attendance);
            }
        }

        DefaultCategoryDataset barchartdata = new DefaultCategoryDataset();
        barchartdata.setValue(jan, "contri amount", "Jan");
        barchartdata.setValue(feb, "contri amount", "Feb");
        barchartdata.setValue(march, "contri amount", "March");
        barchartdata.setValue(april, "contri amount", "April");
        barchartdata.setValue(may, "contri amount", "May");
        barchartdata.setValue(june, "contri amount", "June");
        barchartdata.setValue(july, "contri amount", "July");
        barchartdata.setValue(aug, "contri amount", "August");
        barchartdata.setValue(sept, "contri amount", "Sept");
        barchartdata.setValue(oct, "contri amount", "Oct");
        barchartdata.setValue(nov, "contri amount", "Nov");
        barchartdata.setValue(dec, "contri amount", "Dec");

        JFreeChart barChart = ChartFactory.createBarChart("", "Monthly", "present Employees", barchartdata, PlotOrientation.VERTICAL, false, true, false);
        CategoryPlot Bchart = barChart.getCategoryPlot();
        Bchart.setRangeGridlinePaint(Color.blue);

        ChartPanel barPanel = new ChartPanel(barChart);
        CP.removeAll();
        CP.add(barPanel, BorderLayout.CENTER);
        CP.validate();
    }
///////////////////////////////////////////////////////////////////
    
      public void chart2() throws ClassNotFoundException, SQLException {

        DefaultCategoryDataset barchartdata = new DefaultCategoryDataset();
        barchartdata.setValue(10, "contri amount", "Jan");
        barchartdata.setValue(20, "contri amount", "Feb");
        barchartdata.setValue(5, "contri amount", "March");
        barchartdata.setValue(30, "contri amount", "April");
        barchartdata.setValue(40, "contri amount", "May");
        barchartdata.setValue(35, "contri amount", "June");
         barchartdata.setValue(0, "contri amount", "July");
        barchartdata.setValue(0, "contri amount", "August");
        barchartdata.setValue(0, "contri amount", "Sept");
        barchartdata.setValue(0, "contri amount", "Oct");
        barchartdata.setValue(0, "contri amount", "Nov");
        barchartdata.setValue(0, "contri amount", "Dec");

        JFreeChart barChart = ChartFactory.createBarChart("", "Monthly", "Tot Absent Employees", barchartdata, PlotOrientation.VERTICAL, false, true, false);
        CategoryPlot Bchart = barChart.getCategoryPlot();
        Bchart.setRangeGridlinePaint(Color.blue);

        ChartPanel barPanel = new ChartPanel(barChart);
        CPP.removeAll();
        CPP.add(barPanel, BorderLayout.CENTER);
        CPP.validate();
    }
////////////////////////////////////////////////////////
    public int GetDaysInMonth() {
        Calendar c = Calendar.getInstance();
        int monthMaxDays = c.getActualMaximum(Calendar.DAY_OF_MONTH);
        return monthMaxDays;
    }

    void showDate() {
        Date d = new Date();
        SimpleDateFormat a = new SimpleDateFormat("yyyy-MM-dd");
        DateLabel.setText(a.format(d));
        // LoanIssueDate.setText(a.format(d));
    }

    void showTime() {
        new Timer(0, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Date d = new Date();
                SimpleDateFormat a = new SimpleDateFormat("hh:mm:ss");
                TimeLabel.setText(a.format(d));
            }
        }).start();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jPopupMenu2Admin = new javax.swing.JPopupMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jPopupMenuEmployee = new javax.swing.JPopupMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        jPopupMenuDeductions = new javax.swing.JPopupMenu();
        jMenuItem5 = new javax.swing.JMenuItem();
        jPopupMenuloan = new javax.swing.JPopupMenu();
        jMenuItem6 = new javax.swing.JMenuItem();
        jPopupMenuBonus = new javax.swing.JPopupMenu();
        jMenuItem7 = new javax.swing.JMenuItem();
        jPopupMenuPayment = new javax.swing.JPopupMenu();
        jMenuItem8 = new javax.swing.JMenuItem();
        jPopupMenuAmountEarned = new javax.swing.JPopupMenu();
        jMenuItem9 = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        Buttons = new javax.swing.JPanel();
        helpLabel = new javax.swing.JLabel();
        LogoutLabel = new javax.swing.JLabel();
        GenPayrollBtn = new keeptoo.KButton();
        AttendanceBtn = new keeptoo.KButton();
        AdminBtn = new keeptoo.KButton();
        EmployeeBtn = new keeptoo.KButton();
        DeductionsBtn = new keeptoo.KButton();
        LoansBtn = new keeptoo.KButton();
        BonusBtn = new keeptoo.KButton();
        PaymentsBtn = new keeptoo.KButton();
        DashboardBtn1 = new keeptoo.KButton();
        AmountEarned = new keeptoo.KButton();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        Attendance = new javax.swing.JPanel();
        txtSearchAttendance = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        AttendanceTable = new javax.swing.JTable();
        txtEmpID = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        BtnSubmit = new keeptoo.KButton();
        BtnReset = new keeptoo.KButton();
        DashBoard = new javax.swing.JPanel();
        txtPresent = new javax.swing.JLabel();
        txtAbsent = new javax.swing.JLabel();
        txtLatecomers = new javax.swing.JLabel();
        txtDaystopayday = new javax.swing.JLabel();
        LateLabel = new javax.swing.JLabel();
        LatebTN = new keeptoo.KButton();
        PresentLabel = new javax.swing.JLabel();
        PresentBtn = new keeptoo.KButton();
        AbsentLabel = new javax.swing.JLabel();
        AbsentBtn = new keeptoo.KButton();
        AdminLabel = new javax.swing.JLabel();
        AdminCount = new javax.swing.JLabel();
        AdminisBtn = new keeptoo.KButton();
        DaysLabel = new javax.swing.JLabel();
        DAYsBtn1 = new keeptoo.KButton();
        EmpLabel = new javax.swing.JLabel();
        empCount = new javax.swing.JLabel();
        Empbtn = new keeptoo.KButton();
        TimeLabel = new javax.swing.JLabel();
        DateLabel = new javax.swing.JLabel();
        AttendanceProgress = new javax.swing.JPanel();
        CP = new javax.swing.JPanel();
        CPP = new javax.swing.JPanel();
        Administrator = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        TableAdministrator = new javax.swing.JTable();
        txtUsername = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        searchAdmin = new javax.swing.JTextField();
        txtAdminID = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtAdminFullname = new javax.swing.JTextField();
        txtAdminContact = new javax.swing.JTextField();
        txtConPass = new javax.swing.JPasswordField();
        txtPassword = new javax.swing.JPasswordField();
        UpadateAdminBtn = new keeptoo.KButton();
        AddAdminBtn = new keeptoo.KButton();
        jLabel12 = new javax.swing.JLabel();
        Employee = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tableEmployee = new javax.swing.JTable();
        searchEmployee = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        role = new javax.swing.JTextField();
        empid = new javax.swing.JTextField();
        Fullname = new javax.swing.JTextField();
        contact = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        salarybasic = new javax.swing.JTextField();
        kButton1 = new keeptoo.KButton();
        BtnAddEmployee = new keeptoo.KButton();
        deductions = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tableDeduction = new javax.swing.JTable();
        DedEmpID = new javax.swing.JTextField();
        DedAmount = new javax.swing.JTextField();
        DedReason = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        BtnUpdateDeduction = new keeptoo.KButton();
        BtnAddDeduction = new keeptoo.KButton();
        jLabel24 = new javax.swing.JLabel();
        SearchDeduction = new javax.swing.JTextField();
        generatePayroll = new javax.swing.JPanel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        PayrollEmpId = new javax.swing.JTextField();
        PayrollYear = new javax.swing.JTextField();
        PayrollMonth = new javax.swing.JTextField();
        BtnIssuePayroll = new keeptoo.KButton();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        NoOFDeductions = new javax.swing.JTextField();
        TotDeductios = new javax.swing.JTextField();
        jLabel37 = new javax.swing.JLabel();
        TotLoans = new javax.swing.JTextField();
        LoanAmountTot = new javax.swing.JTextField();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        TotPresentDays = new javax.swing.JTextField();
        TotAbsentDays = new javax.swing.JTextField();
        jLabel43 = new javax.swing.JLabel();
        Bonus = new javax.swing.JTextField();
        jLabel45 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        FinalAmount = new javax.swing.JTextField();
        kButton3 = new keeptoo.KButton();
        BtnPay = new keeptoo.KButton();
        jLabel48 = new javax.swing.JLabel();
        SalaryEarned = new javax.swing.JTextField();
        payments = new javax.swing.JPanel();
        jLabel36 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        tablePayments = new javax.swing.JTable();
        searchPayments = new javax.swing.JTextField();
        lOAN = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tableLoan = new javax.swing.JTable();
        SearchLoan = new javax.swing.JTextField();
        LoanEmpID = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        LoanAmount = new javax.swing.JTextField();
        LoanIssuedDate = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        LoanDueDate = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        LoanReason = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        BtnUpdateLoan = new keeptoo.KButton();
        BtnAddLoan = new keeptoo.KButton();
        LoanSettled = new keeptoo.KButton();
        bonus = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        tableBonus = new javax.swing.JTable();
        BonusAmount = new javax.swing.JTextField();
        BonusYear = new javax.swing.JTextField();
        BonusReason = new javax.swing.JTextField();
        BonusMonth = new javax.swing.JTextField();
        jLabel52 = new javax.swing.JLabel();
        BtnUpdateBonus = new keeptoo.KButton();
        BtnAddBonus = new keeptoo.KButton();
        searchBonus = new javax.swing.JTextField();
        amountEarn = new javax.swing.JPanel();
        jScrollPane8 = new javax.swing.JScrollPane();
        amountEarnedTable = new javax.swing.JTable();
        jLabel53 = new javax.swing.JLabel();
        searchAmountEarned = new javax.swing.JTextField();

        jMenuItem1.setText("jMenuItem1");
        jPopupMenu1.add(jMenuItem1);

        jMenuItem2.setText("jMenuItem2");
        jPopupMenu1.add(jMenuItem2);

        jMenuItem3.setText("jMenuItem3");
        jPopupMenu2Admin.add(jMenuItem3);

        jMenuItem4.setText("jMenuItem4");
        jPopupMenuEmployee.add(jMenuItem4);

        jMenuItem5.setText("jMenuItem5");
        jPopupMenuDeductions.add(jMenuItem5);

        jMenuItem6.setText("jMenuItem6");
        jPopupMenuloan.add(jMenuItem6);

        jMenuItem7.setText("jMenuItem7");
        jPopupMenuBonus.add(jMenuItem7);

        jMenuItem8.setText("jMenuItem8");
        jPopupMenuPayment.add(jMenuItem8);

        jMenuItem9.setText("jMenuItem9");
        jPopupMenuAmountEarned.add(jMenuItem9);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(0, 102, 102));
        jPanel2.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Verdana", 0, 20)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("-");
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 0, 40, 40));

        jLabel5.setFont(new java.awt.Font("Verdana", 0, 20)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("x");
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 0, 40, 40));

        jLabel41.setFont(new java.awt.Font("Segoe Print", 0, 18)); // NOI18N
        jLabel41.setForeground(new java.awt.Color(255, 255, 255));
        jLabel41.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel41.setText("Genesis Payroll System");
        jPanel2.add(jLabel41, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 220, 40));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 990, 40));

        Buttons.setBackground(new java.awt.Color(255, 255, 255));
        Buttons.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        helpLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        helpLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        helpLabel.setText("Help");
        Buttons.add(helpLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 510, 160, 20));

        LogoutLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        LogoutLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LogoutLabel.setText("Log Out");
        LogoutLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LogoutLabelMouseClicked(evt);
            }
        });
        Buttons.add(LogoutLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 540, 160, -1));

        GenPayrollBtn.setBorder(null);
        GenPayrollBtn.setText("Generate Payroll");
        GenPayrollBtn.setDoubleBuffered(true);
        GenPayrollBtn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        GenPayrollBtn.setkBorderRadius(30);
        GenPayrollBtn.setkEndColor(new java.awt.Color(102, 255, 255));
        GenPayrollBtn.setkForeGround(new java.awt.Color(0, 0, 0));
        GenPayrollBtn.setkHoverEndColor(new java.awt.Color(204, 204, 204));
        GenPayrollBtn.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        GenPayrollBtn.setkHoverStartColor(new java.awt.Color(102, 102, 102));
        GenPayrollBtn.setkSelectedColor(new java.awt.Color(102, 102, 102));
        GenPayrollBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GenPayrollBtnActionPerformed(evt);
            }
        });
        Buttons.add(GenPayrollBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 380, 170, 30));

        AttendanceBtn.setBorder(null);
        AttendanceBtn.setText("Attendance Progress");
        AttendanceBtn.setDoubleBuffered(true);
        AttendanceBtn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        AttendanceBtn.setkBorderRadius(30);
        AttendanceBtn.setkEndColor(new java.awt.Color(102, 255, 255));
        AttendanceBtn.setkForeGround(new java.awt.Color(0, 0, 0));
        AttendanceBtn.setkHoverEndColor(new java.awt.Color(204, 204, 204));
        AttendanceBtn.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        AttendanceBtn.setkHoverStartColor(new java.awt.Color(102, 102, 102));
        AttendanceBtn.setkSelectedColor(new java.awt.Color(102, 102, 102));
        AttendanceBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AttendanceBtnActionPerformed(evt);
            }
        });
        Buttons.add(AttendanceBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 170, 30));

        AdminBtn.setBorder(null);
        AdminBtn.setText("Administrators");
        AdminBtn.setDoubleBuffered(true);
        AdminBtn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        AdminBtn.setkBorderRadius(30);
        AdminBtn.setkEndColor(new java.awt.Color(102, 255, 255));
        AdminBtn.setkForeGround(new java.awt.Color(0, 0, 0));
        AdminBtn.setkHoverEndColor(new java.awt.Color(204, 204, 204));
        AdminBtn.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        AdminBtn.setkHoverStartColor(new java.awt.Color(102, 102, 102));
        AdminBtn.setkSelectedColor(new java.awt.Color(102, 102, 102));
        AdminBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AdminBtnActionPerformed(evt);
            }
        });
        Buttons.add(AdminBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 170, 30));

        EmployeeBtn.setBorder(null);
        EmployeeBtn.setText("Employee");
        EmployeeBtn.setDoubleBuffered(true);
        EmployeeBtn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        EmployeeBtn.setkBorderRadius(30);
        EmployeeBtn.setkEndColor(new java.awt.Color(102, 255, 255));
        EmployeeBtn.setkForeGround(new java.awt.Color(0, 0, 0));
        EmployeeBtn.setkHoverEndColor(new java.awt.Color(204, 204, 204));
        EmployeeBtn.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        EmployeeBtn.setkHoverStartColor(new java.awt.Color(102, 102, 102));
        EmployeeBtn.setkSelectedColor(new java.awt.Color(102, 102, 102));
        EmployeeBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EmployeeBtnActionPerformed(evt);
            }
        });
        Buttons.add(EmployeeBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 170, 30));

        DeductionsBtn.setBorder(null);
        DeductionsBtn.setText("Deductions");
        DeductionsBtn.setDoubleBuffered(true);
        DeductionsBtn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        DeductionsBtn.setkBorderRadius(30);
        DeductionsBtn.setkEndColor(new java.awt.Color(102, 255, 255));
        DeductionsBtn.setkForeGround(new java.awt.Color(0, 0, 0));
        DeductionsBtn.setkHoverEndColor(new java.awt.Color(204, 204, 204));
        DeductionsBtn.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        DeductionsBtn.setkHoverStartColor(new java.awt.Color(102, 102, 102));
        DeductionsBtn.setkSelectedColor(new java.awt.Color(102, 102, 102));
        DeductionsBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeductionsBtnActionPerformed(evt);
            }
        });
        Buttons.add(DeductionsBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, 170, 30));

        LoansBtn.setBorder(null);
        LoansBtn.setText("Loans");
        LoansBtn.setDoubleBuffered(true);
        LoansBtn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        LoansBtn.setkBorderRadius(30);
        LoansBtn.setkEndColor(new java.awt.Color(102, 255, 255));
        LoansBtn.setkForeGround(new java.awt.Color(0, 0, 0));
        LoansBtn.setkHoverEndColor(new java.awt.Color(204, 204, 204));
        LoansBtn.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        LoansBtn.setkHoverStartColor(new java.awt.Color(102, 102, 102));
        LoansBtn.setkSelectedColor(new java.awt.Color(102, 102, 102));
        LoansBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LoansBtnActionPerformed(evt);
            }
        });
        Buttons.add(LoansBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, 170, 30));

        BonusBtn.setBorder(null);
        BonusBtn.setText("Bonus");
        BonusBtn.setDoubleBuffered(true);
        BonusBtn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        BonusBtn.setkBorderRadius(30);
        BonusBtn.setkEndColor(new java.awt.Color(102, 255, 255));
        BonusBtn.setkForeGround(new java.awt.Color(0, 0, 0));
        BonusBtn.setkHoverEndColor(new java.awt.Color(204, 204, 204));
        BonusBtn.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        BonusBtn.setkHoverStartColor(new java.awt.Color(102, 102, 102));
        BonusBtn.setkSelectedColor(new java.awt.Color(102, 102, 102));
        BonusBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BonusBtnActionPerformed(evt);
            }
        });
        Buttons.add(BonusBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 300, 170, 30));

        PaymentsBtn.setBorder(null);
        PaymentsBtn.setText("Payments");
        PaymentsBtn.setDoubleBuffered(true);
        PaymentsBtn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        PaymentsBtn.setkBorderRadius(30);
        PaymentsBtn.setkEndColor(new java.awt.Color(102, 255, 255));
        PaymentsBtn.setkForeGround(new java.awt.Color(0, 0, 0));
        PaymentsBtn.setkHoverEndColor(new java.awt.Color(204, 204, 204));
        PaymentsBtn.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        PaymentsBtn.setkHoverStartColor(new java.awt.Color(102, 102, 102));
        PaymentsBtn.setkSelectedColor(new java.awt.Color(102, 102, 102));
        PaymentsBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PaymentsBtnActionPerformed(evt);
            }
        });
        Buttons.add(PaymentsBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 420, 170, 30));

        DashboardBtn1.setBorder(null);
        DashboardBtn1.setText("Dash Board");
        DashboardBtn1.setDoubleBuffered(true);
        DashboardBtn1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        DashboardBtn1.setkBorderRadius(30);
        DashboardBtn1.setkEndColor(new java.awt.Color(102, 255, 255));
        DashboardBtn1.setkForeGround(new java.awt.Color(0, 0, 0));
        DashboardBtn1.setkHoverEndColor(new java.awt.Color(204, 204, 204));
        DashboardBtn1.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        DashboardBtn1.setkHoverStartColor(new java.awt.Color(102, 102, 102));
        DashboardBtn1.setkSelectedColor(new java.awt.Color(102, 102, 102));
        DashboardBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DashboardBtn1ActionPerformed(evt);
            }
        });
        Buttons.add(DashboardBtn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 170, 30));

        AmountEarned.setBorder(null);
        AmountEarned.setText("Amount Earned");
        AmountEarned.setDoubleBuffered(true);
        AmountEarned.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        AmountEarned.setkBorderRadius(30);
        AmountEarned.setkEndColor(new java.awt.Color(102, 255, 255));
        AmountEarned.setkForeGround(new java.awt.Color(0, 0, 0));
        AmountEarned.setkHoverEndColor(new java.awt.Color(204, 204, 204));
        AmountEarned.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        AmountEarned.setkHoverStartColor(new java.awt.Color(102, 102, 102));
        AmountEarned.setkSelectedColor(new java.awt.Color(102, 102, 102));
        AmountEarned.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AmountEarnedActionPerformed(evt);
            }
        });
        Buttons.add(AmountEarned, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 340, 170, 30));

        jPanel1.add(Buttons, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 190, 590));

        jLayeredPane1.setBackground(new java.awt.Color(253, 252, 220));
        jLayeredPane1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTabbedPane1.setBackground(new java.awt.Color(253, 252, 220));
        jTabbedPane1.setFont(new java.awt.Font("Segoe UI Symbol", 0, 14)); // NOI18N

        Attendance.setBackground(new java.awt.Color(255, 255, 255));
        Attendance.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtSearchAttendance.setFont(new java.awt.Font("MV Boli", 0, 14)); // NOI18N
        txtSearchAttendance.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchAttendanceKeyReleased(evt);
            }
        });
        Attendance.add(txtSearchAttendance, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 60, 200, 30));

        AttendanceTable.setFont(new java.awt.Font("Microsoft YaHei UI Light", 0, 14)); // NOI18N
        AttendanceTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Date", "Employee ID", "Time In", "Time Out"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        AttendanceTable.setGridColor(new java.awt.Color(255, 255, 255));
        AttendanceTable.setIntercellSpacing(new java.awt.Dimension(0, 0));
        AttendanceTable.setRowHeight(25);
        AttendanceTable.setSelectionBackground(new java.awt.Color(255, 204, 0));
        AttendanceTable.setShowVerticalLines(false);
        AttendanceTable.getTableHeader().setReorderingAllowed(false);
        AttendanceTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                AttendanceTableMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(AttendanceTable);

        Attendance.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(312, 110, 460, 350));

        txtEmpID.setFont(new java.awt.Font("MV Boli", 0, 14)); // NOI18N
        txtEmpID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEmpIDActionPerformed(evt);
            }
        });
        Attendance.add(txtEmpID, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 130, 160, 30));

        jLabel1.setFont(new java.awt.Font("Microsoft YaHei UI Light", 0, 15)); // NOI18N
        jLabel1.setText("Employee ID :");
        Attendance.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, -1, 30));
        Attendance.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 140, 10));

        jLabel2.setFont(new java.awt.Font("Segoe Print", 1, 15)); // NOI18N
        jLabel2.setText("Mark Attendance");
        Attendance.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, -1, -1));

        jComboBox1.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 12)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Time In", "Time Out", " " }));
        Attendance.add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 180, 160, -1));

        BtnSubmit.setBorder(null);
        BtnSubmit.setText("SUBMIT");
        BtnSubmit.setFont(new java.awt.Font("Microsoft YaHei Light", 0, 14)); // NOI18N
        BtnSubmit.setkBorderRadius(20);
        BtnSubmit.setkEndColor(new java.awt.Color(255, 204, 0));
        BtnSubmit.setkHoverEndColor(new java.awt.Color(102, 102, 102));
        BtnSubmit.setkHoverForeGround(new java.awt.Color(0, 0, 0));
        BtnSubmit.setkHoverStartColor(new java.awt.Color(255, 255, 255));
        BtnSubmit.setkStartColor(new java.awt.Color(0, 0, 0));
        BtnSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnSubmitActionPerformed(evt);
            }
        });
        Attendance.add(BtnSubmit, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 250, 100, 30));

        BtnReset.setBorder(null);
        BtnReset.setText("RESET");
        BtnReset.setFont(new java.awt.Font("Microsoft YaHei Light", 0, 14)); // NOI18N
        BtnReset.setkBorderRadius(20);
        BtnReset.setkEndColor(new java.awt.Color(255, 204, 0));
        BtnReset.setkHoverEndColor(new java.awt.Color(102, 102, 102));
        BtnReset.setkHoverForeGround(new java.awt.Color(0, 0, 0));
        BtnReset.setkHoverStartColor(new java.awt.Color(255, 255, 255));
        BtnReset.setkStartColor(new java.awt.Color(0, 0, 0));
        BtnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnResetActionPerformed(evt);
            }
        });
        Attendance.add(BtnReset, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 250, 100, 30));

        jTabbedPane1.addTab("Mark Attendance", Attendance);

        DashBoard.setBackground(new java.awt.Color(255, 255, 255));
        DashBoard.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtPresent.setFont(new java.awt.Font("Tekton Pro Ext", 0, 18)); // NOI18N
        txtPresent.setText("100");
        DashBoard.add(txtPresent, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 110, 60, 40));

        txtAbsent.setFont(new java.awt.Font("Tekton Pro Ext", 0, 18)); // NOI18N
        txtAbsent.setText("100");
        DashBoard.add(txtAbsent, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 130, -1, -1));

        txtLatecomers.setFont(new java.awt.Font("Tekton Pro Ext", 0, 18)); // NOI18N
        txtLatecomers.setText("100");
        DashBoard.add(txtLatecomers, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 120, -1, -1));

        txtDaystopayday.setFont(new java.awt.Font("Tekton Pro Ext", 0, 18)); // NOI18N
        txtDaystopayday.setText("100");
        DashBoard.add(txtDaystopayday, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 310, -1, -1));

        LateLabel.setFont(new java.awt.Font("Yu Gothic Light", 1, 18)); // NOI18N
        LateLabel.setText("LateComers");
        DashBoard.add(LateLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 150, 120, 40));

        LatebTN.setkBorderRadius(20);
        LatebTN.setkEndColor(new java.awt.Color(255, 255, 255));
        LatebTN.setkHoverEndColor(new java.awt.Color(255, 255, 255));
        LatebTN.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        LatebTN.setkHoverStartColor(new java.awt.Color(0, 102, 102));
        LatebTN.setkStartColor(new java.awt.Color(0, 102, 153));
        DashBoard.add(LatebTN, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 70, -1, 140));

        PresentLabel.setFont(new java.awt.Font("Yu Gothic Light", 1, 18)); // NOI18N
        PresentLabel.setText("Present");
        DashBoard.add(PresentLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 150, 70, 40));

        PresentBtn.setkBorderRadius(20);
        PresentBtn.setkEndColor(new java.awt.Color(255, 255, 255));
        PresentBtn.setkHoverEndColor(new java.awt.Color(255, 255, 255));
        PresentBtn.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        PresentBtn.setkHoverStartColor(new java.awt.Color(0, 102, 102));
        PresentBtn.setkStartColor(new java.awt.Color(0, 102, 153));
        DashBoard.add(PresentBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 70, -1, 140));

        AbsentLabel.setFont(new java.awt.Font("Yu Gothic Light", 1, 18)); // NOI18N
        AbsentLabel.setText("Absent");
        DashBoard.add(AbsentLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 150, 70, 40));

        AbsentBtn.setkBorderRadius(20);
        AbsentBtn.setkEndColor(new java.awt.Color(255, 255, 255));
        AbsentBtn.setkHoverEndColor(new java.awt.Color(255, 255, 255));
        AbsentBtn.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        AbsentBtn.setkHoverStartColor(new java.awt.Color(0, 102, 102));
        AbsentBtn.setkStartColor(new java.awt.Color(0, 102, 153));
        DashBoard.add(AbsentBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 70, -1, 140));

        AdminLabel.setFont(new java.awt.Font("Yu Gothic Light", 1, 18)); // NOI18N
        AdminLabel.setText("Administrators");
        DashBoard.add(AdminLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 350, 130, 40));

        AdminCount.setFont(new java.awt.Font("Tekton Pro", 0, 18)); // NOI18N
        AdminCount.setText("10");
        DashBoard.add(AdminCount, new org.netbeans.lib.awtextra.AbsoluteConstraints(454, 350, 30, 40));

        AdminisBtn.setkEndColor(new java.awt.Color(255, 255, 255));
        AdminisBtn.setkHoverEndColor(new java.awt.Color(102, 102, 102));
        AdminisBtn.setkHoverStartColor(new java.awt.Color(255, 255, 255));
        AdminisBtn.setkStartColor(new java.awt.Color(102, 102, 102));
        DashBoard.add(AdminisBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 340, -1, 60));

        DaysLabel.setFont(new java.awt.Font("Yu Gothic Light", 1, 18)); // NOI18N
        DaysLabel.setText("Days To Pay Day");
        DashBoard.add(DaysLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 340, 150, 40));

        DAYsBtn1.setkEndColor(new java.awt.Color(255, 255, 255));
        DAYsBtn1.setkHoverEndColor(new java.awt.Color(102, 102, 102));
        DAYsBtn1.setkHoverStartColor(new java.awt.Color(102, 102, 102));
        DAYsBtn1.setkStartColor(new java.awt.Color(0, 51, 153));
        DashBoard.add(DAYsBtn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 260, -1, 140));

        EmpLabel.setFont(new java.awt.Font("Yu Gothic Light", 1, 18)); // NOI18N
        EmpLabel.setText("Employees");
        DashBoard.add(EmpLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 270, 100, 40));

        empCount.setFont(new java.awt.Font("Tekton Pro", 0, 18)); // NOI18N
        empCount.setText("10");
        DashBoard.add(empCount, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 280, -1, 30));

        Empbtn.setkEndColor(new java.awt.Color(255, 255, 255));
        Empbtn.setkHoverEndColor(new java.awt.Color(102, 102, 102));
        Empbtn.setkHoverStartColor(new java.awt.Color(255, 255, 255));
        Empbtn.setkStartColor(new java.awt.Color(102, 102, 102));
        DashBoard.add(Empbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 260, -1, 60));

        TimeLabel.setFont(new java.awt.Font("SimSun-ExtB", 1, 18)); // NOI18N
        TimeLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        TimeLabel.setText("Time");
        DashBoard.add(TimeLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 280, 190, -1));

        DateLabel.setFont(new java.awt.Font("SimSun-ExtB", 1, 18)); // NOI18N
        DateLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        DateLabel.setText("Date");
        DashBoard.add(DateLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 340, 190, -1));

        jTabbedPane1.addTab("DashBoard", DashBoard);

        jLayeredPane1.add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 550));

        AttendanceProgress.setBackground(new java.awt.Color(255, 255, 255));
        AttendanceProgress.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        CP.setBackground(new java.awt.Color(255, 255, 255));
        CP.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Present Employee Chart", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI Semibold", 0, 14))); // NOI18N
        CP.setLayout(new java.awt.BorderLayout());
        AttendanceProgress.add(CP, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 50, 720, 230));

        CPP.setBackground(new java.awt.Color(255, 255, 255));
        CPP.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(null, "Absent Employee Chart", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12)))); // NOI18N
        CPP.setLayout(new java.awt.BorderLayout());
        AttendanceProgress.add(CPP, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 320, 710, 210));

        jLayeredPane1.add(AttendanceProgress, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 550));

        Administrator.setBackground(new java.awt.Color(255, 255, 255));
        Administrator.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        TableAdministrator.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 13)); // NOI18N
        TableAdministrator.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Admin ID", "Full Name", "Contact", "User Name"
            }
        ));
        TableAdministrator.setIntercellSpacing(new java.awt.Dimension(0, 0));
        TableAdministrator.setRowHeight(20);
        TableAdministrator.setShowHorizontalLines(false);
        TableAdministrator.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TableAdministratorMouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                TableAdministratorMouseReleased(evt);
            }
        });
        jScrollPane2.setViewportView(TableAdministrator);

        Administrator.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 300, 650, 220));

        txtUsername.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUsernameActionPerformed(evt);
            }
        });
        Administrator.add(txtUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 150, 190, 30));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("  Full Name   :");
        Administrator.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 150, 90, 30));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText(" Contact     :");
        Administrator.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 110, 80, 30));

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setText("Username  :");
        Administrator.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 150, -1, 30));

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setText("Password   :");
        Administrator.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 190, -1, 30));

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel11.setText("Confirm Password :");
        Administrator.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 190, -1, 30));

        searchAdmin.setFont(new java.awt.Font("Microsoft YaHei UI Light", 0, 12)); // NOI18N
        searchAdmin.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchAdminKeyReleased(evt);
            }
        });
        Administrator.add(searchAdmin, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 260, 220, 30));

        txtAdminID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAdminIDActionPerformed(evt);
            }
        });
        Administrator.add(txtAdminID, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 110, 190, 30));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Admin ID   :");
        Administrator.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 110, 80, 30));

        txtAdminFullname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAdminFullnameActionPerformed(evt);
            }
        });
        txtAdminFullname.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtAdminFullnameKeyReleased(evt);
            }
        });
        Administrator.add(txtAdminFullname, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 150, 190, 30));

        txtAdminContact.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAdminContactActionPerformed(evt);
            }
        });
        txtAdminContact.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtAdminContactKeyReleased(evt);
            }
        });
        Administrator.add(txtAdminContact, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 110, 190, 30));

        txtConPass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtConPassActionPerformed(evt);
            }
        });
        Administrator.add(txtConPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 190, 190, 30));

        txtPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPasswordActionPerformed(evt);
            }
        });
        Administrator.add(txtPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 190, 190, 30));

        UpadateAdminBtn.setText("Update Administrator");
        UpadateAdminBtn.setFont(new java.awt.Font("Microsoft YaHei", 1, 12)); // NOI18N
        UpadateAdminBtn.setkHoverForeGround(new java.awt.Color(0, 0, 0));
        UpadateAdminBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpadateAdminBtnActionPerformed(evt);
            }
        });
        Administrator.add(UpadateAdminBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 240, 140, 40));

        AddAdminBtn.setText("Add New Administrator");
        AddAdminBtn.setFont(new java.awt.Font("Microsoft YaHei", 1, 12)); // NOI18N
        AddAdminBtn.setkHoverForeGround(new java.awt.Color(0, 0, 0));
        AddAdminBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddAdminBtnActionPerformed(evt);
            }
        });
        Administrator.add(AddAdminBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 240, 160, 40));

        jLabel12.setFont(new java.awt.Font("Segoe Print", 1, 20)); // NOI18N
        jLabel12.setText("Manage Administrators");
        Administrator.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 270, 40));

        jLayeredPane1.add(Administrator, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 550));

        Employee.setBackground(new java.awt.Color(255, 255, 255));
        Employee.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tableEmployee.setFont(new java.awt.Font("Yu Gothic", 0, 13)); // NOI18N
        tableEmployee.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Employee ID", "Full Name", "Contact", "Role", "Basic Salary"
            }
        ));
        tableEmployee.setGridColor(new java.awt.Color(255, 255, 255));
        tableEmployee.setRowHeight(20);
        tableEmployee.setShowHorizontalLines(false);
        tableEmployee.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableEmployeeMouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tableEmployeeMouseReleased(evt);
            }
        });
        jScrollPane3.setViewportView(tableEmployee);

        Employee.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 130, 420, 390));

        searchEmployee.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchEmployeeKeyReleased(evt);
            }
        });
        Employee.add(searchEmployee, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 90, 240, 30));

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel13.setText("Employee ID   :");
        Employee.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 100, 30));

        jLabel14.setFont(new java.awt.Font("Segoe Print", 1, 20)); // NOI18N
        jLabel14.setText("Manage Employee");
        Employee.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 200, 40));

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel15.setText("   Full Name       :");
        Employee.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, 110, 30));

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel17.setText(" Contact         : ");
        Employee.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, 100, 30));

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel18.setText(" Role         :");
        Employee.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 290, 100, 30));
        Employee.add(role, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 290, 170, 30));
        Employee.add(empid, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 130, 170, 30));

        Fullname.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                FullnameKeyReleased(evt);
            }
        });
        Employee.add(Fullname, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 170, 170, 30));

        contact.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                contactKeyReleased(evt);
            }
        });
        Employee.add(contact, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 210, 170, 30));

        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel19.setText(" Salary         :");
        Employee.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, 100, 30));

        salarybasic.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                salarybasicKeyReleased(evt);
            }
        });
        Employee.add(salarybasic, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 250, 170, 30));

        kButton1.setText("UPDATE EMPLOYEE");
        kButton1.setFont(new java.awt.Font("Microsoft YaHei UI Light", 0, 12)); // NOI18N
        kButton1.setkHoverEndColor(new java.awt.Color(255, 255, 255));
        kButton1.setkHoverForeGround(new java.awt.Color(0, 0, 0));
        kButton1.setkHoverStartColor(new java.awt.Color(255, 204, 0));
        kButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kButton1ActionPerformed(evt);
            }
        });
        Employee.add(kButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 350, 120, 30));

        BtnAddEmployee.setText("ADD EMPLOYEE");
        BtnAddEmployee.setFont(new java.awt.Font("Microsoft YaHei UI Light", 0, 12)); // NOI18N
        BtnAddEmployee.setkHoverEndColor(new java.awt.Color(255, 255, 255));
        BtnAddEmployee.setkHoverForeGround(new java.awt.Color(0, 0, 0));
        BtnAddEmployee.setkHoverStartColor(new java.awt.Color(255, 204, 0));
        BtnAddEmployee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnAddEmployeeActionPerformed(evt);
            }
        });
        Employee.add(BtnAddEmployee, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 350, 120, 30));

        jLayeredPane1.add(Employee, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 550));

        deductions.setBackground(new java.awt.Color(255, 255, 255));
        deductions.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tableDeduction.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 13)); // NOI18N
        tableDeduction.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Employee ID", "Amount", "Reason", "Date"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableDeduction.setIntercellSpacing(new java.awt.Dimension(0, 0));
        tableDeduction.setRowHeight(20);
        tableDeduction.setShowHorizontalLines(false);
        tableDeduction.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableDeductionMouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tableDeductionMouseReleased(evt);
            }
        });
        jScrollPane4.setViewportView(tableDeduction);
        if (tableDeduction.getColumnModel().getColumnCount() > 0) {
            tableDeduction.getColumnModel().getColumn(1).setHeaderValue("Amount");
        }

        deductions.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, 720, 280));

        DedEmpID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DedEmpIDActionPerformed(evt);
            }
        });
        deductions.add(DedEmpID, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 100, 120, 30));

        DedAmount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DedAmountActionPerformed(evt);
            }
        });
        DedAmount.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                DedAmountKeyReleased(evt);
            }
        });
        deductions.add(DedAmount, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 100, 120, 30));
        deductions.add(DedReason, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 100, 180, 30));

        jLabel21.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel21.setText("Reason  :");
        deductions.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 100, 60, 30));

        jLabel22.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel22.setText("   Amount  : ");
        deductions.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 100, -1, 30));

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel16.setText("Employee ID   :");
        deductions.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, 100, 30));

        BtnUpdateDeduction.setText("UPDATE DEDUCTION");
        BtnUpdateDeduction.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        BtnUpdateDeduction.setkHoverEndColor(new java.awt.Color(153, 153, 153));
        BtnUpdateDeduction.setkHoverForeGround(new java.awt.Color(0, 0, 0));
        BtnUpdateDeduction.setkHoverStartColor(new java.awt.Color(255, 255, 255));
        BtnUpdateDeduction.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnUpdateDeductionActionPerformed(evt);
            }
        });
        deductions.add(BtnUpdateDeduction, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 180, 120, 30));

        BtnAddDeduction.setText("ADD DEDUCTION");
        BtnAddDeduction.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        BtnAddDeduction.setkHoverEndColor(new java.awt.Color(153, 153, 153));
        BtnAddDeduction.setkHoverForeGround(new java.awt.Color(0, 0, 0));
        BtnAddDeduction.setkHoverStartColor(new java.awt.Color(255, 255, 255));
        BtnAddDeduction.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnAddDeductionActionPerformed(evt);
            }
        });
        deductions.add(BtnAddDeduction, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 180, 110, 30));

        jLabel24.setFont(new java.awt.Font("Segoe Print", 1, 20)); // NOI18N
        jLabel24.setText("Manage Deductions");
        deductions.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, 220, 40));

        SearchDeduction.setFont(new java.awt.Font("Microsoft JhengHei Light", 0, 12)); // NOI18N
        SearchDeduction.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                SearchDeductionKeyReleased(evt);
            }
        });
        deductions.add(SearchDeduction, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, 250, 30));

        jLayeredPane1.add(deductions, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 550));

        generatePayroll.setBackground(new java.awt.Color(255, 255, 255));
        generatePayroll.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel29.setFont(new java.awt.Font("Segoe UI Symbol", 0, 20)); // NOI18N
        jLabel29.setText("Generate Payroll");
        generatePayroll.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, 190, -1));

        jLabel30.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel30.setText("Year :");
        generatePayroll.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 110, -1, -1));

        jLabel31.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel31.setText("Employee ID :");
        generatePayroll.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, -1, -1));

        jLabel32.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel32.setText("Month :");
        generatePayroll.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 110, -1, -1));
        generatePayroll.add(PayrollEmpId, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 110, 160, -1));
        generatePayroll.add(PayrollYear, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 110, 80, -1));

        PayrollMonth.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                PayrollMonthKeyReleased(evt);
            }
        });
        generatePayroll.add(PayrollMonth, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 110, 80, -1));

        BtnIssuePayroll.setText("Issue Payroll");
        BtnIssuePayroll.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        BtnIssuePayroll.setkHoverEndColor(new java.awt.Color(0, 153, 153));
        BtnIssuePayroll.setkHoverForeGround(new java.awt.Color(0, 0, 0));
        BtnIssuePayroll.setkHoverStartColor(new java.awt.Color(255, 255, 255));
        BtnIssuePayroll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnIssuePayrollActionPerformed(evt);
            }
        });
        generatePayroll.add(BtnIssuePayroll, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 480, 100, 30));
        generatePayroll.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 210, 710, 10));

        jLabel33.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel33.setText("Tot Deductions :");
        generatePayroll.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 310, -1, 30));

        jLabel34.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel34.setText("DEDUCTIONS");
        generatePayroll.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 230, -1, 30));

        jLabel35.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel35.setText("No Deductions :");
        generatePayroll.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 270, -1, 30));
        generatePayroll.add(NoOFDeductions, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 270, 60, 30));
        generatePayroll.add(TotDeductios, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 310, 60, 30));

        jLabel37.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel37.setText("LOANS  ");
        generatePayroll.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 230, -1, 30));
        generatePayroll.add(TotLoans, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 270, 60, 30));
        generatePayroll.add(LoanAmountTot, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 310, 60, 30));

        jLabel39.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel39.setText("Tot  Due Amount :");
        generatePayroll.add(jLabel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 310, 120, 30));

        jLabel40.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel40.setText("No of Loans Due  :");
        generatePayroll.add(jLabel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 270, -1, 30));

        jLabel42.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel42.setText("Tot Present Days      :");
        generatePayroll.add(jLabel42, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 270, -1, 30));
        generatePayroll.add(TotPresentDays, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 270, 60, 30));
        generatePayroll.add(TotAbsentDays, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 310, 60, 30));

        jLabel43.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel43.setText("Tot Absent Days       :");
        generatePayroll.add(jLabel43, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 310, -1, 30));
        generatePayroll.add(Bonus, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 460, 140, 30));

        jLabel45.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel45.setText("ATTENDANCE  ");
        generatePayroll.add(jLabel45, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 230, -1, 30));

        jLabel46.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel46.setText("Bonus : ");
        generatePayroll.add(jLabel46, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 460, 60, 30));

        jLabel47.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel47.setText("Final Amount To Be Paid :");
        generatePayroll.add(jLabel47, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 410, 170, 30));
        generatePayroll.add(FinalAmount, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 410, 160, 30));

        kButton3.setText("Generate Payroll");
        kButton3.setFont(new java.awt.Font("Yu Gothic Medium", 1, 11)); // NOI18N
        kButton3.setkEndColor(new java.awt.Color(0, 153, 153));
        kButton3.setkHoverForeGround(new java.awt.Color(0, 0, 0));
        kButton3.setkHoverStartColor(new java.awt.Color(255, 255, 255));
        kButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kButton3ActionPerformed(evt);
            }
        });
        generatePayroll.add(kButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 160, 120, 30));

        BtnPay.setText("Pay");
        BtnPay.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        BtnPay.setkHoverEndColor(new java.awt.Color(0, 153, 153));
        BtnPay.setkHoverForeGround(new java.awt.Color(0, 0, 0));
        BtnPay.setkHoverStartColor(new java.awt.Color(255, 255, 255));
        BtnPay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnPayActionPerformed(evt);
            }
        });
        generatePayroll.add(BtnPay, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 480, 80, 30));

        jLabel48.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel48.setText("Salary Earned :");
        generatePayroll.add(jLabel48, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 410, 100, 30));
        generatePayroll.add(SalaryEarned, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 410, 140, 30));

        jLayeredPane1.add(generatePayroll, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 550));

        payments.setBackground(new java.awt.Color(255, 255, 255));
        payments.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel36.setFont(new java.awt.Font("Segoe Print", 0, 20)); // NOI18N
        jLabel36.setText("Manage Payments");
        payments.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, -1, -1));

        tablePayments.setFont(new java.awt.Font("Yu Gothic UI", 0, 12)); // NOI18N
        tablePayments.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Employee ID", "HourlySalary ", "Hours Worked", "Salary Earned", "Due Loans", "Deductions", "Bonus", "Tot Payment", "Date"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablePayments.setIntercellSpacing(new java.awt.Dimension(0, 0));
        tablePayments.setRowHeight(20);
        tablePayments.setShowHorizontalLines(false);
        tablePayments.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tablePaymentsMouseReleased(evt);
            }
        });
        jScrollPane6.setViewportView(tablePayments);

        payments.add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 730, 360));

        searchPayments.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchPaymentsKeyReleased(evt);
            }
        });
        payments.add(searchPayments, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 90, 240, 30));

        jLayeredPane1.add(payments, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 550));

        lOAN.setBackground(new java.awt.Color(255, 255, 255));
        lOAN.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tableLoan.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        tableLoan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Employee ID", "Amount", "Reason", "Issue Date", "Due Date", "Settled"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableLoan.setIntercellSpacing(new java.awt.Dimension(0, 0));
        tableLoan.setRowHeight(20);
        tableLoan.setShowVerticalLines(false);
        tableLoan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableLoanMouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tableLoanMouseReleased(evt);
            }
        });
        jScrollPane5.setViewportView(tableLoan);

        lOAN.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 750, 190));

        SearchLoan.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                SearchLoanKeyReleased(evt);
            }
        });
        lOAN.add(SearchLoan, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 80, 250, 30));

        LoanEmpID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LoanEmpIDActionPerformed(evt);
            }
        });
        lOAN.add(LoanEmpID, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 330, 170, 30));

        jLabel20.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel20.setText("Employee ID   :");
        lOAN.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 330, 100, 30));

        jLabel23.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel23.setText("   Amount          : ");
        lOAN.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 370, -1, 30));

        LoanAmount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LoanAmountActionPerformed(evt);
            }
        });
        LoanAmount.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                LoanAmountKeyReleased(evt);
            }
        });
        lOAN.add(LoanAmount, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 370, 170, 30));

        LoanIssuedDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LoanIssuedDateActionPerformed(evt);
            }
        });
        lOAN.add(LoanIssuedDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 330, 170, 30));

        jLabel25.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel25.setText("Issue Date       :");
        lOAN.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 330, 100, 30));

        jLabel26.setFont(new java.awt.Font("Segoe UI Semilight", 0, 18)); // NOI18N
        jLabel26.setText("Manage Loans");
        lOAN.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 220, 40));
        lOAN.add(LoanDueDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 370, 170, 30));

        jLabel27.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel27.setText("Due  Date       :");
        lOAN.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 370, 100, 30));

        LoanReason.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LoanReasonActionPerformed(evt);
            }
        });
        lOAN.add(LoanReason, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 420, 170, 30));

        jLabel28.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel28.setText("Reason           :");
        lOAN.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 420, 100, 30));

        BtnUpdateLoan.setText("UPDATE  LOAN");
        BtnUpdateLoan.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        BtnUpdateLoan.setkHoverEndColor(new java.awt.Color(0, 153, 153));
        BtnUpdateLoan.setkHoverForeGround(new java.awt.Color(0, 0, 0));
        BtnUpdateLoan.setkHoverStartColor(new java.awt.Color(255, 255, 255));
        BtnUpdateLoan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnUpdateLoanActionPerformed(evt);
            }
        });
        lOAN.add(BtnUpdateLoan, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 470, 120, 30));

        BtnAddLoan.setText("ADD LOAN");
        BtnAddLoan.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        BtnAddLoan.setkHoverEndColor(new java.awt.Color(0, 153, 153));
        BtnAddLoan.setkHoverForeGround(new java.awt.Color(0, 0, 0));
        BtnAddLoan.setkHoverStartColor(new java.awt.Color(255, 255, 255));
        BtnAddLoan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnAddLoanActionPerformed(evt);
            }
        });
        lOAN.add(BtnAddLoan, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 470, 120, 30));

        LoanSettled.setText("Settled");
        LoanSettled.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        LoanSettled.setkHoverEndColor(new java.awt.Color(0, 153, 153));
        LoanSettled.setkHoverForeGround(new java.awt.Color(0, 0, 0));
        LoanSettled.setkHoverStartColor(new java.awt.Color(255, 255, 255));
        LoanSettled.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LoanSettledActionPerformed(evt);
            }
        });
        lOAN.add(LoanSettled, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 470, 90, 30));

        jLayeredPane1.add(lOAN, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 550));

        bonus.setBackground(new java.awt.Color(255, 255, 255));
        bonus.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Segoe Print", 0, 20)); // NOI18N
        jLabel3.setText("Manage Bonus");
        bonus.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, -1, -1));

        jLabel49.setFont(new java.awt.Font("Segoe UI Semilight", 0, 18)); // NOI18N
        jLabel49.setText("Reason  :");
        bonus.add(jLabel49, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 390, -1, -1));

        jLabel50.setFont(new java.awt.Font("Segoe UI Semilight", 0, 18)); // NOI18N
        jLabel50.setText("Amount :");
        bonus.add(jLabel50, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 440, -1, -1));

        jLabel51.setFont(new java.awt.Font("Segoe UI Semilight", 0, 18)); // NOI18N
        jLabel51.setText("Year    :");
        bonus.add(jLabel51, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 390, -1, -1));

        tableBonus.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 12)); // NOI18N
        tableBonus.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Bonus ID", "Reason", "Amount", "Month", "Year"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableBonus.setGridColor(new java.awt.Color(204, 204, 204));
        tableBonus.setRowHeight(25);
        tableBonus.setShowHorizontalLines(false);
        tableBonus.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableBonusMouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tableBonusMouseReleased(evt);
            }
        });
        jScrollPane7.setViewportView(tableBonus);

        bonus.add(jScrollPane7, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 110, 630, 240));

        BonusAmount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BonusAmountActionPerformed(evt);
            }
        });
        BonusAmount.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                BonusAmountKeyReleased(evt);
            }
        });
        bonus.add(BonusAmount, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 440, 170, 30));

        BonusYear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BonusYearActionPerformed(evt);
            }
        });
        bonus.add(BonusYear, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 390, 90, 30));

        BonusReason.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BonusReasonActionPerformed(evt);
            }
        });
        bonus.add(BonusReason, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 390, 170, 30));
        bonus.add(BonusMonth, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 440, 90, 30));

        jLabel52.setFont(new java.awt.Font("Segoe UI Semilight", 0, 18)); // NOI18N
        jLabel52.setText("Month :");
        bonus.add(jLabel52, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 440, -1, -1));

        BtnUpdateBonus.setText("UPDATE BONUS");
        BtnUpdateBonus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnUpdateBonusActionPerformed(evt);
            }
        });
        bonus.add(BtnUpdateBonus, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 440, 130, 30));

        BtnAddBonus.setText("ADD BONUS");
        BtnAddBonus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnAddBonusActionPerformed(evt);
            }
        });
        bonus.add(BtnAddBonus, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 390, 130, 30));

        searchBonus.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchBonusKeyReleased(evt);
            }
        });
        bonus.add(searchBonus, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 70, 230, -1));

        jLayeredPane1.add(bonus, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 550));

        amountEarn.setBackground(new java.awt.Color(255, 255, 255));
        amountEarn.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        amountEarnedTable.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        amountEarnedTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Date", "Employee ID", "Hours Worked", "Basic Salary per hour", "Amount Earned"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        amountEarnedTable.setGridColor(new java.awt.Color(204, 204, 204));
        amountEarnedTable.setRowHeight(25);
        amountEarnedTable.setShowHorizontalLines(false);
        amountEarnedTable.getTableHeader().setReorderingAllowed(false);
        amountEarnedTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                amountEarnedTableMouseReleased(evt);
            }
        });
        jScrollPane8.setViewportView(amountEarnedTable);

        amountEarn.add(jScrollPane8, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 150, 670, 340));

        jLabel53.setFont(new java.awt.Font("Segoe Print", 0, 20)); // NOI18N
        jLabel53.setText("Amount Earned by Employee Per Day");
        amountEarn.add(jLabel53, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, -1, -1));

        searchAmountEarned.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchAmountEarnedKeyReleased(evt);
            }
        });
        amountEarn.add(searchAmountEarned, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 110, 210, 30));

        jLayeredPane1.add(amountEarn, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 550));

        jPanel1.add(jLayeredPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 40, 800, 550));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void LogoutLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LogoutLabelMouseClicked
        LoginForm aa = new LoginForm();
        aa.setVisible(true);
        aa.setLocationRelativeTo(null);
        aa.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.dispose();
    }//GEN-LAST:event_LogoutLabelMouseClicked

    private void txtSearchAttendanceKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchAttendanceKeyReleased
        String query = txtSearchAttendance.getText().toLowerCase();
        filter(query);
    }//GEN-LAST:event_txtSearchAttendanceKeyReleased

    private void txtEmpIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmpIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEmpIDActionPerformed

    private void BtnSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnSubmitActionPerformed
        try {
            String EmpId = txtEmpID.getText();
            String combo = jComboBox1.getSelectedItem().toString();
            String CDate = DateLabel.getText();
            String CTime = TimeLabel.getText();

            if (("".equals(EmpId))) {
                JOptionPane.showMessageDialog(null, "missing feild");
            }
            boolean isValid = new AttendanceController().checkValidity(EmpId);
            if (isValid == false) {
                JOptionPane.showMessageDialog(this, "Invalid EmpID");
            }
            if (combo == "Time In") {
                try {
                    boolean isMarked;
                    isMarked = new AttendanceController().
                            markAttendanceIn(new AttendanceModel(EmpId, CDate, CTime));
                    if (isMarked) {
                        loadAttendanceTable();
                        JOptionPane.showMessageDialog(this, "Attendance Marked");
                    } else {
                        JOptionPane.showMessageDialog(this, "Try Again");
                    }
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "error");
                } catch (ClassNotFoundException ex) {
                    JOptionPane.showMessageDialog(null, "error");
                }
            }
            if (combo == "Time Out") {

                boolean isMarked;
                isMarked = new AttendanceController().
                        markAttendanceOut(new AttendanceModel(EmpId, CDate, CTime));
                if (isMarked) {
                    loadAttendanceTable();
                    loadAmountEarnedTable();
                    JOptionPane.showMessageDialog(this, "Attendance Marked");
                } else {
                    JOptionPane.showMessageDialog(this, "Try Again");
                }
            }
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, ex);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }//GEN-LAST:event_BtnSubmitActionPerformed

    private void BtnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnResetActionPerformed
        txtEmpID.setText("");
    }//GEN-LAST:event_BtnResetActionPerformed

    private void AttendanceTableMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AttendanceTableMouseReleased
        if (evt.isPopupTrigger()) {
            jPopupMenu1.show(this, evt.getX(), evt.getY());
        }
    }//GEN-LAST:event_AttendanceTableMouseReleased

    private void AttendanceBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AttendanceBtnActionPerformed
        AttendanceProgress.setVisible(true);
        jTabbedPane1.setVisible(false);
        lOAN.setVisible(false);
        deductions.setVisible(false);
        Employee.setVisible(false);
        Administrator.setVisible(false);
        bonus.setVisible(false);
        generatePayroll.setVisible(false);
        payments.setVisible(false);
        amountEarn.setVisible(false);
        loadAttendanceTable();
    }//GEN-LAST:event_AttendanceBtnActionPerformed

    private void DashboardBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DashboardBtn1ActionPerformed
        
        jTabbedPane1.setVisible(true);
        DashBoard.setVisible(true);
        Attendance.setVisible(false);
        AttendanceProgress.setVisible(false);
        lOAN.setVisible(false);
        deductions.setVisible(false);
        Employee.setVisible(false);
        Administrator.setVisible(false);
        bonus.setVisible(false);
        generatePayroll.setVisible(false);
        payments.setVisible(false);
        amountEarn.setVisible(false);
        
    }//GEN-LAST:event_DashboardBtn1ActionPerformed

    private void AdminBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AdminBtnActionPerformed
        Administrator.setVisible(true);
        AttendanceProgress.setVisible(false);
        jTabbedPane1.setVisible(false);
        lOAN.setVisible(false);
        deductions.setVisible(false);
        Employee.setVisible(false);
        bonus.setVisible(false);
        generatePayroll.setVisible(false);
        payments.setVisible(false);
        amountEarn.setVisible(false);
        loadAdministratorTable();
    }//GEN-LAST:event_AdminBtnActionPerformed

    private void EmployeeBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EmployeeBtnActionPerformed
        Employee.setVisible(true);
        Administrator.setVisible(false);
        AttendanceProgress.setVisible(false);
        jTabbedPane1.setVisible(false);
        lOAN.setVisible(false);
        deductions.setVisible(false);
        bonus.setVisible(false);
        generatePayroll.setVisible(false);
        payments.setVisible(false);
        amountEarn.setVisible(false);
        loadEmployeeTable();
    }//GEN-LAST:event_EmployeeBtnActionPerformed

    private void DeductionsBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeductionsBtnActionPerformed
        deductions.setVisible(true);
        Employee.setVisible(false);
        Administrator.setVisible(false);
        AttendanceProgress.setVisible(false);
        jTabbedPane1.setVisible(false);
        lOAN.setVisible(false);
        bonus.setVisible(false);
        generatePayroll.setVisible(false);
        payments.setVisible(false);
        amountEarn.setVisible(false);
        loadDeductionTable();
    }//GEN-LAST:event_DeductionsBtnActionPerformed

    private void LoansBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LoansBtnActionPerformed
        lOAN.setVisible(true);
        deductions.setVisible(false);
        Employee.setVisible(false);
        Administrator.setVisible(false);
        AttendanceProgress.setVisible(false);
        jTabbedPane1.setVisible(false);
        bonus.setVisible(false);
        generatePayroll.setVisible(false);
        amountEarn.setVisible(false);
        payments.setVisible(false);
        loadLoanTable();
    }//GEN-LAST:event_LoansBtnActionPerformed

    private void BonusBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BonusBtnActionPerformed
        bonus.setVisible(true);
        lOAN.setVisible(false);
        deductions.setVisible(false);
        amountEarn.setVisible(false);
        Employee.setVisible(false);
        Administrator.setVisible(false);
        AttendanceProgress.setVisible(false);
        jTabbedPane1.setVisible(false);
        generatePayroll.setVisible(false);
        loadBonusTable();
    }//GEN-LAST:event_BonusBtnActionPerformed

    private void GenPayrollBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GenPayrollBtnActionPerformed

        generatePayroll.setVisible(true);
        bonus.setVisible(false);
        lOAN.setVisible(false);
        deductions.setVisible(false);
        Employee.setVisible(false);
        Administrator.setVisible(false);
        AttendanceProgress.setVisible(false);
        jTabbedPane1.setVisible(false);
        amountEarn.setVisible(false);
        payments.setVisible(false);
        
    }//GEN-LAST:event_GenPayrollBtnActionPerformed

    private void PaymentsBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PaymentsBtnActionPerformed
        payments.setVisible(true);
        generatePayroll.setVisible(false);
        bonus.setVisible(false);
        lOAN.setVisible(false);
        deductions.setVisible(false);
        Employee.setVisible(false);
        Administrator.setVisible(false);
        AttendanceProgress.setVisible(false);
        jTabbedPane1.setVisible(false);
        amountEarn.setVisible(false);
        loadPaymentTable();
    }//GEN-LAST:event_PaymentsBtnActionPerformed

    private void txtConPassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtConPassActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtConPassActionPerformed

    private void txtPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPasswordActionPerformed
        txtConPass.requestFocus();
    }//GEN-LAST:event_txtPasswordActionPerformed

    private void searchAdminKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchAdminKeyReleased
        String query = searchAdmin.getText().toLowerCase();
        filterAdmin(query);
    }//GEN-LAST:event_searchAdminKeyReleased

    private void TableAdministratorMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableAdministratorMouseReleased
        if (evt.isPopupTrigger()) {
            jPopupMenu2Admin.show(this, evt.getX(), evt.getY());
        }
    }//GEN-LAST:event_TableAdministratorMouseReleased

    public void popupTableAdmin() {
        JPopupMenu popupMenu = new JPopupMenu();
        JMenuItem menuItem1 = new JMenuItem("DeletE");
        menuItem1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DefaultTableModel model = (DefaultTableModel) TableAdministrator.getModel();

                int SelectedRowIndex = TableAdministrator.getSelectedRow();
                String s = TableAdministrator.getModel().getValueAt(SelectedRowIndex, 0).toString();
                boolean isDeleted;
                try {
                    isDeleted = new AdministratorController().deleteAdmin(new AdministratorModel(s));
                    if (isDeleted) {
                        JOptionPane.showMessageDialog(null, "Admin Deleted");
                        model.removeRow(SelectedRowIndex);
                    } else {
                        JOptionPane.showMessageDialog(null, "Try Again");
                    }
                } catch (ClassNotFoundException ex) {
                    JOptionPane.showMessageDialog(null, "error");
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "error");
                }
            }
        });
        popupMenu.add(menuItem1);
        TableAdministrator.setComponentPopupMenu(popupMenu);
    }

    private void AddAdminBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddAdminBtnActionPerformed
        // TODO add your handling code here:
        String id = txtAdminID.getText();
        String fullname = txtAdminFullname.getText();
        int contact = Integer.parseInt(txtAdminContact.getText());
        String username = txtUsername.getText();
        String password = txtPassword.getText();
        String conpass = txtConPass.getText();

        if (conpass.equals(password)) {
            if (txtAdminID.getText().equals("") || txtAdminFullname.getText().equals("") || txtAdminContact.getText().equals("")
                    || txtUsername.getText().equals("") || txtPassword.getText().equals("") || txtConPass.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "missing feilds");
                
                   id = txtAdminID.getText();
         fullname = txtAdminFullname.getText();
         contact = Integer.parseInt(txtAdminContact.getText());
         username = txtUsername.getText();
         password = txtPassword.getText();
        conpass = txtConPass.getText();
                
                
                
            } else {
                AdministratorModel admin = new AdministratorModel(id, fullname, contact, username, password);
                try {
                    boolean isAdded = AdministratorController.addAdmin(admin);
                    if (isAdded) {
                        JOptionPane.showMessageDialog(this, "Added Success");
                    } else {
                        JOptionPane.showMessageDialog(this, "Added Fail");
                    }
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "error");
                } catch (ClassNotFoundException ex) {
                    JOptionPane.showMessageDialog(null, "error");
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "passwords dont match");
        }
        loadAdministratorTable();
    }//GEN-LAST:event_AddAdminBtnActionPerformed

    private void txtUsernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUsernameActionPerformed
        txtPassword.requestFocus();
    }//GEN-LAST:event_txtUsernameActionPerformed

    private void TableAdministratorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableAdministratorMouseClicked
        int SelectedRow = TableAdministrator.getSelectedRow();
        DefaultTableModel model = (DefaultTableModel) TableAdministrator.getModel();
        txtAdminID.setText(model.getValueAt(SelectedRow, 0).toString());
        txtAdminFullname.setText(model.getValueAt(SelectedRow, 1).toString());
        txtAdminContact.setText(model.getValueAt(SelectedRow, 2).toString());
        txtUsername.setText(model.getValueAt(SelectedRow, 3).toString());

    }//GEN-LAST:event_TableAdministratorMouseClicked

    private void UpadateAdminBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpadateAdminBtnActionPerformed
        int i = TableAdministrator.getSelectedRow();
        DefaultTableModel model = (DefaultTableModel) TableAdministrator.getModel();
        if (i >= 0) {
            try {
                model.setValueAt(txtAdminID.getText(), i, 0);
                model.setValueAt(txtAdminFullname.getText(), i, 1);
                model.setValueAt(txtAdminContact.getText(), i, 2);
                model.setValueAt(txtUsername.getText(), i, 3);

                String id = txtAdminID.getText();
                String fullname = txtAdminFullname.getText();
                int contact = Integer.parseInt(txtAdminContact.getText());
                String username = txtUsername.getText();

                AdministratorModel admin = new AdministratorModel(id, fullname, contact, username);
                boolean isUpdated = AdministratorController.updateAdmin(admin);
                if (isUpdated) {
                    JOptionPane.showMessageDialog(this, "updated Success");
                } else {
                    JOptionPane.showMessageDialog(this, "update Failed");
                }
            } catch (ClassNotFoundException ex) {
                JOptionPane.showMessageDialog(null, "error");
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "error");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Error");
        }
        loadAdministratorTable();
    }//GEN-LAST:event_UpadateAdminBtnActionPerformed

    private void BtnAddEmployeeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnAddEmployeeActionPerformed
        String id = empid.getText();
        String fullname = Fullname.getText();
        String Role = role.getText();
        Double BasicSalary = Double.parseDouble(salarybasic.getText());
        int Contact = Integer.parseInt(contact.getText());
        if (empid.getText().equals("") || Fullname.getText().equals("") || contact.getText().equals("")
                || role.getText().equals("") || salarybasic.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "missing feilds");
        } else {
            EmployeeModel employee = new EmployeeModel(id, fullname, Contact, Role, BasicSalary);
            boolean isAdded;
            try {
                isAdded = EmployeeController.addEmployee(employee);
                if (isAdded) {
                    JOptionPane.showMessageDialog(this, "Added Success");
                } else {
                    JOptionPane.showMessageDialog(this, "Added Fail");
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "error");
            } catch (ClassNotFoundException ex) {
                JOptionPane.showMessageDialog(null, "error");
            }
        }
        loadEmployeeTable();
    }//GEN-LAST:event_BtnAddEmployeeActionPerformed

    private void searchEmployeeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchEmployeeKeyReleased
        String query = searchEmployee.getText().toLowerCase();
        filterEmployee(query);
    }//GEN-LAST:event_searchEmployeeKeyReleased

    private void tableEmployeeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableEmployeeMouseClicked
        int SelectedRow = tableEmployee.getSelectedRow();
        DefaultTableModel model = (DefaultTableModel) tableEmployee.getModel();
        empid.setText(model.getValueAt(SelectedRow, 0).toString());
        Fullname.setText(model.getValueAt(SelectedRow, 1).toString());
        contact.setText(model.getValueAt(SelectedRow, 2).toString());
        role.setText(model.getValueAt(SelectedRow, 3).toString());
        salarybasic.setText(model.getValueAt(SelectedRow, 4).toString());
    }//GEN-LAST:event_tableEmployeeMouseClicked

    private void kButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kButton1ActionPerformed
        int i = tableEmployee.getSelectedRow();
        DefaultTableModel model = (DefaultTableModel) tableEmployee.getModel();
        if (i >= 0) {
            try {
                model.setValueAt(empid.getText(), i, 0);
                model.setValueAt(Fullname.getText(), i, 1);
                model.setValueAt(contact.getText(), i, 2);
                model.setValueAt(role.getText(), i, 3);
                model.setValueAt(salarybasic.getText(), i, 4);

                String id = empid.getText();
                String fullname = Fullname.getText();
                int Contact = Integer.parseInt(contact.getText());
                String Role = role.getText();
                double Basicsal = Double.parseDouble(salarybasic.getText());

                EmployeeModel employee = new EmployeeModel(id, fullname, Contact, Role, Basicsal);
                boolean isUpdated = EmployeeController.updateEmployee(employee);
                if (isUpdated) {
                    JOptionPane.showMessageDialog(this, "updated Success");
                    loadEmployeeTable();
                } else {
                    JOptionPane.showMessageDialog(this, "update Failed");
                }
            } catch (ClassNotFoundException ex) {
                JOptionPane.showMessageDialog(null, "error");
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "error");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Error");
        }
    }//GEN-LAST:event_kButton1ActionPerformed

    private void tableDeductionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableDeductionMouseClicked
        int SelectedRow = tableDeduction.getSelectedRow();
        DefaultTableModel model = (DefaultTableModel) tableDeduction.getModel();
        DedEmpID.setText(model.getValueAt(SelectedRow, 0).toString());
        DedAmount.setText(model.getValueAt(SelectedRow, 1).toString());
        DedReason.setText(model.getValueAt(SelectedRow, 2).toString());
    }//GEN-LAST:event_tableDeductionMouseClicked

    private void BtnAddDeductionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnAddDeductionActionPerformed
        String id = DedEmpID.getText();
        String Reason = DedReason.getText();
        Double amount = Double.parseDouble(DedAmount.getText());
        String date = DateLabel.getText();
        if (DedEmpID.getText().equals("") || DedReason.getText().equals("")
                || DedAmount.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "missing feilds");
        } else {
            DeductionModel deduction = new DeductionModel(id, Reason, amount, date);
            boolean isAdded;
            try {
                isAdded = DeductionController.addDeduction(deduction);
                if (isAdded) {
                    JOptionPane.showMessageDialog(this, "Added Success");
                    loadDeductionTable();
                } else {
                    JOptionPane.showMessageDialog(this, "Added Fail");
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "error");
            } catch (ClassNotFoundException ex) {
                JOptionPane.showMessageDialog(null, "error");
            }
        }
    }//GEN-LAST:event_BtnAddDeductionActionPerformed

    private void SearchDeductionKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SearchDeductionKeyReleased
        String query = SearchDeduction.getText().toLowerCase();
        filterDeduction(query);
    }//GEN-LAST:event_SearchDeductionKeyReleased

    private void BtnUpdateDeductionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnUpdateDeductionActionPerformed
        int i = tableDeduction.getSelectedRow();
        DefaultTableModel model = (DefaultTableModel) tableDeduction.getModel();
        if (i >= 0) {
            model.setValueAt(DedEmpID.getText(), i, 0);
            model.setValueAt(DedAmount.getText(), i, 1);
            model.setValueAt(DedReason.getText(), i, 2);
            model.setValueAt(DateLabel.getText(), i, 3);
            String id = DedEmpID.getText();
            String Reason = DedReason.getText();
            Double amount = Double.parseDouble(DedAmount.getText());
            DeductionModel deduction = new DeductionModel(id, Reason, amount);
            boolean isUpdated;
            try {
                isUpdated = DeductionController.updateDeduction(deduction);
                if (isUpdated) {
                    JOptionPane.showMessageDialog(this, "updated Success");
                    loadDeductionTable();
                } else {
                    JOptionPane.showMessageDialog(this, "update Failed");
                }
            } catch (ClassNotFoundException ex) {
                JOptionPane.showMessageDialog(null, "error");
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "error");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Error");
        }
    }//GEN-LAST:event_BtnUpdateDeductionActionPerformed

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        System.exit(0);
    }//GEN-LAST:event_jLabel5MouseClicked

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        this.setState(JFrame.ICONIFIED);
    }//GEN-LAST:event_jLabel4MouseClicked

    private void tableEmployeeMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableEmployeeMouseReleased
        if (evt.isPopupTrigger()) {
            jPopupMenuEmployee.show(this, evt.getX(), evt.getY());
        }
    }//GEN-LAST:event_tableEmployeeMouseReleased

    private void tableDeductionMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableDeductionMouseReleased
        if (evt.isPopupTrigger()) {
            jPopupMenuDeductions.show(this, evt.getX(), evt.getY());
        }
    }//GEN-LAST:event_tableDeductionMouseReleased

    private void tableLoanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableLoanMouseClicked
        int SelectedRow = tableLoan.getSelectedRow();
        DefaultTableModel model = (DefaultTableModel) tableLoan.getModel();
        LoanEmpID.setText(model.getValueAt(SelectedRow, 0).toString());
        LoanAmount.setText(model.getValueAt(SelectedRow, 1).toString());
        LoanReason.setText(model.getValueAt(SelectedRow, 2).toString());
        LoanIssuedDate.setText(model.getValueAt(SelectedRow, 3).toString());
        LoanDueDate.setText(model.getValueAt(SelectedRow, 4).toString());
    }//GEN-LAST:event_tableLoanMouseClicked

    private void tableLoanMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableLoanMouseReleased
        if (evt.isPopupTrigger()) {
            jPopupMenuloan.show(this, evt.getX(), evt.getY());
        }
    }//GEN-LAST:event_tableLoanMouseReleased

    private void SearchLoanKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SearchLoanKeyReleased
        String query = SearchLoan.getText().toLowerCase();
        filterLoan(query);
    }//GEN-LAST:event_SearchLoanKeyReleased

    private void BtnAddLoanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnAddLoanActionPerformed
        String id = LoanEmpID.getText();
        String issue = LoanIssuedDate.getText();
        String due = LoanDueDate.getText();
        String Reason = LoanReason.getText();
        Double amount = Double.parseDouble(LoanAmount.getText());
        String settled = "no";
        if (LoanEmpID.getText().equals("") || LoanIssuedDate.getText().equals("") || LoanDueDate.getText().equals("")
                || LoanReason.getText().equals("") || LoanAmount.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "missing feilds");
        } else {
            LoanModel loan = new LoanModel(id, amount, Reason, issue, due, settled);
            boolean isAdded;
            try {
                isAdded = LoanController.addLoan(loan);
                if (isAdded) {
                    JOptionPane.showMessageDialog(this, "Added Success");
                } else {
                    JOptionPane.showMessageDialog(this, "Added Fail");
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex);
            } catch (ClassNotFoundException ex) {
                JOptionPane.showMessageDialog(null, ex);
            }
        }
        loadLoanTable();
    }//GEN-LAST:event_BtnAddLoanActionPerformed

    private void BtnUpdateLoanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnUpdateLoanActionPerformed
        int i = tableLoan.getSelectedRow();
        DefaultTableModel model = (DefaultTableModel) tableLoan.getModel();
        if (i >= 0) {
            model.setValueAt(LoanEmpID.getText(), i, 0);
            model.setValueAt(LoanAmount.getText(), i, 1);
            model.setValueAt(LoanReason.getText(), i, 2);
            model.setValueAt(LoanIssuedDate.getText(), i, 3);
            model.setValueAt(LoanDueDate.getText(), i, 4);
            String id = LoanEmpID.getText();
            String Reason = LoanReason.getText();
            Double amount = Double.parseDouble(LoanAmount.getText());
            String isuue = LoanIssuedDate.getText();
            String due = LoanDueDate.getText();

            LoanModel loan = new LoanModel(id, amount, Reason, isuue, due);
            boolean isUpdated;
            try {
                isUpdated = LoanController.updateLoan(loan);
                if (isUpdated) {
                    JOptionPane.showMessageDialog(this, "updated Success");
                    loadDeductionTable();
                } else {
                    JOptionPane.showMessageDialog(this, "update Failed");
                }
            } catch (ClassNotFoundException ex) {
                JOptionPane.showMessageDialog(null, "error");
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "error");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Error");
        }
    }//GEN-LAST:event_BtnUpdateLoanActionPerformed

    private void BtnAddBonusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnAddBonusActionPerformed
        String Reason = BonusReason.getText();
        Double amount = Double.parseDouble(BonusAmount.getText());
        String Month = BonusMonth.getText();
        String Year = BonusYear.getText();
        if (BonusReason.getText().equals("") || BonusAmount.getText().equals("") || BonusMonth.getText().equals("") || BonusYear.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "missing feilds");
        } else {
            try {
                BonusModel bonus = new BonusModel(Reason, amount, Month, Year);
                boolean isAdded = BonusController.addBonus(bonus);
                if (isAdded) {
                    JOptionPane.showMessageDialog(this, "Added Succesfully");
                    loadBonusTable();
                } else {
                    JOptionPane.showMessageDialog(this, "failed");
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "error");
            }
        }
    }//GEN-LAST:event_BtnAddBonusActionPerformed

    private void tableBonusMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableBonusMouseClicked
        int SelectedRow = tableBonus.getSelectedRow();
        DefaultTableModel model = (DefaultTableModel) tableBonus.getModel();
        BonusReason.setText(model.getValueAt(SelectedRow, 1).toString());
        BonusAmount.setText(model.getValueAt(SelectedRow, 2).toString());
        BonusMonth.setText(model.getValueAt(SelectedRow, 3).toString());
        BonusYear.setText(model.getValueAt(SelectedRow, 4).toString());
    }//GEN-LAST:event_tableBonusMouseClicked

    private void BtnUpdateBonusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnUpdateBonusActionPerformed
        int i = tableBonus.getSelectedRow();
        DefaultTableModel model = (DefaultTableModel) tableBonus.getModel();
        if (i >= 0) {

            int id;
            id = Integer.parseInt((String) tableBonus.getValueAt(i, 0));
            // int id= (int) tableBonus.getValueAt(i,0);
            String Reason = BonusReason.getText();
            double amount = Double.parseDouble(BonusAmount.getText());
            String Month = BonusMonth.getText();
            String Year = BonusYear.getText();

            BonusModel bonus = new BonusModel(id, Reason, amount, Month, Year);
            boolean isUpdated;
            try {
                isUpdated = BonusController.updateBonus(bonus);
                if (isUpdated) {
                    JOptionPane.showMessageDialog(this, "updated Success");
                } else {
                    JOptionPane.showMessageDialog(this, "update Failed");
                }
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Form.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(Form.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Error");
        }
        loadBonusTable();
    }//GEN-LAST:event_BtnUpdateBonusActionPerformed

    private void searchBonusKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchBonusKeyReleased
        String query = searchBonus.getText().toLowerCase();
        filterBonus(query);
    }//GEN-LAST:event_searchBonusKeyReleased

    private void tableBonusMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableBonusMouseReleased
        if (evt.isPopupTrigger()) {
            jPopupMenuBonus.show(this, evt.getX(), evt.getY());
        }
    }//GEN-LAST:event_tableBonusMouseReleased

    private void kButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kButton3ActionPerformed

        String empID = PayrollEmpId.getText();
        String month = PayrollMonth.getText();
        String year = PayrollYear.getText();

        TotPresentDays.setText("");
        TotAbsentDays.setText("");
        TotLoans.setText("");
        Bonus.setText("");
        LoanAmountTot.setText("");
        NoOFDeductions.setText("");
        TotDeductios.setText("");
        SalaryEarned.setText("");
        Bonus.setText("");
        FinalAmount.setText("");

        if (PayrollEmpId.getText().equals("") || PayrollMonth.getText().equals("") || PayrollYear.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "missing feilds");
        } else {
            generatePayrollModel payroll = new generatePayrollModel(empID, month, year);
            int result = 0;
            try {
                result = generatePayrollController.getPresent(payroll);
                if (result > 0) {
                    String presentdays = Integer.toString(result);
                    TotPresentDays.setText(presentdays);
                }
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Form.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(Form.class.getName()).log(Level.SEVERE, null, ex);
            }

            int daysOfMonth= GetDaysInMonth();
           int absentdays=daysOfMonth-result;
           String Absentdays = Integer.toString(absentdays);
           TotAbsentDays.setText(Absentdays);
            getTotLoans(empID, month, year);
            int loan = getLoansDueTot(empID, month, year);
            getNoOfDeductions(empID, month, year);
            int ded = getTotDeductions(empID, month, year);
            int bonus = getBonus(empID, month, year);
            int salEarn = getSalaryEarned(empID, month, year);
            int finalSal = getFinalSalary(salEarn, bonus, loan, ded);

        }
    }//GEN-LAST:event_kButton3ActionPerformed

    private int getFinalSalary(int salEarn, int bonus, int loan, int ded) {
        int finalSal = (salEarn + bonus) - loan - ded;
        String FA = Integer.toString(finalSal);
        FinalAmount.setText(FA);
        return finalSal;
    }

    private int getSalaryEarned(String empID, String month, String year) {
        generatePayrollModel payroll = new generatePayrollModel(empID, month, year);
        int result = 0;
        try {
            result = generatePayrollController.getSalary(payroll);
            if (result > 0) {
                String salary = Integer.toString(result);
                System.out.println(salary);
                SalaryEarned.setText(salary);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Form.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Form.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    private int getBonus(String empID, String month, String year) {

        generatePayrollModel payroll = new generatePayrollModel(empID, month, year);
        int result = 0;
        try {
            result = generatePayrollController.getTotBonus(payroll);
            if (result > 0) {
                String bonus = Integer.toString(result);
                System.out.println(bonus);
                Bonus.setText(bonus);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Form.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Form.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    private void getTotLoans(String empID, String month, String year) {
        generatePayrollModel payroll = new generatePayrollModel(empID, month, year);
        int result = 0;
        try {
            result = generatePayrollController.getTotLoans(payroll);
            if (result > 0) {
                String totLoans = Integer.toString(result);
                System.out.println(totLoans);
                TotLoans.setText(totLoans);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Form.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Form.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private int getLoansDueTot(String empID, String month, String year) {
        generatePayrollModel payroll = new generatePayrollModel(empID, month, year);
        int result = 0;
        try {
            result = generatePayrollController.getTotLoansDue(payroll);
            if (result > 0) {
                String totLoansDue = Integer.toString(result);
                System.out.println(totLoansDue);
                LoanAmountTot.setText(totLoansDue);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Form.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Form.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    private int getTotDeductions(String empID, String month, String year) {
        generatePayrollModel payroll = new generatePayrollModel(empID, month, year);
        int result = 0;
        try {
            result = generatePayrollController.getTotDeductions(payroll);
            if (result > 0) {
                String totDedudctions = Integer.toString(result);
                System.out.println(totDedudctions);
                TotDeductios.setText(totDedudctions);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Form.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Form.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    private void getNoOfDeductions(String empID, String month, String year) {
        generatePayrollModel payroll = new generatePayrollModel(empID, month, year);
        int result = 0;
        try {
            result = generatePayrollController.getNoOfDeductions(payroll);
            if (result > 0) {
                String NoOfDeductions = Integer.toString(result);
                System.out.println(NoOfDeductions);
                NoOFDeductions.setText(NoOfDeductions);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Form.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Form.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    private void AmountEarnedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AmountEarnedActionPerformed
        amountEarn.setVisible(true);
        payments.setVisible(false);
        generatePayroll.setVisible(false);
        bonus.setVisible(false);
        lOAN.setVisible(false);
        deductions.setVisible(false);
        Employee.setVisible(false);
        Administrator.setVisible(false);
        AttendanceProgress.setVisible(false);
        jTabbedPane1.setVisible(false);
    }//GEN-LAST:event_AmountEarnedActionPerformed

    private void LoanSettledActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LoanSettledActionPerformed
        String id = LoanEmpID.getText();
        String issue = LoanIssuedDate.getText();
        String due = LoanDueDate.getText();
        String Reason = LoanReason.getText();
        Double amount = Double.parseDouble(LoanAmount.getText());
        String settled = "yes";

        LoanModel loan = new LoanModel(id, amount, Reason, issue, due, settled);
        boolean isAdded;
        try {
            isAdded = LoanController.settleLoan(loan);
            loadLoanTable();
            if (isAdded) {
                JOptionPane.showMessageDialog(this, "Marked Settled");
            } else {
                JOptionPane.showMessageDialog(this, " Fail");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }

    }//GEN-LAST:event_LoanSettledActionPerformed

    private void BtnIssuePayrollActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnIssuePayrollActionPerformed
        // TODO add your handling code here:
        String EmployeeID = PayrollEmpId.getText();
        String fullname = "";
        String Role = "";
        String HourlyRate = "";
        EmployeeModel employee = new EmployeeModel(EmployeeID);
        try {
            fullname = EmployeeController.getFullname(employee);
            Role = EmployeeController.getRole(employee);
            HourlyRate = EmployeeController.getRole(employee);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Form.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Form.class.getName()).log(Level.SEVERE, null, ex);
        }
        String month = PayrollMonth.getText();
        String year = PayrollYear.getText();

        String presentDays = TotPresentDays.getText();
        String AbsentDays = TotAbsentDays.getText();

        String loan = LoanAmountTot.getText();
        String deductions = TotDeductios.getText();
        String bonus = Bonus.getText();

        String salEarned = SalaryEarned.getText();
        String finalAmount = FinalAmount.getText();

        JFileChooser dialog = new JFileChooser();

        dialog.setSelectedFile(new File(EmployeeID + " " + "-payroll slip" + ".pdf"));
        int dialogResult = dialog.showSaveDialog(null);
        if (dialogResult == JFileChooser.APPROVE_OPTION) {
            String filepath = dialog.getSelectedFile().getPath();

          

            try {
                Connection connection = DBConnection.getInstance().getConnection();
                String sql = "select * from payments where EmployeeID='" + EmployeeID + "' and month(PaymentDate)='" + month + "' and year(Paymentdate)='" + year + "'  ";
                PreparedStatement stm = connection.prepareStatement(sql);
                ResultSet rs = stm.executeQuery();

                rs.close();
                stm.close();

                Document myDocument = new Document();
                PdfWriter myWriter = PdfWriter.getInstance(myDocument, new FileOutputStream(filepath));
                myDocument.open();

                myDocument.add(new Paragraph("Payroll Slip", FontFactory.getFont(FontFactory.TIMES_BOLD, 20, Font.BOLD)));
                myDocument.add(new Paragraph(new Date().toString()));
                myDocument.add(new Paragraph("----------------------------------------------"));
                myDocument.add(new Paragraph("Employee Details", FontFactory.getFont(FontFactory.TIMES_ROMAN, 15, Font.BOLD)));
                myDocument.add(new Paragraph("Employee ID : " + EmployeeID, FontFactory.getFont(FontFactory.TIMES_ROMAN, 10, Font.NORMAL)));
                myDocument.add(new Paragraph("Employee Name : " + fullname, FontFactory.getFont(FontFactory.TIMES_ROMAN, 10, Font.NORMAL)));
                myDocument.add(new Paragraph("Employee Role : " + Role, FontFactory.getFont(FontFactory.TIMES_ROMAN, 10, Font.NORMAL)));

                myDocument.add(new Paragraph("----------------------------------------------"));
                myDocument.add(new Paragraph("Attendance Details", FontFactory.getFont(FontFactory.TIMES_ROMAN, 15, Font.BOLD)));
                myDocument.add(new Paragraph("Present Days : " + presentDays, FontFactory.getFont(FontFactory.TIMES_ROMAN, 10, Font.NORMAL)));
                myDocument.add(new Paragraph("Absent Days : " + AbsentDays, FontFactory.getFont(FontFactory.TIMES_ROMAN, 10, Font.NORMAL)));

                myDocument.add(new Paragraph("----------------------------------------------"));
                myDocument.add(new Paragraph("Salary Details", FontFactory.getFont(FontFactory.TIMES_ROMAN, 15, Font.BOLD)));
                myDocument.add(new Paragraph("Hourly Rate : " + HourlyRate, FontFactory.getFont(FontFactory.TIMES_ROMAN, 10, Font.NORMAL)));
                //myDocument.add(new Paragraph("Hours Worked : " + WorkTime, FontFactory.getFont(FontFactory.TIMES_ROMAN, 10, Font.NORMAL)));
                myDocument.add(new Paragraph("Amount Earned : " + salEarned, FontFactory.getFont(FontFactory.TIMES_ROMAN, 10, Font.NORMAL)));

                myDocument.add(new Paragraph("Loans Taken : " + loan, FontFactory.getFont(FontFactory.TIMES_ROMAN, 10, Font.NORMAL)));
                myDocument.add(new Paragraph("Bonus Given : " + bonus, FontFactory.getFont(FontFactory.TIMES_ROMAN, 10, Font.NORMAL)));
                myDocument.add(new Paragraph("Deductions Made : " + deductions, FontFactory.getFont(FontFactory.TIMES_ROMAN, 10, Font.NORMAL)));

                myDocument.add(new Paragraph("Net Pay : " + finalAmount, FontFactory.getFont(FontFactory.TIMES_ROMAN, 10, Font.NORMAL)));
                myDocument.newPage();
                myDocument.close();
                JOptionPane.showMessageDialog(null, "Report Generated");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }


    }//GEN-LAST:event_BtnIssuePayrollActionPerformed

    private void BtnPayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnPayActionPerformed
        // TODO add your handling code here:
        String empID = PayrollEmpId.getText();
        String month = PayrollMonth.getText();
        String year = PayrollYear.getText();

        int loan = getLoansDueTot(empID, month, year);
        int ded = getTotDeductions(empID, month, year);
        int bonus = getBonus(empID, month, year);
        int salEarn = getSalaryEarned(empID, month, year);

        PaymentModel payment = new PaymentModel(empID, month, year, salEarn, bonus, loan, ded);
        boolean isAdded;
        try {
            isAdded = PaymentController.addPayment(payment);
            loadLoanTable();
            if (isAdded) {
                JOptionPane.showMessageDialog(this, "Marked Payment");
                loadPaymentTable();
            } else {
                JOptionPane.showMessageDialog(this, " Fail");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }


    }//GEN-LAST:event_BtnPayActionPerformed

    private void searchPaymentsKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchPaymentsKeyReleased
        String query = searchPayments.getText().toLowerCase();
        filterPayments(query);
    }//GEN-LAST:event_searchPaymentsKeyReleased

    private void tablePaymentsMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablePaymentsMouseReleased
        if (evt.isPopupTrigger()) {
            jPopupMenuPayment.show(this, evt.getX(), evt.getY());
        }
    }//GEN-LAST:event_tablePaymentsMouseReleased

    private void searchAmountEarnedKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchAmountEarnedKeyReleased
        String query = searchAmountEarned.getText().toLowerCase();
        filterAmountEarned(query);
    }//GEN-LAST:event_searchAmountEarnedKeyReleased

    private void amountEarnedTableMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_amountEarnedTableMouseReleased

    }//GEN-LAST:event_amountEarnedTableMouseReleased

    private void txtAdminIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAdminIDActionPerformed
       txtAdminFullname.requestFocus();
    }//GEN-LAST:event_txtAdminIDActionPerformed

    private void txtAdminFullnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAdminFullnameActionPerformed
        txtAdminContact.requestFocus();
    }//GEN-LAST:event_txtAdminFullnameActionPerformed

    private void txtAdminContactActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAdminContactActionPerformed
        txtUsername.requestFocus();
    }//GEN-LAST:event_txtAdminContactActionPerformed

    private void DedEmpIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DedEmpIDActionPerformed
        DedAmount.requestFocus();
    }//GEN-LAST:event_DedEmpIDActionPerformed

    private void DedAmountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DedAmountActionPerformed
        DedReason.requestFocus();
    }//GEN-LAST:event_DedAmountActionPerformed

    private void LoanEmpIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LoanEmpIDActionPerformed
        LoanAmount.requestFocus();
    }//GEN-LAST:event_LoanEmpIDActionPerformed

    private void LoanAmountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LoanAmountActionPerformed
        LoanReason.requestFocus();
    }//GEN-LAST:event_LoanAmountActionPerformed

    private void LoanReasonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LoanReasonActionPerformed
       LoanIssuedDate.requestFocus();
    }//GEN-LAST:event_LoanReasonActionPerformed

    private void LoanIssuedDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LoanIssuedDateActionPerformed
        LoanDueDate.requestFocus();
    }//GEN-LAST:event_LoanIssuedDateActionPerformed

    private void BonusReasonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BonusReasonActionPerformed
        BonusAmount.requestFocus();
    }//GEN-LAST:event_BonusReasonActionPerformed

    private void BonusAmountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BonusAmountActionPerformed
        BonusYear.requestFocus();
    }//GEN-LAST:event_BonusAmountActionPerformed

    private void BonusYearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BonusYearActionPerformed
        BonusMonth.requestFocus();
    }//GEN-LAST:event_BonusYearActionPerformed

    private void contactKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_contactKeyReleased
        if(!contact.getText().matches("[0-9]+")){
            JOptionPane.showMessageDialog(rootPane, "Invalid Contact");
        }
    }//GEN-LAST:event_contactKeyReleased

    private void FullnameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_FullnameKeyReleased
          if(!Fullname.getText().matches("[a-z]+")){
            JOptionPane.showMessageDialog(rootPane, "Invalid Name");
        }
    }//GEN-LAST:event_FullnameKeyReleased

    private void salarybasicKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_salarybasicKeyReleased
          if(!salarybasic.getText().matches("[0-9]+")){
            JOptionPane.showMessageDialog(rootPane, "Invalid Salary");
        }
    }//GEN-LAST:event_salarybasicKeyReleased

    private void txtAdminFullnameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAdminFullnameKeyReleased
          if(!txtAdminFullname.getText().matches("[a-z]+")){
            JOptionPane.showMessageDialog(rootPane, "Invalid Name");
        }
    }//GEN-LAST:event_txtAdminFullnameKeyReleased

    private void txtAdminContactKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAdminContactKeyReleased
          if(!txtAdminContact.getText().matches("[0-9]+")){
            JOptionPane.showMessageDialog(rootPane, "Invalid Contact");
        }
    }//GEN-LAST:event_txtAdminContactKeyReleased

    private void DedAmountKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_DedAmountKeyReleased
         if(!DedAmount.getText().matches("[0-9]+")){
            JOptionPane.showMessageDialog(rootPane, "Invalid Salary");
        }
    }//GEN-LAST:event_DedAmountKeyReleased

    private void PayrollMonthKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_PayrollMonthKeyReleased
          if(!PayrollMonth.getText().matches("[0-9]+")){
            JOptionPane.showMessageDialog(rootPane, "Please enter Month Number");
        }
    }//GEN-LAST:event_PayrollMonthKeyReleased

    private void LoanAmountKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_LoanAmountKeyReleased
          if(!LoanAmount.getText().matches("[0-9]+")){
            JOptionPane.showMessageDialog(rootPane, "invalid Amount");
        }
    }//GEN-LAST:event_LoanAmountKeyReleased

    private void BonusAmountKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BonusAmountKeyReleased
          if(!BonusAmount.getText().matches("[0-9]+")){
            JOptionPane.showMessageDialog(rootPane, "Invalid Amount");
        }
    }//GEN-LAST:event_BonusAmountKeyReleased

    public static void main(String args[]) {
    
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Form().setVisible(true);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(Form.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(Form.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private keeptoo.KButton AbsentBtn;
    private javax.swing.JLabel AbsentLabel;
    private keeptoo.KButton AddAdminBtn;
    private keeptoo.KButton AdminBtn;
    private javax.swing.JLabel AdminCount;
    private javax.swing.JLabel AdminLabel;
    private keeptoo.KButton AdminisBtn;
    private javax.swing.JPanel Administrator;
    private keeptoo.KButton AmountEarned;
    private javax.swing.JPanel Attendance;
    private keeptoo.KButton AttendanceBtn;
    private javax.swing.JPanel AttendanceProgress;
    private javax.swing.JTable AttendanceTable;
    private javax.swing.JTextField Bonus;
    private javax.swing.JTextField BonusAmount;
    private keeptoo.KButton BonusBtn;
    private javax.swing.JTextField BonusMonth;
    private javax.swing.JTextField BonusReason;
    private javax.swing.JTextField BonusYear;
    private keeptoo.KButton BtnAddBonus;
    private keeptoo.KButton BtnAddDeduction;
    private keeptoo.KButton BtnAddEmployee;
    private keeptoo.KButton BtnAddLoan;
    private keeptoo.KButton BtnIssuePayroll;
    private keeptoo.KButton BtnPay;
    private keeptoo.KButton BtnReset;
    private keeptoo.KButton BtnSubmit;
    private keeptoo.KButton BtnUpdateBonus;
    private keeptoo.KButton BtnUpdateDeduction;
    private keeptoo.KButton BtnUpdateLoan;
    private javax.swing.JPanel Buttons;
    private javax.swing.JPanel CP;
    private javax.swing.JPanel CPP;
    private keeptoo.KButton DAYsBtn1;
    private javax.swing.JPanel DashBoard;
    private keeptoo.KButton DashboardBtn1;
    private javax.swing.JLabel DateLabel;
    private javax.swing.JLabel DaysLabel;
    private javax.swing.JTextField DedAmount;
    private javax.swing.JTextField DedEmpID;
    private javax.swing.JTextField DedReason;
    private keeptoo.KButton DeductionsBtn;
    private javax.swing.JLabel EmpLabel;
    private keeptoo.KButton Empbtn;
    private javax.swing.JPanel Employee;
    private keeptoo.KButton EmployeeBtn;
    private javax.swing.JTextField FinalAmount;
    private javax.swing.JTextField Fullname;
    private keeptoo.KButton GenPayrollBtn;
    private javax.swing.JLabel LateLabel;
    private keeptoo.KButton LatebTN;
    private javax.swing.JTextField LoanAmount;
    private javax.swing.JTextField LoanAmountTot;
    private javax.swing.JTextField LoanDueDate;
    private javax.swing.JTextField LoanEmpID;
    private javax.swing.JTextField LoanIssuedDate;
    private javax.swing.JTextField LoanReason;
    private keeptoo.KButton LoanSettled;
    private keeptoo.KButton LoansBtn;
    private javax.swing.JLabel LogoutLabel;
    private javax.swing.JTextField NoOFDeductions;
    private keeptoo.KButton PaymentsBtn;
    private javax.swing.JTextField PayrollEmpId;
    private javax.swing.JTextField PayrollMonth;
    private javax.swing.JTextField PayrollYear;
    private keeptoo.KButton PresentBtn;
    private javax.swing.JLabel PresentLabel;
    private javax.swing.JTextField SalaryEarned;
    private javax.swing.JTextField SearchDeduction;
    private javax.swing.JTextField SearchLoan;
    private javax.swing.JTable TableAdministrator;
    private javax.swing.JLabel TimeLabel;
    private javax.swing.JTextField TotAbsentDays;
    private javax.swing.JTextField TotDeductios;
    private javax.swing.JTextField TotLoans;
    private javax.swing.JTextField TotPresentDays;
    private keeptoo.KButton UpadateAdminBtn;
    private javax.swing.JPanel amountEarn;
    private javax.swing.JTable amountEarnedTable;
    private javax.swing.JPanel bonus;
    private javax.swing.JTextField contact;
    private javax.swing.JPanel deductions;
    private javax.swing.JLabel empCount;
    private javax.swing.JTextField empid;
    private javax.swing.JPanel generatePayroll;
    private javax.swing.JLabel helpLabel;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JPopupMenu jPopupMenu2Admin;
    private javax.swing.JPopupMenu jPopupMenuAmountEarned;
    private javax.swing.JPopupMenu jPopupMenuBonus;
    private javax.swing.JPopupMenu jPopupMenuDeductions;
    private javax.swing.JPopupMenu jPopupMenuEmployee;
    private javax.swing.JPopupMenu jPopupMenuPayment;
    private javax.swing.JPopupMenu jPopupMenuloan;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private keeptoo.KButton kButton1;
    private keeptoo.KButton kButton3;
    private javax.swing.JPanel lOAN;
    private javax.swing.JPanel payments;
    private javax.swing.JTextField role;
    private javax.swing.JTextField salarybasic;
    private javax.swing.JTextField searchAdmin;
    private javax.swing.JTextField searchAmountEarned;
    private javax.swing.JTextField searchBonus;
    private javax.swing.JTextField searchEmployee;
    private javax.swing.JTextField searchPayments;
    private javax.swing.JTable tableBonus;
    private javax.swing.JTable tableDeduction;
    private javax.swing.JTable tableEmployee;
    private javax.swing.JTable tableLoan;
    private javax.swing.JTable tablePayments;
    private javax.swing.JLabel txtAbsent;
    private javax.swing.JTextField txtAdminContact;
    private javax.swing.JTextField txtAdminFullname;
    private javax.swing.JTextField txtAdminID;
    private javax.swing.JPasswordField txtConPass;
    private javax.swing.JLabel txtDaystopayday;
    private javax.swing.JTextField txtEmpID;
    private javax.swing.JLabel txtLatecomers;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JLabel txtPresent;
    private javax.swing.JTextField txtSearchAttendance;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables

    int present;

    private void loadPresent() throws ClassNotFoundException, SQLException {
        present = new DashBoardController().getPresent();
        txtPresent.setText(String.valueOf(present));
    }

    private void loadAbsent() throws ClassNotFoundException, SQLException {
        int absent = (new DashBoardController().getEmpCount()) - present;
        txtAbsent.setText(String.valueOf(absent));
    }

      private void loadEmployee() throws ClassNotFoundException, SQLException {
        int emp = new DashBoardController().getEmpCount();
        empCount.setText(String.valueOf(emp));
    }

         private void loadAdmin() throws ClassNotFoundException, SQLException {
        int admin = new DashBoardController().getAdminCount();
        AdminCount.setText(String.valueOf(admin));
    }
    
    private void loadLateComers() throws ClassNotFoundException, SQLException {
        int LateComers = new DashBoardController().getLateComers();
        txtLatecomers.setText(String.valueOf(LateComers));
    }

    private void loadPayDay() throws ClassNotFoundException, SQLException {
        int PayDay = new DashBoardController().getPayDay();
        txtDaystopayday.setText(String.valueOf(PayDay));
    }
    
    /*  private void getMostPresentEmp() throws ClassNotFoundException, SQLException {
        int MPE = new AttendanceController().getMPE();
        txtDaystopayday.setText(String.valueOf(MPE));
    }*/  
    DefaultTableModel dtm;

    public void filter(String query) { 
        DefaultTableModel dtm = (DefaultTableModel) AttendanceTable.getModel();
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(dtm);
        AttendanceTable.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(query));
    }

    public void filterAdmin(String query) {
        DefaultTableModel dtm = (DefaultTableModel) TableAdministrator.getModel();
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(dtm);
        TableAdministrator.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(query));
    }

    public void filterEmployee(String query) {
        DefaultTableModel dtm = (DefaultTableModel) tableEmployee.getModel();
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(dtm);
        tableEmployee.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(query));
    }

    public void filterDeduction(String query) {
        DefaultTableModel dtm = (DefaultTableModel) tableDeduction.getModel();
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(dtm);
        tableDeduction.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(query));
    }

    public void filterLoan(String query) {
        DefaultTableModel dtm = (DefaultTableModel) tableLoan.getModel();
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(dtm);
        tableLoan.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(query));
    }

    public void filterBonus(String query) {
        DefaultTableModel dtm = (DefaultTableModel) tableBonus.getModel();
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(dtm);
        tableBonus.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(query));

    }

    public void filterPayments(String query) {
        DefaultTableModel dtm = (DefaultTableModel) tablePayments.getModel();
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(dtm);
        tablePayments.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(query));

    }

    public void filterAmountEarned(String query) {
        DefaultTableModel dtm = (DefaultTableModel) amountEarnedTable.getModel();
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(dtm);
        amountEarnedTable.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(query));

    }

    private void loadAttendanceTable() {
        String SQL = "Select * From Attendance";
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            Statement stm = connection.createStatement();
            ResultSet rst = stm.executeQuery(SQL);
            dtm = (DefaultTableModel) AttendanceTable.getModel();
            dtm.setRowCount(0);
            while (rst.next()) {
                Object[] rowData = {rst.getString("CurrentDate"), rst.getString("EmployeeID"), rst.getString("TimeIn"), rst.getString("TimeOut")};
                dtm.addRow(rowData);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());

        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(this, "Driver is not found..");
        }
    }

    private void loadAdministratorTable() {
        String SQL = "Select * From Administrator";
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            Statement stm = connection.createStatement();
            ResultSet rst = stm.executeQuery(SQL);
            dtm = (DefaultTableModel) TableAdministrator.getModel();
            dtm.setRowCount(0);
            while (rst.next()) {
                Object[] rowData = {rst.getString("AdminID"), rst.getString("Fullname"), rst.getString("Contact"), rst.getString("Username")};
                dtm.addRow(rowData);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());

        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(this, "Driver is not found..");
        }
    }

    private void loadEmployeeTable() {
        String SQL = "Select * From Employee";
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            Statement stm = connection.createStatement();
            ResultSet rst = stm.executeQuery(SQL);
            dtm = (DefaultTableModel) tableEmployee.getModel();
            dtm.setRowCount(0);
            while (rst.next()) {
                Object[] rowData = {rst.getString("EmployeeID"), rst.getString("Fullname"), rst.getString("Contact"), rst.getString("Role"), rst.getString("BasicSalary")};
                dtm.addRow(rowData);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());

        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(this, "Driver is not found..");
        }
    }

    private void loadDeductionTable() {
        String SQL = "Select * From Deduction";
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            Statement stm = connection.createStatement();
            ResultSet rst = stm.executeQuery(SQL);
            dtm = (DefaultTableModel) tableDeduction.getModel();
            dtm.setRowCount(0);
            while (rst.next()) {
                Object[] rowData = {rst.getString("EmployeeID"), rst.getInt("Amount"), rst.getString("Reason"), rst.getString("DeductedDate")};
                dtm.addRow(rowData);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());

        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(this, "Driver is not found..");
        }
    }

    private void loadLoanTable() {
        String SQL = "Select * From loan";
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            Statement stm = connection.createStatement();
            ResultSet rst = stm.executeQuery(SQL);
            dtm = (DefaultTableModel) tableLoan.getModel();
            dtm.setRowCount(0);
            while (rst.next()) {
                Object[] rowData = {rst.getString("EmployeeID"), rst.getInt("Amount"), rst.getString("Reason"), rst.getString("IssuedDate"), rst.getString("DueDate"), rst.getString("settled")};
                dtm.addRow(rowData);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());

        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(this, "Driver is not found..");
        }
    }

    private void loadBonusTable() {
        String SQL = "Select * From bonus";
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            Statement stm = connection.createStatement();
            ResultSet rst = stm.executeQuery(SQL);
            dtm = (DefaultTableModel) tableBonus.getModel();
            dtm.setRowCount(0);
            while (rst.next()) {
                Object[] rowData = {rst.getString("BonusID"), rst.getString("Reason"), rst.getInt("Amount"), rst.getString("MonthGiven"), rst.getString("YearGiven")};
                dtm.addRow(rowData);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(this, "Driver is not found..");
        }
    }

    private void loadAmountEarnedTable() {
        String SQL = "Select * From AmountEarned";
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            Statement stm = connection.createStatement();
            ResultSet rst = stm.executeQuery(SQL);
            dtm = (DefaultTableModel) amountEarnedTable.getModel();
            dtm.setRowCount(0);
            while (rst.next()) {
                Object[] rowData = {rst.getString("WorkDate"), rst.getString("EmployeeID"), rst.getString("HoursWorked"), rst.getInt("BasicSalary"), rst.getInt("AmountEarned")};
                dtm.addRow(rowData);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(this, "Driver is not found..");
        }
    }

    private void loadPaymentTable() {
        String SQL = "Select * From payments";
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            Statement stm = connection.createStatement();
            ResultSet rst = stm.executeQuery(SQL);
            dtm = (DefaultTableModel) tablePayments.getModel();
            dtm.setRowCount(0);
            while (rst.next()) {
                Object[] rowData = {rst.getString("EmployeeID"), rst.getInt("HourlySalary"), rst.getInt("HoursWorked"), rst.getInt("SalaryEarned"), rst.getInt("LoansDue"), rst.getInt("Deductions"), rst.getInt("Bonus"), rst.getInt("FinalSalary"), rst.getString("Paymentdate")};
                dtm.addRow(rowData);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(this, "Driver is not found..");
        }
    }

    public void popupTable() {
        JPopupMenu popupMenu = new JPopupMenu();
        JMenuItem delete = new JMenuItem("DELETE");
        delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DefaultTableModel model = (DefaultTableModel) AttendanceTable.getModel();
                try {
                    int SelectedRowIndex = AttendanceTable.getSelectedRow();
                    String s = AttendanceTable.getModel().getValueAt(SelectedRowIndex, 2).toString();
                    Connection con = DBConnection.getInstance().getConnection();
                    String sql = "delete  from attendance where TimeIn= '" + s + "'";
                    PreparedStatement stm = con.prepareStatement(sql);
                    int rs = stm.executeUpdate();
                    if (rs > 0) {
                        JOptionPane.showMessageDialog(null, "deleted");
                    } else {
                        JOptionPane.showMessageDialog(null, "failed");
                    }
                    model.removeRow(SelectedRowIndex);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex);
                }
            }
        });
        popupMenu.add(delete);
        AttendanceTable.setComponentPopupMenu(popupMenu);
    }

    public void popupEmployee() {
        JPopupMenu popupMenu = new JPopupMenu();
        JMenuItem delete = new JMenuItem("DELETE");
        delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DefaultTableModel model = (DefaultTableModel) tableEmployee.getModel();
                int SelectedRowIndex = tableEmployee.getSelectedRow();
                String s = tableEmployee.getModel().getValueAt(SelectedRowIndex, 0).toString();
                boolean isDeleted;
                try {
                    isDeleted = new EmployeeController().deleteEmployee(new EmployeeModel(s));
                    if (isDeleted) {
                        JOptionPane.showMessageDialog(null, "Admin Deleted");
                        model.removeRow(SelectedRowIndex);
                    } else {
                        JOptionPane.showMessageDialog(null, "Try Again");
                    }
                } catch (ClassNotFoundException ex) {
                    JOptionPane.showMessageDialog(null, "error");
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "error");
                }
            }
        });
        popupMenu.add(delete);
        tableEmployee.setComponentPopupMenu(popupMenu);
    }

    public void popupDeductions() {
        JPopupMenu popupMenu = new JPopupMenu();
        JMenuItem delete = new JMenuItem("dELETE");
        delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DefaultTableModel model = (DefaultTableModel) tableDeduction.getModel();
                int SelectedRowIndex = tableDeduction.getSelectedRow();
                String s = tableDeduction.getModel().getValueAt(SelectedRowIndex, 0).toString();
                String z = tableDeduction.getModel().getValueAt(SelectedRowIndex, 2).toString();
                String a = tableDeduction.getModel().getValueAt(SelectedRowIndex, 3).toString();
                boolean isDeleted;
                try {
                    isDeleted = new DeductionController().deleteDeduction(new DeductionModel(s, a, z));
                    if (isDeleted) {
                        JOptionPane.showMessageDialog(null, "Deduction Deleted");
                        model.removeRow(SelectedRowIndex);
                    } else {
                        JOptionPane.showMessageDialog(null, "Try Again");
                    }
                } catch (ClassNotFoundException ex) {
                    JOptionPane.showMessageDialog(null, "error");
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "error");
                }
            }
        });
        popupMenu.add(delete);
        tableDeduction.setComponentPopupMenu(popupMenu);
    }

    public void popupLoan() {
        JPopupMenu popupMenu = new JPopupMenu();
        JMenuItem delete = new JMenuItem("DELETE");
        delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DefaultTableModel model = (DefaultTableModel) tableLoan.getModel();
                int SelectedRowIndex = tableLoan.getSelectedRow();
                String s = tableLoan.getModel().getValueAt(SelectedRowIndex, 0).toString();
                String u = tableLoan.getModel().getValueAt(SelectedRowIndex, 2).toString();
                String v = tableLoan.getModel().getValueAt(SelectedRowIndex, 3).toString();
                String w = tableLoan.getModel().getValueAt(SelectedRowIndex, 4).toString();
                boolean isDeleted;
                try {
                    isDeleted = new LoanController().deleteLoan(new LoanModel(s, u, v, w));
                    if (isDeleted) {
                        JOptionPane.showMessageDialog(null, "loan Deleted");
                        model.removeRow(SelectedRowIndex);
                    } else {
                        JOptionPane.showMessageDialog(null, "Try Again");
                    }
                } catch (ClassNotFoundException ex) {
                    JOptionPane.showMessageDialog(null, "error");
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "error");
                }
            }
        });
        popupMenu.add(delete);
        tableLoan.setComponentPopupMenu(popupMenu);
    }

    public void popupBonus() {
        JPopupMenu popupMenu = new JPopupMenu();
        JMenuItem delete = new JMenuItem("DELETE");
        delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DefaultTableModel model = (DefaultTableModel) tableBonus.getModel();
                int SelectedRowIndex = tableBonus.getSelectedRow();
                int id = Integer.parseInt((String) tableBonus.getValueAt(SelectedRowIndex, 0));

                boolean isDeleted;
                try {
                    isDeleted = new BonusController().deleteBonus(new BonusModel(id));
                    if (isDeleted) {
                        JOptionPane.showMessageDialog(null, "Bonus Deleted");
                        model.removeRow(SelectedRowIndex);
                    } else {
                        JOptionPane.showMessageDialog(null, "Try Again");
                    }
                } catch (ClassNotFoundException ex) {
                    JOptionPane.showMessageDialog(null, "error");
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "error");
                }
            }
        });
        popupMenu.add(delete);
        tableBonus.setComponentPopupMenu(popupMenu);
    }

    public void popupPayments() {
        JPopupMenu popupMenu = new JPopupMenu();
        JMenuItem delete = new JMenuItem("DELETE");
        delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DefaultTableModel model = (DefaultTableModel) tablePayments.getModel();
                int SelectedRowIndex = tablePayments.getSelectedRow();
                String id = ((String) tablePayments.getValueAt(SelectedRowIndex, 0));
                String date = (String) (tablePayments.getValueAt(SelectedRowIndex, 8));
                boolean isDeleted;
                try {
                    isDeleted = new PaymentController().deletePayment(new PaymentModel(id, date));
                    if (isDeleted) {
                        JOptionPane.showMessageDialog(null, "Payment Deleted");
                        model.removeRow(SelectedRowIndex);
                    } else {
                        JOptionPane.showMessageDialog(null, "Try Again");
                    }
                } catch (ClassNotFoundException ex) {
                    JOptionPane.showMessageDialog(null, ex);
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, ex);
                }
            }
        });
        popupMenu.add(delete);
        tablePayments.setComponentPopupMenu(popupMenu);
    }

}
