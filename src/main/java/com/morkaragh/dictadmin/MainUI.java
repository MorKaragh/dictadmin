package com.morkaragh.dictadmin;


import com.morkaragh.dictadmin.ui.components.AppNav;
import com.morkaragh.dictadmin.ui.components.AppNavItem;
import com.morkaragh.dictadmin.ui.view.ManageView;
import com.morkaragh.dictadmin.ui.view.TableView;
import com.morkaragh.dictadmin.user.UserService;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.html.Footer;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Header;
import com.vaadin.flow.component.orderedlayout.Scroller;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.theme.lumo.LumoUtility;
import org.vaadin.lineawesome.LineAwesomeIcon;

public class MainUI extends AppLayout {

    private H2 viewTitle;

    private final UserService userService;

    public MainUI(UserService userService) {
        this.userService = userService;
        setPrimarySection(Section.DRAWER);
        addDrawerContent();
        addHeaderContent();
    }

    private void addHeaderContent() {
        DrawerToggle toggle = new DrawerToggle();
        toggle.getElement().setAttribute("aria-label", "Menu toggle");
        viewTitle = new H2();
        viewTitle.addClassNames(LumoUtility.FontSize.LARGE, LumoUtility.Margin.NONE);
        addToNavbar(true, toggle, viewTitle);
    }

    private void addDrawerContent() {
        H1 appName = new H1("Ay-Man");
        appName.getStyle().set("text-align", "center")
                .set("color", "firebrick")
                .set("font-family", "math");

        appName.addClassNames(LumoUtility.FontSize.LARGE, LumoUtility.Margin.NONE);
        Header header = new Header(appName);

        Scroller scroller = new Scroller(createNavigation());

        addToDrawer(header, scroller, createFooter());
    }

    private AppNav createNavigation() {
        // AppNav is not an official component.
        // For documentation, visit https://github.com/vaadin/vcf-nav#readme
        // Starting with v24.1, AppNav will be replaced with the official
        // SideNav component.
        AppNav nav = new AppNav();

        nav.addItem(new AppNavItem("Обяз. программы NBO", TableView.class, LineAwesomeIcon.TABLE_SOLID.create()));
        nav.addItem(new AppNavItem("Профиль (" + userService.getUser().getShortName() + ")", ManageView.class, LineAwesomeIcon.ADDRESS_BOOK.create()));

        return nav;
    }

    private Footer createFooter() {
        Footer layout = new Footer();
        layout.add(userService.getUser().getFullName());
        return layout;
    }

    @Override
    protected void afterNavigation() {
        super.afterNavigation();
        viewTitle.setText(getCurrentPageTitle());
    }

    private String getCurrentPageTitle() {
        PageTitle title = getContent().getClass().getAnnotation(PageTitle.class);
        return title == null ? "" : title.value();
    }
}
