module com.shubham.solutions.leetcodecodingproblems {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.shubham.solutions.leetcodecodingproblems to javafx.fxml;
    exports com.shubham.solutions.leetcodecodingproblems;
}