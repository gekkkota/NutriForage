package com.example.nutriforagepractice;

public class HelpCenter_Description {
    private String name, description;
    private boolean expandable;

    public boolean isExpandable() {
        return expandable;
    }

    public void setExpandable(boolean expandable) {
        this.expandable = expandable;
    }

    public HelpCenter_Description(String name, String description) {
        this.name = name;
        this.description = description;
        this.expandable = false;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "HelpCenter_Description{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
