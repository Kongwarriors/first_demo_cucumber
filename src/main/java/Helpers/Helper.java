package Helpers;

import org.jetbrains.annotations.NotNull;

import java.io.File;

public class Helper {
    public static @NotNull String getCurrentDir(){
        return System.getProperty("user.dir") + File.separator;
    }
}
