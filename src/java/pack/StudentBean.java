/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pack;

/**
 *
 * @author Nikhil
 */
public class StudentBean {
    private int rollno;
    private String enrollmentno;
    private String sname;
    private String fname;
    private String gender;
    private String mobileno;
    private String emailid;

    /**
     * @return the rollno
     */
    public void addStudent(){
        String qry="insert into studentmaster (enrollmentno,sname,fname,gender,mobileno,emailid) values ('" +enrollmentno + "','" + sname + "','" + fname + "','" +gender + "','" + mobileno + "','" + emailid+"')";
    DataManager.executeUpdate(qry);
    }   
    public void updateStudent(int rno){
        DataManager.executeUpdate("update studentmaster set "
                + "enrollmentno='" + enrollmentno + "',"
                + "sname='" + sname + "',"
                + "fname='" + fname + "',"
                + "gender='" + gender + "',"
                + "mobileno='" + mobileno + "',"
                + "emailid='" + emailid + "'"
                + " where rollno=" + rno);
    }
    public static void deleteStudent(int rno){
        DataManager.executeUpdate("delete from studentmaster where rollno = "+rno);
    }
    public int getRollno() {
        return rollno;
    }
    /**
     * @param rollno the rollno to set
     */
    public void setRollno(int rollno) {
        this.rollno = rollno;
    }

    /**
     * @return the enrollmentno
     */
    public String getEnrollmentno() {
        return enrollmentno;
    }

    /**
     * @param enrollmentno the enrollmentno to set
     */
    public void setEnrollmentno(String enrollmentno) {
        this.enrollmentno = enrollmentno;
    }

    /**
     * @return the sname
     */
    public String getSname() {
        return sname;
    }

    /**
     * @param sname the sname to set
     */
    public void setSname(String sname) {
        this.sname = sname;
    }

    /**
     * @return the fname
     */
    public String getFname() {
        return fname;
    }

    /**
     * @param fname the fname to set
     */
    public void setFname(String fname) {
        this.fname = fname;
    }

    /**
     * @return the gender
     */
    public String getGender() {
        return gender;
    }

    /**
     * @param gender the gender to set
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * @return the mobileno
     */
    public String getMobileno() {
        return mobileno;
    }

    /**
     * @param mobileno the mobileno to set
     */
    public void setMobileno(String mobileno) {
        this.mobileno = mobileno;
    }

    /**
     * @return the emailid
     */
    public String getEmailid() {
        return emailid;
    }

    /**
     * @param emailid the emailid to set
     */
    public void setEmailid(String emailid) {
        this.emailid = emailid;
    }
    
}
