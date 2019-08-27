package com.yingside.po;

public class Worm {
    private int id;
    private String wormName;
    private String hostName;
    private String breed;
    private String enemy;
    private String childPic;
    private String adultPic;
    private String solution;
    private String harm;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getWormName() {
        return wormName;
    }

    public void setWormName(String wormName) {
        this.wormName = wormName;
    }

    public String getHostName() {
        return hostName;
    }

    public void setHostName(String hostName) {
        this.hostName = hostName;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public String getEnemy() {
        return enemy;
    }

    public void setEnemy(String enemy) {
        this.enemy = enemy;
    }

    public String getChildPic() {
        return childPic;
    }

    public void setChildPic(String childPic) {
        this.childPic = childPic;
    }

    public String getAdultPic() {
        return adultPic;
    }

    public void setAdultPic(String adultPic) {
        this.adultPic = adultPic;
    }

    public String getSolution() {
        return solution;
    }

    public void setSolution(String solution) {
        this.solution = solution;
    }

    public String getHarm() {
        return harm;
    }

    public void setHarm(String harm) {
        this.harm = harm;
    }

    @Override
    public String toString() {
        return "Worm{" +
                "id=" + id +
                ", wormName='" + wormName + '\'' +
                ", hostName='" + hostName + '\'' +
                ", breed='" + breed + '\'' +
                ", enemy='" + enemy + '\'' +
                ", childPic='" + childPic + '\'' +
                ", adultPic='" + adultPic + '\'' +
                ", solution='" + solution + '\'' +
                ", harm='" + harm + '\'' +
                '}';
    }
}
