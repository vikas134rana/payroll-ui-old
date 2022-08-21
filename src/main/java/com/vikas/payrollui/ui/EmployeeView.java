package com.vikas.payrollui.ui;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Unit;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.html.H4;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.Tabs;
import com.vaadin.flow.component.tabs.TabsVariant;
import com.vaadin.flow.router.Route;
import com.vikas.payrollui.ui.form.EmployeeBasicForm;
import com.vikas.payrollui.ui.form.EmployeePaymentForm;
import com.vikas.payrollui.ui.form.EmployeePersonalForm;
import com.vikas.payrollui.ui.form.EmployeeSalaryForm;

@org.springframework.stereotype.Component
@Route(value = "employee", layout = MainLayout.class)
public class EmployeeView extends VerticalLayout {

    private Tabs tabs;
    private Tab employeeBasicTab;
    private Tab employeeSalaryTab;
    private Tab employeePersonalTab;
    private Tab employeePaymentTab;

    private VerticalLayout content;

    public EmployeeView() {
        setEmployeeForm();
    }

    private void setEmployeeForm() {
        VerticalLayout employeeFormLayout = new VerticalLayout();
        VerticalLayout heading = new VerticalLayout(new H4("Add Employee"));
        heading.setAlignItems(Alignment.CENTER);
        content = new VerticalLayout();
        content.getStyle().set("border", "1px solid rgb(227, 230, 232)");
        employeeFormLayout.setAlignItems(Alignment.CENTER);
        employeeFormLayout.add(heading, tabs(), content, buttons());
        employeeFormLayout.setWidth(80, Unit.PERCENTAGE);
        add(employeeFormLayout);
        setAlignItems(Alignment.CENTER);
        employeeFormLayout.getStyle().set("border", "1px solid rgb(227, 230, 232)");
        getStyle().set("border", "1px solid rgb(227, 230, 232)");
    }

    private Component tabs() {

        employeeBasicTab = new Tab("Basics");
        employeeSalaryTab = new Tab("Salary Details");
        employeePersonalTab = new Tab("Personal Info");
        employeePaymentTab = new Tab("Payment Info");

        tabs = new Tabs();
        tabs.add(employeeBasicTab, employeeSalaryTab, employeePersonalTab, employeePaymentTab);
        tabs.setWidthFull();
        tabs.addThemeVariants(TabsVariant.LUMO_EQUAL_WIDTH_TABS);

        tabs.addSelectedChangeListener(event -> setTabContent(event.getSelectedTab()));
        setTabContent(tabs.getSelectedTab());

        return tabs;
    }

    private void setTabContent(Tab selectedTab) {

        // enable selected tab only and disable other tabs
        tabs.getChildren().forEach(tab -> {
            if(tab instanceof Tab &&  tab != selectedTab)
                ((Tab)tab).setEnabled(false);
        });

        content.removeAll();

        if (selectedTab == employeeBasicTab) {
            content.add(new EmployeeBasicForm());
            content.setWidth(70, Unit.PERCENTAGE);
        } else if (selectedTab == employeeSalaryTab) {
            content.add(new EmployeeSalaryForm());
            content.setWidth(90, Unit.PERCENTAGE);
        } else if (selectedTab == employeePersonalTab) {
            content.add(new EmployeePersonalForm());
            content.setWidth(70, Unit.PERCENTAGE);
        } else if (selectedTab == employeePaymentTab) {
            content.add(new EmployeePaymentForm());
            content.setWidth(70, Unit.PERCENTAGE);
        }
    }

    private Component buttons() {
        Button saveAndContinue = new Button("Save and Continue");
        saveAndContinue.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        saveAndContinue.addClickListener(event -> {
            // Go to next tab
            int selectedTabIndex = tabs.getSelectedIndex();
            if (selectedTabIndex != tabs.getComponentCount() - 1) {
                Tab nextTab = (Tab) tabs.getComponentAt(selectedTabIndex + 1);
                nextTab.setEnabled(true);
                tabs.setSelectedTab(nextTab);
            }
        });

        Button cancel = new Button("Cancel");
        cancel.addThemeVariants(ButtonVariant.LUMO_PRIMARY, ButtonVariant.LUMO_ERROR);
        cancel.addClickListener(event -> {
        });

        HorizontalLayout buttons = new HorizontalLayout(saveAndContinue, cancel);
        buttons.setAlignItems(Alignment.START);

        return buttons;
    }
}
