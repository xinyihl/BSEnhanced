package cn.xinyihl.util;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class GetPlayers {

    public List<Player> getAllPlayers() {
        List<Player> players = new ArrayList<>();
        for (OfflinePlayer offlinePlayer : Bukkit.getOfflinePlayers()) {
            if (offlinePlayer instanceof Player) {
                players.add((Player) offlinePlayer);
            }
        }
        return players;
    }

}
