package animals.model.tree;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Node {
    String value;
    Node yes;
    Node no;

    public Node(){}

    public Node(String value) {
        this.value = value;
        yes = null;
        no = null;
    }

    public Node(String value, Node yes, Node no) {
        this.value = value;
        this.yes = yes;
        this.no = no;
    }

    @JsonIgnore
    public boolean isLeaf() {
        return yes == null && no == null;
    }

    public String getValue() {
        return value;
    }

    public Node getYes() {
        return yes;
    }

    public Node getNo() {
        return no;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public void setYes(Node yes) {
        this.yes = yes;
    }

    public void setNo(Node no) {
        this.no = no;
    }

}
