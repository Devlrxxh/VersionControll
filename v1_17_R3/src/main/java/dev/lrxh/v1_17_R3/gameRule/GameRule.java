package dev.lrxh.v1_17_R3.gameRule;

import dev.lrxh.gameRule.IGameRule;
import org.bukkit.World;

public class GameRule implements IGameRule {
    @Override
    public void setGameRule(World world, dev.lrxh.gameRule.GameRule gameRule, boolean value) {
        if (gameRule == null) return;
        org.bukkit.GameRule rule = org.bukkit.GameRule.getByName(gameRule.toString());
        if (rule != null) {
            world.setGameRule(rule, value);
        }
    }
}
