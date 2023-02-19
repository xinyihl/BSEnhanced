package cn.xinyihl.util;

import cn.handyplus.lib.util.HttpUtil;
import lombok.SneakyThrows;
import org.bukkit.entity.Player;

import static cn.xinyihl.constants.PluginConstants.PLUGIN_API_TOKEN;
import static cn.xinyihl.constants.PluginConstants.PLUGIN_API_URL;

public class GetSkinScore {

    @SneakyThrows
    public static String scor(Player player){

        String output = HttpUtil.get(PLUGIN_API_URL + "query/userscore?player=" + player.getName() + "&token=" + PLUGIN_API_TOKEN);

        return output;

    }
}
