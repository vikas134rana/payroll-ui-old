package com.vikas.payrollui.ui.form;

import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.select.Select;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.component.textfield.TextField;
import org.springframework.stereotype.Component;

@Component
public class EmployeePersonalForm extends FormLayout {

    private EmailField personalEmail;
    private TextField mobile;
    private DatePicker dob;
    private NumberField age;
    private TextField fatherName;
    private TextField pan;
    private TextField address1;
    private TextField address2;
    private TextField city;
    private Select<String> state;
    private NumberField pin;

    public EmployeePersonalForm() {

        personalEmail = new EmailField("Personal Email Address");
        mobile = new TextField("Mobile Number");

        dob = new DatePicker("Date of Birth");
        age = new NumberField("Age");

        fatherName = new TextField("Father Name");
        pan = new TextField("PAN");

        address1 = new TextField("Residential Address");
        address1.setPlaceholder("Address1");

        address2 = new TextField();
        address2.setPlaceholder("Address2");

        city = new TextField();
        city.setPlaceholder("City");
        state = new Select<>("Uttarakhand", "Uttar Pradesh");
        state.setPlaceholder("State");
        pin = new NumberField();
        pin.setPlaceholder("PIN Code");

        setColspan(address1, 2);
        setColspan(address2, 2);

        add(personalEmail, mobile,
                dob, age,
                fatherName, pan,
                address1,
                address2,
                city, state, pin);

    }
}
