# Exercise 9 - Giải thích giải pháp Singleton

## Yêu cầu

Thiết kế lớp GameModel theo mẫu Singleton, có một biến đối tượng kiểu Deck và khởi tạo bộ bài mỗi khi gọi newGame().

## Cách thực hiện

Trong bài này, GameModel sử dụng cách khởi tạo sẵn. Đối tượng dùng chung được tạo khi lớp được khởi tạo và lưu trong biến INSTANCE.

```java
private static final GameModel INSTANCE = new GameModel();
```

Từ khóa static cho biết INSTANCE thuộc về lớp. Từ khóa final ngăn việc gán INSTANCE sang một đối tượng khác.

Constructor được đặt là private để các lớp bên ngoài không thể gọi new GameModel():

```java
private GameModel() {
}
```

Khi cần sử dụng GameModel, chương trình gọi getInstance(). Phương thức này luôn trả về đối tượng đã lưu trong INSTANCE, không tạo thêm đối tượng mới.

```java
public static GameModel getInstance() {
    return INSTANCE;
}
```

GameModel có một biến đối tượng là deck để lưu bộ bài. INSTANCE là biến static nên không tính là biến đối tượng.

```java
private Deck deck;
```

Mỗi lần bắt đầu ván chơi, newGame() tạo một đối tượng Deck mới và gán vào deck:

```java
public void newGame() {
    deck = new Deck();
}
```

Trước lần gọi newGame() đầu tiên, deck có giá trị null. Khi gọi phương thức này nhiều lần, bộ bài được thay mới nhưng GameModel vẫn là đối tượng dùng chung ban đầu.

## Vai trò của các file

- GameModel.java: cài đặt Singleton và phương thức newGame().
- Deck.java: lớp bộ bài dạng khung để chương trình biên dịch và chạy độc lập. Hiện tại lớp chưa chứa các lá bài, chưa có chức năng xáo hoặc chia bài.
- Main.java: lấy GameModel hai lần, so sánh hai tham chiếu và gọi newGame() để minh họa.

Bản này tạo Deck mới trong newGame(). Mẫu của sách dùng lớp Deck có sẵn và gọi shuffle() để xáo lại bộ bài. Vì vậy, bản này minh họa cơ chế Singleton và việc tạo đối tượng Deck, chưa mô phỏng một bộ bài thực tế.

## Chạy thử

Cài JDK, mở terminal tại thư mục dự án và chạy:

```shell
javac -encoding UTF-8 -d out src/Deck.java src/GameModel.java src/Main.java
java -cp out Main
```

Kết quả mong đợi:

```text
Same GameModel instance: true
Game 1 started.
Game 2 started.
Same instance after newGame: true
```

Kết quả true cho thấy các lần gọi getInstance() trả về cùng một đối tượng. Các thông báo bắt đầu ván chơi chỉ cho biết newGame() đã được gọi; chúng không kiểm tra nội dung bộ bài.
