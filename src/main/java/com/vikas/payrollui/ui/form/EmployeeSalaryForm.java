package com.vikas.payrollui.ui.form;

import com.vaadin.flow.component.Unit;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Hr;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.NumberField;
import org.springframework.stereotype.Component;

@Component
public class EmployeeSalaryForm extends FormLayout {

    private NumberField ctc;

    private NumberField basicPerc;
    private NumberField hraPerc;
    private NumberField conveyanceAllowancePerc;
    private NumberField fixedAllowancePerc;

    private NumberField basicMonthly;
    private NumberField hraMonthly;
    private NumberField conveyanceAllowanceMonthly;
    private NumberField fixedAllowanceMonthly;

    private NumberField basicAnnually;
    private NumberField hraAnnually;
    private NumberField conveyanceAllowanceAnnually;
    private NumberField fixedAllowanceAnnually;

    public EmployeeSalaryForm() {

        Span salaryComponentCol = new Span("Salary Components");
        Span calculationTypeCol = new Span("Calculation Type");
        Span monthlyAmountCol = new Span("Monthly Amount");
        Span annualAmountCol = new Span("Annual Amount");
        Hr hr = new Hr();

        ctc = new NumberField("Annual CTC");

        Span basicLabel = new Span("Basic");
        Span hraLabel = new Span("House Rent Allowance");
        Span conveyanceAllowanceLabel = new Span("Conveyance Allowance");
        Span fixedAllowanceLabel = new Span("Fixed Allowance");

        ctc.setPrefixComponent(new Span("₹"));
        setColspan(ctc, 4);
        ctc.setWidth(25, Unit.PERCENTAGE);

        basicPerc = new NumberField();
        hraPerc = new NumberField();
        conveyanceAllowancePerc = new NumberField();
        fixedAllowancePerc = new NumberField();

        basicPerc.setSuffixComponent(new Span("% of CTC"));
        hraPerc.setSuffixComponent(new Span("% of Basic"));

        basicMonthly = new NumberField();
        hraMonthly = new NumberField();
        conveyanceAllowanceMonthly = new NumberField();
        fixedAllowanceMonthly = new NumberField();

        basicMonthly.setReadOnly(true);
        hraMonthly.setReadOnly(true);

        basicAnnually = new NumberField();
        hraAnnually = new NumberField();
        conveyanceAllowanceAnnually = new NumberField();
        fixedAllowanceAnnually = new NumberField();

        basicAnnually.setReadOnly(true);
        hraAnnually.setReadOnly(true);
        conveyanceAllowanceAnnually.setReadOnly(true);
        fixedAllowanceAnnually.setReadOnly(true);

        setResponsiveSteps(
                // Use one column by default
                new ResponsiveStep("0", 4)
        );

        setColspan(hr, 4);

        add(ctc,
                salaryComponentCol, calculationTypeCol, monthlyAmountCol, annualAmountCol,
                hr,
                basicLabel, basicPerc, basicMonthly, basicAnnually,
                hraLabel, hraPerc, hraMonthly, hraAnnually,
                conveyanceAllowanceLabel, conveyanceAllowancePerc, conveyanceAllowanceMonthly, conveyanceAllowanceAnnually,
                fixedAllowanceLabel, fixedAllowancePerc, fixedAllowanceMonthly, fixedAllowanceAnnually
        );
    }
}
