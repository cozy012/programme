
package poee5;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Login {
    
    private static final String P_COMPLEXITY = "^(?.=*[A-z]) (?=.*[a-z] (?=.*[0-9]) (?=.*?[#?!@$%^&*-]).{*8,}$";
    
    private String username;
    
    public String getUsername(){
         return username;
    }
    public void setUsername(String username){
        this.username = username;
    }
    private String password;
    public String getPassword() {
         return password;
    }
    public void setPassword(String password){
        this.password = password;
    }
    private String FirstName;
    
    public String getFirstName(){
         return FirstName;
    }
    public void setFirstName(String FirstName){
        this.FirstName = FirstName;
    }
    
    private String Lastname;
    
     public String getLastname(){
         return Lastname;
     }
     public void setLastname(String surname){
         this.Lastname = Lastname;
     }
     
     public Login(){
         
     }
     public Login login(Login obj){
          return obj;
     }
    public boolean  checkuserName(String username){
         boolean red = true;
        if (!this.username.contains("_") || this.username.length() > 5){
            red = false;
        }
        return red;
    }
    public boolean checkpasswordcomplexity(){
        boolean red;
        if(this.password.isEmpty()){
            red = false;
        }
         Pattern p = Pattern.compile(P_COMPLEXITY);
        Matcher m = p.matcher(this.password);
        red = m.matches();
        return red;
    }
    
    public String registeruser(){
        String response = "";
        
        if (checkuserName()){
            if (!checkpasswordcomplexity()){
                response = "Password is not correctly formatted, please ensure that the password contains at least 8 characters in length, capital letter, a number and a special character.";
            }
        }else {
            response = "Username is not correctly formatted, please ensure that your username contains an underscore and is no more tan 5 characters in length";
        }
         return response;
    }
    
    public boolean loginuser(String uname, String pswd){
        boolean red = false;
        if(uname.equals(this.username) && pswd.equals(this.password)){
            red = true;
        }
        return red;
    }
    
    public String returnloginstatus(boolean status ){
        String response = "username or password incorrect, please try again";
        
        if (status){
            response = "Welcome " + getFirstName() + " , " + getLastname() + " it is great to see you again.";
        }
        Scanner scan = new Scanner(System.in);
        int numOfTasks;
        
        System.out.print("Welcome to Khanban");
        
        System.out.print("\n\nHow Many Tasks Do You Want To Enter? : ");
        
        numOfTasks = scan.nextInt();
        
        if(numOfTasks > 0) {
            Task task1 = new Task(numOfTasks);
            
             System.out.print("\n\nThank You, You May Now Start Capturing The Tasks,\n If you want to quit just press 3..");
             
              for(int k = 0; k < numOfTasks; k++){
                   System.out.print("\n\n1). Add Tasks");
                   
                    System.out.print("\n2). Show Report");
                    
                    System.out.print("\n3). Quit\n\nPick and Option : ");
                    
                    int option = scan.nextInt();
                    
                    if(option == 1){
                        task1.TaskNum = k;
                        
                        System.out.print("Enter This Task's Name : ");
                        
                        task1.TaskName[k] = scan.next();
                        
                        System.out.print("Enter This Task's Description : ");
                        
                        task1.TaskDescription[k] = scan.next();
                        
                        while(!task1.checkTaskDescrptn(task1.TaskDescription[k]))
                        {
                             System.out.print("Description Shouldn't Be More Than 50 Characters, Please Try Again : ");
                             
                             task1.TaskDescription[k] = scan.next();   
                             
                        }
                        System.out.print("Enter This Task's Developer details : ");
                        task1.DeveloperDtls[k] = scan.next();
                        
                       System.out.print("Enter this task's duration (in hours) : ");
                       
                       task1.TaskDuration[k] = scan.nextInt();
                       
                       System.out.print("Enter This Task Status, Choose One Below \n");
                       
                       System.out.print("\n1. To Do");
                       
                       System.out.print("\n2. Done");
                       
                       System.out.print("\n3. Doing");
                       
                       System.out.print("\nEnter Number Before The Option Of Your Choice : ");
                       
                       int choice = scan.nextInt();
                       
                       while(choice < 1 || choice > 3) {
                           System.out.print("\nRange Is Between 1 And 3, Please Try Again : ");
                           
                           choice = scan.nextInt();
                           
                       }
                       if(choice == 1)
                           task1.TaskStatus[k] = "To Do";
                       
                        if(choice == 2)
                            task1.TaskStatus[k] = "Done";
                        
                        if(choice == 3)
                            task1.TaskStatus[k] = "Doing";
                        
                        task1.createľaskID(k);     
                        
                    }
                    if(option == 2){
                        task1.printTaskDetails(k);
                        k--;
                    
                    }
                    if(option == 3){
                        k = numOfTasks;
                    }
              }
        }
         return response;
    }

    private boolean checkuserName() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
