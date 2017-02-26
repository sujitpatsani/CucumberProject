package utill;

public class AllPages {

	private static AllPages getThis() {
		return new AllPages();
	}

	protected HomePage gotoHomePage() {

		HomePage page = (HomePage) PageFactory.pages(PAGE.HOMEPAGE);

		return page;
	}

	
}
