package org.fundacionjala.calculator.pages;

import org.fundacionjala.core.ui.AbstractPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.stereotype.Component;

/** This class represents the response page. **/
@Component
public class ResponsePage extends AbstractPage {

    @FindBy(css = "#hello-response")
    private WebElement helloResponse;

    /**
     * This method get the text in the response page.
     *
     * @return hello response.
     */
    public String getTextHello() {
        return this.action.getValue(this.helloResponse);
    }

}
