# Exercise 9 — Thiết kế GameModel dùng Singleton

## Đề bài

Using the Singleton Design Pattern, design a `GameModel` class that is a Singleton. The class should have a single instance variable of type `Deck` and initialize the deck whenever a `newGame()` method is called. The class can remain a stub, meaning that it does not need to do anything else.

## Mục tiêu và giải pháp

Chương trình sử dụng Java. `GameModel` được thiết kế theo mẫu Singleton với cách khởi tạo sẵn (eager initialization). Khi lớp được khởi tạo, một đối tượng duy nhất được lưu trong trường `INSTANCE`. Mọi lời gọi `getInstance()` đều trả về đối tượng này.

| Thành phần | Ý nghĩa |
| --- | --- |
| `private static final GameModel INSTANCE` | Lưu đối tượng dùng chung của lớp; không cho phép gán lại tham chiếu. |
| `private GameModel()` | Không cho phép mã bên ngoài gọi `new GameModel()`. |
| `public static GameModel getInstance()` | Cung cấp điểm truy cập đối tượng duy nhất. |
| `private Deck deck` | Biến đối tượng duy nhất, lưu bộ bài hiện tại. |
| `newGame()` | Thực hiện `deck = new Deck()` để tạo bộ bài mới mỗi lần gọi. |

`INSTANCE` là biến static thuộc về lớp, không phải instance variable. Vì vậy, lớp vẫn chỉ có một instance variable là `deck`, đúng theo đề bài. Từ khóa `final` của lớp ngăn kế thừa; từ khóa `final` của `INSTANCE` không làm cho bộ bài trở thành bất biến.

Trước lần gọi `newGame()` đầu tiên, `deck` có giá trị `null`. Sau mỗi lần gọi, `deck` tham chiếu đến một bộ bài mới nhưng đối tượng `GameModel` vẫn giữ nguyên. Cơ chế khởi tạo lớp của Java bảo đảm việc tạo Singleton này an toàn giữa các luồng; bài tập không triển khai đồng bộ hóa các lời gọi `newGame()` đồng thời.

`Deck` được cung cấp dưới dạng stub để bài chạy độc lập. Nếu dự án môn học đã có lớp `Deck` với constructor không tham số, sử dụng lớp đó thay cho stub. Không cần cài đặt chia bài, xáo bài, tính điểm hoặc xử lý lượt chơi.

## Cấu trúc

```text
src/
  GameModel.java
  Deck.java
  Main.java
```

## Biên dịch và chạy

Cần cài JDK (Java 8 trở lên). Mở terminal tại thư mục chứa README và chạy:

```shell
javac -d out src/Deck.java src/GameModel.java src/Main.java
java -cp out Main
```

Kết quả mong đợi:

```text
Same GameModel instance: true
Game 1 started.
Game 2 started.
Same instance after newGame: true
```

Phép so sánh `==` cho thấy hai lần lấy model đều trả về cùng một đối tượng. Hai lời gọi `newGame()` minh họa việc bắt đầu hai ván chơi. Việc tạo bộ bài mới nằm ở câu lệnh `deck = new Deck()`; các dòng thông báo trong Main không tự kiểm tra danh tính của bộ bài private.

## Đối chiếu yêu cầu

- Singleton: constructor private và phương thức static trả về đối tượng duy nhất.
- Chỉ một instance variable kiểu Deck: trường `deck`.
- Khởi tạo bộ bài mỗi khi gọi newGame(): luôn tạo `new Deck()`.
- Giữ dạng stub: không thêm logic trò chơi ngoài yêu cầu.
