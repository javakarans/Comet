package ir.comet.model;

import ir.comet.database.SettingsDaoImp;

public class SettingsData {
    private static SettingsData settingsData ;

    private Settings settings;
    private SettingsDaoImp settingsDaoImp;

    private SettingsData()
    {
        settingsDaoImp = new SettingsDaoImp();
        settings = settingsDaoImp.getSettings(1);
    }

    public static SettingsData getInstance()
    {
        if(settingsData == null){
            synchronized (SettingsData.class) {
                if(settingsData == null){
                    settingsData = new SettingsData();
                }
            }
        }
        return settingsData;
    }

    public boolean updateSettings(Settings settings)
    {
        boolean result = settingsDaoImp.updateSettings(settings);
        if (result)
        {
            this.settings = settings;
            return true;
        }
        return false;
    }

    public Settings getSettings() {
        return settings;
    }

    public void setSettings(Settings settings) {
        this.settings = settings;
    }
}
