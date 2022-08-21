package com.vikas.payrollui.ui.form;

import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.select.Select;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.TextField;
import org.springframework.stereotype.Component;

@Component
public class EmployeeBasicForm extends FormLayout {


    private TextField firstName;
    private TextField middleName;
    private TextField lastName;
    private TextField employeeId;
    private Select<String> gender;
    private DatePicker joiningDate;
    private Select<String> designation;
    private EmailField workEmail;
    private Select<String> department;
    private Select<String> workLocation;

    public EmployeeBasicForm() {
        firstName = new TextField("Employee Name", "First Name");
        middleName = new TextField("", "Middle Name");
        lastName = new TextField("", "Last Name");

        employeeId = new TextField("Employee ID");
        gender = new Select<String>("Male", "Female", "Other");
        gender.setLabel("Gender");
        gender.setEmptySelectionAllowed(true);

        joiningDate = new DatePicker("Joining Date");
        designation = new Select<>();
        designation.setLabel("Designation");

        workEmail = new EmailField("Work Email");
        department = new Select<>();
        department.setLabel("Department");

        workLocation = new Select<>();
        workLocation.setLabel("Work Location");

        setResponsiveSteps(
                // Use one column by default
                new ResponsiveStep("0", 1),
                // Use two columns, if layout's width exceeds 500px
                new ResponsiveStep("500px", 2)
        );

        setColspan(workLocation, 2);

        add(firstName, lastName,
                employeeId, gender,
                joiningDate, designation,
                workEmail, department,
                workLocation
        );

        setMandatoryFields();
    }

    private void setMandatoryFields(){
        firstName.setRequired(true);
        lastName.setRequired(true);
        employeeId.setRequired(true);
//        gender.setRequired(true);
        joiningDate.setRequired(true);
//        designation.setRequired(true);
//        workEmail.setRequired(true);
//        department.setRequired(true);
//        workLocation.setRequired(true);

    }
}
