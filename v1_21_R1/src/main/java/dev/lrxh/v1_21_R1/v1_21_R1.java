package dev.lrxh.v1_21_R1;

import dev.lrxh.VersionHandler;
import dev.lrxh.v1_21_R1.config.Config;
import dev.lrxh.v1_21_R1.gameRule.GameRule;
import dev.lrxh.v1_21_R1.sounds.Sound;
import dev.lrxh.v1_21_R1.utils.ChatComponent;
import dev.lrxh.v1_21_R1.utils.ColorUtils;
import dev.lrxh.v1_21_R1.utils.PlayerUtils;
import dev.lrxh.v1_21_R1.utils.ReflectionUtils;
import dev.lrxh.v1_21_R1.utils.chunk.ChunkUtilsUtil;

public class v1_21_R1 extends VersionHandler {
    public v1_21_R1() {
        super(new PlayerUtils(),
                new Config(), new GameRule(), new ColorUtils(), new ChatComponent(), new Sound(), new ChunkUtilsUtil(), new ReflectionUtils());
    }
}
