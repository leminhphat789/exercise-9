Exercise 9
## Mục tiêu và giải pháp

Chương trình sử dụng Java. (GameModel) được thiết kế theo mẫu Singleton với cách khởi tạo sẵn (eager initialization). Khi lớp được khởi tạo, một đối tượng duy nhất được lưu trong trường (INSTANCE). Mọi lời gọi ( getInstance() ) đều trả về đối tượng này.

| Thành phần | Ý nghĩa |
| --- | --- |
| `private static final GameModel INSTANCE` | Lưu đối tượng dùng chung của lớp; không cho phép gán lại tham chiếu. |
| `private GameModel()` | Không cho phép mã bên ngoài gọi `new GameModel()`. |
| `public static GameModel getInstance()` | Cung cấp điểm truy cập đối tượng duy nhất. |
| `private Deck deck` | Biến đối tượng duy nhất, lưu bộ bài hiện tại. |
| `newGame()` | Thực hiện `deck = new Deck()` để tạo bộ bài mới mỗi lần gọi. |
