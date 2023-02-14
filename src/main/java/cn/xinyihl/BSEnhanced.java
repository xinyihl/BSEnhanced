package cn.xinyihl;

import cn.handyplus.lib.InitApi;
import cn.handyplus.lib.api.MessageApi;
import cn.xinyihl.util.ConfigUtil;
import org.bukkit.plugin.java.JavaPlugin;

public final class BSEnhanced extends JavaPlugin {

    private static BSEnhanced INSTANCE;

    @Override
    public void onEnable() {

        INSTANCE = this;

        InitApi initApi = InitApi.getInstance(this);

        ConfigUtil.init();

        initApi.initCommand("cn.xinyihl.command")
                .initListener("cn.xinyihl.listener");

        MessageApi.sendConsoleMessage("§a已成功载入服务器！");

    }

    @Override
    public void onDisable() {

        MessageApi.sendConsoleMessage("§a已成功卸载！");

    }

    public static BSEnhanced getInstance() {
        return INSTANCE;
    }
}
