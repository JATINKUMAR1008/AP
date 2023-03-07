package File_Handling;

import java.io.*;


import java.util.Scanner;

class Employee{
    String name,Eid,desg,age,salary;
}

class File_Writer {

    String name,Eid,desg,age,salary;

    public void writer(Employee details[],int l,int check) throws IOException{
        int temp;
        if(check==0){
            temp=0;
        }else temp = l;
        FileWriter write_obj = new FileWriter("employee_details.txt",true);
        for(int i=0+temp;i<=l;i++){
            write_obj.write("e_id="+details[i].Eid+", e_name="+details[i].name+", designation="+details[i].desg+", age="+details[i].age+", salary="+details[i].salary+"\n");

        }



        write_obj.close();
        System.out.println("Added successfully");
    }


}

class Reader{
    public void read(){
        try{
            File read_obj = new File("employee_details.txt");
            Scanner myreader = new Scanner(read_obj);
            if(read_obj.length()==0){
                System.out.println("Please save your data before reading: ");
            }else{
                while(myreader.hasNextLine()){
                    String data = myreader.nextLine();
                    if(data.equals("")){

                    }else{
                        System.out.print("Employee: ");
                        System.out.println(data);
                    }

                }

            }
            myreader.close();
        }catch (FileNotFoundException e){
            System.out.println("Err");
        }
    }
    public void SearchwithId(String id){
        try{
            File read_obj = new File("employee_details.txt");
            Scanner myreader = new Scanner(read_obj);
            if(read_obj.length()==0){
                System.out.println("Please save your data before reading: ");
            }
            else{
                while(myreader.hasNextLine()){
                    String data = myreader.nextLine();
                    if(data.indexOf(id,0)!=-1){
                        System.out.print("Employee: ");
                        System.out.println(data);
                        return;
                    }

                }
            }

            System.out.println("Employee with e_id: "+id+" not found");
            myreader.close();
        }catch (FileNotFoundException e){
            System.out.println("Err");
        }
    }
}

public class Employee_Details {
    static Employee[] details=new Employee[100];
    static int flag =-1;
    static int check=0;
    public static void main(String[] args) throws IOException {



        File file_obj = new File("employee_details.txt");

        if(file_obj.exists()){
            System.out.println("Already Exists");
        }else{
            file_obj.createNewFile();
            System.out.println("File "+file_obj.getName()+" created");
        }
        int ch=0;
        Scanner input =new Scanner(System.in);
        Reader rd = new Reader();
        while(ch!=6){
            System.out.println("MAIN MENU");
            System.out.println("------------------------------");
            System.out.println("\t1.Add Employee");
            System.out.println("\t2.Display all Employees");
            System.out.println("\t3.Display with Eid");
            System.out.println("\t4.Write all Employees to file: ");
            System.out.println("\t5.Read all Employees from file: ");
            System.out.println("\t6.Exit");
            System.out.println("Enter your choice: ");
            ch = input.nextInt();

            switch (ch){
                case 4:
                    File_Writer fw= new File_Writer();
                    fw.writer(details,flag,check);
                    check++;
                    break;
                case 5:
                    rd.read();
                    break;
                case 6:
                    System.out.println("--------------Thankyou for using------------");
                    ch=6;
                    break;
                case 3:
                    System.out.println("Enter Eid: ");
                    String Eid = input.next();
                    rd.SearchwithId(Eid);
                    break;
                case 1:
                    int j = ++flag;
                    details[j]=new Employee();
                    System.out.println("Enter Employee's Eid: ");
                    String a =input.next();
                    details[j].Eid = a;
                    System.out.println("Enter name of Employee: ");
                    details[j].name = input.next();
                    System.out.println("Enter Employee's age: ");
                    details[j].age = input.next();
                    System.out.println("Enter Employee's designation: ");
                    details[j].desg = input.next();
                    System.out.println("Enter Employee's salary: ");
                    details[j].salary = input.next();
                    break;
                case 2:
                    for(int i=0;i<=flag;i++){
                        System.out.println("Employee [e_id="+details[i].Eid+", e_name="+details[i].name+", designation="+details[i].desg+", age="+details[i].age+", salary="+details[i].salary+"]");
                    }




            }

        }



    }
}
