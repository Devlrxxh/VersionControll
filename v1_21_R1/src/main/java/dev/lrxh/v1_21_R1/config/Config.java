package dev.lrxh.v1_21_R1.config;

import dev.lrxh.config.IConfig;
import org.bukkit.configuration.Configuration;

import java.util.List;

public class Config implements IConfig {
    @Override
    public void addComment(Configuration configuration, String path, List<String> comments) {
        configuration.setInlineComments(path, comments);
    }
}
