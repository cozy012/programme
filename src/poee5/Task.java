
package poee5;


public class Task {
     String[] TaskName;
      int TaskNum;
      String[] TaskDescription;
      int[] TaskDuration;
      String[] DeveloperDtls;
      String[] TaskID;
      String[] TaskStatus; 
      
      public Task (int NumberofTask) {
          TaskName = new String[NumberofTask];
          TaskNum=0;
          TaskDescription = new String[NumberofTask];
          DeveloperDtls = new String[NumberofTask];
          TaskDuration = new int [NumberofTask];
          TaskID = new String[NumberofTask];
          TaskStatus = new String[NumberofTask];
      }   
      
      public boolean checkTaskDescrptn (String descrptn)
      {
          return (descrptn.length() <= 50);
      }
      public String createľaskID(int taskNumber)
      {
          TaskID[taskNumber] = TaskName[taskNumber].substring(0, 2).toUpperCase() + ":" + taskNumber + ":" + DeveloperDtls[taskNumber].substring(DeveloperDtls[taskNumber].length() - 3).toUpperCase() ;
          return TaskID[taskNumber];
      }
      
      public void printTaskDetails(int TotalTasks)
      {
          System.out.print("\n\nTask saved so far...\n");
          System.out.print("\n\ttaskID\ttaskName\tDuration\tStatus\tDescription\tDeveloper\n");
          for(int a = 0; a < TotalTasks; a++)
          {
              System.out.print("\n" + (a+1) + ".\t" + TaskID[a] + "\t" + TaskName[a] + "\t" + TaskDuration[a] + "\t" + TaskStatus[a] + "\t" + DeveloperDtls[a]);
              
          }
          System.out.print("\n\nTotal tasks duration : " + returnTotalhours(TotalTasks) + "\n\n" );
      }
        public int returnTotalhours(int TotalTasks)
        {
           int totalHours = 0;
           for(int a = 0; a < TotalTasks;a++)
               totalHours = totalHours + TaskDuration[a];
           return totalHours;
        } 
    
}
