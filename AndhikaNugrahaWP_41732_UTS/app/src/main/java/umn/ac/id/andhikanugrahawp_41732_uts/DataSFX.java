package umn.ac.id.andhikanugrahawp_41732_uts;

public class DataSFX {
    private String sfxName, sfxType, musicFile;

    public DataSFX(String sfxName, String sfxType, String musicFile) {
        this.sfxName = sfxName;
        this.sfxType = sfxType;
        this.musicFile = musicFile;
    }

    public String getsfxName() {
        return sfxName;
    }
    public String getsfxType() {
        return sfxType;
    }
    public String getMusicFile() { return musicFile; }

    public void setsfxName(String sfxName, String sfxType) {
        this.sfxName = sfxName;
        this.sfxType = sfxType;
        this.musicFile = musicFile;
    }
}
