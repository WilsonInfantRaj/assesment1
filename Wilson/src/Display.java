import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class Display {
	static File Loc = new File("E:\\demo\\");
	static Scanner sc=new Scanner(System.in);  
	static void start() {
		System.out.println("***************Welcome to Lockers Pvt. Ltd******************");
		System.out.println("Application Developer Name : Wilson InfantRaj");
		System.out.println("Select the Option to Continue :");
		System.out.println(" 1.Display the Files Present in the directory"+'\n'+" 2.Create the New Files"+'\n'+" 3.Delete the Files"+'\n'+" 4.Search the Files "+'\n'+" 5.Close the Application");
		Scanner sc=new Scanner(System.in);  
		System.out.print("Enter the Options from the above: "); //object of Scanner class  
		int option=sc.nextInt();
		if(option==1) {
			display();
		}else if(option==2) {
			create();
		}else if(option ==3) {
			delete();
		}else if(option==4) {
			search();
		}else if(option==5) {
			closeApp();
		}
	}
	static void create() {
		System.out.print("Enter the file name to create: ");  
		String name=sc.nextLine().toLowerCase(); 
		File file = new File("E:\\demo\\"+name+".txt");
		boolean result;  
		try   
		{  
		result = file.createNewFile();  //creates a new file  
		if(result)      // test if successfully created a new file  
		{  
		System.out.println("file created "+file.getCanonicalPath()); //returns the path string  
		}  
		else  
		{  
		System.out.println("File already exist at location: "+file.getCanonicalPath());  
		}  
		}   
		catch (IOException e)   
		{  
		e.printStackTrace();    //prints exception if any  
	}
	}
	static void display() {
		 String[] fileList = Loc.list();
	      System.out.println("Files Availabale in this directory :");
	      if (fileList == null) {
	         System.out.println("File does not exists.");
	      }
	      else {
	         for (int i = 0; i < fileList.length; i++) {
	            String filenames = fileList[i];
	           
	            System.out.println(filenames);
	         }
	      }
	}
	static void delete() {
		System.out.print("Enter the file name to be deleted : "); 
	      String delete=sc.nextLine(); 
	      Path path = FileSystems.getDefault().getPath("E:\\demo\\"+delete+".txt");
	        try {
	            Files.deleteIfExists(path);
	            
	            System.out.println("File " + delete+" Deleted Successfully");
	        } catch (IOException x) {
	            System.err.println(x);
	        }
	}
	static void search() {
		File f = new File("E:\\demo");
		 System.out.println("Enter the file name to search :");
		 String search=sc.nextLine(); 
	      Path path = FileSystems.getDefault().getPath("E:\\demo\\"+search+".txt");
		 
        // Checking if the specified file exists or not
        if (f.exists())
 
            // Show if the file exists
            System.out.println("Searched File "+search+" Exists in this directory");
        else
 
            // Show if the file does not exists
            System.out.println("File Not Found");
    }
	static void closeApp() {
		System.exit(0);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		while(true) {
			start();
		}
	}

}
