module mns.java.penduJava {
    requires javafx.controls;
    requires javafx.fxml;
	requires javafx.graphics;

    opens mns.java.penduJava to javafx.fxml;
    exports mns.java.penduJava;
}
