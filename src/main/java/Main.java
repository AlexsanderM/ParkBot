import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiRequestException;

public class Main {
    public static void main(String[] args) {
        ApiContextInitializer.init();
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi();
        //DefaultBotOptions botOptions = ApiContext.getInstance(DefaultBotOptions.class);
//        System.setProperty("java.net.useSystemProxies", "true");

        try {
            telegramBotsApi.registerBot(new TelegBot());
        } catch (TelegramApiRequestException e) {
            e.printStackTrace();
        }
    }


}
