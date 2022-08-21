package com.vikas.payrollui.ui;

import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.RouterLink;

public class MainLayout extends AppLayout {

    public MainLayout() {
        createHeader();
        createDrawer();
    }

    private void createHeader() {
        H3 logo = new H3("Payroll");
        HorizontalLayout header = new HorizontalLayout(logo);
        header.addClassName("header");
        addToNavbar(header);
    }

    private void createDrawer() {
        RouterLink homeLink = new RouterLink("Home", HomeView.class);
        RouterLink payslipLink = new RouterLink("Payslip", PaySlipsView.class);
        RouterLink employeeLink = new RouterLink("Employee", EmployeeView.class);
        VerticalLayout drawer = new VerticalLayout(homeLink, payslipLink, employeeLink);
        drawer.addClassName("drawer");
        addToDrawer(drawer);
    }
}
