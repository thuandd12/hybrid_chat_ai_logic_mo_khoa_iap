package ikame.chatai.testsuite;

import static ikame.chatai.common.TestLogger.info;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import ikame.chatai.common.Management_Account;
import ikame.chatai.common.commonBase;
import ikame.chatai.ui.PageUI_ChatAI;

public final class TS_01_Logic_ChatAI_Chat extends commonBase {

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
	public void TS_001_Logic_ChatAI_Chat_Nhap_Noi_Dung_Hop_Le() {
		info("Open app");
		managementAccount.openHomePageWithLanguage("English");
		sendKeyToElement(PageUI_ChatAI.TEXTBOX_ASK_A_QUESTION, "Hello");
		click(PageUI_ChatAI.BTN_SEND);
		getElementPresent(PageUI_ChatAI.BTN_LEFT);
		getElementPresent(PageUI_ChatAI.TITLE_CHAT_AI);
		getElementPresent(PageUI_ChatAI.ICON_HISTORY);
		getElementPresent(PageUI_ChatAI.ICON_LOUDSPEAKER);
		getElementPresent(PageUI_ChatAI.TEXTBOX_ANSWER_USER);
		getElementPresent(PageUI_ChatAI.TEXT_CONTENT_ANSWER);
		getElementPresent(PageUI_ChatAI.BTN_REGENERATE);
		getElementPresent(PageUI_ChatAI.BTN_COPY);
		getElementPresent(PageUI_ChatAI.BUTTON_SHARE);
		String chatReply1 = parseStringToObject(PageUI_ChatAI.CHAT_AI_RELLY, "1");
		String USER_ASK1 = parseStringToObject(PageUI_ChatAI.TEXT_USER_ASK, "1");
		getElementPresent(USER_ASK1);
		getElementPresent(chatReply1);
		getElementPresent(PageUI_ChatAI.TXTB_ASK_A_QUESTION);
		getElementPresent(PageUI_ChatAI.BUTTON_SEND);
		getElementPresent(PageUI_ChatAI.BTN_IMAGE);
		getElementPresent(PageUI_ChatAI.BTN_VOID_CHAT);
		String chatReply2 = parseStringToObject(PageUI_ChatAI.CHAT_AI_RELLY, "2");
		String USER_ASK2 = parseStringToObject(PageUI_ChatAI.TEXT_USER_ASK, "2");
		sendKeyToElement(PageUI_ChatAI.TXTB_ASK_A_QUESTION, "What is your name");
		click(PageUI_ChatAI.BUTTON_SEND);
		getElementPresent(USER_ASK2);
		getElementPresent(chatReply2);

	}
	@Test
	public void TS_002_Logic_ChatAI_Chat_Nhap_Khoang_Trang() {
		info("Open app");
		managementAccount.openHomePageWithLanguage("English");
		sendKeyToElement(PageUI_ChatAI.TEXTBOX_ASK_A_QUESTION, "           ");
		click(PageUI_ChatAI.BTN_SEND);
		getElementPresent(PageUI_ChatAI.TITLE_CHAT_AI);
		String chatReply = parseStringToObject(PageUI_ChatAI.CHAT_AI_RELLY, "1");
		getElementPresent(chatReply);
		sendKeyToElement(PageUI_ChatAI.TXTB_ASK_A_QUESTION, "          ");
		verifyContains("10", getText(PageUI_ChatAI.TEXT_NUMBER_OF_CHARACTERS));
		click(PageUI_ChatAI.BUTTON_SEND);
		String chatReply2 = parseStringToObject(PageUI_ChatAI.CHAT_AI_RELLY, "2");
		checkElementNotPresent(chatReply2, 5000);
	}
	@Test
	public void TS_003_Logic_ChatAI_Chat_Nhap_Nhieu_Hon_300_Ky_Tu() {
		info("Open app");
		managementAccount.openHomePageWithLanguage("English");
		sendKeyToElement(PageUI_ChatAI.TEXTBOX_ASK_A_QUESTION, "auto test");
		click(PageUI_ChatAI.BTN_SEND);
		getElementPresent(PageUI_ChatAI.TITLE_CHAT_AI);
		String chatReply1 = parseStringToObject(PageUI_ChatAI.CHAT_AI_RELLY, "1");
		String USER_ASK1 = parseStringToObject(PageUI_ChatAI.TEXT_USER_ASK, "1");
		getElementPresent(USER_ASK1);
		getElementPresent(chatReply1);
		sendKeyToElement(PageUI_ChatAI.TXTB_ASK_A_QUESTION, generateRandomString(333));
		verifyCompare("300/300", getValue(PageUI_ChatAI.TEXT_NUMBER_OF_CHARACTERS));
		click(PageUI_ChatAI.BUTTON_SEND);
		String chatReply2 = parseStringToObject(PageUI_ChatAI.CHAT_AI_RELLY, "2");
		String USER_ASK2 = parseStringToObject(PageUI_ChatAI.TEXT_USER_ASK, "2");
		sendKeyToElement(PageUI_ChatAI.TXTB_ASK_A_QUESTION, "What is your name");
		click(PageUI_ChatAI.BUTTON_SEND);
		getElementPresent(USER_ASK2);
		getElementPresent(chatReply2);
	}
	@Test
	public void TS_004_Logic_ChatAI_Chat_Regenerate() {
		info("Open app");
		managementAccount.openHomePageWithLanguage("English");
		sendKeyToElement(PageUI_ChatAI.TEXTBOX_ASK_A_QUESTION, "Hello");
		click(PageUI_ChatAI.BTN_SEND);
		getElementPresent(PageUI_ChatAI.TITLE_CHAT_AI);
		String chatReply1 = parseStringToObject(PageUI_ChatAI.CHAT_AI_RELLY, "1");
		String USER_ASK1 = parseStringToObject(PageUI_ChatAI.TEXT_USER_ASK, "1");
		getElementPresent(USER_ASK1);
		getElementPresent(chatReply1);
		click(PageUI_ChatAI.BTN_REGENERATE);
		String chatReply2 = parseStringToObject(PageUI_ChatAI.CHAT_AI_RELLY, "2");
		getElementPresent(chatReply2);
	}
	@Test
	public void TS_005_Logic_ChatAI_Chat_Coppy() {
		info("Open app");
		managementAccount.openHomePageWithLanguage("English");
		sendKeyToElement(PageUI_ChatAI.TEXTBOX_ASK_A_QUESTION, "Hello");
		click(PageUI_ChatAI.BTN_SEND);
		getElementPresent(PageUI_ChatAI.TITLE_CHAT_AI);
		String chatReply1 = parseStringToObject(PageUI_ChatAI.CHAT_AI_RELLY, "1");
		String USER_ASK1 = parseStringToObject(PageUI_ChatAI.TEXT_USER_ASK, "1");
		getElementPresent(USER_ASK1);
		getElementPresent(chatReply1);
		click(PageUI_ChatAI.BTN_COPY);
		getElementPresent(PageUI_ChatAI.TITLE_CHAT_AI);
		
	}
	@Test
	public void TS_006_Logic_ChatAI_Chat_Share() {
		info("Open app");
		managementAccount.openHomePageWithLanguage("English");
		sendKeyToElement(PageUI_ChatAI.TEXTBOX_ASK_A_QUESTION, "Hello");
		click(PageUI_ChatAI.BTN_SEND);
		getElementPresent(PageUI_ChatAI.TITLE_CHAT_AI);
		String chatReply1 = parseStringToObject(PageUI_ChatAI.CHAT_AI_RELLY, "1");
		String USER_ASK1 = parseStringToObject(PageUI_ChatAI.TEXT_USER_ASK, "1");
		getElementPresent(USER_ASK1);
		getElementPresent(chatReply1);
		click(PageUI_ChatAI.BUTTON_SHARE);
		getElementPresent(PageUI_ChatAI.OPTION_APPLICATION);
	}
	@Test
	public void TS_007_Logic_ChatAI_Chat_History_1_Lich_Su_Chat() {
		info("Open app");
		managementAccount.openHomePageWithLanguage("English");
		sendKeyToElement(PageUI_ChatAI.TEXTBOX_ASK_A_QUESTION, "Hello");
		click(PageUI_ChatAI.BTN_SEND);
		getElementPresent(PageUI_ChatAI.TITLE_CHAT_AI);
		String chatReply1 = parseStringToObject(PageUI_ChatAI.CHAT_AI_RELLY, "1");
		String USER_ASK1 = parseStringToObject(PageUI_ChatAI.TEXT_USER_ASK, "1");
		getElementPresent(USER_ASK1);
		getElementPresent(chatReply1);
		click(PageUI_ChatAI.ICON_HISTORY);
		getElementPresent(PageUI_ChatAI.TITLE_CHAT_AI);
		String chatReply2 = parseStringToObject(PageUI_ChatAI.CHAT_AI_RELLY_HISTORY, "1");
		String USER_ASK2 = parseStringToObject(PageUI_ChatAI.TEXT_USER_ASK_HISTORY, "1");
		getElementPresent(chatReply2);
		getElementPresent(USER_ASK2);

	}
	@Test

	public void TS_008_Logic_ChatAI_Chat_History_Nhieu_Hon_1_Lich_Su_Chat() {
		info("Open app");
		managementAccount.openHomePageWithLanguage("English");
		sendKeyToElement(PageUI_ChatAI.TEXTBOX_ASK_A_QUESTION, "Hello");
		click(PageUI_ChatAI.BTN_SEND);
		getElementPresent(PageUI_ChatAI.TITLE_CHAT_AI);
		String chatReply1 = parseStringToObject(PageUI_ChatAI.CHAT_AI_RELLY, "1");
		String USER_ASK1 = parseStringToObject(PageUI_ChatAI.TEXT_USER_ASK, "1");
		getElementPresent(USER_ASK1);
		getElementPresent(chatReply1);

		sendKeyToElement(PageUI_ChatAI.TXTB_ASK_A_QUESTION, "Hello");
		click(PageUI_ChatAI.BUTTON_SEND);
		String chatReply2 = parseStringToObject(PageUI_ChatAI.CHAT_AI_RELLY, "2");
		String USER_ASK2 = parseStringToObject(PageUI_ChatAI.TEXT_USER_ASK, "2");
		getElementPresent(USER_ASK2);
		getElementPresent(chatReply2);

		click(PageUI_ChatAI.ICON_HISTORY);
		getElementPresent(PageUI_ChatAI.TITLE_CHAT_AI);
		String chatReply1_1 = parseStringToObject(PageUI_ChatAI.CHAT_AI_RELLY_HISTORY, "1");
		String USER_ASK1_1 = parseStringToObject(PageUI_ChatAI.TEXT_USER_ASK_HISTORY, "1");
		getElementPresent(chatReply1_1);
		getElementPresent(USER_ASK1_1);

		String chatReply2_2 = parseStringToObject(PageUI_ChatAI.CHAT_AI_RELLY, "2");
		String USER_ASK2_2 = parseStringToObject(PageUI_ChatAI.TEXT_USER_ASK, "2");
		getElementPresent(USER_ASK2_2);
		getElementPresent(chatReply2_2);

	}
	@Test
	public void TS_009_Logic_ChatAI_Chat_History_Nhieu_Hon_1_Lich_Su_Chat_Man_Home() {
		info("Open app");
		managementAccount.openHomePageWithLanguage("English");
		sendKeyToElement(PageUI_ChatAI.TEXTBOX_ASK_A_QUESTION, "Hello");
		click(PageUI_ChatAI.BTN_SEND);
		getElementPresent(PageUI_ChatAI.TITLE_CHAT_AI);
		String chatReply1 = parseStringToObject(PageUI_ChatAI.CHAT_AI_RELLY, "1");
		String USER_ASK1 = parseStringToObject(PageUI_ChatAI.TEXT_USER_ASK, "1");
		getElementPresent(USER_ASK1);
		getElementPresent(chatReply1);
		click(PageUI_ChatAI.BTN_LEFT);
		clickElementIfDisplay(PageUI_ChatAI.BTN_LEFT);
		clickElementIfDisplay(PageUI_ChatAI.BTN_DISMISS);

		sendKeyToElement(PageUI_ChatAI.TEXTBOX_ASK_A_QUESTION, "Hello");
		click(PageUI_ChatAI.BTN_SEND);
		getElementPresent(PageUI_ChatAI.TITLE_CHAT_AI);
		String chatReply2 = parseStringToObject(PageUI_ChatAI.CHAT_AI_RELLY, "1");
		String USER_ASK2 = parseStringToObject(PageUI_ChatAI.TEXT_USER_ASK, "1");
		getElementPresent(USER_ASK2);
		getElementPresent(chatReply2);

		click(PageUI_ChatAI.ICON_HISTORY);
		getElementPresent(PageUI_ChatAI.TITLE_CHAT_AI);
		String chatReply1_1 = parseStringToObject(PageUI_ChatAI.CHAT_AI_RELLY_HISTORY, "1");
		String USER_ASK1_1 = parseStringToObject(PageUI_ChatAI.TEXT_USER_ASK_HISTORY, "1");
		getElementPresent(chatReply1_1);
		getElementPresent(USER_ASK1_1);

		String chatReply2_2 = parseStringToObject(PageUI_ChatAI.CHAT_AI_RELLY_HISTORY, "2");
		String USER_ASK2_2 = parseStringToObject(PageUI_ChatAI.TEXT_USER_ASK_HISTORY, "2");
		getElementPresent(chatReply2_2);
		getElementPresent(USER_ASK2_2);

	}
	@Test
	public void TS_010_Logic_ChatAI_Chat_History_Nhap_KHoang_Trang() {
		info("Open app");
		managementAccount.openHomePageWithLanguage("English");
		sendKeyToElement(PageUI_ChatAI.TEXTBOX_ASK_A_QUESTION, "           ");
		click(PageUI_ChatAI.BTN_SEND);
		getElementPresent(PageUI_ChatAI.TITLE_CHAT_AI);
		String chatReply = parseStringToObject(PageUI_ChatAI.CHAT_AI_RELLY, "1");
		getElementPresent(chatReply);
		click(PageUI_ChatAI.ICON_HISTORY);
		getElementPresent(PageUI_ChatAI.TITLE_CHAT_AI);
		String chatReply1 = parseStringToObject(PageUI_ChatAI.CHAT_AI_RELLY_HISTORY, "1");
		String USER_ASK1 = parseStringToObject(PageUI_ChatAI.TEXT_USER_ASK_HISTORY, "1");
		checkElementNotPresent(chatReply1, 3000);
		checkElementNotPresent(USER_ASK1, 3000);

	}
	@Test
	public void TS_011_Logic_ChatAI_Chat_History_Delete_0_Lich_Su() {
		info("Open app");
		managementAccount.openHomePageWithLanguage("English");
		sendKeyToElement(PageUI_ChatAI.TEXTBOX_ASK_A_QUESTION, "           ");
		click(PageUI_ChatAI.BTN_SEND);
		getElementPresent(PageUI_ChatAI.TITLE_CHAT_AI);
		String chatReply = parseStringToObject(PageUI_ChatAI.CHAT_AI_RELLY, "1");
		getElementPresent(chatReply);
		click(PageUI_ChatAI.ICON_HISTORY);

		getElementPresent(PageUI_ChatAI.TITLE_CHAT_AI);
		String chatReply1 = parseStringToObject(PageUI_ChatAI.CHAT_AI_RELLY_HISTORY, "1");
		String USER_ASK1 = parseStringToObject(PageUI_ChatAI.TEXT_USER_ASK_HISTORY, "1");
		checkElementNotPresent(chatReply1, 5000);
		checkElementNotPresent(USER_ASK1, 5000);
		click(PageUI_ChatAI.BTN_DELETE);
		getElementPresent(PageUI_ChatAI.TITLE_HISTORY);
		getElementPresent(PageUI_ChatAI.BTN_DELETE);
	}
	@Test
	public void TS_012_Logic_ChatAI_Chat_History_Delete_Choose_All_1_Lich_Su() {
		info("Open app");
		managementAccount.openHomePageWithLanguage("English");
		sendKeyToElement(PageUI_ChatAI.TEXTBOX_ASK_A_QUESTION, "Hello");
		click(PageUI_ChatAI.BTN_SEND);
		getElementPresent(PageUI_ChatAI.TITLE_CHAT_AI);
		String chatReply = parseStringToObject(PageUI_ChatAI.CHAT_AI_RELLY, "1");
		String USER_ASK = parseStringToObject(PageUI_ChatAI.TEXT_USER_ASK, "1");
		getElementPresent(chatReply);
		getElementPresent(USER_ASK);
		click(PageUI_ChatAI.ICON_HISTORY);
		getElementPresent(PageUI_ChatAI.TITLE_CHAT_AI);
		String chatReply1 = parseStringToObject(PageUI_ChatAI.CHAT_AI_RELLY_HISTORY, "1");
		String USER_ASK1 = parseStringToObject(PageUI_ChatAI.TEXT_USER_ASK_HISTORY, "1");
		getElementPresent(chatReply1);
		getElementPresent(USER_ASK1);
		click(PageUI_ChatAI.BTN_DELETE);
		getElementPresent(PageUI_ChatAI.TEXT_DELETE);
		getElementPresent(PageUI_ChatAI.BTN_LEFT);
		getElementPresent(PageUI_ChatAI.BTN_CHOOSE_ALL);
		String chatReply1_1 = parseStringToObject(PageUI_ChatAI.CHAT_AI_RELLY_HISTORY, "1");
		String USER_ASK1_1 = parseStringToObject(PageUI_ChatAI.TEXT_USER_ASK_HISTORY, "1");
		getElementPresent(chatReply1_1);
		getElementPresent(USER_ASK1_1);
		String chosseConversation = parseStringToObject(PageUI_ChatAI.OPTION_CHOOSE, "1");
		getElementPresent(chosseConversation);
		getElementPresent(PageUI_ChatAI.BUTTON_DELETE);
		click(PageUI_ChatAI.BTN_CHOOSE_ALL);
		pause(3000);
		verifyContains("1", getText(PageUI_ChatAI.BUTTON_DELETE));
		click(PageUI_ChatAI.BUTTON_DELETE);
		getElementPresent(PageUI_ChatAI.TEXT_CONFIRM_DELETE);
		getElementPresent(PageUI_ChatAI.TEXT_SUBMIT_DELETE);
		getElementPresent(PageUI_ChatAI.BTN_CANCEL_DELETE);
		click(PageUI_ChatAI.BTN_CANCEL_DELETE);
		getElementPresent(PageUI_ChatAI.TEXT_DELETE);
		getElementPresent(PageUI_ChatAI.BTN_LEFT);
		getElementPresent(PageUI_ChatAI.BTN_CHOOSE_ALL);
		click(PageUI_ChatAI.BUTTON_DELETE);
		click(PageUI_ChatAI.TEXT_SUBMIT_DELETE);
		getElementPresent(PageUI_ChatAI.TITLE_CHAT_AI);
		getElementPresent(PageUI_ChatAI.ICON_HISTORY);
		getElementPresent(PageUI_ChatAI.ICON_LOUDSPEAKER);
		click(PageUI_ChatAI.ICON_HISTORY);
		checkElementNotPresent(chatReply1, 3000);
		checkElementNotPresent(USER_ASK1, 3000);
	}
	@Test
	public void TS_013_Logic_ChatAI_Chat_History_Delete_Choose_One_1_Lich_Su() {
		info("Open app");
		managementAccount.openHomePageWithLanguage("English");
		sendKeyToElement(PageUI_ChatAI.TEXTBOX_ASK_A_QUESTION, "Hello");
		click(PageUI_ChatAI.BTN_SEND);
		getElementPresent(PageUI_ChatAI.TITLE_CHAT_AI);
		String chatReply = parseStringToObject(PageUI_ChatAI.CHAT_AI_RELLY, "1");
		String USER_ASK = parseStringToObject(PageUI_ChatAI.TEXT_USER_ASK, "1");
		getElementPresent(chatReply);
		getElementPresent(USER_ASK);
		click(PageUI_ChatAI.ICON_HISTORY);
		getElementPresent(PageUI_ChatAI.TITLE_CHAT_AI);
		String chatReply1 = parseStringToObject(PageUI_ChatAI.CHAT_AI_RELLY_HISTORY, "1");
		String USER_ASK1 = parseStringToObject(PageUI_ChatAI.TEXT_USER_ASK_HISTORY, "1");
		getElementPresent(chatReply1);
		getElementPresent(USER_ASK1);
		click(PageUI_ChatAI.BTN_DELETE);
		getElementPresent(PageUI_ChatAI.TEXT_DELETE);
		getElementPresent(PageUI_ChatAI.BTN_LEFT);
		getElementPresent(PageUI_ChatAI.BTN_CHOOSE_ALL);
		String chatReply1_1 = parseStringToObject(PageUI_ChatAI.CHAT_AI_RELLY_HISTORY, "1");
		String USER_ASK1_1 = parseStringToObject(PageUI_ChatAI.TEXT_USER_ASK_HISTORY, "1");
		getElementPresent(chatReply1_1);
		getElementPresent(USER_ASK1_1);
		String chosseConversation = parseStringToObject(PageUI_ChatAI.OPTION_CHOOSE, "1");
		getElementPresent(chosseConversation);
		getElementPresent(PageUI_ChatAI.BUTTON_DELETE);
		click(chosseConversation);
		pause(3000);
		verifyContains("1", getText(PageUI_ChatAI.BUTTON_DELETE));
		click(PageUI_ChatAI.BUTTON_DELETE);
		getElementPresent(PageUI_ChatAI.TEXT_CONFIRM_DELETE);
		getElementPresent(PageUI_ChatAI.TEXT_SUBMIT_DELETE);
		getElementPresent(PageUI_ChatAI.BTN_CANCEL_DELETE);
		click(PageUI_ChatAI.BTN_CANCEL_DELETE);
		getElementPresent(PageUI_ChatAI.TEXT_DELETE);
		getElementPresent(PageUI_ChatAI.BTN_LEFT);
		getElementPresent(PageUI_ChatAI.BTN_CHOOSE_ALL);
		click(PageUI_ChatAI.BUTTON_DELETE);
		click(PageUI_ChatAI.TEXT_SUBMIT_DELETE);
		getElementPresent(PageUI_ChatAI.TITLE_CHAT_AI);
		getElementPresent(PageUI_ChatAI.ICON_HISTORY);
		getElementPresent(PageUI_ChatAI.ICON_LOUDSPEAKER);
		click(PageUI_ChatAI.ICON_HISTORY);
		checkElementNotPresent(chatReply1, 3000);
		checkElementNotPresent(USER_ASK1, 3000);
	}
	@Test
	public void TS_014_Logic_ChatAI_Chat_History_Delete_Choose_All_Nheu_Hon_1_Lich_Su() {
		info("Open app");
		managementAccount.openHomePageWithLanguage("English");
		sendKeyToElement(PageUI_ChatAI.TEXTBOX_ASK_A_QUESTION, "Hello");
		click(PageUI_ChatAI.BTN_SEND);
		getElementPresent(PageUI_ChatAI.TITLE_CHAT_AI);
		String chatReply1 = parseStringToObject(PageUI_ChatAI.CHAT_AI_RELLY, "1");
		String USER_ASK1 = parseStringToObject(PageUI_ChatAI.TEXT_USER_ASK, "1");
		getElementPresent(USER_ASK1);
		getElementPresent(chatReply1);
		sendKeyToElement(PageUI_ChatAI.TXTB_ASK_A_QUESTION, "Hi");
		click(PageUI_ChatAI.BUTTON_SEND);
		getElementPresent(PageUI_ChatAI.TITLE_CHAT_AI);
		String chatReply2 = parseStringToObject(PageUI_ChatAI.CHAT_AI_RELLY, "2");
		String USER_ASK2 = parseStringToObject(PageUI_ChatAI.TEXT_USER_ASK, "2");
		getElementPresent(USER_ASK2);
		getElementPresent(chatReply2);
		click(PageUI_ChatAI.ICON_HISTORY);
		getElementPresent(PageUI_ChatAI.TITLE_CHAT_AI);
		String chatReply1_1 = parseStringToObject(PageUI_ChatAI.CHAT_AI_RELLY_HISTORY, "1");
		String USER_ASK1_1 = parseStringToObject(PageUI_ChatAI.TEXT_USER_ASK_HISTORY, "1");
		getElementPresent(chatReply1_1);
		getElementPresent(USER_ASK1_1);
		String chatReply2_2 = parseStringToObject(PageUI_ChatAI.CHAT_AI_RELLY_HISTORY, "2");
		String USER_ASK2_2 = parseStringToObject(PageUI_ChatAI.TEXT_USER_ASK_HISTORY, "2");
		getElementPresent(chatReply2_2);
		getElementPresent(USER_ASK2_2);
		click(PageUI_ChatAI.BTN_DELETE);
		getElementPresent(PageUI_ChatAI.TEXT_DELETE);
		getElementPresent(PageUI_ChatAI.BTN_LEFT);
		getElementPresent(PageUI_ChatAI.BTN_CHOOSE_ALL);
		String chatReply1_1_1= parseStringToObject(PageUI_ChatAI.CHAT_AI_RELLY_HISTORY, "1");
		String USER_ASK1_1_1 = parseStringToObject(PageUI_ChatAI.TEXT_USER_ASK_HISTORY, "1");
		getElementPresent(chatReply1_1_1);
		getElementPresent(USER_ASK1_1_1);
		String chatReply2_2_2= parseStringToObject(PageUI_ChatAI.CHAT_AI_RELLY_HISTORY, "2");
		String USER_ASK2_2_2 = parseStringToObject(PageUI_ChatAI.TEXT_USER_ASK_HISTORY, "2");
		getElementPresent(chatReply2_2_2);
		getElementPresent(USER_ASK2_2_2);
		String chosseConversation = parseStringToObject(PageUI_ChatAI.OPTION_CHOOSE, "1");
		getElementPresent(chosseConversation);
		String chosseConversation2 = parseStringToObject(PageUI_ChatAI.OPTION_CHOOSE, "2");
		getElementPresent(chosseConversation2);
		getElementPresent(PageUI_ChatAI.BUTTON_DELETE);
		click(PageUI_ChatAI.BTN_CHOOSE_ALL);
		pause(3000);
		verifyContains("2", getText(PageUI_ChatAI.BUTTON_DELETE));
		click(PageUI_ChatAI.BUTTON_DELETE);
		getElementPresent(PageUI_ChatAI.TEXT_CONFIRM_DELETE);
		getElementPresent(PageUI_ChatAI.TEXT_SUBMIT_DELETE);
		getElementPresent(PageUI_ChatAI.BTN_CANCEL_DELETE);
		click(PageUI_ChatAI.BTN_CANCEL_DELETE);
		getElementPresent(PageUI_ChatAI.TEXT_DELETE);
		getElementPresent(PageUI_ChatAI.BTN_LEFT);
		getElementPresent(PageUI_ChatAI.BTN_CHOOSE_ALL);
		click(PageUI_ChatAI.BUTTON_DELETE);
		click(PageUI_ChatAI.TEXT_SUBMIT_DELETE);
		getElementPresent(PageUI_ChatAI.TITLE_CHAT_AI);
		getElementPresent(PageUI_ChatAI.ICON_HISTORY);
		getElementPresent(PageUI_ChatAI.ICON_LOUDSPEAKER);
		click(PageUI_ChatAI.ICON_HISTORY);
		checkElementNotPresent(chatReply1_1,3000);
		checkElementNotPresent(USER_ASK1_1,3000);
		checkElementNotPresent(chatReply2_2,3000);
		checkElementNotPresent(USER_ASK2_2,3000);
	}
	@Test
	public void TS_015_Logic_ChatAI_Chat_History_Delete_Choose_All_Nheu_Hon_1_Lich_Su_ManHome() {
		info("Open app");
		managementAccount.openHomePageWithLanguage("English");
		sendKeyToElement(PageUI_ChatAI.TEXTBOX_ASK_A_QUESTION, "Hello");
		click(PageUI_ChatAI.BTN_SEND);
		getElementPresent(PageUI_ChatAI.TITLE_CHAT_AI);
		String chatReply1 = parseStringToObject(PageUI_ChatAI.CHAT_AI_RELLY, "1");
		String USER_ASK1 = parseStringToObject(PageUI_ChatAI.TEXT_USER_ASK, "1");
		getElementPresent(USER_ASK1);
		getElementPresent(chatReply1);
		click(PageUI_ChatAI.BTN_LEFT);
		clickElementIfDisplay(PageUI_ChatAI.BTN_LEFT);
		clickElementIfDisplay(PageUI_ChatAI.BTN_DISMISS);
		sendKeyToElement(PageUI_ChatAI.TEXTBOX_ASK_A_QUESTION, "Hi");
		click(PageUI_ChatAI.BTN_SEND);
		getElementPresent(PageUI_ChatAI.TITLE_CHAT_AI);
		String chatReply2 = parseStringToObject(PageUI_ChatAI.CHAT_AI_RELLY, "1");
		String USER_ASK2 = parseStringToObject(PageUI_ChatAI.TEXT_USER_ASK, "1");
		getElementPresent(USER_ASK2);
		getElementPresent(chatReply2);
		click(PageUI_ChatAI.ICON_HISTORY);
		getElementPresent(PageUI_ChatAI.TITLE_CHAT_AI);
		String chatReply1_1 = parseStringToObject(PageUI_ChatAI.CHAT_AI_RELLY_HISTORY, "1");
		String USER_ASK1_1 = parseStringToObject(PageUI_ChatAI.TEXT_USER_ASK_HISTORY, "1");
		getElementPresent(chatReply1_1);
		getElementPresent(USER_ASK1_1);
		String chatReply2_2 = parseStringToObject(PageUI_ChatAI.CHAT_AI_RELLY_HISTORY, "2");
		String USER_ASK2_2 = parseStringToObject(PageUI_ChatAI.TEXT_USER_ASK_HISTORY, "2");
		getElementPresent(chatReply2_2);
		getElementPresent(USER_ASK2_2);
		click(PageUI_ChatAI.BTN_DELETE);
		getElementPresent(PageUI_ChatAI.TEXT_DELETE);
		getElementPresent(PageUI_ChatAI.BTN_LEFT);
		getElementPresent(PageUI_ChatAI.BTN_CHOOSE_ALL);
		String chatReply1_1_1= parseStringToObject(PageUI_ChatAI.CHAT_AI_RELLY_HISTORY, "1");
		String USER_ASK1_1_1 = parseStringToObject(PageUI_ChatAI.TEXT_USER_ASK_HISTORY, "1");
		getElementPresent(chatReply1_1_1);
		getElementPresent(USER_ASK1_1_1);
		String chatReply2_2_2= parseStringToObject(PageUI_ChatAI.CHAT_AI_RELLY_HISTORY, "2");
		String USER_ASK2_2_2 = parseStringToObject(PageUI_ChatAI.TEXT_USER_ASK_HISTORY, "2");
		getElementPresent(chatReply2_2_2);
		getElementPresent(USER_ASK2_2_2);
		String chosseConversation = parseStringToObject(PageUI_ChatAI.OPTION_CHOOSE, "1");
		getElementPresent(chosseConversation);
		String chosseConversation2 = parseStringToObject(PageUI_ChatAI.OPTION_CHOOSE, "2");
		getElementPresent(chosseConversation2);
		getElementPresent(PageUI_ChatAI.BUTTON_DELETE);
		click(PageUI_ChatAI.BTN_CHOOSE_ALL);
		pause(3000);
		verifyContains("2", getText(PageUI_ChatAI.BUTTON_DELETE));
		click(PageUI_ChatAI.BUTTON_DELETE);
		getElementPresent(PageUI_ChatAI.TEXT_CONFIRM_DELETE);
		getElementPresent(PageUI_ChatAI.TEXT_SUBMIT_DELETE);
		getElementPresent(PageUI_ChatAI.BTN_CANCEL_DELETE);
		click(PageUI_ChatAI.BTN_CANCEL_DELETE);
		getElementPresent(PageUI_ChatAI.TEXT_DELETE);
		getElementPresent(PageUI_ChatAI.BTN_LEFT);
		getElementPresent(PageUI_ChatAI.BTN_CHOOSE_ALL);
		click(PageUI_ChatAI.BUTTON_DELETE);
		click(PageUI_ChatAI.TEXT_SUBMIT_DELETE);
		getElementPresent(PageUI_ChatAI.TITLE_CHAT_AI);
		getElementPresent(PageUI_ChatAI.ICON_HISTORY);
		getElementPresent(PageUI_ChatAI.ICON_LOUDSPEAKER);
		click(PageUI_ChatAI.ICON_HISTORY);
		checkElementNotPresent(chatReply1_1,3000);
		checkElementNotPresent(USER_ASK1_1,3000);
		checkElementNotPresent(chatReply2_2,3000);
		checkElementNotPresent(USER_ASK2_2,3000);
	}
	@Test
	public void TS_016_Logic_ChatAI_Chat_History_Delete_Choose_One_Nheu_Hon_1_Lich_Su() {
		info("Open app");
		managementAccount.openHomePageWithLanguage("English");
		sendKeyToElement(PageUI_ChatAI.TEXTBOX_ASK_A_QUESTION, "Hello");
		click(PageUI_ChatAI.BTN_SEND);
		getElementPresent(PageUI_ChatAI.TITLE_CHAT_AI);
		String chatReply1 = parseStringToObject(PageUI_ChatAI.CHAT_AI_RELLY, "1");
		String USER_ASK1 = parseStringToObject(PageUI_ChatAI.TEXT_USER_ASK, "1");
		getElementPresent(USER_ASK1);
		getElementPresent(chatReply1);
		click(PageUI_ChatAI.BTN_LEFT);
		clickElementIfDisplay(PageUI_ChatAI.BTN_LEFT);
		clickElementIfDisplay(PageUI_ChatAI.BTN_DISMISS);
		sendKeyToElement(PageUI_ChatAI.TEXTBOX_ASK_A_QUESTION, "Hi");
		click(PageUI_ChatAI.BTN_SEND);
		getElementPresent(PageUI_ChatAI.TITLE_CHAT_AI);
		String chatReply2 = parseStringToObject(PageUI_ChatAI.CHAT_AI_RELLY, "1");
		String USER_ASK2 = parseStringToObject(PageUI_ChatAI.TEXT_USER_ASK, "1");
		getElementPresent(USER_ASK2);
		getElementPresent(chatReply2);
		click(PageUI_ChatAI.ICON_HISTORY);
		getElementPresent(PageUI_ChatAI.TITLE_CHAT_AI);
		String chatReply1_1 = parseStringToObject(PageUI_ChatAI.CHAT_AI_RELLY_HISTORY, "1");
		String USER_ASK1_1 = parseStringToObject(PageUI_ChatAI.TEXT_USER_ASK_HISTORY, "1");
		getElementPresent(chatReply1_1);
		getElementPresent(USER_ASK1_1);
		String chatReply2_2 = parseStringToObject(PageUI_ChatAI.CHAT_AI_RELLY_HISTORY, "2");
		String USER_ASK2_2 = parseStringToObject(PageUI_ChatAI.TEXT_USER_ASK_HISTORY, "2");
		getElementPresent(chatReply2_2);
		getElementPresent(USER_ASK2_2);
		click(PageUI_ChatAI.BTN_DELETE);
		getElementPresent(PageUI_ChatAI.TEXT_DELETE);
		getElementPresent(PageUI_ChatAI.BTN_LEFT);
		getElementPresent(PageUI_ChatAI.BTN_CHOOSE_ALL);
		String chatReply1_1_1= parseStringToObject(PageUI_ChatAI.CHAT_AI_RELLY_HISTORY, "1");
		String USER_ASK1_1_1 = parseStringToObject(PageUI_ChatAI.TEXT_USER_ASK_HISTORY, "1");
		getElementPresent(chatReply1_1_1);
		getElementPresent(USER_ASK1_1_1);
		String chatReply2_2_2= parseStringToObject(PageUI_ChatAI.CHAT_AI_RELLY_HISTORY, "2");
		String USER_ASK2_2_2 = parseStringToObject(PageUI_ChatAI.TEXT_USER_ASK_HISTORY, "2");
		getElementPresent(chatReply2_2_2);
		getElementPresent(USER_ASK2_2_2);
		String chosseConversation = parseStringToObject(PageUI_ChatAI.OPTION_CHOOSE, "1");
		getElementPresent(chosseConversation);
		String chosseConversation2 = parseStringToObject(PageUI_ChatAI.OPTION_CHOOSE, "2");
		getElementPresent(chosseConversation2);
		getElementPresent(PageUI_ChatAI.BUTTON_DELETE);
		click(chosseConversation2);
		pause(3000);
		verifyContains("1", getText(PageUI_ChatAI.BUTTON_DELETE));
		click(PageUI_ChatAI.BUTTON_DELETE);
		getElementPresent(PageUI_ChatAI.TEXT_CONFIRM_DELETE);
		getElementPresent(PageUI_ChatAI.TEXT_SUBMIT_DELETE);
		getElementPresent(PageUI_ChatAI.BTN_CANCEL_DELETE);
		click(PageUI_ChatAI.BTN_CANCEL_DELETE);
		getElementPresent(PageUI_ChatAI.TEXT_DELETE);
		getElementPresent(PageUI_ChatAI.BTN_LEFT);
		getElementPresent(PageUI_ChatAI.BTN_CHOOSE_ALL);
		click(PageUI_ChatAI.BUTTON_DELETE);
		click(PageUI_ChatAI.TEXT_SUBMIT_DELETE);
		getElementPresent(chatReply1_1);
		getElementPresent(USER_ASK1_1);
		checkElementNotPresent(chatReply2_2,3000);
		checkElementNotPresent(USER_ASK2_2,3000);
	}
	@Test
	public void TS_017_Logic_ChatAI_IMG() {
		info("Open app");
		managementAccount.openHomePageWithLanguage("English");
		click(PageUI_ChatAI.BTN_IMAGE);
		getElementPresent(PageUI_ChatAI.TEXT_CHOOSE_ACTION);
		getElementPresent(PageUI_ChatAI.BTN_OPEN_CAMERA);
		getElementPresent(PageUI_ChatAI.BTN_GO_TO_PHOTO);
		getElementPresent(PageUI_ChatAI.BTN_CANCEL_ACTION);
	}

	@Test
	public void TS_018_Logic_ChatAI_IMG_Open_Camera_Retake() {
		info("Open app");
		managementAccount.openHomePageWithLanguage("English");
		click(PageUI_ChatAI.BTN_IMAGE);
		click(PageUI_ChatAI.BTN_OPEN_CAMERA);
		click(PageUI_ChatAI.BTN_TAKE_SCREEN);
		click(PageUI_ChatAI.BTN_RETAKE);
		getElement(PageUI_ChatAI.BTN_TAKE_SCREEN);
	}
	@Test
	public void TS_019_Logic_ChatAI_IMG_Open_Camera_Cancel() {
		info("Open app");
		managementAccount.openHomePageWithLanguage("English");
		click(PageUI_ChatAI.BTN_IMAGE);
		click(PageUI_ChatAI.BTN_OPEN_CAMERA);
		click(PageUI_ChatAI.BTN_TAKE_SCREEN);
		click(PageUI_ChatAI.BTN_CANCEL_IMG);
		getElement(PageUI_ChatAI.TEXT_CHAT_AI);
		getElement(PageUI_ChatAI.ICON_CHAT_AI);
		getElement(PageUI_ChatAI.BTN_SETTING);
	}
	@Test
	public void TS_020_Logic_ChatAI_IMG_Open_Camera_Done() {
		info("Open app");
		managementAccount.openHomePageWithLanguage("English");
		click(PageUI_ChatAI.BTN_IMAGE);
		click(PageUI_ChatAI.BTN_OPEN_CAMERA);
		click(PageUI_ChatAI.BTN_TAKE_SCREEN);
		click(PageUI_ChatAI.BTN_DONE_TAKE_SCREEN);
		click(PageUI_ChatAI.ICON_FLIP);
		click(PageUI_ChatAI.BUTTON_DONE);
		getElement(PageUI_ChatAI.TITLE_CHAT_AI);
		getElement(PageUI_ChatAI.ICON_HISTORY);
		getElement(PageUI_ChatAI.ICON_LOUDSPEAKER);
		getElement(PageUI_ChatAI.TEXT_ENTER_PROMPTS);
		getElement(PageUI_ChatAI.IMG_PHOTO_TAKEN);
		getElement(PageUI_ChatAI.BTN_CLOSE_IMG);
		getElement(PageUI_ChatAI.TXTB_ASK_A_QUESTION);
		getElement(PageUI_ChatAI.BUTTON_SEND);
	}
	@Test
	public void TS_021_Logic_ChatAI_IMG_Open_Camera_Done_Option_Version_Chat_GPT() {
		info("Open app");
		managementAccount.openHomePageWithLanguage("English");
		click(PageUI_ChatAI.BTN_IMAGE);
		click(PageUI_ChatAI.BTN_OPEN_CAMERA);
		click(PageUI_ChatAI.BTN_TAKE_SCREEN);
		click(PageUI_ChatAI.BTN_DONE_TAKE_SCREEN);
		click(PageUI_ChatAI.BTN_ROTATE);
		click(PageUI_ChatAI.BUTTON_DONE);
		click(PageUI_ChatAI.TITLE_CHAT_AI);
		getElement(PageUI_ChatAI.TEXT_SELECT_MODEL_GPT);
		getElement(PageUI_ChatAI.CARD_GPT_3_5);
		getElement(PageUI_ChatAI.CARD_GPT_4_0);
		getElement(PageUI_ChatAI.BTN_CONTINUE_TO_CHAT);
		click(PageUI_ChatAI.CARD_GPT_3_5);
		click(PageUI_ChatAI.BTN_CONTINUE_TO_CHAT);
		getElement(PageUI_ChatAI.TITLE_CHAT_AI);
		getElement(PageUI_ChatAI.ICON_HISTORY);
		getElement(PageUI_ChatAI.ICON_LOUDSPEAKER);
		getElement(PageUI_ChatAI.TEXT_ENTER_PROMPTS);
		click(PageUI_ChatAI.TITLE_CHAT_AI);
		click(PageUI_ChatAI.CARD_GPT_4_0);
		click(PageUI_ChatAI.BTN_CONTINUE_TO_CHAT);
		getElement(PageUI_ChatAI.TEXT_GPT_UPGRADE);
		getElement(PageUI_ChatAI.TAB_YEARLY);
		getElement(PageUI_ChatAI.TAB_WEEKLY);
		click(PageUI_ChatAI.BTN_CLOSE_UPGRADE);
		getElement(PageUI_ChatAI.TITLE_CHAT_AI);
		getElement(PageUI_ChatAI.ICON_HISTORY);
		getElement(PageUI_ChatAI.ICON_LOUDSPEAKER);
		getElement(PageUI_ChatAI.TEXT_ENTER_PROMPTS);
	}
	@Test
	public void TS_022_Logic_ChatAI_IMG_Open_Camera_Done_Close() {
		info("Open app");
		managementAccount.openHomePageWithLanguage("English");
		click(PageUI_ChatAI.BTN_IMAGE);
		click(PageUI_ChatAI.BTN_OPEN_CAMERA);
		click(PageUI_ChatAI.BTN_TAKE_SCREEN);
		click(PageUI_ChatAI.BTN_DONE_TAKE_SCREEN);
		click(PageUI_ChatAI.BUTTON_DONE);
		click(PageUI_ChatAI.BTN_CLOSE_IMG);
		getElement(PageUI_ChatAI.TEXT_CONTENT_ANSWER);
		getElement(PageUI_ChatAI.BTN_IMAGE);
		getElement(PageUI_ChatAI.BTN_VOID_CHAT);
	}
	@Test
	public void TS_023_Logic_ChatAI_IMG_Open_Camera_Done_Promots_Mac_Dinh() {
		info("Open app");
		managementAccount.openHomePageWithLanguage("English");
		click(PageUI_ChatAI.BTN_IMAGE);
		click(PageUI_ChatAI.BTN_OPEN_CAMERA);
		click(PageUI_ChatAI.BTN_TAKE_SCREEN);
		click(PageUI_ChatAI.BTN_DONE_TAKE_SCREEN);
		click(PageUI_ChatAI.ICON_FLIP);
		click(PageUI_ChatAI.BUTTON_DONE);
		verifyNotNull(getText(PageUI_ChatAI.TXTB_ASK_A_QUESTION));
		click(PageUI_ChatAI.BUTTON_SEND);
		getElement(PageUI_ChatAI.IMG_PHOTO_TAKEN);
		getElement(PageUI_ChatAI.TEXTBOX_ANSWER_USER);
		getElement(PageUI_ChatAI.TEXT_CONTENT_ANSWER);
		getElement(PageUI_ChatAI.BTN_REGENERATE);
		getElement(PageUI_ChatAI.BTN_COPY);
		getElement(PageUI_ChatAI.BUTTON_SHARE);
	}
	@Test
	public void TS_024_Logic_ChatAI_IMG_Open_Camera_Done_Promots_Mac_Dinh() {
		info("Open app");
		managementAccount.openHomePageWithLanguage("English");
		click(PageUI_ChatAI.BTN_IMAGE);
		click(PageUI_ChatAI.BTN_OPEN_CAMERA);
		click(PageUI_ChatAI.BTN_TAKE_SCREEN);
		click(PageUI_ChatAI.BTN_DONE_TAKE_SCREEN);
		click(PageUI_ChatAI.ICON_FLIP);
		click(PageUI_ChatAI.BUTTON_DONE);
		verifyNotNull(getText(PageUI_ChatAI.TXTB_ASK_A_QUESTION));
		click(PageUI_ChatAI.BUTTON_SEND);
		pause(7000);
		getElement(PageUI_ChatAI.IMG_PHOTO_TAKEN);
		getElement(PageUI_ChatAI.TEXTBOX_ANSWER_USER);
		getElement(PageUI_ChatAI.TEXT_CONTENT_ANSWER);
		getElement(PageUI_ChatAI.BTN_REGENERATE);
		getElement(PageUI_ChatAI.BTN_COPY);
		getElement(PageUI_ChatAI.BUTTON_SHARE);
	}
	@Test
	public void TS_025_Logic_ChatAI_IMG_Open_Camera_Done_Promots_Nhap_Khoang_Trang() {
		info("Open app");
		managementAccount.openHomePageWithLanguage("English");
		click(PageUI_ChatAI.BTN_IMAGE);
		click(PageUI_ChatAI.BTN_OPEN_CAMERA);
		click(PageUI_ChatAI.BTN_TAKE_SCREEN);
		click(PageUI_ChatAI.BTN_DONE_TAKE_SCREEN);
		click(PageUI_ChatAI.ICON_FLIP);
		click(PageUI_ChatAI.BUTTON_DONE);
		sendKeyToElement(PageUI_ChatAI.TXTB_ASK_A_QUESTION,"          ");
		click(PageUI_ChatAI.BUTTON_SEND);
		pause(7000);
		getElement(PageUI_ChatAI.IMG_PHOTO_TAKEN);
		getElement(PageUI_ChatAI.ICON_HISTORY);
		getElement(PageUI_ChatAI.ICON_LOUDSPEAKER);
		getElement(PageUI_ChatAI.TEXT_ENTER_PROMPTS);
		getElement(PageUI_ChatAI.BTN_CLOSE_IMG);
		getElement(PageUI_ChatAI.TXTB_ASK_A_QUESTION);
		getElement(PageUI_ChatAI.BUTTON_SEND);
	}
	@Test
	public void TS_026_Logic_ChatAI_IMG_Open_Camera_Done_Promots_Nhap_Nhieu_Hon_300_Ky_Tu() {
		info("Open app");
		managementAccount.openHomePageWithLanguage("English");
		click(PageUI_ChatAI.BTN_IMAGE);
		click(PageUI_ChatAI.BTN_OPEN_CAMERA);
		click(PageUI_ChatAI.BTN_TAKE_SCREEN);
		click(PageUI_ChatAI.BTN_DONE_TAKE_SCREEN);
		click(PageUI_ChatAI.ICON_FLIP);
		click(PageUI_ChatAI.BUTTON_DONE);
		sendKeyToElement(PageUI_ChatAI.TXTB_ASK_A_QUESTION,generateRandomString(400));
		verifyCompare("300/300", getText(PageUI_ChatAI.TEXT_NUMBER_OF_CHARACTERS));
		click(PageUI_ChatAI.BUTTON_SEND);
		pause(7000);
		getElement(PageUI_ChatAI.IMG_PHOTO_TAKEN);
		getElement(PageUI_ChatAI.TEXTBOX_ANSWER_USER);
		getElement(PageUI_ChatAI.TEXT_CONTENT_ANSWER);
		getElement(PageUI_ChatAI.BTN_REGENERATE);
		getElement(PageUI_ChatAI.BTN_COPY);
		getElement(PageUI_ChatAI.BUTTON_SHARE);
	}
	@Test
	public void TS_027_Logic_ChatAI_IMG_Open_Camera_Done_Promots_Nhap_Noi_Dung_Hop_Le() {
		info("Open app");
		managementAccount.openHomePageWithLanguage("English");
		click(PageUI_ChatAI.BTN_IMAGE);
		click(PageUI_ChatAI.BTN_OPEN_CAMERA);
		click(PageUI_ChatAI.BTN_TAKE_SCREEN);
		click(PageUI_ChatAI.BTN_DONE_TAKE_SCREEN);
		click(PageUI_ChatAI.ICON_FLIP);
		click(PageUI_ChatAI.BUTTON_DONE);
		sendKeyToElement(PageUI_ChatAI.TXTB_ASK_A_QUESTION,"Hello World");
		click(PageUI_ChatAI.BUTTON_SEND);
		pause(7000);
		getElement(PageUI_ChatAI.IMG_PHOTO_TAKEN);
		getElement(PageUI_ChatAI.TEXTBOX_ANSWER_USER);
		getElement(PageUI_ChatAI.TEXT_CONTENT_ANSWER);
		getElement(PageUI_ChatAI.BTN_REGENERATE);
		getElement(PageUI_ChatAI.BTN_COPY);
		getElement(PageUI_ChatAI.BUTTON_SHARE);
	}
	@Test
	public void TS_028_Logic_ChatAI_IMG_Open_Camera_Done_Back() {
		info("Open app");
		managementAccount.openHomePageWithLanguage("English");
		click(PageUI_ChatAI.BTN_IMAGE);
		click(PageUI_ChatAI.BTN_OPEN_CAMERA);
		click(PageUI_ChatAI.BTN_TAKE_SCREEN);
		click(PageUI_ChatAI.BTN_DONE_TAKE_SCREEN);
		click(PageUI_ChatAI.BUTTON_DONE);
		click(PageUI_ChatAI.BTN_LEFT);
		clickElementIfDisplay(PageUI_ChatAI.BTN_LEFT);
		getElement(PageUI_ChatAI.TEXT_CHAT_AI);
		getElement(PageUI_ChatAI.BTN_SETTING);
		getElement(PageUI_ChatAI.TEXT_IMAGE_GENERATOR);
		click(PageUI_ChatAI.BTN_IMAGE);
		click(PageUI_ChatAI.BTN_OPEN_CAMERA);
		click(PageUI_ChatAI.BTN_TAKE_SCREEN);
		click(PageUI_ChatAI.BTN_DONE_TAKE_SCREEN);
		click(PageUI_ChatAI.ICON_IV_BACK);
		getElement(PageUI_ChatAI.TEXT_CHAT_AI);
		getElement(PageUI_ChatAI.BTN_SETTING);
		getElement(PageUI_ChatAI.TEXT_IMAGE_GENERATOR);
	}
	@Test
	public void TS_029_Logic_ChatAI_IMG_Go_To_Photos_Option_Version_Chat_GPT() {
		info("Open app");
		managementAccount.openHomePageWithLanguage("English");
		click(PageUI_ChatAI.BTN_IMAGE);
		click(PageUI_ChatAI.BTN_GO_TO_PHOTO);
		getElement(PageUI_ChatAI.LIST_IMG);
		getElement(PageUI_ChatAI.TITLE_CHOOSE_PHOTOS);
		click(PageUI_ChatAI.IMG_1);
		click(PageUI_ChatAI.BUTTON_DONE);
		click(PageUI_ChatAI.TITLE_CHAT_AI);
		getElement(PageUI_ChatAI.TEXT_SELECT_MODEL_GPT);
		getElement(PageUI_ChatAI.CARD_GPT_3_5);
		getElement(PageUI_ChatAI.CARD_GPT_4_0);
		getElement(PageUI_ChatAI.BTN_CONTINUE_TO_CHAT);
		click(PageUI_ChatAI.CARD_GPT_3_5);
		click(PageUI_ChatAI.BTN_CONTINUE_TO_CHAT);
		getElement(PageUI_ChatAI.TITLE_CHAT_AI);
		getElement(PageUI_ChatAI.ICON_HISTORY);
		getElement(PageUI_ChatAI.ICON_LOUDSPEAKER);
		getElement(PageUI_ChatAI.TEXT_ENTER_PROMPTS);
		click(PageUI_ChatAI.TITLE_CHAT_AI);
		click(PageUI_ChatAI.CARD_GPT_4_0);
		click(PageUI_ChatAI.BTN_CONTINUE_TO_CHAT);
		getElement(PageUI_ChatAI.TEXT_GPT_UPGRADE);
		getElement(PageUI_ChatAI.TAB_YEARLY);
		getElement(PageUI_ChatAI.TAB_WEEKLY);
		click(PageUI_ChatAI.BTN_CLOSE_UPGRADE);
		getElement(PageUI_ChatAI.TITLE_CHAT_AI);
		getElement(PageUI_ChatAI.ICON_HISTORY);
		getElement(PageUI_ChatAI.ICON_LOUDSPEAKER);
		getElement(PageUI_ChatAI.TEXT_ENTER_PROMPTS);
	}
	@Test
	public void TS_030_Logic_ChatAI_IMG_Go_To_Photos_Close() {
		info("Open app");
		managementAccount.openHomePageWithLanguage("English");
		click(PageUI_ChatAI.BTN_IMAGE);
		click(PageUI_ChatAI.BTN_GO_TO_PHOTO);
		getElement(PageUI_ChatAI.LIST_IMG);
		getElement(PageUI_ChatAI.TITLE_CHOOSE_PHOTOS);
		click(PageUI_ChatAI.IMG_1);
		click(PageUI_ChatAI.ICON_FLIP);
		click(PageUI_ChatAI.BUTTON_DONE);
		click(PageUI_ChatAI.BTN_CLOSE_IMG);
		getElement(PageUI_ChatAI.TEXT_CONTENT_ANSWER);
		getElement(PageUI_ChatAI.BTN_IMAGE);
		getElement(PageUI_ChatAI.BTN_VOID_CHAT);
	}
	@Test
	public void TS_031_Logic_ChatAI_IMG_Go_To_Photos_Promots_Mac_Dinh() {
		info("Open app");
		managementAccount.openHomePageWithLanguage("English");
		click(PageUI_ChatAI.BTN_IMAGE);
		click(PageUI_ChatAI.BTN_GO_TO_PHOTO);
		getElement(PageUI_ChatAI.LIST_IMG);
		getElement(PageUI_ChatAI.TITLE_CHOOSE_PHOTOS);
		click(PageUI_ChatAI.IMG_1);
		click(PageUI_ChatAI.ICON_FLIP);
		click(PageUI_ChatAI.BUTTON_DONE);
		verifyNotNull(getText(PageUI_ChatAI.TXTB_ASK_A_QUESTION));
		click(PageUI_ChatAI.BUTTON_SEND);
		getElement(PageUI_ChatAI.IMG_PHOTO_TAKEN);
		getElement(PageUI_ChatAI.TEXTBOX_ANSWER_USER);
		getElement(PageUI_ChatAI.TEXT_CONTENT_ANSWER);
		getElement(PageUI_ChatAI.BTN_REGENERATE);
		getElement(PageUI_ChatAI.BTN_COPY);
		getElement(PageUI_ChatAI.BUTTON_SHARE);
	}
	@Test
	public void TS_032_Logic_ChatAI_IMG_Go_To_Photos_Promots_Mac_Dinh() {
		info("Open app");
		managementAccount.openHomePageWithLanguage("English");
		click(PageUI_ChatAI.BTN_IMAGE);
		click(PageUI_ChatAI.BTN_GO_TO_PHOTO);
		getElement(PageUI_ChatAI.LIST_IMG);
		getElement(PageUI_ChatAI.TITLE_CHOOSE_PHOTOS);
		click(PageUI_ChatAI.IMG_1);
		click(PageUI_ChatAI.BUTTON_DONE);
		verifyNotNull(getText(PageUI_ChatAI.TXTB_ASK_A_QUESTION));
		click(PageUI_ChatAI.BUTTON_SEND);
		pause(7000);
		getElement(PageUI_ChatAI.IMG_PHOTO_TAKEN);
		getElement(PageUI_ChatAI.TEXTBOX_ANSWER_USER);
		getElement(PageUI_ChatAI.TEXT_CONTENT_ANSWER);
		getElement(PageUI_ChatAI.BTN_REGENERATE);
		getElement(PageUI_ChatAI.BTN_COPY);
		getElement(PageUI_ChatAI.BUTTON_SHARE);
	}
	@Test
	public void TS_033_Logic_ChatAI_IMG_Go_To_Photos_Promots_Nhap_Khoang_Trang() {
		info("Open app");
		managementAccount.openHomePageWithLanguage("English");
		click(PageUI_ChatAI.BTN_IMAGE);
		click(PageUI_ChatAI.BTN_GO_TO_PHOTO);
		getElement(PageUI_ChatAI.LIST_IMG);
		getElement(PageUI_ChatAI.TITLE_CHOOSE_PHOTOS);
		click(PageUI_ChatAI.IMG_1);
		click(PageUI_ChatAI.BUTTON_DONE);
		sendKeyToElement(PageUI_ChatAI.TXTB_ASK_A_QUESTION,"          ");
		click(PageUI_ChatAI.BUTTON_SEND);
		pause(7000);
		getElement(PageUI_ChatAI.IMG_PHOTO_TAKEN);
		getElement(PageUI_ChatAI.ICON_HISTORY);
		getElement(PageUI_ChatAI.ICON_LOUDSPEAKER);
		getElement(PageUI_ChatAI.TEXT_ENTER_PROMPTS);
		getElement(PageUI_ChatAI.BTN_CLOSE_IMG);
		getElement(PageUI_ChatAI.TXTB_ASK_A_QUESTION);
		getElement(PageUI_ChatAI.BUTTON_SEND);
	}
	@Test
	public void TS_034_Logic_ChatAI_IMG_Go_To_Photos_Promots_Nhap_Nhieu_Hon_300_Ky_Tu() {
		info("Open app");
		managementAccount.openHomePageWithLanguage("English");
		click(PageUI_ChatAI.BTN_IMAGE);
		click(PageUI_ChatAI.BTN_GO_TO_PHOTO);
		getElement(PageUI_ChatAI.LIST_IMG);
		getElement(PageUI_ChatAI.TITLE_CHOOSE_PHOTOS);
		click(PageUI_ChatAI.IMG_1);
		click(PageUI_ChatAI.BUTTON_DONE);
		sendKeyToElement(PageUI_ChatAI.TXTB_ASK_A_QUESTION,generateRandomString(400));
		verifyCompare("300/300", getText(PageUI_ChatAI.TEXT_NUMBER_OF_CHARACTERS));
		click(PageUI_ChatAI.BUTTON_SEND);
		pause(7000);
		getElement(PageUI_ChatAI.IMG_PHOTO_TAKEN);
		getElement(PageUI_ChatAI.TEXTBOX_ANSWER_USER);
		getElement(PageUI_ChatAI.TEXT_CONTENT_ANSWER);
		getElement(PageUI_ChatAI.BTN_REGENERATE);
		getElement(PageUI_ChatAI.BTN_COPY);
		getElement(PageUI_ChatAI.BUTTON_SHARE);
	}
	@Test
	public void TS_035_Logic_ChatAI_IMG_Go_To_Photos_Promots_Nhap_Noi_Dung_Hop_Le() {
		info("Open app");
		managementAccount.openHomePageWithLanguage("English");
		click(PageUI_ChatAI.BTN_IMAGE);
		click(PageUI_ChatAI.BTN_GO_TO_PHOTO);
		getElement(PageUI_ChatAI.LIST_IMG);
		getElement(PageUI_ChatAI.TITLE_CHOOSE_PHOTOS);
		click(PageUI_ChatAI.IMG_1);
		click(PageUI_ChatAI.BUTTON_DONE);
		sendKeyToElement(PageUI_ChatAI.TXTB_ASK_A_QUESTION,"Hello World");
		click(PageUI_ChatAI.BUTTON_SEND);
		pause(7000);
		getElement(PageUI_ChatAI.IMG_PHOTO_TAKEN);
		getElement(PageUI_ChatAI.TEXTBOX_ANSWER_USER);
		getElement(PageUI_ChatAI.TEXT_CONTENT_ANSWER);
		getElement(PageUI_ChatAI.BTN_REGENERATE);
		getElement(PageUI_ChatAI.BTN_COPY);
		getElement(PageUI_ChatAI.BUTTON_SHARE);
	}
	@Test
	public void TS_036_Logic_ChatAI_IMG_Go_To_Photos_Back() {
		info("Open app");
		managementAccount.openHomePageWithLanguage("English");
		click(PageUI_ChatAI.BTN_IMAGE);
		click(PageUI_ChatAI.BTN_GO_TO_PHOTO);
		getElement(PageUI_ChatAI.LIST_IMG);
		getElement(PageUI_ChatAI.TITLE_CHOOSE_PHOTOS);
		click(PageUI_ChatAI.IMG_1);
		click(PageUI_ChatAI.BUTTON_DONE);
		click(PageUI_ChatAI.BTN_LEFT);
		clickElementIfDisplay(PageUI_ChatAI.BTN_LEFT);
		getElement(PageUI_ChatAI.TEXT_CHAT_AI);
		getElement(PageUI_ChatAI.BTN_SETTING);
		getElement(PageUI_ChatAI.TEXT_IMAGE_GENERATOR);
		click(PageUI_ChatAI.BTN_IMAGE);
		click(PageUI_ChatAI.BTN_OPEN_CAMERA);
		click(PageUI_ChatAI.BTN_TAKE_SCREEN);
		click(PageUI_ChatAI.BTN_DONE_TAKE_SCREEN);
		click(PageUI_ChatAI.ICON_IV_BACK);
		getElement(PageUI_ChatAI.TEXT_CHAT_AI);
		getElement(PageUI_ChatAI.BTN_SETTING);
		getElement(PageUI_ChatAI.TEXT_IMAGE_GENERATOR);
	}
	@Test
	public void TS_037_Logic_ChatAI_IMG_Cancel() {
		info("Open app");
		managementAccount.openHomePageWithLanguage("English");
		click(PageUI_ChatAI.BTN_IMAGE);
		getElementPresent(PageUI_ChatAI.TEXT_CHOOSE_ACTION);
		getElementPresent(PageUI_ChatAI.BTN_OPEN_CAMERA);
		getElementPresent(PageUI_ChatAI.BTN_GO_TO_PHOTO);
		click(PageUI_ChatAI.BTN_CANCEL_ACTION);
		getElementPresent(PageUI_ChatAI.TEXT_CHAT_AI);
		getElementPresent(PageUI_ChatAI.BTN_SETTING);
		getElementPresent(PageUI_ChatAI.TEXT_IMAGE_GENERATOR);
	}
	@Test
	public void TS_038_Logic_ChatAI_Mic() {
		info("Open app");
		managementAccount.openHomePageWithLanguage("English");
		click(PageUI_ChatAI.BTN_VOID_CHAT);
		getElementPresent(PageUI_ChatAI.TITLE_VOID_CHAT);
		getElementPresent(PageUI_ChatAI.IMG_MIC);
		getElementPresent(PageUI_ChatAI.TEXT_TRY_TO_SAY_SOMETHING);
		click(PageUI_ChatAI.TEXT_LANGUAGE);
		getElementPresent(PageUI_ChatAI.TITLE_CHANGE_LANGUAGE);
		getElementPresent(PageUI_ChatAI.LIST_LANGUAGE_MIC);
		getElementPresent(PageUI_ChatAI.LIST_FLAG_MIC);
		click(PageUI_ChatAI.BUTTON_DONE);
		getListElement(PageUI_ChatAI.LIST_LANGUAGE_MIC);
		clickListElement(PageUI_ChatAI.LIST_LANGUAGE_MIC, 3);
		getElementPresent(PageUI_ChatAI.TEXT_CONTENT_ANSWER);
		getElementPresent(PageUI_ChatAI.ICON_HISTORY);
		getElementPresent(PageUI_ChatAI.ICON_LOUDSPEAKER);
		getElementPresent(PageUI_ChatAI.TITLE_CHAT_AI);
		getElementPresent(PageUI_ChatAI.TXTB_ASK_A_QUESTION);
		click(PageUI_ChatAI.BTN_VOID_CHAT);
		click(PageUI_ChatAI.TEXT_LANGUAGE);
		getListElement(PageUI_ChatAI.LIST_LANGUAGE_MIC);
		clickListElement(PageUI_ChatAI.LIST_LANGUAGE_MIC, 5);
		getElementPresent(PageUI_ChatAI.TEXT_CONTENT_ANSWER);
		getElementPresent(PageUI_ChatAI.ICON_HISTORY);
		getElementPresent(PageUI_ChatAI.ICON_LOUDSPEAKER);
		getElementPresent(PageUI_ChatAI.TITLE_CHAT_AI);
		getElementPresent(PageUI_ChatAI.TXTB_ASK_A_QUESTION);
		click(PageUI_ChatAI.BTN_VOID_CHAT);
		click(PageUI_ChatAI.TEXT_LANGUAGE);
		getListElement(PageUI_ChatAI.LIST_LANGUAGE_MIC);
		clickListElement(PageUI_ChatAI.LIST_LANGUAGE_MIC, 4);
		getElementPresent(PageUI_ChatAI.TEXT_CONTENT_ANSWER);
		getElementPresent(PageUI_ChatAI.ICON_HISTORY);
		getElementPresent(PageUI_ChatAI.ICON_LOUDSPEAKER);
		getElementPresent(PageUI_ChatAI.TITLE_CHAT_AI);
		getElementPresent(PageUI_ChatAI.TXTB_ASK_A_QUESTION);
		click(PageUI_ChatAI.BTN_VOID_CHAT);
		click(PageUI_ChatAI.TEXT_LANGUAGE);
		getListElement(PageUI_ChatAI.LIST_LANGUAGE_MIC);
		clickListElement(PageUI_ChatAI.LIST_LANGUAGE_MIC, 7);
		getElementPresent(PageUI_ChatAI.TEXT_CONTENT_ANSWER);
		getElementPresent(PageUI_ChatAI.ICON_HISTORY);
		getElementPresent(PageUI_ChatAI.ICON_LOUDSPEAKER);
		getElementPresent(PageUI_ChatAI.TITLE_CHAT_AI);
		getElementPresent(PageUI_ChatAI.TXTB_ASK_A_QUESTION);
	}

	private Management_Account managementAccount;
}
