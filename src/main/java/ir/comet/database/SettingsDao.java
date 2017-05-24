package ir.comet.database;


import ir.comet.model.Settings;
import ir.comet.model.SlideShow;

import java.util.List;

public interface SettingsDao {
    public Settings getSettings(long adminId);
    public boolean updateSettings(Settings settings);
}
