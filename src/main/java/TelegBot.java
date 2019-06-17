import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.io.IOException;
import java.security.GeneralSecurityException;
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
            int rowDate = dataTable.getRowDate();
            int rowTime = dataTable.getRowTime(rowDate);
            String textMessage = message.getText().toLowerCase().trim();
            boolean flagFormat = Pattern.matches("^[м]+\\s\\d+\\s[ж]+\\s\\d+$", textMessage);

            Date dateDay = new Date((long) message.getDate() * 1000);

            if (flagFormat) {
                String[] strMessge = textMessage.split(" ");
                String countMen = strMessge[1];
                String countWomen = strMessge[3];

                System.out.println(countMen);
                System.out.println(countWomen);
                Google google = null;

                try {
                    google = new Google();
                    google.addValueTable("C", rowTime, countMen);
                    google.addValueTable("D", rowTime, countWomen);

//                    sendMes(message, "Добавлен в отчет");
                } catch (GeneralSecurityException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
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

    private void sendMes(Message message, String send) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.enableMarkdown(true);
        sendMessage.setChatId(message.getChatId().toString());
        sendMessage.setReplyToMessageId(message.getMessageId());
        sendMessage.setText(send);
    }
}
