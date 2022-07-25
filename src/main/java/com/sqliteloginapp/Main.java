/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sqliteloginapp;

/**
 *
 * @author herma
 */
import java.sql.*;
import java.util.Scanner;
import java.util.Base64.Encoder;

import javax.crypto.ExemptionMechanismSpi;
import org.owasp.esapi.Encoder;
import org.owasp.esapi.codecs.XMLEntityCodec;
import org.owasp.esapi.reference.DefaultEncoder;

public class Main {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {			
		
            ESAPI.encoder().encodeForSQL(new Object(), OracleCodec(), Query);
            Connection c = null;                
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:accounts.db");
            c.setAutoCommit(false);
            // This should REALLY be validated
            System.out.println("Enter username");
            String userName = request.getParameter("userName");
            try{
                System.out.println("Enter password");
                String passWord = request.getParameter("passWord");
                try {
                    Codec ORACLE_CODEC = new OracleCodec();
                    String query = "SELECT user_id FROM user_data WHERE user_name = '"
                    + ESAPI.encoder().encodeForSQL( ORACLE_CODEC, req.getParameter("userName"))
                    + "' and user_password = '"
                    + ESAPI.encoder().encodeForSQL( ORACLE_CODEC, req.getParameter("passWord")) +"'";
                    //String query = "select * from user where username='" + userName + "' and password='" + passWord + "'";
                    PreparedStatement pstmt= c.createStatement();
                    pstmt.setString(1, userName);

                    ResultSet res = pstmt.executeQuery();
                    if(res.next()){
                        System.out.println("Success login, welcome "+ userName);
                    } else {
                        System.out.println("Failed login");
                    }
                } catch (SQLException e) {
                    System.out.println("Failed login");
                }
            } catch (SQLException se) {
                System.out.println("Failed login");
            }      

            
                
	}     
}
