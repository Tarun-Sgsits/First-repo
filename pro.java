import java.util.Scanner;
import java.io.*;
import collages.univercity; // USERDEFINED PACKAGE
import companies.company; //USERDEFINED PACKAGE

// All variables used in program
 class variable{
    String UserName , Password , Email , Address , Pincode , title , description , TS;
    String image , Persue;
    double Contact;
    int amount , helper , UCB ;
}

class Project extends SponsorshipInfo{
    public static void main(String args[]){
        Scanner sc =new Scanner(System.in);
        variable obj = new variable();
        UserInfo ui = new UserInfo();
        ProjectInfo pi = new ProjectInfo();
        SponsorshipInfo si = new SponsorshipInfo();
        
        System.out.print("     ");
        System.out.println("Hello and Thank you for selecting BE SPONSORED to be your sponsorship partner.\n"
        +"           We'r excited to embark on this"+"journey with you.");
        System.out.println("        Please provide the requested details to intiate your status.");
        ui.Beneficiary_Detail();
        pi.Project_Detail();
        si.Sponsorship_Detail();
       

    }
}// CLASS PROJECT ENDS

 abstract class Method extends variable{
    abstract public void Beneficiary_Detail();
    abstract public void Project_Detail();
    abstract public void Sponsorship_Detail();
}

//Using MultiLevel Inheritance
class UserInfo extends Method{
    public  void Beneficiary_Detail (){
    Scanner sc = new Scanner(System.in);
    variable obj = new variable();

    System.out.println("Enter Username");
    obj.UserName = sc.nextLine();
    System.out.println("Create Strong Password");
    obj.Password = sc.nextLine();
    System.out.println("E-mail");
    obj.Email = sc.nextLine();
    System.out.println("Address");
    obj.Address = sc.nextLine();
    System.out.println("What are you persuing?");
    obj.Persue = sc.nextLine();
    
    //Following Info Stored in File   
    try{
        FileWriter fw = new FileWriter("file1.txt",true);
        try{
            fw.write(obj.UserName);
            fw.write(obj.Password);
            fw.write(obj.Email);
            fw.write(obj.Address);
            fw.write(obj.Persue);
            
        }
        finally{
            fw.close();
        }
    }catch (IOException i){
        System.out.println(i);
    }

    System.out.println("    "+"Congratulation " + obj.UserName + " You are succesfully Enrolled ");
    System.out.println("       "+"Next you have to Enter your project details");
    }
    public void Project_Detail(){}
    public void Sponsorship_Detail(){}

}// CLASS USER_INFO ENDS


class ProjectInfo extends UserInfo{
    public  void Project_Detail(){
    Scanner sc = new Scanner(System.in);
    ProjectInfo pi = new ProjectInfo();

    System.out.println("Enter Project Title");
    pi.title = sc.nextLine();
    System.out.println("Enter Project Description");
    pi.description = sc.nextLine();
    System.out.println("Enter Y to upload Project Image");
    pi.image = sc.nextLine();

    //Following Info Stored in File
    try{
        FileWriter fw = new FileWriter("file2.txt");
        try{
            fw.write(pi.title);
            fw.write(pi.description);
            fw.write(pi.image);
        }
        finally{
            fw.close();
        }
    }catch (IOException i){
        System.out.println(i);
    }

    System.out.println("   "+" Details of your project"+ " ' " + pi.title + " ' "  + 
    " has stored in our database");
    System.out.println("Now, Complete the lastt step to kickstart your Sponsorship Journey");
    }
} //CLASS PROJECT_INFO ENDS


class SponsorshipInfo extends ProjectInfo{
    public  void Sponsorship_Detail(){
        Scanner sc = new Scanner(System.in);
        SponsorshipInfo si = new SponsorshipInfo();
        univercity uni = new univercity();
        company com = new company();

        System.out.println("Enter amount You need as Sponsor : ");
        si.amount = sc.nextInt();
        System.out.println("Enter number of helper u need : ");
        si.helper = sc.nextInt();
        System.out.println("Enter Y if U need Technical Support : ");
        si.TS = sc.nextLine();
       
        System.out.println("From University(1) Company(2)");
        si.UCB = sc.nextInt();
        if(1 == si.UCB ){

            if(si.amount == 5000)
            uni.MANITBhopal();
            if(si.amount == 1000)
            uni.SGSITS();
            System.out.println();
            uni.Medicaps();
            if(si.amount == 15000)
            uni.IITIndore();

        }else if(2 == si.UCB){
            if(si.amount == 5000)
          com.Accenture("Awards and Recognition: TCS has received numerous awards "+ 
    "recognitions for its services, corporate governance, and sustainability efforts.");
           
           if(si.amount == 1000)
           com.TCS("Awards and Recognition: Accenture has received numerous awards "+
    "and recognitions for its services, workplace practices, and sustainability efforts.");

            if(si.amount == 15000)
           com.tata_motors("Awards and Recognition: The company has received numerous awards "+
    "and accolades for its contributions to the automotive industry and its commitment to quality and sustainability.");


        }//CLASS SPONSORSHIP_INFO ENDS 

    }
}