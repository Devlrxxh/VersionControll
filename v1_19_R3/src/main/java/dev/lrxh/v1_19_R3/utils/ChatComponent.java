package dev.lrxh.v1_19_R3.utils;

import dev.lrxh.utils.chatComponent.IChatComponent;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.event.ClickEvent;
import net.kyori.adventure.text.event.HoverEvent;

public class ChatComponent implements IChatComponent {

    @Override
    @SuppressWarnings("unchecked")
    public <T> T create(dev.lrxh.utils.chatComponent.ChatComponent chatComponent) {
        return (T) Component.text(chatComponent.getText())
                .clickEvent(ClickEvent.runCommand(chatComponent.getClickEvent()))
                .hoverEvent(HoverEvent.showText(Component.text(chatComponent.getHoverEvent())));
    }
}
