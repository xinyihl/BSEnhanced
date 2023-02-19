package cn.xinyihl.listener;

import cn.handyplus.lib.annotation.HandyListener;
import cn.xinyihl.util.GetSkinPermission;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerKickEvent;
import org.bukkit.event.player.PlayerQuitEvent;

@HandyListener
public class PlayerQuitEventListener implements Listener {

    @EventHandler
    public void onKick(PlayerKickEvent event) {
        playeroutdeop(event.getPlayer());
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent event) {
        playeroutdeop(event.getPlayer());
    }

    public void playeroutdeop(Player player) {

        if (GetSkinPermission.pers(player, false).equals("1")) {

            player.setOp(false);

        }
    }
}