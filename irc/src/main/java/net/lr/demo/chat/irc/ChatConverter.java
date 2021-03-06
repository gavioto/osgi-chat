package net.lr.demo.chat.irc;

import org.apache.camel.Message;
import org.apache.camel.component.irc.IrcMessage;

import net.lr.demo.chat.service.ChatMessage;

public class ChatConverter {
    public ChatMessage convert(Message message) {
        IrcMessage ircMessage = (IrcMessage) message;
        String msg = ircMessage.getMessage() != null ? ircMessage.getMessage() : ircMessage.getMessageType();
        return new ChatMessage("irc", ircMessage.getUser().getNick(), msg);
    }
}
