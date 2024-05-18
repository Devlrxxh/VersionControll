package dev.lrxh.v1_8_R3.utils;

import dev.lrxh.utils.chatComponent.IChatComponent;
import net.md_5.bungee.api.chat.*;

public class ChatComponent implements IChatComponent {
    @Override
    @SuppressWarnings("unchecked")
    public <T> T create(dev.lrxh.utils.chatComponent.ChatComponent chatComponent) {
        BaseComponent baseComponent = new TextComponent(chatComponent.getText());
        baseComponent.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT,
                new ComponentBuilder(chatComponent.getClickEvent()).create()));
        baseComponent.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, chatComponent.getHoverEvent()));
        return (T) baseComponent;
    }
}