package objectRepository;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OR_LandingPage {

	public WebDriver driver;

	public OR_LandingPage(WebDriver driver) {

		this.driver = driver;
	}

	By fromMenu = By.id("hp-widget__sfrom");
	By toMenu = By.id("hp-widget__sTo");

	By fromMenuItem = By.cssSelector(
			"ul.ui-autocomplete.ui-front.ui-menu.ui-widget.ui-widget-content.hp-widget__sfrom");

	By toMenuItem = By
			.cssSelector("ul.ui-autocomplete.ui-front.ui-menu.ui-widget.ui-widget-content.hp-widget__sTo");
	By searchButton = By.id("searchBtn");

	public WebElement getfromMenuText() {

		return driver.findElement(fromMenu);
	}

	public WebElement gettoMenuText() {

		return driver.findElement(toMenu);
	}

	public WebElement getfromMenuItem(String selectedItemLabel) {

		List<WebElement> a = driver.findElement(fromMenuItem).findElements(By.className("ui-menu-item"));
		int count = a.size();

		WebElement menuItem = null;

		for (int i = 0; i < count; i++) {
			WebElement menuItems = a.get(i);
			String label = menuItems.getAttribute("aria-label");
			
			String[] labelFull = label.split(":");
			String menuItemLabel = labelFull[1].trim();
			

			if (menuItemLabel.equals(selectedItemLabel)) {
				menuItem = menuItems;
				break;
			}

		}

		return menuItem;

	}

	public WebElement gettoMenuItem(String selectedItemLabel) {

		List<WebElement> a = driver.findElement(toMenuItem).findElements(By.className("ui-menu-item"));
		int count = a.size();

		WebElement menuItem = null;
		

		for (int i = 0; i < count; i++) {
			WebElement menuItems = a.get(i);
			String label = menuItems.getAttribute("aria-label");
			
			String[] labelFull = label.split(":");
			String menuItemLabel = labelFull[1].trim();
			

			if (menuItemLabel.equals(selectedItemLabel)) {
				menuItem = menuItems;
				break;
			}

		}

		return menuItem;

	}

	public WebElement getSearchButton() {

		return driver.findElement(searchButton);
	}

}
