package dev.lrxh.config;

import org.bukkit.configuration.Configuration;

import java.util.List;

public interface IConfig {
    void addComment(Configuration configuration, String path, List<String> comments);
}
