package ikame.chatai.testsuite;

import static ikame.chatai.common.TestLogger.info;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import ikame.chatai.common.Management_Account;
import ikame.chatai.common.commonBase;
import ikame.chatai.ui.PageUI_ChatAI;

public final class TS_02_Logic_Chat_AI_Midj_Art extends commonBase {

	@BeforeMethod
	public void init() {
		driver = initDriverTest("ChatAI.apk", "emulator-5554", "Android", "12.0", "com.begamob.chatgpt_openai",
				"com.begamob.chatgpt_openai.feature.splash.SplashActivity", "windows", "8201");
		managementAccount = new Management_Account(driver);
	}

	@AfterMethod
	public void after() {
		quitDriver(driver);
	}
	
	@Test
	public void TS_001_Logic_Midj_Art_Generate_Art() {
		info("Open app");
		managementAccount.openHomePageWithLanguage("English");
		click(PageUI_ChatAI.TEXT_MIDJ_ART);
		click(PageUI_ChatAI.TAB_GENERATE_ART);
		getElementPresent(PageUI_ChatAI.TAB_WALLPAPERS);
		getElementPresent(PageUI_ChatAI.TEXT_ENTER_YOUR_PROMPT);
		getElementPresent(PageUI_ChatAI.BTN_GET_INSPIRED);
		getElementPresent(PageUI_ChatAI.TEXTBOX_PROMPT);
		getElementPresent(PageUI_ChatAI.BTN_ADVANCED);
		getElementPresent(PageUI_ChatAI.BTN_PRIMARY);
		getElementPresent(PageUI_ChatAI.TEXT_CHOOSE_VERSION);
		getElementPresent(PageUI_ChatAI.TEXT_CHOOSE_MODEL);
		getElementPresent(PageUI_ChatAI.DROPDOWNLIST_CHOOSE_MODEL);
		getElementPresent(PageUI_ChatAI.TEXT_ADVANCED_SETTING);
		getElementPresent(PageUI_ChatAI.DROPDOWNLIST_CHOOSE_SETTING);
		getElementPresent(PageUI_ChatAI.TEXT_CHOOSE_AN_ART_STYLE);
		getElementPresent(PageUI_ChatAI.TEXT_MORE);
		getElementPresent(PageUI_ChatAI.BTN_GENERATE);
	}
	
	@Test
	public void TS_002_Logic_Midj_Art_Generate_Art_Advanced_Khong_Nhap_Prompt() {
		info("Open app");
		managementAccount.openHomePageWithLanguage("English");
		click(PageUI_ChatAI.TEXT_MIDJ_ART);
		click(PageUI_ChatAI.TAB_GENERATE_ART);
		click(PageUI_ChatAI.BTN_ADVANCED);
		click(PageUI_ChatAI.BTN_GENERATE);
		getElementPresent(PageUI_ChatAI.TAB_WALLPAPERS);
		getElementPresent(PageUI_ChatAI.TEXT_ENTER_YOUR_PROMPT);
		getElementPresent(PageUI_ChatAI.BTN_GET_INSPIRED);
		getElementPresent(PageUI_ChatAI.TEXTBOX_PROMPT);
		getElementPresent(PageUI_ChatAI.BTN_ADVANCED);
		getElementPresent(PageUI_ChatAI.BTN_PRIMARY);
		getElementPresent(PageUI_ChatAI.TEXT_CHOOSE_VERSION);
		getElementPresent(PageUI_ChatAI.TEXT_CHOOSE_MODEL);
		getElementPresent(PageUI_ChatAI.DROPDOWNLIST_CHOOSE_MODEL);
		getElementPresent(PageUI_ChatAI.TEXT_ADVANCED_SETTING);
		getElementPresent(PageUI_ChatAI.DROPDOWNLIST_CHOOSE_SETTING);
		getElementPresent(PageUI_ChatAI.TEXT_CHOOSE_AN_ART_STYLE);
		getElementPresent(PageUI_ChatAI.TEXT_MORE);
		getElementPresent(PageUI_ChatAI.BTN_GENERATE);
		
	}
	@Test
	public void TS_003_Logic_Midj_Art_Generate_Art_Advanced_Nhap_10000_Ky_Tu() {
		info("Open app");
		managementAccount.openHomePageWithLanguage("English");
		click(PageUI_ChatAI.TEXT_MIDJ_ART);
		click(PageUI_ChatAI.TAB_GENERATE_ART);
		click(PageUI_ChatAI.BTN_ADVANCED);
		sendKeyToElement(PageUI_ChatAI.TEXTBOX_PROMPT, generateRandomString(10000));
		String textPrompt = getText(PageUI_ChatAI.TEXTBOX_PROMPT);
		scrollDown(2);
		click(PageUI_ChatAI.BLOCK_AMAZONIAN);
		String artStyle = getText(PageUI_ChatAI.BLOCK_AMAZONIAN);
		click(PageUI_ChatAI.BTN_GENERATE);
		pause(10000);
		getElementPresent(PageUI_ChatAI.TEXT_WATERMARK);
		getElementPresent(PageUI_ChatAI.SWITCH_WATERMARK);
		getElementPresent(PageUI_ChatAI.IMG_RESULT_ART);
		verifyCompare(textPrompt, getText(PageUI_ChatAI.TEXT_RESULT_PROMPT));
		verifyCompare(artStyle, getText(PageUI_ChatAI.TEXT_RESULT_STYLE));
		getElementPresent(PageUI_ChatAI.BUTTON_REGENERATE);
		getElementPresent(PageUI_ChatAI.BTN_IMG);
		getElementPresent(PageUI_ChatAI.BTN_SHARE);
	}
	@Test
	public void TS_004_Logic_Midj_Art_Generate_Art_Advanced_Nhap_Ky_Tu_Hop_Le() {
		info("Open app");
		managementAccount.openHomePageWithLanguage("English");
		click(PageUI_ChatAI.TEXT_MIDJ_ART);
		click(PageUI_ChatAI.TAB_GENERATE_ART);
		sendKeyToElement(PageUI_ChatAI.TEXTBOX_PROMPT,"flower");
		scrollDown(2);
		click(PageUI_ChatAI.BLOCK_ABSTRACT_VIBRANT);
		String artStyle = getText(PageUI_ChatAI.BLOCK_ABSTRACT_VIBRANT);
		click(PageUI_ChatAI.BTN_GENERATE);
		pause(10000);
		getElementPresent(PageUI_ChatAI.TEXT_WATERMARK);
		getElementPresent(PageUI_ChatAI.SWITCH_WATERMARK);
		getElementPresent(PageUI_ChatAI.IMG_RESULT_ART);
		verifyCompare("flower", getText(PageUI_ChatAI.TEXT_RESULT_PROMPT));
		verifyCompare(artStyle, getText(PageUI_ChatAI.TEXT_RESULT_STYLE));
		getElementPresent(PageUI_ChatAI.BUTTON_REGENERATE);
		getElementPresent(PageUI_ChatAI.BTN_IMG);
		getElementPresent(PageUI_ChatAI.BTN_SHARE);
	}
	@Test
	public void TS_005_Logic_Midj_Art_Generate_Art_Advanced_Get_Inspired() {
		info("Open app");
		managementAccount.openHomePageWithLanguage("English");
		click(PageUI_ChatAI.TEXT_MIDJ_ART);
		click(PageUI_ChatAI.TAB_GENERATE_ART);
		click(PageUI_ChatAI.BTN_GET_INSPIRED);
		String textPrompt = getText(PageUI_ChatAI.TEXTBOX_PROMPT);
		scrollDown(2);
		click(PageUI_ChatAI.BLOCK_AMAZONIAN);
		String artStyle = getText(PageUI_ChatAI.BLOCK_AMAZONIAN);
		click(PageUI_ChatAI.BTN_GENERATE);
		pause(10000);
		getElementPresent(PageUI_ChatAI.TEXT_WATERMARK);
		getElementPresent(PageUI_ChatAI.SWITCH_WATERMARK);
		getElementPresent(PageUI_ChatAI.IMG_RESULT_ART);
		verifyCompare(textPrompt, getText(PageUI_ChatAI.TEXT_RESULT_PROMPT));
		verifyCompare(artStyle, getText(PageUI_ChatAI.TEXT_RESULT_STYLE));
		getElementPresent(PageUI_ChatAI.BUTTON_REGENERATE);
		getElementPresent(PageUI_ChatAI.BTN_IMG);
		getElementPresent(PageUI_ChatAI.BTN_SHARE);
	}
	@Test
	public void TS_006_Logic_Midj_Art_Generate_Art_Advanced_Choose_Model_1() {
		info("Open app");
		managementAccount.openHomePageWithLanguage("English");
		click(PageUI_ChatAI.TEXT_MIDJ_ART);
		click(PageUI_ChatAI.TAB_GENERATE_ART);
		sendKeyToElement(PageUI_ChatAI.TEXTBOX_PROMPT,"flower");
		click(PageUI_ChatAI.DROPDOWNLIST_CHOOSE_MODEL);
		String nameArt = getText(parseStringToObject(PageUI_ChatAI.TEXT_NAME_ART, "1"));
		click(parseStringToObject(PageUI_ChatAI.TEXT_NAME_ART, "1"));
		verifyCompare(nameArt, getText(PageUI_ChatAI.DROPDOWNLIST_CHOOSE_MODEL));
		scrollDown(2);
		click(PageUI_ChatAI.BLOCK_AMAZONIAN);
		String artStyle = getText(PageUI_ChatAI.BLOCK_AMAZONIAN);
		click(PageUI_ChatAI.BTN_GENERATE);
		pause(10000);
		getElementPresent(PageUI_ChatAI.TEXT_WATERMARK);
		getElementPresent(PageUI_ChatAI.SWITCH_WATERMARK);
		getElementPresent(PageUI_ChatAI.IMG_RESULT_ART);
		verifyCompare("flower", getText(PageUI_ChatAI.TEXT_RESULT_PROMPT));
		verifyCompare(artStyle, getText(PageUI_ChatAI.TEXT_RESULT_STYLE));
		getElementPresent(PageUI_ChatAI.BUTTON_REGENERATE);
		getElementPresent(PageUI_ChatAI.BTN_IMG);
		getElementPresent(PageUI_ChatAI.BTN_SHARE);
	}
	@Test
	public void TS_007_Logic_Midj_Art_Generate_Art_Advanced_Choose_Model_2() {
		info("Open app");
		managementAccount.openHomePageWithLanguage("English");
		click(PageUI_ChatAI.TEXT_MIDJ_ART);
		click(PageUI_ChatAI.TAB_GENERATE_ART);
		sendKeyToElement(PageUI_ChatAI.TEXTBOX_PROMPT,"flower");
		click(PageUI_ChatAI.DROPDOWNLIST_CHOOSE_MODEL);
		String nameArt = getText(parseStringToObject(PageUI_ChatAI.TEXT_NAME_ART, "2"));
		click(parseStringToObject(PageUI_ChatAI.TEXT_NAME_ART, "2"));
		verifyCompare(nameArt, getText(PageUI_ChatAI.DROPDOWNLIST_CHOOSE_MODEL));
		scrollDown(2);
		click(PageUI_ChatAI.BLOCK_RANDOM);
		String artStyle = getText(PageUI_ChatAI.BLOCK_RANDOM);
		click(PageUI_ChatAI.BTN_GENERATE);
		pause(10000);
		getElementPresent(PageUI_ChatAI.TEXT_WATERMARK);
		getElementPresent(PageUI_ChatAI.SWITCH_WATERMARK);
		getElementPresent(PageUI_ChatAI.IMG_RESULT_ART);
		verifyCompare("flower", getText(PageUI_ChatAI.TEXT_RESULT_PROMPT));
		verifyCompare(artStyle, getText(PageUI_ChatAI.TEXT_RESULT_STYLE));
		getElementPresent(PageUI_ChatAI.BUTTON_REGENERATE);
		getElementPresent(PageUI_ChatAI.BTN_IMG);
		getElementPresent(PageUI_ChatAI.BTN_SHARE);
	}
	@Test
	public void TS_008_Logic_Midj_Art_Generate_Art_Advanced_Choose_Model_3() {
		info("Open app");
		managementAccount.openHomePageWithLanguage("English");
		click(PageUI_ChatAI.TEXT_MIDJ_ART);
		click(PageUI_ChatAI.TAB_GENERATE_ART);
		sendKeyToElement(PageUI_ChatAI.TEXTBOX_PROMPT,"flower");
		click(PageUI_ChatAI.DROPDOWNLIST_CHOOSE_MODEL);
		String nameArt = getText(parseStringToObject(PageUI_ChatAI.TEXT_NAME_ART, "3"));
		click(parseStringToObject(PageUI_ChatAI.TEXT_NAME_ART, "3"));
		verifyCompare(nameArt, getText(PageUI_ChatAI.DROPDOWNLIST_CHOOSE_MODEL));
		scrollDown(2);
		click(PageUI_ChatAI.BLOCK_ABSTRACT_VIBRANT);
		String artStyle = getText(PageUI_ChatAI.BLOCK_ABSTRACT_VIBRANT);
		click(PageUI_ChatAI.BTN_GENERATE);
		pause(10000);
		getElementPresent(PageUI_ChatAI.TEXT_WATERMARK);
		getElementPresent(PageUI_ChatAI.SWITCH_WATERMARK);
		getElementPresent(PageUI_ChatAI.IMG_RESULT_ART);
		verifyCompare("flower", getText(PageUI_ChatAI.TEXT_RESULT_PROMPT));
		verifyCompare(artStyle, getText(PageUI_ChatAI.TEXT_RESULT_STYLE));
		getElementPresent(PageUI_ChatAI.BUTTON_REGENERATE);
		getElementPresent(PageUI_ChatAI.BTN_IMG);
		getElementPresent(PageUI_ChatAI.BTN_SHARE);
	}
	@Test
	public void TS_009_Logic_Midj_Art_Generate_Art_Advanced_Choose_Model_4() {
		info("Open app");
		managementAccount.openHomePageWithLanguage("English");
		click(PageUI_ChatAI.TEXT_MIDJ_ART);
		click(PageUI_ChatAI.TAB_GENERATE_ART);
		sendKeyToElement(PageUI_ChatAI.TEXTBOX_PROMPT,"flower");
		click(PageUI_ChatAI.DROPDOWNLIST_CHOOSE_MODEL);
		String nameArt = getText(parseStringToObject(PageUI_ChatAI.TEXT_NAME_ART, "4"));
		click(parseStringToObject(PageUI_ChatAI.TEXT_NAME_ART, "4"));
		verifyCompare(nameArt, getText(PageUI_ChatAI.DROPDOWNLIST_CHOOSE_MODEL));
		scrollDown(2);
		click(PageUI_ChatAI.BLOCK_AMAZONIAN);
		String artStyle = getText(PageUI_ChatAI.BLOCK_AMAZONIAN);
		click(PageUI_ChatAI.BTN_GENERATE);
		pause(10000);
		getElementPresent(PageUI_ChatAI.TEXT_WATERMARK);
		getElementPresent(PageUI_ChatAI.SWITCH_WATERMARK);
		getElementPresent(PageUI_ChatAI.IMG_RESULT_ART);
		verifyCompare("flower", getText(PageUI_ChatAI.TEXT_RESULT_PROMPT));
		verifyCompare(artStyle, getText(PageUI_ChatAI.TEXT_RESULT_STYLE));
		getElementPresent(PageUI_ChatAI.BUTTON_REGENERATE);
		getElementPresent(PageUI_ChatAI.BTN_IMG);
		getElementPresent(PageUI_ChatAI.BTN_SHARE);
	}
	@Test
	public void TS_010_Logic_Midj_Art_Generate_Art_Advanced_Choose_Model_5() {
		info("Open app");
		managementAccount.openHomePageWithLanguage("English");
		click(PageUI_ChatAI.TEXT_MIDJ_ART);
		click(PageUI_ChatAI.TAB_GENERATE_ART);
		sendKeyToElement(PageUI_ChatAI.TEXTBOX_PROMPT,"flower");
		click(PageUI_ChatAI.DROPDOWNLIST_CHOOSE_MODEL);
		String nameArt = getText(parseStringToObject(PageUI_ChatAI.TEXT_NAME_ART, "5"));
		click(parseStringToObject(PageUI_ChatAI.TEXT_NAME_ART, "5"));
		verifyCompare(nameArt, getText(PageUI_ChatAI.DROPDOWNLIST_CHOOSE_MODEL));
		scrollDown(2);
		click(PageUI_ChatAI.BLOCK_ANIME_V2);
		String artStyle = getText(PageUI_ChatAI.BLOCK_ANIME_V2);
		click(PageUI_ChatAI.BTN_GENERATE);
		pause(10000);
		getElementPresent(PageUI_ChatAI.TEXT_WATERMARK);
		getElementPresent(PageUI_ChatAI.SWITCH_WATERMARK);
		getElementPresent(PageUI_ChatAI.IMG_RESULT_ART);
		verifyCompare("flower", getText(PageUI_ChatAI.TEXT_RESULT_PROMPT));
		verifyCompare(artStyle, getText(PageUI_ChatAI.TEXT_RESULT_STYLE));
		getElementPresent(PageUI_ChatAI.BUTTON_REGENERATE);
		getElementPresent(PageUI_ChatAI.BTN_IMG);
		getElementPresent(PageUI_ChatAI.BTN_SHARE);
	}
	@Test
	public void TS_011_Logic_Midj_Art_Generate_Art_Advanced_Choose_Model_6() {
		info("Open app");
		managementAccount.openHomePageWithLanguage("English");
		click(PageUI_ChatAI.TEXT_MIDJ_ART);
		click(PageUI_ChatAI.TAB_GENERATE_ART);
		sendKeyToElement(PageUI_ChatAI.TEXTBOX_PROMPT,"flower");
		click(PageUI_ChatAI.DROPDOWNLIST_CHOOSE_MODEL);
		String nameArt = getText(parseStringToObject(PageUI_ChatAI.TEXT_NAME_ART, "6"));
		click(parseStringToObject(PageUI_ChatAI.TEXT_NAME_ART, "6"));
		verifyCompare(nameArt, getText(PageUI_ChatAI.DROPDOWNLIST_CHOOSE_MODEL));
		scrollDown(2);
		click(PageUI_ChatAI.BLOCK_RANDOM);
		String artStyle = getText(PageUI_ChatAI.BLOCK_RANDOM);
		click(PageUI_ChatAI.BTN_GENERATE);
		pause(10000);
		getElementPresent(PageUI_ChatAI.TEXT_WATERMARK);
		getElementPresent(PageUI_ChatAI.SWITCH_WATERMARK);
		getElementPresent(PageUI_ChatAI.IMG_RESULT_ART);
		verifyCompare("flower", getText(PageUI_ChatAI.TEXT_RESULT_PROMPT));
		verifyCompare(artStyle, getText(PageUI_ChatAI.TEXT_RESULT_STYLE));
		getElementPresent(PageUI_ChatAI.BUTTON_REGENERATE);
		getElementPresent(PageUI_ChatAI.BTN_IMG);
		getElementPresent(PageUI_ChatAI.BTN_SHARE);
	}
	@Test
	public void TS_012_Logic_Midj_Art_Generate_Art_Advanced_Advanced_Settings() {
		info("Open app");
		managementAccount.openHomePageWithLanguage("English");
		click(PageUI_ChatAI.TEXT_MIDJ_ART);
		click(PageUI_ChatAI.TAB_GENERATE_ART);
		click(PageUI_ChatAI.DROPDOWN_LIST_CHOOSE_SETTING);
		getElementPresent(PageUI_ChatAI.TEXT_ADVANCED_SETTINGS);
		getElementPresent(PageUI_ChatAI.TEXT_NEGATIVE_PROMPT);
		getElementPresent(PageUI_ChatAI.TEXTBOX_NEGATIVE_PROMPT);
		getElementPresent(PageUI_ChatAI.BTN_SAVE);
		getElementPresent(PageUI_ChatAI.TEXT_ASPECT_RATIO);
		getElementPresent(PageUI_ChatAI.LIST_FLEXBOX);
		getElementPresent(PageUI_ChatAI.TEXT_SCALE);
		getElementPresent(PageUI_ChatAI.SCALE_SELECTION_BAR);
	}
	@Test
	public void TS_013_Logic_Midj_Art_Generate_Art_Advanced_Settings_Negative_Prompt_10000_Ky_Tu() {
		info("Open app");
		managementAccount.openHomePageWithLanguage("English");
		click(PageUI_ChatAI.TEXT_MIDJ_ART);
		click(PageUI_ChatAI.TAB_GENERATE_ART);
		sendKeyToElement(PageUI_ChatAI.TEXTBOX_PROMPT,"flower");
		click(PageUI_ChatAI.DROPDOWN_LIST_CHOOSE_SETTING);
		sendKeyToElement(PageUI_ChatAI.TEXTBOX_NEGATIVE_PROMPT, generateRandomString(10000));
		click(PageUI_ChatAI.BTN_SAVE);
		scrollDown(2);
		click(PageUI_ChatAI.BLOCK_AMAZONIAN);
		String artStyle = getText(PageUI_ChatAI.BLOCK_AMAZONIAN);
		click(PageUI_ChatAI.BTN_GENERATE);
		pause(10000);
		getElementPresent(PageUI_ChatAI.TEXT_WATERMARK);
		getElementPresent(PageUI_ChatAI.SWITCH_WATERMARK);
		getElementPresent(PageUI_ChatAI.IMG_RESULT_ART);
		verifyCompare("flower", getText(PageUI_ChatAI.TEXT_RESULT_PROMPT));
		verifyCompare(artStyle, getText(PageUI_ChatAI.TEXT_RESULT_STYLE));
		getElementPresent(PageUI_ChatAI.BUTTON_REGENERATE);
		getElementPresent(PageUI_ChatAI.BTN_IMG);
		getElementPresent(PageUI_ChatAI.BTN_SHARE);
	}
	@Test
	public void TS_014_Logic_Midj_Art_Generate_Art_Advanced_Settings_Aspect_Ratio_Low_CFG_Scale() {
		info("Open app");
		managementAccount.openHomePageWithLanguage("English");
		click(PageUI_ChatAI.TEXT_MIDJ_ART);
		click(PageUI_ChatAI.TAB_GENERATE_ART);
		click(PageUI_ChatAI.BTN_GET_INSPIRED);
		sendKeyToElement(PageUI_ChatAI.TEXTBOX_PROMPT,"flower");
		click(PageUI_ChatAI.DROPDOWN_LIST_CHOOSE_SETTING);
		getListElement(PageUI_ChatAI.LIST_FLEXBOX);
		clickListElement(PageUI_ChatAI.LIST_FLEXBOX,8);
		pause(2000);
		singleTab(60, 1983);
		pause(2000);
		click(PageUI_ChatAI.BTN_SAVE);
		scrollDown(2);
		click(PageUI_ChatAI.BLOCK_AMAZONIAN);
		String artStyle = getText(PageUI_ChatAI.BLOCK_AMAZONIAN);
		click(PageUI_ChatAI.BTN_GENERATE);
		pause(10000);
		getElementPresent(PageUI_ChatAI.TEXT_WATERMARK);
		getElementPresent(PageUI_ChatAI.SWITCH_WATERMARK);
		getElementPresent(PageUI_ChatAI.IMG_RESULT_ART);
		verifyCompare("flower", getText(PageUI_ChatAI.TEXT_RESULT_PROMPT));
		verifyCompare(artStyle, getText(PageUI_ChatAI.TEXT_RESULT_STYLE));
		getElementPresent(PageUI_ChatAI.BUTTON_REGENERATE);
		getElementPresent(PageUI_ChatAI.BTN_IMG);
		getElementPresent(PageUI_ChatAI.BTN_SHARE);
	}
	@Test
	public void TS_015_Logic_Midj_Art_Generate_Art_Advanced_Settings_Aspect_Ratio_Mid_CFG_Scale() {
		info("Open app");
		managementAccount.openHomePageWithLanguage("English");
		click(PageUI_ChatAI.TEXT_MIDJ_ART);
		click(PageUI_ChatAI.TAB_GENERATE_ART);
		click(PageUI_ChatAI.BTN_GET_INSPIRED);
		sendKeyToElement(PageUI_ChatAI.TEXTBOX_PROMPT,"flower");
		click(PageUI_ChatAI.DROPDOWN_LIST_CHOOSE_SETTING);
		getListElement(PageUI_ChatAI.LIST_FLEXBOX);
		clickListElement(PageUI_ChatAI.LIST_FLEXBOX,6);
		pause(2000);
		singleTab(515, 1983);
		pause(2000);
		click(PageUI_ChatAI.BTN_SAVE);
		scrollDown(2);
		click(PageUI_ChatAI.BLOCK_ANIME_V2);
		String artStyle = getText(PageUI_ChatAI.BLOCK_ANIME_V2);
		click(PageUI_ChatAI.BTN_GENERATE);
		pause(10000);
		getElementPresent(PageUI_ChatAI.TEXT_WATERMARK);
		getElementPresent(PageUI_ChatAI.SWITCH_WATERMARK);
		getElementPresent(PageUI_ChatAI.IMG_RESULT_ART);
		verifyCompare("flower", getText(PageUI_ChatAI.TEXT_RESULT_PROMPT));
		verifyCompare(artStyle, getText(PageUI_ChatAI.TEXT_RESULT_STYLE));
		getElementPresent(PageUI_ChatAI.BUTTON_REGENERATE);
		getElementPresent(PageUI_ChatAI.BTN_IMG);
		getElementPresent(PageUI_ChatAI.BTN_SHARE);
	}
	@Test
	public void TS_016_Logic_Midj_Art_Generate_Art_Advanced_Settings_Aspect_Ratio_Hight_CFG_Scale() {
		info("Open app");
		managementAccount.openHomePageWithLanguage("English");
		click(PageUI_ChatAI.TEXT_MIDJ_ART);
		click(PageUI_ChatAI.TAB_GENERATE_ART);
		click(PageUI_ChatAI.BTN_GET_INSPIRED);
		sendKeyToElement(PageUI_ChatAI.TEXTBOX_PROMPT,"flower");
		click(PageUI_ChatAI.DROPDOWN_LIST_CHOOSE_SETTING);
		getListElement(PageUI_ChatAI.LIST_FLEXBOX);
		clickListElement(PageUI_ChatAI.LIST_FLEXBOX,6);
		pause(2000);
		singleTab(1048, 1983);
		pause(2000);
		click(PageUI_ChatAI.BTN_SAVE);
		scrollDown(2);
		click(PageUI_ChatAI.BLOCK_RANDOM);
		String artStyle = getText(PageUI_ChatAI.BLOCK_RANDOM);
		click(PageUI_ChatAI.BTN_GENERATE);
		pause(10000);
		getElementPresent(PageUI_ChatAI.TEXT_WATERMARK);
		getElementPresent(PageUI_ChatAI.SWITCH_WATERMARK);
		getElementPresent(PageUI_ChatAI.IMG_RESULT_ART);
		verifyCompare("flower", getText(PageUI_ChatAI.TEXT_RESULT_PROMPT));
		verifyCompare(artStyle, getText(PageUI_ChatAI.TEXT_RESULT_STYLE));
		getElementPresent(PageUI_ChatAI.BUTTON_REGENERATE);
		getElementPresent(PageUI_ChatAI.BTN_IMG);
		getElementPresent(PageUI_ChatAI.BTN_SHARE);
	}
	@Test
	public void TS_017_Logic_Midj_Art_Generate_Art_Advanced_More_Choose_An_Art_Style_1() {
		info("Open app");
		managementAccount.openHomePageWithLanguage("English");
		click(PageUI_ChatAI.TEXT_MIDJ_ART);
		click(PageUI_ChatAI.TAB_GENERATE_ART);
		click(PageUI_ChatAI.BTN_GET_INSPIRED);
		sendKeyToElement(PageUI_ChatAI.TEXTBOX_PROMPT,"flower");
		click(PageUI_ChatAI.TEXT_MORE);
		scrollDown(2);
		click(PageUI_ChatAI.BLOCK_AQUATIC);
		String artStyle = getText(PageUI_ChatAI.BLOCK_AQUATIC);
		click(PageUI_ChatAI.BTN_DONE_STYLE_ART);
		click(PageUI_ChatAI.BTN_GENERATE);
		pause(10000);
		getElementPresent(PageUI_ChatAI.TEXT_WATERMARK);
		getElementPresent(PageUI_ChatAI.SWITCH_WATERMARK);
		getElementPresent(PageUI_ChatAI.IMG_RESULT_ART);
		verifyCompare("flower", getText(PageUI_ChatAI.TEXT_RESULT_PROMPT));
		verifyCompare(artStyle, getText(PageUI_ChatAI.TEXT_RESULT_STYLE));
		getElementPresent(PageUI_ChatAI.BUTTON_REGENERATE);
		getElementPresent(PageUI_ChatAI.BTN_IMG);
		getElementPresent(PageUI_ChatAI.BTN_SHARE);
	}
	@Test
	public void TS_018_Logic_Midj_Art_Generate_Art_Advanced_More_Choose_An_Art_Style_2() {
		info("Open app");
		managementAccount.openHomePageWithLanguage("English");
		click(PageUI_ChatAI.TEXT_MIDJ_ART);
		click(PageUI_ChatAI.TAB_GENERATE_ART);
		click(PageUI_ChatAI.BTN_GET_INSPIRED);
		sendKeyToElement(PageUI_ChatAI.TEXTBOX_PROMPT,"flower");
		click(PageUI_ChatAI.TEXT_MORE);
		scrollDown(2);
		click(PageUI_ChatAI.BLOCK_ARCHITECTURE);
		String artStyle = getText(PageUI_ChatAI.BLOCK_ARCHITECTURE);
		click(PageUI_ChatAI.BTN_DONE_STYLE_ART);
		click(PageUI_ChatAI.BTN_GENERATE);
		pause(10000);
		getElementPresent(PageUI_ChatAI.TEXT_WATERMARK);
		getElementPresent(PageUI_ChatAI.SWITCH_WATERMARK);
		getElementPresent(PageUI_ChatAI.IMG_RESULT_ART);
		verifyCompare("flower", getText(PageUI_ChatAI.TEXT_RESULT_PROMPT));
		verifyCompare(artStyle, getText(PageUI_ChatAI.TEXT_RESULT_STYLE));
		getElementPresent(PageUI_ChatAI.BUTTON_REGENERATE);
		getElementPresent(PageUI_ChatAI.BTN_IMG);
		getElementPresent(PageUI_ChatAI.BTN_SHARE);
	}
	@Test
	public void TS_019_Logic_Midj_Art_Generate_Art_Advanced_More_Choose_An_Art_Style_3() {
		info("Open app");
		managementAccount.openHomePageWithLanguage("English");
		click(PageUI_ChatAI.TEXT_MIDJ_ART);
		click(PageUI_ChatAI.TAB_GENERATE_ART);
		click(PageUI_ChatAI.BTN_GET_INSPIRED);
		sendKeyToElement(PageUI_ChatAI.TEXTBOX_PROMPT,"flower");
		click(PageUI_ChatAI.TEXT_MORE);
		scrollDown(3);
		click(PageUI_ChatAI.BLOCK_CANDYLAND);
		String artStyle = getText(PageUI_ChatAI.BLOCK_CANDYLAND);
		click(PageUI_ChatAI.BTN_DONE_STYLE_ART);
		click(PageUI_ChatAI.BTN_GENERATE);
		pause(10000);
		getElementPresent(PageUI_ChatAI.TEXT_WATERMARK);
		getElementPresent(PageUI_ChatAI.SWITCH_WATERMARK);
		getElementPresent(PageUI_ChatAI.IMG_RESULT_ART);
		verifyCompare("flower", getText(PageUI_ChatAI.TEXT_RESULT_PROMPT));
		verifyCompare(artStyle, getText(PageUI_ChatAI.TEXT_RESULT_STYLE));
		getElementPresent(PageUI_ChatAI.BUTTON_REGENERATE);
		getElementPresent(PageUI_ChatAI.BTN_IMG);
		getElementPresent(PageUI_ChatAI.BTN_SHARE);
	}
	@Test
	public void TS_020_Logic_Midj_Art_Generate_Art_Advanced_More_Choose_An_Art_Style_4() {
		info("Open app");
		managementAccount.openHomePageWithLanguage("English");
		click(PageUI_ChatAI.TEXT_MIDJ_ART);
		click(PageUI_ChatAI.TAB_GENERATE_ART);
		click(PageUI_ChatAI.BTN_GET_INSPIRED);
		sendKeyToElement(PageUI_ChatAI.TEXTBOX_PROMPT,"flower");
		click(PageUI_ChatAI.TEXT_MORE);
		scrollDown(2);
		click(PageUI_ChatAI.BLOCK_AVATAR);
		String artStyle = getText(PageUI_ChatAI.BLOCK_AVATAR);
		click(PageUI_ChatAI.BTN_DONE_STYLE_ART);
		click(PageUI_ChatAI.BTN_GENERATE);
		pause(10000);
		getElementPresent(PageUI_ChatAI.TEXT_WATERMARK);
		getElementPresent(PageUI_ChatAI.SWITCH_WATERMARK);
		getElementPresent(PageUI_ChatAI.IMG_RESULT_ART);
		verifyCompare("flower", getText(PageUI_ChatAI.TEXT_RESULT_PROMPT));
		verifyCompare(artStyle, getText(PageUI_ChatAI.TEXT_RESULT_STYLE));
		getElementPresent(PageUI_ChatAI.BUTTON_REGENERATE);
		getElementPresent(PageUI_ChatAI.BTN_IMG);
		getElementPresent(PageUI_ChatAI.BTN_SHARE);
	}
	@Test
	public void TS_021_Logic_Midj_Art_Generate_Art_Advanced_More_Choose_An_Art_Style_5() {
		info("Open app");
		managementAccount.openHomePageWithLanguage("English");
		click(PageUI_ChatAI.TEXT_MIDJ_ART);
		click(PageUI_ChatAI.TAB_GENERATE_ART);
		sendKeyToElement(PageUI_ChatAI.TEXTBOX_PROMPT,"flower");
		click(PageUI_ChatAI.TEXT_MORE);
		scrollDown(2);
		click(PageUI_ChatAI.BLOCK_BAUHAUS);
		String artStyle = getText(PageUI_ChatAI.BLOCK_BAUHAUS);
		click(PageUI_ChatAI.BTN_DONE_STYLE_ART);
		click(PageUI_ChatAI.BTN_GENERATE);
		pause(10000);
		getElementPresent(PageUI_ChatAI.TEXT_WATERMARK);
		getElementPresent(PageUI_ChatAI.SWITCH_WATERMARK);
		getElementPresent(PageUI_ChatAI.IMG_RESULT_ART);
		verifyCompare("flower", getText(PageUI_ChatAI.TEXT_RESULT_PROMPT));
		verifyCompare(artStyle, getText(PageUI_ChatAI.TEXT_RESULT_STYLE));
		getElementPresent(PageUI_ChatAI.BUTTON_REGENERATE);
		getElementPresent(PageUI_ChatAI.BTN_IMG);
		getElementPresent(PageUI_ChatAI.BTN_SHARE);
	}
	@Test
	public void TS_022_Logic_Midj_Art_Generate_Art_Advanced_More_Choose_An_Art_Style_6() {
		info("Open app");
		managementAccount.openHomePageWithLanguage("English");
		click(PageUI_ChatAI.TEXT_MIDJ_ART);
		click(PageUI_ChatAI.TAB_GENERATE_ART);
		sendKeyToElement(PageUI_ChatAI.TEXTBOX_PROMPT,"flower");
		click(PageUI_ChatAI.TEXT_MORE);
		scrollDown(3);
		click(PageUI_ChatAI.BLOCK_CANDYLAND);
		String artStyle = getText(PageUI_ChatAI.BLOCK_CANDYLAND);
		click(PageUI_ChatAI.BTN_DONE_STYLE_ART);
		click(PageUI_ChatAI.BTN_GENERATE);
		pause(10000);
		getElementPresent(PageUI_ChatAI.TEXT_WATERMARK);
		getElementPresent(PageUI_ChatAI.SWITCH_WATERMARK);
		getElementPresent(PageUI_ChatAI.IMG_RESULT_ART);
		verifyCompare("flower", getText(PageUI_ChatAI.TEXT_RESULT_PROMPT));
		verifyCompare(artStyle, getText(PageUI_ChatAI.TEXT_RESULT_STYLE));
		getElementPresent(PageUI_ChatAI.BUTTON_REGENERATE);
		getElementPresent(PageUI_ChatAI.BTN_IMG);
		getElementPresent(PageUI_ChatAI.BTN_SHARE);
	}
	@Test
	public void TS_023_Logic_Midj_Art_Generate_Art_Advanced_Free_Tries_Left() {
		info("Open app");
		managementAccount.openHomePageWithLanguage("English");
		click(PageUI_ChatAI.TEXT_MIDJ_ART);
		click(PageUI_ChatAI.TAB_GENERATE_ART);
		sendKeyToElement(PageUI_ChatAI.TEXTBOX_PROMPT,"flower");
		verifyContains("2", getText(PageUI_ChatAI.TEXT_NUMBER_FREE_TIMES));
		click(PageUI_ChatAI.TEXT_MORE);
		scrollDown(3);
		click(PageUI_ChatAI.BLOCK_CANDYLAND);
		String artStyle = getText(PageUI_ChatAI.BLOCK_CANDYLAND);
		click(PageUI_ChatAI.BTN_DONE_STYLE_ART);
		click(PageUI_ChatAI.BTN_GENERATE);
		pause(10000);
		getElementPresent(PageUI_ChatAI.TEXT_WATERMARK);
		getElementPresent(PageUI_ChatAI.SWITCH_WATERMARK);
		getElementPresent(PageUI_ChatAI.IMG_RESULT_ART);
		verifyCompare("flower", getText(PageUI_ChatAI.TEXT_RESULT_PROMPT));
		verifyCompare(artStyle, getText(PageUI_ChatAI.TEXT_RESULT_STYLE));
		getElementPresent(PageUI_ChatAI.BUTTON_REGENERATE);
		getElementPresent(PageUI_ChatAI.BTN_IMG);
		getElementPresent(PageUI_ChatAI.BTN_SHARE);
		click(PageUI_ChatAI.BTN_BACK);
		scrollToElementWithTouchAction(PageUI_ChatAI.TEXT_ENTER_YOUR_PROMPT,"V",0.5,0.8);
		verifyContains("1", getText(PageUI_ChatAI.TEXT_NUMBER_FREE_TIMES));
		click(PageUI_ChatAI.BTN_GENERATE);
		pause(10000);
		getElementPresent(PageUI_ChatAI.BUTTON_REGENERATE);
		getElementPresent(PageUI_ChatAI.BTN_IMG);
		getElementPresent(PageUI_ChatAI.BTN_SHARE);
		click(PageUI_ChatAI.BTN_BACK);
		verifyContains("0", getText(PageUI_ChatAI.TEXT_NUMBER_FREE_TIMES));
		click(PageUI_ChatAI.BTN_GENERATE);
		getElementPresent(PageUI_ChatAI.TAB_WALLPAPERS);
		getElementPresent(PageUI_ChatAI.TEXT_ENTER_YOUR_PROMPT);
		getElementPresent(PageUI_ChatAI.BTN_GET_INSPIRED);
		getElementPresent(PageUI_ChatAI.TEXTBOX_PROMPT);
		getElementPresent(PageUI_ChatAI.BTN_ADVANCED);
		getElementPresent(PageUI_ChatAI.BTN_PRIMARY);
	}
	@Test
	public void TS_024_Logic_Midj_Art_Generate_Art_Primary_Khong_Nhap_Prompt() {
		info("Open app");
		managementAccount.openHomePageWithLanguage("English");
		click(PageUI_ChatAI.TEXT_MIDJ_ART);
		click(PageUI_ChatAI.TAB_GENERATE_ART);
		click(PageUI_ChatAI.BTN_PRIMARY);
		click(PageUI_ChatAI.BTN_GENERATE);
		getElementPresent(PageUI_ChatAI.TAB_WALLPAPERS);
		getElementPresent(PageUI_ChatAI.TEXT_ENTER_YOUR_PROMPT);
		getElementPresent(PageUI_ChatAI.BTN_GET_INSPIRED);
		getElementPresent(PageUI_ChatAI.TEXTBOX_PROMPT);
		getElementPresent(PageUI_ChatAI.BTN_ADVANCED);
		getElementPresent(PageUI_ChatAI.BTN_PRIMARY);
		getElementPresent(PageUI_ChatAI.TEXT_CHOOSE_VERSION);
		getElementPresent(PageUI_ChatAI.BTN_GENERATE);
	}
	@Test 
	public void TS_025_Logic_Midj_Art_Generate_Art_Primary_Nhap_10000_Ky_Tu() {
		info("Open app");
		managementAccount.openHomePageWithLanguage("English");
		click(PageUI_ChatAI.TEXT_MIDJ_ART);
		click(PageUI_ChatAI.TAB_GENERATE_ART);
		click(PageUI_ChatAI.BTN_PRIMARY);
		sendKeyToElement(PageUI_ChatAI.TEXTBOX_PROMPT, generateRandomString(10000));
		click(PageUI_ChatAI.BTN_GENERATE);
		pause(10000);
	}
	@Test
	public void TS_026_Logic_Midj_Art_Generate_Art_Primary_Nhap_Ky_Tu_Hop_Le() {
		info("Open app");
		managementAccount.openHomePageWithLanguage("English");
		click(PageUI_ChatAI.TEXT_MIDJ_ART);
		click(PageUI_ChatAI.TAB_GENERATE_ART);
		click(PageUI_ChatAI.BTN_PRIMARY);
		sendKeyToElement(PageUI_ChatAI.TEXTBOX_PROMPT,"flower");
		click(PageUI_ChatAI.BLOCK_PAINTING);
		String artStyle = getText(PageUI_ChatAI.BLOCK_PAINTING);
		click(PageUI_ChatAI.BTN_GENERATE);
		pause(10000);
		getElementPresent(PageUI_ChatAI.TEXT_WATERMARK);
		getElementPresent(PageUI_ChatAI.SWITCH_WATERMARK);
		getElementPresent(PageUI_ChatAI.IMG_RESULT_ART);
		verifyCompare("flower", getText(PageUI_ChatAI.TEXT_RESULT_PROMPT));
		verifyCompare(artStyle, getText(PageUI_ChatAI.TEXT_RESULT_STYLE));
		getElementPresent(PageUI_ChatAI.BUTTON_REGENERATE);
		getElementPresent(PageUI_ChatAI.BTN_IMG);
		getElementPresent(PageUI_ChatAI.BTN_SHARE);
	}
	@Test
	public void TS_027_Logic_Midj_Art_Generate_Art_Primary_Inspired() {
		info("Open app");
		managementAccount.openHomePageWithLanguage("English");
		click(PageUI_ChatAI.TEXT_MIDJ_ART);
		click(PageUI_ChatAI.TAB_GENERATE_ART);
		click(PageUI_ChatAI.BTN_PRIMARY);
		click(PageUI_ChatAI.BTN_GET_INSPIRED);
		String textPrompt = getText(PageUI_ChatAI.TEXTBOX_PROMPT);
		String artStyle = getText(PageUI_ChatAI.BLOCK_RANDOM);
		click(PageUI_ChatAI.BTN_GENERATE);
		pause(10000);
		getElementPresent(PageUI_ChatAI.TEXT_WATERMARK);
		getElementPresent(PageUI_ChatAI.SWITCH_WATERMARK);
		getElementPresent(PageUI_ChatAI.IMG_RESULT_ART);
		verifyCompare(textPrompt, getText(PageUI_ChatAI.TEXT_RESULT_PROMPT));
		verifyCompare(artStyle, getText(PageUI_ChatAI.TEXT_RESULT_STYLE));
		getElementPresent(PageUI_ChatAI.BUTTON_REGENERATE);
		getElementPresent(PageUI_ChatAI.BTN_IMG);
		getElementPresent(PageUI_ChatAI.BTN_SHARE);
	}
	@Test
	public void TS_028_Logic_Midj_Art_Generate_Art_Primary_Choose_An_Art_Style() {
		info("Open app");
		managementAccount.openHomePageWithLanguage("English");
		click(PageUI_ChatAI.TEXT_MIDJ_ART);
		click(PageUI_ChatAI.TAB_GENERATE_ART);
		click(PageUI_ChatAI.BTN_PRIMARY);
		sendKeyToElement(PageUI_ChatAI.TEXTBOX_PROMPT,"flower");
		click(PageUI_ChatAI.BLOCK_PAINTING);
		String artStyle = getText(PageUI_ChatAI.BLOCK_PAINTING);
		click(PageUI_ChatAI.BTN_GENERATE);
		pause(10000);
		getElementPresent(PageUI_ChatAI.TEXT_WATERMARK);
		getElementPresent(PageUI_ChatAI.SWITCH_WATERMARK);
		getElementPresent(PageUI_ChatAI.IMG_RESULT_ART);
		verifyCompare("flower", getText(PageUI_ChatAI.TEXT_RESULT_PROMPT));
		verifyCompare(artStyle, getText(PageUI_ChatAI.TEXT_RESULT_STYLE));
		getElementPresent(PageUI_ChatAI.BUTTON_REGENERATE);
		getElementPresent(PageUI_ChatAI.BTN_IMG);
		getElementPresent(PageUI_ChatAI.BTN_SHARE);
	}
	@Test
	public void TS_029_Logic_Midj_Art_Generate_Art_Primary_Free_Tries_Left() {
		info("Open app");
		managementAccount.openHomePageWithLanguage("English");
		click(PageUI_ChatAI.TEXT_MIDJ_ART);
		click(PageUI_ChatAI.TAB_GENERATE_ART);
		click(PageUI_ChatAI.BTN_PRIMARY);
		sendKeyToElement(PageUI_ChatAI.TEXTBOX_PROMPT,"flower");
		verifyContains("2", getText(PageUI_ChatAI.TEXT_FREE_TRES_LEFT_PRIMARY));
		String artStyle = getText(PageUI_ChatAI.BLOCK_RANDOM);
		click(PageUI_ChatAI.BTN_GENERATE);
		pause(10000);
		getElementPresent(PageUI_ChatAI.TEXT_WATERMARK);
		getElementPresent(PageUI_ChatAI.SWITCH_WATERMARK);
		getElementPresent(PageUI_ChatAI.IMG_RESULT_ART);
		verifyCompare("flower", getText(PageUI_ChatAI.TEXT_RESULT_PROMPT));
		verifyCompare(artStyle, getText(PageUI_ChatAI.TEXT_RESULT_STYLE));
		getElementPresent(PageUI_ChatAI.BUTTON_REGENERATE);
		getElementPresent(PageUI_ChatAI.BTN_IMG);
		getElementPresent(PageUI_ChatAI.BTN_SHARE);
		click(PageUI_ChatAI.BTN_BACK);
		verifyContains("1", getText(PageUI_ChatAI.TEXT_FREE_TRES_LEFT_PRIMARY));
		click(PageUI_ChatAI.BTN_GENERATE);
		pause(10000);
		click(PageUI_ChatAI.BTN_BACK);
		verifyContains("0", getText(PageUI_ChatAI.TEXT_FREE_TRES_LEFT_PRIMARY));
	}
	private Management_Account managementAccount;
}
