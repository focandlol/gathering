package system.gathering.object;

import org.springframework.web.socket.messaging.SubProtocolWebSocketHandler;

public enum Category {

    STUDY("category_study.png","스터디"),
    GAME("category_game.png","게임"),
    MEAL("category_meal.png","식사"),
    SPORTS("category_sport.png","스포츠"),
    PET("category_dog.png","애견"),
    MUSIC("category_music.png","음악");

    private String filename;
    private String category;

    Category(String filename, String category) {
        this.filename = filename;
        this.category = category;
    }

    public String getFilename() {
        return filename;
    }

    public String getCategory() {
        return category;
    }
}
