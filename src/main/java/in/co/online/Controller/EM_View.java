package in.co.online.Controller;

public interface EM_View {

	public String APP_CONTEXT = "/Event_Management";
	public String PAGE_FOLDER = "/jsp";

	// Controller---------------------
	public String WELCOME_CTL = APP_CONTEXT + "/welcome";
	public String LOGIN_CTL = APP_CONTEXT + "/login";
	public String ROLE_CTL = APP_CONTEXT + "/role";
	public String REGISTRATION_CTL = APP_CONTEXT + "/register";
	public String USERLIST_CTL = APP_CONTEXT + "/userlist";
	public String ABOUT_CTL = APP_CONTEXT + "/about";
	public String EVENT_TYPE_CTL = APP_CONTEXT + "/eventtype";
	public String EVENT_LIST_CTL = APP_CONTEXT + "/eventlist";
	public String VENUE_CTL = APP_CONTEXT + "/venue";
	public String IMAGE_CTL = APP_CONTEXT + "/image";
	public String BOOKING_CTL = APP_CONTEXT + "/booking";
	public String PAYMENT_CTL = APP_CONTEXT + "/payment";
	public String PAYMENT_LIST_CTL = APP_CONTEXT + "/paymentlist";
	public String VENUE_LIST_CTL = APP_CONTEXT + "/venuelist";
	public String MYPROFILE_CTL = APP_CONTEXT + "/myprofile";
	public String CONTACT_CTL = APP_CONTEXT +  "/contact";


	// View-----------------------------
	public String WELCOME_VIEW = PAGE_FOLDER + "/WelcomeView.jsp";
	public String LOGIN_VIEW = PAGE_FOLDER + "/LoginView.jsp";
	public String ROLE_VIEW = PAGE_FOLDER + "/RoleView.jsp";
	public String REGISTRATION__VIEW = PAGE_FOLDER + "/RegistrationView.jsp";
	public String USERLIST_VIEW = PAGE_FOLDER + "/UserListView.jsp";
	public String ABOUT_VIEW = PAGE_FOLDER + "/AboutView.jsp";
	public String EVENT_TYPE_VIEW = PAGE_FOLDER + "/EventTypeView.jsp";
	public String EVENT_LIST_VIEW = PAGE_FOLDER + "/EventTypeListView.jsp";
	public String VENUE_VIEW = PAGE_FOLDER + "/VenueView.jsp";
	public String BOOKING_VIEW = PAGE_FOLDER + "/BookingView.jsp";
	public String PAYMENT_VIEW = PAGE_FOLDER + "/PaymentView.jsp";
	public String PAYMENT_LIST_VIEW = PAGE_FOLDER + "/PaymentListView.jsp";
	public String VENUE_LIST_VIEW = PAGE_FOLDER + "/VenuListView.jsp";
	public String MYPROFILE_VIEW = PAGE_FOLDER + "/MyProfileView.jsp";
	public String CONTACT_VIEW = PAGE_FOLDER + "/ContactView.jsp";



}
