
package citizenstoragemanagercli;

import address.Address;
import contracts.DALException;
import education.EducationDegree;
import education.HigherEducation;
import education.PrimaryEducation;
import education.SecondaryEducation;
import insurance.SocialInsuranceRecord;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import mysql.MySqlAddressStorage;
import mysql.MySqlEducationStorage;
import mysql.MySqlInsuranceStoragem;
import mysql.MySqlPersonalStorage;
import personaldetails.Citizen;
import personaldetails.Gender;

public class CitizenStorageManagerCLI {

    public static void main(String[] args) throws DALException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();
        MySqlAddressStorage addressStor = new MySqlAddressStorage();
        addressStor.trancateTable();
        
        MySqlPersonalStorage personStor = new MySqlPersonalStorage();
        personStor.trancateTable();
        
        MySqlEducationStorage education = new MySqlEducationStorage();
        education.trancateTable();
        education.trancateTableEducation();
        
        MySqlInsuranceStoragem insuranceStor = new MySqlInsuranceStoragem();
        insuranceStor.trancateTable();
        for(int i = 0; i < N; i++){
            String personalInfo = sc.nextLine();
            String insurance = sc.nextLine();
            String[] personSplit = personalInfo.split(";");
            String[] insuranceSplit = insurance.split(";");
                
//address
            
            Address address = null;
            if(personSplit.length > 12){
                if(personSplit[12].equals("")){
                    address = new Address(personSplit[6], personSplit[7], personSplit[8], personSplit[9], personSplit[10], personSplit[11], 0, 0);            
                
                } else {
                    address = new Address(personSplit[6], personSplit[7], personSplit[8], personSplit[9], personSplit[10], personSplit[11], Integer.parseInt(personSplit[12]), Integer.parseInt(personSplit[13]));
                }
            } else {
                address = new Address(personSplit[6], personSplit[7], personSplit[8], personSplit[9], personSplit[10], personSplit[11], 0, 0);
            }
            
            addressStor.insertaddress(address);

//citizen
            Gender gender = null;
            
            if(personSplit[3].equalsIgnoreCase("M")){ 
                gender = Gender.Male;
            } else {
                gender = Gender.Female;
            }
            Citizen citizen = new Citizen(personSplit[0],personSplit[1],personSplit[2],gender,Integer.parseInt(personSplit[5]), convertToDate(personSplit[4]));
            personStor.insertCitizen(citizen, addressStor.addresses_id);

//education
            
            education.insertDegree("p");
            if(personSplit.length > 15) {
                PrimaryEducation primary = new PrimaryEducation(personSplit[15],convertToDate(personSplit[16]),convertToDate(personSplit[17]));
                education.insertEducation(primary, personStor.person_id);
            }
            SecondaryEducation secondary = null;
            if(personSplit.length > 18) {
                education.insertDegree(personSplit[18]);
                secondary = new SecondaryEducation(personSplit[19], convertToDate(personSplit[20]), convertToDate(personSplit[21]));
                if(!secondary.graduationDate.isAfter(LocalDate.now())){
                    secondary.gotGraduated(Float.parseFloat(personSplit[22]));
                }
                education.insertEducation(secondary, personStor.person_id);
            }  
            
            HigherEducation higher = null;            
            if(personSplit.length > 23) {
                education.insertDegree(personSplit[23]);
                higher = new HigherEducation(personSplit[24], convertToDate(personSplit[25]), convertToDate(personSplit[26]), EducationDegree.Bachelor);    
                if(!higher.graduationDate.isAfter(LocalDate.now())){
                    higher.gotGraduated(Float.parseFloat(personSplit[27]));
                }
                education.insertEducation(higher, personStor.person_id);
            }
            if(personSplit.length > 28) {
                education.insertDegree(personSplit[28]);
                higher = new HigherEducation(personSplit[29], convertToDate(personSplit[30]), convertToDate(personSplit[31]), EducationDegree.Bachelor);    
                if(!higher.graduationDate.isAfter(LocalDate.now())){
                    higher.gotGraduated(Float.parseFloat(personSplit[32]));
                }
                education.insertEducation(higher, personStor.person_id);
            }
            if(personSplit.length > 33) {
                education.insertDegree(personSplit[33]);
                higher = new HigherEducation(personSplit[34], convertToDate(personSplit[35]), convertToDate(personSplit[36]), EducationDegree.Bachelor);    
                if(!higher.graduationDate.isAfter(LocalDate.now())){
                    higher.gotGraduated(Float.parseFloat(personSplit[37]));
                }
                education.insertEducation(higher, personStor.person_id);
            }
            if(personSplit.length > 38) {
                education.insertDegree(personSplit[38]);
                higher = new HigherEducation(personSplit[39], convertToDate(personSplit[40]), convertToDate(personSplit[41]), EducationDegree.Bachelor);    
                if(!higher.graduationDate.isAfter(LocalDate.now())){
                    higher.gotGraduated(Float.parseFloat(personSplit[42]));
                }
                education.insertEducation(higher, personStor.person_id);
            }
            
//insurance
            
            int index =0;
            for(int y = 0; y < insuranceSplit.length/3; y++){    
                SocialInsuranceRecord insuranceRecord = new SocialInsuranceRecord(Integer.parseInt(insuranceSplit[0+index]), Integer.parseInt(insuranceSplit[1+index]), Double.parseDouble(insuranceSplit[2+index]));
                insuranceStor.insertInsurance(insuranceRecord, personStor.person_id);
                index += 3;
            }
        }
    }    
    private static LocalDate convertToDate(String date) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("d.M.yyyy");
        LocalDate dt = LocalDate.parse(date,dtf);
        return dt;
    }
}
