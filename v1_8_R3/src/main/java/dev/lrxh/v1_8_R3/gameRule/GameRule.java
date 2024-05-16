package dev.lrxh.v1_8_R3.gameRule;

import dev.lrxh.gameRule.IGameRule;
import org.bukkit.World;

public class GameRule implements IGameRule {
    @Override
    public void setGameRule(World world, dev.lrxh.gameRule.GameRule gameRule, boolean value) {
        if (gameRule == null) return;
        world.setGameRuleValue(gameRule.getLegacy(), String.valueOf(value));
    }
}
