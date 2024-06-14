import java.util.*;

public class Main {

    EmployeeService service=new EmployeeService();
    static boolean ordering =true;

    public static void menu(){ṇ
        System.out.println("******************Welcome to Management System**********************"
                        +"\n\n1.Add Employee"
                        +"\n2.View Employee"
                        +"\n3.Update Employee"
                        +"\n4.Delete Employee"
                        +"\n5.View All Employee"
                        +"\n6.Exit");
    }

    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        EmployeeService service=new EmployeeService();
        do{
            menu();
            System.out.println("Enter your Choice=");
            int choice=sc.nextInt();
            switch (choice) {
                
                case 1:
                    System.out.println("Add Employee");
                    service.addEmp();
                    break;

                case 2:
                    System.out.println("View Employee");
                    service.viewEmp();
                    break;    
            
                
                case 3:
                    System.out.println("Update Employee");
                    service.updateEmployee();
                    break;

                case 4:
                    System.out.println("Delete Employee");
                    service.deleteEmp();
                    break;
                    
                case 5:
                    System.out.println("View All Employee");
                    service.viewAllEmps();
                    break;
                    
                case 6:
                    System.out.println("Thank you for using application!!");
                    System.exit(0);
                    break;    
                default:
                System.out.println("Please Enter Valid Choice");
                    break;
            }

        }while(ordering);


    }




    static class Employee {
        private int id;
        private String name;
        private int age;
        private String designation;
        private String department;
        private double salary;
    
        public int getId(){
            return id;
        }
        public void setId(int id){
            this.id=id;
        }
    
        public String getName(){
            return name;
        }
        public void setName(String name){
            this.name=name;
        }
    
        public int getAge(){
            return age;
        }
        public void setAge(int age){
            this.age=age;
        }
    
        public String getDesignation(){
            return designation;
        }
        public void setDesignation(String designation){
            this.designation=designation;
        }
    
        public String getDepartment(){
            return department;
        }
        public void setDepartment(String department){
            this.department=department;
        }
    
        public double getSalary(){
            return salary;
        }
        public void setSalary(double Salary){
            this.salary=Salary;
        }
    
        @Override
        public String toString(){
            return "Employee [id=" + id + ",name=" + name + ",age=" + age + ",designation=" + designation +",department=" + department + ",salary="+ salary +"]";
        };
    
        public Employee(int id,String name,int age,String designation,String department,double salary){
           super();
           this.id=id;
           this.name=name;
           this.age=age;
           this.designation=designation;
           this.department=department;
           this.salary=salary; 
        }
    
    
    
    }
    
    







     static class EmployeeService {
    HashSet<Employee>empset=new HashSet<Employee>();

    Employee emp1=new Employee(101,"Shital",24,"Developer","IT",25000);
    Employee emp2=new Employee(102,"Meena",26,"Tester","CO",57000);
    Employee emp3=new Employee(103,"Bob",20,"DevOps Eng","Admin",5000);
    Employee emp4=new Employee(104,"Max",27,"System Eng","CO",70000);

    Scanner sc=new Scanner(System.in);
    

    int id;
    String name;
    int age;
    String department;
    String designation;
    double sal;

    public EmployeeService(){
        empset.add(emp1);
        empset.add(emp2);
        empset.add(emp3);
        empset.add(emp4);
    }

    //view All Employee
    public void viewAllEmps(){
        for(Employee emp:empset){
            System.out.println(emp);
        }
    }

    //view emp based on their id
    public void viewEmp(){
        boolean found=false;
        System.out.println("Enter id:");
        id=sc.nextInt();
        for(Employee emp:empset){
            if(emp.getId()==id){
                System.out.println(emp);
                found=true;
            }
        }
        if(!found){
            System.out.println("Employee with id is not present");
        }
    }

    //update the employees
    public void updateEmployee(){
        System.out.println("Enter id:");
        id=sc.nextInt();
        boolean found=false;
        for(Employee emp:empset){
            if(emp.getId()==id){
                System.out.println("Enter name:");
                name=sc.next();
                System.out.println("Enter new Salary:");
                sal=sc.nextDouble();
                emp.setName(name);
                emp.setSalary(sal);
                System.out.println("Updated Details of employee are");
                System.out.println(emp);
                found=true;
            }
        }
        if(!found){
            System.out.println("Employee is not present");
        }
        else{
            System.out.println("Employee details updated successfully");
        }
    }    


    //Delete emp
    public void deleteEmp(){
        System.out.println("Enter id:");
        id=sc.nextInt();
        boolean found=false;
        Employee empdelete=null;
        for(Employee emp:empset){
            if(emp.getId()==id){
                empdelete=emp;
                found=true;
            }
        }
        if(!found){
            System.out.println("Employee is not present");
        }
        else{
            empset.remove(empdelete);
            System.out.println("Employee deleted successfully");
        }
    }

    //add emp
    public void addEmp(){
        System.out.println("Enter id:");
        id=sc.nextInt();
        System.out.println("Enter name:");
        name=sc.next();
        System.out.println("Enter age:");
        age=sc.nextInt();
        System.out.println("Enter Designation:");
        designation=sc.next();
        System.out.println("Enter department:");
        department=sc.next();
        System.out.println("Enter salary:");
        sal=sc.nextDouble();

        Employee emp=new Employee(id, name, age, designation, department, sal);
        empset.add(emp);

        System.out.println(emp);
        System.out.println("Employee Added Successfully");

    }


}
    

}





