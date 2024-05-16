package dev.lrxh.gameRule;

import org.bukkit.World;

public interface IGameRule {
    void setGameRule(World world, GameRule gameRule, boolean value);
}
