package cn.xinyihl.constants;

import cn.xinyihl.util.ConfigUtil;

public class PluginConstants {
    public final static String PLUGIN_VERSION_URL = "https://github.com/api/v5/repos/Server-CT/BSEnhanced/releases/latest";

    public final static String PLUGIN_API_URL = ConfigUtil.CONFIG.getString("BSE-API");

    public final static String PLUGIN_API_TOKEN = ConfigUtil.CONFIG.getString("BSE-API-TOKEN");

}
