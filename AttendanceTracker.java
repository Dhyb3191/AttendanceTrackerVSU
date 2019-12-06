/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendancetracker;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;
import java.sql.Timestamp;
import java.net.InetAddress;

/**
 *
 * @author garde
 */
public class AttendanceTracker {

    /**
     * @param args the command line arguments
     */
    public static String K,x,compare,IPA;
    public static int i,temp;
   public static String exit="exit";
   public static String Enter="Enter";
    
    public static void main(String[] args) throws Exception {
        InetAddress IP = InetAddress.getLocalHost();
        IPA=IP.getHostAddress();
        
       Login();
       
       
       
    }
    
    
    
    




public static void Login() {
  
    
     
    try{
    Scanner scan = new Scanner (new File("C:\\Users\\garde\\Documents\\NetBeansProjects\\AttendanceTracker\\Users.txt"));
    
    Scanner keyboard = new Scanner (System.in);
    String user = scan.nextLine();
    
    System.out.println("Please enter your username");
    String inpUser = keyboard.nextLine();
   
  if (inpUser.equals(user)&&user=="Admin") {
        System.out.print("Success!");
        K=user;
        System.out.println("Welcome Back "+user);
     System.out.println("Would you like to wipe the text file Y/N?");
     Scanner s=new Scanner(System.in);
     String answer=s.nextLine();
     answer.toUpperCase();
     if(answer=="Y"){
       File file = new File("C:\\Users\\garde\\Documents\\NetBeansProjects\\AttendanceTracker\\Attendance.txt"); 
          
        if(file.delete()) 
        { 
            System.out.println("File deleted successfully"); 
        } }
        else
        { 
            System.out.println("File is not deleted"); 
        } 
     BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader("C:\\Users\\garde\\Documents\\NetBeansProjects\\AttendanceTracker\\Attendance.txt"
					));
			String line = reader.readLine();
			while (line != null) {
				System.out.println(line);
				// read next line
				line = reader.readLine();
			}
			reader.close();
		}
     
     catch (Exception e){}
  }
    if (inpUser.equals(user)) {
        System.out.println("Success!");
        K=user;
        System.out.println("Welcome "+user+" Your current code is "+randomnumber());

        Scanner n=new Scanner(System.in);
       while(i!=9){
      System.out.println("Please select from the following options");
      System.out.println("1: Begin class");
      System.out.println("2: End Class");
      System.out.println("9: Exit IDE");
      System.out.println();
      
      i=n.nextInt();
      int g=i;
      if(g==1){
      System.out.println("Please enter your code");
      Scanner enterCode=new Scanner(System.in);
      
      int f=enterCode.nextInt();
      
      
      if(temp==f){
           Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        
      System.out.println("Code Accepted! at "+timestamp);
      FileWriter(K,timestamp,Enter,IPA);
      
      }
      else 
          System.out.println("Error invalid Input");
      
      
      
      
      
      
      
      
      }
      if(g==2){
          
      System.out.println("Please enter your code");
      Scanner enterCode=new Scanner(System.in);
      
      int f=enterCode.nextInt();
      
      
      if(temp==f){
           Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        
      System.out.println("Code Accepted! at "+timestamp);
      FileWriter(K,timestamp,exit,IPA);
      
      }
      else 
          System.out.println("Error invalid Input");
      }
      
      
       } 
        
           
    } else {
        System.out.print("User does not exisit");
    }}
  
catch (FileNotFoundException e){}
}
  public static int randomnumber(){
       Random random = new Random();
    int randomInteger = random.nextInt(999999999+1);
    temp=randomInteger;
   
    return randomInteger;
    }
  
  
  
  

  
     


public static String FileWriter(String User,Timestamp time,String type,String IPADDRESS){

 try {

        String content = (User+","+time+","+type+","+IPADDRESS+"\n");

        File file = new File("C:\\Users\\garde\\Documents\\NetBeansProjects\\AttendanceTracker\\Attendance.txt");

        // if file doesnt exists, then create it
        if (!file.exists()) {
            file.createNewFile();
        }

        FileWriter fw = new FileWriter(file.getAbsoluteFile(),true);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(content);
        bw.close();

        

    } catch (IOException e) {
        e.printStackTrace();
    }
 return x;
}}


   
