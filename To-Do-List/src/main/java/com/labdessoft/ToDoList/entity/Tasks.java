package com.labdessoft.ToDoList.entity;



public class Tasks {
    int id;
    String text;
    boolean complete;


  public Tasks(){
  };

  public Tasks(int id, String text){
    this.id = id;
    this.text = text;
    complete = false;
};

public void setId(int id){
  this.id = id;
}

public int getId(){
  return id;
}

public void setComlete(boolean cpmplete){
    this.complete = complete;
  }
  
  public boolean getComplete(){
    return complete;
  }

public void setText(String text){
 this.text = text;
}

public String getText(){
 return text;
}

}
