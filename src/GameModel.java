public final class GameModel {
    // Tạo một đối tượng GameModel duy nhất dùng chung cho chương trình.
    private static final GameModel INSTANCE = new GameModel();

    // Biến đối tượng duy nhất, lưu bộ bài của ván chơi hiện tại.
    // INSTANCE là biến static thuộc về lớp nên không tính là biến đối tượng.
    private Deck deck;

    // Ngăn các lớp bên ngoài tạo GameModel bằng từ khóa new.
    private GameModel() {
    }

    // Mọi lần gọi đều trả về cùng một đối tượng GameModel.
    public static GameModel getInstance() {
        return INSTANCE;
    }

    // Tạo bộ bài mới khi bắt đầu ván chơi; đối tượng GameModel vẫn giữ nguyên.
    public void newGame() {
        deck = new Deck();
    }
}
