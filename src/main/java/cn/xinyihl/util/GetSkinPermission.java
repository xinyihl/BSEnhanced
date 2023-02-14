package cn.xinyihl.util;

import cn.handyplus.lib.util.BaseUtil;
import cn.handyplus.lib.util.HttpUtil;
import lombok.SneakyThrows;
import org.bukkit.entity.Player;

import static cn.xinyihl.constants.PluginConstants.PLUGIN_API_TOKEN;
import static cn.xinyihl.constants.PluginConstants.PLUGIN_API_URL;

public class GetSkinPermission {
    @SneakyThrows
    public static String pers(Player player, Boolean type){

        String out = null;

        String output = HttpUtil.get(PLUGIN_API_URL + "query/permission?player=" + player.getName() + "&token=" + PLUGIN_API_TOKEN);

        if(output.equals("-1")){
            out = BaseUtil.getLangMsg("BANNED");
        }
        else if(output.equals("0")){
            out = BaseUtil.getLangMsg("NORMAL");
        }
        else if(output.equals("1")){
            out = BaseUtil.getLangMsg("ADMIN");
        }
        else if(output.equals("2")){
            out = BaseUtil.getLangMsg("SUPER_ADMIN");
        }

        if(type){
            return out;
        }else {
            return output;
        }

    }
}
