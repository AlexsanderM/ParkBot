import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.util.Calendar;
import java.util.Date;
import java.util.regex.Pattern;

public class TelegBot extends TelegramLongPollingBot {
    @Override
    public void onUpdateReceived(Update update) {
        Message message = update.getMessage();
        System.out.println(message);

        if (message.getChatId() == 130116992) {
            DataTable dataTable = new DataTable();
            int row = dataTable.getRowDate();
            String textMessage = message.getText().toLowerCase().trim();
            boolean flagFormat = Pattern.matches("^[ì]+\\s\\d\\s[æ]+\\s\\d$", textMessage);

            Date dateDay = new Date((long)message.getDate() * 1000);

//            System.out.println(message.getText());
//            System.out.println(message.getDate());
//            Date d = new Date();
//            d.setTime(message.getDate() * 1000);
//            Calendar c = Calendar.getInstance();
//            c.setTime(dateDay);
//            System.out.println(c.getTime());

            if (flagFormat) {
                char[] charMessage = textMessage.toCharArray();
            }

            System.out.println(textMessage.charAt(0) == 'ì');
        }
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
