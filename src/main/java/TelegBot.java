import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;

public class TelegBot extends TelegramLongPollingBot {
    @Override
    public void onUpdateReceived(Update update) {
        Message message = update.getMessage();
        System.out.println(message);
        System.out.println(message.getText());
    }

    @Override
    public String getBotUsername() {
        return ConstTeleg.BotName;
    }

    @Override
    public String getBotToken() {
        return ConstTeleg.BotToken;
    }
}
