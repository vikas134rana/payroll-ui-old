package com.vikas.payrollui.ui;

import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route(value = "payslip", layout = MainLayout.class)
public class PaySlipsView extends VerticalLayout {

    public PaySlipsView() {
        add(new Span("Payslip View"));
    }
}
