package dev.lrxh.v1_19_R3;

import dev.lrxh.VersionHandler;
import dev.lrxh.v1_19_R3.config.Config;
import dev.lrxh.v1_19_R3.gameRule.GameRule;
import dev.lrxh.v1_19_R3.sounds.Sound;
import dev.lrxh.v1_19_R3.utils.ChatComponent;
import dev.lrxh.v1_19_R3.utils.ColorUtils;
import dev.lrxh.v1_19_R3.utils.PlayerUtils;
import dev.lrxh.v1_20_R3.utils.chunk.ChunkUtilsUtil;

public class v1_19_R3 extends VersionHandler {
    public v1_19_R3() {
        super(new PlayerUtils(),
                new Config(), new GameRule(), new ColorUtils(), new ChatComponent(), new Sound(), new ChunkUtilsUtil());
    }
}
