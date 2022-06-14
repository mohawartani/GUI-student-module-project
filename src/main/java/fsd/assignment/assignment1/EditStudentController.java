package fsd.assignment.assignment1;

import fsd.assignment.assignment1.datamodel.Student;
import fsd.assignment.assignment1.datamodel.StudentData;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;

import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;


public class EditStudentController {
    //all of the variables declared below correspond with the edit-students.fxml
    @FXML
    private Label yearStudyDisplay;

    @FXML
    private Label mod1Edit;

    @FXML
    private Label mod2Edit;

    @FXML
    private Label mod3Edit;

    @FXML
    private ChoiceBox<String> mod1ChoiceEdit;

    @FXML
    private ChoiceBox<String> mod2ChoiceEdit;

    @FXML
    private ChoiceBox<String> mod3ChoiceEdit;

    //the modChoices variables correspond to the []
    private String mod1S, mod2S, mod3S;

    private String modChoices[] = {"OOP", "Data Algo", "DS", "Maths", "AI",
            "Adv Programming", "Project"};

    public void initialize() {

        /* TODO: xxx add all the modChoices to each ChoiceBox
         */
        //insert 3 lines of code here
        //these lines have been given to you includes the setOnAction if a ChoiceBox is selected
        mod1ChoiceEdit.setOnAction(this::getChoiceEdit);
        mod2ChoiceEdit.setOnAction(this::getChoiceEdit);
        mod3ChoiceEdit.setOnAction(this::getChoiceEdit);
        mod1ChoiceEdit.getItems().addAll(modChoices);
        mod2ChoiceEdit.getItems().addAll(modChoices);
        mod3ChoiceEdit.getItems().addAll(modChoices);
    }

    //to ensure that detail pops up to edit
    public void setToEdit(Student stu) {
        /* TODO: xxxzzz display the student to be edited details
         */
        yearStudyDisplay.setText(stu.getYearOfStudy());
        mod1Edit.setText((stu.getModule1()));
        mod2Edit.setText((stu.getModule2()));
        mod3Edit.setText((stu.getModule3()));
        //insert 4 lines of code here
        /* TODO: xxxzzz get the new module choices using mod1S, mod2S and mod3S
         */

        mod1S = mod1ChoiceEdit.toString();
        mod2S = mod2ChoiceEdit.toString();
        mod3S = mod3ChoiceEdit.toString();
    }

    public Student processEdit(Student stu) {
        /* TODO: xxxzzz complete the observableIst statement by getting all students from StudentData
                 to be collected in allStudents
         */
        ObservableList<Student> allStudents = StudentData.getInstance().getStudents();
        /* TODO: xxxzzz get studId and year of study
         */
        String studIdS = stu.toString();
        String yearStudyS = stu.getYearOfStudy();
        /* TODO: xxxzzz remove the student to be edited from allStudents
         */
        allStudents.remove(stu);
        //insert the line to remove the student here
        /* TODO: xxxzzz add the student back by creating a new object reference and calling the addStudentData()
         */
        Student changedStu = new Student(studIdS,yearStudyS,mod1S,mod2S,mod3S);
        StudentData.getInstance().addStudentData(changedStu);
        //call the addStudentData()
        /* TODO: xxxzzz return the newly edited student back to the Controller class / editStudent()
         */
        return changedStu;
    }

    public void getChoiceEdit(ActionEvent event) {
        /* TODO: xxxzzz complete the 3 if... statements using event
         */
        if(event.getSource() == mod1ChoiceEdit){
            mod1S = mod1ChoiceEdit.getValue();
            System.out.println(mod1S);
        }
        if(event.getSource() == mod2ChoiceEdit){
            mod2S = mod2ChoiceEdit.getValue();
            System.out.println(mod2S);
        }
        if(event.getSource() == mod3ChoiceEdit){
            mod3S = mod3ChoiceEdit.getValue();
            System.out.println(mod3S);
        }

    }
}
