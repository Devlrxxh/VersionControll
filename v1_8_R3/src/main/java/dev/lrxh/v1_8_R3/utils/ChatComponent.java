package dev.lrxh.v1_8_R3.utils;

import dev.lrxh.utils.chatComponent.IChatComponent;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;

public class ChatComponent implements IChatComponent {
    @Override
    @SuppressWarnings("unchecked")
    public <T> T create(dev.lrxh.utils.chatComponent.ChatComponent chatComponent) {
        TextComponent textComponent = new TextComponent(chatComponent.getText());
        textComponent.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT,
                new ComponentBuilder(chatComponent.getClickEvent()).create()));
        textComponent.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, chatComponent.getHoverEvent()));
        return (T) textComponent;
    }
}