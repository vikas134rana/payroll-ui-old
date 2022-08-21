package com.vikas.payrollui.ui.form;

import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.component.textfield.TextField;
import org.springframework.stereotype.Component;

@Component
public class EmployeePaymentForm extends FormLayout {

    private TextField accountHolderName;
    private TextField bankName;
    private NumberField accountNumber;
    private NumberField reenterAccountNumber;
    private TextField ifsc;

    public EmployeePaymentForm() {
        accountHolderName = new TextField("Account Holder Name");
        bankName = new TextField("Bank name");
        accountNumber = new NumberField("Account Number");
        reenterAccountNumber = new NumberField("Re-enter Account Number");
        ifsc = new TextField("IFSC");

        setColspan(accountHolderName, 2);
        setColspan(bankName, 2);

        add(accountHolderName,
                bankName,
                accountNumber, reenterAccountNumber,
                ifsc);
    }
}
