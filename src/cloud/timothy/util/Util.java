package cloud.timothy.util;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import java.lang.reflect.InvocationTargetException;

public class Util {

    /**
     * String Formatter using Bukkit's ChatColor, removing boilerplate code
     *
     * @param string message to be formatted.
     * @return '&' symbol replaced with corresponding colour.
     */
    public static String formatMessage(String string) {
        return ChatColor.translateAlternateColorCodes('&', string);
    }

    /**
     * String Formatter using Bukkit's ChatColor, removing boilerplate code
     * (shortened)
     *
     * @param string message to be formatted.
     * @return '&' symbol replaced with corresponding colour.
     */
    public static String format(String string) {
        return ChatColor.translateAlternateColorCodes('&', string);
    }

    /**
     * Note: If the player and server are on the same local machine then
     * ping will return 0.
     *
     * @param player which player to calculate ping.
     * @return player's ping.
     */
    public static int calcPing(Player player) {
        try {
            Object entityPlayer = player.getClass().getMethod("getHandle").invoke(player);
            int ping = (int) entityPlayer.getClass().getField("ping").get(entityPlayer);

            return ping;
        } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SecurityException | NoSuchFieldException e) {
            e.printStackTrace();
        }
        return 0;
    }

}
