package test.eum.java;/*
 *@author Zoumugen
 *@create 2018/11/4 0004-下午 20:52
 */

public class TestSeason {
    public static void main(String[] args) {
        Season season = Season.SPRING;
        System.out.println("season = " + season);
        season.show();
        System.out.println(season.getSeasonName());
        Thread.State[] states = Thread.State.values();
        for (int i = 0; i < states.length; i++) {
            System.out.println("states = " + states[i]);
        }

    }
}

interface info {
    void show();
}

//枚举类
@MyAnnotation(value = "zmg")
enum Season implements info {
    //创建枚举类对象
    SPRING("spring", "春暖花开") {
        public void show() {
            System.out.println("春天在哪里");
        }
    },
    SUMMER("summer", "夏日炎炎") {
        public void show() {
            System.out.println("夏天的太阳");
        }
    },
    AUTUMN("autumn", "秋高气爽") {
        public void show() {
            System.out.println("秋天是分手的季节");
        }
    },
    WINTER("winter", "白雪皑皑") {
        public void show() {
            System.out.println("冬天里的一把火");
        }
    };

    private final String seasonName;
    private final String seasonDesc;

    Season(String seasonName, String seasonDesc) {
        this.seasonName = seasonName;
        this.seasonDesc = seasonDesc;
    }

    public String getSeasonName() {
        return seasonName;
    }

    public String getSeasonDesc() {
        return seasonDesc;
    }

    @Override
    public String toString() {
        return "Season{" +
                "seasonName='" + seasonName + '\'' +
                ", seasonDesc='" + seasonDesc + '\'' +
                '}';
    }
}
