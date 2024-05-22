
package poee5;
import java.util.Scanner;


public class POEE5 {

   
    public static void main(String[] args) {
        Scanner jj = new Scanner(System.in);
        Login seg = new Login();
        
        
        String userName;
        String passwrd;
        
        String Firstname;
        String Lastname;
        String password;
        String username;
        String generated;
        
        boolean exit = false;
        
        try {
            do{System.out.println();
            
            System.out.println("select \tl. Login \n\t2. create Account\n\t3. Exit");
            
            int choice = jj.nextInt();
            
            switch (choice){
                case 1: 
                    System.out.print("username");
                    
                    userName = jj.next();
                    
                    System.out.print("password");
                    
                    passwrd = jj.next();
                    
                    seg.setUsername(userName);
                    seg.setPassword(passwrd);
                    
                    generated = seg.registeruser();
                    
                    if (!generated.isEmpty()) {
                        System.out.println(generated);
                        
                    } else if (generated.isEmpty()){
                        boolean success = seg.loginuser(userName, passwrd);
                        
                        System.out.println(seg.returnloginstatus(success));
                    }
                    break;
                case 2:
                    System.out.print("Fisrt Name: ");
                    
                    Firstname = jj.next();
                    
                    System.out.print("Last Name: ");
                    
                    Lastname = jj.next();
                    
                    System.out.print("username: ");
                    
                    username = jj.next();
                    
                    System.out.print("password: ");
                    
                    passwrd = jj.next();
                    
                    seg.setFirstName(Firstname);
                    
                    seg.setLastname(Lastname);
                    
                    seg.setUsername(username);
                    
                    seg.setPassword(passwrd);
                    
                    generated = seg.registeruser();
                    
                    if(Firstname.equals("")) {
                        System.out.println("First name cannot be empty");
                    } else if (Lastname.equals("")) {
                        System.out.println("Last cannot be empty");
                    } else if (!generated.equals("")){
                        System.out.println(generated);
                    } else {
                        System.out.println("user has been registered successfully");
                    }
                   break;
                    case 0:
                        exit = true;
                        break;
                }

            } while (!exit);
            
        } catch (Exception ex) {
            
            System.out.println(ex.getMessage());
            
        } finally {
            
            if (jj != null) {
                
                jj.close();
            }
        }
    }
    
}
