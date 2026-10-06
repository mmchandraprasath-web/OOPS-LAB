import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import java.sql.*;
public class StudentManagementApp extends Application {
private Connection connection;
private TextField idField = new TextField();
private TextField nameField = new TextField();
private TextField ageField = new TextField();
private TextField courseField = new TextField();
private TextArea displayArea = new TextArea();
public static void main(String[] args) {
launch(args);
}

@Override
public void start(Stage primaryStage) {
connectToDatabase();

GridPane gridPane = new GridPane();
gridPane.setPadding(new Insets(10));
gridPane.setHgap(10);
gridPane.setVgap(10);

Font font = new Font("Arial", 14);

idField.setPromptText("ID (for Update/Delete)");
nameField.setPromptText("Name");
ageField.setPromptText("Age");
courseField.setPromptText("Course");

idField.setFont(font);
nameField.setFont(font);
ageField.setFont(font);
courseField.setFont(font);

Button createButton = new Button("Create");
Button readButton = new Button("Display");
Button updateButton = new Button("Update");
Button deleteButton = new Button("Delete");

createButton.setFont(font);
readButton.setFont(font);
updateButton.setFont(font);
deleteButton.setFont(font);

createButton.setStyle(
"-fx-background-color:#4CAF50;-fx-text-fill:white;"
);

readButton.setStyle(
"-fx-background-color:#2196F3;-fx-text-fill:white;"
);

updateButton.setStyle(
"-fx-background-color:#FF9800;-fx-text-fill:white;"
);

deleteButton.setStyle(
"-fx-background-color:#F44336;-fx-text-fill:white;"
);

createButton.setOnAction(e -> createStudent());
readButton.setOnAction(e -> readStudents());
updateButton.setOnAction(e -> updateStudent());
deleteButton.setOnAction(e -> deleteStudent());

displayArea.setFont(font);
displayArea.setEditable(false);
displayArea.setWrapText(true);

gridPane.add(new Label("ID:"), 0, 0);
gridPane.add(idField, 1, 0);

gridPane.add(new Label("Name:"), 0, 1);
gridPane.add(nameField, 1, 1);

gridPane.add(new Label("Age:"), 0, 2);
gridPane.add(ageField, 1, 2);
gridPane.add(new Label("Course:"), 0, 3);
gridPane.add(courseField, 1, 3);
gridPane.add(createButton, 0, 4);
gridPane.add(readButton, 1, 4);

gridPane.add(updateButton, 0, 5);
gridPane.add(deleteButton, 1, 5);

gridPane.add(displayArea, 0, 6, 2, 1);

Scene scene = new Scene(gridPane, 450, 500);

primaryStage.setTitle("Student Management");
primaryStage.setScene(scene);
primaryStage.show();
}

private void connectToDatabase() {

try {
Class.forName("com.mysql.cj.jdbc.Driver");
connection = DriverManager.getConnection(
"jdbc:mysql://localhost:3306/studentdb",
"root",
"1234"
);

displayArea.setText("Database connected successfully.");
} catch (ClassNotFoundException e) {
displayArea.setText("MySQL JDBC Driver not found.");
} catch (SQLException e) {
displayArea.setText(
"Database connection failed:\n" + e.getMessage()
);
}
}
private void createStudent() {

if (connection == null) {
displayArea.setText("Database is not connected.");
return;
}

String name = nameField.getText();
String ageText = ageField.getText();
String course = courseField.getText();

if (name.isEmpty() || ageText.isEmpty() || course.isEmpty()) {
displayArea.setText("Please enter Name, Age and Course.");
return;
}

try {

int age = Integer.parseInt(ageText);

String sql =
"INSERT INTO students (name, age, course) VALUES (?, ?, ?)";

try (PreparedStatement pstmt =
connection.prepareStatement(sql)) {

pstmt.setString(1, name);
pstmt.setInt(2, age);
pstmt.setString(3, course);

pstmt.executeUpdate();

displayArea.setText(
"Student created successfully."
);
}

} catch (NumberFormatException e) {

displayArea.setText("Age must be a number.");

} catch (SQLException e) {

displayArea.setText(
"Error creating student:\n" + e.getMessage()
);
}
}
private void readStudents() {
if (connection == null) {
displayArea.setText("Database is not connected.");
return;
}

String sql = "SELECT * FROM students";
try (
Statement stmt = connection.createStatement();
ResultSet rs = stmt.executeQuery(sql)
) {

StringBuilder sb = new StringBuilder();
while (rs.next()) {
sb.append("ID: ")
.append(rs.getInt("id"))
.append(", Name: ")
.append(rs.getString("name"))
.append(", Age: ")
.append(rs.getInt("age"))
.append(", Course: ")
.append(rs.getString("course"))
.append("\n");
}
if (sb.length() == 0) {
displayArea.setText("No students found.");
} else {
displayArea.setText(sb.toString());
}

} catch (SQLException e) {
    
displayArea.setText(
"Error displaying students:\n" + e.getMessage()
);
}
}
 private void updateStudent() {

if (connection == null) {
displayArea.setText("Database is not connected.");
return;
}

String idText = idField.getText();
String name = nameField.getText();
String ageText = ageField.getText();
String course = courseField.getText();

if (idText.isEmpty() ||
name.isEmpty() ||
ageText.isEmpty() ||
course.isEmpty()) {

displayArea.setText(
"Please enter ID, Name, Age and Course."
);
return;
}

try {

int id = Integer.parseInt(idText);
int age = Integer.parseInt(ageText);

String sql =
"UPDATE students SET name=?, age=?, course=? WHERE id=?";

try (PreparedStatement pstmt =
connection.prepareStatement(sql)) {

pstmt.setString(1, name);
pstmt.setInt(2, age);
pstmt.setString(3, course);
pstmt.setInt(4, id);

int rows = pstmt.executeUpdate();

if (rows > 0) {
displayArea.setText(
"Student updated successfully."
);
} else {
displayArea.setText(
"Student ID not found."
);
}
}

} catch (NumberFormatException e) {

displayArea.setText(
"ID and Age must be numbers."
);

} catch (SQLException e) {

displayArea.setText(
"Error updating student:\n" + e.getMessage()
);
}
}

private void deleteStudent() {

if (connection == null) {
displayArea.setText("Database is not connected.");
return;
}

String idText = idField.getText();

if (idText.isEmpty()) {
displayArea.setText("Please enter Student ID.");
return;
}

try {

int id = Integer.parseInt(idText);

String sql =
"DELETE FROM students WHERE id=?";

try (PreparedStatement pstmt =
connection.prepareStatement(sql)) {

pstmt.setInt(1, id);

int rows = pstmt.executeUpdate();

if (rows > 0) {
displayArea.setText(
"Student deleted successfully."
);
} else {
displayArea.setText(
"Student ID not found."
);
}
}
} catch (NumberFormatException e) {

displayArea.setText("ID must be a number.");

} catch (SQLException e) {

displayArea.setText(
"Error deleting student:\n" + e.getMessage()
);
}
}
@Override
public void stop() throws Exception {

if (connection != null && !connection.isClosed()) {
connection.close();
}

super.stop();
}
}
