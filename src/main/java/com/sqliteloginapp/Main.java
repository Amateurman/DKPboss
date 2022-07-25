/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sqliteloginapp;

import java.lang.System.Logger;
/**
 *
 * @author herma
 */
import java.sql.*;
import java.util.Scanner;
import java.util.Base64.Encoder;
import java.io.IOException;

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
            logger.log("Enter username");
            String userName = request.getParameter("userName");
            String passWord;
            String query;
            try{
                logger.log("Enter password");
                passWord = request.getParameter("passWord");
                try {
                    Codec oracleCodec = new OracleCodec();
                    query = "SELECT user_id FROM user_data WHERE user_name = '" + ESAPI.encoder().encodeForSQL( oracleCodec, req.getParameter("userName")) + "' and user_password = '" + ESAPI.encoder().encodeForSQL( oracleCodec, req.getParameter("passWord")) +"'";
                    
                    PreparedStatement pstmt= c.createStatement();
                    pstmt.setString(1, userName);

                    ResultSet res = pstmt.executeQuery();
                    if(res.next()){
                        logger.log("Success login, welcome "+ userName);
                    } else {
                        logger.log("Failed login");
                    }
                } catch (SQLException e) {
                    logger.log("Your Password like SQL Inject");
                }
            } catch (SQLException se) {
                logger.log("Your Username like SQL Inject");
            }      

            
                
	}     
}
