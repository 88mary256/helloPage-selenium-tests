package org.fundacionjala.calculator.pages;

import org.fundacionjala.core.ui.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.stereotype.Component;

/** This class represents the home page. **/
@Component
public class HelloPage extends AbstractPage {

    @FindBy(css = "#say-hello-text-input")
    private WebElement name;

    @FindBy(css = "#say-hello-button")
    private WebElement sayHelloButton;

    /** Clicks the sayHello button. */
    public void clickSayHelloButton() {
        this.action.click(this.sayHelloButton);
    }

    /**
     * This method set a newName in the input name.
     *
     * @param newName String name to say hello.
     **/
    public void setName(final String newName) {
        this.action.setValue(this.name, newName);
    }

    public boolean isInputNamePresent() {
        return this.action.isExistingSelector(
                By.cssSelector("#say-hello-text-input"));
    }
}
