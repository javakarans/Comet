package ir.comet.model;

public class SettingsData {
    private static SettingsData settingsData ;



    private SettingsData()
    {

    }

    public SettingsData getInstance()
    {
        if (settingsData == null)
            settingsData = new SettingsData();
        return settingsData;
    }
}
