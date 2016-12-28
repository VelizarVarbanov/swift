package personaldetails;

import address.Address;
import education.Education;
import education.GradedEducation;
import insurance.SocialInsuranceRecord;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public final class Citizen {

    private final LocalDate EARLIEST_BIRTH_DATE = LocalDate.of(1900, 1, 1);

    public String _firstName;
    public String _middleName;
    public String _lastName;

    public Gender _gender;
    public int _height;

    public LocalDate _dateOfBirth;

    public Address _address;
    public List<Education> _educations;
    public List<SocialInsuranceRecord> _socialInsuranceRecords;

    public Citizen(String firstName, String middleName, String lastName,
            Gender gender, int height, LocalDate dateOfBirth) {

        setFirstName(firstName);
        setMiddleName(middleName);
        setLastName(lastName);
        setGender(gender);
        setHeight(height);

        if (dateOfBirth == null || dateOfBirth.isBefore(EARLIEST_BIRTH_DATE) || dateOfBirth.isAfter(LocalDate.now())) {
            String message = String.format("Date of birth is expected to be after %s and before now.", EARLIEST_BIRTH_DATE);
            throw new IllegalArgumentException(message);
        }

        _dateOfBirth = dateOfBirth;

        _educations = new ArrayList<>();
        _socialInsuranceRecords = new ArrayList<>();
    }

    public short getAge() {
        return (short) _dateOfBirth.until(LocalDate.now(), ChronoUnit.YEARS);
    }

    public boolean isUnderAged() {
        return getAge() < 18;
    }

    @Override
    public String toString() {

        String heOrShe;
        String hisOrHer;

        if (_gender == Gender.Male) {
            heOrShe = "He";
            hisOrHer = "His";
        } else {
            heOrShe = "She";
            hisOrHer = "Her";
        }

        String result = String.format("%s %s %s is %d years old.", _firstName, _middleName, _lastName, getAge());
        result += String.format(" %s was born in %d.%n", heOrShe, _dateOfBirth.getYear());

        if (isUnderAged()) {
            result += String.format("%s %s %s is under-aged.%n", _firstName, _middleName, _lastName);
        }

        if (this._address != null) {
            result += String.format("%s lives at:%n%s", heOrShe, _address);
        }

        for (Education education : _educations) {
            result += String.format("%n%s started %s degree in %s on %s",
                    heOrShe, education.getDegreeById(1).toString().toLowerCase(),
                    education.getInstitutionName(), education.getEnrollmentDate());

            if (education.isGraduated()) {

                result += String.format(" and finished on %s.", education.getGraduationDate());

                if (education instanceof GradedEducation) {
                    result += String.format(" %s grade was %.3f.", hisOrHer, ((GradedEducation) education).getFinalGrade());
                }

            } else {
                result += String.format(" and is supposed to graduate on %s.", education.getGraduationDate());
            }
        }

        return result;
    }

    // Accessors
    public String getFirstName() {
        return _firstName;
    }

    public void setFirstName(String firstName) {
        if (firstName.isEmpty()) {
            throw new IllegalArgumentException("Expected non-empty first name.");
        }

        _firstName = firstName;
    }

    public String getMiddleName() {
        return _middleName;
    }

    public void setMiddleName(String middleName) {
        if (middleName.isEmpty()) {
            throw new IllegalArgumentException("Expected non-empty middle name.");
        }

        _middleName = middleName;
    }

    public String getLastName() {
        return _lastName;
    }

    public void setLastName(String lastName) {
        if (lastName.isEmpty()) {
            throw new IllegalArgumentException("Expected non-empty last name.");
        }

        _lastName = lastName;
    }

    public Gender getGender() {
        return _gender;
    }

    public void setGender(Gender gender) {
        if (gender == null) {
            throw new IllegalArgumentException("Gender should be male or female.");
        }
        _gender = gender;
    }

    public Address getAddress() {
        return _address;
    }

    public void setAddress(Address address) {
        if (address == null) {
            throw new IllegalArgumentException("Address expected.");
        }
        _address = address;
    }

    public LocalDate getDateOfBirth() {
        return _dateOfBirth;
    }

    public int getHeight() {
        return _height;
    }

    public void setHeight(int height) {
        if (!(40 < height && height < 350)) {
            throw new IllegalArgumentException("Height is expected to be between 40 and 350 cm.");
        }
        _height = height;
    }

    public void addEducation(Education education) {
        _educations.add(education);
    }

    public List<Education> getEducations() {
        return _educations;
    }

    public List<SocialInsuranceRecord> getSocialInsuranceRecords() {
        return _socialInsuranceRecords;
    }

    public void addSocialInsuranceRecord(SocialInsuranceRecord record) {
        _socialInsuranceRecords.add(record);
    }
}
