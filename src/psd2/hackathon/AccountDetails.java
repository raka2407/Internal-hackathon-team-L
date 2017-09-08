/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package psd2.hackathon;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.DefaultProxyRoutePlanner;
import org.json.JSONObject;
import static psd2.hackathon.AccountOverview.displayAccountOverview;

/**
 *
 * @author AB62031
 */
public class AccountDetails extends javax.swing.JFrame {

    static String selectedAccountNumber;
     static String nordeaCustomerNumber;
        static String url;
        static String nordea_url;
        
    /**
     * Creates new form AccountDetails
     */
    public AccountDetails() {
       
        String[] array = new String[AccountOverview.accountNumberList.size()];
    for(int i = 0; i < array.length; i++) {
        array[i] = AccountOverview.accountNumberList.get(i).toString();
    
    }
    System.out.println("Inside AccountDetails, List size is" +AccountOverview.accountNumberList.size());
    System.out.println("Inside AccountDetails, Account Numbers are " +AccountOverview.accountNumberList.get(0));
     jAccountsComboBox = new JComboBox<>(array);
         
     
        initComponents();
        this.getContentPane().setBackground(new Color (0, 102, 102));
    }
    
    
    public static void displayAccountDetails(String AccountNumber)
    {
        
        //Call Account Details API - START
                if(AccountNumber.equalsIgnoreCase("0")){
                    System.out.println("Inside displayaccountdetails method");
                    selectedAccountNumber =   jAccountsComboBox.getItemAt(0);
                }
                
                if(AccountNumber.equalsIgnoreCase("1")){
                    System.out.println("Inside displayaccountdetails method");
                    selectedAccountNumber =   "12083090112";
                    nordeaCustomerNumber = "07028974338";
                    nordea_url = "https://dnbapistore.com/hackathon/accounts/1.0/account/details?accountNumber=" +selectedAccountNumber + "&customerID=" +nordeaCustomerNumber;
                }
                
                                            
                
                if(AccountNumber.equalsIgnoreCase("1")){
                     HttpGet getRequestNordea = new HttpGet(nordea_url);
                     
                     
			getRequestNordea.addHeader("Accept", "application/json");
			getRequestNordea.addHeader("Authorization", "Bearer 81ac5011-d4fc-3fc9-95a1-c1520ad3e060");
			
			
			HttpHost proxy = new HttpHost("proxy.drf01.net", 88);
			DefaultProxyRoutePlanner routePlanner = new DefaultProxyRoutePlanner(proxy);
			CloseableHttpClient httpClient = HttpClients.custom().setRoutePlanner(routePlanner).build();
			
			
    // Create an instance of HttpClient.
	  
			
			
			try {
				JSONObject configObject = null;
				HttpResponse response = httpClient.execute(getRequestNordea);
				
				
				BufferedReader br = new BufferedReader(
		                         new InputStreamReader((response.getEntity().getContent())));

				String output;
                
                                System.out.println("Output from Server .... \n");
				while ((output = br.readLine()) != null) {
					configObject = new JSONObject(output);
                                        
                                        jAccountStatus.setText(configObject.get("accountStatus").toString());
                                        jAccountStatus.updateUI();
                                                                                
                                         jAccountType.setText(configObject.get("accountType").toString());
                                         jAccountType.updateUI();
                                         
                                         jAccountName.setText(configObject.get("accountName").toString());
                                         jAccountName.updateUI();
                                         
                                         jCustomerID.setText(configObject.get("customerID").toString());
                                         jCustomerID.updateUI();
                                         
                                         jIBAN.setText(configObject.get("iban").toString());
                                         jIBAN.updateUI();
                                         
                                         jAvailableBalance.setText(configObject.get("availableBalance").toString());
                                         jAvailableBalance.updateUI();
                                         
                                         jBookBalance.setText(configObject.get("bookBalance").toString());
                                         jBookBalance.updateUI();
                                         
                                         jCurrency.setText(configObject.get("currency").toString());
                                         jCurrency.updateUI();
                                         
                                         jCreatedOn.setText(configObject.get("created").toString());
                                         jCreatedOn.updateUI();
                                         
                                        
			}
				
				httpClient.getConnectionManager().shutdown();
				
				
			} catch (ClientProtocolException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
                 //Call Account Details API - END
                 
                }
                else{
                   
                    url = "https://dnbapistore.com/hackathon/accounts/1.0/account/details?accountNumber=" +selectedAccountNumber + "&customerID=27118632747";
                    HttpGet getRequest = new HttpGet(url);
                 
			
			getRequest.addHeader("Accept", "application/json");
			getRequest.addHeader("Authorization", "Bearer 81ac5011-d4fc-3fc9-95a1-c1520ad3e060");
			
			
			HttpHost proxy = new HttpHost("proxy.drf01.net", 88);
			DefaultProxyRoutePlanner routePlanner = new DefaultProxyRoutePlanner(proxy);
			CloseableHttpClient httpClient = HttpClients.custom().setRoutePlanner(routePlanner).build();
			
			
    // Create an instance of HttpClient.
	  
			
			
			try {
				JSONObject configObject = null;
				HttpResponse response = httpClient.execute(getRequest);
				
				
				BufferedReader br = new BufferedReader(
		                         new InputStreamReader((response.getEntity().getContent())));

				String output;
                
                                System.out.println("Output from Server .... \n");
				while ((output = br.readLine()) != null) {
					configObject = new JSONObject(output);
                                        
                                        jAccountStatus.setText(configObject.get("accountStatus").toString());
                                        jAccountStatus.updateUI();
                                                                                
                                         jAccountType.setText(configObject.get("accountType").toString());
                                         jAccountType.updateUI();
                                         
                                         jAccountName.setText(configObject.get("accountName").toString());
                                         jAccountName.updateUI();
                                         
                                         jCustomerID.setText(configObject.get("customerID").toString());
                                         jCustomerID.updateUI();
                                         
                                         jIBAN.setText(configObject.get("iban").toString());
                                         jIBAN.updateUI();
                                         
                                         jAvailableBalance.setText(configObject.get("availableBalance").toString());
                                         jAvailableBalance.updateUI();
                                         
                                         jBookBalance.setText(configObject.get("bookBalance").toString());
                                         jBookBalance.updateUI();
                                         
                                         jCurrency.setText(configObject.get("currency").toString());
                                         jCurrency.updateUI();
                                         
                                         jCreatedOn.setText(configObject.get("created").toString());
                                         jCreatedOn.updateUI();
                                         
                                        
			}
				
				httpClient.getConnectionManager().shutdown();
				
				
			} catch (ClientProtocolException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
                 //Call Account Details API - END
                }
                
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSeparator2 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jAccountType = new javax.swing.JLabel();
        jCustomerID = new javax.swing.JLabel();
        jIBAN = new javax.swing.JLabel();
        jAvailableBalance = new javax.swing.JLabel();
        jBookBalance = new javax.swing.JLabel();
        jCurrency = new javax.swing.JLabel();
        jCreatedOn = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jAccountsComboBox = new javax.swing.JComboBox<>();
        jSeparator4 = new javax.swing.JSeparator();
        jLabel11 = new javax.swing.JLabel();
        jAccountStatus = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        label1 = new java.awt.Label();
        jAccountName = new javax.swing.JLabel();
        label2 = new java.awt.Label();

        setLocation(new java.awt.Point(200, 200));
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(310, 445));
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Account Details");

        jSeparator1.setPreferredSize(new java.awt.Dimension(70, 2));

        jLabel2.setText("Account Number ");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel4.setText("Account Type :");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel5.setText("Customer ID :");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel6.setText("IBAN :");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel7.setText("Available Balance :");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel8.setText("Book Balance :");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel9.setText("Currency :");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel10.setText("Created On :");

        jAccountType.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jAccountType.setText("jLabel11");

        jCustomerID.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jCustomerID.setText("jLabel12");

        jIBAN.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jIBAN.setText("jLabel13");

        jAvailableBalance.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jAvailableBalance.setText("jLabel14");

        jBookBalance.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jBookBalance.setText("jLabel15");

        jCurrency.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jCurrency.setText("jLabel16");

        jCreatedOn.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jCreatedOn.setText("jLabel17");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel3.setText("Account Name :");

        String[] array = new String[AccountOverview.accountNumberList.size()];
        for(int i = 0; i < array.length; i++) {
            array[i] = AccountOverview.accountNumberList.get(i).toString();

        }
        System.out.println("Inside AccountDetails, List size is" +AccountOverview.accountNumberList.size());
        jAccountsComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(array));
        jAccountsComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jAccountsComboBoxActionPerformed(evt);
            }
        });

        jSeparator4.setPreferredSize(new java.awt.Dimension(70, 2));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel11.setText("Account Status :");

        jAccountStatus.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jAccountStatus.setText("jLabel12");

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel12.setText("Transactions by Category");

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel13.setText("Shopping");

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel14.setText("Food & Drink");

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel15.setText("Clothing");

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel16.setText("Kr 1500");

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel17.setText("Kr 3000");

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel18.setText("Kr 5000");

        jButton1.setText("Update Account");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Close Account");

        label1.setFont(new java.awt.Font("Dialog", 0, 20));
        label1.setText("<");
        label1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                label1MouseClicked(evt);
            }
        });

        jAccountName.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jAccountName.setText("jLabel19");

        label2.setFont(new java.awt.Font("Dialog", 0, 20));
        label2.setText(">");
        label2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                label2MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(60, 60, 60)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addComponent(jButton1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel11)
                            .addComponent(jLabel4)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(label2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel2)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jAccountsComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(jLabel3)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jAccountName))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel6)
                                        .addComponent(jLabel7)
                                        .addComponent(jLabel8)
                                        .addComponent(jLabel9)
                                        .addComponent(jLabel10)
                                        .addComponent(jLabel5)
                                        .addComponent(jLabel13)
                                        .addComponent(jLabel14)
                                        .addComponent(jLabel15))
                                    .addGap(90, 90, 90)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jCreatedOn)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel17)
                                            .addComponent(jLabel16)
                                            .addComponent(jLabel18))
                                        .addComponent(jCurrency)
                                        .addComponent(jBookBalance)
                                        .addComponent(jAvailableBalance)
                                        .addComponent(jIBAN)
                                        .addComponent(jCustomerID)
                                        .addComponent(jAccountType)
                                        .addComponent(jAccountStatus)))))))
                .addGap(421, 421, 421))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(18, 18, 18)
                    .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(464, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(10, 10, 10))
                    .addComponent(label1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(1, 1, 1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jAccountsComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 4, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jAccountStatus))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jAccountType))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jCustomerID))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jIBAN))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(jAvailableBalance))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(jBookBalance))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(jCurrency))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(jCreatedOn)))
                    .addComponent(jAccountName))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(label2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(jLabel16))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(jLabel17))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(jLabel18))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap(21, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(304, 304, 304)
                    .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(121, Short.MAX_VALUE)))
        );

        jLabel1.setForeground(new Color(255,255,255));
        jLabel2.setForeground(new Color(255,255,255));
        jLabel4.setForeground(new Color(255,255,255));
        jLabel5.setForeground(new Color(255,255,255));
        jLabel6.setForeground(new Color(255,255,255));
        jLabel7.setForeground(new Color(255,255,255));
        jLabel8.setForeground(new Color(255,255,255));
        jLabel9.setForeground(new Color(255,255,255));
        jLabel10.setForeground(new Color(255,255,255));
        jAccountType.setForeground(new Color(255,255,255));
        jCustomerID.setForeground(new Color(255,255,255));
        jIBAN.setForeground(new Color(255,255,255));
        jAvailableBalance.setForeground(new Color(255,255,255));
        jBookBalance.setForeground(new Color(255,255,255));
        jCurrency.setForeground(new Color(255,255,255));
        jCreatedOn.setForeground(new Color(255,255,255));
        jLabel3.setForeground(new Color(255,255,255));
        jLabel11.setForeground(new Color(255,255,255));
        jAccountStatus.setForeground(new Color(255,255,255));
        jLabel12.setForeground(new Color(255,255,255));
        jLabel13.setForeground(new Color(255,255,255));
        jLabel14.setForeground(new Color(255,255,255));
        jLabel15.setForeground(new Color(255,255,255));
        jLabel16.setForeground(new Color(255,255,255));
        jLabel17.setForeground(new Color(255,255,255));
        jLabel18.setForeground(new Color(255,255,255));
        label1.setForeground(new Color(255,255,255));
        label1.setBackground(new Color(0,102,102));
        jAccountName.setForeground(new Color(255,255,255));
        label2.setForeground(new Color(255,255,255));
        label2.setBackground(new Color(0,102,102));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jAccountsComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jAccountsComboBoxActionPerformed
        // TODO add your handling code here:
        displayAccountDetails(jAccountsComboBox.getSelectedItem().toString());
               
    }//GEN-LAST:event_jAccountsComboBoxActionPerformed

    private void label1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label1MouseClicked
        // TODO add your handling code here:
         
       AccountOverview aoFrame = new AccountOverview();
        aoFrame.setVisible(true);
        aoFrame.setLocationRelativeTo(null);
        displayAccountOverview();

    }//GEN-LAST:event_label1MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    JTextField textfield = new JTextField(jAccountName.getText());
       
        textfield.setVisible(true);
        textfield.revalidate();
        textfield.repaint();
            
        this.repaint();
        this.revalidate();
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void label2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label2MouseClicked
        // TODO add your handling code here:
        TransactionDetails transactionDetailsFrame = new TransactionDetails();
        transactionDetailsFrame.setVisible(true);
        transactionDetailsFrame.setLocationRelativeTo(null);
        
    }//GEN-LAST:event_label2MouseClicked

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
            java.util.logging.Logger.getLogger(AccountDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AccountDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AccountDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AccountDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

       
    
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
                new AccountDetails().setVisible(true);
                displayAccountDetails("0");
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private static javax.swing.JLabel jAccountName;
    private static javax.swing.JLabel jAccountStatus;
    private static javax.swing.JLabel jAccountType;
    private static javax.swing.JComboBox<String> jAccountsComboBox;
    private static javax.swing.JLabel jAvailableBalance;
    private static javax.swing.JLabel jBookBalance;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private static javax.swing.JLabel jCreatedOn;
    private static javax.swing.JLabel jCurrency;
    private static javax.swing.JLabel jCustomerID;
    private static javax.swing.JLabel jIBAN;
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
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator4;
    private java.awt.Label label1;
    private java.awt.Label label2;
    // End of variables declaration//GEN-END:variables
}

