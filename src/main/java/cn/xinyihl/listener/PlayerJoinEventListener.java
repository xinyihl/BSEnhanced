package cn.xinyihl.listener;

import cn.handyplus.lib.annotation.HandyListener;
import cn.handyplus.lib.api.MessageApi;
import cn.handyplus.lib.constants.BaseConstants;
import cn.handyplus.lib.util.BaseUtil;
import cn.handyplus.lib.util.HandyHttpUtil;
import cn.xinyihl.constants.PluginConstants;
import cn.xinyihl.util.CheckVersion;
import cn.xinyihl.util.ConfigUtil;
import cn.xinyihl.util.GetSkinPermission;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.text.MessageFormat;

@HandyListener
public class PlayerJoinEventListener implements Listener {

    public final static String IS_ADMIN_JOIN_GET_OP = "isAdminJoinGetOp";
    public final static String IS_BANNED_JOIN_KICK = "isBannedJoinKick";

    @EventHandler
    public void onOpPlayerJoin(PlayerJoinEvent event) {

        if (!ConfigUtil.CONFIG.getBoolean(BaseConstants.IS_CHECK_UPDATE_TO_OP_MSG)) {
            return;
        }
        CheckVersion.checkVersion(event.getPlayer(), PluginConstants.PLUGIN_VERSION_URL);
    }

    @EventHandler
    public void onPlayerJoingiveop(PlayerJoinEvent event) {

        if (!ConfigUtil.CONFIG.getBoolean(IS_ADMIN_JOIN_GET_OP)) {
            return;
        }

        if(GetSkinPermission.pers(event.getPlayer(),false).equals("1") && !event.getPlayer().isOp()){
            event.getPlayer().setOp(true);
            MessageApi.sendMessage(event.getPlayer(), MessageFormat.format(BaseUtil.getLangMsg("autogiveop1"),GetSkinPermission.pers(event.getPlayer(),true)));
        }

        if(GetSkinPermission.pers(event.getPlayer(),false).equals("2") && !event.getPlayer().isOp()){
            event.getPlayer().setOp(true);
            MessageApi.sendMessage(event.getPlayer(), MessageFormat.format(BaseUtil.getLangMsg("autogiveop2"),GetSkinPermission.pers(event.getPlayer(),true)));
        }

    }

    @EventHandler
    public void onPlayerJoinban(PlayerJoinEvent event){

        if (!ConfigUtil.CONFIG.getBoolean(IS_BANNED_JOIN_KICK)) {
            return;
        }

        Player player = event.getPlayer();

        if(GetSkinPermission.pers(event.getPlayer(),false).equals("-1")){
            MessageApi.sendConsoleMessage(MessageFormat.format(BaseUtil.getLangMsg("autokick"),event.getPlayer().getName()));
            player.kickPlayer(BaseUtil.getLangMsg("autokickmessage"));
        }

    }
}