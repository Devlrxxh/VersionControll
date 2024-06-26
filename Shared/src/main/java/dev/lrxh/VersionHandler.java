package dev.lrxh;

import dev.lrxh.config.IConfig;
import dev.lrxh.gameRule.IGameRule;
import dev.lrxh.sounds.ISound;
import dev.lrxh.utils.IColorUtils;
import dev.lrxh.utils.IPlayerUtils;
import dev.lrxh.utils.IReflectionUtils;
import dev.lrxh.utils.chatComponent.IChatComponent;
import dev.lrxh.utils.chunk.IChunkUtils;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class VersionHandler {
    private IPlayerUtils playerUtils;
    private IConfig Config;
    private IGameRule gameRule;
    private IColorUtils colorUtils;
    private IChatComponent chatComponent;
    private ISound sound;
    private IChunkUtils chunk;
    private IReflectionUtils reflection;
}
