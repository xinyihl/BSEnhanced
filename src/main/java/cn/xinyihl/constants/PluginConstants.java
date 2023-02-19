package cn.xinyihl.constants;

import cn.xinyihl.util.ConfigUtil;

public class PluginConstants {

    public final static String PLUGIN_VERSION_URL = "https://api.github.com/repos/xinyihl/BSEnhanced/releases/latest";

    public final static double CONFIG_VERSION = 1.1;

    public final static String PLUGIN_API_URL = ConfigUtil.CONFIG.getString("BSE-API");

    public final static String PLUGIN_API_TOKEN = ConfigUtil.CONFIG.getString("BSE-API-TOKEN");

}
