/*
    Creational pattern - Builder
         provide a flexible solution to various object creation problems
*/

package io.ksrntheja.creational.builder;

import java.time.LocalDate;

public class Employee {

    //required parameters
    private int empNo;
    private String eName;
    private String job;
    private LocalDate hireDate;
    private int sal;
    private int deptNo;

    //optional parameters
    private int mgr;
    private int comm;

    public int getEmpNo() {
        return empNo;
    }

    public String geteName() {
        return eName;
    }

    public String getJob() {
        return job;
    }

    public LocalDate getHireDate() {
        return hireDate;
    }

    public int getSal() {
        return sal;
    }

    public int getDeptNo() {
        return deptNo;
    }

    public int getMgr() {
        return mgr;
    }

    public int getComm() {
        return comm;
    }

    private Employee(EmployeeBuilder employeeBuilder) {
        this.empNo = employeeBuilder.empNo;
        this.eName = employeeBuilder.eName;
        this.job = employeeBuilder.job;
        this.hireDate = employeeBuilder.hireDate;
        this.sal = employeeBuilder.sal;
        this.deptNo = employeeBuilder.deptNo;
        this.mgr = employeeBuilder.mgr;
        this.comm = employeeBuilder.comm;
    }

    // Builder Class
    public static class EmployeeBuilder {

        // required parameters
        private int empNo;
        private String eName;
        private String job;
        private LocalDate hireDate;
        private int sal;
        private int deptNo;

        //optional parameters
        private int mgr;
        private int comm;

        public EmployeeBuilder(int empNo, String eName, String job, LocalDate hireDate, int sal, int deptNo) {
            this.empNo = empNo;
            this.eName = eName;
            this.job = job;
            this.hireDate = hireDate;
            this.sal = sal;
            this.deptNo = deptNo;
        }

        public EmployeeBuilder setMgr(int mgr) {
            this.mgr = mgr;
            return this;
        }

        public EmployeeBuilder setComm(int comm) {
            this.comm = comm;
            return this;
        }

        public Employee build() {
            return new Employee(this);
        }

    }
}
/*
        Employee employee = new Employee.
                EmployeeBuilder(1, "one", "CEO", LocalDate.now(), 1, 10).
                setComm(0).
                // setMgr()
                        build();
*/
