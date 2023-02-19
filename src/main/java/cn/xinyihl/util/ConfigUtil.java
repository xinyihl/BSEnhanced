package cn.xinyihl.util;

import cn.handyplus.lib.api.LangMsgApi;
import cn.handyplus.lib.util.HandyConfigUtil;
import org.bukkit.configuration.file.FileConfiguration;

public class ConfigUtil {
    public static FileConfiguration CONFIG, LANG_CONFIG;
    public static void init() {

        CONFIG = HandyConfigUtil.loadConfig();

        LANG_CONFIG = HandyConfigUtil.load("languages/" + CONFIG.getString("language") + ".yml");

        LangMsgApi.initLangMsg(LANG_CONFIG);

    }
}