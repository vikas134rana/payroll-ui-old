package com.vikas.payrollui.ui;

import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route(value = "", layout = MainLayout.class)
public class HomeView extends VerticalLayout {

    public HomeView() {
        add(new Span("Home View"));
    }
}
