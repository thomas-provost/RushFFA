package fr.thomasprovost.rushFFA.utils;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;

public class Locations {

    public static Location parseStringToLoc(String string) {
        String[] parsedLoc = string.split(",");
        double x = Double.valueOf(parsedLoc[1]);
        double y = Double.valueOf(parsedLoc[2]);
        double z = Double.valueOf(parsedLoc[3]);
        String world = parsedLoc[0];
        float pitch = Float.valueOf(parsedLoc[4]);
        float yaw = Float.valueOf(parsedLoc[5]);

        return new Location(Bukkit.getWorld(world), x, y, z, yaw, pitch);
    }

    public static String parseLocToString(Location loc) {
        double x = loc.getX();
        double y = loc.getY();
        double z = loc.getZ();
        World world = loc.getWorld();
        float pitch = loc.getPitch();
        float yaw = loc.getYaw();
        return world.getName()+", "+x+", "+y+", "+z+", "+pitch+", "+yaw;
    }

}
