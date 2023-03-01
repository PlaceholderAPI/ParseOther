
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;

import me.clip.placeholderapi.PlaceholderAPI;
import me.clip.placeholderapi.expansion.PlaceholderExpansion;

public class ParseOtherExpansion extends PlaceholderExpansion {
  
  @Override
  public String getAuthor() {
    return "cj89898";
  }
  
  @Override
  public String getIdentifier() {
    return "parseother";
  }
  
  @Override
  public String getVersion() {
    return "1.4.6";
  }
  
  @SuppressWarnings("deprecation")
  @Override
  public String onRequest(OfflinePlayer p, String s) {
    
    String[] strings = s.split("(?<!\\\\)\\}_", 2);
    strings[0] = strings[0].substring(1);
    strings[0] = strings[0].replaceAll("\\\\}_", "}_");
    strings[1] = strings[1].substring(1, strings[1].length() - 1);
    String user = PlaceholderAPI.setPlaceholders(p, ("%" + strings[0] + "%"));
    OfflinePlayer player;
    if (user.contains("%")) {
      player = Bukkit.getOfflinePlayer(strings[0]);
    } else {
      player = Bukkit.getOfflinePlayer(user);
    }
    String placeholder = PlaceholderAPI.setPlaceholders(player, ("%" + strings[1] + "%"));
    if (placeholder.startsWith("%") && placeholder.endsWith("%")) {
      placeholder = strings[1];
    }
    
    return PlaceholderAPI.setPlaceholders(player, placeholder);
  }
  
}
