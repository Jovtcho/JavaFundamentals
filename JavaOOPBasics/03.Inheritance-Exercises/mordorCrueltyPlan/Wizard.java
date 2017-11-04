package mordorCrueltyPlan;

public class Wizard {
    private int happiness;

    Wizard() {
        this.happiness = 0;
        this.setMood(this.getHappiness());
    }

    private int getHappiness() {
        return this.happiness;
    }

    private String getMood() {
        return this.setMood(this.getHappiness());
    }

    void eatAllFoods(String[] foods) {
        for (String food : foods) {
            switch (food.toLowerCase()) {
                case "cram":
                    this.happiness += Food.DEFAULT_CRAM_VALUE;
                    break;
                case "lembas":
                    this.happiness += Food.DEFAULT_LEMBAS_VALUE;
                    break;
                case "apple":
                    this.happiness += Food.DEFAULT_APPLE_VALUE;
                    break;
                case "melon":
                    this.happiness += Food.DEFAULT_MELON_VALUE;
                    break;
                case "honeycake":
                    this.happiness += Food.DEFAULT_HONEYCAKE_VALUE;
                    break;
                case "mushrooms":
                    this.happiness += Food.DEFAULT_MUSHROOMS_VALUE;
                    break;
                default:
                    this.happiness += Food.DEFAULT_OTHERFOOD_VALUE;
                    break;
            }
        }
    }

    private String setMood(int happiness) {
        String mood;
        if (this.getHappiness() < -5) {
            mood = Mood.DEFAULT_ANGRY_VALUE;
        } else if (this.getHappiness() < 0) {
            mood = Mood.DEFAULT_SAD_VALUE;
        } else if (this.getHappiness() < 15) {
            mood = Mood.DEFAULT_HAPPY_VALUE;
        } else {
            mood = Mood.DEFAULT_JAVASCRIPT_VALUE;
        }
        return mood;
    }

    @Override
    public String toString() {
        return this.getHappiness() + "\n" + this.getMood();
    }
}



