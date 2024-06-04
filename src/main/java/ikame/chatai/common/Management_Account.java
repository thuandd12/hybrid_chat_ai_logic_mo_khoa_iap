package ikame.chatai.common;

import ikame.chatai.ui.PageUI_ChatAI;
import io.appium.java_client.AppiumDriver;

public class Management_Account extends commonBase {
	public Management_Account(AppiumDriver dr) {
		driver = dr;
	}
	public void openHomePageWithLanguage(String language) {
		pause(7000);
		clickElementIfDisplay(PageUI_ChatAI.BTN_CONTINUE);
		clickElementIfDisplay(PageUI_ChatAI.BTN_SKIP);
		String chooseLanguage = parseStringToObject(PageUI_ChatAI.OPTION_LANGUAGE, language);
		if (language.equalsIgnoreCase("English")) {
			getElementPresent(chooseLanguage);
		} else {
			click(chooseLanguage);
		}
		click(PageUI_ChatAI.BTN_DONE_LANGUAGE);
	}
	public void clickOptionButtonAssistant( String nameButton) {
		String optionButton = parseStringToObject(PageUI_ChatAI.BTN_IN_ASSISTANT, nameButton);
		scrollToElementWithTouchAction(optionButton,"E", 0.5, 0.2,8,2400,230);
		click(optionButton);
	}
	public void checkButtonAssistant( String nameButton) {
		String optionButton = parseStringToObject(PageUI_ChatAI.BTN_IN_ASSISTANT, nameButton);
		getElementPresent(optionButton);
	}
	public void chooseOptionUtilitiesAssistant( String value) {
		String optionButton = parseStringToObject(PageUI_ChatAI.OPTION_UTILITIES, value);
		scrollToElementUsingTouchAction(optionButton);
		click(optionButton);
	}
	public void checkUIUtilitiesAssistant( ) {
		getElementPresent(PageUI_ChatAI.TITLE_UTINITIES);
		getElementPresent(PageUI_ChatAI.LIST_TEXTBOX);
		getElementPresent(PageUI_ChatAI.BUTTON_CONTINUE);
	}
	public void checkUIUtilitiesAssistantNoTextbox( ) {
		getElementPresent(PageUI_ChatAI.TITLE_UTINITIES);
		getElementPresent(PageUI_ChatAI.BUTTON_CONTINUE);
	}
	public void checkContentUtilitiesAssistant() {
		getElementPresent(PageUI_ChatAI.LIST_ICON);
		getElementPresent(PageUI_ChatAI.LIST_TITLE_UTILITIES);
		getElementPresent(PageUI_ChatAI.LIST_DESCRIBE_UTILITIES);
	}
	public void checkContentScreenUtilitiesAssistant() {
		getElementPresent(PageUI_ChatAI.LIST_ICON);
		getElementPresent(PageUI_ChatAI.LIST_NAME_UTILITIES);
		getElementPresent(PageUI_ChatAI.LIST_DESCRIBE_UTILITIES);
	}
}
