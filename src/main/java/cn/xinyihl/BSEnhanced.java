package cn.xinyihl;

import cn.handyplus.lib.InitApi;
import cn.handyplus.lib.api.MessageApi;
import cn.xinyihl.ticktimer.AutoBanPlayer;
import cn.xinyihl.util.ConfigUtil;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

import static cn.xinyihl.constants.PluginConstants.CONFIG_VERSION;

public final class BSEnhanced extends JavaPlugin {

    private static BSEnhanced INSTANCE;

    public static BSEnhanced getInstance() {
        return INSTANCE;
    }

    @Override
    public void onEnable() {

        INSTANCE = this;

        InitApi initApi = InitApi.getInstance(this);

        ConfigUtil.init();
        chackconfig();

        initApi.initCommand("cn.xinyihl.command")
                .initListener("cn.xinyihl.listener");

        if(ConfigUtil.CONFIG.getBoolean("isBannedAuto")){
            AutoBanPlayer.MyTimerTask(true);
        }

        MessageApi.sendConsoleMessage("§aBSEnhanced已成功载入服务器！");

    }

    @Override
    public void onDisable() {

        MessageApi.sendConsoleMessage("§aBSEnhanced已成功卸载！");

    }


    public static void chackconfig() {

        if (ConfigUtil.CONFIG.getDouble("configversion") != CONFIG_VERSION) {

            File configFile = new File(InitApi.PLUGIN.getDataFolder(), "config.yml");

            configFile.delete();

            ConfigUtil.init();

        }

    }

}
