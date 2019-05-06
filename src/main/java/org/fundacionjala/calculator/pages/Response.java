package org.fundacionjala.calculator.pages;

import org.fundacionjala.core.ui.AbstractPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.stereotype.Component;

/** This class represents the response page. **/
@Component
public class Response extends AbstractPage {
	
    @FindBy(css = "#credentials_username")
    private WebElement userNameTextField;
	
    /**
     * This method add one value of username text field .
     *
     * @param strUserName value of input.
     */
    public void setUserNameTextField(final String strUserName) {
        this.action.setValue(this.userNameTextField, strUserName);
    }
	
}
